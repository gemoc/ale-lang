/*******************************************************************************
 * Copyright (c) 2019 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig;

/**
 * Holds constants used to deal with an ALE launch configuration.
 */
public final class AleLaunchConfiguration {
	/**
	 * The ID of the launch configuration as specified in the plugin.xml file.
	 */
	public static final String ID = "org.eclipse.emf.ecoretools.ale.ide.ui.launchConfigurationType";
	/**
	 * The name of the attribute storing the path to the .dsl file.
	 */
	public static final String DSL_FILE = "DSL_FILE";
	/**
	 * The name of the attribute storing the path to the .xmi file.
	 */
	public static final String MODEL_FILE = "MODEL_FILE";
	/**
	 * The name of the attribute storing the URI of the element to execute, relative to its resource.
	 */
	public static final String MAIN_MODEL_ELEMENT = "MAIN_MODEL_ELEMENT";
	/**
	 * The name of the attribute storing the {@link MethodRepresentation identifier} of the method to call.
	 */
	public static final String MAIN_METHOD = "MAIN_METHOD";
	
	private AleLaunchConfiguration() {
		// utility class, should not be instantiated
	}

}
