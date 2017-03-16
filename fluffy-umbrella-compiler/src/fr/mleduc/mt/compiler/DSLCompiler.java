package fr.mleduc.mt.compiler;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.codegen.ecore.generator.Generator;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenJDKLevel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.inria.diverse.objectalgebragenerator.GenerateAlgebra;
import fr.inria.diverse.objectalgebragenerator.Graph;
import fr.inria.diverse.objectalgebragenerator.Graph.GraphNode;
import fr.mleduc.mt.compiler.generator.operation.GenerateOperation;
import implementation.ExtendedClass;
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

	private GenModel saveGenModel(final ResourceSetImpl resSet, final String languageName, final EPackage rootPackage,
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

		// TODO: Update genmodel in order to avoid the regeneration of
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

	private void proceedToGeneration(final GenModel genModel) {
		genModel.reconcile();
		genModel.setCanGenerate(true);
		genModel.setValidateModel(true);
		genModel.setUpdateClasspath(true);

		final org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory.Descriptor.Registry reg = GeneratorAdapterFactory.Descriptor.Registry.INSTANCE;
		final Generator generator = new Generator(reg);
		generator.setInput(genModel);

		generator.generate(genModel, GenBaseGeneratorAdapter.MODEL_PROJECT_TYPE, new NullMonitorImplementation(this));

	}

	private ModelBehavior getRoot() {
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

	public void compile(IProject project) throws IOException {

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
			this.generateAlgebra(ePackage, project);
		});

		this.generateAlgebra(rootPackage, project);

		this.getRoot().getClassExtensions().forEach(clazz -> {
			new GenerateOperation().generate(clazz, project);
		});

		this.generateConcreteAlgebra(rootPackage, project);

		this.generateConcreteOperations(rootPackage, behavior, project);

	}

	private void generateConcreteOperations(final EPackage rootPackage, final String behavior, final IProject project) {
		Graph<EClass> res = new GenerateAlgebra().buildGraph(rootPackage);
		res.nodes.forEach(entry -> {
			generateConceteOperation(entry, project, rootPackage);
		});

	}

	private void generateConceteOperation(GraphNode<EClass> entry, IProject project, EPackage ePackage) {
		final String fileContent = new GenerateAlgebra().processConcreteOperation(entry, ePackage);
		final IPath directoryAlgebra = project.getLocation().append("src").append(ePackage.getName()).append("algebra")
				.append("impl").append("operation");
		directoryAlgebra.toFile().mkdirs();

		EClass rootType = entry.elem;
		String ePackageName = rootType.getEPackage().getName().substring(0, 1).toUpperCase()
				+ rootType.getEPackage().getName().substring(1);
		String rootTypeName = rootType.getName().substring(0, 1).toUpperCase() + rootType.getName().substring(1);
		// String typeName = entry.getValue()
		final IPath fileJavaAlgebra = directoryAlgebra.append(ePackageName + rootTypeName + "Operation")
				.addFileExtension("java");

		try {
			final FileWriter fileWriter = new FileWriter(fileJavaAlgebra.toFile());
			fileWriter.write(fileContent);
			fileWriter.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	private void generateConcreteAlgebra(EPackage ePackage, IProject project) {
		final String fileContent = new GenerateAlgebra().processConcreteAlgebra(ePackage);
		final IPath directoryAlgebra = project.getLocation().append("src").append(ePackage.getName()).append("algebra")
				.append("impl");
		directoryAlgebra.toFile().mkdirs();
		final IPath fileJavaAlgebra = directoryAlgebra.append(
				ePackage.getName().substring(0, 1).toUpperCase() + ePackage.getName().substring(1) + "AlgebraImpl")
				.addFileExtension("java");

		try {
			final FileWriter fileWriter = new FileWriter(fileJavaAlgebra.toFile());
			fileWriter.write(fileContent);
			fileWriter.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}

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
		final ModelBehavior modelBehavior = this.getRoot();
		final String behaviourName = modelBehavior.getName();
		final Map<EClass, List<VariableDeclaration>> clazzList = new HashMap<>();

		final List<ExtendedClass> classExtensions = modelBehavior.getClassExtensions();
		classExtensions.forEach(extendedClass -> {
			if (!extendedClass.getAttributes().isEmpty()) {
				final List<VariableDeclaration> attributes = extendedClass.getAttributes();
				final EClass baseClass = extendedClass.getBaseClass();
				clazzList.put(baseClass, attributes);
			}
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
				ref.setEType(variableDecl.getType().getEType());
				ref.setEGenericType(variableDecl.getType().getEGenericType());
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

	private void generateAlgebra(final EPackage ePackage, final IProject project) {
		final String fileContent = new GenerateAlgebra().processAlgebra(ePackage);
		final IPath directoryAlgebra = project.getLocation().append("src").append(ePackage.getName()).append("algebra");
		directoryAlgebra.toFile().mkdirs();
		final IPath fileJavaAlgebra = directoryAlgebra
				.append(ePackage.getName().substring(0, 1).toUpperCase() + ePackage.getName().substring(1) + "Algebra")
				.addFileExtension("java");

		try {
			final FileWriter fileWriter = new FileWriter(fileJavaAlgebra.toFile());
			fileWriter.write(fileContent);
			fileWriter.close();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

}
