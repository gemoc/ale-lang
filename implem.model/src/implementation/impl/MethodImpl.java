/**
 */
package implementation.impl;

import implementation.ImplementationPackage;
import implementation.Method;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link implementation.impl.MethodImpl#getOperationDef <em>Operation Def</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodImpl extends BehavioredImpl implements Method {
	/**
	 * The cached value of the '{@link #getOperationDef() <em>Operation Def</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperationDef()
	 * @generated
	 * @ordered
	 */
	protected EOperation operationDef;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getOperationDef() {
		return operationDef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperationDef(EOperation newOperationDef, NotificationChain msgs) {
		EOperation oldOperationDef = operationDef;
		operationDef = newOperationDef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImplementationPackage.METHOD__OPERATION_DEF, oldOperationDef, newOperationDef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperationDef(EOperation newOperationDef) {
		if (newOperationDef != operationDef) {
			NotificationChain msgs = null;
			if (operationDef != null)
				msgs = ((InternalEObject)operationDef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImplementationPackage.METHOD__OPERATION_DEF, null, msgs);
			if (newOperationDef != null)
				msgs = ((InternalEObject)newOperationDef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImplementationPackage.METHOD__OPERATION_DEF, null, msgs);
			msgs = basicSetOperationDef(newOperationDef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.METHOD__OPERATION_DEF, newOperationDef, newOperationDef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImplementationPackage.METHOD__OPERATION_DEF:
				return basicSetOperationDef(null, msgs);
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
			case ImplementationPackage.METHOD__OPERATION_DEF:
				return getOperationDef();
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
			case ImplementationPackage.METHOD__OPERATION_DEF:
				setOperationDef((EOperation)newValue);
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
			case ImplementationPackage.METHOD__OPERATION_DEF:
				setOperationDef((EOperation)null);
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
			case ImplementationPackage.METHOD__OPERATION_DEF:
				return operationDef != null;
		}
		return super.eIsSet(featureID);
	}

} //MethodImpl
