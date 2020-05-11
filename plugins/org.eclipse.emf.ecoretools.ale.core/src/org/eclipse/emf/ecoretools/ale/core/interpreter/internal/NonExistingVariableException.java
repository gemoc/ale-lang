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
package org.eclipse.emf.ecoretools.ale.core.interpreter.internal;

/**
 * Thrown when an attempt to query a variable that does not exist is made. 
 */
public class NonExistingVariableException extends IllegalArgumentException {

	/**
	 * Generated serial UID.
	 */
	private static final long serialVersionUID = -5230569305013748671L;

	/**
	 * Creates an exception supposed to be thrown when an attempt 
	 * to query a variable that does not exist is made.
	 */
	public NonExistingVariableException() {
		super();
	}

	/**
	 * Creates an exception supposed to be thrown when an attempt 
	 * to query a variable that does not exist is made.
	 */
	public NonExistingVariableException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates an exception supposed to be thrown when an attempt 
	 * to query a variable that does not exist is made.
	 */
	public NonExistingVariableException(String s) {
		super(s);
	}

	/**
	 * Creates an exception supposed to be thrown when an attempt 
	 * to query a variable that does not exist is made.
	 */
	public NonExistingVariableException(Throwable cause) {
		super(cause);
	}
	
}
