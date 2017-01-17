/**
 */
package userstory;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see userstory.UserstoryPackage
 * @generated
 */
public interface UserstoryFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UserstoryFactory eINSTANCE = userstory.impl.UserstoryFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>spec</em>'.
	 * @generated
	 */
	spec createspec();

	/**
	 * Returns a new object of class '<em>role</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>role</em>'.
	 * @generated
	 */
	role createrole();

	/**
	 * Returns a new object of class '<em>means</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>means</em>'.
	 * @generated
	 */
	means createmeans();

	/**
	 * Returns a new object of class '<em>end</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>end</em>'.
	 * @generated
	 */
	end createend();

	/**
	 * Returns a new object of class '<em>action Verb</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>action Verb</em>'.
	 * @generated
	 */
	actionVerb createactionVerb();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UserstoryPackage getUserstoryPackage();

} //UserstoryFactory
