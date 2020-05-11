/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;
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
			public Adapter caseTypeNotFound(TypeNotFound object) {
				return createTypeNotFoundAdapter();
			}
			@Override
			public Adapter caseTypeMismatch(TypeMismatch object) {
				return createTypeMismatchAdapter();
			}
			@Override
			public Adapter caseVariableAlreadyBound(VariableAlreadyBound object) {
				return createVariableAlreadyBoundAdapter();
			}
			@Override
			public Adapter caseInternalError(org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError object) {
				return createInternalErrorAdapter();
			}
			@Override
			public Adapter caseAssignmentToSelf(AssignmentToSelf object) {
				return createAssignmentToSelfAdapter();
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound <em>Variable Already Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound
	 * @generated
	 */
	public Adapter createVariableAlreadyBoundAdapter() {
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
	 * Creates a new adapter for an object of class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToSelf <em>Assignment To Self</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToSelf
	 * @generated
	 */
	public Adapter createAssignmentToSelfAdapter() {
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
