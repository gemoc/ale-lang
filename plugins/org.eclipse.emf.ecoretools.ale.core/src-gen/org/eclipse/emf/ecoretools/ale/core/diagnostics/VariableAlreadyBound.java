/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Already Bound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound#getDuplicateLocation <em>Duplicate Location</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getVariableAlreadyBound()
 * @model
 * @generated
 */
public interface VariableAlreadyBound extends Message {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getVariableAlreadyBound_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Duplicate Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duplicate Location</em>' reference.
	 * @see #setDuplicateLocation(CodeLocation)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getVariableAlreadyBound_DuplicateLocation()
	 * @model
	 * @generated
	 */
	CodeLocation getDuplicateLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound#getDuplicateLocation <em>Duplicate Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duplicate Location</em>' reference.
	 * @see #getDuplicateLocation()
	 * @generated
	 */
	void setDuplicateLocation(CodeLocation value);

} // VariableAlreadyBound
