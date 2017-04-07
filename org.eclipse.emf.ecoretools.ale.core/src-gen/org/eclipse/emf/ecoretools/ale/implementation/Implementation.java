/**
 */
package org.eclipse.emf.ecoretools.ale.implementation;

import org.eclipse.emf.ecore.EOperation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Implementation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.Implementation#getOperationRef <em>Operation Ref</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getImplementation()
 * @model
 * @generated
 */
public interface Implementation extends Behaviored {
	/**
	 * Returns the value of the '<em><b>Operation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation Ref</em>' reference.
	 * @see #setOperationRef(EOperation)
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage#getImplementation_OperationRef()
	 * @model required="true"
	 * @generated
	 */
	EOperation getOperationRef();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.implementation.Implementation#getOperationRef <em>Operation Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Ref</em>' reference.
	 * @see #getOperationRef()
	 * @generated
	 */
	void setOperationRef(EOperation value);

} // Implementation
