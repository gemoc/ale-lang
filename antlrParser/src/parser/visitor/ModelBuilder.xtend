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
import implementation.Expression
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

class ModelBuilder {
	
	public static ModelBuilder singleton
	
	def static ModelBuilder createSingleton(EPackageProvider ePackageProvider) {
		ModelBuilder.singleton = new ModelBuilder(ePackageProvider)
		return singleton
	}


	
	
	EPackageProvider ePackageProvider
	
	val ecoreFactory = EcorePackage.eINSTANCE.EFactoryInstance as EcoreFactory
	val factory = ImplementationPackage.eINSTANCE.EFactoryInstance as ImplementationFactory
	
	new(EPackageProvider ePackageProvider){
		this.ePackageProvider = ePackageProvider
	}
	
//	static val allPackages = new ArrayList<EPackage>
	
//	def static void initPackages(List<EPackage> pkgs) { //TODO: remove static stuff
//		allPackages.clear
//		allPackages.addAll(pkgs)
//	}

	def void registerPackages(List<EPackage> pkgs) {
		pkgs.forEach[ePackageProvider.registerPackage(it)]
	}
	
	def Behaviored buildOperation(String containingClass, String name, List<Parameter> params, Block body) {
		val existingOperation = resolve(containingClass, name, params.size)
		
		if(existingOperation === null)
			return buildMethod(name,params,body)
		else
			return buildImplementation(existingOperation,params,body)
	}
	
	def Method buildMethod(String name, List<Parameter> params, Block body) {
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
		
		return newMethod
	}
	
	def Implementation buildImplementation(EOperation operationRef, List<Parameter> params, Block body) {
		val implem = factory.createImplementation
		
		implem.operationRef = operationRef
		implem.body = body
		
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
		varDecl.valueExpression = exp
		varDecl.type = resolve(type)
		return varDecl 
	}
	
	def VariableAssignement buildVariableAssignement(String name, String exp) {
		val varAssign = factory. createVariableAssignement
		varAssign.name = name
		varAssign.valueExpression = exp
		return varAssign 
	}
	
	def If buildIf(String condition, Block thenBlock, Block elseBlock) {
		val ifStmt = factory.createIf
		ifStmt.condition = condition
		ifStmt.then = thenBlock
		ifStmt.^else = elseBlock
		return ifStmt 
	}
	
	def Block buildBlock(List<Statement> statements) {
		val block = factory.createBlock
		block.statements += statements
		return block
	}
	
	def Expression buildExpression(String value) {
		val exp = factory.createExpression
		exp.value = value
		return exp
	}
	
	def ForEach buildForEach(String variable, String expression, Block body) {
		val loop = factory.createForEach
		loop.variable = variable
		loop.collectionExpression = expression
		loop.body = body
		return loop
	}
	
	def While buildWhile(String expression, Block body) {
		val loop = factory.createWhile
		loop.collectionExpression = expression
		loop.body = body
		return loop
	}
	
	def FeatureAssignment buildFeatureAssign(String target, String feature, String valueExp) {
		val featSetting = factory.createFeatureAssignment
		featSetting.targetExpression = target
		featSetting.targetFeature = feature
		featSetting.valueExpression = valueExp
		return featSetting
	}
	
	def FeatureInsert buildFeatureInsert(String target, String feature, String valueExp) {
		val featSetting = factory.createFeatureInsert
		featSetting.targetExpression = target
		featSetting.targetFeature = feature
		featSetting.valueExpression = valueExp
		return featSetting
	}
	
	def FeatureRemove buildFeatureRemove(String target, String feature, String valueExp) {
		val featSetting = factory.createFeatureRemove
		featSetting.targetExpression = target
		featSetting.targetFeature = feature
		featSetting.valueExpression = valueExp
		return featSetting
	}
	
	def FeaturePut buildFeaturePut(String target, String feature, String keyExp, String valueExp) {
		val featSetting = factory.createFeaturePut
		featSetting.targetExpression = target
		featSetting.targetFeature = feature
		featSetting.keyExpression = keyExp
		featSetting.valueExpression = valueExp
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
		val candidates = ePackageProvider.EClassifiers.filter(EClass).filter[name == className]
			
		val eOperation = 
			candidates
			.map[EOperations]
			.flatten
			.findFirst[name == methodName && EParameters.size == nbArgs]
			
		return eOperation
	}
	
	def EClassifier resolve(String className) {
		
		//TODO: manage qualified name
		val candidate = ePackageProvider.EClassifiers.findFirst[name == className]
		
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
}