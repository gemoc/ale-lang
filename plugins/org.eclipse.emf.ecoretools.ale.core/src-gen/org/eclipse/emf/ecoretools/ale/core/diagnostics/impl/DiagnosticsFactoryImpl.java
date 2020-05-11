/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.acceleo.query.validation.type.IType;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToResultInVoidOperation;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Context;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsFactory;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MissingReturnStatement;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.NotIterable;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagnosticsFactoryImpl extends EFactoryImpl implements DiagnosticsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DiagnosticsFactory init() {
		try {
			DiagnosticsFactory theDiagnosticsFactory = (DiagnosticsFactory)EPackage.Registry.INSTANCE.getEFactory(DiagnosticsPackage.eNS_URI);
			if (theDiagnosticsFactory != null) {
				return theDiagnosticsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DiagnosticsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagnosticsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DiagnosticsPackage.ATTRIBUTE_NOT_FOUND: return createAttributeNotFound();
			case DiagnosticsPackage.MESSAGE: return createMessage();
			case DiagnosticsPackage.CODE_LOCATION: return createCodeLocation();
			case DiagnosticsPackage.CONTEXT: return createContext();
			case DiagnosticsPackage.METHOD_NOT_FOUND: return createMethodNotFound();
			case DiagnosticsPackage.VARIABLE_NOT_FOUND: return createVariableNotFound();
			case DiagnosticsPackage.TYPE_NOT_FOUND: return createTypeNotFound();
			case DiagnosticsPackage.TYPE_MISMATCH: return createTypeMismatch();
			case DiagnosticsPackage.VARIABLE_ALREADY_BOUND: return createVariableAlreadyBound();
			case DiagnosticsPackage.INTERNAL_ERROR: return createInternalError();
			case DiagnosticsPackage.ASSIGNMENT_TO_SELF: return createAssignmentToSelf();
			case DiagnosticsPackage.ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION: return createAssignmentToResultInVoidOperation();
			case DiagnosticsPackage.NOT_ITERABLE: return createNotIterable();
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR: return createUnsupportedOperator();
			case DiagnosticsPackage.MISSING_RETURN_STATEMENT: return createMissingReturnStatement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DiagnosticsPackage.OPERATOR:
				return createOperatorFromString(eDataType, initialValue);
			case DiagnosticsPackage.ITYPE:
				return createITypeFromString(eDataType, initialValue);
			case DiagnosticsPackage.THROWABLE:
				return createThrowableFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DiagnosticsPackage.OPERATOR:
				return convertOperatorToString(eDataType, instanceValue);
			case DiagnosticsPackage.ITYPE:
				return convertITypeToString(eDataType, instanceValue);
			case DiagnosticsPackage.THROWABLE:
				return convertThrowableToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeNotFound createAttributeNotFound() {
		AttributeNotFoundImpl attributeNotFound = new AttributeNotFoundImpl();
		return attributeNotFound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Message createMessage() {
		MessageImpl message = new MessageImpl();
		return message;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CodeLocation createCodeLocation() {
		CodeLocationImpl codeLocation = new CodeLocationImpl();
		return codeLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Context createContext() {
		ContextImpl context = new ContextImpl();
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MethodNotFound createMethodNotFound() {
		MethodNotFoundImpl methodNotFound = new MethodNotFoundImpl();
		return methodNotFound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableNotFound createVariableNotFound() {
		VariableNotFoundImpl variableNotFound = new VariableNotFoundImpl();
		return variableNotFound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeNotFound createTypeNotFound() {
		TypeNotFoundImpl typeNotFound = new TypeNotFoundImpl();
		return typeNotFound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeMismatch createTypeMismatch() {
		TypeMismatchImpl typeMismatch = new TypeMismatchImpl();
		return typeMismatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VariableAlreadyBound createVariableAlreadyBound() {
		VariableAlreadyBoundImpl variableAlreadyBound = new VariableAlreadyBoundImpl();
		return variableAlreadyBound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError createInternalError() {
		InternalErrorImpl internalError = new InternalErrorImpl();
		return internalError;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssignmentToSelf createAssignmentToSelf() {
		AssignmentToSelfImpl assignmentToSelf = new AssignmentToSelfImpl();
		return assignmentToSelf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssignmentToResultInVoidOperation createAssignmentToResultInVoidOperation() {
		AssignmentToResultInVoidOperationImpl assignmentToResultInVoidOperation = new AssignmentToResultInVoidOperationImpl();
		return assignmentToResultInVoidOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotIterable createNotIterable() {
		NotIterableImpl notIterable = new NotIterableImpl();
		return notIterable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnsupportedOperator createUnsupportedOperator() {
		UnsupportedOperatorImpl unsupportedOperator = new UnsupportedOperatorImpl();
		return unsupportedOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MissingReturnStatement createMissingReturnStatement() {
		MissingReturnStatementImpl missingReturnStatement = new MissingReturnStatementImpl();
		return missingReturnStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator createOperatorFromString(EDataType eDataType, String initialValue) {
		Operator result = Operator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IType createITypeFromString(EDataType eDataType, String initialValue) {
		return (IType)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertITypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Throwable createThrowableFromString(EDataType eDataType, String initialValue) {
		return (Throwable)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertThrowableToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DiagnosticsPackage getDiagnosticsPackage() {
		return (DiagnosticsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DiagnosticsPackage getPackage() {
		return DiagnosticsPackage.eINSTANCE;
	}

} //DiagnosticsFactoryImpl
