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

import static java.util.Objects.requireNonNull;

import java.util.Set;

import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.validation.type.IType;

/**
 * Represents a modification that can be applied to a variable/feature.
 * <p>
 * Convenient interface used internally by {@link TypeValidator}; it has been put
 * in its own class to alleviate the code.
 */
interface IVariableModificationStrategy {

	/**
	 * Determines the scope of the modification.
	 * @return true if the modification inserts a new value, false if it removes one.
	 */
	boolean isInsertion();
	
	/**
	 * Determines all the types of the values that can be accepted as operand of the modification.
	 * 
	 * @param variableTypes
	 * 			The types of the variable targeted by the modification
	 * 
	 * @return the types of the values that can be used to modify the variable
	 */
	Set<IType> acceptedTypes(Set<IType> variableTypes);

	/**
	 * Determines whether a variable supports the modification.
	 * 
	 * @param variableType
	 * 			The type of the variable
	 * 
	 * @return true if the variable supports the modification, false otherwise
	 */
	boolean supportsModification(IType variableType);

	/**
	 * Determines whether the modification can be applied on a variable using a given value.
	 * 
	 * @param variableTypes
	 * 			The types of the variable to modify
	 * @param valueTypes
	 * 			The types of the value used to modify the variable
	 * 
	 * @return true if the modification is allowed, false otherwise
	 */
	boolean acceptsModification(Set<IType> variableTypes, Set<IType> valueTypes);
	
	/**
	 * Creates a message warning about an attempt to modify a variable with a value
	 * having an incompatible type.
	 * 
	 * @param variableTypes
	 * 			The types of the variable
	 * @param removedValueTypes
	 * 			The types of the value to removed
	 * @param acceptedValueTypes
	 * 			The types that are compatible for an insertion to the variable
	 * @param valueExpression
	 * 			The value used to modify the variable
	 * 
	 * @return a new validation message
	 */
	IValidationMessage createIllegalModificationMessage(Set<IType> variableTypes, Set<IType> valueTypes, Set<IType> acceptedValueTypes, Object valueExpression);
}

/**
 * Represents the insertion of a value (the '+=' operator). 
 */
class InsertionStrategy implements IVariableModificationStrategy {

	private final ITypeChecker typeChecker;

	private final IValidationMessageFactory messages;
	
	/**
	 * Creates a new modification strategy representing the insertion of a value (the '+=' operator).
	 * 
	 * @param typeChecker
	 * 			The instance used to check the types of variables
	 * @param messages
	 * 			The factory used to create validation messages
	 */
	public InsertionStrategy(ITypeChecker typeChecker, IValidationMessageFactory messages) {
		this.typeChecker = requireNonNull(typeChecker, "typeChecker");
		this.messages = requireNonNull(messages, "messages");
	}

	@Override
	public boolean isInsertion() {
		return true;
	}

	@Override
	public Set<IType> acceptedTypes(Set<IType> variableTypes) {
		return typeChecker.acceptedTypesForInsertion(variableTypes);
	}

	@Override
	public boolean supportsModification(IType variableType) {
		return typeChecker.supportsInsertion(variableType);
	}

	@Override
	public boolean acceptsModification(Set<IType> variableTypes, Set<IType> valueTypes) {
		return typeChecker.acceptsInsertion(variableTypes, valueTypes);
	}

	@Override
	public IValidationMessage createIllegalModificationMessage(Set<IType> variableTypes, Set<IType> valueTypes,
			Set<IType> acceptedValueTypes, Object valueExpression) {
		return messages.illegalInsertion(
				variableTypes, valueTypes, acceptedValueTypes, valueExpression);
	}

}

/**
 * Represents the removal of a value (the '-='operator)
 */
class RemovalStrategy implements IVariableModificationStrategy {

	private final ITypeChecker typeChecker;
	
	private final IValidationMessageFactory messages;

	/**
	 * Creates a new modification strategy representing the removal of a value (the '-=' operator).
	 * 
	 * @param typeChecker
	 * 			The instance used to check the types of variables
	 * @param messages
	 * 			The factory used to create validation messages
	 */
	public RemovalStrategy(ITypeChecker typeChecker, IValidationMessageFactory messages) {
		this.typeChecker = typeChecker;
		this.messages = messages;
	}

	@Override
	public boolean isInsertion() {
		return false;
	}

	@Override
	public Set<IType> acceptedTypes(Set<IType> variableTypes) {
		return typeChecker.acceptedTypesForRemoval(variableTypes);
	}

	@Override
	public boolean supportsModification(IType variableType) {
		return typeChecker.supportsRemoval(variableType);
	}

	@Override
	public boolean acceptsModification(Set<IType> variableTypes, Set<IType> valueTypes) {
		return typeChecker.acceptsRemoval(variableTypes, valueTypes);
	}

	@Override
	public IValidationMessage createIllegalModificationMessage(Set<IType> variableTypes, Set<IType> valueTypes,
			Set<IType> acceptedValueTypes, Object valueExpression) {
		return messages.illegalRemoval(
				variableTypes, valueTypes, acceptedValueTypes, valueExpression);
	}

}