//package parser
//
//import implementation.ImplementationPackage
//import implementation.ImplementationFactory
//import implementation.Root
//import parser.XtdAQLParser.RRootContext
//import parser.XtdAQLParser.RClassContext
//import parser.XtdAQLParser.ROperationContext
//import parser.XtdAQLParser.RParametersContext
//import parser.XtdAQLParser.RVariableContext
//import org.eclipse.emf.ecore.EObject
//import org.eclipse.emf.ecore.EClassifier
//import org.eclipse.emf.ecore.EClass
//import org.eclipse.emf.ecore.EcorePackage
//import implementation.Parameter
//import java.util.List
//import org.eclipse.emf.ecore.EOperation
//import implementation.Implementation
//import implementation.Method
//import org.eclipse.emf.ecore.EcoreFactory
//import implementation.Block
//import parser.XtdAQLParser.RAssignContext
//import parser.XtdAQLParser.ExpContext
//import java.util.Stack
//import parser.XtdAQLParser.AssignContext
//import parser.XtdAQLParser.IfContext
//import parser.XtdAQLParser.LoopContext
//import implementation.Expression
//import implementation.VariableDeclaration
//import implementation.If
//import implementation.ForEach
//import java.util.EmptyStackException
//import parser.XtdAQLParser.RBlockContext
//
//class XtdAqlListener extends XtdAQLBaseListener{
//	
//	ImplementationFactory factory
//	EcoreFactory ecoreFactory
//	
//	List<Parameter> tmpParameters = newArrayList
//	String currentClass
//	
//	Stack<Object> stack = new Stack
//	
//	Root result
//	
//	new() {
//		factory = ImplementationPackage.eINSTANCE.EFactoryInstance as ImplementationFactory
//		ecoreFactory = EcorePackage.eINSTANCE.EFactoryInstance as EcoreFactory
//		result = factory.createRoot
//	}
//	
//	def Root getModel() {
//		return result
//	}
//	
//	override exitROperation(ROperationContext ctx) {
//		
//		//TODO:return method or implem
//		val operationName = ctx.getChild(1).text
//		val nbArgs = tmpParameters.size
//		val className = ctx.parent.getChild(1).text
//		
//		val realOperation = resolve(className, operationName, nbArgs)
//		if(realOperation !== null) {
//			result.declarations += buildImplementation(realOperation, null) //TODO: body
//		}
//		else {
//			result.declarations += buildMethod(className, operationName, tmpParameters, null) //TODO: body
//		}
//		
//		tmpParameters.clear
//	}
//	
//	override exitRVariable(RVariableContext ctx) {
//		val type = ctx.getChild(0).text
//		val name = ctx.getChild(1).text
//		tmpParameters.add(buildParameter(type,name))
//	}
//	
//	
//	override exitExp(ExpContext ctx) {
//		val rctx= ctx.ruleContext
//		val exp = factory.createExpression
//		exp.value = ctx.text
//		feed(exp)
//	}
//	
//	override exitRBlock(RBlockContext ctx) {
//		stack.pop
//	}
//	
//	override exitRAssign(RAssignContext ctx) {
//		val assign = stack.pop as VariableDeclaration
//		val block = stack.peek
//		if(block instanceof Block)
//			block.statements += assign
//	}
//	
//	override exitIf(IfContext ctx) {
//		val ifStmt = stack.pop as If
//		val block = stack.peek
//		if(block instanceof Block)
//			block.statements += ifStmt
//	}
//	
//	override exitLoop(LoopContext ctx) {
//		val loop = stack.pop as ForEach
//		val block = stack.peek
//		if(block instanceof Block)
//			block.statements += loop
//	}
//
//	
//	override enterRBlock(RBlockContext ctx) {
//		stack.push(factory.createBlock)
//	}
//	override enterAssign(AssignContext ctx) {
//		stack.push(factory.createVariableDeclaration)
//	}
//	override enterIf(IfContext ctx) {
//		stack.push(factory.createIf)
//	}
//	override enterLoop(LoopContext ctx) {
//		stack.push(factory.createForEach)
//	}
//	
//	override enterRRoot(RRootContext ctx) {
//		super.enterRRoot(ctx)
//	}
//	override enterRClass(RClassContext ctx) {
//		super.enterRClass(ctx)
//	}
//	override enterROperation(ROperationContext ctx) {
//		super.enterROperation(ctx)
//	}
//	
//	
//	
//	def void feed(Expression exp) {
//		
//		try {
//			val eater = stack.peek
//		
//			if(eater instanceof VariableDeclaration){
//				eater.valueExpression = exp.value
//			}
//			else if(eater instanceof If){
//				eater.condition = exp.value
//			}
//			else if(eater instanceof ForEach){
//				eater.collectionExpression = exp.value
//			}
//			else if(eater instanceof Block){
//				eater.statements += exp
//			}
//		} catch (EmptyStackException exception) {
//			
//		}
//	}
//	
//	
//	
//	def Parameter buildParameter(String type, String name) {
//		val param = factory.createParameter
//		param.name = name
//		param.type = resolve(type)
//		return param
//	}
//	
//	def Method buildMethod(String containingClass, String name, List<Parameter> params, Block body) {
//		
//		val operation = ecoreFactory.createEOperation
//		operation.name = name
//		params.forEach[p |
//			val opParam = ecoreFactory.createEParameter
//			opParam.name = p.name
//			opParam.EType = p.type
//			operation.EParameters.add(opParam)
//		]
//		
//		val newMethod = factory.createMethod
//		newMethod.containingClass = containingClass
//		newMethod.operationDef = operation
//		newMethod.body = body
//		
//		return newMethod
//	}
//	
//	def Implementation buildImplementation(EOperation op, String body) {
//		val implem = factory.createImplementation
//		
//		return implem
//	}
//	
//	
//	//Can return null
//	def EOperation resolve(String className, String methodName, int nbArgs) {
//		//TODO: use IPackageProvider
//		return null
//	}
//	
//	def EClassifier resolve(String name) {
//		//TODO: use IPackageProvider (& need qualified name)
//		return EcorePackage.eINSTANCE.EClassifier
//	}
//}