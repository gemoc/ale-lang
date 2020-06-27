/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Indirect Extension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension#getOpenClass <em>Open Class</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension#getInheritedClass <em>Inherited Class</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getIndirectExtension()
 * @model
 * @generated
 */
public interface IndirectExtension extends Message {
	/**
	 * Returns the value of the '<em><b>Open Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Open Class</em>' reference.
	 * @see #setOpenClass(EClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getIndirectExtension_OpenClass()
	 * @model
	 * @generated
	 */
	EClass getOpenClass();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension#getOpenClass <em>Open Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Open Class</em>' reference.
	 * @see #getOpenClass()
	 * @generated
	 */
	void setOpenClass(EClass value);

	/**
	 * Returns the value of the '<em><b>Inherited Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inherited Class</em>' reference.
	 * @see #setInheritedClass(EClass)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getIndirectExtension_InheritedClass()
	 * @model
	 * @generated
	 */
	EClass getInheritedClass();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension#getInheritedClass <em>Inherited Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Inherited Class</em>' reference.
	 * @see #getInheritedClass()
	 * @generated
	 */
	void setInheritedClass(EClass value);

} // IndirectExtension
