/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Already Defined In Current Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass#getPreviousDeclaration <em>Previous Declaration</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass#getCurrentDeclaration <em>Current Declaration</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getMethodAlreadyDefinedInCurrentClass()
 * @model
 * @generated
 */
public interface MethodAlreadyDefinedInCurrentClass extends Message {
	/**
	 * Returns the value of the '<em><b>Previous Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Previous Declaration</em>' reference.
	 * @see #setPreviousDeclaration(Method)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getMethodAlreadyDefinedInCurrentClass_PreviousDeclaration()
	 * @model
	 * @generated
	 */
	Method getPreviousDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass#getPreviousDeclaration <em>Previous Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Previous Declaration</em>' reference.
	 * @see #getPreviousDeclaration()
	 * @generated
	 */
	void setPreviousDeclaration(Method value);

	/**
	 * Returns the value of the '<em><b>Current Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Declaration</em>' reference.
	 * @see #setCurrentDeclaration(Method)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getMethodAlreadyDefinedInCurrentClass_CurrentDeclaration()
	 * @model
	 * @generated
	 */
	Method getCurrentDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass#getCurrentDeclaration <em>Current Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Declaration</em>' reference.
	 * @see #getCurrentDeclaration()
	 * @generated
	 */
	void setCurrentDeclaration(Method value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see #setOwner(BehavioredClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getMethodAlreadyDefinedInCurrentClass_Owner()
	 * @model
	 * @generated
	 */
	BehavioredClass getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass#getOwner <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(BehavioredClass value);

} // MethodAlreadyDefinedInCurrentClass
