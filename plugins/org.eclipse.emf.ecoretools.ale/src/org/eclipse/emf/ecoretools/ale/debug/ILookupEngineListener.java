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
package org.eclipse.emf.ecoretools.ale.debug;

import org.eclipse.acceleo.query.runtime.ILookupEngine;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.validation.type.IType;

public interface ILookupEngineListener {

	/**
	 * Called at the start of {@link ILookupEngine#lookup(String, IType[])
	 */
	public void preLookup(String name, IType[] argumentTypes);
	
	/**
	 * Called at the end of {@link ILookupEngine#lookup(String, IType[])
	 */
	public void postLookup(IService foundService);
	
}
