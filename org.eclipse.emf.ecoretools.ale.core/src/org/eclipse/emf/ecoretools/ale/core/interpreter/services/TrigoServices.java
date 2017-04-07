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
 * AQL service providing basic trigonometry
 */
public class TrigoServices {
	
	public static double cosinus(Double angle) {
		return Math.cos((angle/360.0)*Math.PI*2);
	}
	
	public static double sinus(Double angle) {
		return Math.sin((angle/360.0)*Math.PI*2);
	}
	
	public static double tan(Double angle) {
		return Math.tan((angle/360.0)*Math.PI*2);
	}
	
}