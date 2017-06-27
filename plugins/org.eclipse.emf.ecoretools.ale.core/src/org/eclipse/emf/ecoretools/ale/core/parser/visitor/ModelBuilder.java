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
package org.eclipse.emf.ecoretools.ale.core.parser.visitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.antlr.v4.runtime.misc.Interval;
import org.eclipse.acceleo.query.ast.AstFactory;
import org.eclipse.acceleo.query.ast.Binding;
import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.ast.IntegerLiteral;
import org.eclipse.acceleo.query.ast.Let;
import org.eclipse.acceleo.query.ast.SequenceInExtensionLiteral;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.impl.QueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.ExpressionContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RCaseContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RExpressionContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RSwitchContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RTypeContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.TypeLiteralContext;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.Case;
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeaturePut;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationFactory;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.Switch;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.While;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * Helper to create parts of Implementation model & to resolve types.
 */
public class ModelBuilder {
	
	public static ModelBuilder singleton;
	public static final String PARSER_SOURCE = "http://org/eclipse/emf/ecoretools/ale/parser/metadata";
	public static final String PARSER_EXTENDS_KEY = "extends";
	public static final String PARSER_OPPOSITE_KEY = "opposite";
	public static final String RUNTIME_ALE_NSURI = "http://ale/runtime/";
	public static final String PARSER_ID = "org.eclipse.emf.ecoretools.ale";

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
	QueryEvaluationEngine aqlEngine;
	
	ImplementationFactory implemFactory;
	EcoreFactory ecoreFactory;
	AstFactory aqlFactory;
	
	public ModelBuilder (IQueryEnvironment qryEnv){
		this.qryEnv = qryEnv;
		builder = new QueryBuilderEngine(qryEnv);
		aqlEngine = new QueryEvaluationEngine(qryEnv);
		
		ecoreFactory = (EcoreFactory) qryEnv.getEPackageProvider().getEPackage("ecore").iterator().next().getEFactoryInstance();
		implemFactory = (ImplementationFactory) qryEnv.getEPackageProvider().getEPackage("implementation").iterator().next().getEFactoryInstance();
		aqlFactory = (AstFactory) qryEnv.getEPackageProvider().getEPackage("ast").iterator().next().getEFactoryInstance();
	}
	
	public Method buildMethod(EClass fragment, String name, List<Parameter> params, RTypeContext returnType, Block body, List<String> tags) {
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
		
		return buildMethod(operation,body,tags);
	}
	
	public Method buildMethod(EOperation operation, Block body, List<String> tags) {
		Method newMethod = implemFactory.createMethod();
		newMethod.setOperationRef(operation);
		newMethod.setBody(body);
		newMethod.getTags().addAll(tags);
		
		return newMethod;
	}
	
	public Method buildImplementation(String containingClass, String name, List<Parameter> params, RTypeContext returnType, Block body, List<String> tags) {
		Optional<EOperation> existingOperation = resolve(containingClass, name, params.size(), returnType);
		
		if(!existingOperation.isPresent()){
			return buildMethod(null,body,tags);
		}
		
		return buildMethod(existingOperation.get(),body,tags);
	}
	
	
	
	public Parameter buildParameter(RTypeContext type, String name) {
		return new Parameter(name, resolve(type));
	}
	
	public Attribute buildAttribute(EClass fragment, String name, RExpressionContext exp, RTypeContext type, int lowerBound, int upperBound, boolean isContainment, boolean isUnique, String opposite, ParseResult<ModelUnit> parseRes) {
		Attribute attribute = implemFactory.createAttribute();
		EStructuralFeature feature;
		
		
		EClassifier featureType = resolve(type);
		if(featureType instanceof EClass) {
			feature = ecoreFactory.createEReference();
			((EReference)feature).setContainment(isContainment);
		}
		else {
			feature = ecoreFactory.createEAttribute();
		}
		
		feature.setName(name);
		feature.setEType(featureType);
		attribute.setFeatureRef(feature);
		
		if(exp != null){
			attribute.setInitialValue(parseExp(exp,parseRes));
		}
		
		if(opposite != null) {
			EAnnotation annot = ecoreFactory.createEAnnotation();
			annot.setSource(PARSER_SOURCE);
			annot.getDetails().put(PARSER_OPPOSITE_KEY, opposite);
			attribute.getEAnnotations().add(annot);
		}
		
		fragment.getEStructuralFeatures().add(feature);
		
		feature.setLowerBound(lowerBound);
		feature.setUpperBound(upperBound);
		feature.setUnique(isUnique);
		
		return attribute;
	}
	
	public VariableDeclaration buildVariableDecl(String name, RExpressionContext exp, RTypeContext type, ParseResult<ModelUnit> parseRes) {
		VariableDeclaration varDecl = implemFactory.createVariableDeclaration();
		varDecl.setName(name);
		if(exp != null){
			varDecl.setInitialValue(parseExp(exp,parseRes));
		}
		varDecl.setType(resolve(type));
		return varDecl;
	}
	
	public VariableAssignment buildVariableAssignement(String name, RExpressionContext exp, ParseResult<ModelUnit> parseRes) {
		VariableAssignment varAssign = implemFactory. createVariableAssignment();
		varAssign.setName(name);
		varAssign.setValue(parseExp(exp,parseRes));
		return varAssign; 
	}
	
	public If buildIf(RExpressionContext condition, Block thenBlock, Block elseBlock, ParseResult<ModelUnit> parseRes) {
		If ifStmt = implemFactory.createIf();
		ifStmt.setCondition(parseExp(condition,parseRes));
		ifStmt.setThen(thenBlock);
		ifStmt.setElse(elseBlock);
		return ifStmt;
	}
	
	public Block buildBlock(List<Statement> statements) {
		Block block = implemFactory.createBlock();
		block.getStatements().addAll(statements);
		return block;
	}
	
	public ExpressionStatement buildExpressionStatement(RExpressionContext value, ParseResult<ModelUnit> parseRes) {
		ExpressionStatement exp = implemFactory.createExpressionStatement();
		exp.setExpression(parseExp(value,parseRes));
		return exp;
	}
	
	public ForEach buildForEach(String variable, RExpressionContext expression, Block body, ParseResult<ModelUnit> parseRes) {
		ForEach loop = implemFactory.createForEach();
		loop.setVariable(variable);
		loop.setCollectionExpression(parseExp(expression,parseRes));
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
	
	public While buildWhile(RExpressionContext expression, Block body, ParseResult<ModelUnit> parseRes) {
		While loop = implemFactory.createWhile();
		loop.setCondition(parseExp(expression,parseRes));
		loop.setBody(body);
		return loop;
	}
	
	public FeatureAssignment buildFeatureAssign(ExpressionContext target, String feature, RExpressionContext valueExp, ParseResult<ModelUnit> parseRes) {
		FeatureAssignment featSetting = implemFactory.createFeatureAssignment();
		featSetting.setTarget(parseAQL(target,parseRes));
		featSetting.setTargetFeature(feature);
		featSetting.setValue(parseExp(valueExp,parseRes));
		return featSetting;
	}
	
	public FeatureInsert buildFeatureInsert(ExpressionContext target, String feature, ExpressionContext valueExp, ParseResult<ModelUnit> parseRes) {
		FeatureInsert featSetting = implemFactory.createFeatureInsert();
		featSetting.setTarget(parseAQL(target,parseRes));
		featSetting.setTargetFeature(feature);
		featSetting.setValue(parseAQL(valueExp,parseRes));
		return featSetting;
	}
	
	public FeatureRemove buildFeatureRemove(ExpressionContext target, String feature, ExpressionContext valueExp, ParseResult<ModelUnit> parseRes) {
		FeatureRemove featSetting = implemFactory.createFeatureRemove();
		featSetting.setTarget(parseAQL(target,parseRes));
		featSetting.setTargetFeature(feature);
		featSetting.setValue(parseAQL(valueExp,parseRes));
		return featSetting;
	}
	
	public FeaturePut buildFeaturePut(ExpressionContext target, String feature, ExpressionContext keyExp, ExpressionContext valueExp, ParseResult<ModelUnit> parseRes) {
		FeaturePut featSetting = implemFactory.createFeaturePut();
		featSetting.setTarget(parseAQL(target,parseRes));
		featSetting.setTargetFeature(feature);
		featSetting.setKey(parseAQL(keyExp,parseRes));
		featSetting.setValue(parseAQL(valueExp,parseRes));
		return featSetting;
	}
	
	public ExtendedClass buildExtendedClass(String baseCls, List<Attribute> attributes, List<Method> operations, List<String> extendedCls) {
		ExtendedClass cls = implemFactory.createExtendedClass();
		EClassifier resolvedType = resolve(baseCls);
		if(resolvedType instanceof EClass)
			cls.setBaseClass((EClass)resolvedType);
		cls.getMethods().addAll(operations);
		cls.getAttributes().addAll(attributes);
		cls.setName(baseCls);
		
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
		newPkg.setNsPrefix(segments[0]);
		newPkg.setNsURI(RUNTIME_ALE_NSURI+segments[0]);
		
		int i = 1;
		EPackage parent = newPkg;
		while(i < segments.length) {
			String segment = segments[i];
			EPackage subPkg = (EPackage) EcoreUtil.create(ePkgClass);
			subPkg.setName(segment);
			parent.getESubpackages().add(subPkg);
			subPkg.setNsPrefix(segment);
			subPkg.setNsURI(parent.getNsURI()+"/"+segment);
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
			attr.setFeatureRef(featureCopy);
			
		});
		
		clsDef
		.getMethods()
		.stream()
		.forEach(mtd -> {
			if(mtd.getOperationRef() != null) {
				EOperation newOp = EcoreUtil.copy(mtd.getOperationRef());
				cls.getEOperations().add(newOp);
				mtd.setOperationRef(newOp);
			}
		});
	}
	
	//Can return null
	public Optional<EOperation> resolve(String className, String methodName, int nbArgs, RTypeContext returnType) {
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
	
	public EClassifier resolve(RTypeContext type) {
		TypeLiteralContext typeLit = type.typeLiteral();
		if(typeLit != null) {
			AstResult astResult = builder.build(type.getText());
			EvaluationResult evaluationResult = aqlEngine.eval(astResult, Maps.newHashMap());
			Object result = evaluationResult.getResult();
			
			if(result == java.lang.String.class)
				return EcorePackage.eINSTANCE.getEString();
			else if(result == java.lang.Integer.class)
				return EcorePackage.eINSTANCE.getEInt();
			else if(result == java.lang.Double.class)
				return EcorePackage.eINSTANCE.getEDouble();
			else if(result == java.lang.Boolean.class)
				return EcorePackage.eINSTANCE.getEBoolean();
			else if(result == List.class)
				return EcorePackage.eINSTANCE.getEEList();
			else if(result == Set.class)
				return EcorePackage.eINSTANCE.getEEList();
			else if(result instanceof EClassifier) {
				return (EClassifier) result;
			}
			//TODO: else error
		}
		
		return resolve(type.getText()); //default
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
	
	public Expression parseExp(RExpressionContext ctx, ParseResult<ModelUnit> parseRes) {
		
		if(ctx.rSwitch() != null) {
			return parseSwitch(ctx.rSwitch(), parseRes);
		}
		else {
			return parseAQL(ctx.expression(), parseRes);
		}
	}
	
	public Expression parseSwitch(RSwitchContext ctx, ParseResult<ModelUnit> parseRes) {
		
		Switch switchExp = implemFactory.createSwitch();
		
		RExpressionContext paramVal = ctx.paramVal;
		List<RCaseContext> cases = ctx.cases;
		RExpressionContext defaultExp = ctx.other;
		
		switchExp.setParam(parseExp(paramVal, parseRes));
		switchExp.setDefault(parseExp(defaultExp, parseRes));
		cases.forEach(caseCtx -> {
			Case newCase = implemFactory.createCase();
			if(caseCtx.guard != null){
				newCase.setGuard(resolve(caseCtx.guard));
			}
			if(caseCtx.match != null){
				newCase.setMatch(parseExp(caseCtx.match, parseRes));
			}
			//TODO: guard & match can't be null together -> raise error
			newCase.setValue(parseExp(caseCtx.value, parseRes));
			switchExp.getCases().add(newCase);
		});
		
		/*
		 * Trick to register a new variable in the variable stack
		 * since we can't access private field of AstEvaluator
		 */
		if(ctx.paramName != null) {
			String paramName = ctx.paramName.getText();
			Let let = aqlFactory.createLet(); 
			Binding binding = aqlFactory.createBinding();
			binding.setName(paramName);
			binding.setValue(switchExp.getParam());
			let.getBindings().add(binding);
			let.setBody(switchExp);
			
			// Because paramVal is contained in Let,
			// now the switch expression is paramName
			AstResult astRes = builder.build(paramName);
			Expression param = astRes.getAst();
			switchExp.setParam(param);
			return let;
		}
		
		return switchExp;
	}
	
	public Expression parseAQL(ExpressionContext ctx, ParseResult<ModelUnit> parseRes) {
		
		//Parse with AQL
		String text = safeGetText(ctx);
		AstResult astRes = builder.build(text);
		Expression res = astRes.getAst();
		
		//Update offsets
		parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
		parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
		
		int startOffset = ctx.start.getStartIndex();
		TreeIterator<EObject> allSubExp = res.eAllContents();
		allSubExp.forEachRemaining(subExp -> {
			if(subExp instanceof Expression){
				int relativeStart = astRes.getStartPosition((Expression) subExp);
				int relativeEnd = astRes.getEndPosition((Expression) subExp);
				if(relativeStart != -1 && relativeEnd != -1) {
					parseRes.getStartPositions().put(subExp,relativeStart + startOffset);
					parseRes.getEndPositions().put(subExp,relativeEnd + startOffset);
				}
			}
			
		});
		
		return res;
	}
	
	/**
	 * Get the original text to keep white spaces
	 */
	public static String safeGetText(ExpressionContext exp) {
	    Interval interval = new Interval(exp.start.getStartIndex(),exp.stop.getStopIndex());
		return exp.start.getInputStream().getText(interval);
	}
}