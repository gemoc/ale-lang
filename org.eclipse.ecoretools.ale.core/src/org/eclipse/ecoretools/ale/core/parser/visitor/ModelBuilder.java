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
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.ast.AstFactory;
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
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.Lists;

<<<<<<< HEAD:lang.core/src/lang/core/parser/visitor/ModelBuilder.java
import implementation.Behaviored;
import implementation.Block;
import implementation.ExpressionStatement;
import implementation.ExtendedClass;
import implementation.FeatureAssignment;
import implementation.FeatureInsert;
import implementation.FeaturePut;
import implementation.FeatureRemove;
import implementation.ForEach;
import implementation.If;
import implementation.Implementation;
import implementation.ImplementationFactory;
import implementation.Method;
import implementation.RuntimeClass;
import implementation.Statement;
import implementation.VariableAssignment;
import implementation.VariableDeclaration;
import implementation.While;
=======
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
>>>>>>> master:org.eclipse.ecoretools.ale.core/src/org/eclipse/ecoretools/ale/core/parser/visitor/ModelBuilder.java

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
		ETypedElement type;

		public Parameter(String name, ETypedElement type) {
			this.name = name;
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public ETypedElement getType() {
			return type;
		}
	}

	IQueryEnvironment qryEnv;
	QueryBuilderEngine builder;

	ImplementationFactory factory;
	EcoreFactory ecoreFactory;
	AstFactory aqlFactory;

	public ModelBuilder(IQueryEnvironment qryEnv) {
		this.qryEnv = qryEnv;
		builder = new QueryBuilderEngine(qryEnv);

		ecoreFactory = (EcoreFactory) qryEnv.getEPackageProvider().getEPackage("ecore").iterator().next()
				.getEFactoryInstance();
		factory = (ImplementationFactory) qryEnv.getEPackageProvider().getEPackage("implementation").iterator().next()
				.getEFactoryInstance();
		aqlFactory = (AstFactory) qryEnv.getEPackageProvider().getEPackage("ast").iterator().next()
				.getEFactoryInstance();
	}

	public Method buildMethod(String name, List<Parameter> params, String returnType, Block body, List<String> tags) {
		final EOperation operation = ecoreFactory.createEOperation();
		operation.setName(name);

		params.stream().forEach(p -> {
			final EParameter opParam = ecoreFactory.createEParameter();
			opParam.setName(p.getName());
			opParam.setEType(p.getType().getEType());
			opParam.setEGenericType(p.getType().getEGenericType());
			operation.getEParameters().add(opParam);
		});

		final ETypedElement type = resolve(returnType);
		operation.setEType(type.getEType());
		operation.setEGenericType(type.getEGenericType());

		final Method newMethod = factory.createMethod();
		newMethod.setOperationDef(operation);
		newMethod.setBody(body);
		newMethod.getTags().addAll(tags);

		return newMethod;
	}

	public Implementation buildImplementation(String containingClass, String name, List<Parameter> params,
			String returnType, Block body, List<String> tags) {
		Optional<EOperation> existingOperation = resolve(containingClass, name, params.size(), returnType);

		if (!existingOperation.isPresent()) {
			// TODO: error
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
		VariableDeclaration varDecl = factory.createVariableDeclaration();
		varDecl.setName(name);
		if (exp != null) {
			varDecl.setInitialValue(builder.build(exp).getAst());
		}
		varDecl.setType(resolve(type));
		return varDecl;
	}

	public VariableAssignment buildVariableAssignement(String name, String exp) {
		VariableAssignment varAssign = factory.createVariableAssignment();
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

	public ExtendedClass buildExtendedClass(String baseCls, List<VariableDeclaration> vars, List<Behaviored> operations,
			List<String> extendedCls) {
		ExtendedClass cls = factory.createExtendedClass();
		ETypedElement resolvedType = resolve(baseCls);
		if (resolvedType.getEType() instanceof EClass)
			cls.setBaseClass((EClass) resolvedType.getEType());
		cls.getMethods().addAll(operations);
		cls.getAttributes().addAll(vars);

		// Add metadata for ID to be resolved
		extendedCls.stream().forEach(xtd -> {
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

		try {
			int min = Integer.parseInt(left);
			int max = Integer.parseInt(right);

			if (min <= max) {
				for (int i = min; i <= max; i++) {
					IntegerLiteral item = aqlFactory.createIntegerLiteral();
					item.setValue(i);
					seq.getValues().add(item);
				}
			} else {
				for (int i = min; i >= max; i--) {
					IntegerLiteral item = aqlFactory.createIntegerLiteral();
					item.setValue(i);
					seq.getValues().add(item);
				}
			}
		} catch (NumberFormatException e) {
			// TODO: complain here
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
		while (i < segments.length) {
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

		cls.getAttributes().stream().forEach(attr -> {
			String name = attr.getName();
			ETypedElement type = attr.getType();

			if (type.getEType() instanceof EClass) {
				EReference newRef = (EReference) EcoreUtil.create(eRefClass);
				newRef.setName(name);
				newRef.setEType(type.getEType());
				res.getEReferences().add(newRef);
			} else if (type.getEType() instanceof EDataType) {
				EAttribute newAttr = (EAttribute) EcoreUtil.create(eAttClass);
				newAttr.setName(name);
				newAttr.setEType(type.getEType());
				res.getEAttributes().add(newAttr);
			}
		});

		cls.getMethods().stream().forEach(mtd -> {
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
		ETypedElement type = resolve(returnType);
		// TODO: manage qualified name
		Optional<EOperation> eOperation = qryEnv.getEPackageProvider().getEClassifiers().stream()
				.filter(cls -> cls instanceof EClass).filter(cls -> cls.getName().equals(className))
				.flatMap(cls -> ((EClass) cls).getEOperations().stream()).filter(op -> op.getName().equals(methodName)
						&& op.getEParameters().size() == nbArgs && op.getEType() == type)
				.findFirst();

		return eOperation;
	}

	public ETypedElement resolve(String clazzName) {

		// TODO: hacky, cleanup needed !
		if (clazzName.contains("::") && !(clazzName.contains("(") || clazzName.contains(")")))
			clazzName = clazzName.split("::")[1];

		final String className = clazzName;

		int lastDotIndex = className.lastIndexOf(".");
		if (lastDotIndex != -1 && lastDotIndex < className.length()) {
			String simpleName = className.substring(lastDotIndex + 1);

			Collection<EClassifier> clsCandidates = qryEnv.getEPackageProvider().getTypes(simpleName);

			Optional<EClassifier> foundCls = clsCandidates.stream().filter(c -> getQualifiedName(c).equals(className))
					.findFirst();
			if (foundCls.isPresent()) {
				final EAttribute ret = EcoreFactory.eINSTANCE.createEAttribute();
				ret.setEType(foundCls.get());
				return ret;
			}
		}

		Optional<EClassifier> candidate = qryEnv.getEPackageProvider().getEClassifiers().stream()
				.filter(cls -> !cls.getEPackage().getName().equals("implementation"))
				.filter(cls -> cls.getName().equals(className)).findFirst();

		if (candidate.isPresent()) {
			final EAttribute ret = EcoreFactory.eINSTANCE.createEAttribute();
			EClassifier value = candidate.get();
			ret.setEType(value);
			ret.getEType().setInstanceClassName(value.getEPackage().getName() + "." + value.getName());
			return ret;

		}

		// NOTE: Minial implementation for my needs.
		if (className.startsWith("Sequence(")) {
			final EAttribute ret = EcoreFactory.eINSTANCE.createEAttribute();
			ret.setName("tmp");
			ret.setEType(EcorePackage.eINSTANCE.getEEList());

			String substring = className.substring("Sequence(".length(), className.length() - 1);
			List<String> asList = Arrays.asList(substring.split(","));
			final List<EGenericType> collect = asList.stream().map(t -> {
				return resolve(t);
			}).map(t -> {
				final EGenericType eTypeArgument = EcoreFactory.eINSTANCE.createEGenericType();
				eTypeArgument.setEClassifier(t.getEType());
				return eTypeArgument;
			}).collect(Collectors.toList());

			ret.getEGenericType().getETypeArguments().addAll(collect);
			return ret;
		}

		if (className.startsWith("OrderedSet(")) {

		}

		EClassifier primitiveType;
		switch (className) {
		case "String": {
			primitiveType = EcorePackage.eINSTANCE.getEString();
			break;
		}
		case "boolean": {
			primitiveType = EcorePackage.eINSTANCE.getEBoolean();
			break;
		}
		case "byte": {
			primitiveType = EcorePackage.eINSTANCE.getEByte();
			break;
		}
		case "char": {
			primitiveType = EcorePackage.eINSTANCE.getEChar();
			break;
		}
		case "short": {
			primitiveType = EcorePackage.eINSTANCE.getEShort();
			break;
		}
		case "int": {
			primitiveType = EcorePackage.eINSTANCE.getEInt();
			break;
		}
		case "long": {
			primitiveType = EcorePackage.eINSTANCE.getELong();
			break;
		}
		case "float": {
			primitiveType = EcorePackage.eINSTANCE.getEFloat();
			break;
		}
		case "double": {
			primitiveType = EcorePackage.eINSTANCE.getEDouble();
			break;
		}
		case "void": {
			primitiveType = null;
			break;
		}
		default:
			throw new RuntimeException("Unknow type");
		}

		final EAttribute ret = EcoreFactory.eINSTANCE.createEAttribute();
		ret.setEType(primitiveType);
		return ret;
	}

	public static String getQualifiedName(EClassifier cls) {

		List<String> fullName = new ArrayList<String>();

		fullName.add(cls.getName());

		EPackage current = cls.getEPackage();
		fullName.add(current.getName());
		while (current.getESuperPackage() != null) {
			current = current.getESuperPackage();
			fullName.add(current.getName());
		}

		return String.join(".", Lists.reverse(fullName));
	}

	public AstResult parse(String expression) {
		return builder.build(expression);
	}
}