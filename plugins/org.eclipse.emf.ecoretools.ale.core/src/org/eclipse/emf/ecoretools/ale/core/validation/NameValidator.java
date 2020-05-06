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

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.acceleo.query.runtime.impl.ValidationMessage;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.ValidationMessageFactory;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
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

/**
 * This validator checks validity, conflict and existence of named elements
 */
public class NameValidator implements IValidator {
	
	public static final String NAME_ALREADY_USED = "The name %s is already used";
	public static final String SELF_RESERVED = "'self' is a reserved name";
	public static final String RESULT_RESERVED = "'result' is a reserved name";
	public static final String OP_ALREADY_DECLARED = "The operation %s is already declared";
	public static final String OP_MUST_OVERRIDE = "The operation %s must override";
	public static final String FEATURE_UNDEFINED = "The feature %s is not defined";
	public static final String VARIABLE_UNDEFINED = "The variable %s is not defined";
	public static final String PARAM_ASSIGN = "%s is a parameter and can't be assigned";
	public static final String SELF_ASSIGN = "'self' can't be assigned";
	public static final String OVERRIDE_UNDEFINED = "Can't find matching EOperation in %s";
	
	BaseValidator base;
	
	private IValidationMessageFactory messages;
	
	public void setBase(BaseValidator base) {
		this.base = base;
		this.messages = new ValidationMessageFactory(base);
	}
	
	public List<IValidationMessage> validateModelBehavior(List<ModelUnit> units) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		/*
		 * Check ModelUnit names are unique
		 */
		List<String> declarations = new ArrayList<>();
		units
		.stream()
		.forEach(unit -> {
			if(declarations.contains(unit.getName())) {
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(NAME_ALREADY_USED, unit.getName()),
						0,
						0
						));
			}
			else {
				declarations.add(unit.getName());
			}
		});
		
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateModelUnit(ModelUnit unit) {
		
		List<IValidationMessage> msgs = new ArrayList<>();
		
		/*
		 * Check duplication of RuntimeClass
		 */
		List<String> declarations = new ArrayList<>(); 
		unit
		.getClassDefinitions()
		.stream()
		.forEach(cls -> {
			if(declarations.contains(cls.getName())) {
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(NAME_ALREADY_USED, cls.getName()),
						base.getStartOffset(cls),
						base.getEndOffset(cls)
						));
			}
			else {
				declarations.add(cls.getName());
			}
		});
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateExtendedClass(ExtendedClass xtdClass) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		//TODO: check cycles in 'extends'
		msgs.addAll(validateBehavioredClass(xtdClass));
		
		/*
		 * Check name of base class attributes
		 */
		List<String> declarations = 
			xtdClass
			.getBaseClass()
			.getEAllStructuralFeatures()
			.stream().map(s -> s.getName())
			.collect(Collectors.toList());
		xtdClass
		.getAttributes()
		.stream()
		.forEach(att -> {
			String name = att.getFeatureRef().getName();
			if(declarations.contains(name)) {
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(NAME_ALREADY_USED, name),
						base.getStartOffset(att),
						base.getEndOffset(att)
						));
			}
		});
		
		/*
		 * Check def methods must not override
		 */
		EList<EOperation> allEOperations = xtdClass.getBaseClass().getEAllOperations();
		for (Method mtd : xtdClass.getMethods()) {
			EOperation opRef = mtd.getOperationRef();
			if(opRef!= null && opRef.getEContainingClass() != xtdClass.getBaseClass()) {
				if(allEOperations.stream().anyMatch(op -> isMatching(opRef, op))){
					msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(OP_MUST_OVERRIDE, getSignature(mtd)),
						base.getStartOffset(mtd),
						base.getEndOffset(mtd)
						));
				}
			}
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateRuntimeClass(RuntimeClass classDef) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		msgs.addAll(validateBehavioredClass(classDef));
		
		return msgs;
	}
	
	private List<IValidationMessage> validateBehavioredClass(BehavioredClass clazz) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		/*
		 * Check attributes names
		 */
		List<String> declarations = new ArrayList<>(); 
		clazz
		.getAttributes()
		.stream()
		.forEach(att -> {
			String name = att.getFeatureRef().getName();
			if(declarations.contains(name)) {
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(NAME_ALREADY_USED, name),
						base.getStartOffset(att),
						base.getEndOffset(att)
						));
			}
			else if(name.equals("self")){
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(SELF_RESERVED, name),
						base.getStartOffset(att),
						base.getEndOffset(att)
						));
			}
			else if(name.equals("result")){
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(RESULT_RESERVED, name),
						base.getStartOffset(att),
						base.getEndOffset(att)
						));
			}
			else {
				declarations.add(name);
			}
		});
		
		/*
		 * Check operation duplication
		 */
		List<Method> previousOp = new ArrayList<>(); 
		for (Method mtd : clazz.getMethods()) {
			boolean isConflict = previousOp.stream().anyMatch(prevOp -> isMatching(mtd, prevOp));
			if(isConflict) {
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(OP_ALREADY_DECLARED, getSignature(mtd)),
						base.getStartOffset(mtd),
						base.getEndOffset(mtd)
						));
			}
			previousOp.add(mtd);
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateMethod(Method mtd) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		/*
		 * Check parameter name
		 */
		List<String> declarations = new ArrayList<>();
		if(mtd.getOperationRef() != null) {
			for (EParameter param : mtd.getOperationRef().getEParameters()) {
				String name = param.getName();
				if(declarations.contains(name)) {
					msgs.add(new ValidationMessage(
							ValidationMessageLevel.ERROR,
							String.format(NAME_ALREADY_USED,param.getName()),
							base.getStartOffset(mtd),
							base.getEndOffset(mtd)
							));
				}
				else if(param.getName().equals("result")){
					msgs.add(new ValidationMessage(
							ValidationMessageLevel.ERROR,
							String.format(RESULT_RESERVED,param.getName()),
							base.getStartOffset(mtd),
							base.getEndOffset(mtd)
							));
				}
				else if(param.getName().equals("self")){
					msgs.add(new ValidationMessage(
							ValidationMessageLevel.ERROR,
							String.format(SELF_RESERVED,param.getName()),
							base.getStartOffset(mtd),
							base.getEndOffset(mtd)
							));
				}
				else {
					declarations.add(name);
				}
			}
		}
		else {
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(OVERRIDE_UNDEFINED, ((BehavioredClass)mtd.eContainer()).getName()),
					base.getStartOffset(mtd),
					base.getEndOffset(mtd)
					));
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateFeatureAssignment(FeatureAssignment featAssign) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		/*
		 * Check the assigned feature exist 
		 */
		boolean isExistingFeature = false;
		Set<IType> targetTypes = base.getPossibleTypes(featAssign.getTarget());
		for(IType type: targetTypes){
			if(type.getType() instanceof EClass){
				EClass realType = (EClass) type.getType();
				EStructuralFeature feature = realType.getEStructuralFeature(featAssign.getTargetFeature());
				
				if(feature  != null){ //static features
					isExistingFeature = true;
				}
				else { //runtime features
					List<ExtendedClass> extensions = base.findExtensions(realType);
					Optional<Attribute> foundDynamicAttribute = //FIXME: take inheritance in account
						extensions
						.stream()
						.flatMap(xtdCls -> xtdCls.getAttributes().stream())
						.filter(field -> field.getFeatureRef().getName().equals(featAssign.getTargetFeature()))
						.findFirst();
					if(foundDynamicAttribute.isPresent()) {
						isExistingFeature = true;
					}
				}
			}
		}
		
		if(!isExistingFeature){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(FEATURE_UNDEFINED,featAssign.getTargetFeature()),
					base.getStartOffset(featAssign),
					base.getEndOffset(featAssign)
					));
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateFeatureInsert(FeatureInsert featInsert) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		/*
		 * Check the assigned feature exist 
		 */
		boolean isExistingFeature = false;
		Set<IType> targetTypes = base.getPossibleTypes(featInsert.getTarget());
		for(IType type: targetTypes){
			if(type.getType() instanceof EClass){
				EClass realType = (EClass) type.getType();
				EStructuralFeature feature = realType.getEStructuralFeature(featInsert.getTargetFeature());
				
				if(feature  != null){ //static features
					isExistingFeature = true;
				}
				else { //runtime features
					List<ExtendedClass> extensions = base.findExtensions(realType);
					Optional<Attribute> foundDynamicAttribute = //FIXME: take inheritance in account
						extensions
						.stream()
						.flatMap(xtdCls -> xtdCls.getAttributes().stream())
						.filter(field -> field.getFeatureRef().getName().equals(featInsert.getTargetFeature()))
						.findFirst();
					if(foundDynamicAttribute.isPresent()) {
						isExistingFeature = true;
					}
				}
			}
		}
		
		if(!isExistingFeature){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(FEATURE_UNDEFINED,featInsert.getTargetFeature()),
					base.getStartOffset(featInsert),
					base.getEndOffset(featInsert)
					));
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateFeatureRemove(FeatureRemove featRemove) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		/*
		 * Check the assigned feature exist 
		 */
		boolean isExistingFeature = false;
		Set<IType> targetTypes = base.getPossibleTypes(featRemove.getTarget());
		for(IType type: targetTypes){
			if(type.getType() instanceof EClass){
				EClass realType = (EClass) type.getType();
				EStructuralFeature feature = realType.getEStructuralFeature(featRemove.getTargetFeature());
				
				if(feature  != null){ //static features
					isExistingFeature = true;
				}
				else { //runtime features
					List<ExtendedClass> extensions = base.findExtensions(realType);
					Optional<Attribute> foundDynamicAttribute = //FIXME: take inheritance in account
						extensions
						.stream()
						.flatMap(xtdCls -> xtdCls.getAttributes().stream())
						.filter(field -> field.getFeatureRef().getName().equals(featRemove.getTargetFeature()))
						.findFirst();
					if(foundDynamicAttribute.isPresent()) {
						isExistingFeature = true;
					}
				}
			}
		}
		
		if(!isExistingFeature){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(FEATURE_UNDEFINED,featRemove.getTargetFeature()),
					base.getStartOffset(featRemove),
					base.getEndOffset(featRemove)
					));
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateVariableAssignment(VariableAssignment varAssign) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		/*
		 * Check name
		 */
		Set<IType> declaringTypes = base.getCurrentScope().get(varAssign.getName());
		if(declaringTypes == null && !varAssign.getName().equals("result")){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(VARIABLE_UNDEFINED,varAssign.getName()),
					base.getStartOffset(varAssign),
					base.getEndOffset(varAssign)
					));
		}
		else if(varAssign.getName().equals("self")){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(SELF_ASSIGN,varAssign.getName()),
					base.getStartOffset(varAssign),
					base.getEndOffset(varAssign)
					));
		}
		else {
			Method method = base.getContainingOperation(varAssign);
			EOperation enclosingOperation = method.getOperationRef();
			if(enclosingOperation != null) {
				
				// Check whether the variable is a parameter of the operation
				
				List<EParameter> params = enclosingOperation.getEParameters();
				Optional<EParameter> matchingParam = 
						params
						.stream()
						.filter(param -> param.getName().equals(varAssign.getName()))
						.findFirst();
				if(matchingParam.isPresent()){
					msgs.add(new ValidationMessage(
							ValidationMessageLevel.ERROR,
							String.format(PARAM_ASSIGN,varAssign.getName()),
							base.getStartOffset(varAssign),
							base.getEndOffset(varAssign)
							));
				}
				
				// Check attempts to assign 'result' in a void operation
				
				boolean assigningToResult = "result".equals(varAssign.getName());
				boolean isVoidOperation = enclosingOperation.getEType() == null && enclosingOperation.getEGenericType() == null;
				if(assigningToResult && isVoidOperation) {
					IValidationMessage invalidAssignment = messages.assignmentToResultInVoidOperation(varAssign);
					msgs.add(invalidAssignment);
					return msgs;
				}
			}
		}
		
		return msgs;
	}
	
	public List<IValidationMessage> validateVariableDeclaration(VariableDeclaration varDecl) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		/*
		 * Check name
		 */
		if(varDecl.getName().equals("result")){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(RESULT_RESERVED,varDecl.getName()),
					base.getStartOffset(varDecl),
					base.getEndOffset(varDecl)
					));
		}
		else if(varDecl.getName().equals("self")){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(SELF_RESERVED,varDecl.getName()),
					base.getStartOffset(varDecl),
					base.getEndOffset(varDecl)
					));
		}
		else {
			Set<IType> declaringTypes = base.getCurrentScope().get(varDecl.getName());
			if(declaringTypes != null){
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(NAME_ALREADY_USED,varDecl.getName()),
						base.getStartOffset(varDecl),
						base.getEndOffset(varDecl)
						));
			}
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateVariableInsert(VariableInsert varInsert) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		boolean assigningToResult = "result".equals(varInsert.getName());
		Set<IType> declaringTypes = base.getCurrentScope().get(varInsert.getName());

		if(declaringTypes == null && !assigningToResult){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(VARIABLE_UNDEFINED,varInsert.getName()),
					base.getStartOffset(varInsert),
					base.getEndOffset(varInsert)
					));
		}
		else if (assigningToResult) {
			// Check attempts to assign 'result' in a void operation
			
			Method method = base.getContainingOperation(varInsert);
			EOperation enclosingOperation = method.getOperationRef();
			
			if (enclosingOperation != null) {
				boolean isVoidOperation = enclosingOperation.getEType() == null && enclosingOperation.getEGenericType() == null;
				if(isVoidOperation) {
					IValidationMessage invalidAssignment = messages.assignmentToResultInVoidOperation(varInsert);
					msgs.add(invalidAssignment);
					return msgs;
				}
			}
		}
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateVariableRemove(VariableRemove varRemove) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		boolean assigningToResult = "result".equals(varRemove.getName());
		Set<IType> declaringTypes = base.getCurrentScope().get(varRemove.getName());
		
		if(declaringTypes == null && !assigningToResult){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(VARIABLE_UNDEFINED,varRemove.getName()),
					base.getStartOffset(varRemove),
					base.getEndOffset(varRemove)
					));
		}
		else if (assigningToResult) {
			// Check attempts to assign 'result' in a void operation
			
			Method method = base.getContainingOperation(varRemove);
			EOperation enclosingOperation = method.getOperationRef();
			
			if (enclosingOperation != null) {
				boolean isVoidOperation = enclosingOperation.getEType() == null && enclosingOperation.getEGenericType() == null;
				if(isVoidOperation) {
					IValidationMessage invalidAssignment = messages.assignmentToResultInVoidOperation(varRemove);
					msgs.add(invalidAssignment);
					return msgs;
				}
			}
		}
		return msgs;
	}
	
	public List<IValidationMessage> validateForEach(ForEach loop) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		if(loop.getVariable().equals("result")){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(RESULT_RESERVED,loop.getVariable()),
					base.getStartOffset(loop),
					base.getEndOffset(loop)
					));
		}
		else if(loop.getVariable().equals("self")){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(SELF_RESERVED,loop.getVariable()),
					base.getStartOffset(loop),
					base.getEndOffset(loop)
					));
		}
		else {
			Set<IType> declaringTypes = base.getCurrentScope().get(loop.getVariable());
			if(declaringTypes != null){
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(NAME_ALREADY_USED,loop.getVariable()),
						base.getStartOffset(loop),
						base.getEndOffset(loop)
						));
			}
		}
		
		return msgs;
	}
	
	public List<IValidationMessage> validateIf(If ifStmt) {
		return new ArrayList<>();
	}
	
	public List<IValidationMessage> validateWhile(While loop) {
		return new ArrayList<>();
	}
	
	private String getSignature(Method op) {
		EOperation eOp = op.getOperationRef();
		if(eOp != null) {
			String paramsToString = 
					eOp
					.getEParameters()
					.stream()
					.map(param -> param.getEType().getName())
					.collect(joining(",","(",")"));
			
			return eOp.getName() + paramsToString; 
		}
		return "undefined";
	}
	
	private boolean isMatching(Method op1, Method op2) {
		EOperation eOp1 = op1.getOperationRef();
		EOperation eOp2 = op2.getOperationRef();
		
		return isMatching(eOp1,eOp2);
	}
	
	private boolean isMatching(EOperation eOp1, EOperation eOp2) {
		
		if(eOp1 == null || eOp2 == null) {
			return false;
		}
		
		boolean isMatchingName = eOp1.getName().equals(eOp2.getName());
		boolean isMatchingArgsSize = (eOp1.getEParameters().size() == eOp2.getEParameters().size());
		
		if(!(isMatchingName && isMatchingArgsSize)){
			return false;
		}
		
		boolean areParamTypeMatching = true;
		for(int i = 0; i <  eOp1.getEParameters().size(); i++) {
			EParameter param1 = eOp1.getEParameters().get(i);
			EParameter param2 = eOp2.getEParameters().get(i);
			areParamTypeMatching = areParamTypeMatching && (param1.getEType().equals(param2.getEType()));
		}
		return isMatchingName && isMatchingArgsSize && areParamTypeMatching;
	}
}
