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
import org.eclipse.jface.layout.GridDataFactory;
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
	 * Whether the "Create a DSL configuration file" option should be activated by default.
	 */
	private static final boolean CREATE_DSL_FILE_BY_DEFAULT = false;

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
	 * Whether the user wants ALE environment to be defined in a .dsl configuration file.
	 */
	private Button createDslFileCheckBox;

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
			return ! CREATE_NEW_ECORE_MODEL_BY_DEFAULT;
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
			return CREATE_SIRIUS_REPRESENTATION_BY_DEFAULT;
		}
		return createRepresentationCheckBox.getSelection();
	}
	
	/**
	 * @return whether the user wants to expose Java services in the new project
	 */
	public boolean activateJava() {
		if (useJavaServicesCheckBox == null) {
			return EXPOSE_JAVA_SERVICES_BY_DEFAULT;
		}
		return useJavaServicesCheckBox.getSelection();
	}
	
	public boolean createDslFile() {
		if (createDslFileCheckBox == null) {
			return CREATE_DSL_FILE_BY_DEFAULT;
		}
		return createDslFileCheckBox.getSelection();
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
		group.setText(" Ecore model ");
		
		// "(x) Create a new Ecore model" button
		
		Button createNewEcoreModelFileRadioButton = new Button(group, SWT.RADIO | SWT.LEFT);
		createNewEcoreModelFileRadioButton.setText("Create a new Ecore model");
		createNewEcoreModelFileRadioButton.setToolTipText("A new Ecore model will be created in the model/ folder");
		createNewEcoreModelFileRadioButton.setSelection(CREATE_NEW_ECORE_MODEL_BY_DEFAULT);
		createNewEcoreModelFileRadioButton.setData(SWTBOT_ID, CREATE_ECORE_MODEL_BUTTON_ID);
		GridDataFactory.fillDefaults().span(layout.numColumns, 1).applyTo(createNewEcoreModelFileRadioButton);
		
		// Ecore package name text field
		
		Label ecorePackageNameLabel = new Label(group, SWT.LEFT);
		ecorePackageNameLabel.setText("Package name: ");
		GridDataFactory.swtDefaults().indent(LayoutConstants.getIndent(), 0).applyTo(ecorePackageNameLabel);
		
		ecorePackageNameText = new Text(group, SWT.BORDER);
		ecorePackageNameText.setData(SWTBOT_ID, ECORE_PACKAGE_NAME_TEXT_ID);
		ecorePackageNameText.addListener(SWT.Modify, e -> setPageComplete(isValid()));
		GridDataFactory.createFrom(new GridData(GridData.FILL_HORIZONTAL)).span(layout.numColumns - 1, 1).applyTo(ecorePackageNameText);
		
		// "( ) Use an existing Ecore model" button
		
		useAnExistingEcoreModelFileRadioButton = new Button(group, SWT.RADIO | SWT.LEFT);
		useAnExistingEcoreModelFileRadioButton.setText("Use an existing Ecore model");
		useAnExistingEcoreModelFileRadioButton.setToolTipText("The project will be configured to reuse an existing Ecore model");
		useAnExistingEcoreModelFileRadioButton.setSelection( ! CREATE_NEW_ECORE_MODEL_BY_DEFAULT);
		GridDataFactory.fillDefaults().span(layout.numColumns, 1).applyTo(useAnExistingEcoreModelFileRadioButton);
		
		// "Browse Ecore models in workspace" button
		// Clicking the button opens a dialog that fills 'selectedEcoreModelText' text field
		
		Button browseExistingEcoreButton = new Button(group, SWT.NONE);
		browseExistingEcoreButton.setText("Select model...");
		browseExistingEcoreButton.setToolTipText("Opens a dialog to select an .ecore file within the workspace");
		GridDataFactory.swtDefaults().indent(LayoutConstants.getIndent(), 0).applyTo(browseExistingEcoreButton);
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
		
		// Text displaying the path to the Ecore model to reuse
		
		selectedEcoreModelText = new Text(group, SWT.READ_ONLY | SWT.BORDER);
		GridDataFactory.createFrom(new GridData(GridData.FILL_HORIZONTAL)).span(layout.numColumns - 1, 1).applyTo(selectedEcoreModelText);
		selectedEcoreModelText.addListener(SWT.Modify, e -> {
			// Make sure "Use an existing Ecore model" button is checked when the user chooses one
			createNewEcoreModelFileRadioButton.setSelection(false);
			useAnExistingEcoreModelFileRadioButton.setSelection(true);
			setPageComplete(isValid());
		});
	}

	/**
	 * Creates widgets allowing the user to customize Ecore model's Sirius representation.
	 */
	private void createRepresentationGroup(Composite container) {
		Group group = new Group(container, SWT.LEFT);
		group.setLayout(new GridLayout());
		group.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		group.setText(" Representation ");
		
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
	
	/**
	 * Checks whether Sirius plug-ins are available because they are an <b>optional</b> dependency
	 * and we don't want the user to ask for a class diagram if we can't provide one.
	 */
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
		group.setLayout(new GridLayout());
		group.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
		group.setText(" Services ");
		
		// "[ ] Expose Java services" check box
		
		useJavaServicesCheckBox = new Button(group, SWT.CHECK);
		useJavaServicesCheckBox.setText("Will expose Java services to ALE");
		useJavaServicesCheckBox.setToolTipText("Add the Java nature to the project, allowing the definition of ALE services");
		useJavaServicesCheckBox.setSelection(EXPOSE_JAVA_SERVICES_BY_DEFAULT);
		
		// "[ ] Define environment in a .dsl file" check box
		
		createDslFileCheckBox = new Button(group, SWT.CHECK);
		createDslFileCheckBox.setText("Define environment in a .dsl file");
		createDslFileCheckBox.setToolTipText("Ease integration with third-parties (GEMOC Studio, Maven) and collaboration with colleagues");
		createDslFileCheckBox.setSelection(CREATE_DSL_FILE_BY_DEFAULT);
	}
	
	/**
	 * @return whether the user has filled in all required info
	 */
	public boolean isValid() {
		if (useExistingEcoreModel()) {
			return ! getEcoreModelFile().isEmpty();
		}
		else {
			// Actually, requires that the Ecore package name is not empty.
			// But in our case we consider that the package is named after the project by default.
			return true;
		}
	}

}
