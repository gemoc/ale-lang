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

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToMethodParameter;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Context;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsFactory;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInBaseClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodParameterAlreadyDefined;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordResult;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.ValidationMessageFactory;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
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
	
	BaseValidator base;
	
	private IValidationMessageFactory messages;
	
	public void setBase(BaseValidator base) {
		this.base = base;
		this.messages = new ValidationMessageFactory(base);
	}
	
	@Override
	public List<Message> validateModelUnit(ModelUnit unit) {
		
		List<Message> msgs = new ArrayList<>();
		
		/*
		 * Check duplication of RuntimeClass
		 */
		Map<String, RuntimeClass> declarations = new HashMap<>(5);
		unit
		.getClassDefinitions()
		.stream()
		.forEach(cls -> {
			if(declarations.containsKey(cls.getName())) {
				CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
				location.setLine(base.getLines(cls).get(0));
				location.setStartPosition(base.getStartOffset(cls));
				location.setEndPosition(base.getStartOffset(cls) + ("class" + cls.getName()).length());
				
				Context context = DiagnosticsFactory.eINSTANCE.createContext();
				
				DynamicClassAlreadyDefined alreadyDeclared = DiagnosticsFactory.eINSTANCE.createDynamicClassAlreadyDefined();
				alreadyDeclared.setContext(context);
				alreadyDeclared.setLocation(location);
				alreadyDeclared.setSource(cls);
				alreadyDeclared.setCurrentDeclaration(cls);
				alreadyDeclared.setPreviousDeclaration(declarations.get(cls.getName()));
				msgs.add(alreadyDeclared);
			}
			else {
				declarations.put(cls.getName(), cls);
			}
		});
		
		return msgs;
	}
	
	@Override
	public List<Message> validateExtendedClass(ExtendedClass xtdClass) {
		List<Message> msgs = new ArrayList<>();
		
		//TODO: check cycles in 'extends'
		msgs.addAll(validateBehavioredClass(xtdClass));
		
		if (xtdClass.getBaseClass() != null) {
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
					CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
					location.setLine(base.getLines(att).get(0));
					location.setStartPosition(base.getStartOffset(att));
					location.setEndPosition(base.getEndOffset(att));
					
					Context context = DiagnosticsFactory.eINSTANCE.createContext();
					
					AttributeAlreadyDefinedInBaseClass alreadyDeclared = DiagnosticsFactory.eINSTANCE.createAttributeAlreadyDefinedInBaseClass();
					alreadyDeclared.setContext(context);
					alreadyDeclared.setLocation(location);
					alreadyDeclared.setSource(att);
					alreadyDeclared.setAttributeName(name);
					alreadyDeclared.setOpenClass(xtdClass);
					alreadyDeclared.setBaseClass(xtdClass.getBaseClass());
					msgs.add(alreadyDeclared);
				}
			});
			
			/*
			 * Check def methods must not override
			 */
			EList<EOperation> allEOperations = xtdClass.getBaseClass().getEAllOperations();
			for (Method mtd : xtdClass.getMethods()) {
				if (mtd.isOverriding()) {
					continue;
				}
				EOperation opRef = mtd.getOperationRef();
				if(opRef!= null && opRef.getEContainingClass() != xtdClass.getBaseClass()) {
					if(allEOperations.stream().anyMatch(op -> areTheSame(opRef, op))){
						CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
						location.setLine(base.getLines(mtd).get(0));
						location.setStartPosition(base.getStartOffset(mtd));
						location.setEndPosition(base.getStartOffset(mtd.getBody()));
						
						Context context = DiagnosticsFactory.eINSTANCE.createContext();
						
						MethodAlreadyDefinedInBaseClass alreadyDeclared = DiagnosticsFactory.eINSTANCE.createMethodAlreadyDefinedInBaseClass();
						alreadyDeclared.setContext(context);
						alreadyDeclared.setLocation(location);
						alreadyDeclared.setNewDefinition(mtd);
						alreadyDeclared.setSource(mtd);
						msgs.add(alreadyDeclared);
					}
				}
			}
		}
		return msgs;
	}
	
	@Override
	public List<Message> validateRuntimeClass(RuntimeClass classDef) {
		return validateBehavioredClass(classDef);
	}
	
	private List<Message> validateBehavioredClass(BehavioredClass clazz) {
		List<Message> msgs = new ArrayList<>();
		
		/*
		 * Check attributes names
		 */
		Map<String, Attribute> declarations = new HashMap<>(5); 
		clazz
		.getAttributes()
		.stream()
		.forEach(att -> {
			String name = att.getFeatureRef().getName();
			if(declarations.containsKey(name)) {
				CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
				location.setLine(base.getLines(att).get(0));
				location.setStartPosition(base.getStartOffset(att));
				location.setEndPosition(base.getEndOffset(att));
				
				Context context = DiagnosticsFactory.eINSTANCE.createContext();
				
				AttributeAlreadyDefinedInCurrentClass alreadyDeclared = DiagnosticsFactory.eINSTANCE.createAttributeAlreadyDefinedInCurrentClass();
				alreadyDeclared.setContext(context);
				alreadyDeclared.setLocation(location);
				alreadyDeclared.setSource(att);
				alreadyDeclared.setAttributeName(name);
				alreadyDeclared.setOwner(clazz);
				alreadyDeclared.setPreviousDeclaration(declarations.get(name));
				msgs.add(alreadyDeclared);
			}
			else if(name.equals("self")){
				CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
				location.setLine(base.getLines(att).get(0));
				location.setStartPosition(base.getStartOffset(att));
				location.setEndPosition(base.getEndOffset(att));
				
				Context context = DiagnosticsFactory.eINSTANCE.createContext();
				
				ReservedKeywordSelf reservedKeyword = DiagnosticsFactory.eINSTANCE.createReservedKeywordSelf();
				reservedKeyword.setContext(context);
				reservedKeyword.setLocation(location);
				reservedKeyword.setSource(att);
				msgs.add(reservedKeyword);
			}
			else if(name.equals("result")){
				CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
				location.setLine(base.getLines(att).get(0));
				location.setStartPosition(base.getStartOffset(att));
				location.setEndPosition(base.getEndOffset(att));
				
				Context context = DiagnosticsFactory.eINSTANCE.createContext();
				
				ReservedKeywordResult reservedKeyword = DiagnosticsFactory.eINSTANCE.createReservedKeywordResult();
				reservedKeyword.setContext(context);
				reservedKeyword.setLocation(location);
				reservedKeyword.setSource(att);
				msgs.add(reservedKeyword);
			}
			else {
				declarations.put(name, att);
			}
		});
		
		/*
		 * Check operation duplication
		 */
		List<Method> previousOp = new ArrayList<>(5); 
		for (Method mtd : clazz.getMethods()) {
			Optional<Method> previousDeclaration = previousOp.stream().filter(prevOp -> areTheSame(mtd, prevOp)).findFirst();
			if(previousDeclaration.isPresent()) {
				CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
				location.setLine(base.getLines(mtd).get(0));
				location.setStartPosition(base.getStartOffset(mtd));
				location.setEndPosition(base.getStartOffset(mtd.getBody()));
				
				Context context = DiagnosticsFactory.eINSTANCE.createContext();
				
				MethodAlreadyDefinedInCurrentClass alreadyDeclared = DiagnosticsFactory.eINSTANCE.createMethodAlreadyDefinedInCurrentClass();
				alreadyDeclared.setContext(context);
				alreadyDeclared.setLocation(location);
				alreadyDeclared.setSource(mtd);
				alreadyDeclared.setOwner(clazz);
				alreadyDeclared.setCurrentDeclaration(mtd);
				alreadyDeclared.setPreviousDeclaration(previousDeclaration.get());
				msgs.add(alreadyDeclared);
			}
			previousOp.add(mtd);
		}
		
		return msgs;
	}
	
	@Override
	public List<Message> validateMethod(Method mtd) {
		List<Message> msgs = new ArrayList<>();
		
		/*
		 * Check parameter name
		 */
		List<String> declarations = new ArrayList<>();
		if(mtd.getOperationRef() != null) {
			for (EParameter param : mtd.getOperationRef().getEParameters()) {
				String name = param.getName();
				if(declarations.contains(name)) {
					CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
					location.setLine(base.getLines(mtd).get(0));
					location.setStartPosition(base.getStartOffset(param));
					location.setEndPosition(base.getEndOffset(param) + 1);
					
					if (location.getStartPosition() == 0) {
						location.setStartPosition(base.getStartOffset(mtd));
						location.setEndPosition(base.getStartOffset(mtd.getBody()));
					}
					
					Context context = DiagnosticsFactory.eINSTANCE.createContext();
					
					MethodParameterAlreadyDefined alreadyDefined = DiagnosticsFactory.eINSTANCE.createMethodParameterAlreadyDefined();
					alreadyDefined.setContext(context);
					alreadyDefined.setLocation(location);
					alreadyDefined.setSource(param);
					alreadyDefined.setParameterName(name);
					msgs.add(alreadyDefined);
				}
				else if(param.getName().equals("result")){
					CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
					location.setLine(base.getLines(mtd).get(0));
					location.setStartPosition(base.getStartOffset(param));
					location.setEndPosition(base.getEndOffset(param) + 1);
					
					if (location.getStartPosition() == 0) {
						location.setStartPosition(base.getStartOffset(mtd));
						location.setEndPosition(base.getStartOffset(mtd.getBody()));
					}
					
					Context context = DiagnosticsFactory.eINSTANCE.createContext();
					
					ReservedKeywordResult reservedKeyword = DiagnosticsFactory.eINSTANCE.createReservedKeywordResult();
					reservedKeyword.setContext(context);
					reservedKeyword.setLocation(location);
					reservedKeyword.setSource(param);
					msgs.add(reservedKeyword);
				}
				else if(param.getName().equals("self")){
					CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
					location.setLine(base.getLines(mtd).get(0));
					location.setStartPosition(base.getStartOffset(param));
					location.setEndPosition(base.getEndOffset(param) + 1);
					
					if (location.getStartPosition() == 0) {
						location.setStartPosition(base.getStartOffset(mtd));
						location.setEndPosition(base.getStartOffset(mtd.getBody()));
					}
					
					Context context = DiagnosticsFactory.eINSTANCE.createContext();
					
					ReservedKeywordSelf reservedKeyword = DiagnosticsFactory.eINSTANCE.createReservedKeywordSelf();
					reservedKeyword.setContext(context);
					reservedKeyword.setLocation(location);
					reservedKeyword.setSource(param);
					msgs.add(reservedKeyword);
				}
				else {
					declarations.add(name);
				}
			}
		}
		else {
			CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
			location.setLine(base.getLines(mtd).get(0));
			location.setStartPosition(base.getStartOffset(mtd));
			location.setEndPosition(base.getStartOffset(mtd.getBody()));
			
			Context context = DiagnosticsFactory.eINSTANCE.createContext();
			
			OverriddenMethodNotFound methodNotFound = DiagnosticsFactory.eINSTANCE.createOverriddenMethodNotFound();
			methodNotFound.setContext(context);
			methodNotFound.setLocation(location);
			methodNotFound.setSource(mtd);
			methodNotFound.setOverridingMethod(mtd);
			methodNotFound.setOverridingMethodOwner((BehavioredClass) mtd.eContainer());
			msgs.add(methodNotFound);
		}
		
		return msgs;
	}
	
	@Override
	public List<Message> validateFeatureAssignment(FeatureAssignment featAssign) {
		List<Message> msgs = new ArrayList<>();
		
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
			CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
			location.setLine(base.getLines(featAssign.getTarget()).get(0));
			location.setStartPosition(base.getStartOffset(featAssign.getTarget()));
			location.setEndPosition(base.getStartOffset(featAssign.getTarget()) + ("self." + featAssign.getTargetFeature()).length());
			
			Context context = DiagnosticsFactory.eINSTANCE.createContext();
			
			AttributeNotFound attributeNotFound = DiagnosticsFactory.eINSTANCE.createAttributeNotFound();
			attributeNotFound.setContext(context);
			attributeNotFound.setLocation(location);
			attributeNotFound.setSource(featAssign);
			attributeNotFound.setName(featAssign.getTargetFeature());
			attributeNotFound.setOwner(null /* FIXME Find owner */);
			msgs.add(attributeNotFound);
		}
		
		return msgs;
	}
	
	@Override
	public List<Message> validateFeatureInsert(FeatureInsert featInsert) {
		List<Message> msgs = new ArrayList<>();
		
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
			CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
			location.setLine(base.getLines(featInsert.getTarget()).get(0));
			location.setStartPosition(base.getStartOffset(featInsert.getTarget()));
			location.setEndPosition(base.getStartOffset(featInsert.getTarget()) + ("self." + featInsert.getTargetFeature()).length());
			
			Context context = DiagnosticsFactory.eINSTANCE.createContext();
			
			AttributeNotFound attributeNotFound = DiagnosticsFactory.eINSTANCE.createAttributeNotFound();
			attributeNotFound.setContext(context);
			attributeNotFound.setLocation(location);
			attributeNotFound.setSource(featInsert);
			attributeNotFound.setName(featInsert.getTargetFeature());
			attributeNotFound.setOwner(null /* FIXME Find owner */);
			msgs.add(attributeNotFound);
		}
		
		return msgs;
	}
	
	@Override
	public List<Message> validateFeatureRemove(FeatureRemove featRemove) {
		List<Message> msgs = new ArrayList<>();
		
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
			CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
			location.setLine(base.getLines(featRemove.getTarget()).get(0));
			location.setStartPosition(base.getStartOffset(featRemove.getTarget()));
			location.setEndPosition(base.getStartOffset(featRemove.getTarget()) + ("self." + featRemove.getTargetFeature()).length());
			
			Context context = DiagnosticsFactory.eINSTANCE.createContext();
			
			AttributeNotFound attributeNotFound = DiagnosticsFactory.eINSTANCE.createAttributeNotFound();
			attributeNotFound.setContext(context);
			attributeNotFound.setLocation(location);
			attributeNotFound.setSource(featRemove);
			attributeNotFound.setName(featRemove.getTargetFeature());
			attributeNotFound.setOwner(null /* FIXME Find owner */);
			msgs.add(attributeNotFound);
		}
		
		return msgs;
	}
	
	@Override
	public List<Message> validateVariableAssignment(VariableAssignment varAssign) {
		List<Message> msgs = new ArrayList<>();
		
		/*
		 * Check name
		 */
		Set<IType> declaringTypes = base.getCurrentScope().get(varAssign.getName());
		if(declaringTypes == null && !varAssign.getName().equals("result")){
			CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
			location.setLine(base.getLines(varAssign).get(0));
			location.setStartPosition(base.getStartOffset(varAssign));
			location.setEndPosition(base.getStartOffset(varAssign) + varAssign.getName().length());
			
			Context context = DiagnosticsFactory.eINSTANCE.createContext();
			
			VariableNotFound variableNotFound = DiagnosticsFactory.eINSTANCE.createVariableNotFound();
			variableNotFound.setContext(context);
			variableNotFound.setLocation(location);
			variableNotFound.setSource(varAssign);
			variableNotFound.setName(varAssign.getName());
			msgs.add(variableNotFound);
		}
		else if(varAssign.getName().equals("self")){
			CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
			location.setLine(base.getLines(varAssign).get(0));
			location.setStartPosition(base.getStartOffset(varAssign));
			location.setEndPosition(base.getStartOffset(varAssign) + varAssign.getName().length());
			
			Context context = DiagnosticsFactory.eINSTANCE.createContext();
			
			ProhibitedAssignmentToSelf assignmentToSelf = DiagnosticsFactory.eINSTANCE.createProhibitedAssignmentToSelf();
			assignmentToSelf.setContext(context);
			assignmentToSelf.setLocation(location);
			assignmentToSelf.setSource(varAssign);
			msgs.add(assignmentToSelf);
		}
		else {
			Method method = base.getContainingOperation(varAssign);
			EOperation enclosingOperation = method.getOperationRef();
			if(enclosingOperation != null) {
				
				// Check whether the variable is a parameter of the operation
				
				boolean isProhibitedAssignmentToMethodParameter =
						enclosingOperation.getEParameters()
						.stream()
						.anyMatch(param -> param.getName().equals(varAssign.getName()));
				if(isProhibitedAssignmentToMethodParameter){
					CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
					location.setLine(base.getLines(varAssign).get(0));
					location.setStartPosition(base.getStartOffset(varAssign));
					location.setEndPosition(base.getStartOffset(varAssign) + varAssign.getName().length());
					
					Context context = DiagnosticsFactory.eINSTANCE.createContext();
					
					ProhibitedAssignmentToMethodParameter assignmentToParam = DiagnosticsFactory.eINSTANCE.createProhibitedAssignmentToMethodParameter();
					assignmentToParam.setContext(context);
					assignmentToParam.setLocation(location);
					assignmentToParam.setSource(varAssign);
					assignmentToParam.setParameterName(varAssign.getName());
					msgs.add(assignmentToParam);
				}
				
				// Check attempts to assign 'result' in a void operation
				
				boolean assigningToResult = "result".equals(varAssign.getName());
				boolean isVoidOperation = (enclosingOperation.getEType() == null && enclosingOperation.getEGenericType() == null)
									   || enclosingOperation.getEType() == ImplementationPackage.eINSTANCE.getVoidEClassifier();
				if(assigningToResult && isVoidOperation) {
					Message invalidAssignment = messages.assignmentToResultInVoidOperation(varAssign);
					msgs.add(invalidAssignment);
					return msgs;
				}
			}
		}
		
		return msgs;
	}
	
	public List<Message> validateVariableDeclaration(VariableDeclaration varDecl) {
		List<Message> msgs = new ArrayList<>();
		
		/*
		 * Check name
		 */
		if(varDecl.getName().equals("result")){
			CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
			location.setLine(base.getLines(varDecl).get(0));
			location.setStartPosition(base.getStartOffset(varDecl));
			location.setEndPosition(base.getEndOffset(varDecl));
			
			Context context = DiagnosticsFactory.eINSTANCE.createContext();
			
			ReservedKeywordResult reservedKeyword = DiagnosticsFactory.eINSTANCE.createReservedKeywordResult();
			reservedKeyword.setContext(context);
			reservedKeyword.setLocation(location);
			reservedKeyword.setSource(varDecl);
			msgs.add(reservedKeyword);
		}
		else if(varDecl.getName().equals("self")){
			CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
			location.setLine(base.getLines(varDecl).get(0));
			location.setStartPosition(base.getStartOffset(varDecl));
			location.setEndPosition(base.getEndOffset(varDecl));
			
			Context context = DiagnosticsFactory.eINSTANCE.createContext();
			
			ReservedKeywordSelf reservedKeyword = DiagnosticsFactory.eINSTANCE.createReservedKeywordSelf();
			reservedKeyword.setContext(context);
			reservedKeyword.setLocation(location);
			reservedKeyword.setSource(varDecl);
			msgs.add(reservedKeyword);
		}
		else {
			Set<IType> declaringTypes = base.getCurrentScope().get(varDecl.getName());
			if(declaringTypes != null){
				CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
				location.setLine(base.getLines(varDecl).get(0));
				location.setStartPosition(base.getStartOffset(varDecl));
				location.setEndPosition(base.getEndOffset(varDecl));
				
				Context context = DiagnosticsFactory.eINSTANCE.createContext();
				
				VariableAlreadyDefined alreadyBound = DiagnosticsFactory.eINSTANCE.createVariableAlreadyDefined();
				alreadyBound.setContext(context);
				alreadyBound.setLocation(location);
				alreadyBound.setSource(varDecl);
				alreadyBound.setName(varDecl.getName());
				msgs.add(alreadyBound);
			}
		}
		
		return msgs;
	}
	
	@Override
	public List<Message> validateVariableInsert(VariableInsert varInsert) {
		List<Message> msgs = new ArrayList<>();
		
		boolean assigningToResult = "result".equals(varInsert.getName());
		Set<IType> declaringTypes = base.getCurrentScope().get(varInsert.getName());

		if(declaringTypes == null && !assigningToResult){
			CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
			location.setLine(base.getLines(varInsert).get(0));
			location.setStartPosition(base.getStartOffset(varInsert));
			location.setEndPosition(base.getStartOffset(varInsert) + varInsert.getName().length());
			
			Context context = DiagnosticsFactory.eINSTANCE.createContext();
			
			VariableNotFound variableNotFound = DiagnosticsFactory.eINSTANCE.createVariableNotFound();
			variableNotFound.setContext(context);
			variableNotFound.setLocation(location);
			variableNotFound.setSource(varInsert);
			variableNotFound.setName(varInsert.getName());
			msgs.add(variableNotFound);
		}
		else if (assigningToResult) {
			// Check attempts to assign 'result' in a void operation
			
			Method method = base.getContainingOperation(varInsert);
			EOperation enclosingOperation = method.getOperationRef();
			
			if (enclosingOperation != null) {
				boolean isVoidOperation = (enclosingOperation.getEType() == null && enclosingOperation.getEGenericType() == null)
									   || enclosingOperation.getEType() == ImplementationPackage.eINSTANCE.getVoidEClassifier();
				if(isVoidOperation) {
					Message invalidAssignment = messages.assignmentToResultInVoidOperation(varInsert);
					msgs.add(invalidAssignment);
					return msgs;
				}
			}
		}
		return msgs;
	}
	
	@Override
	public List<Message> validateVariableRemove(VariableRemove varRemove) {
		List<Message> msgs = new ArrayList<>();
		
		boolean assigningToResult = "result".equals(varRemove.getName());
		Set<IType> declaringTypes = base.getCurrentScope().get(varRemove.getName());
		
		if(declaringTypes == null && !assigningToResult){
			CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
			location.setLine(base.getLines(varRemove).get(0));
			location.setStartPosition(base.getStartOffset(varRemove));
			location.setEndPosition(base.getStartOffset(varRemove) + varRemove.getName().length());
			
			Context context = DiagnosticsFactory.eINSTANCE.createContext();
			
			VariableNotFound variableNotFound = DiagnosticsFactory.eINSTANCE.createVariableNotFound();
			variableNotFound.setContext(context);
			variableNotFound.setLocation(location);
			variableNotFound.setSource(varRemove);
			variableNotFound.setName(varRemove.getName());
			msgs.add(variableNotFound);
		}
		else if (assigningToResult) {
			// Check attempts to assign 'result' in a void operation
			
			Method method = base.getContainingOperation(varRemove);
			EOperation enclosingOperation = method.getOperationRef();
			
			if (enclosingOperation != null) {
				boolean isVoidOperation = (enclosingOperation.getEType() == null && enclosingOperation.getEGenericType() == null)
						   				|| enclosingOperation.getEType() == ImplementationPackage.eINSTANCE.getVoidEClassifier();
				if(isVoidOperation) {
					Message invalidAssignment = messages.assignmentToResultInVoidOperation(varRemove);
					msgs.add(invalidAssignment);
					return msgs;
				}
			}
		}
		return msgs;
	}
	
	public List<Message> validateForEach(ForEach loop) {
		List<Message> msgs = new ArrayList<>();
		
		if(loop.getVariable().equals("result")){
			CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
			location.setLine(base.getLines(loop).get(0));
			location.setStartPosition(base.getStartOffset(loop));
			location.setEndPosition(base.getEndOffset(loop));
			
			Context context = DiagnosticsFactory.eINSTANCE.createContext();
			
			ReservedKeywordResult reservedKeyword = DiagnosticsFactory.eINSTANCE.createReservedKeywordResult();
			reservedKeyword.setContext(context);
			reservedKeyword.setLocation(location);
			reservedKeyword.setSource(loop);
			msgs.add(reservedKeyword);
		}
		else if(loop.getVariable().equals("self")){
			CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
			location.setLine(base.getLines(loop).get(0));
			location.setStartPosition(base.getStartOffset(loop));
			location.setEndPosition(base.getEndOffset(loop));
			
			Context context = DiagnosticsFactory.eINSTANCE.createContext();
			
			ReservedKeywordSelf reservedKeyword = DiagnosticsFactory.eINSTANCE.createReservedKeywordSelf();
			reservedKeyword.setContext(context);
			reservedKeyword.setLocation(location);
			reservedKeyword.setSource(loop);
			msgs.add(reservedKeyword);
		}
		else {
			Set<IType> declaringTypes = base.getCurrentScope().get(loop.getVariable());
			if(declaringTypes != null){
				CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
				location.setLine(base.getLines(loop).get(0));
				location.setStartPosition(base.getStartOffset(loop));
				location.setEndPosition(base.getEndOffset(loop));
				
				Context context = DiagnosticsFactory.eINSTANCE.createContext();
				
				VariableAlreadyDefined alreadyBound = DiagnosticsFactory.eINSTANCE.createVariableAlreadyDefined();
				alreadyBound.setContext(context);
				alreadyBound.setLocation(location);
				alreadyBound.setSource(loop);
				alreadyBound.setName(loop.getVariable());
				msgs.add(alreadyBound);
			}
		}
		
		return msgs;
	}
	
	public List<Message> validateIf(If ifStmt) {
		return emptyList();
	}
	
	public List<Message> validateWhile(While loop) {
		return emptyList();
	}
	
	private boolean areTheSame(Method op1, Method op2) {
		EOperation eOp1 = op1.getOperationRef();
		EOperation eOp2 = op2.getOperationRef();
		
		return areTheSame(eOp1,eOp2);
	}
	
	private boolean areTheSame(EOperation eOp1, EOperation eOp2) {
		
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
