package org.eclipse.emf.ecoretools.ale.ide;

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
