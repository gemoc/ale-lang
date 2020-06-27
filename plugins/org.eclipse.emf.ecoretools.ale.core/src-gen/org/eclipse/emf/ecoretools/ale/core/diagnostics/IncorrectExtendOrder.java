/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Incorrect Extend Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder#getSuperSuperType <em>Super Super Type</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getIncorrectExtendOrder()
 * @model
 * @generated
 */
public interface IncorrectExtendOrder extends Message {
	/**
	 * Returns the value of the '<em><b>Super Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Type</em>' reference.
	 * @see #setSuperType(EClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getIncorrectExtendOrder_SuperType()
	 * @model
	 * @generated
	 */
	EClass getSuperType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder#getSuperType <em>Super Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Type</em>' reference.
	 * @see #getSuperType()
	 * @generated
	 */
	void setSuperType(EClass value);

	/**
	 * Returns the value of the '<em><b>Super Super Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Super Type</em>' reference.
	 * @see #setSuperSuperType(EClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getIncorrectExtendOrder_SuperSuperType()
	 * @model
	 * @generated
	 */
	EClass getSuperSuperType();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder#getSuperSuperType <em>Super Super Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Super Type</em>' reference.
	 * @see #getSuperSuperType()
	 * @generated
	 */
	void setSuperSuperType(EClass value);

} // IncorrectExtendOrder
