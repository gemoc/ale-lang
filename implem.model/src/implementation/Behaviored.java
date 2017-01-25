/**
 */
package implementation;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behaviored</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link implementation.Behaviored#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see implementation.ImplementationPackage#getBehaviored()
 * @model
 * @generated
 */
public interface Behaviored extends EObject {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Block)
	 * @see implementation.ImplementationPackage#getBehaviored_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Block getBody();

	/**
	 * Sets the value of the '{@link implementation.Behaviored#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Block value);

} // Behaviored
