/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import java.util.Collection;

import org.eclipse.acceleo.query.validation.type.IType;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Mismatch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeMismatchImpl#getExpectedTypes <em>Expected Types</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeMismatchImpl#getActualTypes <em>Actual Types</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeMismatchImpl#getTargetTypes <em>Target Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeMismatchImpl extends MessageImpl implements TypeMismatch {
	/**
	 * The cached value of the '{@link #getExpectedTypes() <em>Expected Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpectedTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<IType> expectedTypes;

	/**
	 * The cached value of the '{@link #getActualTypes() <em>Actual Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getActualTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<IType> actualTypes;

	/**
	 * The cached value of the '{@link #getTargetTypes() <em>Target Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<IType> targetTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeMismatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.TYPE_MISMATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IType> getExpectedTypes() {
		if (expectedTypes == null) {
			expectedTypes = new EDataTypeUniqueEList<IType>(IType.class, this, DiagnosticsPackage.TYPE_MISMATCH__EXPECTED_TYPES);
		}
		return expectedTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IType> getActualTypes() {
		if (actualTypes == null) {
			actualTypes = new EDataTypeUniqueEList<IType>(IType.class, this, DiagnosticsPackage.TYPE_MISMATCH__ACTUAL_TYPES);
		}
		return actualTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IType> getTargetTypes() {
		if (targetTypes == null) {
			targetTypes = new EDataTypeUniqueEList<IType>(IType.class, this, DiagnosticsPackage.TYPE_MISMATCH__TARGET_TYPES);
		}
		return targetTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.TYPE_MISMATCH__EXPECTED_TYPES:
				return getExpectedTypes();
			case DiagnosticsPackage.TYPE_MISMATCH__ACTUAL_TYPES:
				return getActualTypes();
			case DiagnosticsPackage.TYPE_MISMATCH__TARGET_TYPES:
				return getTargetTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DiagnosticsPackage.TYPE_MISMATCH__EXPECTED_TYPES:
				getExpectedTypes().clear();
				getExpectedTypes().addAll((Collection<? extends IType>)newValue);
				return;
			case DiagnosticsPackage.TYPE_MISMATCH__ACTUAL_TYPES:
				getActualTypes().clear();
				getActualTypes().addAll((Collection<? extends IType>)newValue);
				return;
			case DiagnosticsPackage.TYPE_MISMATCH__TARGET_TYPES:
				getTargetTypes().clear();
				getTargetTypes().addAll((Collection<? extends IType>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DiagnosticsPackage.TYPE_MISMATCH__EXPECTED_TYPES:
				getExpectedTypes().clear();
				return;
			case DiagnosticsPackage.TYPE_MISMATCH__ACTUAL_TYPES:
				getActualTypes().clear();
				return;
			case DiagnosticsPackage.TYPE_MISMATCH__TARGET_TYPES:
				getTargetTypes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DiagnosticsPackage.TYPE_MISMATCH__EXPECTED_TYPES:
				return expectedTypes != null && !expectedTypes.isEmpty();
			case DiagnosticsPackage.TYPE_MISMATCH__ACTUAL_TYPES:
				return actualTypes != null && !actualTypes.isEmpty();
			case DiagnosticsPackage.TYPE_MISMATCH__TARGET_TYPES:
				return targetTypes != null && !targetTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (expectedTypes: ");
		result.append(expectedTypes);
		result.append(", actualTypes: ");
		result.append(actualTypes);
		result.append(", targetTypes: ");
		result.append(targetTypes);
		result.append(')');
		return result.toString();
	}

} //TypeMismatchImpl
