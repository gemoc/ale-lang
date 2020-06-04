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
import static org.eclipse.emf.ecoretools.ale.core.parser.IOUtils.toAbsolutePaths;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.core.Activator;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RRootContext;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.AntlrAstToAleBehaviorsFactory;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.AntlrAstToBehaviorsAstAdapter;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

/**
 * Extract ALE behaviors from .ale files.
 * <p>
 * Those behaviors are represented by model instances of the {@link ImplementationPackage Implementation metamodel}.
 */
public class BehaviorsParser {
	
	private IQueryEnvironment queryEnvironment;
	private ResourceSet rs;
	
	public BehaviorsParser(IQueryEnvironment qryEnv) {
		this.queryEnvironment = qryEnv;
		this.rs = new ResourceSetImpl();
	}
	
	public BehaviorsParser(IQueryEnvironment qryEnv, ResourceSet rs) {
		this.queryEnvironment = qryEnv;
		this.rs = rs;
	}

	/**
     * Parses given sources and returns the corresponding AST.
     * <p>
     * Adds all new EPackages and EClasses to the {@link IQueryEnvironment}
     * that has be given to the constructor.
     * 
     * @param metamodels
     * 			The static metamodels of which the behaviors will be parsed.
     * @param behaviorsSourcesPaths
     * 			The paths to the ALE source files to parse.
     */
    public List<ParsedFile<ModelUnit>> parse(List<EPackage> metamodels, Set<String> behaviorsSourcesPaths) {
    	cleanUp();
    	register(metamodels);
    	return parseFromFiles(toAbsolutePaths(behaviorsSourcesPaths));
    }

	/**
     * Parses given sources and returns the corresponding AST.
     * <p>
     * Adds all new EPackages and EClasses to the {@link IQueryEnvironment}
     * that has be given to the constructor.
     * 
     * @param metamodels
     * 			The static metamodels of which the behaviors will be parsed.
     * @param behaviorsContents
     * 			The contents of the ALE source files to parse.
     */
    public List<ParsedFile<ModelUnit>> parse(List<EPackage> context, List<InputStream> behaviorsContents) {
    	cleanUp();
    	register(context);
    	return parseFromInputStreams(behaviorsContents);
    }
    
    // =====================================================================================================
    //
    //	AQL ENVIRONMENT MANAGEMENT
    //
    //	TODO Move higher (AbstractAleEnvironment?)
    //
    // =====================================================================================================
    
    /**
     * Cleans up the environment to prevent issues when the same IQueryEnvironment
     * is used multiple times to parse ALE sources.
     */
    private void cleanUp() {
    	List<EPackage> toRemove = queryEnvironment.getEPackageProvider()
    											  .getRegisteredEPackages().stream()
    											  .filter(p -> p.getNsURI().startsWith(AntlrAstToAleBehaviorsFactory.RUNTIME_ALE_NSURI))
    											  .collect(toList());
    	toRemove.forEach(p -> queryEnvironment.removeEPackage(p));
    }
    
    /**
     * Register static EClass so they can be found while parsing expressions and types.
     */
    private void register(Collection<EPackage> packages) {
    	rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
    	for (EPackage pkg : packages) {
    		EPackage registryPkg = rs.getPackageRegistry().getEPackage(pkg.getNsURI());
    		boolean metamodelAlreadyInRegistry = registryPkg != null;
    		
    		// Priority is given to EPackage already available in EMF's registry
    		if (metamodelAlreadyInRegistry) {
    			register(registryPkg);
    		}
    		else {
    			register(pkg);
    		}
    	}
    }
    
    /**
     * Exposes given EPackage to AQL queries performed with {@link #queryEnvironment}.
     */
    private void register(EPackage pkg) {
    	Collection<EPackage> matchingPkgs = queryEnvironment.getEPackageProvider().getEPackage(pkg.getName());
		Optional<EPackage> existingPkg = matchingPkgs.stream().filter(p -> p.getNsURI().equals(pkg.getNsURI())).findFirst();
		if(!existingPkg.isPresent()){
			queryEnvironment.registerEPackage(pkg);
		}
    }
    
    // =====================================================================================================
    //
    //	ACTUAL PARSING
    //
    // =====================================================================================================
	
	public List<ParsedFile<ModelUnit>> parseFromInputStreams(List<InputStream> inputs) {
		List<RRootContext> rawASTs = new ArrayList<>();
		inputs.forEach(input -> doParse(input).ifPresent(rawASTs::add));
		
		AntlrAstToBehaviorsAstAdapter adapter = new AntlrAstToBehaviorsAstAdapter(queryEnvironment);
		return adapter.toBehaviors(rawASTs,new HashMap<RRootContext,String>());
	}
	
	public List<ParsedFile<ModelUnit>> parseFromFiles(Collection<String> paths) {
		List<RRootContext> rawASTs = new ArrayList<>();
		Map<RRootContext, String> sourceFiles = new HashMap<>(); 
		
		for (String path : paths) {
			doParse(path).ifPresent(ast -> {
				rawASTs.add(ast);
				sourceFiles.put(ast, path);
			});
		}
		AntlrAstToBehaviorsAstAdapter adapter = new AntlrAstToBehaviorsAstAdapter(queryEnvironment);
		return adapter.toBehaviors(rawASTs, sourceFiles);
	}
	
	private Optional<RRootContext> doParse(InputStream fileContent) {
		try {
			ANTLRInputStream input = new ANTLRInputStream(fileContent);
			ALELexer lexer = new ALELexer(input);
			lexer.setTokenFactory(new CommonTokenFactory(true));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ALEParser parser = new ALEParser(tokens);
			return Optional.of(parser.rRoot());
		}
		catch (IOException e) {
			// TODO find a way to report the exception so that it can be processed by the caller, without interrupting parsing
			Activator.error("ANTLR parser failed to parse ALE sources from given input stream", e);
			return Optional.empty();
		}
	}
	
	private Optional<RRootContext> doParse(String fileName) {
		try {
			ANTLRFileStream input = new ANTLRFileStream(fileName);
			ALELexer lexer = new ALELexer(input);
			lexer.setTokenFactory(new CommonTokenFactory(true));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			ALEParser parser = new ALEParser(tokens);
			return Optional.of(parser.rRoot());
		}
		catch (IOException e) {
			// TODO find a way to report the exception so that it can be processed by the caller, without interrupting parsing
			Activator.error("ANTLR parser failed to parse ALE sources from given input stream", e);
			return Optional.empty();
		}
	}
	
}
