/**
 *  Copyright (c) 2017 Inria and Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Inria - initial API and implementation
 * 
 */
package org.eclipse.emf.ecoretools.ale.implementation;

import org.eclipse.acceleo.query.ast.AstPackage;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = " Copyright (c) 2017 Inria and Obeo.\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n     Inria - initial API and implementation\n";

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
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_BEHAVIOR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Units</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_BEHAVIOR__UNITS = 1;

	/**
	 * The number of structural features of the '<em>Model Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_BEHAVIOR_FEATURE_COUNT = 2;

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
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.BehavioredClassImpl <em>Behaviored Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.BehavioredClassImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getBehavioredClass()
	 * @generated
	 */
	int BEHAVIORED_CLASS = 5;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORED_CLASS__EANNOTATIONS = EcorePackage.ENAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORED_CLASS__NAME = EcorePackage.ENAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORED_CLASS__METHODS = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORED_CLASS__ATTRIBUTES = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fragment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORED_CLASS__FRAGMENT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Behaviored Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORED_CLASS_FEATURE_COUNT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORED_CLASS___GET_EANNOTATION__STRING = EcorePackage.ENAMED_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Behaviored Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIORED_CLASS_OPERATION_COUNT = EcorePackage.ENAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__EANNOTATIONS = BEHAVIORED_CLASS__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__NAME = BEHAVIORED_CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__METHODS = BEHAVIORED_CLASS__METHODS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__ATTRIBUTES = BEHAVIORED_CLASS__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Fragment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__FRAGMENT = BEHAVIORED_CLASS__FRAGMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__BASE_CLASS = BEHAVIORED_CLASS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__EXTENDS = BEHAVIORED_CLASS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS__CHILDREN = BEHAVIORED_CLASS_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Extended Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS_FEATURE_COUNT = BEHAVIORED_CLASS_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS___GET_EANNOTATION__STRING = BEHAVIORED_CLASS___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Extended Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_CLASS_OPERATION_COUNT = BEHAVIORED_CLASS_OPERATION_COUNT + 0;

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
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CLASS__EANNOTATIONS = BEHAVIORED_CLASS__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CLASS__NAME = BEHAVIORED_CLASS__NAME;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CLASS__METHODS = BEHAVIORED_CLASS__METHODS;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CLASS__ATTRIBUTES = BEHAVIORED_CLASS__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Fragment</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CLASS__FRAGMENT = BEHAVIORED_CLASS__FRAGMENT;

	/**
	 * The number of structural features of the '<em>Runtime Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CLASS_FEATURE_COUNT = BEHAVIORED_CLASS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CLASS___GET_EANNOTATION__STRING = BEHAVIORED_CLASS___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Runtime Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUNTIME_CLASS_OPERATION_COUNT = BEHAVIORED_CLASS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.MethodImpl <em>Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.MethodImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 3;

	/**
	 * The feature id for the '<em><b>Operation Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__OPERATION_REF = 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__BODY = 1;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD__TAGS = 2;

	/**
	 * The number of structural features of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ModelUnitImpl <em>Model Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ModelUnitImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getModelUnit()
	 * @generated
	 */
	int MODEL_UNIT = 4;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_UNIT__EANNOTATIONS = EcorePackage.ENAMED_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_UNIT__NAME = EcorePackage.ENAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Services</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_UNIT__SERVICES = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Class Extensions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_UNIT__CLASS_EXTENSIONS = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Class Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_UNIT__CLASS_DEFINITIONS = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Model Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_UNIT_FEATURE_COUNT = EcorePackage.ENAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_UNIT___GET_EANNOTATION__STRING = EcorePackage.ENAMED_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Model Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODEL_UNIT_OPERATION_COUNT = EcorePackage.ENAMED_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.AttributeImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 6;

	/**
	 * The feature id for the '<em><b>EAnnotations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__EANNOTATIONS = EcorePackage.EMODEL_ELEMENT__EANNOTATIONS;

	/**
	 * The feature id for the '<em><b>Feature Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__FEATURE_REF = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__INITIAL_VALUE = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = EcorePackage.EMODEL_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The operation id for the '<em>Get EAnnotation</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE___GET_EANNOTATION__STRING = EcorePackage.EMODEL_ELEMENT___GET_EANNOTATION__STRING;

	/**
	 * The number of operations of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_OPERATION_COUNT = EcorePackage.EMODEL_ELEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.StatementImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 8;

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
	int BLOCK = 7;

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
	int VARIABLE_DECLARATION = 9;

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
	int ASSIGNMENT = 10;

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
	int VARIABLE_ASSIGNMENT = 11;

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
	int FEATURE_ASSIGNMENT = 12;

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
	int FEATURE_INSERT = 13;

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
	int FEATURE_REMOVE = 14;

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
	int FEATURE_PUT = 15;

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
	int FOR_EACH = 16;

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
	int WHILE = 17;

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
	int IF = 18;

	/**
	 * The feature id for the '<em><b>Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__BLOCKS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Else</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF__ELSE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>If</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ConditionalBlockImpl <em>Conditional Block</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ConditionalBlockImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getConditionalBlock()
	 * @generated
	 */
	int CONDITIONAL_BLOCK = 19;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK__BLOCK = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Conditional Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Conditional Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_BLOCK_OPERATION_COUNT = STATEMENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ExpressionStatementImpl <em>Expression Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ExpressionStatementImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getExpressionStatement()
	 * @generated
	 */
	int EXPRESSION_STATEMENT = 20;

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
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.SwitchImpl <em>Switch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.SwitchImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getSwitch()
	 * @generated
	 */
	int SWITCH = 21;

	/**
	 * The feature id for the '<em><b>Param</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__PARAM = AstPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__CASES = AstPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Default</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH__DEFAULT = AstPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_FEATURE_COUNT = AstPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Switch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_OPERATION_COUNT = AstPackage.EXPRESSION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.CaseImpl <em>Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.CaseImpl
	 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getCase()
	 * @generated
	 */
	int CASE = 22;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__GUARD = 0;

	/**
	 * The feature id for the '<em><b>Match</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__MATCH = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE__VALUE = 2;

	/**
	 * The number of structural features of the '<em>Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CASE_OPERATION_COUNT = 0;


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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Units</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior#getUnits()
	 * @see #getModelBehavior()
	 * @generated
	 */
	EReference getModelBehavior_Units();

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
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Method
	 * @generated
	 */
	EClass getMethod();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.implementation.Method#getOperationRef <em>Operation Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Operation Ref</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Method#getOperationRef()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_OperationRef();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.Method#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Method#getBody()
	 * @see #getMethod()
	 * @generated
	 */
	EReference getMethod_Body();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.ecoretools.ale.implementation.Method#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Tags</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Method#getTags()
	 * @see #getMethod()
	 * @generated
	 */
	EAttribute getMethod_Tags();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.ModelUnit <em>Model Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model Unit</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
	 * @generated
	 */
	EClass getModelUnit();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.ecoretools.ale.implementation.ModelUnit#getServices <em>Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Services</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ModelUnit#getServices()
	 * @see #getModelUnit()
	 * @generated
	 */
	EAttribute getModelUnit_Services();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.ModelUnit#getClassExtensions <em>Class Extensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Extensions</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ModelUnit#getClassExtensions()
	 * @see #getModelUnit()
	 * @generated
	 */
	EReference getModelUnit_ClassExtensions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.ModelUnit#getClassDefinitions <em>Class Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Class Definitions</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ModelUnit#getClassDefinitions()
	 * @see #getModelUnit()
	 * @generated
	 */
	EReference getModelUnit_ClassDefinitions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass <em>Behaviored Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behaviored Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass
	 * @generated
	 */
	EClass getBehavioredClass();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass#getMethods()
	 * @see #getBehavioredClass()
	 * @generated
	 */
	EReference getBehavioredClass_Methods();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass#getAttributes()
	 * @see #getBehavioredClass()
	 * @generated
	 */
	EReference getBehavioredClass_Attributes();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass#getFragment <em>Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fragment</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass#getFragment()
	 * @see #getBehavioredClass()
	 * @generated
	 */
	EReference getBehavioredClass_Fragment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.implementation.Attribute#getFeatureRef <em>Feature Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature Ref</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Attribute#getFeatureRef()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_FeatureRef();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.Attribute#getInitialValue <em>Initial Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initial Value</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Attribute#getInitialValue()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_InitialValue();

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
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.If#getBlocks <em>Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Blocks</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.If#getBlocks()
	 * @see #getIf()
	 * @generated
	 */
	EReference getIf_Blocks();

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
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock <em>Conditional Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Block</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock
	 * @generated
	 */
	EClass getConditionalBlock();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock#getCondition()
	 * @see #getConditionalBlock()
	 * @generated
	 */
	EReference getConditionalBlock_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock#getBlock <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Block</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock#getBlock()
	 * @see #getConditionalBlock()
	 * @generated
	 */
	EReference getConditionalBlock_Block();

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
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.Switch <em>Switch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Switch
	 * @generated
	 */
	EClass getSwitch();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.Switch#getParam <em>Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Param</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Switch#getParam()
	 * @see #getSwitch()
	 * @generated
	 */
	EReference getSwitch_Param();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.implementation.Switch#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Switch#getCases()
	 * @see #getSwitch()
	 * @generated
	 */
	EReference getSwitch_Cases();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.Switch#getDefault <em>Default</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Switch#getDefault()
	 * @see #getSwitch()
	 * @generated
	 */
	EReference getSwitch_Default();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.implementation.Case <em>Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Case</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Case
	 * @generated
	 */
	EClass getCase();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.implementation.Case#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Guard</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Case#getGuard()
	 * @see #getCase()
	 * @generated
	 */
	EReference getCase_Guard();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.Case#getMatch <em>Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Match</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Case#getMatch()
	 * @see #getCase()
	 * @generated
	 */
	EReference getCase_Match();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.implementation.Case#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.implementation.Case#getValue()
	 * @see #getCase()
	 * @generated
	 */
	EReference getCase_Value();

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
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_BEHAVIOR__NAME = eINSTANCE.getModelBehavior_Name();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_BEHAVIOR__UNITS = eINSTANCE.getModelBehavior_Units();

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
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.MethodImpl <em>Method</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.MethodImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getMethod()
		 * @generated
		 */
		EClass METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em><b>Operation Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__OPERATION_REF = eINSTANCE.getMethod_OperationRef();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD__BODY = eINSTANCE.getMethod_Body();

		/**
		 * The meta object literal for the '<em><b>Tags</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD__TAGS = eINSTANCE.getMethod_Tags();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ModelUnitImpl <em>Model Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ModelUnitImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getModelUnit()
		 * @generated
		 */
		EClass MODEL_UNIT = eINSTANCE.getModelUnit();

		/**
		 * The meta object literal for the '<em><b>Services</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MODEL_UNIT__SERVICES = eINSTANCE.getModelUnit_Services();

		/**
		 * The meta object literal for the '<em><b>Class Extensions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_UNIT__CLASS_EXTENSIONS = eINSTANCE.getModelUnit_ClassExtensions();

		/**
		 * The meta object literal for the '<em><b>Class Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODEL_UNIT__CLASS_DEFINITIONS = eINSTANCE.getModelUnit_ClassDefinitions();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.BehavioredClassImpl <em>Behaviored Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.BehavioredClassImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getBehavioredClass()
		 * @generated
		 */
		EClass BEHAVIORED_CLASS = eINSTANCE.getBehavioredClass();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIORED_CLASS__METHODS = eINSTANCE.getBehavioredClass_Methods();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIORED_CLASS__ATTRIBUTES = eINSTANCE.getBehavioredClass_Attributes();

		/**
		 * The meta object literal for the '<em><b>Fragment</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIORED_CLASS__FRAGMENT = eINSTANCE.getBehavioredClass_Fragment();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.AttributeImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Feature Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__FEATURE_REF = eINSTANCE.getAttribute_FeatureRef();

		/**
		 * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__INITIAL_VALUE = eINSTANCE.getAttribute_InitialValue();

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
		 * The meta object literal for the '<em><b>Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__BLOCKS = eINSTANCE.getIf_Blocks();

		/**
		 * The meta object literal for the '<em><b>Else</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF__ELSE = eINSTANCE.getIf_Else();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ConditionalBlockImpl <em>Conditional Block</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ConditionalBlockImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getConditionalBlock()
		 * @generated
		 */
		EClass CONDITIONAL_BLOCK = eINSTANCE.getConditionalBlock();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_BLOCK__CONDITION = eINSTANCE.getConditionalBlock_Condition();

		/**
		 * The meta object literal for the '<em><b>Block</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_BLOCK__BLOCK = eINSTANCE.getConditionalBlock_Block();

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

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.SwitchImpl <em>Switch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.SwitchImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getSwitch()
		 * @generated
		 */
		EClass SWITCH = eINSTANCE.getSwitch();

		/**
		 * The meta object literal for the '<em><b>Param</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH__PARAM = eINSTANCE.getSwitch_Param();

		/**
		 * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH__CASES = eINSTANCE.getSwitch_Cases();

		/**
		 * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH__DEFAULT = eINSTANCE.getSwitch_Default();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.implementation.impl.CaseImpl <em>Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.CaseImpl
		 * @see org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationPackageImpl#getCase()
		 * @generated
		 */
		EClass CASE = eINSTANCE.getCase();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE__GUARD = eINSTANCE.getCase_Guard();

		/**
		 * The meta object literal for the '<em><b>Match</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE__MATCH = eINSTANCE.getCase_Match();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CASE__VALUE = eINSTANCE.getCase_Value();

	}

} //ImplementationPackage
