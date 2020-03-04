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
package org.eclipse.emf.ecoretools.ale.ide.project.impl;

import static org.eclipse.emf.ecoretools.ale.core.preferences.AleProjectPreferences.ALE_SOURCE_FILES;
import static org.eclipse.emf.ecoretools.ale.core.preferences.AleProjectPreferences.CONFIGURED_FROM_DSL_FILE;
import static org.eclipse.emf.ecoretools.ale.core.preferences.AleProjectPreferences.DSL_FILE_PATH;
import static org.eclipse.emf.ecoretools.ale.core.preferences.AleProjectPreferences.ECORE_MODEL_FILES;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.impl.RuntimeAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.ide.Activator;
import org.eclipse.emf.ecoretools.ale.ide.Normalized;
import org.eclipse.emf.ecoretools.ale.ide.project.AleProject;

/**
 * Decorates {@link IProject} to enhance them with ALE-specific features.
 */
public class AleAware implements AleProject {
	
	public static final String CORE_PLUGIN_ID = "org.eclipse.emf.ecoretools.ale.core";
	
	private final IProject project;

	public AleAware(IProject project) {
		this.project = project;
	}

	@Override
	public IProject create(String name, IPath path, IProgressMonitor monitor) throws CoreException {
		return project;
	}

	@Override
	public IAleEnvironment getEnvironment() {
		IScopeContext context = new ProjectScope(project);
        IEclipsePreferences preferences = context.getNode(CORE_PLUGIN_ID);
        
        try {
	        boolean reliesOnDslFile = preferences.getBoolean(CONFIGURED_FROM_DSL_FILE.property(), false);
			if (reliesOnDslFile) {
	        	return environmentFromDslConfigurationFile(preferences);
	        }
	        else {
	        	return environmentFromProjectPreferences(preferences);
	        }
        } 
        catch (IllegalArgumentException | IOException e) {
        	// TODO Do we want to broadcast the exception instead of catching it here?
        	Activator.error("Cannot load ALE environment of project '" + project.getName() + "'", e);
        	return new RuntimeAleEnvironment(new ArrayList<>(0), new ArrayList<>(0));
        }
	}

	private IAleEnvironment environmentFromDslConfigurationFile(IEclipsePreferences preferences) throws IOException {
		String dslFilePath = preferences.get(DSL_FILE_PATH.property(), "");
		URI dslFileURI = URI.createURI(dslFilePath, true);
		IResource dslFile = project.getWorkspace().getRoot().findMember(dslFileURI.toPlatformString(true));
		
		if (! (dslFile instanceof IFile)) {
			throw new IllegalArgumentException("Cannot load DSL file (expected IFile, got: " + dslFile + ")");
		}
		IFile file = (IFile) dslFile;
		try {
			return new Dsl(file.getContents());
		} 
		catch (CoreException e) {
			throw new IOException("Unable to read the content of the DSL configuration file " + dslFile.getFullPath());
		}
	}

	private IAleEnvironment environmentFromProjectPreferences(IEclipsePreferences preferences) {
		String aleSourceFilesPath = preferences.get(ALE_SOURCE_FILES.property(), "");
		String ecoreModelFilesPath = preferences.get(ECORE_MODEL_FILES.property(), "");

		List<String> sourceFiles = Arrays.asList(aleSourceFilesPath.split(","));
		List<String> ecoreModels = Arrays.asList(ecoreModelFilesPath.split(","));

		return new RuntimeAleEnvironment(ecoreModels, sourceFiles);
	}

}
