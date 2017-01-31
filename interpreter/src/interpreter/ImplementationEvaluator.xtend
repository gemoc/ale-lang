package interpreter

import implementation.util.ImplementationSwitch
import implementation.Method
import implementation.Implementation
import implementation.Block
import implementation.VariableDeclaration
import implementation.FeatureAssignment
import implementation.FeatureInsert
import implementation.FeatureRemove
import implementation.FeaturePut
import implementation.ForEach
import implementation.While
import implementation.If
import implementation.ExpressionStatement
import java.util.Map
import java.util.Stack
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine
import org.eclipse.acceleo.query.runtime.IQueryEvaluationEngine
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.common.util.EMap
import java.util.Collection
import org.eclipse.acceleo.query.runtime.EvaluationResult
import implementation.Behaviored
import java.util.List
import org.eclipse.emf.common.util.BasicDiagnostic
import org.eclipse.emf.common.util.Diagnostic
import implementation.VariableAssignement
import org.eclipse.acceleo.query.ast.Expression
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult

class ImplementationEvaluator extends ImplementationSwitch<Object> {
	
	IQueryEvaluationEngine aqlEngine
	DynamicFeatureAccess dynamicFeatureAccess
	
	Diagnostic diagnostic
	Stack<Map<String, Object>> variablesStack
	
	new(IQueryEvaluationEngine aqlEngine, DynamicFeatureAccess dynamicFeatureAccess) {
		this.aqlEngine = aqlEngine
		this.dynamicFeatureAccess = dynamicFeatureAccess
	}
	
	def Object eval(EObject target, Behaviored operation, List<Object> parameters) {
		variablesStack = new Stack
		//Init variables
		val Map<String, Object> variables = newHashMap
		variables.put("self", target)
		variables.put("result", null)
		
		val opDefinition = 
			if(operation instanceof Implementation)
				operation.operationRef
			else if (operation instanceof Method)
				operation.operationDef
		opDefinition.EParameters.forEach[param, index|
				variables.put(param.name, parameters.get(index))
			]
		
		variablesStack.push(variables);
		diagnostic = new BasicDiagnostic();
		doSwitch(operation.body)
		val result =  variables.get("result")
		variablesStack.pop();
		
		//return new EvaluationResult(result, diagnostic);
		return result
	}
	
	override caseBlock(Block block) {
		val newScope = newHashMap
		variablesStack.push(newScope)
		block.statements.forEach[stmt |
			doSwitch(stmt)
		]
		variablesStack.pop()
		return null
	}
	
	override caseVariableDeclaration(VariableDeclaration varDecl) {
		val value = aqlEval(varDecl.initialValue)
		variablesStack.peek().put(varDecl.name, value)
		return null
	}
	
	override caseVariableAssignement(VariableAssignement varAssign) {
		val scope = findScope(varAssign.name)
		if(scope !== null) {
			val value = aqlEval(varAssign.value)
			scope.put(varAssign.name, value)
		}
		else {
			//not local variable or operation parameter

			//FIXME : try self.attribute ?
			
			//TODO: error: var not def	
		}
		return null
	}
	
	override caseFeatureAssignment(FeatureAssignment featAssign) {
		val assigned = aqlEval(featAssign.target)
		val value = aqlEval(featAssign.value)

		if(assigned instanceof EObject){
			val feature = assigned.eClass.getEStructuralFeature(featAssign.targetFeature)
			if(feature !== null){
				assigned.eSet(feature,value)
			}
			else{
				dynamicFeatureAccess.setDynamicFeatureValue(assigned,featAssign.targetFeature,value)
			}
		}
		return null
	}
	
	override caseFeatureInsert(FeatureInsert featInsert) {
		val assigned = aqlEval(featInsert.target)
		val value = aqlEval(featInsert.value)
		
		if(assigned instanceof EObject){
			val feature = assigned.eClass.getEStructuralFeature(featInsert.targetFeature)
			val featureValue = assigned.eGet(feature)
			if(featureValue instanceof EList){
				featureValue.add(value)
			}
		}
		return null
	}
	
	override caseFeatureRemove(FeatureRemove featRemove) {
		val assigned = aqlEval(featRemove.target)
		val value = aqlEval(featRemove.value)
			
		if(assigned instanceof EObject){
			val feature = assigned.eClass.getEStructuralFeature(featRemove.targetFeature)
			val featureValue = assigned.eGet(feature)
			if(featureValue instanceof EList){
				featureValue.remove(value)
			}
		}
		return null
	}
	
	override caseFeaturePut(FeaturePut featPut) {
		val assigned = aqlEval(featPut.target)
		val key = aqlEval(featPut.key)
		val value = aqlEval(featPut.value)
		
		if(assigned instanceof EObject){
			val feature = assigned.eClass.getEStructuralFeature(featPut.targetFeature)
			val featureValue = assigned.eGet(feature)
			if(featureValue instanceof EMap){
				featureValue.put(key,value)
			}
		}
		return null
	}
	
	override caseForEach(ForEach forEach) {
		val collection = aqlEval(forEach.collectionExpression) as Collection//TODO: check type
		val newScope = newHashMap
		variablesStack.push(newScope)
		collection.forEach[it|
			newScope.put(forEach.variable,it)
			doSwitch(forEach.body)
		]
		variablesStack.pop()
		return null
	}
	
	override caseWhile(While loop) {
		var conditionValue = aqlEval(loop.collectionExpression)
		while(conditionValue instanceof Boolean && conditionValue == true){
			doSwitch(loop.body)
			conditionValue = aqlEval(loop.collectionExpression)
		}
		return null
	}
	
	override caseIf(If ifStmt) {
		val condition = aqlEval(ifStmt.condition) as Boolean //TODO: check type
		if(condition){
			doSwitch(ifStmt.then)
		}
		else if(ifStmt.^else !== null){
			doSwitch(ifStmt.^else)
		}
		return null
	}
	
	override caseExpressionStatement(ExpressionStatement stmt) {
		return aqlEval(stmt.expression)
	}
	
	/*
	 * Flatten stack
	 */
	def private Map<String,Object> getCurrentScope() {
		val scope = newHashMap
		variablesStack.forEach[frame|
			frame.entrySet.forEach[entry|
				scope.put(entry.key,entry.value)
			]
		]
		return scope
	}
	
	def private aqlEval(Expression expression) {
		val dummyAstResult = new AstResult(expression, {}, {}, #[], new BasicDiagnostic());
		return aqlEngine.eval(dummyAstResult, getCurrentScope()).result
	}
	
	def private findScope(String variable) {
		return variablesStack.reverseView.findFirst[keySet.contains(variable)]
	}
	
}