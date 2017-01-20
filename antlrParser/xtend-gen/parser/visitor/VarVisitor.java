package parser.visitor;

import implementation.Parameter;
import org.antlr.v4.runtime.tree.ParseTree;
import parser.XtdAQLBaseVisitor;
import parser.XtdAQLParser;
import parser.visitor.ModelBuilder;

@SuppressWarnings("all")
public class VarVisitor extends XtdAQLBaseVisitor<Parameter> {
  @Override
  public Parameter visitRVariable(final XtdAQLParser.RVariableContext ctx) {
    ParseTree _child = ctx.getChild(0);
    final String type = _child.getText();
    ParseTree _child_1 = ctx.getChild(1);
    final String name = _child_1.getText();
    return ModelBuilder.singleton.buildParameter(type, name);
  }
}
