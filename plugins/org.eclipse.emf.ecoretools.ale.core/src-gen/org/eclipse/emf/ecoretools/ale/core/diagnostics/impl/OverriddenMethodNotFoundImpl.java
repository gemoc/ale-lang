/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound;

import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Overridden Method Not Found</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.OverriddenMethodNotFoundImpl#getOverridingMethod <em>Overriding Method</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.OverriddenMethodNotFoundImpl#getOverridingMethodOwner <em>Overriding Method Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OverriddenMethodNotFoundImpl extends MessageImpl implements OverriddenMethodNotFound {
	/**
	 * The cached value of the '{@link #getOverridingMethod() <em>Overriding Method</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverridingMethod()
	 * @generated
	 * @ordered
	 */
	protected Method overridingMethod;

	/**
	 * The cached value of the '{@link #getOverridingMethodOwner() <em>Overriding Method Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOverridingMethodOwner()
	 * @generated
	 * @ordered
	 */
	protected BehavioredClass overridingMethodOwner;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OverriddenMethodNotFoundImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.OVERRIDDEN_METHOD_NOT_FOUND;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Method getOverridingMethod() {
		if (overridingMethod != null && overridingMethod.eIsProxy()) {
			InternalEObject oldOverridingMethod = (InternalEObject)overridingMethod;
			overridingMethod = (Method)eResolveProxy(oldOverridingMethod);
			if (overridingMethod != oldOverridingMethod) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD, oldOverridingMethod, overridingMethod));
			}
		}
		return overridingMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method basicGetOverridingMethod() {
		return overridingMethod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverridingMethod(Method newOverridingMethod) {
		Method oldOverridingMethod = overridingMethod;
		overridingMethod = newOverridingMethod;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD, oldOverridingMethod, overridingMethod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehavioredClass getOverridingMethodOwner() {
		if (overridingMethodOwner != null && overridingMethodOwner.eIsProxy()) {
			InternalEObject oldOverridingMethodOwner = (InternalEObject)overridingMethodOwner;
			overridingMethodOwner = (BehavioredClass)eResolveProxy(oldOverridingMethodOwner);
			if (overridingMethodOwner != oldOverridingMethodOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD_OWNER, oldOverridingMethodOwner, overridingMethodOwner));
			}
		}
		return overridingMethodOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioredClass basicGetOverridingMethodOwner() {
		return overridingMethodOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOverridingMethodOwner(BehavioredClass newOverridingMethodOwner) {
		BehavioredClass oldOverridingMethodOwner = overridingMethodOwner;
		overridingMethodOwner = newOverridingMethodOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD_OWNER, oldOverridingMethodOwner, overridingMethodOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD:
				if (resolve) return getOverridingMethod();
				return basicGetOverridingMethod();
			case DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD_OWNER:
				if (resolve) return getOverridingMethodOwner();
				return basicGetOverridingMethodOwner();
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
			case DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD:
				setOverridingMethod((Method)newValue);
				return;
			case DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD_OWNER:
				setOverridingMethodOwner((BehavioredClass)newValue);
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
			case DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD:
				setOverridingMethod((Method)null);
				return;
			case DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD_OWNER:
				setOverridingMethodOwner((BehavioredClass)null);
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
			case DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD:
				return overridingMethod != null;
			case DiagnosticsPackage.OVERRIDDEN_METHOD_NOT_FOUND__OVERRIDING_METHOD_OWNER:
				return overridingMethodOwner != null;
		}
		return super.eIsSet(featureID);
	}

} //OverriddenMethodNotFoundImpl
