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

import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecore.ETypedElement;

/**
 * Used to check properties about types manipulated by ALE.
 */
/**
 * @author echebbi
 *
 */
public interface ITypeChecker {

	/**
	 * Returns all the types that can be inserted into a variable of given types.
	 * <p>
	 * <b><u>Important</b></u>: the returned set may not be comprehensive! For instance,
	 * if both {@code String} and {@code EString} are accepted then only one of these may
	 * be returned.
	 * 
	 * @param variableTypes
	 * 			The types of the variable into which a value should be inserted
	 * 
	 * @return the types of the values that can be inserted into a variable
	 * 		   of the given types.
	 */
	Set<IType> acceptedTypesForInsertion(Set<IType> variableTypes);

	/**
	 * Returns all the types that can be removed from a variable of given types.
	 * <p>
	 * <b><u>Important</b></u>: the returned set may not be comprehensive! For instance,
	 * if both {@code Integer} and {@code EInt} are accepted then only one of these may
	 * be returned.
	 * 
	 * @param variableTypes
	 * 			The types of the variable into which a value should be removed
	 * 
	 * @return the types of the values that can be removed from a variable
	 * 		   of the given types.
	 */
	Set<IType> acceptedTypesForRemoval(Set<IType> variableTypes);
	
	/**
	 * Determines whether a value of given types can be inserted to a variable of another types.
	 * 
	 * @param variableTypes
	 * 			The types of the variable to which a value could be inserted
	 * @param valueTypes
	 * 			The types of the value to insert
	 * 
	 * @return true if a value of a given types can be inserted to a variable of another types
	 */
	boolean acceptsInsertion(Set<IType> variableTypes, Set<IType> valueTypes);
	
	/**
	 * Determines whether a value of a given types can be removed from a variable of another types.
	 * 
	 * @param variableTypes
	 * 			The types of the variable from which a value could be removed
	 * @param valueTypes
	 * 			The types of the value to remove
	 * 
	 * @return true if a value of a given types can be removed from a variable of another types
	 */
	boolean acceptsRemoval(Set<IType> variableTypes, Set<IType> valueTypes);
	
	/**
	 * Determines whether a given element is allowed to belong to a collection.
	 * <p>
	 * In other words, determines whether the type of the element can be assigned
	 * to the type of the collection's elements.
	 * 
	 * @param collectionType
	 * 			The type of the collection to check
	 * @param elementType
	 * 			The type of the element that may belong to the collection
	 * 
	 * @return true if the element type is compatible with the collection, false otherwise
	 */
	boolean elementCanBelongToCollection(IType collectionType, IType elementType);
	
	/**
	 * Finds a value type that is assignable to given variable type. 
	 * 
	 * @param variableType
	 * 			The type of the variable to be assigned
	 * @param valueTypes
	 * 			The possible types of the value to assign
	 * 
	 * @return an assignable value type, if any
	 */
	Optional<IType> findCompatibleType(IType variableType, Set<IType> valueTypes);
	
	/**
	 * Determines whether a type can be assigned to another type. 
	 * <p>
	 * This function is required because {@link IType#isAssignableFrom(IType)} does not work as expected
	 * when its parameter represents a metaclass defined within user's metamodel. Reasons are the following:
	 * <ul>
	 * 	<li>when the package is registered, EMF does not register the type as a subtype of EClass. This is
	 * 		likely expected since not explicitly stated in the metamodel, but still surprising. Hence, given:
	 * 		<ul>
	 * 			<li>target = EClass
	 * 			<li>value = Greet (a custom EClass)
	 * 		</ul>
	 * 		Acceleo is not able to determine that Greet inherits from EClass and returns false when 
	 * 		{@code target.isAssignableFrom(value)} is called.
	 * 
	 * 	<li>when no corresponding Java class is registered for the user class (which happens at least when 
	 * 		the user has defined a metamodel but didn't generate any code) then the method returns true most
	 *      of the time. That's because, since Acceleo is not able to determine that user's class inherits internally the algorithm is close to:
	 * 		<pre>boolean isAssignableFrom(otherType) {
	 *    if (getJavaClass(otherType) == null) {
	 *        return this.isAssignable(null); 
	 *    }
	 *    return getJavaClass(this).isAssignableFrom(getJavaClass(otherType);
	 *}</pre>
	 * </ul>
	 * <p>
	 * Moreover, type parameters are not taken into account when comparing collections.
	 * <p>
	 * This method performs checks corresponding to the previous cases then calls {@link IType#isAssignableFrom(IType)}.
	 * 
	 * @param variableType
	 * 			The type to which a value should be assigned
	 * @param valueType
	 * 			The type of the expression to assign
	 * 
	 * @return whether a value of type {@code valueType} can be assigned to a variable of type {@code target}
	 * 
	 * @see #isAssignable(IType, Set)
	 */
	boolean isAssignable(IType variableType, IType valueType);

	/**
	 * Determines whether at least one type among a set can be assigned to another type.
	 * 
	 * @param variableType
	 * 			The type to which a value should be assigned
	 * @param valueTypes
	 * 			The possible types of the expression to assign
	 * 
	 * @return true if at least one of value types can be assigned to the variable type
	 * 
	 * @see #isAssignable(IType, IType)
	 */
	boolean isAssignable(IType variableType, Set<IType> valueTypes);
	
	/**
	 * Determines whether an expression yields a boolean value.
	 * 
	 * @param expression
	 * 			The expression to check.
	 * 
	 * @return true if the expression yields a boolean value, false otherwise
	 */
	boolean isBoolean(Expression expression);
	
	/**
	 * Determines whether the given type corresponds to a boolean.
	 * 
	 * @param type
	 * 			The type to check
	 * 
	 * @return true if the type represents a boolean, false otherwise
	 */
	boolean isBoolean(IType type);
	
	/**
	 * Determines whether the given type corresponds to a collection.
	 * 
	 * @param type
	 * 			The type to check
	 * 
	 * @return true if the type represents a collection, false otherwise
	 */
	boolean isCollection(IType type);
	
	/**
	 * Determines whether the given type corresponds to an integer.
	 * 
	 * @param type
	 * 			The type to check
	 * 
	 * @return true if the type represents an integer, false otherwise
	 */
	boolean isInteger(IType type);

	/**
	 * Determines whether the given type corresponds to {@code null}.
	 * 
	 * @param type
	 * 			The type to check
	 * 
	 * @return true if the type represents {@code null}, false otherwise
	 */
	boolean isNull(IType type);

	/**
	 * Determines whether the given type corresponds to a set of unique elements.
	 * 
	 * @param type
	 * 			The type to check
	 * 
	 * @return true if the type represents a set, false otherwise
	 */
	boolean isSet(IType type);

	/**
	 * Determines whether the given type corresponds to an ordered list.
	 * 
	 * @param type
	 * 			The type to check
	 * 
	 * @return true if the type represents an ordered list, false otherwise
	 */
	boolean isSequence(IType type);
	
	/**
	 * Determines whether the given type corresponds to a string.
	 * 
	 * @param type
	 * 			The type to check
	 * 
	 * @return true if the type represents a string, false otherwise
	 */
	boolean isString(IType type);
	
	/**
	 * Determines whether the type is known.
	 * 
	 * @param type
	 * 			The type to check
	 * 
	 * @return false if the type is known, true otherwise
	 */
	boolean isUnknown(IType type);

	/**
	 * Determines whether the type has been resolved.
	 * 
	 * @param type
	 * 			The type to check
	 * 
	 * @return false is the type has been resolved, true otherwise
	 */
	boolean isUnresolved(ETypedElement type);
	
	/**
	 * Determines whether a type supports the '+=' operator.
	 * 
	 * @param type
	 * 			The type to check
	 * 
	 * @return true if the type supports the '+=' operator, false otherwise
	 * 
	 * @see #supportsRemoval(IType)
	 */
	boolean supportsInsertion(IType type);

	/**
	 * Determines whether a type supports the '-=' operator.
	 * 
	 * @param type
	 * 			The type to check
	 * 
	 * @return true if the type supports the '-=' operator, false otherwise
	 * 
	 * @see #supportsInsertion(IType)
	 */
	boolean supportsRemoval(IType type);
	
}
