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
package org.eclipse.emf.ecoretools.ale.core.validation.impl;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.parser.AstValidator;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.implementation.Case;
import org.eclipse.emf.ecoretools.ale.implementation.Switch;

/**
 * Validates an AQL AST.
 * <p>
 * Extends AQL's default evaluator to support ALE's 'switch' expression.
 */
public class AleValidator extends AstValidator {

	/**
	 * Creates a new AST evaluator supporting both 
	 * standard AQL expressions and new ALE expressions.
	 * 
	 * @param services
	 * 			The set of available AQL services.
	 */
	public AleValidator(ValidationServices services) {
		super(services);
	}

	@Override
	public Set<IType> defaultCase(EObject object) {
		Set<IType> possibleTypes = new HashSet<>();
		
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
					possibleTypes = doSwitch(aCase.getValue());
					break;
				}
			}
			// Default case
			if (possibleTypes.isEmpty()) {
				possibleTypes = doSwitch(switchExp.getDefault());
			}
			validationResult.addTypes(switchExp, possibleTypes);
		}
		else {
			possibleTypes = super.defaultCase(object);
		}
		return possibleTypes;
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
