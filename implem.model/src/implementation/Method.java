/**
 */
package implementation;

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
 *   <li>{@link implementation.Method#getOperationDef <em>Operation Def</em>}</li>
 *   <li>{@link implementation.Method#getContainingClass <em>Containing Class</em>}</li>
 * </ul>
 *
 * @see implementation.ImplementationPackage#getMethod()
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
	 * @see implementation.ImplementationPackage#getMethod_OperationDef()
	 * @model containment="true"
	 * @generated
	 */
	EOperation getOperationDef();

	/**
	 * Sets the value of the '{@link implementation.Method#getOperationDef <em>Operation Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation Def</em>' containment reference.
	 * @see #getOperationDef()
	 * @generated
	 */
	void setOperationDef(EOperation value);

	/**
	 * Returns the value of the '<em><b>Containing Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Class</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Class</em>' attribute.
	 * @see #setContainingClass(String)
	 * @see implementation.ImplementationPackage#getMethod_ContainingClass()
	 * @model required="true"
	 * @generated
	 */
	String getContainingClass();

	/**
	 * Sets the value of the '{@link implementation.Method#getContainingClass <em>Containing Class</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Class</em>' attribute.
	 * @see #getContainingClass()
	 * @generated
	 */
	void setContainingClass(String value);

} // Method
