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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecoretools.ale.ide.ui.Activator;
import org.eclipse.emf.ecoretools.ale.ide.ui.project.WorkspaceAleProject;
import org.eclipse.emf.ecoretools.ale.ide.ui.project.WorkspaceAleProject.Template;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

/**
 * A wizard used to create new ALE projects.
 */
public class NewAleProjectWizard extends Wizard implements INewWizard {
	/** 
	 * Used to choose the name and the location of the project 
	 */
	private WizardNewProjectCreationPage newProjectPage;
	/** 
	 * Used to choose the Ecore model file to use 
	 */
	private NewAleProjectConfigurationWizardPage aleConfigurationPage;

	/**
	 * Instantiates a wizard used to create new ALE projects. 
	 */
	public NewAleProjectWizard() {
		super();
		setNeedsProgressMonitor(true);
		setWindowTitle("ALE Project Wizard");
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// nothing to initialize
	}
	
	@Override
	public void addPages() {
		super.addPages();
		
		newProjectPage = new WizardNewProjectCreationPage("ALE Project");
		newProjectPage.setTitle("New ALE Project");
		newProjectPage.setDescription("Create a new ALE project.");
		
		aleConfigurationPage = new NewAleProjectConfigurationWizardPage();
		
		addPage(newProjectPage);
		addPage(aleConfigurationPage);
	}
	
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		if (page == newProjectPage) {
			aleConfigurationPage.setDefaultEcorePackage(newProjectPage.getProjectName());
		}
		return super.getNextPage(page);
	}

	@Override
	public boolean canFinish() {
		return ! newProjectPage.getProjectName().isEmpty()
			&& ! newProjectPage.getLocationPath().isEmpty()
			&& aleConfigurationPage.isPageComplete();
	}
	
	@Override
	public boolean performFinish() {
		try {
	    	// Gather all the data required to create the project.
			// Must be retrieved out of the IRunnable to prevent invalid thread accesses
			
	    	String projectName = newProjectPage.getProjectName();
	    	boolean defaultProjectLocation = newProjectPage.useDefaults();
	    	IPath projectLocation;
	    	
	    	if (defaultProjectLocation) {
	    		projectLocation = newProjectPage.getLocationPath().append(projectName);
	    	}
	    	else {
	    		projectLocation = newProjectPage.getLocationPath();
	    	}
	    	boolean useAnExistingEcoreModel = aleConfigurationPage.useExistingEcoreModel();
	    	IPath ecoreModelFilePath = aleConfigurationPage.getEcoreModelFile();
	    	boolean createRepresentation = aleConfigurationPage.createRepresentation();
	    	boolean activateJava = aleConfigurationPage.activateJava();
	    	boolean createDslFile = aleConfigurationPage.createDslFile();
	    	String ecorePackageName = (aleConfigurationPage.getEcorePackageName() == null) ? projectName : aleConfigurationPage.getEcorePackageName();
	    	
	    	// Create the new project

			getContainer().run(true, false, new IRunnableWithProgress() {	
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
					try {
						WorkspaceAleProject.Description desc = 
								new WorkspaceAleProject.Description(useAnExistingEcoreModel, ecoreModelFilePath, ecorePackageName, createRepresentation, activateJava, createDslFile);
						Template project = new WorkspaceAleProject.Template(ResourcesPlugin.getWorkspace(), desc);
						project.create(projectName, projectLocation, monitor);
					} 
					catch (Exception e) {
			            throw new InvocationTargetException(e, "An error occurred while creating the new ALE project " + projectName);
					}
				}
			});
			return true;
		} 
	    catch (InvocationTargetException | InterruptedException e) {
	    	if (e instanceof InterruptedException) {
	    		Thread.currentThread().interrupt();
	    	}
	    	Activator.error("An error occurred while creating the new ALE project", e);
	    	showErrorDialog(e, "Project creation failed", e.getMessage());
		}
	    return false;
	}
	
	/**
	 * Shows an error dialog displaying an exception's stack trace.
	 * 
	 * @param e
	 * 			The exception to show.
	 * @param title
	 * 			The title of the dialog.
	 * @param message
	 * 			The message of the dialog.
	 */
	private void showErrorDialog(Exception e, String title, String message) {
		// Compute a String containing the whole stack trace
		StringWriter sw = new StringWriter();
	    PrintWriter pw = new PrintWriter(sw);
	    e.printStackTrace(pw);

	    String trace = sw.toString();

	    List<Status> childStatuses = new ArrayList<>();

	    for (String line : trace.split(System.getProperty("line.separator"))) {
	        childStatuses.add(new Status(IStatus.ERROR, Activator.PLUGIN_ID, line));
	    }

	    // Create a status owning the String stack trace
        MultiStatus status = new MultiStatus(
        		Activator.PLUGIN_ID, IStatus.ERROR, 
                childStatuses.toArray(new Status[] {}),
                e.toString(), e
        );
        ErrorDialog.openError(getShell(), title, message, status);
    }

}
