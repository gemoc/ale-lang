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
import java.util.Optional;

import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.EvalBodyService;
import org.eclipse.emf.ecoretools.ale.implementation.Method;

public class ALEEngine {
	
	EvalEnvironment implemEnv;
	
	public ALEEngine (EvalEnvironment evalEnv) {
		this.implemEnv = evalEnv;
	}
	
	public EvaluationResult eval(EObject target, Method mainOp, List<Object> args) {
		
		Optional<EvalBodyService> entryPoint = 
			implemEnv
			.getQueryEnvironment()
			.getLookupEngine()
			.getRegisteredServices()
			.stream()
			.filter(service -> service instanceof EvalBodyService)
			.map(service -> (EvalBodyService) service)
			.filter(service -> service.getImplem() == mainOp)
			.findFirst();
		ArrayList<Object> arguments = new ArrayList<>();
		arguments.add(target);
		arguments.addAll(args);
		
		/*
		 * Pre Call
		 */
		if(entryPoint.isPresent()) {
			implemEnv.getCallListeners().forEach(l -> l.preCall(entryPoint.get(), arguments.toArray()));
		}
		
		/*
		 * Call
		 */
		MethodEvaluator evaluator = new MethodEvaluator(new ExpressionEvaluationEngine(implemEnv.getQueryEnvironment(),implemEnv.getCallListeners()), implemEnv.getFeatureAccess(),implemEnv.getStatementListeners());
		EvaluationResult result = evaluator.eval(target,mainOp,args);
		
		/*
		 * Post Call
		 */
		if(entryPoint.isPresent()) {
			implemEnv.getCallListeners().forEach(l -> l.postCall(entryPoint.get(), arguments.toArray(),result.getResult()));
		}
		
		return result;
	}
	
	public EvalEnvironment getEvalEnvironment() {
		return implemEnv;
	}
}