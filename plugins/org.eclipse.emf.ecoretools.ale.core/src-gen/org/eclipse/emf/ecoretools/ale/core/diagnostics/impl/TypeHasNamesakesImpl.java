/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeHasNamesakes;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Has Namesakes</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.TypeHasNamesakesImpl#getNamesakes <em>Namesakes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeHasNamesakesImpl extends MessageImpl implements TypeHasNamesakes {
	/**
	 * The cached value of the '{@link #getNamesakes() <em>Namesakes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamesakes()
	 * @generated
	 * @ordered
	 */
	protected EList<EClassifier> namesakes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeHasNamesakesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.TYPE_HAS_NAMESAKES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EClassifier> getNamesakes() {
		if (namesakes == null) {
			namesakes = new EObjectResolvingEList<EClassifier>(EClassifier.class, this, DiagnosticsPackage.TYPE_HAS_NAMESAKES__NAMESAKES);
		}
		return namesakes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.TYPE_HAS_NAMESAKES__NAMESAKES:
				return getNamesakes();
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
			case DiagnosticsPackage.TYPE_HAS_NAMESAKES__NAMESAKES:
				getNamesakes().clear();
				getNamesakes().addAll((Collection<? extends EClassifier>)newValue);
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
			case DiagnosticsPackage.TYPE_HAS_NAMESAKES__NAMESAKES:
				getNamesakes().clear();
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
			case DiagnosticsPackage.TYPE_HAS_NAMESAKES__NAMESAKES:
				return namesakes != null && !namesakes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TypeHasNamesakesImpl
