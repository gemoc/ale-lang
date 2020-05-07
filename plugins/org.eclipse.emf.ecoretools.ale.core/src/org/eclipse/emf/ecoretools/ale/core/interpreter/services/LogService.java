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
package org.eclipse.emf.ecoretools.ale.core.interpreter.services;

/**
 * AQL service that prints objects to stdout.
 * <p>
 * Printing is made by calling {@code log()} on an object:
 * <pre>
 *anObject.log();</pre>
 */
public class LogService {
	
	public static void log(Object o) {
		System.out.println(String.valueOf(o));
	}
}