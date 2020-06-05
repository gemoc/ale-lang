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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.core.interpreter.notapi.EvalEnvironment;

import com.google.common.collect.Sets;

/**
 * AQL service that allows to instantiate EClasses.
 * <p>
 * Instantiation is made by calling {@code create()} on an EClass:
 * <pre>
 *FSM fsm := FSM.create();</pre>
 */
public class FactoryService {
	
	private EvalEnvironment evalEnv;
	
	public FactoryService(EvalEnvironment evalEnv) {
		this.evalEnv = evalEnv;
	}
	
	public EObject create(EClass cls) {
		EObject newInstance = EcoreUtil.create(cls);
		evalEnv.initialize(Sets.newHashSet(newInstance));
		return newInstance;
	}
}