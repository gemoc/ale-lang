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
package org.eclipse.emf.ecoretools.ale.core.delegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate.Factory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ALEEngine;
import org.eclipse.emf.ecoretools.ale.core.interpreter.DiagnosticLogger;
import org.eclipse.emf.ecoretools.ale.core.interpreter.EvalEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.ImmutableDslSemantics;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.DslSemantics;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

public class ALEInvocationDelegateFactory implements Factory {

	ALEEngine engine;
	private DslSemantics semantics;
	List<EPackage> scope;
	
	public ALEInvocationDelegateFactory() {
		
	}
	
	public ALEInvocationDelegateFactory(List<EPackage> scope) {
		this.scope = scope;
	}
	
	@Override
	public InvocationDelegate createInvocationDelegate(EOperation operation) {
		// This call to getEngine() ensures this.semantics is properly initialized
		ALEEngine engine = getEngine();
		
		Optional<Method> method = semantics.findMethod(operation);
		return new ALEInvocationDelegate(engine, method);
	}
	
	public ALEEngine getEngine() {
		if(engine == null) {
			IQueryEnvironment qryEnv = new ExtensionEnvironment();
			qryEnv.registerEPackage(EcorePackage.eINSTANCE);
	    	qryEnv.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(),
					EStringToStringMapEntryImpl.class);
	    	qryEnv.registerEPackage(ImplementationPackage.eINSTANCE);
	    	qryEnv.registerEPackage(AstPackage.eINSTANCE);
	    	
	    	List<EPackage> pkgs = getAllPackages();
	    	for (EPackage ePkg : pkgs) {
	    		qryEnv.registerEPackage(ePkg);
			}
			
			List<ParseResult<ModelUnit>> parsedSemantics = (new EAnnotationParser(qryEnv)).parse(pkgs);
			semantics = new ImmutableDslSemantics(parsedSemantics);
			DiagnosticLogger logger = new DiagnosticLogger(semantics);
			EvalEnvironment env = new EvalEnvironment(qryEnv, semantics.getBehaviors(), logger, null);
			engine = new ALEEngine(env);
		}
		return engine;
	}
	
	private List<EPackage> getAllPackages() {
		if(scope != null) {
			return scope;
		}
		else {
			List<EPackage> pkgs = new ArrayList<EPackage>();
	    	pkgs.addAll((Collection<? extends EPackage>) EPackageRegistryImpl.createGlobalRegistry().values());
	    	return pkgs;
		}
	}
}
