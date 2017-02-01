package parser.visitor

import implementation.Method
import java.util.List
import implementation.Parameter
import implementation.Block
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecore.EcoreFactory
import implementation.ImplementationPackage
import implementation.ImplementationFactory
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EClassifier
import implementation.VariableDeclaration
import implementation.If
import implementation.Statement
import implementation.ExpressionStatement
import implementation.ForEach
import org.eclipse.emf.ecore.EPackage
import java.util.ArrayList
import org.eclipse.emf.ecore.EClass
import org.eclipse.acceleo.query.runtime.impl.EPackageProvider
import implementation.While
import implementation.FeatureAssignment
import implementation.FeatureInsert
import implementation.FeaturePut
import implementation.FeatureRemove
import implementation.Behaviored
import implementation.ExtendedClass
import implementation.Implementation
import implementation.VariableAssignement
import org.eclipse.acceleo.query.ast.AstPackage
import org.eclipse.acceleo.query.ast.AstFactory
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult
import org.eclipse.acceleo.query.runtime.impl.QueryBuilderEngine
import org.eclipse.acceleo.query.runtime.Query
import org.eclipse.acceleo.query.runtime.IQueryEnvironment

class ModelBuilder {
	
	public static ModelBuilder singleton
	
	def static ModelBuilder createSingleton(IQueryEnvironment qryEnv) {
		ModelBuilder.singleton = new ModelBuilder(qryEnv)
		return singleton
	}
	
	val ecoreFactory = EcorePackage.eINSTANCE.EFactoryInstance as EcoreFactory
	val factory = ImplementationPackage.eINSTANCE.EFactoryInstance as ImplementationFactory
	val IQueryEnvironment qryEnv
	val QueryBuilderEngine builder
	
	new(IQueryEnvironment qryEnv){
		this.qryEnv = qryEnv
		builder = new QueryBuilderEngine(qryEnv);
	}
	
//	def void registerPackages(List<EPackage> pkgs) {
//		pkgs.forEach[ePackageProvider.registerPackage(it)]
//	}
	
	def Behaviored buildOperation(String containingClass, String name, List<Parameter> params, Block body, boolean isMain) {
		val existingOperation = resolve(containingClass, name, params.size)
		
		if(existingOperation === null)
			return buildMethod(name,params,body, isMain)
		else
			return buildImplementation(existingOperation,params,body, isMain)
	}
	
	def Method buildMethod(String name, List<Parameter> params, Block body, boolean isMain) {
		val operation = ecoreFactory.createEOperation
		operation.name = name
		params.forEach[p |
			val opParam = ecoreFactory.createEParameter
			opParam.name = p.name
			opParam.EType = p.type
			operation.EParameters.add(opParam)
		]
		
		val newMethod = factory.createMethod
		newMethod.operationDef = operation
		newMethod.body = body
		newMethod.isMain = isMain
		
		return newMethod
	}
	
	def Implementation buildImplementation(EOperation operationRef, List<Parameter> params, Block body, boolean isMain) {
		val implem = factory.createImplementation
		
		implem.operationRef = operationRef
		implem.body = body
		implem.isMain = isMain
		
		return implem
	}
	
	def Parameter buildParameter(String type, String name) {
		val param = factory.createParameter
		param.name = name
		param.type = resolve(type)
		return param
	}
	
	def VariableDeclaration buildVariableDecl(String name, String exp, String type) {
		val varDecl = factory. createVariableDeclaration
		varDecl.name = name
		varDecl.initialValue = builder.build(exp).ast
		varDecl.type = resolve(type)
		return varDecl 
	}
	
	def VariableAssignement buildVariableAssignement(String name, String exp) {
		val varAssign = factory. createVariableAssignement
		varAssign.name = name
		varAssign.value = builder.build(exp).ast
		return varAssign 
	}
	
	def If buildIf(String condition, Block thenBlock, Block elseBlock) {
		val ifStmt = factory.createIf
		ifStmt.condition = builder.build(condition).ast
		ifStmt.then = thenBlock
		ifStmt.^else = elseBlock
		return ifStmt 
	}
	
	def Block buildBlock(List<Statement> statements) {
		val block = factory.createBlock
		block.statements += statements
		return block
	}
	
	def ExpressionStatement buildExpressionStatement(String value) {
		val exp = factory.createExpressionStatement
		exp.expression = builder.build(value).ast
		return exp
	}
	
	def ForEach buildForEach(String variable, String expression, Block body) {
		val loop = factory.createForEach
		loop.variable = variable
		loop.collectionExpression = builder.build(expression).ast
		loop.body = body
		return loop
	}
	
	def While buildWhile(String expression, Block body) {
		val loop = factory.createWhile
		loop.collectionExpression = builder.build(expression).ast
		loop.body = body
		return loop
	}
	
	def FeatureAssignment buildFeatureAssign(String target, String feature, String valueExp) {
		val featSetting = factory.createFeatureAssignment
		featSetting.target = builder.build(target).ast
		featSetting.targetFeature = feature
		featSetting.value = builder.build(valueExp).ast
		return featSetting
	}
	
	def FeatureInsert buildFeatureInsert(String target, String feature, String valueExp) {
		val featSetting = factory.createFeatureInsert
		featSetting.target = builder.build(target).ast
		featSetting.targetFeature = feature
		featSetting.value = builder.build(valueExp).ast
		return featSetting
	}
	
	def FeatureRemove buildFeatureRemove(String target, String feature, String valueExp) {
		val featSetting = factory.createFeatureRemove
		featSetting.target = builder.build(target).ast
		featSetting.targetFeature = feature
		featSetting.value = builder.build(valueExp).ast
		return featSetting
	}
	
	def FeaturePut buildFeaturePut(String target, String feature, String keyExp, String valueExp) {
		val featSetting = factory.createFeaturePut
		featSetting.target = builder.build(target).ast
		featSetting.targetFeature = feature
		featSetting.key = builder.build(keyExp).ast
		featSetting.value = builder.build(valueExp).ast
		return featSetting
	}
	
	def ExtendedClass buildExtendedClass(String baseCls, List<VariableDeclaration> vars, List<Behaviored> operations) {
		val cls = factory.createExtendedClass
		cls.baseClass = resolve(baseCls) as EClass
		cls.methods += operations
		cls.attributes += vars
		return cls
	}
	
	//Can return null
	def EOperation resolve(String className, String methodName, int nbArgs) {

		//TODO: manage qualified name		
		val candidates = qryEnv.EPackageProvider.EClassifiers.filter(EClass).filter[name == className]
			
		val eOperation = 
			candidates
			.map[EOperations]
			.flatten
			.findFirst[name == methodName && EParameters.size == nbArgs]
			
		return eOperation
	}
	
	def EClassifier resolve(String className) {
		
		//TODO: manage qualified name
		val candidate = qryEnv.EPackageProvider.EClassifiers.findFirst[name == className]
		
//		val candidate = 
//			allPackages
//			.map[EClassifiers.filter(EClass)]
//			.flatten
//			.findFirst[name == className]
		
		if(candidate !== null)
			return candidate
			
		switch className {
			case "boolean" 	: return EcorePackage.eINSTANCE.EBoolean
			case "byte" 	: return EcorePackage.eINSTANCE.EByte
			case "char" 	: return EcorePackage.eINSTANCE.EChar
			case "short" 	: return EcorePackage.eINSTANCE.EShort
			case "int" 		: return EcorePackage.eINSTANCE.EInt
			case "long" 	: return EcorePackage.eINSTANCE.ELong
			case "float" 	: return EcorePackage.eINSTANCE.EFloat
			case "double" 	: return EcorePackage.eINSTANCE.EDouble
			default			: return EcorePackage.eINSTANCE.EClassifier
		}
	}
	
	def AstResult parse(String expression) {
		
		return builder.build(expression)
	}
}