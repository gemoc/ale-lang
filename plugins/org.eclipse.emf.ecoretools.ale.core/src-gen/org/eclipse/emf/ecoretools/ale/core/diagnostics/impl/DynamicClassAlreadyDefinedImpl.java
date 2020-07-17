/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined;

import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dynamic Class Already Defined</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DynamicClassAlreadyDefinedImpl#getPreviousDeclaration <em>Previous Declaration</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.DynamicClassAlreadyDefinedImpl#getCurrentDeclaration <em>Current Declaration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DynamicClassAlreadyDefinedImpl extends MessageImpl implements DynamicClassAlreadyDefined {
	/**
	 * The cached value of the '{@link #getPreviousDeclaration() <em>Previous Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousDeclaration()
	 * @generated
	 * @ordered
	 */
	protected RuntimeClass previousDeclaration;

	/**
	 * The cached value of the '{@link #getCurrentDeclaration() <em>Current Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentDeclaration()
	 * @generated
	 * @ordered
	 */
	protected RuntimeClass currentDeclaration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DynamicClassAlreadyDefinedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.DYNAMIC_CLASS_ALREADY_DEFINED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RuntimeClass getPreviousDeclaration() {
		if (previousDeclaration != null && previousDeclaration.eIsProxy()) {
			InternalEObject oldPreviousDeclaration = (InternalEObject)previousDeclaration;
			previousDeclaration = (RuntimeClass)eResolveProxy(oldPreviousDeclaration);
			if (previousDeclaration != oldPreviousDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED__PREVIOUS_DECLARATION, oldPreviousDeclaration, previousDeclaration));
			}
		}
		return previousDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeClass basicGetPreviousDeclaration() {
		return previousDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPreviousDeclaration(RuntimeClass newPreviousDeclaration) {
		RuntimeClass oldPreviousDeclaration = previousDeclaration;
		previousDeclaration = newPreviousDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED__PREVIOUS_DECLARATION, oldPreviousDeclaration, previousDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RuntimeClass getCurrentDeclaration() {
		if (currentDeclaration != null && currentDeclaration.eIsProxy()) {
			InternalEObject oldCurrentDeclaration = (InternalEObject)currentDeclaration;
			currentDeclaration = (RuntimeClass)eResolveProxy(oldCurrentDeclaration);
			if (currentDeclaration != oldCurrentDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED__CURRENT_DECLARATION, oldCurrentDeclaration, currentDeclaration));
			}
		}
		return currentDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuntimeClass basicGetCurrentDeclaration() {
		return currentDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentDeclaration(RuntimeClass newCurrentDeclaration) {
		RuntimeClass oldCurrentDeclaration = currentDeclaration;
		currentDeclaration = newCurrentDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED__CURRENT_DECLARATION, oldCurrentDeclaration, currentDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED__PREVIOUS_DECLARATION:
				if (resolve) return getPreviousDeclaration();
				return basicGetPreviousDeclaration();
			case DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED__CURRENT_DECLARATION:
				if (resolve) return getCurrentDeclaration();
				return basicGetCurrentDeclaration();
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
			case DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED__PREVIOUS_DECLARATION:
				setPreviousDeclaration((RuntimeClass)newValue);
				return;
			case DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED__CURRENT_DECLARATION:
				setCurrentDeclaration((RuntimeClass)newValue);
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
			case DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED__PREVIOUS_DECLARATION:
				setPreviousDeclaration((RuntimeClass)null);
				return;
			case DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED__CURRENT_DECLARATION:
				setCurrentDeclaration((RuntimeClass)null);
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
			case DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED__PREVIOUS_DECLARATION:
				return previousDeclaration != null;
			case DiagnosticsPackage.DYNAMIC_CLASS_ALREADY_DEFINED__CURRENT_DECLARATION:
				return currentDeclaration != null;
		}
		return super.eIsSet(featureID);
	}

} //DynamicClassAlreadyDefinedImpl
