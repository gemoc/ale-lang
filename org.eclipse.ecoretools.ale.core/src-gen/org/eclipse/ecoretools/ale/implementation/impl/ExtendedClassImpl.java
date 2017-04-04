/**
 */
package org.eclipse.ecoretools.ale.implementation.impl;

import java.util.Collection;

import org.eclipse.ecoretools.ale.implementation.Attribute;
import org.eclipse.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.ecoretools.ale.implementation.Method;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EModelElementImpl;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extended Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.impl.ExtendedClassImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.impl.ExtendedClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.impl.ExtendedClassImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.impl.ExtendedClassImpl#getFragment <em>Fragment</em>}</li>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.impl.ExtendedClassImpl#getBaseClass <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.impl.ExtendedClassImpl#getExtends <em>Extends</em>}</li>
 *   <li>{@link org.eclipse.ecoretools.ale.implementation.impl.ExtendedClassImpl#getChildren <em>Children</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExtendedClassImpl extends EModelElementImpl implements ExtendedClass {
	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<Method> methods;

	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFragment() <em>Fragment</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFragment()
	 * @generated
	 * @ordered
	 */
	protected EClass fragment;

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
	 * The cached value of the '{@link #getExtends() <em>Extends</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExtends()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtendedClass> extends_;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList<ExtendedClass> children;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExtendedClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.EXTENDED_CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Method> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentEList<Method>(Method.class, this, ImplementationPackage.EXTENDED_CLASS__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, ImplementationPackage.EXTENDED_CLASS__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.EXTENDED_CLASS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFragment() {
		return fragment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFragment(EClass newFragment, NotificationChain msgs) {
		EClass oldFragment = fragment;
		fragment = newFragment;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImplementationPackage.EXTENDED_CLASS__FRAGMENT, oldFragment, newFragment);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFragment(EClass newFragment) {
		if (newFragment != fragment) {
			NotificationChain msgs = null;
			if (fragment != null)
				msgs = ((InternalEObject)fragment).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImplementationPackage.EXTENDED_CLASS__FRAGMENT, null, msgs);
			if (newFragment != null)
				msgs = ((InternalEObject)newFragment).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImplementationPackage.EXTENDED_CLASS__FRAGMENT, null, msgs);
			msgs = basicSetFragment(newFragment, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.EXTENDED_CLASS__FRAGMENT, newFragment, newFragment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBaseClass() {
		if (baseClass != null && baseClass.eIsProxy()) {
			InternalEObject oldBaseClass = (InternalEObject)baseClass;
			baseClass = (EClass)eResolveProxy(oldBaseClass);
			if (baseClass != oldBaseClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ImplementationPackage.EXTENDED_CLASS__BASE_CLASS, oldBaseClass, baseClass));
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
	public void setBaseClass(EClass newBaseClass) {
		EClass oldBaseClass = baseClass;
		baseClass = newBaseClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.EXTENDED_CLASS__BASE_CLASS, oldBaseClass, baseClass));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtendedClass> getExtends() {
		if (extends_ == null) {
			extends_ = new EObjectWithInverseResolvingEList.ManyInverse<ExtendedClass>(ExtendedClass.class, this, ImplementationPackage.EXTENDED_CLASS__EXTENDS, ImplementationPackage.EXTENDED_CLASS__CHILDREN);
		}
		return extends_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ExtendedClass> getChildren() {
		if (children == null) {
			children = new EObjectWithInverseResolvingEList.ManyInverse<ExtendedClass>(ExtendedClass.class, this, ImplementationPackage.EXTENDED_CLASS__CHILDREN, ImplementationPackage.EXTENDED_CLASS__EXTENDS);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImplementationPackage.EXTENDED_CLASS__EXTENDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getExtends()).basicAdd(otherEnd, msgs);
			case ImplementationPackage.EXTENDED_CLASS__CHILDREN:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getChildren()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImplementationPackage.EXTENDED_CLASS__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
			case ImplementationPackage.EXTENDED_CLASS__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case ImplementationPackage.EXTENDED_CLASS__FRAGMENT:
				return basicSetFragment(null, msgs);
			case ImplementationPackage.EXTENDED_CLASS__EXTENDS:
				return ((InternalEList<?>)getExtends()).basicRemove(otherEnd, msgs);
			case ImplementationPackage.EXTENDED_CLASS__CHILDREN:
				return ((InternalEList<?>)getChildren()).basicRemove(otherEnd, msgs);
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
			case ImplementationPackage.EXTENDED_CLASS__METHODS:
				return getMethods();
			case ImplementationPackage.EXTENDED_CLASS__ATTRIBUTES:
				return getAttributes();
			case ImplementationPackage.EXTENDED_CLASS__NAME:
				return getName();
			case ImplementationPackage.EXTENDED_CLASS__FRAGMENT:
				return getFragment();
			case ImplementationPackage.EXTENDED_CLASS__BASE_CLASS:
				if (resolve) return getBaseClass();
				return basicGetBaseClass();
			case ImplementationPackage.EXTENDED_CLASS__EXTENDS:
				return getExtends();
			case ImplementationPackage.EXTENDED_CLASS__CHILDREN:
				return getChildren();
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
			case ImplementationPackage.EXTENDED_CLASS__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends Method>)newValue);
				return;
			case ImplementationPackage.EXTENDED_CLASS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case ImplementationPackage.EXTENDED_CLASS__NAME:
				setName((String)newValue);
				return;
			case ImplementationPackage.EXTENDED_CLASS__FRAGMENT:
				setFragment((EClass)newValue);
				return;
			case ImplementationPackage.EXTENDED_CLASS__BASE_CLASS:
				setBaseClass((EClass)newValue);
				return;
			case ImplementationPackage.EXTENDED_CLASS__EXTENDS:
				getExtends().clear();
				getExtends().addAll((Collection<? extends ExtendedClass>)newValue);
				return;
			case ImplementationPackage.EXTENDED_CLASS__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection<? extends ExtendedClass>)newValue);
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
			case ImplementationPackage.EXTENDED_CLASS__METHODS:
				getMethods().clear();
				return;
			case ImplementationPackage.EXTENDED_CLASS__ATTRIBUTES:
				getAttributes().clear();
				return;
			case ImplementationPackage.EXTENDED_CLASS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ImplementationPackage.EXTENDED_CLASS__FRAGMENT:
				setFragment((EClass)null);
				return;
			case ImplementationPackage.EXTENDED_CLASS__BASE_CLASS:
				setBaseClass((EClass)null);
				return;
			case ImplementationPackage.EXTENDED_CLASS__EXTENDS:
				getExtends().clear();
				return;
			case ImplementationPackage.EXTENDED_CLASS__CHILDREN:
				getChildren().clear();
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
			case ImplementationPackage.EXTENDED_CLASS__METHODS:
				return methods != null && !methods.isEmpty();
			case ImplementationPackage.EXTENDED_CLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case ImplementationPackage.EXTENDED_CLASS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ImplementationPackage.EXTENDED_CLASS__FRAGMENT:
				return fragment != null;
			case ImplementationPackage.EXTENDED_CLASS__BASE_CLASS:
				return baseClass != null;
			case ImplementationPackage.EXTENDED_CLASS__EXTENDS:
				return extends_ != null && !extends_.isEmpty();
			case ImplementationPackage.EXTENDED_CLASS__CHILDREN:
				return children != null && !children.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == BehavioredClass.class) {
			switch (derivedFeatureID) {
				case ImplementationPackage.EXTENDED_CLASS__METHODS: return ImplementationPackage.BEHAVIORED_CLASS__METHODS;
				case ImplementationPackage.EXTENDED_CLASS__ATTRIBUTES: return ImplementationPackage.BEHAVIORED_CLASS__ATTRIBUTES;
				case ImplementationPackage.EXTENDED_CLASS__NAME: return ImplementationPackage.BEHAVIORED_CLASS__NAME;
				case ImplementationPackage.EXTENDED_CLASS__FRAGMENT: return ImplementationPackage.BEHAVIORED_CLASS__FRAGMENT;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == BehavioredClass.class) {
			switch (baseFeatureID) {
				case ImplementationPackage.BEHAVIORED_CLASS__METHODS: return ImplementationPackage.EXTENDED_CLASS__METHODS;
				case ImplementationPackage.BEHAVIORED_CLASS__ATTRIBUTES: return ImplementationPackage.EXTENDED_CLASS__ATTRIBUTES;
				case ImplementationPackage.BEHAVIORED_CLASS__NAME: return ImplementationPackage.EXTENDED_CLASS__NAME;
				case ImplementationPackage.BEHAVIORED_CLASS__FRAGMENT: return ImplementationPackage.EXTENDED_CLASS__FRAGMENT;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ExtendedClassImpl
