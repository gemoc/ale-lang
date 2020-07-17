/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;

import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Opened More Than Once</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ClassOpenedMoreThanOnceImpl#getCurrentDeclaration <em>Current Declaration</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ClassOpenedMoreThanOnceImpl#getPreviousDeclaration <em>Previous Declaration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassOpenedMoreThanOnceImpl extends MessageImpl implements ClassOpenedMoreThanOnce {
	/**
	 * The cached value of the '{@link #getCurrentDeclaration() <em>Current Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentDeclaration()
	 * @generated
	 * @ordered
	 */
	protected ExtendedClass currentDeclaration;

	/**
	 * The cached value of the '{@link #getPreviousDeclaration() <em>Previous Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousDeclaration()
	 * @generated
	 * @ordered
	 */
	protected ExtendedClass previousDeclaration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassOpenedMoreThanOnceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.CLASS_OPENED_MORE_THAN_ONCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExtendedClass getCurrentDeclaration() {
		if (currentDeclaration != null && currentDeclaration.eIsProxy()) {
			InternalEObject oldCurrentDeclaration = (InternalEObject)currentDeclaration;
			currentDeclaration = (ExtendedClass)eResolveProxy(oldCurrentDeclaration);
			if (currentDeclaration != oldCurrentDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE__CURRENT_DECLARATION, oldCurrentDeclaration, currentDeclaration));
			}
		}
		return currentDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedClass basicGetCurrentDeclaration() {
		return currentDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentDeclaration(ExtendedClass newCurrentDeclaration) {
		ExtendedClass oldCurrentDeclaration = currentDeclaration;
		currentDeclaration = newCurrentDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE__CURRENT_DECLARATION, oldCurrentDeclaration, currentDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExtendedClass getPreviousDeclaration() {
		if (previousDeclaration != null && previousDeclaration.eIsProxy()) {
			InternalEObject oldPreviousDeclaration = (InternalEObject)previousDeclaration;
			previousDeclaration = (ExtendedClass)eResolveProxy(oldPreviousDeclaration);
			if (previousDeclaration != oldPreviousDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE__PREVIOUS_DECLARATION, oldPreviousDeclaration, previousDeclaration));
			}
		}
		return previousDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedClass basicGetPreviousDeclaration() {
		return previousDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPreviousDeclaration(ExtendedClass newPreviousDeclaration) {
		ExtendedClass oldPreviousDeclaration = previousDeclaration;
		previousDeclaration = newPreviousDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE__PREVIOUS_DECLARATION, oldPreviousDeclaration, previousDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE__CURRENT_DECLARATION:
				if (resolve) return getCurrentDeclaration();
				return basicGetCurrentDeclaration();
			case DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE__PREVIOUS_DECLARATION:
				if (resolve) return getPreviousDeclaration();
				return basicGetPreviousDeclaration();
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
			case DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE__CURRENT_DECLARATION:
				setCurrentDeclaration((ExtendedClass)newValue);
				return;
			case DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE__PREVIOUS_DECLARATION:
				setPreviousDeclaration((ExtendedClass)newValue);
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
			case DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE__CURRENT_DECLARATION:
				setCurrentDeclaration((ExtendedClass)null);
				return;
			case DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE__PREVIOUS_DECLARATION:
				setPreviousDeclaration((ExtendedClass)null);
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
			case DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE__CURRENT_DECLARATION:
				return currentDeclaration != null;
			case DiagnosticsPackage.CLASS_OPENED_MORE_THAN_ONCE__PREVIOUS_DECLARATION:
				return previousDeclaration != null;
		}
		return super.eIsSet(featureID);
	}

} //ClassOpenedMoreThanOnceImpl
