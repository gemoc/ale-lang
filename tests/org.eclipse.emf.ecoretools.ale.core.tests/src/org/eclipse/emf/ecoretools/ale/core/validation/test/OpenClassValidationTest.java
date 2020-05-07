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

import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
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
		ALEValidator validator = new ALEValidator(env.getContext());
		validator.validate(env.getBehaviors().getParsedFiles());
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testInvertMultiInherits() {
		env = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/invertMultiInherits.implem"));
		ALEValidator validator = new ALEValidator(env.getContext());
		validator.validate(env.getBehaviors().getParsedFiles());
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 280, 352, "The extended EClass C have to be after B", msg.get(0));
	}
	
	@Test
	public void testServeralOpenClass() {
		env = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/simple.implem","input/lookup/implicitExtend.implem"));
		ALEValidator validator = new ALEValidator(env.getContext());
		validator.validate(env.getBehaviors().getParsedFiles());
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 32, 148, "The EClass A is already opened (need explicit extends)", msg.get(0));
	}
	
	@Test
	public void testForbidenExtends() {
		env = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/forbiddenExtend.implem"));
		ALEValidator validator = new ALEValidator(env.getContext());
		validator.validate(env.getBehaviors().getParsedFiles());
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 212, 282, "Can't extend diamon::B since it is not a direct super type of diamon::C", msg.get(0));
	}
	
	@Test
	public void testIndirectExtends() {
		env = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/indirectExtend.implem"));
		ALEValidator validator = new ALEValidator(env.getContext());
		validator.validate(env.getBehaviors().getParsedFiles());
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 212, 282, "Can't extend diamon::A since it is not a direct super type of diamon::D", msg.get(0));
	}
	
	@Test
	public void testDirectExtend() {
		env = IAleEnvironment.fromPaths(asList("model/diamon.ecore"),asList("input/lookup/directExtend.implem"));
		ALEValidator validator = new ALEValidator(env.getContext());
		validator.validate(env.getBehaviors().getParsedFiles());
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testOpeningNonExistingClass() {
		env = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/validation/openingNonExistingClass.implem"));
		ALEValidator validator = new ALEValidator(env.getContext());
		validator.validate(env.getBehaviors().getParsedFiles());
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 27, 49, "Cannot open class NonExisting: the class must be defined in an Ecore metamodel", msg.get(0));
	}
	
	@Test
	public void testOpeningLocallyDefinedRuntimeClass() {
		env = IAleEnvironment.fromPaths(asList("model/ABC.ecore"),asList("input/validation/openingLocallyDefinedRuntimeClass.implem"));
		ALEValidator validator = new ALEValidator(env.getContext());
		validator.validate(env.getBehaviors().getParsedFiles());
		List<IValidationMessage> msg = validator.getMessages();
		
		assertTrue("Opening a locally defined class should not raise any error", msg.isEmpty());
	}
	
}
