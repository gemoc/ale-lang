/**
 */
package implementation;

import org.eclipse.acceleo.query.ast.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Remove</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link implementation.FeatureRemove#getTarget <em>Target</em>}</li>
 *   <li>{@link implementation.FeatureRemove#getTargetFeature <em>Target Feature</em>}</li>
 *   <li>{@link implementation.FeatureRemove#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see implementation.ImplementationPackage#getFeatureRemove()
 * @model
 * @generated
 */
public interface FeatureRemove extends Statement {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' containment reference.
	 * @see #setTarget(Expression)
	 * @see implementation.ImplementationPackage#getFeatureRemove_Target()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getTarget();

	/**
	 * Sets the value of the '{@link implementation.FeatureRemove#getTarget <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' containment reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(Expression value);

	/**
	 * Returns the value of the '<em><b>Target Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Feature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Feature</em>' attribute.
	 * @see #setTargetFeature(String)
	 * @see implementation.ImplementationPackage#getFeatureRemove_TargetFeature()
	 * @model required="true"
	 * @generated
	 */
	String getTargetFeature();

	/**
	 * Sets the value of the '{@link implementation.FeatureRemove#getTargetFeature <em>Target Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Feature</em>' attribute.
	 * @see #getTargetFeature()
	 * @generated
	 */
	void setTargetFeature(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(Expression)
	 * @see implementation.ImplementationPackage#getFeatureRemove_Value()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Expression getValue();

	/**
	 * Sets the value of the '{@link implementation.FeatureRemove#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Expression value);

} // FeatureRemove
