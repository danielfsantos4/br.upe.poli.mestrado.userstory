/**
 */
package userstory.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import userstory.UserstoryPackage;
import userstory.end;
import userstory.means;
import userstory.role;
import userstory.spec;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link userstory.impl.specImpl#getFormat <em>Format</em>}</li>
 *   <li>{@link userstory.impl.specImpl#getOrigin <em>Origin</em>}</li>
 *   <li>{@link userstory.impl.specImpl#getRole <em>Role</em>}</li>
 *   <li>{@link userstory.impl.specImpl#getMeans <em>Means</em>}</li>
 *   <li>{@link userstory.impl.specImpl#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @generated
 */
public class specImpl extends MinimalEObjectImpl.Container implements spec {
	/**
	 * The default value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected static final String FORMAT_EDEFAULT = "\"as/i want/so that\"";

	/**
	 * The cached value of the '{@link #getFormat() <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFormat()
	 * @generated
	 * @ordered
	 */
	protected String format = FORMAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getOrigin() <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGIN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOrigin() <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOrigin()
	 * @generated
	 * @ordered
	 */
	protected String origin = ORIGIN_EDEFAULT;

	/**
	 * The cached value of the '{@link #getRole() <em>Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRole()
	 * @generated
	 * @ordered
	 */
	protected role role;

	/**
	 * The cached value of the '{@link #getMeans() <em>Means</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMeans()
	 * @generated
	 * @ordered
	 */
	protected means means;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected EList<end> end;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected specImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return UserstoryPackage.Literals.SPEC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFormat(String newFormat) {
		String oldFormat = format;
		format = newFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserstoryPackage.SPEC__FORMAT, oldFormat, format));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOrigin() {
		return origin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOrigin(String newOrigin) {
		String oldOrigin = origin;
		origin = newOrigin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserstoryPackage.SPEC__ORIGIN, oldOrigin, origin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public role getRole() {
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRole(role newRole, NotificationChain msgs) {
		role oldRole = role;
		role = newRole;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UserstoryPackage.SPEC__ROLE, oldRole, newRole);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRole(role newRole) {
		if (newRole != role) {
			NotificationChain msgs = null;
			if (role != null)
				msgs = ((InternalEObject)role).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UserstoryPackage.SPEC__ROLE, null, msgs);
			if (newRole != null)
				msgs = ((InternalEObject)newRole).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UserstoryPackage.SPEC__ROLE, null, msgs);
			msgs = basicSetRole(newRole, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserstoryPackage.SPEC__ROLE, newRole, newRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public means getMeans() {
		return means;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMeans(means newMeans, NotificationChain msgs) {
		means oldMeans = means;
		means = newMeans;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, UserstoryPackage.SPEC__MEANS, oldMeans, newMeans);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMeans(means newMeans) {
		if (newMeans != means) {
			NotificationChain msgs = null;
			if (means != null)
				msgs = ((InternalEObject)means).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - UserstoryPackage.SPEC__MEANS, null, msgs);
			if (newMeans != null)
				msgs = ((InternalEObject)newMeans).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - UserstoryPackage.SPEC__MEANS, null, msgs);
			msgs = basicSetMeans(newMeans, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, UserstoryPackage.SPEC__MEANS, newMeans, newMeans));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<end> getEnd() {
		if (end == null) {
			end = new EObjectContainmentEList<end>(end.class, this, UserstoryPackage.SPEC__END);
		}
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case UserstoryPackage.SPEC__ROLE:
				return basicSetRole(null, msgs);
			case UserstoryPackage.SPEC__MEANS:
				return basicSetMeans(null, msgs);
			case UserstoryPackage.SPEC__END:
				return ((InternalEList<?>)getEnd()).basicRemove(otherEnd, msgs);
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
			case UserstoryPackage.SPEC__FORMAT:
				return getFormat();
			case UserstoryPackage.SPEC__ORIGIN:
				return getOrigin();
			case UserstoryPackage.SPEC__ROLE:
				return getRole();
			case UserstoryPackage.SPEC__MEANS:
				return getMeans();
			case UserstoryPackage.SPEC__END:
				return getEnd();
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
			case UserstoryPackage.SPEC__FORMAT:
				setFormat((String)newValue);
				return;
			case UserstoryPackage.SPEC__ORIGIN:
				setOrigin((String)newValue);
				return;
			case UserstoryPackage.SPEC__ROLE:
				setRole((role)newValue);
				return;
			case UserstoryPackage.SPEC__MEANS:
				setMeans((means)newValue);
				return;
			case UserstoryPackage.SPEC__END:
				getEnd().clear();
				getEnd().addAll((Collection<? extends end>)newValue);
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
			case UserstoryPackage.SPEC__FORMAT:
				setFormat(FORMAT_EDEFAULT);
				return;
			case UserstoryPackage.SPEC__ORIGIN:
				setOrigin(ORIGIN_EDEFAULT);
				return;
			case UserstoryPackage.SPEC__ROLE:
				setRole((role)null);
				return;
			case UserstoryPackage.SPEC__MEANS:
				setMeans((means)null);
				return;
			case UserstoryPackage.SPEC__END:
				getEnd().clear();
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
			case UserstoryPackage.SPEC__FORMAT:
				return FORMAT_EDEFAULT == null ? format != null : !FORMAT_EDEFAULT.equals(format);
			case UserstoryPackage.SPEC__ORIGIN:
				return ORIGIN_EDEFAULT == null ? origin != null : !ORIGIN_EDEFAULT.equals(origin);
			case UserstoryPackage.SPEC__ROLE:
				return role != null;
			case UserstoryPackage.SPEC__MEANS:
				return means != null;
			case UserstoryPackage.SPEC__END:
				return end != null && !end.isEmpty();
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (format: ");
		result.append(format);
		result.append(", origin: ");
		result.append(origin);
		result.append(')');
		return result.toString();
	}

} //specImpl
