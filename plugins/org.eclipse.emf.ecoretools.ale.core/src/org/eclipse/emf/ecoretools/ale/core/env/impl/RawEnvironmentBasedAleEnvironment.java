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
package org.eclipse.emf.ecoretools.ale.core.env.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.IBehaviors;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

/**
 * An ALE environment which is based on a raw environment 
 * made up of Ecore metamodels and ALE behaviors.
 * <p>
 * This class is not supposed to be instantiated by clients, call 
 * {@link IAleEnvironment#fromRaw(IQueryEnvironment, Collection, Collection)}
 * instead.
 */
public class RawEnvironmentBasedAleEnvironment extends AbstractAleEnvironment {
	
	private final List<EPackage> metamodels;

	/**
	 * Creates a new ALE environment.
	 * 
	 * @param context
	 * 			The AQL context used by the interpreter. {@link #close()} frees the resources it holds.
	 * @param metamodels
	 * 			The metamodels available in this environment.
	 * @param behaviors
	 * 			The behaviors available in this environment.
	 */
	public RawEnvironmentBasedAleEnvironment(IQueryEnvironment context, Collection<EPackage> metamodels, Collection<ParsedFile<ModelUnit>> behaviors) {
		this.context = context;
		this.behaviors = new ImmutableBehaviors(behaviors);
		this.metamodels = new ArrayList<>(metamodels);
	}

	@Override
	public List<EPackage> getMetamodels() {
		return new ArrayList<>(metamodels);
	}

	@Override
	public IBehaviors getBehaviors() {
		return behaviors;
	}
	
	@Override
	public IQueryEnvironment getContext() {
		return context;
	}

	@Override
	public LinkedHashSet<String> getBehaviorsSources() {
		return new LinkedHashSet<>(0);
	}

	@Override
	public LinkedHashSet<String> getMetamodelsSources() {
		return new LinkedHashSet<>(0);
	}

}
