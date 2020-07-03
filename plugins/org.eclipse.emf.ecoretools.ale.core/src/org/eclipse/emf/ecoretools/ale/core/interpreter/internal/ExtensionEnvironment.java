/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.interpreter.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IQueryEnvironmentListener;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.ServiceRegistrationResult;
import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.acceleo.query.runtime.impl.EPackageProvider;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.acceleo.query.runtime.lookup.basic.BasicLookupEngine;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;

//FIXME: copy/past from org.eclipse.acceleo.query.runtime.impl.QueryEnvironment because no other way to change the lookupEngine implem :(
public class ExtensionEnvironment implements IQueryEnvironment {
	/**
	 * The lookupEngine to be used for this evaluator.
	 */
	private BasicLookupEngine lookupEngine;

	/**
	 * The package provider that contains the referred packages.
	 */
	private EPackageProvider ePackageProvider;

	/**
	 * The {@link List} of {@link IQueryEnvironmentListener}.
	 */
	private List<IQueryEnvironmentListener> listeners = new ArrayList<IQueryEnvironmentListener>();

	/**
	 * Creates a new {@link QueryEvaluationEngine} instance.
	 * 
	 * @since 4.0.0
	 */
	public ExtensionEnvironment() {
		ePackageProvider = new EPackageProvider();
		lookupEngine = new ExtensionLookupEngine(this);
	}

	@Override
	public ServiceRegistrationResult registerService(IService service) {
		final ServiceRegistrationResult result = lookupEngine.registerService(service);

		if (!result.getRegistered().isEmpty()) {
			for (IQueryEnvironmentListener listener : getListeners()) {
				listener.serviceRegistered(result, service);
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.acceleo.query.runtime.IQueryEnvironment#removeService(org.eclipse.acceleo.query.runtime.IService)
	 */
	@Override
	public void removeService(IService service) {
		final IService removedService = lookupEngine.removeService(service);
		if (removedService != null) {
			for (IQueryEnvironmentListener listener : getListeners()) {
				listener.serviceRemoved(removedService);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.acceleo.query.runtime.IQueryEnvironment#registerEPackage(org.eclipse.emf.ecore.EPackage)
	 */
	@Override
	public void registerEPackage(EPackage ePackage) {
		final EPackage registeredEPackage = ePackageProvider.registerPackage(ePackage);
		if (registeredEPackage != null) {
			for (IQueryEnvironmentListener listener : getListeners()) {
				listener.ePackageRegistered(ePackage);
			}
			/*
			 * Set 'VoidEClassifier' as EType of EOperation that don't have one.
			 * 
			 * The rational is that AQL doesn't handle EOperation without an explicit 
			 * return type and throws unexpected NullPointerException when calling them.
			 * 
			 * See https://github.com/gemoc/ale-lang/issues/165
			 */
			TreeIterator<EObject> eAllContents = registeredEPackage.eAllContents();
			while (eAllContents.hasNext()) {
				EObject content = eAllContents.next();
				if (content instanceof EOperation && ((EOperation) content).getEType() == null) {
					EOperation operation = (EOperation) content;
					operation.setEType(ImplementationPackage.eINSTANCE.getVoidEClassifier());
				}
			}
			final Set<IService> services = ServiceUtils.getServices(ePackage);
			ServiceUtils.registerServices(this, services);
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.acceleo.query.runtime.IQueryEnvironment#removeEPackage(org.eclipse.emf.ecore.EPackage)
	 */
	@Override
	public void removeEPackage(EPackage ePackage) {
		final Collection<EPackage> ePackages = ePackageProvider.removePackage(ePackage);
		for (EPackage ePkg : ePackages) {
			for (IQueryEnvironmentListener listener : getListeners()) {
				listener.ePackageRemoved(ePkg);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.acceleo.query.runtime.IQueryEnvironment#removeEPackage(java.lang.String)
	 * @deprecated
	 */
	@Override
	public void removeEPackage(String name) {
		final Collection<EPackage> ePackages = ePackageProvider.removePackage(name);
		for (EPackage ePackage : ePackages) {
			for (IQueryEnvironmentListener listener : getListeners()) {
				listener.ePackageRemoved(ePackage);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.acceleo.query.runtime.IQueryEnvironment#registerCustomClassMapping(org.eclipse.emf.ecore.EClassifier,
	 *      java.lang.Class)
	 */
	@Override
	public void registerCustomClassMapping(EClassifier eClassifier, Class<?> cls) {
		ePackageProvider.registerCustomClassMapping(eClassifier, cls);
		for (IQueryEnvironmentListener listener : getListeners()) {
			listener.customClassMappingRegistered(eClassifier, cls);
		}
	}

	@Override
	public BasicLookupEngine getLookupEngine() {
		return lookupEngine;
	}

	@Override
	public EPackageProvider getEPackageProvider() {
		return ePackageProvider;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.acceleo.query.runtime.IQueryEnvironment#addQueryEnvironmentListener(org.eclipse.acceleo.query.runtime.IQueryEnvironmentListener)
	 */
	@Override
	public void addQueryEnvironmentListener(IQueryEnvironmentListener listener) {
		if (listener != null) {
			synchronized(listeners) {
				listeners.add(listener);
			}
		} else {
			throw new IllegalArgumentException("IQueryEnvironmentListener can't be null");
		}
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.acceleo.query.runtime.IQueryEnvironment#removeQueryEnvironmentListener(org.eclipse.acceleo.query.runtime.IQueryEnvironmentListener)
	 */
	@Override
	public void removeQueryEnvironmentListener(IQueryEnvironmentListener listener) {
		if (listener != null) {
			synchronized(listeners) {
				listeners.remove(listener);
			}
		}
	}

	/**
	 * Gets {@link IQueryEnvironment#addQueryEnvironmentListener(IQueryEnvironmentListener) added}
	 * {@link IQueryEnvironmentListener}.
	 * 
	 * @return {@link IQueryEnvironment#addQueryEnvironmentListener(IQueryEnvironmentListener) added}
	 *         {@link IQueryEnvironmentListener}
	 */
	protected List<IQueryEnvironmentListener> getListeners() {
		final List<IQueryEnvironmentListener> result;

		synchronized(listeners) {
			result = new ArrayList<IQueryEnvironmentListener>(listeners);
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.acceleo.query.runtime.IQueryEnvironment#isRegisteredService(org.eclipse.acceleo.query.runtime.IService)
	 */
	@Override
	public boolean isRegisteredService(IService service) {
		return lookupEngine.isRegisteredService(service);
	}

}
