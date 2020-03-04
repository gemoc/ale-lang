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
package org.eclipse.emf.ecoretools.ale.core.parser;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ModelBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.osgi.framework.Bundle;

public class DslBuilder {
	
	IQueryEnvironment queryEnvironment;
	ResourceSet rs;
	
	public DslBuilder(IQueryEnvironment qryEnv) {
		this.queryEnvironment = qryEnv;
		this.rs = new ResourceSetImpl();
	}
	
	public DslBuilder(IQueryEnvironment qryEnv, ResourceSet rs) {
		this.queryEnvironment = qryEnv;
		this.rs = rs;
	}

	/**
     * Setups the eval environment & parse semantic files.
     * <p>
     * Dynamically loads the ECore metamodels specified in {@link Dsl#getAllSemantics() dsl' semantics}.
     */
    public List<ParseResult<ModelUnit>> parse(IAleEnvironment env) { //TODO: add an option to clear services & epackages before
    	
    	cleanUp();
    	
    	/*
    	 * Register EPackages
    	 */
    	rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
    	env.getMetamodels()
    		.stream()
    		.forEach(syntaxURI -> {
    			List<EPackage> pkgImports = load(syntaxURI, rs);
    			List<EPackage> toRegister = new ArrayList<>();
    			for(EPackage pkg : pkgImports) {
    				EPackage registryPkg = rs.getPackageRegistry().getEPackage(pkg.getNsURI());
    				
    				//Give priority to EPackages from the registry
    				if(registryPkg == null) {
    					toRegister.add(pkg);
    				}
    				else {
    					toRegister.add(registryPkg);
    				}
    			}
    			register(toRegister);
    		});
    	
    	/*
    	 * Parse behavior files
    	 */
    	List<ParseResult<ModelUnit>> parsedSemantics =
    			(new AstBuilder(queryEnvironment)).parseFromFiles(toAbsolutePaths(env.getBehaviors()));
    	
    	return parsedSemantics;
    }
    
    /**
     * Setup the eval environment & parse inputs streams
     */
    public List<ParseResult<ModelUnit>> parse(List<EPackage> context, List<InputStream> inputs) {
    	cleanUp();
    	register(context);
    	List<ParseResult<ModelUnit>> parsedSemantics = (new AstBuilder(queryEnvironment)).parseFromInputStreams(inputs);
    	return parsedSemantics;
    	
    }
    
    public List<EPackage> getSyntaxes(Dsl dsl) {
    	return
	    	dsl
	    	.getMetamodels()
			.stream()
			.flatMap(syntaxURI -> load(syntaxURI, rs).stream())
			.collect(toList());
    }
    
    /**
     * Clean up existing Runtime EPackages
     */
    private void cleanUp() {
    	List<EPackage> toRemove = 
    		queryEnvironment
			.getEPackageProvider()
			.getRegisteredEPackages()
			.stream()
			.filter(p -> p.getNsURI().startsWith(ModelBuilder.RUNTIME_ALE_NSURI))
			.collect(toList());
    	toRemove.forEach(p -> queryEnvironment.removeEPackage(p));
    }
    
    /**
     * Register EPackages if not already there
     */
    private void register(List<EPackage> packages) {
    	packages
		.stream()
		.forEach(pkg -> {
			Collection<EPackage> matchingPkgs = queryEnvironment.getEPackageProvider().getEPackage(pkg.getName());
			Optional<EPackage> existingPkg = matchingPkgs.stream().filter(p -> p.getNsURI().equals(pkg.getNsURI())).findFirst();
			if(!existingPkg.isPresent()){
				queryEnvironment.registerEPackage(pkg);
			}
		});
    }
	
    public static List<EPackage> load(String ecoreURI, ResourceSet rs) {
    	URI uri = URI.createURI(ecoreURI);
    	Resource res  = rs.getResource(uri, true);
    	
    	return 
    		res
	    	.getContents()
	    	.stream()
	    	.filter(o -> o instanceof EPackage)
	    	.map(o -> (EPackage) o)
	    	.collect(toList());
    }
    
    private static List<String> toAbsolutePaths(Collection<String> behaviors) {
    	List<String> absolutePaths = new ArrayList<>();
    	
    	for (String behavior : behaviors) {
    		try {
    			URI behaviorURI = URI.createFileURI(convertToFile(behavior));
    			absolutePaths.add(behaviorURI.toFileString());
    		} 
    		catch (IllegalArgumentException e) {
    			// URI is ill-formatted, skip it
    		}
		}
    	return absolutePaths;
    }
	
	/**
	 * Convert platform URI to file path
	 */
	public static String convertToFile(String path) {
		URI uri = URI.createURI(path);
		
		String res = null;
		
		if(uri.isPlatformResource()) {
			res = resourceToFile(uri);
			if(res == null) {
				res = pluginToFile(resourceToPlugin(uri));
			}
		}
		else if(uri.isPlatformPlugin()) {
			res = pluginToFile(uri);
		}
		
		if(res == null) {
			res = path;
		}
		
		return res;
	}
	
	private static String resourceToFile(URI uri) {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		if(ws != null) {
			IResource file = ws.getRoot().findMember(uri.toPlatformString(true));
			if(file != null) {
				return file.getLocationURI().getRawPath();
			}
		}
		return null;
	}
	
	private static String pluginToFile(URI uri) {
		String pluginName = uri.segment(1);
		String path = uri.toPlatformString(true).substring(pluginName.length()+1);
		
		Bundle plugin = Platform.getBundle(pluginName);
		URL pluginURL = plugin.getEntry("/");
		
		try {
			String pluginFilePath = FileLocator.toFileURL(pluginURL).getFile();
			return  pluginFilePath.toString() + path.substring(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Convert platform:/resource/ to platform:/plugin/
	 */
	private static URI resourceToPlugin(URI uri) {
		return URI.createPlatformPluginURI(uri.toPlatformString(true), true);
	}
}
