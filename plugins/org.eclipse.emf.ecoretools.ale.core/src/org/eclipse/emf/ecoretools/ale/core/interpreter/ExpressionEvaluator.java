package org.eclipse.emf.ecoretools.ale.core.interpreter;

import org.eclipse.acceleo.query.parser.AstEvaluator;
import org.eclipse.acceleo.query.runtime.impl.EvaluationServices;
import org.eclipse.emf.ecore.EObject;

public class ExpressionEvaluator extends AstEvaluator{

	public ExpressionEvaluator(EvaluationServices services) {
		super(services);
	}

	@Override
	public Object defaultCase(EObject object) {
		// TODO Auto-generated method stub
		return super.defaultCase(object);
	}
}
