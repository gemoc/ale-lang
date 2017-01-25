package parser.visitor;

import implementation.Behaviored;
import implementation.ExtendedClass;
import implementation.Statement;
import implementation.VariableDeclaration;
import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import parser.XtdAQLBaseVisitor;
import parser.XtdAQLParser;
import parser.visitor.ModelBuilder;
import parser.visitor.OpVisitor;
import parser.visitor.StatementVisitor;

@SuppressWarnings("all")
public class ClassVisitor extends XtdAQLBaseVisitor<ExtendedClass> {
  @Override
  public ExtendedClass visitRClass(final XtdAQLParser.RClassContext ctx) {
    TerminalNode _ID = ctx.ID();
    final String name = _ID.getText();
    final StatementVisitor subVisitor1 = new StatementVisitor();
    List<XtdAQLParser.RAssignContext> _rAssign = ctx.rAssign();
    final Function1<XtdAQLParser.RAssignContext, VariableDeclaration> _function = (XtdAQLParser.RAssignContext it) -> {
      Statement _visitRAssign = subVisitor1.visitRAssign(it);
      return ((VariableDeclaration) _visitRAssign);
    };
    final List<VariableDeclaration> attributes = ListExtensions.<XtdAQLParser.RAssignContext, VariableDeclaration>map(_rAssign, _function);
    final OpVisitor subVisitor2 = new OpVisitor();
    List<XtdAQLParser.ROperationContext> _rOperation = ctx.rOperation();
    final Function1<XtdAQLParser.ROperationContext, Behaviored> _function_1 = (XtdAQLParser.ROperationContext it) -> {
      return subVisitor2.visit(it);
    };
    final List<Behaviored> operations = ListExtensions.<XtdAQLParser.ROperationContext, Behaviored>map(_rOperation, _function_1);
    return ModelBuilder.singleton.buildExtendedClass(name, attributes, operations);
  }
}
