package parser.visitor;

import implementation.Behaviored;
import implementation.ExtendedClass;
import implementation.VariableDeclaration;
import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import parser.XtdAQLBaseVisitor;
import parser.XtdAQLParser;
import parser.visitor.AttributeVisitor;
import parser.visitor.ModelBuilder;
import parser.visitor.OpVisitor;

@SuppressWarnings("all")
public class ClassVisitor extends XtdAQLBaseVisitor<ExtendedClass> {
  @Override
  public ExtendedClass visitRClass(final XtdAQLParser.RClassContext ctx) {
    TerminalNode _Ident = ctx.Ident();
    final String name = _Ident.getText();
    final AttributeVisitor subVisitor1 = new AttributeVisitor();
    List<XtdAQLParser.RAttributeContext> _rAttribute = ctx.rAttribute();
    final Function1<XtdAQLParser.RAttributeContext, VariableDeclaration> _function = (XtdAQLParser.RAttributeContext it) -> {
      VariableDeclaration _visitRAttribute = subVisitor1.visitRAttribute(it);
      return ((VariableDeclaration) _visitRAttribute);
    };
    final List<VariableDeclaration> attributes = ListExtensions.<XtdAQLParser.RAttributeContext, VariableDeclaration>map(_rAttribute, _function);
    final OpVisitor subVisitor2 = new OpVisitor();
    List<XtdAQLParser.ROperationContext> _rOperation = ctx.rOperation();
    final Function1<XtdAQLParser.ROperationContext, Behaviored> _function_1 = (XtdAQLParser.ROperationContext it) -> {
      return subVisitor2.visit(it);
    };
    final List<Behaviored> operations = ListExtensions.<XtdAQLParser.ROperationContext, Behaviored>map(_rOperation, _function_1);
    return ModelBuilder.singleton.buildExtendedClass(name, attributes, operations);
  }
}
