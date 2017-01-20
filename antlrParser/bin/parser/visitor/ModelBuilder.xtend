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
	
	def Method buildMethod(String containingClass, String name, List<Parameter> params, Block body) {
		val operation = ecoreFactory.createEOperation
		operation.name = name
		params.forEach[p |
			val opParam = ecoreFactory.createEParameter
			opParam.name = p.name
			opParam.EType = p.type
			operation.EParameters.add(opParam)
		]
		
		val newMethod = factory.createMethod
		newMethod.containingClass = containingClass
		newMethod.operationDef = operation
		newMethod.body = body
		
		return newMethod
	}
	
	def Parameter buildParameter(String type, String name) {
		val param = factory.createParameter
		param.name = name
		param.type = resolve(type)
		return param
	}
	
	def VariableDeclaration buildVariableDecl(String name, String exp) {
		val varDecl = factory. createVariableDeclaration
		varDecl.name = name
		varDecl.valueExpression = exp
		return varDecl 
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
	
	//Can return null
	def EOperation resolve(String className, String methodName, int nbArgs) {

		//TODO: manage qualified name		
		val candidates = ePackageProvider.EClassifiers.filter(EClass).filter[name == className]
		
//		val candidates = 
//			allPackages
//			.map[EClassifiers.filter(EClass)]
//			.flatten
//			.filter[name == className]
			
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
			
		return EcorePackage.eINSTANCE.EClassifier
	}
}