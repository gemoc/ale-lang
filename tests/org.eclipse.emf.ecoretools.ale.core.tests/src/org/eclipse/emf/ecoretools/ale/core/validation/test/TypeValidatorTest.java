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

import static java.lang.System.lineSeparator;
import static java.util.Arrays.asList;
import static org.eclipse.emf.ecoretools.ale.core.validation.test.ValidationMessages.assertMsgEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.validation.ALEValidator;
import org.junit.After;
import org.junit.ComparisonFailure;
import org.junit.Test;

/**
 * Check type errors raised by the ModelBehavior validator
 */
public class TypeValidatorTest {

	IAleEnvironment env;
	
	@After
	public void setup(){
		if (env != null) {
			env.close();
		}
	}

	/** Returns the system-dependent line separator character */ 
	private static String nl() {
		return System.lineSeparator();
	}
	
	/*
	 * Test ExtendedClass extending another with the same baseClass
	 */
	@Test
	public void testExtendsSameType() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/extendSameType.implem","input/validation/extendSameType2.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test ExtendedClass extending another with the same baseClass
	 */
	@Test
	public void testExtendTypeTreeWithAttributes() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/extendTypeTreeWithAttributes.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test ExtendedClass extending another based on a super type of its baseClass
	 */
	@Test
	public void testExtendsUpperType() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/extendSameType.implem","input/validation/extendSuperType.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test ExtendedClass extending another based on a sub type of its baseClass
	 */
	@Test
	public void testExtendsLowerType() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/extendSubType.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 59, 101, "Cannot inherit from 'ecore::EClass' since it is not a direct super type of 'ecore::EClassifier'", msg.get(0));
	}
	
	/*
	 * Test ExtendedClass extending another one not based on a super type of its baseClass
	 */
	@Test
	public void testExtendsNotSuperType() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/extendNotSuperType.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 63, 105, "Cannot inherit from 'ecore::EOperation' since it is not a direct super type of 'ecore::EClassifier'", msg.get(0));
	}
	
	/*
	 * Test ExtendedClass extending itself
	 */
	@Test
	public void testExtendsItself() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/extendItself.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 73, 118, "Reopened ecore::EClass is extending itself", msg.get(0));
		assertEquals(1, msg.size());
	}
	
	/*
	 * Test ExtendedClass extending itself by transitivity
	 */
	@Test
	public void testExtendsCycle() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/extendSameType2.implem","input/validation/extendCycle.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 76, 131, "Reopened ecore::EClassifier is extending itself", msg.get(0));
	}
	
	/*
	 * Test initial value of attribute is assignable to the declared type
	 */
	@Test
	public void testAttributeAssignValue() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/declareAttrib.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test initial value of attribute is not assignable to the declared type
	 */
	@Test
	public void testAttributeAssignValueConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/typeErrorAttrib.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 61, 62, "Type mismatch: cannot assign [java.lang.Integer] to [ecore::EString]", msg.get(0));
	}
	
	/*
	 * Test initial value of variable is assignable to the declared type
	 */
	@Test
	public void testVariableInitValue() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/declareLocal.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test initial value of variable is not assignable to the declared type
	 */
	@Test
	public void testVariableInitValueConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/typeErrorLocal.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 89, 90, "Type mismatch: cannot assign [java.lang.Integer] to [ecore::EString]", msg.get(0));
	}
	
	/*
	 * Test assigned value doesn't conflict the declared type
	 */
	@Test
	public void testVariableAssignValue() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignLocalSameBlock.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assigned value conflict the declared type
	 */
	@Test
	public void testVariableAssignValueConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignLocalTypeError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 87, 95, "Type mismatch: cannot assign [java.lang.String] to [ecore::EInt]", msg.get(0));
	}
	
	/*
	 * Test assigned value doesn't conflict the declared type in upper block
	 */
	@Test
	public void testVariableAssignValueInnerBlock() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignLocalInnerBlock.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assigned value conflict the declared type in upper block
	 */
	@Test
	public void testVariableAssignValueInnerBlockConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/scopeTypeErrorLocal.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 104, 109, "Type mismatch: cannot assign [java.lang.String] to [ecore::EInt]", msg.get(0));
	}
	
	/*
	 * Test value of result doesn't conflict the return type
	 */
	@Test
	public void testReturnAssignValue() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignResult.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test value of result conflict the return type
	 */
	@Test
	public void testReturnAssignValueConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignResultConflict.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 76, 77, "Type mismatch: cannot assign [java.lang.Integer] to [ecore::EString]", msg.get(0));
	}
	
	/*
	 * Test assigned value doesn't conflict the feature type of the baseClass
	 */
	@Test
	public void testFeatureAssignBaseClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignFeatureBaseClass.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assigned value conflict the feature type of the baseClass
	 */
	@Test
	public void testFeatureAssignBaseClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignFeatureTypeError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 81, 83, "Type mismatch: cannot assign [java.lang.Integer] to [ecore::EPackage]", msg.get(0));
	}
	
	/*
	 * Test assigned value doesn't conflict the feature type from the ExtendedClass
	 */
	@Test
	public void testFeatureAssignExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignFeatureExtendedClass.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assigned value conflict the feature type from the ExtendedClass
	 */
	@Test
	public void testFeatureAssignExtendedClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignAttributeTypeError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 99, 101, "Type mismatch: cannot assign [java.lang.Integer] to [ecore::EString]", msg.get(0));
	}
	
	/*
	 * Test assigned value doesn't conflict the feature type from the RuntimeClass
	 */
	@Test
	public void testFeatureAssignRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignAttribRuntimeClass.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test assigned value conflict the feature type from the RuntimeClass
	 */
	@Test
	public void testFeatureAssignRuntimeClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignAttribRuntimeClassError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 101, 106, "Type mismatch: cannot assign [java.lang.String] to [ecore::EInt]", msg.get(0));
	}
	
	/*
	 * Test the feature is typed collection from the BaseClass for insert
	 */
	@Test
	public void testInsertToCollectionBaseClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureInsertCollection.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test the feature isn't typed collection from the BaseClass for insert
	 */
	@Test
	public void testInsertToCollectionBaseClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureInsertCollectionError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 61, 74, "[ecore::EBoolean] does not support the '+=' operator", msg.get(0));
	}
	
	/*
	 * Test the feature is typed collection from the ExtendedClass for insert
	 */
	@Test
	public void testInsertToCollectionExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureInsertExtendedClassCollection.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test the feature isn't typed collection from the ExtendedClass for insert
	 */
	@Test
	public void testInsertToCollectionExtendedClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureInsertExtendedClassCollectionError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 79, 90, "[ecore::EClass] does not support the '+=' operator", msg.get(0));
	}
	
	/*
	 * Test the feature is typed collection from the RuntimeClass for insert
	 */
	@Test
	public void testInsertToCollectionRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureInsertRuntimeClassCollection.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test the feature isn't typed collection from the RuntimeClass for insert
	 */
	@Test
	public void testInsertToCollectionRuntimeClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureInsertRuntimeClassCollectionError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 82, 93, "[ecore::EClass] does not support the '+=' operator", msg.get(0));
	}
	
	/*
	 * Test inserted value is assignable to the feature from the BaseClass
	 */
	@Test
	public void testInsertBaseClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertEClassAttrib.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test inserted value is not assignable to the feature from the BaseClass
	 */
	@Test
	public void testInsertBaseClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureInsertTypeError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 81, 89, "[java.lang.String] cannot be added to [Sequence(ecore::EClass)] (expected [Sequence(ecore::EClass),ecore::EClass])", msg.get(0));
	}
	
	/*
	 * Test inserted value is assignable to the feature from the ExtendedClass
	 */
	@Test
	public void testInsertExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertAttribExtendedClass.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test inserted value is not assignable to the feature from the ExtendedClass
	 */
	@Test
	public void testInsertExtendedClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertAttribExtendedClassError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 103, 108, "[java.lang.String] cannot be added to [Sequence(ecore::EInt)] (expected [Sequence(ecore::EInt),ecore::EInt])", msg.get(0));
	}
	
	/*
	 * Test inserted value is assignable to the feature from the RuntimeClass
	 */
	@Test
	public void testInsertRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertAttribRuntimeClass.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test inserted value is not assignable to the feature from the RuntimeClass
	 */
	@Test
	public void testInsertRuntimeClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertAttribRuntimeClassError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 106, 111, "[java.lang.String] cannot be added to [Sequence(ecore::EInt)] (expected [Sequence(ecore::EInt),ecore::EInt])", msg.get(0));
	}
	
	/*
	 * Test the feature is typed collection from the BaseClass for remove
	 */
	@Test
	public void testRemoveToCollectionBaseClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureRemoveCollection.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test the feature isn't typed collection from the BaseClass for remove
	 */
	@Test
	public void testRemoveToCollectionBaseClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureRemoveCollectionError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 60, 73, "[ecore::EBoolean] does not support the '-=' operator", msg.get(0));
	}
	
	/*
	 * Test the feature is typed collection from the ExtendedClass for remove
	 */
	@Test
	public void testRemoveToCollectionExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureRemoveExtendedClassCollection.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test the feature isn't typed collection from the ExtendedClass for remove
	 */
	@Test
	public void testRemoveToCollectionExtendedClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureRemoveExtendedClassCollectionError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 78, 89, "[ecore::EClass] does not support the '-=' operator", msg.get(0));
	}
	
	/*
	 * Test the feature is typed collection from the RuntimeClass for remove
	 */
	@Test
	public void testRemoveToCollectionRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureRemoveRuntimeClassCollection.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test the feature isn't typed collection from the RuntimeClass for remove
	 */
	@Test
	public void testRemoveToCollectionRuntimeClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureRemoveRuntimeClassCollectionError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 81, 92, "[ecore::EClass] does not support the '-=' operator", msg.get(0));
	}
	
	/*
	 * Test removed value is assignable to the feature from the BaseClass
	 */
	@Test
	public void testRemoveBaseClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeEClassAttrib.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test removed value is not assignable to the feature from the BaseClass
	 */
	@Test
	public void testRemoveBaseClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/featureRemoveTypeError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 80, 88, "[java.lang.String] cannot be removed from [Sequence(ecore::EClass)] (expected [Sequence(ecore::EClass),ecore::EClass])", msg.get(0));
	}
	
	/*
	 * Test removed value is assignable to the feature from the ExtendedClass
	 */
	@Test
	public void testRemoveExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeAttribExtendedClass.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test removed value is not assignable to the feature from the ExtendedClass
	 */
	@Test
	public void testRemoveExtendedClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeAttribExtendedClassError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 103, 108, "[java.lang.String] cannot be removed from [Sequence(ecore::EInt)] (expected [Sequence(ecore::EInt),ecore::EInt])", msg.get(0));
	}
	
	/*
	 * Test removed value is assignable to the feature from the RuntimeClass
	 */
	@Test
	public void testRemoveRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeAttribRuntimeClass.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test removed value is not assignable to the feature from the RuntimeClass
	 */
	@Test
	public void testRemoveRuntimeClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeAttribRuntimeClassError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 106, 111, "[java.lang.String] cannot be removed from [Sequence(ecore::EInt)] (expected [Sequence(ecore::EInt),ecore::EInt])", msg.get(0));
	}
	
	/**
	 * Test using the '+=' on self raise an error
	 */
	@Test
	public void testInsertSelf() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertSelf.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 61, 65, "'self' does not support the '+=' operator", msg.get(0));
	}
	
	/**
	 * Test that a value can be inserted into a local Collection
	 */
	@Test
	public void testInsertIntoLocalCollection() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertLocalCollection.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test that a value cannot be inserted into a local Collection if their types mismatch
	 */
	@Test
	public void testInsertIntoLocalCollectionError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertLocalCollectionError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 177, 178, "[java.lang.Integer] cannot be added to [Sequence(ecore::EString)] (expected [Sequence(ecore::EString),ecore::EString])", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 193, 201, "[Sequence(java.lang.Integer)] cannot be added to [Sequence(ecore::EString)] (expected [Sequence(ecore::EString),ecore::EString])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(1));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 216, 230, "[Sequence(java.lang.Integer)] cannot be added to [Sequence(ecore::EString)] (expected [Sequence(ecore::EString),ecore::EString])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(2));
	}
	
	/**
	 * Test that the iterator of a for-each loop can be inserted into a local collection
	 */
	@Test
	public void testInsertIntoLocalCollectionInForEachLoop() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertLocalCollectionInForEachLoop.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test that the iterator of a for-each loop cannot be inserted into a local collection if their types mismatch
	 */
	@Test
	public void testInsertIntoLocalCollectionInForEachLoopError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertLocalCollectionInForEachLoopError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 244, 250, "[java.lang.Integer] cannot be added to [Sequence(ecore::EString)] (expected [Sequence(ecore::EString),ecore::EString])", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 267, 273, "[java.lang.Integer] cannot be added to [Sequence(ecore::EString)] (expected [Sequence(ecore::EString),ecore::EString])", msg.get(1));
	}
	
	/**
	 * Test that some do not support the '-=' operator
	 */
	@Test
	public void testInsertIntoLocalVariableError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertIntoLocalBooleanError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 98, 114, "[ecore::EBoolean] does not support the '+=' operator", msg.get(0));
	}
	
	/**
	 * Test that the result special variable supports the '+=' operator
	 */
	@Test
	public void testInsertResult() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertResult.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test that using '+=' with the result special variable produces an error when types mismatch
	 */
	@Test
	public void testInsertResultError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertResultError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(4, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 75, 77, "[java.lang.Integer] cannot be added to [ecore::EString] (expected [ecore::EString])", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 111, 117, "[ecore::EBoolean] does not support the '+=' operator", msg.get(1));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 179, 187, "[java.lang.String] cannot be added to [Sequence(ecore::EInt)] (expected [Sequence(ecore::EInt),ecore::EInt])", msg.get(2));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 201, 222, "[Sequence(java.lang.Boolean)] cannot be added to [Sequence(ecore::EInt)] (expected [Sequence(ecore::EInt),ecore::EInt])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(3));
	}
	
	/**
	 * Test that the result special variable supports the '-=' operator
	 */
	@Test
	public void testRemoveResult() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeResult.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test that using '-=' with the result special variable produces an error when types mismatch
	 */
	@Test
	public void testRemoveResultError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeResultError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(4, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 75, 79, "[java.lang.String] cannot be removed from [ecore::EInt] (expected [ecore::EInt])", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 113, 119, "[ecore::EBoolean] does not support the '-=' operator", msg.get(1));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 181, 189, "[java.lang.String] cannot be removed from [Sequence(ecore::EInt)] (expected [Sequence(ecore::EInt),ecore::EInt])", msg.get(2));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 203, 224, "[Sequence(java.lang.Boolean)] cannot be removed from [Sequence(ecore::EInt)] (expected [Sequence(ecore::EInt),ecore::EInt])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(3));
	}
	
	@Test
	public void testInsertStringToString() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertStringToString.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testInsertIntToString() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertIntToString.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 89, 91, "[java.lang.Integer] cannot be added to [ecore::EString] (expected [ecore::EString])", msg.get(0));
	}
	
	@Test
	public void testInsertStringToInt() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertStringToInt.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 86, 93, "[java.lang.String] cannot be added to [ecore::EInt] (expected [ecore::EInt])", msg.get(0));
	}
	
	@Test
	public void testInsertIntToInt() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/insertIntToInt.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test using the '-=' on self raise an error
	 */
	@Test
	public void testRemoveFromSelf() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeSelf.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 61, 65, "'self' does not support the '-=' operator", msg.get(0));
	}
	
	/**
	 * Test that a value can be removed from a local Collection
	 */
	@Test
	public void testRemoveFromLocalCollection() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeLocalCollection.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test that a value cannot be removed from a local Collection if their types mismatch
	 */
	@Test
	public void testRemoveFromLocalCollectionError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeLocalCollectionError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 177, 178, "[java.lang.Integer] cannot be removed from [Sequence(ecore::EString)] (expected [Sequence(ecore::EString),ecore::EString])", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 193, 201, "[Sequence(java.lang.Integer)] cannot be removed from [Sequence(ecore::EString)] (expected [Sequence(ecore::EString),ecore::EString])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(1));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 216, 230, "[Sequence(java.lang.Integer)] cannot be removed from [Sequence(ecore::EString)] (expected [Sequence(ecore::EString),ecore::EString])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(2));
	}
	
	/**
	 * Test that the iterator of a for-each loop can be removed from a local collection
	 */
	@Test
	public void testRemoveFromLocalCollectionInForEachLoop() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeLocalCollectionInForEachLoop.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Test that the iterator of a for-each loop cannot be removed from a local collection if their types mismatch
	 */
	@Test
	public void testRemoveFromLocalCollectionInForEachLoopError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeLocalCollectionInForEachLoopError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 244, 250, "[java.lang.Integer] cannot be removed from [Sequence(ecore::EString)] (expected [Sequence(ecore::EString),ecore::EString])", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 267, 273, "[java.lang.Integer] cannot be removed from [Sequence(ecore::EString)] (expected [Sequence(ecore::EString),ecore::EString])", msg.get(1));
	}
	
	/**
	 * Test that some types do not support the '-=' operator
	 */
	@Test
	public void testRemoveFromLocalVariableError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/removeLocalVariablesError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 98, 114, "[ecore::EBoolean] does not support the '-=' operator", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 158, 164, "[ecore::EString] does not support the '-=' operator", msg.get(1));
	}
	
	/*
	 * Test that for-each loops accept integer ranges:
	 * 		for (i in [0..10])
	 */
	@Test
	public void testForEachIntegerRange() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/forEachIntRange.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test ForEach expression is not a Collection
	 */
	@Test
	public void testForEachNotCollection() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/forEachCollectionError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 70, 73, "Expected Collection but was [java.lang.Boolean]", msg.get(0));
	}
	
	/*
	 * Test type of ForEach variable is inferred
	 */
	@Test
	public void testForEachSequence() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/forEachSequence.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals("should have no errors but was: " + msg, 0, msg.size());
	}
	
	/*
	 * Test type of ForEach variable is inferred
	 */
	@Test
	public void testForEachSequenceError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/forEachSequenceError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 143, 144, "Type mismatch: cannot assign [java.lang.String] to [ecore::EInt]", msg.get(0));
	}
	
	/*
	 * Test that a method can be used to set the range of a for-each loop
	 */
	@Test
	public void testForEachRangeFromMethodCall() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/forEachRangeFromMethodCall.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals("Got: " + msg, 0, msg.size());
	}
	
	/*
	 * Test If expression is a boolean
	 */
	@Test
	public void testIfBoolean() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/ifBoolean.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test If expression is not a boolean
	 */
	@Test
	public void testIfNotBoolean() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/ifBooleanError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 63, 69, "Expected [ecore::EBoolean] but was [java.lang.Integer]", msg.get(0));
	}
	
	/*
	 * Test While expression is a boolean
	 */
	@Test
	public void testWhileBoolean() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/whileBoolean.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test While expression is not a boolean
	 */
	@Test
	public void testWhileNotBoolean() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/whileBooleanError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 69, 78, "Expected [ecore::EBoolean] but was [java.lang.String]", msg.get(0));
	}
	
	/*
	 * Test call argument is assignable to EParameter's type from baseClass
	 */
	@Test
	public void testCallArgumentBaseClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/callBaseClass.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test call argument is not assignable to EParameter's type from baseClass
	 */
	@Test
	public void testCallArgumentBaseClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/callBaseClassError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 68, 84, "Couldn't find the 'isSuperTypeOf(EClassifier=EClass,java.lang.Integer)' service", msg.get(0));
	}
	
	/*
	 * Test call argument is assignable to EParameter's type from ExtendedClass
	 */
	@Test
	public void testCallArgumentExtendedClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/callExtendedClass.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test call argument is not assignable to EParameter's type from ExtendedClass
	 */
	@Test
	public void testCallArgumentExtendedClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/callExtendedClassError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 68, 74, "Couldn't find the 'foo(EClassifier=EClass,java.lang.Integer)' service", msg.get(0));
	}
	
	/*
	 * Test call argument is assignable to EParameter's type from RuntimeClass
	 */
	@Test
	public void testCallArgumentRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/callRuntimeClass.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/*
	 * Test call argument is not assignable to EParameter's type from RuntimeClass
	 */
	@Test
	public void testCallArgumentRuntimeClassConflict() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/callRuntimeClassError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 71, 77, "Couldn't find the 'foo(EClassifier=MyRuntimeClass,java.lang.Integer)' service", msg.get(0));
	}
	
	@Test
	public void testInferIfThen() {
		env = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/validation/inferIfThen.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 156, 161, "Couldn't find the 'bar(EClassifier=A)' service", msg.get(0));
	}
	
	@Test
	public void testInferIfElse() {
		env = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/validation/inferIfElse.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(msg.toString(), 1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 120, 125, "Couldn't find the 'bar(EClassifier=A)' service", msg.get(0));
	}
	
	@Test
	public void testInferElseIf() {
		env = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/validation/inferElseIf.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 249, 254, "Couldn't find the 'bar(EClassifier=A)' service", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 293, 298, "Couldn't find the 'foo(EClassifier=EObject)' service", msg.get(1));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 324, 329, "Couldn't find the 'bar(EClassifier=EObject)' service", msg.get(2));
	}
	
	@Test
	public void testInferNotElseIf() {
		env = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/validation/inferElseIf2.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 126, 131, "Couldn't find the 'foo(EClassifier=EObject)' service", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 157, 162, "Couldn't find the 'bar(EClassifier=EObject)' service", msg.get(1));
		try {
			assertMsgEquals(env, ValidationMessageLevel.ERROR, 328, 333, "Couldn't find the 'bar(EClassifier=EObject)' service" + lineSeparator() + "Couldn't find the 'bar(EClassifier=A)' service", msg.get(2));
		} catch (ComparisonFailure e) {
			// FIXME for some reason the order is reversed in CI
			assertMsgEquals(env, ValidationMessageLevel.ERROR, 328, 333, "Couldn't find the 'bar(EClassifier=A)' service" + lineSeparator() + "Couldn't find the 'bar(EClassifier=EObject)' service", msg.get(2));
		}
	}
	
	@Test
	public void testInferWhile() {
		env = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/validation/inferWhile.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testInferWhileError() {
		env = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/validation/inferWhileError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 127, 137, "Couldn't find the 'bar(EClassifier=A,EClassifier=A)' service", msg.get(0));
	}
	
	@Test
	public void testInferInner() {
		env = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/validation/inferInner.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(msg.toString(), 0, msg.size());
	}
	
	@Test
	public void testAssignCreate() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignCreate.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testAssignCreateError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignCreateError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 80, 106, "Type mismatch: cannot assign [ecore::EOperation] to [ecore::EClass]", msg.get(0));
	}
	
	@Test
	public void testAssignSubtype() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignSubtype.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testAssignCollection() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignCollection.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(msg.toString(), 0, msg.size());
	}
	
	@Test
	public void testAssignCollectionError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignCollectionError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 90, 94, "Type mismatch: cannot assign [ecore::EClass] to [Sequence(ecore::EClass)]", msg.get(0));
	}
	
	@Test
	public void testAssignCollectionError2() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignCollectionError2.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 90, 91, "Type mismatch: cannot assign [java.lang.Integer] to [Sequence(ecore::EClass)]", msg.get(0));
	}
	
	@Test
	public void testDeclareCollection() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/declareCollection.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testDeclareCollection2() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/declareCollection2.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testDeclareCollectionError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/declareCollectionError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 100, 101, "Type mismatch: cannot assign [java.lang.Integer] to [Sequence(ecore::EInt)]", msg.get(0));
	}
	
	@Test
	public void testAssignCollectionType() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignCollectionType.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testAssignCollectionTypeError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignCollectionTypeError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 125, 143, "Type mismatch: cannot assign [Sequence(java.lang.String)] to [Sequence(ecore::EInt)]", msg.get(0));
	}
	@Test
	public void testAssignSequenceFeature() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignSequenceFeature.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	@Test
	public void testAssignSequenceFeatureError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignSequenceFeatureError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 143, 147, "Type mismatch: cannot assign [ecore::EClass] to [Sequence(ecore::EClass)]", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 170, 192, "Type mismatch: cannot assign [ecore::EClass] to [Sequence(ecore::EClass)]", msg.get(1));
	}
	@Test
	public void testAssignSequenceVarDecl() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignSequenceVarDecl.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	@Test
	public void testAssignSequenceVarDeclError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignSequenceVarDeclError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(4, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 124, 128, "Type mismatch: cannot assign [ecore::EClass] to [Sequence(ecore::EClass)]", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 147, 151, "Type mismatch: cannot assign [ecore::EClass] to [Sequence(ecore::EClass)]", msg.get(1));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 194, 216, "Type mismatch: cannot assign [ecore::EClass] to [Sequence(ecore::EClass)]", msg.get(2));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 235, 257, "Type mismatch: cannot assign [ecore::EClass] to [Sequence(ecore::EClass)]", msg.get(3));
	}
	
	@Test
	public void testAssignSequenceResult() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignSequenceResult.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	@Test
	public void testAssignSequenceResultError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignSequenceResultError.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 110, 132, "Type mismatch: cannot assign [ecore::EClass] to [Sequence(ecore::EClass)]", msg.get(0));
	}
	
	@Test
	public void testInitAttributesToNull() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/initializeAttributesToNull.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals("Unexpected errors: " + msg, 0, msg.size());
	}
	
	@Test
	public void testAssignNullToAttribute() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignNullToAttribute.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals("Unexpected errors: " + msg, 0, msg.size());
	}
	
	@Test
	public void testAssignNullToLocalVariables() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/assignNullToLocalVariables.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals("Unexpected errors: " + msg, 0, msg.size());
	}
	
	/**
	 * Test that an operation can take a sequence as parameter and use it freely
	 */
	@Test
	public void testCallMethodTakingASequence() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/callMethodTakingSequence.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals("no error was expected but got: " + msg, 0, msg.size());
	}
	
	@Test
	public void testUnresolvedTypeInDeclarationError() {
		env = IAleEnvironment.fromPaths(asList(),asList("input/validation/unresolvedTypeInDeclaration.implem"));
		
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 64, 84, "Unresolved type '', it cannot be found in any of the declared packages:" + nl() + 
				" - ecore (http://www.eclipse.org/emf/2002/Ecore)" + nl() + 
				" - implementation (http://implementation/)" + nl() + 
				" - ast (http://www.eclipse.org/acceleo/query/1.0)" + nl() + 
				" - test (http://ale/runtime/test)" + nl() +
				" - test::unresolvedTypeInDecaration (http://ale/runtime/test/unresolvedTypeInDecaration)", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 136, 157, "Unresolved type '', it cannot be found in any of the declared packages:" + nl() + 
				" - ecore (http://www.eclipse.org/emf/2002/Ecore)" + nl() + 
				" - implementation (http://implementation/)" + nl() + 
				" - ast (http://www.eclipse.org/acceleo/query/1.0)" + nl() + 
				" - test (http://ale/runtime/test)" + nl() +
				" - test::unresolvedTypeInDecaration (http://ale/runtime/test/unresolvedTypeInDecaration)", msg.get(1));
	}
	
	@Test
	public void testAssignmentSequenceAndOrderedSetError() {
		env = IAleEnvironment.fromPaths(asList() ,asList("input/validation/assignmentSequenceAndOrderedSetError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(msg.toString(), 1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 85, 108, "Type mismatch: cannot assign [Set(java.lang.Boolean)] to [Sequence(ecore::EBoolean)]\n------------------------------------------------------------------------------------\nCall anOrderedSet->asSequence() to allow assignment", msg.get(0));
		
		// FIXME This test is valid but we currently can't create Set variables. Should be fixed ASAP 
//		assertMsgEquals(env, ValidationMessageLevel.ERROR, 152, 217, "Type mismatch: cannot assign [Sequence(ecore::EClass)] to [Set(ecore::EClass)]\n------------------------------------------------------------------------------\nCall aSequence->asOrderedSet() to allow assignment", msg.get(1));
	}
	
	@Test
	public void testAdditionAssignmentSequenceAndOrderedSet() {
		env = IAleEnvironment.fromPaths(asList() ,asList("input/validation/additionAssignmentSequenceAndOrderedSet.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(msg.toString(), 0, msg.size());
	}
	
	@Test
	public void testAdditionAssignmentSequenceAndOrderedSetError() {
		env = IAleEnvironment.fromPaths(asList() ,asList("input/validation/additionAssignmentSequenceAndOrderedSetError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(msg.toString(), 6, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 241, 260, "[Set(java.lang.Integer)] cannot be added to [Sequence(ecore::EBoolean)] (expected [Sequence(ecore::EBoolean),ecore::EBoolean])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 283, 305, "[Sequence(java.lang.String)] cannot be added to [Sequence(ecore::EClass)] (expected [Sequence(ecore::EClass),ecore::EClass])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(1));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 414, 433, "[Set(java.lang.Integer)] cannot be added to [Sequence(ecore::EBoolean)] (expected [Sequence(ecore::EBoolean),ecore::EBoolean])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(2));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 452, 474, "[Sequence(java.lang.String)] cannot be added to [Sequence(ecore::EClass)] (expected [Sequence(ecore::EClass),ecore::EClass])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(3));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 500, 519, "[Set(java.lang.Integer)] cannot be added to [Sequence(ecore::EString)] (expected [Sequence(ecore::EString),ecore::EString])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(4));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 539, 566, "[Sequence(java.lang.Boolean)] cannot be added to [Sequence(ecore::EInt)] (expected [Sequence(ecore::EInt),ecore::EInt])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(5));
	}
	
	@Test
	public void testSubstractionAssignmentSequenceAndOrderedSet() {
		env = IAleEnvironment.fromPaths(asList() ,asList("input/validation/substractionAssignmentSequenceAndOrderedSet.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(msg.toString(), 0, msg.size());
	}
	
	@Test
	public void testSubstractionAssignmentSequenceAndOrderedSetError() {
		env = IAleEnvironment.fromPaths(asList() ,asList("input/validation/substractionAssignmentSequenceAndOrderedSetError.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(msg.toString(), 6, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 241, 260, "[Set(java.lang.Integer)] cannot be removed from [Sequence(ecore::EBoolean)] (expected [Sequence(ecore::EBoolean),ecore::EBoolean])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 283, 305, "[Sequence(java.lang.String)] cannot be removed from [Sequence(ecore::EClass)] (expected [Sequence(ecore::EClass),ecore::EClass])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(1));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 414, 433, "[Set(java.lang.Integer)] cannot be removed from [Sequence(ecore::EBoolean)] (expected [Sequence(ecore::EBoolean),ecore::EBoolean])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(2));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 452, 474, "[Sequence(java.lang.String)] cannot be removed from [Sequence(ecore::EClass)] (expected [Sequence(ecore::EClass),ecore::EClass])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(3));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 500, 519, "[Set(java.lang.Integer)] cannot be removed from [Sequence(ecore::EString)] (expected [Sequence(ecore::EString),ecore::EString])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(4));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 539, 566, "[Sequence(java.lang.Boolean)] cannot be removed from [Sequence(ecore::EInt)] (expected [Sequence(ecore::EInt),ecore::EInt])\n--------------------------------------------------\nMake sure both collections hold the same type", msg.get(5));
	}
	
	@Test
	public void testAssignmentsInvolvingRuntimeClassesAreTypeChecked() {
		env = IAleEnvironment.fromPaths(asList() ,asList("input/validation/assignmentsInvolvingRuntimeClasses.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(msg.toString(), 1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 278, 282, "Type mismatch: cannot assign [ecore::EClass] to [helloworld::MyClass]", msg.get(0));
	}
	
}
