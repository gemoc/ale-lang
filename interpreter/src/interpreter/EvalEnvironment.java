package interpreter;

import implementation.ModelBehavior;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import services.EvalBodyService;
import services.FactoryService;
import services.LogService;
import services.TrigoServices;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * 
 */
public class EvalEnvironment {
	
	IQueryEnvironment qryEnv;
	ModelBehavior implemModel;
	DynamicFeatureAccess dynamicFeatures;
	DiagnosticLogger logger;
	
	public EvalEnvironment (IQueryEnvironment qryEnv, Set<EPackage> metamodel, ModelBehavior implem, DiagnosticLogger logger) {
		this.qryEnv = qryEnv;
		this.logger = logger;
		createDefaultServices();
		metamodel
			.stream()
			.forEach(pkg -> registerEPackage(pkg));
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
	
	public void registerEPackage(EPackage pkg){
		qryEnv.registerEPackage(pkg);
		if (!EPackage.Registry.INSTANCE.containsKey(pkg.getNsURI()));
			EPackage.Registry.INSTANCE.put(pkg.getNsURI(), pkg);
	}
	
	/**
	 * Register services to access dynamic features and evaluate operations
	 */
	public void registerImplem(ModelBehavior implemModel) {
		this.implemModel = implemModel;
		this.dynamicFeatures = new DynamicFeatureAccess(implemModel);
		ImplementationEvaluator evaluator = new ImplementationEvaluator(new QueryEvaluationEngine(qryEnv), dynamicFeatures);
		implemModel
			.getClassExtensions()
			.stream()
			.flatMap(cls -> cls.getMethods().stream())
			.forEach(implemOp -> qryEnv.registerService(new EvalBodyService(implemOp,this,logger)));
		Method featureAccessMethod;
		try {
			featureAccessMethod = DynamicFeatureAccess.class.getMethod("aqlFeatureAccess",EObject.class,String.class);
			qryEnv.registerService(new DynamicFeatureAccessService(featureAccessMethod, dynamicFeatures));
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	public IQueryEnvironment getQueryEnvironment() {
		return qryEnv;
	}
	
	public DynamicFeatureAccess getFeatureAccess() {
		return dynamicFeatures;
	}
}