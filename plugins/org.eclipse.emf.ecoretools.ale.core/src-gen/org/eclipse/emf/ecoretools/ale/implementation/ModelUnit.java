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
package org.eclipse.emf.ecoretools.ale.implementation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Unit</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.ModelUnit#getServices <em>Services</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.ModelUnit#getClassExtensions <em>Class Extensions</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.ModelUnit#getClassDefinitions <em>Class Definitions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getModelUnit()
 * @model
 * @generated
 */
public interface ModelUnit extends ENamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2017 Inria and Obeo.\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n     Inria - initial API and implementation\n";

	/**
	 * Returns the value of the '<em><b>Services</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' attribute list.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getModelUnit_Services()
	 * @model
	 * @generated
	 */
	EList<String> getServices();

	/**
	 * Returns the value of the '<em><b>Class Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Extensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Extensions</em>' containment reference list.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getModelUnit_ClassExtensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExtendedClass> getClassExtensions();

	/**
	 * Returns the value of the '<em><b>Class Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Definitions</em>' containment reference list.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getModelUnit_ClassDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<RuntimeClass> getClassDefinitions();

} // ModelUnit
