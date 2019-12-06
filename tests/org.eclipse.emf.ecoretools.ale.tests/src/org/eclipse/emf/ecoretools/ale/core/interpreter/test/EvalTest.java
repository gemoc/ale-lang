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

import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter.ClosedALEInterpreterException;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.ServiceCallListener;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.DslSemantics;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.ImmutableDslSemantics;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.junit.After;
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

	@After
	public void release() {
		if (interpreter != null) {
			interpreter.close();
		}
	}

	@Test
	public void testAccessLocalVariable() throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/localvar.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("foobar", res.getValue());
	}

	@Test
	public void testAccessParameter() throws ClosedALEInterpreterException {
		String obj = "";
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/args.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(obj), semantics);

		assertEquals(obj, res.getValue());
	}

	@Test
	public void testAccessSelf() throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/self.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(caller, res.getValue());
	}

	@Test
	public void testAccessSelfDynamicAttribute() throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/selfDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("foo", res.getValue());
	}

	@Test
	public void testAccessCreateDynamicAttribute() throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/createDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("foo", res.getValue());
	}

	@Test
	public void testAccessLocalDynamicAttribute() throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/localDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("foo", res.getValue());
	}

	@Test
	public void testAccessParamDynamicAttribute() throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/paramDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(newInstance), semantics);

		assertEquals("foo", res.getValue());
	}

	@Test
	public void testAccessResultDynamicAttribute() throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/resultDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("foo", res.getValue());
	}

	@Test
	public void testAccessCallDynamicAttribute() throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/callDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("foo", res.getValue());
	}

	@Test
	public void testNullDynamicAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/nullDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(Diagnostic.OK, res.getDiagnostic().getSeverity());
		assertEquals(null, res.getValue());
	}

	@Test
	public void testUnknownDynamicAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/unknownDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(Diagnostic.WARNING, res.getDiagnostic().getSeverity());
		assertEquals("An error occured during evaluation of a query", res.getDiagnostic().getMessage());
		assertEquals(null, res.getValue());
	}

	@Test
	public void testAccessSelfAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/selfAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		caller.eSet(field, 1);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(1, res.getValue());
	}

	@Test
	public void testAccessLocalAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/localAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		caller.eSet(field, 2);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(2, res.getValue());
	}

	@Test
	public void testAccessParamAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/paramAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		EStructuralFeature field = newInstance.eClass().getEStructuralFeature("field");
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		newInstance.eSet(field, 3);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(newInstance), semantics);

		assertEquals(3, res.getValue());
	}

	@Test
	public void testAccessResultAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/resultAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		caller.eSet(field, 4);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(4, res.getValue());
	}

	@Test
	public void testAccessCallAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/callAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		caller.eSet(field, 5);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(5, res.getValue());
	}

	@Test
	public void testAssignSelfDynamicAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/selfDynamicAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("bar", res.getValue());
	}

	@Test
	public void testAssignLocalDynamicAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/localDynamicAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("bar", res.getValue());
	}

	@Test
	public void testAssignParamDynamicAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/paramDynamicAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(newInstance), semantics);

		assertEquals("bar", res.getValue());
	}

	@Test
	public void testAssignResultDynamicAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/resultDynamicAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("bar", res.getValue());
	}

	@Test
	public void testAssignCallDynamicAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/callDynamicAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("bar", res.getValue());
	}

	@Test
	public void testAssignSelfAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/selfAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(1, res.getValue());
	}

	@Test
	public void testAssignLocalAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/localAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(2, res.getValue());
	}

	@Test
	public void testAssignParamAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/paramAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(newInstance), semantics);

		assertEquals(3, res.getValue());
	}

	@Test
	public void testAssignResultAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/resultAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(4, res.getValue());
	}

	@Test
	public void testAssignCallAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/callAttributeAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(5, res.getValue());
	}

	@Test
	public void testSelfCall()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/selfCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(1, res.getValue());
	}

	@Test
	public void testLocalCall()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/localCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(2, res.getValue());
	}

	@Test
	public void testAttributeCall()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/attributeCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(3, res.getValue());
	}

	@Test
	public void testDynamicAttributeCall()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/dynamicAttributeCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(4, res.getValue());
	}

	@Test
	public void testParamCall()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/paramCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(newInstance), semantics);

		assertEquals(5, res.getValue());
	}

	@Test
	public void testParamValue()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/paramValue.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(6, res.getValue());
	}

	@Test
	public void testResultCall()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/resultCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(6, res.getValue());
	}

	@Test
	public void testChainAttrib()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/chainAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(caller, res.getValue());
	}

	@Test
	public void testChainDynamicAttrib()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/chainDynamicAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(caller, res.getValue());
	}

	@Test
	public void testChainCall()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/chainCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(caller, res.getValue());
	}

	@Test
	public void testForEachSequence()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/forEachSequence.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("012345", res.getValue());
	}

	@Test
	public void testForEachReverseSequence()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/forEachReverseSequence.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("4321", res.getValue());
	}

	@Test
	public void testForEachCollection()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/forEachCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(2, res.getValue());
	}

	@Test
	public void testForEachEmpty()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/forEachEmptyCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(0, res.getValue());
	}

	@Test
	public void testWhile()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/while.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(10, res.getValue());
	}

	@Test
	public void testIfTrue()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/ifTrue.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(1, res.getValue());
	}

	@Test
	public void testIfFalse()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/ifFalse.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(0, res.getValue());
	}

	@Test
	public void testElseTrue()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/elseTrue.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(1, res.getValue());
	}

	@Test
	public void testElseFalse()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/elseFalse.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(2, res.getValue());
	}

	@Test
	public void testElseIf()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/elseIf.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("345", res.getValue());
	}

	@Test
	public void testAdd()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/add.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(3, res.getValue());
	}

	@Test
	public void testRemove()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/remove.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(2, res.getValue());
	}

	@Test
	public void testLog()  throws ClosedALEInterpreterException {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/log.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("foobar\n", outContent.toString());

		System.setOut(null);

	}

	@Test
	public void testCreate()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/create.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertNotNull(res.getValue());
		assertNotEquals(caller, res.getValue());
		assertTrue(res.getValue() instanceof EObject);
		assertTrue(((EObject) res.getValue()).eClass().getName().equals("ClassA"));
	}

	@Test
	public void testService()  throws ClosedALEInterpreterException {
		try {
			ServiceUtils.registerServices(interpreter.getQueryEnvironment(),
					ServiceUtils.getServices(interpreter.getQueryEnvironment(),
							Class.forName("org.eclipse.emf.ecoretools.ale.core.interpreter.test.Service")));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/service.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("foobar:ClassA", res.getValue());
	}

	@Test
	public void testNewClass()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/newClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertNotNull(res.getValue());
		assertNotEquals(caller, res.getValue());
		assertTrue(res.getValue() instanceof EObject);
		assertEquals("NewRuntimeClass", ((EObject) res.getValue()).eClass().getName());
	}

	@Test
	public void testOppositeAssign()  throws ClosedALEInterpreterException {
		/*
		 * Check NewClass to self
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/opposite.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertTrue(res.getValue() instanceof EObject);
		assertNotEquals(caller, res.getValue());
		assertEquals("NewClass", ((EObject) res.getValue()).eClass().getName());
	}

	@Test
	public void testOppositeAssign2()  throws ClosedALEInterpreterException {
		/*
		 * Check self to NewClass
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/opposite2.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertTrue(res.getValue() instanceof EObject);
		assertEquals(caller, res.getValue());
	}

	@Test
	public void testOppositeAssign3()  throws ClosedALEInterpreterException {
		/*
		 * Check ClassA to self
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/opposite3.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertTrue(res.getValue() instanceof EObject);
		assertEquals(caller, res.getValue());
	}

	@Test
	public void testOppositeAssign4()  throws ClosedALEInterpreterException {
		/*
		 * Check NewClass to NewClass
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/opposite4.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertNotNull(res.getValue());
		assertNotEquals(caller, res.getValue());
		assertEquals("obj1", res.getValue());
	}

	@Test
	public void testContainsDynamicEContainer()  throws ClosedALEInterpreterException {
		/*
		 * Check eContainer()
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/containsDynamicEContainer.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertNotNull(res.getValue());
		assertEquals(caller, res.getValue());
	}

	@Test
	public void testContainsDoubelAssign()  throws ClosedALEInterpreterException {
		/*
		 * Check double assignment
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/containsDoubleAssign.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertNull(res.getValue());
	}

	@Test
	public void testContainsSelfEContainer()  throws ClosedALEInterpreterException {
		/*
		 * Check self.eContainer()
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/containsSelfEContainer.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertTrue(res.getValue() instanceof EObject);
		assertEquals("NewClass", ((EObject) res.getValue()).eClass().getName());
	}

	@Test
	public void testContainsEContents()  throws ClosedALEInterpreterException {
		/*
		 * Check self.eContent()
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/containsEContents.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		Object value = res.getValue();
		assertTrue(value instanceof List);
		assertEquals(1, ((List<?>) value).size());

		Object contained = ((List<?>) value).get(0);
		assertTrue(contained instanceof EObject);
		assertEquals("NewClass", ((EObject) contained).eClass().getName());
	}

	@Test
	public void testContainsEAllContents()  throws ClosedALEInterpreterException {
		/*
		 * Check self.eAllContent()
		 */
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/containsEAllContents.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA2.xmi").getContents().get(0);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		Object value = res.getValue();
		assertTrue(value instanceof List);
		assertEquals(4, ((List<?>) value).size());

		Object elem1 = ((List<?>) value).get(0);
		Object elem2 = ((List<?>) value).get(1);
		Object elem3 = ((List<?>) value).get(2);
		Object elem4 = ((List<?>) value).get(3);

		assertTrue(elem1 instanceof EObject);
		assertEquals("ClassA", ((EObject) elem1).eClass().getName());
		assertTrue(elem2 instanceof EObject);
		assertEquals("ClassA", ((EObject) elem2).eClass().getName());
		assertTrue(elem3 instanceof EObject);
		assertEquals("NewClass", ((EObject) elem3).eClass().getName());
		assertTrue(elem4 instanceof EObject);
		assertEquals("ClassA", ((EObject) elem4).eClass().getName());
	}

	@Test
	public void testUniqueAssign()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/unique.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(1, res.getValue());
	}

	@Test
	public void testManyRemove()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/removeDynamic.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(1, res.getValue());
	}

	@Test
	public void testInitDynamicAttributeFailure()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/initDynamicAttributeFailure.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("ClassA", ((EObject) res.getValue()).eClass().getName());
		interpreter.getLogger().diagnosticForHuman();
		assertEquals("An error occured during initialization of an EObject",
				interpreter.getLogger().getLog().get(0).getMessage());
	}
	
	@Test
	public void testInitLocalVariable() throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/attributesOfDifferentTypes.ecore"), Arrays.asList("input/eval/initLocalVariables.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/Mix.xmi").getContents().get(0);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		interpreter.eval(caller, main, Arrays.asList(), semantics);
		
		assertEquals("int should be initialized to 0", 0, caller.eGet(caller.eClass().getEStructuralFeature("int")));
		assertEquals("bool should be initialized to false", false, caller.eGet(caller.eClass().getEStructuralFeature("bool")));
		assertEquals("string should be initialized to an empty string", "", caller.eGet(caller.eClass().getEStructuralFeature("string")));
		assertEquals("sequence should be initialized to an empty sequence", new BasicEList<>(), caller.eGet(caller.eClass().getEStructuralFeature("strings")));
	}

	@Test
	public void testECrossRef()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/crossRef.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA3.xmi").getContents().get(0);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertTrue(res.getValue() instanceof List);
		List<?> resValue = (List<?>) res.getValue();
		assertEquals(1, resValue.size());

		EObject elem1 = (EObject) resValue.get(0);
		assertEquals("ClassA", elem1.eClass().getName());
		EStructuralFeature field = elem1.eClass().getEStructuralFeature("field");
		assertEquals(0, elem1.eGet(field));
		assertEquals(5, caller.eGet(field));
	}

	@Test
	public void testECrossRefDynamic()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/crossRefDynamic.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		EObject arg = interpreter.loadModel("model/ClassA3.xmi").getContents().get(0);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(arg), semantics);

		assertTrue(res.getValue() instanceof List);
		List<?> resValue = (List<?>) res.getValue();
		assertEquals(1, resValue.size());

		EObject elem1 = (EObject) resValue.get(0);
		assertEquals("ClassA", elem1.eClass().getName());
		EStructuralFeature field = elem1.eClass().getEStructuralFeature("field");
		assertEquals(5, elem1.eGet(field));
		assertEquals(0, caller.eGet(field));
	}

	@Test
	public void testEGet()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/eGet.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA3.xmi").getContents().get(0);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(5, res.getValue());
	}

	@Test
	public void testEGetDynamic()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/eGetDynamic.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA3.xmi").getContents().get(0);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(123, res.getValue());
	}

	@Test
	public void testSelectedCall()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"), Arrays.asList("input/eval/selectedCallMain.implem",
				"input/eval/selectedCall1.implem", "input/eval/selectedCall2.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/B.xmi").getContents().get(0);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(
				"test.selectedCallOne.A.foo()\ntest.selectedCallOne.B.foo()\ntest.selectedCallTwo.A.foo()\ntest.selectedCallTwo.B.foo()",
				res.getValue());
	}

	@Test
	public void testSwitch()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/switch.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(2, res.getValue());
	}

	@Test
	public void testSwitchEClassGuard()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/switchEClassGuard.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(2, res.getValue());
	}

	@Test
	public void testSwitchBooleanGuard()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/switchBooleanGuard.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(2, res.getValue());
	}

	@Test
	public void testSwitchDefault()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/switchDefault.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(1, res.getValue());
	}

	@Test
	public void testSwitchBoth()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/switchBoth.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(4, res.getValue());
	}

	@Test
	public void testSwitchVarRef()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/switchVarRef.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(3, res.getValue());
	}

	@Test(expected=NullPointerException.class)
	public void testNoMain()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/nomain.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		interpreter.eval(caller, null, Arrays.asList(), semantics);
	}

	@Test
	public void testListener()  throws ClosedALEInterpreterException {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"), Arrays.asList("input/eval/attributeCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		Method main = semantics.getMainMethods().get(0);

		interpreter.addListener(new ServiceCallListener() {
			@Override
			public void preCall(IService service, Object[] arguments) {
				System.out.println("In:" + service.getName());
			}

			@Override
			public void postCall(IService service, Object[] arguments, Object result) {
				System.out.println("Out:" + service.getName());
			}
		});
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(3, res.getValue());
		assertEquals("In:aqlFeatureAccess\nOut:aqlFeatureAccess\nIn:getSelf\nOut:getSelf\n", outContent.toString());

		System.setOut(null);
	}

	@Test
	public void testAssignDynamicCollectionAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/assignDynamicCollectionAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("1 1", res.getValue());
	}

	@Test
	public void testAssignCollectionAttribute()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/assignCollectionAttribute.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals("1 ClassA", res.getValue());
	}

	@Test
	public void testInsertLocalVariable()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/insertLocalVariable.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertTrue(res.getValue() instanceof List);
		assertEquals(3, ((List) res.getValue()).size());
		assertEquals(caller.eClass(), ((EObject) ((List) res.getValue()).get(0)).eClass());
		assertEquals(caller.eClass(), ((EObject) ((List) res.getValue()).get(1)).eClass());
		assertEquals(caller.eClass(), ((EObject) ((List) res.getValue()).get(2)).eClass());
	}

	@Test
	public void testRemoveLocalVariable()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/removeLocalVariable.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertTrue(res.getValue() instanceof List);
		assertEquals(2, ((List) res.getValue()).size());
		assertEquals(caller.eClass(), ((EObject) ((List) res.getValue()).get(0)).eClass());
		assertEquals(caller.eClass(), ((EObject) ((List) res.getValue()).get(1)).eClass());
	}

	@Test
	public void testCallMissingMethod()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/test.ecore"),
				Arrays.asList("input/eval/callMissingMethod.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment()))
				.parse(environment);
		DslSemantics semantics = new ImmutableDslSemantics(parsedSemantics);
		EObject caller = interpreter.loadModel("model/ClassA.xmi").getContents().get(0);
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = interpreter.eval(caller, main, Arrays.asList(), semantics);

		assertEquals(Diagnostic.WARNING, res.getDiagnostic().getSeverity());
		assertEquals("An error occured during evaluation of a query", res.getDiagnostic().getMessage());
	}
}
