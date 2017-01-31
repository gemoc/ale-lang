package interpreter

import implementation.Behaviored
import org.eclipse.acceleo.query.runtime.IQueryEvaluationEngine
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine
import org.eclipse.emf.ecore.EObject
import org.osgi.resource.Resource
import java.util.List

class ImplementationEngine {
	
	EvalEnvironment implemEnv
	
	new(EvalEnvironment evalEnv) {
		this.implemEnv = evalEnv
	}
	
	def void eval(EObject target, Behaviored mainOp, List<Object> args) {
		val evaluator = new ImplementationEvaluator(new QueryEvaluationEngine(implemEnv.queryEnvironment), implemEnv.featureAccess)
		evaluator.eval(target,mainOp,args)
	}
}