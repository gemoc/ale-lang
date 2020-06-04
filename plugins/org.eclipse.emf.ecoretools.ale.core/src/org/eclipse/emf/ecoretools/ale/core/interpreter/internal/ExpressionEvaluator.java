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

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.parser.AstEvaluator;
import org.eclipse.acceleo.query.runtime.impl.EvaluationServices;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.implementation.Case;
import org.eclipse.emf.ecoretools.ale.implementation.Switch;

/**
 * Evaluates an AQL AST.
 * <p>
 * Extends AQL's default evaluator to support ALE's 'switch' expression.
 */
public class ExpressionEvaluator extends AstEvaluator {

	/**
	 * Creates a new AST evaluator supporting both 
	 * standard AQL expressions and new ALE expressions.
	 * 
	 * @param services
	 * 			The set of available AQL services.
	 */
	public ExpressionEvaluator(EvaluationServices services) {
		super(services);
	}

	@Override
	public Object defaultCase(EObject object) {
		
		// The Switch here represents the 'switch' expression in the ALE language.
		// It is not handled by AstEvaluator and hence falls back into this 'default case'.
		//
		// Other features of ALE have been implemented through AQL standard features (e.g. Call)
		// and thus do not require special treatments.
		//
		if (object instanceof Switch) {
			Switch switchExp = (Switch) object;
			
			Expression input = switchExp.getParam();
			Object inputVal = doSwitch(input);
			
			// Browse cases
			for (Case aCase : switchExp.getCases()) {
				boolean inputMatchesCase = isMatchingGuard(inputVal,aCase.getGuard()) && isMatchingExp(inputVal,aCase.getMatch());
				if (inputMatchesCase) {
					return doSwitch(aCase.getValue());
				}
			}
			// Default case
			return doSwitch(switchExp.getDefault());
		}
		return super.defaultCase(object);
	}
	
	public boolean isMatchingGuard(Object obj, EClassifier type) {
		if (type == null) {
			return true;
		}
		else {
			return type.isInstance(obj);
		}
	}
	
	/**
	 * Returns the value of {@link matchExp} if it is boolean.
	 * Otherwise return {@link obj} equals {@link matchExp}
	 */
	public boolean isMatchingExp(Object obj, Expression matchExp) {
		if(matchExp == null) {
			return true;
		}
		else {
			Object matchValue = doSwitch(matchExp);
			
			if(matchValue instanceof Boolean) {
				return (boolean) matchValue;
			}
			else {
				return obj.equals(matchValue);
			}
		}
	}
}
