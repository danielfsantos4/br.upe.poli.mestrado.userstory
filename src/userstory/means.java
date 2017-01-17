/**
 */
package userstory;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>means</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link userstory.means#getValue <em>Value</em>}</li>
 *   <li>{@link userstory.means#getVerb <em>Verb</em>}</li>
 * </ul>
 *
 * @see userstory.UserstoryPackage#getmeans()
 * @model
 * @generated
 */
public interface means extends EObject {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see userstory.UserstoryPackage#getmeans_Value()
	 * @model default=""
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link userstory.means#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Verb</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verb</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Verb</em>' containment reference.
	 * @see #setVerb(actionVerb)
	 * @see userstory.UserstoryPackage#getmeans_Verb()
	 * @model containment="true"
	 * @generated
	 */
	actionVerb getVerb();

	/**
	 * Sets the value of the '{@link userstory.means#getVerb <em>Verb</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Verb</em>' containment reference.
	 * @see #getVerb()
	 * @generated
	 */
	void setVerb(actionVerb value);

} // means
