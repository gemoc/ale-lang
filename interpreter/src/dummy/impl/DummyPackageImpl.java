/**
 */
package dummy.impl;

import dummy.DummyFactory;
import dummy.DummyPackage;
import dummy.NewEClass1;

import dummy.util.DummyValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DummyPackageImpl extends EPackageImpl implements DummyPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass newEClass1EClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see dummy.DummyPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DummyPackageImpl() {
		super(eNS_URI, DummyFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link DummyPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DummyPackage init() {
		if (isInited) return (DummyPackage)EPackage.Registry.INSTANCE.getEPackage(DummyPackage.eNS_URI);

		// Obtain or create and register package
		DummyPackageImpl theDummyPackage = (DummyPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DummyPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DummyPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theDummyPackage.createPackageContents();

		// Initialize created meta-data
		theDummyPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theDummyPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return DummyValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theDummyPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DummyPackage.eNS_URI, theDummyPackage);
		return theDummyPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNewEClass1() {
		return newEClass1EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNewEClass1_Name() {
		return (EAttribute)newEClass1EClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getNewEClass1__Foobar() {
		return newEClass1EClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DummyFactory getDummyFactory() {
		return (DummyFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		newEClass1EClass = createEClass(NEW_ECLASS1);
		createEAttribute(newEClass1EClass, NEW_ECLASS1__NAME);
		createEOperation(newEClass1EClass, NEW_ECLASS1___FOOBAR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(newEClass1EClass, NewEClass1.class, "NewEClass1", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNewEClass1_Name(), ecorePackage.getEString(), "name", "", 0, 1, NewEClass1.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getNewEClass1__Foobar(), null, "foobar", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
		   });	
		addAnnotation
		  (newEClass1EClass, 
		   source, 
		   new String[] {
			 "constraints", "Constraint1 Constraint2"
		   });	
		addAnnotation
		  (newEClass1EClass, 
		   source, 
		   new String[] {
			 "constraints", "Constraint1 Constraint2"
		   });
	}

} //DummyPackageImpl
