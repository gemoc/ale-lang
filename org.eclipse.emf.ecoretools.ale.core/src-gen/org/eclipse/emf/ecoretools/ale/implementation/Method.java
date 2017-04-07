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

import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.Method#getOperationDef <em>Operation Def</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends Behaviored {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2017 Inria and Obeo.\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n     Inria - initial API and implementation\n";

	/**
	 * Returns the value of the '<em><b>Operation Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Def</em>' containment reference.
	 * @see #setOperationDef(EOperation)
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getMethod_OperationDef()
	 * @model containment="true"
	 * @generated
	 */
	EOperation getOperationDef();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.implementation.Method#getOperationDef <em>Operation Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Def</em>' containment reference.
	 * @see #getOperationDef()
	 * @generated
	 */
	void setOperationDef(EOperation value);

} // Method
