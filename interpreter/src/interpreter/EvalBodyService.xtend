package interpreter

import org.eclipse.acceleo.query.runtime.impl.EOperationService
import org.eclipse.emf.ecore.EOperation
import fr.inria.diverse.xtdAQL.Method
import org.eclipse.emf.ecore.EObject

/**
 * AQL Service to eval EOperation implementation 
 */
class EvalBodyService extends EOperationService{
	
	Interpreter interpreter
	Method implem
	
	new(EOperation eOperation, Method implem, Interpreter interpreter) {
		super(eOperation)
		this.implem = implem
		this.interpreter = interpreter
	}
	
//	override int getPriority() {
//		return super.getPriority() + 1
//	}
	
	//redef to avoid equality with the corresponding EOperationService
	override boolean equals(Object obj) {
		return this === obj
	}
	
	override Object internalInvoke(Object[] arguments) throws Exception {
		val caller = arguments.get(0) as EObject
		interpreter.eval(caller, implem, arguments.drop(1).toList).getResult()
	}
}