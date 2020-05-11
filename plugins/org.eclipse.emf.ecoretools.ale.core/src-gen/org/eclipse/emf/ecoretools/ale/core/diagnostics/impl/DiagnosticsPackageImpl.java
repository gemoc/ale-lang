/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.acceleo.query.ast.AstPackage;

import org.eclipse.acceleo.query.validation.type.IType;

import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;
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
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagnosticsPackageImpl extends EPackageImpl implements DiagnosticsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeNotFoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass messageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodNotFoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableNotFoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeNotFoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeMismatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableAlreadyBoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalErrorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentToSelfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assignmentToResultInVoidOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notIterableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unsupportedOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass missingReturnStatementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iTypeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType throwableEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DiagnosticsPackageImpl() {
		super(eNS_URI, DiagnosticsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DiagnosticsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DiagnosticsPackage init() {
		if (isInited) return (DiagnosticsPackage)EPackage.Registry.INSTANCE.getEPackage(DiagnosticsPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDiagnosticsPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DiagnosticsPackageImpl theDiagnosticsPackage = registeredDiagnosticsPackage instanceof DiagnosticsPackageImpl ? (DiagnosticsPackageImpl)registeredDiagnosticsPackage : new DiagnosticsPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		AstPackage.eINSTANCE.eClass();
		EcorePackage.eINSTANCE.eClass();
		GenModelPackage.eINSTANCE.eClass();
		ImplementationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theDiagnosticsPackage.createPackageContents();

		// Initialize created meta-data
		theDiagnosticsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDiagnosticsPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DiagnosticsPackage.eNS_URI, theDiagnosticsPackage);
		return theDiagnosticsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeNotFound() {
		return attributeNotFoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeNotFound_Owner() {
		return (EReference)attributeNotFoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributeNotFound_Name() {
		return (EAttribute)attributeNotFoundEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMessage() {
		return messageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMessage_Location() {
		return (EReference)messageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMessage_Stacktrace() {
		return (EReference)messageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMessage_Context() {
		return (EReference)messageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMessage_WholeCode() {
		return (EAttribute)messageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMessage_IncriminatedCode() {
		return (EAttribute)messageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMessage_Source() {
		return (EReference)messageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCodeLocation() {
		return codeLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCodeLocation_Source() {
		return (EAttribute)codeLocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCodeLocation_Line() {
		return (EAttribute)codeLocationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContext() {
		return contextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContext_Scopes() {
		return (EAttribute)contextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMethodNotFound() {
		return methodNotFoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMethodNotFound_Owner() {
		return (EReference)methodNotFoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMethodNotFound_Name() {
		return (EAttribute)methodNotFoundEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMethodNotFound_Arguments() {
		return (EAttribute)methodNotFoundEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMethodNotFound_ArgumentTypes() {
		return (EAttribute)methodNotFoundEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableNotFound() {
		return variableNotFoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVariableNotFound_Name() {
		return (EAttribute)variableNotFoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeNotFound() {
		return typeNotFoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTypeNotFound_Name() {
		return (EAttribute)typeNotFoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeMismatch() {
		return typeMismatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTypeMismatch_ExpectedTypes() {
		return (EAttribute)typeMismatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTypeMismatch_ActualTypes() {
		return (EAttribute)typeMismatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableAlreadyBound() {
		return variableAlreadyBoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVariableAlreadyBound_Name() {
		return (EAttribute)variableAlreadyBoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableAlreadyBound_DuplicateLocation() {
		return (EReference)variableAlreadyBoundEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInternalError() {
		return internalErrorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInternalError_Message() {
		return (EAttribute)internalErrorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInternalError_Cause() {
		return (EAttribute)internalErrorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssignmentToSelf() {
		return assignmentToSelfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAssignmentToResultInVoidOperation() {
		return assignmentToResultInVoidOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNotIterable() {
		return notIterableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUnsupportedOperator() {
		return unsupportedOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnsupportedOperator_Operator() {
		return (EAttribute)unsupportedOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUnsupportedOperator_Target() {
		return (EAttribute)unsupportedOperatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMissingReturnStatement() {
		return missingReturnStatementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMissingReturnStatement_Method() {
		return (EReference)missingReturnStatementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getOperator() {
		return operatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getIType() {
		return iTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getThrowable() {
		return throwableEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DiagnosticsFactory getDiagnosticsFactory() {
		return (DiagnosticsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		attributeNotFoundEClass = createEClass(ATTRIBUTE_NOT_FOUND);
		createEReference(attributeNotFoundEClass, ATTRIBUTE_NOT_FOUND__OWNER);
		createEAttribute(attributeNotFoundEClass, ATTRIBUTE_NOT_FOUND__NAME);

		messageEClass = createEClass(MESSAGE);
		createEReference(messageEClass, MESSAGE__LOCATION);
		createEReference(messageEClass, MESSAGE__STACKTRACE);
		createEReference(messageEClass, MESSAGE__CONTEXT);
		createEAttribute(messageEClass, MESSAGE__WHOLE_CODE);
		createEAttribute(messageEClass, MESSAGE__INCRIMINATED_CODE);
		createEReference(messageEClass, MESSAGE__SOURCE);

		codeLocationEClass = createEClass(CODE_LOCATION);
		createEAttribute(codeLocationEClass, CODE_LOCATION__SOURCE);
		createEAttribute(codeLocationEClass, CODE_LOCATION__LINE);

		contextEClass = createEClass(CONTEXT);
		createEAttribute(contextEClass, CONTEXT__SCOPES);

		methodNotFoundEClass = createEClass(METHOD_NOT_FOUND);
		createEReference(methodNotFoundEClass, METHOD_NOT_FOUND__OWNER);
		createEAttribute(methodNotFoundEClass, METHOD_NOT_FOUND__NAME);
		createEAttribute(methodNotFoundEClass, METHOD_NOT_FOUND__ARGUMENTS);
		createEAttribute(methodNotFoundEClass, METHOD_NOT_FOUND__ARGUMENT_TYPES);

		variableNotFoundEClass = createEClass(VARIABLE_NOT_FOUND);
		createEAttribute(variableNotFoundEClass, VARIABLE_NOT_FOUND__NAME);

		typeNotFoundEClass = createEClass(TYPE_NOT_FOUND);
		createEAttribute(typeNotFoundEClass, TYPE_NOT_FOUND__NAME);

		typeMismatchEClass = createEClass(TYPE_MISMATCH);
		createEAttribute(typeMismatchEClass, TYPE_MISMATCH__EXPECTED_TYPES);
		createEAttribute(typeMismatchEClass, TYPE_MISMATCH__ACTUAL_TYPES);

		variableAlreadyBoundEClass = createEClass(VARIABLE_ALREADY_BOUND);
		createEAttribute(variableAlreadyBoundEClass, VARIABLE_ALREADY_BOUND__NAME);
		createEReference(variableAlreadyBoundEClass, VARIABLE_ALREADY_BOUND__DUPLICATE_LOCATION);

		internalErrorEClass = createEClass(INTERNAL_ERROR);
		createEAttribute(internalErrorEClass, INTERNAL_ERROR__MESSAGE);
		createEAttribute(internalErrorEClass, INTERNAL_ERROR__CAUSE);

		assignmentToSelfEClass = createEClass(ASSIGNMENT_TO_SELF);

		assignmentToResultInVoidOperationEClass = createEClass(ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION);

		notIterableEClass = createEClass(NOT_ITERABLE);

		unsupportedOperatorEClass = createEClass(UNSUPPORTED_OPERATOR);
		createEAttribute(unsupportedOperatorEClass, UNSUPPORTED_OPERATOR__OPERATOR);
		createEAttribute(unsupportedOperatorEClass, UNSUPPORTED_OPERATOR__TARGET);

		missingReturnStatementEClass = createEClass(MISSING_RETURN_STATEMENT);
		createEReference(missingReturnStatementEClass, MISSING_RETURN_STATEMENT__METHOD);

		// Create enums
		operatorEEnum = createEEnum(OPERATOR);

		// Create data types
		iTypeEDataType = createEDataType(ITYPE);
		throwableEDataType = createEDataType(THROWABLE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		GenModelPackage theGenModelPackage = (GenModelPackage)EPackage.Registry.INSTANCE.getEPackage(GenModelPackage.eNS_URI);
		ImplementationPackage theImplementationPackage = (ImplementationPackage)EPackage.Registry.INSTANCE.getEPackage(ImplementationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		attributeNotFoundEClass.getESuperTypes().add(this.getMessage());
		methodNotFoundEClass.getESuperTypes().add(this.getMessage());
		variableNotFoundEClass.getESuperTypes().add(this.getMessage());
		typeNotFoundEClass.getESuperTypes().add(this.getMessage());
		typeMismatchEClass.getESuperTypes().add(this.getMessage());
		variableAlreadyBoundEClass.getESuperTypes().add(this.getMessage());
		internalErrorEClass.getESuperTypes().add(this.getMessage());
		assignmentToSelfEClass.getESuperTypes().add(this.getMessage());
		assignmentToResultInVoidOperationEClass.getESuperTypes().add(this.getVariableNotFound());
		notIterableEClass.getESuperTypes().add(this.getTypeMismatch());
		unsupportedOperatorEClass.getESuperTypes().add(this.getMessage());
		missingReturnStatementEClass.getESuperTypes().add(this.getMessage());

		// Initialize classes, features, and operations; add parameters
		initEClass(attributeNotFoundEClass, AttributeNotFound.class, "AttributeNotFound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeNotFound_Owner(), theEcorePackage.getEClass(), null, "owner", null, 0, 1, AttributeNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAttributeNotFound_Name(), theEcorePackage.getEString(), "name", null, 0, 1, AttributeNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(messageEClass, Message.class, "Message", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMessage_Location(), this.getCodeLocation(), null, "location", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessage_Stacktrace(), this.getCodeLocation(), null, "stacktrace", null, 0, -1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessage_Context(), this.getContext(), null, "context", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessage_WholeCode(), theEcorePackage.getEString(), "wholeCode", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMessage_IncriminatedCode(), theEcorePackage.getEString(), "incriminatedCode", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMessage_Source(), theEcorePackage.getEObject(), null, "source", null, 0, 1, Message.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(codeLocationEClass, CodeLocation.class, "CodeLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCodeLocation_Source(), theGenModelPackage.getPath(), "source", null, 0, 1, CodeLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeLocation_Line(), theEcorePackage.getEInt(), "line", null, 0, 1, CodeLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContext_Scopes(), theEcorePackage.getEJavaObject(), "scopes", null, 0, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodNotFoundEClass, MethodNotFound.class, "MethodNotFound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethodNotFound_Owner(), theImplementationPackage.getBehavioredClass(), null, "owner", null, 0, 1, MethodNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodNotFound_Name(), theEcorePackage.getEString(), "name", null, 0, 1, MethodNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodNotFound_Arguments(), theEcorePackage.getEJavaObject(), "arguments", null, 0, -1, MethodNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodNotFound_ArgumentTypes(), this.getIType(), "argumentTypes", null, 0, -1, MethodNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableNotFoundEClass, VariableNotFound.class, "VariableNotFound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableNotFound_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VariableNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeNotFoundEClass, TypeNotFound.class, "TypeNotFound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeNotFound_Name(), theEcorePackage.getEString(), "name", null, 0, 1, TypeNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeMismatchEClass, TypeMismatch.class, "TypeMismatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeMismatch_ExpectedTypes(), this.getIType(), "expectedTypes", null, 0, -1, TypeMismatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeMismatch_ActualTypes(), this.getIType(), "actualTypes", null, 0, -1, TypeMismatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableAlreadyBoundEClass, VariableAlreadyBound.class, "VariableAlreadyBound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableAlreadyBound_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VariableAlreadyBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableAlreadyBound_DuplicateLocation(), this.getCodeLocation(), null, "duplicateLocation", null, 0, 1, VariableAlreadyBound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(internalErrorEClass, org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError.class, "InternalError", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInternalError_Message(), theEcorePackage.getEString(), "message", null, 0, 1, org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInternalError_Cause(), this.getThrowable(), "cause", null, 0, 1, org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(assignmentToSelfEClass, AssignmentToSelf.class, "AssignmentToSelf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignmentToResultInVoidOperationEClass, AssignmentToResultInVoidOperation.class, "AssignmentToResultInVoidOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notIterableEClass, NotIterable.class, "NotIterable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unsupportedOperatorEClass, UnsupportedOperator.class, "UnsupportedOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnsupportedOperator_Operator(), this.getOperator(), "operator", null, 0, 1, UnsupportedOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnsupportedOperator_Target(), theEcorePackage.getEJavaObject(), "target", null, 0, 1, UnsupportedOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(missingReturnStatementEClass, MissingReturnStatement.class, "MissingReturnStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMissingReturnStatement_Method(), theImplementationPackage.getMethod(), null, "method", null, 0, 1, MissingReturnStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(operatorEEnum, Operator.class, "Operator");
		addEEnumLiteral(operatorEEnum, Operator.SUBSTRACTION);
		addEEnumLiteral(operatorEEnum, Operator.ADDITION);
		addEEnumLiteral(operatorEEnum, Operator.LOWER_THAN);
		addEEnumLiteral(operatorEEnum, Operator.GREATER_THAN);
		addEEnumLiteral(operatorEEnum, Operator.EQUAL);
		addEEnumLiteral(operatorEEnum, Operator.DOT);
		addEEnumLiteral(operatorEEnum, Operator.LOWER_OR_EQUAL);
		addEEnumLiteral(operatorEEnum, Operator.GREATER_OR_EQUAL);
		addEEnumLiteral(operatorEEnum, Operator.ASSIGNMENT);
		addEEnumLiteral(operatorEEnum, Operator.ADDITION_ASSIGNMENT);
		addEEnumLiteral(operatorEEnum, Operator.SUBSTRACTION_ASSIGNMENT);

		// Initialize data types
		initEDataType(iTypeEDataType, IType.class, "IType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(throwableEDataType, Throwable.class, "Throwable", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DiagnosticsPackageImpl
