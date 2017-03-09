package lang.core.parser;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;

import implementation.ModelBehavior;
import lang.core.parser.XtdAQLParser.RRootContext;
import lang.core.parser.visitor.ModelBuilder;
import lang.core.parser.visitor.ParseResult;
import lang.core.parser.visitor.Visitors;

/**
 * This class parse ".implem" file and produce model intance of Implementation metamodel
 */
public class AstBuilder {
	
	public AstBuilder(IQueryEnvironment qryEnv) {
		ModelBuilder.createSingleton(qryEnv);
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