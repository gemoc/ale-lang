package org.eclipse.emf.ecoretools.ale.core.interpreter;

import java.util.Map;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.parser.AstEvaluator;
import org.eclipse.acceleo.query.runtime.AcceleoQueryEvaluationException;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IQueryEvaluationEngine;
import org.eclipse.acceleo.query.runtime.impl.EvaluationServices;
import org.eclipse.acceleo.query.runtime.impl.Nothing;

public class ExpressionEvaluationEngine implements IQueryEvaluationEngine {

	/**
	 * The environment containing all necessary information and used to execute query services.
	 */
	private IQueryEnvironment queryEnvironment;
	
	public ExpressionEvaluationEngine(IQueryEnvironment queryEnvironment) {
		this.queryEnvironment = queryEnvironment;
	}

	@Override
	public EvaluationResult eval(AstResult expression, Map<String, Object> environment)
			throws AcceleoQueryEvaluationException {
		EvaluationResult result = null;
		if (expression != null && expression.getAst() != null) {
			Expression ast = expression.getAst();
			ExpressionEvaluator evaluator = new ExpressionEvaluator(new EvaluationServices(queryEnvironment));
			result = evaluator.eval(environment, ast);
			if (result.getResult() instanceof Nothing) {
				result = new EvaluationResult(null, result.getDiagnostic());
			}
		}
		return result;
	}
}
