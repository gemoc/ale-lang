/**
 */
package dummy;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

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
 * @see dummy.DummyFactory
 * @model kind="package"
 * @generated
 */
public interface DummyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "dummy";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.example.org/dummy";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dummy";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DummyPackage eINSTANCE = dummy.impl.DummyPackageImpl.init();

	/**
	 * The meta object id for the '{@link dummy.impl.NewEClass1Impl <em>New EClass1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dummy.impl.NewEClass1Impl
	 * @see dummy.impl.DummyPackageImpl#getNewEClass1()
	 * @generated
	 */
	int NEW_ECLASS1 = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_ECLASS1__NAME = 0;

	/**
	 * The number of structural features of the '<em>New EClass1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_ECLASS1_FEATURE_COUNT = 1;

	/**
	 * The operation id for the '<em>Foobar</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_ECLASS1___FOOBAR = 0;

	/**
	 * The number of operations of the '<em>New EClass1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEW_ECLASS1_OPERATION_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link dummy.NewEClass1 <em>New EClass1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>New EClass1</em>'.
	 * @see dummy.NewEClass1
	 * @generated
	 */
	EClass getNewEClass1();

	/**
	 * Returns the meta object for the attribute '{@link dummy.NewEClass1#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dummy.NewEClass1#getName()
	 * @see #getNewEClass1()
	 * @generated
	 */
	EAttribute getNewEClass1_Name();

	/**
	 * Returns the meta object for the '{@link dummy.NewEClass1#foobar() <em>Foobar</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Foobar</em>' operation.
	 * @see dummy.NewEClass1#foobar()
	 * @generated
	 */
	EOperation getNewEClass1__Foobar();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DummyFactory getDummyFactory();

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
		 * The meta object literal for the '{@link dummy.impl.NewEClass1Impl <em>New EClass1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dummy.impl.NewEClass1Impl
		 * @see dummy.impl.DummyPackageImpl#getNewEClass1()
		 * @generated
		 */
		EClass NEW_ECLASS1 = eINSTANCE.getNewEClass1();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEW_ECLASS1__NAME = eINSTANCE.getNewEClass1_Name();
		/**
		 * The meta object literal for the '<em><b>Foobar</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation NEW_ECLASS1___FOOBAR = eINSTANCE.getNewEClass1__Foobar();

	}

} //DummyPackage
