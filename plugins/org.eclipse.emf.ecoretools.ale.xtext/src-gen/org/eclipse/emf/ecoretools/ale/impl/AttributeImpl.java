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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecoretools.ale.AlePackage;
import org.eclipse.emf.ecoretools.ale.Attribute;
import org.eclipse.emf.ecoretools.ale.ExpressionStmt;
import org.eclipse.emf.ecoretools.ale.rOpposite;
import org.eclipse.emf.ecoretools.ale.rType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.impl.AttributeImpl#getModifier <em>Modifier</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.impl.AttributeImpl#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.impl.AttributeImpl#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.impl.AttributeImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.impl.AttributeImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.impl.AttributeImpl#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AttributeImpl extends MinimalEObjectImpl.Container implements Attribute
{
  /**
   * The default value of the '{@link #getModifier() <em>Modifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifier()
   * @generated
   * @ordered
   */
  protected static final String MODIFIER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getModifier() <em>Modifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModifier()
   * @generated
   * @ordered
   */
  protected String modifier = MODIFIER_EDEFAULT;

  /**
   * The default value of the '{@link #getBounds() <em>Bounds</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBounds()
   * @generated
   * @ordered
   */
  protected static final String BOUNDS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getBounds() <em>Bounds</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBounds()
   * @generated
   * @ordered
   */
  protected String bounds = BOUNDS_EDEFAULT;

  /**
   * The cached value of the '{@link #getOpposite() <em>Opposite</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOpposite()
   * @generated
   * @ordered
   */
  protected rOpposite opposite;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected rType type;

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
   * The cached value of the '{@link #getExp() <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExp()
   * @generated
   * @ordered
   */
  protected ExpressionStmt exp;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AttributeImpl()
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
    return AlePackage.Literals.ATTRIBUTE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getModifier()
  {
    return modifier;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setModifier(String newModifier)
  {
    String oldModifier = modifier;
    modifier = newModifier;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlePackage.ATTRIBUTE__MODIFIER, oldModifier, modifier));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String getBounds()
  {
    return bounds;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void setBounds(String newBounds)
  {
    String oldBounds = bounds;
    bounds = newBounds;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlePackage.ATTRIBUTE__BOUNDS, oldBounds, bounds));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public rOpposite getOpposite()
  {
    return opposite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOpposite(rOpposite newOpposite, NotificationChain msgs)
  {
    rOpposite oldOpposite = opposite;
    opposite = newOpposite;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlePackage.ATTRIBUTE__OPPOSITE, oldOpposite, newOpposite);
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
  public void setOpposite(rOpposite newOpposite)
  {
    if (newOpposite != opposite)
    {
      NotificationChain msgs = null;
      if (opposite != null)
        msgs = ((InternalEObject)opposite).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlePackage.ATTRIBUTE__OPPOSITE, null, msgs);
      if (newOpposite != null)
        msgs = ((InternalEObject)newOpposite).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlePackage.ATTRIBUTE__OPPOSITE, null, msgs);
      msgs = basicSetOpposite(newOpposite, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlePackage.ATTRIBUTE__OPPOSITE, newOpposite, newOpposite));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public rType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetType(rType newType, NotificationChain msgs)
  {
    rType oldType = type;
    type = newType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlePackage.ATTRIBUTE__TYPE, oldType, newType);
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
  public void setType(rType newType)
  {
    if (newType != type)
    {
      NotificationChain msgs = null;
      if (type != null)
        msgs = ((InternalEObject)type).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlePackage.ATTRIBUTE__TYPE, null, msgs);
      if (newType != null)
        msgs = ((InternalEObject)newType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlePackage.ATTRIBUTE__TYPE, null, msgs);
      msgs = basicSetType(newType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlePackage.ATTRIBUTE__TYPE, newType, newType));
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
      eNotify(new ENotificationImpl(this, Notification.SET, AlePackage.ATTRIBUTE__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ExpressionStmt getExp()
  {
    return exp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExp(ExpressionStmt newExp, NotificationChain msgs)
  {
    ExpressionStmt oldExp = exp;
    exp = newExp;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AlePackage.ATTRIBUTE__EXP, oldExp, newExp);
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
  public void setExp(ExpressionStmt newExp)
  {
    if (newExp != exp)
    {
      NotificationChain msgs = null;
      if (exp != null)
        msgs = ((InternalEObject)exp).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AlePackage.ATTRIBUTE__EXP, null, msgs);
      if (newExp != null)
        msgs = ((InternalEObject)newExp).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AlePackage.ATTRIBUTE__EXP, null, msgs);
      msgs = basicSetExp(newExp, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AlePackage.ATTRIBUTE__EXP, newExp, newExp));
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
      case AlePackage.ATTRIBUTE__OPPOSITE:
        return basicSetOpposite(null, msgs);
      case AlePackage.ATTRIBUTE__TYPE:
        return basicSetType(null, msgs);
      case AlePackage.ATTRIBUTE__EXP:
        return basicSetExp(null, msgs);
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
      case AlePackage.ATTRIBUTE__MODIFIER:
        return getModifier();
      case AlePackage.ATTRIBUTE__BOUNDS:
        return getBounds();
      case AlePackage.ATTRIBUTE__OPPOSITE:
        return getOpposite();
      case AlePackage.ATTRIBUTE__TYPE:
        return getType();
      case AlePackage.ATTRIBUTE__NAME:
        return getName();
      case AlePackage.ATTRIBUTE__EXP:
        return getExp();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AlePackage.ATTRIBUTE__MODIFIER:
        setModifier((String)newValue);
        return;
      case AlePackage.ATTRIBUTE__BOUNDS:
        setBounds((String)newValue);
        return;
      case AlePackage.ATTRIBUTE__OPPOSITE:
        setOpposite((rOpposite)newValue);
        return;
      case AlePackage.ATTRIBUTE__TYPE:
        setType((rType)newValue);
        return;
      case AlePackage.ATTRIBUTE__NAME:
        setName((String)newValue);
        return;
      case AlePackage.ATTRIBUTE__EXP:
        setExp((ExpressionStmt)newValue);
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
      case AlePackage.ATTRIBUTE__MODIFIER:
        setModifier(MODIFIER_EDEFAULT);
        return;
      case AlePackage.ATTRIBUTE__BOUNDS:
        setBounds(BOUNDS_EDEFAULT);
        return;
      case AlePackage.ATTRIBUTE__OPPOSITE:
        setOpposite((rOpposite)null);
        return;
      case AlePackage.ATTRIBUTE__TYPE:
        setType((rType)null);
        return;
      case AlePackage.ATTRIBUTE__NAME:
        setName(NAME_EDEFAULT);
        return;
      case AlePackage.ATTRIBUTE__EXP:
        setExp((ExpressionStmt)null);
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
      case AlePackage.ATTRIBUTE__MODIFIER:
        return MODIFIER_EDEFAULT == null ? modifier != null : !MODIFIER_EDEFAULT.equals(modifier);
      case AlePackage.ATTRIBUTE__BOUNDS:
        return BOUNDS_EDEFAULT == null ? bounds != null : !BOUNDS_EDEFAULT.equals(bounds);
      case AlePackage.ATTRIBUTE__OPPOSITE:
        return opposite != null;
      case AlePackage.ATTRIBUTE__TYPE:
        return type != null;
      case AlePackage.ATTRIBUTE__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case AlePackage.ATTRIBUTE__EXP:
        return exp != null;
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
    result.append(" (modifier: ");
    result.append(modifier);
    result.append(", bounds: ");
    result.append(bounds);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //AttributeImpl
