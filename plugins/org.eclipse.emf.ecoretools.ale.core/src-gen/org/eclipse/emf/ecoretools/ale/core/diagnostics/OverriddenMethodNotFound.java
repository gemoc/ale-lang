/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Overridden Method Not Found</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound#getOverridingMethod <em>Overriding Method</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound#getOverridingMethodOwner <em>Overriding Method Owner</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getOverriddenMethodNotFound()
 * @model
 * @generated
 */
public interface OverriddenMethodNotFound extends Message {
	/**
	 * Returns the value of the '<em><b>Overriding Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overriding Method</em>' reference.
	 * @see #setOverridingMethod(Method)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getOverriddenMethodNotFound_OverridingMethod()
	 * @model
	 * @generated
	 */
	Method getOverridingMethod();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound#getOverridingMethod <em>Overriding Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overriding Method</em>' reference.
	 * @see #getOverridingMethod()
	 * @generated
	 */
	void setOverridingMethod(Method value);

	/**
	 * Returns the value of the '<em><b>Overriding Method Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Overriding Method Owner</em>' reference.
	 * @see #setOverridingMethodOwner(BehavioredClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getOverriddenMethodNotFound_OverridingMethodOwner()
	 * @model
	 * @generated
	 */
	BehavioredClass getOverridingMethodOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound#getOverridingMethodOwner <em>Overriding Method Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Overriding Method Owner</em>' reference.
	 * @see #getOverridingMethodOwner()
	 * @generated
	 */
	void setOverridingMethodOwner(BehavioredClass value);

} // OverriddenMethodNotFound
