/**
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Inria - initial API and implementation
 * 
 * generated by Xtext 2.24.0
 */
package org.eclipse.emf.ecoretools.ale.impl;

import java.lang.String;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ecoretools.ale.AlePackage;
import org.eclipse.emf.ecoretools.ale.Apply;
import org.eclipse.emf.ecoretools.ale.Expression;
import org.eclipse.emf.ecoretools.ale.typeLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Apply</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.impl.ApplyImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.impl.ApplyImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.impl.ApplyImpl#getVarName <em>Var Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.impl.ApplyImpl#getVarType <em>Var Type</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.impl.ApplyImpl#getLambda <em>Lambda</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.impl.ApplyImpl#getParams <em>Params</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ApplyImpl extends ExpressionImpl implements Apply
{
  /**
   * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTarget()
   * @generated
   * @ordered
   */
  protected Expression target;

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
   * The default value of the '{@link #getVarName() <em>Var Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVarName()
   * @generated
   * @ordered
   */
  protected static final String VAR_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getVarName() <em>Var Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVarName()
   * @generated
   * @ordered
   */
  protected String varName = VAR_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getVarType() <em>Var Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getVarType()
   * @generated
   * @ordered
   */
  protected typeLiteral varType;

  /**
   * The cached value of the '{@link #getLambda() <em>Lambda</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLambda()
   * @generated
   * @ordered
   */
  protected Expression lambda;

  /**
   * The cached value of the '{@link #getParams() <em>Params</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getParams()
   * @generated
   * @ordered
   */
  protected EList<Expression> params;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ApplyImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return AlePackage.Literals.APPLY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getTarget()
  {
    return target;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTarget(Expression newTarget, NotificationChain msgs)
  {
    Expression oldTarget = target;
    target = newTarget;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlePackage.APPLY__TARGET, oldTarget, newTarget);
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
  public void setTarget(Expression newTarget)
  {
    if (newTarget != target)
    {
      NotificationChain msgs = null;
      if (target != null)
        msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlePackage.APPLY__TARGET, null, msgs);
      if (newTarget != null)
        msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlePackage.APPLY__TARGET, null, msgs);
      msgs = basicSetTarget(newTarget, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlePackage.APPLY__TARGET, newTarget, newTarget));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlePackage.APPLY__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getVarName()
  {
    return varName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setVarName(String newVarName)
  {
    String oldVarName = varName;
    varName = newVarName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlePackage.APPLY__VAR_NAME, oldVarName, varName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public typeLiteral getVarType()
  {
    return varType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetVarType(typeLiteral newVarType, NotificationChain msgs)
  {
    typeLiteral oldVarType = varType;
    varType = newVarType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlePackage.APPLY__VAR_TYPE, oldVarType, newVarType);
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
  public void setVarType(typeLiteral newVarType)
  {
    if (newVarType != varType)
    {
      NotificationChain msgs = null;
      if (varType != null)
        msgs = ((InternalEObject)varType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlePackage.APPLY__VAR_TYPE, null, msgs);
      if (newVarType != null)
        msgs = ((InternalEObject)newVarType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlePackage.APPLY__VAR_TYPE, null, msgs);
      msgs = basicSetVarType(newVarType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlePackage.APPLY__VAR_TYPE, newVarType, newVarType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Expression getLambda()
  {
    return lambda;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLambda(Expression newLambda, NotificationChain msgs)
  {
    Expression oldLambda = lambda;
    lambda = newLambda;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlePackage.APPLY__LAMBDA, oldLambda, newLambda);
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
  public void setLambda(Expression newLambda)
  {
    if (newLambda != lambda)
    {
      NotificationChain msgs = null;
      if (lambda != null)
        msgs = ((InternalEObject)lambda).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlePackage.APPLY__LAMBDA, null, msgs);
      if (newLambda != null)
        msgs = ((InternalEObject)newLambda).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlePackage.APPLY__LAMBDA, null, msgs);
      msgs = basicSetLambda(newLambda, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlePackage.APPLY__LAMBDA, newLambda, newLambda));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<Expression> getParams()
  {
    if (params == null)
    {
      params = new EObjectContainmentEList<Expression>(Expression.class, this, AlePackage.APPLY__PARAMS);
    }
    return params;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AlePackage.APPLY__TARGET:
        return basicSetTarget(null, msgs);
      case AlePackage.APPLY__VAR_TYPE:
        return basicSetVarType(null, msgs);
      case AlePackage.APPLY__LAMBDA:
        return basicSetLambda(null, msgs);
      case AlePackage.APPLY__PARAMS:
        return ((InternalEList<?>)getParams()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case AlePackage.APPLY__TARGET:
        return getTarget();
      case AlePackage.APPLY__NAME:
        return getName();
      case AlePackage.APPLY__VAR_NAME:
        return getVarName();
      case AlePackage.APPLY__VAR_TYPE:
        return getVarType();
      case AlePackage.APPLY__LAMBDA:
        return getLambda();
      case AlePackage.APPLY__PARAMS:
        return getParams();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AlePackage.APPLY__TARGET:
        setTarget((Expression)newValue);
        return;
      case AlePackage.APPLY__NAME:
        setName((String)newValue);
        return;
      case AlePackage.APPLY__VAR_NAME:
        setVarName((String)newValue);
        return;
      case AlePackage.APPLY__VAR_TYPE:
        setVarType((typeLiteral)newValue);
        return;
      case AlePackage.APPLY__LAMBDA:
        setLambda((Expression)newValue);
        return;
      case AlePackage.APPLY__PARAMS:
        getParams().clear();
        getParams().addAll((Collection<? extends Expression>)newValue);
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
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case AlePackage.APPLY__TARGET:
        setTarget((Expression)null);
        return;
      case AlePackage.APPLY__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AlePackage.APPLY__VAR_NAME:
        setVarName(VAR_NAME_EDEFAULT);
        return;
      case AlePackage.APPLY__VAR_TYPE:
        setVarType((typeLiteral)null);
        return;
      case AlePackage.APPLY__LAMBDA:
        setLambda((Expression)null);
        return;
      case AlePackage.APPLY__PARAMS:
        getParams().clear();
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
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case AlePackage.APPLY__TARGET:
        return target != null;
      case AlePackage.APPLY__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AlePackage.APPLY__VAR_NAME:
        return VAR_NAME_EDEFAULT == null ? varName != null : !VAR_NAME_EDEFAULT.equals(varName);
      case AlePackage.APPLY__VAR_TYPE:
        return varType != null;
      case AlePackage.APPLY__LAMBDA:
        return lambda != null;
      case AlePackage.APPLY__PARAMS:
        return params != null && !params.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuilder result = new StringBuilder(super.toString());
    result.append(" (name: ");
    result.append(name);
    result.append(", varName: ");
    result.append(varName);
    result.append(')');
    return result.toString();
  }

} //ApplyImpl
