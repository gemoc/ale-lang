package org.eclipse.emf.ecoretools.ale.core.delegate;

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
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.core.parser.ALELexer;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RBlockContext;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.AstVisitors.BlockVisitor;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ModelBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationFactory;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

/**
 * Build ALE model from EAnnotations on EOperations
 */
public class EAnnotationParser {

	ImplementationFactory factory = (ImplementationFactory) ImplementationPackage.eINSTANCE.getEFactoryInstance();
	
	
	public EAnnotationParser(IQueryEnvironment qryEnv) {
		ModelBuilder.createSingleton(qryEnv);
	}
	
	public List<ParseResult<ModelUnit>> parse(List<EPackage> pkgs) {
		List<ParseResult<ModelUnit>> results = new ArrayList<ParseResult<ModelUnit>>();
		pkgs.forEach(pkg -> {
			Optional<ParseResult<ModelUnit>> unit = parse(pkg);
			if(unit.isPresent()) {
				results.add(unit.get());
			}
		});
		return results;
	}
	
	public Optional<ParseResult<ModelUnit>> parse(EPackage pkg) {
		
		ParseResult<ModelUnit> parseRes = new ParseResult<ModelUnit>();
		parseRes.setDiagnostic(new BasicDiagnostic());
		
		List<ExtendedClass> allExtensions = new ArrayList<ExtendedClass>();
		pkg
		.getEClassifiers()
		.stream()
		.filter(cls -> cls instanceof EClass)
		.forEach(cls -> {
			List<Method> allImplem = parse((EClass)cls,parseRes);
			if(!allImplem.isEmpty()) {
				ExtendedClass xtdCls = factory.createExtendedClass();
				xtdCls.setBaseClass((EClass)cls);
				xtdCls.setName(cls.getName());
				xtdCls.getMethods().addAll(allImplem);
				allExtensions.add(xtdCls);
			}
		});
		
		if(!allExtensions.isEmpty()) {
			ModelUnit unit = factory.createModelUnit();
			unit.setName(qualifiedName(pkg));
			unit.getClassExtensions().addAll(allExtensions);
			parseRes.setRoot(unit);
			return Optional.of(parseRes);
		}
		
		return Optional.empty();
	}
	
	public List<Method> parse(EClass cls, ParseResult<ModelUnit> parseRes) {
		List<Method> allImplem = new ArrayList<Method>();
		cls
		.getEOperations()
		.forEach(op -> {
			Optional<Method> mtd = parse(op, parseRes);
			if(mtd.isPresent()) {
				allImplem.add(mtd.get());
			}
		});
		
		return allImplem;
	}
	
	public Optional<Method> parse(EOperation op, ParseResult<ModelUnit> parseRes) {
		String body = EcoreUtil.getAnnotation(op, ImplementationPackage.eNS_URI, "body");
		
		if(body != null) {
			if(!(body.trim().startsWith("{") && body.trim().endsWith("}"))) {
				body = "{" + body + "}";
			}
			try {
				RBlockContext blockAst = parse(body);
				Block block = new BlockVisitor(parseRes).visit(blockAst);
				return Optional.of(ModelBuilder.singleton.buildMethod(op,block,Arrays.asList()));
			} catch (IOException e) {
				e.printStackTrace();
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
