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
package org.eclipse.emf.ecoretools.ale.ide.ui.io;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;

/**
 * A console used to print the output of ALE programs.
 */
public class AleConsole extends MessageConsole {
	
	/**
	 * Creates a new console aimed at printing the output of ALE programs.
	 * 
	 * @param name
	 * 			The name of the console.
	 * @param imageDescriptor
	 * 			console image descriptor or null.
	 */
	private AleConsole(String name, ImageDescriptor imageDescriptor) {
		super(name, imageDescriptor);
	}
	
	/**
	 * Returns the current ALE console.
	 * <p>
	 * If an ALE console is already open, returns this instance. If no ALE console is found, creates a new one.
	 * 
	 * @return the current ALE console
	 */
	public static AleConsole current() {
		IConsole[] consoles = ConsolePlugin.getDefault().getConsoleManager().getConsoles();
		
		for (IConsole console : consoles) {
			if (console instanceof AleConsole) {
				return (AleConsole) console;
			}
		}
		AleConsole console = new AleConsole("ALE Console", null);
		ConsolePlugin.getDefault().getConsoleManager().addConsoles(new IConsole[] { console });
		
		return console;
	}
	
	@Override
	public void setName(String newName) {
		super.setName(newName);
	}

}
