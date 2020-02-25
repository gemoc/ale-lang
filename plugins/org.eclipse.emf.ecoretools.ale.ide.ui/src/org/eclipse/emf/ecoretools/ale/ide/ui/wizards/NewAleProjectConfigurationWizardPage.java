/*******************************************************************************
 * Copyright (c) 2020 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.ide.ui.wizards;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;

/**
 * Wizard page used to configure an ALE project.
 */
public class NewAleProjectConfigurationWizardPage extends WizardPage {
	/**
	 * Key used by SWTBot to reliably identify widgets.
	 */
	private static final String SWTBOT_ID = "org.eclipse.swtbot.widget.key";
	/**
	 * Id used by SWTBot to identify the "create new Ecore model" radio button. 
	 */
	public static final String CREATE_ECORE_MODEL_BUTTON_ID = "createEcoreModelRadioButton";
	/**
	 * Id used by SWTBot to identify the "Package name" text field. 
	 */
	public static final String ECORE_PACKAGE_NAME_TEXT_ID = "ecorePackageName";
	
	/**
	 * Whether the "Create a new Ecore model" option should be activated by default.
	 */
	private static final boolean CREATE_NEW_ECORE_MODEL_BY_DEFAULT = true;
	/**
	 * Whether the "Create a Sirius representation" option should be activated by default.
	 */
	private static final boolean CREATE_SIRIUS_REPRESENTATION_BY_DEFAULT = true;
	/**
	 * Whether the "This project will expose Java services" option should be activated by default.
	 */
	private static final boolean EXPOSE_JAVA_SERVICES_BY_DEFAULT = false;

	/**
	 * Whether the user wants to use an existing Ecore model instead of creating a new one.
	 */
	private Button useAnExistingEcoreModelFileRadioButton;
	/**
	 * URI to the Ecore model chosen by the user (if he wants to reuse an existing one).
	 */
	private Text selectedEcoreModelText;
	/**
	 * Name of the new Ecore model (if the user wants to create a new one).
	 */
	private Text ecorePackageNameText;
	/**
	 * Whether the user wants a Sirius representation to be created for the Ecore model.
	 */
	private Button createRepresentationCheckBox;
	/**
	 * Whether the user plans to expose Java services.
	 */
	private Button useJavaServicesCheckBox;
	/**
	 * Whether this page has been visible at least once.
	 */
	private boolean hasBeenSeen = false;

	/**
	 * Instantiates a new wizard page aimed at configuring an ALE project
	 */
	protected NewAleProjectConfigurationWizardPage() {
		super("New ALE Project");
		setTitle("New ALE Project");
		setDescription("Configure the project.");
	}
	
	/**
	 * @return whether the user wants to reuse an existing Ecore model
	 */
	public boolean useExistingEcoreModel() {
		if (useAnExistingEcoreModelFileRadioButton == null) {
			return false;
		}
		return useAnExistingEcoreModelFileRadioButton.getSelection();
	}
	
	/**
	 * @return the path to the Ecore model to reuse (meaningful when the user wants
	 * 		   to reuse an existing one)
	 */
	public IPath getEcoreModelFile() {
		if (selectedEcoreModelText == null) {
			return Path.EMPTY;
		}
		return new Path(selectedEcoreModelText.getText());
	}
	
	/**
	 * @return the name of the new EPackage to create (meaningful when the user wants
	 * 		   to create a new Ecore model)
	 */
	public String getEcorePackageName() {
		if (ecorePackageNameText == null) {
			return "";
		}
		return ecorePackageNameText.getText().trim();
	}
	
	/**
	 * @return whether the user wants a Sirius representation to be created for the Ecore model
	 */
	public boolean createRepresentation() {
		if (createRepresentationCheckBox == null) {
			return false;
		}
		return createRepresentationCheckBox.getSelection();
	}
	
	/**
	 * @return whether the user wants to expose Java services in the new project
	 */
	public boolean activateJava() {
		if (useJavaServicesCheckBox == null) {
			return false;
		}
		return useJavaServicesCheckBox.getSelection();
	}

	public void setDefaultEcorePackage(String projectName) {
		ecorePackageNameText.setText(projectName);
	}
	
	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		createEcoreModelGroup(container);
		createRepresentationGroup(container);
		createServicesGroup(container);
		
		setControl(container);
	}
	
	@Override
	public void setVisible(boolean isVisible) {
		super.setVisible(isVisible);
		if (isVisible) {
			hasBeenSeen = true;
			ecorePackageNameText.setFocus();
			setPageComplete(isValid());
		}
	}

	/**
	 * Creates widgets allowing the user to select the king of Ecore model he wants.
	 */
	private void createEcoreModelGroup(Composite container) {
		Group group = new Group(container, SWT.LEFT);
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		group.setLayout(layout);
		group.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		group.setText("Ecore model");
		
		// "(x) Create a new Ecore model" button
		
		Button createNewEcoreModelFileRadioButton = new Button(group, SWT.RADIO | SWT.LEFT);
		createNewEcoreModelFileRadioButton.setText("Create a new Ecore model");
		createNewEcoreModelFileRadioButton.setToolTipText("A new Ecore model will be created in the project");
		createNewEcoreModelFileRadioButton.setSelection(CREATE_NEW_ECORE_MODEL_BY_DEFAULT);
		createNewEcoreModelFileRadioButton.setData(SWTBOT_ID, CREATE_ECORE_MODEL_BUTTON_ID);
		
		// Span the button horizontally
		GridData createNewEcoreModelFileLayoutData = new GridData(GridData.FILL_HORIZONTAL);
		createNewEcoreModelFileLayoutData.horizontalSpan = layout.numColumns;
		createNewEcoreModelFileRadioButton.setLayoutData(createNewEcoreModelFileLayoutData);
		
		// Ecore package name text field
		
		Label ecorePackageNameLabel = new Label(group, SWT.LEFT);
		ecorePackageNameLabel.setText("Package name: ");

		// Span the text displaying the path horizontally
		GridData ecorePackageNameLayoutData = new GridData();
		ecorePackageNameLayoutData.horizontalIndent = LayoutConstants.getIndent();
		ecorePackageNameLabel.setLayoutData(ecorePackageNameLayoutData);
		
		ecorePackageNameText = new Text(group, SWT.BORDER);
		// Span the text horizontally
		GridData ecorePackageNameTextLayoutData = new GridData(GridData.FILL_HORIZONTAL);
		ecorePackageNameTextLayoutData.horizontalSpan = layout.numColumns - 1;
		ecorePackageNameText.setLayoutData(ecorePackageNameTextLayoutData);
		ecorePackageNameText.setData(SWTBOT_ID, ECORE_PACKAGE_NAME_TEXT_ID);
		ecorePackageNameText.addListener(SWT.Modify, e -> setPageComplete(isValid()));
		
		// "( ) Use an existing Ecore model" button
		
		useAnExistingEcoreModelFileRadioButton = new Button(group, SWT.RADIO | SWT.LEFT);
		useAnExistingEcoreModelFileRadioButton.setText("Use an existing Ecore model");
		useAnExistingEcoreModelFileRadioButton.setText("The project will be configured to reuse an existing Ecore model");
		useAnExistingEcoreModelFileRadioButton.setSelection(! CREATE_NEW_ECORE_MODEL_BY_DEFAULT);
		
		// Span the button horizontally
		GridData useAnExistingEcoreModelFileLayoutData = new GridData(GridData.FILL_HORIZONTAL);
		useAnExistingEcoreModelFileLayoutData.horizontalSpan = layout.numColumns;
		useAnExistingEcoreModelFileRadioButton.setLayoutData(useAnExistingEcoreModelFileLayoutData);
		
		// "Browse Ecore models in workspace" button
		// Clicking the button opens a dialog that fills 'selectedEcoreModelText' text field
		
		Button browseExistingEcoreButton = new Button(group, SWT.NONE);
		browseExistingEcoreButton.setText("Select model...");
		browseExistingEcoreButton.setToolTipText("Opens a dialog to select an .ecore file within the workspace");
		browseExistingEcoreButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				FilteredResourcesSelectionDialog dialog = new FilteredResourcesSelectionDialog(
						shell, 
						false,
						ResourcesPlugin.getWorkspace().getRoot(),
						IResource.FILE
				);
				dialog.setTitle("Select an Ecore model");
				dialog.setInitialPattern("*.ecore");
				
				dialog.open();
				Object[] selected = dialog.getResult();
				
				if (selected != null && selected.length == 1 && selected[0] instanceof IResource) {
					IResource selectedModel = (IResource) selected[0];
					selectedEcoreModelText.setText("" + selectedModel.getFullPath().toPortableString());
				}
			}
		});
		GridData browseExistingEcoreLayoutData = new GridData();
		browseExistingEcoreLayoutData.horizontalIndent = LayoutConstants.getIndent();
		browseExistingEcoreButton.setLayoutData(browseExistingEcoreLayoutData);
		
		// Text displaying the path to the Ecore model to reuse
		
		selectedEcoreModelText = new Text(group, SWT.READ_ONLY | SWT.BORDER);
		selectedEcoreModelText.addListener(SWT.Modify, e -> {
			// Make sure "Use an existing Ecore model" button is checked when the user chooses one
			createNewEcoreModelFileRadioButton.setSelection(false);
			useAnExistingEcoreModelFileRadioButton.setSelection(true);
			setPageComplete(isValid());
		});

		// Span the text displaying the path horizontally
		GridData selectedEcoreModelTextLayoutData = new GridData(GridData.FILL_HORIZONTAL);
		selectedEcoreModelText.setLayoutData(selectedEcoreModelTextLayoutData);
	}

	/**
	 * Creates widgets allowing the user to customize Ecore model's Sirius representation.
	 */
	private void createRepresentationGroup(Composite container) {
		Group group = new Group(container, SWT.LEFT);
		GridLayout layout = new GridLayout();
		group.setLayout(layout);
		group.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		group.setText("Representation");
		
		if (SiriusPluginsAreAvailable()) {
			// "[x] Create a Sirius representation" button
			
			createRepresentationCheckBox = new Button(group,SWT.CHECK);
			createRepresentationCheckBox.setText("Create a Sirius representation");
			createRepresentationCheckBox.setToolTipText("Create an .aird representation file linked to the Ecore model in the model/ folder");
			createRepresentationCheckBox.setSelection(CREATE_SIRIUS_REPRESENTATION_BY_DEFAULT);
		}
		else {
			Text siriusIsNotAvailableText = new Text(group, SWT.READ_ONLY);
			siriusIsNotAvailableText.setText("Warning: Sirius UI seems not to be installed, we cannot create any representation.");
		}
	}
	
	@SuppressWarnings({"squid:S00100", "squid:S3516", "squid:S2159"})
	private static boolean SiriusPluginsAreAvailable() {
		try {
			DialectManager.INSTANCE.equals(null);
			return true;
		} 
		catch (Exception | NoClassDefFoundError e) {
			return false;
		}
	}

	/**
	 * Creates widgets allowing the user to tailor the services available to ALE.
	 */
	private void createServicesGroup(Composite container) {
		Group group = new Group(container, SWT.LEFT);
		GridLayout layout = new GridLayout();
		group.setLayout(layout);
		group.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		group.setText("Services");
		
		// "[ ] Expose Java services" button
		
		useJavaServicesCheckBox = new Button(group, SWT.CHECK);
		useJavaServicesCheckBox.setText("This project will expose Java services to ALE");
		useJavaServicesCheckBox.setToolTipText("Add the Java nature to the project");
		useJavaServicesCheckBox.setSelection(EXPOSE_JAVA_SERVICES_BY_DEFAULT);
	}
	
	/**
	 * @return whether the user has filled in all required info
	 */
	public boolean isValid() {
		if (! hasBeenSeen) {
			return false;
		}
		if (useExistingEcoreModel()) {
			return ! getEcoreModelFile().isEmpty();
		}
		else {
			return ! getEcorePackageName().isEmpty();
		}
	}

}
