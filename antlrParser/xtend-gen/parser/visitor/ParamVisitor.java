package parser.visitor;

import implementation.Parameter;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import parser.XtdAQLBaseVisitor;
import parser.XtdAQLParser;
import parser.visitor.VarVisitor;

@SuppressWarnings("all")
public class ParamVisitor extends XtdAQLBaseVisitor<List<Parameter>> {
  @Override
  public List<Parameter> visitRParameters(final XtdAQLParser.RParametersContext ctx) {
    final VarVisitor subVisitor = new VarVisitor();
    List<XtdAQLParser.RVariableContext> _rVariable = ctx.rVariable();
    final Function1<XtdAQLParser.RVariableContext, Parameter> _function = (XtdAQLParser.RVariableContext it) -> {
      return subVisitor.visit(it);
    };
    return ListExtensions.<XtdAQLParser.RVariableContext, Parameter>map(_rVariable, _function);
  }
}
