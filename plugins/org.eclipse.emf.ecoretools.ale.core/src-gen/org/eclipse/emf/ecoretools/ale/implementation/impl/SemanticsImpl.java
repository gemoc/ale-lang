/**
 *  Copyright (c) 2017 Inria and Obeo.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Inria - initial API and implementation
 * 
 */
package org.eclipse.emf.ecoretools.ale.implementation.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.implementation.Concept;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.Semantics;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Semantics</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.impl.SemanticsImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.impl.SemanticsImpl#getImplem <em>Implem</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.impl.SemanticsImpl#getConcept <em>Concept</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.implementation.impl.SemanticsImpl#getOperationRef <em>Operation Ref</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SemanticsImpl extends MinimalEObjectImpl.Container implements Semantics {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = " Copyright (c) 2017 Inria and Obeo.\n All rights reserved. This program and the accompanying materials\n are made available under the terms of the Eclipse Public License v1.0\n which accompanies this distribution, and is available at\n http://www.eclipse.org/legal/epl-v10.html\n\n Contributors:\n     Inria - initial API and implementation\n";

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getImplem() <em>Implem</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImplem()
	 * @generated
	 * @ordered
	 */
	protected Method implem;

	/**
	 * The cached value of the '{@link #getOperationRef() <em>Operation Ref</em>}' containment reference.
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
	protected SemanticsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImplementationPackage.Literals.SEMANTICS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.SEMANTICS__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Method getImplem() {
		return implem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetImplem(Method newImplem, NotificationChain msgs) {
		Method oldImplem = implem;
		implem = newImplem;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImplementationPackage.SEMANTICS__IMPLEM, oldImplem, newImplem);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setImplem(Method newImplem) {
		if (newImplem != implem) {
			NotificationChain msgs = null;
			if (implem != null)
				msgs = ((InternalEObject)implem).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImplementationPackage.SEMANTICS__IMPLEM, null, msgs);
			if (newImplem != null)
				msgs = ((InternalEObject)newImplem).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImplementationPackage.SEMANTICS__IMPLEM, null, msgs);
			msgs = basicSetImplem(newImplem, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.SEMANTICS__IMPLEM, newImplem, newImplem));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Concept getConcept() {
		if (eContainerFeatureID() != ImplementationPackage.SEMANTICS__CONCEPT) return null;
		return (Concept)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConcept(Concept newConcept, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newConcept, ImplementationPackage.SEMANTICS__CONCEPT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConcept(Concept newConcept) {
		if (newConcept != eInternalContainer() || (eContainerFeatureID() != ImplementationPackage.SEMANTICS__CONCEPT && newConcept != null)) {
			if (EcoreUtil.isAncestor(this, newConcept))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newConcept != null)
				msgs = ((InternalEObject)newConcept).eInverseAdd(this, ImplementationPackage.CONCEPT__SEMANTICS, Concept.class, msgs);
			msgs = basicSetConcept(newConcept, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.SEMANTICS__CONCEPT, newConcept, newConcept));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getOperationRef() {
		return operationRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperationRef(EOperation newOperationRef, NotificationChain msgs) {
		EOperation oldOperationRef = operationRef;
		operationRef = newOperationRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ImplementationPackage.SEMANTICS__OPERATION_REF, oldOperationRef, newOperationRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperationRef(EOperation newOperationRef) {
		if (newOperationRef != operationRef) {
			NotificationChain msgs = null;
			if (operationRef != null)
				msgs = ((InternalEObject)operationRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ImplementationPackage.SEMANTICS__OPERATION_REF, null, msgs);
			if (newOperationRef != null)
				msgs = ((InternalEObject)newOperationRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ImplementationPackage.SEMANTICS__OPERATION_REF, null, msgs);
			msgs = basicSetOperationRef(newOperationRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ImplementationPackage.SEMANTICS__OPERATION_REF, newOperationRef, newOperationRef));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ImplementationPackage.SEMANTICS__CONCEPT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetConcept((Concept)otherEnd, msgs);
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
			case ImplementationPackage.SEMANTICS__IMPLEM:
				return basicSetImplem(null, msgs);
			case ImplementationPackage.SEMANTICS__CONCEPT:
				return basicSetConcept(null, msgs);
			case ImplementationPackage.SEMANTICS__OPERATION_REF:
				return basicSetOperationRef(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ImplementationPackage.SEMANTICS__CONCEPT:
				return eInternalContainer().eInverseRemove(this, ImplementationPackage.CONCEPT__SEMANTICS, Concept.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImplementationPackage.SEMANTICS__ID:
				return getId();
			case ImplementationPackage.SEMANTICS__IMPLEM:
				return getImplem();
			case ImplementationPackage.SEMANTICS__CONCEPT:
				return getConcept();
			case ImplementationPackage.SEMANTICS__OPERATION_REF:
				return getOperationRef();
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
			case ImplementationPackage.SEMANTICS__ID:
				setId((String)newValue);
				return;
			case ImplementationPackage.SEMANTICS__IMPLEM:
				setImplem((Method)newValue);
				return;
			case ImplementationPackage.SEMANTICS__CONCEPT:
				setConcept((Concept)newValue);
				return;
			case ImplementationPackage.SEMANTICS__OPERATION_REF:
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
			case ImplementationPackage.SEMANTICS__ID:
				setId(ID_EDEFAULT);
				return;
			case ImplementationPackage.SEMANTICS__IMPLEM:
				setImplem((Method)null);
				return;
			case ImplementationPackage.SEMANTICS__CONCEPT:
				setConcept((Concept)null);
				return;
			case ImplementationPackage.SEMANTICS__OPERATION_REF:
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
			case ImplementationPackage.SEMANTICS__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ImplementationPackage.SEMANTICS__IMPLEM:
				return implem != null;
			case ImplementationPackage.SEMANTICS__CONCEPT:
				return getConcept() != null;
			case ImplementationPackage.SEMANTICS__OPERATION_REF:
				return operationRef != null;
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
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} //SemanticsImpl
