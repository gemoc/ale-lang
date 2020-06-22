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

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.env.ClosedAleEnvironmentException;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.IBehaviors;
import org.eclipse.emf.ecoretools.ale.core.env.impl.FileBasedAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleInterpreter;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.sirius.common.tools.api.interpreter.IEvaluationResult;

public class Main {
	
	public static void main(String[] args) throws IOException {
		/*
		 * Input files
		 */
		File dslFile = new File("logo-standalone.dsl");
		String modelFile = "../logo.example/data/LogoProgram.xmi";
		
		try (FileBasedAleEnvironment environment = IAleEnvironment.fromFile(dslFile)) {
			/*
			 * Initialize evaluation environment
			 */
			ServiceUtils.registerServices(
					environment.getContext(),
					ServiceUtils.getServices(environment.getContext(), Class.forName("logo.example.service.Display"))
			);
			
			/*
			 * Load the model and its semantics
			 */
			IBehaviors semantics = environment.getBehaviors();
			Method main = semantics.getMainMethods().get(0);

			EObject caller = environment.loadModel(URI.createURI(modelFile)).get(0);
			
			/*
			 * Evaluate the program
			 */
			IAleInterpreter interpreter = environment.getInterpreter();
			IEvaluationResult result = interpreter.eval(caller, main, new ArrayList<>());
			
			System.out.println("eval => " + result.getValue());
			
			interpreter.getLogger().diagnosticForHuman();
		} 
		catch (ClassNotFoundException e) {
			System.err.println("Cannot execute ALE; the following class cannot be found: " + e.getMessage());
			System.err.println("Please make sure the logo.example project is in the classpath.\n");
			e.printStackTrace();
		} 
		catch (ClosedAleEnvironmentException e) {
			// Should never happen
			System.err.println("Cannot execute ALE; the interpreter and its related resources have already been closed.\n");
			e.printStackTrace();
		}
		System.out.println("DONE");
	}
}
