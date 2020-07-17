/*******************************************************************************
 * Copyright (c) 2019 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse License v1.0
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.VariableInsert;
import org.eclipse.emf.ecoretools.ale.implementation.VariableRemove;

/**
 * A factory that creates new, tailored, {@link Message validation messages}.
 * <p>
 * A lot of methods need a reference to an AST element. This element is used to set the position
 * of the message in the corresponding source code.
 * <p>
 * <b>Important</b>: this interface is for internal use only and should not be used by clients.
 */
public interface IValidationMessageFactory {
	
	/**
	 * Creates a message warning about the assignment to the 'result'
	 * variable within a void operation.
	 * 
	 * @param assignment
	 * 			The assignment to 'result'
	 * 
	 * @return a new validation message
	 */
	Message assignmentToResultInVoidOperation(Statement statement);
	
	/**
	 * Creates a message telling that an expression was supposed to be boolean.
	 * 
	 * @param exp
	 * 			The non-boolean expression
	 * 
	 * @return a new validation message
	 */
	Message expectedBoolean(Expression exp);
	
	/**
	 * Creates a message warning about a class extending itself.
	 * 
	 * @param xtdClass
	 * 			The class that extends itself.
	 * 
	 * @return a new validation message
	 */
	Message extendingItself(ExtendedClass xtdClass);
	
	/**
	 * Creates a message warning about an attempt to iterate over a scalar
	 * with a for each loop.
	 * 
	 * @param loop
	 * 			The for each statement
	 * 
	 * @return a new validation message
	 */
	Message forEachCanOnlyIterateOnCollections(ForEach loop);
	
	/**
	 * Creates a message warning about an attempt to assign a value to a variable
	 * of a non compatible type.
	 * 
	 * @param variableTypes
	 * 			The types of the variable
	 * @param valueTypes
	 * 			The types of the value
	 * @param assignment
	 * 			The assignment statement
	 * @param assignedValue
	 * 			The value assigned to the variable
	 * 
	 * @return a new validation message
	 */
	Message illegalAssignment(Set<IType> variableTypes, Set<IType> valueTypes, EObject assignment, Object assignedValue);
	
	/**
	 * Creates a message warning about an attempt to insert a value into a variable
	 * of a non compatible type.
	 * 
	 * @param variableTypes
	 * 			The types of the variable
	 * @param insertedValueTypes
	 * 			The types of the value to insert
	 * @param acceptedValueTypes
	 * 			The types that are compatible for an insertion to the variable
	 * @param value
	 * 			The value to insert
	 * 
	 * @return a new validation message
	 */
	Message illegalInsertion(Set<IType> variableTypes, Set<IType> insertedValueTypes, Set<IType> acceptedValueTypes, Expression value);
	
	/**
	 * Creates a message warning about an attempt to remove a value from a variable
	 * of a non compatible type.
	 * 
	 * @param variableTypes
	 * 			The types of the variable
	 * @param removedValueTypes
	 * 			The types of the value to removed
	 * @param acceptedValueTypes
	 * 			The types that are compatible for an insertion to the variable
	 * @param value
	 * 			The value to remove
	 * 
	 * @return a new validation message
	 */
	Message illegalRemoval(Set<IType> variableTypes, Set<IType> removedValueTypes, Set<IType> acceptedValueTypes, Expression value);
	
	/**
	 * Creates a message warning about unexpected types.
	 * 
	 * @param expected
	 * 			The expected types
	 * @param actual
	 * 			The actual, unexpected types
	 * @param statement
	 * 			The statement where the unexpected types have been found
	 * 
	 * @return a new validation message
	 */
	Message incompatibleTypes(Set<IType> expected, Set<IType> actual, EObject statement);
	
	/**
	 * Creates a message warning about an attempt to extend a class that is not 
	 * a direct super type of self.
	 * 
	 * @param xtdClass
	 * 			The extending class
	 * @param superBase
	 * 			The extended class
	 * @param baseCls
	 * 			The parent class of extending class
	 * 
	 * @return a new validation message
	 */
	Message indirectExtension(ExtendedClass xtdClass, EClass superBase, EClass baseCls);
	
	/**
	 * Creates a message warning about an attempt to insert a value into 'self'.
	 * 
	 * @param statement
	 * 			The insertion statement
	 * 
	 * @return a new validation message
	 */
	Message prohibitedInsertionToSelf(VariableInsert statement);

	/**
	 * Creates a message warning about an attempt to remove a value from 'self'.
	 * 
	 * @param statement
	 * 			The remove statement
	 * 
	 * @return a new validation message
	 */
	Message prohibitedRemovalFromSelf(VariableRemove statement);

	/**
	 * Creates a message warning about the use of a variable which type
	 * could not being resolved.
	 * 
	 * @param statement
	 * 			The statement or expression where the variable is used
	 * 
	 * @return a new validation message
	 */
	Message unresolvedType(EObject statement);
	
	/**
	 * Creates a message warning about the use of an operator on a feature
	 * which type does not support it.
	 * 
	 * @param featureTypes
	 * 			The types of the feature
	 * @param statement
	 * 			The statement in which the operator is used
	 * @param featureName
	 * 			The name of the feature on which the operator is used
	 * @param operator
	 * 			The operator
	 * 
	 * @return a new validation message
	 */
	Message unsupportedOperatorOnFeature(Set<IType> featureTypes, EObject statement, String featureName, Operator operator);
	
	/**
	 * Creates a message warning about the use of an operator on a variable
	 * which type does not support it.
	 * 
	 * @param variableTypes
	 * 			The types of the variable
	 * @param statement
	 * 			The statement in which the operator is used
	 * @param variableName
	 * 			The name of the variable on which the operator is used
	 * @param operator
	 * 			The operator
	 * 
	 * @return a new validation message
	 */
	Message unsupportedOperatorOnVariable(Set<IType> variableTypes, EObject statement, String variableName, Operator operator);

}
