/**
 */
package implementation.impl;

import implementation.ExtendedClass;
import implementation.ImplementationPackage;
import implementation.ModelBehavior;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Model Behavior</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link implementation.impl.ModelBehaviorImpl#getClassExtensions <em>Class Extensions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ModelBehaviorImpl extends MinimalEObjectImpl.Container implements ModelBehavior {
	/**
	 * The cached value of the '{@link #getClassExtensions() <em>Class Extensions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassExtensions()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtendedClass> classExtensions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ModelBehaviorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.MODEL_BEHAVIOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtendedClass> getClassExtensions() {
		if (classExtensions == null) {
			classExtensions = new EObjectContainmentEList<ExtendedClass>(ExtendedClass.class, this, ImplementationPackage.MODEL_BEHAVIOR__CLASS_EXTENSIONS);
		}
		return classExtensions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImplementationPackage.MODEL_BEHAVIOR__CLASS_EXTENSIONS:
				return ((InternalEList<?>)getClassExtensions()).basicRemove(otherEnd, msgs);
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
			case ImplementationPackage.MODEL_BEHAVIOR__CLASS_EXTENSIONS:
				return getClassExtensions();
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
			case ImplementationPackage.MODEL_BEHAVIOR__CLASS_EXTENSIONS:
				getClassExtensions().clear();
				getClassExtensions().addAll((Collection<? extends ExtendedClass>)newValue);
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
			case ImplementationPackage.MODEL_BEHAVIOR__CLASS_EXTENSIONS:
				getClassExtensions().clear();
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
			case ImplementationPackage.MODEL_BEHAVIOR__CLASS_EXTENSIONS:
				return classExtensions != null && !classExtensions.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ModelBehaviorImpl
