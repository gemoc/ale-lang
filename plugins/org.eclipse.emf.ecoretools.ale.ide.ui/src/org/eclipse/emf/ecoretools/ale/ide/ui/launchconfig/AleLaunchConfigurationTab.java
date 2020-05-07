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

import static org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig.AleLaunchConfiguration.DSL_FILE;
import static org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig.AleLaunchConfiguration.MAIN_METHOD;
import static org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig.AleLaunchConfiguration.MAIN_MODEL_ELEMENT;
import static org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig.AleLaunchConfiguration.MODEL_FILE;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.impl.DslConfiguration;
import org.eclipse.emf.ecoretools.ale.core.interpreter.impl.AleInterpreter;
import org.eclipse.emf.ecoretools.ale.ide.ui.Activator;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.BaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;

public class AleLaunchConfigurationTab extends AbstractLaunchConfigurationTab {

	/**
	 * Displays the path to the selected .dsl file.
	 */
	private Text dslSelection;
	/**
	 * Displays the path to the .xmi file.
	 */
	private Text modelSelection;
	/**
	 * Displays the name of the main method to call.
	 */
	private Text mainMethodSelection;
	/**
	 * Displays the element of the XMI file on which the main method should be called.
	 */
	private Text mainModelElementSelection;
	/**
	 * Used to load the program and find the main methods. 
	 */
	private AleInterpreter interpreter;
	
	@Override
	public void createControl(Composite parent) {
		Composite area = new Composite(parent, SWT.NULL);
		GridLayout gl = new GridLayout(1, false);
		gl.marginHeight = 0;
		area.setLayout(gl);
		area.layout();
		setControl(area);

		Group dslArea = createGroup(area, "Language");
		createDslWidgets(dslArea);

		Group modelArea = createGroup(area, "Model");
		createModelWidgets(modelArea);

		Group executionArea = createGroup(area, "Execution");
		createExecutionWidgets(executionArea);
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(DSL_FILE, "");
		configuration.setAttribute(MODEL_FILE, "");
		configuration.setAttribute(MAIN_METHOD, "");
		configuration.setAttribute(MAIN_MODEL_ELEMENT, "");
		try {
			configuration.doSave();
		} catch (CoreException e) {
			Activator.error("Unable to init ALE launch configuration with default values", e);
		}
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		try {
			dslSelection.setText(configuration.getAttribute(DSL_FILE, ""));
			modelSelection.setText(configuration.getAttribute(MODEL_FILE, ""));
			mainMethodSelection.setText(configuration.getAttribute(MAIN_METHOD, ""));
			mainModelElementSelection.setText(configuration.getAttribute(MAIN_MODEL_ELEMENT, ""));
		} catch (CoreException e) {
			Activator.error("Unable to init ALE launch configuration from " + configuration, e);
		}
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		configuration.setAttribute(DSL_FILE, dslSelection.getText().trim());
		configuration.setAttribute(MODEL_FILE, modelSelection.getText().trim());
		configuration.setAttribute(MAIN_METHOD, mainMethodSelection.getText().trim());
		configuration.setAttribute(MAIN_MODEL_ELEMENT, mainModelElementSelection.getText().trim());
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

	@Override
	public void dispose() {
		if (interpreter != null) {
			interpreter.close();
		}
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
		Label modelSelectionLabel = new Label(parent, SWT.NONE);
		modelSelectionLabel.setText("Model to execute");
		
		modelSelection = new Text(parent, SWT.SINGLE | SWT.BORDER);
		modelSelection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		modelSelection.addModifyListener(modifyEvent ->
				updateLaunchConfigurationDialog()
		);
		
		Button modelLocationButton = createPushButton(parent, "Browse", null);
		modelLocationButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(event -> {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(shell, ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
			dialog.setTitle("Model Selection");
			if (dialog.open() == Window.OK) {
				Object[] selected = dialog.getResult();
				modelSelection.setText(((IResource)selected[0]).getFullPath().toPortableString());
			}
		}));
	}
	
	private void createDslWidgets(Composite parent) {
		Label modelSelectionLabel = new Label(parent, SWT.NONE);
		modelSelectionLabel.setText("Configuration");
		
		dslSelection = new Text(parent, SWT.SINGLE | SWT.BORDER);
		dslSelection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dslSelection.addModifyListener(modifyEvent ->
				updateLaunchConfigurationDialog()
		);
		
		Button dslLocationButton = createPushButton(parent, "Browse", null);
		dslLocationButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(event -> {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(shell, ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
			dialog.setTitle("DSL Selection");
			if (dialog.open() == Window.OK) {
				Object[] selected = dialog.getResult();
				dslSelection.setText(((IResource)selected[0]).getFullPath().toPortableString());
			}
		}));
	}
	
	private void createExecutionWidgets(Composite parent) {
		Label mainMethodSelectionLabel = new Label(parent, SWT.NONE);
		mainMethodSelectionLabel.setText("Main method");
		
		mainMethodSelection = new Text(parent, SWT.SINGLE | SWT.BORDER);
		mainMethodSelection.setEditable(false);
		mainMethodSelection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		mainMethodSelection.addModifyListener(modifyEvent ->
			updateLaunchConfigurationDialog()
		);
		Button mainMethodSelectionButton = createPushButton(parent, "Browse", null);
		mainMethodSelectionButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(event -> {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			try {
				Optional<Method> selectedMain = askUserToSelectMainMethod(shell, getAvailableMethods());
				selectedMain.ifPresent(main -> {
					mainMethodSelection.setText(new MethodLabelProvider().getText(main));
				});
			} 
			catch (IOException | CoreException e) {
				MessageDialog.openError(shell, "Unable to find @main methods", "File not found in workspace: " + e.getMessage());
				Activator.error("Unable to find @main methods", e);
			}
		}));
		
		Label mainModelElementSelectionLabel = new Label(parent, SWT.NONE);
		mainModelElementSelectionLabel.setText("Main model element path");
		
		mainModelElementSelection = new Text(parent, SWT.SINGLE | SWT.BORDER);
		mainModelElementSelection.setEditable(false);
		mainModelElementSelection.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		mainModelElementSelection.addModifyListener(modifyEvent ->
			updateLaunchConfigurationDialog()
		);
		
		Button mainModelElementSelectionButton = createPushButton(parent, "Browse", null);
		mainModelElementSelectionButton.addSelectionListener(SelectionListener.widgetSelectedAdapter(event -> {
			try {
				IFile resourceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(modelSelection.getText()));
				if (! resourceFile.exists()) {
					MessageDialog.openInformation(parent.getShell(), "Model not selected", "You must select a model first.");
					return;
				}
				final ResourceSet resources = new ResourceSetImpl();
				resources.getResource(URI.createPlatformResourceURI(modelSelection.getText(), true), true);
				Optional<EObject> mainModelElement = askUserToChooseMainModelElement(parent.getShell(), resources);
				mainModelElement.ifPresent(mainElement -> {
					String resourceRelativeURI = mainElement.eResource().getURIFragment(mainElement);
					mainModelElementSelection.setText(resourceRelativeURI);
				});
			}
			catch (Exception e) {
				MessageDialog.openError(
						parent.getShell(),
						"Cannot select the model element to execute", 
						"Please check that the model to execute is a valid XMI model. See more details in the Log Error view"
				);
			}
		}));
	}
	
	/**
	 * Opens a dialog letting the user select an {@link EObject}.
	 * 
	 * @param shell
	 *            The {@link Shell} to use for display
	 * @param resourceSet
	 *            The {@link ResourceSet} to get the element from
	 *            
	 * @return the selected first instruction {@link URI} if any selected, <code>null</code> otherwise
	 */
	private static Optional<EObject> askUserToChooseMainModelElement(final Shell shell, ResourceSet resourceSet) {
		final ComposedAdapterFactory fatory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		try {
			fatory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			fatory.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
	
			ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
					shell,
					new AdapterFactoryLabelProvider(fatory), 
					new AdapterFactoryContentProvider(fatory)
			);
			dialog.setTitle("Select the main model element");
			dialog.setMessage("Select the element on which the @main method will be called:");
			dialog.setAllowMultiple(false);
			dialog.setValidator(new AcceptModelElementsOnly());
			dialog.setInput(resourceSet);
			if (dialog.open() == Window.OK) {
				EObject selection = (EObject) dialog.getFirstResult();
				return Optional.of(selection);
			} else {
				return Optional.empty();
			}
		} 
		finally {
			fatory.dispose();
		}
	}
	
	/**
	 * A validator that ignores EPackages, EClass, etc. to only accept elements that are part
	 * of the XMI model. 
	 */
	private static class AcceptModelElementsOnly implements ISelectionStatusValidator {

		@Override
		public IStatus validate(Object[] selection) {
			if (selection.length == 0) {
				return Status.CANCEL_STATUS;
			}
			Object selected = selection[0];
			boolean isAModelElementSelected = selected instanceof DynamicEObjectImpl;
			return isAModelElementSelected ? Status.OK_STATUS : Status.CANCEL_STATUS;
		}
		
	}
	
	private final List<Method> getAvailableMethods() throws CoreException, IOException {
		IFile dslFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(dslSelection.getText()));
		try (IAleEnvironment dsl = IAleEnvironment.fromDslFile(dslFile)) {
			return dsl.getBehaviors().getMainMethods();
		}
	}
	
	/**
	 * Opens a dialog letting the user select an {@link EObject}.
	 * 
	 * @param shell
	 *            The {@link Shell} to use for display
	 * @param resourceSet
	 *            The {@link ResourceSet} to get the element from
	 *            
	 * @return the selected first instruction {@link URI} if any selected, <code>null</code> otherwise
	 */
	private static Optional<Method> askUserToSelectMainMethod(final Shell shell, List<Method> methods) {
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, new MethodLabelProvider());
		dialog.setElements(methods.toArray());
		dialog.setTitle("Select the @main method to call");
		dialog.setMessage("Select method to use as the program's entry point:");

		if (dialog.open() == Window.OK) {
			Method selection = (Method) dialog.getFirstResult();
			return Optional.of(selection);
		} else {
			return Optional.empty();
		}
	}
	
	/** Provides labels for {@link Method} instances. */
	private static class MethodLabelProvider extends BaseLabelProvider implements ILabelProvider {

		@Override
		public Image getImage(Object element) {
			return null;
		}

		@Override
		public String getText(Object element) {
			Method method = (Method) element;
			return MethodRepresentation.of(method, null)
									   .toString();
		}
		
	}
	
}
