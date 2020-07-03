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

import static java.util.Arrays.asList;
import static org.eclipse.emf.ecoretools.ale.core.validation.test.ValidationMessages.assertMsgEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.validation.ALEValidator;
import org.junit.After;
import org.junit.Test;

/**
 * Check name errors raised by the ModelBehavior validator
 */
public class NameValidatorTest {

	IAleEnvironment env;
	
	@After
	public void setup(){
		if (env != null) {
			env.close();
		}
	}
	
	/*
	 * Test unique name for RuntimeClass in a ModelUnit
	 */
	@Test
	public void testUniqueRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/uniqueRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 57, 76, "The name MyRuntimeClass is already used", msg.get(0));
	}
	
	/*
	 * Test same name for RuntimeClass in a different ModelUnit is OK
	 */
	@Test
	public void testGlobalUniqueRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/uniqueRuntimeClassGlobal1.implem","input/validation/uniqueRuntimeClassGlobal2.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test unique def method in RuntimeClass
	 */
	@Test
	public void testUniqueMethodRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/operationDuplicationRuntime.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 67, 80, "The operation op() is already declared", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 143, 170, "The operation mtd(EString) is already declared", msg.get(1));
	}
	
	/*
	 * Test unique def method in ExtendedClass
	 */
	@Test
	public void testUniqueMethodExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/operationDuplication.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(msg.toString(), 2, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 64, 77, "The operation op() is already declared", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 140, 167, "The operation mtd(EString) is already declared", msg.get(1));
	}
	
	/*
	 * Test def must be override
	 */
	@Test
	public void testDefIsOverride() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/defOverrideConflict.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 56, 82, "Use the 'override' keyword to override the getFeatureCount() operation", msg.get(0));
	}
	
	/*
	 * Test override not found
	 */
	@Test
	public void testOverrideNotFound() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/overrideNotFound.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 53, 85, "Can't find matching EOperation in EClass", msg.get(0));
	}
	
	/*
	 * Test unique parameter in RuntimeClass
	 */
	@Test
	public void testUniqueParamRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/duplicatedParametersRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 46, 82, "The name param is already used", msg.get(0));
	}
	
	/*
	 * Test self parameter in RuntimeClass
	 */
	@Test
	public void testSelfParamRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/selfParamRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 48, 68, "'self' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test result parameter in RuntimeClass
	 */
	@Test
	public void testResultParamRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/resultParamRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 48, 70, "'result' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test unique parameter in ExtendedClass
	 */
	@Test
	public void testUniqueParamExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/duplicatedParameters.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 66, 78, "The name param is already used", msg.get(0));
	}
	
	/*
	 * Test self parameter in ExtendedClass
	 */
	@Test
	public void testSelfParamExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/selfParamExtendedClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 56, 64, "'self' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test result parameter in ExtendedClass
	 */
	@Test
	public void testResultParamExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/resultParamExtendedClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 56, 66, "'result' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test unique attribute in RuntimeClass
	 */
	@Test
	public void testUniqueAttributeRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/duplicatedAttribRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 74, 95, "The name newAttribute is already used", msg.get(0));
	}
	
	/*
	 * Test self attribute in RuntimeClass
	 */
	@Test
	public void testSelfAttributeRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/selfAttributeRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 48, 61, "'self' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test result attribute in RuntimeClass
	 */
	@Test
	public void testResultAttributeRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/resultAttributeRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 48, 63, "'result' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test unique attribute in ExtendedClass
	 */
	@Test
	public void testUniqueAttributeExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/duplicatedAttrib.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 71, 92, "The name newAttribute is already used", msg.get(0));
	}
	
	/*
	 * Test self attribute in ExtendedClass
	 */
	@Test
	public void testSelfAttributeExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/selfAttributeExtendedClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 45, 58, "'self' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test result attribute in ExtendedClass
	 */
	@Test
	public void testResultAttributeExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/resultAttributeExtendedClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 45, 60, "'result' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test attribute exist in EClass
	 */
	@Test
	public void testExistingAttribute() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/conflictAttrib.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 45, 61, "The name abstract is already used", msg.get(0));
	}
	
	/*
	 * Test local variable conflict parameter
	 */
	@Test
	public void testConflictLocalParam() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/conflictAttribParamLocal.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 87, 99, "The name foo is already used", msg.get(0));
	}
	
	/*
	 * Test local variable is self
	 */
	@Test
	public void testLocalSelf() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/declareSelfError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 45, 58, "'self' is a reserved name", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 72, 80, "'self' is a reserved name", msg.get(1));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 85, 98, "'self' is a reserved name", msg.get(2));
	}
	
	/*
	 * Test local variable is result
	 */
	@Test
	public void testLocalResult() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/declareResultError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 44, 59, "'result' is a reserved name", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 73, 83, "'result' is a reserved name", msg.get(1));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 88, 103, "'result' is a reserved name", msg.get(2));
	}
	
	/*
	 * Test conflict of local variables in one block
	 */
	@Test
	public void testLocalBlockConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/duplicatedLocalVariable.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 82, 99, "The name localVar is already used", msg.get(0));
	}
	
	/*
	 * Test local variable conflict in other blocks
	 */
	@Test
	public void testLocalNoExternalConflit() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/scopeLocalVariable.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 93, 110, "The name localVar is already used", msg.get(0));
	}
	
	/*
	 * Test local variable doesn't conflict attribute
	 */
	@Test
	public void testLocalAttributeConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/localAttribNoConflict.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assign existing variable
	 */
	@Test
	public void testAssignExistingVar() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignLocal.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assign not existing variable
	 */
	@Test
	public void testAssignNotExistingVar() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignUnknownLocal.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 65, 70, "The variable wrong is not defined", msg.get(0));
	}
	
	/*
	 * Test assign self
	 */
	@Test
	public void testAssignSelf() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignSelfError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 64, 68, "'self' can't be assigned", msg.get(0));
	}
	
	/*
	 * Test assign a parameter
	 */
	@Test
	public void testAssignParam() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignParamError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 74, 79, "param is a parameter and can't be assigned", msg.get(0));
	}
	
	/*
	 * Test assign existing feature from EClass
	 */
	@Test
	public void testAssignEClassFeature() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignEClassAttrib.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assign existing feature from ExtendedClass
	 */
	@Test
	public void testAssignFeatureExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignAttribExtendedClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assign existing feature from RuntimeClass
	 */
	@Test
	public void testAssignFeatureRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignAttribRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assign not existing feature from ExtendedClass
	 */
	@Test
	public void testAssignNotExistingFeatureExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignUnknownFeature.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 64, 74, "The feature wrong is not defined", msg.get(0));
	}
	
	/*
	 * Test assign existing feature from RuntimeClass
	 */
	@Test
	public void testAssignNotExistingFeatureRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignUnknownFeatureRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 67, 77, "The feature wrong is not defined", msg.get(0));
	}
	
	/*
	 * Test insert in existing feature from EClass
	 */
	@Test
	public void testInsertEClassFeature() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertEClassAttrib.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test insert in existing feature from ExtendedClass
	 */
	@Test
	public void testInsertFeatureExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertAttribExtendedClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test insert in existing feature from RuntimeClass
	 */
	@Test
	public void testInsertFeatureRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertAttribRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test insert in not existing feature from ExtendedClass
	 */
	@Test
	public void testInsertNotExistingFeatureExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertUnknownFeatureExtendedClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 64, 74, "The feature wrong is not defined", msg.get(0));
	}
	
	/*
	 * Test insert in existing feature from RuntimeClass
	 */
	@Test
	public void testInsertNotExistingFeatureRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertUnknownFeatureRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 67, 77, "The feature wrong is not defined", msg.get(0));
	}
	
	//Remove idem
	
	/*
	 * Test remove in existing feature from EClass
	 */
	@Test
	public void testRemoveEClassFeature() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeEClassAttrib.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test remove in existing feature from ExtendedClass
	 */
	@Test
	public void testRemoveFeatureExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeAttribExtendedClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test remove in existing feature from RuntimeClass
	 */
	@Test
	public void testRemoveFeatureRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeAttribRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test remove in not existing feature from ExtendedClass
	 */
	@Test
	public void testRemoveNotExistingFeatureExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeUnknownFeatureExtendedClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 64, 74, "The feature wrong is not defined", msg.get(0));
	}
	
	/*
	 * Test remove in existing feature from RuntimeClass
	 */
	@Test
	public void testRemoveNotExistingFeatureRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeUnknownFeatureRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 67, 77, "The feature wrong is not defined", msg.get(0));
	}
	
	/*
	 * Test ForEach variable conflict with parameter
	 */
	@Test
	public void testForEachParam() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/forEachParamConflict.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 70, 95, "The name param is already used", msg.get(0));
	}
	
	/*
	 * Test ForEach variable is result
	 */
	@Test
	public void testForEachResult() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/forEachResult.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 61, 87, "'result' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test ForEach variable is self
	 */
	@Test
	public void testForEachSelf() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/forEachSelf.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 61, 85, "'self' is a reserved name", msg.get(0));
	}
	
	/*
	 * Test ForEach variable conflict with other blocks
	 */
	@Test
	public void testForEachExternalBlocks() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/forEachExternalBlock.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(msg.toString(), 2, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 83, 153, "The name localDef is already used", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 83, 153, "The name localDef is already used", msg.get(0));
	}
	
	/*
	 * Test access to dynamic feature (in expression) doesn't rise 'Feature not found' error
	 */
	@Test
	public void testFeatureAccessType() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureAccessTypes.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test access to dynamic feature (in expression) rises 'Feature not found' error
	 */
	@Test
	public void testUnknownFeatureAccessType() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureAccessTypesError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals("messages: " + msg, 1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 112, 117, "Feature wrong not found in EClass EClass", msg.get(0));
	}
	
	/*
	 * Test that no value can be assigned (:=, +=, -=) to the 'result' variable
	 */
	@Test
	public void testReturnAssignVoid() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignVoid.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(msg.toString(), 3, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 65, 76, "'result' is not available in a void method. Change method's return type", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 80, 91, "'result' is not available in a void method. Change method's return type", msg.get(1));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 95, 106, "'result' is not available in a void method. Change method's return type", msg.get(2));
	}
	
	/*
	 * Test a method declared in a parent class can be overridden.
	 */
	@Test
	public void testOverrideMethodFromParent() {
		env = IAleEnvironment.fromPaths(asList("model/doubleMulti.ecore"), asList("input/overrideMethodFromParent.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertTrue(msg.toString(), msg.isEmpty());
	}
}
