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

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.DslSemantics;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

public class DiagnosticLogger {
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
			.stream()
			.forEach(
				diag -> {
					if(diag.getSource().equals(MethodEvaluator.PLUGIN_ID)){
						Expression failedExp = (Expression) diag.getData().get(0);
						Diagnostic diagExp = diag;
						
						// Check whether a more accurate diagnostic is available
						if(diag.getData().size() > 1) {
							diagExp = (Diagnostic) diag.getData().get(1);
						}
						printError(failedExp, diagExp.toString());
						if(diagExp instanceof BasicDiagnostic) {
							diagnosticForHuman((BasicDiagnostic) diagExp);
						}
					} else {
						if(!diag.getData().isEmpty() && diag.getData().get(0) instanceof Exception) {
							Exception e = (Exception) diag.getData().get(0);
							if(e.getCause() instanceof CriticalFailure) {
								CriticalFailure interpreterFailure = (CriticalFailure) e.getCause();
								diagnosticForHuman(interpreterFailure.diagnostics);
							} else if(e.getCause() != null){
								e.getCause().printStackTrace();
							}
						}
					}
				}
			);
	}
	
	private void printError(Expression expr, String errorMsg) {
		ParseResult<ModelUnit> parsedFile = semantics.findParsedFileDefining(expr).orElse(null);
		if (parsedFile == null) {
			System.err.println("\n[AQL eval fail] At unknown file and line (" + expr + ")");
			System.err.println(errorMsg);
		}
		else {
			// TODO [Refactor] Optional<Integer> start = parsedFile.getStartPositionOf(expr)
			Integer startPos = parsedFile.getStartPositions().get(expr);
			if(startPos != null) {
				String file = parsedFile.getSourceFile();
				int line =  getLine(startPos,file);
				System.err.println("\n[AQL eval fail] At line "+ line +" in " + file + ":\n" + errorMsg);
			}
		}
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
