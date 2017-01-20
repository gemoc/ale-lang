/**
 */
package vmlogo;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Stack Frame</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link vmlogo.StackFrame#getVariables <em>Variables</em>}</li>
 * </ul>
 *
 * @see vmlogo.VmlogoPackage#getStackFrame()
 * @model
 * @generated
 */
public interface StackFrame extends EObject {
	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link vmlogo.Variable}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see vmlogo.VmlogoPackage#getStackFrame_Variables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variable> getVariables();

} // StackFrame
