/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.acceleo.query.validation.type.IType;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unsupported Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator#getTargetTypes <em>Target Types</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getUnsupportedOperator()
 * @model
 * @generated
 */
public interface UnsupportedOperator extends Message {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator
	 * @see #setOperator(Operator)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getUnsupportedOperator_Operator()
	 * @model
	 * @generated
	 */
	Operator getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(Operator value);

	/**
	 * Returns the value of the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' attribute.
	 * @see #setTarget(Object)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getUnsupportedOperator_Target()
	 * @model
	 * @generated
	 */
	Object getTarget();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator#getTarget <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' attribute.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Object value);

	/**
	 * Returns the value of the '<em><b>Target Types</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.acceleo.query.validation.type.IType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Types</em>' attribute list.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getUnsupportedOperator_TargetTypes()
	 * @model dataType="org.eclipse.emf.ecoretools.ale.core.diagnostics.IType"
	 * @generated
	 */
	EList<IType> getTargetTypes();

} // UnsupportedOperator
