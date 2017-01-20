/**
 */
package implementation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link implementation.While#getCollectionExpression <em>Collection Expression</em>}</li>
 *   <li>{@link implementation.While#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see implementation.ImplementationPackage#getWhile()
 * @model
 * @generated
 */
public interface While extends Statement {
	/**
	 * Returns the value of the '<em><b>Collection Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Expression</em>' attribute.
	 * @see #setCollectionExpression(String)
	 * @see implementation.ImplementationPackage#getWhile_CollectionExpression()
	 * @model required="true"
	 * @generated
	 */
	String getCollectionExpression();

	/**
	 * Sets the value of the '{@link implementation.While#getCollectionExpression <em>Collection Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Expression</em>' attribute.
	 * @see #getCollectionExpression()
	 * @generated
	 */
	void setCollectionExpression(String value);

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
	 * @see implementation.ImplementationPackage#getWhile_Body()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Block getBody();

	/**
	 * Sets the value of the '{@link implementation.While#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Block value);

} // While
