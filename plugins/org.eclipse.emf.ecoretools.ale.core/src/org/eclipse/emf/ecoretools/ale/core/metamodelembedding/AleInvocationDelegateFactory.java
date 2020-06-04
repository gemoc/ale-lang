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
package org.eclipse.emf.ecoretools.ale.core.metamodelembedding;

import static java.util.stream.Collectors.toList;

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
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

/**
 * Used by EMF to execute an EOperation which body is defined in ALE through an EAnnotation.
 * <p>
 * More specifically, this factory is used when:
 * <ul>
 * 	<li>an EOperation is {@link EObject #eInvoke(EOperation, org.eclipse.emf.common.util.EList) dynamically invoked}
 * 	<li>this EOperation holds an EAnnotation which source is {@link ImplementationPackage#getNsURI()}
 * </ul>
 */
public class AleInvocationDelegateFactory implements Factory {

	private IAleEnvironment environment;
	private List<EPackage> scope;
	
	public AleInvocationDelegateFactory() {
		// Ensure EMF can instantiate the factory
	}
	
	public AleInvocationDelegateFactory(List<EPackage> scope) {
		this.scope = scope;
	}
	
	@Override
	public InvocationDelegate createInvocationDelegate(EOperation operation) {
		Optional<Method> method = getEnvironment().getBehaviors().findMethod(operation);
		return new AleInvocationDelegate(getEnvironment(), method.orElse(null));
	}
	
	private IAleEnvironment getEnvironment() {
		if(environment == null) {
			IQueryEnvironment context = new ExtensionEnvironment();
			context.registerEPackage(EcorePackage.eINSTANCE);
	    	context.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(),
					EStringToStringMapEntryImpl.class);
	    	context.registerEPackage(ImplementationPackage.eINSTANCE);
	    	context.registerEPackage(AstPackage.eINSTANCE);
	    	
	    	List<EPackage> packages = getAllPackages();
	    	packages.forEach(context::registerEPackage);
			
			List<ParsedFile<ModelUnit>> parsedBehaviors = new EAnnotationParser(context).parse(packages);
			environment = IAleEnvironment.fromRaw(context, packages, parsedBehaviors);
		}
		return environment;
	}
	
	private List<EPackage> getAllPackages() {
		if(scope != null) {
			return scope;
		}
		else {
			return EPackageRegistryImpl.createGlobalRegistry()
									   .values().stream()
									   .filter(EPackage.class::isInstance)
									   .map(EPackage.class::cast)
									   .collect(toList());
		}
	}
}
