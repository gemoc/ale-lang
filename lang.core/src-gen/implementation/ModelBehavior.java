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
/**
 */
package implementation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link implementation.ModelBehavior#getClassExtensions <em>Class Extensions</em>}</li>
 *   <li>{@link implementation.ModelBehavior#getClassDefinitions <em>Class Definitions</em>}</li>
 *   <li>{@link implementation.ModelBehavior#getServices <em>Services</em>}</li>
 *   <li>{@link implementation.ModelBehavior#getName <em>Name</em>}</li>
 *   <li>{@link implementation.ModelBehavior#getImports <em>Imports</em>}</li>
 * </ul>
 *
 * @see implementation.ImplementationPackage#getModelBehavior()
 * @model
 * @generated
 */
public interface ModelBehavior extends EObject {
	/**
	 * Returns the value of the '<em><b>Class Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link implementation.ExtendedClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Extensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Extensions</em>' containment reference list.
	 * @see implementation.ImplementationPackage#getModelBehavior_ClassExtensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExtendedClass> getClassExtensions();

	/**
	 * Returns the value of the '<em><b>Class Definitions</b></em>' containment reference list.
	 * The list contents are of type {@link implementation.RuntimeClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Definitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Definitions</em>' containment reference list.
	 * @see implementation.ImplementationPackage#getModelBehavior_ClassDefinitions()
	 * @model containment="true"
	 * @generated
	 */
	EList<RuntimeClass> getClassDefinitions();

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
	 * @see implementation.ImplementationPackage#getModelBehavior_Services()
	 * @model
	 * @generated
	 */
	EList<String> getServices();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see implementation.ImplementationPackage#getModelBehavior_Name()
	 * @model default="" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link implementation.ModelBehavior#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link implementation.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see implementation.ImplementationPackage#getModelBehavior_Imports()
	 * @model containment="true"
	 * @generated
	 */
	EList<Import> getImports();

} // ModelBehavior
