/*******************************************************************************
 * Copyright (c) 2020 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.interpreter.internal;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.validation.type.IType;

/**
 * An ordered collection of {@link Scope} instances. Keeps track of all the variables of a program.
 * <p>
 * Here is an idiomatic use:
 *<pre>Scopes scopes = ...
 *try (Scope methodScope = scopes.pushNew()) {
 *    methodScope.put("greeting", "Hello World!");
 *    
 *    try (Scope loopScope = scopes.pushNew()) {
 *        loopScope.put("i", 0);
 *    } 
 *    // calls loopScope.close() and pop the scope from scopes
 *}</pre>
 * <b>Important</b>: scope instance must be pop/closed in the reverse order they are pushed.
 * {@link Scope#close()} will throw an exception if the scope is not the current scope.
 * To prevent this:
 * <ol>
 * 	<li>always use a try-with-resource statement,
 * 	<li>call {@link #pop()} to pop the scope if you cannot use the try-with-resource statement.
 * </ol>
 */
public interface Scopes extends Iterable<Scopes.Scope> {

	/**
	 * A set of variables accessible at a given point of the program.
	 */
	public interface Scope extends AutoCloseable {

		/**
		 * Returns whether the scope is aware of a given variable.
		 * 
		 * @param variable
		 * 			The name of the variable
		 * 
		 * @return true if the scope knows at least the value or the types of the variable,
		 * 		   false otherwise
		 */
		boolean contains(String variable);
		
		/**
		 * Returns the name of all the variables which value is known.
		 * @return the name of all the variables which value is known
		 */
		Set<String> getVariableNames();
		
		/**
		 * Returns whether the value of a given variable is known.
		 * 
		 * @param variable
		 * 			The name of the variable
		 * 
		 * @return true if the value is known, false otherwise
		 */
		boolean hasValue(String variable);
		
		/**
		 * Returns the value of a given variable.
		 * <p>
		 * This value may be {@code null}.
		 * 
		 * @param variable
		 * 			The name of the variable
		 * 
		 * @return the value of the variable
		 * 
		 * @throws NonExistingVariableException if the value of the variable is unknown
		 * 
		 * @see #hasValue(String)
		 * @see #findValue(String)
		 */
		Object getValue(String variable);
		
		/**
		 * Returns the value of a given variable, if found.
		 * <p>
		 * Note that {@code Optional.empty()} is returned if the variable's value is null.
		 * 
		 * @param variable
		 * 			The name of the variable
		 * 
		 * @return the value of the variable, if found
		 * 
		 * @see #hasValue(String)
		 * @see #getValue(String)
		 */
		Optional<Object> findValue(String variable);
		
		/**
		 * Returns whether the types of a given variable is known.
		 * 
		 * @param variable
		 * 			The name of the variable
		 * 
		 * @return true if the types are known, false otherwise
		 * 
		 * @see #getTypes(String)
		 * @see #findTypes(String)
		 */
		boolean hasTypes(String variable);
		
		/**
		 * Returns the types of a given variable.
		 * 
		 * @param variable
		 * 			The name of the variable
		 * 
		 * @return the types of the variable
		 * 
		 * @throws NonExistingVariableException if the types of the variable are unknown
		 * 
		 * @see #hasTypes(String)
		 * @see #findTypes(String)
		 */
		Set<IType> getTypes(String variable);

		/**
		 * Returns the types of a given variable, if found.
		 * 
		 * @param variable
		 * 			The name of the variable
		 * 
		 * @return the types of the variable, if found
		 * 
		 * @see #hasTypes(String)
		 * @see #getTypes(String)
		 */
		Optional<Set<IType>> findTypes(String variable);
		
		/**
		 * Returns the types of all available variables as a {@code name -> types} mapping.
		 * @return the types of all available variables
		 */
		Map<String, Set<IType>> getVariableTypes();
	
		/**
		 * Returns the value of all available variables as a {@code name -> value} mapping.
		 * @return the value of all available variables
		 */
		Map<String, Object> getVariableValues();
		
		/**
		 * Sets the value and the types of a given variable.
		 * 
		 * @param variable
		 * 			The name of the variable
		 * @param types
		 * 			The types of the variable
		 * @param value
		 * 			The value of the variable
		 * 
		 * @see #putValue(String, Object)
		 * @see #putTypes(String, Set)
		 */
		void putVariable(String variable, Set<IType> types, Object value);
		
		/**
		 * Sets the value of a given variable.
		 * 
		 * @param variable
		 * 			The name of the variable
		 * @param value
		 * 			The new value
		 * 
		 * @see #putVariable(String, Set, Object)
		 * @see #putTypes(String, Set)
		 */
		void putValue(String variable, Object value);
		
		/**
		 * Sets the types of a given variable.
		 * 
		 * @param variable
		 * 			The name of the variable
		 * @param types
		 * 			The types of the variable
		 * 
		 * @see #putVariable(String, Set, Object)
		 * @see #putValue(String, Object)
		 */
		void putTypes(String variable, Set<IType> types);
		
		/**
		 * Sets the types of a given expression.
		 * 
		 * @param expression
		 * 			The expression
		 * @param types
		 * 			The types of the expression
		 */
		void putTypes(Expression expression, Set<IType> types);
		
		/**
		 * Returns all the types known for a given expression.
		 * 
		 * @param expression
		 * 			The expression
		 * 
		 * @return the types known for a given expression
		 */
		Set<IType> getPossibleTypesOf(Expression expression);
		
		/**
		 * Removes the scope from the {@link Scopes} object it belongs to,
		 * only if it's the current scope.
		 * <p>
		 * <b>Should not be called directly by clients.</b>
		 * 
		 * @throws UnpoppableScopeException if the scope is not the current scope of the
		 * 									{@link Scopes} object it belongs to
		 */
		@Override
		void close();
	}

	/**
	 * Returns whether no scope is currently available
	 * @return true if no scope exist, false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Returns the last scope that has been {@link #pushNew() pushed}.
	 * @return the last scope that has been pushed
	 * 
	 * @throws NoSuchElementException if {@link #isEmpty() empty}
	 */
	Scope getCurrent();
	
	/**
	 * Returns the scope where given variable has last been declared.
	 * 
	 * @param variable
	 * 			The name of the variable
	 * 
	 * @return the scope 
	 */
	Optional<Scope> getDeclaringScope(String variable);
	
	/**
	 * Pushes a new Scope on top of the others.
	 * <p>
	 * It is advised to call it in a try-with-resource statement:
	 * <pre>try (Scope newScope = scopes.pushNew()) {
	 *     
	 *}</pre>
	 *
	 * See {@link Scopes} for further details.
	 *
	 * @return the new Scope
	 */
	Scope pushNew();
	
	/**
	 * Pop the last Scope that has been pushed.
	 * <p>
	 * It is advised to not call this method unless you can't use
	 * a try-with-resource statement. See {@link Scopes} for further details.
	 * 
	 * @return the corresponding Scope, if any
	 */
	Optional<Scope> pop();
	
	/**
	 * Removes all the Scope instances.
	 */
	void clear();

}
