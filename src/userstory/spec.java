/**
 */
package userstory;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link userstory.spec#getFormat <em>Format</em>}</li>
 *   <li>{@link userstory.spec#getOrigin <em>Origin</em>}</li>
 *   <li>{@link userstory.spec#getRole <em>Role</em>}</li>
 *   <li>{@link userstory.spec#getMeans <em>Means</em>}</li>
 *   <li>{@link userstory.spec#getEnd <em>End</em>}</li>
 * </ul>
 *
 * @see userstory.UserstoryPackage#getspec()
 * @model
 * @generated
 */
public interface spec extends EObject {
	/**
	 * Returns the value of the '<em><b>Format</b></em>' attribute.
	 * The default value is <code>"\"as/i want/so that\""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Format</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Format</em>' attribute.
	 * @see #setFormat(String)
	 * @see userstory.UserstoryPackage#getspec_Format()
	 * @model default="\"as/i want/so that\""
	 * @generated
	 */
	String getFormat();

	/**
	 * Sets the value of the '{@link userstory.spec#getFormat <em>Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Format</em>' attribute.
	 * @see #getFormat()
	 * @generated
	 */
	void setFormat(String value);

	/**
	 * Returns the value of the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Origin</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Origin</em>' attribute.
	 * @see #setOrigin(String)
	 * @see userstory.UserstoryPackage#getspec_Origin()
	 * @model
	 * @generated
	 */
	String getOrigin();

	/**
	 * Sets the value of the '{@link userstory.spec#getOrigin <em>Origin</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Origin</em>' attribute.
	 * @see #getOrigin()
	 * @generated
	 */
	void setOrigin(String value);

	/**
	 * Returns the value of the '<em><b>Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role</em>' containment reference.
	 * @see #setRole(role)
	 * @see userstory.UserstoryPackage#getspec_Role()
	 * @model containment="true" required="true"
	 * @generated
	 */
	role getRole();

	/**
	 * Sets the value of the '{@link userstory.spec#getRole <em>Role</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role</em>' containment reference.
	 * @see #getRole()
	 * @generated
	 */
	void setRole(role value);

	/**
	 * Returns the value of the '<em><b>Means</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Means</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Means</em>' containment reference.
	 * @see #setMeans(means)
	 * @see userstory.UserstoryPackage#getspec_Means()
	 * @model containment="true" required="true"
	 * @generated
	 */
	means getMeans();

	/**
	 * Sets the value of the '{@link userstory.spec#getMeans <em>Means</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Means</em>' containment reference.
	 * @see #getMeans()
	 * @generated
	 */
	void setMeans(means value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' containment reference list.
	 * The list contents are of type {@link userstory.end}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' containment reference list.
	 * @see userstory.UserstoryPackage#getspec_End()
	 * @model containment="true"
	 * @generated
	 */
	EList<end> getEnd();

} // spec
