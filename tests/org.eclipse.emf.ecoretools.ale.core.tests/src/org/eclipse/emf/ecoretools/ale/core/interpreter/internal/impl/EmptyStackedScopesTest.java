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

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;

import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.Scopes.Scope;
import org.junit.Before;
import org.junit.Test;

/**
 * Test the behavior of a {@link StackedScopes} that is empty.
 */
public class EmptyStackedScopesTest {
	
	StackedScopes scopes;
	
	@Before
	public void createEmptyStackedScopes() {
		scopes = new StackedScopes();
	}
	
	@Test
	public void isEmpty() {
		assertTrue("should be empty", scopes.isEmpty());
	}
	
	@Test(expected = NoSuchElementException.class)
	public void whenAskedForCurrentThrowsNoSuchElementException() {
		scopes.getCurrent();
	}
	
	@Test
	public void hasNoScope() {
		assertFalse("contains scopes: " + scopes, scopes.iterator().hasNext());
	}
	
	@Test
	public void whenPushingScopeReturnsTheNewScope() {
		Scope newScope = scopes.pushNew();
		assertThat("should contain the new scope", scopes, hasItem(newScope));
	}
	
	@Test
	public void whenLastScopeIsPoppedReturnsNothing() {
		assertFalse("should pop nothing", scopes.pop().isPresent());
	}
	
	@Test
	public void canBeCleared() {
		// does not throw
		scopes.clear();
	}

}
