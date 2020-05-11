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
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.ecore.EObject;

/**
 * Turns {@link Message}s to String.
 * <p>
 * Formatters are supposed to be used to turn errors detected by ALE's interpreter,
 * compiler or validator into a string that can be printed to the console or shown in tooltips.
 */
public interface IDiagnosticFormatter {
	
	/**
	 * Turns given error to string.
	 * 
	 * @param error
	 * 			The error to format properly.
	 * 
	 * @return the error in a pretty format
	 */
	String adapt(EObject error);

}
