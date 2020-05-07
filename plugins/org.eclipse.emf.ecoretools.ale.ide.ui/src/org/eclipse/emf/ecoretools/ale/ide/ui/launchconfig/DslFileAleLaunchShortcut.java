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

import java.io.IOException;
import java.util.Optional;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.impl.DslConfiguration;
import org.eclipse.emf.ecoretools.ale.ide.Activator;

/**
 * Action triggered when the user right-click on a .dsl file
 * and selects Run As &gt; ALE Application. 
 */
public class DslFileAleLaunchShortcut extends AbstractAleLaunchShortcut {
	
	private IAleEnvironment environment;
	
	private IResource modelFile;

	private String baseConfigurationName;

	@Override
	protected void prepareLaunchOn(IResource resource) throws CoreException {
		if (! (resource instanceof IFile)) {
			throw new IllegalArgumentException("Shortcut can only be applied on .dsl files (got: " + resource + ")");
		}
		IFile dslFile = (IFile) resource;
		try {
			environment = new DslConfiguration(dslFile.getContents());
			baseConfigurationName = configurationNameFor(dslFile);
			
			modelFile = askUserToSelectAnXmiModel(dslFile).orElse(null);
		}
		catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}
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
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	///    LAUNCH CONFIGURATIONS-RELATED UTILITY FUNCTIONS ////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings("squid:S1488")
	private String configurationNameFor(IResource dslFile) {
		String fileName = dslFile.getName();
		
		if (! fileName.contains(".")) {
			return fileName;
		}
		String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf("."));
		return fileNameWithoutExtension;
	}
	
}