package fr.mleduc.mt.compiler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import implementation.ExtendedClass;
import implementation.Implementation;
import implementation.ImplementationPackage;
import implementation.Import;
import implementation.Method;
import implementation.ModelBehavior;
import implementation.VariableDeclaration;
import lang.LangInterpreter;
import lang.core.parser.AstBuilder;
import lang.core.parser.visitor.ParseResult;

/**
 * 
 * This compiler compiles a given semantic, which conform itself to a bunch of
 * syntaxes, to a bunch of (conforming) target syntaxes.
 * 
 * @author mleduc
 *
 */
public class DSLCompiler {

	private final InputStream dslProperty;
	private String sourceCode;
	private ModelBehavior root;
	private List<EPackage> syntaxes;

	public DSLCompiler(final InputStream dslProperty) {
		this.dslProperty = dslProperty;
	}

	public GenModel saveGenModel(final ResourceSetImpl resSet, final String languageName, final EPackage rootPackage,
			final String projectName) {
		/*
		 * Final step: Generating the emf code from the ecore generated
		 */

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("genmodel", new XMIResourceFactoryImpl());

		// resSet.getURIConverter().getURIMap().putAll(EcorePlugin.computePlatformURIMap(true));

		final GenModel genModel = GenModelFactory.eINSTANCE.createGenModel();
		genModel.setComplianceLevel(GenJDKLevel.JDK80_LITERAL);
		genModel.getForeignModel().add("http://" + languageName);
		genModel.setModelName("MODELNAMETEST");
		genModel.setModelPluginID("ModelPluginIDTest");
		genModel.getForeignModel().add(rootPackage.getNsURI());
		genModel.initialize(Collections.singleton(rootPackage));
		genModel.setModelDirectory("/" + projectName + "/src");

		// TODO: Update genmodel in order to avoir the regeneration of
		// cross-references

		final URI createURI = URI
				.createPlatformResourceURI("/" + projectName + "/src-gen/" + languageName + ".genmodel", true);
		final Resource res = resSet.createResource(createURI);

		res.getContents().add(genModel);

		try {
			res.save(null);

		} catch (final IOException e) {
			e.printStackTrace();
		}

		return genModel;
	}

	public EPackage initializeLanguageEcore(final Map<String, EPackage> syntaxes, final String languageName,
			final ResourceSetImpl resSet, final String projectName) {
		/*
		 * First step: copying the target syntaxes to a working directory
		 * 
		 */

		final String languageNameClean = languageName.replaceAll("\\.", "");

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());

		final URI createUri = URI.createPlatformResourceURI("/" + projectName + "/src-gen/" + languageName + ".ecore",
				true);
		final Resource res = resSet.createResource(createUri);
		final EPackage rootPackage = EcoreFactory.eINSTANCE.createEPackage();
		rootPackage.setName(languageNameClean);
		rootPackage.setNsPrefix(languageNameClean);
		rootPackage.setNsURI("http://" + languageName);
		res.getContents().add(rootPackage);
		for (final Entry<String, EPackage> ePackage : syntaxes.entrySet()) {

			final EPackage copy = EcoreUtil.copy(ePackage.getValue());
			for (final EPackage eSubPackage : copy.getESubpackages()) {
				final String initialName = eSubPackage.getName();
				eSubPackage.setName(languageNameClean + ePackage.getKey() + initialName);
				eSubPackage.setNsPrefix(languageNameClean + copy.getNsPrefix());
				eSubPackage.setNsURI("http://" + languageNameClean + "/" + initialName);
			}

			final String initialName = ePackage.getKey();
			copy.setName(languageNameClean + initialName);
			copy.setNsPrefix(languageNameClean + copy.getNsPrefix());
			copy.setNsURI("http://" + languageName + "/" + initialName);
			rootPackage.getESubpackages().add(copy);
		}

		resSet.getPackageRegistry().put(rootPackage.getNsURI(), rootPackage);

		this.completeFields(rootPackage);
		this.completeMethods(rootPackage);

		try {
			res.save(null);
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return rootPackage;
	}

	public void proceedToGeneration(final GenModel genModel) {
		genModel.reconcile();
		genModel.setCanGenerate(true);
		genModel.setValidateModel(true);
		genModel.setUpdateClasspath(true);

		final org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory.Descriptor.Registry reg = GeneratorAdapterFactory.Descriptor.Registry.INSTANCE;
		final Generator generator = new Generator(reg);
		generator.setInput(genModel);

		generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, new NullMonitorImplementation(this));

	}

	public Map<String, EPackage> getListSyntaxes() {
		final ModelBehavior root = getRoot();
		final Map<String, EPackage> syntaxes = new HashMap<>();

		final EList<Import> importSyntaxes = root.getImports();
		importSyntaxes.forEach(
				object -> syntaxes.put(object.getName(), EPackage.Registry.INSTANCE.getEPackage(object.getUri())));

		return syntaxes;
	}

	public ModelBehavior getRoot() {
		if (this.root == null) {
			final LangInterpreter interpreter = new LangInterpreter();
			final IQueryEnvironment queryEnvironment = interpreter.getQueryEnvironment();
			this.syntaxes.stream().forEach(pkg -> {
				// Register if not already there
				final Collection<EPackage> matchingPkgs = queryEnvironment.getEPackageProvider()
						.getEPackage(pkg.getName());
				final Optional<EPackage> existingPkg = matchingPkgs.stream()
						.filter(p -> p.getNsURI().equals(pkg.getNsURI())).findFirst();
				if (!existingPkg.isPresent()) {
					queryEnvironment.registerEPackage(pkg);
				}
			});
			final ParseResult<ModelBehavior> parse = new AstBuilder(queryEnvironment).parse(sourceCode);
			this.root = parse.getRoot();
		}
		return this.root;
	}

	private List<EPackage> load(final String ecoreURI, final ResourceSet rs) {
		final URI uri = URI.createURI(ecoreURI);
		final Resource res = rs.getResource(uri, true);

		return res.getContents().stream().filter(o -> o instanceof EPackage).map(o -> (EPackage) o)
				.collect(Collectors.toList());
	}

	private void completeMethods(final EPackage languagePackage) {
		this.root.getClassExtensions().stream().flatMap(ce -> ce.getMethods().stream()).forEach(behaviored -> {
			final ExtendedClass extendedClass = (ExtendedClass) behaviored.eContainer();

			final String namespace = ""; // extendedClass.getSyntax().getName();

			final EList<EPackage> listPackages = languagePackage.getESubpackages();
			final String target = languagePackage.getName() + namespace;

			final EPackage namespacePackage = listPackages.stream().filter(p -> p.getName().equals(target)).findFirst()
					.get();

			final EClass classToUpdate = namespacePackage.eContents().stream().filter(e -> e instanceof EClass)
					.map(e -> (EClass) e).filter(e -> e.getName().equals(extendedClass.getBaseClass().getName()))
					.findAny().get();

			if (behaviored.eClass().getClassifierID() == ImplementationPackage.IMPLEMENTATION) {

				// implementation = override
				// in this case a EOperation already exists !
				final Implementation implementation = (Implementation) behaviored;

				final EOperation eOperation = classToUpdate.getEOperations().stream()
						.filter(eop -> eop.getName().equals(implementation.getOperationRef().getName())).findAny()
						.get();

				final EAnnotation createEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				createEAnnotation.setSource("http://www.eclipse.org/emf/2002/GenModel");
				createEAnnotation.getDetails().put("body", "System.out.println()");
				eOperation.getEAnnotations().add(createEAnnotation);

			} else {
				// method
				final Method method = (Method) behaviored;
				final EOperation eOperation = EcoreUtil.copy(method.getOperationDef());
				final EAnnotation createEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				createEAnnotation.setSource("http://www.eclipse.org/emf/2002/GenModel");
				createEAnnotation.getDetails().put("body", "System.out.println();");
				eOperation.getEAnnotations().add(createEAnnotation);
				classToUpdate.getEOperations().add(eOperation);
			}
		});
	}

	public void completeFields(final EPackage languagePackage) {

		this.root.getClassExtensions().stream().flatMap(ce -> ce.getAttributes().stream()).forEach(attribute -> {
			final ExtendedClass extendedClass = (ExtendedClass) attribute.eContainer();
			final String namespace = ""; // extendedClass.getSyntax().getName();

			final EList<EPackage> listPackages = languagePackage.getESubpackages();
			final String target = languagePackage.getName() + namespace;
			final EPackage namespacePackage = listPackages.stream().filter(p -> p.getName().equals(target)).findFirst()
					.get();

			final String targetClass = extendedClass.getBaseClass().getName();
			final EClass classToUpdate = namespacePackage.eContents().stream().filter(e -> e instanceof EClass)
					.map(e -> (EClass) e).filter(e -> e.getName().equals(targetClass)).findAny().get();
			final EAttribute createEAttribute = EcoreFactory.eINSTANCE.createEAttribute();
			createEAttribute.setName(attribute.getName());
			createEAttribute.setEType(EcorePackage.eINSTANCE.getEString());
			classToUpdate.getEStructuralFeatures().add(createEAttribute);
		});

	}

	public void compile() throws IOException {

		final Properties properties = new Properties();
		properties.load(this.dslProperty);

		final ResourceSetImpl resSet = new ResourceSetImpl();

		this.syntaxes = Arrays.asList(((String) properties.get("syntax")).split(",")).stream()
				.flatMap((final String stx) -> load(stx, resSet).stream()).collect(Collectors.toList());

		final String behavior = (String) properties.get("behavior");

		final URI behaviorURI = URI.createURI(behavior);

		final InputStream createInputStream = URIConverter.INSTANCE.createInputStream(behaviorURI);

		this.sourceCode = new BufferedReader(new InputStreamReader(createInputStream)).lines().parallel()
				.collect(Collectors.joining("\n"));

		final String projectName = "fsm";
		final EPackage rootPackage = this.generateDynamicModel(projectName, resSet);
		final GenModel genModel = this.saveGenModel(resSet, this.getRoot().getName(), rootPackage, projectName);
		this.proceedToGeneration(genModel);
		
		
		this.syntaxes.forEach(ePackage -> {
			
		});

	}

	/**
	 * Generates a ecore file from the dynamic data declared in the implemented
	 * behavior
	 * 
	 * @param projectName
	 * @param resSet
	 * @return
	 * 
	 * @throws IOException
	 */
	private EPackage generateDynamicModel(final String projectName, final ResourceSet resSet) throws IOException {

		final String behaviourName = this.getRoot().getName();

		final Map<EClass, List<VariableDeclaration>> clazzList = new HashMap<>();

		root.getClassExtensions().forEach(extendedClass -> {
			final List<VariableDeclaration> attributes = extendedClass.getAttributes();
			final EClass baseClass = extendedClass.getBaseClass();
			clazzList.put(baseClass, attributes);
		});

		final EPackage dynamicModelPackage = EcoreFactory.eINSTANCE.createEPackage();
		dynamicModelPackage.setName(behaviourName.replaceAll("\\.", ""));
		dynamicModelPackage.setNsPrefix(behaviourName);
		dynamicModelPackage.setNsURI("http://" + behaviourName);

		clazzList.entrySet().stream().forEach(entry -> {
			final EClass fromClazz = entry.getKey();
			final EClass clazz = EcoreFactory.eINSTANCE.createEClass();
			clazz.setName(fromClazz.getName());
			clazz.getESuperTypes().add(fromClazz);

			entry.getValue().stream().forEach((final VariableDeclaration variableDecl) -> {
				final EReference ref = EcoreFactory.eINSTANCE.createEReference();
				ref.setName(variableDecl.getName());
				ref.setEType(variableDecl.getType());
				// attr.setE

				// TODO : solve why currentState has an error in modeling
				// workbench

				clazz.getEReferences().add(ref);
			});

			dynamicModelPackage.getEClassifiers().add(clazz);
		});

		final URI createUri = URI.createPlatformResourceURI("/" + projectName + "/src-gen/" + behaviourName + ".ecore",
				true);

		final Resource resource = resSet.createResource(createUri);

		resource.getContents().add(dynamicModelPackage);

		resource.save(null);

		return dynamicModelPackage;

	}

}
