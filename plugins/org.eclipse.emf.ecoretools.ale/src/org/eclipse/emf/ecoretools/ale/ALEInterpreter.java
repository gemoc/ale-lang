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

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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
import org.eclipse.emf.ecoretools.ale.core.interpreter.MethodEvaluator;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.EvalBodyService;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.ServiceCallListener;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
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
 */
public class ALEInterpreter {
	
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
                queryEnvironment.removeEPackage(pak.getName());
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
    
    /**
     * Entry point for an evaluation.
     */
    public IEvaluationResult eval(String modelURI, List<Object> args, Dsl dsl) {
    	
    	/*
    	 * Parse semantic files
    	 */
    	List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(queryEnvironment)).parse(dsl);
    	
    	/*
    	 * Load input model
    	 */
    	Resource model = loadModel(modelURI);
		EObject caller = model.getContents().get(0);
		
		/*
		 * Eval
		 */
		return eval(caller,args,parsedSemantics);
		
    }
    
    /**
     * Search in {@link dslFile}'s semantics
     * for the first operation tagged 'main' and apply it to {@link caller}
     */
    public IEvaluationResult eval(EObject caller, List<Object> args, List<ParseResult<ModelUnit>> parsedSemantics) {
    	return eval(caller, null, args, parsedSemantics);
    }
    
    /**
     * Apply {@link calledOp} on {@caller}.
     */
    public IEvaluationResult eval(EObject caller, Method calledOp, List<Object> args, List<ParseResult<ModelUnit>> parsedSemantics) {
    	
    	final BasicDiagnostic diagnostic = new BasicDiagnostic();
    	parsedSemantics
    	.stream()
    	.filter(parseResult -> Diagnostic.OK != parseResult.getDiagnostic().getSeverity())
    	.forEach(parseResult -> diagnostic.merge(parseResult.getDiagnostic()));
    	
    	logger = new DiagnosticLogger(parsedSemantics);
    	
    	if (calledOp == null) {
    		calledOp = firstOperationTaggedMain(parsedSemantics);
    	}
    	Object value = null;
		if (calledOp != null) {
			EvaluationResult evalResult = doEval(caller, calledOp, args, parsedSemantics);
			if (Diagnostic.OK != evalResult.getDiagnostic().getSeverity()) {
				diagnostic.merge(evalResult.getDiagnostic());
			}
			value = evalResult.getResult();
		}
		else {
			Diagnostic child = new BasicDiagnostic (
					Diagnostic.ERROR,
					MethodEvaluator.PLUGIN_ID,
					0,
					ALEInterpreter.NO_MAIN_ERROR,
					new Object[] { caller }
					);
			diagnostic.add(child);
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
    
    private EvaluationResult doEval(EObject caller, Method operation, List<Object> args, List<ParseResult<ModelUnit>> parsedSemantics) {
    	List<ModelUnit> allBehaviors = 
				parsedSemantics
		    	.stream()
		    	.filter(sem -> sem.getRoot() != null)
		    	.map(sem -> sem.getRoot())
		    	.collect(toList());
    	
    	/*
    	 * Register services
    	 */
    	List<String> services = 
    		parsedSemantics
	    	.stream()
	    	.map(unit -> unit.getRoot())
	    	.filter(root -> root != null)
	    	.flatMap(root -> root.getServices().stream())
	    	.collect(toList());
	    registerServices(services);
    	
    	EvalEnvironment env = new EvalEnvironment(queryEnvironment, allBehaviors, logger, serviceListeners);
    	List<Object> inputElems = new ArrayList<>();
    	inputElems.add(caller);
    	inputElems.addAll(args);
    	initDynamicFeatures(inputElems,env);
    	
    	ALEEngine engine = new ALEEngine(env);
    	this.currentEngine = engine;
    	return engine.eval(caller, operation, args);
    }

    /**
     * Searches {@code semantics} for the first method annotated with '@main'.
     * 
     * @param semantics
     * 			Available semantics.
     * 
     * @return the first method annotated with '@main' found,
     * 		   or null if none is found.
     */
	private Method firstOperationTaggedMain(List<ParseResult<ModelUnit>> semantics) {
		return semantics
			.stream()
			.filter(sem -> sem.getRoot() != null)
			.map(sem -> getMainOp(sem.getRoot()))
			.filter(op -> op.isPresent())
			.map(op -> op.get())
			.findFirst()
			.orElse(null);
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
    
    private Optional<Method> getMainOp(ModelUnit implem) {
		return 
			implem.getClassExtensions().stream()
			.flatMap(cls -> cls.getMethods().stream())
			.filter(op -> op.getTags().contains("main"))
			.findFirst();
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
    public Resource loadModel(String modelURI) {
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
    public void registerServices(List<java.lang.String> services) {
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
}
