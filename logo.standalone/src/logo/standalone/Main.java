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
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.runtime.ServiceUtils;
import org.eclipse.ecoretools.ale.LangInterpreter;
import org.eclipse.ecoretools.ale.core.interpreter.DiagnosticLogger;
import org.eclipse.ecoretools.ale.core.interpreter.ImplementationEvaluator;
import org.eclipse.ecoretools.ale.core.parser.Dsl;
import org.eclipse.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;

import org.eclipse.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.ecoretools.ale.implementation.ModelBehavior;
import kmLogo.ASM.ASMPackage;
import kmLogo.ASM.LogoProgram;
import vmlogo.VmlogoPackage;

public class Main {
	
	public static void main(String[] args) {
		/*
		 * Input files
		 */
		String dslFile = "logo-standalone.dsl";
		String modelFile = "../logo.example/data/LogoProgram.xmi";
		
		/*
		 * Init eval environment
		 */
		LangInterpreter interpreter = new LangInterpreter();
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
		IEvaluationResult result = interpreter.eval(modelFile, new ArrayList(), new Dsl(dslFile));
	}
}
