package org.eclipse.emf.ecoretools.ale.core.interpreter.internal.impl;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;

import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.Scopes.Scope;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the behavior of a {@link StackedScopes} that is not empty.
 */
public class FilledStackedScopesTest {
	
	static int NUMBER_OF_SCOPES = 3;
	
	StackedScopes scopes;
	LinkedList<Scope> rawScopes;
	
	@Before
	public void createStackedScopesWithAFewScopes() {
		assert NUMBER_OF_SCOPES > 0;
		
		scopes = new StackedScopes();
		rawScopes = new LinkedList<>();
		
		for (int i = 0 ; i < NUMBER_OF_SCOPES ; ++i) {
			rawScopes.add(scopes.pushNew());
		}
	}
	
	@Test
	public void isNotEmpty() {
		assertFalse("should not be empty", scopes.isEmpty());
	}
	
	@Test
	public void whenAskedForCurrentReturnsLastPushedScope() {
		assertEquals("", rawScopes.get(NUMBER_OF_SCOPES - 1), scopes.getCurrent());
	}
	
	@Test
	public void providesIteratorWithFirstPushedScopeFirst() {
		Iterator<Scope> scopesIterator = scopes.iterator();
		Iterator<Scope> rawScopesIterator = rawScopes.iterator();
		
		while (rawScopesIterator.hasNext()) {
			Scope expectedScope = rawScopesIterator.next();
			assertTrue("iterator ends whereas it should provide " + expectedScope, scopesIterator.hasNext());
			assertEquals("iterator provided wrong scope", expectedScope, scopesIterator.next());
		}
	}
	
	@Test
	public void whenPopShouldReturnScopesInReverseOrder() {
		Iterator<Scope> rawScopesIterator = rawScopes.descendingIterator();
		
		while (rawScopesIterator.hasNext()) {
			Scope expectedScope = rawScopesIterator.next();
			Optional<Scope> poppedScope = scopes.pop();
			
			assertTrue("iterator ends whereas it should provide " + expectedScope, poppedScope.isPresent());
			assertEquals("iterator provided wrong scope", expectedScope, poppedScope.get());
		}
	}
	
	@Test
	public void whenClearedBecomesEmpty() {
		scopes.clear();
		assertTrue("should be empty", scopes.isEmpty());
	}
	
	@Test
	public void whenClearedHasNoScopeAnymore() {
		scopes.clear();
		assertFalse("should be empty", scopes.iterator().hasNext());
	}

}
