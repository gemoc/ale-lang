package lang.core.interpreter;

import java.lang.reflect.Method;
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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import implementation.Behaviored;
import implementation.ExtendedClass;
import implementation.ModelBehavior;
import lang.core.interpreter.services.DynamicFeatureAccessService;
import lang.core.interpreter.services.EvalBodyService;
import lang.core.interpreter.services.FactoryService;
import lang.core.interpreter.services.LogService;
import lang.core.interpreter.services.TrigoServices;

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
	List<ModelBehavior> allImplemModels;
	
	/**
	 * Store dynamics attributes
	 */
	DynamicFeatureRegistry dynamicFeatures;
	
	/**
	 * Keep trace of evaluation errors
	 */
	DiagnosticLogger logger;
	
	public EvalEnvironment (IQueryEnvironment qryEnv, List<ModelBehavior> allImplem, DiagnosticLogger logger) {
		this.qryEnv = qryEnv;
		this.logger = logger;
		createDefaultServices();
		registerImplem(allImplem);
	}
	
	public void createDefaultServices() {
		try {
			Method logMethod = LogService.class.getMethod("log",Object.class);
			qryEnv.registerService(new JavaMethodService(logMethod, null));
			Method createMethod = FactoryService.class.getMethod("create",EClass.class);
			qryEnv.registerService(new JavaMethodService(createMethod, null));
			Method cosMethod = TrigoServices.class.getMethod("cosinus",Double.class);
			qryEnv.registerService(new JavaMethodService(cosMethod, null));
			Method sinMethod = TrigoServices.class.getMethod("sinus",Double.class);
			qryEnv.registerService(new JavaMethodService(sinMethod, null));
			Method tanMethod = TrigoServices.class.getMethod("tan",Double.class);
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
	public void registerImplem(List<ModelBehavior> allImplemModels) {
		this.allImplemModels = allImplemModels;
		this.dynamicFeatures = new DynamicFeatureRegistry(allImplemModels);
		createServices(allImplemModels)
			.stream()
			.forEach(opService -> qryEnv.registerService(opService));
		Method featureAccessMethod;
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
	
	private List<EvalBodyService> createServices(List<ModelBehavior> allImplemModels) {
		Map<Behaviored, EvalBodyService> res = new HashMap<Behaviored, EvalBodyService>();
		
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