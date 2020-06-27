/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;

import org.eclipse.acceleo.query.validation.type.IType;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsFactory;
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
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator;
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
			case DiagnosticsPackage.TYPE_MISMATCH: return createTypeMismatch();
			case DiagnosticsPackage.VARIABLE_ALREADY_DEFINED: return createVariableAlreadyDefined();
			case DiagnosticsPackage.INTERNAL_ERROR: return createInternalError();
			case DiagnosticsPackage.PROHIBITED_ASSIGNMENT_TO_SELF: return createProhibitedAssignmentToSelf();
			case DiagnosticsPackage.ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION: return createAssignmentToResultInVoidOperation();
			case DiagnosticsPackage.NOT_ITERABLE: return createNotIterable();
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR: return createUnsupportedOperator();
			case DiagnosticsPackage.MISSING_RETURN_STATEMENT: return createMissingReturnStatement();
			case DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE: return createClassOpenedMoreThanOnce();
			case DiagnosticsPackage.NOT_AN_OPENABLE_CLASS: return createNotAnOpenableClass();
			case DiagnosticsPackage.OPEN_CLASS_NOT_FOUND: return createOpenClassNotFound();
			case DiagnosticsPackage.TYPE_HAS_NAMESAKES: return createTypeHasNamesakes();
			case DiagnosticsPackage.INCORRECT_EXTEND_ORDER: return createIncorrectExtendOrder();
			case DiagnosticsPackage.COLLECTION_TYPE_MISMATCH: return createCollectionTypeMismatch();
			case DiagnosticsPackage.CLASS_EXTENDS_ITSELF: return createClassExtendsItself();
			case DiagnosticsPackage.ILLEGAL_ASSIGNMENT: return createIllegalAssignment();
			case DiagnosticsPackage.INDIRECT_EXTENSION: return createIndirectExtension();
			case DiagnosticsPackage.PROHIBITED_INSERTION_TO_SELF: return createProhibitedInsertionToSelf();
			case DiagnosticsPackage.PROHIBITED_REMOVAL_FROM_SELF: return createProhibitedRemovalFromSelf();
			case DiagnosticsPackage.TYPE_NOT_FOUND: return createTypeNotFound();
			case DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED: return createDynamicClassAlreadyDefined();
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS: return createAttributeAlreadyDefinedInBaseClass();
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_BASE_CLASS: return createMethodAlreadyDefinedInBaseClass();
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS: return createAttributeAlreadyDefinedInCurrentClass();
			case DiagnosticsPackage.RESERVED_KEYWORD_SELF: return createReservedKeywordSelf();
			case DiagnosticsPackage.RESERVED_KEYWORD_RESULT: return createReservedKeywordResult();
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS: return createMethodAlreadyDefinedInCurrentClass();
			case DiagnosticsPackage.METHOD_PARAMETER_ALREADY_DEFINED: return createMethodParameterAlreadyDefined();
			case DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND: return createOverriddenMethodNotFound();
			case DiagnosticsPackage.PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER: return createProhibitedAssignmentToMethodParameter();
			case DiagnosticsPackage.ACCELEO_VALIDATION_MESSAGE: return createAcceleoValidationMessage();
			case DiagnosticsPackage.ILLEGAL_ADDITION_ASSIGNMENT: return createIllegalAdditionAssignment();
			case DiagnosticsPackage.ILLEGAL_SUBSTRACTION_ASSIGNMENT: return createIllegalSubstractionAssignment();
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
			case DiagnosticsPackage.VALIDATION_MESSAGE_LEVEL:
				return createValidationMessageLevelFromString(eDataType, initialValue);
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
			case DiagnosticsPackage.VALIDATION_MESSAGE_LEVEL:
				return convertValidationMessageLevelToString(eDataType, instanceValue);
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
	public VariableAlreadyDefined createVariableAlreadyDefined() {
		VariableAlreadyDefinedImpl variableAlreadyDefined = new VariableAlreadyDefinedImpl();
		return variableAlreadyDefined;
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
	public ProhibitedAssignmentToSelf createProhibitedAssignmentToSelf() {
		ProhibitedAssignmentToSelfImpl prohibitedAssignmentToSelf = new ProhibitedAssignmentToSelfImpl();
		return prohibitedAssignmentToSelf;
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
	@Override
	public ClassOpenedMoreThanOnce createClassOpenedMoreThanOnce() {
		ClassOpenedMoreThanOnceImpl classOpenedMoreThanOnce = new ClassOpenedMoreThanOnceImpl();
		return classOpenedMoreThanOnce;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotAnOpenableClass createNotAnOpenableClass() {
		NotAnOpenableClassImpl notAnOpenableClass = new NotAnOpenableClassImpl();
		return notAnOpenableClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OpenClassNotFound createOpenClassNotFound() {
		OpenClassNotFoundImpl openClassNotFound = new OpenClassNotFoundImpl();
		return openClassNotFound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeHasNamesakes createTypeHasNamesakes() {
		TypeHasNamesakesImpl typeHasNamesakes = new TypeHasNamesakesImpl();
		return typeHasNamesakes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IncorrectExtendOrder createIncorrectExtendOrder() {
		IncorrectExtendOrderImpl incorrectExtendOrder = new IncorrectExtendOrderImpl();
		return incorrectExtendOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CollectionTypeMismatch createCollectionTypeMismatch() {
		CollectionTypeMismatchImpl collectionTypeMismatch = new CollectionTypeMismatchImpl();
		return collectionTypeMismatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ClassExtendsItself createClassExtendsItself() {
		ClassExtendsItselfImpl classExtendsItself = new ClassExtendsItselfImpl();
		return classExtendsItself;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IllegalAssignment createIllegalAssignment() {
		IllegalAssignmentImpl illegalAssignment = new IllegalAssignmentImpl();
		return illegalAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IndirectExtension createIndirectExtension() {
		IndirectExtensionImpl indirectExtension = new IndirectExtensionImpl();
		return indirectExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProhibitedInsertionToSelf createProhibitedInsertionToSelf() {
		ProhibitedInsertionToSelfImpl prohibitedInsertionToSelf = new ProhibitedInsertionToSelfImpl();
		return prohibitedInsertionToSelf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProhibitedRemovalFromSelf createProhibitedRemovalFromSelf() {
		ProhibitedRemovalFromSelfImpl prohibitedRemovalFromSelf = new ProhibitedRemovalFromSelfImpl();
		return prohibitedRemovalFromSelf;
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
	public DynamicClassAlreadyDefined createDynamicClassAlreadyDefined() {
		DynamicClassAlreadyDefinedImpl dynamicClassAlreadyDefined = new DynamicClassAlreadyDefinedImpl();
		return dynamicClassAlreadyDefined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeAlreadyDefinedInBaseClass createAttributeAlreadyDefinedInBaseClass() {
		AttributeAlreadyDefinedInBaseClassImpl attributeAlreadyDefinedInBaseClass = new AttributeAlreadyDefinedInBaseClassImpl();
		return attributeAlreadyDefinedInBaseClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MethodAlreadyDefinedInBaseClass createMethodAlreadyDefinedInBaseClass() {
		MethodAlreadyDefinedInBaseClassImpl methodAlreadyDefinedInBaseClass = new MethodAlreadyDefinedInBaseClassImpl();
		return methodAlreadyDefinedInBaseClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AttributeAlreadyDefinedInCurrentClass createAttributeAlreadyDefinedInCurrentClass() {
		AttributeAlreadyDefinedInCurrentClassImpl attributeAlreadyDefinedInCurrentClass = new AttributeAlreadyDefinedInCurrentClassImpl();
		return attributeAlreadyDefinedInCurrentClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReservedKeywordSelf createReservedKeywordSelf() {
		ReservedKeywordSelfImpl reservedKeywordSelf = new ReservedKeywordSelfImpl();
		return reservedKeywordSelf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReservedKeywordResult createReservedKeywordResult() {
		ReservedKeywordResultImpl reservedKeywordResult = new ReservedKeywordResultImpl();
		return reservedKeywordResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MethodAlreadyDefinedInCurrentClass createMethodAlreadyDefinedInCurrentClass() {
		MethodAlreadyDefinedInCurrentClassImpl methodAlreadyDefinedInCurrentClass = new MethodAlreadyDefinedInCurrentClassImpl();
		return methodAlreadyDefinedInCurrentClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MethodParameterAlreadyDefined createMethodParameterAlreadyDefined() {
		MethodParameterAlreadyDefinedImpl methodParameterAlreadyDefined = new MethodParameterAlreadyDefinedImpl();
		return methodParameterAlreadyDefined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OverriddenMethodNotFound createOverriddenMethodNotFound() {
		OverriddenMethodNotFoundImpl overriddenMethodNotFound = new OverriddenMethodNotFoundImpl();
		return overriddenMethodNotFound;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProhibitedAssignmentToMethodParameter createProhibitedAssignmentToMethodParameter() {
		ProhibitedAssignmentToMethodParameterImpl prohibitedAssignmentToMethodParameter = new ProhibitedAssignmentToMethodParameterImpl();
		return prohibitedAssignmentToMethodParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AcceleoValidationMessage createAcceleoValidationMessage() {
		AcceleoValidationMessageImpl acceleoValidationMessage = new AcceleoValidationMessageImpl();
		return acceleoValidationMessage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IllegalAdditionAssignment createIllegalAdditionAssignment() {
		IllegalAdditionAssignmentImpl illegalAdditionAssignment = new IllegalAdditionAssignmentImpl();
		return illegalAdditionAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IllegalSubstractionAssignment createIllegalSubstractionAssignment() {
		IllegalSubstractionAssignmentImpl illegalSubstractionAssignment = new IllegalSubstractionAssignmentImpl();
		return illegalSubstractionAssignment;
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
	public ValidationMessageLevel createValidationMessageLevelFromString(EDataType eDataType, String initialValue) {
		return (ValidationMessageLevel)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValidationMessageLevelToString(EDataType eDataType, Object instanceValue) {
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
