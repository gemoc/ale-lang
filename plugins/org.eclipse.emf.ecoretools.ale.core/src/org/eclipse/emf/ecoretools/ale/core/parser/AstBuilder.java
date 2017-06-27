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

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RRootContext;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ModelBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.AstVisitors;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

/**
 * This class parse ".ale" file and produce model intance of Implementation metamodel
 */
public class AstBuilder {
	
	IQueryEnvironment qryEnv;
	
	public AstBuilder(IQueryEnvironment qryEnv) {
		this.qryEnv = qryEnv;
		ModelBuilder.createSingleton(qryEnv);
	}
	
	public List<ParseResult<ModelUnit>> parseFromInputStreams(List<InputStream> inputs) {
		
		List<RRootContext> parses = new ArrayList<RRootContext>();
		inputs
			.stream()
			.forEach(f -> {
				try {
					RRootContext parseRes = doParse(f);
					parses.add(parseRes);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		
		return makeModel(parses,new HashMap<RRootContext,String>());
	}
	
	public List<ParseResult<ModelUnit>> parseFromFiles(List<String> files) {
		List<RRootContext> parses = new ArrayList<RRootContext>();
		Map<RRootContext,String> sourceFiles = new HashMap<RRootContext,String>(); 
		files
			.stream()
			.forEach(f -> {
				try {
					RRootContext parseRes = doParse(f);
					parses.add(parseRes);
					sourceFiles.put(parseRes,f);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		
		return makeModel(parses,sourceFiles);
	}
	
	/**
	 * Transform ANTLR parse result to proper ALE model
	 */
	private List<ParseResult<ModelUnit>> makeModel(List<RRootContext> rawParses, Map<RRootContext,String> sourceFiles){
		List<ParseResult<ModelUnit>> build = new ArrayList<ParseResult<ModelUnit>>();
		
		/*
		 * Create & declare new EClasses
		 */
		Map<String,List<EClass>> allNewClasses = new HashMap<String,List<EClass>>();
		rawParses
			.stream()
			.forEach(implemParse -> {
				List<EClass> newOnes = AstVisitors.preVisit(implemParse);
				
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
		rawParses
		.stream()
		.forEach(p -> {
			ParseResult<ModelUnit> parseRes = AstVisitors.visit(p);
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
						/*
						 * cls is a copy of clsDef.fragment since it
						 * can't be contains by clsDef & qryEnv in the same time
						 */
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
    		ModelUnit root = sem.getRoot();
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
    				String qualifying = ((ModelUnit)cls.eContainer()).getName();
    				String name = xtd;
    				if(AstVisitors.isQualified(xtd)) {
    					int lastDot = xtd.lastIndexOf(".");
    					if(lastDot < xtd.length()){
    						qualifying = xtd.substring(0, lastDot);
    						name = xtd.substring(lastDot+1);
    					}
    				}
    				String finalName = name;
    				List<ExtendedClass> candidates = behaviorToClass.get(qualifying);
    				if(candidates != null) {
    					Optional<ExtendedClass> searchRes =
    							candidates
    							.stream()
    							.filter(c -> c.getBaseClass().getName().equals(finalName))
    							.findFirst();
    					if(searchRes.isPresent()) {
    						cls.getExtends().add(searchRes.get());
    						cls.getEAnnotations().remove(annot);
    					}
    				}
	    		});
    	});
    	
    	/*
    	 * Resolve opposites
    	 */
    	List<Attribute> allAttributes = new ArrayList<Attribute>();
    	build
    	.stream()
    	.forEach(sem -> {
    		ModelUnit root = sem.getRoot();
    		if(root != null) {
    			root.getClassExtensions().stream().forEach(cls -> {
    				allAttributes.addAll(cls.getAttributes());
    			});
    			root.getClassDefinitions().stream().forEach(cls -> {
    				allAttributes.addAll(cls.getAttributes());
    			});
    		}
    	});
    	allAttributes
    	.stream()
    	.filter(attr -> attr.getEAnnotation(ModelBuilder.PARSER_SOURCE) != null)
    	.forEach(attr -> {
    		EAnnotation annot = attr.getEAnnotation(ModelBuilder.PARSER_SOURCE);
    		String opposite = annot.getDetails().get(ModelBuilder.PARSER_OPPOSITE_KEY);
    		EClassifier oppositeType = attr.getFeatureRef().getEType();
    		if(oppositeType instanceof EClass) {
    			EClass oppositeClass = (EClass) oppositeType;
    			EStructuralFeature oppositeFeature = oppositeClass.getEStructuralFeature(opposite);
    			if(oppositeFeature == null) {
    				Optional<Attribute> candidate = allExtensions
						.stream()
						.filter(xtd -> xtd.getBaseClass() == oppositeType)
						.flatMap(xtd -> xtd.getAttributes().stream())
						.filter(a -> a.getFeatureRef().getName().equals(opposite))
						.findFirst();
    				if(candidate.isPresent()){
    					oppositeFeature = candidate.get().getFeatureRef();
    				}
    			}
    			
    			if(oppositeFeature instanceof EReference) {
    				((EReference)attr.getFeatureRef()).setEOpposite((EReference) oppositeFeature);
    				attr.getEAnnotations().remove(annot);
    			}
    		}
    	});
		
		return build;
	}
	
	private RRootContext doParse(InputStream fileContent) throws IOException {
		ANTLRInputStream input = new ANTLRInputStream(fileContent);
		ALELexer lexer = new ALELexer(input);
		lexer.setTokenFactory(new CommonTokenFactory(true));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ALEParser parser = new ALEParser(tokens);
		return  parser.rRoot();
	}
	
	private RRootContext doParse(String fileName) throws IOException {
		ANTLRFileStream input = new ANTLRFileStream(fileName);
		ALELexer lexer = new ALELexer(input);
		lexer.setTokenFactory(new CommonTokenFactory(true));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ALEParser parser = new ALEParser(tokens);
		return  parser.rRoot();
	}
	
	public ParseResult<ModelUnit> parse(String fileName) throws IOException {
		ANTLRFileStream input = new ANTLRFileStream(fileName);
		ALELexer lexer = new ALELexer(input);
		lexer.setTokenFactory(new CommonTokenFactory(true));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ALEParser parser = new ALEParser(tokens);
		RRootContext rootCtx  = parser.rRoot();
		
		return AstVisitors.visit(rootCtx);
	}
	
	public ParseResult<ModelUnit> parseFromFile(String filePath) throws IOException {
		ParseResult<ModelUnit> parseRes = parse(filePath);
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