/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Illegal Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAssignment#getAssignedValue <em>Assigned Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getIllegalAssignment()
 * @model
 * @generated
 */
public interface IllegalAssignment extends TypeMismatch {
	/**
	 * Returns the value of the '<em><b>Assigned Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned Value</em>' attribute.
	 * @see #setAssignedValue(Object)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getIllegalAssignment_AssignedValue()
	 * @model
	 * @generated
	 */
	Object getAssignedValue();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAssignment#getAssignedValue <em>Assigned Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assigned Value</em>' attribute.
	 * @see #getAssignedValue()
	 * @generated
	 */
	void setAssignedValue(Object value);

} // IllegalAssignment
