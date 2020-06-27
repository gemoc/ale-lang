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
	 * Returns a new object of class '<em>Type Mismatch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Mismatch</em>'.
	 * @generated
	 */
	TypeMismatch createTypeMismatch();

	/**
	 * Returns a new object of class '<em>Variable Already Defined</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Already Defined</em>'.
	 * @generated
	 */
	VariableAlreadyDefined createVariableAlreadyDefined();

	/**
	 * Returns a new object of class '<em>Internal Error</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Error</em>'.
	 * @generated
	 */
	InternalError createInternalError();

	/**
	 * Returns a new object of class '<em>Prohibited Assignment To Self</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prohibited Assignment To Self</em>'.
	 * @generated
	 */
	ProhibitedAssignmentToSelf createProhibitedAssignmentToSelf();

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
	 * Returns a new object of class '<em>Class Opened More Than Once</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Opened More Than Once</em>'.
	 * @generated
	 */
	ClassOpenedMoreThanOnce createClassOpenedMoreThanOnce();

	/**
	 * Returns a new object of class '<em>Not An Openable Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Not An Openable Class</em>'.
	 * @generated
	 */
	NotAnOpenableClass createNotAnOpenableClass();

	/**
	 * Returns a new object of class '<em>Open Class Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Open Class Not Found</em>'.
	 * @generated
	 */
	OpenClassNotFound createOpenClassNotFound();

	/**
	 * Returns a new object of class '<em>Type Has Namesakes</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Has Namesakes</em>'.
	 * @generated
	 */
	TypeHasNamesakes createTypeHasNamesakes();

	/**
	 * Returns a new object of class '<em>Incorrect Extend Order</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Incorrect Extend Order</em>'.
	 * @generated
	 */
	IncorrectExtendOrder createIncorrectExtendOrder();

	/**
	 * Returns a new object of class '<em>Collection Type Mismatch</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Type Mismatch</em>'.
	 * @generated
	 */
	CollectionTypeMismatch createCollectionTypeMismatch();

	/**
	 * Returns a new object of class '<em>Class Extends Itself</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Class Extends Itself</em>'.
	 * @generated
	 */
	ClassExtendsItself createClassExtendsItself();

	/**
	 * Returns a new object of class '<em>Illegal Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Illegal Assignment</em>'.
	 * @generated
	 */
	IllegalAssignment createIllegalAssignment();

	/**
	 * Returns a new object of class '<em>Indirect Extension</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Indirect Extension</em>'.
	 * @generated
	 */
	IndirectExtension createIndirectExtension();

	/**
	 * Returns a new object of class '<em>Prohibited Insertion To Self</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prohibited Insertion To Self</em>'.
	 * @generated
	 */
	ProhibitedInsertionToSelf createProhibitedInsertionToSelf();

	/**
	 * Returns a new object of class '<em>Prohibited Removal From Self</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prohibited Removal From Self</em>'.
	 * @generated
	 */
	ProhibitedRemovalFromSelf createProhibitedRemovalFromSelf();

	/**
	 * Returns a new object of class '<em>Type Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Not Found</em>'.
	 * @generated
	 */
	TypeNotFound createTypeNotFound();

	/**
	 * Returns a new object of class '<em>Dynamic Class Already Defined</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dynamic Class Already Defined</em>'.
	 * @generated
	 */
	DynamicClassAlreadyDefined createDynamicClassAlreadyDefined();

	/**
	 * Returns a new object of class '<em>Attribute Already Defined In Base Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Already Defined In Base Class</em>'.
	 * @generated
	 */
	AttributeAlreadyDefinedInBaseClass createAttributeAlreadyDefinedInBaseClass();

	/**
	 * Returns a new object of class '<em>Method Already Defined In Base Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Already Defined In Base Class</em>'.
	 * @generated
	 */
	MethodAlreadyDefinedInBaseClass createMethodAlreadyDefinedInBaseClass();

	/**
	 * Returns a new object of class '<em>Attribute Already Defined In Current Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Attribute Already Defined In Current Class</em>'.
	 * @generated
	 */
	AttributeAlreadyDefinedInCurrentClass createAttributeAlreadyDefinedInCurrentClass();

	/**
	 * Returns a new object of class '<em>Reserved Keyword Self</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reserved Keyword Self</em>'.
	 * @generated
	 */
	ReservedKeywordSelf createReservedKeywordSelf();

	/**
	 * Returns a new object of class '<em>Reserved Keyword Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reserved Keyword Result</em>'.
	 * @generated
	 */
	ReservedKeywordResult createReservedKeywordResult();

	/**
	 * Returns a new object of class '<em>Method Already Defined In Current Class</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Already Defined In Current Class</em>'.
	 * @generated
	 */
	MethodAlreadyDefinedInCurrentClass createMethodAlreadyDefinedInCurrentClass();

	/**
	 * Returns a new object of class '<em>Method Parameter Already Defined</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Parameter Already Defined</em>'.
	 * @generated
	 */
	MethodParameterAlreadyDefined createMethodParameterAlreadyDefined();

	/**
	 * Returns a new object of class '<em>Overridden Method Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Overridden Method Not Found</em>'.
	 * @generated
	 */
	OverriddenMethodNotFound createOverriddenMethodNotFound();

	/**
	 * Returns a new object of class '<em>Prohibited Assignment To Method Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Prohibited Assignment To Method Parameter</em>'.
	 * @generated
	 */
	ProhibitedAssignmentToMethodParameter createProhibitedAssignmentToMethodParameter();

	/**
	 * Returns a new object of class '<em>Acceleo Validation Message</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Acceleo Validation Message</em>'.
	 * @generated
	 */
	AcceleoValidationMessage createAcceleoValidationMessage();

	/**
	 * Returns a new object of class '<em>Illegal Addition Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Illegal Addition Assignment</em>'.
	 * @generated
	 */
	IllegalAdditionAssignment createIllegalAdditionAssignment();

	/**
	 * Returns a new object of class '<em>Illegal Substraction Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Illegal Substraction Assignment</em>'.
	 * @generated
	 */
	IllegalSubstractionAssignment createIllegalSubstractionAssignment();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DiagnosticsPackage getDiagnosticsPackage();

} //DiagnosticsFactory
