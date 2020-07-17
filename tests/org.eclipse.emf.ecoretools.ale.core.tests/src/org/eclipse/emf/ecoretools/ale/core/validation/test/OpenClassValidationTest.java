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

public class OpenClassValidationTest {
	
	IAleEnvironment env;
	
	@After
	public void setup(){
		if (env != null) {
			env.close();
		}
	}
	
	@Test
	public void testMultiInherits() {
		env = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/multiInherits.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testInvertMultiInherits() {
		env = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/invertMultiInherits.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 280, 302, "The extended EClass C has to be after B", msg.get(0));
	}
	
	@Test
	public void testSeveralOpenClass() {
		env = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/simple.implem","input/lookup/implicitExtend.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(msg.toString(), 2, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 30, 146, "The EClass A is already opened (need explicit extends)", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 32, 148, "The EClass A is already opened (need explicit extends)", msg.get(1));
	}
	
	@Test
	public void testForbidenExtends() {
		env = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/forbiddenExtend.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 212, 234, "Cannot inherit from 'diamon::B' since it is not a direct super type of 'diamon::C'", msg.get(0));
	}
	
	@Test
	public void testIndirectExtends() {
		env = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/indirectExtend.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 212, 234, "Cannot inherit from 'diamon::A' since it is not a direct super type of 'diamon::D'", msg.get(0));
	}
	
	@Test
	public void testDirectExtend() {
		env = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/directExtend.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testOpeningNonExistingClass() {
		env = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/validation/openingNonExistingClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 27, 49, "Cannot open 'NonExisting': the class must be defined in an Ecore metamodel", msg.get(0));
	}
	
	@Test
	public void testOpeningLocallyDefinedRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/validation/openingLocallyDefinedRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertTrue("Opening a locally defined class should not raise any error", msg.isEmpty());
	}
	
	@Test
	public void testOpeningEnumShouldShowAnError() {
		env = IAleEnvironment.fromPaths(asList("model/test.ecore"),asList("input/validation/openingEnum.implem"));
		ALEValidator validator = new ALEValidator(env);
		validator.validate(env.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 22, 39, "Cannot open 'MyEnum': make sure it is an EClass (not e.g. an EEnum)", msg.get(0));
		assertMsgEquals(env, ValidationMessageLevel.ERROR, 89, 93, "Type mismatch: cannot assign [implementation::UnresolvedEClassifier] to [ecore::EString]", msg.get(1));
	}
	
}
