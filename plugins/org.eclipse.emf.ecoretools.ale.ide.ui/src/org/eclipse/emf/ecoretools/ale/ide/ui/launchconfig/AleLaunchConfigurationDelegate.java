/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

public class AleLaunchConfigurationDelegate implements ILaunchConfigurationDelegate {
	
	public static final String DSL_FILE = "DSL_FILE";
	public static final String MODEL_FILE = "MODEL_FILE";

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		
		String dslLocation = configuration.getAttribute(DSL_FILE, "");
		String modelLocation = configuration.getAttribute(MODEL_FILE, "");
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResource dslFile = workspace.getRoot().findMember(dslLocation);
		IResource modelFile = workspace.getRoot().findMember(modelLocation);
		 
		RunModelAction.launch(dslFile, modelFile);
	}
}
