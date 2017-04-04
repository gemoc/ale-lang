/**
 */
package org.eclipse.ecoretools.ale.implementation.impl;

import org.eclipse.ecoretools.ale.implementation.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ImplementationFactoryImpl extends EFactoryImpl implements ImplementationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ImplementationFactory init() {
		try {
			ImplementationFactory theImplementationFactory = (ImplementationFactory)EPackage.Registry.INSTANCE.getEFactory(ImplementationPackage.eNS_URI);
			if (theImplementationFactory != null) {
				return theImplementationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ImplementationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationFactoryImpl() {
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
			case ImplementationPackage.MODEL_BEHAVIOR: return createModelBehavior();
			case ImplementationPackage.EXTENDED_CLASS: return createExtendedClass();
			case ImplementationPackage.RUNTIME_CLASS: return createRuntimeClass();
			case ImplementationPackage.METHOD: return createMethod();
			case ImplementationPackage.MODEL_UNIT: return createModelUnit();
			case ImplementationPackage.ATTRIBUTE: return createAttribute();
			case ImplementationPackage.BLOCK: return createBlock();
			case ImplementationPackage.STATEMENT: return createStatement();
			case ImplementationPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
			case ImplementationPackage.ASSIGNMENT: return createAssignment();
			case ImplementationPackage.VARIABLE_ASSIGNMENT: return createVariableAssignment();
			case ImplementationPackage.FEATURE_ASSIGNMENT: return createFeatureAssignment();
			case ImplementationPackage.FEATURE_INSERT: return createFeatureInsert();
			case ImplementationPackage.FEATURE_REMOVE: return createFeatureRemove();
			case ImplementationPackage.FEATURE_PUT: return createFeaturePut();
			case ImplementationPackage.FOR_EACH: return createForEach();
			case ImplementationPackage.WHILE: return createWhile();
			case ImplementationPackage.IF: return createIf();
			case ImplementationPackage.EXPRESSION_STATEMENT: return createExpressionStatement();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelBehavior createModelBehavior() {
		ModelBehaviorImpl modelBehavior = new ModelBehaviorImpl();
		return modelBehavior;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedClass createExtendedClass() {
		ExtendedClassImpl extendedClass = new ExtendedClassImpl();
		return extendedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeClass createRuntimeClass() {
		RuntimeClassImpl runtimeClass = new RuntimeClassImpl();
		return runtimeClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethod() {
		MethodImpl method = new MethodImpl();
		return method;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelUnit createModelUnit() {
		ModelUnitImpl modelUnit = new ModelUnitImpl();
		return modelUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute createAttribute() {
		AttributeImpl attribute = new AttributeImpl();
		return attribute;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statement createStatement() {
		StatementImpl statement = new StatementImpl();
		return statement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration createVariableDeclaration() {
		VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assignment createAssignment() {
		AssignmentImpl assignment = new AssignmentImpl();
		return assignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableAssignment createVariableAssignment() {
		VariableAssignmentImpl variableAssignment = new VariableAssignmentImpl();
		return variableAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureAssignment createFeatureAssignment() {
		FeatureAssignmentImpl featureAssignment = new FeatureAssignmentImpl();
		return featureAssignment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureInsert createFeatureInsert() {
		FeatureInsertImpl featureInsert = new FeatureInsertImpl();
		return featureInsert;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureRemove createFeatureRemove() {
		FeatureRemoveImpl featureRemove = new FeatureRemoveImpl();
		return featureRemove;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeaturePut createFeaturePut() {
		FeaturePutImpl featurePut = new FeaturePutImpl();
		return featurePut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForEach createForEach() {
		ForEachImpl forEach = new ForEachImpl();
		return forEach;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public While createWhile() {
		WhileImpl while_ = new WhileImpl();
		return while_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public If createIf() {
		IfImpl if_ = new IfImpl();
		return if_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionStatement createExpressionStatement() {
		ExpressionStatementImpl expressionStatement = new ExpressionStatementImpl();
		return expressionStatement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationPackage getImplementationPackage() {
		return (ImplementationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ImplementationPackage getPackage() {
		return ImplementationPackage.eINSTANCE;
	}

} //ImplementationFactoryImpl
