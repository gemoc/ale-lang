/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.acceleo.query.validation.type.IType;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Mismatch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch#getExpectedTypes <em>Expected Types</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch#getActualTypes <em>Actual Types</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch#getTargetTypes <em>Target Types</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getTypeMismatch()
 * @model
 * @generated
 */
public interface TypeMismatch extends Message {
	/**
	 * Returns the value of the '<em><b>Expected Types</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.acceleo.query.validation.type.IType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expected Types</em>' attribute list.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getTypeMismatch_ExpectedTypes()
	 * @model dataType="org.eclipse.emf.ecoretools.ale.core.diagnostics.IType"
	 * @generated
	 */
	EList<IType> getExpectedTypes();

	/**
	 * Returns the value of the '<em><b>Actual Types</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.acceleo.query.validation.type.IType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Types</em>' attribute list.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getTypeMismatch_ActualTypes()
	 * @model dataType="org.eclipse.emf.ecoretools.ale.core.diagnostics.IType"
	 * @generated
	 */
	EList<IType> getActualTypes();

	/**
	 * Returns the value of the '<em><b>Target Types</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.acceleo.query.validation.type.IType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Types</em>' attribute list.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getTypeMismatch_TargetTypes()
	 * @model dataType="org.eclipse.emf.ecoretools.ale.core.diagnostics.IType"
	 * @generated
	 */
	EList<IType> getTargetTypes();

} // TypeMismatch
