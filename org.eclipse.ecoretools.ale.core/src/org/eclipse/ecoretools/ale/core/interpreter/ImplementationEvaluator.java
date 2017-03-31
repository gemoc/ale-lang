/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.ecoretools.ale.core.interpreter;

import org.eclipse.ecoretools.ale.implementation.util.ImplementationSwitch;
import org.eclipse.ecoretools.ale.implementation.Method;
import org.eclipse.ecoretools.ale.implementation.Implementation;
import org.eclipse.ecoretools.ale.implementation.Block;
import org.eclipse.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.ecoretools.ale.implementation.FeaturePut;
import org.eclipse.ecoretools.ale.implementation.ForEach;
import org.eclipse.ecoretools.ale.implementation.While;
import org.eclipse.ecoretools.ale.implementation.If;
import org.eclipse.ecoretools.ale.implementation.ExpressionStatement;
import java.util.Map;
import java.util.Stack;
import org.eclipse.acceleo.query.runtime.IQueryEvaluationEngine;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.ecoretools.ale.implementation.Behaviored;
import java.util.List;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult;

/**
 * This class evaluate the body of an operation.
 */
public class ImplementationEvaluator extends ImplementationSwitch<Object> {
	
	public static final String PLUGIN_ID = "interpreter"; //FIXME: set real name
	public static final String AQL_ERROR = "An error occured during evaluation of a query";
	
	IQueryEvaluationEngine aqlEngine;
	DynamicFeatureRegistry dynamicFeatureAccess;
	
	BasicDiagnostic diagnostic;
	Stack<Map<String, Object>> variablesStack;
	
	public ImplementationEvaluator (IQueryEvaluationEngine aqlEngine, DynamicFeatureRegistry dynamicFeatureAccess) {
		this.aqlEngine = aqlEngine;
		this.dynamicFeatureAccess = dynamicFeatureAccess;
	}
	
	public EvaluationResult eval(EObject target, Behaviored operation, List<Object> parameters) {
		variablesStack = new Stack();
		//Init variables
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("self", target);
		variables.put("result", null);
		
		EOperation opDefinition = null; 
		if(operation instanceof Implementation)
			opDefinition = ((Implementation)operation).getOperationRef();
		else if (operation instanceof Method)
			opDefinition = ((Method)operation).getOperationDef();
		
		for(int i = 0; i < opDefinition.getEParameters().size(); i++) {
			EParameter param = opDefinition.getEParameters().get(i);
			variables.put(param.getName(), parameters.get(i));
		}
		
		variablesStack.push(variables);
		diagnostic = new BasicDiagnostic();
		doSwitch(operation.getBody());
		Object result =  variables.get("result");
		variablesStack.pop();
		
		return new EvaluationResult(result, diagnostic);
	}
	
	@Override
	public Object caseBlock(Block block) {
		Map<String, Object> newScope = new HashMap<String, Object>();
		variablesStack.push(newScope);
		block.getStatements()
			.stream()
			.forEach(stmt -> doSwitch(stmt));
		variablesStack.pop();
		return null;
	}
	
	@Override
	public Object caseVariableDeclaration(VariableDeclaration varDecl) {
		Object value = aqlEval(varDecl.getInitialValue());
		variablesStack.peek().put(varDecl.getName(), value);
		return null;
	}
	
	@Override
	public Object caseVariableAssignment(VariableAssignment varAssign) {
		Map<String,Object> scope = findScope(varAssign.getName());
		if(scope != null) {
			Object value = aqlEval(varAssign.getValue());
			scope.put(varAssign.getName(), value);
		}
		else {
			//not local variable or operation parameter

			//FIXME : try self.attribute ?
			
			//TODO: error: var not def	
		}
		return null;
	}
	
	@Override
	public Object caseFeatureAssignment(FeatureAssignment featAssign) {
		Object assigned = aqlEval(featAssign.getTarget());
		Object value = aqlEval(featAssign.getValue());

		if(assigned instanceof EObject){
			EStructuralFeature feature = ((EObject)assigned).eClass().getEStructuralFeature(featAssign.getTargetFeature());
			if(feature != null){
				((EObject)assigned).eSet(feature,value);
			}
			else{
				dynamicFeatureAccess.setDynamicFeatureValue(((EObject)assigned),featAssign.getTargetFeature(),value);
			}
		}
		return null;
	}
	
	@Override
	public Object caseFeatureInsert(FeatureInsert featInsert) {
		Object assigned = aqlEval(featInsert.getTarget());
		Object value = aqlEval(featInsert.getValue());
		
		if(assigned instanceof EObject){
			EStructuralFeature feature = ((EObject)assigned).eClass().getEStructuralFeature(featInsert.getTargetFeature());
			Object featureValue = ((EObject)assigned).eGet(feature);
			if(featureValue instanceof EList){
				((EList)featureValue).add(value);
			}
		}
		return null;
	}
	
	@Override
	public Object caseFeatureRemove(FeatureRemove featRemove) {
		Object assigned = aqlEval(featRemove.getTarget());
		Object value = aqlEval(featRemove.getValue());
			
		if(assigned instanceof EObject){
			EStructuralFeature feature = ((EObject)assigned).eClass().getEStructuralFeature(featRemove.getTargetFeature());
			Object featureValue = ((EObject)assigned).eGet(feature);
			if(featureValue instanceof EList){
				((EList)featureValue).remove(value);
			}
		}
		return null;
	}
	
	@Override
	public Object caseFeaturePut(FeaturePut featPut) {
		Object assigned = aqlEval(featPut.getTarget());
		Object key = aqlEval(featPut.getKey());
		Object value = aqlEval(featPut.getValue());
		
		if(assigned instanceof EObject){
			EStructuralFeature feature = ((EObject)assigned).eClass().getEStructuralFeature(featPut.getTargetFeature());
			Object featureValue = ((EObject)assigned).eGet(feature);
			if(featureValue instanceof EMap){
				((EMap)featureValue).put(key,value);
			}
		}
		return null;
	}
	
	@Override
	public Object caseForEach(ForEach forEach) {
		Collection<?> collection = (Collection<?>) aqlEval(forEach.getCollectionExpression());//TODO: check type
		Map<String,Object> newScope = new HashMap<String,Object>();
		variablesStack.push(newScope);
		collection
			.stream()
			.forEach(elem -> {
				newScope.put(forEach.getVariable(),elem);
				doSwitch(forEach.getBody());
			});
		
		variablesStack.pop();
		return null;
	}
	
	@Override
	public Object caseWhile(While loop) {
		Object conditionValue = aqlEval(loop.getCondition());
		while(conditionValue instanceof Boolean && conditionValue.equals(true)){
			doSwitch(loop.getBody());
			conditionValue = aqlEval(loop.getCondition());
		}
		return null;
	}
	
	@Override
	public Object caseIf(If ifStmt) {
		Boolean condition = (Boolean) aqlEval(ifStmt.getCondition()); //TODO: check type
		if(condition){
			doSwitch(ifStmt.getThen());
		}
		else if(ifStmt.getElse() != null){
			doSwitch(ifStmt.getElse());
		}
		return null;
	}
	
	@Override
	public Object caseExpressionStatement(ExpressionStatement stmt) {
		return aqlEval(stmt.getExpression());
	}
	
	/*
	 * Flatten stack
	 */
	private Map<String,Object> getCurrentScope() {
		Map<String,Object> scope = new HashMap<String,Object>();
		variablesStack
		.stream()
		.flatMap(scp -> scp.entrySet().stream())
		.forEachOrdered(entry -> scope.put(entry.getKey(), entry.getValue()));
		
		return scope;
	}
	
	private Object aqlEval(Expression expression) {
		AstResult dummyAstResult = new AstResult(expression, new HashMap(), new HashMap(), new ArrayList(), new BasicDiagnostic());
		EvaluationResult result = aqlEngine.eval(dummyAstResult, getCurrentScope());
		
		if(result.getDiagnostic().getSeverity() != Diagnostic.OK){
			Diagnostic child = new BasicDiagnostic(
					result.getDiagnostic().getSeverity(),
					ImplementationEvaluator.PLUGIN_ID,
					0,
					ImplementationEvaluator.AQL_ERROR,
					new Object[] { expression , result.getDiagnostic()}
					);
			diagnostic.add(child);
		}
		
		return result.getResult();
	}
	
	private Map<String,Object> findScope(String variable) {
		for(int i = variablesStack.size() - 1; i >= 0; i--) {
			Map<String,Object> scope = variablesStack.get(i);
			if(scope.keySet().contains(variable)){
				return scope;
			}
		}
		return null;
	}
	
}