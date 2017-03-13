package fr.mleduc.mt.compiler;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import implementation.ExtendedClass;
import implementation.Implementation;
import implementation.ImplementationPackage;
import implementation.Method;
import implementation.ModelBehavior;
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
public class Compiler {

	private final String sourceCode;
	private ModelBehavior root;

	public Compiler(final String sourceCode) {
		this.sourceCode = sourceCode;
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

//		final EList<ImportSyntax> importSyntaxes = root.getImportSyntaxes();
//		importSyntaxes.forEach(
//				object -> syntaxes.put(object.getName(), EPackage.Registry.INSTANCE.getEPackage(object.getUri())));

		return syntaxes;
	}

	public ModelBehavior getRoot() {
		if (this.root == null) {
			final LangInterpreter interpreter = new LangInterpreter();
			final ParseResult<ModelBehavior> parse = new AstBuilder(interpreter.getQueryEnvironment())
					.parse(sourceCode);
			this.root = parse.getRoot();
		}
		return this.root;
	}

	private void completeMethods(EPackage languagePackage) {
		this.root.getClassExtensions().stream().flatMap(ce -> ce.getMethods().stream()).forEach(behaviored -> {
			ExtendedClass extendedClass = (ExtendedClass) behaviored.eContainer();

			String namespace = ""; //extendedClass.getSyntax().getName();

			EList<EPackage> listPackages = languagePackage.getESubpackages();
			final String target = languagePackage.getName() + namespace;

			final EPackage namespacePackage = listPackages.stream().filter(p -> p.getName().equals(target)).findFirst()
					.get();

			final EClass classToUpdate = namespacePackage.eContents().stream().filter(e -> e instanceof EClass)
					.map(e -> (EClass) e).filter(e -> e.getName().equals(extendedClass.getBaseClass().getName()))
					.findAny().get();

			if (behaviored.eClass().getClassifierID() == ImplementationPackage.IMPLEMENTATION) {

				// implementation = override
				// in this case a EOperation already exists !
				Implementation implementation = (Implementation) behaviored;

				EOperation eOperation = classToUpdate.getEOperations().stream()
						.filter(eop -> eop.getName().equals(implementation.getOperationRef().getName())).findAny()
						.get();

				EAnnotation createEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
				createEAnnotation.setSource("http://www.eclipse.org/emf/2002/GenModel");
				createEAnnotation.getDetails().put("body", "System.out.println()");
				eOperation.getEAnnotations().add(createEAnnotation);
		

			} else {
				// method
				Method method = (Method) behaviored;
				EOperation eOperation = EcoreUtil.copy(method.getOperationDef());
				EAnnotation createEAnnotation = EcoreFactory.eINSTANCE.createEAnnotation();
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
			
			String targetClass = extendedClass.getBaseClass().getName();
			final EClass classToUpdate = namespacePackage.eContents().stream().filter(e -> e instanceof EClass)
					.map(e -> (EClass) e).filter(e -> e.getName().equals(targetClass)).findAny().get();
			final EAttribute createEAttribute = EcoreFactory.eINSTANCE.createEAttribute();
			createEAttribute.setName(attribute.getName());
			createEAttribute.setEType(EcorePackage.eINSTANCE.getEString());
			classToUpdate.getEStructuralFeatures().add(createEAttribute);
		});

	}

	public void compile(String projectName) {
		final Map<String, EPackage> syntaxes = this.getListSyntaxes();

		final ModelBehavior language = this.getRoot();

		final ResourceSetImpl resSet = new ResourceSetImpl();
		// TODO: replace fsm by the language name (or project name)
		final EPackage languagePackage = this.initializeLanguageEcore(syntaxes, language.getName(), resSet,
				projectName);

		// TODO : alterate the language package with the semantical
		// constructions defined in the body

		GenModel languageGenerator = this.saveGenModel(resSet, language.getName(), languagePackage, "fsm");

		this.proceedToGeneration(languageGenerator);
	}

}
