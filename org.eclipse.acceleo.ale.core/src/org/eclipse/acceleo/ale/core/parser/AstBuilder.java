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

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.eclipse.acceleo.ale.core.parser.visitor.ModelBuilder;
import org.eclipse.acceleo.ale.core.parser.visitor.ParseResult;
import org.eclipse.acceleo.ale.core.parser.visitor.Visitors;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import implementation.ExtendedClass;
import implementation.ModelBehavior;
import org.eclipse.acceleo.ale.core.parser.ALELexer;
import org.eclipse.acceleo.ale.core.parser.ALEParser;
import org.eclipse.acceleo.ale.core.parser.ALEParser.RRootContext;

/**
 * This class parse ".implem" file and produce model intance of Implementation metamodel
 */
public class AstBuilder {
	
	IQueryEnvironment qryEnv;
	
	public AstBuilder(IQueryEnvironment qryEnv) {
		this.qryEnv = qryEnv;
		ModelBuilder.createSingleton(qryEnv);
	}
	
	public List<ParseResult<ModelBehavior>> parseFromFiles(List<String> files) {
		List<ParseResult<ModelBehavior>> build = new ArrayList<ParseResult<ModelBehavior>>();
		
		List<RRootContext> parses = new ArrayList<RRootContext>();
		Map<RRootContext,String> sourceFiles = new HashMap<RRootContext,String>(); 
		files
			.stream()
			.forEach(f -> {
				RRootContext parseRes = doParse(f);
				parses.add(parseRes);
				sourceFiles.put(parseRes,f);
			});
		
		/*
		 * Create & declare new EClasses
		 */
		Map<String,List<EClass>> allNewClasses = new HashMap<String,List<EClass>>();
		parses
			.stream()
			.forEach(implemParse -> {
				List<EClass> newOnes = Visitors.preVisit(implemParse);
				
				EPackage candidatePkg = null;
				Collection<EPackage> pkgs = qryEnv.getEPackageProvider().getEPackage(implemParse.rQualified().getText());
				if(pkgs != null && !pkgs.isEmpty()) {
					candidatePkg = pkgs.iterator().next();
				}
				else {
					candidatePkg = ModelBuilder.singleton.buildEPackage(implemParse.rQualified().getText());
				}
				candidatePkg.getEClassifiers().addAll(newOnes);
				allNewClasses.put(implemParse.rQualified().getText(),newOnes);
				
				EPackage topPkg = candidatePkg;
				while(topPkg.getESuperPackage() != null){
					topPkg = topPkg.getESuperPackage();
				}
				qryEnv.registerEPackage(topPkg);
			});
		
		/*
		 * Build class extensions
		 */
		parses
		.stream()
		.forEach(p -> {
			ParseResult<ModelBehavior> parseRes = Visitors.visit(p);
			parseRes.setSourceFile(sourceFiles.get(p));
			build.add(parseRes);
		});
		
		/*
		 * Update declared EClass definitions
		 */
		build
		.stream()
		.map(m -> m.getRoot())
		.filter(m -> m != null)
		.forEach(implemModel -> {
			List<EClass> newClasses = allNewClasses.get(implemModel.getName());
			if(newClasses != null) {
				implemModel
				.getClassDefinitions()
				.stream()
				.forEach(clsDef -> {
					Optional<EClass> cls = newClasses.stream().filter(c -> c.getName().equals(clsDef.getName())).findFirst();
					if(cls.isPresent()){
						ModelBuilder.singleton.updateEClass(cls.get(),clsDef);
					}
				});
			}
		});
		
		/*
    	 * Resolve extends
    	 */
    	Map<String,List<ExtendedClass>> behaviorToClass = new HashMap<String,List<ExtendedClass>>();
    	List<ExtendedClass> allExtensions = new ArrayList<ExtendedClass>();
    	build
    	.stream()
    	.forEach(sem -> {
    		ModelBehavior root = sem.getRoot();
    		if(root != null) {
    			List<ExtendedClass> xtdCls =  root.getClassExtensions().stream().collect(Collectors.toList());
    			behaviorToClass.put(root.getName(), xtdCls);
    			allExtensions.addAll(xtdCls);
    		}
    	});
    	allExtensions
    	.stream()
    	.forEach(cls -> {
    		List<EAnnotation> toResolve =
				cls
				.getEAnnotations()
				.stream()
				.filter(a -> a.getSource().equals(ModelBuilder.PARSER_SOURCE))
				.filter(a -> a.getDetails().get(ModelBuilder.PARSER_EXTENDS_KEY) != null)
				.collect(Collectors.toList());
    		toResolve
	    		.stream()
	    		.forEach(annot -> {
	    			String xtd = annot.getDetails().get(ModelBuilder.PARSER_EXTENDS_KEY);
	    			if(Visitors.isQualified(xtd)) {
	    				int lastDot = xtd.lastIndexOf(".");
	    				if(lastDot < xtd.length()){
	    					String qualifying = xtd.substring(0, lastDot);
	    					String name = xtd.substring(lastDot+1);
	    					List<ExtendedClass> candidates = behaviorToClass.get(qualifying);
	    					if(candidates != null) {
	    						Optional<ExtendedClass> searchRes =
	    							candidates
		    						.stream()
		    						.filter(c -> c.getBaseClass().getName().equals(name))
		    						.findFirst();
	    						if(searchRes.isPresent()) {
	    							cls.getExtends().add(searchRes.get());
	    							cls.getEAnnotations().remove(annot);
	    						}
	    					}
	    				}
	    			}
	    		});
    	});
		
		return build;
	}
	
	private RRootContext doParse(String file) {
		String content = getFileContent(file);
		UnbufferedCharStream input = new UnbufferedCharStream(new StringReader(content), content.length());
		ALELexer lexer = new ALELexer(input);
		lexer.setTokenFactory(new CommonTokenFactory(true));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ALEParser parser = new ALEParser(tokens);
		return  parser.rRoot();
	}
	
	public ParseResult<ModelBehavior> parse(String program) {
		UnbufferedCharStream input = new UnbufferedCharStream(new StringReader(program), program.length());
		ALELexer lexer = new ALELexer(input);
		lexer.setTokenFactory(new CommonTokenFactory(true));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ALEParser parser = new ALEParser(tokens);
		RRootContext rootCtx  = parser.rRoot();
		
		return Visitors.visit(rootCtx);
	}
	
	public ParseResult<ModelBehavior> parseFromFile(String filePath) {
		ParseResult<ModelBehavior> parseRes = parse(getFileContent(filePath));
		parseRes.setSourceFile(filePath);
		return parseRes;
	}
	
    private static String getFileContent(String implementionPath) {
		String fileContent = "";
		try {
			fileContent = new String(Files.readAllBytes(Paths.get(implementionPath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}
}