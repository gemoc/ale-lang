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
import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getBaseClass <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getExtendedClass()
 * @model
 * @generated
 */
public interface ExtendedClass extends EModelElement, BehavioredClass {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2017 Inria and Obeo.\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n     Inria - initial API and implementation\n";

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBaseClass(EClass)
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getExtendedClass_BaseClass()
	 * @model required="true"
	 * @generated
	 */
	EClass getBaseClass();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getBaseClass <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBaseClass()
	 * @generated
	 */
	void setBaseClass(EClass value);

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference list.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getExtendedClass_Extends()
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	EList<ExtendedClass> getExtends();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getExtendedClass_Children()
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getExtends
	 * @model opposite="extends"
	 * @generated
	 */
	EList<ExtendedClass> getChildren();

} // ExtendedClass
