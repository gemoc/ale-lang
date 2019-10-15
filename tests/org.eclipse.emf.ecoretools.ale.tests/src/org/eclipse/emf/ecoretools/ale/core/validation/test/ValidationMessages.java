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

import static org.junit.Assert.assertEquals;

import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;

/**
 * Provides utility methods for testing purposes. 
 */
final class ValidationMessages {
	
	private ValidationMessages() {
		// utility classes should not be instantiated
	}
	
	static void assertMsgEquals(ValidationMessageLevel errorLvl, int startPos, int endPos, String text, IValidationMessage msg){
		assertEquals("wrong error level", errorLvl, msg.getLevel());
		assertEquals("wrong start position", startPos, msg.getStartPosition());
		assertEquals("wrong end position", endPos, msg.getEndPosition());
		assertEquals("wrong message", text, msg.getMessage());
	}

}
