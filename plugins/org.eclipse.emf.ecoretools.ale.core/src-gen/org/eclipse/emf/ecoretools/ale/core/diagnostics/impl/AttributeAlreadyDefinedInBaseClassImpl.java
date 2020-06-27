/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;

import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Already Defined In Base Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInBaseClassImpl#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInBaseClassImpl#getOpenClass <em>Open Class</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInBaseClassImpl#getBaseClass <em>Base Class</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeAlreadyDefinedInBaseClassImpl extends MessageImpl implements AttributeAlreadyDefinedInBaseClass {
	/**
	 * The default value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected static final String ATTRIBUTE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAttributeName() <em>Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributeName()
	 * @generated
	 * @ordered
	 */
	protected String attributeName = ATTRIBUTE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getOpenClass() <em>Open Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenClass()
	 * @generated
	 * @ordered
	 */
	protected ExtendedClass openClass;

	/**
	 * The cached value of the '{@link #getBaseClass() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBaseClass()
	 * @generated
	 * @ordered
	 */
	protected EClass baseClass;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeAlreadyDefinedInBaseClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAttributeName() {
		return attributeName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAttributeName(String newAttributeName) {
		String oldAttributeName = attributeName;
		attributeName = newAttributeName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__ATTRIBUTE_NAME, oldAttributeName, attributeName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExtendedClass getOpenClass() {
		if (openClass != null && openClass.eIsProxy()) {
			InternalEObject oldOpenClass = (InternalEObject)openClass;
			openClass = (ExtendedClass)eResolveProxy(oldOpenClass);
			if (openClass != oldOpenClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__OPEN_CLASS, oldOpenClass, openClass));
			}
		}
		return openClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedClass basicGetOpenClass() {
		return openClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOpenClass(ExtendedClass newOpenClass) {
		ExtendedClass oldOpenClass = openClass;
		openClass = newOpenClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__OPEN_CLASS, oldOpenClass, openClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBaseClass() {
		if (baseClass != null && baseClass.eIsProxy()) {
			InternalEObject oldBaseClass = (InternalEObject)baseClass;
			baseClass = (EClass)eResolveProxy(oldBaseClass);
			if (baseClass != oldBaseClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__BASE_CLASS, oldBaseClass, baseClass));
			}
		}
		return baseClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetBaseClass() {
		return baseClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBaseClass(EClass newBaseClass) {
		EClass oldBaseClass = baseClass;
		baseClass = newBaseClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__BASE_CLASS, oldBaseClass, baseClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__ATTRIBUTE_NAME:
				return getAttributeName();
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__OPEN_CLASS:
				if (resolve) return getOpenClass();
				return basicGetOpenClass();
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__BASE_CLASS:
				if (resolve) return getBaseClass();
				return basicGetBaseClass();
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
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__ATTRIBUTE_NAME:
				setAttributeName((String)newValue);
				return;
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__OPEN_CLASS:
				setOpenClass((ExtendedClass)newValue);
				return;
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__BASE_CLASS:
				setBaseClass((EClass)newValue);
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
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__ATTRIBUTE_NAME:
				setAttributeName(ATTRIBUTE_NAME_EDEFAULT);
				return;
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__OPEN_CLASS:
				setOpenClass((ExtendedClass)null);
				return;
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__BASE_CLASS:
				setBaseClass((EClass)null);
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
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__ATTRIBUTE_NAME:
				return ATTRIBUTE_NAME_EDEFAULT == null ? attributeName != null : !ATTRIBUTE_NAME_EDEFAULT.equals(attributeName);
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__OPEN_CLASS:
				return openClass != null;
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_BASE_CLASS__BASE_CLASS:
				return baseClass != null;
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
		result.append(" (attributeName: ");
		result.append(attributeName);
		result.append(')');
		return result.toString();
	}

} //AttributeAlreadyDefinedInBaseClassImpl
