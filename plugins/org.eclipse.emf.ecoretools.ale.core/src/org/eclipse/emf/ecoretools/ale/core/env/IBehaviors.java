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
package org.eclipse.emf.ecoretools.ale.core.env;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;

/**
 * The behaviors defined in an {@link IAleEnvironment}.
 */
public interface IBehaviors {
	
	/**
	 * Determines all the units of behavior that make up the environment.
	 * @return all the units of behavior defined in the environment
	 */
	List<ModelUnit> getUnits();
	
	/**
	 * Determines all the classes, static (Ecore) and dynamic (ALE), available in the environment
	 * @return all the classes available in the environment
	 */
	List<BehavioredClass> getClasses();
	
	/**
	 * Searches for a specific behaviored class.
	 * 
	 * @param qualifiedName
	 * 			The fully qualified name of the class.
	 * 
	 * @return if the corresponding to the given name, if found
	 */
	Optional<BehavioredClass> findClass(String qualifiedName);
	
	/**
	 * Determines all the classes defined in a metamodel that are available in the environment.
	 * @return all the classes defined in a metamodel that are available in the environment
	 */
	List<ExtendedClass> getOpenClasses();
	
	/**
	 * Determines all the classes defined in an ALE source file that are available in the environment.
	 * @return all the classes defined in an ALE source file that are available in the environment
	 */
	List<RuntimeClass> getRuntimeClasses();
	
	/**
	 * Determines all the Java services available in the environment
	 * @return all the Java services available in the environment
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
	List<ParsedFile<ModelUnit>> getParsedFiles();
	
	/**
	 * Finds the file where a given AST element is defined.
	 * 
	 * @param astElement
	 * 			The element of the AST
	 * 
	 * @return the parsed file where the element is declared, if any
	 */
	Optional<ParsedFile<ModelUnit>> findParsedFileDefining(Object astElement);

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
