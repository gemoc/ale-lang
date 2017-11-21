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
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;

public class Main {
	
	public static void main(String[] args) {
		/*
		 * Input files
		 */
		String dslFile = "logo-standalone.properties";
		String modelFile = "../logo.example/data/LogoProgram.xmi";
		
		/*
		 * Init eval environment
		 */
		ALEInterpreter interpreter = new ALEInterpreter();
		try {
			ServiceUtils.registerServices(
					interpreter.getQueryEnvironment(),
					ServiceUtils.getServices(interpreter.getQueryEnvironment(),	Class.forName("logo.example.service.Display"))
					);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		/*
		 * Eval
		 */
		try {
			IEvaluationResult result = interpreter.eval(modelFile, new ArrayList(), new Dsl(dslFile));
			interpreter.getLogger().diagnosticForHuman();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println("DONE");
	}
}
