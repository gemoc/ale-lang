/**
 */
package org.eclipse.ecoretools.ale.implementation;

import org.eclipse.acceleo.query.ast.Expression;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.Attribute#getFeatureRef <em>Feature Ref</em>}</li>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.Attribute#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ecoretools.ale.implementation.ImplementationPackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends EObject {
	/**
	 * Returns the value of the '<em><b>Feature Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Ref</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Ref</em>' reference.
	 * @see #setFeatureRef(EStructuralFeature)
	 * @see org.eclipse.ecoretools.ale.implementation.ImplementationPackage#getAttribute_FeatureRef()
	 * @model required="true"
	 * @generated
	 */
	EStructuralFeature getFeatureRef();

	/**
	 * Sets the value of the '{@link org.eclipse.ecoretools.ale.implementation.Attribute#getFeatureRef <em>Feature Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Ref</em>' reference.
	 * @see #getFeatureRef()
	 * @generated
	 */
	void setFeatureRef(EStructuralFeature value);

	/**
	 * Returns the value of the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Value</em>' containment reference.
	 * @see #setInitialValue(Expression)
	 * @see org.eclipse.ecoretools.ale.implementation.ImplementationPackage#getAttribute_InitialValue()
	 * @model containment="true"
	 * @generated
	 */
	Expression getInitialValue();

	/**
	 * Sets the value of the '{@link org.eclipse.ecoretools.ale.implementation.Attribute#getInitialValue <em>Initial Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Value</em>' containment reference.
	 * @see #getInitialValue()
	 * @generated
	 */
	void setInitialValue(Expression value);

} // Attribute
