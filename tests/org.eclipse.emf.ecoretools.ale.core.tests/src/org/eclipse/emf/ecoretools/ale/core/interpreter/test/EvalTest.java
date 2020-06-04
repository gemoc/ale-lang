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

import static java.lang.System.lineSeparator;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.core.env.ClosedAleEnvironmentException;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.IBehaviors;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IServiceCallListener;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * This class test the execution of ModelBehavior
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EvalTest {

	IAleEnvironment environment;

	@After
	public void release() {
		if (environment != null) {
			environment.close();
		}
	}

	@Test
	public void testAccessLocalVariable() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/localvar.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("foobar", res.getValue());
	}

	@Test
	public void testAccessParameter() throws ClosedAleEnvironmentException {
		String obj = "";
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/args.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(obj));

		assertEquals(obj, res.getValue());
	}

	@Test
	public void testAccessSelf() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/self.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(caller, res.getValue());
	}

	@Test
	public void testAccessSelfDynamicAttribute() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/selfDynamicAttribute.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("foo", res.getValue());
	}

	@Test
	public void testAccessCreateDynamicAttribute() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/createDynamicAttribute.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("foo", res.getValue());
	}

	@Test
	public void testAccessLocalDynamicAttribute() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/localDynamicAttribute.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("foo", res.getValue());
	}

	@Test
	public void testAccessParamDynamicAttribute() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/paramDynamicAttribute.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(newInstance));

		assertEquals("foo", res.getValue());
	}

	@Test
	public void testAccessResultDynamicAttribute() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/resultDynamicAttribute.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("foo", res.getValue());
	}

	@Test
	public void testAccessCallDynamicAttribute() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/callDynamicAttribute.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("foo", res.getValue());
	}

	@Test
	public void testNullDynamicAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/nullDynamicAttribute.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(Diagnostic.OK, res.getDiagnostic().getSeverity());
		assertEquals(null, res.getValue());
	}

	@Test
	public void testUnknownDynamicAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/unknownDynamicAttribute.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(Diagnostic.WARNING, res.getDiagnostic().getSeverity());
		assertEquals("An error occured during evaluation of a query", res.getDiagnostic().getMessage());
		assertEquals(null, res.getValue());
	}

	@Test
	public void testAccessSelfAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/selfAttribute.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		caller.eSet(field, 1);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(1, res.getValue());
	}

	@Test
	public void testAccessLocalAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/localAttribute.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		caller.eSet(field, 2);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(2, res.getValue());
	}

	@Test
	public void testAccessParamAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/paramAttribute.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		EStructuralFeature field = newInstance.eClass().getEStructuralFeature("field");
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		newInstance.eSet(field, 3);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(newInstance));

		assertEquals(3, res.getValue());
	}

	@Test
	public void testAccessResultAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/resultAttribute.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		caller.eSet(field, 4);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(4, res.getValue());
	}

	@Test
	public void testAccessCallAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/callAttribute.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		caller.eSet(field, 5);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(res.getDiagnostic().toString(), 5, res.getValue());
	}

	@Test
	public void testAssignSelfDynamicAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/selfDynamicAttributeAssign.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("bar", res.getValue());
	}

	@Test
	public void testAssignLocalDynamicAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/localDynamicAttributeAssign.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("bar", res.getValue());
	}

	@Test
	public void testAssignParamDynamicAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/paramDynamicAttributeAssign.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(newInstance));

		assertEquals("bar", res.getValue());
	}

	@Test
	public void testAssignResultDynamicAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/resultDynamicAttributeAssign.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("bar", res.getValue());
	}

	@Test
	public void testAssignCallDynamicAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/callDynamicAttributeAssign.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("bar", res.getValue());
	}

	@Test
	public void testAssignSelfAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/selfAttributeAssign.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(1, res.getValue());
	}

	@Test
	public void testAssignLocalAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/localAttributeAssign.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(2, res.getValue());
	}

	@Test
	public void testAssignParamAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/paramAttributeAssign.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(newInstance));

		assertEquals(3, res.getValue());
	}

	@Test
	public void testAssignResultAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/resultAttributeAssign.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(4, res.getValue());
	}

	@Test
	public void testAssignCallAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/callAttributeAssign.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(5, res.getValue());
	}

	@Test
	public void testSelfCall()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/selfCall.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(1, res.getValue());
	}

	@Test
	public void testLocalCall()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/localCall.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(2, res.getValue());
	}

	@Test
	public void testAttributeCall()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/attributeCall.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(3, res.getValue());
	}

	@Test
	public void testDynamicAttributeCall()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/dynamicAttributeCall.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(4, res.getValue());
	}

	@Test
	public void testParamCall()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/paramCall.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		EObject newInstance = EcoreUtil.create(caller.eClass());
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(newInstance));

		assertEquals(5, res.getValue());
	}

	@Test
	public void testParamValue()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/paramValue.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(6, res.getValue());
	}

	@Test
	public void testResultCall()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/resultCall.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(6, res.getValue());
	}

	@Test
	public void testChainAttrib()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/chainAttribute.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(caller, res.getValue());
	}

	@Test
	public void testChainDynamicAttrib()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/chainDynamicAttribute.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(caller, res.getValue());
	}

	@Test
	public void testChainCall()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/chainCall.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(caller, res.getValue());
	}

	@Test
	public void testForEachSequence()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/forEachSequence.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("012345", res.getValue());
	}

	@Test
	public void testForEachReverseSequence()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/forEachReverseSequence.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("4321", res.getValue());
	}

	@Test
	public void testForEachCollection()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/forEachCollection.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(2, res.getValue());
	}

	@Test
	public void testForEachEmpty()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/forEachEmptyCollection.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(0, res.getValue());
	}

	@Test
	public void testWhile()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/while.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(10, res.getValue());
	}

	@Test
	public void testIfTrue()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/ifTrue.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(1, res.getValue());
	}

	@Test
	public void testIfFalse()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/ifFalse.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(0, res.getValue());
	}

	@Test
	public void testElseTrue()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/elseTrue.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(1, res.getValue());
	}

	@Test
	public void testElseFalse()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/elseFalse.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(2, res.getValue());
	}

	@Test
	public void testElseIf()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/elseIf.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("345", res.getValue());
	}

	@Test
	public void testAdd()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/add.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(3, res.getValue());
	}

	@Test
	public void testRemove()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/remove.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(2, res.getValue());
	}

	@Test
	public void testLog()  throws ClosedAleEnvironmentException {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/log.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());

		assertEquals("foobar" + lineSeparator(), outContent.toString());

		System.setOut(null);

	}

	@Test
	public void testCreate()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/create.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertNotNull(res.getValue());
		assertNotEquals(caller, res.getValue());
		assertTrue(res.getValue() instanceof EObject);
		assertTrue(((EObject) res.getValue()).eClass().getName().equals("ClassA"));
	}

	@Test
	public void testService()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/service.implem"));
		ServiceUtils.registerServices(
				environment.getContext(),
				ServiceUtils.getServices(environment.getContext(),Service.class)
		);
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("foobar:ClassA", res.getValue());
	}

	@Test
	public void testNewClass()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/newClass.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertNotNull(res.getValue());
		assertNotEquals(caller, res.getValue());
		assertTrue(res.getValue() instanceof EObject);
		assertEquals("NewRuntimeClass", ((EObject) res.getValue()).eClass().getName());
	}

	@Test
	public void testOppositeAssign()  throws ClosedAleEnvironmentException {
		/*
		 * Check NewClass to self
		 */
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/opposite.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());
		Object value = res.getValue();
		
		assertTrue("got: " + (value == null ? "null" : value.getClass()) + ", expected: EObject", res.getValue() instanceof EObject);
		assertNotEquals(caller, res.getValue());
		assertEquals("NewClass", ((EObject) res.getValue()).eClass().getName());
	}

	@Test
	public void testOppositeAssign2()  throws ClosedAleEnvironmentException {
		/*
		 * Check self to NewClass
		 */
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/opposite2.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertTrue(res.getValue() instanceof EObject);
		assertEquals(caller, res.getValue());
	}

	@Test
	public void testOppositeAssign3()  throws ClosedAleEnvironmentException {
		/*
		 * Check ClassA to self
		 */
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/opposite3.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertTrue(res.getValue() instanceof EObject);
		assertEquals(caller, res.getValue());
	}

	@Test
	public void testOppositeAssign4()  throws ClosedAleEnvironmentException {
		/*
		 * Check NewClass to NewClass
		 */
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/opposite4.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertNotNull(res.getValue());
		assertNotEquals(caller, res.getValue());
		assertEquals("obj1", res.getValue());
	}

	@Test
	public void testContainsDynamicEContainer()  throws ClosedAleEnvironmentException {
		/*
		 * Check eContainer()
		 */
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/containsDynamicEContainer.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertNotNull(res.getValue());
		assertEquals(caller, res.getValue());
	}

	@Test
	public void testContainsDoubelAssign()  throws ClosedAleEnvironmentException {
		/*
		 * Check double assignment
		 */
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/containsDoubleAssign.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertNull(res.getValue());
	}

	@Test
	public void testContainsSelfEContainer()  throws ClosedAleEnvironmentException {
		/*
		 * Check self.eContainer()
		 */
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/containsSelfEContainer.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertTrue(res.getValue() instanceof EObject);
		assertEquals("NewClass", ((EObject) res.getValue()).eClass().getName());
	}

	@Test
	public void testContainsEContents()  throws ClosedAleEnvironmentException {
		/*
		 * Check self.eContent()
		 */
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/containsEContents.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		Object value = res.getValue();
		assertTrue(value instanceof List);
		assertEquals(1, ((List<?>) value).size());

		Object contained = ((List<?>) value).get(0);
		assertTrue(contained instanceof EObject);
		assertEquals("NewClass", ((EObject) contained).eClass().getName());
	}

	@Test
	public void testContainsEAllContents()  throws ClosedAleEnvironmentException {
		/*
		 * Check self.eAllContent()
		 */
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/containsEAllContents.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA2.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

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
	public void testUniqueAssign()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/unique.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(1, res.getValue());
	}

	@Test
	public void testManyRemove()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/removeDynamic.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(1, res.getValue());
	}

	@Test
	public void testInitDynamicAttributeFailure()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/initDynamicAttributeFailure.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("ClassA", ((EObject) res.getValue()).eClass().getName());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		assertEquals("An error occured during initialization of an EObject",
				environment.getInterpreter().getLogger().getLog().get(0).getMessage());
	}
	
	@Test
	public void testInitLocalVariable() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/attributesOfDifferentTypes.ecore"), asList("input/eval/initLocalVariables.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/Mix.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals("int should be initialized to 0", 0, caller.eGet(caller.eClass().getEStructuralFeature("int")));
		assertEquals("bool should be initialized to false", false, caller.eGet(caller.eClass().getEStructuralFeature("bool")));
		assertEquals("string should be initialized to an empty string", "", caller.eGet(caller.eClass().getEStructuralFeature("string")));
		assertEquals("sequence should be initialized to an empty sequence", new BasicEList<>(), caller.eGet(caller.eClass().getEStructuralFeature("strings")));
		assertEquals("set should be initialized to an empty set", new BasicEList<>(), caller.eGet(caller.eClass().getEStructuralFeature("integers")));
	}

	@Test
	public void testECrossRef()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/crossRef.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA3.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

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
	public void testECrossRefDynamic()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/crossRefDynamic.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		EObject arg = environment.loadModel(URI.createURI("model/ClassA3.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(arg));

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
	public void testEGet()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/eGet.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA3.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(5, res.getValue());
	}

	@Test
	public void testEGetDynamic()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/eGetDynamic.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA3.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(123, res.getValue());
	}

	@Test
	public void testSelectedCall()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/ABC.ecore"), asList("input/eval/selectedCallMain.implem",
				"input/eval/selectedCall1.implem", "input/eval/selectedCall2.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/B.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(
				"test.selectedCallOne.A.foo()\ntest.selectedCallOne.B.foo()\ntest.selectedCallTwo.A.foo()\ntest.selectedCallTwo.B.foo()",
				res.getValue());
	}

	@Test
	public void testSwitch()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/switch.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(2, res.getValue());
	}

	@Test
	public void testSwitchEClassGuard()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/switchEClassGuard.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(2, res.getValue());
	}

	@Test
	public void testSwitchBooleanGuard()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/switchBooleanGuard.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(2, res.getValue());
	}

	@Test
	public void testSwitchDefault()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/switchDefault.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(1, res.getValue());
	}

	@Test
	public void testSwitchBoth()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/switchBoth.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(4, res.getValue());
	}

	@Test
	public void testSwitchVarRef()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/switchVarRef.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(3, res.getValue());
	}

	@Test(expected=NullPointerException.class)
	public void testNoMain()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/nomain.implem"));
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		environment.getInterpreter().eval(caller, null, asList());
	}

	@Test
	public void testListener()  throws ClosedAleEnvironmentException {
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));

		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/eval/attributeCall.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);

		environment.getInterpreter().addServiceListener(new IServiceCallListener() {
			@Override
			public void preCall(IService service, Object[] arguments) {
				System.out.println("In:" + service.getName());
			}

			@Override
			public void postCall(IService service, Object[] arguments, Object result) {
				System.out.println("Out:" + service.getName());
			}
		});
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(3, res.getValue());
		assertEquals("In:aqlFeatureAccess" + lineSeparator() + "Out:aqlFeatureAccess" + lineSeparator() + "In:getSelf" + lineSeparator() + "Out:getSelf" + lineSeparator() + "", outContent.toString());

		System.setOut(null);
	}

	@Test
	public void testAssignDynamicCollectionAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/assignDynamicCollectionAttribute.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("1 1", res.getValue());
	}

	@Test
	public void testAssignCollectionAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/assignCollectionAttribute.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("1 ClassA", res.getValue());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testInsertLocalVariable()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/insertLocalVariable.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertTrue(res.getValue() instanceof List);
		assertEquals(3, ((List<?>) res.getValue()).size());
		assertEquals(caller.eClass(), ((EObject) ((List<EObject>) res.getValue()).get(0)).eClass());
		assertEquals(caller.eClass(), ((EObject) ((List<EObject>) res.getValue()).get(1)).eClass());
		assertEquals(caller.eClass(), ((EObject) ((List<EObject>) res.getValue()).get(2)).eClass());
	}

	@Test
	@SuppressWarnings("unchecked")
	public void testRemoveLocalVariable()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/removeLocalVariable.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertTrue(res.getValue() instanceof List);
		assertEquals(2, ((List<?>) res.getValue()).size());
		assertEquals(caller.eClass(), ((EObject) ((List<EObject>) res.getValue()).get(0)).eClass());
		assertEquals(caller.eClass(), ((EObject) ((List<EObject>) res.getValue()).get(1)).eClass());
	}

	@Test
	public void testCallMissingMethod()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/callMissingMethod.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals(Diagnostic.WARNING, res.getDiagnostic().getSeverity());
		assertEquals("An error occured during evaluation of a query", res.getDiagnostic().getMessage());
	}
	
	
	@Test
	@Ignore // for some reason it fails in CI but pass locally (from IDE & CLI)
			// should fix that but can't figure out why it fails so nevermind
	public void testCallMethodWithDouble()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"),
				asList("input/eval/doubleAsParameter.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		Method main = behaviors.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertNull("Unexpected errors: " + res.getDiagnostic(), res.getDiagnostic().getMessage());
		assertEquals(Diagnostic.OK, res.getDiagnostic().getSeverity());
	}
	
	@Test
	public void testCanAddAllToStaticCollectionAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/attributesOfDifferentTypes.ecore"),
				asList("input/eval/addAllCollectionWithOperator.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/Mix.xmi")).get(0);
		Method main = behaviors.getMainMethods().stream().filter(m -> m.getOperationRef().getName().equals("concatWithStaticAttribute")).findAny().get();
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertNull("Unexpected errors: " + res.getDiagnostic(), res.getDiagnostic().getMessage());
		assertEquals(Diagnostic.OK, res.getDiagnostic().getSeverity());
	}
	
	@Test
	public void testCannotAddAllDifferentCollectionTypeToStaticCollectionAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/attributesOfDifferentTypes.ecore"),
				asList("input/eval/addAllCollectionWithOperator.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/Mix.xmi")).get(0);
		Method main = behaviors.getMainMethods().stream().filter(m -> m.getOperationRef().getName().equals("concatWrongTypeWithStaticAttribute")).findAny().get();
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("Cannot add the value to 'strings': types mismatch", res.getDiagnostic().getMessage());
		assertEquals(Diagnostic.ERROR, res.getDiagnostic().getSeverity());
	}
	
	@Test
	public void testCanAddAllDynamicCollectionAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/attributesOfDifferentTypes.ecore"),
				asList("input/eval/addAllCollectionWithOperator.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/Mix.xmi")).get(0);
		Method main = behaviors.getMainMethods().stream().filter(m -> m.getOperationRef().getName().equals("concatWithDynamicAttribute")).findAny().get();
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertNull("Unexpected errors: " + res.getDiagnostic(), res.getDiagnostic().getMessage());
		assertEquals(Diagnostic.OK, res.getDiagnostic().getSeverity());
	}
	
	@Test
	@Ignore // This test fails but we currently have no easy way to fix it
			// see https://github.com/gemoc/ale-lang/issues/127
	public void testCannotAddAllDifferentCollectionTypeToDynamicCollectionAttribute()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/attributesOfDifferentTypes.ecore"),
				asList("input/eval/addAllCollectionWithOperator.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/Mix.xmi")).get(0);
		Method main = behaviors.getMainMethods().stream().filter(m -> m.getOperationRef().getName().equals("concatWrongTypeWithDynamicAttribute")).findAny().get();
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("Cannot add the value to 'dynStrings': types mismatch", res.getDiagnostic().getMessage());
		assertEquals(Diagnostic.ERROR, res.getDiagnostic().getSeverity());
	}
	
	@Test
	public void testCanAddAllLocalCollectionVariable()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/attributesOfDifferentTypes.ecore"),
				asList("input/eval/addAllCollectionWithOperator.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/Mix.xmi")).get(0);
		Method main = behaviors.getMainMethods().stream().filter(m -> m.getOperationRef().getName().equals("concatWithLocalVariable")).findAny().get();
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertNull("Unexpected errors: " + res.getDiagnostic(), res.getDiagnostic().getMessage());
		assertEquals(Diagnostic.OK, res.getDiagnostic().getSeverity());
	}
	
	@Test
	@Ignore // This test fails but we currently have no easy way to fix it
			// see https://github.com/gemoc/ale-lang/issues/128
	public void testCannotAddAllDifferentCollectionTypeToLocalCollectionVariable()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/attributesOfDifferentTypes.ecore"),
				asList("input/eval/addAllCollectionWithOperator.implem"));
		IBehaviors behaviors = environment.getBehaviors();
		EObject caller = environment.loadModel(URI.createURI("model/Mix.xmi")).get(0);
		Method main = behaviors.getMainMethods().stream().filter(m -> m.getOperationRef().getName().equals("concatWrongTypeWithLocalVariable")).findAny().get();
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());

		assertEquals("Cannot add the value to 'localNumbers': types mismatch", res.getDiagnostic().getMessage());
		assertEquals(Diagnostic.ERROR, res.getDiagnostic().getSeverity());
	}
	
	@Test
	public void testInsertSequence() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/attributesOfDifferentTypes.ecore"), asList("input/eval/insertOrderedSet.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/Mix.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals("+= sould allow to concatenate sets with sets and sequences", asList(1, 2, 3, 4, 5, 6), caller.eGet(caller.eClass().getEStructuralFeature("integers")));
	}
	
	@Test
	public void testRemoveSequence() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/attributesOfDifferentTypes.ecore"), asList("input/eval/removeOrderedSet.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/Mix.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals("-= sould allow to substract sets with sets and sequences", asList(2, 4), caller.eGet(caller.eClass().getEStructuralFeature("integers")));
	}
	
}
