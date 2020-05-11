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
package org.eclipse.emf.ecoretools.ale.core.interpreter.internal.impl;

import static java.lang.System.lineSeparator;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.NonExistingVariableException;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.Scopes;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.UnpoppableScopeException;

/**
 * A {@link Scopes} that keeps its {@link Scope} instances stacked.
 * <p>
 * The instances on the top of the stack have access to all the variables
 * declared in the instances below. 
 */
public class StackedScopes implements Scopes {
	
	/**
	 * FIXME This is a hack because EnclosedScope instances always
	 * take into account the variables known by their enclosing scope,
	 * making hard to determine the variables they actually store
	 * (necessary by e.g. {@link StackedScopes#getDeclaringScope(String)}.
	 * 
	 * The API should allow to explicitly deal with one the following views:
	 * <ul>
	 * 	<li>either a "flatten" scope (having access to all variables of lower scopes)
	 * 	<li>or a "nested" / "hierachical" scope (having only access to its own variables)
	 * </ul>
	 * 
	 * The Scopes API should then be updated as soon as we have a betterhindsight
	 * on what is exactly needed.
	 */
	private interface HumbleScope extends Scope {
		boolean containsOnItsOwn(String variable);
	}

	/**
	 * A scope that is always empty. Aims at simplifying code in EnclosedScope.
	 */
	private class EmptyScope implements HumbleScope {

		@Override
		public boolean contains(String variable) {
			return false;
		}
		
		@Override
		public boolean containsOnItsOwn(String variable) {
			return false;
		}

		@Override
		public Set<String> getVariableNames() {
			return new HashSet<>(0);
		}

		@Override
		public boolean hasValue(String variable) {
			return false;
		}

		@Override
		public Object getValue(String variable) {
			throw new IllegalArgumentException("variable '" + variable + "' not found");
		}

		@Override
		public Optional<Object> findValue(String variable) {
			return Optional.empty();
		}

		@Override
		public Map<String, Object> getVariableValues() {
			return new HashMap<>(0);
		}

		@Override
		public boolean hasTypes(String variable) {
			return false;
		}

		@Override
		public Set<IType> getTypes(String variable) {
			return new HashSet<>(0);
		}

		@Override
		public Optional<Set<IType>> findTypes(String variable) {
			return Optional.empty();
		}

		@Override
		public Map<String, Set<IType>> getVariableTypes() {
			return new HashMap<>(0);
		}
		
		@Override
		public void putVariable(String variable, Set<IType> types, Object value) {
			throw new UnsupportedOperationException("EmptyScope does not support 'putVariable(String, Set<IType>, Object)'; this method should not be called");
		}

		@Override
		public void putValue(String variable, Object value) {
			// Should never be called, but let's throw to warn the caller
			throw new UnsupportedOperationException("EmptyScope does not support 'putValue(String, Object)'; this method should not be called");
		}

		@Override
		public void putTypes(String variable, Set<IType> types) {
			// Should never be called, but let's throw to warn the caller
			throw new UnsupportedOperationException("EmptyScope does not support 'put(String, Set<IType)'; this method should not be called");
		}

		@Override
		public void putTypes(Expression expression, Set<IType> types) {
			// Should never be called, but let's throw to warn the caller
			throw new UnsupportedOperationException("EmptyScope does not support 'put(Expression, Set<IType>)'; this method should not be called");
		}

		@Override
		public Set<IType> getPossibleTypesOf(Expression expression) {
			return new HashSet<>(0);
		}
		
		@Override
		public void close() {
			if (StackedScopes.this.isEmpty()) {
				throw new UnpoppableScopeException("Cannot pop " + this + " when " + StackedScopes.this + " is empty");
			}
			if (StackedScopes.this.getCurrent() != this) {
				throw new UnpoppableScopeException("Cannot pop " + this + " when " + StackedScopes.this.getCurrent() + " is the current scope");
			}
			StackedScopes.this.pop();
		}
		
		@Override
		public String toString() {
			return "Scope: {}";
		}

	}
	
	/**
	 * A {@link Scope} that is enclosed within another one.
	 * <p>
	 * An enclosed scope has access to all the variables available in
	 * its enclosing scope.
	 */
	private class EnclosedScope implements HumbleScope {
		
		private final Scope enclosing;
		private final Map<String, Object> values;
		private final Map<String, Set<IType>> types;
		private final Map<Expression, Set<IType>> expressions;
		
		EnclosedScope(Scope enclosing) {
			this(enclosing, Collections.emptyMap());
		}

		EnclosedScope(Scope enclosing, Map<String, Object> variables) {
			this.enclosing = enclosing;
			this.values = new HashMap<>(variables);
			this.types = new HashMap<>();
			this.expressions = new HashMap<>();
		}
		
		@Override
		public boolean contains(String variable) {
			return getVariableNames().contains(variable) || getVariableTypes().containsKey(variable);
		}
		
		@Override
		public boolean containsOnItsOwn(String variable) {
			return types.containsKey(variable);
		}
		
		@Override
		public boolean hasValue(String variable) {
			return getVariableValues().containsKey(variable);
		}
		
		@Override
		public Object getValue(String variable) {
			return findValue(variable)
					.orElseThrow(() -> new NonExistingVariableException("variable '" + variable + "' not found"));
		}
		
		@Override
		public Optional<Object> findValue(String variable) {
			return Optional.ofNullable(values.get(variable));
		}
		
		@Override
		public boolean hasTypes(String variable) {
			return getVariableTypes().containsKey(variable);
		}
		
		@Override
		public Set<IType> getTypes(String variable) {
			return findTypes(variable)
					.orElseThrow(() -> new NonExistingVariableException("variable '" + variable + "' not found"));
		}
		
		@Override
		public Optional<Set<IType>> findTypes(String variable) {
			// First search current scope
			if (this.types.containsKey(variable)) {
				return Optional.ofNullable(types.get(variable));
			}
			// Then fallback to enclosing scopes
			else {
				return enclosing.findTypes(variable);
			}
		}
		
		@Override
		public Set<String> getVariableNames() {
			Set<String> names = new HashSet<>(this.values.keySet());
			names.addAll(enclosing.getVariableNames());
			return names;
		}
		
		@Override
		public void putVariable(String variable, Set<IType> types, Object value) {
			putValue(variable, value);
			putTypes(variable, types);
		}
		
		@Override
		public void putValue(String variable, Object value) {
			values.put(variable, value);
		}
		
		@Override
		public void putTypes(String variable, Set<IType> types) {
			this.types.put(variable, new HashSet<>(types));
		}
		
		@Override
		public void putTypes(Expression expression, Set<IType> types) {
			expressions.put(expression, new HashSet<>(types));
		}
		
		@Override
		public Set<IType> getPossibleTypesOf(Expression expression) {
			return expressions.getOrDefault(expression, new HashSet<>(0));
		}
		
		@Override
		public Map<String, Set<IType>> getVariableTypes() {
			// this.types are put *after* enclosing scope's types to prevent potential issues with namesakes
			Map<String, Set<IType>> variableTypes = enclosing.getVariableTypes();
			variableTypes.putAll(this.types);
			return variableTypes;
		}
		
		@Override
		public Map<String, Object> getVariableValues() {
			// this.variables are put *after* enclosing scope's types to prevent potential issues with namesakes
			Map<String, Object> variableValues = enclosing.getVariableValues();
			variableValues.putAll(this.values);
			return variableValues;
		}
		
		@Override
		public void close() {
			if (StackedScopes.this.isEmpty()) {
				throw new UnpoppableScopeException("Cannot pop " + this + " when " + StackedScopes.this + " is empty");
			}
			if (StackedScopes.this.getCurrent() != this) {
				throw new UnpoppableScopeException("Cannot pop " + this + " when " + StackedScopes.this.getCurrent() + " is the current scope");
			}
			StackedScopes.this.pop();
		}

		@Override
		public String toString() {
			return "EnclosedScope {" + lineSeparator() 
				 + "    values=" + getVariableValues() + "," + lineSeparator()
				 + "    types=" + getVariableTypes() + "," + lineSeparator()
				 + "    expressions=" + expressions + lineSeparator() 
				 + "}";
		}
		
	}
	
	private final LinkedList<HumbleScope> stack;
	
	public StackedScopes() {
		this(new LinkedList<>());
	}

	public StackedScopes(List<Map<String, Object>> stack) {
		this.stack = new LinkedList<>();
		
		for (Map<String, Object> rawScope : stack) {
			Scope enclosingScope = getCurrentOrEmptyScope();
			this.stack.addLast(new EnclosedScope(enclosingScope, rawScope));
		}
	}
	
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	@Override
	public Scope getCurrent() {
		return stack.getLast();
	}
	
	@Override
	public Optional<Scope> getDeclaringScope(String variable) {
		// Iterate stack in reverse order (FILO) because we want the *last* scope
		// that declares the variable to prevent overriding a namesake
		Iterator<HumbleScope> scopesFromLastToFirst = stack.descendingIterator();
		while (scopesFromLastToFirst.hasNext()) {
			HumbleScope scope = scopesFromLastToFirst.next();
			if (scope.containsOnItsOwn(variable)) {
				return Optional.of(scope);
			}
		}
		return Optional.empty();
	}
	
	@Override
	public Iterator<Scope> iterator() {
		// FIXME Makes iterator.remove() unusable
		LinkedList<Scope> stackCopy = new LinkedList<>(stack);
		return stackCopy.iterator();
	}

	@Override
	public Scope pushNew() {
		this.stack.addLast(new EnclosedScope(getCurrentOrEmptyScope()));
		return getCurrent();
	}
	
	@Override
	public Optional<Scope> pop() {
		if (isEmpty()) {
			return Optional.empty();
		}
		else {
			return Optional.of(stack.removeLast());
		}
	}
	
	@Override
	public void clear() {
		this.stack.clear();
	}
	
	private Scope getCurrentOrEmptyScope() {
		try {
			return getCurrent();
		}
		catch (NoSuchElementException e) {
			return new EmptyScope();
		}
	}

	@Override
	public String toString() {
		return stack.toString();
	}

}
