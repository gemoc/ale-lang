/**
 */
package org.eclipse.acceleo.ale.implementation;

import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.acceleo.ale.implementation.Method#getOperationDef <em>Operation Def</em>}</li>
 * </ul>
 *
 * @see org.eclipse.acceleo.ale.implementation.ImplementationPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends Behaviored {
	/**
	 * Returns the value of the '<em><b>Operation Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Def</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Def</em>' containment reference.
	 * @see #setOperationDef(EOperation)
	 * @see org.eclipse.acceleo.ale.implementation.ImplementationPackage#getMethod_OperationDef()
	 * @model containment="true"
	 * @generated
	 */
	EOperation getOperationDef();

	/**
	 * Sets the value of the '{@link org.eclipse.acceleo.ale.implementation.Method#getOperationDef <em>Operation Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Def</em>' containment reference.
	 * @see #getOperationDef()
	 * @generated
	 */
	void setOperationDef(EOperation value);

} // Method
