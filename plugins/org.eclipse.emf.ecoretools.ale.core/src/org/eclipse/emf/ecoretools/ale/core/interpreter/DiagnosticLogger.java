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
package org.eclipse.emf.ecoretools.ale.core.interpreter;

import static java.util.Objects.requireNonNull;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecoretools.ale.core.Activator;
import org.eclipse.emf.ecoretools.ale.core.env.IBehaviors;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.MethodEvaluator;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

public class DiagnosticLogger {
	
	/**
	 * Matches AQL's error messages and returned the actual, wrapped error.
	 */
	private static final Pattern AQL_SERVICE_ERROR_PATTERN = Pattern.compile(".*with arguments \\[.*\\].* failed:(.*)", Pattern.DOTALL);
	
	List<Diagnostic> log = new ArrayList<>();
	private final IBehaviors semantics;
	
	public DiagnosticLogger(IBehaviors semantics) {
		this.semantics = requireNonNull(semantics, "semantics");
	}
	
	public void notify(Diagnostic diag) {
		log.add(diag);
	}
	
	public List<Diagnostic> getLog() {
		return log;
	}
	
	public void diagnosticForHuman() {
		log
		.stream()
		.forEach(diagnotic -> {
			if(diagnotic instanceof BasicDiagnostic){
				diagnosticForHuman((BasicDiagnostic) diagnotic, new LinkedList<>());
			}
		});
	}
	
	public void diagnosticForHuman(BasicDiagnostic diagnostic, LinkedList<String> stacktrace) {
		diagnostic
			.getChildren()
			.forEach(
				diag -> {
					// We only want to display our own errors
					if (diag.getSource().equals(Activator.PLUGIN_ID)) {
						Object failedExp = diag.getData().get(0);
						Diagnostic diagExp = diag;
						
						// Check whether a more accurate diagnostic is available
						if(diag.getData().size() > 1) {
							diagExp = (Diagnostic) diag.getData().get(1);
						}
						printError(failedExp, diagExp, stacktrace);
						if(diagExp instanceof BasicDiagnostic) {
							diagnosticForHuman((BasicDiagnostic) diagExp, stacktrace);
						}
					}
					else {
						if(!diag.getData().isEmpty() && diag.getData().get(0) instanceof Exception) {
							Exception e = (Exception) diag.getData().get(0);
							if(e.getCause() instanceof CriticalFailureException) {
								CriticalFailureException interpreterFailure = (CriticalFailureException) e.getCause();
								diagnosticForHuman(interpreterFailure.getDiagnostic(), stacktrace);
							}
						}
					}
				}
			);
	}
	
	private void printError(Object expr, Diagnostic diagnostic, LinkedList<String> stacktrace) {
		ParsedFile<ModelUnit> parsedFile = semantics.findParsedFileDefining(expr).orElse(null);
		if (parsedFile == null) {
			stacktrace.addFirst("At unknown file and line (" + expr + "):");
			Stream.concat(Stream.of(diagnostic), diagnostic.getChildren().stream())
				  .map(Diagnostic::getMessage)
				  .map(getActualError())
				  .filter(msg -> msg != null && !msg.trim().isEmpty())
				  .forEach(message -> {
					  System.err.println(message);
					  unfold(stacktrace);
				  });
		}
		else {
			// TODO [Refactor] Optional<Integer> start = parsedFile.getStartPositionOf(expr)
			Integer startPos = parsedFile.getStartPositions().get(expr);
			if(startPos != null) {
				String file = parsedFile.getSourceFile();
				String filePath = file;
				
				IContainer[] ifiles = ResourcesPlugin.getWorkspace().getRoot().findContainersForLocationURI(new File(file).toURI());
				if (ifiles.length > 0) {
					filePath = ifiles[0].getFullPath().makeRelative().toString();
				}
				filePath = filePath.replace('\\', '/');
				int line =  getLine(startPos,file);
				stacktrace.addFirst("At " + filePath + ":" + line);
				Stream.concat(Stream.of(diagnostic), diagnostic.getChildren().stream())
					  .map(Diagnostic::getMessage)
					  .filter(msg -> msg != null && !msg.trim().isEmpty())
					  .map(getActualError())
					  .filter(msg -> !MethodEvaluator.ROOT_ERROR_MESSAGE.equals(msg))
					  .forEach(message -> {
						  System.err.println(message);
						  unfold(stacktrace);
					  });
			}
		}
	}
	
	private static void unfold(List<String> stacktrace) {
		System.err.println();
		for (String trace : stacktrace) {
			System.err.println("  " + trace);
		}
		stacktrace.clear();
	}
	
	/**
	 * Returns the wrapped error message or the message itself if it's not wrapped.
	 * <p>
	 * Required because AQL catch exceptions thrown by services and directly modifies
	 * their (so, our) error message. 
	 */
	private Function<String, String> getActualError() {
		return message -> {
			Matcher matcher = AQL_SERVICE_ERROR_PATTERN.matcher(message);
			
			if (matcher.matches()) {
				return matcher.group(1).trim();
			}
			else {
				return message;
			}
		};
	}
	
	private int getLine(int offset, String file) {
		try (LineNumberReader r = new LineNumberReader(new FileReader(file))) {
			r.setLineNumber(1); //first line is number 0 by default
		    int count = 0;
		    while (r.read() != -1 && count < offset) {
		        count++;
		    }
		    if (count == offset) {
		        return r.getLineNumber();
		    } else {
		    	// FIXME Should throw
		        System.out.println("File is not long enough");
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
