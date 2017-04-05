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
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.Lists;

import org.eclipse.ecoretools.ale.implementation.Behaviored;
import org.eclipse.ecoretools.ale.implementation.Block;
import org.eclipse.ecoretools.ale.implementation.ExpressionStatement;
import org.eclipse.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.ecoretools.ale.implementation.FeaturePut;
import org.eclipse.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.ecoretools.ale.implementation.ForEach;
import org.eclipse.ecoretools.ale.implementation.If;
import org.eclipse.ecoretools.ale.implementation.Implementation;
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
	
	ImplementationFactory factory;
	EcoreFactory ecoreFactory;
	AstFactory aqlFactory;
	
	public ModelBuilder (IQueryEnvironment qryEnv){
		this.qryEnv = qryEnv;
		builder = new QueryBuilderEngine(qryEnv);
		
		ecoreFactory = (EcoreFactory) qryEnv.getEPackageProvider().getEPackage("ecore").iterator().next().getEFactoryInstance();
		factory = (ImplementationFactory) qryEnv.getEPackageProvider().getEPackage("implementation").iterator().next().getEFactoryInstance();
		aqlFactory = (AstFactory) qryEnv.getEPackageProvider().getEPackage("ast").iterator().next().getEFactoryInstance();
	}
	
	public Method buildMethod(String name, List<Parameter> params, String returnType, Block body, List<String> tags) {
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
		
		Method newMethod = factory.createMethod();
		newMethod.setOperationDef(operation);
		newMethod.setBody(body);
		newMethod.getTags().addAll(tags);
		
		return newMethod;
	}
	
	public Implementation buildImplementation(String containingClass, String name, List<Parameter> params, String returnType, Block body, List<String> tags) {
		Optional<EOperation> existingOperation = resolve(containingClass, name, params.size(), returnType);
		
		if(!existingOperation.isPresent()){
			//TODO: error
		}
		
		Implementation implem = factory.createImplementation();
		
		implem.setOperationRef(existingOperation.get());
		implem.setBody(body);
		implem.getTags().addAll(tags);
		
		return implem;
	}
	
	
	
	public Parameter buildParameter(String type, String name) {
		return new Parameter(name, resolve(type));
	}
	
	public VariableDeclaration buildVariableDecl(String name, String exp, String type) {
		VariableDeclaration varDecl = factory. createVariableDeclaration();
		varDecl.setName(name);
		if(exp != null){
			varDecl.setInitialValue(builder.build(exp).getAst());
		}
		
		varDecl.getType().setEType(resolve(type));
		return varDecl;
	}
	
	public VariableAssignment buildVariableAssignement(String name, String exp) {
		VariableAssignment varAssign = factory. createVariableAssignment();
		varAssign.setName(name);
		varAssign.setValue(builder.build(exp).getAst());
		return varAssign; 
	}
	
	public If buildIf(String condition, Block thenBlock, Block elseBlock) {
		If ifStmt = factory.createIf();
		ifStmt.setCondition(builder.build(condition).getAst());
		ifStmt.setThen(thenBlock);
		ifStmt.setElse(elseBlock);
		return ifStmt;
	}
	
	public Block buildBlock(List<Statement> statements) {
		Block block = factory.createBlock();
		block.getStatements().addAll(statements);
		return block;
	}
	
	public ExpressionStatement buildExpressionStatement(String value) {
		ExpressionStatement exp = factory.createExpressionStatement();
		exp.setExpression(builder.build(value).getAst());
		return exp;
	}
	
	public ForEach buildForEach(String variable, String expression, Block body) {
		ForEach loop = factory.createForEach();
		loop.setVariable(variable);
		loop.setCollectionExpression(builder.build(expression).getAst());
		loop.setBody(body);
		return loop;
	}
	
	public ForEach buildForEach(String variable, SequenceInExtensionLiteral expression, Block body) {
		ForEach loop = factory.createForEach();
		loop.setVariable(variable);
		loop.setCollectionExpression(expression);
		loop.setBody(body);
		return loop;
	}
	
	public While buildWhile(String expression, Block body) {
		While loop = factory.createWhile();
		loop.setCondition(builder.build(expression).getAst());
		loop.setBody(body);
		return loop;
	}
	
	public FeatureAssignment buildFeatureAssign(String target, String feature, String valueExp) {
		FeatureAssignment featSetting = factory.createFeatureAssignment();
		featSetting.setTarget(builder.build(target).getAst());
		featSetting.setTargetFeature(feature);
		featSetting.setValue(builder.build(valueExp).getAst());
		return featSetting;
	}
	
	public FeatureInsert buildFeatureInsert(String target, String feature, String valueExp) {
		FeatureInsert featSetting = factory.createFeatureInsert();
		featSetting.setTarget(builder.build(target).getAst());
		featSetting.setTargetFeature(feature);
		featSetting.setValue(builder.build(valueExp).getAst());
		return featSetting;
	}
	
	public FeatureRemove buildFeatureRemove(String target, String feature, String valueExp) {
		FeatureRemove featSetting = factory.createFeatureRemove();
		featSetting.setTarget(builder.build(target).getAst());
		featSetting.setTargetFeature(feature);
		featSetting.setValue(builder.build(valueExp).getAst());
		return featSetting;
	}
	
	public FeaturePut buildFeaturePut(String target, String feature, String keyExp, String valueExp) {
		FeaturePut featSetting = factory.createFeaturePut();
		featSetting.setTarget(builder.build(target).getAst());
		featSetting.setTargetFeature(feature);
		featSetting.setKey(builder.build(keyExp).getAst());
		featSetting.setValue(builder.build(valueExp).getAst());
		return featSetting;
	}
	
	public ExtendedClass buildExtendedClass(String baseCls, List<VariableDeclaration> vars, List<Behaviored> operations, List<String> extendedCls) {
		ExtendedClass cls = factory.createExtendedClass();
		EClassifier resolvedType = resolve(baseCls);
		if(resolvedType instanceof EClass)
			cls.setBaseClass((EClass)resolvedType);
		cls.getMethods().addAll(operations);
		cls.getAttributes().addAll(vars);
		
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
	
	public RuntimeClass buildRuntimeClass(String name, List<VariableDeclaration> vars, List<Method> operations) {
		RuntimeClass cls = factory.createRuntimeClass();
		cls.setName(name);
		cls.getMethods().addAll(operations);
		cls.getAttributes().addAll(vars);
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
	
	public EClass buildEClass(RuntimeClass cls) {
		EClass eClsClass = EcorePackage.eINSTANCE.getEClass();
		EClass eRefClass = EcorePackage.eINSTANCE.getEReference();
		EClass eAttClass = EcorePackage.eINSTANCE.getEAttribute();
		EClass eOpClass = EcorePackage.eINSTANCE.getEOperation();
		
		EClass res = (EClass) EcoreUtil.create(eClsClass);
		res.setName(cls.getName());

		cls
		.getAttributes()
		.stream()
		.forEach(attr -> {
			String name = attr.getName();
			EClassifier type = attr.getType().getEType();
			
			if(type instanceof EClass){
				EReference newRef = (EReference) EcoreUtil.create(eRefClass);
				newRef.setName(name);
				newRef.setEType(type);
				res.getEStructuralFeatures().add(newRef);
			}
			else if(type instanceof EDataType) {
				EAttribute newAttr = (EAttribute) EcoreUtil.create(eAttClass);
				newAttr.setName(name);
				newAttr.setEType(type);
				res.getEStructuralFeatures().add(newAttr);
			}
		});
		
		cls
		.getMethods()
		.stream()
		.forEach(mtd -> {
			EOperation newOp = EcoreUtil.copy(mtd.getOperationDef());
			res.getEOperations().add(newOp);
		});
		
		return res;
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
			String name = attr.getName();
			EClassifier type = attr.getType().getEType();
			
			if(type instanceof EClass){
				EReference newRef = (EReference) EcoreUtil.create(eRefClass);
				newRef.setName(name);
				newRef.setEType(type);
				cls.getEStructuralFeatures().add(newRef);
			}
			else if(type instanceof EDataType) {
				EAttribute newAttr = (EAttribute) EcoreUtil.create(eAttClass);
				newAttr.setName(name);
				newAttr.setEType(type);
				cls.getEStructuralFeatures().add(newAttr);
			}
		});
		
		clsDef
		.getMethods()
		.stream()
		.forEach(mtd -> {
			EOperation newOp = EcoreUtil.copy(mtd.getOperationDef());
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