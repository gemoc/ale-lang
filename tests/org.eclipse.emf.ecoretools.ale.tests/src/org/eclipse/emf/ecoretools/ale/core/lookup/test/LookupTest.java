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

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter.ClosedALEInterpreterException;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LookupTest {
	
	ALEInterpreter interpreter;
	
	@Before
	public void setup() {
		interpreter = new ALEInterpreter();
	}

	@After
	public void release() throws IOException {
		if (interpreter != null) {
			interpreter.close();
		}
	}
	
	@Test
	public void testInherits()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/lookup/inherits.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/A.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("a.foo:b.foo:c.foo",res.getValue());
	}
	
	@Test
	public void testInheritsWithParam()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/lookup/inheritsWithParam.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/A.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("a.foo:b.foo:c.foo",res.getValue());
	}
	
	@Test
	public void testExtends()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/lookup/inherits.implem","input/lookup/extends.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/A.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("a.foo2:b.foo:c.foo",res.getValue());
	}
	
	@Test
	public void testMultiInherits()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/multi.ecore"),Arrays.asList("input/lookup/multi.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/C.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("b.foo",res.getValue());
	}
	
	@Test
	public void testDoubleMultiInherits()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/doubleMulti.ecore"),Arrays.asList("input/lookup/doubleMulti.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("C");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("b.foo a.foo",res.getValue());
	}
	
	@Test
	public void testSimple()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/simple.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("A");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("a.foo",res.getValue());
	}
	
	@Test
	public void testImplicitInherit()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/simple.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("B");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("a.foo",res.getValue());
	}
	
	@Test
	public void testImplicitExtend()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/implicitExtend.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("B");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("b.foo",res.getValue());
	}
	
	@Test
	public void testExplicitExtend()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/explicitExtend.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("B");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("b.foo",res.getValue());
	}
	
	@Test
	public void testClosestExtend()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/implicitExtend.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("D");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("b.foo",res.getValue());
	}
	
	@Test
	public void testSimpleLowerType()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/simpleLowerType.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("A");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(create("A")), parsedSemantics);
		
		assertEquals("a.foo(a)",res.getValue());
	}
	
	@Test
	public void testSimpleLowerType2()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/simpleLowerType.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("A");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(create("B")), parsedSemantics);
		
		assertEquals("a.foo(b)",res.getValue());
	}
	
	@Test
	public void testLowerType() throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/lowerType.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("B");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(create("A")), parsedSemantics);
		
		assertEquals("a.foo(a)",res.getValue());
	}
	
	@Test
	public void testLowerType2()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/lowerType.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("B");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(create("B")), parsedSemantics);
		
		assertEquals("b.foo(b)",res.getValue());
	}
	
	@Test
	public void testLowerType3()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/lowerType.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("A");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(create("B")), parsedSemantics);
		
		assertEquals("a.foo(a)",res.getValue());
	}
	
	@Test
	public void testLowerTypeInverted()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/lowerTypeInverted.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("B");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(create("A")), parsedSemantics);
		
		assertEquals("b.foo(a)",res.getValue());
	}
	
	@Test
	public void testLowerTypeInverted2()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/lowerTypeInverted.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("B");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(create("B")), parsedSemantics);
		
		assertEquals("b.foo(a)",res.getValue());
	}
	
	@Test
	public void testInheritGetter()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/lookup/inheritGetter.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/B.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(42,res.getValue());
	}
	
	@Test
	public void testInheritSetter()  throws ClosedALEInterpreterException {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/lookup/inheritSetter.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/B.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals(43,res.getValue());
	}
	
	private EObject create(String className) {
		EClassifier cls = interpreter.getQueryEnvironment().getEPackageProvider().getTypes(className).iterator().next();
		return EcoreUtil.create((EClass) cls);
	}
}
