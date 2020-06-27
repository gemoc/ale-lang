/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import java.util.Collection;

import org.eclipse.acceleo.query.validation.type.IType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unsupported Operator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.UnsupportedOperatorImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.UnsupportedOperatorImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.UnsupportedOperatorImpl#getTargetTypes <em>Target Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UnsupportedOperatorImpl extends MessageImpl implements UnsupportedOperator {
	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final Operator OPERATOR_EDEFAULT = Operator.SUBSTRACTION;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected Operator operator = OPERATOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected static final Object TARGET_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Object target = TARGET_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTargetTypes() <em>Target Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<IType> targetTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnsupportedOperatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.UNSUPPORTED_OPERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operator getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperator(Operator newOperator) {
		Operator oldOperator = operator;
		operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.UNSUPPORTED_OPERATOR__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTarget(Object newTarget) {
		Object oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.UNSUPPORTED_OPERATOR__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IType> getTargetTypes() {
		if (targetTypes == null) {
			targetTypes = new EDataTypeUniqueEList<IType>(IType.class, this, DiagnosticsPackage.UNSUPPORTED_OPERATOR__TARGET_TYPES);
		}
		return targetTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR__OPERATOR:
				return getOperator();
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR__TARGET:
				return getTarget();
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR__TARGET_TYPES:
				return getTargetTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR__OPERATOR:
				setOperator((Operator)newValue);
				return;
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR__TARGET:
				setTarget(newValue);
				return;
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR__TARGET_TYPES:
				getTargetTypes().clear();
				getTargetTypes().addAll((Collection<? extends IType>)newValue);
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
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR__TARGET:
				setTarget(TARGET_EDEFAULT);
				return;
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR__TARGET_TYPES:
				getTargetTypes().clear();
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
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR__TARGET:
				return TARGET_EDEFAULT == null ? target != null : !TARGET_EDEFAULT.equals(target);
			case DiagnosticsPackage.UNSUPPORTED_OPERATOR__TARGET_TYPES:
				return targetTypes != null && !targetTypes.isEmpty();
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
		result.append(" (operator: ");
		result.append(operator);
		result.append(", target: ");
		result.append(target);
		result.append(", targetTypes: ");
		result.append(targetTypes);
		result.append(')');
		return result.toString();
	}

} //UnsupportedOperatorImpl
