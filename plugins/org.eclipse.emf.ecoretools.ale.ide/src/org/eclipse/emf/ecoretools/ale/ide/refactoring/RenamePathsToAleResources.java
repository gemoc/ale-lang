/*******************************************************************************
 * Copyright (c) 2020 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.ide.refactoring;

import static java.util.Arrays.asList;
import static org.eclipse.emf.ecoretools.ale.ide.project.IAleProject.hasAleNature;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.impl.DslConfiguration;
import org.eclipse.emf.ecoretools.ale.ide.Activator;
import org.eclipse.emf.ecoretools.ale.ide.project.IAleProject;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;

public class RenamePathsToAleResources extends RenameParticipant {
	
	private IContainer renamed;

	@Override
	protected boolean initialize(Object element) {
		if (! (element instanceof IContainer)) {
			return false;
		}
		renamed = (IContainer) element;
		return true;
	}

	@Override
	public String getName() {
		return "Rename paths to ALE resources files when the enclosing project is renamed";
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm, CheckConditionsContext context) throws OperationCanceledException {
		return new RefactoringStatus();
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException {
		String newName = getArguments().getNewName();
		
		CompositeChange changes = new CompositeChange("Update paths to ALE resources");
		changeMadeToProject(newName).ifPresent(changes::add);
		changesMadeToDslFiles(newName).forEach(changes::add);
		
		return changes;
	}
	
	private Optional<Change> changeMadeToProject(String newName) {
		IProject project = renamed.getProject();
		if (!hasAleNature(project)) {
			// the project is not interested in our changes
			return Optional.empty();
		}
		IFile oldDslFile = findDslConfigurationFile(project);
		IFile newDslFile = oldDslFile == null ? oldDslFile : toWorkspace(uriAfterRenaming(oldDslFile, newName));
		IProject newProject = projectAfterRename(renamed, newName);

		try (IAleEnvironment env = IAleProject.from(project).getEnvironment()) {
			Collection<String> newBehaviors = renamedIfImpacted(env.getBehaviorsSources(), newName);
			Collection<String> newMetamodels = renamedIfImpacted(env.getMetamodelsSources(), newName);
			
			Change change = new RenamePathsInProjectPreferencesChange(newProject, oldDslFile, newDslFile, newBehaviors, newMetamodels);
			return Optional.of(change);
		}
	}
	
	private List<Change> changesMadeToDslFiles(String newName) throws CoreException {
		List<Change> changes = new ArrayList<>();
		
		renamed.getProject().accept(new IResourceVisitor() {
			
			@Override
			public boolean visit(IResource resource) throws CoreException {
				if (resource instanceof IFile && resource.getName().endsWith(".dsl")) {
					IFile file = (IFile) resource;
					try (DslConfiguration dsl = IAleEnvironment.fromDslFile(file)) {
						IFile fileAfterRenaming = toWorkspace(uriAfterRenaming(file, newName));

						Collection<String> newBehaviors = renamedIfImpacted(dsl.getBehaviorsSources(), newName);
						Collection<String> newMetamodels = renamedIfImpacted(dsl.getMetamodelsSources(), newName);
						
						changes.add(new RenamePathsInDslFilesChange(fileAfterRenaming, newBehaviors, newMetamodels));
					} 
					catch (Exception e) {
						Activator.warn("Unable to rename paths in " + file.getFullPath(), e);
					}
				}
				return true;
			}
		});
		return changes;
	}

	/** @return the .dsl file used to configure ALE, or null if the project doesn't use one */
	private IFile findDslConfigurationFile(IProject project) {
		return IAleProject.from(project).findDslFile().orElse(null);
	}

	/** @return all given URIs, but updating the ones impacted by the renaming */
	private LinkedHashSet<String> renamedIfImpacted(Collection<String> uris, String newName) {
		LinkedHashSet<String> renamedURIs = new LinkedHashSet<>();
		
		for (String uri : uris) {
			boolean uriHasBeenRenamed = false;
			Set<IFile> files = toWorkspaceFiles(uri);
			
			for (IFile file : files) {
				if (isImpactedByRenaming(file)) {
					String renamedURI = uriAfterRenaming(file, newName).toString();

					renamedURIs.add(renamedURI);
					uriHasBeenRenamed = true;
				}
			}
			if (!uriHasBeenRenamed) {
				renamedURIs.add(uri);
			}
		}
		return renamedURIs;
	}
	
	/** @return the project that will contain the given resource after the rename operation */
	private static IProject projectAfterRename(IResource resource, String newName) {
		boolean theProjectIsBeingRenamed = resource.equals(resource.getProject());
		if (theProjectIsBeingRenamed) {
			return ResourcesPlugin.getWorkspace().getRoot().getProject(newName);
		}
		else {
			return resource.getProject();
		}
	}

	/** @return the URI that identifies the file once it has been renamed 
	 * 			(uses the platform:/resource/ scheme) */
	private URI uriAfterRenaming(IFile file, String newName) {
		IPath newPath = pathAfterRenaming(file, newName);
		URI newURI = URI.createPlatformResourceURI(newPath.toString(), true);
		return newURI;
	}

	/** @return the new path of the given file once {@link #renamed} is renamed as newName */
	private IPath pathAfterRenaming(IFile file, String newName) {
		if (!isImpactedByRenaming(file)) {
			return file.getFullPath();
		}
		IPath containerPath = renamed.getFullPath().removeLastSegments(1);
		IPath containerPathAfterRenaiming = containerPath.append(newName);
		IPath relativeFilePath = file.getFullPath().removeFirstSegments(renamed.getFullPath().segmentCount());
		return containerPathAfterRenaiming.append(relativeFilePath);
	}

	/** @return whether the path of the given file will change once {@link #renamed} is renamed */
	private boolean isImpactedByRenaming(IFile file) {
		return file.getFullPath().matchingFirstSegments(renamed.getFullPath()) == renamed.getFullPath().segmentCount();
	}

	/** @return the files of the workspace identified by given URI */
	private static Set<IFile> toWorkspaceFiles(String uri) {
		try {
			URI behaviorURI = URI.createURI(uri);
			return toWorkspace(new File(toAbsoluteFilePath(behaviorURI)));
		}
		catch (NullPointerException e) {
			// the file identified by the URI does not exist
			return new HashSet<>();
		}
	}
	
	/** @return the system-absolute path of the file identified by the given URI */
	private static String toAbsoluteFilePath(URI uri) {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		if(ws != null) {
			IResource file = ws.getRoot().findMember(uri.toPlatformString(true));
			if(file != null) {
				return file.getLocationURI().getRawPath();
			}
		}
		return null;
	}
	
	/** @return the files of the workspace that correspond to the given file */
	private static Set<IFile> toWorkspace(File file) {
		java.net.URI location = file.toURI();
		IFile[] files = ResourcesPlugin.getWorkspace().getRoot()
									   .findFilesForLocationURI(location);
		return new HashSet<>(asList(files));
	}
	
	/** @return the file of the workspace identified by the given URI */
	private static IFile toWorkspace(URI uri) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
	}

}
