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
package org.eclipse.emf.ecoretools.ale.core.parser.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.ast.BooleanLiteral;
import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.ast.IntegerLiteral;
import org.eclipse.acceleo.query.ast.RealLiteral;
import org.eclipse.acceleo.query.ast.SequenceInExtensionLiteral;
import org.eclipse.acceleo.query.ast.TypeLiteral;
import org.eclipse.acceleo.query.ast.VarRef;
import org.eclipse.acceleo.query.parser.AstBuilderListener;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.core.parser.AstBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.Assignment;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.While;
import org.junit.Before;
import org.junit.Test;

/**
 * This class checks the structure of the ModelBehavior produced by the parser
 */
public class BuildTest {
	
	IQueryEnvironment queryEnvironment;
	AstBuilder parser;
	
	@Before
	public void setup() {
		queryEnvironment = Query.newEnvironmentWithDefaultServices(null);
		queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE);
		queryEnvironment.registerEPackage(AstPackage.eINSTANCE);
		parser = new AstBuilder(queryEnvironment);
	}
	
	@Test
	public void testClassExtension() {
		ParseResult<ModelUnit> res = parse("input/structure/extendedClass.implem");
		ModelUnit root = res.getRoot();
		
		assertNotNull(root);
		assertEquals("test.extendedclass",root.getName());
		assertEquals(0, root.getServices().size());
		assertEquals(1, root.getClassExtensions().size());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(0, xtdCls.getAttributes().size());
		assertEquals(0, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), xtdCls.getBaseClass());
	}
	
	@Test
	public void testAttributes() {
		ParseResult<ModelUnit> res = parse("input/structure/attributes.implem");
		ModelUnit root = res.getRoot();
		
		assertNotNull(root);
		assertEquals("test.attributes",root.getName());
		assertEquals(0, root.getServices().size());
		assertEquals(1, root.getClassExtensions().size());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(0, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), xtdCls.getBaseClass());
		assertEquals(2, xtdCls.getAttributes().size());
		
		Attribute attrib0 = xtdCls.getAttributes().get(0);
		assertEquals("newAttribute", attrib0.getFeatureRef().getName());
		assertEquals(EcorePackage.eINSTANCE.getEBoolean(), attrib0.getFeatureRef().getEType());
		assertNull(attrib0.getInitialValue());
		
		Attribute attrib1 = xtdCls.getAttributes().get(1);
		assertEquals("initialValue", attrib1.getFeatureRef().getName());
		assertEquals(EcorePackage.eINSTANCE.getEInt(), attrib1.getFeatureRef().getEType());
		assertNotNull(attrib1.getInitialValue());
		Expression value = attrib1.getInitialValue();
		assertTrue(value instanceof IntegerLiteral);
		assertEquals(0,((IntegerLiteral)value).getValue());
	}
	
	@Test
	public void testMethod(){
		ParseResult<ModelUnit> res = parse("input/structure/defMethod.implem");
		ModelUnit root = res.getRoot();
		
		assertNotNull(root);
		assertEquals("test.defmethod",root.getName());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(1, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), xtdCls.getBaseClass());
		assertEquals(0, xtdCls.getAttributes().size());
		
		Method method = xtdCls.getMethods().get(0);
		assertTrue(method instanceof Method);
		EOperation eOperationDef = ((Method)method).getOperationRef();
		assertNotNull(eOperationDef);
		assertEquals("fooBar",eOperationDef.getName());
		assertNull(eOperationDef.getEType());
		assertEquals(2, eOperationDef.getEParameters().size());
		assertEquals("param1", eOperationDef.getEParameters().get(0).getName());
		assertEquals(EcorePackage.eINSTANCE.getEObject(), eOperationDef.getEParameters().get(0).getEType());
		assertEquals("param2", eOperationDef.getEParameters().get(1).getName());
		assertEquals(EcorePackage.eINSTANCE.getEDouble(), eOperationDef.getEParameters().get(1).getEType());
		
		Block body = ((Method)method).getBody();
		assertNotNull(body);
		assertEquals(2, body.getStatements().size());
		Statement local0 = body.getStatements().get(0);
		Statement local1 = body.getStatements().get(1);
		assertTrue(local0 instanceof VariableDeclaration);
		assertEquals("localVariable",((VariableDeclaration)local0).getName());
		assertEquals(EcorePackage.eINSTANCE.getEBoolean(),((VariableDeclaration)local0).getType());
		assertNull(((VariableDeclaration)local0).getInitialValue());
		assertTrue(local1 instanceof VariableDeclaration);
		assertEquals("loacalValue",((VariableDeclaration)local1).getName());
		assertEquals(EcorePackage.eINSTANCE.getEDouble(),((VariableDeclaration)local1).getType());
		assertNotNull(((VariableDeclaration)local1).getInitialValue());
		Expression value = ((VariableDeclaration)local1).getInitialValue();
		assertTrue(value instanceof Call);
		assertEquals(AstBuilderListener.ADD_SERVICE_NAME,((Call)value).getServiceName());
		assertEquals(2,((Call)value).getArguments().size());
		Expression left = ((Call)value).getArguments().get(0);
		Expression right = ((Call)value).getArguments().get(1);
		assertTrue(left instanceof VarRef);
		assertEquals("param2", ((VarRef)left).getVariableName());
		assertTrue(right instanceof RealLiteral);
		assertEquals(2.0, ((RealLiteral)right).getValue(),0);
	}
	
	@Test
	public void testImplem() {
		ParseResult<ModelUnit> res = parse("input/structure/defImplem.implem");
		ModelUnit root = res.getRoot();
		
		assertNotNull(root);
		assertEquals("test.defimpl",root.getName());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(1, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEObject(), xtdCls.getBaseClass());
		assertEquals(0, xtdCls.getAttributes().size());
		
		Method method = xtdCls.getMethods().get(0);
		assertEquals(xtdCls.getBaseClass(),method.getOperationRef().getEContainingClass());
		EOperation eOperationRef = method.getOperationRef();
		assertNotNull(eOperationRef);
		assertEquals("eClass",eOperationRef.getName());
		assertEquals(EcorePackage.eINSTANCE.getEObject(),eOperationRef.getEContainingClass());
		
		Block body = method.getBody();
		assertNotNull(body);
		assertEquals(2, body.getStatements().size());
		Statement local0 = body.getStatements().get(0);
		assertTrue(local0 instanceof ExpressionStatement);
		assertTrue(((ExpressionStatement)local0).getExpression() instanceof Call);
		Call call = (Call) ((ExpressionStatement)local0).getExpression();
		assertEquals("log",call.getServiceName());
		assertEquals(1,call.getArguments().size());
		Expression arg = call.getArguments().get(0);
		assertTrue(arg instanceof VarRef);
		assertEquals("self", ((VarRef)arg).getVariableName());
		Statement local1 = body.getStatements().get(1);
		assertTrue(local1 instanceof VariableAssignment);
		assertEquals("result",((VariableAssignment)local1).getName());
		Expression value = ((VariableAssignment)local1).getValue();
		assertTrue(value instanceof TypeLiteral);
		assertEquals(EcorePackage.eINSTANCE.getEModelElement(),((TypeLiteral)value).getValue());
	}
	
	@Test
	public void testFor(){
		ParseResult<ModelUnit> res = parse("input/structure/for.implem");
		ModelUnit root = res.getRoot();
		
		assertNotNull(root);
		assertEquals("test.forloop",root.getName());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(1, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEPackage(), xtdCls.getBaseClass());
		assertEquals(0, xtdCls.getAttributes().size());
		
		Method method = xtdCls.getMethods().get(0);
		assertTrue(method instanceof Method);
		EOperation eOperationDef = method.getOperationRef();
		assertNotNull(eOperationDef);
		assertEquals("entryPoint",eOperationDef.getName());
		assertNull(eOperationDef.getEType());
		assertEquals(1, eOperationDef.getEParameters().size());
		assertEquals("arg", eOperationDef.getEParameters().get(0).getName());
		assertEquals(EcorePackage.eINSTANCE.getEInt(), eOperationDef.getEParameters().get(0).getEType());
		
		Block body = ((Method)method).getBody();
		assertNotNull(body);
		assertEquals(4, body.getStatements().size());
		
		Statement local0 = body.getStatements().get(0);
		assertTrue(local0 instanceof VariableDeclaration);
		assertEquals("me",((VariableDeclaration)local0).getName());
		assertEquals(EcorePackage.eINSTANCE.getEPackage(),((VariableDeclaration)local0).getType());
		Expression value = ((VariableDeclaration)local0).getInitialValue();
		assertNotNull(value);
		assertTrue(value instanceof VarRef);
		assertEquals("self",((VarRef)value).getVariableName());
		
		Statement loop1 = body.getStatements().get(1);
		assertTrue(loop1 instanceof ForEach);
		assertEquals("i", ((ForEach)loop1).getVariable());
		Expression expression = ((ForEach)loop1).getCollectionExpression();
		assertNotNull(expression);
		assertTrue(expression instanceof Call);
		assertEquals("eClassifiers", ((Call)expression).getServiceName());
		assertEquals(1, ((Call)expression).getArguments().size());
		Expression caller = ((Call)expression).getArguments().get(0);
		assertTrue(caller instanceof VarRef);
		assertEquals("self",((VarRef)caller).getVariableName());
		Block loop1Body = ((ForEach)loop1).getBody();
		assertNotNull(body);
		assertEquals(1,loop1Body.getStatements().size());
		Statement stmt = loop1Body.getStatements().get(0);
		assertTrue(stmt instanceof VariableDeclaration);
		assertEquals("o",((VariableDeclaration)stmt).getName());
		assertEquals(EcorePackage.eINSTANCE.getEObject(),((VariableDeclaration)stmt).getType());
		Expression stmtValue = ((VariableDeclaration)stmt).getInitialValue();
		assertNotNull(stmtValue);
		assertTrue(stmtValue instanceof Call);
		assertEquals("create",((Call)stmtValue).getServiceName());
		assertEquals(1,((Call)stmtValue).getArguments().size());
		Expression arg = ((Call)stmtValue).getArguments().get(0);
		assertTrue(arg instanceof TypeLiteral);
		assertEquals(EcorePackage.eINSTANCE.getEObject(),((TypeLiteral)arg).getValue());
		
		Statement loop2 = body.getStatements().get(2);
		assertTrue(loop2 instanceof ForEach);
		assertEquals("j", ((ForEach)loop2).getVariable());
		Expression expression2 = ((ForEach)loop2).getCollectionExpression();
		assertNotNull(expression2);
		assertTrue(expression2 instanceof SequenceInExtensionLiteral);
		SequenceInExtensionLiteral sequence = (SequenceInExtensionLiteral) expression2;
		assertEquals(4,sequence.getValues().size());
		assertTrue(sequence.getValues().get(0) instanceof IntegerLiteral);
		assertEquals(1, ((IntegerLiteral)sequence.getValues().get(0)).getValue());
		assertTrue(sequence.getValues().get(1) instanceof IntegerLiteral);
		assertEquals(2, ((IntegerLiteral)sequence.getValues().get(1)).getValue());
		assertTrue(sequence.getValues().get(2) instanceof IntegerLiteral);
		assertEquals(3, ((IntegerLiteral)sequence.getValues().get(2)).getValue());
		assertTrue(sequence.getValues().get(3) instanceof IntegerLiteral);
		assertEquals(4, ((IntegerLiteral)sequence.getValues().get(3)).getValue());
		Block loop2Body = ((ForEach)loop2).getBody();
		assertEquals(1,loop2Body.getStatements().size());
		Statement stmt2 = loop2Body.getStatements().get(0);
		assertTrue(stmt2 instanceof ExpressionStatement);
		Expression expression3 = ((ExpressionStatement)stmt2).getExpression();
		assertTrue(expression3 instanceof Call);
		assertEquals("log", ((Call)expression3).getServiceName());
		assertEquals(1,((Call)expression3).getArguments().size());
		assertTrue(((Call)expression3).getArguments().get(0) instanceof VarRef);
		assertEquals("j",((VarRef)((Call)expression3).getArguments().get(0)).getVariableName());
		
		Statement loop3 = body.getStatements().get(3);
		assertTrue(loop3 instanceof ForEach);
		assertEquals("k", ((ForEach)loop3).getVariable());
		Expression expression4 = ((ForEach)loop3).getCollectionExpression();
		assertNotNull(expression4);
		assertTrue(expression4 instanceof SequenceInExtensionLiteral);
		SequenceInExtensionLiteral reverseSequence = (SequenceInExtensionLiteral) expression4;
		assertEquals(3,reverseSequence.getValues().size());
		assertTrue(reverseSequence.getValues().get(0) instanceof IntegerLiteral);
		assertEquals(2, ((IntegerLiteral)reverseSequence.getValues().get(0)).getValue());
		assertTrue(reverseSequence.getValues().get(1) instanceof IntegerLiteral);
		assertEquals(1, ((IntegerLiteral)reverseSequence.getValues().get(1)).getValue());
		assertTrue(reverseSequence.getValues().get(2) instanceof IntegerLiteral);
		assertEquals(0, ((IntegerLiteral)reverseSequence.getValues().get(2)).getValue());
	}
	
	@Test
	public void testWhile(){
		ParseResult<ModelUnit> res = parse("input/structure/while.implem");
		ModelUnit root = res.getRoot();
		
		assertNotNull(root);
		assertEquals("test.whileloop",root.getName());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(1, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEPackage(), xtdCls.getBaseClass());
		assertEquals(0, xtdCls.getAttributes().size());
		
		Method method = xtdCls.getMethods().get(0);
		assertTrue(method instanceof Method);
		EOperation eOperationDef = method.getOperationRef();
		assertNotNull(eOperationDef);
		assertEquals("entryPoint",eOperationDef.getName());
		assertNull(eOperationDef.getEType());
		assertEquals(1, eOperationDef.getEParameters().size());
		assertEquals("arg", eOperationDef.getEParameters().get(0).getName());
		assertEquals(EcorePackage.eINSTANCE.getEInt(), eOperationDef.getEParameters().get(0).getEType());
		assertEquals(1,method.getTags().size());
		assertEquals("main",method.getTags().get(0));
		
		Block body = ((Method)method).getBody();
		assertNotNull(body);
		assertEquals(2, body.getStatements().size());
		
		Statement stmt1 = body.getStatements().get(0);
		assertTrue(stmt1 instanceof VariableDeclaration);
		VariableDeclaration var = (VariableDeclaration) stmt1;
		assertEquals("i", var.getName());
		assertEquals(EcorePackage.eINSTANCE.getEInt(), var.getType());
		assertNotNull(var.getInitialValue());
		Expression value = var.getInitialValue();
		assertTrue(value instanceof IntegerLiteral);
		assertEquals(0,((IntegerLiteral)value).getValue());
		
		Statement stmt2 = body.getStatements().get(1);
		assertTrue(stmt2 instanceof While);
		While loop = (While) stmt2;
		Expression condition = loop.getCondition();
		assertNotNull(condition);
		assertTrue(condition instanceof Call);
		assertEquals(AstBuilderListener.LESS_THAN_SERVICE_NAME,((Call)condition).getServiceName());
		assertEquals(2, ((Call)condition).getArguments().size());
		Expression left = ((Call)condition).getArguments().get(0);
		Expression right = ((Call)condition).getArguments().get(1);
		assertTrue(left instanceof VarRef);
		assertEquals("i", ((VarRef)left).getVariableName());
		assertTrue(right instanceof IntegerLiteral);
		assertEquals(2, ((IntegerLiteral)right).getValue());
		
		assertNotNull(loop.getBody());
		assertEquals(1,loop.getBody().getStatements().size());
		Statement stmt3 = loop.getBody().getStatements().get(0);
		assertTrue(stmt3 instanceof VariableAssignment);
		assertEquals("i",((VariableAssignment)stmt3).getName());
		assertNotNull(((VariableAssignment)stmt3).getValue());
		Expression value2 = ((VariableAssignment)stmt3).getValue();
		assertTrue(value2 instanceof Call);
		assertEquals(AstBuilderListener.ADD_SERVICE_NAME,((Call)value2).getServiceName());
		assertEquals(2,((Call)value2).getArguments().size());
		Expression left2 = ((Call)value2).getArguments().get(0);
		Expression right2 = ((Call)value2).getArguments().get(1);
		assertTrue(left2 instanceof IntegerLiteral);
		assertEquals(1, ((IntegerLiteral)left2).getValue());
		assertTrue(right2 instanceof VarRef);
		assertEquals("i", ((VarRef)right2).getVariableName());
	}
	
	@Test
	public void testIf(){
		ParseResult<ModelUnit> res = parse("input/structure/if.implem");
		ModelUnit root = res.getRoot();
		
		assertNotNull(root);
		assertEquals("test.ifstmt",root.getName());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(1, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEPackage(), xtdCls.getBaseClass());
		assertEquals(0, xtdCls.getAttributes().size());
		
		Method method = xtdCls.getMethods().get(0);
		assertTrue(method instanceof Method);
		EOperation eOperationDef = ((Method)method).getOperationRef();
		assertNotNull(eOperationDef);
		assertEquals("entryPoint",eOperationDef.getName());
		assertNull(eOperationDef.getEType());
		assertEquals(1, eOperationDef.getEParameters().size());
		assertEquals("arg", eOperationDef.getEParameters().get(0).getName());
		assertEquals(EcorePackage.eINSTANCE.getEInt(), eOperationDef.getEParameters().get(0).getEType());
		
		Block body = ((Method)method).getBody();
		assertNotNull(body);
		assertEquals(4, body.getStatements().size());
		
		Statement local0 = body.getStatements().get(0);
		assertTrue(local0 instanceof VariableDeclaration);
		assertEquals("me",((VariableDeclaration)local0).getName());
		assertEquals(EcorePackage.eINSTANCE.getEPackage(),((VariableDeclaration)local0).getType());
		Expression value = ((VariableDeclaration)local0).getInitialValue();
		assertNotNull(value);
		assertTrue(value instanceof VarRef);
		assertEquals("self",((VarRef)value).getVariableName());
		
		Statement stmt1 = body.getStatements().get(1);
		assertTrue(stmt1 instanceof VariableDeclaration);
		VariableDeclaration var = (VariableDeclaration) stmt1;
		assertEquals("i", var.getName());
		assertEquals(EcorePackage.eINSTANCE.getEInt(), var.getType());
		assertNotNull(var.getInitialValue());
		Expression value1 = var.getInitialValue();
		assertTrue(value1 instanceof IntegerLiteral);
		assertEquals(0,((IntegerLiteral)value1).getValue());
		
		Statement stmt2 = body.getStatements().get(2);
		assertTrue(stmt2 instanceof If);
		If ifStmt = (If) stmt2;
		Expression cond1 = ifStmt.getCondition();
		assertNotNull(cond1);
		assertTrue(cond1 instanceof Call);
		assertEquals(AstBuilderListener.EQUALS_SERVICE_NAME,((Call)cond1).getServiceName());
		assertEquals(2,((Call)cond1).getArguments().size());
		Expression left = ((Call)cond1).getArguments().get(0);
		Expression right = ((Call)cond1).getArguments().get(1);
		assertTrue(left instanceof VarRef);
		assertEquals("me",((VarRef)left).getVariableName());
		assertTrue(right instanceof VarRef);
		assertEquals("self",((VarRef)right).getVariableName());
		assertNotNull(ifStmt.getThen());
		assertEquals(1, ifStmt.getThen().getStatements().size());
		Statement stmt3 = ifStmt.getThen().getStatements().get(0);
		assertTrue(stmt3 instanceof VariableAssignment);
		VariableAssignment varAssign = (VariableAssignment) stmt3;
		assertEquals("i", varAssign.getName());
		assertNotNull(varAssign.getValue());
		Expression value2 = varAssign.getValue();
		assertTrue(value2 instanceof IntegerLiteral);
		assertEquals(1,((IntegerLiteral)value2).getValue());
		
		Statement stmt4 = body.getStatements().get(3);
		assertTrue(stmt4 instanceof If);
		If ifStmt2 = (If) stmt4;
		Expression cond2 = ifStmt2.getCondition();
		assertNotNull(cond2);
		assertTrue(cond2 instanceof BooleanLiteral);
		assertFalse(((BooleanLiteral)cond2).isValue());
		assertNotNull(ifStmt2.getThen());
		assertEquals(1,ifStmt2.getThen().getStatements().size());
		Statement stmt5 = ifStmt2.getThen().getStatements().get(0);
		assertTrue(stmt5 instanceof VariableAssignment);
		VariableAssignment varAssign2 = (VariableAssignment) stmt5;
		assertEquals("i", varAssign2.getName());
		assertNotNull(varAssign2.getValue());
		Expression value3 = varAssign2.getValue();
		assertTrue(value3 instanceof IntegerLiteral);
		assertEquals(2,((IntegerLiteral)value3).getValue());
		
		assertNotNull(ifStmt2.getElse());
		assertEquals(1,ifStmt2.getElse().getStatements().size());
		Statement stmt6 = ifStmt2.getElse().getStatements().get(0);
		assertTrue(stmt6 instanceof VariableAssignment);
		VariableAssignment varAssign3 = (VariableAssignment) stmt6;
		assertEquals("i", varAssign3.getName());
		assertNotNull(varAssign3.getValue());
		Expression value4 = varAssign3.getValue();
		assertTrue(value4 instanceof IntegerLiteral);
		assertEquals(3,((IntegerLiteral)value4).getValue());
	}
	
	@Test
	public void testAllFeatures(){
		ParseResult<ModelUnit> res = parse("input/structure/allFeatures.implem");
		ModelUnit root = res.getRoot();
		assertEquals(Diagnostic.OK,res.getDiagnostic().getCode());
		assertNotNull(root);
		assertEquals("test.allfeatures",root.getName());
	}
	
	@Test
	public void testRuntimeClass() {
		List<ParseResult<ModelUnit>> res = parser.parseFromFiles(Arrays.asList("input/structure/newClass.implem"));
		ModelUnit root = res.get(0).getRoot();
		
		assertNotNull(root);
		assertEquals("test.newclass",root.getName());
		assertEquals(0, root.getServices().size());
		assertEquals(0, root.getClassExtensions().size());
		assertEquals(1, root.getClassDefinitions().size());
		
		RuntimeClass newCls = root.getClassDefinitions().get(0);
		assertEquals("NewRuntimeClass", newCls.getName());
		assertEquals(2, newCls.getAttributes().size());
		
		Attribute myName = newCls.getAttributes().get(0);
		assertEquals("myName",myName.getFeatureRef().getName());
		assertEquals(EcorePackage.eINSTANCE.getEString(), myName.getFeatureRef().getEType());
		assertNotNull(myName.getInitialValue());
		Attribute toEClass = newCls.getAttributes().get(1);
		assertEquals("toEClass",toEClass.getFeatureRef().getName());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), toEClass.getFeatureRef().getEType());
		assertNull(toEClass.getInitialValue());
		
		assertEquals(2, newCls.getMethods().size());
		Method someOp = newCls.getMethods().get(0);
		assertEquals("someOp",someOp.getOperationRef().getName());
		assertEquals(0,someOp.getOperationRef().getEParameters().size());
		assertEquals(EcorePackage.eINSTANCE.getEClass(),someOp.getOperationRef().getEType());
		
		
		Collection<EClassifier> foundTypes = queryEnvironment.getEPackageProvider().getTypes("NewRuntimeClass");
		assertEquals(1,foundTypes.size());
		EClass runtimeClass = (EClass) foundTypes.iterator().next();
		
		Method entryPoint = newCls.getMethods().get(1);
		assertEquals("entryPoint",entryPoint.getOperationRef().getName());
		assertEquals(1,entryPoint.getOperationRef().getEParameters().size());
		assertEquals(EcorePackage.eINSTANCE.getEInt(),entryPoint.getOperationRef().getEParameters().get(0).getEType());
		assertEquals(runtimeClass,entryPoint.getOperationRef().getEType());
		assertEquals(1,entryPoint.getTags().size());
		assertEquals("main",entryPoint.getTags().get(0));
		
		//myName,toEClass, someOp, entryPoint
		assertEquals("NewRuntimeClass", runtimeClass.getName());
		assertEquals(1, runtimeClass.getEAttributes().size());
		assertEquals("myName", runtimeClass.getEAttributes().get(0).getName());
		assertEquals(EcorePackage.eINSTANCE.getEString(), runtimeClass.getEAttributes().get(0).getEType());
		assertEquals(1, runtimeClass.getEReferences().size());
		assertEquals("toEClass", runtimeClass.getEReferences().get(0).getName());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), runtimeClass.getEReferences().get(0).getEType());
		assertEquals(2, runtimeClass.getEOperations().size());
		assertEquals("someOp",runtimeClass.getEOperations().get(0).getName());
		assertEquals(0,runtimeClass.getEOperations().get(0).getEParameters().size());
		assertEquals(EcorePackage.eINSTANCE.getEClass(),runtimeClass.getEOperations().get(0).getEType());
		assertEquals("entryPoint",runtimeClass.getEOperations().get(1).getName());
		assertEquals(1,runtimeClass.getEOperations().get(1).getEParameters().size());
		assertEquals(EcorePackage.eINSTANCE.getEInt(),runtimeClass.getEOperations().get(1).getEParameters().get(0).getEType());
		assertEquals(runtimeClass,runtimeClass.getEOperations().get(1).getEType());
	}
	
	@Test
	public void testExtends() {
		List<ParseResult<ModelUnit>> res = parser.parseFromFiles(Arrays.asList("input/structure/extends.implem","input/structure/extendedClass.implem"));
		ModelUnit root = res.get(1).getRoot();
		ModelUnit extendedRoot = res.get(0).getRoot();
		
		assertNotNull(root);
		assertEquals("test.extendedclass",root.getName());
		assertEquals(0, root.getServices().size());
		assertEquals(1, root.getClassExtensions().size());
		assertEquals(0, root.getClassDefinitions().size());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(0, xtdCls.getAttributes().size());
		assertEquals(0, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), xtdCls.getBaseClass());
		
		assertNotNull(extendedRoot);
		assertEquals("test.extendedextendedclass",extendedRoot.getName());
		assertEquals(0, extendedRoot.getServices().size());
		assertEquals(1, extendedRoot.getClassExtensions().size());
		assertEquals(0, extendedRoot.getClassDefinitions().size());
		
		ExtendedClass xtdXtdCls = extendedRoot.getClassExtensions().get(0);
		assertEquals(0, xtdXtdCls.getAttributes().size());
		assertEquals(0, xtdXtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), xtdXtdCls.getBaseClass());
		assertEquals(1,xtdXtdCls.getExtends().size());
		assertEquals(xtdCls,xtdXtdCls.getExtends().get(0));
	}
	
	@Test
	public void testContains() {
		List<ParseResult<ModelUnit>> res = parser.parseFromFiles(Arrays.asList("input/structure/contains.implem"));
		ModelUnit root = res.get(0).getRoot();
		ModelUnit extendedRoot = res.get(0).getRoot();
		
		assertNotNull(root);
		assertEquals("test.containsattributes",root.getName());
		assertEquals(0, root.getServices().size());
		assertEquals(1, root.getClassExtensions().size());
		assertEquals(0, root.getClassDefinitions().size());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(1, xtdCls.getAttributes().size());
		assertEquals(0, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), xtdCls.getBaseClass());
		
		
		assertEquals(1, xtdCls.getAttributes().size());
		
		EReference toEClass = (EReference) xtdCls.getAttributes().get(0).getFeatureRef();
		
		assertEquals("toEClass", toEClass.getName());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), toEClass.getEType());
		assertEquals(1,toEClass.getLowerBound());
		assertEquals(-1,toEClass.getUpperBound());
		assertTrue(toEClass.isContainment());
	}
	
	@Test
	public void testUnique() {
		List<ParseResult<ModelUnit>> res = parser.parseFromFiles(Arrays.asList("input/structure/unique.implem"));
		ModelUnit root = res.get(0).getRoot();
		ModelUnit extendedRoot = res.get(0).getRoot();
		
		assertNotNull(root);
		assertEquals("test.uniqueattributes",root.getName());
		assertEquals(0, root.getServices().size());
		assertEquals(1, root.getClassExtensions().size());
		assertEquals(0, root.getClassDefinitions().size());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(1, xtdCls.getAttributes().size());
		assertEquals(0, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), xtdCls.getBaseClass());
		
		
		assertEquals(1, xtdCls.getAttributes().size());
		
		EReference toEClass = (EReference) xtdCls.getAttributes().get(0).getFeatureRef();
		
		assertEquals("toEClass", toEClass.getName());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), toEClass.getEType());
		assertTrue(toEClass.isUnique());
	}
	
	@Test
	public void testOpposite() {
		List<ParseResult<ModelUnit>> res = parser.parseFromFiles(Arrays.asList("input/structure/opposite.implem"));
		ModelUnit root = res.get(0).getRoot();
		ModelUnit extendedRoot = res.get(0).getRoot();
		
		assertNotNull(root);
		assertEquals("test.oppattributes",root.getName());
		assertEquals(0, root.getServices().size());
		assertEquals(1, root.getClassExtensions().size());
		assertEquals(1, root.getClassDefinitions().size());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(1, xtdCls.getAttributes().size());
		assertEquals(0, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), xtdCls.getBaseClass());
		
		RuntimeClass newCls = root.getClassDefinitions().get(0);
		assertEquals(1, newCls.getAttributes().size());
		assertEquals(0, newCls.getMethods().size());
		assertNotNull(newCls.getFragment());
		assertEquals("NewClass",newCls.getFragment().getName());
		
		assertEquals(1, xtdCls.getAttributes().size());
		assertEquals(1, newCls.getAttributes().size());
		
		EReference toNewClass = (EReference) xtdCls.getAttributes().get(0).getFeatureRef();
		EReference toEClass = (EReference) newCls.getAttributes().get(0).getFeatureRef();
		
		assertEquals("toNewClass", toNewClass.getName());
		assertEquals("toEClass", toEClass.getName());
		assertEquals(toNewClass.getEOpposite(), toEClass);
		assertEquals(toEClass.getEOpposite(), toNewClass);
	}
	
	@Test
	public void testTypeLiteral() {
		ParseResult<ModelUnit> res = parse("input/structure/typeLiteral.implem");
		ModelUnit root = res.getRoot();
		
		assertNotNull(root);
		assertEquals("test.typeliteral",root.getName());
		assertEquals(0, root.getServices().size());
		assertEquals(1, root.getClassExtensions().size());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(0, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), xtdCls.getBaseClass());
		assertEquals(8, xtdCls.getAttributes().size());
		
		Attribute attrib0 = xtdCls.getAttributes().get(0);
		assertEquals("stringAttr", attrib0.getFeatureRef().getName());
		assertEquals(EcorePackage.eINSTANCE.getEString(), attrib0.getFeatureRef().getEType());
		assertNull(attrib0.getInitialValue());
		
		Attribute attrib1 = xtdCls.getAttributes().get(1);
		assertEquals("intAttr", attrib1.getFeatureRef().getName());
		assertEquals(EcorePackage.eINSTANCE.getEInt(), attrib1.getFeatureRef().getEType());
		assertNull(attrib1.getInitialValue());
		
		Attribute attrib2 = xtdCls.getAttributes().get(2);
		assertEquals("realAttr", attrib2.getFeatureRef().getName());
		assertEquals(EcorePackage.eINSTANCE.getEDouble(), attrib2.getFeatureRef().getEType());
		assertNull(attrib2.getInitialValue());
		
		Attribute attrib3 = xtdCls.getAttributes().get(3);
		assertEquals("boolAttr", attrib3.getFeatureRef().getName());
		assertEquals(EcorePackage.eINSTANCE.getEBoolean(), attrib3.getFeatureRef().getEType());
		assertNull(attrib3.getInitialValue());
		
		Attribute attrib4 = xtdCls.getAttributes().get(4);
		assertEquals("seqAttr", attrib4.getFeatureRef().getName());
		assertEquals(EcorePackage.eINSTANCE.getEEList(), attrib4.getFeatureRef().getEType());
		assertNull(attrib4.getInitialValue());
		
		Attribute attrib5 = xtdCls.getAttributes().get(5);
		assertEquals("setAttr", attrib5.getFeatureRef().getName());
		assertEquals(EcorePackage.eINSTANCE.getEEList(), attrib5.getFeatureRef().getEType());
		assertNull(attrib5.getInitialValue());
		
		Attribute attrib6 = xtdCls.getAttributes().get(6);
		assertEquals("clsAttr", attrib6.getFeatureRef().getName());
		assertEquals(EcorePackage.eINSTANCE.getEClass(), attrib6.getFeatureRef().getEType());
		assertNull(attrib6.getInitialValue());
		
		//Check multi set fall in default EType
		Attribute attrib7 = xtdCls.getAttributes().get(7);
		assertEquals("clsSetAttr", attrib7.getFeatureRef().getName());
		assertEquals(EcorePackage.eINSTANCE.getEClassifier(), attrib7.getFeatureRef().getEType());
		assertNull(attrib7.getInitialValue());
	}
	
	@Test
	public void testAssign() {
		ParseResult<ModelUnit> res = parse("input/structure/assign.implem");
		ModelUnit root = res.getRoot();
		
		assertNotNull(root);
		assertEquals("test.assign",root.getName());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(1, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEObject(), xtdCls.getBaseClass());
		assertEquals(0, xtdCls.getAttributes().size());
		
		Method method = xtdCls.getMethods().get(0);
		assertTrue(method instanceof Method);
		EOperation eOperationDef = method.getOperationRef();
		assertNotNull(eOperationDef);
		assertEquals("eClass",eOperationDef.getName());
		assertEquals(EcorePackage.eINSTANCE.getEClass(),eOperationDef.getEType());
		assertEquals(0, eOperationDef.getEParameters().size());
		
		Block body = ((Method)method).getBody();
		assertNotNull(body);
		assertEquals(1, body.getStatements().size());
		
		Statement local0 = body.getStatements().get(0);
		assertTrue(local0 instanceof VariableAssignment);
		assertEquals("result",((VariableAssignment)local0).getName());
		Expression value = ((VariableAssignment)local0).getValue();
		assertTrue(value instanceof TypeLiteral);
		assertEquals(EcorePackage.eINSTANCE.getEModelElement(), ((TypeLiteral)value).getValue());
	}
	
	@Test
	public void testInsert() {
		ParseResult<ModelUnit> res = parse("input/structure/insert.implem");
		ModelUnit root = res.getRoot();
		
		assertNotNull(root);
		assertEquals("test.insert",root.getName());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(1, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEObject(), xtdCls.getBaseClass());
		assertEquals(0, xtdCls.getAttributes().size());
		
		Method method = xtdCls.getMethods().get(0);
		assertTrue(method instanceof Method);
		EOperation eOperationDef = method.getOperationRef();
		assertNotNull(eOperationDef);
		assertEquals("eClass",eOperationDef.getName());
		assertEquals(EcorePackage.eINSTANCE.getEClass(),eOperationDef.getEType());
		assertEquals(0, eOperationDef.getEParameters().size());
		
		Block body = ((Method)method).getBody();
		assertNotNull(body);
		assertEquals(1, body.getStatements().size());
		
		Statement insertion = body.getStatements().get(0);
		assertTrue(insertion instanceof FeatureInsert);
		assertTrue(((FeatureInsert)insertion).getTarget() instanceof VarRef);
		assertEquals("self", ((VarRef)((FeatureInsert)insertion).getTarget()).getVariableName());
		assertEquals("eSuperTypes",((FeatureInsert)insertion).getTargetFeature());
		Expression value = ((FeatureInsert)insertion).getValue();
		assertTrue(value instanceof VarRef);
		assertEquals("self", ((VarRef)value).getVariableName());
	}
	
	@Test
	public void testRemove() {
		ParseResult<ModelUnit> res = parse("input/structure/remove.implem");
		ModelUnit root = res.getRoot();
		
		assertNotNull(root);
		assertEquals("test.remove",root.getName());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(1, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEObject(), xtdCls.getBaseClass());
		assertEquals(0, xtdCls.getAttributes().size());
		
		Method method = xtdCls.getMethods().get(0);
		assertTrue(method instanceof Method);
		EOperation eOperationDef = method.getOperationRef();
		assertNotNull(eOperationDef);
		assertEquals("eClass",eOperationDef.getName());
		assertEquals(EcorePackage.eINSTANCE.getEClass(),eOperationDef.getEType());
		assertEquals(0, eOperationDef.getEParameters().size());
		
		Block body = ((Method)method).getBody();
		assertNotNull(body);
		assertEquals(1, body.getStatements().size());
		
		Statement removal = body.getStatements().get(0);
		assertTrue(removal instanceof FeatureRemove);
		assertTrue(((FeatureRemove)removal).getTarget() instanceof VarRef);
		assertEquals("self", ((VarRef)((FeatureRemove)removal).getTarget()).getVariableName());
		assertEquals("eSuperTypes",((FeatureRemove)removal).getTargetFeature());
		Expression value = ((FeatureRemove)removal).getValue();
		assertTrue(value instanceof VarRef);
		assertEquals("self", ((VarRef)value).getVariableName());
	}
	
	@Test
	public void testStatementError() {
		ParseResult<ModelUnit> res = parse("input/structure/statementError.implem");
		ModelUnit root = res.getRoot();
		
		assertNotNull(root);
		assertEquals("test.assign",root.getName());
		
		ExtendedClass xtdCls = root.getClassExtensions().get(0);
		assertEquals(1, xtdCls.getMethods().size());
		assertEquals(EcorePackage.eINSTANCE.getEObject(), xtdCls.getBaseClass());
		assertEquals(0, xtdCls.getAttributes().size());
		
		Method method = xtdCls.getMethods().get(0);
		assertTrue(method instanceof Method);
		EOperation eOperationDef = method.getOperationRef();
		assertNotNull(eOperationDef);
		assertEquals("eClass",eOperationDef.getName());
		assertEquals(EcorePackage.eINSTANCE.getEClass(),eOperationDef.getEType());
		assertEquals(0, eOperationDef.getEParameters().size());
		
		Block body = ((Method)method).getBody();
		assertNotNull(body);
		assertEquals(1, body.getStatements().size());
		
		Statement insertion = body.getStatements().get(0);
		assertTrue(insertion instanceof ExpressionStatement);
		Expression expression = ((ExpressionStatement)insertion).getExpression();
		assertTrue(expression instanceof TypeLiteral);
		assertEquals(EcorePackage.eINSTANCE.getEModelElement(), ((TypeLiteral)expression).getValue());
	}
	
	private static String getFileContent(String implementionPath){
		String fileContent = "";
		try {
			fileContent = new String(Files.readAllBytes(Paths.get(implementionPath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}
	
	private ParseResult<ModelUnit> parse(String fileName) {
		try {
			return parser.parse(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
