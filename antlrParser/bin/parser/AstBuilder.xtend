package parser

import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.UnbufferedCharStream
import java.io.StringReader
import org.antlr.v4.runtime.CommonTokenFactory
import parser.visitor.RootVisitor
import implementation.Root
import org.eclipse.acceleo.query.runtime.impl.EPackageProvider
import parser.visitor.ModelBuilder
import org.eclipse.emf.ecore.EPackage
import java.util.Set

class AstBuilder {
	
	new(Set<EPackage> metamodel) {
		val ePackageProvider = new EPackageProvider
		metamodel.forEach[ePackageProvider.registerPackage(it)]
		ModelBuilder.createSingleton(ePackageProvider)
	}
	
	def Root parse(String program) {
		val input = new UnbufferedCharStream(new StringReader(program), program.length());
		val lexer = new XtdAQLLexer(input)
		lexer.setTokenFactory(new CommonTokenFactory(true));
		val tokens = new CommonTokenStream(lexer)
		val parser = new XtdAQLParser(tokens)
//		val listener = new XtdAqlListener
//		parser.addParseListener(listener)
		val rootCtx  = parser.rRoot()
		
//		listener.getModel
		
		return (new RootVisitor).visit(rootCtx)
	}
	
	def static void main(String[] args) {
		
		val prog = "class toto {
			def method (int x) {
				[test some expression here!/]
			}
		}"
		
		val builder = new AstBuilder(#[].toSet)
		val root = builder.parse(prog)
		println("Done")
	}
}