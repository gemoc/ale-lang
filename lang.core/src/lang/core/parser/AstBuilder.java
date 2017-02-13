package lang.core.parser;

import java.io.StringReader;

import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;

import implementation.ModelBehavior;
import lang.core.parser.XtdAQLParser.RRootContext;
import lang.core.parser.visitor.ModelBuilder;
import lang.core.parser.visitor.ParseResult;
import lang.core.parser.visitor.Visitors;

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
}