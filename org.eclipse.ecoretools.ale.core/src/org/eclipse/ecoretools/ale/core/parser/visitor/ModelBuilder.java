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
package org.eclipse.ecoretools.ale.core.parser.visitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.eclipse.acceleo.query.ast.AstFactory;
import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.ast.IntegerLiteral;
import org.eclipse.acceleo.query.ast.SequenceInExtensionLiteral;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.impl.QueryBuilderEngine;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.Lists;

import org.eclipse.ecoretools.ale.implementation.Block;
import org.eclipse.ecoretools.ale.implementation.ExpressionStatement;
import org.eclipse.ecoretools.ale.implementation.Attribute;
import org.eclipse.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.ecoretools.ale.implementation.FeaturePut;
import org.eclipse.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.ecoretools.ale.implementation.ForEach;
import org.eclipse.ecoretools.ale.implementation.If;
import org.eclipse.ecoretools.ale.implementation.ImplementationFactory;
import org.eclipse.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.ecoretools.ale.implementation.Method;
import org.eclipse.ecoretools.ale.implementation.RuntimeClass;
import org.eclipse.ecoretools.ale.implementation.Statement;
import org.eclipse.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.ecoretools.ale.implementation.While;

/**
 * Helper to create parts of Implementation model & to resolve types.
 */
public class ModelBuilder {
	
	public static ModelBuilder singleton;
	public static final String PARSER_SOURCE = "http://org/eclipse/ecoretools/ale/parser/metadata";
	public static final String PARSER_EXTENDS_KEY = "extends";
	
	
	public static ModelBuilder createSingleton(IQueryEnvironment qryEnv) {
		ModelBuilder.singleton = new ModelBuilder(qryEnv);
		return singleton;
	}
	
	public static class Parameter {
		
		String name;
		EClassifier type;
		
		public Parameter(String name, EClassifier type) {
			this.name = name;
			this.type = type;
		}
		
		public String getName() {
			return name;
		}
		
		public EClassifier getType() {
			return type;
		}
	}
	
	IQueryEnvironment qryEnv;
	QueryBuilderEngine builder;
	
	ImplementationFactory implemFactory;
	EcoreFactory ecoreFactory;
	AstFactory aqlFactory;
	
	public ModelBuilder (IQueryEnvironment qryEnv){
		this.qryEnv = qryEnv;
		builder = new QueryBuilderEngine(qryEnv);
		
		ecoreFactory = (EcoreFactory) qryEnv.getEPackageProvider().getEPackage("ecore").iterator().next().getEFactoryInstance();
		implemFactory = (ImplementationFactory) qryEnv.getEPackageProvider().getEPackage("implementation").iterator().next().getEFactoryInstance();
		aqlFactory = (AstFactory) qryEnv.getEPackageProvider().getEPackage("ast").iterator().next().getEFactoryInstance();
	}
	
	public Method buildMethod(EClass fragment, String name, List<Parameter> params, String returnType, Block body, List<String> tags) {
		EOperation operation = ecoreFactory.createEOperation();
		operation.setName(name);
		
		params.stream().forEach(p -> {
			EParameter opParam = ecoreFactory.createEParameter();
			opParam.setName(p.getName());
			opParam.setEType(p.getType());
			operation.getEParameters().add(opParam);
		});
		
		EClassifier type = resolve(returnType);
		operation.setEType(type);
		fragment.getEOperations().add(operation);
		
		return buildMethod(name,params,returnType,body,tags,operation);
	}
	
	public Method buildMethod(String name, List<Parameter> params, String returnType, Block body, List<String> tags, EOperation operation) {
		Method newMethod = implemFactory.createMethod();
		newMethod.setOperationRef(operation);
		newMethod.setBody(body);
		newMethod.getTags().addAll(tags);
		
		return newMethod;
	}
	
	public Method buildImplementation(String containingClass, String name, List<Parameter> params, String returnType, Block body, List<String> tags) {
		Optional<EOperation> existingOperation = resolve(containingClass, name, params.size(), returnType);
		
		if(!existingOperation.isPresent()){
			//TODO: error
			return null;
		}
		
		return buildMethod(name,params,returnType,body,tags,existingOperation.get());
	}
	
	
	
	public Parameter buildParameter(String type, String name) {
		return new Parameter(name, resolve(type));
	}
	
	public Attribute buildAttribute(EClass fragment, String name, String exp, String type) {
		Attribute attribute = implemFactory.createAttribute();
		EStructuralFeature feature;
		
		
		EClassifier featureType = resolve(type);
		if(featureType instanceof EClass) {
			feature = ecoreFactory.createEReference();
		}
		else {
			feature = ecoreFactory.createEAttribute();
		}
		
		feature.setName(name);
		feature.setEType(featureType);
		attribute.setFeatureRef(feature);
		
		if(exp != null){
			attribute.setInitialValue(builder.build(exp).getAst());
		}
		
		fragment.getEStructuralFeatures().add(feature);
		
		return attribute;
	}
	
	public VariableDeclaration buildVariableDecl(String name, String exp, String type) {
		VariableDeclaration varDecl = implemFactory. createVariableDeclaration();
		varDecl.setName(name);
		if(exp != null){
			varDecl.setInitialValue(builder.build(exp).getAst());
		}
		varDecl.setType(resolve(type));
		return varDecl;
	}
	
	public VariableAssignment buildVariableAssignement(String name, String exp) {
		VariableAssignment varAssign = implemFactory. createVariableAssignment();
		varAssign.setName(name);
		varAssign.setValue(builder.build(exp).getAst());
		return varAssign; 
	}
	
	public If buildIf(String condition, Block thenBlock, Block elseBlock) {
		If ifStmt = implemFactory.createIf();
		ifStmt.setCondition(builder.build(condition).getAst());
		ifStmt.setThen(thenBlock);
		ifStmt.setElse(elseBlock);
		return ifStmt;
	}
	
	public Block buildBlock(List<Statement> statements) {
		Block block = implemFactory.createBlock();
		block.getStatements().addAll(statements);
		return block;
	}
	
	public ExpressionStatement buildExpressionStatement(String value) {
		ExpressionStatement exp = implemFactory.createExpressionStatement();
		exp.setExpression(builder.build(value).getAst());
		return exp;
	}
	
	public ForEach buildForEach(String variable, String expression, Block body) {
		ForEach loop = implemFactory.createForEach();
		loop.setVariable(variable);
		loop.setCollectionExpression(builder.build(expression).getAst());
		loop.setBody(body);
		return loop;
	}
	
	public ForEach buildForEach(String variable, SequenceInExtensionLiteral expression, Block body) {
		ForEach loop = implemFactory.createForEach();
		loop.setVariable(variable);
		loop.setCollectionExpression(expression);
		loop.setBody(body);
		return loop;
	}
	
	public While buildWhile(String expression, Block body) {
		While loop = implemFactory.createWhile();
		loop.setCondition(builder.build(expression).getAst());
		loop.setBody(body);
		return loop;
	}
	
	public FeatureAssignment buildFeatureAssign(String target, String feature, String valueExp) {
		FeatureAssignment featSetting = implemFactory.createFeatureAssignment();
		featSetting.setTarget(builder.build(target).getAst());
		featSetting.setTargetFeature(feature);
		featSetting.setValue(builder.build(valueExp).getAst());
		return featSetting;
	}
	
	public FeatureInsert buildFeatureInsert(String target, String feature, String valueExp) {
		FeatureInsert featSetting = implemFactory.createFeatureInsert();
		featSetting.setTarget(builder.build(target).getAst());
		featSetting.setTargetFeature(feature);
		featSetting.setValue(builder.build(valueExp).getAst());
		return featSetting;
	}
	
	public FeatureRemove buildFeatureRemove(String target, String feature, String valueExp) {
		FeatureRemove featSetting = implemFactory.createFeatureRemove();
		featSetting.setTarget(builder.build(target).getAst());
		featSetting.setTargetFeature(feature);
		featSetting.setValue(builder.build(valueExp).getAst());
		return featSetting;
	}
	
	public FeaturePut buildFeaturePut(String target, String feature, String keyExp, String valueExp) {
		FeaturePut featSetting = implemFactory.createFeaturePut();
		featSetting.setTarget(builder.build(target).getAst());
		featSetting.setTargetFeature(feature);
		featSetting.setKey(builder.build(keyExp).getAst());
		featSetting.setValue(builder.build(valueExp).getAst());
		return featSetting;
	}
	
	public ExtendedClass buildExtendedClass(String baseCls, List<Attribute> attributes, List<Method> operations, List<String> extendedCls) {
		ExtendedClass cls = implemFactory.createExtendedClass();
		EClassifier resolvedType = resolve(baseCls);
		if(resolvedType instanceof EClass)
			cls.setBaseClass((EClass)resolvedType);
		cls.getMethods().addAll(operations);
		cls.getAttributes().addAll(attributes);
		
		//Add metadata for ID to be resolved
		extendedCls
			.stream()
			.forEach(xtd -> {
				EAnnotation annot = ecoreFactory.createEAnnotation();
				annot.setSource(PARSER_SOURCE);
				annot.getDetails().put(PARSER_EXTENDS_KEY, xtd);
				cls.getEAnnotations().add(annot);
			});
		
		return cls;
	}
	
	public RuntimeClass buildRuntimeClass(String name, List<Attribute> attributes, List<Method> operations) {
		RuntimeClass cls = implemFactory.createRuntimeClass();
		cls.setName(name);
		cls.getMethods().addAll(operations);
		cls.getAttributes().addAll(attributes);
		return cls;
	}
	
	
	public SequenceInExtensionLiteral buildIntSequence(String left, String right) {
		
		SequenceInExtensionLiteral seq = aqlFactory.createSequenceInExtensionLiteral();
		
		try{
			int min = Integer.parseInt(left);
			int max = Integer.parseInt(right);
			
			if(min <= max){
				for(int i = min; i <= max; i++){
					IntegerLiteral item = aqlFactory.createIntegerLiteral();
					item.setValue(i);
					seq.getValues().add(item);
				}
			}
			else {
				for(int i = min; i >= max; i--){
					IntegerLiteral item = aqlFactory.createIntegerLiteral();
					item.setValue(i);
					seq.getValues().add(item);
				}
			}
		}
		catch(NumberFormatException e) {
			//TODO: complain here
		}
		
		return seq;
	}
	
	public EPackage buildEPackage(String qualifiedName) {
		EClass ePkgClass = EcorePackage.eINSTANCE.getEPackage();
		EPackage newPkg = (EPackage) EcoreUtil.create(ePkgClass);
		
		String[] segments = qualifiedName.split("\\.");
		newPkg.setName(segments[0]);
		
		int i = 1;
		EPackage parent = newPkg;
		while(i < segments.length) {
			String segment = segments[i];
			EPackage subPkg = (EPackage) EcoreUtil.create(ePkgClass);
			subPkg.setName(segment);
			parent.getESubpackages().add(subPkg);
			parent = subPkg;
			i++;
		}
		
		return parent;
	}
	
	public EClass buildEClass(String name) {
		EClass eClsClass = EcorePackage.eINSTANCE.getEClass();
		EClass cls = (EClass) EcoreUtil.create(eClsClass);
		cls.setName(name);
		return cls;
	}
	
	
	/**
	 * Add new EOperation, EAttribute & EReference in {@link cls}, based on features defined in {@link clsDef} 
	 */
	public void updateEClass(EClass cls, RuntimeClass clsDef) {
		EClass eRefClass = EcorePackage.eINSTANCE.getEReference();
		EClass eAttClass = EcorePackage.eINSTANCE.getEAttribute();

		clsDef
		.getAttributes()
		.stream()
		.forEach(attr -> {
			
			String name = attr.getFeatureRef().getName();
			EStructuralFeature featureCopy = EcoreUtil.copy(attr.getFeatureRef());
			cls.getEStructuralFeatures().add(featureCopy);
			
		});
		
		clsDef
		.getMethods()
		.stream()
		.forEach(mtd -> {
			EOperation newOp = EcoreUtil.copy(mtd.getOperationRef());
			cls.getEOperations().add(newOp);
		});
	}
	
	//Can return null
	public Optional<EOperation> resolve(String className, String methodName, int nbArgs, String returnType) {
		EClassifier type = resolve(returnType);
		//TODO: manage qualified name		
		Optional<EOperation> eOperation = 
			qryEnv
			.getEPackageProvider()
			.getEClassifiers()
			.stream()
			.filter(cls -> cls instanceof EClass)
			.filter(cls -> cls.getName().equals(className))
			.flatMap(cls -> ((EClass)cls).getEOperations().stream())
			.filter(op -> op.getName().equals(methodName) && op.getEParameters().size() == nbArgs && op.getEType() == type)
			.findFirst();
		
		return eOperation;
	}
	
	public EClassifier resolve(String className) {
		
		int lastDotIndex = className.lastIndexOf(".");
		if(lastDotIndex != -1 && lastDotIndex < className.length()) {
			String simpleName = className.substring(lastDotIndex+1);
			
			Collection<EClassifier> clsCandidates = qryEnv.getEPackageProvider().getTypes(simpleName);
			
			Optional<EClassifier> foundCls = 
				clsCandidates
				.stream()
				.filter(c -> getQualifiedName(c).equals(className))
				.findFirst();
			if(foundCls.isPresent())
				return foundCls.get();
		}
		
		Optional<EClassifier> candidate =
			qryEnv
			.getEPackageProvider()
			.getEClassifiers()
			.stream()
			.filter(cls -> !cls.getEPackage().getName().equals("implementation"))
			.filter(cls -> cls.getName().equals(className))
			.findFirst();
		
		if(candidate.isPresent())
			return candidate.get();
		
		switch (className) {
			case "String"	: return EcorePackage.eINSTANCE.getEString();
			case "boolean" 	: return EcorePackage.eINSTANCE.getEBoolean();
			case "byte" 	: return EcorePackage.eINSTANCE.getEByte();
			case "char" 	: return EcorePackage.eINSTANCE.getEChar();
			case "short" 	: return EcorePackage.eINSTANCE.getEShort();
			case "int" 		: return EcorePackage.eINSTANCE.getEInt();
			case "long" 	: return EcorePackage.eINSTANCE.getELong();
			case "float" 	: return EcorePackage.eINSTANCE.getEFloat();
			case "double" 	: return EcorePackage.eINSTANCE.getEDouble();
			case "void"		: return null;
			default			: return EcorePackage.eINSTANCE.getEClassifier();
		}
	}
	
	public static String getQualifiedName(EClassifier cls) {
		
		List<String> fullName = new ArrayList<String>();
		
		fullName.add(cls.getName());
		
		EPackage current = cls.getEPackage();
		fullName.add(current.getName());
		while(current.getESuperPackage() != null) {
			current = current.getESuperPackage();
			fullName.add(current.getName());
		}
		
		return String.join(".", Lists.reverse(fullName));
	}
	
	public AstResult parse(String expression) {
		return builder.build(expression);
	}
}