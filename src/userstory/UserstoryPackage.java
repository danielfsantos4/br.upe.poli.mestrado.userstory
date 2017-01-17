/**
 */
package userstory;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see userstory.UserstoryFactory
 * @model kind="package"
 * @generated
 */
public interface UserstoryPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "userstory";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.upe.br/userstory/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "userstory";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UserstoryPackage eINSTANCE = userstory.impl.UserstoryPackageImpl.init();

	/**
	 * The meta object id for the '{@link userstory.impl.specImpl <em>spec</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see userstory.impl.specImpl
	 * @see userstory.impl.UserstoryPackageImpl#getspec()
	 * @generated
	 */
	int SPEC = 0;

	/**
	 * The feature id for the '<em><b>Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEC__FORMAT = 0;

	/**
	 * The feature id for the '<em><b>Origin</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEC__ORIGIN = 1;

	/**
	 * The feature id for the '<em><b>Role</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEC__ROLE = 2;

	/**
	 * The feature id for the '<em><b>Means</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEC__MEANS = 3;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEC__END = 4;

	/**
	 * The number of structural features of the '<em>spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEC_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>spec</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPEC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link userstory.impl.roleImpl <em>role</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see userstory.impl.roleImpl
	 * @see userstory.impl.UserstoryPackageImpl#getrole()
	 * @generated
	 */
	int ROLE = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE__VALUE = 0;

	/**
	 * The number of structural features of the '<em>role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>role</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link userstory.impl.meansImpl <em>means</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see userstory.impl.meansImpl
	 * @see userstory.impl.UserstoryPackageImpl#getmeans()
	 * @generated
	 */
	int MEANS = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Verb</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS__VERB = 1;

	/**
	 * The number of structural features of the '<em>means</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>means</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEANS_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link userstory.impl.endImpl <em>end</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see userstory.impl.endImpl
	 * @see userstory.impl.UserstoryPackageImpl#getend()
	 * @generated
	 */
	int END = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END__VALUE = 0;

	/**
	 * The number of structural features of the '<em>end</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>end</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link userstory.impl.actionVerbImpl <em>action Verb</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see userstory.impl.actionVerbImpl
	 * @see userstory.impl.UserstoryPackageImpl#getactionVerb()
	 * @generated
	 */
	int ACTION_VERB = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_VERB__VALUE = 0;

	/**
	 * The number of structural features of the '<em>action Verb</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_VERB_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>action Verb</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_VERB_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link userstory.spec <em>spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>spec</em>'.
	 * @see userstory.spec
	 * @generated
	 */
	EClass getspec();

	/**
	 * Returns the meta object for the attribute '{@link userstory.spec#getFormat <em>Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Format</em>'.
	 * @see userstory.spec#getFormat()
	 * @see #getspec()
	 * @generated
	 */
	EAttribute getspec_Format();

	/**
	 * Returns the meta object for the attribute '{@link userstory.spec#getOrigin <em>Origin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Origin</em>'.
	 * @see userstory.spec#getOrigin()
	 * @see #getspec()
	 * @generated
	 */
	EAttribute getspec_Origin();

	/**
	 * Returns the meta object for the containment reference '{@link userstory.spec#getRole <em>Role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Role</em>'.
	 * @see userstory.spec#getRole()
	 * @see #getspec()
	 * @generated
	 */
	EReference getspec_Role();

	/**
	 * Returns the meta object for the containment reference '{@link userstory.spec#getMeans <em>Means</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Means</em>'.
	 * @see userstory.spec#getMeans()
	 * @see #getspec()
	 * @generated
	 */
	EReference getspec_Means();

	/**
	 * Returns the meta object for the containment reference list '{@link userstory.spec#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>End</em>'.
	 * @see userstory.spec#getEnd()
	 * @see #getspec()
	 * @generated
	 */
	EReference getspec_End();

	/**
	 * Returns the meta object for class '{@link userstory.role <em>role</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>role</em>'.
	 * @see userstory.role
	 * @generated
	 */
	EClass getrole();

	/**
	 * Returns the meta object for the attribute '{@link userstory.role#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see userstory.role#getValue()
	 * @see #getrole()
	 * @generated
	 */
	EAttribute getrole_Value();

	/**
	 * Returns the meta object for class '{@link userstory.means <em>means</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>means</em>'.
	 * @see userstory.means
	 * @generated
	 */
	EClass getmeans();

	/**
	 * Returns the meta object for the attribute '{@link userstory.means#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see userstory.means#getValue()
	 * @see #getmeans()
	 * @generated
	 */
	EAttribute getmeans_Value();

	/**
	 * Returns the meta object for the containment reference '{@link userstory.means#getVerb <em>Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Verb</em>'.
	 * @see userstory.means#getVerb()
	 * @see #getmeans()
	 * @generated
	 */
	EReference getmeans_Verb();

	/**
	 * Returns the meta object for class '{@link userstory.end <em>end</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>end</em>'.
	 * @see userstory.end
	 * @generated
	 */
	EClass getend();

	/**
	 * Returns the meta object for the attribute '{@link userstory.end#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see userstory.end#getValue()
	 * @see #getend()
	 * @generated
	 */
	EAttribute getend_Value();

	/**
	 * Returns the meta object for class '{@link userstory.actionVerb <em>action Verb</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>action Verb</em>'.
	 * @see userstory.actionVerb
	 * @generated
	 */
	EClass getactionVerb();

	/**
	 * Returns the meta object for the attribute '{@link userstory.actionVerb#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see userstory.actionVerb#getValue()
	 * @see #getactionVerb()
	 * @generated
	 */
	EAttribute getactionVerb_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	UserstoryFactory getUserstoryFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link userstory.impl.specImpl <em>spec</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see userstory.impl.specImpl
		 * @see userstory.impl.UserstoryPackageImpl#getspec()
		 * @generated
		 */
		EClass SPEC = eINSTANCE.getspec();

		/**
		 * The meta object literal for the '<em><b>Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPEC__FORMAT = eINSTANCE.getspec_Format();

		/**
		 * The meta object literal for the '<em><b>Origin</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SPEC__ORIGIN = eINSTANCE.getspec_Origin();

		/**
		 * The meta object literal for the '<em><b>Role</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPEC__ROLE = eINSTANCE.getspec_Role();

		/**
		 * The meta object literal for the '<em><b>Means</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPEC__MEANS = eINSTANCE.getspec_Means();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPEC__END = eINSTANCE.getspec_End();

		/**
		 * The meta object literal for the '{@link userstory.impl.roleImpl <em>role</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see userstory.impl.roleImpl
		 * @see userstory.impl.UserstoryPackageImpl#getrole()
		 * @generated
		 */
		EClass ROLE = eINSTANCE.getrole();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROLE__VALUE = eINSTANCE.getrole_Value();

		/**
		 * The meta object literal for the '{@link userstory.impl.meansImpl <em>means</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see userstory.impl.meansImpl
		 * @see userstory.impl.UserstoryPackageImpl#getmeans()
		 * @generated
		 */
		EClass MEANS = eINSTANCE.getmeans();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEANS__VALUE = eINSTANCE.getmeans_Value();

		/**
		 * The meta object literal for the '<em><b>Verb</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEANS__VERB = eINSTANCE.getmeans_Verb();

		/**
		 * The meta object literal for the '{@link userstory.impl.endImpl <em>end</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see userstory.impl.endImpl
		 * @see userstory.impl.UserstoryPackageImpl#getend()
		 * @generated
		 */
		EClass END = eINSTANCE.getend();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute END__VALUE = eINSTANCE.getend_Value();

		/**
		 * The meta object literal for the '{@link userstory.impl.actionVerbImpl <em>action Verb</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see userstory.impl.actionVerbImpl
		 * @see userstory.impl.UserstoryPackageImpl#getactionVerb()
		 * @generated
		 */
		EClass ACTION_VERB = eINSTANCE.getactionVerb();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION_VERB__VALUE = eINSTANCE.getactionVerb_Value();

	}

} //UserstoryPackage
