/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Not An Openable Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.NotAnOpenableClass#getOpenClass <em>Open Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getNotAnOpenableClass()
 * @model
 * @generated
 */
public interface NotAnOpenableClass extends Message {
	/**
	 * Returns the value of the '<em><b>Open Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open Class</em>' reference.
	 * @see #setOpenClass(ExtendedClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getNotAnOpenableClass_OpenClass()
	 * @model
	 * @generated
	 */
	ExtendedClass getOpenClass();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.NotAnOpenableClass#getOpenClass <em>Open Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Open Class</em>' reference.
	 * @see #getOpenClass()
	 * @generated
	 */
	void setOpenClass(ExtendedClass value);

} // NotAnOpenableClass
