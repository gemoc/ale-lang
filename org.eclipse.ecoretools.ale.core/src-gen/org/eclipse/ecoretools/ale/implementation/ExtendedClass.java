/**
 */
package org.eclipse.ecoretools.ale.implementation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Extended Class</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.ExtendedClass#getBaseClass <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.ExtendedClass#getMethods <em>Methods</em>}</li>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.ExtendedClass#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.ExtendedClass#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.ExtendedClass#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @see org.eclipse.ecoretools.ale.implementation.ImplementationPackage#getExtendedClass()
 * @model
 * @generated
 */
public interface ExtendedClass extends EModelElement {
	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBaseClass(EClass)
	 * @see org.eclipse.ecoretools.ale.implementation.ImplementationPackage#getExtendedClass_BaseClass()
	 * @model required="true"
	 * @generated
	 */
	EClass getBaseClass();

	/**
	 * Sets the value of the '{@link org.eclipse.ecoretools.ale.implementation.ExtendedClass#getBaseClass <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBaseClass()
	 * @generated
	 */
	void setBaseClass(EClass value);

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ecoretools.ale.implementation.Behaviored}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' containment reference list.
	 * @see org.eclipse.ecoretools.ale.implementation.ImplementationPackage#getExtendedClass_Methods()
	 * @model containment="true"
	 * @generated
	 */
	EList<Behaviored> getMethods();

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.ecoretools.ale.implementation.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see org.eclipse.ecoretools.ale.implementation.ImplementationPackage#getExtendedClass_Attributes()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableDeclaration> getAttributes();

	/**
	 * Returns the value of the '<em><b>Extends</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ecoretools.ale.implementation.ExtendedClass}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ecoretools.ale.implementation.ExtendedClass#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extends</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extends</em>' reference list.
	 * @see org.eclipse.ecoretools.ale.implementation.ImplementationPackage#getExtendedClass_Extends()
	 * @see org.eclipse.ecoretools.ale.implementation.ExtendedClass#getChildren
	 * @model opposite="children"
	 * @generated
	 */
	EList<ExtendedClass> getExtends();

	/**
	 * Returns the value of the '<em><b>Children</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.ecoretools.ale.implementation.ExtendedClass}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.ecoretools.ale.implementation.ExtendedClass#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Children</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Children</em>' reference list.
	 * @see org.eclipse.ecoretools.ale.implementation.ImplementationPackage#getExtendedClass_Children()
	 * @see org.eclipse.ecoretools.ale.implementation.ExtendedClass#getExtends
	 * @model opposite="extends"
	 * @generated
	 */
	EList<ExtendedClass> getChildren();

} // ExtendedClass
