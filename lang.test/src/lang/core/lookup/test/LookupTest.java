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
package lang.core.lookup.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.junit.Before;
import org.junit.Test;

import implementation.ModelBehavior;
import lang.LangInterpreter;
import lang.core.parser.Dsl;
import lang.core.parser.DslBuilder;
import lang.core.parser.visitor.ParseResult;

public class LookupTest {
	
	LangInterpreter interpreter;
	
	@Before
	public void setup() {
		interpreter = new LangInterpreter();
	}
	
	@Test
	public void testInherits() {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/lookup/inherits.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/A.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("a.foo:b.foo:c.foo",res.getValue());
	}
	
	@Test
	public void testExtends() {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/lookup/inherits.implem","input/lookup/extends.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		EObject caller = interpreter.loadModel("model/A.xmi").getContents().get(0);
		IEvaluationResult res = interpreter.eval(caller, Arrays.asList(), parsedSemantics);
		
		assertEquals("a.foo2:b.foo:c.foo",res.getValue());
	}
}
