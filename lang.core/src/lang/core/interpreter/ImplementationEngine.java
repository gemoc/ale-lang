package lang.core.interpreter;

import java.util.List;

import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.emf.ecore.EObject;

import implementation.Behaviored;

public class ImplementationEngine {
	
	EvalEnvironment implemEnv;
	
	public ImplementationEngine (EvalEnvironment evalEnv) {
		this.implemEnv = evalEnv;
	}
	
	public EvaluationResult eval(EObject target, Behaviored mainOp, List<Object> args) {
		ImplementationEvaluator evaluator = new ImplementationEvaluator(new QueryEvaluationEngine(implemEnv.getQueryEnvironment()), implemEnv.getFeatureAccess());
		return evaluator.eval(target,mainOp,args);
	}
}