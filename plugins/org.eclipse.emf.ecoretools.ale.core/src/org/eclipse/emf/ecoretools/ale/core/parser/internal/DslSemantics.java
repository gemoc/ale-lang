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
package org.eclipse.emf.ecoretools.ale.core.parser.internal;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

/**
 * The semantics of a {@link Dsl}.
 * <p>
 * <b>Important</b>: this interface will eventually become API, but is currently
 * likely to undergo breaking changes: uses it at your own risk!
 */
public interface DslSemantics {
	
	/**
	 * Determines all the behaviors defined within this semantics.
	 * @return all the behaviors of this semantics
	 */
	List<ModelUnit> getBehaviors();
	
	/**
	 * Determines all the Java services available in this semantics.
	 * @return all the Java services of this semantics
	 */
	Set<String> getServices();
	
	/**
	 * Determines all the methods annotated with ALE's <code>&#64;main</code>.
	 * @return all available <code>main</code> methods
	 */
	List<Method> getMainMethods();

	/**
	 * Returns all the parsed files that compose this semantics.
	 * @return all the parsed files that compose this semantics
	 */
	List<ParseResult<ModelUnit>> getParsedFiles();
	
	/**
	 * Finds the file where a given AST element is defined.
	 * 
	 * @param astElement
	 * 			The element of the AST
	 * 
	 * @return the parsed file where the element is declared, if any
	 */
	Optional<ParseResult<ModelUnit>> findParsedFileDefining(Object astElement);

	/**
	 * Finds a specific method.
	 * 
	 * @param correspondingOperation
	 * 			The EOperation corresponding to the desired method
	 * 
	 * @return the method corresponding to the given EOperation, if any
	 */
	Optional<Method> findMethod(EOperation correspondingOperation);

}
