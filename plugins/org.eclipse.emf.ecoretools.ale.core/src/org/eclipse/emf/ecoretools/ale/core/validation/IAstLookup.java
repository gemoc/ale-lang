/*******************************************************************************
 * Copyright (c) 2019 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.validation;

import java.util.Set;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;

/**
 * Used to retrieve the types of expressions manipulated by ALE.
 */
public interface IAstLookup {
	
	/**
	 * Infers the types of a given expression.
	 * 
	 * @param expression
	 * 			The expression which types must be inferred
	 * 
	 * @return the types inferred for the given expression
	 */
	Set<IType> inferredTypesOf(Expression expression);
	
	/**
	 * Determines the types used to declare a variable.
	 * 
	 * @param variableName
	 * 			The name of the variable to check
	 * @param astBranch
	 * 			A branch of the AST from which types will be looked for
	 * 
	 * @return the types found for the given variable
	 */
	Set<IType> typesDeclaredFor(String variableName, EObject astBranch);
	
	/**
	 * Determines all the possible types of a feature.
	 * 
	 * @param featureName
	 * 			The name of the feature
	 * @param featureAccessExpression
	 * 			The expression representing the access to the feature
	 * 
	 * @return all the possible types of the feature
	 */
	Set<IType> findFeatureTypes(String featureName, Expression featureAccessExpression);
	
	/**
	 * Determines the method that surrounds a statement.
	 * 
	 * @param statement
	 * 			The statement to check
	 * 
	 * @return the method enclosing the given statement
	 */
	// TODO [Refactor] Consider returning Optional<Method>
	Method enclosingMethod(Statement statement);
	
}
