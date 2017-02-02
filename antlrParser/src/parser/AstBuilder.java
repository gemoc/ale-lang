package parser;

import java.io.StringReader;
import java.util.Set;

import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.emf.ecore.EPackage;

import implementation.ModelBehavior;
import parser.XtdAQLParser.RRootContext;
import parser.visitor.ModelBuilder;
import parser.visitor.Visitors;

public class AstBuilder {
	
	public AstBuilder(Set<EPackage> metamodel) {
		IQueryEnvironment qryEnv = Query.newEnvironmentWithDefaultServices(null);
		metamodel.stream().forEach(pkg -> qryEnv.registerEPackage(pkg));
		ModelBuilder.createSingleton(qryEnv);
	}
	
	public ModelBehavior parse(String program) {
		UnbufferedCharStream input = new UnbufferedCharStream(new StringReader(program), program.length());
		XtdAQLLexer lexer = new XtdAQLLexer(input);
		lexer.setTokenFactory(new CommonTokenFactory(true));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		XtdAQLParser parser = new XtdAQLParser(tokens);
		RRootContext rootCtx  = parser.rRoot();
		
		return Visitors.visit(rootCtx);
	}
}