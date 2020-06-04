/*******************************************************************************
 * Copyright (c) 2020 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.env.impl;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Set;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.IBehaviors;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleInterpreter;
import org.eclipse.emf.ecoretools.ale.core.interpreter.impl.AleInterpreter;
import org.eclipse.emf.ecoretools.ale.core.parser.BehaviorsParser;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

/**
 * An ALE environment that only requires it subclasses to provide source files.
 * <p>
 * This class is not supposed to be extended by clients. 
 */
public abstract class AbstractAleEnvironment implements IAleEnvironment {
	
	protected IQueryEnvironment context;
	
	protected IBehaviors behaviors;
	
	protected IAleInterpreter interpreter;
	
	@Override
	public List<EPackage> getMetamodels() {
		// FIXME [API] I think that EClass returned by this method are not usable
		//			   because those EPackages are not the ones registered in the
		//			   IQueryEnvironment by the AstBuilder.
		//				
		//			   This will become an issue if someone attempts to dynamically
		//			   create an EObject from those EPackages and gives it to the 
		//			   interpreter (as "caller" argument).
		//
		ResourceSet resources = new ResourceSetImpl();
		resources.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		return getMetamodelsSources().stream()
					.map(URI::createURI)
					.map(metamodelURI -> resources.getResource(metamodelURI, true))
					.flatMap(res -> res.getContents().stream())
					.filter(EPackage.class::isInstance)
					.map(EPackage.class::cast)
					.collect(toList());
	}
	
	@Override
	public IQueryEnvironment getContext() {
		if (context == null) {
			context = new ExtensionEnvironment();
	    	context.registerEPackage(EcorePackage.eINSTANCE);
	    	context.registerEPackage(ImplementationPackage.eINSTANCE);
	    	context.registerEPackage(AstPackage.eINSTANCE);
	    	context.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(), EStringToStringMapEntryImpl.class);
		}
    	return context;
	}
	
	@Override
	public IAleInterpreter getInterpreter() {
		if (interpreter == null) {
			interpreter = new AleInterpreter(this, getContext());
		}
		return interpreter;
	}
	
	@Override
	public IBehaviors getBehaviors() {
		// FIXME Should also use EAnnotationParser to extract behaviors from EAnnotations in #getMetamodels()
		if (behaviors == null) {
			BehaviorsParser parser = new BehaviorsParser(getContext());
			List<ParsedFile<ModelUnit>> ast = parser.parse(getMetamodels(), getBehaviorsSources());
			behaviors = new ImmutableBehaviors(ast);
		}
		return this.behaviors;
	}
	
	@Override
	public List<EObject> loadModel(URI modelURI) {
		return loadResource(modelURI).getContents();
	}
	
	@Override
	public Resource loadResource(URI modelURI) {
		ensureBehaviorsHaveBeenLoaded();
		
		// Make the resource set aware of available EPackage instances
		// We ask the context for the EPackages to make sure that:
		//		- both static and dynamic packages are taken into account
		//		- loaded EObjects will be properly resolved by the interpreter
		
		ResourceSet resources = new ResourceSetImpl();
    	resources.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
    	
    	getMetamodels().forEach(pkg -> resources.getPackageRegistry().put(pkg.getNsURI(), pkg));
    	
    	getContext().getEPackageProvider().getRegisteredEPackages().stream()
    				.forEach(pkg -> resources.getPackageRegistry().put(pkg.getNsURI(), pkg));
		
    	// Load the resource
    	
    	return resources.getResource(modelURI, true);
	}
	
	@Override
	public void close() {
		if (context != null) {
			// Free memory to prevent memory leaks
			Set<EPackage> registeredPackages = context.getEPackageProvider().getRegisteredEPackages();
			
			for (EPackage registeredPackage : registeredPackages) {
				context.removeEPackage(registeredPackage);
			}
			getInterpreter().close();
			
			this.context = null;
			this.behaviors = null;
			this.interpreter = null;
		}
	}

	/**
	 * Ensures that the IQueryEnvironment is properly initialized with all the EPackages
	 * loaded from the ALE source files.
	 * <p>
	 * Otherwise EClass may be duplicated in the environment, leading objects returned by
	 * {@link #loadModel(URI)} and {@link #loadResource(URI)} not to be properly resolved
	 * at runtime by the interpreter/validators.
	 */
	private void ensureBehaviorsHaveBeenLoaded() {
		getBehaviors();
	}

}
