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
	public void setup() {
		interpreter = new ALEInterpreter();
	}
	
	/*
	 * Test ExtendedClass extending another with the same baseClass
	 */
	@Test
	public void testExtendsSameType() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/extendSameType.implem","input/validation/extendSameType2.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test ExtendedClass extending another based on a super type of its baseClass
	 */
	@Test
	public void testExtendsUpperType() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/extendSameType.implem","input/validation/extendSuperType.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test ExtendedClass extending another based on a sub type of its baseClass
	 */
	@Test
	public void testExtendsLowerType() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/extendSubType.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 59, 99, "Can't extend EClass since it is not a direct super type of EClassifier", msg.get(0));
	}
	
	/*
	 * Test ExtendedClass extending another one not based on a super type of its baseClass
	 */
	@Test
	public void testExtendsNotSuperType() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/extendNotSuperType.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 63, 107, "Can't extend EOperation since it is not a direct super type of EClassifier", msg.get(0));
	}
	
	/*
	 * Test ExtendedClass extending itself
	 */
	@Test
	public void testExtendsItself() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/extendItself.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 73, 128, "Reopened EClassifier is extending itself", msg.get(0));
	}
	
	/*
	 * Test ExtendedClass extending itself by transitivity
	 */
	@Test
	public void testExtendsCycle() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/extendSameType2.implem","input/validation/extendCycle.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 76, 131, "Reopened EClassifier is extending itself", msg.get(0));
	}
	
	/*
	 * Test initial value of attribute is assignable to the declared type
	 */
	@Test
	public void testAttributeAssignValue() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/declareAttrib.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test initial value of attribute is not assignable to the declared type
	 */
	@Test
	public void testAttributeAssignValueConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/typeErrorAttrib.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 45, 62, "Expected EString but was [java.lang.Integer]", msg.get(0));
	}
	
	/*
	 * Test initial value of variable is assignable to the declared type
	 */
	@Test
	public void testVariableInitValue() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/declareLocal.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test initial value of variable is not assignable to the declared type
	 */
	@Test
	public void testVariableInitValueConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/typeErrorLocal.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 73, 90, "Expected EString but was [java.lang.Integer]", msg.get(0));
	}
	
	/*
	 * Test assigned value doesn't conflict the declared type
	 */
	@Test
	public void testVariableAssignValue() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignLocalSameBlock.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assigned value conflict the declared type
	 */
	@Test
	public void testVariableAssignValueConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignLocalTypeError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 78, 95, "Expected [EClassifier=EInt] but was [java.lang.String]", msg.get(0));
	}
	
	/*
	 * Test assigned value doesn't conflict the declared type in upper block
	 */
	@Test
	public void testVariableAssignValueInnerBlock() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignLocalInnerBlock.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assigned value conflict the declared type in upper block
	 */
	@Test
	public void testVariableAssignValueInnerBlockConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/scopeTypeErrorLocal.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 92, 109, "Expected [EClassifier=EInt] but was [java.lang.String]", msg.get(0));
	}
	
	/*
	 * Test value of result doesn't conflict the return type
	 */
	@Test
	public void testReturnAssignValue() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignResult.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test value of result conflict the return type
	 */
	@Test
	public void testReturnAssignValueConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignResultConflict.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 66, 77, "Expected EString but was [java.lang.Integer]", msg.get(0));
	}
	
	/*
	 * Test value of result conflict the return type void
	 */
	@Test
	public void testReturnAssignVoid() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignVoid.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 65, 76, "'result' is assigned in void operation", msg.get(0));
	}
	
	/*
	 * Test assigned value doesn't conflict the feature type of the baseClass
	 */
	@Test
	public void testFeatureAssignBaseClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignFeatureBaseClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assigned value conflict the feature type of the baseClass
	 */
	@Test
	public void testFeatureAssignBaseClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignFeatureTypeError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 83, "Expected [EPackage] but was [java.lang.Integer]", msg.get(0));
	}
	
	/*
	 * Test assigned value doesn't conflict the feature type from the ExtendedClass
	 */
	@Test
	public void testFeatureAssignExtendedClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignFeatureExtendedClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assigned value conflict the feature type from the ExtendedClass
	 */
	@Test
	public void testFeatureAssignExtendedClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignAttributeTypeError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 82, 101, "Expected [EString] but was [java.lang.Integer]", msg.get(0));
	}
	
	/*
	 * Test assigned value doesn't conflict the feature type from the RuntimeClass
	 */
	@Test
	public void testFeatureAssignRuntimeClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignAttribRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assigned value conflict the feature type from the RuntimeClass
	 */
	@Test
	public void testFeatureAssignRuntimeClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignAttribRuntimeClassError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 83, 106, "Expected [EInt] but was [java.lang.String]", msg.get(0));
	}
	
	/*
	 * Test the feature is typed collection from the BaseClass for insert
	 */
	@Test
	public void testInsertToCollectionBaseClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureInsertCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test the feature isn't typed collection from the BaseClass for insert
	 */
	@Test
	public void testInsertToCollectionBaseClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureInsertCollectionError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 61, 64, "Expected Collection but was [EClassifier=EBoolean]", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 61, 82, "Expected [EBoolean] but was [EClassifier=EClass]", msg.get(1));
	}
	
	/*
	 * Test the feature is typed collection from the ExtendedClass for insert
	 */
	@Test
	public void testInsertToCollectionExtendedClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureInsertExtendedClassCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test the feature isn't typed collection from the ExtendedClass for insert
	 */
	@Test
	public void testInsertToCollectionExtendedClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureInsertExtendedClassCollectionError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 79, 82, "Expected Collection but was [EClassifier=EClass]", msg.get(0));
	}
	
	/*
	 * Test the feature is typed collection from the RuntimeClass for insert
	 */
	@Test
	public void testInsertToCollectionRuntimeClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureInsertRuntimeClassCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test the feature isn't typed collection from the RuntimeClass for insert
	 */
	@Test
	public void testInsertToCollectionRuntimeClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureInsertRuntimeClassCollectionError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 82, 85, "Expected Collection but was [EClassifier=EClass]", msg.get(0));
	}
	
	/*
	 * Test inserted value is assignable to the feature from the BaseClass
	 */
	@Test
	public void testInsertBaseClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertEClassAttrib.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test inserted value is not assignable to the feature from the BaseClass
	 */
	@Test
	public void testInsertBaseClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureInsertTypeError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 61, 89, "Expected [EClass] but was [java.lang.String]", msg.get(0));
	}
	
	/*
	 * Test inserted value is assignable to the feature from the ExtendedClass
	 */
	@Test
	public void testInsertExtendedClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertAttribExtendedClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test inserted value is not assignable to the feature from the ExtendedClass
	 */
	@Test
	public void testInsertExtendedClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertAttribExtendedClassError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 85, 108, "Expected [EInt] but was [java.lang.String]", msg.get(0));
	}
	
	/*
	 * Test inserted value is assignable to the feature from the RuntimeClass
	 */
	@Test
	public void testInsertRuntimeClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertAttribRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test inserted value is not assignable to the feature from the RuntimeClass
	 */
	@Test
	public void testInsertRuntimeClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertAttribRuntimeClassError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 88, 111, "Expected [EInt] but was [java.lang.String]", msg.get(0));
	}
	
	/*
	 * Test the feature is typed collection from the BaseClass for remove
	 */
	@Test
	public void testRemoveToCollectionBaseClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureRemoveCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test the feature isn't typed collection from the BaseClass for remove
	 */
	@Test
	public void testRemoveToCollectionBaseClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureRemoveCollectionError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 60, 63, "Expected Collection but was [EClassifier=EBoolean]", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 60, 81, "Expected [EBoolean] but was [EClassifier=EClass]", msg.get(1));
	}
	
	/*
	 * Test the feature is typed collection from the ExtendedClass for remove
	 */
	@Test
	public void testRemoveToCollectionExtendedClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureRemoveExtendedClassCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test the feature isn't typed collection from the ExtendedClass for remove
	 */
	@Test
	public void testRemoveToCollectionExtendedClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureRemoveExtendedClassCollectionError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 78, 81, "Expected Collection but was [EClassifier=EClass]", msg.get(0));
	}
	
	/*
	 * Test the feature is typed collection from the RuntimeClass for remove
	 */
	@Test
	public void testRemoveToCollectionRuntimeClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureRemoveRuntimeClassCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test the feature isn't typed collection from the RuntimeClass for remove
	 */
	@Test
	public void testRemoveToCollectionRuntimeClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureRemoveRuntimeClassCollectionError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 81, 84, "Expected Collection but was [EClassifier=EClass]", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 81, 100, "Expected [EClass] but was [EClassifier=MyRuntimeClass]", msg.get(1));
	}
	
	/*
	 * Test removed value is assignable to the feature from the BaseClass
	 */
	@Test
	public void testRemoveBaseClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/removeEClassAttrib.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test removed value is not assignable to the feature from the BaseClass
	 */
	@Test
	public void testRemoveBaseClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureRemoveTypeError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 60, 88, "Expected [EClass] but was [java.lang.String]", msg.get(0));
	}
	
	/*
	 * Test removed value is assignable to the feature from the ExtendedClass
	 */
	@Test
	public void testRemoveExtendedClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/removeAttribExtendedClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test removed value is not assignable to the feature from the ExtendedClass
	 */
	@Test
	public void testRemoveExtendedClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/removeAttribExtendedClassError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 85, 108, "Expected [EInt] but was [java.lang.String]", msg.get(0));
	}
	
	/*
	 * Test removed value is assignable to the feature from the RuntimeClass
	 */
	@Test
	public void testRemoveRuntimeClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/removeAttribRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test removed value is not assignable to the feature from the RuntimeClass
	 */
	@Test
	public void testRemoveRuntimeClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/removeAttribRuntimeClassError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 88, 111, "Expected [EInt] but was [java.lang.String]", msg.get(0));
	}
	
	/*
	 * Test ForEach expression is a Collection
	 */
	@Test
	public void testForEachCollection() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/forEachCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test ForEach expression is not a Collection
	 */
	@Test
	public void testForEachNotCollection() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/forEachCollectionError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 70, 73, "Expected Collection but was [java.lang.Boolean]", msg.get(0));
	}
	
	/*
	 * Test type of ForEach variable is inferred
	 */
	@Test
	public void testForEachSequence() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/forEachSequence.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test type of ForEach variable is inferred
	 */
	@Test
	public void testForEachSequenceError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/forEachSequenceError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 134, 144, "Expected EInt but was [java.lang.String]", msg.get(0));
	}
	
	/*
	 * Test If expression is a boolean
	 */
	@Test
	public void testIfBoolean() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/ifBoolean.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test If expression is not a boolean
	 */
	@Test
	public void testIfNotBoolean() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/ifBooleanError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 63, 69, "Expected Boolean but was [java.lang.Integer]", msg.get(0));
	}
	
	/*
	 * Test While expression is a boolean
	 */
	@Test
	public void testWhileBoolean() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/whileBoolean.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test While expression is not a boolean
	 */
	@Test
	public void testWhileNotBoolean() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/whileBooleanError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 69, 78, "Expected Boolean but was [java.lang.String]", msg.get(0));
	}
	
	/*
	 * Test call argument is assignable to EParameter's type from baseClass
	 */
	@Test
	public void testCallArgumentBaseClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/callBaseClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test call argument is not assignable to EParameter's type from baseClass
	 */
	@Test
	public void testCallArgumentBaseClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/callBaseClassError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 68, 84, "Couldn't find the 'isSuperTypeOf(EClassifier=EClass,java.lang.Integer)' service", msg.get(0));
	}
	
	/*
	 * Test call argument is assignable to EParameter's type from ExtendedClass
	 */
	@Test
	public void testCallArgumentExtendedClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/callExtendedClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test call argument is not assignable to EParameter's type from ExtendedClass
	 */
	@Test
	public void testCallArgumentExtendedClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/callExtendedClassError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 68, 74, "Couldn't find the 'foo(EClassifier=EClass,java.lang.Integer)' service", msg.get(0));
	}
	
	/*
	 * Test call argument is assignable to EParameter's type from RuntimeClass
	 */
	@Test
	public void testCallArgumentRuntimeClass() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/callRuntimeClass.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test call argument is not assignable to EParameter's type from RuntimeClass
	 */
	@Test
	public void testCallArgumentRuntimeClassConflict() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/callRuntimeClassError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 71, 77, "Couldn't find the 'foo(EClassifier=MyRuntimeClass,java.lang.Integer)' service", msg.get(0));
	}
	
	@Test
	public void testInferIfThen() {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/validation/inferIfThen.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 156, 161, "Couldn't find the 'bar(EClassifier=A)' service", msg.get(0));
	}
	
	@Test
	public void testInferIfElse() {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/validation/inferIfElse.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 120, 125, "Couldn't find the 'bar(EClassifier=A)' service", msg.get(0));
	}
	
	@Test
	public void testInferElseIf() {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/validation/inferElseIf.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 249, 254, "Couldn't find the 'bar(EClassifier=A)' service", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 293, 298, "Couldn't find the 'foo(EClassifier=EObject)' service", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 324, 329, "Couldn't find the 'bar(EClassifier=EObject)' service", msg.get(2));
	}
	
	@Test
	public void testInferNotElseIf() {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/validation/inferElseIf2.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 126, 131, "Couldn't find the 'foo(EClassifier=EObject)' service", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 157, 162, "Couldn't find the 'bar(EClassifier=EObject)' service", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 328, 333, "Couldn't find the 'bar(EClassifier=A)' service\nCouldn't find the 'bar(EClassifier=EObject)' service", msg.get(2));
	}
	
	@Test
	public void testInferWhile() {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/validation/inferWhile.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testInferWhileError() {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/validation/inferWhileError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 127, 137, "Couldn't find the 'bar(EClassifier=A,EClassifier=A)' service", msg.get(0));
	}
	
	@Test
	public void testInferInner() {
		Dsl environment = new Dsl(Arrays.asList("model/ABC.ecore"),Arrays.asList("input/validation/inferInner.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testAssignCreate() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignCreate.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testAssignCreateError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignCreateError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 66, 106, "Expected EClass but was [EClassifierLiteral=EOperation]", msg.get(0));
	}
	
	@Test
	public void testAssignSubtype() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignSubtype.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	private void assertMsgEquals(ValidationMessageLevel errorLvl, int startPos, int endPos, String text, IValidationMessage msg){
		assertEquals(errorLvl, msg.getLevel());
		assertEquals(startPos, msg.getStartPosition());
		assertEquals(endPos, msg.getEndPosition());
		assertEquals(text, msg.getMessage());
	}
}
