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

import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.Scopes.Scope;

/**
 * Thrown when one attempts to pop {@link Scope} that is not the current scope
 * of the {@link Scopes} it belongs to. 
 */
public class UnpoppableScopeException extends IllegalStateException {

	/**
	 * Generated serial UID.
	 */
	private static final long serialVersionUID = -9138525606419960875L;

	/**
	 * Creates an exception supposed to be thrown when one attempts 
	 * to pop {@link Scope} that is not the current scope of the 
	 * {@link Scopes} it belongs to.
	 */
	public UnpoppableScopeException() {
		super();
	}

	/**
	 * Creates an exception supposed to be thrown when one attempts 
	 * to pop {@link Scope} that is not the current scope of the 
	 * {@link Scopes} it belongs to.
	 */
	public UnpoppableScopeException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Creates an exception supposed to be thrown when one attempts 
	 * to pop {@link Scope} that is not the current scope of the 
	 * {@link Scopes} it belongs to.
	 */
	public UnpoppableScopeException(String s) {
		super(s);
	}

	/**
	 * Creates an exception supposed to be thrown when one attempts 
	 * to pop {@link Scope} that is not the current scope of the 
	 * {@link Scopes} it belongs to.
	 */
	public UnpoppableScopeException(Throwable cause) {
		super(cause);
	}
	
}
