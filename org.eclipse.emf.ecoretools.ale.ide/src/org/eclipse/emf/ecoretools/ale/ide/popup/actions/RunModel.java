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
package org.eclipse.emf.ecoretools.ale.ide.popup.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecoretools.ale.LangInterpreter;
import org.eclipse.emf.ecoretools.ale.ide.WorkbenchDsl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;

public class RunModel extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		Shell shell = HandlerUtil.getActiveWorkbenchWindow(event).getShell();
		
		/*
		 * Dsl file
		 */
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		IResource resource = (IResource) selection.getFirstElement();
		String dslProject = resource.getProject().getName();
		
		System.out.println("\nRun "+resource.getName());
		System.out.println("------------");
		
		/*
		 * Selected model
		 */
		ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(shell, ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
		dialog.setTitle("Resource Selection");
		dialog.open();
		Object[] selected = dialog.getResult();
		
		if(selected == null)
			return null;
		
		String modelLocation = ((File)selected[0]).getLocationURI().toString();
		String modelProject = ((File)selected[0]).getProject().getName();
		
		/*
		 * Init interpreter
		 */
		Set<String> projects = new HashSet<String>();
		Set<String> plugins = new HashSet<String>();
		projects.add(dslProject);
		projects.add(modelProject);
		LangInterpreter interpreter = new LangInterpreter();
		interpreter.javaExtensions.updateScope(plugins,projects);
		interpreter.javaExtensions.reloadIfNeeded();
		
		/*
		 * Eval
		 */
		Job evalJob = new Job("AQL Eval") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				
				Thread execThread = new Thread("Aql eval thread"){
					@Override
					public void run() {
						IEvaluationResult result = interpreter.eval(modelLocation, new ArrayList(), new WorkbenchDsl(resource.getLocationURI().getPath().toString()));
						interpreter.getLogger().diagnosticForHuman();
						this.stop();
					}
				};
				execThread.start();
				
				while(execThread.isAlive()){
					if(monitor.isCanceled()){
						execThread.stop();
						return Status.CANCEL_STATUS;
					}
					 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if(execThread.isAlive()){
					execThread.stop();
				}
				
				return Status.OK_STATUS;
			}
		};
		evalJob.schedule();
		
		return null;
	}
}
