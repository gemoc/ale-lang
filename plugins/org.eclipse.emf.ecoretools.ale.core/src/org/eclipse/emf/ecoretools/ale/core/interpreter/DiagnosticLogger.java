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
import static java.util.regex.Pattern.MULTILINE;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.DslSemantics;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

public class DiagnosticLogger {
	
	/**
	 * Matches AQL's error messages and returned the actual, wrapped error.
	 */
	private static final Pattern AQL_SERVICE_ERROR_PATTERN = Pattern.compile(".*with arguments \\[.*\\].* failed:(.*)", Pattern.DOTALL);
	
	List<Diagnostic> log = new ArrayList<>();
	private final DslSemantics semantics;
	
	public DiagnosticLogger(DslSemantics semantics) {
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
				diagnosticForHuman((BasicDiagnostic) diagnotic);
			}
		});
	}
	
	public void diagnosticForHuman( BasicDiagnostic diagnostic) {
		diagnostic
			.getChildren()
			.forEach(
				diag -> {
					// We only want to display our own errors
					if (diag.getSource().equals(MethodEvaluator.PLUGIN_ID)) {
						Expression failedExp = (Expression) diag.getData().get(0);
						Diagnostic diagExp = diag;
						
						// Check whether a more accurate diagnostic is available
						if(diag.getData().size() > 1) {
							diagExp = (Diagnostic) diag.getData().get(1);
						}
						printError(failedExp, diagExp);
						if(diagExp instanceof BasicDiagnostic) {
							diagnosticForHuman((BasicDiagnostic) diagExp);
						}
					}
					
					// TODO Consider removing the code below
					//		I comment it because it exposes internal and irrelevant errors
					//		to the user. However, it may be useful for debugging purposes
					//		and I prefer to comment it out: it will be easier to find it.
					
//					else {
//						if(!diag.getData().isEmpty() && diag.getData().get(0) instanceof Exception) {
//							Exception e = (Exception) diag.getData().get(0);
//							if(e.getCause() instanceof CriticalFailure) {
//								CriticalFailure interpreterFailure = (CriticalFailure) e.getCause();
//								diagnosticForHuman(interpreterFailure.diagnostics);
//							} else if(e.getCause() != null){
//								e.getCause().printStackTrace();
//							}
//						}
//					}
				}
			);
	}
	
	private void printError(Expression expr, Diagnostic diagnostic) {
		ParseResult<ModelUnit> parsedFile = semantics.findParsedFileDefining(expr).orElse(null);
		if (parsedFile == null) {
			System.err.println("\nAt unknown file and line (" + expr + "):\n");
			Stream.concat(Stream.of(diagnostic), diagnostic.getChildren().stream())
				  .map(Diagnostic::getMessage)
				  .map(getActualError())
				  .filter(msg -> msg != null && !msg.trim().isEmpty())
				  .forEach(message -> System.err.println("    " + message));
		}
		else {
			// TODO [Refactor] Optional<Integer> start = parsedFile.getStartPositionOf(expr)
			Integer startPos = parsedFile.getStartPositions().get(expr);
			if(startPos != null) {
				String file = parsedFile.getSourceFile();
				int line =  getLine(startPos,file);
				System.err.println("\nAt line "+ line +" in " + file + ":");
				Stream.concat(Stream.of(diagnostic), diagnostic.getChildren().stream())
					  .map(Diagnostic::getMessage)
					  .filter(msg -> msg != null && !msg.trim().isEmpty())
					  .map(getActualError())
					  .forEach(message -> System.err.println("    " + message));
			}
		}
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
