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

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Objects.requireNonNull;
import static org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig.UiUtils.getDisplay;
import static org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig.UiUtils.getShell;

import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter.ClosedALEInterpreterException;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.DslSemantics;
import org.eclipse.emf.ecoretools.ale.ide.ui.Activator;
import org.eclipse.emf.ecoretools.ale.ide.ui.io.AleConsole;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.eclipse.swt.SWT;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import com.google.common.collect.Sets;

/**
 * An {@link Job Eclipse Job} that runs the {@link ALEInterpreter ALE Interpreter}
 * in background.
 */
public class AleEvaluationJob extends Job {
	/**
	 * The interpreter used to evaluate the model.
	 */
	private final ALEInterpreter interpreter;
	/**
	 * The element of the model on which the main method should be called.
	 */
	private final EObject caller;
	/**
	 * The method to call.
	 */
	private final Method main;
	/**
	 * The resource containing <code>this.caller</code>.
	 */
	private final IResource modelFile;
	/**
	 * The semantics of the model.
	 */
	private final DslSemantics semantics;
	
	/**
	 * Creates a new {@link Job Eclipse Job} that runs the {@link ALEInterpreter ALE Interpreter}
	 * in background.
	 * 
	 * @param interpreter
	 * 			The interpreter used to evaluate the model. Automatically closed at the end of the execution
	 * @param caller
	 * 			The element of the model on which the main method will be called
	 * @param main
	 * 			The method to call
	 * @param semantics
	 * 			The semantics of the model
	 * @param modelFile
	 * 			The resource containing {@code caller}
	 */
	public AleEvaluationJob(ALEInterpreter interpreter, EObject caller, Method main, DslSemantics semantics, IResource modelFile) {
		super("AQL Eval");
		
		this.interpreter = interpreter;
		this.caller = requireNonNull(caller, "caller");
		this.main = requireNonNull(main, "main");
		this.modelFile = requireNonNull(modelFile, "modelFile");
		this.semantics = requireNonNull(semantics, "semantics");
		
		setUser(true);
	}
	
	@Override
	protected IStatus run(IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
		
		subMonitor.split(5).setTaskName("Initializing");
		
//		String dslProject = dslFile.getProject().getName();
		String modelProject = modelFile.getProject().getName();

		/*
		 * Init interpreter
		 * 
		 * TODO Consider moving initialization in 'AQL Eval' run's body to reduce scope?
		 */
		Set<String> projects = Sets.newHashSet(modelProject);
		Set<String> plugins = emptySet();

		AleConsole console = AleConsole.current();
		console.activate();
		console.clearConsole();
		
		LocalTime startTime = LocalTime.now();
		updateConsoleName(console, "",  caller, main, startTime, null);
		
		PrintStream oldOut = System.out;
		PrintStream oldErr = System.err;
		MessageConsoleStream consoleStdout = console.newMessageStream();
		MessageConsoleStream consoleStderr = console.newMessageStream();
		try (
			PrintStream consoleStdoutStream = new PrintStream(consoleStdout);
			PrintStream consoleStderrStream = new PrintStream(consoleStderr);
		) {
			getDisplay().syncExec(() ->
				consoleStderr.setColor(getDisplay().getSystemColor(SWT.COLOR_RED))
			);
			
			System.setOut(consoleStdoutStream);
			System.setErr(consoleStderrStream);
			
			subMonitor.split(10).setTaskName("Building interpreter's environment");
			
			Thread execThread = new Thread("AQL Eval thread") {
				@Override
				public void run() {
					try {
						interpreter.javaExtensions.updateScope(plugins, projects);
						interpreter.javaExtensions.reloadIfNeeded();
						
						subMonitor.split(80).setTaskName("In progress...");
						
						IEvaluationResult result = interpreter.eval(caller, main, emptyList(), semantics);
						interpreter.getLogger().diagnosticForHuman();

						Diagnostic diagnostic = result.getDiagnostic();
						LocalTime endTime = LocalTime.now();
						String status = diagnostic.getSeverity() == Diagnostic.OK ? "<terminated> " : "<failed> ";
						
						updateConsoleName(console, status, caller, main, startTime, endTime);
					} 
					catch (ClosedALEInterpreterException e) {
						updateConsoleName(console, "<internal failure> ", caller, main, startTime, LocalTime.now());
						// Should never happen
						Activator.error("An internal error occurred while launching ALE", e);
						getDisplay().asyncExec(() -> 
							MessageDialog.openError(
									getShell(),
									"An internal error occurred",
									e.getMessage() + "\nPlease check the Error Log view for more details and report this " +
											"error at https://github.com/gemoc/ale-lang"
							)
						);
					}
					catch (Exception e) {
						updateConsoleName(console, "<internal failure> ", caller, main, startTime, LocalTime.now());
						Activator.error("An error occurred while executing ALE", e);
						getDisplay().asyncExec(() -> 
							MessageDialog.openError(
									getShell(),
									"An internal error occurred",
									e.getMessage() + "\nPlease check the Error Log view for more details and report this " +
											"error at https://github.com/gemoc/ale-lang"
							)
						);
					}
				}
			};
			execThread.start();

			while (execThread.isAlive()) {
				if (monitor.isCanceled()) {
					execThread.stop();
					return Status.CANCEL_STATUS;
				}
				try {
					Thread.sleep(1000);
				} 
				catch (InterruptedException e) {
					Thread.currentThread().interrupt();

					// Main thread has been interrupted: let's stop the evaluation and move on
					execThread.stop();
					return new Status(IStatus.CANCEL, Activator.PLUGIN_ID,
							"Execution thread has been interrupted", e);
				}
			}
			return Status.OK_STATUS;
		} 
		finally {
			subMonitor.split(5).setTaskName("Cleaning");
			
			// Ensure standard streams are always reset
			System.setOut(oldOut);
			System.setErr(oldErr);
			
			// Ensure resources held by the interpreter are freed
			interpreter.close();
		}
	}
	
	private void updateConsoleName(AleConsole console, String status, EObject caller, Method main, LocalTime startTime, LocalTime endTime) {
		String operation = caller.eClass().getName() + "::" + main.getOperationRef().getName();
		String kind = "[ALE Application]";
		String time = pretty(startTime) + " - " + (endTime == null ? "" : pretty(endTime));
		
		getDisplay().asyncExec(() -> 
			console.setName(status + operation + " " + kind + " (" + time + ")")
		);
	}

	/** @return the time, prettily formatted */
	private String pretty(LocalTime time) {
		return time.getHour() + ":" + time.getMinute() + ":" + time.getSecond();
	}

	static class MyConsole extends MessageConsole {
		
		MyConsole(String name, ImageDescriptor desc) {
			super(name, desc);
		}
		
		public void updateName(String newName) {
			this.setName(newName);
		}
		
	}
}
