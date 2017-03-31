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
package org.eclipse.ecoretools.ale.core.interpreter.services;

import org.eclipse.ecoretools.ale.core.interpreter.EvalEnvironment;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.Sets;

/**
 * AQL service to create instance of EClass
 */
public class FactoryService {
	
	EvalEnvironment evalEnv;
	
	public FactoryService(EvalEnvironment evalEnv) {
		this.evalEnv = evalEnv;
	}
	
	public EObject create(EClass cls) {
		EObject newInstance = EcoreUtil.create(cls);
		evalEnv.initialize(Sets.newHashSet(newInstance));
		return newInstance;
	}
}