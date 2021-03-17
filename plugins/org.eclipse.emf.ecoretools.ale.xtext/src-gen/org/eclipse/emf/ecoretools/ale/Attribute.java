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
package org.eclipse.emf.ecoretools.ale;

import java.lang.String;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Attribute</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.Attribute#getModifier <em>Modifier</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.Attribute#getBounds <em>Bounds</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.Attribute#getOpposite <em>Opposite</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.Attribute#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.Attribute#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.Attribute#getExp <em>Exp</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.AlePackage#getAttribute()
 * @model
 * @generated
 */
public interface Attribute extends EObject
{
  /**
   * Returns the value of the '<em><b>Modifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modifier</em>' attribute.
   * @see #setModifier(String)
   * @see org.eclipse.emf.ecoretools.ale.AlePackage#getAttribute_Modifier()
   * @model
   * @generated
   */
  String getModifier();

  /**
   * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.Attribute#getModifier <em>Modifier</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Modifier</em>' attribute.
   * @see #getModifier()
   * @generated
   */
  void setModifier(String value);

  /**
   * Returns the value of the '<em><b>Bounds</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bounds</em>' attribute.
   * @see #setBounds(String)
   * @see org.eclipse.emf.ecoretools.ale.AlePackage#getAttribute_Bounds()
   * @model
   * @generated
   */
  String getBounds();

  /**
   * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.Attribute#getBounds <em>Bounds</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bounds</em>' attribute.
   * @see #getBounds()
   * @generated
   */
  void setBounds(String value);

  /**
   * Returns the value of the '<em><b>Opposite</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Opposite</em>' containment reference.
   * @see #setOpposite(rOpposite)
   * @see org.eclipse.emf.ecoretools.ale.AlePackage#getAttribute_Opposite()
   * @model containment="true"
   * @generated
   */
  rOpposite getOpposite();

  /**
   * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.Attribute#getOpposite <em>Opposite</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Opposite</em>' containment reference.
   * @see #getOpposite()
   * @generated
   */
  void setOpposite(rOpposite value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(rType)
   * @see org.eclipse.emf.ecoretools.ale.AlePackage#getAttribute_Type()
   * @model containment="true"
   * @generated
   */
  rType getType();

  /**
   * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.Attribute#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(rType value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.emf.ecoretools.ale.AlePackage#getAttribute_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.Attribute#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference.
   * @see #setExp(ExpressionStmt)
   * @see org.eclipse.emf.ecoretools.ale.AlePackage#getAttribute_Exp()
   * @model containment="true"
   * @generated
   */
  ExpressionStmt getExp();

  /**
   * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.Attribute#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(ExpressionStmt value);

} // Attribute
