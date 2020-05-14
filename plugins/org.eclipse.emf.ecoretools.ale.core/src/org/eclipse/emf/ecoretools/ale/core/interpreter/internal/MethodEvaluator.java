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
package org.eclipse.emf.ecoretools.ale.core.interpreter.internal;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult;
import org.eclipse.acceleo.query.runtime.IQueryEvaluationEngine;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.core.Activator;
import org.eclipse.emf.ecoretools.ale.core.interpreter.CriticalFailureException;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock;
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeaturePut;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.VariableInsert;
import org.eclipse.emf.ecoretools.ale.implementation.VariableRemove;
import org.eclipse.emf.ecoretools.ale.implementation.While;

/**
 * Evaluates the body of a {@link Method}.
 */
public class MethodEvaluator {
	
	public static final String ROOT_ERROR_MESSAGE = "AQL evaluation failed";
	public static final String AQL_ERROR = "An error occured during evaluation of a query";
	public static final String MTD_ERROR = "Can't eval null method on %s";
	
	private IQueryEvaluationEngine aqlEngine;
	private DynamicFeatureRegistry dynamicFeatureAccess;
	
	private BasicDiagnostic diagnostic;
	private LinkedList<Map<String, Object>> variablesStack;
	
	public MethodEvaluator(IQueryEvaluationEngine aqlEngine, DynamicFeatureRegistry dynamicFeatureAccess) {
		this.aqlEngine = aqlEngine;
		this.dynamicFeatureAccess = dynamicFeatureAccess;
	}
	
	public EvaluationResult eval(EObject target, Method operation, List<Object> parameters) throws CriticalFailureException {
		variablesStack = new LinkedList<>();
		//Init variables
		Map<String, Object> variables = new HashMap<>();
		variables.put("self", target);
		variables.put("result", null);
		
		EOperation opDefinition = operation.getOperationRef();
		
		if(opDefinition != null) {
			for(int i = 0; i < opDefinition.getEParameters().size(); i++) {
				EParameter param = opDefinition.getEParameters().get(i);
				variables.put(param.getName(), parameters.get(i));
			}
			
			variablesStack.push(variables);
			diagnostic = new BasicDiagnostic();
			throwableSwitch(operation.getBody());
			Object result =  variables.get("result");
			variablesStack.pop();
			
			return new EvaluationResult(result, diagnostic);
		}
		else {
			Diagnostic child = new BasicDiagnostic(
					Diagnostic.ERROR,
					Activator.PLUGIN_ID,
					0,
					String.format(MethodEvaluator.MTD_ERROR,target),
					new Object[] {}
					);
			diagnostic.add(child);
			return new EvaluationResult(null, diagnostic);
		}
	}
	
	public Object caseBlock(Block block) throws CriticalFailureException {
		Map<String, Object> newScope = new HashMap<>();
		variablesStack.push(newScope);
		for(Statement stmt : block.getStatements()) {
			throwableSwitch(stmt);
		}
		variablesStack.pop();
		return null;
	}
	
	public Object caseVariableDeclaration(VariableDeclaration varDecl) throws CriticalFailureException {
		Object value;
		if (varDecl.getInitialValue() == null) {
			value = defaultValueFor(varDecl).orElse(null);
		}
		else {
			value = aqlEval(varDecl.getInitialValue());
		}
		variablesStack.peek().put(varDecl.getName(), value);
		return null;
	}
	
	private Optional<Object> defaultValueFor(VariableDeclaration varDecl) {
		if (varDecl.getType().isMany()) {
			return Optional.of(new BasicEList<>());
		}
		if (varDecl.getType().getEType() == EcorePackage.eINSTANCE.getEString()) {
			return Optional.of("");
		}
		if (varDecl.getType().getEType() == EcorePackage.eINSTANCE.getEInt()) {
			return Optional.of(0);
		}
		if (varDecl.getType().getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
			return Optional.of(false);
		}
		return Optional.empty();
	}
	
	public Object caseVariableAssignment(VariableAssignment varAssign) throws CriticalFailureException {
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

	public Object caseFeatureAssignment(FeatureAssignment featAssign) throws CriticalFailureException {
		Object assigned = aqlEval(featAssign.getTarget());
		Object value = aqlEval(featAssign.getValue());

		if(assigned instanceof EObject){
			EStructuralFeature feature = ((EObject)assigned).eClass().getEStructuralFeature(featAssign.getTargetFeature());
			if(feature != null){
				if(value instanceof Collection) {
					BasicEList<EObject> newList = new BasicEList<>((Collection)value);
					((EObject)assigned).eSet(feature, newList);
				}
				else {
					((EObject)assigned).eSet(feature, value);
				}
			}
			else{
				dynamicFeatureAccess.setDynamicFeatureValue(((EObject)assigned),featAssign.getTargetFeature(),value);
			}
			
			//Manage EOpposite
			if(value instanceof EObject && feature instanceof EReference) {
				EReference oppositeRef = ((EReference)feature).getEOpposite();
				if(oppositeRef != null){
					
					//oppositeRef can be defined in an 'open class'
					EStructuralFeature opFeat = ((EObject)value).eClass().getEStructuralFeature(oppositeRef.getName());
					if(opFeat != null){
						((EObject)value).eSet(opFeat,assigned);
					}
					else{
						dynamicFeatureAccess.setDynamicFeatureValue(((EObject)value),oppositeRef.getName(),assigned);
					}
				}
			}
			else if(value instanceof EObject && feature == null){
				Optional<Attribute> featureDef = dynamicFeatureAccess.findFeature(((EObject)assigned).eClass(), featAssign.getTargetFeature());
				if(featureDef.isPresent() && featureDef.get().getFeatureRef() instanceof EReference){
					EReference oppositeRef = ((EReference)featureDef.get().getFeatureRef()).getEOpposite();
					if(oppositeRef != null){
						
						//oppositeRef can be defined in an 'open class'
						EStructuralFeature opFeat = ((EObject)value).eClass().getEStructuralFeature(oppositeRef.getName());
						if(opFeat != null){
							((EObject)value).eSet(opFeat,assigned);
						}
						else{
							dynamicFeatureAccess.setDynamicFeatureValue(((EObject)value),oppositeRef.getName(),assigned);
						}
					}
				}
			}
		}
		return null;
	}
	
	public Object caseVariableInsert(VariableInsert varInsert) throws CriticalFailureException {
		Map<String,Object> scope = findScope(varInsert.getName());
		if(scope != null) {
			Object insertedValue = aqlEval(varInsert.getValue());
			Object variableValue = scope.get(varInsert.getName());
			
			if(variableValue instanceof Collection) {
				if(insertedValue instanceof Collection) {
					((Collection)variableValue).addAll((Collection) insertedValue);
				}
				else {
					((Collection)variableValue).add(insertedValue);
				}
			}
			else if(variableValue instanceof String) {
				scope.put(varInsert.getName(), variableValue + "" + insertedValue);
			}
			else if(variableValue instanceof Integer && insertedValue instanceof Integer) {
				Integer sum = (Integer) variableValue + (Integer) insertedValue;
				scope.put(varInsert.getName(), sum);
			}
			else {
				BasicDiagnostic child = new BasicDiagnostic(
						Diagnostic.ERROR,
						Activator.PLUGIN_ID,
						0,
						String.format("Variable '%s' is not a list, cannot insert %s", varInsert.getName(), insertedValue),
						new Object[] {varInsert.getValue()}
				);
				diagnostic.add(child);
				stopExecution(ROOT_ERROR_MESSAGE);
			}
		}
		return null;
	}
	
	public Object caseVariableRemove(VariableRemove varInsert) throws CriticalFailureException {
		Map<String,Object> scope = findScope(varInsert.getName());
		if(scope != null) {
			Object insertedValue = aqlEval(varInsert.getValue());
			Object variableValue = scope.get(varInsert.getName());
			
			if(variableValue instanceof Collection) {
				if(insertedValue instanceof Collection) {
					((Collection)variableValue).removeAll((Collection) insertedValue);
				}
				else {
					((Collection)variableValue).remove(insertedValue);
				}
			}
			else if(variableValue instanceof Integer && insertedValue instanceof Integer) {
				Integer substraction = (Integer) variableValue - (Integer) insertedValue;
				scope.put(varInsert.getName(), substraction);
			}
			else {
				BasicDiagnostic child = new BasicDiagnostic(
						Diagnostic.ERROR,
						Activator.PLUGIN_ID,
						0,
						String.format("Variable '%s' is not a list, cannot remove %s", varInsert.getName(), insertedValue),
						new Object[] {varInsert.getValue()}
				);
				diagnostic.add(child);
				stopExecution(ROOT_ERROR_MESSAGE);
			}
		}
		
		return null;
	}
	
	public Object caseFeatureInsert(FeatureInsert featInsert) throws CriticalFailureException {
		Object assigned = aqlEval(featInsert.getTarget());
		Object value = aqlEval(featInsert.getValue());
		
		if(assigned instanceof EObject){
			EStructuralFeature feature = ((EObject)assigned).eClass().getEStructuralFeature(featInsert.getTargetFeature());
			
			try {
				if(feature != null){
					Object featureValue = ((EObject)assigned).eGet(feature);
					if(featureValue instanceof Collection){
						if (value instanceof Collection) {
							((Collection)featureValue).addAll((Collection) value);
						}
						else {
							((Collection)featureValue).add(value);
						}
					}
				}
				else {
					dynamicFeatureAccess.insertDynamicFeatureValue(((EObject)assigned),featInsert.getTargetFeature(),value);
				}
			} catch (ArrayStoreException e) {
				BasicDiagnostic child = new BasicDiagnostic(
						Diagnostic.ERROR,
						Activator.PLUGIN_ID,
						0,
						String.format("Cannot add the value to '%s': types mismatch", featInsert.getTargetFeature()),
						new Object[] {featInsert.getTarget()}
						);
				diagnostic.add(child);
				stopExecution(ROOT_ERROR_MESSAGE);
			}
		}
		return null;
	}
	
	public Object caseFeatureRemove(FeatureRemove featRemove) throws CriticalFailureException {
		Object assigned = aqlEval(featRemove.getTarget());
		Object value = aqlEval(featRemove.getValue());
			
		if(assigned instanceof EObject){
			EStructuralFeature feature = ((EObject)assigned).eClass().getEStructuralFeature(featRemove.getTargetFeature());
			if(feature != null){
				Object featureValue = ((EObject)assigned).eGet(feature);
				if(featureValue instanceof Collection){
					if (value instanceof Collection) {
						((Collection)featureValue).removeAll((Collection) value);
					}
					else {
						((Collection)featureValue).remove(value);
					}
				}
			}
			else {
				dynamicFeatureAccess.removeDynamicFeatureValue(((EObject)assigned),featRemove.getTargetFeature(),value);
			}
		}
		return null;
	}
	
	public Object caseFeaturePut(FeaturePut featPut) throws CriticalFailureException {
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
	
	public Object caseForEach(ForEach forEach) throws CriticalFailureException {
		Collection<?> collection = (Collection<?>) aqlEval(forEach.getCollectionExpression());//TODO: check type
		Map<String,Object> newScope = new HashMap<>();
		variablesStack.push(newScope);
		for(Object elem : collection) {
			newScope.put(forEach.getVariable(),elem);
			throwableSwitch(forEach.getBody());
		}
		
		variablesStack.pop();
		return null;
	}
	
	public Object caseWhile(While loop) throws CriticalFailureException {
		Object conditionValue = aqlEval(loop.getCondition());
		while(conditionValue instanceof Boolean && conditionValue.equals(true)){
			throwableSwitch(loop.getBody());
			conditionValue = aqlEval(loop.getCondition());
		}
		return null;
	}
	
	public Object caseIf(If ifStmt) throws CriticalFailureException {
		Block selectedBlock = null;
		for (ConditionalBlock conditionalBlock : ifStmt.getBlocks()) {
			Object resEval = aqlEval(conditionalBlock.getCondition());
			if(resEval instanceof Boolean && ((Boolean)resEval)) {
				selectedBlock = conditionalBlock.getBlock();
				break;
			}
		}
		
		if(selectedBlock != null){
			throwableSwitch(selectedBlock);
		}
		else if(ifStmt.getElse() != null){
			throwableSwitch(ifStmt.getElse());
		}
		return null;
	}
	
	public Object caseExpressionStatement(ExpressionStatement stmt) throws CriticalFailureException {
		return aqlEval(stmt.getExpression());
	}
	
	/*
	 * Flatten stack
	 */
	private Map<String,Object> getCurrentScope() {
		Map<String,Object> scope = new HashMap<>();
		variablesStack
		.stream()
		.flatMap(scp -> scp.entrySet().stream())
		.forEachOrdered(entry -> scope.put(entry.getKey(), entry.getValue()));
		
		return scope;
	}
	
	private Object aqlEval(Expression expression) throws CriticalFailureException {
		AstResult dummyAstResult = new AstResult(expression, new HashMap<>(), new HashMap<>(), new ArrayList<>(), new BasicDiagnostic());
		EvaluationResult result = aqlEngine.eval(dummyAstResult, getCurrentScope());
		
		if(result.getDiagnostic().getSeverity() != Diagnostic.OK){
			Diagnostic child = new BasicDiagnostic(
					result.getDiagnostic().getSeverity(),
					Activator.PLUGIN_ID,
					0,
					MethodEvaluator.AQL_ERROR,
					new Object[] { expression , result.getDiagnostic()}
					);
			diagnostic.add(child);
			stopExecution(ROOT_ERROR_MESSAGE);
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
	
	private void stopExecution(String message) throws CriticalFailureException {
		throw new CriticalFailureException(message,diagnostic);
	}
	
	private Object throwableSwitch(Object obj) throws CriticalFailureException {
		if(obj instanceof Block) {
			return caseBlock((Block) obj);
		}
		else if(obj instanceof ExpressionStatement) {
			return caseExpressionStatement((ExpressionStatement) obj);
		}
		else if(obj instanceof FeatureAssignment) {
			return caseFeatureAssignment((FeatureAssignment) obj);
		}
		else if(obj instanceof FeatureInsert) {
			return caseFeatureInsert((FeatureInsert) obj);
		}
		else if(obj instanceof FeaturePut) {
			return caseFeaturePut((FeaturePut) obj);
		}
		else if(obj instanceof FeatureRemove) {
			return caseFeatureRemove((FeatureRemove) obj);
		}
		else if(obj instanceof ForEach) {
			return caseForEach((ForEach) obj);
		}
		else if(obj instanceof If) {
			return caseIf((If) obj);
		}
		else if(obj instanceof VariableAssignment) {
			return caseVariableAssignment((VariableAssignment) obj);
		}
		else if(obj instanceof VariableDeclaration) {
			return caseVariableDeclaration((VariableDeclaration) obj);
		}
		else if(obj instanceof VariableInsert) {
			return caseVariableInsert((VariableInsert) obj);
		}
		else if(obj instanceof VariableRemove) {
			return caseVariableRemove((VariableRemove) obj);
		}
		else if(obj instanceof While) {
			return caseWhile((While) obj);
		}
		return null;
	}
	
}