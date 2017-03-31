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
package org.eclipse.ecoretools.ale.core.interpreter.test;

import org.eclipse.emf.ecore.EObject;

public class Service {
	public String foobar(EObject o) {
		return "foobar:"+o.eClass().getName();
	}
}
