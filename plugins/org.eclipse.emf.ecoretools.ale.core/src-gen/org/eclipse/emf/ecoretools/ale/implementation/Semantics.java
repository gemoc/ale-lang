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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Semantics</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.Semantics#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.Semantics#getImplem <em>Implem</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.Semantics#getConcept <em>Concept</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.Semantics#getOperationRef <em>Operation Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getSemantics()
 * @model
 * @generated
 */
public interface Semantics extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2017 Inria and Obeo.\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n     Inria - initial API and implementation\n";

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getSemantics_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.implementation.Semantics#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Implem</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implem</em>' containment reference.
	 * @see #setImplem(Method)
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getSemantics_Implem()
	 * @model containment="true"
	 * @generated
	 */
	Method getImplem();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.implementation.Semantics#getImplem <em>Implem</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Implem</em>' containment reference.
	 * @see #getImplem()
	 * @generated
	 */
	void setImplem(Method value);

	/**
	 * Returns the value of the '<em><b>Concept</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.ecoretools.ale.implementation.Concept#getSemantics <em>Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Concept</em>' container reference.
	 * @see #setConcept(Concept)
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getSemantics_Concept()
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Concept#getSemantics
	 * @model opposite="semantics" transient="false"
	 * @generated
	 */
	Concept getConcept();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.implementation.Semantics#getConcept <em>Concept</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Concept</em>' container reference.
	 * @see #getConcept()
	 * @generated
	 */
	void setConcept(Concept value);

	/**
	 * Returns the value of the '<em><b>Operation Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Ref</em>' containment reference.
	 * @see #setOperationRef(EOperation)
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getSemantics_OperationRef()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EOperation getOperationRef();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.implementation.Semantics#getOperationRef <em>Operation Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Ref</em>' containment reference.
	 * @see #getOperationRef()
	 * @generated
	 */
	void setOperationRef(EOperation value);

} // Semantics
