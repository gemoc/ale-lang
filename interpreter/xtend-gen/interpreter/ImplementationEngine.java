package interpreter;

import implementation.Behaviored;
import interpreter.DynamicFeatureAccess;
import interpreter.EvalEnvironment;
import interpreter.ImplementationEvaluator;
import java.util.List;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.emf.ecore.EObject;

@SuppressWarnings("all")
public class ImplementationEngine {
  private EvalEnvironment implemEnv;
  
  public ImplementationEngine(final EvalEnvironment evalEnv) {
    this.implemEnv = evalEnv;
  }
  
  public void eval(final EObject target, final Behaviored mainOp, final List<Object> args) {
    IQueryEnvironment _queryEnvironment = this.implemEnv.getQueryEnvironment();
    QueryEvaluationEngine _queryEvaluationEngine = new QueryEvaluationEngine(_queryEnvironment);
    DynamicFeatureAccess _featureAccess = this.implemEnv.getFeatureAccess();
    final ImplementationEvaluator evaluator = new ImplementationEvaluator(_queryEvaluationEngine, _featureAccess);
    evaluator.eval(target, mainOp, args);
  }
}
