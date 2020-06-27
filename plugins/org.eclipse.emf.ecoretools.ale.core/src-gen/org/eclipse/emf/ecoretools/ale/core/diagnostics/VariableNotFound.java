/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Not Found</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound#getName <em>Name</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getVariableNotFound()
 * @model
 * @generated
 */
public interface VariableNotFound extends Message {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getVariableNotFound_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // VariableNotFound
