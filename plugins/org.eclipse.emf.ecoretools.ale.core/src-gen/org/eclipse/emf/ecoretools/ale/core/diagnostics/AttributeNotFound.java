/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Not Found</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getAttributeNotFound()
 * @model
 * @generated
 */
public interface AttributeNotFound extends Message {
	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(EClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getAttributeNotFound_Owner()
	 * @model
	 * @generated
	 */
	EClass getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(EClass value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getAttributeNotFound_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // AttributeNotFound
