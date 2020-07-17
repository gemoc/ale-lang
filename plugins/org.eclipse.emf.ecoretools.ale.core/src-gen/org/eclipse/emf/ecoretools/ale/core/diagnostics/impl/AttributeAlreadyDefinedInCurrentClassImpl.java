/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;

import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute Already Defined In Current Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInCurrentClassImpl#getAttributeName <em>Attribute Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInCurrentClassImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInCurrentClassImpl#getPreviousDeclaration <em>Previous Declaration</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.AttributeAlreadyDefinedInCurrentClassImpl#getCurrentDeclaration <em>Current Declaration</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeAlreadyDefinedInCurrentClassImpl extends MessageImpl implements AttributeAlreadyDefinedInCurrentClass {
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
	 * The cached value of the '{@link #getOwner() <em>Owner</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwner()
	 * @generated
	 * @ordered
	 */
	protected BehavioredClass owner;

	/**
	 * The cached value of the '{@link #getPreviousDeclaration() <em>Previous Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreviousDeclaration()
	 * @generated
	 * @ordered
	 */
	protected Attribute previousDeclaration;

	/**
	 * The cached value of the '{@link #getCurrentDeclaration() <em>Current Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentDeclaration()
	 * @generated
	 * @ordered
	 */
	protected Attribute currentDeclaration;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeAlreadyDefinedInCurrentClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__ATTRIBUTE_NAME, oldAttributeName, attributeName));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER, oldOwner, owner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Attribute getPreviousDeclaration() {
		if (previousDeclaration != null && previousDeclaration.eIsProxy()) {
			InternalEObject oldPreviousDeclaration = (InternalEObject)previousDeclaration;
			previousDeclaration = (Attribute)eResolveProxy(oldPreviousDeclaration);
			if (previousDeclaration != oldPreviousDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION, oldPreviousDeclaration, previousDeclaration));
			}
		}
		return previousDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute basicGetPreviousDeclaration() {
		return previousDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPreviousDeclaration(Attribute newPreviousDeclaration) {
		Attribute oldPreviousDeclaration = previousDeclaration;
		previousDeclaration = newPreviousDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION, oldPreviousDeclaration, previousDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Attribute getCurrentDeclaration() {
		if (currentDeclaration != null && currentDeclaration.eIsProxy()) {
			InternalEObject oldCurrentDeclaration = (InternalEObject)currentDeclaration;
			currentDeclaration = (Attribute)eResolveProxy(oldCurrentDeclaration);
			if (currentDeclaration != oldCurrentDeclaration) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION, oldCurrentDeclaration, currentDeclaration));
			}
		}
		return currentDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute basicGetCurrentDeclaration() {
		return currentDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCurrentDeclaration(Attribute newCurrentDeclaration) {
		Attribute oldCurrentDeclaration = currentDeclaration;
		currentDeclaration = newCurrentDeclaration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION, oldCurrentDeclaration, currentDeclaration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__ATTRIBUTE_NAME:
				return getAttributeName();
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION:
				if (resolve) return getPreviousDeclaration();
				return basicGetPreviousDeclaration();
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION:
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
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__ATTRIBUTE_NAME:
				setAttributeName((String)newValue);
				return;
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER:
				setOwner((BehavioredClass)newValue);
				return;
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION:
				setPreviousDeclaration((Attribute)newValue);
				return;
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION:
				setCurrentDeclaration((Attribute)newValue);
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
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__ATTRIBUTE_NAME:
				setAttributeName(ATTRIBUTE_NAME_EDEFAULT);
				return;
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER:
				setOwner((BehavioredClass)null);
				return;
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION:
				setPreviousDeclaration((Attribute)null);
				return;
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION:
				setCurrentDeclaration((Attribute)null);
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
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__ATTRIBUTE_NAME:
				return ATTRIBUTE_NAME_EDEFAULT == null ? attributeName != null : !ATTRIBUTE_NAME_EDEFAULT.equals(attributeName);
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__OWNER:
				return owner != null;
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__PREVIOUS_DECLARATION:
				return previousDeclaration != null;
			case DiagnosticsPackage.ATTRIBUTE_ALREADY_DEFINED_IN_CURRENT_CLASS__CURRENT_DECLARATION:
				return currentDeclaration != null;
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

} //AttributeAlreadyDefinedInCurrentClassImpl
