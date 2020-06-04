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
package org.eclipse.emf.ecoretools.ale.core.env;

/**
 * Thrown when an ALE interpreter is used although its environment has been closed.
 */
public class ClosedAleEnvironmentException extends Exception {
	
	private static final long serialVersionUID = -8494003054984405449L;
	
	public ClosedAleEnvironmentException(String string) {
		super(string);
	}
}