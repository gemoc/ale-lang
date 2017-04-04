/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.interpreter.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import org.eclipse.acceleo.query.runtime.impl.AbstractService;
import org.eclipse.acceleo.query.runtime.impl.EOperationService;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecoretools.ale.core.interpreter.DiagnosticLogger;
import org.eclipse.emf.ecoretools.ale.core.interpreter.EvalEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ImplementationEvaluator;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ModelBuilder;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;

/**
 * AQL Service to eval EOperation implementation 
 */
public class EvalBodyService extends AbstractService {
	
	EvalEnvironment evalEnv;
	Method implem;
	DiagnosticLogger logger;
	
	int priority = EOperationService.PRIORITY + 1;
	
	public EvalBodyService (Method implem, EvalEnvironment evalEnv, DiagnosticLogger logger) {
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
			return implem.getOperationRef().getName();
		}
		else
			return "undefined";
	}
	
	@Override
	public int getNumberOfParameters() {
		if(implem instanceof Method){
			return implem.getOperationRef().getEParameters().size() + 1;
		}
		else
			return 1;
	}
	
	@Override
	public List<IType> getParameterTypes(IReadOnlyQueryEnvironment queryEnvironment) {
		List<IType> result = new ArrayList<IType>();
			//TODO: take care of qualified name & EClass not found
			if(implem.eContainer() instanceof ExtendedClass) {
				EClass containingClass = ((ExtendedClass)implem.eContainer()).getBaseClass();
				result.add(new EClassifierType(queryEnvironment, containingClass));
			}
			else if (implem.eContainer() instanceof RuntimeClass) {
				RuntimeClass container = ((RuntimeClass)implem.eContainer());
				String pkgName = ((ModelUnit)container.eContainer()).getName();
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
			
			for (EParameter parameter : ((Method)implem).getOperationRef().getEParameters()) {
				EClassifierType rawType = new EClassifierType(queryEnvironment, parameter.getEType());
				if (parameter.isMany()) {
					result.add(new SequenceType(queryEnvironment, rawType));
				} else {
					result.add(rawType);
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
		List<IType> parameterTypes = getParameterTypes(evalEnv.getQueryEnvironment());
		return serviceShortSignature(parameterTypes.toArray());
	}
	
	@Override
	public String getLongSignature() {
		String ePkgNsURI;
		String eCLassName;
		
		if( implem.eContainer() instanceof RuntimeClass) {
			return ((RuntimeClass)implem.eContainer()).getName() + " " + getShortSignature();
		}
		
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

		EOperation eOperation = ((Method)implem).getOperationRef();
				
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
	
	public boolean isLowerParameterTypes(IReadOnlyQueryEnvironment queryEnvironment,
			IService service) {
		final List<IType> paramTypes1 = getParameterTypes(queryEnvironment);
		final List<IType> paramTypes2 = service.getParameterTypes(queryEnvironment);
		boolean result = paramTypes1.size() == paramTypes2.size();

		final Iterator<IType> it1 = paramTypes1.iterator();
		final Iterator<IType> it2 = paramTypes2.iterator();
		while (result && it1.hasNext()) {
			IType paramType1 = it1.next();
			IType paramType2 = it2.next();
			if (paramType2.equals(paramType1) || !paramType2.isAssignableFrom(paramType1)) {
				result = false;
			}
		}

		return result;
	}
}
