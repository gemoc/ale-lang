/**
 */
package implementation.impl;

import implementation.FeaturePut;
import implementation.ImplementationPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Put</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link implementation.impl.FeaturePutImpl#getTargetExpression <em>Target Expression</em>}</li>
 *   <li>{@link implementation.impl.FeaturePutImpl#getTargetFeature <em>Target Feature</em>}</li>
 *   <li>{@link implementation.impl.FeaturePutImpl#getKeyExpression <em>Key Expression</em>}</li>
 *   <li>{@link implementation.impl.FeaturePutImpl#getValueExpression <em>Value Expression</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FeaturePutImpl extends StatementImpl implements FeaturePut {
	/**
	 * The default value of the '{@link #getTargetExpression() <em>Target Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetExpression() <em>Target Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetExpression()
	 * @generated
	 * @ordered
	 */
	protected String targetExpression = TARGET_EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetFeature() <em>Target Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFeature()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_FEATURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetFeature() <em>Target Feature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetFeature()
	 * @generated
	 * @ordered
	 */
	protected String targetFeature = TARGET_FEATURE_EDEFAULT;

	/**
	 * The default value of the '{@link #getKeyExpression() <em>Key Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String KEY_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getKeyExpression() <em>Key Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKeyExpression()
	 * @generated
	 * @ordered
	 */
	protected String keyExpression = KEY_EXPRESSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueExpression() <em>Value Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueExpression()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EXPRESSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValueExpression() <em>Value Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueExpression()
	 * @generated
	 * @ordered
	 */
	protected String valueExpression = VALUE_EXPRESSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeaturePutImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.FEATURE_PUT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetExpression() {
		return targetExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetExpression(String newTargetExpression) {
		String oldTargetExpression = targetExpression;
		targetExpression = newTargetExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.FEATURE_PUT__TARGET_EXPRESSION, oldTargetExpression, targetExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTargetFeature() {
		return targetFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTargetFeature(String newTargetFeature) {
		String oldTargetFeature = targetFeature;
		targetFeature = newTargetFeature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.FEATURE_PUT__TARGET_FEATURE, oldTargetFeature, targetFeature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getKeyExpression() {
		return keyExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeyExpression(String newKeyExpression) {
		String oldKeyExpression = keyExpression;
		keyExpression = newKeyExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.FEATURE_PUT__KEY_EXPRESSION, oldKeyExpression, keyExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueExpression() {
		return valueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueExpression(String newValueExpression) {
		String oldValueExpression = valueExpression;
		valueExpression = newValueExpression;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.FEATURE_PUT__VALUE_EXPRESSION, oldValueExpression, valueExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImplementationPackage.FEATURE_PUT__TARGET_EXPRESSION:
				return getTargetExpression();
			case ImplementationPackage.FEATURE_PUT__TARGET_FEATURE:
				return getTargetFeature();
			case ImplementationPackage.FEATURE_PUT__KEY_EXPRESSION:
				return getKeyExpression();
			case ImplementationPackage.FEATURE_PUT__VALUE_EXPRESSION:
				return getValueExpression();
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
			case ImplementationPackage.FEATURE_PUT__TARGET_EXPRESSION:
				setTargetExpression((String)newValue);
				return;
			case ImplementationPackage.FEATURE_PUT__TARGET_FEATURE:
				setTargetFeature((String)newValue);
				return;
			case ImplementationPackage.FEATURE_PUT__KEY_EXPRESSION:
				setKeyExpression((String)newValue);
				return;
			case ImplementationPackage.FEATURE_PUT__VALUE_EXPRESSION:
				setValueExpression((String)newValue);
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
			case ImplementationPackage.FEATURE_PUT__TARGET_EXPRESSION:
				setTargetExpression(TARGET_EXPRESSION_EDEFAULT);
				return;
			case ImplementationPackage.FEATURE_PUT__TARGET_FEATURE:
				setTargetFeature(TARGET_FEATURE_EDEFAULT);
				return;
			case ImplementationPackage.FEATURE_PUT__KEY_EXPRESSION:
				setKeyExpression(KEY_EXPRESSION_EDEFAULT);
				return;
			case ImplementationPackage.FEATURE_PUT__VALUE_EXPRESSION:
				setValueExpression(VALUE_EXPRESSION_EDEFAULT);
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
			case ImplementationPackage.FEATURE_PUT__TARGET_EXPRESSION:
				return TARGET_EXPRESSION_EDEFAULT == null ? targetExpression != null : !TARGET_EXPRESSION_EDEFAULT.equals(targetExpression);
			case ImplementationPackage.FEATURE_PUT__TARGET_FEATURE:
				return TARGET_FEATURE_EDEFAULT == null ? targetFeature != null : !TARGET_FEATURE_EDEFAULT.equals(targetFeature);
			case ImplementationPackage.FEATURE_PUT__KEY_EXPRESSION:
				return KEY_EXPRESSION_EDEFAULT == null ? keyExpression != null : !KEY_EXPRESSION_EDEFAULT.equals(keyExpression);
			case ImplementationPackage.FEATURE_PUT__VALUE_EXPRESSION:
				return VALUE_EXPRESSION_EDEFAULT == null ? valueExpression != null : !VALUE_EXPRESSION_EDEFAULT.equals(valueExpression);
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (targetExpression: ");
		result.append(targetExpression);
		result.append(", targetFeature: ");
		result.append(targetFeature);
		result.append(", keyExpression: ");
		result.append(keyExpression);
		result.append(", valueExpression: ");
		result.append(valueExpression);
		result.append(')');
		return result.toString();
	}

} //FeaturePutImpl
