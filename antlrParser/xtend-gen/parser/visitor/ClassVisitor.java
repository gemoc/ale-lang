package parser.visitor;

import implementation.Behaviored;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import parser.XtdAQLBaseVisitor;
import parser.XtdAQLParser;
import parser.visitor.OpVisitor;

@SuppressWarnings("all")
public class ClassVisitor extends XtdAQLBaseVisitor<List<Behaviored>> {
  @Override
  public List<Behaviored> visitRClass(final XtdAQLParser.RClassContext ctx) {
    final OpVisitor subVisitor = new OpVisitor();
    List<XtdAQLParser.ROperationContext> _rOperation = ctx.rOperation();
    final Function1<XtdAQLParser.ROperationContext, Behaviored> _function = (XtdAQLParser.ROperationContext it) -> {
      return subVisitor.visit(it);
    };
    final List<Behaviored> res = ListExtensions.<XtdAQLParser.ROperationContext, Behaviored>map(_rOperation, _function);
    return res;
  }
}
