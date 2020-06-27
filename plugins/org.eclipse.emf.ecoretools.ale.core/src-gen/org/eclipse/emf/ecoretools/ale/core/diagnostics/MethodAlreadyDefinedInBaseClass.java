/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.ecoretools.ale.implementation.Method;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Already Defined In Base Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInBaseClass#getNewDefinition <em>New Definition</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getMethodAlreadyDefinedInBaseClass()
 * @model
 * @generated
 */
public interface MethodAlreadyDefinedInBaseClass extends Message {
	/**
	 * Returns the value of the '<em><b>New Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>New Definition</em>' reference.
	 * @see #setNewDefinition(Method)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getMethodAlreadyDefinedInBaseClass_NewDefinition()
	 * @model
	 * @generated
	 */
	Method getNewDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInBaseClass#getNewDefinition <em>New Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>New Definition</em>' reference.
	 * @see #getNewDefinition()
	 * @generated
	 */
	void setNewDefinition(Method value);

} // MethodAlreadyDefinedInBaseClass
