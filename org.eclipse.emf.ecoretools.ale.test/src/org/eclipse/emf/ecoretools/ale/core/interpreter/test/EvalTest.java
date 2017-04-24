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
package org.eclipse.emf.ecoretools.ale.core.interpreter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.junit.Before;
import org.junit.Test;
/**
 * This class test the execution of ModelBehavior
 */
public class EvalTest {
	
	ALEInterpreter interpreter;
	
	@Before
	public void setup() {
		interpreter = new ALEInterpreter();
	}
	
	@Test
	public void testAccessLocalVariable(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/localvar.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("foobar",res.getValue());
	}
	
	@Test
	public void testAccessParameter(){
		String obj = "";
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/args.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(obj), parsedSemantics);
		
		assertEquals(obj,res.getValue());
	}
	
	@Test
	public void testAccessSelf(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/self.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(caller,res.getValue());
	}
	
	@Test
	public void testAccessSelfDynamicAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/selfDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("foo",res.getValue());
	}
	
	@Test
	public void testAccessCreateDynamicAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/createDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("foo",res.getValue());
	}
	
	@Test
	public void testAccessLocalDynamicAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/localDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("foo",res.getValue());
	}

	@Test
	public void testAccessParamDynamicAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/paramDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		IEvaluationResult res = interpreter.eval(caller,  Arrays.asList(newInstance), parsedSemantics);
		
		assertEquals("foo",res.getValue());
	}

	@Test
	public void testAccessResultDynamicAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/resultDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("foo",res.getValue());
	}
	
	@Test
	public void testAccessCallDynamicAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/callDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("foo",res.getValue());
	}
	
	@Test
	public void testAccessSelfAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/selfAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		caller.eSet(field, 1);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(1,res.getValue());
	}
	
	@Test
	public void testAccessLocalAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/localAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		caller.eSet(field, 2);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(2,res.getValue());
	}

	@Test
	public void testAccessParamAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/paramAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		EStructuralFeature field = newInstance.eClass().getEStructuralFeature("field");
		newInstance.eSet(field, 3);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(newInstance), parsedSemantics);
		
		assertEquals(3,res.getValue());
	}

	@Test
	public void testAccessResultAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/resultAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		caller.eSet(field, 4);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(4,res.getValue());
	}
	
	@Test
	public void testAccessCallAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/callAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		caller.eSet(field, 5);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(5,res.getValue());
	}
	
	@Test
	public void testAssignSelfDynamicAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/selfDynamicAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("bar",res.getValue());
	}
	
	@Test
	public void testAssignLocalDynamicAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/localDynamicAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("bar",res.getValue());
	}
	
	@Test
	public void testAssignParamDynamicAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/paramDynamicAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(newInstance), parsedSemantics);
		
		assertEquals("bar",res.getValue());
	}
	
	@Test
	public void testAssignResultDynamicAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/resultDynamicAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("bar",res.getValue());
	}
	
	@Test
	public void testAssignCallDynamicAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/callDynamicAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("bar",res.getValue());
	}
	
	@Test
	public void testAssignSelfAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/selfAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(1,res.getValue());
	}
	
	@Test
	public void testAssignLocalAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/localAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(2,res.getValue());
	}
	
	@Test
	public void testAssignParamAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/paramAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(newInstance), parsedSemantics);
		
		assertEquals(3,res.getValue());
	}

	@Test
	public void testAssignResultAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/resultAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(4,res.getValue());
	}

	@Test
	public void testAssignCallAttribute(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/callAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(5,res.getValue());
	}
	
	@Test
	public void testSelfCall(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/selfCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(1,res.getValue());
	}
	
	@Test
	public void testLocalCall(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/localCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(2,res.getValue());
	}
	
	@Test
	public void testAttributeCall(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/attributeCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(3,res.getValue());
	}
	
	@Test
	public void testDynamicAttributeCall(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/dynamicAttributeCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(4,res.getValue());
	}
	
	@Test
	public void testParamCall(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/paramCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(newInstance), parsedSemantics);
		
		assertEquals(5,res.getValue());
	}
	
	@Test
	public void testParamValue(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/paramValue.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(6,res.getValue());
	}
	
	@Test
	public void testResultCall(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/resultCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(6,res.getValue());
	}
	
	@Test
	public void testChainAttrib(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/chainAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(caller,res.getValue());
	}
	
	@Test
	public void testChainDynamicAttrib(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/chainDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(caller,res.getValue());
	}
	
	@Test
	public void testChainCall(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/chainCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(caller,res.getValue());
	}
	
	@Test
	public void testForEachSequence(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/forEachSequence.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("012345",res.getValue());
	}
	
	@Test
	public void testForEachReverseSequence(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/forEachReverseSequence.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("4321",res.getValue());
	}
	
	@Test
	public void testForEachCollection(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/forEachCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(2,res.getValue());
	}
	
	@Test
	public void testForEachEmpty(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/forEachEmptyCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(0,res.getValue());
	}
	
	@Test
	public void testWhile(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/while.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(10,res.getValue());
	}
	
	@Test
	public void testIfTrue(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/ifTrue.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(1,res.getValue());
	}
	
	@Test
	public void testIfFalse(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/ifFalse.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(0,res.getValue());
	}
	
	@Test
	public void testElseTrue(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/elseTrue.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(1,res.getValue());
	}
	
	@Test
	public void testElseFalse(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/elseFalse.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(2,res.getValue());
	}
	
	@Test
	public void testAdd(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/add.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(3,res.getValue());
	}
	
	@Test
	public void testRemove(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/remove.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(2,res.getValue());
	}
	
	@Test
	public void testLog(){
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/log.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("foobar\n", outContent.toString());
		
		System.setOut(null);
		
	}
	
	@Test
	public void testCreate(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/create.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertNotNull(res.getValue());
		assertNotEquals(caller,res.getValue());
		assertTrue(res.getValue() instanceof EObject);
		assertTrue(((EObject)res.getValue()).eClass().getName().equals("ClassA"));
	}
	
	@Test
	public void testService(){
		try {
			ServiceUtils.registerServices(
					interpreter.getQueryEnvironment(),
					ServiceUtils.getServices(interpreter.getQueryEnvironment(),	Class.forName("org.eclipse.emf.ecoretools.ale.core.interpreter.test.Service"))
					);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/service.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("foobar:ClassA",res.getValue());
	}
	
	@Test
	public void testNewClass(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/newClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertNotNull(res.getValue());
		assertNotEquals(caller,res.getValue());
		assertTrue(res.getValue() instanceof EObject);
		assertEquals("NewRuntimeClass",((EObject)res.getValue()).eClass().getName());
	}
	
	@Test
	public void testOppositeAssign(){
		/*
		 * Check NewClass to self
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/opposite.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertTrue(res.getValue() instanceof EObject);
		assertNotEquals(caller,res.getValue());
		assertEquals("NewClass",((EObject)res.getValue()).eClass().getName());
	}
	
	@Test
	public void testOppositeAssign2(){
		/*
		 * Check self to NewClass
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/opposite2.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertTrue(res.getValue() instanceof EObject);
		assertEquals(caller,res.getValue());
	}
	
	@Test
	public void testOppositeAssign3(){
		/*
		 * Check ClassA to self
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/opposite3.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertTrue(res.getValue() instanceof EObject);
		assertEquals(caller,res.getValue());
	}
	
	@Test
	public void testOppositeAssign4(){
		/*
		 * Check NewClass to NewClass
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/opposite4.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertNotNull(res.getValue());
		assertNotEquals(caller,res.getValue());
		assertEquals("obj1", res.getValue());
	}
	
	@Test
	public void testContainsDynamicEContainer(){
		/*
		 * Check eContainer()
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/containsDynamicEContainer.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertNotNull(res.getValue());
		assertEquals(caller, res.getValue());
	}
	
	@Test
	public void testContainsDoubelAssign(){
		/*
		 * Check double assignment
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/containsDoubleAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertNull(res.getValue());
	}
	
	@Test
	public void testContainsSelfEContainer(){
		/*
		 * Check self.eContainer()
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/containsSelfEContainer.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertTrue(res.getValue() instanceof EObject);
		assertEquals("NewClass", ((EObject)res.getValue()).eClass().getName());
	}
	
	@Test
	public void testContainsEContents(){
		/*
		 * Check self.eContent()
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/containsEContents.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		Object value = res.getValue();
		assertTrue(value instanceof List);
		assertEquals(1,((List<?>)value).size());
		
		Object contained = ((List<?>)value).get(0);
		assertTrue(contained instanceof EObject);
		assertEquals("NewClass", ((EObject)contained).eClass().getName());
	}
	
	@Test
	public void testContainsEAllContents(){
		/*
		 * Check self.eAllContent()
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/containsEAllContents.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA2.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		Object value = res.getValue();
		assertTrue(value instanceof List);
		assertEquals(4,((List<?>)value).size());
		
		Object elem1 = ((List<?>)value).get(0);
		Object elem2 = ((List<?>)value).get(1);
		Object elem3 = ((List<?>)value).get(2);
		Object elem4 = ((List<?>)value).get(3);
		
		assertTrue(elem1 instanceof EObject);
		assertEquals("ClassA", ((EObject)elem1).eClass().getName());
		assertTrue(elem2 instanceof EObject);
		assertEquals("ClassA", ((EObject)elem2).eClass().getName());
		assertTrue(elem3 instanceof EObject);
		assertEquals("NewClass", ((EObject)elem3).eClass().getName());
		assertTrue(elem4 instanceof EObject);
		assertEquals("ClassA", ((EObject)elem4).eClass().getName());
	}
	
	@Test
	public void testUniqueAssign(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/unique.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(1, res.getValue());
	}
	
	@Test
	public void testManyRemove(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/removeDynamic.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(1, res.getValue());
	}
	
	@Test
	public void testInitDynamicAttributeFailure(){
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/initDynamicAttributeFailure.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("ClassA",((EObject)res.getValue()).eClass().getName());
		interpreter.getLogger().diagnosticForHuman();
		assertEquals("An error occured during initialization of an EObject", interpreter.getLogger().getLog().get(0).getMessage());
	}
	
	@Test
	public void testECrossRef() {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/crossRef.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA3.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertTrue(res.getValue() instanceof List);
		List<?> resValue = (List<?>) res.getValue();
		assertEquals(1,resValue.size());
		
		EObject elem1 = (EObject) resValue.get(0);
		assertEquals("ClassA",elem1.eClass().getName());
		EStructuralFeature field = elem1.eClass().getEStructuralFeature("field");
		assertEquals(0,elem1.eGet(field));
		assertEquals(5,caller.eGet(field));
	}
	
	@Test
	public void testECrossRefDynamic() {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/crossRefDynamic.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EObject arg = interpreter.loadModel("model/ClassA3.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(arg), parsedSemantics);
		
		assertTrue(res.getValue() instanceof List);
		List<?> resValue = (List<?>) res.getValue();
		assertEquals(1,resValue.size());
		
		EObject elem1 = (EObject) resValue.get(0);
		assertEquals("ClassA",elem1.eClass().getName());
		EStructuralFeature field = elem1.eClass().getEStructuralFeature("field");
		assertEquals(5,elem1.eGet(field));
		assertEquals(0,caller.eGet(field));
	}
	
	@Test
	public void testEGet() {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/eGet.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA3.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(5,res.getValue());
	}
	
	@Test
	public void testEGetDynamic() {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),Arrays.asList("input/eval/eGetDynamic.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA3.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(123,res.getValue());
	}
	
	@Test
	public void testSelectedCall() {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/eval/selectedCallMain.implem","input/eval/selectedCall1.implem","input/eval/selectedCall2.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/B.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("test.selectedCallOne.A.foo()\ntest.selectedCallOne.B.foo()\ntest.selectedCallTwo.A.foo()\ntest.selectedCallTwo.B.foo()",res.getValue());
	}
}
