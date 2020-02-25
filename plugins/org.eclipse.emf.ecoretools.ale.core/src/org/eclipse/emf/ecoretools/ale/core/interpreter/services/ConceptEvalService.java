/*******************************************************************************
 * Copyright (c) 2019 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.interpreter.services;

import static java.util.Arrays.asList;
import static java.util.Arrays.copyOfRange;
import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import org.eclipse.acceleo.query.runtime.impl.AbstractService;
import org.eclipse.acceleo.query.runtime.impl.EOperationService;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecoretools.ale.core.interpreter.DiagnosticLogger;
import org.eclipse.emf.ecoretools.ale.core.interpreter.EvalEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExpressionEvaluationEngine;
import org.eclipse.emf.ecoretools.ale.core.interpreter.MethodEvaluator;
import org.eclipse.emf.ecoretools.ale.core.validation.IConvertType;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.ConvertType;
import org.eclipse.emf.ecoretools.ale.implementation.Concept;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Semantics;

public class ConceptEvalService extends AbstractService {
	
	private final Concept concept;
	
	private final Semantics semantics;
	
	private final EvalEnvironment evalEnvironment;
	
	private final DiagnosticLogger logger;
	
	public ConceptEvalService(Semantics semantics, EvalEnvironment evalEnvironment, DiagnosticLogger logger) {
		this.semantics = requireNonNull(semantics, "semantics");
		this.concept = requireNonNull(semantics.getConcept(), "concept");
		this.evalEnvironment = requireNonNull(evalEnvironment, "evalEnvironment");
		this.logger = requireNonNull(logger, "logger");
	}
	
	@Override
	protected Object internalInvoke(Object[] arguments) throws Exception {
		MethodEvaluator evaluator = new MethodEvaluator(new ExpressionEvaluationEngine(evalEnvironment.getQueryEnvironment(), evalEnvironment.getListeners()), evalEnvironment.getFeatureAccess());
		List<Object> args = asList(copyOfRange(arguments, 1, arguments.length));
		EvaluationResult eval = evaluator.eval(concept, semantics.getImplem(), args);
		logger.notify(eval.getDiagnostic());
		return eval.getResult();
	}
	
	@Override
	public Set<IType> getType(Call call, ValidationServices services, IValidationResult validationResult,
			IReadOnlyQueryEnvironment queryEnvironment, List<IType> argTypes) {
		Set<IType> returnTypes = new LinkedHashSet<>();
		EOperation eOperation = semantics.getImplem().getOperationRef();
		
		if(eOperation != null) {
			IType eClassifierType = new EClassifierType(queryEnvironment, eOperation.getEType());
			if (eOperation.isMany()) {
				returnTypes.add(new SequenceType(queryEnvironment, eClassifierType));
			} else if(eClassifierType.getType() != null){
				returnTypes.add(eClassifierType);
			}
		}
		return returnTypes;
	}
	
	@Override
	public String getShortSignature() {
		return concept.getId() + "." + semantics.getId();
	}
	
	@Override
	public int getPriority() {
		return EOperationService.PRIORITY + 1;
	}
	
	@Override
	public List<IType> getParameterTypes(IReadOnlyQueryEnvironment queryEnvironment) {
		List<IType> types = new ArrayList<>();
		EClassifierType callerType = new EClassifierType(queryEnvironment, ImplementationPackage.eINSTANCE.getConcept());
		types.add(callerType);
		
		if (semantics.getImplem().getOperationRef() != null) {
			IConvertType convert = new ConvertType(queryEnvironment);
			for (EParameter parameter : semantics.getImplem().getOperationRef().getEParameters()) {
				IType aqlParameterType = convert.toAQL(parameter);
				types.add(aqlParameterType);
			}
		}
		return types;
	}
	
	@Override
	public int getNumberOfParameters() {
		if (semantics.getImplem().getOperationRef() != null) {
			return semantics.getImplem().getOperationRef().getEParameters().size() + 1;
		}
		return 1;
	}
	
	@Override
	public String getName() {
		return semantics.getId();
	}
	
	@Override
	public String getLongSignature() {
		return getShortSignature();
	}

}
