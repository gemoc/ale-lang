/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass;

import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Already Defined In Current Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodAlreadyDefinedInCurrentClassImpl#getPreviousDeclaration <em>Previous Declaration</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodAlreadyDefinedInCurrentClassImpl#getCurrentDeclaration <em>Current Declaration</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodAlreadyDefinedInCurrentClassImpl#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodAlreadyDefinedInCurrentClassImpl extends MessageImpl implements MethodAlreadyDefinedInCurrentClass {
	/**
	 * The cached value of the '{@link #getPreviousDeclaration() <em>Previous Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousDeclaration()
	 * @generated
	 * @ordered
	 */
	protected Method previousDeclaration;

	/**
	 * The cached value of the '{@link #getCurrentDeclaration() <em>Current Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentDeclaration()
	 * @generated
	 * @ordered
	 */
	protected Method currentDeclaration;

	/**
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected BehavioredClass owner;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodAlreadyDefinedInCurrentClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Method getPreviousDeclaration() {
		if (previousDeclaration != null && previousDeclaration.eIsProxy()) {
			InternalEObject oldPreviousDeclaration = (InternalEObject)previousDeclaration;
			previousDeclaration = (Method)eResolveProxy(oldPreviousDeclaration);
			if (previousDeclaration != oldPreviousDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION, oldPreviousDeclaration, previousDeclaration));
			}
		}
		return previousDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method basicGetPreviousDeclaration() {
		return previousDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPreviousDeclaration(Method newPreviousDeclaration) {
		Method oldPreviousDeclaration = previousDeclaration;
		previousDeclaration = newPreviousDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION, oldPreviousDeclaration, previousDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Method getCurrentDeclaration() {
		if (currentDeclaration != null && currentDeclaration.eIsProxy()) {
			InternalEObject oldCurrentDeclaration = (InternalEObject)currentDeclaration;
			currentDeclaration = (Method)eResolveProxy(oldCurrentDeclaration);
			if (currentDeclaration != oldCurrentDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION, oldCurrentDeclaration, currentDeclaration));
			}
		}
		return currentDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method basicGetCurrentDeclaration() {
		return currentDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentDeclaration(Method newCurrentDeclaration) {
		Method oldCurrentDeclaration = currentDeclaration;
		currentDeclaration = newCurrentDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION, oldCurrentDeclaration, currentDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BehavioredClass getOwner() {
		if (owner != null && owner.eIsProxy()) {
			InternalEObject oldOwner = (InternalEObject)owner;
			owner = (BehavioredClass)eResolveProxy(oldOwner);
			if (owner != oldOwner) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER, oldOwner, owner));
			}
		}
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BehavioredClass basicGetOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOwner(BehavioredClass newOwner) {
		BehavioredClass oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION:
				if (resolve) return getPreviousDeclaration();
				return basicGetPreviousDeclaration();
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION:
				if (resolve) return getCurrentDeclaration();
				return basicGetCurrentDeclaration();
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
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
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION:
				setPreviousDeclaration((Method)newValue);
				return;
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION:
				setCurrentDeclaration((Method)newValue);
				return;
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER:
				setOwner((BehavioredClass)newValue);
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
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION:
				setPreviousDeclaration((Method)null);
				return;
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION:
				setCurrentDeclaration((Method)null);
				return;
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER:
				setOwner((BehavioredClass)null);
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
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION:
				return previousDeclaration != null;
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION:
				return currentDeclaration != null;
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER:
				return owner != null;
		}
		return super.eIsSet(featureID);
	}

} //MethodAlreadyDefinedInCurrentClassImpl
