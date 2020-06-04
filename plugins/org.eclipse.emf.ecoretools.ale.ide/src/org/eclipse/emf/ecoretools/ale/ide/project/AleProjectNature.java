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
package org.eclipse.emf.ecoretools.ale.ide.project;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

/**
 * A project nature aimed at tagging projects using ALE source files.
 * <p>
 * Use {@link IAleProject#hasAleNature(IProject)} to check whether a project
 * has the ALE nature.
 */
public class AleProjectNature implements IProjectNature {
	
	/**
	 * ID of the ALE project nature.
	 */
	public static final String ID = "org.eclipse.emf.ecoretools.ale.ide.project.alenature";
	
	private IProject project;

	@Override
	public IProject getProject() {
		return project;
	}
	
	@Override
	public void setProject(IProject project) {
		this.project = project;
	}
	
	@Override
	public void configure() throws CoreException {
		// nothing to configure
	}

	@Override
	public void deconfigure() throws CoreException {
		// nothing to configure
	}

}
