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
package org.eclipse.emf.ecoretools.ale.core.parser.internal;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RRootContext;
import org.eclipse.emf.ecoretools.ale.core.parser.BehaviorsParser;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;

/**
 * An adapter that turns the AST produced by ANTLR into an AST
 * mainly made of ALE Behaviors
 * <p>
 * Said ALE Behaviors are EObject that belong to the {@link ImplementationPackage Implementation metamodel}.
 * <p>
 * This factory is used by the {@link BehaviorsParser} to produce an actually exploitable AST.
 */
public class AntlrAstToBehaviorsAstAdapter {
	
	private IQueryEnvironment qryEnv;
	
	public AntlrAstToBehaviorsAstAdapter(IQueryEnvironment qryEnv) {
		this.qryEnv = qryEnv;
		AntlrAstToAleBehaviorsFactory.createSingleton(qryEnv);
	}
	
	/**
	 * Transform ANTLR parse result to proper ALE model
	 */
	public List<ParsedFile<ModelUnit>> toBehaviors(List<RRootContext> antlrASTs, Map<RRootContext,String> sourceFiles){
		List<ParsedFile<ModelUnit>> build = new ArrayList<>();
		
		Map<String, List<EClass>> allNewClasses = createNewEClassesFromDynamicClasses(antlrASTs);
		
		buildClassExtensions(antlrASTs, sourceFiles, build);
		
		updateDeclaredEClassDefinitions(build, allNewClasses);

		List<ExtendedClass> allExtensions = resolveExtends(build);
    	
    	resolveOpposites(build, allExtensions);
		
		return build;
	}

	/**
	 * Create new {@link EClass} instances from AST's {@link RuntimeClass}es.
	 * <p>
	 * New EClasses are added to the EPackage named after the source file's behavior
	 * (qualified name after the {@code behavior} keyword). A new EPackage is created
	 * if the behavior doesn't match any existing EPackage.
	 * 
	 * @param antlrASTs
	 * 			The ASTs built by ANTLR. Each AST correspond to a unique source file.
	 * 
	 * @return the new EClass instantiated from the definition of ALE dynamic classes.
	 */
	private Map<String, List<EClass>> createNewEClassesFromDynamicClasses(List<RRootContext> antlrASTs) {
		Map<String,List<EClass>> allNewClasses = new HashMap<>();
		antlrASTs
			.stream()
			.forEach(sourceFileAST -> {
				// == dynamic classes, that do not belong to a metamodel
				List<EClass> newOnes = AstVisitors.preVisit(sourceFileAST);
				
				EPackage candidatePkg = null;
				Collection<EPackage> pkgs = qryEnv.getEPackageProvider().getEPackage(sourceFileAST.rQualified().getText());
				if(pkgs != null && !pkgs.isEmpty()) {
					candidatePkg = pkgs.iterator().next();
				}
				else {
					candidatePkg = AntlrAstToAleBehaviorsFactory.singleton.buildEPackage(sourceFileAST.rQualified().getText());
				}
				candidatePkg.getEClassifiers().addAll(newOnes);
				String behaviorName = sourceFileAST.rQualified().getText();
				allNewClasses.put(behaviorName, newOnes);
				
				EPackage topPkg = candidatePkg;
				while(topPkg.getESuperPackage() != null){
					topPkg = topPkg.getESuperPackage();
				}
				
				// removeEPackage() is called to make sure the package is updated
				// Otherwise a show stopper prevents the package to be registered again
				//
				// See: https://git.eclipse.org/c/acceleo/org.eclipse.acceleo.git/tree/query/plugins/org.eclipse.acceleo.query/src/org/eclipse/acceleo/query/runtime/impl/EPackageProvider.java#n265
				//	    (commit 	41f1588)
				qryEnv.removeEPackage(topPkg);
				qryEnv.registerEPackage(topPkg);
			});
		return allNewClasses;
	}

	/**
	 * Build class extensions
	 * 
	 * @param rawParses
	 * @param sourceFiles
	 * @param build
	 */
	private void buildClassExtensions(List<RRootContext> rawParses, Map<RRootContext, String> sourceFiles,
			List<ParsedFile<ModelUnit>> build) {
		rawParses
		.stream()
		.forEach(p -> {
			ParsedFile<ModelUnit> parseRes = AstVisitors.visit(p);
			parseRes.setSourceFile(sourceFiles.get(p));
			build.add(parseRes);
		});
	}

	private void updateDeclaredEClassDefinitions(List<ParsedFile<ModelUnit>> build, Map<String, List<EClass>> allNewClasses) {
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
						AntlrAstToAleBehaviorsFactory.singleton.updateEClass(cls.get(),clsDef);
					}
				});
			}
		});
	}

	private List<ExtendedClass> resolveExtends(List<ParsedFile<ModelUnit>> build) {
		Map<String,List<ExtendedClass>> behaviorToClass = new HashMap<>();
    	List<ExtendedClass> allExtensions = new ArrayList<>();
    	build
    	.stream()
    	.forEach(sem -> {
    		ModelUnit root = sem.getRoot();
    		if(root != null) {
    			List<ExtendedClass> xtdCls =  root.getClassExtensions().stream().collect(toList());
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
				.filter(a -> a.getSource().equals(AntlrAstToAleBehaviorsFactory.PARSER_SOURCE))
				.filter(a -> a.getDetails().get(AntlrAstToAleBehaviorsFactory.PARSER_EXTENDS_KEY) != null)
				.collect(toList());
    		toResolve
	    		.stream()
	    		.forEach(annot -> {
	    			String xtd = annot.getDetails().get(AntlrAstToAleBehaviorsFactory.PARSER_EXTENDS_KEY);
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
		return allExtensions;
	}

	private void resolveOpposites(List<ParsedFile<ModelUnit>> build, List<ExtendedClass> allExtensions) {
		List<Attribute> allAttributes = new ArrayList<>();
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
    	.filter(attr -> attr.getEAnnotation(AntlrAstToAleBehaviorsFactory.PARSER_SOURCE) != null)
    	.forEach(attr -> {
    		EAnnotation annot = attr.getEAnnotation(AntlrAstToAleBehaviorsFactory.PARSER_SOURCE);
    		String opposite = annot.getDetails().get(AntlrAstToAleBehaviorsFactory.PARSER_OPPOSITE_KEY);
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
	}
	
}