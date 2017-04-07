/**
 */
package org.eclipse.emf.ecoretools.ale.implementation;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.ecoretools.ale.implementation.ImplementationFactory
 * @model kind="package"
 * @generated
 */
public interface ImplementationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "implementation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://implementation/";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "implementation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ImplementationPackage eINSTANCE = org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ModelBehaviorImpl <em>Model Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ModelBehaviorImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getModelBehavior()
	 * @generated
	 */
	int MODEL_BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>Class Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_BEHAVIOR__CLASS_EXTENSIONS = 0;

	/**
	 * The feature id for the '<em><b>Class Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_BEHAVIOR__CLASS_DEFINITIONS = 1;

	/**
	 * The feature id for the '<em><b>Services</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_BEHAVIOR__SERVICES = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_BEHAVIOR__NAME = 3;

	/**
	 * The number of structural features of the '<em>Model Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_BEHAVIOR_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Model Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_BEHAVIOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ExtendedClassImpl <em>Extended Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ExtendedClassImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getExtendedClass()
	 * @generated
	 */
	int EXTENDED_CLASS = 1;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__BASE_CLASS = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__METHODS = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__ATTRIBUTES = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__EXTENDS = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__CHILDREN = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Extended Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Extended Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.RuntimeClassImpl <em>Runtime Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.RuntimeClassImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getRuntimeClass()
	 * @generated
	 */
	int RUNTIME_CLASS = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CLASS__NAME = 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CLASS__ATTRIBUTES = 1;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CLASS__METHODS = 2;

	/**
	 * The number of structural features of the '<em>Runtime Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CLASS_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Runtime Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CLASS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.BehavioredImpl <em>Behaviored</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.BehavioredImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getBehaviored()
	 * @generated
	 */
	int BEHAVIORED = 3;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORED__BODY = 0;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORED__TAGS = 1;

	/**
	 * The number of structural features of the '<em>Behaviored</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORED_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Behaviored</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationImpl <em>Implementation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getImplementation()
	 * @generated
	 */
	int IMPLEMENTATION = 4;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__BODY = BEHAVIORED__BODY;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__TAGS = BEHAVIORED__TAGS;

	/**
	 * The feature id for the '<em><b>Operation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION__OPERATION_REF = BEHAVIORED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_FEATURE_COUNT = BEHAVIORED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Implementation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_OPERATION_COUNT = BEHAVIORED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.MethodImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 5;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__BODY = BEHAVIORED__BODY;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__TAGS = BEHAVIORED__TAGS;

	/**
	 * The feature id for the '<em><b>Operation Def</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__OPERATION_DEF = BEHAVIORED_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = BEHAVIORED_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_OPERATION_COUNT = BEHAVIORED_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.StatementImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 7;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.BlockImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 6;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.VariableDeclarationImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__NAME = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__INITIAL_VALUE = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.AssignmentImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 9;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__VALUE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.VariableAssignmentImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getVariableAssignment()
	 * @generated
	 */
	int VARIABLE_ASSIGNMENT = 10;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__VALUE = ASSIGNMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT__NAME = ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variable Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ASSIGNMENT_OPERATION_COUNT = ASSIGNMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.FeatureAssignmentImpl <em>Feature Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.FeatureAssignmentImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getFeatureAssignment()
	 * @generated
	 */
	int FEATURE_ASSIGNMENT = 11;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_ASSIGNMENT__VALUE = ASSIGNMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_ASSIGNMENT__TARGET = ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_ASSIGNMENT__TARGET_FEATURE = ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Feature Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_ASSIGNMENT_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Feature Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_ASSIGNMENT_OPERATION_COUNT = ASSIGNMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.FeatureInsertImpl <em>Feature Insert</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.FeatureInsertImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getFeatureInsert()
	 * @generated
	 */
	int FEATURE_INSERT = 12;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSERT__VALUE = ASSIGNMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSERT__TARGET = ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSERT__TARGET_FEATURE = ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Feature Insert</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSERT_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Feature Insert</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_INSERT_OPERATION_COUNT = ASSIGNMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.FeatureRemoveImpl <em>Feature Remove</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.FeatureRemoveImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getFeatureRemove()
	 * @generated
	 */
	int FEATURE_REMOVE = 13;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_REMOVE__VALUE = ASSIGNMENT__VALUE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_REMOVE__TARGET = ASSIGNMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_REMOVE__TARGET_FEATURE = ASSIGNMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Feature Remove</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_REMOVE_FEATURE_COUNT = ASSIGNMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Feature Remove</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_REMOVE_OPERATION_COUNT = ASSIGNMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.FeaturePutImpl <em>Feature Put</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.FeaturePutImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getFeaturePut()
	 * @generated
	 */
	int FEATURE_PUT = 14;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PUT__TARGET = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PUT__TARGET_FEATURE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PUT__KEY = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PUT__VALUE = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Feature Put</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PUT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Feature Put</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_PUT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ForEachImpl <em>For Each</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ForEachImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getForEach()
	 * @generated
	 */
	int FOR_EACH = 15;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH__VARIABLE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Collection Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH__COLLECTION_EXPRESSION = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH__BODY = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>For Each</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>For Each</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_EACH_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.WhileImpl <em>While</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.WhileImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getWhile()
	 * @generated
	 */
	int WHILE = 16;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE__BODY = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>While</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>While</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.IfImpl <em>If</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.IfImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getIf()
	 * @generated
	 */
	int IF = 17;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__THEN = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__ELSE = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ExpressionStatementImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getExpressionStatement()
	 * @generated
	 */
	int EXPRESSION_STATEMENT = 18;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Expression Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Expression Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_STATEMENT_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior <em>Model Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Behavior</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior
	 * @generated
	 */
	EClass getModelBehavior();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior#getClassExtensions <em>Class Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Extensions</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior#getClassExtensions()
	 * @see #getModelBehavior()
	 * @generated
	 */
	EReference getModelBehavior_ClassExtensions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior#getClassDefinitions <em>Class Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Definitions</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior#getClassDefinitions()
	 * @see #getModelBehavior()
	 * @generated
	 */
	EReference getModelBehavior_ClassDefinitions();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Services</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior#getServices()
	 * @see #getModelBehavior()
	 * @generated
	 */
	EAttribute getModelBehavior_Services();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior#getName()
	 * @see #getModelBehavior()
	 * @generated
	 */
	EAttribute getModelBehavior_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass <em>Extended Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass
	 * @generated
	 */
	EClass getExtendedClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getBaseClass <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getBaseClass()
	 * @see #getExtendedClass()
	 * @generated
	 */
	EReference getExtendedClass_BaseClass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getMethods()
	 * @see #getExtendedClass()
	 * @generated
	 */
	EReference getExtendedClass_Methods();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getAttributes()
	 * @see #getExtendedClass()
	 * @generated
	 */
	EReference getExtendedClass_Attributes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extends</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getExtends()
	 * @see #getExtendedClass()
	 * @generated
	 */
	EReference getExtendedClass_Extends();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass#getChildren()
	 * @see #getExtendedClass()
	 * @generated
	 */
	EReference getExtendedClass_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass <em>Runtime Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Runtime Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass
	 * @generated
	 */
	EClass getRuntimeClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass#getName()
	 * @see #getRuntimeClass()
	 * @generated
	 */
	EAttribute getRuntimeClass_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass#getAttributes()
	 * @see #getRuntimeClass()
	 * @generated
	 */
	EReference getRuntimeClass_Attributes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass#getMethods()
	 * @see #getRuntimeClass()
	 * @generated
	 */
	EReference getRuntimeClass_Methods();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.Behaviored <em>Behaviored</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behaviored</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Behaviored
	 * @generated
	 */
	EClass getBehaviored();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.Behaviored#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Behaviored#getBody()
	 * @see #getBehaviored()
	 * @generated
	 */
	EReference getBehaviored_Body();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.ecoretools.ale.implementation.Behaviored#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tags</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Behaviored#getTags()
	 * @see #getBehaviored()
	 * @generated
	 */
	EAttribute getBehaviored_Tags();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.Implementation <em>Implementation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implementation</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Implementation
	 * @generated
	 */
	EClass getImplementation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.implementation.Implementation#getOperationRef <em>Operation Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation Ref</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Implementation#getOperationRef()
	 * @see #getImplementation()
	 * @generated
	 */
	EReference getImplementation_OperationRef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.Method#getOperationDef <em>Operation Def</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operation Def</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Method#getOperationDef()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_OperationDef();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.Block#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Block#getStatements()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Statements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration#getName()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EAttribute getVariableDeclaration_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration#getType()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Value</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration#getInitialValue()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_InitialValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.Assignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Assignment#getValue()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment <em>Variable Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Assignment</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment
	 * @generated
	 */
	EClass getVariableAssignment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment#getName()
	 * @see #getVariableAssignment()
	 * @generated
	 */
	EAttribute getVariableAssignment_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment <em>Feature Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Assignment</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment
	 * @generated
	 */
	EClass getFeatureAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment#getTarget()
	 * @see #getFeatureAssignment()
	 * @generated
	 */
	EReference getFeatureAssignment_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment#getTargetFeature <em>Target Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Feature</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment#getTargetFeature()
	 * @see #getFeatureAssignment()
	 * @generated
	 */
	EAttribute getFeatureAssignment_TargetFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert <em>Feature Insert</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Insert</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert
	 * @generated
	 */
	EClass getFeatureInsert();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert#getTarget()
	 * @see #getFeatureInsert()
	 * @generated
	 */
	EReference getFeatureInsert_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert#getTargetFeature <em>Target Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Feature</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert#getTargetFeature()
	 * @see #getFeatureInsert()
	 * @generated
	 */
	EAttribute getFeatureInsert_TargetFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove <em>Feature Remove</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Remove</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove
	 * @generated
	 */
	EClass getFeatureRemove();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove#getTarget()
	 * @see #getFeatureRemove()
	 * @generated
	 */
	EReference getFeatureRemove_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove#getTargetFeature <em>Target Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Feature</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove#getTargetFeature()
	 * @see #getFeatureRemove()
	 * @generated
	 */
	EAttribute getFeatureRemove_TargetFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.FeaturePut <em>Feature Put</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Put</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeaturePut
	 * @generated
	 */
	EClass getFeaturePut();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.FeaturePut#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeaturePut#getTarget()
	 * @see #getFeaturePut()
	 * @generated
	 */
	EReference getFeaturePut_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.implementation.FeaturePut#getTargetFeature <em>Target Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Feature</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeaturePut#getTargetFeature()
	 * @see #getFeaturePut()
	 * @generated
	 */
	EAttribute getFeaturePut_TargetFeature();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.FeaturePut#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeaturePut#getKey()
	 * @see #getFeaturePut()
	 * @generated
	 */
	EReference getFeaturePut_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.FeaturePut#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.FeaturePut#getValue()
	 * @see #getFeaturePut()
	 * @generated
	 */
	EReference getFeaturePut_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.ForEach <em>For Each</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Each</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ForEach
	 * @generated
	 */
	EClass getForEach();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.implementation.ForEach#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ForEach#getVariable()
	 * @see #getForEach()
	 * @generated
	 */
	EAttribute getForEach_Variable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.ForEach#getCollectionExpression <em>Collection Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection Expression</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ForEach#getCollectionExpression()
	 * @see #getForEach()
	 * @generated
	 */
	EReference getForEach_CollectionExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.ForEach#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ForEach#getBody()
	 * @see #getForEach()
	 * @generated
	 */
	EReference getForEach_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.While <em>While</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.While
	 * @generated
	 */
	EClass getWhile();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.While#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.While#getCondition()
	 * @see #getWhile()
	 * @generated
	 */
	EReference getWhile_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.While#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.While#getBody()
	 * @see #getWhile()
	 * @generated
	 */
	EReference getWhile_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.If <em>If</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.If
	 * @generated
	 */
	EClass getIf();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.If#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.If#getCondition()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.If#getThen <em>Then</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.If#getThen()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Then();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.If#getElse <em>Else</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.If#getElse()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Else();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement <em>Expression Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression Statement</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement
	 * @generated
	 */
	EClass getExpressionStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement#getExpression()
	 * @see #getExpressionStatement()
	 * @generated
	 */
	EReference getExpressionStatement_Expression();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ImplementationFactory getImplementationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ModelBehaviorImpl <em>Model Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ModelBehaviorImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getModelBehavior()
		 * @generated
		 */
		EClass MODEL_BEHAVIOR = eINSTANCE.getModelBehavior();

		/**
		 * The meta object literal for the '<em><b>Class Extensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_BEHAVIOR__CLASS_EXTENSIONS = eINSTANCE.getModelBehavior_ClassExtensions();

		/**
		 * The meta object literal for the '<em><b>Class Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_BEHAVIOR__CLASS_DEFINITIONS = eINSTANCE.getModelBehavior_ClassDefinitions();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_BEHAVIOR__SERVICES = eINSTANCE.getModelBehavior_Services();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_BEHAVIOR__NAME = eINSTANCE.getModelBehavior_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ExtendedClassImpl <em>Extended Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ExtendedClassImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getExtendedClass()
		 * @generated
		 */
		EClass EXTENDED_CLASS = eINSTANCE.getExtendedClass();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_CLASS__BASE_CLASS = eINSTANCE.getExtendedClass_BaseClass();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_CLASS__METHODS = eINSTANCE.getExtendedClass_Methods();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_CLASS__ATTRIBUTES = eINSTANCE.getExtendedClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_CLASS__EXTENDS = eINSTANCE.getExtendedClass_Extends();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_CLASS__CHILDREN = eINSTANCE.getExtendedClass_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.RuntimeClassImpl <em>Runtime Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.RuntimeClassImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getRuntimeClass()
		 * @generated
		 */
		EClass RUNTIME_CLASS = eINSTANCE.getRuntimeClass();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUNTIME_CLASS__NAME = eINSTANCE.getRuntimeClass_Name();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNTIME_CLASS__ATTRIBUTES = eINSTANCE.getRuntimeClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUNTIME_CLASS__METHODS = eINSTANCE.getRuntimeClass_Methods();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.BehavioredImpl <em>Behaviored</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.BehavioredImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getBehaviored()
		 * @generated
		 */
		EClass BEHAVIORED = eINSTANCE.getBehaviored();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIORED__BODY = eINSTANCE.getBehaviored_Body();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIORED__TAGS = eINSTANCE.getBehaviored_Tags();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationImpl <em>Implementation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getImplementation()
		 * @generated
		 */
		EClass IMPLEMENTATION = eINSTANCE.getImplementation();

		/**
		 * The meta object literal for the '<em><b>Operation Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION__OPERATION_REF = eINSTANCE.getImplementation_OperationRef();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.MethodImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Operation Def</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__OPERATION_DEF = eINSTANCE.getMethod_OperationDef();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.BlockImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK__STATEMENTS = eINSTANCE.getBlock_Statements();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.StatementImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.VariableDeclarationImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DECLARATION__NAME = eINSTANCE.getVariableDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__TYPE = eINSTANCE.getVariableDeclaration_Type();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__INITIAL_VALUE = eINSTANCE.getVariableDeclaration_InitialValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.AssignmentImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__VALUE = eINSTANCE.getAssignment_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.VariableAssignmentImpl <em>Variable Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.VariableAssignmentImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getVariableAssignment()
		 * @generated
		 */
		EClass VARIABLE_ASSIGNMENT = eINSTANCE.getVariableAssignment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_ASSIGNMENT__NAME = eINSTANCE.getVariableAssignment_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.FeatureAssignmentImpl <em>Feature Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.FeatureAssignmentImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getFeatureAssignment()
		 * @generated
		 */
		EClass FEATURE_ASSIGNMENT = eINSTANCE.getFeatureAssignment();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_ASSIGNMENT__TARGET = eINSTANCE.getFeatureAssignment_Target();

		/**
		 * The meta object literal for the '<em><b>Target Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_ASSIGNMENT__TARGET_FEATURE = eINSTANCE.getFeatureAssignment_TargetFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.FeatureInsertImpl <em>Feature Insert</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.FeatureInsertImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getFeatureInsert()
		 * @generated
		 */
		EClass FEATURE_INSERT = eINSTANCE.getFeatureInsert();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_INSERT__TARGET = eINSTANCE.getFeatureInsert_Target();

		/**
		 * The meta object literal for the '<em><b>Target Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_INSERT__TARGET_FEATURE = eINSTANCE.getFeatureInsert_TargetFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.FeatureRemoveImpl <em>Feature Remove</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.FeatureRemoveImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getFeatureRemove()
		 * @generated
		 */
		EClass FEATURE_REMOVE = eINSTANCE.getFeatureRemove();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_REMOVE__TARGET = eINSTANCE.getFeatureRemove_Target();

		/**
		 * The meta object literal for the '<em><b>Target Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_REMOVE__TARGET_FEATURE = eINSTANCE.getFeatureRemove_TargetFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.FeaturePutImpl <em>Feature Put</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.FeaturePutImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getFeaturePut()
		 * @generated
		 */
		EClass FEATURE_PUT = eINSTANCE.getFeaturePut();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_PUT__TARGET = eINSTANCE.getFeaturePut_Target();

		/**
		 * The meta object literal for the '<em><b>Target Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_PUT__TARGET_FEATURE = eINSTANCE.getFeaturePut_TargetFeature();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_PUT__KEY = eINSTANCE.getFeaturePut_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_PUT__VALUE = eINSTANCE.getFeaturePut_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ForEachImpl <em>For Each</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ForEachImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getForEach()
		 * @generated
		 */
		EClass FOR_EACH = eINSTANCE.getForEach();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOR_EACH__VARIABLE = eINSTANCE.getForEach_Variable();

		/**
		 * The meta object literal for the '<em><b>Collection Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_EACH__COLLECTION_EXPRESSION = eINSTANCE.getForEach_CollectionExpression();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_EACH__BODY = eINSTANCE.getForEach_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.WhileImpl <em>While</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.WhileImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getWhile()
		 * @generated
		 */
		EClass WHILE = eINSTANCE.getWhile();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE__CONDITION = eINSTANCE.getWhile_Condition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE__BODY = eINSTANCE.getWhile_Body();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.IfImpl <em>If</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.IfImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getIf()
		 * @generated
		 */
		EClass IF = eINSTANCE.getIf();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__CONDITION = eINSTANCE.getIf_Condition();

		/**
		 * The meta object literal for the '<em><b>Then</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__THEN = eINSTANCE.getIf_Then();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__ELSE = eINSTANCE.getIf_Else();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ExpressionStatementImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getExpressionStatement()
		 * @generated
		 */
		EClass EXPRESSION_STATEMENT = eINSTANCE.getExpressionStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_STATEMENT__EXPRESSION = eINSTANCE.getExpressionStatement_Expression();

	}

} //ImplementationPackage
