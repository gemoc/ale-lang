/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.acceleo.query.ast.AstPackage;

import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;

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
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Uninitialized;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined;
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
	private EClass typeMismatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableAlreadyDefinedEClass = null;

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
	private EClass prohibitedAssignmentToSelfEClass = null;

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
	private EClass classOpenedMoreThanOnceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notAnOpenableClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass openClassNotFoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typeHasNamesakesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass incorrectExtendOrderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionTypeMismatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass classExtendsItselfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass illegalAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass indirectExtensionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prohibitedInsertionToSelfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prohibitedRemovalFromSelfEClass = null;

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
	private EClass dynamicClassAlreadyDefinedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeAlreadyDefinedInBaseClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodAlreadyDefinedInBaseClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeAlreadyDefinedInCurrentClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reservedKeywordSelfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reservedKeywordResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodAlreadyDefinedInCurrentClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodParameterAlreadyDefinedEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass overriddenMethodNotFoundEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass prohibitedAssignmentToMethodParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass acceleoValidationMessageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass illegalAdditionAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass illegalSubstractionAssignmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uninitializedEClass = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType validationMessageLevelEDataType = null;

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
	public EAttribute getCodeLocation_StartPosition() {
		return (EAttribute)codeLocationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCodeLocation_EndPosition() {
		return (EAttribute)codeLocationEClass.getEStructuralFeatures().get(3);
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
	public EAttribute getTypeMismatch_TargetTypes() {
		return (EAttribute)typeMismatchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableAlreadyDefined() {
		return variableAlreadyDefinedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVariableAlreadyDefined_Name() {
		return (EAttribute)variableAlreadyDefinedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableAlreadyDefined_DuplicateLocation() {
		return (EReference)variableAlreadyDefinedEClass.getEStructuralFeatures().get(1);
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
	public EClass getProhibitedAssignmentToSelf() {
		return prohibitedAssignmentToSelfEClass;
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
	public EAttribute getUnsupportedOperator_TargetTypes() {
		return (EAttribute)unsupportedOperatorEClass.getEStructuralFeatures().get(2);
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
	public EClass getClassOpenedMoreThanOnce() {
		return classOpenedMoreThanOnceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassOpenedMoreThanOnce_CurrentDeclaration() {
		return (EReference)classOpenedMoreThanOnceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getClassOpenedMoreThanOnce_PreviousDeclaration() {
		return (EReference)classOpenedMoreThanOnceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNotAnOpenableClass() {
		return notAnOpenableClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNotAnOpenableClass_OpenClass() {
		return (EReference)notAnOpenableClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOpenClassNotFound() {
		return openClassNotFoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOpenClassNotFound_OpenClass() {
		return (EReference)openClassNotFoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTypeHasNamesakes() {
		return typeHasNamesakesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTypeHasNamesakes_Namesakes() {
		return (EReference)typeHasNamesakesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIncorrectExtendOrder() {
		return incorrectExtendOrderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIncorrectExtendOrder_SuperType() {
		return (EReference)incorrectExtendOrderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIncorrectExtendOrder_SuperSuperType() {
		return (EReference)incorrectExtendOrderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCollectionTypeMismatch() {
		return collectionTypeMismatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getClassExtendsItself() {
		return classExtendsItselfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIllegalAssignment() {
		return illegalAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIllegalAssignment_AssignedValue() {
		return (EAttribute)illegalAssignmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIndirectExtension() {
		return indirectExtensionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIndirectExtension_OpenClass() {
		return (EReference)indirectExtensionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIndirectExtension_InheritedClass() {
		return (EReference)indirectExtensionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProhibitedInsertionToSelf() {
		return prohibitedInsertionToSelfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProhibitedRemovalFromSelf() {
		return prohibitedRemovalFromSelfEClass;
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
	public EReference getTypeNotFound_AvailableEPackages() {
		return (EReference)typeNotFoundEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDynamicClassAlreadyDefined() {
		return dynamicClassAlreadyDefinedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDynamicClassAlreadyDefined_PreviousDeclaration() {
		return (EReference)dynamicClassAlreadyDefinedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDynamicClassAlreadyDefined_CurrentDeclaration() {
		return (EReference)dynamicClassAlreadyDefinedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeAlreadyDefinedInBaseClass() {
		return attributeAlreadyDefinedInBaseClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributeAlreadyDefinedInBaseClass_AttributeName() {
		return (EAttribute)attributeAlreadyDefinedInBaseClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeAlreadyDefinedInBaseClass_OpenClass() {
		return (EReference)attributeAlreadyDefinedInBaseClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeAlreadyDefinedInBaseClass_BaseClass() {
		return (EReference)attributeAlreadyDefinedInBaseClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMethodAlreadyDefinedInBaseClass() {
		return methodAlreadyDefinedInBaseClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMethodAlreadyDefinedInBaseClass_NewDefinition() {
		return (EReference)methodAlreadyDefinedInBaseClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAttributeAlreadyDefinedInCurrentClass() {
		return attributeAlreadyDefinedInCurrentClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAttributeAlreadyDefinedInCurrentClass_AttributeName() {
		return (EAttribute)attributeAlreadyDefinedInCurrentClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeAlreadyDefinedInCurrentClass_Owner() {
		return (EReference)attributeAlreadyDefinedInCurrentClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeAlreadyDefinedInCurrentClass_PreviousDeclaration() {
		return (EReference)attributeAlreadyDefinedInCurrentClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAttributeAlreadyDefinedInCurrentClass_CurrentDeclaration() {
		return (EReference)attributeAlreadyDefinedInCurrentClassEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReservedKeywordSelf() {
		return reservedKeywordSelfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getReservedKeywordResult() {
		return reservedKeywordResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMethodAlreadyDefinedInCurrentClass() {
		return methodAlreadyDefinedInCurrentClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMethodAlreadyDefinedInCurrentClass_PreviousDeclaration() {
		return (EReference)methodAlreadyDefinedInCurrentClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMethodAlreadyDefinedInCurrentClass_CurrentDeclaration() {
		return (EReference)methodAlreadyDefinedInCurrentClassEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMethodAlreadyDefinedInCurrentClass_Owner() {
		return (EReference)methodAlreadyDefinedInCurrentClassEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMethodParameterAlreadyDefined() {
		return methodParameterAlreadyDefinedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMethodParameterAlreadyDefined_ParameterName() {
		return (EAttribute)methodParameterAlreadyDefinedEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMethodParameterAlreadyDefined_Method() {
		return (EReference)methodParameterAlreadyDefinedEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOverriddenMethodNotFound() {
		return overriddenMethodNotFoundEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOverriddenMethodNotFound_OverridingMethod() {
		return (EReference)overriddenMethodNotFoundEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getOverriddenMethodNotFound_OverridingMethodOwner() {
		return (EReference)overriddenMethodNotFoundEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProhibitedAssignmentToMethodParameter() {
		return prohibitedAssignmentToMethodParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProhibitedAssignmentToMethodParameter_ParameterName() {
		return (EAttribute)prohibitedAssignmentToMethodParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAcceleoValidationMessage() {
		return acceleoValidationMessageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAcceleoValidationMessage_Message() {
		return (EAttribute)acceleoValidationMessageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAcceleoValidationMessage_Level() {
		return (EAttribute)acceleoValidationMessageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIllegalAdditionAssignment() {
		return illegalAdditionAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIllegalSubstractionAssignment() {
		return illegalSubstractionAssignmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getUninitialized() {
		return uninitializedEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getUninitialized_Name() {
		return (EAttribute)uninitializedEClass.getEStructuralFeatures().get(0);
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
	public EDataType getValidationMessageLevel() {
		return validationMessageLevelEDataType;
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
		createEAttribute(codeLocationEClass, CODE_LOCATION__START_POSITION);
		createEAttribute(codeLocationEClass, CODE_LOCATION__END_POSITION);

		contextEClass = createEClass(CONTEXT);
		createEAttribute(contextEClass, CONTEXT__SCOPES);

		methodNotFoundEClass = createEClass(METHOD_NOT_FOUND);
		createEReference(methodNotFoundEClass, METHOD_NOT_FOUND__OWNER);
		createEAttribute(methodNotFoundEClass, METHOD_NOT_FOUND__NAME);
		createEAttribute(methodNotFoundEClass, METHOD_NOT_FOUND__ARGUMENTS);
		createEAttribute(methodNotFoundEClass, METHOD_NOT_FOUND__ARGUMENT_TYPES);

		variableNotFoundEClass = createEClass(VARIABLE_NOT_FOUND);
		createEAttribute(variableNotFoundEClass, VARIABLE_NOT_FOUND__NAME);

		typeMismatchEClass = createEClass(TYPE_MISMATCH);
		createEAttribute(typeMismatchEClass, TYPE_MISMATCH__EXPECTED_TYPES);
		createEAttribute(typeMismatchEClass, TYPE_MISMATCH__ACTUAL_TYPES);
		createEAttribute(typeMismatchEClass, TYPE_MISMATCH__TARGET_TYPES);

		variableAlreadyDefinedEClass = createEClass(VARIABLE_ALREADY_DEFINED);
		createEAttribute(variableAlreadyDefinedEClass, VARIABLE_ALREADY_DEFINED__NAME);
		createEReference(variableAlreadyDefinedEClass, VARIABLE_ALREADY_DEFINED__DUPLICATE_LOCATION);

		internalErrorEClass = createEClass(INTERNAL_ERROR);
		createEAttribute(internalErrorEClass, INTERNAL_ERROR__MESSAGE);
		createEAttribute(internalErrorEClass, INTERNAL_ERROR__CAUSE);

		prohibitedAssignmentToSelfEClass = createEClass(PROHIBITED_ASSIGNMENT_TO_SELF);

		assignmentToResultInVoidOperationEClass = createEClass(ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION);

		notIterableEClass = createEClass(NOT_ITERABLE);

		unsupportedOperatorEClass = createEClass(UNSUPPORTED_OPERATOR);
		createEAttribute(unsupportedOperatorEClass, UNSUPPORTED_OPERATOR__OPERATOR);
		createEAttribute(unsupportedOperatorEClass, UNSUPPORTED_OPERATOR__TARGET);
		createEAttribute(unsupportedOperatorEClass, UNSUPPORTED_OPERATOR__TARGET_TYPES);

		missingReturnStatementEClass = createEClass(MISSING_RETURN_STATEMENT);
		createEReference(missingReturnStatementEClass, MISSING_RETURN_STATEMENT__METHOD);

		classOpenedMoreThanOnceEClass = createEClass(CLASS_OPENED_MORE_THAN_ONCE);
		createEReference(classOpenedMoreThanOnceEClass, CLASS_OPENED_MORE_THAN_ONCE__CURRENT_DECLARATION);
		createEReference(classOpenedMoreThanOnceEClass, CLASS_OPENED_MORE_THAN_ONCE__PREVIOUS_DECLARATION);

		notAnOpenableClassEClass = createEClass(NOT_AN_OPENABLE_CLASS);
		createEReference(notAnOpenableClassEClass, NOT_AN_OPENABLE_CLASS__OPEN_CLASS);

		openClassNotFoundEClass = createEClass(OPEN_CLASS_NOT_FOUND);
		createEReference(openClassNotFoundEClass, OPEN_CLASS_NOT_FOUND__OPEN_CLASS);

		typeHasNamesakesEClass = createEClass(TYPE_HAS_NAMESAKES);
		createEReference(typeHasNamesakesEClass, TYPE_HAS_NAMESAKES__NAMESAKES);

		incorrectExtendOrderEClass = createEClass(INCORRECT_EXTEND_ORDER);
		createEReference(incorrectExtendOrderEClass, INCORRECT_EXTEND_ORDER__SUPER_TYPE);
		createEReference(incorrectExtendOrderEClass, INCORRECT_EXTEND_ORDER__SUPER_SUPER_TYPE);

		collectionTypeMismatchEClass = createEClass(COLLECTION_TYPE_MISMATCH);

		classExtendsItselfEClass = createEClass(CLASS_EXTENDS_ITSELF);

		illegalAssignmentEClass = createEClass(ILLEGAL_ASSIGNMENT);
		createEAttribute(illegalAssignmentEClass, ILLEGAL_ASSIGNMENT__ASSIGNED_VALUE);

		indirectExtensionEClass = createEClass(INDIRECT_EXTENSION);
		createEReference(indirectExtensionEClass, INDIRECT_EXTENSION__OPEN_CLASS);
		createEReference(indirectExtensionEClass, INDIRECT_EXTENSION__INHERITED_CLASS);

		prohibitedInsertionToSelfEClass = createEClass(PROHIBITED_INSERTION_TO_SELF);

		prohibitedRemovalFromSelfEClass = createEClass(PROHIBITED_REMOVAL_FROM_SELF);

		typeNotFoundEClass = createEClass(TYPE_NOT_FOUND);
		createEAttribute(typeNotFoundEClass, TYPE_NOT_FOUND__NAME);
		createEReference(typeNotFoundEClass, TYPE_NOT_FOUND__AVAILABLE_EPACKAGES);

		dynamicClassAlreadyDefinedEClass = createEClass(DYNAMIC_CLASS_ALREADY_DEFINED);
		createEReference(dynamicClassAlreadyDefinedEClass, DYNAMIC_CLASS_ALREADY_DEFINED__PREVIOUS_DECLARATION);
		createEReference(dynamicClassAlreadyDefinedEClass, DYNAMIC_CLASS_ALREADY_DEFINED__CURRENT_DECLARATION);

		attributeAlreadyDefinedInBaseClassEClass = createEClass(ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS);
		createEAttribute(attributeAlreadyDefinedInBaseClassEClass, ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__ATTRIBUTE_NAME);
		createEReference(attributeAlreadyDefinedInBaseClassEClass, ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__OPEN_CLASS);
		createEReference(attributeAlreadyDefinedInBaseClassEClass, ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__BASE_CLASS);

		methodAlreadyDefinedInBaseClassEClass = createEClass(METHOD_ALREADY_DEFINED_IN_BASE_CLASS);
		createEReference(methodAlreadyDefinedInBaseClassEClass, METHOD_ALREADY_DEFINED_IN_BASE_CLASS__NEW_DEFINITION);

		attributeAlreadyDefinedInCurrentClassEClass = createEClass(ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS);
		createEAttribute(attributeAlreadyDefinedInCurrentClassEClass, ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__ATTRIBUTE_NAME);
		createEReference(attributeAlreadyDefinedInCurrentClassEClass, ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER);
		createEReference(attributeAlreadyDefinedInCurrentClassEClass, ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION);
		createEReference(attributeAlreadyDefinedInCurrentClassEClass, ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION);

		reservedKeywordSelfEClass = createEClass(RESERVED_KEYWORD_SELF);

		reservedKeywordResultEClass = createEClass(RESERVED_KEYWORD_RESULT);

		methodAlreadyDefinedInCurrentClassEClass = createEClass(METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS);
		createEReference(methodAlreadyDefinedInCurrentClassEClass, METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION);
		createEReference(methodAlreadyDefinedInCurrentClassEClass, METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION);
		createEReference(methodAlreadyDefinedInCurrentClassEClass, METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER);

		methodParameterAlreadyDefinedEClass = createEClass(METHOD_PARAMETER_ALREADY_DEFINED);
		createEAttribute(methodParameterAlreadyDefinedEClass, METHOD_PARAMETER_ALREADY_DEFINED__PARAMETER_NAME);
		createEReference(methodParameterAlreadyDefinedEClass, METHOD_PARAMETER_ALREADY_DEFINED__METHOD);

		overriddenMethodNotFoundEClass = createEClass(OVERRIDDEN_METHOD_NOT_FOUND);
		createEReference(overriddenMethodNotFoundEClass, OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD);
		createEReference(overriddenMethodNotFoundEClass, OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD_OWNER);

		prohibitedAssignmentToMethodParameterEClass = createEClass(PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER);
		createEAttribute(prohibitedAssignmentToMethodParameterEClass, PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER__PARAMETER_NAME);

		acceleoValidationMessageEClass = createEClass(ACCELEO_VALIDATION_MESSAGE);
		createEAttribute(acceleoValidationMessageEClass, ACCELEO_VALIDATION_MESSAGE__MESSAGE);
		createEAttribute(acceleoValidationMessageEClass, ACCELEO_VALIDATION_MESSAGE__LEVEL);

		illegalAdditionAssignmentEClass = createEClass(ILLEGAL_ADDITION_ASSIGNMENT);

		illegalSubstractionAssignmentEClass = createEClass(ILLEGAL_SUBSTRACTION_ASSIGNMENT);

		uninitializedEClass = createEClass(UNINITIALIZED);
		createEAttribute(uninitializedEClass, UNINITIALIZED__NAME);

		// Create enums
		operatorEEnum = createEEnum(OPERATOR);

		// Create data types
		iTypeEDataType = createEDataType(ITYPE);
		throwableEDataType = createEDataType(THROWABLE);
		validationMessageLevelEDataType = createEDataType(VALIDATION_MESSAGE_LEVEL);
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
		typeMismatchEClass.getESuperTypes().add(this.getMessage());
		variableAlreadyDefinedEClass.getESuperTypes().add(this.getMessage());
		internalErrorEClass.getESuperTypes().add(this.getMessage());
		prohibitedAssignmentToSelfEClass.getESuperTypes().add(this.getMessage());
		assignmentToResultInVoidOperationEClass.getESuperTypes().add(this.getVariableNotFound());
		notIterableEClass.getESuperTypes().add(this.getTypeMismatch());
		unsupportedOperatorEClass.getESuperTypes().add(this.getMessage());
		missingReturnStatementEClass.getESuperTypes().add(this.getMessage());
		classOpenedMoreThanOnceEClass.getESuperTypes().add(this.getMessage());
		notAnOpenableClassEClass.getESuperTypes().add(this.getMessage());
		openClassNotFoundEClass.getESuperTypes().add(this.getMessage());
		typeHasNamesakesEClass.getESuperTypes().add(this.getMessage());
		incorrectExtendOrderEClass.getESuperTypes().add(this.getMessage());
		collectionTypeMismatchEClass.getESuperTypes().add(this.getTypeMismatch());
		classExtendsItselfEClass.getESuperTypes().add(this.getMessage());
		illegalAssignmentEClass.getESuperTypes().add(this.getTypeMismatch());
		indirectExtensionEClass.getESuperTypes().add(this.getMessage());
		prohibitedInsertionToSelfEClass.getESuperTypes().add(this.getUnsupportedOperator());
		prohibitedRemovalFromSelfEClass.getESuperTypes().add(this.getUnsupportedOperator());
		typeNotFoundEClass.getESuperTypes().add(this.getMessage());
		dynamicClassAlreadyDefinedEClass.getESuperTypes().add(this.getMessage());
		attributeAlreadyDefinedInBaseClassEClass.getESuperTypes().add(this.getMessage());
		methodAlreadyDefinedInBaseClassEClass.getESuperTypes().add(this.getMessage());
		attributeAlreadyDefinedInCurrentClassEClass.getESuperTypes().add(this.getMessage());
		reservedKeywordSelfEClass.getESuperTypes().add(this.getMessage());
		reservedKeywordResultEClass.getESuperTypes().add(this.getMessage());
		methodAlreadyDefinedInCurrentClassEClass.getESuperTypes().add(this.getMessage());
		methodParameterAlreadyDefinedEClass.getESuperTypes().add(this.getMessage());
		overriddenMethodNotFoundEClass.getESuperTypes().add(this.getMessage());
		prohibitedAssignmentToMethodParameterEClass.getESuperTypes().add(this.getMessage());
		acceleoValidationMessageEClass.getESuperTypes().add(this.getMessage());
		illegalAdditionAssignmentEClass.getESuperTypes().add(this.getTypeMismatch());
		illegalSubstractionAssignmentEClass.getESuperTypes().add(this.getTypeMismatch());
		uninitializedEClass.getESuperTypes().add(this.getMessage());

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
		initEAttribute(getCodeLocation_StartPosition(), ecorePackage.getEInt(), "startPosition", null, 0, 1, CodeLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCodeLocation_EndPosition(), ecorePackage.getEInt(), "endPosition", null, 0, 1, CodeLocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextEClass, Context.class, "Context", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContext_Scopes(), theEcorePackage.getEJavaObject(), "scopes", null, 0, 1, Context.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodNotFoundEClass, MethodNotFound.class, "MethodNotFound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethodNotFound_Owner(), theImplementationPackage.getBehavioredClass(), null, "owner", null, 0, 1, MethodNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodNotFound_Name(), theEcorePackage.getEString(), "name", null, 0, 1, MethodNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodNotFound_Arguments(), theEcorePackage.getEJavaObject(), "arguments", null, 0, -1, MethodNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMethodNotFound_ArgumentTypes(), this.getIType(), "argumentTypes", null, 0, -1, MethodNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableNotFoundEClass, VariableNotFound.class, "VariableNotFound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableNotFound_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VariableNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeMismatchEClass, TypeMismatch.class, "TypeMismatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeMismatch_ExpectedTypes(), this.getIType(), "expectedTypes", null, 0, -1, TypeMismatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeMismatch_ActualTypes(), this.getIType(), "actualTypes", null, 0, -1, TypeMismatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTypeMismatch_TargetTypes(), this.getIType(), "targetTypes", null, 0, -1, TypeMismatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variableAlreadyDefinedEClass, VariableAlreadyDefined.class, "VariableAlreadyDefined", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableAlreadyDefined_Name(), theEcorePackage.getEString(), "name", null, 0, 1, VariableAlreadyDefined.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVariableAlreadyDefined_DuplicateLocation(), this.getCodeLocation(), null, "duplicateLocation", null, 0, 1, VariableAlreadyDefined.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(internalErrorEClass, org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError.class, "InternalError", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInternalError_Message(), theEcorePackage.getEString(), "message", null, 0, 1, org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInternalError_Cause(), this.getThrowable(), "cause", null, 0, 1, org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(prohibitedAssignmentToSelfEClass, ProhibitedAssignmentToSelf.class, "ProhibitedAssignmentToSelf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(assignmentToResultInVoidOperationEClass, AssignmentToResultInVoidOperation.class, "AssignmentToResultInVoidOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notIterableEClass, NotIterable.class, "NotIterable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unsupportedOperatorEClass, UnsupportedOperator.class, "UnsupportedOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUnsupportedOperator_Operator(), this.getOperator(), "operator", null, 0, 1, UnsupportedOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnsupportedOperator_Target(), theEcorePackage.getEJavaObject(), "target", null, 0, 1, UnsupportedOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getUnsupportedOperator_TargetTypes(), this.getIType(), "targetTypes", null, 0, -1, UnsupportedOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(missingReturnStatementEClass, MissingReturnStatement.class, "MissingReturnStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMissingReturnStatement_Method(), theImplementationPackage.getMethod(), null, "method", null, 0, 1, MissingReturnStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(classOpenedMoreThanOnceEClass, ClassOpenedMoreThanOnce.class, "ClassOpenedMoreThanOnce", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getClassOpenedMoreThanOnce_CurrentDeclaration(), theImplementationPackage.getExtendedClass(), null, "currentDeclaration", null, 0, 1, ClassOpenedMoreThanOnce.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getClassOpenedMoreThanOnce_PreviousDeclaration(), theImplementationPackage.getExtendedClass(), null, "previousDeclaration", null, 0, 1, ClassOpenedMoreThanOnce.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(notAnOpenableClassEClass, NotAnOpenableClass.class, "NotAnOpenableClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNotAnOpenableClass_OpenClass(), theImplementationPackage.getExtendedClass(), null, "openClass", null, 0, 1, NotAnOpenableClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(openClassNotFoundEClass, OpenClassNotFound.class, "OpenClassNotFound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOpenClassNotFound_OpenClass(), theImplementationPackage.getExtendedClass(), null, "openClass", null, 0, 1, OpenClassNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typeHasNamesakesEClass, TypeHasNamesakes.class, "TypeHasNamesakes", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTypeHasNamesakes_Namesakes(), ecorePackage.getEClassifier(), null, "namesakes", null, 0, -1, TypeHasNamesakes.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(incorrectExtendOrderEClass, IncorrectExtendOrder.class, "IncorrectExtendOrder", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIncorrectExtendOrder_SuperType(), theEcorePackage.getEClass(), null, "superType", null, 0, 1, IncorrectExtendOrder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIncorrectExtendOrder_SuperSuperType(), theEcorePackage.getEClass(), null, "superSuperType", null, 0, 1, IncorrectExtendOrder.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(collectionTypeMismatchEClass, CollectionTypeMismatch.class, "CollectionTypeMismatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(classExtendsItselfEClass, ClassExtendsItself.class, "ClassExtendsItself", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(illegalAssignmentEClass, IllegalAssignment.class, "IllegalAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIllegalAssignment_AssignedValue(), theEcorePackage.getEJavaObject(), "assignedValue", null, 0, 1, IllegalAssignment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(indirectExtensionEClass, IndirectExtension.class, "IndirectExtension", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIndirectExtension_OpenClass(), theEcorePackage.getEClass(), null, "openClass", null, 0, 1, IndirectExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIndirectExtension_InheritedClass(), theEcorePackage.getEClass(), null, "inheritedClass", null, 0, 1, IndirectExtension.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(prohibitedInsertionToSelfEClass, ProhibitedInsertionToSelf.class, "ProhibitedInsertionToSelf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(prohibitedRemovalFromSelfEClass, ProhibitedRemovalFromSelf.class, "ProhibitedRemovalFromSelf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typeNotFoundEClass, TypeNotFound.class, "TypeNotFound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypeNotFound_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTypeNotFound_AvailableEPackages(), ecorePackage.getEPackage(), null, "availableEPackages", null, 0, -1, TypeNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dynamicClassAlreadyDefinedEClass, DynamicClassAlreadyDefined.class, "DynamicClassAlreadyDefined", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDynamicClassAlreadyDefined_PreviousDeclaration(), theImplementationPackage.getRuntimeClass(), null, "previousDeclaration", null, 0, 1, DynamicClassAlreadyDefined.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDynamicClassAlreadyDefined_CurrentDeclaration(), theImplementationPackage.getRuntimeClass(), null, "currentDeclaration", null, 0, 1, DynamicClassAlreadyDefined.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeAlreadyDefinedInBaseClassEClass, AttributeAlreadyDefinedInBaseClass.class, "AttributeAlreadyDefinedInBaseClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeAlreadyDefinedInBaseClass_AttributeName(), theEcorePackage.getEString(), "attributeName", null, 0, 1, AttributeAlreadyDefinedInBaseClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeAlreadyDefinedInBaseClass_OpenClass(), theImplementationPackage.getExtendedClass(), null, "openClass", null, 0, 1, AttributeAlreadyDefinedInBaseClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeAlreadyDefinedInBaseClass_BaseClass(), theEcorePackage.getEClass(), null, "baseClass", null, 0, 1, AttributeAlreadyDefinedInBaseClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodAlreadyDefinedInBaseClassEClass, MethodAlreadyDefinedInBaseClass.class, "MethodAlreadyDefinedInBaseClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethodAlreadyDefinedInBaseClass_NewDefinition(), theImplementationPackage.getMethod(), null, "newDefinition", null, 0, 1, MethodAlreadyDefinedInBaseClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeAlreadyDefinedInCurrentClassEClass, AttributeAlreadyDefinedInCurrentClass.class, "AttributeAlreadyDefinedInCurrentClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeAlreadyDefinedInCurrentClass_AttributeName(), theEcorePackage.getEString(), "attributeName", null, 0, 1, AttributeAlreadyDefinedInCurrentClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeAlreadyDefinedInCurrentClass_Owner(), theImplementationPackage.getBehavioredClass(), null, "owner", null, 0, 1, AttributeAlreadyDefinedInCurrentClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeAlreadyDefinedInCurrentClass_PreviousDeclaration(), theImplementationPackage.getAttribute(), null, "previousDeclaration", null, 0, 1, AttributeAlreadyDefinedInCurrentClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeAlreadyDefinedInCurrentClass_CurrentDeclaration(), theImplementationPackage.getAttribute(), null, "currentDeclaration", null, 0, 1, AttributeAlreadyDefinedInCurrentClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(reservedKeywordSelfEClass, ReservedKeywordSelf.class, "ReservedKeywordSelf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reservedKeywordResultEClass, ReservedKeywordResult.class, "ReservedKeywordResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(methodAlreadyDefinedInCurrentClassEClass, MethodAlreadyDefinedInCurrentClass.class, "MethodAlreadyDefinedInCurrentClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethodAlreadyDefinedInCurrentClass_PreviousDeclaration(), theImplementationPackage.getMethod(), null, "previousDeclaration", null, 0, 1, MethodAlreadyDefinedInCurrentClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethodAlreadyDefinedInCurrentClass_CurrentDeclaration(), theImplementationPackage.getMethod(), null, "currentDeclaration", null, 0, 1, MethodAlreadyDefinedInCurrentClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethodAlreadyDefinedInCurrentClass_Owner(), theImplementationPackage.getBehavioredClass(), null, "owner", null, 0, 1, MethodAlreadyDefinedInCurrentClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(methodParameterAlreadyDefinedEClass, MethodParameterAlreadyDefined.class, "MethodParameterAlreadyDefined", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMethodParameterAlreadyDefined_ParameterName(), theEcorePackage.getEString(), "parameterName", null, 0, 1, MethodParameterAlreadyDefined.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMethodParameterAlreadyDefined_Method(), theImplementationPackage.getMethod(), null, "method", null, 0, 1, MethodParameterAlreadyDefined.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(overriddenMethodNotFoundEClass, OverriddenMethodNotFound.class, "OverriddenMethodNotFound", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOverriddenMethodNotFound_OverridingMethod(), theImplementationPackage.getMethod(), null, "overridingMethod", null, 0, 1, OverriddenMethodNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getOverriddenMethodNotFound_OverridingMethodOwner(), theImplementationPackage.getBehavioredClass(), null, "overridingMethodOwner", null, 0, 1, OverriddenMethodNotFound.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(prohibitedAssignmentToMethodParameterEClass, ProhibitedAssignmentToMethodParameter.class, "ProhibitedAssignmentToMethodParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProhibitedAssignmentToMethodParameter_ParameterName(), theEcorePackage.getEString(), "parameterName", null, 0, 1, ProhibitedAssignmentToMethodParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(acceleoValidationMessageEClass, AcceleoValidationMessage.class, "AcceleoValidationMessage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAcceleoValidationMessage_Message(), theEcorePackage.getEString(), "message", null, 0, 1, AcceleoValidationMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAcceleoValidationMessage_Level(), this.getValidationMessageLevel(), "level", null, 0, 1, AcceleoValidationMessage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(illegalAdditionAssignmentEClass, IllegalAdditionAssignment.class, "IllegalAdditionAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(illegalSubstractionAssignmentEClass, IllegalSubstractionAssignment.class, "IllegalSubstractionAssignment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(uninitializedEClass, Uninitialized.class, "Uninitialized", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUninitialized_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Uninitialized.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		initEDataType(validationMessageLevelEDataType, ValidationMessageLevel.class, "ValidationMessageLevel", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //DiagnosticsPackageImpl
