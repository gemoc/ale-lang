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
package org.eclipse.emf.ecoretools.ale.core.interpreter;

import java.util.LinkedHashSet;

/**
 * The environment used by ALE's tooling.
 * <p>
 * An environment defines the Ecore models and the ALE source files that are currently available.
 * Editors, interpreters and compilers should rely on one to configure their runtime. 
 */
/*
 * TODO [Refactor] The getBehaviors() and getMetamodels() methods should return more specific objects,
 * 				   e.g. create "Behaviors" or "Metamodels" class, or at least return an URI or an IPath.
 * 				   Currently there are a lot of checks/conversion used across the source base to make
 * 				   sure these strings can be used and that's both confusing and error-prone.
 */
public interface IAleEnvironment {
	
	/**
	 * Returns a path made of all the resources defining some behavior.
	 * <p>
	 * Each resource is separated by a comma.
	 * <p>
	 * Depending on the implementation this method may or may not return
	 * the underlying collection used by this object.
	 * 
	 * @return a comma-separated list of all ALE source files
	 */
	LinkedHashSet<String> getBehaviors();
	
	/**
	 * Returns a path made of all the resources defining an Ecore model.
	 * <p>
	 * Each resource is separated by a comma.
	 * <p>
	 * Depending on the implementation this method may or may not return
	 * the underlying collection used by this object.
	 * 
	 * @return a comma-separated list of all the Ecore model
	 */
	LinkedHashSet<String> getMetamodels();

}
