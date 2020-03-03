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

import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.impl.RuntimeAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.core.validation.ALEValidator;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.junit.Before;
import org.junit.Test;

/**
 * Check the behavior of a {@link BaseValidator}.
 */
public class BaseValidatorTest {
	
	ALEInterpreter interpreter;
	
	@Before
	public void setup() {
		interpreter = new ALEInterpreter();
	}
	
	/**
	 * Tests that the special 'result' variable can be read within a method's body.
	 */
	@Test
	public void testResultVariableCanBeRead() {
		IAleEnvironment environment = new RuntimeAleEnvironment(emptyList(), asList("input/validation/resultRead.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	/**
	 * Tests that the type checker only allows to assign to 'result' a value which type
	 * matches method's return type. 
	 */
	@Test
	public void testTypeCheckingResultVariableAssignation() {
		IAleEnvironment environment = new RuntimeAleEnvironment(emptyList(), asList("input/validation/assignForbiddenValueToResult.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 77, 92, "Type mismatch: cannot assign [java.lang.String] to [ecore::EBoolean]", msg.get(0));
	}

}
