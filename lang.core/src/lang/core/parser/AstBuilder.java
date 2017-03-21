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
import java.util.Optional;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.ecore.EClass;
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
		
		return build;
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