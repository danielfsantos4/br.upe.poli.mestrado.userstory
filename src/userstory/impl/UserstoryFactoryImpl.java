/**
 */
package userstory.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import userstory.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UserstoryFactoryImpl extends EFactoryImpl implements UserstoryFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static UserstoryFactory init() {
		try {
			UserstoryFactory theUserstoryFactory = (UserstoryFactory)EPackage.Registry.INSTANCE.getEFactory(UserstoryPackage.eNS_URI);
			if (theUserstoryFactory != null) {
				return theUserstoryFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new UserstoryFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserstoryFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case UserstoryPackage.SPEC: return createspec();
			case UserstoryPackage.ROLE: return createrole();
			case UserstoryPackage.MEANS: return createmeans();
			case UserstoryPackage.END: return createend();
			case UserstoryPackage.ACTION_VERB: return createactionVerb();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public spec createspec() {
		specImpl spec = new specImpl();
		return spec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public role createrole() {
		roleImpl role = new roleImpl();
		return role;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public means createmeans() {
		meansImpl means = new meansImpl();
		return means;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public end createend() {
		endImpl end = new endImpl();
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public actionVerb createactionVerb() {
		actionVerbImpl actionVerb = new actionVerbImpl();
		return actionVerb;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserstoryPackage getUserstoryPackage() {
		return (UserstoryPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static UserstoryPackage getPackage() {
		return UserstoryPackage.eINSTANCE;
	}

} //UserstoryFactoryImpl
