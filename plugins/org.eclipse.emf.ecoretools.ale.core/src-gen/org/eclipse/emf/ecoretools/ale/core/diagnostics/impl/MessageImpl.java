/**
 */
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Context;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsPackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Message</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MessageImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MessageImpl#getStacktrace <em>Stacktrace</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MessageImpl#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MessageImpl#getWholeCode <em>Whole Code</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MessageImpl#getIncriminatedCode <em>Incriminated Code</em>}</li>
 *   <li>{@link org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.MessageImpl#getSource <em>Source</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MessageImpl extends MinimalEObjectImpl.Container implements Message {
	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected CodeLocation location;

	/**
	 * The cached value of the '{@link #getStacktrace() <em>Stacktrace</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStacktrace()
	 * @generated
	 * @ordered
	 */
	protected EList<CodeLocation> stacktrace;

	/**
	 * The cached value of the '{@link #getContext() <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContext()
	 * @generated
	 * @ordered
	 */
	protected Context context;

	/**
	 * The default value of the '{@link #getWholeCode() <em>Whole Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWholeCode()
	 * @generated
	 * @ordered
	 */
	protected static final String WHOLE_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getWholeCode() <em>Whole Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWholeCode()
	 * @generated
	 * @ordered
	 */
	protected String wholeCode = WHOLE_CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getIncriminatedCode() <em>Incriminated Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncriminatedCode()
	 * @generated
	 * @ordered
	 */
	protected static final String INCRIMINATED_CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getIncriminatedCode() <em>Incriminated Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncriminatedCode()
	 * @generated
	 * @ordered
	 */
	protected String incriminatedCode = INCRIMINATED_CODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected EObject source;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MessageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagnosticsPackage.Literals.MESSAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CodeLocation getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocation(CodeLocation newLocation, NotificationChain msgs) {
		CodeLocation oldLocation = location;
		location = newLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.MESSAGE__LOCATION, oldLocation, newLocation);
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
	public void setLocation(CodeLocation newLocation) {
		if (newLocation != location) {
			NotificationChain msgs = null;
			if (location != null)
				msgs = ((InternalEObject)location).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagnosticsPackage.MESSAGE__LOCATION, null, msgs);
			if (newLocation != null)
				msgs = ((InternalEObject)newLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagnosticsPackage.MESSAGE__LOCATION, null, msgs);
			msgs = basicSetLocation(newLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.MESSAGE__LOCATION, newLocation, newLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CodeLocation> getStacktrace() {
		if (stacktrace == null) {
			stacktrace = new EObjectContainmentEList<CodeLocation>(CodeLocation.class, this, DiagnosticsPackage.MESSAGE__STACKTRACE);
		}
		return stacktrace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Context getContext() {
		return context;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContext(Context newContext, NotificationChain msgs) {
		Context oldContext = context;
		context = newContext;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.MESSAGE__CONTEXT, oldContext, newContext);
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
	public void setContext(Context newContext) {
		if (newContext != context) {
			NotificationChain msgs = null;
			if (context != null)
				msgs = ((InternalEObject)context).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagnosticsPackage.MESSAGE__CONTEXT, null, msgs);
			if (newContext != null)
				msgs = ((InternalEObject)newContext).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagnosticsPackage.MESSAGE__CONTEXT, null, msgs);
			msgs = basicSetContext(newContext, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.MESSAGE__CONTEXT, newContext, newContext));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getWholeCode() {
		return wholeCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWholeCode(String newWholeCode) {
		String oldWholeCode = wholeCode;
		wholeCode = newWholeCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.MESSAGE__WHOLE_CODE, oldWholeCode, wholeCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getIncriminatedCode() {
		return incriminatedCode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIncriminatedCode(String newIncriminatedCode) {
		String oldIncriminatedCode = incriminatedCode;
		incriminatedCode = newIncriminatedCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.MESSAGE__INCRIMINATED_CODE, oldIncriminatedCode, incriminatedCode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagnosticsPackage.MESSAGE__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSource(EObject newSource) {
		EObject oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagnosticsPackage.MESSAGE__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagnosticsPackage.MESSAGE__LOCATION:
				return basicSetLocation(null, msgs);
			case DiagnosticsPackage.MESSAGE__STACKTRACE:
				return ((InternalEList<?>)getStacktrace()).basicRemove(otherEnd, msgs);
			case DiagnosticsPackage.MESSAGE__CONTEXT:
				return basicSetContext(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagnosticsPackage.MESSAGE__LOCATION:
				return getLocation();
			case DiagnosticsPackage.MESSAGE__STACKTRACE:
				return getStacktrace();
			case DiagnosticsPackage.MESSAGE__CONTEXT:
				return getContext();
			case DiagnosticsPackage.MESSAGE__WHOLE_CODE:
				return getWholeCode();
			case DiagnosticsPackage.MESSAGE__INCRIMINATED_CODE:
				return getIncriminatedCode();
			case DiagnosticsPackage.MESSAGE__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
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
			case DiagnosticsPackage.MESSAGE__LOCATION:
				setLocation((CodeLocation)newValue);
				return;
			case DiagnosticsPackage.MESSAGE__STACKTRACE:
				getStacktrace().clear();
				getStacktrace().addAll((Collection<? extends CodeLocation>)newValue);
				return;
			case DiagnosticsPackage.MESSAGE__CONTEXT:
				setContext((Context)newValue);
				return;
			case DiagnosticsPackage.MESSAGE__WHOLE_CODE:
				setWholeCode((String)newValue);
				return;
			case DiagnosticsPackage.MESSAGE__INCRIMINATED_CODE:
				setIncriminatedCode((String)newValue);
				return;
			case DiagnosticsPackage.MESSAGE__SOURCE:
				setSource((EObject)newValue);
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
			case DiagnosticsPackage.MESSAGE__LOCATION:
				setLocation((CodeLocation)null);
				return;
			case DiagnosticsPackage.MESSAGE__STACKTRACE:
				getStacktrace().clear();
				return;
			case DiagnosticsPackage.MESSAGE__CONTEXT:
				setContext((Context)null);
				return;
			case DiagnosticsPackage.MESSAGE__WHOLE_CODE:
				setWholeCode(WHOLE_CODE_EDEFAULT);
				return;
			case DiagnosticsPackage.MESSAGE__INCRIMINATED_CODE:
				setIncriminatedCode(INCRIMINATED_CODE_EDEFAULT);
				return;
			case DiagnosticsPackage.MESSAGE__SOURCE:
				setSource((EObject)null);
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
			case DiagnosticsPackage.MESSAGE__LOCATION:
				return location != null;
			case DiagnosticsPackage.MESSAGE__STACKTRACE:
				return stacktrace != null && !stacktrace.isEmpty();
			case DiagnosticsPackage.MESSAGE__CONTEXT:
				return context != null;
			case DiagnosticsPackage.MESSAGE__WHOLE_CODE:
				return WHOLE_CODE_EDEFAULT == null ? wholeCode != null : !WHOLE_CODE_EDEFAULT.equals(wholeCode);
			case DiagnosticsPackage.MESSAGE__INCRIMINATED_CODE:
				return INCRIMINATED_CODE_EDEFAULT == null ? incriminatedCode != null : !INCRIMINATED_CODE_EDEFAULT.equals(incriminatedCode);
			case DiagnosticsPackage.MESSAGE__SOURCE:
				return source != null;
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
		result.append(" (wholeCode: ");
		result.append(wholeCode);
		result.append(", incriminatedCode: ");
		result.append(incriminatedCode);
		result.append(')');
		return result.toString();
	}

} //MessageImpl
