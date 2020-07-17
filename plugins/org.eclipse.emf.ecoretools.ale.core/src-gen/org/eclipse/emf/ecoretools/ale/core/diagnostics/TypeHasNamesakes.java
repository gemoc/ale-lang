/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClassifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Has Namesakes</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeHasNamesakes#getNamesakes <em>Namesakes</em>}</li>
 * </ul>
 *
 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getTypeHasNamesakes()
 * @model
 * @generated
 */
public interface TypeHasNamesakes extends Message {
	/**
	 * Returns the value of the '<em><b>Namesakes</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EClassifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namesakes</em>' reference list.
	 * @see org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage#getTypeHasNamesakes_Namesakes()
	 * @model
	 * @generated
	 */
	EList<EClassifier> getNamesakes();

} // TypeHasNamesakes
