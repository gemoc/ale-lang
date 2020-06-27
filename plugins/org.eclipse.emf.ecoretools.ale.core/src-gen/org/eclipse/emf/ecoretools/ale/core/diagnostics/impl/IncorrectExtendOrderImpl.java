/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Incorrect Extend Order</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IncorrectExtendOrderImpl#getSuperType <em>Super Type</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IncorrectExtendOrderImpl#getSuperSuperType <em>Super Super Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IncorrectExtendOrderImpl extends MessageImpl implements IncorrectExtendOrder {
	/**
	 * The cached value of the '{@link #getSuperType() <em>Super Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperType()
	 * @generated
	 * @ordered
	 */
	protected EClass superType;

	/**
	 * The cached value of the '{@link #getSuperSuperType() <em>Super Super Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperSuperType()
	 * @generated
	 * @ordered
	 */
	protected EClass superSuperType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IncorrectExtendOrderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.INCORRECT_EXTEND_ORDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSuperType() {
		if (superType != null && superType.eIsProxy()) {
			InternalEObject oldSuperType = (InternalEObject)superType;
			superType = (EClass)eResolveProxy(oldSuperType);
			if (superType != oldSuperType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.INCORRECT_EXTEND_ORDER__SUPER_TYPE, oldSuperType, superType));
			}
		}
		return superType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetSuperType() {
		return superType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuperType(EClass newSuperType) {
		EClass oldSuperType = superType;
		superType = newSuperType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.INCORRECT_EXTEND_ORDER__SUPER_TYPE, oldSuperType, superType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSuperSuperType() {
		if (superSuperType != null && superSuperType.eIsProxy()) {
			InternalEObject oldSuperSuperType = (InternalEObject)superSuperType;
			superSuperType = (EClass)eResolveProxy(oldSuperSuperType);
			if (superSuperType != oldSuperSuperType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.INCORRECT_EXTEND_ORDER__SUPER_SUPER_TYPE, oldSuperSuperType, superSuperType));
			}
		}
		return superSuperType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetSuperSuperType() {
		return superSuperType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuperSuperType(EClass newSuperSuperType) {
		EClass oldSuperSuperType = superSuperType;
		superSuperType = newSuperSuperType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.INCORRECT_EXTEND_ORDER__SUPER_SUPER_TYPE, oldSuperSuperType, superSuperType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.INCORRECT_EXTEND_ORDER__SUPER_TYPE:
				if (resolve) return getSuperType();
				return basicGetSuperType();
			case DiagnosticsPackage.INCORRECT_EXTEND_ORDER__SUPER_SUPER_TYPE:
				if (resolve) return getSuperSuperType();
				return basicGetSuperSuperType();
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
			case DiagnosticsPackage.INCORRECT_EXTEND_ORDER__SUPER_TYPE:
				setSuperType((EClass)newValue);
				return;
			case DiagnosticsPackage.INCORRECT_EXTEND_ORDER__SUPER_SUPER_TYPE:
				setSuperSuperType((EClass)newValue);
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
			case DiagnosticsPackage.INCORRECT_EXTEND_ORDER__SUPER_TYPE:
				setSuperType((EClass)null);
				return;
			case DiagnosticsPackage.INCORRECT_EXTEND_ORDER__SUPER_SUPER_TYPE:
				setSuperSuperType((EClass)null);
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
			case DiagnosticsPackage.INCORRECT_EXTEND_ORDER__SUPER_TYPE:
				return superType != null;
			case DiagnosticsPackage.INCORRECT_EXTEND_ORDER__SUPER_SUPER_TYPE:
				return superSuperType != null;
		}
		return super.eIsSet(featureID);
	}

} //IncorrectExtendOrderImpl
