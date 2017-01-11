package interpreter

import fr.inria.diverse.xtdAQL.Method
import fr.inria.diverse.xtdAQL.Root
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
import fr.inria.diverse.XtdAQLStandaloneSetup
import java.util.regex.Pattern

public class Interpreter {
	
	IQueryEnvironment qryEnv
	Root implem
	
	def static void main(String[] args) {
		
		/*
		 * Config
		 */
		val String metamodelPath 	= "model/dummy.ecore" //define EClasses
		val String implementionPath = "model/implem.xmi" //define EOperations bodies
		val String modelPath 		= "model/model.xmi" //instance of the metamodel
		val String mainExpression 	= "self.name + \' : \' + self.eClass().name + '\nService : ' + self.foobar()" // entry point
		
		
		/*
		 * Do stuff
		 */
		
		//Init
		val metamodel = loadModel(metamodelPath).getAllContents().filter(EPackage).toSet
		
		XtdAQLStandaloneSetup.doSetup
		val implemModel = loadModel(implementionPath).getAllContents().head as Root
		
		val interpreter = new Interpreter(metamodel,implemModel)
		
		//AQL expression
		
		/* Main method : 
		 * 
		 * should call the implementation of foobar()
		 */
		val astResult = interpreter.parse(mainExpression);
		
		//Eval
		val newClass1 = loadModel(modelPath).getContents().head;
		val evaluationResult = interpreter.eval(newClass1,astResult);
		val status = evaluationResult.diagnostic
		
		println(status)
		println
		println(evaluationResult.result)
	}
	
	new(Set<EPackage> metamodel, Root implem) {
		this.implem = implem
		createEnvironment(metamodel)
	}
	
	def void createEnvironment(Set<EPackage> metamodel) {
		
		qryEnv = Query.newEnvironmentWithDefaultServices(null);

		//Register service foo()
		val method = MyService.getMethod("foo",Object)
		qryEnv.registerService(new JavaMethodService(method, null));
		
		metamodel.forEach[pkg |
			qryEnv.registerEPackage(pkg)
			
			if (!EPackage.Registry.INSTANCE.containsKey(pkg.nsURI))
				EPackage.Registry.INSTANCE.put(pkg.nsURI, pkg);
				
			registerImplem(pkg)
		]
	}
	
	def AstResult parse(String expression) {
		val builder = new QueryBuilderEngine(qryEnv)
		return builder.build(expression)
	}
	
	/**
	 * Evaluate an AQL expression in the context of {@link target}
	 */
	def EvaluationResult eval(EObject target, AstResult expression) {
		val engine = new QueryEvaluationEngine(qryEnv)
		val Map<String, Object> variables = newHashMap
		variables.put("self", target)
		return engine.eval(expression, variables)
	}
	
	/**
	 * Evaluate the body of an implemented EOperation
	 */
	def EvaluationResult eval(EObject target, Method implem, List<Object> paramters) {
		val engine = new QueryEvaluationEngine(qryEnv)
		
		var body = implem.body.replaceFirst(Pattern.quote("["),"")
		body = body.replaceFirst(Pattern.quote("/]"),"")
		val expression = parse(body)
		
		val Map<String, Object> variables = newHashMap
		variables.put("self", target)
		implem.param.forEach[param, index|
			variables.put(param.name, paramters.get(index))
		]
		
		return engine.eval(expression, variables)
	}
	
	/**
	 * Register a service for each implementation of EOperation
	 */
	def private registerImplem(EPackage p) {
		p.getEClassifiers.filter(EClass).forEach[registerImplem]
	}
	
	/**
	 * Register a service for each implementation of EOperation
	 */
	def private registerImplem(EClass cls) {
		cls.getEAllOperations().forEach[op |
			val opImpl = implem?.classes?.findFirst[it.name == cls.name]?.methods?.findFirst[name == op.name]
			if(opImpl !== null) {
				qryEnv.registerService(new EvalBodyService(op,opImpl,this));
			}
		]
	}
	
	def static Resource loadModel(String path) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());

		val rs = new ResourceSetImpl();
		val uri = URI.createURI(path);
		return rs.getResource(uri, true);
	}
}
