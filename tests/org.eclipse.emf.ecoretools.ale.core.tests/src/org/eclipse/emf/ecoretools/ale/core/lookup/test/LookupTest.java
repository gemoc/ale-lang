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
package org.eclipse.emf.ecoretools.ale.core.lookup.test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.core.env.ClosedAleEnvironmentException;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.IBehaviors;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.sirius.common.tools.api.interpreter.IEvaluationResult;
import org.junit.After;
import org.junit.Test;

public class LookupTest {

	IAleEnvironment environment;

	@After
	public void release() {
		if (environment != null) {
			environment.close();
		}
	}
	
	@Test
	public void testInherits()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/lookup/inherits.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/A.xmi")).get(0);
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals("a.foo:b.foo:c.foo",res.getValue());
	}
	
	@Test
	public void testInheritsWithParam()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/lookup/inheritsWithParam.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/A.xmi")).get(0);
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals("a.foo:b.foo:c.foo",res.getValue());
	}
	
	@Test
	public void testExtends()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/lookup/inherits.implem","input/lookup/extends.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/A.xmi")).get(0);
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals("a.foo2:b.foo:c.foo",res.getValue());
	}
	
	@Test
	public void testMultiInherits()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/multi.ecore"),asList("input/lookup/multi.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/C.xmi")).get(0);
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals("b.foo",res.getValue());
	}
	
	@Test
	public void testDoubleMultiInherits()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/doubleMulti.ecore"),asList("input/lookup/doubleMulti.implem"));
		
		EObject caller = create("C");
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals("b.foo a.foo",res.getValue());
	}
	
	@Test
	public void testSimple()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/simple.implem"));
		
		EObject caller = create("A");
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals("a.foo",res.getValue());
	}
	
	@Test
	public void testImplicitInherit()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/simple.implem"));
		
		EObject caller = create("B");
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals("a.foo",res.getValue());
	}
	
	@Test
	public void testImplicitExtend()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/implicitExtend.implem"));
		
		EObject caller = create("B");
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals("b.foo",res.getValue());
	}
	
	@Test
	public void testExplicitExtend()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/explicitExtend.implem"));
		
		EObject caller = create("B");
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals("b.foo",res.getValue());
	}
	
	@Test
	public void testClosestExtend()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/implicitExtend.implem"));
		
		EObject caller = create("D");
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals("b.foo",res.getValue());
	}
	
	@Test
	public void testSimpleLowerType()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/simpleLowerType.implem"));
		
		EObject caller = create("A");
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(create("A")));
		
		assertEquals("a.foo(a)",res.getValue());
	}
	
	@Test
	public void testSimpleLowerType2()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/simpleLowerType.implem"));
		
		EObject caller = create("A");
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(create("B")));
		
		assertEquals("a.foo(b)",res.getValue());
	}
	
	@Test
	public void testLowerType() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/lowerType.implem"));
		
		EObject caller = create("B");
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(create("A")));
		
		assertEquals("a.foo(a)",res.getValue());
	}
	
	@Test
	public void testLowerType2()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/lowerType.implem"));
		
		EObject caller = create("B");
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(create("B")));
		
		assertEquals("b.foo(b)",res.getValue());
	}
	
	@Test
	public void testLowerType3()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/lowerType.implem"));
		
		EObject caller = create("A");
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(create("B")));
		
		assertEquals("a.foo(a)",res.getValue());
	}
	
	@Test
	public void testLowerTypeInverted()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/lowerTypeInverted.implem"));
		
		EObject caller = create("B");
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(create("A")));
		
		assertEquals("b.foo(a)",res.getValue());
	}
	
	@Test
	public void testLowerTypeInverted2()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/lowerTypeInverted.implem"));
		
		EObject caller = create("B");
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList(create("B")));
		
		assertEquals("b.foo(a)",res.getValue());
	}
	
	@Test
	public void testInheritGetter()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/lookup/inheritGetter.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/B.xmi")).get(0);
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals(42,res.getValue());
	}
	
	@Test
	public void testInheritSetter()  throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/lookup/inheritSetter.implem"));
		
		EObject caller = environment.loadModel(URI.createURI("model/B.xmi")).get(0);
		IBehaviors semantics = environment.getBehaviors();
		Method main = semantics.getMainMethods().get(0);
		IEvaluationResult res = environment.getInterpreter().eval(caller, main, asList());
		
		assertEquals(43,res.getValue());
	}
	
	private EObject create(String className) {
		// Make sure ALE sources have been loaded
		environment.getBehaviors();
		
		EClassifier cls = environment.getContext().getEPackageProvider().getTypes(className).iterator().next();
		return EcoreUtil.create((EClass) cls);
	}
}
