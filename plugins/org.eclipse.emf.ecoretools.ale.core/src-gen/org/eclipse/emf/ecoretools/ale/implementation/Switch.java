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

import org.eclipse.acceleo.query.ast.Expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.Switch#getParam <em>Param</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.Switch#getCases <em>Cases</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.Switch#getDefault <em>Default</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getSwitch()
 * @model
 * @generated
 */
public interface Switch extends Expression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2017 Inria and Obeo.\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n     Inria - initial API and implementation\n";

	/**
	 * Returns the value of the '<em><b>Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Param</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Param</em>' containment reference.
	 * @see #setParam(Expression)
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getSwitch_Param()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getParam();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.implementation.Switch#getParam <em>Param</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Param</em>' containment reference.
	 * @see #getParam()
	 * @generated
	 */
	void setParam(Expression value);

	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecoretools.ale.implementation.Case}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getSwitch_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<Case> getCases();

	/**
	 * Returns the value of the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default</em>' containment reference.
	 * @see #setDefault(Expression)
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getSwitch_Default()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getDefault();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.implementation.Switch#getDefault <em>Default</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Default</em>' containment reference.
	 * @see #getDefault()
	 * @generated
	 */
	void setDefault(Expression value);

} // Switch
