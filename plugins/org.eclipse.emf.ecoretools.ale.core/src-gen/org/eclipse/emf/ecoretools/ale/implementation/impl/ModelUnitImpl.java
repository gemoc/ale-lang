/**
 *  Copyright (c) 2017 Inria and Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Inria - initial API and implementation
 * 
 */
package org.eclipse.emf.ecoretools.ale.implementation.impl;

import java.util.Collection;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENamedElementImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Unit</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ModelUnitImpl#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ModelUnitImpl#getClassExtensions <em>Class Extensions</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ModelUnitImpl#getClassDefinitions <em>Class Definitions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelUnitImpl extends ENamedElementImpl implements ModelUnit {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " Copyright (c) 2017 Inria and Obeo.\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n     Inria - initial API and implementation\n";

	/**
	 * The cached value of the '{@link #getServices() <em>Services</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServices()
	 * @generated
	 * @ordered
	 */
	protected EList<String> services;

	/**
	 * The cached value of the '{@link #getClassExtensions() <em>Class Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtendedClass> classExtensions;

	/**
	 * The cached value of the '{@link #getClassDefinitions() <em>Class Definitions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassDefinitions()
	 * @generated
	 * @ordered
	 */
	protected EList<RuntimeClass> classDefinitions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.MODEL_UNIT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getServices() {
		if (services == null) {
			services = new EDataTypeUniqueEList<String>(String.class, this, ImplementationPackage.MODEL_UNIT__SERVICES);
		}
		return services;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ExtendedClass> getClassExtensions() {
		if (classExtensions == null) {
			classExtensions = new EObjectContainmentEList<ExtendedClass>(ExtendedClass.class, this, ImplementationPackage.MODEL_UNIT__CLASS_EXTENSIONS);
		}
		return classExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RuntimeClass> getClassDefinitions() {
		if (classDefinitions == null) {
			classDefinitions = new EObjectContainmentEList<RuntimeClass>(RuntimeClass.class, this, ImplementationPackage.MODEL_UNIT__CLASS_DEFINITIONS);
		}
		return classDefinitions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImplementationPackage.MODEL_UNIT__CLASS_EXTENSIONS:
				return ((InternalEList<?>)getClassExtensions()).basicRemove(otherEnd, msgs);
			case ImplementationPackage.MODEL_UNIT__CLASS_DEFINITIONS:
				return ((InternalEList<?>)getClassDefinitions()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImplementationPackage.MODEL_UNIT__SERVICES:
				return getServices();
			case ImplementationPackage.MODEL_UNIT__CLASS_EXTENSIONS:
				return getClassExtensions();
			case ImplementationPackage.MODEL_UNIT__CLASS_DEFINITIONS:
				return getClassDefinitions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImplementationPackage.MODEL_UNIT__SERVICES:
				getServices().clear();
				getServices().addAll((Collection<? extends String>)newValue);
				return;
			case ImplementationPackage.MODEL_UNIT__CLASS_EXTENSIONS:
				getClassExtensions().clear();
				getClassExtensions().addAll((Collection<? extends ExtendedClass>)newValue);
				return;
			case ImplementationPackage.MODEL_UNIT__CLASS_DEFINITIONS:
				getClassDefinitions().clear();
				getClassDefinitions().addAll((Collection<? extends RuntimeClass>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImplementationPackage.MODEL_UNIT__SERVICES:
				getServices().clear();
				return;
			case ImplementationPackage.MODEL_UNIT__CLASS_EXTENSIONS:
				getClassExtensions().clear();
				return;
			case ImplementationPackage.MODEL_UNIT__CLASS_DEFINITIONS:
				getClassDefinitions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImplementationPackage.MODEL_UNIT__SERVICES:
				return services != null && !services.isEmpty();
			case ImplementationPackage.MODEL_UNIT__CLASS_EXTENSIONS:
				return classExtensions != null && !classExtensions.isEmpty();
			case ImplementationPackage.MODEL_UNIT__CLASS_DEFINITIONS:
				return classDefinitions != null && !classDefinitions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (services: ");
		result.append(services);
		result.append(')');
		return result.toString();
	}

} //ModelUnitImpl
