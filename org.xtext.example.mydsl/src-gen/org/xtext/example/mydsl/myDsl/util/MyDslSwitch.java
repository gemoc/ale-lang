/**
 * generated by Xtext 2.10.0
 */
package org.xtext.example.mydsl.myDsl.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.xtext.example.mydsl.myDsl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.xtext.example.mydsl.myDsl.MyDslPackage
 * @generated
 */
public class MyDslSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static MyDslPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MyDslSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = MyDslPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case MyDslPackage.RROOT:
      {
        rRoot rRoot = (rRoot)theEObject;
        T result = caserRoot(rRoot);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.RCLASS:
      {
        rClass rClass = (rClass)theEObject;
        T result = caserClass(rClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.ROPEN_CLASS:
      {
        rOpenClass rOpenClass = (rOpenClass)theEObject;
        T result = caserOpenClass(rOpenClass);
        if (result == null) result = caserClass(rOpenClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.RNEW_CLASS:
      {
        rNewClass rNewClass = (rNewClass)theEObject;
        T result = caserNewClass(rNewClass);
        if (result == null) result = caserClass(rNewClass);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.ROPERATION:
      {
        rOperation rOperation = (rOperation)theEObject;
        T result = caserOperation(rOperation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.RPARAMETERS:
      {
        rParameters rParameters = (rParameters)theEObject;
        T result = caserParameters(rParameters);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.RVARIABLE:
      {
        rVariable rVariable = (rVariable)theEObject;
        T result = caserVariable(rVariable);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case MyDslPackage.RATTRIBUTE:
      {
        rAttribute rAttribute = (rAttribute)theEObject;
        T result = caserAttribute(rAttribute);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>rRoot</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>rRoot</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caserRoot(rRoot object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>rClass</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>rClass</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caserClass(rClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>rOpen Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>rOpen Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caserOpenClass(rOpenClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>rNew Class</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>rNew Class</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caserNewClass(rNewClass object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>rOperation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>rOperation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caserOperation(rOperation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>rParameters</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>rParameters</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caserParameters(rParameters object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>rVariable</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>rVariable</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caserVariable(rVariable object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>rAttribute</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>rAttribute</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caserAttribute(rAttribute object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //MyDslSwitch