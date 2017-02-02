package interpreter;

import java.util.List;

import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.emf.ecore.EObject;

import implementation.Behaviored;

public class ImplementationEngine {
	
	EvalEnvironment implemEnv;
	
	public ImplementationEngine (EvalEnvironment evalEnv) {
		this.implemEnv = evalEnv;
	}
	
	public void eval(EObject target, Behaviored mainOp, List<Object> args) {
		ImplementationEvaluator evaluator = new ImplementationEvaluator(new QueryEvaluationEngine(implemEnv.getQueryEnvironment()), implemEnv.getFeatureAccess());
		evaluator.eval(target,mainOp,args);
	}
}