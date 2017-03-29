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
package org.eclipse.acceleo.ale.core.interpreter;

import java.util.List;

import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.acceleo.ale.implementation.Behaviored;

public class ImplementationEngine {
	
	EvalEnvironment implemEnv;
	
	public ImplementationEngine (EvalEnvironment evalEnv) {
		this.implemEnv = evalEnv;
	}
	
	public EvaluationResult eval(EObject target, Behaviored mainOp, List<Object> args) {
		ImplementationEvaluator evaluator = new ImplementationEvaluator(new QueryEvaluationEngine(implemEnv.getQueryEnvironment()), implemEnv.getFeatureAccess());
		return evaluator.eval(target,mainOp,args);
	}
}