package lang;

import java.util.List;
import java.util.Optional;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
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
    
    /**
     * Entry point for an evaluation.Search in {@link implementation}
     * for the first operation tagged 'main' and apply it to {@link caller}
     */
    public IEvaluationResult eval(EObject caller, List<Object> args, String implementation) {
    	ParseResult<ModelBehavior> parseResult = (new AstBuilder(queryEnvironment)).parse(implementation);
    	
    	parseResult
    		.getRoot()
    		.getServices()
    		.stream()
    		.forEach(srv -> javaExtensions.addImport(srv));
    	javaExtensions.reloadIfNeeded();
    	
    	Behaviored mainOp = getMainOp(parseResult.getRoot());
		EvaluationResult evalResult = eval(caller,mainOp,args);
		
		final BasicDiagnostic diagnostic = new BasicDiagnostic();
        if (Diagnostic.OK != parseResult.getDiagnostic().getSeverity()) {
            diagnostic.merge(parseResult.getDiagnostic());
        }
        if (Diagnostic.OK != evalResult.getDiagnostic().getSeverity()) {
            diagnostic.merge(evalResult.getDiagnostic());
        }

        return new IEvaluationResult() {

            @Override
            public Object getValue() {
                return evalResult.getResult();
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
    
    private EvaluationResult eval(EObject caller, Behaviored operation, List<Object> args) {
    	ModelBehavior root = (ModelBehavior) EcoreUtil.getRootContainer(operation);
    	DiagnosticLogger logger = new DiagnosticLogger();
    	EvalEnvironment env = new EvalEnvironment(queryEnvironment, root, logger);
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
}
