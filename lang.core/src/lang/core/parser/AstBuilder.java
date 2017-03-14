package lang.core.parser;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.ecore.EPackage;

import implementation.ModelBehavior;
import lang.core.parser.XtdAQLParser.RRootContext;
import lang.core.parser.visitor.ModelBuilder;
import lang.core.parser.visitor.ParseResult;
import lang.core.parser.visitor.Visitors;

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
		Map<RRootContext,ParseResult<ModelBehavior>> preBuilds = new HashMap<RRootContext,ParseResult<ModelBehavior>>();
		/*
		 * Build new classes
		 */
		parses
			.stream()
			.forEach(p -> {
				preBuilds.put(p, Visitors.preVisit(p));
			});
		/*
		 * Transform new classes to EClasses
		 */
		List<ModelBehavior> runtimeClasses =
			preBuilds
			.entrySet()
			.stream()
			.map(e -> e.getValue().getRoot())
			.collect(Collectors.toList());
		registerDynamicClasses(runtimeClasses);
		
		/*
		 * Build class extensions
		 */
		parses
		.stream()
		.forEach(p -> {
			ParseResult<ModelBehavior> parseRes = Visitors.visit(p);
			parseRes.setSourceFile(sourceFiles.get(p));
			build.add(parseRes);
			//Then merge with the pre-build
			ParseResult<ModelBehavior> preBuild = preBuilds.get(p);
			parseRes.getRoot().getClassDefinitions().addAll(preBuild.getRoot().getClassDefinitions());
			parseRes.getStartPositions().putAll(preBuild.getStartPositions());
			parseRes.getEndPositions().putAll(preBuild.getEndPositions());
		});
		
		return build;
	}
	
	/**
	 * Register classes defined inside behaviors
	 */
	private void registerDynamicClasses(List<ModelBehavior> allImplemModels) {
		allImplemModels
		.stream()
		.forEach(implemModel -> {
			if(!implemModel.getClassDefinitions().isEmpty()){
				EPackage candidatePkg = null;
				Collection<EPackage> pkgs = qryEnv.getEPackageProvider().getEPackage(implemModel.getName());
				if(pkgs != null && !pkgs.isEmpty()) {
					candidatePkg = pkgs.iterator().next();
				}
				else {
					candidatePkg = ModelBuilder.singleton.buildEPackage(implemModel.getName());
				}
				
				final EPackage newPkg = candidatePkg;
				implemModel
					.getClassDefinitions()
					.stream()
					.forEach(cls -> {
						newPkg.getEClassifiers().add(ModelBuilder.singleton.buildEClass(cls));
					});
				qryEnv.registerEPackage(candidatePkg);
			}
		});
	}
	
	private RRootContext doParse(String file) {
		String content = getFileContent(file);
		UnbufferedCharStream input = new UnbufferedCharStream(new StringReader(content), content.length());
		XtdAQLLexer lexer = new XtdAQLLexer(input);
		lexer.setTokenFactory(new CommonTokenFactory(true));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		XtdAQLParser parser = new XtdAQLParser(tokens);
		return  parser.rRoot();
	}
	
	public ParseResult<ModelBehavior> parse(String program) {
		UnbufferedCharStream input = new UnbufferedCharStream(new StringReader(program), program.length());
		XtdAQLLexer lexer = new XtdAQLLexer(input);
		lexer.setTokenFactory(new CommonTokenFactory(true));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		XtdAQLParser parser = new XtdAQLParser(tokens);
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