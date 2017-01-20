/**
 */
package implementation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature Insert</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link implementation.FeatureInsert#getTargetExpression <em>Target Expression</em>}</li>
 *   <li>{@link implementation.FeatureInsert#getTargetFeature <em>Target Feature</em>}</li>
 *   <li>{@link implementation.FeatureInsert#getValueExpression <em>Value Expression</em>}</li>
 * </ul>
 *
 * @see implementation.ImplementationPackage#getFeatureInsert()
 * @model
 * @generated
 */
public interface FeatureInsert extends Statement {
	/**
	 * Returns the value of the '<em><b>Target Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Expression</em>' attribute.
	 * @see #setTargetExpression(String)
	 * @see implementation.ImplementationPackage#getFeatureInsert_TargetExpression()
	 * @model required="true"
	 * @generated
	 */
	String getTargetExpression();

	/**
	 * Sets the value of the '{@link implementation.FeatureInsert#getTargetExpression <em>Target Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Expression</em>' attribute.
	 * @see #getTargetExpression()
	 * @generated
	 */
	void setTargetExpression(String value);

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
	 * @see implementation.ImplementationPackage#getFeatureInsert_TargetFeature()
	 * @model required="true"
	 * @generated
	 */
	String getTargetFeature();

	/**
	 * Sets the value of the '{@link implementation.FeatureInsert#getTargetFeature <em>Target Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Feature</em>' attribute.
	 * @see #getTargetFeature()
	 * @generated
	 */
	void setTargetFeature(String value);

	/**
	 * Returns the value of the '<em><b>Value Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Expression</em>' attribute.
	 * @see #setValueExpression(String)
	 * @see implementation.ImplementationPackage#getFeatureInsert_ValueExpression()
	 * @model required="true"
	 * @generated
	 */
	String getValueExpression();

	/**
	 * Sets the value of the '{@link implementation.FeatureInsert#getValueExpression <em>Value Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Expression</em>' attribute.
	 * @see #getValueExpression()
	 * @generated
	 */
	void setValueExpression(String value);

} // FeatureInsert
