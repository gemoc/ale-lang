package lang;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback;
import org.eclipse.sirius.common.tools.api.interpreter.EPackageLoadingCallback;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager;

import implementation.Behaviored;
import implementation.ImplementationPackage;
import implementation.ModelBehavior;
import lang.core.interpreter.DiagnosticLogger;
import lang.core.interpreter.EvalEnvironment;
import lang.core.interpreter.ImplementationEngine;
import lang.core.parser.AstBuilder;
import lang.core.parser.visitor.ParseResult;

/**
 * This class is an interpreter for the 'Lang' Language.
 */
public class LangInterpreter {
	
	/**
	 * Environment of the evaluation. It contains declared EPackages & services.
	 * Mainly used to evalute AQL expression and to resolve types. 
	 */
	IQueryEnvironment queryEnvironment;
	
	
	/**
	 * Tracks updates of EPackges & services from the workspace  
	 */
	public JavaExtensionsManager javaExtensions;
	
	/**
	 * Binding between {@link javaExtensions} and {@link queryEnvironment}
	 */
	EPackageLoadingCallback ePackageCallBack;
	
	/**
	 * Binding between {@link javaExtensions} and {@link queryEnvironment} 
	 */
	private final ClassLoadingCallback callback = new ClassLoadingCallback() {

        @Override
        public void loaded(String qualifiedName, Class<?> clazz) {
        	ServiceUtils.registerServices(queryEnvironment, ServiceUtils.getServices(queryEnvironment, clazz));
        }

        @Override
        public void notFound(String qualifiedName) {
            //TODO: log error
        }

        @Override
        public void unloaded(String qualifiedName, Class<?> clazz) {
            ServiceUtils.removeServices(queryEnvironment, ServiceUtils.getServices(queryEnvironment, clazz));
        }
    };
    
    /**
     * The environment is setup with default services & EPackages
     */
    public LangInterpreter() {
        this.queryEnvironment = Query.newEnvironmentWithDefaultServices(null);
        queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE);
		queryEnvironment.registerEPackage(AstPackage.eINSTANCE);
        this.ePackageCallBack = new EPackageLoadingCallback() {

            @Override
            public void loaded(String nsURI, EPackage pak) {
                queryEnvironment.registerEPackage(pak);
            }

            @Override
            public void unloaded(String nsURI, EPackage pak) {
                queryEnvironment.removeEPackage(pak.getName());
            }
        };
        this.javaExtensions = JavaExtensionsManager.createManagerWithOverride();
        this.javaExtensions.addClassLoadingCallBack(callback);
        this.javaExtensions.addEPackageCallBack(ePackageCallBack);
	}
    
    public IEvaluationResult eval(String modelURI, List<Object> args, String dslFile) {
    	DslContent dsl = new DslContent(dslFile);
    	
    	/*
    	 * Register EPackages
    	 */
    	ResourceSet rs = new ResourceSetImpl();
    	rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
    	dsl.getAllSyntaxes()
    		.stream()
    		.forEach(syntaxURI -> {
    			List<EPackage> pkgImports = load(syntaxURI, rs);
    			pkgImports
	    			.stream()
	    			.forEach(pkg -> {
	    				//Register if not already there
	    				Collection<EPackage> matchingPkgs = queryEnvironment.getEPackageProvider().getEPackage(pkg.getName());
	    				Optional<EPackage> existingPkg = matchingPkgs.stream().filter(p -> p.getNsURI().equals(pkg.getNsURI())).findFirst();
	    				if(!existingPkg.isPresent()){
	    					queryEnvironment.registerEPackage(pkg);
	    				}
	    			});
    		});
    	
    	/*
    	 * Parse behavior files
    	 */
    	List<ParseResult<ModelBehavior>> parsedSemantics =
	    	dsl
	    	.getAllSemantics()
	    	.stream()
	    	.map(behaviorFile -> (new AstBuilder(queryEnvironment)).parse(getFileContent(behaviorFile)))
	    	.collect(Collectors.toList());
    	
    	/*
    	 * Register services
    	 */
    	parsedSemantics
	    	.stream()
	    	.forEach(sem -> {
	    		ModelBehavior root = sem.getRoot();
	    		if(root != null) {
	    			root
	    			.getServices()
	        		.stream()
	        		.forEach(srv -> javaExtensions.addImport(srv));
	    		}
	    	});
    	javaExtensions.reloadIfNeeded();
    	
    	/*
    	 * Load input model
    	 */
    	ResourceSet modelRs = new ResourceSetImpl();
    	modelRs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
    	queryEnvironment
	    	.getEPackageProvider()
	    	.getRegisteredEPackages()
	    	.stream()
	    	.forEach(pkg -> {
	    		modelRs.getPackageRegistry().put(pkg.getNsURI(), pkg);
	    	});
    	URI uri = URI.createURI(modelURI);
		Resource modelRes = modelRs.getResource(uri, true);
		EObject caller = modelRes.getContents().get(0);
		
		/*
		 * Eval
		 */
		return eval(caller,args,parsedSemantics);
		
    }
    
    
    /**
     * Entry point for an evaluation.
     * Search in {@link dslFile}'s semantics
     * for the first operation tagged 'main' and apply it to {@link caller}
     */
    private IEvaluationResult eval(EObject caller, List<Object> args, List<ParseResult<ModelBehavior>> parsedSemantics) {
    	
    	Optional<Behaviored> mainOp =
    		parsedSemantics
	    	.stream()
	    	.filter(sem -> sem.getRoot() != null)
	    	.map(sem -> getMainOp(sem.getRoot()))
	    	.findFirst();
    	
    	final BasicDiagnostic diagnostic = new BasicDiagnostic();
    	parsedSemantics
    	.stream()
    	.filter(parseResult -> Diagnostic.OK != parseResult.getDiagnostic().getSeverity())
    	.forEach(parseResult -> diagnostic.merge(parseResult.getDiagnostic()));
    	
    	
    	Object value = null;
		if (mainOp.isPresent()) {
			List<ModelBehavior> allBehaviors = 
				parsedSemantics
		    	.stream()
		    	.filter(sem -> sem.getRoot() != null)
		    	.map(sem -> sem.getRoot())
		    	.collect(Collectors.toList());
			EvaluationResult evalResult = eval(caller, mainOp.get(), args, allBehaviors);
			if (Diagnostic.OK != evalResult.getDiagnostic().getSeverity()) {
				diagnostic.merge(evalResult.getDiagnostic());
			}
			value = evalResult.getResult();
		}
		
		Object dumbFinal = value;
		return new IEvaluationResult() {

			@Override
			public Object getValue() {
				return dumbFinal;
			}

			@Override
			public Diagnostic getDiagnostic() {
				List<Diagnostic> children = diagnostic.getChildren();
				if (children.size() == 1) {
					return children.get(0);
				} else {
					return diagnostic;
				}
			}
		};
    }
    
    private EvaluationResult eval(EObject caller, Behaviored operation, List<Object> args, List<ModelBehavior> allBehaviors) {
    	DiagnosticLogger logger = new DiagnosticLogger();
    	EvalEnvironment env = new EvalEnvironment(queryEnvironment, allBehaviors, logger);
    	ImplementationEngine engine = new ImplementationEngine(env);
    	return engine.eval(caller, operation, args);
    }
    
    private Behaviored getMainOp(ModelBehavior implem) {
		Optional<Behaviored> mainOp = 
				implem.getClassExtensions().stream()
				.flatMap(cls -> cls.getMethods().stream())
				.filter(op -> op.getTags().contains("main"))
				.findFirst();
		
		return mainOp.get();
	}
    
    public IQueryEnvironment getQueryEnvironment() {
        return this.queryEnvironment;
    }
    
    private static String getFileContent(String implementionPath) {
		String fileContent = "";
		try {
			fileContent = new String(Files.readAllBytes(Paths.get(implementionPath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}
    
    private List<EPackage> load(String ecoreURI, ResourceSet rs) {
    	URI uri = URI.createURI(ecoreURI);
    	Resource res  = rs.getResource(uri, true);
    	
    	return 
    		res
	    	.getContents()
	    	.stream()
	    	.filter(o -> o instanceof EPackage)
	    	.map(o -> (EPackage) o)
	    	.collect(Collectors.toList());
    }
}
