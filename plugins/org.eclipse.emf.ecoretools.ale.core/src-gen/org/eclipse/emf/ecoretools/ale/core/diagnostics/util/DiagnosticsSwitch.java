/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToResultInVoidOperation;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassExtendsItself;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.CollectionTypeMismatch;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Context;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAdditionAssignment;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAssignment;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalSubstractionAssignment;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInBaseClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodParameterAlreadyDefined;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MissingReturnStatement;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.NotAnOpenableClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.NotIterable;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.OpenClassNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToMethodParameter;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedInsertionToSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedRemovalFromSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordResult;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeHasNamesakes;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage
 * @generated
 */
public class DiagnosticsSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DiagnosticsPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagnosticsSwitch() {
		if (modelPackage == null) {
			modelPackage = DiagnosticsPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case DiagnosticsPackage.ATTRIBUTE_NOT_FOUND: {
				AttributeNotFound attributeNotFound = (AttributeNotFound)theEObject;
				T result = caseAttributeNotFound(attributeNotFound);
				if (result == null) result = caseMessage(attributeNotFound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.MESSAGE: {
				Message message = (Message)theEObject;
				T result = caseMessage(message);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.CODE_LOCATION: {
				CodeLocation codeLocation = (CodeLocation)theEObject;
				T result = caseCodeLocation(codeLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.CONTEXT: {
				Context context = (Context)theEObject;
				T result = caseContext(context);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.METHOD_NOT_FOUND: {
				MethodNotFound methodNotFound = (MethodNotFound)theEObject;
				T result = caseMethodNotFound(methodNotFound);
				if (result == null) result = caseMessage(methodNotFound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.VARIABLE_NOT_FOUND: {
				VariableNotFound variableNotFound = (VariableNotFound)theEObject;
				T result = caseVariableNotFound(variableNotFound);
				if (result == null) result = caseMessage(variableNotFound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.TYPE_MISMATCH: {
				TypeMismatch typeMismatch = (TypeMismatch)theEObject;
				T result = caseTypeMismatch(typeMismatch);
				if (result == null) result = caseMessage(typeMismatch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.VARIABLE_ALREADY_DEFINED: {
				VariableAlreadyDefined variableAlreadyDefined = (VariableAlreadyDefined)theEObject;
				T result = caseVariableAlreadyDefined(variableAlreadyDefined);
				if (result == null) result = caseMessage(variableAlreadyDefined);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.INTERNAL_ERROR: {
				org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError internalError = (org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError)theEObject;
				T result = caseInternalError(internalError);
				if (result == null) result = caseMessage(internalError);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.PROHIBITED_ASSIGNMENT_TO_SELF: {
				ProhibitedAssignmentToSelf prohibitedAssignmentToSelf = (ProhibitedAssignmentToSelf)theEObject;
				T result = caseProhibitedAssignmentToSelf(prohibitedAssignmentToSelf);
				if (result == null) result = caseMessage(prohibitedAssignmentToSelf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION: {
				AssignmentToResultInVoidOperation assignmentToResultInVoidOperation = (AssignmentToResultInVoidOperation)theEObject;
				T result = caseAssignmentToResultInVoidOperation(assignmentToResultInVoidOperation);
				if (result == null) result = caseVariableNotFound(assignmentToResultInVoidOperation);
				if (result == null) result = caseMessage(assignmentToResultInVoidOperation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.NOT_ITERABLE: {
				NotIterable notIterable = (NotIterable)theEObject;
				T result = caseNotIterable(notIterable);
				if (result == null) result = caseTypeMismatch(notIterable);
				if (result == null) result = caseMessage(notIterable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR: {
				UnsupportedOperator unsupportedOperator = (UnsupportedOperator)theEObject;
				T result = caseUnsupportedOperator(unsupportedOperator);
				if (result == null) result = caseMessage(unsupportedOperator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.MISSING_RETURN_STATEMENT: {
				MissingReturnStatement missingReturnStatement = (MissingReturnStatement)theEObject;
				T result = caseMissingReturnStatement(missingReturnStatement);
				if (result == null) result = caseMessage(missingReturnStatement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE: {
				ClassOpenedMoreThanOnce classOpenedMoreThanOnce = (ClassOpenedMoreThanOnce)theEObject;
				T result = caseClassOpenedMoreThanOnce(classOpenedMoreThanOnce);
				if (result == null) result = caseMessage(classOpenedMoreThanOnce);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.NOT_AN_OPENABLE_CLASS: {
				NotAnOpenableClass notAnOpenableClass = (NotAnOpenableClass)theEObject;
				T result = caseNotAnOpenableClass(notAnOpenableClass);
				if (result == null) result = caseMessage(notAnOpenableClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.OPEN_CLASS_NOT_FOUND: {
				OpenClassNotFound openClassNotFound = (OpenClassNotFound)theEObject;
				T result = caseOpenClassNotFound(openClassNotFound);
				if (result == null) result = caseMessage(openClassNotFound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.TYPE_HAS_NAMESAKES: {
				TypeHasNamesakes typeHasNamesakes = (TypeHasNamesakes)theEObject;
				T result = caseTypeHasNamesakes(typeHasNamesakes);
				if (result == null) result = caseMessage(typeHasNamesakes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.INCORRECT_EXTEND_ORDER: {
				IncorrectExtendOrder incorrectExtendOrder = (IncorrectExtendOrder)theEObject;
				T result = caseIncorrectExtendOrder(incorrectExtendOrder);
				if (result == null) result = caseMessage(incorrectExtendOrder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.COLLECTION_TYPE_MISMATCH: {
				CollectionTypeMismatch collectionTypeMismatch = (CollectionTypeMismatch)theEObject;
				T result = caseCollectionTypeMismatch(collectionTypeMismatch);
				if (result == null) result = caseTypeMismatch(collectionTypeMismatch);
				if (result == null) result = caseMessage(collectionTypeMismatch);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.CLASS_EXTENDS_ITSELF: {
				ClassExtendsItself classExtendsItself = (ClassExtendsItself)theEObject;
				T result = caseClassExtendsItself(classExtendsItself);
				if (result == null) result = caseMessage(classExtendsItself);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.ILLEGAL_ASSIGNMENT: {
				IllegalAssignment illegalAssignment = (IllegalAssignment)theEObject;
				T result = caseIllegalAssignment(illegalAssignment);
				if (result == null) result = caseTypeMismatch(illegalAssignment);
				if (result == null) result = caseMessage(illegalAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.INDIRECT_EXTENSION: {
				IndirectExtension indirectExtension = (IndirectExtension)theEObject;
				T result = caseIndirectExtension(indirectExtension);
				if (result == null) result = caseMessage(indirectExtension);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.PROHIBITED_INSERTION_TO_SELF: {
				ProhibitedInsertionToSelf prohibitedInsertionToSelf = (ProhibitedInsertionToSelf)theEObject;
				T result = caseProhibitedInsertionToSelf(prohibitedInsertionToSelf);
				if (result == null) result = caseUnsupportedOperator(prohibitedInsertionToSelf);
				if (result == null) result = caseMessage(prohibitedInsertionToSelf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.PROHIBITED_REMOVAL_FROM_SELF: {
				ProhibitedRemovalFromSelf prohibitedRemovalFromSelf = (ProhibitedRemovalFromSelf)theEObject;
				T result = caseProhibitedRemovalFromSelf(prohibitedRemovalFromSelf);
				if (result == null) result = caseUnsupportedOperator(prohibitedRemovalFromSelf);
				if (result == null) result = caseMessage(prohibitedRemovalFromSelf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.TYPE_NOT_FOUND: {
				TypeNotFound typeNotFound = (TypeNotFound)theEObject;
				T result = caseTypeNotFound(typeNotFound);
				if (result == null) result = caseMessage(typeNotFound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED: {
				DynamicClassAlreadyDefined dynamicClassAlreadyDefined = (DynamicClassAlreadyDefined)theEObject;
				T result = caseDynamicClassAlreadyDefined(dynamicClassAlreadyDefined);
				if (result == null) result = caseMessage(dynamicClassAlreadyDefined);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS: {
				AttributeAlreadyDefinedInBaseClass attributeAlreadyDefinedInBaseClass = (AttributeAlreadyDefinedInBaseClass)theEObject;
				T result = caseAttributeAlreadyDefinedInBaseClass(attributeAlreadyDefinedInBaseClass);
				if (result == null) result = caseMessage(attributeAlreadyDefinedInBaseClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_BASE_CLASS: {
				MethodAlreadyDefinedInBaseClass methodAlreadyDefinedInBaseClass = (MethodAlreadyDefinedInBaseClass)theEObject;
				T result = caseMethodAlreadyDefinedInBaseClass(methodAlreadyDefinedInBaseClass);
				if (result == null) result = caseMessage(methodAlreadyDefinedInBaseClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS: {
				AttributeAlreadyDefinedInCurrentClass attributeAlreadyDefinedInCurrentClass = (AttributeAlreadyDefinedInCurrentClass)theEObject;
				T result = caseAttributeAlreadyDefinedInCurrentClass(attributeAlreadyDefinedInCurrentClass);
				if (result == null) result = caseMessage(attributeAlreadyDefinedInCurrentClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.RESERVED_KEYWORD_SELF: {
				ReservedKeywordSelf reservedKeywordSelf = (ReservedKeywordSelf)theEObject;
				T result = caseReservedKeywordSelf(reservedKeywordSelf);
				if (result == null) result = caseMessage(reservedKeywordSelf);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.RESERVED_KEYWORD_RESULT: {
				ReservedKeywordResult reservedKeywordResult = (ReservedKeywordResult)theEObject;
				T result = caseReservedKeywordResult(reservedKeywordResult);
				if (result == null) result = caseMessage(reservedKeywordResult);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS: {
				MethodAlreadyDefinedInCurrentClass methodAlreadyDefinedInCurrentClass = (MethodAlreadyDefinedInCurrentClass)theEObject;
				T result = caseMethodAlreadyDefinedInCurrentClass(methodAlreadyDefinedInCurrentClass);
				if (result == null) result = caseMessage(methodAlreadyDefinedInCurrentClass);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.METHOD_PARAMETER_ALREADY_DEFINED: {
				MethodParameterAlreadyDefined methodParameterAlreadyDefined = (MethodParameterAlreadyDefined)theEObject;
				T result = caseMethodParameterAlreadyDefined(methodParameterAlreadyDefined);
				if (result == null) result = caseMessage(methodParameterAlreadyDefined);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND: {
				OverriddenMethodNotFound overriddenMethodNotFound = (OverriddenMethodNotFound)theEObject;
				T result = caseOverriddenMethodNotFound(overriddenMethodNotFound);
				if (result == null) result = caseMessage(overriddenMethodNotFound);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER: {
				ProhibitedAssignmentToMethodParameter prohibitedAssignmentToMethodParameter = (ProhibitedAssignmentToMethodParameter)theEObject;
				T result = caseProhibitedAssignmentToMethodParameter(prohibitedAssignmentToMethodParameter);
				if (result == null) result = caseMessage(prohibitedAssignmentToMethodParameter);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.ACCELEO_VALIDATION_MESSAGE: {
				AcceleoValidationMessage acceleoValidationMessage = (AcceleoValidationMessage)theEObject;
				T result = caseAcceleoValidationMessage(acceleoValidationMessage);
				if (result == null) result = caseMessage(acceleoValidationMessage);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.ILLEGAL_ADDITION_ASSIGNMENT: {
				IllegalAdditionAssignment illegalAdditionAssignment = (IllegalAdditionAssignment)theEObject;
				T result = caseIllegalAdditionAssignment(illegalAdditionAssignment);
				if (result == null) result = caseTypeMismatch(illegalAdditionAssignment);
				if (result == null) result = caseMessage(illegalAdditionAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case DiagnosticsPackage.ILLEGAL_SUBSTRACTION_ASSIGNMENT: {
				IllegalSubstractionAssignment illegalSubstractionAssignment = (IllegalSubstractionAssignment)theEObject;
				T result = caseIllegalSubstractionAssignment(illegalSubstractionAssignment);
				if (result == null) result = caseTypeMismatch(illegalSubstractionAssignment);
				if (result == null) result = caseMessage(illegalSubstractionAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Not Found</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeNotFound(AttributeNotFound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMessage(Message object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCodeLocation(CodeLocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContext(Context object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Not Found</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodNotFound(MethodNotFound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Not Found</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableNotFound(VariableNotFound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Mismatch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Mismatch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeMismatch(TypeMismatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Already Defined</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Already Defined</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableAlreadyDefined(VariableAlreadyDefined object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Error</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Error</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalError(org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prohibited Assignment To Self</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prohibited Assignment To Self</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProhibitedAssignmentToSelf(ProhibitedAssignmentToSelf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Assignment To Result In Void Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment To Result In Void Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignmentToResultInVoidOperation(AssignmentToResultInVoidOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Iterable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Iterable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotIterable(NotIterable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unsupported Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unsupported Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUnsupportedOperator(UnsupportedOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Missing Return Statement</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Missing Return Statement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMissingReturnStatement(MissingReturnStatement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Opened More Than Once</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Opened More Than Once</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassOpenedMoreThanOnce(ClassOpenedMoreThanOnce object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not An Openable Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not An Openable Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotAnOpenableClass(NotAnOpenableClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Open Class Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Open Class Not Found</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOpenClassNotFound(OpenClassNotFound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Has Namesakes</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Has Namesakes</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeHasNamesakes(TypeHasNamesakes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Incorrect Extend Order</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Incorrect Extend Order</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIncorrectExtendOrder(IncorrectExtendOrder object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Type Mismatch</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Type Mismatch</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionTypeMismatch(CollectionTypeMismatch object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Class Extends Itself</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Class Extends Itself</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseClassExtendsItself(ClassExtendsItself object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Illegal Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Illegal Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIllegalAssignment(IllegalAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Indirect Extension</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Indirect Extension</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIndirectExtension(IndirectExtension object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prohibited Insertion To Self</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prohibited Insertion To Self</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProhibitedInsertionToSelf(ProhibitedInsertionToSelf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prohibited Removal From Self</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prohibited Removal From Self</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProhibitedRemovalFromSelf(ProhibitedRemovalFromSelf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type Not Found</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypeNotFound(TypeNotFound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Class Already Defined</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Class Already Defined</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicClassAlreadyDefined(DynamicClassAlreadyDefined object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Already Defined In Base Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Already Defined In Base Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeAlreadyDefinedInBaseClass(AttributeAlreadyDefinedInBaseClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Already Defined In Base Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Already Defined In Base Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodAlreadyDefinedInBaseClass(MethodAlreadyDefinedInBaseClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Already Defined In Current Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Already Defined In Current Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeAlreadyDefinedInCurrentClass(AttributeAlreadyDefinedInCurrentClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reserved Keyword Self</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reserved Keyword Self</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReservedKeywordSelf(ReservedKeywordSelf object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reserved Keyword Result</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reserved Keyword Result</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReservedKeywordResult(ReservedKeywordResult object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Already Defined In Current Class</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Already Defined In Current Class</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodAlreadyDefinedInCurrentClass(MethodAlreadyDefinedInCurrentClass object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Method Parameter Already Defined</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Method Parameter Already Defined</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMethodParameterAlreadyDefined(MethodParameterAlreadyDefined object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Overridden Method Not Found</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Overridden Method Not Found</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOverriddenMethodNotFound(OverriddenMethodNotFound object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Prohibited Assignment To Method Parameter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Prohibited Assignment To Method Parameter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProhibitedAssignmentToMethodParameter(ProhibitedAssignmentToMethodParameter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Acceleo Validation Message</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Acceleo Validation Message</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAcceleoValidationMessage(AcceleoValidationMessage object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Illegal Addition Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Illegal Addition Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIllegalAdditionAssignment(IllegalAdditionAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Illegal Substraction Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Illegal Substraction Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIllegalSubstractionAssignment(IllegalSubstractionAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //DiagnosticsSwitch
