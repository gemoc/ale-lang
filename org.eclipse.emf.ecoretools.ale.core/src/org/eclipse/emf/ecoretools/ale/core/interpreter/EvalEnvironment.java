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
package org.eclipse.emf.ecoretools.ale.core.interpreter;

//import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.runtime.CrossReferenceProvider;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IRootEObjectProvider;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.acceleo.query.services.AnyServices;
import org.eclipse.acceleo.query.services.BooleanServices;
import org.eclipse.acceleo.query.services.CollectionServices;
import org.eclipse.acceleo.query.services.ComparableServices;
import org.eclipse.acceleo.query.services.EObjectServices;
import org.eclipse.acceleo.query.services.NumberServices;
import org.eclipse.acceleo.query.services.ResourceServices;
import org.eclipse.acceleo.query.services.StringServices;
import org.eclipse.acceleo.query.services.XPathServices;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.DynamicEObjectServices;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.EvalBodyService;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.FactoryService;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.LogService;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.SelectedCallService;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.TrigoServices;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

import com.google.common.collect.Sets;

/**
 * This class is the context of an evaluation.
 */
public class EvalEnvironment {
	
	public static final String INIT_ERROR = "An error occured during initialization of an EObject";
	
	/**
	 * It contains declared EPackages & services.
	 * Mainly used to evalute AQL expression and to resolve types
	 */
	IQueryEnvironment qryEnv;
	
	/**
	 * Contains declarations of dynamics attributes & operations bodies
	 */
	List<ModelUnit> allImplemModels;
	
	/**
	 * Store dynamics attributes
	 */
	DynamicFeatureRegistry dynamicFeatures;
	
	/**
	 * Keep trace of evaluation errors
	 */
	DiagnosticLogger logger;
	
	public EvalEnvironment (IQueryEnvironment qryEnv, List<ModelUnit> allImplem, DiagnosticLogger logger) {
		this.qryEnv = qryEnv;
		this.logger = logger;
		registerImplem(allImplem);
		populateEnvironmentWithDefaultServices(null,null);
	}
	
    /**
     * @see org.eclipse.acceleo.query.runtime.Query
     */
	private void populateEnvironmentWithDefaultServices(CrossReferenceProvider xRefProvider,
			IRootEObjectProvider rootProvider) {
		Set<IService> services = ServiceUtils.getServices(qryEnv, new AnyServices(qryEnv));
		ServiceUtils.registerServices(qryEnv, services);
		services = ServiceUtils.getServices(qryEnv, new DynamicEObjectServices(qryEnv, xRefProvider, rootProvider, dynamicFeatures));
		ServiceUtils.registerServices(qryEnv, services);
		services = ServiceUtils.getServices(qryEnv, new XPathServices(qryEnv));
		ServiceUtils.registerServices(qryEnv, services);
		services = ServiceUtils.getServices(qryEnv, ComparableServices.class);
		ServiceUtils.registerServices(qryEnv, services);
		services = ServiceUtils.getServices(qryEnv, NumberServices.class);
		ServiceUtils.registerServices(qryEnv, services);
		services = ServiceUtils.getServices(qryEnv, StringServices.class);
		ServiceUtils.registerServices(qryEnv, services);
		services = ServiceUtils.getServices(qryEnv, BooleanServices.class);
		ServiceUtils.registerServices(qryEnv, services);
		services = ServiceUtils.getServices(qryEnv, CollectionServices.class);
		ServiceUtils.registerServices(qryEnv, services);
		services = ServiceUtils.getServices(qryEnv, ResourceServices.class);
		ServiceUtils.registerServices(qryEnv, services);
		
		
		if(qryEnv.getLookupEngine() instanceof ExtensionLookupEngine) {
			IService selectedCall = new SelectedCallService(qryEnv, (ExtensionLookupEngine) qryEnv.getLookupEngine()).createService();
			ServiceUtils.registerServices(qryEnv, Sets.newHashSet(selectedCall));
		}
		
		try {
			java.lang.reflect.Method logMethod = LogService.class.getMethod("log",Object.class);
			qryEnv.registerService(new JavaMethodService(logMethod, null));
			java.lang.reflect.Method createMethod = FactoryService.class.getMethod("create",EClass.class);
			qryEnv.registerService(new JavaMethodService(createMethod, new FactoryService(this)));
			java.lang.reflect.Method cosMethod = TrigoServices.class.getMethod("cosinus",Double.class);
			qryEnv.registerService(new JavaMethodService(cosMethod, null));
			java.lang.reflect.Method sinMethod = TrigoServices.class.getMethod("sinus",Double.class);
			qryEnv.registerService(new JavaMethodService(sinMethod, null));
			java.lang.reflect.Method tanMethod = TrigoServices.class.getMethod("tan",Double.class);
			qryEnv.registerService(new JavaMethodService(tanMethod, null));
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Register services to access dynamic features and evaluate operations
	 */
	public void registerImplem(List<ModelUnit> allImplemModels) {
		this.allImplemModels = allImplemModels;
		this.dynamicFeatures = new DynamicFeatureRegistry(allImplemModels);
		createServices(allImplemModels)
			.stream()
			.forEach(opService -> qryEnv.registerService(opService));
	}
	
	public IQueryEnvironment getQueryEnvironment() {
		return qryEnv;
	}
	
	public DynamicFeatureRegistry getFeatureAccess() {
		return dynamicFeatures;
	}
	
	private List<EvalBodyService> createServices(List<ModelUnit> allImplemModels) {
		Map<Method, EvalBodyService> res = new HashMap<Method, EvalBodyService>();
		
		/*
		 * Create services
		 */
		allImplemModels
			.stream()
			.forEach(implemModel -> {
				implemModel
				.getClassExtensions()
				.stream()
				.flatMap(cls -> cls.getMethods().stream())
				.forEach(implemOp -> res.put(implemOp,(new EvalBodyService(implemOp,this,logger))));
			});
		
		List<EvalBodyService> newClassOperations = new ArrayList<EvalBodyService>();
		allImplemModels
			.stream()
			.forEach(implemModel -> {
				implemModel
				.getClassDefinitions()
				.stream()
				.flatMap(cls -> cls.getMethods().stream())
				.forEach(implemOp -> newClassOperations.add(new EvalBodyService(implemOp,this,logger)));
			});
		
		
		/*
		 * Set lookup priorities for implementations
		 */
		List<ExtendedClass> allExtendedClasses = 
			allImplemModels
			.stream()
			.flatMap(implem -> implem.getClassExtensions().stream())
			.collect(Collectors.toList());
		 Map<ExtendedClass,Integer> priorityMap = getPriorities(allExtendedClasses);
		 res
			 .keySet()
			 .stream()
			 .forEach(op -> {
				 int prio = priorityMap.get(op.eContainer());
				 res.get(op).setPriority(prio);
			 });
		
		List<EvalBodyService> allOpServices =
			res
			.entrySet()
			.stream()
			.map(entry -> (EvalBodyService) entry.getValue())
			.collect(Collectors.toList());
		allOpServices.addAll(newClassOperations);
		
		return allOpServices;
	}
	
	private Map<ExtendedClass,Integer> getPriorities(List<ExtendedClass> allCls) {
		
		Map<ExtendedClass,Integer> priorities = new HashMap<ExtendedClass,Integer>();
		allCls
			.stream()
			.forEach(cls -> getPriority(cls,priorities));
		return priorities;
	}
	
	private int getMaxPriority(List<ExtendedClass> superCls, Map<ExtendedClass,Integer> priorities) {
		Optional<Integer> max = 
			superCls
			.stream()
			.map(cls -> getPriority(cls,priorities))
			.max((a,b) -> Integer.compare(a,b));
		if(max.isPresent()){
			return max.get();
		}
		else {
			return 0;
		}
	}
	
	private int getPriority(ExtendedClass cls, Map<ExtendedClass,Integer> priorities) {
		Integer priority = priorities.get(cls);
		if(priority == null) {
			if(!cls.getExtends().isEmpty()) {
				priorities.put(cls, 0);//avoid infinite recursion if cls extends itself
				int p = getMaxPriority(cls.getExtends(),priorities) + 1 ;
				priorities.put(cls, p);
				return p;
			}
			else {
				priorities.put(cls, 0);
				return 0;
			}
		}
		return priority;
	}
	
	/**
	 * Set initial values for dynamic attributes 
	 */
	public void initialize(Set<EObject> model) {
		try {
			this.dynamicFeatures.dynamicModelConstructor(model, new QueryEvaluationEngine(qryEnv));
		} catch (Exception e) {
			Diagnostic initError = new BasicDiagnostic(
					Diagnostic.ERROR,
					MethodEvaluator.PLUGIN_ID,
					0,
					EvalEnvironment.INIT_ERROR,
					new Object[] { model }
					);
			logger.notify(initError);
		}
	}
	
}