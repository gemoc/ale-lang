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
package org.eclipse.emf.ecoretools.ale.ide.launchconfig;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.IJobChangeListener;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.ide.debug.AleDebugTarget;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

public class AleLaunchConfigurationDelegate implements ILaunchConfigurationDelegate {
	
	public static final String DSL_FILE = "DSL_FILE";
	public static final String MODEL_FILE = "MODEL_FILE";

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		
		String dslLocation = configuration.getAttribute(DSL_FILE, "");
		String modelLocation = configuration.getAttribute(MODEL_FILE, "");
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IResource dslFile = workspace.getRoot().findMember(dslLocation);
		IResource modelFile = workspace.getRoot().findMember(modelLocation);
		
		ALEInterpreter interpreter = RunModelAction.createInterpreter(dslFile,modelFile,new ArrayList<>(),new ArrayList<>());
		List<ParseResult<ModelUnit>> parsedSemantics = RunModelAction.loadSemantics(interpreter, dslFile);
		EObject caller = RunModelAction.loadCaller(interpreter, modelFile);
		
		Job evalJob = RunModelAction.createEvalJob(dslFile.getName(),interpreter,caller,parsedSemantics);
		
		if (ILaunchManager.DEBUG_MODE.equals(mode)) {
			AleDebugTarget target = new AleDebugTarget(launch,evalJob,parsedSemantics, interpreter);
	        launch.addDebugTarget(target);
	        interpreter.addServiceListener(target.getDebugger());
	        interpreter.addStatementListener(target.getDebugger());
	        evalJob.addJobChangeListener(new IJobChangeListener() {
				@Override
				public void sleeping(IJobChangeEvent event) {}
				@Override
				public void scheduled(IJobChangeEvent event) {}
				@Override
				public void running(IJobChangeEvent event) {}
				@Override
				public void done(IJobChangeEvent event) {
					IStatus result = event.getResult();
					if(result != null) {
						if( result.getSeverity() == IStatus.OK || result.getSeverity() == IStatus.CANCEL || result.getSeverity() == IStatus.ERROR) {
							try {
								target.terminate();
							} catch (DebugException e) {
								e.printStackTrace();
							}
						}
					}
				}
				@Override
				public void awake(IJobChangeEvent event) {}
				@Override
				public void aboutToRun(IJobChangeEvent event) {}
			});
	    }
		
		evalJob.schedule();
	}
}
