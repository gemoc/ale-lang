/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Already Defined</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableAlreadyDefinedImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.VariableAlreadyDefinedImpl#getDuplicateLocation <em>Duplicate Location</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableAlreadyDefinedImpl extends MessageImpl implements VariableAlreadyDefined {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDuplicateLocation() <em>Duplicate Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuplicateLocation()
	 * @generated
	 * @ordered
	 */
	protected CodeLocation duplicateLocation;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableAlreadyDefinedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.VARIABLE_ALREADY_DEFINED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.VARIABLE_ALREADY_DEFINED__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CodeLocation getDuplicateLocation() {
		if (duplicateLocation != null && duplicateLocation.eIsProxy()) {
			InternalEObject oldDuplicateLocation = (InternalEObject)duplicateLocation;
			duplicateLocation = (CodeLocation)eResolveProxy(oldDuplicateLocation);
			if (duplicateLocation != oldDuplicateLocation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.VARIABLE_ALREADY_DEFINED__DUPLICATE_LOCATION, oldDuplicateLocation, duplicateLocation));
			}
		}
		return duplicateLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CodeLocation basicGetDuplicateLocation() {
		return duplicateLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDuplicateLocation(CodeLocation newDuplicateLocation) {
		CodeLocation oldDuplicateLocation = duplicateLocation;
		duplicateLocation = newDuplicateLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.VARIABLE_ALREADY_DEFINED__DUPLICATE_LOCATION, oldDuplicateLocation, duplicateLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.VARIABLE_ALREADY_DEFINED__NAME:
				return getName();
			case DiagnosticsPackage.VARIABLE_ALREADY_DEFINED__DUPLICATE_LOCATION:
				if (resolve) return getDuplicateLocation();
				return basicGetDuplicateLocation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DiagnosticsPackage.VARIABLE_ALREADY_DEFINED__NAME:
				setName((String)newValue);
				return;
			case DiagnosticsPackage.VARIABLE_ALREADY_DEFINED__DUPLICATE_LOCATION:
				setDuplicateLocation((CodeLocation)newValue);
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
			case DiagnosticsPackage.VARIABLE_ALREADY_DEFINED__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagnosticsPackage.VARIABLE_ALREADY_DEFINED__DUPLICATE_LOCATION:
				setDuplicateLocation((CodeLocation)null);
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
			case DiagnosticsPackage.VARIABLE_ALREADY_DEFINED__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagnosticsPackage.VARIABLE_ALREADY_DEFINED__DUPLICATE_LOCATION:
				return duplicateLocation != null;
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //VariableAlreadyDefinedImpl
