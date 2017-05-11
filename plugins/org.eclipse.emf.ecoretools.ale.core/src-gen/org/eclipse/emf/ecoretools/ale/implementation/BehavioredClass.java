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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behaviored Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass#getMethods <em>Methods</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass#getFragment <em>Fragment</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getBehavioredClass()
 * @model abstract="true"
 * @generated
 */
public interface BehavioredClass extends ENamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2017 Inria and Obeo.\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n     Inria - initial API and implementation\n";

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecoretools.ale.implementation.Method}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getBehavioredClass_Methods()
	 * @model containment="true"
	 * @generated
	 */
	EList<Method> getMethods();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecoretools.ale.implementation.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getBehavioredClass_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Fragment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fragment</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragment</em>' containment reference.
	 * @see #setFragment(EClass)
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getBehavioredClass_Fragment()
	 * @model containment="true"
	 * @generated
	 */
	EClass getFragment();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass#getFragment <em>Fragment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fragment</em>' containment reference.
	 * @see #getFragment()
	 * @generated
	 */
	void setFragment(EClass value);

} // BehavioredClass
