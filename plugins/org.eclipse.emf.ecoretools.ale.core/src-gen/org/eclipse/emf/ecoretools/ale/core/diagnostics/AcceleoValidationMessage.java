/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Acceleo Validation Message</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage#getMessage <em>Message</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage#getLevel <em>Level</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getAcceleoValidationMessage()
 * @model
 * @generated
 */
public interface AcceleoValidationMessage extends Message {
	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getAcceleoValidationMessage_Message()
	 * @model
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #setLevel(ValidationMessageLevel)
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getAcceleoValidationMessage_Level()
	 * @model dataType="org.eclipse.emf.ecoretools.ale.core.diagnostics.ValidationMessageLevel"
	 * @generated
	 */
	ValidationMessageLevel getLevel();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(ValidationMessageLevel value);

} // AcceleoValidationMessage
