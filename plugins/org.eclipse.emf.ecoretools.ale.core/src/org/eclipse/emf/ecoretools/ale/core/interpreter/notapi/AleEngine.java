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
package org.eclipse.emf.ecoretools.ale.core.interpreter.notapi;

import java.util.List;

import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.Activator;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.CriticalFailureException;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.ExpressionEvaluationEngine;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.MethodEvaluator;
import org.eclipse.emf.ecoretools.ale.implementation.Method;

// FIXME [API] What is the scope of this class?
//			   Based on its current usage it looks like we could get rid of it.
//			   Has it any purpose, like being more flexible than a whole AleInterpreter?
//   this class is used by GEMOC in order to manage complex execution (multiple evaluations and runtime access)
public class AleEngine {
	
	private EvalEnvironment implemEnv;
	private IAleEnvironment environment;
	
	public AleEngine(EvalEnvironment evalEnv, IAleEnvironment environment) {
		this.implemEnv = evalEnv;
		this.environment = environment;
	}
	
	public EvaluationResult eval(EObject target, Method mainOp, List<Object> args) {
		EvaluationResult res = new EvaluationResult(null, new BasicDiagnostic());
		MethodEvaluator evaluator = new MethodEvaluator(environment, new ExpressionEvaluationEngine(implemEnv.getQueryEnvironment(),implemEnv.getListeners()), implemEnv.getFeatureAccess());
		try {
			res = evaluator.eval(target,mainOp,args);
		}
		catch(CriticalFailureException e) {
			res = new EvaluationResult(null, e.getDiagnostic());
			this.implemEnv.getLogger().notify(e.getDiagnostic());
		}
		catch (Exception e) {
			Throwable t = e;
			while (t.getCause() != null) {
				t = t.getCause();
				
				if (t instanceof CriticalFailureException) {
					CriticalFailureException criticalFailureException = (CriticalFailureException) t;
					
					res = new EvaluationResult(null, criticalFailureException.getDiagnostic());
					this.implemEnv.getLogger().notify(criticalFailureException.getDiagnostic());
				}
			}
			throw e;
		}
		return res;
	}
	
	public EvalEnvironment getEvalEnvironment() {
		return implemEnv;
	}
}