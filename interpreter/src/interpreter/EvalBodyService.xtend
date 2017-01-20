package interpreter

import org.eclipse.acceleo.query.runtime.impl.EOperationService
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.EObject
import implementation.Behaviored
import org.eclipse.acceleo.query.runtime.impl.AbstractService
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment
import org.eclipse.acceleo.query.ast.Call
import org.eclipse.acceleo.query.runtime.impl.ValidationServices
import org.eclipse.acceleo.query.runtime.IValidationResult
import java.util.List
import org.eclipse.acceleo.query.validation.type.IType
import implementation.Method
import implementation.Implementation
import java.util.ArrayList
import org.eclipse.acceleo.query.validation.type.EClassifierType
import org.eclipse.emf.ecore.EParameter
import org.eclipse.acceleo.query.validation.type.SequenceType
import implementation.Parameter
import java.util.Set
import java.util.LinkedHashSet
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage

/**
 * AQL Service to eval EOperation implementation 
 */
class EvalBodyService extends AbstractService{
	
	Interpreter interpreter
	Behaviored implem
	
	new(Behaviored implem, Interpreter interpreter) {
		this.implem = implem
		this.interpreter = interpreter
	}
	
//	override int getPriority() {
//		return super.getPriority() + 1
//	}
//	
//	//redef to avoid equality with the corresponding EOperationService
//	override boolean equals(Object obj) {
//		return this === obj
//	}
	
	override Object internalInvoke(Object[] arguments) throws Exception {
		val caller = arguments.get(0) as EObject
		interpreter.eval(caller, implem, arguments.drop(1).toList)
	}
	
	override getName() {
		if(implem instanceof Method){
			return implem.operationDef.name
		}
		else if(implem instanceof Implementation){
			return implem.operationRef.name
		}
		else
			return "undefined"
	}
	
	override getNumberOfParameters() {
		if(implem instanceof Method){
			return implem.operationDef.EParameters.size + 1
		}
		else if(implem instanceof Implementation){
			return implem.operationRef.EParameters.size + 1
		}
		else
			return 1
	}
	
	override getParameterTypes(IReadOnlyQueryEnvironment queryEnvironment) {
		val List<IType> result = new ArrayList<IType>()
		if(implem instanceof Implementation) {
			result.add(new EClassifierType(queryEnvironment, implem.operationRef.getEContainingClass()))
			for (EParameter parameter : implem.operationRef.getEParameters()) {
				val EClassifierType rawType = new EClassifierType(queryEnvironment, parameter.getEType())
				if (parameter.isMany()) {
					result.add(new SequenceType(queryEnvironment, rawType))
				} else {
					result.add(rawType)
				}
			}
		}
		else if(implem instanceof Method) {
			//TODO: take care of qualified name & EClass not found
			val containingClass = interpreter.metamodel.map[EClassifiers].flatten.findFirst[name == implem.containingClass]
			result.add(new EClassifierType(queryEnvironment, containingClass))
			for (EParameter parameter : implem.operationDef.getEParameters()) {
				val EClassifierType rawType = new EClassifierType(queryEnvironment, parameter.getEType)
				if (parameter.isMany()) {
					result.add(new SequenceType(queryEnvironment, rawType))
				} else {
					result.add(rawType)
				}
			}
		}
		return result;
	}
	
	override getPriority() {
		return EOperationService.PRIORITY + 1;
	}
	
	override getShortSignature() {
		val List<IType> parameterTypes = getParameterTypes(null);
//		val t = new IType[]
//		val IType[] argumentTypes = parameterTypes.toArray(new IType[parameterTypes.size()]);

		return serviceShortSignature(parameterTypes);
	}
	
	override getLongSignature() {
		var String ePkgNsURI
		var String eCLassName

		val EClass eContainingClass = 
			if(implem instanceof Implementation)
				implem.operationRef.EContainingClass
			else if(implem instanceof Method)
				interpreter.metamodel.map[EClassifiers].flatten.filter(EClass).findFirst[name == implem.containingClass]
		
		if (eContainingClass != null) {
			eCLassName = eContainingClass.getName()
			val EPackage ePackage = eContainingClass.getEPackage()
			if (ePackage != null) {
				ePkgNsURI = ePackage.getNsURI()
			} else {
				ePkgNsURI = null
			}
		} else {
			ePkgNsURI = null
			eCLassName = null
		}

		return ePkgNsURI + " " + eCLassName + " " + getShortSignature()
	}
	
	override getType(Call call, ValidationServices services, IValidationResult validationResult, IReadOnlyQueryEnvironment queryEnvironment, List<IType> argTypes) {
		val Set<IType> result = new LinkedHashSet<IType>()

		val eOperation = 
			if(implem instanceof Implementation)
				implem.operationRef
			else if(implem instanceof Method)
				implem.operationDef
				
		val IType eClassifierType = new EClassifierType(queryEnvironment, eOperation.getEType())
		if (eOperation.isMany()) {
			result.add(new SequenceType(queryEnvironment, eClassifierType))
		} else {
			result.add(eClassifierType)
		}

		return result
	}
}
