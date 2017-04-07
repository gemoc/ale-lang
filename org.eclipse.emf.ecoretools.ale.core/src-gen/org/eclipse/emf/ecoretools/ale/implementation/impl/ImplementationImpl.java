/**
 */
package org.eclipse.emf.ecoretools.ale.implementation.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecoretools.ale.implementation.Implementation;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Implementation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.impl.ImplementationImpl#getOperationRef <em>Operation Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImplementationImpl extends BehavioredImpl implements Implementation {
	/**
	 * The cached value of the '{@link #getOperationRef() <em>Operation Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationRef()
	 * @generated
	 * @ordered
	 */
	protected EOperation operationRef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ImplementationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.IMPLEMENTATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationRef() {
		if (operationRef != null && operationRef.eIsProxy()) {
			InternalEObject oldOperationRef = (InternalEObject)operationRef;
			operationRef = (EOperation)eResolveProxy(oldOperationRef);
			if (operationRef != oldOperationRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImplementationPackage.IMPLEMENTATION__OPERATION_REF, oldOperationRef, operationRef));
			}
		}
		return operationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation basicGetOperationRef() {
		return operationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationRef(EOperation newOperationRef) {
		EOperation oldOperationRef = operationRef;
		operationRef = newOperationRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.IMPLEMENTATION__OPERATION_REF, oldOperationRef, operationRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImplementationPackage.IMPLEMENTATION__OPERATION_REF:
				if (resolve) return getOperationRef();
				return basicGetOperationRef();
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
			case ImplementationPackage.IMPLEMENTATION__OPERATION_REF:
				setOperationRef((EOperation)newValue);
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
			case ImplementationPackage.IMPLEMENTATION__OPERATION_REF:
				setOperationRef((EOperation)null);
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
			case ImplementationPackage.IMPLEMENTATION__OPERATION_REF:
				return operationRef != null;
		}
		return super.eIsSet(featureID);
	}

} //ImplementationImpl
