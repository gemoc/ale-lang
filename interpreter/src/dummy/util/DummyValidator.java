/**
 */
package dummy.util;

import dummy.*;

import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.EObjectValidator;

/**
 * <!-- begin-user-doc -->
 * The <b>Validator</b> for the model.
 * <!-- end-user-doc -->
 * @see dummy.DummyPackage
 * @generated
 */
public class DummyValidator extends EObjectValidator {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final DummyValidator INSTANCE = new DummyValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "dummy";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DummyValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return DummyPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value, DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case DummyPackage.NEW_ECLASS1:
				return validateNewEClass1((NewEClass1)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNewEClass1(NewEClass1 newEClass1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(newEClass1, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(newEClass1, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(newEClass1, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(newEClass1, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(newEClass1, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(newEClass1, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(newEClass1, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(newEClass1, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(newEClass1, diagnostics, context);
		if (result || diagnostics != null) result &= validateNewEClass1_Constraint1(newEClass1, diagnostics, context);
		if (result || diagnostics != null) result &= validateNewEClass1_Constraint2(newEClass1, diagnostics, context);
		return result;
	}

	/**
	 * Validates the Constraint1 constraint of '<em>New EClass1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNewEClass1_Constraint1(NewEClass1 newEClass1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Constraint1", getObjectLabel(newEClass1, context) },
						 new Object[] { newEClass1 },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the Constraint2 constraint of '<em>New EClass1</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNewEClass1_Constraint2(NewEClass1 newEClass1, DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "Constraint2", getObjectLabel(newEClass1, context) },
						 new Object[] { newEClass1 },
						 context));
			}
			return false;
		}
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

} //DummyValidator
