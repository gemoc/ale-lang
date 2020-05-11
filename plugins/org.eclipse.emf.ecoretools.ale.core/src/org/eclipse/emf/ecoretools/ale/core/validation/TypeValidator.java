/*******************************************************************************
 * Copyright (c) 2017-2019 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.validation;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.NothingType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.AstLookup;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.ConvertType;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.TypeChecker;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.ValidationMessageFactory;
import org.eclipse.emf.ecoretools.ale.implementation.Assignment;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.VariableInsert;
import org.eclipse.emf.ecoretools.ale.implementation.VariableRemove;
import org.eclipse.emf.ecoretools.ale.implementation.While;
import org.eclipse.osgi.service.environment.EnvironmentInfo;

import com.google.common.base.Objects;

/**
 * Enforces static typing in an ALE program.
 */
public class TypeValidator implements IValidator {
	
	/** 
	 * Indicates that no problem have been found.
	 * Returned by validation messages when appropriated. 
	 */
	private static final List<IValidationMessage> NO_PROBLEM = emptyList();
	/**
	 * Indicates that a problem have been found but that it's up to another validator to handle it.
	 * Returned by validation messages when appropriated.
	 */
	private static final List<IValidationMessage> PROBLEM_HANDLED_BY_ANOTHER_VALIDATOR = emptyList();
	/** 
	 * Used to create appropriate messages applied to the user. 
	 */
	private IValidationMessageFactory messages;
	/** 
	 * Used to validate the types of the variables and expressions. 
	 */
	private ITypeChecker typeChecker;
	/** 
	 * Used to turn turn EMF types into AQL ones and vice-versa.
	 * Needed because the AST contains a lot of EMF types whereas
	 * a ITypeChecker can only reason on AQL types.
	 */
	private IConvertType convert;
	/** 
	 * Used to lookup the types of some variables in the program's AST. 
	 */
	private IAstLookup lookup;
	
	@Override
	public void setBase(BaseValidator base) {
		this.messages = new ValidationMessageFactory(base);
		this.typeChecker = new TypeChecker(base.getScopes(), base.getQryEnv());
		this.convert = new ConvertType(base.getQryEnv());
		this.lookup = new AstLookup(base.environment, base.scopes, convert);
	}
	
	@Override
	public List<IValidationMessage> validateModelBehavior(List<ModelUnit> units) {
		return NO_PROBLEM;
	}
	
	@Override
	public List<IValidationMessage> validateModelUnit(ModelUnit unit) {
		return NO_PROBLEM;
	}
	
	@Override
	public List<IValidationMessage> validateExtendedClass(ExtendedClass xtdClass) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		msgs.addAll(validateBehavioredClass(xtdClass));
		
		if(isExtendingItself(xtdClass)) {
			msgs.add(messages.extendingItself(xtdClass));
		}
		EClass baseCls = xtdClass.getBaseClass();
		EList<EClass> superTypes = baseCls.getESuperTypes();
		
		List<EClass> extendsBaseClasses =
				xtdClass
				.getExtends()
				.stream()
				.map(xtd -> xtd.getBaseClass())
				.collect(toList());
		
		extendsBaseClasses.stream()
						  .filter(noneOf(superTypes, baseCls))
						  .map(superBase -> messages.indirectExtension(xtdClass, superBase, baseCls))
						  .forEach(msgs::add);
		return msgs;
	}

	private static Predicate<EClass> noneOf(List<EClass> superTypes, EClass baseCls) {
		return superBase -> !superTypes.contains(superBase) && baseCls != superBase;
	}
	
	@Override
	public List<IValidationMessage> validateRuntimeClass(RuntimeClass classDef) {
		return validateBehavioredClass(classDef);
	}
	
	private List<IValidationMessage> validateBehavioredClass(BehavioredClass clazz) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		// Check whether the types of the attributes can be resolved
		
		clazz.getAttributes().stream()
		.filter(att -> typeChecker.isUnresolved(att.getFeatureRef()))
		.map(messages::unresolvedType)
		.forEach(msgs::add);
		
		// Check whether attributes have an initial value that can be assigned to them 
		
		clazz
		.getAttributes().stream()
		.filter(att -> att.getInitialValue() != null)
		.forEach(att -> {
			Set<IType> valueTypes = lookup.inferredTypesOf(att.getInitialValue());
			IType declaredType = convert.toAQL(att.getFeatureRef());
			msgs.addAll(validateAssignment(newHashSet(declaredType), valueTypes, att.getInitialValue()));
		});
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateMethod(Method mtd) {
		return NO_PROBLEM;
	}
	
	@Override
	public List<IValidationMessage> validateFeatureAssignment(FeatureAssignment assignment) {
		Set<IType> valueTypes = lookup.inferredTypesOf(assignment.getValue());
		return validateAssignment(lookup.findFeatureTypes(assignment.getTargetFeature(), assignment.getTarget()), valueTypes, assignment.getValue());
	}
	
	@Override
	public List<IValidationMessage> validateFeatureInsert(FeatureInsert insertion) {
		String featureName = insertion.getTargetFeature();
		Set<IType> variableTypes = lookup.findFeatureTypes(featureName, insertion.getTarget());
		Supplier<IValidationMessage> unsupportedOperatorMessage = () -> messages.unsupportedOperatorOnFeature(variableTypes, insertion, featureName, "+=");
		
		return validateInsertionOrRemoval(variableTypes, insertion.getValue(), new InsertionStrategy(typeChecker, messages), unsupportedOperatorMessage);
	}
	
	@Override
	public List<IValidationMessage> validateFeatureRemove(FeatureRemove removal) {
		String featureName = removal.getTargetFeature();
		Set<IType> variableTypes = lookup.findFeatureTypes(featureName, removal.getTarget());
		Supplier<IValidationMessage> unsupportedOperatorMessage = () -> messages.unsupportedOperatorOnFeature(variableTypes, removal.getTarget(), featureName, "-=");
		
		return validateInsertionOrRemoval(variableTypes, removal.getValue(), new RemovalStrategy(typeChecker, messages), unsupportedOperatorMessage);
	}

	@Override
	public List<IValidationMessage> validateVariableAssignment(VariableAssignment assignment) {
		String assignedVariableName = assignment.getName();
		if("self".equals(assignedVariableName)) {
			// assignment to self is prohibited but handled by a NameValidator
			return PROBLEM_HANDLED_BY_ANOTHER_VALIDATOR;
		}
		Set<IType> variableTypes = lookup.typesDeclaredFor(assignedVariableName, assignment);
		Set<IType> valueTypes = lookup.inferredTypesOf(assignment.getValue());
		
		if("result".equals(assignedVariableName)) {
			return validateAssignmentToResult(assignment, valueTypes);
		}
		else {
			return validateAssignment(variableTypes, valueTypes, assignment.getValue());
		}
	}
	
	/**
	 * Validates that the 'result' variable is properly assigned.
	 * 
	 * @param assignment
	 * 			The assignment
	 * @param returnedValueTypes
	 * 			The types of the value assigned to 'result'
	 * 
	 * @return the validation messages produced from the validation of the assignment
	 */
	private List<IValidationMessage> validateAssignmentToResult(VariableAssignment assignment, Set<IType> returnedValueTypes) {
		Method enclosingMethod = lookup.enclosingMethod(assignment);
		EOperation enclosingOperation = enclosingMethod.getOperationRef();
		
		if(enclosingOperation == null) {
			// Assignment outside of a method, should never happen
			return PROBLEM_HANDLED_BY_ANOTHER_VALIDATOR;
		}
		IType operationReturnType = convert.toAQL(enclosingOperation);
		boolean isVoidOperation = operationReturnType instanceof NothingType;
		if(isVoidOperation) {
			// A void operation should not return anything but this is handled by the NameValidator
			return PROBLEM_HANDLED_BY_ANOTHER_VALIDATOR;
		}
		return validateAssignment(newHashSet(operationReturnType), returnedValueTypes, assignment.getValue());
	}
	
	/**
	 * Validates an assignment to a variable or a feature.
	 * 
	 * @param variableTypes
	 * 			The types of the variable
	 * @param valueTypes
	 * 			The types of the value being assigned to the variable
	 * @param valueExp
	 * 			The expression producing the value to assign
	 * 
	 * @return the messages produced by the validation of the assignment
	 */
	private List<IValidationMessage> validateAssignment(Set<IType> variableTypes, Set<IType> valueTypes, EObject valueExp) {
		if(variableTypes.isEmpty()) {
			// The variable has no type: it is likely undeclared
			return PROBLEM_HANDLED_BY_ANOTHER_VALIDATOR;
		}
		boolean valueCanBeAssigned = variableTypes.stream().anyMatch(variableType -> typeChecker.isAssignable(variableType, valueTypes));
		if(valueCanBeAssigned){
			return NO_PROBLEM;
		}
		else {
			IValidationMessage illegalAssignment = messages.illegalAssignment(variableTypes, valueTypes, valueExp);
			return asList(illegalAssignment);
		}
	}
	
	/**
	 * Validates a statement in which the '+=' or '-=' operator is used.
	 * 
	 * @param variableTypes
	 * 			The types of the variable or feature on which the operator is used
	 * @param value
	 * 			The value given to the operator
	 * @param modif
	 * 			The specific logic related to operator used
	 * @param unsupportedOperatorMessage
	 * 			Supplies the validation message telling the user that the operator
	 * 			cannot be used on given variable/feature
	 * 			
	 * @return the messages produced by the validation of the statement
	 */
	private List<IValidationMessage> validateInsertionOrRemoval(Set<IType> variableTypes, Expression value, IVariableModificationStrategy modif, Supplier<IValidationMessage> unsupportedOperatorMessage) {
		boolean isUnableToDetermineVariableType = variableTypes.isEmpty();
		if(isUnableToDetermineVariableType) {
			// Cannot validate anything: failed to determine variable's type.
			// This is likely caused by an undeclared variable, which is handled by a NameValidator.
			return PROBLEM_HANDLED_BY_ANOTHER_VALIDATOR;
		}
		boolean modificationIsSupported = variableTypes.stream().anyMatch(modif::supportsModification);
		if(!modificationIsSupported) {
			IValidationMessage unsupportedOperator = unsupportedOperatorMessage.get();
			return asList(unsupportedOperator);
		}
		Set<IType> valueTypes = lookup.inferredTypesOf(value);
		boolean modificationIsAccepted = modif.acceptsModification(variableTypes, valueTypes);		
		if(modificationIsAccepted) {
			return NO_PROBLEM;
		}
		else {
			Set<IType> acceptedValueTypes = modif.acceptedTypes(variableTypes);
			IValidationMessage illegalModification = modif.createIllegalModificationMessage(variableTypes, valueTypes, acceptedValueTypes, value);
			return asList(illegalModification);
		}
	}
	
	@Override
	public List<IValidationMessage> validateVariableDeclaration(VariableDeclaration varDecl) {
		if(typeChecker.isUnresolved(varDecl.getType())) {
			return asList(messages.unresolvedType(varDecl));
		}
		if(varDecl.getInitialValue() == null) {
			// Nothing to validate: no initial value => a default one will be used instead.
			return NO_PROBLEM;
		}
		IType variableType = convert.toAQL(varDecl.getType());
		Set<IType> valueTypes = lookup.inferredTypesOf(varDecl.getInitialValue());
		
		boolean initialValueCanBeAssigned = typeChecker.isAssignable(variableType, valueTypes);
		if(initialValueCanBeAssigned) {
			return NO_PROBLEM;
		}
		else {
			IValidationMessage incompatibleTypes = messages.illegalAssignment(newHashSet(variableType), valueTypes, varDecl);
			return asList(incompatibleTypes);
		}
	}
	
	@Override
	public List<IValidationMessage> validateVariableInsert(VariableInsert varInsert) {
		if("self".equals(varInsert.getName())) {
			// self cannot be inserted, no more validation is needed
			return asList(messages.prohibitedInsertionToSelf(varInsert));
		}
		Set<IType> variableTypes = lookup.typesDeclaredFor(varInsert.getName(), varInsert);
		InsertionStrategy insertionStrategy = new InsertionStrategy(typeChecker, messages);

		if("result".equals(varInsert.getName())) {
			return validateInsertionOrRemovalToResult(varInsert, insertionStrategy, "+=");
		}
		else {
			Supplier<IValidationMessage> unsupportedOperatorMessage = () -> messages.unsupportedOperatorOnVariable(variableTypes, varInsert, varInsert.getName(), "+=");
			return validateInsertionOrRemoval(variableTypes, varInsert.getValue(), insertionStrategy, unsupportedOperatorMessage);
		}
	}
	
	@Override
	public List<IValidationMessage> validateVariableRemove(VariableRemove varRemove) {
		if("self".equals(varRemove.getName())) {
			// Nothing can be removed from self, no more validation is needed
			return asList(messages.prohibitedRemovalFromSelf(varRemove));
		}
		Set<IType> variableTypes = lookup.typesDeclaredFor(varRemove.getName(), varRemove);
		RemovalStrategy removalStrategy = new RemovalStrategy(typeChecker, messages);
		
		if("result".equals(varRemove.getName())) {
			return validateInsertionOrRemovalToResult(varRemove, removalStrategy, "-=");
		}
		else {
			Supplier<IValidationMessage> unsupportedOperatorMessage = () -> messages.unsupportedOperatorOnVariable(variableTypes, varRemove, varRemove.getName(), "-=");
			return validateInsertionOrRemoval(variableTypes, varRemove.getValue(), removalStrategy, unsupportedOperatorMessage);
		}
	}
	
	/**
	 * Validates that the 'result' variable is properly assigned.
	 * 
	 * @param assignment
	 * 			The assignment
	 * @param returnedValueTypes
	 * 			The types of the value assigned to 'result'
	 * 
	 * @return the validation messages produced from the validation of the assignment
	 */
	private List<IValidationMessage> validateInsertionOrRemovalToResult(Assignment assignment, IVariableModificationStrategy modif, String operator) {
		Method enclosingMethod = lookup.enclosingMethod(assignment);
		EOperation enclosingOperation = enclosingMethod.getOperationRef();
		
		if(enclosingOperation == null) {
			// Assignment outside of a method, should never happen
			return PROBLEM_HANDLED_BY_ANOTHER_VALIDATOR;
		}
		boolean isVoidOperation = enclosingOperation.getEType() == null && enclosingOperation.getEGenericType() == null;
		if(isVoidOperation) {
			// A void operation should not return anything but this is handled by the NameValidator
			return PROBLEM_HANDLED_BY_ANOTHER_VALIDATOR;
		}
		IType operationReturnType = convert.toAQL(enclosingOperation);
		Supplier<IValidationMessage> unsupportedOperatorMessage = () -> messages.unsupportedOperatorOnVariable(newHashSet(operationReturnType), assignment, "result", operator);
		return validateInsertionOrRemoval(newHashSet(operationReturnType), assignment.getValue(), modif, unsupportedOperatorMessage);
	}
	
	@Override
	public List<IValidationMessage> validateForEach(ForEach loop) {
		boolean iteratesOverACollection = lookup.inferredTypesOf(loop.getCollectionExpression()).stream()
											  	.anyMatch(type -> isIterable(type));
		if(iteratesOverACollection) {
			return NO_PROBLEM;
		}
		else {
			return asList(messages.forEachCanOnlyIterateOnCollections(loop));
		}
	}
	
	/** Whether a for-each loop can iterate on an instance of the given type */
	private final boolean isIterable(IType type) {
		if (typeChecker.isCollection(type)) {
			return true;
		}
		// TODO This check is out of the TypeChecker class because it was inconsistent with the other types
		// and was painful to handle (the issue is the lookup.inferredTypesOf() can return a 'EClassifier'
		// with 'EEList' as a type instead of a Sequence as we do everywhere else).
		//
		// Since for now this is an isolated case I chose to check this here, but if we end up needing this
		// elsewhere we should consider putting it in TypeChecker.
		if (type instanceof EClassifierType) {
			EClassifierType classifierType = (EClassifierType) type;
			return Objects.equal(classifierType.getType(), EcorePackage.eINSTANCE.getEEList());
		}
		return false;
	}
	
	@Override
	public List<IValidationMessage> validateIf(If ifStmt) {
		List<IValidationMessage> res = new ArrayList<>();
		for (ConditionalBlock cBlock : ifStmt.getBlocks()) {
			res.addAll(validateIsBoolean(cBlock.getCondition()));
		}
		return res;
	}
	
	@Override
	public List<IValidationMessage> validateWhile(While loop) {
		return validateIsBoolean(loop.getCondition());
	}
	
	private List<IValidationMessage> validateIsBoolean(Expression exp) {
		if(typeChecker.isBoolean(exp)){
			return NO_PROBLEM;
		}
		else {
			return asList(messages.expectedBoolean(exp));
		}
	}
	
	private boolean isExtendingItself(ExtendedClass xtdClass) {
		List<ExtendedClass> todo = newArrayList(xtdClass);
		List<ExtendedClass> done = newArrayList();
		
		while(!todo.isEmpty()) {
			ExtendedClass current = todo.get(0);
			
			if(done.contains(current)) {
				return true;
			}
			todo.addAll(current.getExtends());
			
			done.add(current);
			todo.remove(0);
		}
		return false;
	}
	
}
