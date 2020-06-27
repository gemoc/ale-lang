/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Opened More Than Once</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce#getCurrentDeclaration <em>Current Declaration</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce#getPreviousDeclaration <em>Previous Declaration</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getClassOpenedMoreThanOnce()
 * @model
 * @generated
 */
public interface ClassOpenedMoreThanOnce extends Message {
	/**
	 * Returns the value of the '<em><b>Current Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Declaration</em>' reference.
	 * @see #setCurrentDeclaration(ExtendedClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getClassOpenedMoreThanOnce_CurrentDeclaration()
	 * @model
	 * @generated
	 */
	ExtendedClass getCurrentDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce#getCurrentDeclaration <em>Current Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Declaration</em>' reference.
	 * @see #getCurrentDeclaration()
	 * @generated
	 */
	void setCurrentDeclaration(ExtendedClass value);

	/**
	 * Returns the value of the '<em><b>Previous Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous Declaration</em>' reference.
	 * @see #setPreviousDeclaration(ExtendedClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getClassOpenedMoreThanOnce_PreviousDeclaration()
	 * @model
	 * @generated
	 */
	ExtendedClass getPreviousDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce#getPreviousDeclaration <em>Previous Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous Declaration</em>' reference.
	 * @see #getPreviousDeclaration()
	 * @generated
	 */
	void setPreviousDeclaration(ExtendedClass value);

} // ClassOpenedMoreThanOnce
