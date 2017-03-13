package lang.core.interpreter.services;

import org.eclipse.acceleo.query.runtime.impl.EOperationService;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EObject;
import implementation.Behaviored;
import org.eclipse.acceleo.query.runtime.impl.AbstractService;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import java.util.List;
import java.util.Optional;

import org.eclipse.acceleo.query.validation.type.IType;
import implementation.Method;
import implementation.ModelBehavior;
import implementation.RuntimeClass;
import implementation.Implementation;
import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import lang.core.interpreter.DiagnosticLogger;
import lang.core.interpreter.EvalEnvironment;
import lang.core.interpreter.ImplementationEvaluator;
import lang.core.parser.visitor.ModelBuilder;

import java.util.Set;
import java.util.LinkedHashSet;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import implementation.ExtendedClass;

import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;

/**
 * AQL Service to eval EOperation implementation 
 */
public class EvalBodyService extends AbstractService {
	
	EvalEnvironment evalEnv;
	Behaviored implem;
	DiagnosticLogger logger;
	
	int priority = EOperationService.PRIORITY + 1;
	
	public EvalBodyService (Behaviored implem, EvalEnvironment evalEnv, DiagnosticLogger logger) {
		this.implem = implem;
		this.evalEnv = evalEnv;
		this.logger = logger;
	}
	
	@Override
	public Object internalInvoke(Object[] arguments) throws Exception {
		EObject caller = (EObject) arguments[0];
		ImplementationEvaluator evaluator = new ImplementationEvaluator(new QueryEvaluationEngine(evalEnv.getQueryEnvironment()), evalEnv.getFeatureAccess());
		List<Object> args = new ArrayList<Object>();
		for(int i = 1; i < arguments.length; i++)
			args.add(arguments[i]);
		EvaluationResult eval = evaluator.eval(caller, implem, args);
		logger.notify(eval.getDiagnostic());
		return eval.getResult();
	}
	
	@Override
	public String getName() {
		if(implem instanceof Method){
			return ((Method)implem).getOperationDef().getName();
		}
		else if(implem instanceof Implementation){
			return ((Implementation)implem).getOperationRef().getName();
		}
		else
			return "undefined";
	}
	
	@Override
	public int getNumberOfParameters() {
		if(implem instanceof Method){
			return ((Method)implem).getOperationDef().getEParameters().size() + 1;
		}
		else if(implem instanceof Implementation){
			return ((Implementation)implem).getOperationRef().getEParameters().size() + 1;
		}
		else
			return 1;
	}
	
	@Override
	public List<IType> getParameterTypes(IReadOnlyQueryEnvironment queryEnvironment) {
		List<IType> result = new ArrayList<IType>();
		if(implem instanceof Implementation) {
			result.add(new EClassifierType(queryEnvironment, ((Implementation)implem).getOperationRef().getEContainingClass()));
			for (EParameter parameter : ((Implementation)implem).getOperationRef().getEParameters()) {
				EClassifierType rawType = new EClassifierType(queryEnvironment, parameter.getEType());
				if (parameter.isMany()) {
					result.add(new SequenceType(queryEnvironment, rawType));
				} else {
					result.add(rawType);
				}
			}
		}
		else if(implem instanceof Method) {
			//TODO: take care of qualified name & EClass not found
			if(implem.eContainer() instanceof ExtendedClass) {
				EClass containingClass = ((ExtendedClass)implem.eContainer()).getBaseClass();
				result.add(new EClassifierType(queryEnvironment, containingClass));
			}
			else if (implem.eContainer() instanceof RuntimeClass) {
				RuntimeClass container = ((RuntimeClass)implem.eContainer());
				String pkgName = ((ModelBehavior)container.eContainer()).getName();
				String simpleName = container.getName();
				String fullName = pkgName+"."+simpleName;
				Collection<EClassifier> candidates = queryEnvironment.getEPackageProvider().getTypes(simpleName); //TODO: move to constructor
				Optional<EClassifier> containingClass =
					candidates
					.stream()
					.filter(cls -> ModelBuilder.getQualifiedName(cls).equals(fullName))
					.findFirst();
				if(containingClass.isPresent()) {
					result.add(new EClassifierType(queryEnvironment, containingClass.get()));
				}
			}
			
			for (EParameter parameter : ((Method)implem).getOperationDef().getEParameters()) {
				EClassifierType rawType = new EClassifierType(queryEnvironment, parameter.getEType());
				if (parameter.isMany()) {
					result.add(new SequenceType(queryEnvironment, rawType));
				} else {
					result.add(rawType);
				}
			}
		}
		return result;
	}
	
	@Override
	public int getPriority() {
		return priority;
	}
	
	@Override
	public String getShortSignature() {
		List<IType> parameterTypes = getParameterTypes(null);
		return serviceShortSignature(parameterTypes.toArray());
	}
	
	@Override
	public String getLongSignature() {
		String ePkgNsURI;
		String eCLassName;
		
		EClass eContainingClass = ((ExtendedClass) implem.eContainer()).getBaseClass();
		
		if (eContainingClass != null) {
			eCLassName = eContainingClass.getName();
			EPackage ePackage = eContainingClass.getEPackage();
			if (ePackage != null) {
				ePkgNsURI = ePackage.getNsURI();
			} else {
				ePkgNsURI = null;
			}
		} else {
			ePkgNsURI = null;
			eCLassName = null;
		}

		return ePkgNsURI + " " + eCLassName + " " + getShortSignature();
	}
	
	@Override
	public Set<IType> getType(Call call, ValidationServices services, IValidationResult validationResult, IReadOnlyQueryEnvironment queryEnvironment, List<IType> argTypes) {
		Set<IType> result = new LinkedHashSet<IType>();

		EOperation eOperation = null;
		if(implem instanceof Implementation)
			eOperation = ((Implementation)implem).getOperationRef();
		else if(implem instanceof Method)
			eOperation = ((Method)implem).getOperationDef();
				
		IType eClassifierType = new EClassifierType(queryEnvironment, eOperation.getEType());
		if (eOperation.isMany()) {
			result.add(new SequenceType(queryEnvironment, eClassifierType));
		} else {
			result.add(eClassifierType);
		}

		return result;
	}
	
	public void setPriority(int newValue) {
		priority = newValue;
	}
}
