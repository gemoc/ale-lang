/**
 */
package org.eclipse.ecoretools.ale.implementation.impl;

import org.eclipse.acceleo.query.ast.Expression;

import org.eclipse.ecoretools.ale.implementation.Attribute;
import org.eclipse.ecoretools.ale.implementation.ImplementationPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.impl.AttributeImpl#getFeatureRef <em>Feature Ref</em>}</li>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.impl.AttributeImpl#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeImpl extends EModelElementImpl implements Attribute {
	/**
	 * The cached value of the '{@link #getFeatureRef() <em>Feature Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatureRef()
	 * @generated
	 * @ordered
	 */
	protected EStructuralFeature featureRef;

	/**
	 * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialValue()
	 * @generated
	 * @ordered
	 */
	protected Expression initialValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AttributeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.ATTRIBUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature getFeatureRef() {
		if (featureRef != null && featureRef.eIsProxy()) {
			InternalEObject oldFeatureRef = (InternalEObject)featureRef;
			featureRef = (EStructuralFeature)eResolveProxy(oldFeatureRef);
			if (featureRef != oldFeatureRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImplementationPackage.ATTRIBUTE__FEATURE_REF, oldFeatureRef, featureRef));
			}
		}
		return featureRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EStructuralFeature basicGetFeatureRef() {
		return featureRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureRef(EStructuralFeature newFeatureRef) {
		EStructuralFeature oldFeatureRef = featureRef;
		featureRef = newFeatureRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.ATTRIBUTE__FEATURE_REF, oldFeatureRef, featureRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getInitialValue() {
		return initialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialValue(Expression newInitialValue, NotificationChain msgs) {
		Expression oldInitialValue = initialValue;
		initialValue = newInitialValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImplementationPackage.ATTRIBUTE__INITIAL_VALUE, oldInitialValue, newInitialValue);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialValue(Expression newInitialValue) {
		if (newInitialValue != initialValue) {
			NotificationChain msgs = null;
			if (initialValue != null)
				msgs = ((InternalEObject)initialValue).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImplementationPackage.ATTRIBUTE__INITIAL_VALUE, null, msgs);
			if (newInitialValue != null)
				msgs = ((InternalEObject)newInitialValue).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImplementationPackage.ATTRIBUTE__INITIAL_VALUE, null, msgs);
			msgs = basicSetInitialValue(newInitialValue, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.ATTRIBUTE__INITIAL_VALUE, newInitialValue, newInitialValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImplementationPackage.ATTRIBUTE__INITIAL_VALUE:
				return basicSetInitialValue(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImplementationPackage.ATTRIBUTE__FEATURE_REF:
				if (resolve) return getFeatureRef();
				return basicGetFeatureRef();
			case ImplementationPackage.ATTRIBUTE__INITIAL_VALUE:
				return getInitialValue();
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
			case ImplementationPackage.ATTRIBUTE__FEATURE_REF:
				setFeatureRef((EStructuralFeature)newValue);
				return;
			case ImplementationPackage.ATTRIBUTE__INITIAL_VALUE:
				setInitialValue((Expression)newValue);
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
			case ImplementationPackage.ATTRIBUTE__FEATURE_REF:
				setFeatureRef((EStructuralFeature)null);
				return;
			case ImplementationPackage.ATTRIBUTE__INITIAL_VALUE:
				setInitialValue((Expression)null);
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
			case ImplementationPackage.ATTRIBUTE__FEATURE_REF:
				return featureRef != null;
			case ImplementationPackage.ATTRIBUTE__INITIAL_VALUE:
				return initialValue != null;
		}
		return super.eIsSet(featureID);
	}

} //AttributeImpl
