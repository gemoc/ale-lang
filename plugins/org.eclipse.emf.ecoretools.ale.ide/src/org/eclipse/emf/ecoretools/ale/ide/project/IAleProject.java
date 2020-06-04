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

import java.util.Optional;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.ide.project.impl.AleProject;

/**
 * <p>An Eclipse IDE project aimed at storing ALE source files.</p>
 *
 * <p>Such a project usually contains:
 * 	<ul>
 * 		<li>some <code>*.ale</code> source files,
 * 		<li>a <code>.dsl</code> description file
 * 	</ul>
 * 	and sometimes:
 * 	<ul>
 * 		<li>an <code>.ecore</code> model,
 * 		<li>an <code>.aird</code> representation file
 * 	</ul>
 * </p>
 */
public interface IAleProject {

	/**
	 * Turns given {@link IProject} into an ALE-aware one.
	 * <p>
	 * Makes easier to deal with projects using ALE.
	 * 
	 * @param project
	 * 			The project using ALE.
	 * 
	 * @return an ALE-aware version of the given project
	 */
	static IAleProject from(IProject project) {
		return new AleProject(project);
	}
	
	/**
	 * Checks whether a given project has the ALE nature.
	 * 
	 * @param project
	 * 			The project to check
	 * 
	 * @return true if the project has the ALE nature, false otherwise
	 */
	static boolean hasAleNature(IProject project) {
		try {
			return project.hasNature(AleProjectNature.ID);
		} catch (CoreException e) {
			return false;
		}
	}
	
	/**
	 * Returns whether the project's environment is configured from project's preferences.
	 * @return true if the environment is configured from project's preferences,
	 * 		   false if the environment is configured from a .dsl file
	 */
	boolean isConfiguredFromPreferences();
	
	/**
	 * Returns the .dsl file used to configure project's environment, if any.
	 * <p>
	 * Returns nothing only in one of the following cases:
	 * <ul>
	 * 	<li>the project {@link #isConfiguredFromPreferences() is configured from its preferences}
	 * 	<li>the .dsl file cannot be located from project's preferences
	 * </ul>
	 * 
	 * @return the .dsl file used to configure project's environment, if any
	 * 
	 * @see #isConfiguredFromPreferences()
	 * @see #getEnvironment()
	 */
	Optional<IFile> findDslFile();
	
	/**
	 * Returns the environment relevant to tooling operating on resources of this project.
	 * @return the environment relevant to tooling operating on resources of this project.
	 */
	IAleEnvironment getEnvironment();
	
	/**
	 * Returns the underlying Eclipse project.
	 * @return the underlying Eclipse project
	 */
	IProject getProject(); 

}
