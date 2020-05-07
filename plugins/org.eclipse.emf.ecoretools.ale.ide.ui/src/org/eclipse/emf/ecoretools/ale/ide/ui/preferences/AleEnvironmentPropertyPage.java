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
package org.eclipse.emf.ecoretools.ale.ide.ui.preferences;

import static org.eclipse.emf.common.util.URI.createPlatformResourceURI;
import static org.eclipse.emf.ecoretools.ale.ide.project.AleProjectPreferences.ALE_SOURCE_FILES;
import static org.eclipse.emf.ecoretools.ale.ide.project.AleProjectPreferences.CONFIGURED_FROM_DSL_FILE;
import static org.eclipse.emf.ecoretools.ale.ide.project.AleProjectPreferences.DSL_FILE_PATH;
import static org.eclipse.emf.ecoretools.ale.ide.project.AleProjectPreferences.ECORE_MODEL_FILES;
import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.ide.ui.Activator;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.LayoutConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.eclipse.ui.dialogs.ResourceSelectionDialog;
import org.osgi.service.prefs.BackingStoreException;

/**
 * Property page to set project's {@link IAleEnvironment ALE environment}.
 * <p>
 * The environment can:
 * <ul>
 * 	<li>either be loaded from a DSL configuration file (.dsl)
 * 	<li>or manually specified
 * </ul> 
 */
public class AleEnvironmentPropertyPage extends AbstractPropertyPage  {
	
	public static final String CORE_PLUGIN_ID = "org.eclipse.emf.ecoretools.ale.core";
	
	private static final boolean IS_CONFIGURED_FROM_A_DSL_FILE_BY_DEFAULT = false;
	private static final String DEFAULT_DSL_FILE_PATH = "";
	private static final String DEFAULT_ALE_SOURCE_FILES = "";
	private static final String DEFAULT_ECORE_MODEL_FILES = "";
	
	private IEclipsePreferences preferences;
	
	private Button configureFromDslFileRadioButton;
		private Text dslFilePathText;
	
	private Button configureFromProjectPreferencesRadioButton;
		private Text aleSourceFilesPathText;
		private Text ecoreModelsPathText;

	@Override
	protected Control createContents(Composite parent) {
		if (! resolveCurrentProject()) {
			Activator.warn("Cannot create the 'ALE Environment' property page: failed to resolve current project", null);
            return new Composite(parent, SWT.NONE);
        }
		// Get preferences
		
        IScopeContext context = new ProjectScope(project);
        preferences = context.getNode(CORE_PLUGIN_ID);
        
        // Create main container
        
        Composite container = new Composite(parent, SWT.FILL);
        container.setLayout(new GridLayout(3, false));
		container.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));
        GridDataFactory.fillDefaults().grab(true, false).applyTo(container);
        
        // Fill the container

        try {
        	createPageDescription(container, 3);

        	addSeparator(container, 3);
        	
    		createConfigureFromPreferencesGroup(container);
			createConfigureFromDslFileGroup(container);
        } 
        catch (Exception e) {
            /* Should never happen */
            Activator.error("An error occurred while created the 'ALE Environment' property page", e);
        }
		return container;
	}
	
    @Override
	protected void performDefaults() {
		super.performDefaults();
		configureFromDslFileRadioButton.setSelection(IS_CONFIGURED_FROM_A_DSL_FILE_BY_DEFAULT);
		dslFilePathText.setText(DEFAULT_DSL_FILE_PATH);
		
		configureFromProjectPreferencesRadioButton.setSelection( ! IS_CONFIGURED_FROM_A_DSL_FILE_BY_DEFAULT);
		aleSourceFilesPathText.setText(DEFAULT_ALE_SOURCE_FILES);
		ecoreModelsPathText.setText(DEFAULT_ECORE_MODEL_FILES);
	}

	@Override
	public boolean performOk() {
		try {
            preferences.putBoolean(CONFIGURED_FROM_DSL_FILE.property(), configureFromDslFileRadioButton.getSelection());
            preferences.put(DSL_FILE_PATH.property(), dslFilePathText.getText().trim());
            preferences.put(ALE_SOURCE_FILES.property(), aleSourceFilesPathText.getText().trim());
            preferences.put(ECORE_MODEL_FILES.property(), ecoreModelsPathText.getText().trim());

            preferences.flush();
        } 
        catch (IllegalStateException | BackingStoreException unlikelyToHappen) {
            Activator.error("An unexpected error occurred while saving preferences", unlikelyToHappen);
            return false;
        }
        return true;
	}
    
    private void createPageDescription(Composite container, int numColumns) {
		String description = "Configure sources and metamodels in path. Affects editors, compilers and interpreters.\n"
						   + "See the documentation for further details.";
		
		StyledText linkToDocumentation = createLink(
				container,
                description,
                "http://gemoc.org/ale-lang",
                description.indexOf("See"),
                description.length() - description.indexOf("See") - 1
        );
		// Span the text displaying the path horizontally
		GridDataFactory.fillDefaults().span(numColumns, 1).grab(true, false).applyTo(linkToDocumentation);
    }

	private void createConfigureFromPreferencesGroup(Composite container) {
		int numColumns = 3;
		
//		Group container = new Group(parent, SWT.FILL);
//		container.setLayout(new GridLayout(3, false));
//		container.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));

		// "(x) Load the following resources to configure ALE's environment" button
		
		configureFromProjectPreferencesRadioButton = new Button(container, SWT.RADIO | SWT.LEFT);
		configureFromProjectPreferencesRadioButton.setText("Load the following resources to configure ALE's environment");
		configureFromProjectPreferencesRadioButton.setToolTipText("ALE source files and Ecore models will be loaded from the paths below");
		configureFromProjectPreferencesRadioButton.setSelection(
				! preferences.getBoolean(CONFIGURED_FROM_DSL_FILE.property(), IS_CONFIGURED_FROM_A_DSL_FILE_BY_DEFAULT)
		);
		configureFromProjectPreferencesRadioButton.addSelectionListener(widgetSelectedAdapter(event -> {
			aleSourceFilesPathText.setEnabled(configureFromProjectPreferencesRadioButton.getSelection());
			ecoreModelsPathText.setEnabled(configureFromProjectPreferencesRadioButton.getSelection());
			
			configureFromDslFileRadioButton.setSelection( ! configureFromProjectPreferencesRadioButton.getSelection());
			dslFilePathText.setEnabled( ! configureFromProjectPreferencesRadioButton.getSelection());
		}));
		GridDataFactory.fillDefaults().span(numColumns, 1).applyTo(configureFromProjectPreferencesRadioButton);
		
		// Text displaying the path to the ALE source files
		
		Label label = new Label(container, SWT.NONE);
		label.setText("ALE source files:");
		label.setToolTipText("Comma-separated list of .ale source files");
		GridDataFactory.swtDefaults().indent(LayoutConstants.getIndent(), 0).applyTo(label);
		
		aleSourceFilesPathText  = new Text(container, SWT.READ_ONLY | SWT.BORDER);
		aleSourceFilesPathText.setText(preferences.get(ALE_SOURCE_FILES.property(), ""));
		aleSourceFilesPathText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		aleSourceFilesPathText.setEnabled(configureFromProjectPreferencesRadioButton.getSelection());
		aleSourceFilesPathText.addListener(SWT.Modify, e -> {
			// Make sure "Load project's preferences" button is checked
			configureFromDslFileRadioButton.setSelection(false);
			configureFromProjectPreferencesRadioButton.setSelection(true);
			aleSourceFilesPathText.setToolTipText(aleSourceFilesPathText.getText());
		});
		
		// "Browse Ecore models in workspace" button
		// Clicking the button opens a dialog that fills 'aleSourceFilesPathText' text field
		
		Button browseAleSourceFiles = new Button(container, SWT.NONE);
		browseAleSourceFiles.setText("Browse ALE source files...");
		browseAleSourceFiles.setToolTipText("Opens a dialog to select .ale source files");
		GridDataFactory.fillDefaults().applyTo(browseAleSourceFiles);
		browseAleSourceFiles.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				ResourceSelectionDialog dialog = new ResourceSelectionDialog(
						shell, 
						ResourcesPlugin.getWorkspace().getRoot(),
						""
				);
				dialog.setTitle("Select the source files defining available behaviors");
				try {
					// Buggy, never mind
//					dialog.setInitialElementSelections(relativeURIsToFiles(aleSourceFilesPathText.getText()));
				} 
				catch (RuntimeException e) {
					// no valid file selected
				}
				dialog.open();
				Object[] selected = dialog.getResult();

				if (selected == null) {
					// Selection canceled, nothing to do
					return;
				}
				StringBuilder path = new StringBuilder();				
				for (Object selection : selected) {
					if (selection instanceof IFile) {
						IFile file = (IFile) selection;
						if ("ale".equals(file.getFileExtension())) {
							if (path.length() > 0) {
								path.append(",");
							}
							URI fileURI = createPlatformResourceURI(file.getFullPath().toPortableString(), true);
							path.append(fileURI.toString());
						}
					}
				}
				aleSourceFilesPathText.setText(path.toString());
			}
		});
		
		// Text displaying the path to the Ecore model files
		
		label = new Label(container, SWT.NONE);
		label.setText("Ecore models:");
		label.setToolTipText("Comma-separated list of .ecore model files");
		GridDataFactory.swtDefaults().indent(LayoutConstants.getIndent(), 0).applyTo(label);
		
		ecoreModelsPathText  = new Text(container, SWT.READ_ONLY | SWT.BORDER);
		ecoreModelsPathText.setText(preferences.get(ECORE_MODEL_FILES.property(), ""));
		ecoreModelsPathText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		ecoreModelsPathText.setEnabled(configureFromProjectPreferencesRadioButton.getSelection());
		ecoreModelsPathText.addListener(SWT.Modify, e -> {
			// Make sure "Use the preferences below" button is checked when the user chooses one
			configureFromDslFileRadioButton.setSelection(false);
			configureFromProjectPreferencesRadioButton.setSelection(true);
			ecoreModelsPathText.setToolTipText(ecoreModelsPathText.getText());
		});
		
		// "Browse Ecore models in workspace" button
		// Clicking the button opens a dialog that fills 'ecoreModelsPathText' text field
		
		Button browseEcoreModels = new Button(container, SWT.NONE);
		browseEcoreModels.setText("Browse Ecore model files...");
		browseEcoreModels.setToolTipText("Opens a dialog to select .ecore model files");
		GridDataFactory.fillDefaults().applyTo(browseEcoreModels);
		browseEcoreModels.addSelectionListener(widgetSelectedAdapter(event -> {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			ResourceSelectionDialog dialog = new ResourceSelectionDialog(
					shell, 
					ResourcesPlugin.getWorkspace().getRoot(),
					""
			);
			dialog.setTitle("Select the source files defining available behaviors");
			try {
				// Buggy, never mind
//				dialog.setInitialElementSelections(relativeURIsToFiles(ecoreModelsPathText.getText()));
			} 
			catch (RuntimeException e) {
				// no valid file selected 
			}
			dialog.open();
			Object[] selected = dialog.getResult();

			if (selected == null) {
				// Selection canceled, nothing to do
				return;
			}
			StringBuilder path = new StringBuilder();				
			for (Object selection : selected) {
				if (selection instanceof IFile) {
					IFile file = (IFile) selection;
					if ("ecore".equals(file.getFileExtension())) {
						if (path.length() > 0) {
							path.append(",");
						}
						URI fileURI = createPlatformResourceURI(file.getFullPath().toPortableString(), true);
						path.append(fileURI.toString());
					}
				}
			}
			ecoreModelsPathText.setText(path.toString());
		}));
	}

	private void createConfigureFromDslFileGroup(Composite container) {
		int numColumns = 3;
		
//		Group container = new Group(parent, SWT.FILL);
//		container.setLayout(new GridLayout(3, false));
//		container.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL | GridData.GRAB_HORIZONTAL));

		// "( ) Load the following DSL configuration file to configure ALE's environment" radio button
		
		configureFromDslFileRadioButton = new Button(container, SWT.RADIO | SWT.LEFT);
		configureFromDslFileRadioButton.setText("Load the following DSL configuration file to configure ALE's environment");
		configureFromDslFileRadioButton.setToolTipText("ALE source files and Ecore models will be loaded from a .dsl file");
		configureFromDslFileRadioButton.setSelection(
				preferences.getBoolean(CONFIGURED_FROM_DSL_FILE.property(), IS_CONFIGURED_FROM_A_DSL_FILE_BY_DEFAULT)
		);
		configureFromDslFileRadioButton.addSelectionListener(widgetSelectedAdapter(event -> {
			configureFromProjectPreferencesRadioButton.setSelection( ! configureFromDslFileRadioButton.getSelection());
			aleSourceFilesPathText.setEnabled( ! configureFromDslFileRadioButton.getSelection());
			ecoreModelsPathText.setEnabled( ! configureFromDslFileRadioButton.getSelection());
			
			dslFilePathText.setEnabled(configureFromDslFileRadioButton.getSelection());
		}));
		GridDataFactory.fillDefaults().span(numColumns, 1).applyTo(configureFromDslFileRadioButton);
		
		// .dsl file text field
		
		Label label = new Label(container, SWT.NONE);
		label.setText("DSL configuration file:");
		GridDataFactory.swtDefaults().indent(LayoutConstants.getIndent(), 0).applyTo(label);
		
		dslFilePathText = new Text(container, SWT.READ_ONLY | SWT.BORDER);
		dslFilePathText.setToolTipText("Path to the .dsl configuration file");
		dslFilePathText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		dslFilePathText.setText(preferences.get(DSL_FILE_PATH.property(), ""));
		dslFilePathText.setEnabled(configureFromDslFileRadioButton.getSelection());
		dslFilePathText.addListener(SWT.Modify, e -> {
			// Make sure the "Load DSL configuration file" button is checked
			configureFromDslFileRadioButton.setSelection(true);
			configureFromProjectPreferencesRadioButton.setSelection(false);
		});
		
		// "Browse Ecore models in workspace" button
		// Clicking the button opens a dialog that fills 'selectedEcoreModelText' text field
		
		Button browseDslFile = new Button(container, SWT.NONE);
		browseDslFile.setText("Select DSL file...");
		browseDslFile.setToolTipText("Opens a dialog to select a .dsl file within the workspace");
		browseDslFile.addSelectionListener(widgetSelectedAdapter(event -> {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			FilteredResourcesSelectionDialog dialog = new FilteredResourcesSelectionDialog(
					shell, 
					false,
					ResourcesPlugin.getWorkspace().getRoot(),
					IResource.FILE
			);
			dialog.setTitle("Select a DSL configuration file");
			dialog.setInitialPattern("*.dsl");
			try {
				// Buggy, never mind
//				dialog.setInitialElementSelections(relativeURIsToFiles(dslFilePathText.getText()));
			} 
			catch (RuntimeException e) {
				// no valid file selected
			}
			dialog.open();
			Object[] selected = dialog.getResult();

			if (selected != null && selected.length == 1 && selected[0] instanceof IResource) {
				IResource selectedModel = (IResource) selected[0];
				URI dslFileURI = createPlatformResourceURI(selectedModel.getFullPath().toPortableString(), true);
				dslFilePathText.setText(dslFileURI.toString());
			}
		}));
	}
    
	/**
	 * Creates a label embedding a clickable hyperlink.
	 * <p>
	 * Clicking on the link opens it in a web browser.
	 * 
	 * @param parent
	 * 			The parent of the label.
	 * @param text
	 * 			The content of the label.
	 * @param link
	 * 			The URL to the web page targeted by the link.
	 * @param linkStartIndex
	 * 			The index of the first character of the hyperlink.
	 * @param linkLength
	 * 			The length of the hyperlink.
	 * 
	 * @return a label embedding given link
	 */
    private static StyledText createLink(Composite parent, String text, String link, int linkStartIndex, int linkLength) {
    	StyledText styledText = new StyledText(parent, SWT.WRAP);
        styledText.setText(text);
        styledText.setBackground(parent.getBackground());

        StyleRange style = new StyleRange();
        style.underline = true;
        style.underlineStyle = SWT.UNDERLINE_LINK;
        style.start = linkStartIndex;
        style.length = linkLength;
        styledText.setStyleRange(style);
        
        styledText.addListener(SWT.MouseDown, event -> {
            int clickOffset = styledText.getCaretOffset();
            if (linkStartIndex <= clickOffset && clickOffset < linkStartIndex + linkLength) {
                // Open the documentation with external browser
                Program.launch(link);
            }
        });
        styledText.setBottomMargin(5);
        styledText.setToolTipText(link);
        return styledText;
    }
	
}
