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
import static java.util.Objects.requireNonNull;
import static org.eclipse.emf.ecoretools.ale.core.preferences.AleProjectPreferences.ALE_SOURCE_FILES;
import static org.eclipse.emf.ecoretools.ale.core.preferences.AleProjectPreferences.CONFIGURED_FROM_DSL_FILE;
import static org.eclipse.emf.ecoretools.ale.core.preferences.AleProjectPreferences.DSL_FILE_PATH;
import static org.eclipse.emf.ecoretools.ale.core.preferences.AleProjectPreferences.ECORE_MODEL_FILES;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecoretools.ale.core.preferences.AleProjectPreferences;
import org.eclipse.emf.ecoretools.ale.ide.Activator;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.osgi.service.prefs.BackingStoreException;

/**
 * A change that updates the paths to ALE resources in a project's preferences.
 * <p>
 * This change is supposed to occur <strong>after</strong> that the project has been renamed.
 * <p>
 * Those preferences are identified by {@link AleProjectPreferences}. 
 */
public class RenamePathsInProjectPreferencesChange extends Change {
	
	private final IProject project;
	private final IFile oldDslFile;
	private final IFile newDslFile;
	private final Collection<String> behaviors;
	private final Collection<String> metamodels;

	/**
	 * Creates a new change that updates paths to ALE resources in a project's preferences.
	 * 
	 * @param project
	 * 			The project which preferences must be updated
	 * @param oldDslFile
	 * 			The .dsl file used to configure the project before its renaming,
	 * 			or null if the project doesn't use any
	 * @param newDslFile
	 * 			The .dsl file used to configure the project after its renaming,
	 * 			or null if the project doesn't use any
	 * @param behaviors
	 * 			The new URIs to environment's behaviors 
	 * @param metamodels
	 * 			The new URIs to environment's metamodels 
	 */
	public RenamePathsInProjectPreferencesChange(IProject project, IFile oldDslFile, IFile newDslFile, Collection<String> behaviors, Collection<String> metamodels) {
		super();
		this.project = requireNonNull(project, "project");
		this.oldDslFile = oldDslFile;
		this.newDslFile = newDslFile;
		this.behaviors = requireNonNull(behaviors, "behaviors");
		this.metamodels = requireNonNull(metamodels, "metamodels");
	}

	@Override
	public String getName() {
		return "Update preferences of '" + project.getName() + "'";
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
		// nothing to do
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException {
		// Actually project.exists() is always false here (and within initialize)
		// so the lines below are not a reliable way to check change's validity
		
//		if (!project.exists()) {
//			return RefactoringStatus.createFatalErrorStatus("project '" + project.getName() + "' does not exist");
//		}
		return RefactoringStatus.create(Status.OK_STATUS);
	}

	@Override
	public Object getModifiedElement() {
		return project;
	}
	
	@Override
	public Object[] getAffectedObjects() {
		return new Object[] { project };
	}
	
	@Override
	public Change perform(IProgressMonitor monitor) throws CoreException {
		IScopeContext context = new ProjectScope(project);
        IEclipsePreferences preferences = context.getNode("org.eclipse.emf.ecoretools.ale.core");
        
    	if (newDslFile != null) {
        	URI dslFileURI = URI.createPlatformResourceURI(newDslFile.getFullPath().toPortableString(), true);
			preferences.put(DSL_FILE_PATH.property(), dslFileURI.toString());
        }
    	List<String> currentBehaviors = asList(preferences.get(ALE_SOURCE_FILES.property(), "").split(","));
    	List<String> currentMetamodels = asList(preferences.get(ECORE_MODEL_FILES.property(), "").split(","));
        boolean pathsAreStoredInPreferences = !preferences.getBoolean(CONFIGURED_FROM_DSL_FILE.property(), false);
		if (pathsAreStoredInPreferences) {
        	preferences.put(ALE_SOURCE_FILES.property(), commaSeparated(behaviors));
        	preferences.put(ECORE_MODEL_FILES.property(), commaSeparated(metamodels));
        }
		try {
			preferences.flush();
			
			Change undo = new RenamePathsInProjectPreferencesChange(project, newDslFile, oldDslFile, currentBehaviors, currentMetamodels);
			return undo;
		} 
		catch (BackingStoreException e) {
			Activator.error("Unable to update " + project.getName() + "'s preferences impacted by refactoring", e);
		}
		return null;
	}
	
	private static String commaSeparated(Collection<String> elements) {
		return String.join(",", elements);
	}

}
