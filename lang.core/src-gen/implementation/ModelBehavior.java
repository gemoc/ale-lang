/**
 */
package implementation;

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
 *   <li>{@link implementation.ModelBehavior#getClassExtensions <em>Class Extensions</em>}</li>
 *   <li>{@link implementation.ModelBehavior#getServices <em>Services</em>}</li>
 * </ul>
 *
 * @see implementation.ImplementationPackage#getModelBehavior()
 * @model
 * @generated
 */
public interface ModelBehavior extends EObject {
	/**
	 * Returns the value of the '<em><b>Class Extensions</b></em>' containment reference list.
	 * The list contents are of type {@link implementation.ExtendedClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Extensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Extensions</em>' containment reference list.
	 * @see implementation.ImplementationPackage#getModelBehavior_ClassExtensions()
	 * @model containment="true"
	 * @generated
	 */
	EList<ExtendedClass> getClassExtensions();

	/**
	 * Returns the value of the '<em><b>Services</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Services</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Services</em>' attribute list.
	 * @see implementation.ImplementationPackage#getModelBehavior_Services()
	 * @model
	 * @generated
	 */
	EList<String> getServices();

} // ModelBehavior
