/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage
 * @generated
 */
public interface DiagnosticsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagnosticsFactory eINSTANCE = org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Attribute Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Not Found</em>'.
	 * @generated
	 */
	AttributeNotFound createAttributeNotFound();

	/**
	 * Returns a new object of class '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Message</em>'.
	 * @generated
	 */
	Message createMessage();

	/**
	 * Returns a new object of class '<em>Code Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Code Location</em>'.
	 * @generated
	 */
	CodeLocation createCodeLocation();

	/**
	 * Returns a new object of class '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Context</em>'.
	 * @generated
	 */
	Context createContext();

	/**
	 * Returns a new object of class '<em>Method Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Not Found</em>'.
	 * @generated
	 */
	MethodNotFound createMethodNotFound();

	/**
	 * Returns a new object of class '<em>Variable Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Not Found</em>'.
	 * @generated
	 */
	VariableNotFound createVariableNotFound();

	/**
	 * Returns a new object of class '<em>Type Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Not Found</em>'.
	 * @generated
	 */
	TypeNotFound createTypeNotFound();

	/**
	 * Returns a new object of class '<em>Type Mismatch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Mismatch</em>'.
	 * @generated
	 */
	TypeMismatch createTypeMismatch();

	/**
	 * Returns a new object of class '<em>Variable Already Bound</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Already Bound</em>'.
	 * @generated
	 */
	VariableAlreadyBound createVariableAlreadyBound();

	/**
	 * Returns a new object of class '<em>Internal Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Error</em>'.
	 * @generated
	 */
	InternalError createInternalError();

	/**
	 * Returns a new object of class '<em>Assignment To Self</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment To Self</em>'.
	 * @generated
	 */
	AssignmentToSelf createAssignmentToSelf();

	/**
	 * Returns a new object of class '<em>Assignment To Result In Void Operation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assignment To Result In Void Operation</em>'.
	 * @generated
	 */
	AssignmentToResultInVoidOperation createAssignmentToResultInVoidOperation();

	/**
	 * Returns a new object of class '<em>Not Iterable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not Iterable</em>'.
	 * @generated
	 */
	NotIterable createNotIterable();

	/**
	 * Returns a new object of class '<em>Unsupported Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unsupported Operator</em>'.
	 * @generated
	 */
	UnsupportedOperator createUnsupportedOperator();

	/**
	 * Returns a new object of class '<em>Missing Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Missing Return Statement</em>'.
	 * @generated
	 */
	MissingReturnStatement createMissingReturnStatement();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DiagnosticsPackage getDiagnosticsPackage();

} //DiagnosticsFactory
