/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.messages;

import org.eclipse.osgi.util.NLS;

/**
 * Helper class to obtains translated strings.
 * 
 */
@SuppressWarnings("squid:S3008")
public final class Messages extends NLS {
	
	private static final String BASE_NAME = "org.eclipse.emf.ecoretools.ale.core.messages.messages"; //$NON-NLS-1$

    static {
    	// load message values from bundle file
    	NLS.initializeMessages(BASE_NAME, Messages.class);
    }

    public static String AleInterpreter_errorWithExpression;

}
