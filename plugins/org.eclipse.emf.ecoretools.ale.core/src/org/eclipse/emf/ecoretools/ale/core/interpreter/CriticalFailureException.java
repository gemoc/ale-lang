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
package org.eclipse.emf.ecoretools.ale.core.interpreter;

import org.eclipse.emf.common.util.BasicDiagnostic;

/**
 * Thrown when an unrecoverable failure happens in the interpreter. 
 */
public class CriticalFailureException extends Exception {
	
	private static final long serialVersionUID = 6830478207656290038L;
	
	private final transient BasicDiagnostic diagnostics;

	public CriticalFailureException(String message, BasicDiagnostic diagnostics) {
		super(message);
		this.diagnostics = diagnostics;
	}
	
	public BasicDiagnostic getDiagnostic() {
		return diagnostics;
	}
	
}
