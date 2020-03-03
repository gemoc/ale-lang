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
package org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig;

import java.util.Optional;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.ide.project.AleProject;

/**
 * Action triggered when the user right-click on a project
 * and selects Run As &gt; ALE Application. 
 */
public class ProjectAleLaunchShortcut extends AbstractAleLaunchShortcut {
	
	private IAleEnvironment environment;
	
	private IResource modelFile;

	private String baseConfigurationName;

	@Override
	protected void prepareLaunchOn(IResource resource) throws Exception {
		// FIXME should also make sure no input is missing
		
		IProject project = resource.getProject();
		AleProject aleProject = AleProject.from(project);
		environment = aleProject.getEnvironment();
		baseConfigurationName = project.getName();
		
		modelFile = askUserToSelectAnXmiModel(null).orElse(null);
	}

	@Override
	protected String getBaseConfigurationName() {
		return baseConfigurationName;
	}

	@Override
	protected IAleEnvironment getEnvironment() {
		return environment;
	}
	
	@Override
	protected Optional<IResource> getModel() {
		return Optional.ofNullable(modelFile);
	}
	
}
