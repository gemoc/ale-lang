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
package org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;

public class AleLaunchConfigurationTab extends AbstractLaunchConfigurationTab {

	Text dslSelection;
	Text modelSelection;
	
	@Override
	public void createControl(Composite parent) {
		Composite area = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout(1, false);
		gl.marginHeight = 0;
		area.setLayout(gl);
		area.layout();
		setControl(area);

		Group dslArea = createGroup(area, "DSL location");
		createDslWidgets(dslArea);

		Group modelArea = createGroup(area, "Model to run");
		createModelWidgets(modelArea);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(AleLaunchConfiguration.DSL_FILE, "");
		configuration.setAttribute(AleLaunchConfiguration.MODEL_FILE, "");
		try {
			configuration.doSave();
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			dslSelection.setText(configuration.getAttribute(AleLaunchConfiguration.DSL_FILE, ""));
			modelSelection.setText(configuration.getAttribute(AleLaunchConfiguration.MODEL_FILE, ""));
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(
				AleLaunchConfiguration.DSL_FILE,
				dslSelection.getText()
				);
		configuration.setAttribute(
				AleLaunchConfiguration.MODEL_FILE,
				modelSelection.getText()
				);
	}

	@Override
	public String getName() {
		return "ALE Launch Tab";
	}
	
	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		String dslName = dslSelection.getText().trim();
		String modelName = modelSelection.getText().trim();
		if (!dslName.isEmpty() && !modelName.isEmpty()) {
			
			IResource dslFile = workspace.getRoot().findMember(dslName);
			IResource modelFile = workspace.getRoot().findMember(modelName);
			
			if (dslFile == null || !dslFile.exists()) {
				return false;
			}
			if (modelFile == null || !modelFile.exists()) {
				return false;
			}
		}

		return true;
	}
	
	private Group createGroup(Composite parent, String text) {
		Group group = new Group(parent, SWT.NULL);
		group.setText(text);
		GridLayout locationLayout = new GridLayout();
		locationLayout.numColumns = 3;
		locationLayout.marginHeight = 10;
		locationLayout.marginWidth = 10;
		group.setLayout(locationLayout);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		group.setLayoutData(gd);
		return group;
	}

	private void createModelWidgets(Composite parent) {
		modelSelection = new Text(parent, SWT.SINGLE | SWT.BORDER);
		modelSelection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		modelSelection.addModifyListener(modifyEvent ->
				updateLaunchConfigurationDialog()
		);
		
		Button modelLocationButton = createPushButton(parent, "Browse", null);
		modelLocationButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent evt) {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(shell, ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
				dialog.setTitle("Model Selection");
				if (dialog.open() == ResourceListSelectionDialog.OK) {
					Object[] selected = dialog.getResult();
					modelSelection.setText(((IResource)selected[0]).getFullPath().toPortableString());
				}
			}
		});
	}
	
	private void createDslWidgets(Composite parent) {
		dslSelection = new Text(parent, SWT.SINGLE | SWT.BORDER);
		dslSelection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dslSelection.addModifyListener(modifyEvent ->
				updateLaunchConfigurationDialog()
		);
		
		Button dslLocationButton = createPushButton(parent, "Browse", null);
		dslLocationButton.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent evt) {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(shell, ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
				dialog.setTitle("DSL Selection");
				if (dialog.open() == ResourceListSelectionDialog.OK) {
					Object[] selected = dialog.getResult();
					dslSelection.setText(((IResource)selected[0]).getFullPath().toPortableString());
				}
			}
		});
	}
}
