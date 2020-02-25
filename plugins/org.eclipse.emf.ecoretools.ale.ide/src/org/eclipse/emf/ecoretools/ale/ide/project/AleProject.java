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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;

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
public interface AleProject {
	
	/**
	 * Creates the project.
	 * 
	 * @param name
	 * 			The name of the project
	 * @param path
	 * 			The path of the project
	 * @param monitor
	 * 			The monitor used to follow the creation. Can be null.
	 * 
	 * @return the new project
	 * 
	 * @throws CoreException if the project cannot be created
	 */
	IProject create(String name, IPath path, IProgressMonitor monitor) throws CoreException;

}
