/**
 */
package implementation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link implementation.Root#getDeclarations <em>Declarations</em>}</li>
 * </ul>
 *
 * @see implementation.ImplementationPackage#getRoot()
 * @model
 * @generated
 */
public interface Root extends EObject {
	/**
	 * Returns the value of the '<em><b>Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link implementation.Behaviored}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declarations</em>' containment reference list.
	 * @see implementation.ImplementationPackage#getRoot_Declarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<Behaviored> getDeclarations();

} // Root
