package parser;

import implementation.Root;
import java.io.StringReader;
import java.util.Collections;
import java.util.Set;
import java.util.function.Consumer;
import org.antlr.v4.runtime.CommonTokenFactory;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.UnbufferedCharStream;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import parser.XtdAQLLexer;
import parser.XtdAQLParser;
import parser.visitor.ModelBuilder;
import parser.visitor.RootVisitor;

@SuppressWarnings("all")
public class AstBuilder {
  public AstBuilder(final Set<EPackage> metamodel) {
    final IQueryEnvironment qryEnv = Query.newEnvironmentWithDefaultServices(null);
    final Consumer<EPackage> _function = (EPackage it) -> {
      qryEnv.registerEPackage(it);
    };
    metamodel.forEach(_function);
    ModelBuilder.createSingleton(qryEnv);
  }
  
  public Root parse(final String program) {
    StringReader _stringReader = new StringReader(program);
    int _length = program.length();
    final UnbufferedCharStream input = new UnbufferedCharStream(_stringReader, _length);
    final XtdAQLLexer lexer = new XtdAQLLexer(input);
    CommonTokenFactory _commonTokenFactory = new CommonTokenFactory(true);
    lexer.setTokenFactory(_commonTokenFactory);
    final CommonTokenStream tokens = new CommonTokenStream(lexer);
    final XtdAQLParser parser = new XtdAQLParser(tokens);
    final XtdAQLParser.RRootContext rootCtx = parser.rRoot();
    RootVisitor _rootVisitor = new RootVisitor();
    return _rootVisitor.visit(rootCtx);
  }
  
  public static void main(final String[] args) {
    final String prog = "class toto {\n\t\t\tdef method (int x) {\n\t\t\t\t[test some expression here!/]\n\t\t\t}\n\t\t}";
    Set<EPackage> _set = IterableExtensions.<EPackage>toSet(Collections.<EPackage>unmodifiableList(CollectionLiterals.<EPackage>newArrayList()));
    final AstBuilder builder = new AstBuilder(_set);
    final Root root = builder.parse(prog);
    InputOutput.<String>println("Done");
  }
}
