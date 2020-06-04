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
package org.eclipse.emf.ecoretools.ale.core.interpreter.internal;

import java.util.List;

import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.interpreter.CriticalFailureException;
import org.eclipse.emf.ecoretools.ale.implementation.Method;

// FIXME [API] What is the scope of this class?
//			   Based on its current usage it looks like we could get rid of it.
//			   Has it any purpose, like being more flexible than a whole AleInterpreter?
/**
 * @deprecated this class does not seem useful
 */
@Deprecated
public class AleEngine {
	
	private EvalEnvironment implemEnv;
	
	public AleEngine(EvalEnvironment evalEnv) {
		this.implemEnv = evalEnv;
	}
	
	public EvaluationResult eval(EObject target, Method mainOp, List<Object> args) {
		EvaluationResult res;
		MethodEvaluator evaluator = new MethodEvaluator(new ExpressionEvaluationEngine(implemEnv.getQueryEnvironment(),implemEnv.getListeners()), implemEnv.getFeatureAccess());
		try {
			res = evaluator.eval(target,mainOp,args);
		}
		catch(CriticalFailureException e) {
			res = new EvaluationResult(null, e.getDiagnostic());
			this.implemEnv.getLogger().notify(e.getDiagnostic());
		}
		return res;
	}
	
	public EvalEnvironment getEvalEnvironment() {
		return implemEnv;
	}
}