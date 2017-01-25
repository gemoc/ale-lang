package parser.visitor;

import implementation.Behaviored;
import implementation.Block;
import implementation.Parameter;
import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import parser.XtdAQLBaseVisitor;
import parser.XtdAQLParser;
import parser.visitor.BlockVisitor;
import parser.visitor.ModelBuilder;
import parser.visitor.ParamVisitor;

@SuppressWarnings("all")
public class OpVisitor extends XtdAQLBaseVisitor<Behaviored> {
  @Override
  public Behaviored visitROperation(final XtdAQLParser.ROperationContext ctx) {
    List<Parameter> _xifexpression = null;
    XtdAQLParser.RParametersContext _rParameters = ctx.rParameters();
    boolean _tripleNotEquals = (_rParameters != null);
    if (_tripleNotEquals) {
      ParamVisitor _paramVisitor = new ParamVisitor();
      XtdAQLParser.RParametersContext _rParameters_1 = ctx.rParameters();
      _xifexpression = _paramVisitor.visit(_rParameters_1);
    } else {
      _xifexpression = CollectionLiterals.<Parameter>newArrayList();
    }
    final List<Parameter> parameters = _xifexpression;
    BlockVisitor _blockVisitor = new BlockVisitor();
    XtdAQLParser.RBlockContext _rBlock = ctx.rBlock();
    final Block body = _blockVisitor.visit(_rBlock);
    ParseTree _child = ctx.getChild(1);
    final String operationName = _child.getText();
    ParseTree _child_1 = ctx.parent.getChild(1);
    final String className = _child_1.getText();
    return ModelBuilder.singleton.buildOperation(className, operationName, parameters, body);
  }
}
