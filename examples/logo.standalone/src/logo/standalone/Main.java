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
package logo.standalone;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter.ClosedALEInterpreterException;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;

public class Main {
	
	public static void main(String[] args) {
		/*
		 * Input files
		 */
		String dslFile = "logo-standalone.dsl";
		String modelFile = "../logo.example/data/LogoProgram.xmi";
		
		try (ALEInterpreter interpreter = new ALEInterpreter()) {
			/*
			 * Initialize evaluation environment
			 */
			ServiceUtils.registerServices(
					interpreter.getQueryEnvironment(),
					ServiceUtils.getServices(interpreter.getQueryEnvironment(),	Class.forName("logo.example.service.Display"))
			);
			
			/*
			 * Evaluate the program
			 */
			IEvaluationResult result = interpreter.eval(modelFile, new ArrayList<>(), new Dsl(dslFile));
			interpreter.getLogger().diagnosticForHuman();
		} 
		catch (ClassNotFoundException e) {
			System.err.println("Cannot execute ALE; the following class cannot be found: " + e.getMessage());
			System.err.println("Please make sure the logo.example project is in the classpath.\n");
			e.printStackTrace();
		} 
		catch (FileNotFoundException e) {
			System.err.println("Cannot execute ALE; the following file cannot be found: " + e.getMessage());
			System.err.println("Please make sure all the required files at the right location.\n");
			e.printStackTrace();
		} 
		catch (ClosedALEInterpreterException e) {
			// Should never happen
			System.err.println("Cannot execute ALE; the interpreter and its related resources have already been closed.\n");
			e.printStackTrace();
		}
		
		System.out.println("DONE");
	}
}
