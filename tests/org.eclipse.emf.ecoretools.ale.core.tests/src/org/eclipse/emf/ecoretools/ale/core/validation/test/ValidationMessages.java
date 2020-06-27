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

import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.TypeChecker;
import org.eclipse.emf.ecoretools.ale.validation.DiagnosticsToEditorMarkerAdapter;
import org.eclipse.emf.ecoretools.ale.validation.EditorMarkerFormatter;

/**
 * Provides utility methods for testing purposes. 
 */
final class ValidationMessages {
	
	private static DiagnosticsToEditorMarkerAdapter adapter;
	
	private ValidationMessages() {
		// utility classes should not be instantiated
	}
	
	static void assertMsgEquals(IAleEnvironment env, ValidationMessageLevel errorLvl, int startPos, int endPos, String text, Message msg){
		adapter = new DiagnosticsToEditorMarkerAdapter(str -> new FakeMarker(), new EditorMarkerFormatter(new TypeChecker(null, env.getContext())));
		IMarker marker = adapter.doSwitch(msg);
//		assertEquals("wrong error level", errorLvl, msg.getLevel());
		assertEquals("wrong start position", startPos, marker.getAttribute(IMarker.CHAR_START, -1));
		assertEquals("wrong end position", endPos, marker.getAttribute(IMarker.CHAR_END, -1));
		assertEquals("wrong message", text, marker.getAttribute(IMarker.MESSAGE, ""));
	}
	
}
