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
package org.eclipse.emf.ecoretools.ale.core.interpreter.impl;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecoretools.ale.core.env.ClosedAleEnvironmentException;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.IBehaviors;
import org.eclipse.emf.ecoretools.ale.core.interpreter.DiagnosticLogger;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleInterpreter;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ILookupEngineListener;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IServiceCallListener;
import org.eclipse.emf.ecoretools.ale.core.interpreter.notapi.AleEngine;
import org.eclipse.emf.ecoretools.ale.core.interpreter.notapi.EvalEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.EvalBodyService;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoadingCallback;
import org.eclipse.sirius.common.tools.api.interpreter.EPackageLoadingCallback;
import org.eclipse.sirius.common.tools.api.interpreter.IEvaluationResult;
import org.eclipse.sirius.common.tools.api.interpreter.JavaExtensionsManager;

/**
 * A concrete ALE interpreter based on AQL's interpreter.
 */
public class AleInterpreter implements IAleInterpreter, AutoCloseable {
	
	public static final String NO_MAIN_ERROR = "No operation with @main found";
	
	/**
	 * Environment of the evaluation. It contains declared EPackages & services.
	 * Mainly used to evaluate AQL expression and to resolve types. 
	 */
	private IQueryEnvironment queryEnvironment;
	/**
	 * Tracks updates of EPackages & services from the workspace  
	 */
	private JavaExtensionsManager javaExtensions;
	/**
	 * Binding between {@link javaExtensions} and {@link queryEnvironment}
	 */
	private EPackageLoadingCallback ePackageCallBack;
    /**
     * Logs diagnostic for each call of implementation
     */
    private DiagnosticLogger logger;
    /**
	 * Listeners for service calls
	 */
	private List<IServiceCallListener> serviceListeners;
	/**
	 * Reference the engine used by the ongoing evaluation
	 */
	private AleEngine currentEngine;
	/**
	 * 
	 */
	private IAleEnvironment environment;
	/**
	 * 
	 */
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
    
	public AleInterpreter(IAleEnvironment environment, IQueryEnvironment context) {
		this(environment, context, false);
	}
	
    public AleInterpreter(IAleEnvironment environment, IQueryEnvironment context, boolean isDebug) {
    	this.environment = environment;
    	this.queryEnvironment = isDebug ? toDebugContext(context) : context;
        this.queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE);
		this.queryEnvironment.registerEPackage(AstPackage.eINSTANCE);
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
    
    private static IQueryEnvironment toDebugContext(IQueryEnvironment context) {
		DebugQueryEnvironment debugContext = new DebugQueryEnvironment(context);
		debugContext.registerListener(new ILookupEngineListener() {
			
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
		return debugContext;
    }
    
    @Override
    public IEvaluationResult eval(EObject caller, Method main, List<Object> args) throws ClosedAleEnvironmentException {
    	requireNonNull(caller, "caller");
    	requireNonNull(main, "main");
    	requireNonNull(args, "args");
    	
    	if (isClosed) {
    		throw new ClosedAleEnvironmentException("AleInterpreter has been closed");
    	}
    	final BasicDiagnostic diagnostic = new BasicDiagnostic();
    	IBehaviors behaviors = environment.getBehaviors();
    	behaviors.getParsedFiles().stream()
    				   .filter(parseResult -> Diagnostic.OK != parseResult.getDiagnostic().getSeverity())
    				   .forEach(parseResult -> diagnostic.merge(parseResult.getDiagnostic()));
    	
    	logger = new DiagnosticLogger(behaviors);
    	
		EvaluationResult evalResult = doEval(caller, main, args);
		if (Diagnostic.OK != evalResult.getDiagnostic().getSeverity()) {
			diagnostic.merge(evalResult.getDiagnostic());
		}
		return new OptimizedEvaluationResult(
				Optional.ofNullable(evalResult.getResult()),
				diagnostic);
    }
    
    private EvaluationResult doEval(EObject caller, Method operation, List<Object> args) {
	    registerServices(environment.getBehaviors().getServices());
    	
    	EvalEnvironment env = new EvalEnvironment(environment, logger, serviceListeners);
    	List<Object> inputs = new ArrayList<>();
    	inputs.add(caller);
    	inputs.addAll(args);
    	initDynamicFeatures(inputs, env);
    	
    	this.currentEngine = new AleEngine(env, environment);
    	return currentEngine.eval(caller, operation, args);
    }
    
    public IQueryEnvironment getQueryEnvironment() {
        return this.queryEnvironment;
    }
    
    @Override
    public DiagnosticLogger getLogger() {
		return logger;
	}
    
    @Override
    public void registerServices(Iterable<String> services) {
    	services.forEach(srv -> javaExtensions.addImport(srv));
    	javaExtensions.reloadIfNeeded();
    }
    
    @Override
    public void initScope(Set<String> plugins, Set<String> project) {
    	javaExtensions.updateScope(plugins, project);
    	javaExtensions.reloadIfNeeded();
    }
    
    @Override
    public void addServiceListener(IServiceCallListener listener) {
    	this.serviceListeners.add(listener);
    }
    
    @Override
    public List<IServiceCallListener> getServiceListeners() {
		return serviceListeners;
	}
    
    @Override
    public AleEngine getCurrentEngine() {
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
		
		this.javaExtensions.removeClassLoadingCallBack(callback);
		this.javaExtensions.removeEPackageCallBack(ePackageCallBack);
		this.javaExtensions.dispose();
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
}
