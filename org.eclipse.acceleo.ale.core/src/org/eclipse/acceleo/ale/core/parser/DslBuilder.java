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
package org.eclipse.acceleo.ale.core.parser;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.acceleo.ale.core.parser.visitor.ParseResult;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.acceleo.ale.implementation.ModelBehavior;

public class DslBuilder {
	
	IQueryEnvironment queryEnvironment;
	
	public DslBuilder(IQueryEnvironment qryEnv) {
		this.queryEnvironment = qryEnv;
	}

	/**
     * Setup the eval environment & parse semantic files
     */
    public List<ParseResult<ModelBehavior>> parse(Dsl dsl) { //TODO: add an option to clear services & epackages before
    	/*
    	 * Register EPackages
    	 */
    	ResourceSet rs = new ResourceSetImpl();
    	rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
    	dsl.getAllSyntaxes()
    		.stream()
    		.forEach(syntaxURI -> {
    			List<EPackage> pkgImports = load(syntaxURI, rs);
    			pkgImports
	    			.stream()
	    			.forEach(pkg -> {
	    				//Register if not already there
	    				Collection<EPackage> matchingPkgs = queryEnvironment.getEPackageProvider().getEPackage(pkg.getName());
	    				Optional<EPackage> existingPkg = matchingPkgs.stream().filter(p -> p.getNsURI().equals(pkg.getNsURI())).findFirst();
	    				if(!existingPkg.isPresent()){
	    					queryEnvironment.registerEPackage(pkg);
	    				}
	    			});
    		});
    	
    	/*
    	 * Parse behavior files
    	 */
    	List<ParseResult<ModelBehavior>> parsedSemantics =
    			(new AstBuilder(queryEnvironment)).parseFromFiles(dsl.getAllSemantics());
    	
    	return parsedSemantics;
    }
	
    private List<EPackage> load(String ecoreURI, ResourceSet rs) {
    	URI uri = URI.createURI(ecoreURI);
    	Resource res  = rs.getResource(uri, true);
    	
    	return 
    		res
	    	.getContents()
	    	.stream()
	    	.filter(o -> o instanceof EPackage)
	    	.map(o -> (EPackage) o)
	    	.collect(Collectors.toList());
    }
}
