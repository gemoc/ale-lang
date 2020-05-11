/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import java.util.Collection;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method Not Found</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodNotFoundImpl#getOwner <em>Owner</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodNotFoundImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodNotFoundImpl#getArguments <em>Arguments</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MethodNotFoundImpl#getArgumentTypes <em>Argument Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodNotFoundImpl extends MessageImpl implements MethodNotFound {
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
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

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
	 * The cached value of the '{@link #getArguments() <em>Arguments</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<Object> arguments;

	/**
	 * The cached value of the '{@link #getArgumentTypes() <em>Argument Types</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArgumentTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<IType> argumentTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodNotFoundImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.METHOD_NOT_FOUND;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.METHOD_NOT_FOUND__OWNER, oldOwner, owner));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.METHOD_NOT_FOUND__OWNER, oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.METHOD_NOT_FOUND__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Object> getArguments() {
		if (arguments == null) {
			arguments = new EDataTypeUniqueEList<Object>(Object.class, this, DiagnosticsPackage.METHOD_NOT_FOUND__ARGUMENTS);
		}
		return arguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IType> getArgumentTypes() {
		if (argumentTypes == null) {
			argumentTypes = new EDataTypeUniqueEList<IType>(IType.class, this, DiagnosticsPackage.METHOD_NOT_FOUND__ARGUMENT_TYPES);
		}
		return argumentTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.METHOD_NOT_FOUND__OWNER:
				if (resolve) return getOwner();
				return basicGetOwner();
			case DiagnosticsPackage.METHOD_NOT_FOUND__NAME:
				return getName();
			case DiagnosticsPackage.METHOD_NOT_FOUND__ARGUMENTS:
				return getArguments();
			case DiagnosticsPackage.METHOD_NOT_FOUND__ARGUMENT_TYPES:
				return getArgumentTypes();
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
			case DiagnosticsPackage.METHOD_NOT_FOUND__OWNER:
				setOwner((BehavioredClass)newValue);
				return;
			case DiagnosticsPackage.METHOD_NOT_FOUND__NAME:
				setName((String)newValue);
				return;
			case DiagnosticsPackage.METHOD_NOT_FOUND__ARGUMENTS:
				getArguments().clear();
				getArguments().addAll((Collection<? extends Object>)newValue);
				return;
			case DiagnosticsPackage.METHOD_NOT_FOUND__ARGUMENT_TYPES:
				getArgumentTypes().clear();
				getArgumentTypes().addAll((Collection<? extends IType>)newValue);
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
			case DiagnosticsPackage.METHOD_NOT_FOUND__OWNER:
				setOwner((BehavioredClass)null);
				return;
			case DiagnosticsPackage.METHOD_NOT_FOUND__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagnosticsPackage.METHOD_NOT_FOUND__ARGUMENTS:
				getArguments().clear();
				return;
			case DiagnosticsPackage.METHOD_NOT_FOUND__ARGUMENT_TYPES:
				getArgumentTypes().clear();
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
			case DiagnosticsPackage.METHOD_NOT_FOUND__OWNER:
				return owner != null;
			case DiagnosticsPackage.METHOD_NOT_FOUND__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagnosticsPackage.METHOD_NOT_FOUND__ARGUMENTS:
				return arguments != null && !arguments.isEmpty();
			case DiagnosticsPackage.METHOD_NOT_FOUND__ARGUMENT_TYPES:
				return argumentTypes != null && !argumentTypes.isEmpty();
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
		result.append(" (name: ");
		result.append(name);
		result.append(", arguments: ");
		result.append(arguments);
		result.append(", argumentTypes: ");
		result.append(argumentTypes);
		result.append(')');
		return result.toString();
	}

} //MethodNotFoundImpl
