/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Indirect Extension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IndirectExtensionImpl#getOpenClass <em>Open Class</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.IndirectExtensionImpl#getInheritedClass <em>Inherited Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IndirectExtensionImpl extends MessageImpl implements IndirectExtension {
	/**
	 * The cached value of the '{@link #getOpenClass() <em>Open Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenClass()
	 * @generated
	 * @ordered
	 */
	protected EClass openClass;

	/**
	 * The cached value of the '{@link #getInheritedClass() <em>Inherited Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInheritedClass()
	 * @generated
	 * @ordered
	 */
	protected EClass inheritedClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IndirectExtensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.INDIRECT_EXTENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOpenClass() {
		if (openClass != null && openClass.eIsProxy()) {
			InternalEObject oldOpenClass = (InternalEObject)openClass;
			openClass = (EClass)eResolveProxy(oldOpenClass);
			if (openClass != oldOpenClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.INDIRECT_EXTENSION__OPEN_CLASS, oldOpenClass, openClass));
			}
		}
		return openClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetOpenClass() {
		return openClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOpenClass(EClass newOpenClass) {
		EClass oldOpenClass = openClass;
		openClass = newOpenClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.INDIRECT_EXTENSION__OPEN_CLASS, oldOpenClass, openClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInheritedClass() {
		if (inheritedClass != null && inheritedClass.eIsProxy()) {
			InternalEObject oldInheritedClass = (InternalEObject)inheritedClass;
			inheritedClass = (EClass)eResolveProxy(oldInheritedClass);
			if (inheritedClass != oldInheritedClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.INDIRECT_EXTENSION__INHERITED_CLASS, oldInheritedClass, inheritedClass));
			}
		}
		return inheritedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetInheritedClass() {
		return inheritedClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInheritedClass(EClass newInheritedClass) {
		EClass oldInheritedClass = inheritedClass;
		inheritedClass = newInheritedClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.INDIRECT_EXTENSION__INHERITED_CLASS, oldInheritedClass, inheritedClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.INDIRECT_EXTENSION__OPEN_CLASS:
				if (resolve) return getOpenClass();
				return basicGetOpenClass();
			case DiagnosticsPackage.INDIRECT_EXTENSION__INHERITED_CLASS:
				if (resolve) return getInheritedClass();
				return basicGetInheritedClass();
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
			case DiagnosticsPackage.INDIRECT_EXTENSION__OPEN_CLASS:
				setOpenClass((EClass)newValue);
				return;
			case DiagnosticsPackage.INDIRECT_EXTENSION__INHERITED_CLASS:
				setInheritedClass((EClass)newValue);
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
			case DiagnosticsPackage.INDIRECT_EXTENSION__OPEN_CLASS:
				setOpenClass((EClass)null);
				return;
			case DiagnosticsPackage.INDIRECT_EXTENSION__INHERITED_CLASS:
				setInheritedClass((EClass)null);
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
			case DiagnosticsPackage.INDIRECT_EXTENSION__OPEN_CLASS:
				return openClass != null;
			case DiagnosticsPackage.INDIRECT_EXTENSION__INHERITED_CLASS:
				return inheritedClass != null;
		}
		return super.eIsSet(featureID);
	}

} //IndirectExtensionImpl
