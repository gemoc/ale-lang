/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dynamic Class Already Defined</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined#getPreviousDeclaration <em>Previous Declaration</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined#getCurrentDeclaration <em>Current Declaration</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getDynamicClassAlreadyDefined()
 * @model
 * @generated
 */
public interface DynamicClassAlreadyDefined extends Message {
	/**
	 * Returns the value of the '<em><b>Previous Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous Declaration</em>' reference.
	 * @see #setPreviousDeclaration(RuntimeClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getDynamicClassAlreadyDefined_PreviousDeclaration()
	 * @model
	 * @generated
	 */
	RuntimeClass getPreviousDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined#getPreviousDeclaration <em>Previous Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous Declaration</em>' reference.
	 * @see #getPreviousDeclaration()
	 * @generated
	 */
	void setPreviousDeclaration(RuntimeClass value);

	/**
	 * Returns the value of the '<em><b>Current Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Declaration</em>' reference.
	 * @see #setCurrentDeclaration(RuntimeClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getDynamicClassAlreadyDefined_CurrentDeclaration()
	 * @model
	 * @generated
	 */
	RuntimeClass getCurrentDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined#getCurrentDeclaration <em>Current Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Declaration</em>' reference.
	 * @see #getCurrentDeclaration()
	 * @generated
	 */
	void setCurrentDeclaration(RuntimeClass value);

} // DynamicClassAlreadyDefined
