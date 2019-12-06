/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.CrossReferenceProvider;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ALEEngine;
import org.eclipse.emf.ecoretools.ale.core.interpreter.DiagnosticLogger;
import org.eclipse.emf.ecoretools.ale.core.interpreter.EvalEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.EvalBodyService;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.ServiceCallListener;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.ImmutableDslSemantics;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.DslSemantics;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.debug.DebugQueryEnvironment;
import org.eclipse.emf.ecoretools.ale.debug.ILookupEngineListener;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback;
import org.eclipse.sirius.common.tools.api.interpreter.EPackageLoadingCallback;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager;

/**
 * This class is an interpreter for the 'ALE' Language.
 * Important note: do not forget to call close()  in order to dispose resources when the interpreter is not used anymore
 */
public class ALEInterpreter implements AutoCloseable {
	
	/**
	 * Exception thrown if the interpreter is used after having been closed
	 *
	 */
	public class ClosedALEInterpreterException extends Exception {
		public ClosedALEInterpreterException(String string) {
			super(string);
		}

		private static final long serialVersionUID = -8494003054984405449L;
	}
	public static final String NO_MAIN_ERROR = "No operation with @main found";
	
	/**
	 * Environment of the evaluation. It contains declared EPackages & services.
	 * Mainly used to evaluate AQL expression and to resolve types. 
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
	
	protected boolean isClosed = false;
	
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
     * Logs diagnostic for each call of implementation
     */
    DiagnosticLogger logger;
    
    
    /**
	 * Listeners for service calls
	 */
	List<ServiceCallListener> serviceListeners;

	/**
	 * Reference the engine used by the ongoing evaluation
	 */
	ALEEngine currentEngine;
    
    /**
     * The environment is setup with default services & EPackages
     */
    public ALEInterpreter() {
    	this(false);
    }
    
    public ALEInterpreter(boolean isDebugMode) {
        this.queryEnvironment = createQueryEnvironment(isDebugMode,null);
        queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE);
		queryEnvironment.registerEPackage(AstPackage.eINSTANCE);
        this.ePackageCallBack = new EPackageLoadingCallback() {

            @Override
            public void loaded(String nsURI, EPackage pak) {
                queryEnvironment.registerEPackage(pak);
            }

            @Override
            public void unloaded(String nsURI, EPackage pak) {
            	queryEnvironment.removeEPackage(pak);
            }
        };
        this.javaExtensions = JavaExtensionsManager.createManagerWithOverride();
        this.javaExtensions.addClassLoadingCallBack(callback);
        this.javaExtensions.addEPackageCallBack(ePackageCallBack);
        this.serviceListeners = new ArrayList<>();
	}
    
    private IQueryEnvironment createQueryEnvironment(boolean isDebug, CrossReferenceProvider xRefProvider) {
    	
    	IQueryEnvironment newEnv = new ExtensionEnvironment();
    	newEnv.registerEPackage(EcorePackage.eINSTANCE);
    	newEnv.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(),
				EStringToStringMapEntryImpl.class);
    	
    	if(isDebug) {
    		DebugQueryEnvironment debugQryEnv = new DebugQueryEnvironment(newEnv);
    		debugQryEnv.registerListener(new ILookupEngineListener() {
				@Override
				public void preLookup(String name, IType[] argumentTypes) {
					// Do nothing
				}
				@Override
				public void postLookup(IService foundService) {
					if(foundService instanceof EvalBodyService) {
						System.out.println("Call : " + foundService.getLongSignature());
					}
				}
			});
    		return debugQryEnv;
    	}
    	else {
    		return newEnv;
    	}
    }
    
    public DslSemantics getSemanticsOf(Dsl dsl) {
    	List<ParseResult<ModelUnit>> parsedFiles = new DslBuilder(queryEnvironment).parse(dsl);
    	return new ImmutableDslSemantics(parsedFiles);
    }
    
    /**
     * Applies {@code calledOp} on {@code caller}.
     * <p>
     * <b>Important</b>: all the EObjects given as arguments must have been loaded
     * with the same {@link ResourceSet}, otherwise the interpreter won't be able
     * to resolve every type and method. Loading models from the resource produced
     * by {@link #loadModel(String)} should achieve a similar result.
     * 
     * @throws ClosedALEInterpreterException if the interpreter has been closed 
     */
    public IEvaluationResult eval(EObject caller, Method calledOp, List<Object> args, DslSemantics parsedSemantics) throws ClosedALEInterpreterException {
    	requireNonNull(caller, "caller");
    	requireNonNull(calledOp, "main");
    	
    	if(isClosed) {
    		throw new ClosedALEInterpreterException("ALEInterpreter has been closed");
    	}
    	final BasicDiagnostic diagnostic = new BasicDiagnostic();
    	parsedSemantics.getParsedFiles().stream()
    				   .filter(parseResult -> Diagnostic.OK != parseResult.getDiagnostic().getSeverity())
    				   .forEach(parseResult -> diagnostic.merge(parseResult.getDiagnostic()));
    	
    	logger = new DiagnosticLogger(parsedSemantics);
    	
		EvaluationResult evalResult = doEval(caller, calledOp, args, parsedSemantics);
		if (Diagnostic.OK != evalResult.getDiagnostic().getSeverity()) {
			diagnostic.merge(evalResult.getDiagnostic());
		}
		Object value = evalResult.getResult();
		
		return new IEvaluationResult() {

			@Override
			public Object getValue() {
				return value;
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
    
    private EvaluationResult doEval(EObject caller, Method operation, List<Object> args, DslSemantics semantics) {
    	/*
    	 * Register services
    	 */
	    registerServices(semantics.getServices());
    	
    	EvalEnvironment env = new EvalEnvironment(queryEnvironment, semantics.getBehaviors(), logger, serviceListeners);
    	List<Object> inputElems = new ArrayList<>();
    	inputElems.add(caller);
    	inputElems.addAll(args);
    	initDynamicFeatures(inputElems,env);
    	
    	ALEEngine engine = new ALEEngine(env);
    	this.currentEngine = engine;
    	return engine.eval(caller, operation, args);
    }
    
    private void initDynamicFeatures(List<Object> inputElems, EvalEnvironment env) {
    	
    	Set<EObject> accessibleInputElements = new HashSet<>();
    	
    	Set<Resource> allResources = 
    		inputElems
	    	.stream()
	    	.filter(elem -> elem instanceof EObject)
	    	.map(elem -> ((EObject)elem).eResource())
	    	.filter(res -> res != null)
	    	.collect(toSet());
    	
    	//EObject from accessible resources
    	allResources
    		.forEach(res -> 
    			res.getAllContents().forEachRemaining(e ->
    				accessibleInputElements.add(e)
    			)
    		);
    	
    	//EObject outside a resource
    	inputElems
	    	.stream()
	    	.filter(elem -> elem instanceof EObject)
	    	.filter(elem -> ((EObject)elem).eResource() == null)
	    	.forEach(elem -> accessibleInputElements.add((EObject)elem));
    	
    	env.initialize(accessibleInputElements);
    }
    
    public IQueryEnvironment getQueryEnvironment() {
        return this.queryEnvironment;
    }
    
    public DiagnosticLogger getLogger() {
		return logger;
	}
    
    /**
     * Return the resource resolved by this uri.
     * Ensure to use EPackages registered in the eval environment
     */
    public Resource loadModel(java.lang.String modelURI) {
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
		return modelRs.getResource(uri, true);
    }
    
    /**
     * Register services for each methods from a list of qualified class names
     */
    public void registerServices(Iterable<java.lang.String> services) {
    	services.forEach(srv -> javaExtensions.addImport(srv));
    	javaExtensions.reloadIfNeeded();
    }
    
    /**
     * Declare plugins & projects where to find services
     */
    public void initScope(Set<java.lang.String> plugins, Set<java.lang.String> project) {
    	javaExtensions.updateScope(plugins, project);
    	javaExtensions.reloadIfNeeded();
    }
    
    public void addListener(ServiceCallListener listener) {
    	this.serviceListeners.add(listener);
    }
    
    public List<ServiceCallListener> getServiceListeners() {
		return serviceListeners;
	}
    
    /**
     * Return the engine used by the ongoing evaluation.
     * Return null if eval() wasn't called before
     */
    public ALEEngine getCurrentEngine() {
		return currentEngine;
	}

    /**
     * Release resources hold by this interpreter
     * (this includes unregistering from any listener)
     * 
     * once this method has been called, the eval should be disabled 
     */
	@Override
	public void close()  {
		isClosed = true;
		queryEnvironment.removeEPackage(ImplementationPackage.eINSTANCE);
		queryEnvironment.removeEPackage(AstPackage.eINSTANCE);
		//this.javaExtensions.addClassLoadingCallBack(callback);
        //this.javaExtensions.addEPackageCallBack(ePackageCallBack);
		this.javaExtensions.removeClassLoadingCallBack(callback);
		this.javaExtensions.removeEPackageCallBack(ePackageCallBack);
		this.javaExtensions.dispose();
	}
}
