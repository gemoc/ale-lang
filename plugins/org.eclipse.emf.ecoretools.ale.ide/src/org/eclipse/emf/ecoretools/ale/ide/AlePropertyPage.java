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
package org.eclipse.emf.ecoretools.ale.ide;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.RadioGroupFieldEditor;
import org.eclipse.ui.IWorkbenchPropertyPage;
import org.eclipse.ui.preferences.ScopedPreferenceStore;

public class AlePropertyPage extends FieldEditorPreferencePage implements IWorkbenchPropertyPage {
	
	IProject project;
	
	@Override
	public IAdaptable getElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setElement(IAdaptable element) {
		project = (IProject) element.getAdapter(IResource.class);
	}

	@Override
	protected void createFieldEditors() {
		addField(new BooleanFieldEditor(AlePreferenceStore.ALE_PREF_XTEXT_FOCUS, "Activate text editor focus : ", getFieldEditorParent()));
		addField(new RadioGroupFieldEditor(AlePreferenceStore.ALE_PREF_SERIALIZATION, "Serialization mode : ", 1, new String[][]{{"ALE", AlePreferenceStore.ALE_PREF_SERIALIZATION_ALE},{"Ecore", AlePreferenceStore.ALE_PREF_SERIALIZATION_Ecore}}, getFieldEditorParent()));
	}
	
	@Override
	protected IPreferenceStore doGetPreferenceStore() {
		ScopedPreferenceStore store = new AlePreferenceStore(new ProjectScope(project), Activator.PLUGIN_ID); 
		return store;
    }

}
