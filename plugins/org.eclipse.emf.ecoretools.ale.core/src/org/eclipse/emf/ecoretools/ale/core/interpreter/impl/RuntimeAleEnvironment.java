/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.interpreter.impl;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleEnvironment;

/**
 * An {@link IAleEnvironment ALE environment} dynamically defined at runtime. 
 */
public class RuntimeAleEnvironment implements IAleEnvironment {
	
	private final LinkedHashSet<String> metamodels;
	
	private final LinkedHashSet<String> behaviors;

	/**
	 * Creates a new {@link IAleEnvironment ALE environment} based on given paths.
	 * 
	 * @param metamodels
	 * 			A comma-separated list of paths to available Ecore models.
	 * @param behaviors
	 * 			A comma-separated list of paths to available ALE source files.
	 */
	public RuntimeAleEnvironment(Collection<String> metamodels, Collection<String> behaviors) {
		this.metamodels = new LinkedHashSet<>(metamodels);
		this.behaviors = new LinkedHashSet<>(behaviors);
	}
	
	@Override
	public LinkedHashSet<String> getBehaviors() {
		return behaviors;
	}
	
	@Override
	public LinkedHashSet<String> getMetamodels() {
		return metamodels;
	}
	
}