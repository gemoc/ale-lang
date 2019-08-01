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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.implementation.Method;

public class ALEEngine {
	
	EvalEnvironment implemEnv;
	
	public ALEEngine (EvalEnvironment evalEnv) {
		this.implemEnv = evalEnv;
	}
	
	public EvaluationResult eval(EObject target, Method mainOp, List<Object> args) {
		EvaluationResult res;
		MethodEvaluator evaluator = new MethodEvaluator(new ExpressionEvaluationEngine(implemEnv.getQueryEnvironment(),implemEnv.getListeners()), implemEnv.getFeatureAccess());
		try {
			res = evaluator.eval(target,mainOp,args);
		}
		catch(CriticalFailure e) {
			res = new EvaluationResult(null, e.diagnostics);
		}
		return res;
	}
	
	public EvalEnvironment getEvalEnvironment() {
		return implemEnv;
	}
}