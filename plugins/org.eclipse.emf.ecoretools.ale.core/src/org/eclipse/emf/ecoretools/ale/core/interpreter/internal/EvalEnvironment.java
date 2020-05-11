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
package org.eclipse.emf.ecoretools.ale.core.interpreter.internal;

import static java.util.stream.Collectors.toList;

//import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.runtime.CrossReferenceProvider;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IRootEObjectProvider;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.services.AnyServices;
import org.eclipse.acceleo.query.services.BooleanServices;
import org.eclipse.acceleo.query.services.CollectionServices;
import org.eclipse.acceleo.query.services.ComparableServices;
import org.eclipse.acceleo.query.services.NumberServices;
import org.eclipse.acceleo.query.services.ResourceServices;
import org.eclipse.acceleo.query.services.StringServices;
import org.eclipse.acceleo.query.services.XPathServices;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.Activator;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.DiagnosticLogger;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IServiceCallListener;
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
 * The context of an evaluation. Responsible for registering every AQL service.
 */
public class EvalEnvironment {
	
	public static final String INIT_ERROR = "An error occured during initialization of an EObject";
	
	/**
	 * It contains declared EPackages & services.
	 * Mainly used to evaluate AQL expression and to resolve types
	 */
	private IQueryEnvironment qryEnv;
	
	/**
	 * Store dynamics attributes
	 */
	private DynamicFeatureRegistry dynamicFeatures;
	
	/**
	 * Keep trace of evaluation errors
	 */
	private DiagnosticLogger logger;
	
	/**
	 * Listeners for service calls
	 */
	private List<IServiceCallListener> listeners;

	private IAleEnvironment environment;
	
	public EvalEnvironment(IAleEnvironment environment, DiagnosticLogger logger, List<IServiceCallListener> listeners) {
		this.environment = environment;
		this.qryEnv = environment.getContext();
		this.logger = logger;
		this.listeners = listeners;
		registerImplem(environment.getBehaviors().getUnits());
		populateEnvironmentWithDefaultServices(null,null);
	}
	
	public IQueryEnvironment getQueryEnvironment() {
		return qryEnv;
	}
	
	public DynamicFeatureRegistry getFeatureAccess() {
		return dynamicFeatures;
	}
	
	public List<IServiceCallListener> getListeners() {
		if(listeners == null) {
			listeners = new ArrayList<>();
		}
		return listeners;
	}
	
	public DiagnosticLogger getLogger() {
		return logger;
	}
	
    /**
     * @see org.eclipse.acceleo.query.runtime.Query
     */
	private void populateEnvironmentWithDefaultServices(CrossReferenceProvider xRefProvider, IRootEObjectProvider rootProvider) {
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
			qryEnv.registerService(newCreateService());
			java.lang.reflect.Method cosMethod = TrigoServices.class.getMethod("cosinus",Double.class);
			qryEnv.registerService(new JavaMethodService(cosMethod, null));
			java.lang.reflect.Method sinMethod = TrigoServices.class.getMethod("sinus",Double.class);
			qryEnv.registerService(new JavaMethodService(sinMethod, null));
			java.lang.reflect.Method tanMethod = TrigoServices.class.getMethod("tan",Double.class);
			qryEnv.registerService(new JavaMethodService(tanMethod, null));
		} 
		catch (SecurityException | NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Register services to access dynamic features and evaluate operations
	 */
	public void registerImplem(List<ModelUnit> allImplemModels) {
		List<EClass> domain = qryEnv.getEPackageProvider()
									.getEClassifiers().stream()
									.filter(cls -> cls instanceof EClass)
									.map(cls -> (EClass) cls)
									.collect(toList());
		this.dynamicFeatures = new DynamicFeatureRegistry(allImplemModels, domain);
		createServices(allImplemModels).forEach(qryEnv::registerService);
	}
	
	private List<EvalBodyService> createServices(List<ModelUnit> allImplemModels) {
		Map<Method, EvalBodyService> res = new LinkedHashMap<>();
		
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
				.forEach(implemOp -> res.put(implemOp,(new EvalBodyService(environment, implemOp,this,logger))));
			});
		
		List<EvalBodyService> newClassOperations = new ArrayList<>();
		allImplemModels
			.stream()
			.forEach(implemModel -> {
				implemModel
				.getClassDefinitions()
				.stream()
				.flatMap(cls -> cls.getMethods().stream())
				.forEach(implemOp -> newClassOperations.add(new EvalBodyService(environment, implemOp,this,logger)));
			});
		
		
		/*
		 * Set lookup priorities for implementations
		 */
		List<ExtendedClass> allExtendedClasses = 
			allImplemModels
			.stream()
			.flatMap(implem -> implem.getClassExtensions().stream())
			.collect(toList());
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
			.collect(toList());
		allOpServices.addAll(newClassOperations);
		
		return allOpServices;
	}
	
	private Map<ExtendedClass,Integer> getPriorities(List<ExtendedClass> allCls) {
		Map<ExtendedClass,Integer> priorities = new HashMap<>();
		allCls.forEach(cls -> getPriority(cls, priorities));
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
					Activator.PLUGIN_ID,
					0,
					EvalEnvironment.INIT_ERROR,
					new Object[] { model }
					);
			logger.notify(initError);
		}
	}
	
	private IService newCreateService() throws NoSuchMethodException, SecurityException {
		java.lang.reflect.Method createMethod = FactoryService.class.getMethod("create",EClass.class);
		return 
			new JavaMethodService(createMethod, new FactoryService(this)){
				/**
				 * The create() service is typed by its caller
				 */
				@Override
				public Set<IType> getType(Call call, ValidationServices services, IValidationResult validationResult,
						IReadOnlyQueryEnvironment queryEnvironment, List<IType> argTypes) {
					Set<IType> res = super.getType(call, services, validationResult, queryEnvironment, argTypes);
					if (!argTypes.isEmpty()) {
						return Sets.newHashSet(argTypes.get(0));
					}
					else {
						return res;
					}
				}
			};
	}
	
}