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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.core.Activator;
import org.eclipse.emf.ecoretools.ale.core.parser.ALELexer;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RBlockContext;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.AntlrAstToAleBehaviorsFactory;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.AstVisitors.BlockVisitor;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationFactory;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

/**
 * Parses the ALE behaviors directly defined on EOperations through EAnnotations.
 * <p>
 * Such EAnnotations must:
 * <ul>
 * 	<li>have {@link ImplementationPackage#getNsURI() Implementation EPackage's Ns URI} as source
 * 	<li>have {@link EAnnotationParser#BODY_KEY} as key
 * </ul> 
 */
class EAnnotationParser {
	
	/**
	 * The key identifying EAnnotations defining the body of an EOperation in ALE.
	 */
	public static final String BODY_KEY = "body";

	private ImplementationFactory factory = (ImplementationFactory) ImplementationPackage.eINSTANCE.getEFactoryInstance();
	
	/**
	 * Creates a new parser to extract ALE behaviors from specific EAnnotations on EOperations.
	 * 
	 * @param qryEnv
	 * 			The AQL environment to enrich with the behaviors loaded from EAnnotations.
	 */
	EAnnotationParser(IQueryEnvironment qryEnv) {
		AntlrAstToAleBehaviorsFactory.createSingleton(qryEnv);
	}
	
	public List<ParsedFile<ModelUnit>> parse(List<EPackage> pkgs) {
		List<ParsedFile<ModelUnit>> results = new ArrayList<>();
		for (EPackage pkg : pkgs) {
			parse(pkg).ifPresent(results::add);
		}
		return results;
	}
	
	public Optional<ParsedFile<ModelUnit>> parse(EPackage pkg) {
		ParsedFile<ModelUnit> parseRes = new ParsedFile<>();
		parseRes.setDiagnostic(new BasicDiagnostic());
		
		List<ExtendedClass> allExtensions = new ArrayList<>();
		for (EClassifier classifier : pkg.getEClassifiers()) {
			if (classifier instanceof EClass) {
				EClass cls = (EClass) classifier;
				List<Method> allImplem = parse(cls, parseRes);
				if(!allImplem.isEmpty()) {
					ExtendedClass xtdCls = factory.createExtendedClass();
					xtdCls.setBaseClass(cls);
					xtdCls.setName(cls.getName());
					xtdCls.getMethods().addAll(allImplem);
					allExtensions.add(xtdCls);
				}
			}
		}
		if(!allExtensions.isEmpty()) {
			ModelUnit unit = factory.createModelUnit();
			unit.setName(qualifiedName(pkg));
			unit.getClassExtensions().addAll(allExtensions);
			parseRes.setRoot(unit);
			return Optional.of(parseRes);
		}
		return Optional.empty();
	}
	
	public List<Method> parse(EClass cls, ParsedFile<ModelUnit> parseRes) {
		List<Method> allImplem = new ArrayList<>();
		for (EOperation op : cls.getEOperations()) {
			parse(op, parseRes).ifPresent(allImplem::add);
		}
		return allImplem;
	}
	
	public Optional<Method> parse(EOperation op, ParsedFile<ModelUnit> parseRes) {
		String body = EcoreUtil.getAnnotation(op, ImplementationPackage.eNS_URI, BODY_KEY);
		
		if(body != null) {
			if(!(body.trim().startsWith("{") && body.trim().endsWith("}"))) {
				body = "{" + body + "}";
			}
			try {
				RBlockContext blockAst = parse(body);
				Block block = new BlockVisitor(parseRes).visit(blockAst);
				return Optional.of(AntlrAstToAleBehaviorsFactory.singleton.buildMethod(op,block,Arrays.asList()));
			}
			catch (IOException e) {
				Activator.error("Unable to parse the body of method '" + op.getEContainingClass().getName() + "::" + op.getName() + "' from its EAnnotation", e);
			}
		}
		return Optional.empty();
	}
	
	private RBlockContext parse(String content) throws IOException {
		InputStream stream = new ByteArrayInputStream(content.getBytes());
		ANTLRInputStream input = new ANTLRInputStream(stream);
		ALELexer lexer = new ALELexer(input);
		lexer.setTokenFactory(new CommonTokenFactory(true));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		ALEParser parser = new ALEParser(tokens);
		return parser.rBlock();
	}
	
	private String qualifiedName(EPackage pkg) {
		return pkg.getESuperPackage() == null
				? pkg.getName() 
				: qualifiedName(pkg.getESuperPackage()) + "." + pkg.getName();
	}
}
