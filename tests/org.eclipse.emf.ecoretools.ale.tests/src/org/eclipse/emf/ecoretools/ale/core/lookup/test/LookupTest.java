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

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.junit.Before;
import org.junit.Test;

public class LookupTest {
	
	ALEInterpreter interpreter;
	
	@Before
	public void setup() {
		interpreter = new ALEInterpreter();
	}
	
	@Test
	public void testInherits() {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/lookup/inherits.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/A.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("a.foo:b.foo:c.foo",res.getValue());
	}
	
	@Test
	public void testExtends() {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/lookup/inherits.implem","input/lookup/extends.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/A.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("a.foo2:b.foo:c.foo",res.getValue());
	}
	
	@Test
	public void testMultiInherits() {
		Dsl environment = new Dsl(Arrays.asList("model/multi.ecore"),Arrays.asList("input/lookup/multi.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/C.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("b.foo",res.getValue());
	}
	
	@Test
	public void testSimple() {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/simple.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("A");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("a.foo",res.getValue());
	}
	
	@Test
	public void testImplicitInherit() {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/simple.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("B");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("a.foo",res.getValue());
	}
	
	@Test
	public void testImplicitExtend() {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/implicitExtend.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("B");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("b.foo",res.getValue());
	}
	
	@Test
	public void testExplicitExtend() {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/explicitExtend.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("B");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("b.foo",res.getValue());
	}
	
	@Test
	public void testClosestExtend() {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/implicitExtend.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = create("D");
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("b.foo",res.getValue());
	}
	
	private EObject create(String className) {
		EClassifier cls = interpreter.getQueryEnvironment().getEPackageProvider().getTypes(className).iterator().next();
		return EcoreUtil.create((EClass) cls);
	}
}
