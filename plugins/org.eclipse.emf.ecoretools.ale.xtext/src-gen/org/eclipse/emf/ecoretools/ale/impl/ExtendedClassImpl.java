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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.util.EDataTypeEList;

import org.eclipse.emf.ecoretools.ale.AlePackage;
import org.eclipse.emf.ecoretools.ale.ExtendedClass;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Extended Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.impl.ExtendedClassImpl#getExtends <em>Extends</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExtendedClassImpl extends BehavioredClassImpl implements ExtendedClass
{
  /**
   * The cached value of the '{@link #getExtends() <em>Extends</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExtends()
   * @generated
   * @ordered
   */
  protected EList<String> extends_;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExtendedClassImpl()
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
    return AlePackage.Literals.EXTENDED_CLASS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EList<String> getExtends()
  {
    if (extends_ == null)
    {
      extends_ = new EDataTypeEList<String>(String.class, this, AlePackage.EXTENDED_CLASS__EXTENDS);
    }
    return extends_;
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
      case AlePackage.EXTENDED_CLASS__EXTENDS:
        return getExtends();
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
      case AlePackage.EXTENDED_CLASS__EXTENDS:
        getExtends().clear();
        getExtends().addAll((Collection<? extends String>)newValue);
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
      case AlePackage.EXTENDED_CLASS__EXTENDS:
        getExtends().clear();
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
      case AlePackage.EXTENDED_CLASS__EXTENDS:
        return extends_ != null && !extends_.isEmpty();
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
    result.append(" (extends: ");
    result.append(extends_);
    result.append(')');
    return result.toString();
  }

} //ExtendedClassImpl
