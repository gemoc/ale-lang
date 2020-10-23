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
	 * The feature id for the '<em><b>Start Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__START_POSITION = 2;

	/**
	 * The feature id for the '<em><b>End Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION__END_POSITION = 3;

	/**
	 * The number of structural features of the '<em>Code Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_LOCATION_FEATURE_COUNT = 4;

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
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeMismatchImpl <em>Type Mismatch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeMismatchImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getTypeMismatch()
	 * @generated
	 */
	int TYPE_MISMATCH = 6;

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
	 * The feature id for the '<em><b>Target Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MISMATCH__TARGET_TYPES = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type Mismatch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MISMATCH_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Type Mismatch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_MISMATCH_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableAlreadyDefinedImpl <em>Variable Already Defined</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableAlreadyDefinedImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getVariableAlreadyDefined()
	 * @generated
	 */
	int VARIABLE_ALREADY_DEFINED = 7;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_DEFINED__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_DEFINED__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_DEFINED__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_DEFINED__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_DEFINED__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_DEFINED__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_DEFINED__NAME = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Duplicate Location</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_DEFINED__DUPLICATE_LOCATION = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Already Defined</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_DEFINED_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Variable Already Defined</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ALREADY_DEFINED_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.InternalErrorImpl <em>Internal Error</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.InternalErrorImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getInternalError()
	 * @generated
	 */
	int INTERNAL_ERROR = 8;

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
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedAssignmentToSelfImpl <em>Prohibited Assignment To Self</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedAssignmentToSelfImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getProhibitedAssignmentToSelf()
	 * @generated
	 */
	int PROHIBITED_ASSIGNMENT_TO_SELF = 9;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_SELF__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_SELF__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_SELF__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_SELF__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_SELF__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_SELF__SOURCE = MESSAGE__SOURCE;

	/**
	 * The number of structural features of the '<em>Prohibited Assignment To Self</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_SELF_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Prohibited Assignment To Self</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_SELF_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AssignmentToResultInVoidOperationImpl <em>Assignment To Result In Void Operation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AssignmentToResultInVoidOperationImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getAssignmentToResultInVoidOperation()
	 * @generated
	 */
	int ASSIGNMENT_TO_RESULT_IN_VOID_OPERATION = 10;

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
	int NOT_ITERABLE = 11;

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
	 * The feature id for the '<em><b>Target Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_ITERABLE__TARGET_TYPES = TYPE_MISMATCH__TARGET_TYPES;

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
	int UNSUPPORTED_OPERATOR = 12;

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
	 * The feature id for the '<em><b>Target Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED_OPERATOR__TARGET_TYPES = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Unsupported Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNSUPPORTED_OPERATOR_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 3;

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
	int MISSING_RETURN_STATEMENT = 13;

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
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ClassOpenedMoreThanOnceImpl <em>Class Opened More Than Once</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ClassOpenedMoreThanOnceImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getClassOpenedMoreThanOnce()
	 * @generated
	 */
	int CLASS_OPENED_MORE_THAN_ONCE = 14;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPENED_MORE_THAN_ONCE__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPENED_MORE_THAN_ONCE__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPENED_MORE_THAN_ONCE__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPENED_MORE_THAN_ONCE__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPENED_MORE_THAN_ONCE__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPENED_MORE_THAN_ONCE__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Current Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPENED_MORE_THAN_ONCE__CURRENT_DECLARATION = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Previous Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPENED_MORE_THAN_ONCE__PREVIOUS_DECLARATION = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Class Opened More Than Once</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPENED_MORE_THAN_ONCE_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Class Opened More Than Once</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_OPENED_MORE_THAN_ONCE_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.NotAnOpenableClassImpl <em>Not An Openable Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.NotAnOpenableClassImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getNotAnOpenableClass()
	 * @generated
	 */
	int NOT_AN_OPENABLE_CLASS = 15;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AN_OPENABLE_CLASS__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AN_OPENABLE_CLASS__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AN_OPENABLE_CLASS__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AN_OPENABLE_CLASS__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AN_OPENABLE_CLASS__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AN_OPENABLE_CLASS__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Open Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AN_OPENABLE_CLASS__OPEN_CLASS = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Not An Openable Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AN_OPENABLE_CLASS_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Not An Openable Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOT_AN_OPENABLE_CLASS_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.OpenClassNotFoundImpl <em>Open Class Not Found</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.OpenClassNotFoundImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getOpenClassNotFound()
	 * @generated
	 */
	int OPEN_CLASS_NOT_FOUND = 16;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_CLASS_NOT_FOUND__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_CLASS_NOT_FOUND__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_CLASS_NOT_FOUND__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_CLASS_NOT_FOUND__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_CLASS_NOT_FOUND__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_CLASS_NOT_FOUND__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Open Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_CLASS_NOT_FOUND__OPEN_CLASS = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Open Class Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_CLASS_NOT_FOUND_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Open Class Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_CLASS_NOT_FOUND_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeHasNamesakesImpl <em>Type Has Namesakes</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeHasNamesakesImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getTypeHasNamesakes()
	 * @generated
	 */
	int TYPE_HAS_NAMESAKES = 17;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_HAS_NAMESAKES__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_HAS_NAMESAKES__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_HAS_NAMESAKES__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_HAS_NAMESAKES__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_HAS_NAMESAKES__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_HAS_NAMESAKES__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Namesakes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_HAS_NAMESAKES__NAMESAKES = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Type Has Namesakes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_HAS_NAMESAKES_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Type Has Namesakes</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_HAS_NAMESAKES_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IncorrectExtendOrderImpl <em>Incorrect Extend Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IncorrectExtendOrderImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getIncorrectExtendOrder()
	 * @generated
	 */
	int INCORRECT_EXTEND_ORDER = 18;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCORRECT_EXTEND_ORDER__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCORRECT_EXTEND_ORDER__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCORRECT_EXTEND_ORDER__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCORRECT_EXTEND_ORDER__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCORRECT_EXTEND_ORDER__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCORRECT_EXTEND_ORDER__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Super Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCORRECT_EXTEND_ORDER__SUPER_TYPE = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Super Super Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCORRECT_EXTEND_ORDER__SUPER_SUPER_TYPE = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Incorrect Extend Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCORRECT_EXTEND_ORDER_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Incorrect Extend Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INCORRECT_EXTEND_ORDER_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.CollectionTypeMismatchImpl <em>Collection Type Mismatch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.CollectionTypeMismatchImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getCollectionTypeMismatch()
	 * @generated
	 */
	int COLLECTION_TYPE_MISMATCH = 19;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_MISMATCH__LOCATION = TYPE_MISMATCH__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_MISMATCH__STACKTRACE = TYPE_MISMATCH__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_MISMATCH__CONTEXT = TYPE_MISMATCH__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_MISMATCH__WHOLE_CODE = TYPE_MISMATCH__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_MISMATCH__INCRIMINATED_CODE = TYPE_MISMATCH__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_MISMATCH__SOURCE = TYPE_MISMATCH__SOURCE;

	/**
	 * The feature id for the '<em><b>Expected Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_MISMATCH__EXPECTED_TYPES = TYPE_MISMATCH__EXPECTED_TYPES;

	/**
	 * The feature id for the '<em><b>Actual Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_MISMATCH__ACTUAL_TYPES = TYPE_MISMATCH__ACTUAL_TYPES;

	/**
	 * The feature id for the '<em><b>Target Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_MISMATCH__TARGET_TYPES = TYPE_MISMATCH__TARGET_TYPES;

	/**
	 * The number of structural features of the '<em>Collection Type Mismatch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_MISMATCH_FEATURE_COUNT = TYPE_MISMATCH_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Collection Type Mismatch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_TYPE_MISMATCH_OPERATION_COUNT = TYPE_MISMATCH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ClassExtendsItselfImpl <em>Class Extends Itself</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ClassExtendsItselfImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getClassExtendsItself()
	 * @generated
	 */
	int CLASS_EXTENDS_ITSELF = 20;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_EXTENDS_ITSELF__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_EXTENDS_ITSELF__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_EXTENDS_ITSELF__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_EXTENDS_ITSELF__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_EXTENDS_ITSELF__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_EXTENDS_ITSELF__SOURCE = MESSAGE__SOURCE;

	/**
	 * The number of structural features of the '<em>Class Extends Itself</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_EXTENDS_ITSELF_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Class Extends Itself</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLASS_EXTENDS_ITSELF_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IllegalAssignmentImpl <em>Illegal Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IllegalAssignmentImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getIllegalAssignment()
	 * @generated
	 */
	int ILLEGAL_ASSIGNMENT = 21;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ASSIGNMENT__LOCATION = TYPE_MISMATCH__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ASSIGNMENT__STACKTRACE = TYPE_MISMATCH__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ASSIGNMENT__CONTEXT = TYPE_MISMATCH__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ASSIGNMENT__WHOLE_CODE = TYPE_MISMATCH__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ASSIGNMENT__INCRIMINATED_CODE = TYPE_MISMATCH__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ASSIGNMENT__SOURCE = TYPE_MISMATCH__SOURCE;

	/**
	 * The feature id for the '<em><b>Expected Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ASSIGNMENT__EXPECTED_TYPES = TYPE_MISMATCH__EXPECTED_TYPES;

	/**
	 * The feature id for the '<em><b>Actual Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ASSIGNMENT__ACTUAL_TYPES = TYPE_MISMATCH__ACTUAL_TYPES;

	/**
	 * The feature id for the '<em><b>Target Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ASSIGNMENT__TARGET_TYPES = TYPE_MISMATCH__TARGET_TYPES;

	/**
	 * The feature id for the '<em><b>Assigned Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ASSIGNMENT__ASSIGNED_VALUE = TYPE_MISMATCH_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Illegal Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ASSIGNMENT_FEATURE_COUNT = TYPE_MISMATCH_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Illegal Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ASSIGNMENT_OPERATION_COUNT = TYPE_MISMATCH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IndirectExtensionImpl <em>Indirect Extension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IndirectExtensionImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getIndirectExtension()
	 * @generated
	 */
	int INDIRECT_EXTENSION = 22;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_EXTENSION__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_EXTENSION__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_EXTENSION__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_EXTENSION__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_EXTENSION__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_EXTENSION__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Open Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_EXTENSION__OPEN_CLASS = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Inherited Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_EXTENSION__INHERITED_CLASS = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Indirect Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_EXTENSION_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Indirect Extension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INDIRECT_EXTENSION_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedInsertionToSelfImpl <em>Prohibited Insertion To Self</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedInsertionToSelfImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getProhibitedInsertionToSelf()
	 * @generated
	 */
	int PROHIBITED_INSERTION_TO_SELF = 23;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_INSERTION_TO_SELF__LOCATION = UNSUPPORTED_OPERATOR__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_INSERTION_TO_SELF__STACKTRACE = UNSUPPORTED_OPERATOR__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_INSERTION_TO_SELF__CONTEXT = UNSUPPORTED_OPERATOR__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_INSERTION_TO_SELF__WHOLE_CODE = UNSUPPORTED_OPERATOR__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_INSERTION_TO_SELF__INCRIMINATED_CODE = UNSUPPORTED_OPERATOR__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_INSERTION_TO_SELF__SOURCE = UNSUPPORTED_OPERATOR__SOURCE;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_INSERTION_TO_SELF__OPERATOR = UNSUPPORTED_OPERATOR__OPERATOR;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_INSERTION_TO_SELF__TARGET = UNSUPPORTED_OPERATOR__TARGET;

	/**
	 * The feature id for the '<em><b>Target Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_INSERTION_TO_SELF__TARGET_TYPES = UNSUPPORTED_OPERATOR__TARGET_TYPES;

	/**
	 * The number of structural features of the '<em>Prohibited Insertion To Self</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_INSERTION_TO_SELF_FEATURE_COUNT = UNSUPPORTED_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Prohibited Insertion To Self</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_INSERTION_TO_SELF_OPERATION_COUNT = UNSUPPORTED_OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedRemovalFromSelfImpl <em>Prohibited Removal From Self</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedRemovalFromSelfImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getProhibitedRemovalFromSelf()
	 * @generated
	 */
	int PROHIBITED_REMOVAL_FROM_SELF = 24;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_REMOVAL_FROM_SELF__LOCATION = UNSUPPORTED_OPERATOR__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_REMOVAL_FROM_SELF__STACKTRACE = UNSUPPORTED_OPERATOR__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_REMOVAL_FROM_SELF__CONTEXT = UNSUPPORTED_OPERATOR__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_REMOVAL_FROM_SELF__WHOLE_CODE = UNSUPPORTED_OPERATOR__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_REMOVAL_FROM_SELF__INCRIMINATED_CODE = UNSUPPORTED_OPERATOR__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_REMOVAL_FROM_SELF__SOURCE = UNSUPPORTED_OPERATOR__SOURCE;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_REMOVAL_FROM_SELF__OPERATOR = UNSUPPORTED_OPERATOR__OPERATOR;

	/**
	 * The feature id for the '<em><b>Target</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_REMOVAL_FROM_SELF__TARGET = UNSUPPORTED_OPERATOR__TARGET;

	/**
	 * The feature id for the '<em><b>Target Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_REMOVAL_FROM_SELF__TARGET_TYPES = UNSUPPORTED_OPERATOR__TARGET_TYPES;

	/**
	 * The number of structural features of the '<em>Prohibited Removal From Self</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_REMOVAL_FROM_SELF_FEATURE_COUNT = UNSUPPORTED_OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Prohibited Removal From Self</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_REMOVAL_FROM_SELF_OPERATION_COUNT = UNSUPPORTED_OPERATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeNotFoundImpl <em>Type Not Found</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeNotFoundImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getTypeNotFound()
	 * @generated
	 */
	int TYPE_NOT_FOUND = 25;

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
	 * The feature id for the '<em><b>Available EPackages</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NOT_FOUND__AVAILABLE_EPACKAGES = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NOT_FOUND_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Type Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_NOT_FOUND_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DynamicClassAlreadyDefinedImpl <em>Dynamic Class Already Defined</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DynamicClassAlreadyDefinedImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getDynamicClassAlreadyDefined()
	 * @generated
	 */
	int DYNAMIC_CLASS_ALREADY_DEFINED = 26;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_CLASS_ALREADY_DEFINED__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_CLASS_ALREADY_DEFINED__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_CLASS_ALREADY_DEFINED__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_CLASS_ALREADY_DEFINED__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_CLASS_ALREADY_DEFINED__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_CLASS_ALREADY_DEFINED__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Previous Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_CLASS_ALREADY_DEFINED__PREVIOUS_DECLARATION = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Current Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_CLASS_ALREADY_DEFINED__CURRENT_DECLARATION = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dynamic Class Already Defined</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_CLASS_ALREADY_DEFINED_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Dynamic Class Already Defined</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DYNAMIC_CLASS_ALREADY_DEFINED_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInBaseClassImpl <em>Attribute Already Defined In Base Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInBaseClassImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getAttributeAlreadyDefinedInBaseClass()
	 * @generated
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS = 27;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__ATTRIBUTE_NAME = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Open Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__OPEN_CLASS = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__BASE_CLASS = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Attribute Already Defined In Base Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Attribute Already Defined In Base Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodAlreadyDefinedInBaseClassImpl <em>Method Already Defined In Base Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodAlreadyDefinedInBaseClassImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getMethodAlreadyDefinedInBaseClass()
	 * @generated
	 */
	int METHOD_ALREADY_DEFINED_IN_BASE_CLASS = 28;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_BASE_CLASS__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_BASE_CLASS__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_BASE_CLASS__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_BASE_CLASS__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_BASE_CLASS__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_BASE_CLASS__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>New Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_BASE_CLASS__NEW_DEFINITION = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Method Already Defined In Base Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_BASE_CLASS_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Method Already Defined In Base Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_BASE_CLASS_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInCurrentClassImpl <em>Attribute Already Defined In Current Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInCurrentClassImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getAttributeAlreadyDefinedInCurrentClass()
	 * @generated
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS = 29;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__ATTRIBUTE_NAME = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Previous Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Current Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION = MESSAGE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Attribute Already Defined In Current Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Attribute Already Defined In Current Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ReservedKeywordSelfImpl <em>Reserved Keyword Self</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ReservedKeywordSelfImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getReservedKeywordSelf()
	 * @generated
	 */
	int RESERVED_KEYWORD_SELF = 30;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_SELF__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_SELF__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_SELF__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_SELF__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_SELF__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_SELF__SOURCE = MESSAGE__SOURCE;

	/**
	 * The number of structural features of the '<em>Reserved Keyword Self</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_SELF_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reserved Keyword Self</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_SELF_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ReservedKeywordResultImpl <em>Reserved Keyword Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ReservedKeywordResultImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getReservedKeywordResult()
	 * @generated
	 */
	int RESERVED_KEYWORD_RESULT = 31;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_RESULT__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_RESULT__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_RESULT__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_RESULT__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_RESULT__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_RESULT__SOURCE = MESSAGE__SOURCE;

	/**
	 * The number of structural features of the '<em>Reserved Keyword Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_RESULT_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Reserved Keyword Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESERVED_KEYWORD_RESULT_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodAlreadyDefinedInCurrentClassImpl <em>Method Already Defined In Current Class</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodAlreadyDefinedInCurrentClassImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getMethodAlreadyDefinedInCurrentClass()
	 * @generated
	 */
	int METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS = 32;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Previous Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Current Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Method Already Defined In Current Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Method Already Defined In Current Class</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodParameterAlreadyDefinedImpl <em>Method Parameter Already Defined</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodParameterAlreadyDefinedImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getMethodParameterAlreadyDefined()
	 * @generated
	 */
	int METHOD_PARAMETER_ALREADY_DEFINED = 33;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_PARAMETER_ALREADY_DEFINED__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_PARAMETER_ALREADY_DEFINED__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_PARAMETER_ALREADY_DEFINED__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_PARAMETER_ALREADY_DEFINED__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_PARAMETER_ALREADY_DEFINED__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_PARAMETER_ALREADY_DEFINED__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Parameter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_PARAMETER_ALREADY_DEFINED__PARAMETER_NAME = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_PARAMETER_ALREADY_DEFINED__METHOD = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Method Parameter Already Defined</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_PARAMETER_ALREADY_DEFINED_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Method Parameter Already Defined</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_PARAMETER_ALREADY_DEFINED_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.OverriddenMethodNotFoundImpl <em>Overridden Method Not Found</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.OverriddenMethodNotFoundImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getOverriddenMethodNotFound()
	 * @generated
	 */
	int OVERRIDDEN_METHOD_NOT_FOUND = 34;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDDEN_METHOD_NOT_FOUND__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDDEN_METHOD_NOT_FOUND__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDDEN_METHOD_NOT_FOUND__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDDEN_METHOD_NOT_FOUND__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDDEN_METHOD_NOT_FOUND__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDDEN_METHOD_NOT_FOUND__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Overriding Method</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Overriding Method Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD_OWNER = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Overridden Method Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDDEN_METHOD_NOT_FOUND_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Overridden Method Not Found</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OVERRIDDEN_METHOD_NOT_FOUND_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedAssignmentToMethodParameterImpl <em>Prohibited Assignment To Method Parameter</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedAssignmentToMethodParameterImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getProhibitedAssignmentToMethodParameter()
	 * @generated
	 */
	int PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER = 35;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Parameter Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER__PARAMETER_NAME = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Prohibited Assignment To Method Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Prohibited Assignment To Method Parameter</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AcceleoValidationMessageImpl <em>Acceleo Validation Message</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AcceleoValidationMessageImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getAcceleoValidationMessage()
	 * @generated
	 */
	int ACCELEO_VALIDATION_MESSAGE = 36;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCELEO_VALIDATION_MESSAGE__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCELEO_VALIDATION_MESSAGE__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCELEO_VALIDATION_MESSAGE__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCELEO_VALIDATION_MESSAGE__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCELEO_VALIDATION_MESSAGE__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCELEO_VALIDATION_MESSAGE__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCELEO_VALIDATION_MESSAGE__MESSAGE = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCELEO_VALIDATION_MESSAGE__LEVEL = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Acceleo Validation Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCELEO_VALIDATION_MESSAGE_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Acceleo Validation Message</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACCELEO_VALIDATION_MESSAGE_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IllegalAdditionAssignmentImpl <em>Illegal Addition Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IllegalAdditionAssignmentImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getIllegalAdditionAssignment()
	 * @generated
	 */
	int ILLEGAL_ADDITION_ASSIGNMENT = 37;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ADDITION_ASSIGNMENT__LOCATION = TYPE_MISMATCH__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ADDITION_ASSIGNMENT__STACKTRACE = TYPE_MISMATCH__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ADDITION_ASSIGNMENT__CONTEXT = TYPE_MISMATCH__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ADDITION_ASSIGNMENT__WHOLE_CODE = TYPE_MISMATCH__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ADDITION_ASSIGNMENT__INCRIMINATED_CODE = TYPE_MISMATCH__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ADDITION_ASSIGNMENT__SOURCE = TYPE_MISMATCH__SOURCE;

	/**
	 * The feature id for the '<em><b>Expected Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ADDITION_ASSIGNMENT__EXPECTED_TYPES = TYPE_MISMATCH__EXPECTED_TYPES;

	/**
	 * The feature id for the '<em><b>Actual Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ADDITION_ASSIGNMENT__ACTUAL_TYPES = TYPE_MISMATCH__ACTUAL_TYPES;

	/**
	 * The feature id for the '<em><b>Target Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ADDITION_ASSIGNMENT__TARGET_TYPES = TYPE_MISMATCH__TARGET_TYPES;

	/**
	 * The number of structural features of the '<em>Illegal Addition Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ADDITION_ASSIGNMENT_FEATURE_COUNT = TYPE_MISMATCH_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Illegal Addition Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_ADDITION_ASSIGNMENT_OPERATION_COUNT = TYPE_MISMATCH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IllegalSubstractionAssignmentImpl <em>Illegal Substraction Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IllegalSubstractionAssignmentImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getIllegalSubstractionAssignment()
	 * @generated
	 */
	int ILLEGAL_SUBSTRACTION_ASSIGNMENT = 38;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_SUBSTRACTION_ASSIGNMENT__LOCATION = TYPE_MISMATCH__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_SUBSTRACTION_ASSIGNMENT__STACKTRACE = TYPE_MISMATCH__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_SUBSTRACTION_ASSIGNMENT__CONTEXT = TYPE_MISMATCH__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_SUBSTRACTION_ASSIGNMENT__WHOLE_CODE = TYPE_MISMATCH__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_SUBSTRACTION_ASSIGNMENT__INCRIMINATED_CODE = TYPE_MISMATCH__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_SUBSTRACTION_ASSIGNMENT__SOURCE = TYPE_MISMATCH__SOURCE;

	/**
	 * The feature id for the '<em><b>Expected Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_SUBSTRACTION_ASSIGNMENT__EXPECTED_TYPES = TYPE_MISMATCH__EXPECTED_TYPES;

	/**
	 * The feature id for the '<em><b>Actual Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_SUBSTRACTION_ASSIGNMENT__ACTUAL_TYPES = TYPE_MISMATCH__ACTUAL_TYPES;

	/**
	 * The feature id for the '<em><b>Target Types</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_SUBSTRACTION_ASSIGNMENT__TARGET_TYPES = TYPE_MISMATCH__TARGET_TYPES;

	/**
	 * The number of structural features of the '<em>Illegal Substraction Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_SUBSTRACTION_ASSIGNMENT_FEATURE_COUNT = TYPE_MISMATCH_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Illegal Substraction Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ILLEGAL_SUBSTRACTION_ASSIGNMENT_OPERATION_COUNT = TYPE_MISMATCH_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.UninitializedImpl <em>Uninitialized</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.UninitializedImpl
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getUninitialized()
	 * @generated
	 */
	int UNINITIALIZED = 39;

	/**
	 * The feature id for the '<em><b>Location</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNINITIALIZED__LOCATION = MESSAGE__LOCATION;

	/**
	 * The feature id for the '<em><b>Stacktrace</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNINITIALIZED__STACKTRACE = MESSAGE__STACKTRACE;

	/**
	 * The feature id for the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNINITIALIZED__CONTEXT = MESSAGE__CONTEXT;

	/**
	 * The feature id for the '<em><b>Whole Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNINITIALIZED__WHOLE_CODE = MESSAGE__WHOLE_CODE;

	/**
	 * The feature id for the '<em><b>Incriminated Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNINITIALIZED__INCRIMINATED_CODE = MESSAGE__INCRIMINATED_CODE;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNINITIALIZED__SOURCE = MESSAGE__SOURCE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNINITIALIZED__NAME = MESSAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Uninitialized</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNINITIALIZED_FEATURE_COUNT = MESSAGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Uninitialized</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNINITIALIZED_OPERATION_COUNT = MESSAGE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator <em>Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 40;

	/**
	 * The meta object id for the '<em>IType</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.acceleo.query.validation.type.IType
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getIType()
	 * @generated
	 */
	int ITYPE = 41;

	/**
	 * The meta object id for the '<em>Throwable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Throwable
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getThrowable()
	 * @generated
	 */
	int THROWABLE = 42;

	/**
	 * The meta object id for the '<em>Validation Message Level</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.acceleo.query.runtime.ValidationMessageLevel
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getValidationMessageLevel()
	 * @generated
	 */
	int VALIDATION_MESSAGE_LEVEL = 43;


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
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation#getStartPosition <em>Start Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Position</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation#getStartPosition()
	 * @see #getCodeLocation()
	 * @generated
	 */
	EAttribute getCodeLocation_StartPosition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation#getEndPosition <em>End Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End Position</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation#getEndPosition()
	 * @see #getCodeLocation()
	 * @generated
	 */
	EAttribute getCodeLocation_EndPosition();

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
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch#getTargetTypes <em>Target Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Target Types</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch#getTargetTypes()
	 * @see #getTypeMismatch()
	 * @generated
	 */
	EAttribute getTypeMismatch_TargetTypes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined <em>Variable Already Defined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Already Defined</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined
	 * @generated
	 */
	EClass getVariableAlreadyDefined();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined#getName()
	 * @see #getVariableAlreadyDefined()
	 * @generated
	 */
	EAttribute getVariableAlreadyDefined_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined#getDuplicateLocation <em>Duplicate Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Duplicate Location</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined#getDuplicateLocation()
	 * @see #getVariableAlreadyDefined()
	 * @generated
	 */
	EReference getVariableAlreadyDefined_DuplicateLocation();

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
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToSelf <em>Prohibited Assignment To Self</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prohibited Assignment To Self</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToSelf
	 * @generated
	 */
	EClass getProhibitedAssignmentToSelf();

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
	 * Returns the meta object for the attribute list '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator#getTargetTypes <em>Target Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Target Types</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator#getTargetTypes()
	 * @see #getUnsupportedOperator()
	 * @generated
	 */
	EAttribute getUnsupportedOperator_TargetTypes();

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
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce <em>Class Opened More Than Once</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Opened More Than Once</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce
	 * @generated
	 */
	EClass getClassOpenedMoreThanOnce();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce#getCurrentDeclaration <em>Current Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current Declaration</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce#getCurrentDeclaration()
	 * @see #getClassOpenedMoreThanOnce()
	 * @generated
	 */
	EReference getClassOpenedMoreThanOnce_CurrentDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce#getPreviousDeclaration <em>Previous Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previous Declaration</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce#getPreviousDeclaration()
	 * @see #getClassOpenedMoreThanOnce()
	 * @generated
	 */
	EReference getClassOpenedMoreThanOnce_PreviousDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.NotAnOpenableClass <em>Not An Openable Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not An Openable Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.NotAnOpenableClass
	 * @generated
	 */
	EClass getNotAnOpenableClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.NotAnOpenableClass#getOpenClass <em>Open Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Open Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.NotAnOpenableClass#getOpenClass()
	 * @see #getNotAnOpenableClass()
	 * @generated
	 */
	EReference getNotAnOpenableClass_OpenClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.OpenClassNotFound <em>Open Class Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Class Not Found</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.OpenClassNotFound
	 * @generated
	 */
	EClass getOpenClassNotFound();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.OpenClassNotFound#getOpenClass <em>Open Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Open Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.OpenClassNotFound#getOpenClass()
	 * @see #getOpenClassNotFound()
	 * @generated
	 */
	EReference getOpenClassNotFound_OpenClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeHasNamesakes <em>Type Has Namesakes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Has Namesakes</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeHasNamesakes
	 * @generated
	 */
	EClass getTypeHasNamesakes();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeHasNamesakes#getNamesakes <em>Namesakes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Namesakes</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeHasNamesakes#getNamesakes()
	 * @see #getTypeHasNamesakes()
	 * @generated
	 */
	EReference getTypeHasNamesakes_Namesakes();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder <em>Incorrect Extend Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Incorrect Extend Order</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder
	 * @generated
	 */
	EClass getIncorrectExtendOrder();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder#getSuperType <em>Super Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Type</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder#getSuperType()
	 * @see #getIncorrectExtendOrder()
	 * @generated
	 */
	EReference getIncorrectExtendOrder_SuperType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder#getSuperSuperType <em>Super Super Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Super Super Type</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder#getSuperSuperType()
	 * @see #getIncorrectExtendOrder()
	 * @generated
	 */
	EReference getIncorrectExtendOrder_SuperSuperType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.CollectionTypeMismatch <em>Collection Type Mismatch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Type Mismatch</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.CollectionTypeMismatch
	 * @generated
	 */
	EClass getCollectionTypeMismatch();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassExtendsItself <em>Class Extends Itself</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Class Extends Itself</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassExtendsItself
	 * @generated
	 */
	EClass getClassExtendsItself();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAssignment <em>Illegal Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Illegal Assignment</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAssignment
	 * @generated
	 */
	EClass getIllegalAssignment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAssignment#getAssignedValue <em>Assigned Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Assigned Value</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAssignment#getAssignedValue()
	 * @see #getIllegalAssignment()
	 * @generated
	 */
	EAttribute getIllegalAssignment_AssignedValue();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension <em>Indirect Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Indirect Extension</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension
	 * @generated
	 */
	EClass getIndirectExtension();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension#getOpenClass <em>Open Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Open Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension#getOpenClass()
	 * @see #getIndirectExtension()
	 * @generated
	 */
	EReference getIndirectExtension_OpenClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension#getInheritedClass <em>Inherited Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Inherited Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension#getInheritedClass()
	 * @see #getIndirectExtension()
	 * @generated
	 */
	EReference getIndirectExtension_InheritedClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedInsertionToSelf <em>Prohibited Insertion To Self</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prohibited Insertion To Self</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedInsertionToSelf
	 * @generated
	 */
	EClass getProhibitedInsertionToSelf();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedRemovalFromSelf <em>Prohibited Removal From Self</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prohibited Removal From Self</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedRemovalFromSelf
	 * @generated
	 */
	EClass getProhibitedRemovalFromSelf();

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
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound#getAvailableEPackages <em>Available EPackages</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Available EPackages</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound#getAvailableEPackages()
	 * @see #getTypeNotFound()
	 * @generated
	 */
	EReference getTypeNotFound_AvailableEPackages();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined <em>Dynamic Class Already Defined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dynamic Class Already Defined</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined
	 * @generated
	 */
	EClass getDynamicClassAlreadyDefined();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined#getPreviousDeclaration <em>Previous Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previous Declaration</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined#getPreviousDeclaration()
	 * @see #getDynamicClassAlreadyDefined()
	 * @generated
	 */
	EReference getDynamicClassAlreadyDefined_PreviousDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined#getCurrentDeclaration <em>Current Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current Declaration</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined#getCurrentDeclaration()
	 * @see #getDynamicClassAlreadyDefined()
	 * @generated
	 */
	EReference getDynamicClassAlreadyDefined_CurrentDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass <em>Attribute Already Defined In Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Already Defined In Base Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass
	 * @generated
	 */
	EClass getAttributeAlreadyDefinedInBaseClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass#getAttributeName()
	 * @see #getAttributeAlreadyDefinedInBaseClass()
	 * @generated
	 */
	EAttribute getAttributeAlreadyDefinedInBaseClass_AttributeName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass#getOpenClass <em>Open Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Open Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass#getOpenClass()
	 * @see #getAttributeAlreadyDefinedInBaseClass()
	 * @generated
	 */
	EReference getAttributeAlreadyDefinedInBaseClass_OpenClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass#getBaseClass <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass#getBaseClass()
	 * @see #getAttributeAlreadyDefinedInBaseClass()
	 * @generated
	 */
	EReference getAttributeAlreadyDefinedInBaseClass_BaseClass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInBaseClass <em>Method Already Defined In Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Already Defined In Base Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInBaseClass
	 * @generated
	 */
	EClass getMethodAlreadyDefinedInBaseClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInBaseClass#getNewDefinition <em>New Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>New Definition</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInBaseClass#getNewDefinition()
	 * @see #getMethodAlreadyDefinedInBaseClass()
	 * @generated
	 */
	EReference getMethodAlreadyDefinedInBaseClass_NewDefinition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass <em>Attribute Already Defined In Current Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute Already Defined In Current Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass
	 * @generated
	 */
	EClass getAttributeAlreadyDefinedInCurrentClass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getAttributeName <em>Attribute Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attribute Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getAttributeName()
	 * @see #getAttributeAlreadyDefinedInCurrentClass()
	 * @generated
	 */
	EAttribute getAttributeAlreadyDefinedInCurrentClass_AttributeName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getOwner()
	 * @see #getAttributeAlreadyDefinedInCurrentClass()
	 * @generated
	 */
	EReference getAttributeAlreadyDefinedInCurrentClass_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getPreviousDeclaration <em>Previous Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previous Declaration</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getPreviousDeclaration()
	 * @see #getAttributeAlreadyDefinedInCurrentClass()
	 * @generated
	 */
	EReference getAttributeAlreadyDefinedInCurrentClass_PreviousDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getCurrentDeclaration <em>Current Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current Declaration</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass#getCurrentDeclaration()
	 * @see #getAttributeAlreadyDefinedInCurrentClass()
	 * @generated
	 */
	EReference getAttributeAlreadyDefinedInCurrentClass_CurrentDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordSelf <em>Reserved Keyword Self</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reserved Keyword Self</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordSelf
	 * @generated
	 */
	EClass getReservedKeywordSelf();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordResult <em>Reserved Keyword Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reserved Keyword Result</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordResult
	 * @generated
	 */
	EClass getReservedKeywordResult();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass <em>Method Already Defined In Current Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Already Defined In Current Class</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass
	 * @generated
	 */
	EClass getMethodAlreadyDefinedInCurrentClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass#getPreviousDeclaration <em>Previous Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Previous Declaration</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass#getPreviousDeclaration()
	 * @see #getMethodAlreadyDefinedInCurrentClass()
	 * @generated
	 */
	EReference getMethodAlreadyDefinedInCurrentClass_PreviousDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass#getCurrentDeclaration <em>Current Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Current Declaration</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass#getCurrentDeclaration()
	 * @see #getMethodAlreadyDefinedInCurrentClass()
	 * @generated
	 */
	EReference getMethodAlreadyDefinedInCurrentClass_CurrentDeclaration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass#getOwner()
	 * @see #getMethodAlreadyDefinedInCurrentClass()
	 * @generated
	 */
	EReference getMethodAlreadyDefinedInCurrentClass_Owner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodParameterAlreadyDefined <em>Method Parameter Already Defined</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Parameter Already Defined</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodParameterAlreadyDefined
	 * @generated
	 */
	EClass getMethodParameterAlreadyDefined();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodParameterAlreadyDefined#getParameterName <em>Parameter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodParameterAlreadyDefined#getParameterName()
	 * @see #getMethodParameterAlreadyDefined()
	 * @generated
	 */
	EAttribute getMethodParameterAlreadyDefined_ParameterName();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodParameterAlreadyDefined#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Method</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodParameterAlreadyDefined#getMethod()
	 * @see #getMethodParameterAlreadyDefined()
	 * @generated
	 */
	EReference getMethodParameterAlreadyDefined_Method();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound <em>Overridden Method Not Found</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Overridden Method Not Found</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound
	 * @generated
	 */
	EClass getOverriddenMethodNotFound();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound#getOverridingMethod <em>Overriding Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Overriding Method</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound#getOverridingMethod()
	 * @see #getOverriddenMethodNotFound()
	 * @generated
	 */
	EReference getOverriddenMethodNotFound_OverridingMethod();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound#getOverridingMethodOwner <em>Overriding Method Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Overriding Method Owner</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound#getOverridingMethodOwner()
	 * @see #getOverriddenMethodNotFound()
	 * @generated
	 */
	EReference getOverriddenMethodNotFound_OverridingMethodOwner();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToMethodParameter <em>Prohibited Assignment To Method Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prohibited Assignment To Method Parameter</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToMethodParameter
	 * @generated
	 */
	EClass getProhibitedAssignmentToMethodParameter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToMethodParameter#getParameterName <em>Parameter Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToMethodParameter#getParameterName()
	 * @see #getProhibitedAssignmentToMethodParameter()
	 * @generated
	 */
	EAttribute getProhibitedAssignmentToMethodParameter_ParameterName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage <em>Acceleo Validation Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Acceleo Validation Message</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage
	 * @generated
	 */
	EClass getAcceleoValidationMessage();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage#getMessage()
	 * @see #getAcceleoValidationMessage()
	 * @generated
	 */
	EAttribute getAcceleoValidationMessage_Message();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage#getLevel()
	 * @see #getAcceleoValidationMessage()
	 * @generated
	 */
	EAttribute getAcceleoValidationMessage_Level();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAdditionAssignment <em>Illegal Addition Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Illegal Addition Assignment</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAdditionAssignment
	 * @generated
	 */
	EClass getIllegalAdditionAssignment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalSubstractionAssignment <em>Illegal Substraction Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Illegal Substraction Assignment</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalSubstractionAssignment
	 * @generated
	 */
	EClass getIllegalSubstractionAssignment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Uninitialized <em>Uninitialized</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Uninitialized</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Uninitialized
	 * @generated
	 */
	EClass getUninitialized();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.Uninitialized#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.Uninitialized#getName()
	 * @see #getUninitialized()
	 * @generated
	 */
	EAttribute getUninitialized_Name();

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
	 * Returns the meta object for data type '{@link org.eclipse.acceleo.query.runtime.ValidationMessageLevel <em>Validation Message Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Validation Message Level</em>'.
	 * @see org.eclipse.acceleo.query.runtime.ValidationMessageLevel
	 * @model instanceClass="org.eclipse.acceleo.query.runtime.ValidationMessageLevel"
	 * @generated
	 */
	EDataType getValidationMessageLevel();

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
		 * The meta object literal for the '<em><b>Start Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_LOCATION__START_POSITION = eINSTANCE.getCodeLocation_StartPosition();

		/**
		 * The meta object literal for the '<em><b>End Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CODE_LOCATION__END_POSITION = eINSTANCE.getCodeLocation_EndPosition();

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
		 * The meta object literal for the '<em><b>Target Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_MISMATCH__TARGET_TYPES = eINSTANCE.getTypeMismatch_TargetTypes();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableAlreadyDefinedImpl <em>Variable Already Defined</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableAlreadyDefinedImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getVariableAlreadyDefined()
		 * @generated
		 */
		EClass VARIABLE_ALREADY_DEFINED = eINSTANCE.getVariableAlreadyDefined();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_ALREADY_DEFINED__NAME = eINSTANCE.getVariableAlreadyDefined_Name();

		/**
		 * The meta object literal for the '<em><b>Duplicate Location</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ALREADY_DEFINED__DUPLICATE_LOCATION = eINSTANCE.getVariableAlreadyDefined_DuplicateLocation();

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
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedAssignmentToSelfImpl <em>Prohibited Assignment To Self</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedAssignmentToSelfImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getProhibitedAssignmentToSelf()
		 * @generated
		 */
		EClass PROHIBITED_ASSIGNMENT_TO_SELF = eINSTANCE.getProhibitedAssignmentToSelf();

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
		 * The meta object literal for the '<em><b>Target Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNSUPPORTED_OPERATOR__TARGET_TYPES = eINSTANCE.getUnsupportedOperator_TargetTypes();

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
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ClassOpenedMoreThanOnceImpl <em>Class Opened More Than Once</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ClassOpenedMoreThanOnceImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getClassOpenedMoreThanOnce()
		 * @generated
		 */
		EClass CLASS_OPENED_MORE_THAN_ONCE = eINSTANCE.getClassOpenedMoreThanOnce();

		/**
		 * The meta object literal for the '<em><b>Current Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_OPENED_MORE_THAN_ONCE__CURRENT_DECLARATION = eINSTANCE.getClassOpenedMoreThanOnce_CurrentDeclaration();

		/**
		 * The meta object literal for the '<em><b>Previous Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLASS_OPENED_MORE_THAN_ONCE__PREVIOUS_DECLARATION = eINSTANCE.getClassOpenedMoreThanOnce_PreviousDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.NotAnOpenableClassImpl <em>Not An Openable Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.NotAnOpenableClassImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getNotAnOpenableClass()
		 * @generated
		 */
		EClass NOT_AN_OPENABLE_CLASS = eINSTANCE.getNotAnOpenableClass();

		/**
		 * The meta object literal for the '<em><b>Open Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOT_AN_OPENABLE_CLASS__OPEN_CLASS = eINSTANCE.getNotAnOpenableClass_OpenClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.OpenClassNotFoundImpl <em>Open Class Not Found</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.OpenClassNotFoundImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getOpenClassNotFound()
		 * @generated
		 */
		EClass OPEN_CLASS_NOT_FOUND = eINSTANCE.getOpenClassNotFound();

		/**
		 * The meta object literal for the '<em><b>Open Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPEN_CLASS_NOT_FOUND__OPEN_CLASS = eINSTANCE.getOpenClassNotFound_OpenClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeHasNamesakesImpl <em>Type Has Namesakes</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeHasNamesakesImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getTypeHasNamesakes()
		 * @generated
		 */
		EClass TYPE_HAS_NAMESAKES = eINSTANCE.getTypeHasNamesakes();

		/**
		 * The meta object literal for the '<em><b>Namesakes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_HAS_NAMESAKES__NAMESAKES = eINSTANCE.getTypeHasNamesakes_Namesakes();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IncorrectExtendOrderImpl <em>Incorrect Extend Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IncorrectExtendOrderImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getIncorrectExtendOrder()
		 * @generated
		 */
		EClass INCORRECT_EXTEND_ORDER = eINSTANCE.getIncorrectExtendOrder();

		/**
		 * The meta object literal for the '<em><b>Super Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCORRECT_EXTEND_ORDER__SUPER_TYPE = eINSTANCE.getIncorrectExtendOrder_SuperType();

		/**
		 * The meta object literal for the '<em><b>Super Super Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INCORRECT_EXTEND_ORDER__SUPER_SUPER_TYPE = eINSTANCE.getIncorrectExtendOrder_SuperSuperType();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.CollectionTypeMismatchImpl <em>Collection Type Mismatch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.CollectionTypeMismatchImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getCollectionTypeMismatch()
		 * @generated
		 */
		EClass COLLECTION_TYPE_MISMATCH = eINSTANCE.getCollectionTypeMismatch();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ClassExtendsItselfImpl <em>Class Extends Itself</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ClassExtendsItselfImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getClassExtendsItself()
		 * @generated
		 */
		EClass CLASS_EXTENDS_ITSELF = eINSTANCE.getClassExtendsItself();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IllegalAssignmentImpl <em>Illegal Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IllegalAssignmentImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getIllegalAssignment()
		 * @generated
		 */
		EClass ILLEGAL_ASSIGNMENT = eINSTANCE.getIllegalAssignment();

		/**
		 * The meta object literal for the '<em><b>Assigned Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ILLEGAL_ASSIGNMENT__ASSIGNED_VALUE = eINSTANCE.getIllegalAssignment_AssignedValue();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IndirectExtensionImpl <em>Indirect Extension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IndirectExtensionImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getIndirectExtension()
		 * @generated
		 */
		EClass INDIRECT_EXTENSION = eINSTANCE.getIndirectExtension();

		/**
		 * The meta object literal for the '<em><b>Open Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDIRECT_EXTENSION__OPEN_CLASS = eINSTANCE.getIndirectExtension_OpenClass();

		/**
		 * The meta object literal for the '<em><b>Inherited Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INDIRECT_EXTENSION__INHERITED_CLASS = eINSTANCE.getIndirectExtension_InheritedClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedInsertionToSelfImpl <em>Prohibited Insertion To Self</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedInsertionToSelfImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getProhibitedInsertionToSelf()
		 * @generated
		 */
		EClass PROHIBITED_INSERTION_TO_SELF = eINSTANCE.getProhibitedInsertionToSelf();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedRemovalFromSelfImpl <em>Prohibited Removal From Self</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedRemovalFromSelfImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getProhibitedRemovalFromSelf()
		 * @generated
		 */
		EClass PROHIBITED_REMOVAL_FROM_SELF = eINSTANCE.getProhibitedRemovalFromSelf();

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
		 * The meta object literal for the '<em><b>Available EPackages</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_NOT_FOUND__AVAILABLE_EPACKAGES = eINSTANCE.getTypeNotFound_AvailableEPackages();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DynamicClassAlreadyDefinedImpl <em>Dynamic Class Already Defined</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DynamicClassAlreadyDefinedImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getDynamicClassAlreadyDefined()
		 * @generated
		 */
		EClass DYNAMIC_CLASS_ALREADY_DEFINED = eINSTANCE.getDynamicClassAlreadyDefined();

		/**
		 * The meta object literal for the '<em><b>Previous Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_CLASS_ALREADY_DEFINED__PREVIOUS_DECLARATION = eINSTANCE.getDynamicClassAlreadyDefined_PreviousDeclaration();

		/**
		 * The meta object literal for the '<em><b>Current Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DYNAMIC_CLASS_ALREADY_DEFINED__CURRENT_DECLARATION = eINSTANCE.getDynamicClassAlreadyDefined_CurrentDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInBaseClassImpl <em>Attribute Already Defined In Base Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInBaseClassImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getAttributeAlreadyDefinedInBaseClass()
		 * @generated
		 */
		EClass ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS = eINSTANCE.getAttributeAlreadyDefinedInBaseClass();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__ATTRIBUTE_NAME = eINSTANCE.getAttributeAlreadyDefinedInBaseClass_AttributeName();

		/**
		 * The meta object literal for the '<em><b>Open Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__OPEN_CLASS = eINSTANCE.getAttributeAlreadyDefinedInBaseClass_OpenClass();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__BASE_CLASS = eINSTANCE.getAttributeAlreadyDefinedInBaseClass_BaseClass();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodAlreadyDefinedInBaseClassImpl <em>Method Already Defined In Base Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodAlreadyDefinedInBaseClassImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getMethodAlreadyDefinedInBaseClass()
		 * @generated
		 */
		EClass METHOD_ALREADY_DEFINED_IN_BASE_CLASS = eINSTANCE.getMethodAlreadyDefinedInBaseClass();

		/**
		 * The meta object literal for the '<em><b>New Definition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_ALREADY_DEFINED_IN_BASE_CLASS__NEW_DEFINITION = eINSTANCE.getMethodAlreadyDefinedInBaseClass_NewDefinition();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInCurrentClassImpl <em>Attribute Already Defined In Current Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInCurrentClassImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getAttributeAlreadyDefinedInCurrentClass()
		 * @generated
		 */
		EClass ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS = eINSTANCE.getAttributeAlreadyDefinedInCurrentClass();

		/**
		 * The meta object literal for the '<em><b>Attribute Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__ATTRIBUTE_NAME = eINSTANCE.getAttributeAlreadyDefinedInCurrentClass_AttributeName();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER = eINSTANCE.getAttributeAlreadyDefinedInCurrentClass_Owner();

		/**
		 * The meta object literal for the '<em><b>Previous Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION = eINSTANCE.getAttributeAlreadyDefinedInCurrentClass_PreviousDeclaration();

		/**
		 * The meta object literal for the '<em><b>Current Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION = eINSTANCE.getAttributeAlreadyDefinedInCurrentClass_CurrentDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ReservedKeywordSelfImpl <em>Reserved Keyword Self</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ReservedKeywordSelfImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getReservedKeywordSelf()
		 * @generated
		 */
		EClass RESERVED_KEYWORD_SELF = eINSTANCE.getReservedKeywordSelf();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ReservedKeywordResultImpl <em>Reserved Keyword Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ReservedKeywordResultImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getReservedKeywordResult()
		 * @generated
		 */
		EClass RESERVED_KEYWORD_RESULT = eINSTANCE.getReservedKeywordResult();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodAlreadyDefinedInCurrentClassImpl <em>Method Already Defined In Current Class</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodAlreadyDefinedInCurrentClassImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getMethodAlreadyDefinedInCurrentClass()
		 * @generated
		 */
		EClass METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS = eINSTANCE.getMethodAlreadyDefinedInCurrentClass();

		/**
		 * The meta object literal for the '<em><b>Previous Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION = eINSTANCE.getMethodAlreadyDefinedInCurrentClass_PreviousDeclaration();

		/**
		 * The meta object literal for the '<em><b>Current Declaration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION = eINSTANCE.getMethodAlreadyDefinedInCurrentClass_CurrentDeclaration();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER = eINSTANCE.getMethodAlreadyDefinedInCurrentClass_Owner();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodParameterAlreadyDefinedImpl <em>Method Parameter Already Defined</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodParameterAlreadyDefinedImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getMethodParameterAlreadyDefined()
		 * @generated
		 */
		EClass METHOD_PARAMETER_ALREADY_DEFINED = eINSTANCE.getMethodParameterAlreadyDefined();

		/**
		 * The meta object literal for the '<em><b>Parameter Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHOD_PARAMETER_ALREADY_DEFINED__PARAMETER_NAME = eINSTANCE.getMethodParameterAlreadyDefined_ParameterName();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_PARAMETER_ALREADY_DEFINED__METHOD = eINSTANCE.getMethodParameterAlreadyDefined_Method();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.OverriddenMethodNotFoundImpl <em>Overridden Method Not Found</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.OverriddenMethodNotFoundImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getOverriddenMethodNotFound()
		 * @generated
		 */
		EClass OVERRIDDEN_METHOD_NOT_FOUND = eINSTANCE.getOverriddenMethodNotFound();

		/**
		 * The meta object literal for the '<em><b>Overriding Method</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD = eINSTANCE.getOverriddenMethodNotFound_OverridingMethod();

		/**
		 * The meta object literal for the '<em><b>Overriding Method Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD_OWNER = eINSTANCE.getOverriddenMethodNotFound_OverridingMethodOwner();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedAssignmentToMethodParameterImpl <em>Prohibited Assignment To Method Parameter</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ProhibitedAssignmentToMethodParameterImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getProhibitedAssignmentToMethodParameter()
		 * @generated
		 */
		EClass PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER = eINSTANCE.getProhibitedAssignmentToMethodParameter();

		/**
		 * The meta object literal for the '<em><b>Parameter Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROHIBITED_ASSIGNMENT_TO_METHOD_PARAMETER__PARAMETER_NAME = eINSTANCE.getProhibitedAssignmentToMethodParameter_ParameterName();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AcceleoValidationMessageImpl <em>Acceleo Validation Message</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AcceleoValidationMessageImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getAcceleoValidationMessage()
		 * @generated
		 */
		EClass ACCELEO_VALIDATION_MESSAGE = eINSTANCE.getAcceleoValidationMessage();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCELEO_VALIDATION_MESSAGE__MESSAGE = eINSTANCE.getAcceleoValidationMessage_Message();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACCELEO_VALIDATION_MESSAGE__LEVEL = eINSTANCE.getAcceleoValidationMessage_Level();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IllegalAdditionAssignmentImpl <em>Illegal Addition Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IllegalAdditionAssignmentImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getIllegalAdditionAssignment()
		 * @generated
		 */
		EClass ILLEGAL_ADDITION_ASSIGNMENT = eINSTANCE.getIllegalAdditionAssignment();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IllegalSubstractionAssignmentImpl <em>Illegal Substraction Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IllegalSubstractionAssignmentImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getIllegalSubstractionAssignment()
		 * @generated
		 */
		EClass ILLEGAL_SUBSTRACTION_ASSIGNMENT = eINSTANCE.getIllegalSubstractionAssignment();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.UninitializedImpl <em>Uninitialized</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.UninitializedImpl
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getUninitialized()
		 * @generated
		 */
		EClass UNINITIALIZED = eINSTANCE.getUninitialized();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNINITIALIZED__NAME = eINSTANCE.getUninitialized_Name();

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

		/**
		 * The meta object literal for the '<em>Validation Message Level</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.acceleo.query.runtime.ValidationMessageLevel
		 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DiagnosticsPackageImpl#getValidationMessageLevel()
		 * @generated
		 */
		EDataType VALIDATION_MESSAGE_LEVEL = eINSTANCE.getValidationMessageLevel();

	}

} //DiagnosticsPackage
