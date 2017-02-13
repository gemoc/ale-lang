package lang.core.interpreter;

import implementation.ModelBehavior;
import lang.core.interpreter.services.DynamicFeatureAccessService;
import lang.core.interpreter.services.EvalBodyService;
import lang.core.interpreter.services.FactoryService;
import lang.core.interpreter.services.LogService;
import lang.core.interpreter.services.TrigoServices;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * 
 */
public class EvalEnvironment {
	
	IQueryEnvironment qryEnv;
	ModelBehavior implemModel;
	DynamicFeatureRegistry dynamicFeatures;
	DiagnosticLogger logger;
	
	public EvalEnvironment (IQueryEnvironment qryEnv, ModelBehavior implem, DiagnosticLogger logger) {
		this.qryEnv = qryEnv;
		this.logger = logger;
		createDefaultServices();
		registerImplem(implem);
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
	public void registerImplem(ModelBehavior implemModel) {
		this.implemModel = implemModel;
		this.dynamicFeatures = new DynamicFeatureRegistry(implemModel);
		ImplementationEvaluator evaluator = new ImplementationEvaluator(new QueryEvaluationEngine(qryEnv), dynamicFeatures);
		implemModel
			.getClassExtensions()
			.stream()
			.flatMap(cls -> cls.getMethods().stream())
			.forEach(implemOp -> qryEnv.registerService(new EvalBodyService(implemOp,this,logger)));
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
}