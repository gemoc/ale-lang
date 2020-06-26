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
package org.eclipse.emf.ecoretools;

import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.BundleContext;

public class AleXtextPlugin extends Plugin {
	
	public static final String PLUGIN_ID = "org.eclipse.emf.ecoretools.ale.xtext";

	// The shared instance
	private static AleXtextPlugin plugin;

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}


	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static AleXtextPlugin getDefault() {
		return plugin;
	}

	public static void warn(String msg, Throwable e) {
		AleXtextPlugin.getDefault().getLog().log(new Status(Status.WARNING, PLUGIN_ID, Status.OK, msg, e));
	}

	public static void error(String msg, Throwable e) {
		AleXtextPlugin.getDefault().getLog().log(new Status(Status.ERROR, PLUGIN_ID, Status.OK, msg, e));
	}
	

}
