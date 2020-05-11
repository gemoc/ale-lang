/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsFactory
 * @model kind="package"
 * @generated
 */
public interface DiagnosticsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "diagnostics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://eclipse.org/emf/ecoretools/ale/diagnostics";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "diagnostics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagnosticsPackage eINSTANCE = org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MessageImpl <em>Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MessageImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getMessage()
	 * @generated
	 */
	int MESSAGE = 1;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__LOCATION = 0;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__STACKTRACE = 1;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__CONTEXT = 2;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__WHOLE_CODE = 3;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__INCRIMINATED_CODE = 4;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE__SOURCE = 5;

	/**
	 * The number of structural features of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeNotFoundImpl <em>Attribute Not Found</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeNotFoundImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getAttributeNotFound()
	 * @generated
	 */
	int ATTRIBUTE_NOT_FOUND = 0;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOT_FOUND__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOT_FOUND__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOT_FOUND__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOT_FOUND__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOT_FOUND__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOT_FOUND__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOT_FOUND__OWNER = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOT_FOUND__NAME = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Attribute Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOT_FOUND_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Attribute Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_NOT_FOUND_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.CodeLocationImpl <em>Code Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.CodeLocationImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getCodeLocation()
	 * @generated
	 */
	int CODE_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Source</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Line</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__LINE = 1;

	/**
	 * The number of structural features of the '<em>Code Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Code Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ContextImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getContext()
	 * @generated
	 */
	int CONTEXT = 3;

	/**
	 * The feature id for the '<em><b>Scopes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT__SCOPES = 0;

	/**
	 * The number of structural features of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodNotFoundImpl <em>Method Not Found</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodNotFoundImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getMethodNotFound()
	 * @generated
	 */
	int METHOD_NOT_FOUND = 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NOT_FOUND__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NOT_FOUND__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NOT_FOUND__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NOT_FOUND__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NOT_FOUND__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NOT_FOUND__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NOT_FOUND__OWNER = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NOT_FOUND__NAME = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NOT_FOUND__ARGUMENTS = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Argument Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NOT_FOUND__ARGUMENT_TYPES = MESSAGE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Method Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NOT_FOUND_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Method Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_NOT_FOUND_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableNotFoundImpl <em>Variable Not Found</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableNotFoundImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getVariableNotFound()
	 * @generated
	 */
	int VARIABLE_NOT_FOUND = 5;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NOT_FOUND__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NOT_FOUND__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NOT_FOUND__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NOT_FOUND__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NOT_FOUND__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NOT_FOUND__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NOT_FOUND__NAME = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NOT_FOUND_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Variable Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_NOT_FOUND_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeNotFoundImpl <em>Type Not Found</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeNotFoundImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getTypeNotFound()
	 * @generated
	 */
	int TYPE_NOT_FOUND = 6;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NOT_FOUND__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NOT_FOUND__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NOT_FOUND__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NOT_FOUND__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NOT_FOUND__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NOT_FOUND__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NOT_FOUND__NAME = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NOT_FOUND_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NOT_FOUND_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeMismatchImpl <em>Type Mismatch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeMismatchImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getTypeMismatch()
	 * @generated
	 */
	int TYPE_MISMATCH = 7;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MISMATCH__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MISMATCH__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MISMATCH__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MISMATCH__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MISMATCH__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MISMATCH__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Expected Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MISMATCH__EXPECTED_TYPES = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Actual Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MISMATCH__ACTUAL_TYPES = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Mismatch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MISMATCH_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Type Mismatch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MISMATCH_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableAlreadyBoundImpl <em>Variable Already Bound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableAlreadyBoundImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getVariableAlreadyBound()
	 * @generated
	 */
	int VARIABLE_ALREADY_BOUND = 8;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_BOUND__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_BOUND__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_BOUND__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_BOUND__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_BOUND__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_BOUND__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_BOUND__NAME = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Duplicate Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_BOUND__DUPLICATE_LOCATION = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Already Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_BOUND_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Variable Already Bound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_BOUND_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.InternalErrorImpl <em>Internal Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.InternalErrorImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getInternalError()
	 * @generated
	 */
	int INTERNAL_ERROR = 9;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ERROR__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ERROR__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ERROR__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ERROR__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ERROR__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ERROR__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ERROR__MESSAGE = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Cause</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ERROR__CAUSE = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Internal Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ERROR_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Internal Error</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_ERROR_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AssignmentToSelfImpl <em>Assignment To Self</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AssignmentToSelfImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getAssignmentToSelf()
	 * @generated
	 */
	int ASSIGNMENT_TO_SELF = 10;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_SELF__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_SELF__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_SELF__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_SELF__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_SELF__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_SELF__SOURCE = MESSAGE__SOURCE;

	/**
	 * The number of structural features of the '<em>Assignment To Self</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_SELF_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Assignment To Self</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_SELF_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AssignmentToResultInVoidOperationImpl <em>Assignment To Result In Void Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AssignmentToResultInVoidOperationImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getAssignmentToResultInVoidOperation()
	 * @generated
	 */
	int ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION = 11;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION__LOCATION = VARIABLE_NOT_FOUND__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION__STACKTRACE = VARIABLE_NOT_FOUND__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION__CONTEXT = VARIABLE_NOT_FOUND__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION__WHOLE_CODE = VARIABLE_NOT_FOUND__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION__INCRIMINATED_CODE = VARIABLE_NOT_FOUND__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION__SOURCE = VARIABLE_NOT_FOUND__SOURCE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION__NAME = VARIABLE_NOT_FOUND__NAME;

	/**
	 * The number of structural features of the '<em>Assignment To Result In Void Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION_FEATURE_COUNT = VARIABLE_NOT_FOUND_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Assignment To Result In Void Operation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION_OPERATION_COUNT = VARIABLE_NOT_FOUND_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.NotIterableImpl <em>Not Iterable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.NotIterableImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getNotIterable()
	 * @generated
	 */
	int NOT_ITERABLE = 12;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_ITERABLE__LOCATION = TYPE_MISMATCH__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_ITERABLE__STACKTRACE = TYPE_MISMATCH__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_ITERABLE__CONTEXT = TYPE_MISMATCH__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_ITERABLE__WHOLE_CODE = TYPE_MISMATCH__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_ITERABLE__INCRIMINATED_CODE = TYPE_MISMATCH__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_ITERABLE__SOURCE = TYPE_MISMATCH__SOURCE;

	/**
	 * The feature id for the '<em><b>Expected Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_ITERABLE__EXPECTED_TYPES = TYPE_MISMATCH__EXPECTED_TYPES;

	/**
	 * The feature id for the '<em><b>Actual Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_ITERABLE__ACTUAL_TYPES = TYPE_MISMATCH__ACTUAL_TYPES;

	/**
	 * The number of structural features of the '<em>Not Iterable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_ITERABLE_FEATURE_COUNT = TYPE_MISMATCH_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Not Iterable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_ITERABLE_OPERATION_COUNT = TYPE_MISMATCH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.UnsupportedOperatorImpl <em>Unsupported Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.UnsupportedOperatorImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getUnsupportedOperator()
	 * @generated
	 */
	int UNSUPPORTED_OPERATOR = 13;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED_OPERATOR__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED_OPERATOR__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED_OPERATOR__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED_OPERATOR__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED_OPERATOR__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED_OPERATOR__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED_OPERATOR__OPERATOR = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED_OPERATOR__TARGET = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unsupported Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED_OPERATOR_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Unsupported Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED_OPERATOR_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MissingReturnStatementImpl <em>Missing Return Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MissingReturnStatementImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getMissingReturnStatement()
	 * @generated
	 */
	int MISSING_RETURN_STATEMENT = 14;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_RETURN_STATEMENT__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_RETURN_STATEMENT__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_RETURN_STATEMENT__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_RETURN_STATEMENT__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_RETURN_STATEMENT__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_RETURN_STATEMENT__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_RETURN_STATEMENT__METHOD = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Missing Return Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_RETURN_STATEMENT_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Missing Return Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MISSING_RETURN_STATEMENT_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator <em>Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 15;

	/**
	 * The meta object id for the '<em>IType</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.acceleo.query.validation.type.IType
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getIType()
	 * @generated
	 */
	int ITYPE = 16;


	/**
	 * The meta object id for the '<em>Throwable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Throwable
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getThrowable()
	 * @generated
	 */
	int THROWABLE = 17;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound <em>Attribute Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Not Found</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound
	 * @generated
	 */
	EClass getAttributeNotFound();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound#getOwner()
	 * @see #getAttributeNotFound()
	 * @generated
	 */
	EReference getAttributeNotFound_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound#getName()
	 * @see #getAttributeNotFound()
	 * @generated
	 */
	EAttribute getAttributeNotFound_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Message <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Message
	 * @generated
	 */
	EClass getMessage();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Message#getLocation <em>Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Location</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Message#getLocation()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Location();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Message#getStacktrace <em>Stacktrace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Stacktrace</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Message#getStacktrace()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Stacktrace();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Message#getContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Context</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Message#getContext()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Context();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Message#getWholeCode <em>Whole Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Whole Code</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Message#getWholeCode()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_WholeCode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Message#getIncriminatedCode <em>Incriminated Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Incriminated Code</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Message#getIncriminatedCode()
	 * @see #getMessage()
	 * @generated
	 */
	EAttribute getMessage_IncriminatedCode();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Message#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Message#getSource()
	 * @see #getMessage()
	 * @generated
	 */
	EReference getMessage_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation <em>Code Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code Location</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation
	 * @generated
	 */
	EClass getCodeLocation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation#getSource()
	 * @see #getCodeLocation()
	 * @generated
	 */
	EAttribute getCodeLocation_Source();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation#getLine()
	 * @see #getCodeLocation()
	 * @generated
	 */
	EAttribute getCodeLocation_Line();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Context <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Context
	 * @generated
	 */
	EClass getContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Context#getScopes <em>Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scopes</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Context#getScopes()
	 * @see #getContext()
	 * @generated
	 */
	EAttribute getContext_Scopes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound <em>Method Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Not Found</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound
	 * @generated
	 */
	EClass getMethodNotFound();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getOwner()
	 * @see #getMethodNotFound()
	 * @generated
	 */
	EReference getMethodNotFound_Owner();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getName()
	 * @see #getMethodNotFound()
	 * @generated
	 */
	EAttribute getMethodNotFound_Name();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Arguments</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getArguments()
	 * @see #getMethodNotFound()
	 * @generated
	 */
	EAttribute getMethodNotFound_Arguments();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getArgumentTypes <em>Argument Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Argument Types</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound#getArgumentTypes()
	 * @see #getMethodNotFound()
	 * @generated
	 */
	EAttribute getMethodNotFound_ArgumentTypes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound <em>Variable Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Not Found</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound
	 * @generated
	 */
	EClass getVariableNotFound();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound#getName()
	 * @see #getVariableNotFound()
	 * @generated
	 */
	EAttribute getVariableNotFound_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound <em>Type Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Not Found</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound
	 * @generated
	 */
	EClass getTypeNotFound();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound#getName()
	 * @see #getTypeNotFound()
	 * @generated
	 */
	EAttribute getTypeNotFound_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch <em>Type Mismatch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Mismatch</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch
	 * @generated
	 */
	EClass getTypeMismatch();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch#getExpectedTypes <em>Expected Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Expected Types</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch#getExpectedTypes()
	 * @see #getTypeMismatch()
	 * @generated
	 */
	EAttribute getTypeMismatch_ExpectedTypes();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch#getActualTypes <em>Actual Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Actual Types</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch#getActualTypes()
	 * @see #getTypeMismatch()
	 * @generated
	 */
	EAttribute getTypeMismatch_ActualTypes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound <em>Variable Already Bound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Already Bound</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound
	 * @generated
	 */
	EClass getVariableAlreadyBound();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound#getName()
	 * @see #getVariableAlreadyBound()
	 * @generated
	 */
	EAttribute getVariableAlreadyBound_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound#getDuplicateLocation <em>Duplicate Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Duplicate Location</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound#getDuplicateLocation()
	 * @see #getVariableAlreadyBound()
	 * @generated
	 */
	EReference getVariableAlreadyBound_DuplicateLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError <em>Internal Error</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Error</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError
	 * @generated
	 */
	EClass getInternalError();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError#getMessage()
	 * @see #getInternalError()
	 * @generated
	 */
	EAttribute getInternalError_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError#getCause <em>Cause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cause</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError#getCause()
	 * @see #getInternalError()
	 * @generated
	 */
	EAttribute getInternalError_Cause();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToSelf <em>Assignment To Self</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment To Self</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToSelf
	 * @generated
	 */
	EClass getAssignmentToSelf();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToResultInVoidOperation <em>Assignment To Result In Void Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment To Result In Void Operation</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToResultInVoidOperation
	 * @generated
	 */
	EClass getAssignmentToResultInVoidOperation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.NotIterable <em>Not Iterable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Iterable</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.NotIterable
	 * @generated
	 */
	EClass getNotIterable();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator <em>Unsupported Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unsupported Operator</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator
	 * @generated
	 */
	EClass getUnsupportedOperator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator#getOperator()
	 * @see #getUnsupportedOperator()
	 * @generated
	 */
	EAttribute getUnsupportedOperator_Operator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator#getTarget()
	 * @see #getUnsupportedOperator()
	 * @generated
	 */
	EAttribute getUnsupportedOperator_Target();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MissingReturnStatement <em>Missing Return Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Missing Return Statement</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MissingReturnStatement
	 * @generated
	 */
	EClass getMissingReturnStatement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MissingReturnStatement#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Method</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MissingReturnStatement#getMethod()
	 * @see #getMissingReturnStatement()
	 * @generated
	 */
	EReference getMissingReturnStatement_Method();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator
	 * @generated
	 */
	EEnum getOperator();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.acceleo.query.validation.type.IType <em>IType</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>IType</em>'.
	 * @see org.eclipse.acceleo.query.validation.type.IType
	 * @model instanceClass="org.eclipse.acceleo.query.validation.type.IType"
	 * @generated
	 */
	EDataType getIType();

	/**
	 * Returns the meta object for data type '{@link java.lang.Throwable <em>Throwable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Throwable</em>'.
	 * @see java.lang.Throwable
	 * @model instanceClass="java.lang.Throwable"
	 * @generated
	 */
	EDataType getThrowable();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagnosticsFactory getDiagnosticsFactory();

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
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeNotFoundImpl <em>Attribute Not Found</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeNotFoundImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getAttributeNotFound()
		 * @generated
		 */
		EClass ATTRIBUTE_NOT_FOUND = eINSTANCE.getAttributeNotFound();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_NOT_FOUND__OWNER = eINSTANCE.getAttributeNotFound_Owner();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_NOT_FOUND__NAME = eINSTANCE.getAttributeNotFound_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MessageImpl <em>Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MessageImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getMessage()
		 * @generated
		 */
		EClass MESSAGE = eINSTANCE.getMessage();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__LOCATION = eINSTANCE.getMessage_Location();

		/**
		 * The meta object literal for the '<em><b>Stacktrace</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__STACKTRACE = eINSTANCE.getMessage_Stacktrace();

		/**
		 * The meta object literal for the '<em><b>Context</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__CONTEXT = eINSTANCE.getMessage_Context();

		/**
		 * The meta object literal for the '<em><b>Whole Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__WHOLE_CODE = eINSTANCE.getMessage_WholeCode();

		/**
		 * The meta object literal for the '<em><b>Incriminated Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE__INCRIMINATED_CODE = eINSTANCE.getMessage_IncriminatedCode();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE__SOURCE = eINSTANCE.getMessage_Source();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.CodeLocationImpl <em>Code Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.CodeLocationImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getCodeLocation()
		 * @generated
		 */
		EClass CODE_LOCATION = eINSTANCE.getCodeLocation();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_LOCATION__SOURCE = eINSTANCE.getCodeLocation_Source();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_LOCATION__LINE = eINSTANCE.getCodeLocation_Line();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ContextImpl <em>Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ContextImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getContext()
		 * @generated
		 */
		EClass CONTEXT = eINSTANCE.getContext();

		/**
		 * The meta object literal for the '<em><b>Scopes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTEXT__SCOPES = eINSTANCE.getContext_Scopes();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodNotFoundImpl <em>Method Not Found</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodNotFoundImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getMethodNotFound()
		 * @generated
		 */
		EClass METHOD_NOT_FOUND = eINSTANCE.getMethodNotFound();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_NOT_FOUND__OWNER = eINSTANCE.getMethodNotFound_Owner();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_NOT_FOUND__NAME = eINSTANCE.getMethodNotFound_Name();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_NOT_FOUND__ARGUMENTS = eINSTANCE.getMethodNotFound_Arguments();

		/**
		 * The meta object literal for the '<em><b>Argument Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_NOT_FOUND__ARGUMENT_TYPES = eINSTANCE.getMethodNotFound_ArgumentTypes();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableNotFoundImpl <em>Variable Not Found</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableNotFoundImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getVariableNotFound()
		 * @generated
		 */
		EClass VARIABLE_NOT_FOUND = eINSTANCE.getVariableNotFound();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_NOT_FOUND__NAME = eINSTANCE.getVariableNotFound_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeNotFoundImpl <em>Type Not Found</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeNotFoundImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getTypeNotFound()
		 * @generated
		 */
		EClass TYPE_NOT_FOUND = eINSTANCE.getTypeNotFound();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_NOT_FOUND__NAME = eINSTANCE.getTypeNotFound_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeMismatchImpl <em>Type Mismatch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeMismatchImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getTypeMismatch()
		 * @generated
		 */
		EClass TYPE_MISMATCH = eINSTANCE.getTypeMismatch();

		/**
		 * The meta object literal for the '<em><b>Expected Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_MISMATCH__EXPECTED_TYPES = eINSTANCE.getTypeMismatch_ExpectedTypes();

		/**
		 * The meta object literal for the '<em><b>Actual Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_MISMATCH__ACTUAL_TYPES = eINSTANCE.getTypeMismatch_ActualTypes();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableAlreadyBoundImpl <em>Variable Already Bound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableAlreadyBoundImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getVariableAlreadyBound()
		 * @generated
		 */
		EClass VARIABLE_ALREADY_BOUND = eINSTANCE.getVariableAlreadyBound();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_ALREADY_BOUND__NAME = eINSTANCE.getVariableAlreadyBound_Name();

		/**
		 * The meta object literal for the '<em><b>Duplicate Location</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ALREADY_BOUND__DUPLICATE_LOCATION = eINSTANCE.getVariableAlreadyBound_DuplicateLocation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.InternalErrorImpl <em>Internal Error</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.InternalErrorImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getInternalError()
		 * @generated
		 */
		EClass INTERNAL_ERROR = eINSTANCE.getInternalError();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_ERROR__MESSAGE = eINSTANCE.getInternalError_Message();

		/**
		 * The meta object literal for the '<em><b>Cause</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_ERROR__CAUSE = eINSTANCE.getInternalError_Cause();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AssignmentToSelfImpl <em>Assignment To Self</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AssignmentToSelfImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getAssignmentToSelf()
		 * @generated
		 */
		EClass ASSIGNMENT_TO_SELF = eINSTANCE.getAssignmentToSelf();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AssignmentToResultInVoidOperationImpl <em>Assignment To Result In Void Operation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AssignmentToResultInVoidOperationImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getAssignmentToResultInVoidOperation()
		 * @generated
		 */
		EClass ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION = eINSTANCE.getAssignmentToResultInVoidOperation();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.NotIterableImpl <em>Not Iterable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.NotIterableImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getNotIterable()
		 * @generated
		 */
		EClass NOT_ITERABLE = eINSTANCE.getNotIterable();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.UnsupportedOperatorImpl <em>Unsupported Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.UnsupportedOperatorImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getUnsupportedOperator()
		 * @generated
		 */
		EClass UNSUPPORTED_OPERATOR = eINSTANCE.getUnsupportedOperator();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNSUPPORTED_OPERATOR__OPERATOR = eINSTANCE.getUnsupportedOperator_Operator();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNSUPPORTED_OPERATOR__TARGET = eINSTANCE.getUnsupportedOperator_Target();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MissingReturnStatementImpl <em>Missing Return Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MissingReturnStatementImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getMissingReturnStatement()
		 * @generated
		 */
		EClass MISSING_RETURN_STATEMENT = eINSTANCE.getMissingReturnStatement();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MISSING_RETURN_STATEMENT__METHOD = eINSTANCE.getMissingReturnStatement_Method();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator <em>Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getOperator()
		 * @generated
		 */
		EEnum OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '<em>IType</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.acceleo.query.validation.type.IType
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getIType()
		 * @generated
		 */
		EDataType ITYPE = eINSTANCE.getIType();

		/**
		 * The meta object literal for the '<em>Throwable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Throwable
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getThrowable()
		 * @generated
		 */
		EDataType THROWABLE = eINSTANCE.getThrowable();

	}

} //DiagnosticsPackage
