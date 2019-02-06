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
package org.eclipse.emf.ecoretools.ale.ide.ui;

import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class AlePreferenceStore extends ScopedPreferenceStore{

	public static String ALE_PREF_XTEXT_FOCUS = "xtextFocus";
	public static String ALE_PREF_SERIALIZATION = "serialization";
	public static String ALE_PREF_SERIALIZATION_ALE = "ALE";
	public static String ALE_PREF_SERIALIZATION_Ecore = "Ecore";
	
	public AlePreferenceStore(IScopeContext context, String qualifier) {
		super(context, qualifier);
		setDefault(ALE_PREF_XTEXT_FOCUS, true);
		setDefault(ALE_PREF_SERIALIZATION, ALE_PREF_SERIALIZATION_ALE);
	}
}
