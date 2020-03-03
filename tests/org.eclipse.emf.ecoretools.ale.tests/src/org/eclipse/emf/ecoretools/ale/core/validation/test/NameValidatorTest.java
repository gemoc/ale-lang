/*******************************************************************************
 * Copyright (c) 2017-2019 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.validation.test;

import static org.eclipse.emf.ecoretools.ale.core.validation.test.ValidationMessages.assertMsgEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.impl.RuntimeAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.core.validation.ALEValidator;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.junit.Before;
import org.junit.Test;

/**
 * Check name errors raised by the ModelBehavior validator
 */
public class NameValidatorTest {

	ALEInterpreter interpreter;
	
	@Before
	public void setup(){
		interpreter = new ALEInterpreter();
	}
	
	/*
	 * Test unique name for ModelUnit
	 */
	@Test
	public void testUniqueModelUnit() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/unit1.implem","input/validation/unit2.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 0, 0, "The name test.unit is already used", msg.get(0));
	}
	
	/*
	 * Test unique name for RuntimeClass in a ModelUnit
	 */
	@Test
	public void testUniqueRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/uniqueRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 57, 81, "The name MyRuntimeClass is already used", msg.get(0));
	}
	
	/*
	 * Test same name for RuntimeClass in a different ModelUnit is OK
	 */
	@Test
	public void testGlobalUniqueRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/uniqueRuntimeClassGlobal1.implem","input/validation/uniqueRuntimeClassGlobal2.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test unique def method in RuntimeClass
	 */
	@Test
	public void testUniqueMethodRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/operationDuplicationRuntime.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 67, 83, "The operation op() is already declared", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 143, 171, "The operation mtd(EString) is already declared", msg.get(1));
	}
	
	/*
	 * Test unique def method in ExtendedClass
	 */
	@Test
	public void testUniqueMethodExtendedClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/operationDuplication.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 80, "The operation op() is already declared", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 140, 168, "The operation mtd(EString) is already declared", msg.get(1));
	}
	
	/*
	 * Test def must be override
	 */
	@Test
	public void testDefIsOverride() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/defOverrideConflict.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 56, 83, "The operation getFeatureCount() must override", msg.get(0));
	}
	
	/*
	 * Test override not found
	 */
	@Test
	public void testOverrideNotFound() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/overrideNotFound.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 53, 86, "Can't find matching EOperation in EClass", msg.get(0));
	}
	
	/*
	 * Test unique parameter in RuntimeClass
	 */
	@Test
	public void testUniqueParamRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/duplicatedParametersRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 46, 85, "The name param is already used", msg.get(0));
	}
	
	/*
	 * Test self parameter in RuntimeClass
	 */
	@Test
	public void testSelfParamRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/selfParamRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 48, 71, "'self' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test result parameter in RuntimeClass
	 */
	@Test
	public void testResultParamRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/resultParamRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 48, 73, "'result' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test unique parameter in ExtendedClass
	 */
	@Test
	public void testUniqueParamExtendedClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/duplicatedParameters.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 43, 82, "The name param is already used", msg.get(0));
	}
	
	/*
	 * Test self parameter in ExtendedClass
	 */
	@Test
	public void testSelfParamExtendedClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/selfParamExtendedClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 45, 68, "'self' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test result parameter in ExtendedClass
	 */
	@Test
	public void testResultParamExtendedClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/resultParamExtendedClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 45, 70, "'result' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test unique attribute in RuntimeClass
	 */
	@Test
	public void testUniqueAttributeRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/duplicatedAttribRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 74, 95, "The name newAttribute is already used", msg.get(0));
	}
	
	/*
	 * Test self attribute in RuntimeClass
	 */
	@Test
	public void testSelfAttributeRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/selfAttributeRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 48, 61, "'self' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test result attribute in RuntimeClass
	 */
	@Test
	public void testResultAttributeRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/resultAttributeRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 48, 63, "'result' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test unique attribute in ExtendedClass
	 */
	@Test
	public void testUniqueAttributeExtendedClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/duplicatedAttrib.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 71, 92, "The name newAttribute is already used", msg.get(0));
	}
	
	/*
	 * Test self attribute in ExtendedClass
	 */
	@Test
	public void testSelfAttributeExtendedClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/selfAttributeExtendedClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 45, 58, "'self' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test result attribute in ExtendedClass
	 */
	@Test
	public void testResultAttributeExtendedClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/resultAttributeExtendedClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 45, 60, "'result' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test attribute exist in EClass
	 */
	@Test
	public void testExistingAttribute() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/conflictAttrib.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 45, 61, "The name abstract is already used", msg.get(0));
	}
	
	/*
	 * Test local variable conflict parameter
	 */
	@Test
	public void testConflictLocalParam() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/conflictAttribParamLocal.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 87, 99, "The name foo is already used", msg.get(0));
	}
	
	/*
	 * Test local variable is self
	 */
	@Test
	public void testLocalSelf() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/declareSelfError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 45, 58, "'self' is a reserved name", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 61, 101, "'self' is a reserved name", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 85, 98, "'self' is a reserved name", msg.get(2));
	}
	
	/*
	 * Test local variable is result
	 */
	@Test
	public void testLocalResult() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/declareResultError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 44, 59, "'result' is a reserved name", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 62, 106, "'result' is a reserved name", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 88, 103, "'result' is a reserved name", msg.get(2));
	}
	
	/*
	 * Test conflict of local variables in one block
	 */
	@Test
	public void testLocalBlockConflict() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/duplicatedLocalVariable.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 82, 99, "The name localVar is already used", msg.get(0));
	}
	
	/*
	 * Test local variable conflict in other blocks
	 */
	@Test
	public void testLocalNoExternalConflit() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/scopeLocalVariable.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 93, 110, "The name localVar is already used", msg.get(0));
	}
	
	/*
	 * Test local variable doesn't conflict attribute
	 */
	@Test
	public void testLocalAttributeConflict() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/localAttribNoConflict.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assign existing variable
	 */
	@Test
	public void testAssignExistingVar() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/assignLocal.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assign not existing variable
	 */
	@Test
	public void testAssignNotExistingVar() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/assignUnknownLocal.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 65, 82, "The variable wrong is not defined", msg.get(0));
	}
	
	/*
	 * Test assign self
	 */
	@Test
	public void testAssignSelf() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/assignSelfError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 92, "'self' can't be assigned", msg.get(0));
	}
	
	/*
	 * Test assign a parameter
	 */
	@Test
	public void testAssignParam() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/assignParamError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 74, 85, "param is a parameter and can't be assigned", msg.get(0));
	}
	
	/*
	 * Test assign existing feature from EClass
	 */
	@Test
	public void testAssignEClassFeature() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/assignEClassAttrib.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assign existing feature from ExtendedClass
	 */
	@Test
	public void testAssignFeatureExtendedClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/assignAttribExtendedClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assign existing feature from RuntimeClass
	 */
	@Test
	public void testAssignFeatureRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/assignAttribRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assign not existing feature from ExtendedClass
	 */
	@Test
	public void testAssignNotExistingFeatureExtendedClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/assignUnknownFeature.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 86, "The feature wrong is not defined", msg.get(0));
	}
	
	/*
	 * Test assign existing feature from RuntimeClass
	 */
	@Test
	public void testAssignNotExistingFeatureRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/assignUnknownFeatureRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 67, 89, "The feature wrong is not defined", msg.get(0));
	}
	
	/*
	 * Test insert in existing feature from EClass
	 */
	@Test
	public void testInsertEClassFeature() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/insertEClassAttrib.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test insert in existing feature from ExtendedClass
	 */
	@Test
	public void testInsertFeatureExtendedClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/insertAttribExtendedClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test insert in existing feature from RuntimeClass
	 */
	@Test
	public void testInsertFeatureRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/insertAttribRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test insert in not existing feature from ExtendedClass
	 */
	@Test
	public void testInsertNotExistingFeatureExtendedClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/insertUnknownFeatureExtendedClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 86, "The feature wrong is not defined", msg.get(0));
	}
	
	/*
	 * Test insert in existing feature from RuntimeClass
	 */
	@Test
	public void testInsertNotExistingFeatureRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/insertUnknownFeatureRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 67, 89, "The feature wrong is not defined", msg.get(0));
	}
	
	//Remove idem
	
	/*
	 * Test remove in existing feature from EClass
	 */
	@Test
	public void testRemoveEClassFeature() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/removeEClassAttrib.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test remove in existing feature from ExtendedClass
	 */
	@Test
	public void testRemoveFeatureExtendedClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/removeAttribExtendedClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test remove in existing feature from RuntimeClass
	 */
	@Test
	public void testRemoveFeatureRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/removeAttribRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test remove in not existing feature from ExtendedClass
	 */
	@Test
	public void testRemoveNotExistingFeatureExtendedClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/removeUnknownFeatureExtendedClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 86, "The feature wrong is not defined", msg.get(0));
	}
	
	/*
	 * Test remove in existing feature from RuntimeClass
	 */
	@Test
	public void testRemoveNotExistingFeatureRuntimeClass() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/removeUnknownFeatureRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 67, 89, "The feature wrong is not defined", msg.get(0));
	}
	
	/*
	 * Test ForEach variable conflict with parameter
	 */
	@Test
	public void testForEachParam() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/forEachParamConflict.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 70, 95, "The name param is already used", msg.get(0));
	}
	
	/*
	 * Test ForEach variable is result
	 */
	@Test
	public void testForEachResult() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/forEachResult.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 61, 87, "'result' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test ForEach variable is self
	 */
	@Test
	public void testForEachSelf() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/forEachSelf.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 61, 85, "'self' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test ForEach variable conflict with other blocks
	 */
	@Test
	public void testForEachExternalBlocks() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/forEachExternalBlock.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 83, 153, "The name localDef is already used", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 83, 153, "The name localDef is already used", msg.get(0));
	}
	
	/*
	 * Test access to dynamic feature (in expression) doesn't rise 'Feature not found' error
	 */
	@Test
	public void testFeatureAccessType() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/featureAccessTypes.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test access to dynamic feature (in expression) rises 'Feature not found' error
	 */
	@Test
	public void testUnknownFeatureAccessType() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/featureAccessTypesError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals("messages: " + msg, 1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 112, 117, "Feature wrong not found in EClass EClass", msg.get(0));
	}
	
	/*
	 * Test value of result conflict the return type void
	 */
	@Test
	public void testReturnAssignVoid() {
		IAleEnvironment environment = new RuntimeAleEnvironment(Arrays.asList(),Arrays.asList("input/validation/assignVoid.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 65, 76, "Cannot assign 'result' in a void operation", msg.get(0));
	}
}
