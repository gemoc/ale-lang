package interpreter

import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.acceleo.query.runtime.EvaluationResult
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult
import org.eclipse.acceleo.query.runtime.IQueryEnvironment
import org.eclipse.acceleo.query.runtime.Query
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService
import org.eclipse.acceleo.query.runtime.impl.QueryBuilderEngine
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import java.util.regex.Pattern
import org.eclipse.emf.ecore.plugin.EcorePlugin
import implementation.Behaviored
import implementation.Root
import implementation.Method
import implementation.Implementation
import org.eclipse.emf.ecore.resource.ResourceSet
import implementation.impl.ImplementationFactoryImpl
import implementation.ImplementationPackage
import vmlogo.VmlogoPackage
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.acceleo.query.runtime.impl.LambdaValue
import implementation.Statement
import implementation.Block
import org.eclipse.emf.common.util.BasicDiagnostic
import implementation.VariableDeclaration
import implementation.FeatureAssignment
import implementation.ForEach
import implementation.If
import implementation.Expression
import java.util.Collection
import parser.AstBuilder
import java.nio.file.Paths
import java.nio.file.Files
import implementation.While
import org.eclipse.emf.ecore.EFactory
import org.eclipse.emf.common.util.EList
import implementation.FeatureInsert
import implementation.FeaturePut
import org.eclipse.emf.common.util.EMap
import implementation.FeatureRemove
import drawing.Window
import vmlogo.Context

public class Interpreter {
	
	IQueryEnvironment qryEnv
	Root implemModel
	Set<EPackage> metamodel
	DynamicFeatureAccess dynamicFeatureAccess
	
	def static void main(String[] args) {
		
		/*
		 * Config
		 */
		val String metamodelPath 	= "/home/fcoulon/git/fluffy-umbrella/k3.sample.maven.logo.model/model/ASMLogo.ecore" //define EClasses
		
//		val String implementionPath = "model/LogoImplem2.xmi" //define EOperations bodies
//		val String implementionPath = "data/My.implementation"
		val String implementionPath = "data/LogoProgram.implem"
		val String modelPath 		= "model/LogoProgram.xmi" //instance of the metamodel
//		val String contextPath = "model/Context.xmi"
		val String contextPath = "data/My.vmlogo"
		
		val String mainExpression 	= "self.eval(context)" // entry point
		
		
		/*
		 * Do stuff
		 */
		
		//Init
		val rs = new ResourceSetImpl
		val metamodel = loadModel(metamodelPath,rs).getAllContents().filter(EPackage).toSet
		val implemPkg = ImplementationPackage.eINSTANCE
		val vmPkg = VmlogoPackage.eINSTANCE
		metamodel += vmPkg
//		val implemModel = loadModel(implementionPath,rs).getAllContents().head as Root
//		EcoreUtil.resolveAll(implemModel);
		
		val fileContent = new String(Files.readAllBytes(Paths.get(implementionPath)));
		val implemModel = (new AstBuilder(metamodel)).parse(fileContent)
		
		val interpreter = new Interpreter(metamodel,implemModel)
		interpreter.registerImplem()
		interpreter.qryEnv.registerEPackage(vmPkg)//TODO: urgly
		
		//AQL expression
		
		/* Main method : 
		 * 
		 * should call the implementation of foobar()
		 */
		val astResult = interpreter.parse(mainExpression);
		
		//Eval
		val root = loadModel(modelPath,rs).getContents().head;
		val ctx = loadModel(contextPath,rs).getContents().head;
		val arguments = newHashMap("context" -> ctx)
		val evaluationResult = interpreter.eval(root,astResult,arguments);
		val status = evaluationResult.diagnostic
		
		val win = new Window((ctx as Context).turtle)
		
		println(status)
		println
		println(evaluationResult.result)
	}
	
	new(Set<EPackage> metamodel, Root implem) {
		this.implemModel = implem
		this.metamodel = metamodel
		createEnvironment()
	}
	
	def void createEnvironment() {
		
		qryEnv = Query.newEnvironmentWithDefaultServices(null);

		//Register service foo()
		val method = MyService.getMethod("foo",Object)
		qryEnv.registerService(new JavaMethodService(method, null));
		val logMethod = LogService.getMethod("log",Object)
		qryEnv.registerService(new JavaMethodService(logMethod, null));
		val createMethod = FactoryService.getMethod("create",EClass)
		qryEnv.registerService(new JavaMethodService(createMethod, null));
		val cosMethod = TrigoServices.getMethod("cosinus",Double)
		qryEnv.registerService(new JavaMethodService(cosMethod, null));
		val sinMethod = TrigoServices.getMethod("sinus",Double)
		qryEnv.registerService(new JavaMethodService(sinMethod, null));
		val tanMethod = TrigoServices.getMethod("tan",Double)
		qryEnv.registerService(new JavaMethodService(tanMethod, null));
		val featureAccessMethod = DynamicFeatureAccess.getMethod("aqlFeatureAccess",EObject,String)
		this.dynamicFeatureAccess = new DynamicFeatureAccess(implemModel)
		qryEnv.registerService(new DynamicFeatureAccessService(featureAccessMethod, dynamicFeatureAccess));
//		val addMethod = EListService.getMethod("add",Collection,Object)
//		qryEnv.registerService(new JavaMethodService(addMethod, null));
//		val forEachMethod = ForEachService.getMethod("forEach",List,LambdaValue)
//		qryEnv.registerService(new JavaMethodService(forEachMethod, null));
		
		metamodel.forEach[pkg |
			qryEnv.registerEPackage(pkg)
			
			if (!EPackage.Registry.INSTANCE.containsKey(pkg.nsURI))
				EPackage.Registry.INSTANCE.put(pkg.nsURI, pkg);
		]
//		registerFactoryServices(metamodel)
	}
	
	def AstResult parse(String expression) {
		var exp = expression.replaceFirst(Pattern.quote("["),"")
		exp = exp.replaceFirst(Pattern.quote("/]"),"")
		
		val builder = new QueryBuilderEngine(qryEnv)
		return builder.build(exp)
	}
	
	/**
	 * Evaluate an AQL expression in the context of {@link target}
	 */
	def EvaluationResult eval(EObject target, AstResult expression, Map<String, EObject> args) {
		val engine = new QueryEvaluationEngine(qryEnv)
		val Map<String, Object> variables = newHashMap
//		variables.putAll(factoryRefs)
		variables.put("self", target)
		variables.putAll(args)
		return engine.eval(expression, variables)
	}
	
	/**
	 * Evaluate the body of an implemented EOperation
	 */
	def Object eval(EObject target, Behaviored implem, List<Object> paramters) { //TODO: manage runtime errors
		
		//Init variables
		val Map<String, Object> variables = newHashMap
		variables.put("self", target)
		variables.put("result", null)
		
		if(implem instanceof Implementation) {
			implem.operationRef.EParameters.forEach[param, index|
				variables.put(param.name, paramters.get(index))
			]
		}
		else if (implem instanceof Method) {
			implem.operationDef.EParameters.forEach[param, index|
				variables.put(param.name, paramters.get(index))
			]
		}
		
		eval(implem.body,variables)
		
		return variables.get("result")
		
//		var body = implem.statements.replaceFirst(Pattern.quote("["),"")
//		body = body.replaceFirst(Pattern.quote("/]"),"")
//		val expression = parse(body)
//		
//		val engine = new QueryEvaluationEngine(qryEnv)
//		return engine.eval(expression, variables)
	}
	
	/*
	 * Always return the variable 'result'
	 */
	def Object eval(Statement stmt, Map<String, Object> variables) { //TODO: try/catch + error mngmt
		val engine = new QueryEvaluationEngine(qryEnv)
		
		if(stmt instanceof Block) {
			val newScope = newHashMap
			newScope.putAll(variables)
			stmt.statements.forEach[s |
				eval(s,newScope)
			]
			variables.keySet.forEach[key|
				variables.put(key,newScope.get(key))
			]
		}
		else if(stmt instanceof VariableDeclaration) {
			val expression = parse(stmt.valueExpression)
			val valueRes = engine.eval(expression, variables)
			variables.put(stmt.name,valueRes.result)
		}
		else if(stmt instanceof FeatureAssignment) {
			val assignedExp = parse(stmt.targetExpression)
			val assigned = engine.eval(assignedExp, variables).result
			val valueExp = parse(stmt.valueExpression)
			val value = engine.eval(valueExp, variables).result
//			val setter = getJavaMethod(assigned.class,"set"+stmt.targetFeature.toFirstUpper,value.class)
//			if(setter !== null)
//				setter.invoke(assigned,value)

			if(assigned instanceof EObject){
				val feature = assigned.eClass.getEStructuralFeature(stmt.targetFeature)
				if(feature !== null){
					assigned.eSet(feature,value)
				}
				else{
					dynamicFeatureAccess.setDynamicFeatureValue(assigned,stmt.targetFeature,value)
				}
			}
		}
		else if(stmt instanceof FeatureInsert) {
			val assignedExp = parse(stmt.targetExpression)
			val assigned = engine.eval(assignedExp, variables).result
			val valueExp = parse(stmt.valueExpression)
			val value = engine.eval(valueExp, variables).result
			
			if(assigned instanceof EObject){
				val feature = assigned.eClass.getEStructuralFeature(stmt.targetFeature)
				val featureValue = assigned.eGet(feature)
				if(featureValue instanceof EList){
					featureValue.add(value)
				}
			}
		}
		else if(stmt instanceof FeatureRemove) {
			val assignedExp = parse(stmt.targetExpression)
			val assigned = engine.eval(assignedExp, variables).result
			val valueExp = parse(stmt.valueExpression)
			val value = engine.eval(valueExp, variables).result
			
			if(assigned instanceof EObject){
				val feature = assigned.eClass.getEStructuralFeature(stmt.targetFeature)
				val featureValue = assigned.eGet(feature)
				if(featureValue instanceof EList){
					featureValue.remove(value)
				}
			}
		}
		else if(stmt instanceof FeaturePut) {
			val assignedExp = parse(stmt.targetExpression)
			val assigned = engine.eval(assignedExp, variables).result
			val keyExp = parse(stmt.keyExpression)
			val key = engine.eval(keyExp, variables).result
			val valueExp = parse(stmt.valueExpression)
			val value = engine.eval(valueExp, variables).result
			
			if(assigned instanceof EObject){
				val feature = assigned.eClass.getEStructuralFeature(stmt.targetFeature)
				val featureValue = assigned.eGet(feature)
				if(featureValue instanceof EMap){
					featureValue.put(key,value)
				}
			}
		}
		else if(stmt instanceof ForEach) {
			val collectionExp = parse(stmt.collectionExpression)
			val collection = engine.eval(collectionExp, variables).result as Collection//TODO: check type
			val newScope = newHashMap
			newScope.putAll(variables)
			collection.forEach[it|
				newScope.put(stmt.variable,it)
				eval(stmt.body,newScope)
			]
			variables.keySet.forEach[key|
				variables.put(key,newScope.get(key))
			]
		}
		else if(stmt instanceof While) {
			val condition = parse(stmt.collectionExpression)
			var conditionValue = engine.eval(condition, variables).result
			while(conditionValue instanceof Boolean && conditionValue == true){
				eval(stmt.body,variables)
				conditionValue = engine.eval(condition, variables).result
			}
		}
		else if(stmt instanceof If) {
			val conditionExp = parse(stmt.condition)
			val condition = engine.eval(conditionExp, variables).result as Boolean //TODO: check type
			if(condition){
				eval(stmt.then,variables)
			}
			else if(stmt.^else !== null){
				eval(stmt.^else,variables)
			}
		}
		else if(stmt instanceof Expression) {
			val valueExp = parse(stmt.value)
			engine.eval(valueExp, variables)
		}
		
		return variables.get("result")
	}
	
	def private java.lang.reflect.Method getJavaMethod(Class cls, String methodName, Class argType) {
		
		val candidates =
			cls.methods
			.filter[name == methodName]
			.filter[parameterCount == 1]
			
		val firstTry =
			candidates
			.filter[parameterTypes.get(0).isAssignableFrom(argType)]
			.head
		
		if(firstTry !== null)
			return firstTry
		
		val primitiveType =
			switch argType {
				case typeof(Boolean) 	: typeof(boolean)
				case typeof(Byte) 		: typeof(byte)
				case typeof(Character)	: typeof(char)
				case typeof(Short) 		: typeof(short)
				case typeof(Integer) 	: typeof(int)
				case typeof(Long) 		: typeof(long)
				case typeof(Float) 		: typeof(float)
				case typeof(Double) 	: typeof(double)
				default 				: null 
			}
		
		if(primitiveType !== null)
			return candidates
			.filter[parameterTypes.get(0).isAssignableFrom(primitiveType)]
			.head
		
		return null
	} 
//	/**
//	 * Register a service for each implementation of EOperation
//	 */
//	def private registerImplem(EPackage p) {
//		p.getEClassifiers.filter(EClass).forEach[registerImplem]
//	}
//	
//	/**
//	 * Register a service for each implementation of EOperation
//	 */
//	def private registerImplem(EClass cls) {
//		cls.getEAllOperations().forEach[op |
//			val opImpl = implem?.classes?.findFirst[it.name == cls.name]?.methods?.findFirst[name == op.name]
//			if(opImpl !== null) {
//				qryEnv.registerService(new EvalBodyService(op,opImpl,this));
//			}
//		]
//	}
	
	def private registerImplem() {
		implemModel.classExtensions.map[methods].flatten.forEach[implem |
			qryEnv.registerService(new EvalBodyService(implem,this));
		]
	}
	
//	def private void registerFactoryServices(Set<EPackage> pkgs) {
//		pkgs.forEach[pkg |
//			val factory = pkg.EFactoryInstance
//			factory.class.methods
//				.filter[parameterCount == 0]
//				.filter[name.startsWith("create")]
//				.forEach[createMethod|
//					qryEnv.registerService(new JavaMethodService(createMethod, factory));
//				]
//		]		
//	}
	
//	def Map<String,EFactory> getFactoryRefs() {
//		val map = newHashMap
//		metamodel.forEach[pkg |
//			val factory = pkg.EFactoryInstance
//			map.put(factory.eClass.name,factory)
//		]
//		return map
//	}
	
	def getMetamodel() {
		return metamodel
	}
	
	def static Resource loadModel(String path) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

		val rs = new ResourceSetImpl();
		val uri = URI.createURI(path);
		return rs.getResource(uri, true);
	}
	
	def static Resource loadModel(String path,ResourceSet rs) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

		val uri = URI.createURI(path);
		return rs.getResource(uri, true);
	}
	
	
}
