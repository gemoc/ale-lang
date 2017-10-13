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
package org.eclipse.emf.ecoretools.ale.core.delegate;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ALEEngine;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecore.InternalEObject;

public class ALEInvocationDelegate implements InvocationDelegate {

	ALEEngine engine;
	Optional<Method> mtd;
	
	public ALEInvocationDelegate(ALEEngine engine, Optional<Method> mtd) {
		this.engine = engine;
		this.mtd = mtd;
	}
	
	@Override
	public Object dynamicInvoke(InternalEObject target, EList<?> arguments) throws InvocationTargetException {
		
		if(mtd.isPresent()) {
			return engine.eval(target, mtd.get(), (List<Object>) arguments);
		}
		
		return null;
	}

}
