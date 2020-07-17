/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute Already Defined In Current Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getPreviousDeclaration <em>Previous Declaration</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getCurrentDeclaration <em>Current Declaration</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getAttributeAlreadyDefinedInCurrentClass()
 * @model
 * @generated
 */
public interface AttributeAlreadyDefinedInCurrentClass extends Message {
	/**
	 * Returns the value of the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attribute Name</em>' attribute.
	 * @see #setAttributeName(String)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getAttributeAlreadyDefinedInCurrentClass_AttributeName()
	 * @model
	 * @generated
	 */
	String getAttributeName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getAttributeName <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attribute Name</em>' attribute.
	 * @see #getAttributeName()
	 * @generated
	 */
	void setAttributeName(String value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(BehavioredClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getAttributeAlreadyDefinedInCurrentClass_Owner()
	 * @model
	 * @generated
	 */
	BehavioredClass getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(BehavioredClass value);

	/**
	 * Returns the value of the '<em><b>Previous Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous Declaration</em>' reference.
	 * @see #setPreviousDeclaration(Attribute)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getAttributeAlreadyDefinedInCurrentClass_PreviousDeclaration()
	 * @model
	 * @generated
	 */
	Attribute getPreviousDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getPreviousDeclaration <em>Previous Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous Declaration</em>' reference.
	 * @see #getPreviousDeclaration()
	 * @generated
	 */
	void setPreviousDeclaration(Attribute value);

	/**
	 * Returns the value of the '<em><b>Current Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Declaration</em>' reference.
	 * @see #setCurrentDeclaration(Attribute)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getAttributeAlreadyDefinedInCurrentClass_CurrentDeclaration()
	 * @model
	 * @generated
	 */
	Attribute getCurrentDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getCurrentDeclaration <em>Current Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Declaration</em>' reference.
	 * @see #getCurrentDeclaration()
	 * @generated
	 */
	void setCurrentDeclaration(Attribute value);

} // AttributeAlreadyDefinedInCurrentClass
