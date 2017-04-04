/**
 */
package org.eclipse.ecoretools.ale.implementation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Behavior</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.ModelBehavior#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.ModelBehavior#getUnits <em>Units</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ecoretools.ale.implementation.ImplementationPackage#getModelBehavior()
 * @model
 * @generated
 */
public interface ModelBehavior extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.ecoretools.ale.implementation.ImplementationPackage#getModelBehavior_Name()
	 * @model default="" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.ecoretools.ale.implementation.ModelBehavior#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Units</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ecoretools.ale.implementation.ModelUnit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units</em>' containment reference list.
	 * @see org.eclipse.ecoretools.ale.implementation.ImplementationPackage#getModelBehavior_Units()
	 * @model containment="true"
	 * @generated
	 */
	EList<ModelUnit> getUnits();

} // ModelBehavior
