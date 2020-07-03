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
package org.eclipse.emf.ecoretools.ale.core.parser.internal;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.IntStream;

import org.antlr.v4.runtime.misc.Interval;
import org.eclipse.acceleo.query.ast.AstFactory;
import org.eclipse.acceleo.query.ast.Binding;
import org.eclipse.acceleo.query.ast.CollectionTypeLiteral;
import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.ast.IntegerLiteral;
import org.eclipse.acceleo.query.ast.Let;
import org.eclipse.acceleo.query.ast.SequenceInExtensionLiteral;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IQueryEvaluationEngine;
import org.eclipse.acceleo.query.runtime.QueryEvaluation;
import org.eclipse.acceleo.query.runtime.QueryParsing;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.ExpressionContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RCaseContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RExpressionContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RSwitchContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RTypeContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RVariableContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.TypeLiteralContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.core.validation.IConvertType;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.ConvertType;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.Case;
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock;
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeaturePut;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationFactory;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.Switch;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.VariableInsert;
import org.eclipse.emf.ecoretools.ale.implementation.VariableRemove;
import org.eclipse.emf.ecoretools.ale.implementation.While;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * A factory that create ALE Behaviors from elements of the AST produced by the ANTLR parser.
 * <p>
 * Said ALE Behaviors are EObject that belong to the {@link ImplementationPackage Implementation metamodel}.
 * <p>
 * This factory is used by the {@link AntlrAstToBehaviorsAstAdapter} and {@link AstVisitors} to properly turn 
 * the AST produced by the ANTLR parser into an AST fully made of ALE Behaviors.
 */
public class AntlrAstToAleBehaviorsFactory {
	
	public static AntlrAstToAleBehaviorsFactory singleton;
	public static final String PARSER_SOURCE = "http://org/eclipse/emf/ecoretools/ale/parser/metadata";
	public static final String PARSER_EXTENDS_KEY = "extends";
	public static final String PARSER_OPPOSITE_KEY = "opposite";
	public static final String RUNTIME_ALE_NSURI = "http://ale/runtime/";
	public static final String PARSER_ID = "org.eclipse.emf.ecoretools.ale";

	// FIXME [API] We can get rid of this singleton
	public static AntlrAstToAleBehaviorsFactory createSingleton(IQueryEnvironment qryEnv) {
		AntlrAstToAleBehaviorsFactory.singleton = new AntlrAstToAleBehaviorsFactory(qryEnv);
		return singleton;
	}
	
	public static class Parameter {
		
		private String name;
		private EClassifier type;
		private EGenericType genericType;
		
		/*
		 * Trick required because Parameter are not part of the final AST:
		 * 		they are replaced by method::operationRef::EParameters
		 * 
		 * This is hence used to put start & stop positions of corresponding EParameters
		 */
		RVariableContext ctx;
		
		public Parameter(String name, EClassifier type, RVariableContext ctx) {
			this(name, type, null, ctx);
		}
		
		public Parameter(String name, EClassifier type, EGenericType genericType, RVariableContext ctx) {
			this.name = name;
			this.type = type;
			this.genericType = genericType;
			this.ctx = ctx;
		}
		
		public String getName() {
			return name;
		}
		
		public EClassifier getType() {
			return type;
		}
		
		public Optional<EGenericType> getGenericType() {
			return Optional.ofNullable(genericType);
		}

		public RVariableContext getCtx() {
			return ctx;
		}
	}
	
	private final IQueryEnvironment qryEnv;
	private final IQueryBuilderEngine builder;
	private final IQueryEvaluationEngine aqlEngine;
	
	private final ImplementationFactory implemFactory;
	private final EcoreFactory ecoreFactory;
	private final AstFactory aqlFactory;
	
	private final IConvertType convert;
	
	AntlrAstToAleBehaviorsFactory(IQueryEnvironment qryEnv) {
		this.qryEnv = qryEnv;
		builder = QueryParsing.newBuilder(qryEnv);
		aqlEngine = QueryEvaluation.newEngine(qryEnv);
		
		ecoreFactory = (EcoreFactory) qryEnv.getEPackageProvider().getEPackage("ecore").iterator().next().getEFactoryInstance();
		implemFactory = (ImplementationFactory) qryEnv.getEPackageProvider().getEPackage("implementation").iterator().next().getEFactoryInstance();
		aqlFactory = (AstFactory) qryEnv.getEPackageProvider().getEPackage("ast").iterator().next().getEFactoryInstance();
		
		convert = new ConvertType(qryEnv);
	}
	
	public Method buildMethod(EClass fragment, String name, List<Parameter> params, RTypeContext returnType, Block body, List<String> tags) {
		EOperation operation = ecoreFactory.createEOperation();
		operation.setName(name);
		
		params.stream().forEach(p -> {
			EParameter opParam = ecoreFactory.createEParameter();
			opParam.setName(p.getName());
			opParam.setEType(p.getType());
			p.getGenericType().ifPresent(t -> opParam.getEGenericType().getETypeArguments().add(t));
			
			operation.getEParameters().add(opParam);
		});
		
		ETypedElement type = resolve(returnType);
		operation.setEType(type.getEType());
		operation.setUnique(type.isUnique());
		operation.setLowerBound(type.getLowerBound());
		operation.setUpperBound(type.getUpperBound());

		fragment.getEOperations().add(operation);
		
		return buildMethod(operation,body,tags);
	}
	
	public Method buildMethod(EOperation operation, Block body, List<String> tags) {
		Method newMethod = implemFactory.createMethod();
		newMethod.setOperationRef(operation);
		newMethod.setBody(body);
		newMethod.getTags().addAll(tags);
		
		if (operation != null && operation.getEType() == null) {
//			operation.setEType(ImplementationPackage.eINSTANCE.getVoidEClassifier());
		}
		return newMethod;
	}
	
	public Method buildImplementation(String containingClass, String name, List<Parameter> params, RTypeContext returnType, Block body, List<String> tags) {
		Optional<EOperation> existingOperation = resolve(containingClass, name, params.size(), returnType);
		
		if(!existingOperation.isPresent()){
			return buildMethod(null,body,tags);
		}
		
		return buildMethod(existingOperation.get(),body,tags);
	}
	
	
	
	public Parameter buildParameter(RTypeContext type, String name, RVariableContext ctx) {
		ETypedElement typedElement = resolve(type);
		
		// FIXME This is a hack: parameters should have bounds and isUnique such as Attribute
		//		 Currently we can't represent Sets and nested Lists
		
		if (typedElement.isMany()) {
			EGenericType genericType = EcoreFactory.eINSTANCE.createEGenericType();
			genericType.setEClassifier(typedElement.getEType());
			return new Parameter(name, EcorePackage.eINSTANCE.getEEList(), genericType, ctx);
		}
		else {
			return new Parameter(name, typedElement.getEType(), typedElement.getEGenericType(), ctx);
		}
	}
	
	public Attribute buildAttribute(EClass fragment, String name, RExpressionContext exp, RTypeContext type, int lowerBound, int upperBound, boolean isContainment, boolean isUnique, String opposite, ParsedFile<ModelUnit> parseRes) {
		Attribute attribute = implemFactory.createAttribute();
		EStructuralFeature feature;
		
		
		ETypedElement featureType = resolve(type);
		if((featureType.getEType() instanceof EClass) || isContainment) {
			feature = ecoreFactory.createEReference();
			((EReference)feature).setContainment(isContainment);
		}
		else {
			feature = ecoreFactory.createEAttribute();
		}
		
		feature.setName(name);
		// 
		// Given 'isUnique' property takes precedence because it has been specified in the code, e.g.:
		//
		//		contains fsm::FSM parent
		//
		isUnique = isUnique ? isUnique : featureType.isUnique();
		// 
		// Given bounds take precedence because they have been specified in the code, e.g.:
		//
		//		1..* fsm::State states
		//
		// FIXME Does not handle nested collections
		//
		upperBound = upperBound != 1 ? upperBound : featureType.getUpperBound();
		lowerBound = lowerBound != 0 ? lowerBound : featureType.getLowerBound();
		
		feature.setUnique(isUnique);
		feature.setEType(featureType.getEType());
		feature.setLowerBound(lowerBound);
		feature.setUpperBound(upperBound);

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
		
		return attribute;
	}
	
	public VariableDeclaration buildVariableDecl(String name, RExpressionContext exp, RTypeContext type, ParsedFile<ModelUnit> parseRes) {
		VariableDeclaration varDecl = implemFactory.createVariableDeclaration();
		varDecl.setName(name);
		if(exp != null){
			varDecl.setInitialValue(parseExp(exp,parseRes));
		}
		ETypedElement declaredType = resolve(type);
		varDecl.setType(declaredType);
		
		return varDecl;
	}
	
	public VariableAssignment buildVariableAssignement(String name, RExpressionContext exp, ParsedFile<ModelUnit> parseRes) {
		VariableAssignment varAssign = implemFactory. createVariableAssignment();
		varAssign.setName(name);
		varAssign.setValue(parseExp(exp,parseRes));
		return varAssign; 
	}
	
	public If buildIf(List<ConditionalBlock> cBlocks, Block elseBlock, ParsedFile<ModelUnit> parseRes) {
		If ifStmt = implemFactory.createIf();
		ifStmt.getBlocks().addAll(cBlocks);
		ifStmt.setElse(elseBlock);
		return ifStmt;
	}
	
	public ConditionalBlock buildConditionalBlock(RExpressionContext condition, Block block, ParsedFile<ModelUnit> parseRes) {
		ConditionalBlock cBlock = implemFactory.createConditionalBlock();
		cBlock.setCondition(parseExp(condition,parseRes));
		cBlock.setBlock(block);
		return cBlock;
		
	}
	
	public Block buildBlock(List<Statement> statements) {
		Block block = implemFactory.createBlock();
		block.getStatements().addAll(statements);
		return block;
	}
	
	public ExpressionStatement buildExpressionStatement(RExpressionContext value, ParsedFile<ModelUnit> parseRes) {
		ExpressionStatement exp = implemFactory.createExpressionStatement();
		exp.setExpression(parseExp(value,parseRes));
		return exp;
	}
	
	public ForEach buildForEach(String variable, RExpressionContext expression, Block body, ParsedFile<ModelUnit> parseRes) {
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
	
	public While buildWhile(RExpressionContext expression, Block body, ParsedFile<ModelUnit> parseRes) {
		While loop = implemFactory.createWhile();
		loop.setCondition(parseExp(expression,parseRes));
		loop.setBody(body);
		return loop;
	}
	
	
	public VariableInsert buildVariableInsert(String name, RExpressionContext exp, ParsedFile<ModelUnit> parseRes) {
		VariableInsert varInsert = implemFactory. createVariableInsert();
		varInsert.setName(name);
		varInsert.setValue(parseExp(exp,parseRes));
		return varInsert; 
	}
	
	public VariableRemove buildVariableRemove(String name, RExpressionContext exp, ParsedFile<ModelUnit> parseRes) {
		VariableRemove varRemove = implemFactory. createVariableRemove();
		varRemove.setName(name);
		varRemove.setValue(parseExp(exp,parseRes));
		return varRemove; 
	}
	
	public FeatureAssignment buildFeatureAssign(ExpressionContext target, String feature, RExpressionContext valueExp, ParsedFile<ModelUnit> parseRes) {
		FeatureAssignment featSetting = implemFactory.createFeatureAssignment();
		featSetting.setTarget(parseAQL(target,parseRes));
		featSetting.setTargetFeature(feature);
		featSetting.setValue(parseExp(valueExp,parseRes));
		return featSetting;
	}
	
	public FeatureInsert buildFeatureInsert(ExpressionContext target, String feature, ExpressionContext valueExp, ParsedFile<ModelUnit> parseRes) {
		FeatureInsert featSetting = implemFactory.createFeatureInsert();
		featSetting.setTarget(parseAQL(target,parseRes));
		featSetting.setTargetFeature(feature);
		featSetting.setValue(parseAQL(valueExp,parseRes));
		return featSetting;
	}
	
	public FeatureRemove buildFeatureRemove(ExpressionContext target, String feature, ExpressionContext valueExp, ParsedFile<ModelUnit> parseRes) {
		FeatureRemove featSetting = implemFactory.createFeatureRemove();
		featSetting.setTarget(parseAQL(target,parseRes));
		featSetting.setTargetFeature(feature);
		featSetting.setValue(parseAQL(valueExp,parseRes));
		return featSetting;
	}
	
	public FeaturePut buildFeaturePut(ExpressionContext target, String feature, ExpressionContext keyExp, ExpressionContext valueExp, ParsedFile<ModelUnit> parseRes) {
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
		clsDef.getAttributes().stream()
			  .forEach(attr -> {
				  EStructuralFeature featureCopy = EcoreUtil.copy(attr.getFeatureRef());
				  cls.getEStructuralFeatures().add(featureCopy);
				  attr.setFeatureRef(featureCopy);
			  });
		
		clsDef.getMethods().stream()
			  .forEach(mtd -> {
				  if (mtd.getOperationRef() != null) {
					  EOperation newOp = EcoreUtil.copy(mtd.getOperationRef());
					  cls.getEOperations().add(newOp);
					  mtd.setOperationRef(newOp);
				  }
			  });
	}
	
	//Can return null
	public Optional<EOperation> resolve(String className, String methodName, int nbArgs, RTypeContext returnType) {
		EClassifier type = resolve(returnType).getEType();
		//TODO: manage qualified name		
		return qryEnv.getEPackageProvider()
					 .getEClassifiers().stream()
					 .filter(cls -> cls instanceof EClass)
					 .filter(cls -> cls.getName().equals(className))
					 .flatMap(cls -> ((EClass)cls).getEOperations().stream())
					 .filter(op -> op.getName().equals(methodName) && op.getEParameters().size() == nbArgs && op.getEType() == type)
					 .findFirst();
	}
	
	public EClassifier resolve(String typeName) {
		String className = typeName.replaceAll("::", ".");
		
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
			// FIXME Should return all candidates to outline the fact that namesakes
			// 		 have been found & allow to address the issue thereafter in validators
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
			case "Double"   : return EcorePackage.eINSTANCE.getEDouble();
			case "void"		: return ImplementationPackage.eINSTANCE.getVoidEClassifier();
			default			: return ImplementationPackage.eINSTANCE.getUnresolvedEClassifier();
		}
	}
	
	public ETypedElement resolve(RTypeContext type) {
		TypeLiteralContext typeLit = type.typeLiteral();
		if(typeLit != null) {
			AstResult astResult = builder.build(type.getText());
			EvaluationResult evaluationResult = aqlEngine.eval(astResult, Maps.newHashMap());
			Object result = evaluationResult.getResult();
			
			if (astResult.getAst() instanceof CollectionTypeLiteral) {
				CollectionTypeLiteral aqlCollection = (CollectionTypeLiteral) astResult.getAst();
				boolean isUnique = Set.class.equals(aqlCollection.getValue());
				EClassifier classifier = convert.toEMF(aqlCollection.getElementType()).orElse(ImplementationPackage.eINSTANCE.getUnresolvedEClassifier());
				return createRawType(classifier, isUnique, 0, -1);
			}
			else if (result instanceof EClassifier) {
				return createRawType((EClassifier) result, false, 0, 1);
			}
			else if (result instanceof Class<?>) {	
				EClassifier classifier = convert.toEMF((Class<?>) result);
				return createRawType(classifier, false, 0, 1);
			}
		}
		return createRawType(resolve(type.getText()), false, 0, 1); //default
	}
	
	private static ETypedElement createRawType(EClassifier classifier, boolean isUnique, int lowerBound, int upperBound) {
		ETypedElement element = EcoreFactory.eINSTANCE.createEAttribute();
		element.setEType(classifier);
		element.setUnique(isUnique);
		element.setLowerBound(lowerBound);
		element.setUpperBound(upperBound);
		return element;
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
	
	public Expression parseExp(RExpressionContext ctx, ParsedFile<ModelUnit> parseRes) {
		if(ctx.rSwitch() != null) {
			return parseSwitch(ctx.rSwitch(), parseRes);
		}
		else {
			return parseAQL(ctx.expression(), parseRes);
		}
	}
	
	public Expression parseSwitch(RSwitchContext ctx, ParsedFile<ModelUnit> parseRes) {
		Switch switchExp = implemFactory.createSwitch();
		
		RExpressionContext paramVal = ctx.paramVal;
		List<RCaseContext> cases = ctx.cases;
		RExpressionContext defaultExp = ctx.other;
		
		switchExp.setParam(parseExp(paramVal, parseRes));
		switchExp.setDefault(parseExp(defaultExp, parseRes));
		cases.forEach(caseCtx -> {
			Case newCase = implemFactory.createCase();
			if(caseCtx.guard != null){
				newCase.setGuard(resolve(caseCtx.guard).getEType());
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
	
	public Expression parseAQL(ExpressionContext ctx, ParsedFile<ModelUnit> parseRes) {
		//Parse with AQL
		String text = safeGetText(ctx);
		AstResult astRes = builder.build(text);
		Expression res = astRes.getAst();
		
		// FIXME Attempt to use ctx.start.getText to directly set the text in parseRes
		
		//Update offsets
		parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
		parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
		
		List<Integer> lines = IntStream.rangeClosed(ctx.start.getLine(), ctx.stop.getLine()).boxed()
									   .collect(toList());
		
		parseRes.setLines(res, lines);
		
		int startOffset = ctx.start.getStartIndex();
		TreeIterator<EObject> allSubExp = res.eAllContents();
		allSubExp.forEachRemaining(subExp -> {
			if (subExp instanceof Expression) {
				int relativeStart = astRes.getStartPosition((Expression) subExp);
				int relativeEnd = astRes.getEndPosition((Expression) subExp);
				if(relativeStart != -1 && relativeEnd != -1) {
					parseRes.getStartPositions().put(subExp,relativeStart + startOffset);
					parseRes.getEndPositions().put(subExp,relativeEnd + startOffset);
					parseRes.setLines(subExp, lines);
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