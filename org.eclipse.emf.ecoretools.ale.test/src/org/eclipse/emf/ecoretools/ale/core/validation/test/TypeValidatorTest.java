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
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.core.validation.ALEValidator;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.junit.Before;
import org.junit.Test;

/**
 * Check type errors raised by the ModelBehavior validator
 */
public class TypeValidatorTest {
	
	ALEInterpreter interpreter;
	
	@Before
	public void setup(){
		interpreter = new ALEInterpreter();
	}
	
	@Test
	public void testTypeErrorAttribute(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/typeErrorAttrib.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 81, "Expected EString but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testTypeErrorLocal(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/typeErrorLocal.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 73, 90, "Expected EString but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testScopeTypeErrorLocal(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/scopeTypeErrorLocal.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 92, 109, "Expected [EClassifier=EInt] but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testLocalAssignTypeError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignLocalTypeError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 113, 130, "Expected [EClassifier=EInt] but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testAttributeAssignTypeError(){ //dynamic attribute
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignAttributeTypeError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 82, 101, "Expected [EString] but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testFeatureAssignTypeError(){ //EStructural feature
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignFeatureTypeError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 83, "Expected [EPackage] but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testResultAssignTypeError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignResult.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 63, 74, "'result' is assigned in void operation", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 122, 133, "Expected EString but was [java.lang.Integer]", msg.get(1));
	}
	
	@Test
	public void testFeatureInsertTypeError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureInsertTypeError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 61, 91, "Expected [EClass] but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testFeatureRemoveTypeError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureRemoveTypeError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 60, 93, "Expected [EClass] but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testForEachCollectionError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/forEachCollectionError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 70, 73, "Expected Collection but was [java.lang.Boolean]", msg.get(0));
	}
	
	@Test
	public void testIfBooleanError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/ifBooleanError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 63, 69, "Expected Boolean but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testWhileBooelanError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/whileBooleanError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 69, 78, "Expected Boolean but was [java.lang.String]", msg.get(0));
	}
	
	
	private void assertMsgEquals(ValidationMessageLevel errorLvl, int startPos, int endPos, String text, IValidationMessage msg){
		assertEquals(errorLvl, msg.getLevel());
		assertEquals(startPos, msg.getStartPosition());
		assertEquals(endPos, msg.getEndPosition());
		assertEquals(text, msg.getMessage());
	}
}
