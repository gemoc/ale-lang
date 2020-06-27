/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage
 * @generated
 */
public class DiagnosticsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DiagnosticsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagnosticsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DiagnosticsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagnosticsSwitch<Adapter> modelSwitch =
		new DiagnosticsSwitch<Adapter>() {
			@Override
			public Adapter caseAttributeNotFound(AttributeNotFound object) {
				return createAttributeNotFoundAdapter();
			}
			@Override
			public Adapter caseMessage(Message object) {
				return createMessageAdapter();
			}
			@Override
			public Adapter caseCodeLocation(CodeLocation object) {
				return createCodeLocationAdapter();
			}
			@Override
			public Adapter caseContext(Context object) {
				return createContextAdapter();
			}
			@Override
			public Adapter caseMethodNotFound(MethodNotFound object) {
				return createMethodNotFoundAdapter();
			}
			@Override
			public Adapter caseVariableNotFound(VariableNotFound object) {
				return createVariableNotFoundAdapter();
			}
			@Override
			public Adapter caseTypeMismatch(TypeMismatch object) {
				return createTypeMismatchAdapter();
			}
			@Override
			public Adapter caseVariableAlreadyDefined(VariableAlreadyDefined object) {
				return createVariableAlreadyDefinedAdapter();
			}
			@Override
			public Adapter caseInternalError(org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError object) {
				return createInternalErrorAdapter();
			}
			@Override
			public Adapter caseProhibitedAssignmentToSelf(ProhibitedAssignmentToSelf object) {
				return createProhibitedAssignmentToSelfAdapter();
			}
			@Override
			public Adapter caseAssignmentToResultInVoidOperation(AssignmentToResultInVoidOperation object) {
				return createAssignmentToResultInVoidOperationAdapter();
			}
			@Override
			public Adapter caseNotIterable(NotIterable object) {
				return createNotIterableAdapter();
			}
			@Override
			public Adapter caseUnsupportedOperator(UnsupportedOperator object) {
				return createUnsupportedOperatorAdapter();
			}
			@Override
			public Adapter caseMissingReturnStatement(MissingReturnStatement object) {
				return createMissingReturnStatementAdapter();
			}
			@Override
			public Adapter caseClassOpenedMoreThanOnce(ClassOpenedMoreThanOnce object) {
				return createClassOpenedMoreThanOnceAdapter();
			}
			@Override
			public Adapter caseNotAnOpenableClass(NotAnOpenableClass object) {
				return createNotAnOpenableClassAdapter();
			}
			@Override
			public Adapter caseOpenClassNotFound(OpenClassNotFound object) {
				return createOpenClassNotFoundAdapter();
			}
			@Override
			public Adapter caseTypeHasNamesakes(TypeHasNamesakes object) {
				return createTypeHasNamesakesAdapter();
			}
			@Override
			public Adapter caseIncorrectExtendOrder(IncorrectExtendOrder object) {
				return createIncorrectExtendOrderAdapter();
			}
			@Override
			public Adapter caseCollectionTypeMismatch(CollectionTypeMismatch object) {
				return createCollectionTypeMismatchAdapter();
			}
			@Override
			public Adapter caseClassExtendsItself(ClassExtendsItself object) {
				return createClassExtendsItselfAdapter();
			}
			@Override
			public Adapter caseIllegalAssignment(IllegalAssignment object) {
				return createIllegalAssignmentAdapter();
			}
			@Override
			public Adapter caseIndirectExtension(IndirectExtension object) {
				return createIndirectExtensionAdapter();
			}
			@Override
			public Adapter caseProhibitedInsertionToSelf(ProhibitedInsertionToSelf object) {
				return createProhibitedInsertionToSelfAdapter();
			}
			@Override
			public Adapter caseProhibitedRemovalFromSelf(ProhibitedRemovalFromSelf object) {
				return createProhibitedRemovalFromSelfAdapter();
			}
			@Override
			public Adapter caseTypeNotFound(TypeNotFound object) {
				return createTypeNotFoundAdapter();
			}
			@Override
			public Adapter caseDynamicClassAlreadyDefined(DynamicClassAlreadyDefined object) {
				return createDynamicClassAlreadyDefinedAdapter();
			}
			@Override
			public Adapter caseAttributeAlreadyDefinedInBaseClass(AttributeAlreadyDefinedInBaseClass object) {
				return createAttributeAlreadyDefinedInBaseClassAdapter();
			}
			@Override
			public Adapter caseMethodAlreadyDefinedInBaseClass(MethodAlreadyDefinedInBaseClass object) {
				return createMethodAlreadyDefinedInBaseClassAdapter();
			}
			@Override
			public Adapter caseAttributeAlreadyDefinedInCurrentClass(AttributeAlreadyDefinedInCurrentClass object) {
				return createAttributeAlreadyDefinedInCurrentClassAdapter();
			}
			@Override
			public Adapter caseReservedKeywordSelf(ReservedKeywordSelf object) {
				return createReservedKeywordSelfAdapter();
			}
			@Override
			public Adapter caseReservedKeywordResult(ReservedKeywordResult object) {
				return createReservedKeywordResultAdapter();
			}
			@Override
			public Adapter caseMethodAlreadyDefinedInCurrentClass(MethodAlreadyDefinedInCurrentClass object) {
				return createMethodAlreadyDefinedInCurrentClassAdapter();
			}
			@Override
			public Adapter caseMethodParameterAlreadyDefined(MethodParameterAlreadyDefined object) {
				return createMethodParameterAlreadyDefinedAdapter();
			}
			@Override
			public Adapter caseOverriddenMethodNotFound(OverriddenMethodNotFound object) {
				return createOverriddenMethodNotFoundAdapter();
			}
			@Override
			public Adapter caseProhibitedAssignmentToMethodParameter(ProhibitedAssignmentToMethodParameter object) {
				return createProhibitedAssignmentToMethodParameterAdapter();
			}
			@Override
			public Adapter caseAcceleoValidationMessage(AcceleoValidationMessage object) {
				return createAcceleoValidationMessageAdapter();
			}
			@Override
			public Adapter caseIllegalAdditionAssignment(IllegalAdditionAssignment object) {
				return createIllegalAdditionAssignmentAdapter();
			}
			@Override
			public Adapter caseIllegalSubstractionAssignment(IllegalSubstractionAssignment object) {
				return createIllegalSubstractionAssignmentAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound <em>Attribute Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound
	 * @generated
	 */
	public Adapter createAttributeNotFoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Message
	 * @generated
	 */
	public Adapter createMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation <em>Code Location</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation
	 * @generated
	 */
	public Adapter createCodeLocationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Context
	 * @generated
	 */
	public Adapter createContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound <em>Method Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound
	 * @generated
	 */
	public Adapter createMethodNotFoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound <em>Variable Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound
	 * @generated
	 */
	public Adapter createVariableNotFoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch <em>Type Mismatch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch
	 * @generated
	 */
	public Adapter createTypeMismatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined <em>Variable Already Defined</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined
	 * @generated
	 */
	public Adapter createVariableAlreadyDefinedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError <em>Internal Error</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError
	 * @generated
	 */
	public Adapter createInternalErrorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToSelf <em>Prohibited Assignment To Self</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToSelf
	 * @generated
	 */
	public Adapter createProhibitedAssignmentToSelfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToResultInVoidOperation <em>Assignment To Result In Void Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToResultInVoidOperation
	 * @generated
	 */
	public Adapter createAssignmentToResultInVoidOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.NotIterable <em>Not Iterable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.NotIterable
	 * @generated
	 */
	public Adapter createNotIterableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator <em>Unsupported Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator
	 * @generated
	 */
	public Adapter createUnsupportedOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MissingReturnStatement <em>Missing Return Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MissingReturnStatement
	 * @generated
	 */
	public Adapter createMissingReturnStatementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce <em>Class Opened More Than Once</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce
	 * @generated
	 */
	public Adapter createClassOpenedMoreThanOnceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.NotAnOpenableClass <em>Not An Openable Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.NotAnOpenableClass
	 * @generated
	 */
	public Adapter createNotAnOpenableClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.OpenClassNotFound <em>Open Class Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.OpenClassNotFound
	 * @generated
	 */
	public Adapter createOpenClassNotFoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeHasNamesakes <em>Type Has Namesakes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeHasNamesakes
	 * @generated
	 */
	public Adapter createTypeHasNamesakesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder <em>Incorrect Extend Order</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder
	 * @generated
	 */
	public Adapter createIncorrectExtendOrderAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.CollectionTypeMismatch <em>Collection Type Mismatch</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.CollectionTypeMismatch
	 * @generated
	 */
	public Adapter createCollectionTypeMismatchAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassExtendsItself <em>Class Extends Itself</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassExtendsItself
	 * @generated
	 */
	public Adapter createClassExtendsItselfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAssignment <em>Illegal Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAssignment
	 * @generated
	 */
	public Adapter createIllegalAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension <em>Indirect Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension
	 * @generated
	 */
	public Adapter createIndirectExtensionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedInsertionToSelf <em>Prohibited Insertion To Self</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedInsertionToSelf
	 * @generated
	 */
	public Adapter createProhibitedInsertionToSelfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedRemovalFromSelf <em>Prohibited Removal From Self</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedRemovalFromSelf
	 * @generated
	 */
	public Adapter createProhibitedRemovalFromSelfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound <em>Type Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound
	 * @generated
	 */
	public Adapter createTypeNotFoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined <em>Dynamic Class Already Defined</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined
	 * @generated
	 */
	public Adapter createDynamicClassAlreadyDefinedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass <em>Attribute Already Defined In Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass
	 * @generated
	 */
	public Adapter createAttributeAlreadyDefinedInBaseClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInBaseClass <em>Method Already Defined In Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInBaseClass
	 * @generated
	 */
	public Adapter createMethodAlreadyDefinedInBaseClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass <em>Attribute Already Defined In Current Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass
	 * @generated
	 */
	public Adapter createAttributeAlreadyDefinedInCurrentClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordSelf <em>Reserved Keyword Self</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordSelf
	 * @generated
	 */
	public Adapter createReservedKeywordSelfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordResult <em>Reserved Keyword Result</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordResult
	 * @generated
	 */
	public Adapter createReservedKeywordResultAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass <em>Method Already Defined In Current Class</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass
	 * @generated
	 */
	public Adapter createMethodAlreadyDefinedInCurrentClassAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodParameterAlreadyDefined <em>Method Parameter Already Defined</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodParameterAlreadyDefined
	 * @generated
	 */
	public Adapter createMethodParameterAlreadyDefinedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound <em>Overridden Method Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound
	 * @generated
	 */
	public Adapter createOverriddenMethodNotFoundAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToMethodParameter <em>Prohibited Assignment To Method Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToMethodParameter
	 * @generated
	 */
	public Adapter createProhibitedAssignmentToMethodParameterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage <em>Acceleo Validation Message</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage
	 * @generated
	 */
	public Adapter createAcceleoValidationMessageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAdditionAssignment <em>Illegal Addition Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAdditionAssignment
	 * @generated
	 */
	public Adapter createIllegalAdditionAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalSubstractionAssignment <em>Illegal Substraction Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalSubstractionAssignment
	 * @generated
	 */
	public Adapter createIllegalSubstractionAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DiagnosticsAdapterFactory
