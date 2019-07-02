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
package org.eclipse.emf.ecoretools.ale.core.validation.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.core.validation.ALEValidator;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.junit.Before;
import org.junit.Test;

public class OpenClassValidationTest {
	ALEInterpreter interpreter;
	
	@Before
	public void setup(){
		interpreter = new ALEInterpreter();
	}
	
	@Test
	public void testMultiInherits() {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/multiInherits.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testInvertMultiInherits() {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/invertMultiInherits.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 280, 352, "The extended EClass C have to be after B", msg.get(0));
	}
	
	@Test
	public void testServeralOpenClass() {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/simple.implem","input/lookup/implicitExtend.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 32, 148, "The EClass A is already opened (need explicit extends)", msg.get(0));
	}
	
	@Test
	public void testForbidenExtends() {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/forbiddenExtend.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 212, 282, "Can't extend diamon::B since it is not a direct super type of diamon::C", msg.get(0));
	}
	
	@Test
	public void testIndirectExtends() {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/indirectExtend.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 212, 282, "Can't extend diamon::A since it is not a direct super type of diamon::D", msg.get(0));
	}
	
	@Test
	public void testDirectExtend() {
		Dsl environment = new Dsl(Arrays.asList("model/diamon.ecore"),Arrays.asList("input/lookup/directExtend.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	private EObject create(String className) {
		EClassifier cls = interpreter.getQueryEnvironment().getEPackageProvider().getTypes(className).iterator().next();
		return EcoreUtil.create((EClass) cls);
	}
	
	private void assertMsgEquals(ValidationMessageLevel errorLvl, int startPos, int endPos, String text, IValidationMessage msg){
		assertEquals(errorLvl, msg.getLevel());
		assertEquals(startPos, msg.getStartPosition());
		assertEquals(endPos, msg.getEndPosition());
		assertEquals(text, msg.getMessage());
	}
}
