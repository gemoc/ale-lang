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
package org.eclipse.emf.ecoretools.ale.core.interpreter.internal;


import static com.google.common.collect.Sets.newHashSet;
import static java.util.Objects.requireNonNull;
import static org.eclipse.emf.ecoretools.ale.core.interpreter.internal.Messages.repr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.parser.AstValidator;
import org.eclipse.acceleo.query.runtime.AcceleoQueryValidationException;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult;
import org.eclipse.acceleo.query.runtime.IQueryEvaluationEngine;
import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.core.Activator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.impl.ConsoleDiagnosticsFormatter;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.CriticalFailureException;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ServiceNotFoundException;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.Scopes.Scope;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.impl.StackedScopes;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.core.validation.IAstLookup;
import org.eclipse.emf.ecoretools.ale.core.validation.IConvertType;
import org.eclipse.emf.ecoretools.ale.core.validation.ITypeChecker;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.AleValidator;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.AstLookup;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.ConvertType;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.TypeChecker;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock;
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeaturePut;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.VariableInsert;
import org.eclipse.emf.ecoretools.ale.implementation.VariableRemove;
import org.eclipse.emf.ecoretools.ale.implementation.While;

/**
 * Evaluates the body of a {@link Method}.
 * <p>
 * {@link #eval(EObject, Method, List) eval} is the entry point of this class.
 * {@code case*()} methods should not be called directly.
 * <p>
 * Each {@code case*()} evaluates a specific statement or expression.
 * The value returned is the result of the expression or {@code null}
 * for statements.
 */
public class MethodEvaluator {
	
	public static final String ROOT_ERROR_MESSAGE = "AQL evaluation failed";
	public static final String AQL_ERROR = "An error occured during evaluation of a query";
	public static final String MTD_ERROR = "[Internal Error, please report] Can't eval null method on %s";
	
	/**
	 * Returned by case* methods to indicate the evaluation of the AST yield no value.
	 * This typically occurs when evaluate a statement like {@link VariableDeclaration}. 
	 */
	private static final Object NO_VALUE_RETURNED = null;
	
	private IAleEnvironment environment;
	private IQueryEvaluationEngine aqlEngine;
	private DynamicFeatureRegistry dynamicFeatureAccess;
	
	/**
	 * Provides access to the values and known types of variables and expressions, per scope.
	 */
	private Scopes scopes;
	/**
	 * Computes the type of some expressions.
	 */
	private IAstLookup lookup;
	/**
	 * Checks the compatibility of different types.
	 */
	private ITypeChecker types;
	/**
	 * Converts AQL types to EMF types and vice versa.
	 */
	private IConvertType convert;
	/**
	 * Validates that an AST has no error. Also infer possible types of an {@link Expression}.
	 */
	private AstValidator validator;
	/**
	 * Generates EMF diagnostics to report errors.
	 */
	private MessageToDiagnosticAdapter errors;
	
	/**
	 * Keeps track of detected error; eventually returned to the user.
	 */
	private BasicDiagnostic diagnostic;
	
	/**
	 * Creates a new object to evaluate the body of a {@link Method}.
	 * 
	 * @param environment
	 * 			The applicable ALE environment.
	 * @param aqlEngine
	 * 			The engine able to evaluate AQL ASTs.
	 * @param dynamicFeatureAccess
	 * 			The registry providing access to ALE dynamic features.
	 */
	public MethodEvaluator(IAleEnvironment environment, IQueryEvaluationEngine aqlEngine, DynamicFeatureRegistry dynamicFeatureAccess) {
		this.environment = requireNonNull(environment, "environment");
		this.aqlEngine = requireNonNull(aqlEngine, "aqlEngine");
		this.dynamicFeatureAccess = requireNonNull(dynamicFeatureAccess, "dynamicFeatureAccess");
		this.scopes = new StackedScopes();
		this.convert = new ConvertType(environment.getContext());
		this.lookup = new AstLookup(environment, scopes, convert);
		this.types = new TypeChecker(scopes, environment.getContext());
		this.validator = new AleValidator(new ValidationServices(environment.getContext()));
		this.errors = new MessageToDiagnosticAdapter(environment, new ConsoleDiagnosticsFormatter());
	}
	
	public EvaluationResult eval(EObject target, Method operation, List<Object> parameters) throws CriticalFailureException {
		diagnostic = new BasicDiagnostic();
		if (operation.getOperationRef() == null) {
			// Should never happen: the AST has been badly built
			diagnostic.add(errors.newDiagnostic(operation, String.format(MethodEvaluator.MTD_ERROR, target)));
			stopExecution(ROOT_ERROR_MESSAGE);
			return null;
		}
		scopes.clear();
		
		// Push special variables onto scope
		
		try (Scope methodScope = scopes.pushNew()) {
			methodScope.putValue("self", target);
			methodScope.putTypes("self", newHashSet(convert.toAQL(target.eClass())));
			
			boolean isVoidMethod = operation.getOperationRef().getEType() == null;
			if (!isVoidMethod) {
				methodScope.putTypes("result", newHashSet(convert.toAQL(operation.getOperationRef())));
			}
			
			// Push method's arguments onto scope
			
			EOperation opDefinition = operation.getOperationRef();
			
			for(int i = 0; i < opDefinition.getEParameters().size(); i++) {
				// FIXME [Validation] Not enough arguments
				EParameter param = opDefinition.getEParameters().get(i);
				methodScope.putValue(param.getName(), parameters.get(i));
				methodScope.putTypes(param.getName(), newHashSet(convert.toAQL(param)));
			}
			
			// Execute statements
			
			throwableSwitch(operation.getBody());
			
			// Ensure that 'result' has been assigned
	
			if (!isVoidMethod) {
				if (!methodScope.hasValue("result")) {
					diagnostic.add(errors.missingReturnStatement(operation, scopes));
					stopExecution(ROOT_ERROR_MESSAGE);
				}
			}
			return new EvaluationResult(methodScope.findValue("result").orElse(null), diagnostic);
		}
	}
	
	public Object caseBlock(Block block) throws CriticalFailureException {
		for(Statement stmt : block.getStatements()) {
			throwableSwitch(stmt);
		}
		return NO_VALUE_RETURNED;
	}
	
	public Object caseVariableDeclaration(VariableDeclaration varDecl) throws CriticalFailureException {
		if (scopes.getCurrent().contains(varDecl.getName())) {
			diagnostic.add(errors.alreadyBound(varDecl, scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		Object value;
		if (varDecl.getInitialValue() == null) {
			value = defaultValueFor(varDecl).orElse(null);
			scopes.getCurrent().putTypes(varDecl.getName(), newHashSet(convert.toAQL(varDecl.getType())));
		}
		else {
			IType variableType = convert.toAQL(varDecl.getType());
			Set<IType> valueTypes = validateAndStoreType(varDecl.getInitialValue());
			
			boolean initialValueCanBeAssigned = types.isAssignable(variableType, valueTypes);
			if (!initialValueCanBeAssigned) {
				diagnostic.add(errors.typeMismatch(varDecl, varDecl.getInitialValue(), newHashSet(variableType), valueTypes));
				stopExecution(ROOT_ERROR_MESSAGE);
			}
			value = aqlEval(varDecl.getInitialValue());
			scopes.getCurrent().putTypes(varDecl.getName(), newHashSet(variableType));
		}
		scopes.getCurrent().putValue(varDecl.getName(), value);
		return NO_VALUE_RETURNED;
	}
	
	private Optional<Object> defaultValueFor(VariableDeclaration varDecl) {
		if (varDecl.getType().isMany()) {
			return Optional.of(new BasicEList<>());
		}
		if (varDecl.getType().getEType() == EcorePackage.eINSTANCE.getEString()) {
			return Optional.of("");
		}
		if (varDecl.getType().getEType() == EcorePackage.eINSTANCE.getEInt()) {
			return Optional.of(0);
		}
		if (varDecl.getType().getEType() == EcorePackage.eINSTANCE.getEBoolean()) {
			return Optional.of(false);
		}
		return Optional.empty();
	}
	
	public Object caseVariableAssignment(VariableAssignment varAssign) throws CriticalFailureException {
		if (varAssign.getName().equals("self")) {
			diagnostic.add(errors.assignmentToSelf(varAssign, scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		if ( ! scopes.getCurrent().contains(varAssign.getName())) {
			diagnostic.add(errors.variableNotFound(varAssign.getName(), varAssign, scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		Set<IType> variableTypes = scopes.getCurrent().getTypes(varAssign.getName());
		Set<IType> valueTypes = varAssign.getValue() == null ? variableTypes : validateAndStoreType(varAssign.getValue());
		
		boolean valueCannotBeAssigned = variableTypes.stream().noneMatch(variableType -> types.isAssignable(variableType, valueTypes));
		if (valueCannotBeAssigned) {
			diagnostic.add(errors.typeMismatch(varAssign, varAssign.getValue(), variableTypes, valueTypes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		Object value = aqlEval(varAssign.getValue());
		Optional<Scope> declaringScope = scopes.getDeclaringScope(varAssign.getName());
		declaringScope.ifPresent(scope -> scope.putValue(varAssign.getName(), value));
		return NO_VALUE_RETURNED;
	}
	
	@SuppressWarnings("unchecked") // thanks to this::types we can confidently cast values
	public Object caseFeatureAssignment(FeatureAssignment featAssign) throws CriticalFailureException {
		// Preconditions
		
		Object rawOwner = aqlEval(featAssign.getTarget());
		if (! (rawOwner instanceof EObject)) {
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		validateAndStoreType(featAssign.getTarget());
		
		Set<IType> variableTypes = lookup.findFeatureTypes(featAssign.getTargetFeature(), featAssign.getTarget());
		Set<IType> valueTypes = featAssign.getValue() == null ? variableTypes : validateAndStoreType(featAssign.getValue());
		EObject owner = (EObject) rawOwner;

		if (variableTypes.isEmpty()) {
			diagnostic.add(errors.attributeNotFound(featAssign.getTargetFeature(), featAssign, owner.eClass(), scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		boolean valueCannotBeAssigned = variableTypes.stream().noneMatch(variableType -> types.isAssignable(variableType, valueTypes));
		if (valueCannotBeAssigned) {
			diagnostic.add(errors.typeMismatch(featAssign, featAssign.getValue(), variableTypes, valueTypes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		
		// Actually insert the value
		
		Object value = aqlEval(featAssign.getValue());

		EStructuralFeature feature = owner.eClass().getEStructuralFeature(featAssign.getTargetFeature());
		if(feature != null){
			/*
			 * feature declared in Ecore metamodel
			 */
			if(value instanceof Collection) {
				BasicEList<Object> newList = new BasicEList<>((Collection<Object>) value);
				owner.eSet(feature, newList);
			}
			else {
				owner.eSet(feature, value);
			}
		}
		else{
			/*
			 * feature declared in ALE
			 */
			if(value instanceof Collection) {
				dynamicFeatureAccess.setDynamicFeatureValue(owner,featAssign.getTargetFeature(), new BasicEList<>((Collection<Object>) value));
			}
			else {
				dynamicFeatureAccess.setDynamicFeatureValue(owner,featAssign.getTargetFeature(),value);
			}
		}
		
		//Manage EOpposite
		if(value instanceof EObject && feature instanceof EReference) {
			EReference oppositeRef = ((EReference)feature).getEOpposite();
			if(oppositeRef != null){
				
				//oppositeRef can be defined in an 'open class'
				EStructuralFeature opFeat = ((EObject)value).eClass().getEStructuralFeature(oppositeRef.getName());
				if(opFeat != null){
					((EObject)value).eSet(opFeat,owner);
				}
				else{
					dynamicFeatureAccess.setDynamicFeatureValue(((EObject)value), oppositeRef.getName(), owner);
				}
			}
		}
		else if(value instanceof EObject && feature == null){
			Optional<Attribute> featureDef = dynamicFeatureAccess.findFeature(owner.eClass(), featAssign.getTargetFeature());
			if(featureDef.isPresent() && featureDef.get().getFeatureRef() instanceof EReference){
				EReference oppositeRef = ((EReference)featureDef.get().getFeatureRef()).getEOpposite();
				if(oppositeRef != null){
					
					//oppositeRef can be defined in an 'open class'
					EStructuralFeature opFeat = ((EObject)value).eClass().getEStructuralFeature(oppositeRef.getName());
					if(opFeat != null){
						((EObject)value).eSet(opFeat,owner);
					}
					else{
						dynamicFeatureAccess.setDynamicFeatureValue(((EObject)value), oppositeRef.getName(), owner);
					}
				}
			}
		}
		return NO_VALUE_RETURNED;
	}
	
	@SuppressWarnings("unchecked") // thanks to this::types we can confidently cast values
	public Object caseVariableInsert(VariableInsert varInsert) throws CriticalFailureException {
		// Preconditions
		
		if ( ! scopes.getCurrent().contains(varInsert.getName())) {
			diagnostic.add(errors.variableNotFound(varInsert.getName(), varInsert, scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		Set<IType> variableTypes = scopes.getCurrent().getTypes(varInsert.getName());
		Set<IType> valueTypes = varInsert.getValue() == null ? variableTypes : validateAndStoreType(varInsert.getValue());
		
		boolean supportsInsertion = variableTypes.stream().anyMatch(types::supportsInsertion);
		if ( ! supportsInsertion) {
			diagnostic.add(errors.unsupportedOperator(varInsert, varInsert.getName(), variableTypes, Operator.ADDITION_ASSIGNMENT, scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		boolean valueCanBeAssigned = types.acceptsInsertion(variableTypes, valueTypes);
		if ( ! valueCanBeAssigned) {
			diagnostic.add(errors.typeMismatch(varInsert, varInsert.getValue(), variableTypes, valueTypes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		Object insertedValue = aqlEval(varInsert.getValue());
		Object variableValue = scopes.getCurrent().getValue(varInsert.getName());
		
		// Actually insert the value
		
		if (variableValue instanceof Collection) {
			if (insertedValue instanceof Collection) {
				((Collection<Object>) variableValue).addAll((Collection<?>) insertedValue);
			}
			else {
				((Collection<Object>) variableValue).add(insertedValue);
			}
		}
		else if(variableValue instanceof String) {
			String concatenated = variableValue + "" + insertedValue;
			Optional<Scope> declaringScope = scopes.getDeclaringScope(varInsert.getName());
			declaringScope.ifPresent(scope -> scope.putValue(varInsert.getName(), concatenated));
		}
		else if(variableValue instanceof Integer && insertedValue instanceof Number) {
			Integer sum = (Integer) variableValue + ((Number) insertedValue).intValue();
			Optional<Scope> declaringScope = scopes.getDeclaringScope(varInsert.getName());
			declaringScope.ifPresent(scope -> scope.putValue(varInsert.getName(), sum));
		}
		else if(variableValue instanceof Double && insertedValue instanceof Number) {
			Double sum = (Double) variableValue + ((Number) insertedValue).doubleValue();
			Optional<Scope> declaringScope = scopes.getDeclaringScope(varInsert.getName());
			declaringScope.ifPresent(scope -> scope.putValue(varInsert.getName(), sum));
		}
		else {
			throw new CriticalFailureException("Operator `+=` not implemented for variable=" + repr(variableTypes) + " value=" + repr(valueTypes), diagnostic);
		}
		return NO_VALUE_RETURNED;
	}
	
	@SuppressWarnings("unchecked") // thanks to this::types we can confidently cast values
	public Object caseVariableRemove(VariableRemove varRemove) throws CriticalFailureException {
		// Preconditions
		
		if ( ! scopes.getCurrent().contains(varRemove.getName())) {
			diagnostic.add(errors.variableNotFound(varRemove.getName(), varRemove, scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		Set<IType> variableTypes = scopes.getCurrent().getTypes(varRemove.getName());
		Set<IType> valueTypes = varRemove.getValue() == null ? variableTypes : validateAndStoreType(varRemove.getValue());
		
		boolean supportsRemoval = variableTypes.stream().anyMatch(types::supportsRemoval);
		if ( ! supportsRemoval) {
			diagnostic.add(errors.unsupportedOperator(varRemove, varRemove.getName(), variableTypes, Operator.SUBSTRACTION_ASSIGNMENT, scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		boolean valueCanBeAssigned = types.acceptsRemoval(variableTypes, valueTypes);
		if ( ! valueCanBeAssigned) {
			diagnostic.add(errors.typeMismatch(varRemove, varRemove.getValue(), variableTypes, valueTypes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		Object removedValue = aqlEval(varRemove.getValue());
		Object variableValue = scopes.getCurrent().getValue(varRemove.getName());
		
		// Actually insert the value
		
		if(variableValue instanceof Collection) {
			if(removedValue instanceof Collection) {
				((Collection<Object>) variableValue).removeAll((Collection<?>) removedValue);
			}
			else {
				((Collection<Object>) variableValue).remove(removedValue);
			}
		}
		else if(variableValue instanceof Integer && removedValue instanceof Integer) {
			Integer substraction = (Integer) variableValue - (Integer) removedValue;
			scopes.getCurrent().putValue(varRemove.getName(), substraction);
		}
		else {
			throw new CriticalFailureException("Operator `-=` not implemented for variable=" + repr(variableTypes) + " value=" + repr(valueTypes), diagnostic);
		}
		return NO_VALUE_RETURNED;
	}

	@SuppressWarnings("unchecked") // thanks to this::types we can confidently cast values
	public Object caseFeatureInsert(FeatureInsert featInsert) throws CriticalFailureException {
		// Preconditions
		
		Object rawOwner = aqlEval(featInsert.getTarget());
		if (! (rawOwner instanceof EObject)) {
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		validateAndStoreType(featInsert.getTarget());
		
		Set<IType> variableTypes = lookup.findFeatureTypes(featInsert.getTargetFeature(), featInsert.getTarget());
		Set<IType> valueTypes = featInsert.getValue() == null ? variableTypes : validateAndStoreType(featInsert.getValue());
		EObject owner = (EObject) rawOwner;

		if (variableTypes.isEmpty()) {
			diagnostic.add(errors.attributeNotFound(featInsert.getTargetFeature(), featInsert, owner.eClass(), scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		boolean supportsInsertion = variableTypes.stream().anyMatch(types::supportsInsertion);
		if ( ! supportsInsertion) {
			diagnostic.add(errors.unsupportedOperator(featInsert, featInsert.getTargetFeature(), variableTypes, Operator.ADDITION_ASSIGNMENT, scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		boolean valueCanBeAssigned = types.acceptsInsertion(variableTypes, valueTypes);
		if ( ! valueCanBeAssigned) {
			diagnostic.add(errors.typeMismatch(featInsert, featInsert.getValue(), variableTypes, valueTypes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		
		// Actually insert the value
		
		Object inserted = aqlEval(featInsert.getValue());
		
		EStructuralFeature feature = owner.eClass().getEStructuralFeature(featInsert.getTargetFeature());
		if (feature != null){
			/*
			 * Static attribute declared in the Ecore metamodel
			 */
			// FIXME Duplicate of dynamicFeatureAccess::insertDynamicFeatureValue
			Object featureValue = owner.eGet(feature);
			if (featureValue instanceof Collection){
				if (inserted instanceof Collection) {
					((Collection<Object>) featureValue).addAll((Collection<?>) inserted);
				}
				else {
					((Collection<Object>) featureValue).add(inserted);
				}
			}
			else if (featureValue instanceof String){
				String concat = featureValue + "" + inserted;
				((EObject) rawOwner).eSet(feature, concat);
			}
			else if (featureValue instanceof Integer && inserted instanceof Number) {
				Integer sum = (Integer) featureValue + ((Number) inserted).intValue();
				owner.eSet(feature, sum);
			}
			else if (featureValue instanceof Double && inserted instanceof Number) {
				Double sum = (Double) featureValue + ((Number) inserted).doubleValue();
				owner.eSet(feature, sum);
			}
		}
		else {
			/*
			 * Dynamic attribute declared in ALE
			 */
			dynamicFeatureAccess.insertDynamicFeatureValue(owner,featInsert.getTargetFeature(),inserted);
		}
		return NO_VALUE_RETURNED;
	}

	@SuppressWarnings("unchecked") // thanks to this::types we can confidently cast values
	public Object caseFeatureRemove(FeatureRemove featRemove) throws CriticalFailureException {
		// Preconditions
		
		Object rawOwner = aqlEval(featRemove.getTarget());
		if (! (rawOwner instanceof EObject)) {
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		validateAndStoreType(featRemove.getTarget());
		
		Set<IType> variableTypes = lookup.findFeatureTypes(featRemove.getTargetFeature(), featRemove.getTarget());
		Set<IType> valueTypes = featRemove.getValue() == null ? variableTypes : validateAndStoreType(featRemove.getValue());
		EObject owner = (EObject) rawOwner;

		if (variableTypes.isEmpty()) {
			diagnostic.add(errors.attributeNotFound(featRemove.getTargetFeature(), featRemove, owner.eClass(), scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		boolean supportsRemove = variableTypes.stream().anyMatch(types::supportsRemoval);
		if ( ! supportsRemove) {
			diagnostic.add(errors.unsupportedOperator(featRemove, featRemove.getTargetFeature(), variableTypes, Operator.SUBSTRACTION_ASSIGNMENT, scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		boolean valueCanBeAssigned = types.acceptsRemoval(variableTypes, valueTypes);
		if ( ! valueCanBeAssigned) {
			diagnostic.add(errors.typeMismatch(featRemove, featRemove.getValue(), variableTypes, valueTypes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		
		// Actually remove the value
		
		Object removed = aqlEval(featRemove.getValue());
		
		EStructuralFeature feature = owner.eClass().getEStructuralFeature(featRemove.getTargetFeature());
		if (feature != null){
			/*
			 * Static attribute declared in the Ecore metamodel
			 */
			// FIXME Duplicate of dynamicFeatureAccess::removeDynamicFeatureValue
			Object featureValue = owner.eGet(feature);
			if (featureValue instanceof Collection){
				if (removed instanceof Collection) {
					((Collection<Object>) featureValue).removeAll((Collection<?>) removed);
				}
				else {
					((Collection<Object>) featureValue).remove(removed);
				}
			}
			else if (featureValue instanceof Integer && removed instanceof Number) {
				Integer substraction = (Integer) featureValue - ((Number) removed).intValue();
				owner.eSet(feature, substraction);
			}
			else if (featureValue instanceof Double && removed instanceof Number) {
				Double substraction = (Double) featureValue - ((Number) removed).doubleValue();
				owner.eSet(feature, substraction);
			}
		}
		else {
			/*
			 * Dynamic attribute declared in ALE
			 */
			dynamicFeatureAccess.removeDynamicFeatureValue(owner,featRemove.getTargetFeature(),removed);
		}
		return NO_VALUE_RETURNED;
	}
	
	public Object caseFeaturePut(FeaturePut featPut) throws CriticalFailureException {
		Object assigned = aqlEval(featPut.getTarget());
		Object key = aqlEval(featPut.getKey());
		Object value = aqlEval(featPut.getValue());
		
		if(assigned instanceof EObject){
			EStructuralFeature feature = ((EObject)assigned).eClass().getEStructuralFeature(featPut.getTargetFeature());
			Object featureValue = ((EObject)assigned).eGet(feature);
			if(featureValue instanceof EMap){
				((EMap)featureValue).put(key,value);
			}
		}
		return null;
	}
	
	public Object caseForEach(ForEach forEach) throws CriticalFailureException {
		if (scopes.getCurrent().contains(forEach.getVariable())) {
			diagnostic.add(errors.alreadyBound(forEach, scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		Set<IType> collectionTypes = validateAndStoreType(forEach.getCollectionExpression());
		if (collectionTypes.stream().noneMatch(types::isCollection)) {
			diagnostic.add(errors.notIterable(forEach, collectionTypes, scopes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		Object iterable = aqlEval(forEach.getCollectionExpression());
		Collection<Object> iterableElements = (Collection<Object>) iterable;
		for (Object currentElement : iterableElements) {
			try (Scope newScope = scopes.pushNew()) {
				newScope.putVariable(forEach.getVariable(), collectionTypes, currentElement);
				throwableSwitch(forEach.getBody());
			}
		}
		return NO_VALUE_RETURNED;
	}
	
	public Object caseWhile(While loop) throws CriticalFailureException {
		Set<IType> conditionTypes = validateAndStoreType(loop.getCondition());
		if (conditionTypes.stream().noneMatch(types::isBoolean)) {
			diagnostic.add(errors.typeMismatch(loop, loop.getCondition(), newHashSet(convert.toAQL(EcorePackage.eINSTANCE.getEBoolean())), conditionTypes));
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		boolean conditionValue = (boolean) aqlEval(loop.getCondition());
		while (conditionValue){
			throwableSwitch(loop.getBody());
			conditionValue = (boolean) aqlEval(loop.getCondition());
		}
		return NO_VALUE_RETURNED;
	}
	
	public Object caseIf(If ifStmt) throws CriticalFailureException {
		Block selectedBlock = null;
		for (ConditionalBlock conditionalBlock : ifStmt.getBlocks()) {
			Set<IType> conditionTypes = validateAndStoreType(conditionalBlock.getCondition());
			if (conditionTypes.stream().noneMatch(types::isBoolean)) {
				diagnostic.add(errors.typeMismatch(ifStmt, conditionalBlock, newHashSet(convert.toAQL(EcorePackage.eINSTANCE.getEBoolean())), conditionTypes));
				stopExecution(ROOT_ERROR_MESSAGE);
			}
			boolean condition = (boolean) aqlEval(conditionalBlock.getCondition());
			if ((boolean) condition) {
				selectedBlock = conditionalBlock.getBlock();
				break;
			}
		}
		if (selectedBlock != null){
			throwableSwitch(selectedBlock);
		}
		else if (ifStmt.getElse() != null){
			throwableSwitch(ifStmt.getElse());
		}
		return NO_VALUE_RETURNED;
	}
	
	public Object caseExpressionStatement(ExpressionStatement stmt) throws CriticalFailureException {
		return aqlEval(stmt.getExpression());
	}
	
	private Object aqlEval(Expression expression) throws CriticalFailureException {
		AstResult dummyAstResult = new AstResult(expression, new HashMap<>(), new HashMap<>(), new ArrayList<>(), new BasicDiagnostic());
		EvaluationResult result;
		try {
			result = aqlEngine.eval(dummyAstResult, scopes.getCurrent().getVariableValues());
		} 
		catch (Exception e) {
			Throwable t = e;
			while (t.getCause() != null) {
				t = t.getCause();
				
				if (t instanceof ServiceNotFoundException) {
					ServiceNotFoundException notFound = (ServiceNotFoundException) t;
					diagnostic.add(errors.methodNotFound(expression, notFound, scopes));
					stopExecution(ROOT_ERROR_MESSAGE);
				}
			}
			throw e;
		}
		if(result.getDiagnostic().getSeverity() != Diagnostic.OK){
			Diagnostic child = new BasicDiagnostic(
					result.getDiagnostic().getSeverity(),
					Activator.PLUGIN_ID,
					0,
					MethodEvaluator.AQL_ERROR,
					new Object[] { expression , result.getDiagnostic()}
					);
			diagnostic.add(child);
			stopExecution(ROOT_ERROR_MESSAGE);
		}
		
		return result.getResult();
	}
	
	/**
	 * Validates an Expression and stored its types in the current scope.
	 */
	private Set<IType> validateAndStoreType(Expression expression) throws CriticalFailureException {
		// FIXME [Validation] Should do something with validation.getMessages()
		IValidationResult validation = validate(expression);
		Set<IType> inferredTypes = validation.getPossibleTypes(expression);
		inferredTypes = inferredTypes == null ? new HashSet<>() : inferredTypes;
		
		for (IValidationMessage message : validation.getMessages()) {
			if (message.getLevel() == ValidationMessageLevel.ERROR) {
				diagnostic.add(errors.newDiagnostic(expression, message.getMessage()));
			}
		}
		scopes.getCurrent().putTypes(expression, inferredTypes);
		return inferredTypes;
	}
	
	/*
	 * Validates an Expression.
	 */
	private IValidationResult validate(Expression exp) throws CriticalFailureException {
		try {
			ParsedFile<ModelUnit> file = findSourceFile(exp)
					.orElseThrow(() -> new IllegalArgumentException("Cannot find file defining " + exp));
			
			//Make an AstResult with positions from Implementation parser
			
			AstResult fakeAst = new AstResult(
					exp,
					file.getStartPositions(),
					file.getEndPositions(),
					new ArrayList<>(),
					new BasicDiagnostic()
			);
			return validator.validate(scopes.getCurrent().getVariableTypes(), fakeAst);
		}
		catch (AcceleoQueryValidationException e) {
			diagnostic.add(errors.internalError(exp, e));
			stopExecution(ROOT_ERROR_MESSAGE);
			return null;
		}
	}

	private Optional<ParsedFile<ModelUnit>> findSourceFile(Expression exp) {
		EObject element = exp;
		while (element != null) {
			Optional<ParsedFile<ModelUnit>> file = environment.getBehaviors().findParsedFileDefining(element);
			
			if (file.isPresent()) {
				return file;
			}
			element = element.eContainer();
		}
		return Optional.empty();
	}
	
	private void stopExecution(String message) throws CriticalFailureException {
		throw new CriticalFailureException(message, diagnostic);
	}
	
	private Object throwableSwitch(Object obj) throws CriticalFailureException {
		if(obj instanceof Block) {
			return caseBlock((Block) obj);
		}
		else if(obj instanceof ExpressionStatement) {
			return caseExpressionStatement((ExpressionStatement) obj);
		}
		else if(obj instanceof FeatureAssignment) {
			return caseFeatureAssignment((FeatureAssignment) obj);
		}
		else if(obj instanceof FeatureInsert) {
			return caseFeatureInsert((FeatureInsert) obj);
		}
		else if(obj instanceof FeaturePut) {
			return caseFeaturePut((FeaturePut) obj);
		}
		else if(obj instanceof FeatureRemove) {
			return caseFeatureRemove((FeatureRemove) obj);
		}
		else if(obj instanceof ForEach) {
			return caseForEach((ForEach) obj);
		}
		else if(obj instanceof If) {
			return caseIf((If) obj);
		}
		else if(obj instanceof VariableAssignment) {
			return caseVariableAssignment((VariableAssignment) obj);
		}
		else if(obj instanceof VariableDeclaration) {
			return caseVariableDeclaration((VariableDeclaration) obj);
		}
		else if(obj instanceof VariableInsert) {
			return caseVariableInsert((VariableInsert) obj);
		}
		else if(obj instanceof VariableRemove) {
			return caseVariableRemove((VariableRemove) obj);
		}
		else if(obj instanceof While) {
			return caseWhile((While) obj);
		}
		return null;
	}
	
}