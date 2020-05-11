/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToResultInVoidOperation;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Context;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MissingReturnStatement;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.NotIterable;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound;
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
			case DiagnosticsPackage.TYPE_NOT_FOUND: {
				TypeNotFound typeNotFound = (TypeNotFound)theEObject;
				T result = caseTypeNotFound(typeNotFound);
				if (result == null) result = caseMessage(typeNotFound);
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
			case DiagnosticsPackage.VARIABLE_ALREADY_BOUND: {
				VariableAlreadyBound variableAlreadyBound = (VariableAlreadyBound)theEObject;
				T result = caseVariableAlreadyBound(variableAlreadyBound);
				if (result == null) result = caseMessage(variableAlreadyBound);
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
			case DiagnosticsPackage.ASSIGNMENT_TO_SELF: {
				AssignmentToSelf assignmentToSelf = (AssignmentToSelf)theEObject;
				T result = caseAssignmentToSelf(assignmentToSelf);
				if (result == null) result = caseMessage(assignmentToSelf);
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
	 * Returns the result of interpreting the object as an instance of '<em>Variable Already Bound</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Already Bound</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableAlreadyBound(VariableAlreadyBound object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Assignment To Self</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Assignment To Self</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAssignmentToSelf(AssignmentToSelf object) {
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
