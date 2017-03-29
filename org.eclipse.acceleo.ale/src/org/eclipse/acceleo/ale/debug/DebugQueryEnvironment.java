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
package org.eclipse.acceleo.ale.debug;

import org.eclipse.acceleo.query.runtime.IEPackageProvider;
import org.eclipse.acceleo.query.runtime.ILookupEngine;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IQueryEnvironmentListener;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.ServiceRegistrationResult;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

/**
 * This class allows to add listeners on the lookup engine
 */
public class DebugQueryEnvironment implements IQueryEnvironment{

	IQueryEnvironment wrapped;
	
	DebugLookupEngine lookup;
	
	public DebugQueryEnvironment(IQueryEnvironment wrapped) {
		this.wrapped = wrapped;
	}
	
	@Override
	public IEPackageProvider getEPackageProvider() {
		return wrapped.getEPackageProvider();
	}

	@Override
	public ILookupEngine getLookupEngine() {
		return getDebugLookupEngine();
	}

	@Override
	public void addQueryEnvironmentListener(IQueryEnvironmentListener arg0) {
		wrapped.addQueryEnvironmentListener(arg0);
	}

	@Override
	public boolean isRegisteredService(IService arg0) {
		return wrapped.isRegisteredService(arg0);
	}

	@Override
	public void registerCustomClassMapping(EClassifier arg0, Class<?> arg1) {
		wrapped.registerCustomClassMapping(arg0, arg1);
	}

	@Override
	public void registerEPackage(EPackage arg0) {
		wrapped.registerEPackage(arg0);
	}

	@Override
	public ServiceRegistrationResult registerService(IService arg0) {
		return wrapped.registerService(arg0);
	}

	@Override
	public void removeEPackage(EPackage arg0) {
		wrapped.removeEPackage(arg0);
	}

	@Override
	public void removeEPackage(String arg0) {
		wrapped.removeEPackage(arg0);
	}

	@Override
	public void removeQueryEnvironmentListener(IQueryEnvironmentListener arg0) {
		wrapped.removeQueryEnvironmentListener(arg0);
	}

	@Override
	public void removeService(IService arg0) {
		wrapped.removeService(arg0);
	}
	
	public DebugLookupEngine getDebugLookupEngine() {
		if(lookup == null) {
			lookup = new DebugLookupEngine(wrapped.getLookupEngine());
		}
		return lookup;
	}
	
	public void registerListener(ILookupEngineListener listener) {
		getDebugLookupEngine().registerListener(listener);
	}
	
	public void removeListener(ILookupEngineListener listener) {
		getDebugLookupEngine().removeListener(listener);
	}
}
