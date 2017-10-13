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

import java.util.List;
import java.util.Map;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.parser.AstEvaluator;
import org.eclipse.acceleo.query.runtime.AcceleoQueryEvaluationException;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IQueryEvaluationEngine;
import org.eclipse.acceleo.query.runtime.impl.EvaluationServices;
import org.eclipse.acceleo.query.runtime.impl.Nothing;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.NotifyingEvaluationServices;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.ServiceCallListener;

/**
 * Engine able to evaluate Switch expression & standard AQL expression
 */
public class ExpressionEvaluationEngine implements IQueryEvaluationEngine {

	/**
	 * The environment containing all necessary information and used to execute query services.
	 */
	private IQueryEnvironment queryEnvironment;
	
	List<ServiceCallListener> listeners;
	
	public ExpressionEvaluationEngine(IQueryEnvironment queryEnvironment, List<ServiceCallListener> listeners) {
		this.queryEnvironment = queryEnvironment;
		this.listeners = listeners;
	}

	@Override
	public EvaluationResult eval(AstResult expression, Map<String, Object> environment)
			throws AcceleoQueryEvaluationException {
		EvaluationResult result = null;
		if (expression != null && expression.getAst() != null) {
			Expression ast = expression.getAst();
			ExpressionEvaluator evaluator = new ExpressionEvaluator(new NotifyingEvaluationServices(queryEnvironment,listeners));
			result = evaluator.eval(environment, ast);
			if (result.getResult() instanceof Nothing) {
				result = new EvaluationResult(null, result.getDiagnostic());
			}
		}
		return result;
	}
}
