/*******************************************************************************
 * Copyright (c) 2019 Inria and Obeo.
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
import static java.util.Collections.emptyList;
import static org.eclipse.emf.ecoretools.ale.core.validation.test.ValidationMessages.assertMsgEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.validation.ALEValidator;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.junit.After;
import org.junit.Test;

/**
 * Check the behavior of a {@link BaseValidator}.
 */
public class BaseValidatorTest {
	
	IAleEnvironment environment;
	
	@After
	public void dispose() {
		if (environment != null) {
			environment.close();
		}
	}
	
	/**
	 * Tests that the special 'result' variable can be read within a method's body.
	 */
	@Test
	public void testResultVariableCanBeRead() {
		environment = IAleEnvironment.fromPaths(emptyList(), asList("input/validation/resultRead.implem"));
		ALEValidator validator = new ALEValidator(environment);
		validator.validate(environment.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Tests that the type checker only allows to assign to 'result' a value which type
	 * matches method's return type. 
	 */
	@Test
	public void testTypeCheckingResultVariableAssignation() {
		environment = IAleEnvironment.fromPaths(emptyList(), asList("input/validation/assignForbiddenValueToResult.implem"));
		ALEValidator validator = new ALEValidator(environment);
		validator.validate(environment.getBehaviors().getParsedFiles());
		List<Message> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(environment, ValidationMessageLevel.ERROR, 77, 92, "Type mismatch: cannot assign [java.lang.String] to [ecore::EBoolean]", msg.get(0));
	}

}
