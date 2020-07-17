/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.acceleo.query.validation.type.IType;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Not Found</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getArgumentTypes <em>Argument Types</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getMethodNotFound()
 * @model
 * @generated
 */
public interface MethodNotFound extends Message {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(BehavioredClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getMethodNotFound_Owner()
	 * @model
	 * @generated
	 */
	BehavioredClass getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(BehavioredClass value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getMethodNotFound_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Object}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' attribute list.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getMethodNotFound_Arguments()
	 * @model
	 * @generated
	 */
	EList<Object> getArguments();

	/**
	 * Returns the value of the '<em><b>Argument Types</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.acceleo.query.validation.type.IType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Argument Types</em>' attribute list.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getMethodNotFound_ArgumentTypes()
	 * @model dataType="org.eclipse.emf.ecoretools.ale.core.diagnostics.IType"
	 * @generated
	 */
	EList<IType> getArgumentTypes();

} // MethodNotFound
