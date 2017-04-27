package org.eclipse.emf.ecoretools.ale.core.interpreter;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.parser.AstEvaluator;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.impl.EvaluationServices;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.implementation.Case;
import org.eclipse.emf.ecoretools.ale.implementation.Switch;

import com.google.common.collect.Maps;

public class ExpressionEvaluator extends AstEvaluator{

	public ExpressionEvaluator(EvaluationServices services) {
		super(services);
	}

	@Override
	public Object defaultCase(EObject object) {
		
		if(object instanceof Switch) {
			Switch switchExp = (Switch) object;
			
			Expression input = switchExp.getParam();
			Object inputVal = doSwitch(input);
			
			//Browse cases
			for(Case aCase : switchExp.getCases()) {
				if(isMatchingGuard(inputVal,aCase.getGuard()) && isMatchingExp(inputVal,aCase.getMatch())) {
					return doSwitch(aCase.getValue());
				}
			}
			
			//Default case
			return doSwitch(switchExp.getDefault());
		}
		
		return super.defaultCase(object);
	}
	
	public boolean isMatchingGuard(Object obj, EClassifier type) {
		if(type == null) {
			return true;
		}
		else {
			return type.isInstance(obj);
		}
	}
	
	/**
	 * Return the value of {@link matchExp} if it is boolean.
	 * Otherwise return {@link obj} equals {@link matchExp}
	 */
	public boolean isMatchingExp(Object obj, Expression matchExp) {
		if(matchExp == null) {
			return true;
		}
		else {
			Object matchValue = doSwitch(matchExp);
			
			if(matchValue instanceof Boolean) {
				return (boolean) matchValue;
			}
			else {
				return obj.equals(matchValue);
			}
		}
	}
}
