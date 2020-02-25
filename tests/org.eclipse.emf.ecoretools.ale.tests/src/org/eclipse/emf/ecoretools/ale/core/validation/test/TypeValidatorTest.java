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
	 * Test ExtendedClass extending another with the same baseClass
	 */
	@Test
	public void testExtendTypeTreeWithAttributes() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/extendTypeTreeWithAttributes.implem"));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 59, 99, "Can't extend ecore::EClass since it is not a direct super type of ecore::EClassifier", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 63, 107, "Can't extend ecore::EOperation since it is not a direct super type of ecore::EClassifier", msg.get(0));
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
		
		
		assertMsgEquals(ValidationMessageLevel.ERROR, 73, 118, "Reopened ecore::EClass is extending itself", msg.get(0));
		assertEquals(1, msg.size());
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 76, 131, "Reopened ecore::EClassifier is extending itself", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 45, 62, "Expected ecore::EString but was [java.lang.Integer]", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 73, 90, "Expected [ecore::EString] but was [java.lang.Integer]", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 87, 95, "Type mismatch: cannot assign [java.lang.String] to [ecore::EInt]", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 104, 109, "Type mismatch: cannot assign [java.lang.String] to [ecore::EInt]", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 76, 77, "Type mismatch: cannot assign [java.lang.Integer] to [ecore::EString]", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 65, 76, "Cannot assign 'result' in a void operation", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 81, 83, "Type mismatch: cannot assign [java.lang.Integer] to [ecore::EPackage]", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 99, 101, "Type mismatch: cannot assign [java.lang.Integer] to [ecore::EString]", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 101, 106, "Type mismatch: cannot assign [java.lang.String] to [ecore::EInt]", msg.get(0));
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
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 61, 74, "[ecore::EBoolean] does not support the '+=' operator", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 79, 90, "[ecore::EClass] does not support the '+=' operator", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 82, 93, "[ecore::EClass] does not support the '+=' operator", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 81, 89, "[java.lang.String] cannot be added to [Collection(ecore::EClass)] (expected [Collection(ecore::EClass),ecore::EClass])", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 103, 108, "[java.lang.String] cannot be added to [Collection(ecore::EInt)] (expected [Collection(ecore::EInt),ecore::EInt])", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 106, 111, "[java.lang.String] cannot be added to [Collection(ecore::EInt)] (expected [Collection(ecore::EInt),ecore::EInt])", msg.get(0));
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
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 60, 73, "[ecore::EBoolean] does not support the '-=' operator", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 78, 89, "[ecore::EClass] does not support the '-=' operator", msg.get(0));
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
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 81, 92, "[ecore::EClass] does not support the '-=' operator", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 80, 88, "[java.lang.String] cannot be removed from [Collection(ecore::EClass)] (expected [Collection(ecore::EClass),ecore::EClass])", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 103, 108, "[java.lang.String] cannot be removed from [Collection(ecore::EInt)] (expected [Collection(ecore::EInt),ecore::EInt])", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 106, 111, "[java.lang.String] cannot be removed from [Collection(ecore::EInt)] (expected [Collection(ecore::EInt),ecore::EInt])", msg.get(0));
	}
	
	/**
	 * Test using the '+=' on self raise an error
	 */
	@Test
	public void testInsertSelf() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertSelf.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 61, 65, "'self' does not support the '+=' operator", msg.get(0));
	}
	
	/**
	 * Test that a value can be inserted into a local Collection
	 */
	@Test
	public void testInsertIntoLocalCollection() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertLocalCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test that a value cannot be inserted into a local Collection if their types mismatch
	 */
	@Test
	public void testInsertIntoLocalCollectionError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertLocalCollectionError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 177, 178, "[java.lang.Integer] cannot be added to [Collection(ecore::EString)] (expected [Collection(ecore::EString),ecore::EString])", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 193, 201, "[Collection(java.lang.Integer)] cannot be added to [Collection(ecore::EString)] (expected [Collection(ecore::EString),ecore::EString])", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 216, 230, "[Collection(java.lang.Integer)] cannot be added to [Collection(ecore::EString)] (expected [Collection(ecore::EString),ecore::EString])", msg.get(2));
	}
	
	/**
	 * Test that the iterator of a for-each loop can be inserted into a local collection
	 */
	@Test
	public void testInsertIntoLocalCollectionInForEachLoop() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertLocalCollectionInForEachLoop.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test that the iterator of a for-each loop cannot be inserted into a local collection if their types mismatch
	 */
	@Test
	public void testInsertIntoLocalCollectionInForEachLoopError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertLocalCollectionInForEachLoopError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 244, 250, "[java.lang.Integer] cannot be added to [Collection(ecore::EString)] (expected [Collection(ecore::EString),ecore::EString])", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 267, 273, "[java.lang.Integer] cannot be added to [Collection(ecore::EString)] (expected [Collection(ecore::EString),ecore::EString])", msg.get(1));
	}
	
	/**
	 * Test that some do not support the '-=' operator
	 */
	@Test
	public void testInsertIntoLocalVariableError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertIntoLocalBooleanError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 98, 114, "[ecore::EBoolean] does not support the '+=' operator", msg.get(0));
	}
	
	/**
	 * Test that the result special variable supports the '+=' operator
	 */
	@Test
	public void testInsertResult() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertResult.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test that using '+=' with the result special variable produces an error when types mismatch
	 */
	@Test
	public void testInsertResultError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertResultError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(4, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 75, 77, "[java.lang.Integer] cannot be added to [ecore::EString] (expected [ecore::EString])", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 111, 117, "[ecore::EBoolean] does not support the '+=' operator", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 179, 187, "[java.lang.String] cannot be added to [Collection(ecore::EInt)] (expected [Collection(ecore::EInt),ecore::EInt])", msg.get(2));
		assertMsgEquals(ValidationMessageLevel.ERROR, 201, 222, "[Collection(java.lang.Boolean)] cannot be added to [Collection(ecore::EInt)] (expected [Collection(ecore::EInt),ecore::EInt])", msg.get(3));
	}
	
	/**
	 * Test that the result special variable supports the '-=' operator
	 */
	@Test
	public void testRemoveResult() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/removeResult.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test that using '-=' with the result special variable produces an error when types mismatch
	 */
	@Test
	public void testRemoveResultError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/removeResultError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(4, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 75, 79, "[java.lang.String] cannot be removed from [ecore::EInt] (expected [ecore::EInt])", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 113, 119, "[ecore::EBoolean] does not support the '-=' operator", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 181, 189, "[java.lang.String] cannot be removed from [Collection(ecore::EInt)] (expected [Collection(ecore::EInt),ecore::EInt])", msg.get(2));
		assertMsgEquals(ValidationMessageLevel.ERROR, 203, 224, "[Collection(java.lang.Boolean)] cannot be removed from [Collection(ecore::EInt)] (expected [Collection(ecore::EInt),ecore::EInt])", msg.get(3));
	}
	
	@Test
	public void testInsertStringToString() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertStringToString.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testInsertIntToString() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertIntToString.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 89, 91, "[java.lang.Integer] cannot be added to [ecore::EString] (expected [ecore::EString])", msg.get(0));
	}
	
	@Test
	public void testInsertStringToInt() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertStringToInt.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 86, 93, "[java.lang.String] cannot be added to [ecore::EInt] (expected [ecore::EInt])", msg.get(0));
	}
	
	@Test
	public void testInsertIntToInt() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/insertIntToInt.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test using the '-=' on self raise an error
	 */
	@Test
	public void testRemoveFromSelf() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/removeSelf.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 61, 65, "'self' does not support the '-=' operator", msg.get(0));
	}
	
	/**
	 * Test that a value can be removed from a local Collection
	 */
	@Test
	public void testRemoveFromLocalCollection() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/removeLocalCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test that a value cannot be removed from a local Collection if their types mismatch
	 */
	@Test
	public void testRemoveFromLocalCollectionError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/removeLocalCollectionError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 177, 178, "[java.lang.Integer] cannot be removed from [Collection(ecore::EString)] (expected [Collection(ecore::EString),ecore::EString])", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 193, 201, "[Collection(java.lang.Integer)] cannot be removed from [Collection(ecore::EString)] (expected [Collection(ecore::EString),ecore::EString])", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 216, 230, "[Collection(java.lang.Integer)] cannot be removed from [Collection(ecore::EString)] (expected [Collection(ecore::EString),ecore::EString])", msg.get(2));
	}
	
	/**
	 * Test that the iterator of a for-each loop can be removed from a local collection
	 */
	@Test
	public void testRemoveFromLocalCollectionInForEachLoop() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/removeLocalCollectionInForEachLoop.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test that the iterator of a for-each loop cannot be removed from a local collection if their types mismatch
	 */
	@Test
	public void testRemoveFromLocalCollectionInForEachLoopError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/removeLocalCollectionInForEachLoopError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 244, 250, "[java.lang.Integer] cannot be removed from [Collection(ecore::EString)] (expected [Collection(ecore::EString),ecore::EString])", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 267, 273, "[java.lang.Integer] cannot be removed from [Collection(ecore::EString)] (expected [Collection(ecore::EString),ecore::EString])", msg.get(1));
	}
	
	/**
	 * Test that some types do not support the '-=' operator
	 */
	@Test
	public void testRemoveFromLocalVariableError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/removeLocalVariablesError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 98, 114, "[ecore::EBoolean] does not support the '-=' operator", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 158, 164, "[ecore::EString] does not support the '-=' operator", msg.get(1));
	}
	
	/*
	 * Test that for-each loops accept integer ranges:
	 * 		for (i in [0..10])
	 */
	@Test
	public void testForEachIntegerRange() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/forEachIntRange.implem"));
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
		
		assertEquals("should have no errors but was: " + msg, 0, msg.size());
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 134, 144, "Expected [ecore::EInt] but was [java.lang.String]", msg.get(0));
	}
	
	/*
	 * Test that a method can be used to set the range of a for-each loop
	 */
	@Test
	public void testForEachRangeFromMethodCall() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/forEachRangeFromMethodCall.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals("Got: " + msg, 0, msg.size());
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 63, 69, "Expected a boolean expression but was [java.lang.Integer]", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 69, 78, "Expected a boolean expression but was [java.lang.String]", msg.get(0));
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
		assertMsgEquals(ValidationMessageLevel.ERROR, 66, 106, "Expected [ecore::EClass] but was [ecore::EOperation]", msg.get(0));
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
	
	@Test
	public void testAssignCollection() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testAssignCollectionError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignCollectionError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 90, 94, "Type mismatch: cannot assign [ecore::EClass] to [Collection(ecore::EClass)]", msg.get(0));
	}
	
	@Test
	public void testAssignCollectionError2() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignCollectionError2.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 90, 91, "Type mismatch: cannot assign [java.lang.Integer] to [Collection(ecore::EClass)]", msg.get(0));
	}
	
	@Test
	public void testDeclareCollection() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/declareCollection.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testDeclareCollection2() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/declareCollection2.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testDeclareCollectionError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/declareCollectionError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 71, 101, "Expected [Collection(ecore::EInt)] but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testAssignCollectionType() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignCollectionType.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testAssignCollectionTypeError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignCollectionTypeError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 125, 143, "Type mismatch: cannot assign [Collection(java.lang.String)] to [Collection(ecore::EInt)]", msg.get(0));
	}
	@Test
	public void testAssignSequenceFeature() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignSequenceFeature.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	@Test
	public void testAssignSequenceFeatureError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignSequenceFeatureError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 143, 147, "Type mismatch: cannot assign [ecore::EClass] to [Collection(ecore::EClass)]", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 170, 192, "Type mismatch: cannot assign [ecore::EClass] to [Collection(ecore::EClass)]", msg.get(1));
	}
	@Test
	public void testAssignSequenceVarDecl() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignSequenceVarDecl.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	@Test
	public void testAssignSequenceVarDeclError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignSequenceVarDeclError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(4, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 85, 128, "Expected [Collection(ecore::EClass)] but was [ecore::EClass]", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 147, 151, "Type mismatch: cannot assign [ecore::EClass] to [Collection(ecore::EClass)]", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 155, 216, "Expected [Collection(ecore::EClass)] but was [ecore::EClass]", msg.get(2));
		assertMsgEquals(ValidationMessageLevel.ERROR, 235, 257, "Type mismatch: cannot assign [ecore::EClass] to [Collection(ecore::EClass)]", msg.get(3));
	}
	
	@Test
	public void testAssignSequenceResult() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignSequenceResult.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	@Test
	public void testAssignSequenceResultError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignSequenceResultError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 110, 132, "Type mismatch: cannot assign [ecore::EClass] to [Collection(ecore::EClass)]", msg.get(0));
	}
	
	/**
	 * Test that an operation can take a sequence as parameter and use it freely
	 */
	@Test
	public void testCallMethodTakingASequence() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/callMethodTakingSequence.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals("no error was expected but got: " + msg, 0, msg.size());
	}
	

	@Test
	public void testUnresolvedTypeInDeclarationError() {
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/unresolvedTypeInDeclaration.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 84, "Unresolved type , it cannot be found in any of the declared packages: [ecore, implementation, ast, test, unresolvedTypeInDecaration]", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 136, 157, "Unresolved type , it cannot be found in any of the declared packages: [ecore, implementation, ast, test, unresolvedTypeInDecaration]", msg.get(1));
	}
	
}
