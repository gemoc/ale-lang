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
package org.eclipse.ecoretools.ale.core.interpreter;

//import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.ecoretools.ale.core.interpreter.services.DynamicFeatureAccessService;
import org.eclipse.ecoretools.ale.core.interpreter.services.EvalBodyService;
import org.eclipse.ecoretools.ale.core.interpreter.services.FactoryService;
import org.eclipse.ecoretools.ale.core.interpreter.services.LogService;
import org.eclipse.ecoretools.ale.core.interpreter.services.TrigoServices;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.ecoretools.ale.implementation.Method;
import org.eclipse.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.ecoretools.ale.implementation.ModelBehavior;
import org.eclipse.ecoretools.ale.implementation.ModelUnit;

/**
 * This class is the context of an evaluation.
 */
public class EvalEnvironment {
	
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
		createDefaultServices();
		registerImplem(allImplem);
	}
	
	public void createDefaultServices() {
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
		java.lang.reflect.Method featureAccessMethod;
		try {
			featureAccessMethod = DynamicFeatureRegistry.class.getMethod("aqlFeatureAccess",EObject.class,String.class);
			qryEnv.registerService(new DynamicFeatureAccessService(featureAccessMethod, dynamicFeatures));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
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
		this.dynamicFeatures.dynamicModelConstructor(model, new QueryEvaluationEngine(qryEnv));
	}
	
}