package lang;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.AcceleoQueryValidationException;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.acceleo.query.runtime.impl.AbstractService;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.validation.type.ClassType;
import org.eclipse.acceleo.query.validation.type.EClassifierLiteralType;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IJavaType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
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

public class LangInterpreter {
	
	IQueryEnvironment queryEnvironment;
	EPackageLoadingCallback ePackageCallBack;
	public JavaExtensionsManager javaExtensions;
	
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
