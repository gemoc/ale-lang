/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInBaseClass;

import org.eclipse.emf.ecoretools.ale.implementation.Method;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Already Defined In Base Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodAlreadyDefinedInBaseClassImpl#getNewDefinition <em>New Definition</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodAlreadyDefinedInBaseClassImpl extends MessageImpl implements MethodAlreadyDefinedInBaseClass {
	/**
	 * The cached value of the '{@link #getNewDefinition() <em>New Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewDefinition()
	 * @generated
	 * @ordered
	 */
	protected Method newDefinition;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodAlreadyDefinedInBaseClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.METHOD_ALREADY_DEFINED_IN_BASE_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Method getNewDefinition() {
		if (newDefinition != null && newDefinition.eIsProxy()) {
			InternalEObject oldNewDefinition = (InternalEObject)newDefinition;
			newDefinition = (Method)eResolveProxy(oldNewDefinition);
			if (newDefinition != oldNewDefinition) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_BASE_CLASS__NEW_DEFINITION, oldNewDefinition, newDefinition));
			}
		}
		return newDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method basicGetNewDefinition() {
		return newDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNewDefinition(Method newNewDefinition) {
		Method oldNewDefinition = newDefinition;
		newDefinition = newNewDefinition;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_BASE_CLASS__NEW_DEFINITION, oldNewDefinition, newDefinition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_BASE_CLASS__NEW_DEFINITION:
				if (resolve) return getNewDefinition();
				return basicGetNewDefinition();
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
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_BASE_CLASS__NEW_DEFINITION:
				setNewDefinition((Method)newValue);
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
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_BASE_CLASS__NEW_DEFINITION:
				setNewDefinition((Method)null);
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
			case DiagnosticsPackage.METHOD_ALREADY_DEFINED_IN_BASE_CLASS__NEW_DEFINITION:
				return newDefinition != null;
		}
		return super.eIsSet(featureID);
	}

} //MethodAlreadyDefinedInBaseClassImpl
