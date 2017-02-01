package interpreter

import implementation.ModelBehavior
import org.eclipse.acceleo.query.runtime.IQueryEnvironment
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import services.EvalBodyService
import services.FactoryService
import services.LogService
import services.TrigoServices
import java.util.Set

/**
 * 
 */
class EvalEnvironment {
	
	IQueryEnvironment qryEnv
	ModelBehavior implemModel
	DynamicFeatureAccess dynamicFeatures
	
	new(IQueryEnvironment qryEnv, Set<EPackage> metamodel, ModelBehavior implem) {
		this.qryEnv = qryEnv
		createDefaultServices()
		metamodel.forEach[registerEPackage]
		registerImplem(implem)
	}
	
	def void createDefaultServices() {
		//qryEnv = Query.newEnvironmentWithDefaultServices(null);
		val logMethod = LogService.getMethod("log",Object)
		qryEnv.registerService(new JavaMethodService(logMethod, null));
		val createMethod = FactoryService.getMethod("create",EClass)
		qryEnv.registerService(new JavaMethodService(createMethod, null));
		val cosMethod = TrigoServices.getMethod("cosinus",Double)
		qryEnv.registerService(new JavaMethodService(cosMethod, null));
		val sinMethod = TrigoServices.getMethod("sinus",Double)
		qryEnv.registerService(new JavaMethodService(sinMethod, null));
		val tanMethod = TrigoServices.getMethod("tan",Double)
		qryEnv.registerService(new JavaMethodService(tanMethod, null));
	}
	
	def void registerEPackage(EPackage pkg){
		qryEnv.registerEPackage(pkg)
		if (!EPackage.Registry.INSTANCE.containsKey(pkg.nsURI))
			EPackage.Registry.INSTANCE.put(pkg.nsURI, pkg);
	}
	
	/**
	 * Register services to access dynamic features and evaluate operations
	 */
	def registerImplem(ModelBehavior implemModel) {
		this.implemModel = implemModel
		this.dynamicFeatures = new DynamicFeatureAccess(implemModel)
		val evaluator = new ImplementationEvaluator(new QueryEvaluationEngine(qryEnv), dynamicFeatures)
		implemModel.classExtensions.map[methods].flatten.forEach[implemOp |
			qryEnv.registerService(new EvalBodyService(implemOp,this))
		]
		val featureAccessMethod = DynamicFeatureAccess.getMethod("aqlFeatureAccess",EObject,String)
		qryEnv.registerService(new DynamicFeatureAccessService(featureAccessMethod, dynamicFeatures));
	}
	
	def IQueryEnvironment getQueryEnvironment() {
		return qryEnv
	}
	
	def DynamicFeatureAccess getFeatureAccess() {
		return dynamicFeatures
	}
}