package parser.visitor;

import com.google.common.base.Objects;
import implementation.Block;
import implementation.If;
import implementation.Statement;
import java.util.List;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import parser.XtdAQLBaseVisitor;
import parser.XtdAQLParser;
import parser.visitor.BlockVisitor;
import parser.visitor.ModelBuilder;

@SuppressWarnings("all")
public class StatementVisitor extends XtdAQLBaseVisitor<Statement> {
  @Override
  public Statement visitRVarDecl(final XtdAQLParser.RVarDeclContext ctx) {
    TerminalNode _Ident = ctx.Ident(1);
    String _text = _Ident.getText();
    XtdAQLParser.ExpressionContext _expression = ctx.expression();
    String _text_1 = _expression.getText();
    TerminalNode _Ident_1 = ctx.Ident(0);
    String _text_2 = _Ident_1.getText();
    return ModelBuilder.singleton.buildVariableDecl(_text, _text_1, _text_2);
  }
  
  @Override
  public Statement visitRAssign(final XtdAQLParser.RAssignContext ctx) {
    List<XtdAQLParser.ExpressionContext> _expression = ctx.expression();
    final XtdAQLParser.ExpressionContext left = _expression.get(0);
    List<XtdAQLParser.ExpressionContext> _expression_1 = ctx.expression();
    XtdAQLParser.ExpressionContext _get = _expression_1.get(1);
    final String value = _get.getText();
    if ((left instanceof XtdAQLParser.VarRefContext)) {
      TerminalNode _Ident = ((XtdAQLParser.VarRefContext)left).Ident();
      String _text = _Ident.getText();
      return ModelBuilder.singleton.buildVariableAssignement(_text, value);
    } else {
      if ((left instanceof XtdAQLParser.NavContext)) {
        final XtdAQLParser.NavigationSegmentContext navSegment = ((XtdAQLParser.NavContext)left).navigationSegment();
        if ((navSegment instanceof XtdAQLParser.FeatureContext)) {
          TerminalNode _Ident_1 = ((XtdAQLParser.FeatureContext)navSegment).Ident();
          final String feature = _Ident_1.getText();
          XtdAQLParser.ExpressionContext _expression_2 = ((XtdAQLParser.NavContext)left).expression();
          final String target = _expression_2.getText();
          return ModelBuilder.singleton.buildFeatureAssign(target, feature, value);
        }
      }
    }
    String _text_1 = left.getText();
    return ModelBuilder.singleton.buildVariableAssignement(_text_1, value);
  }
  
  @Override
  public Statement visitRIf(final XtdAQLParser.RIfContext ctx) {
    If _xblockexpression = null;
    {
      XtdAQLParser.ExpressionContext _expression = ctx.expression();
      final String cond = _expression.getText();
      BlockVisitor _blockVisitor = new BlockVisitor();
      List<XtdAQLParser.RBlockContext> _rBlock = ctx.rBlock();
      XtdAQLParser.RBlockContext _head = IterableExtensions.<XtdAQLParser.RBlockContext>head(_rBlock);
      final Block then = _blockVisitor.visit(_head);
      Block _xifexpression = null;
      List<XtdAQLParser.RBlockContext> _rBlock_1 = ctx.rBlock();
      int _size = _rBlock_1.size();
      boolean _greaterThan = (_size > 1);
      if (_greaterThan) {
        BlockVisitor _blockVisitor_1 = new BlockVisitor();
        List<XtdAQLParser.RBlockContext> _rBlock_2 = ctx.rBlock();
        XtdAQLParser.RBlockContext _get = _rBlock_2.get(1);
        _xifexpression = _blockVisitor_1.visit(_get);
      } else {
        _xifexpression = null;
      }
      final Block elseB = _xifexpression;
      _xblockexpression = ModelBuilder.singleton.buildIf(cond, then, elseB);
    }
    return _xblockexpression;
  }
  
  @Override
  public Statement visitRForEach(final XtdAQLParser.RForEachContext ctx) {
    BlockVisitor _blockVisitor = new BlockVisitor();
    XtdAQLParser.RBlockContext _rBlock = ctx.rBlock();
    final Block body = _blockVisitor.visit(_rBlock);
    TerminalNode _Ident = ctx.Ident();
    String _text = _Ident.getText();
    XtdAQLParser.ExpressionContext _expression = ctx.expression();
    String _text_1 = _expression.getText();
    return ModelBuilder.singleton.buildForEach(_text, _text_1, body);
  }
  
  @Override
  public Statement visitRWhile(final XtdAQLParser.RWhileContext ctx) {
    BlockVisitor _blockVisitor = new BlockVisitor();
    XtdAQLParser.RBlockContext _rBlock = ctx.rBlock();
    final Block body = _blockVisitor.visit(_rBlock);
    XtdAQLParser.ExpressionContext _expression = ctx.expression();
    String _text = _expression.getText();
    return ModelBuilder.singleton.buildWhile(_text, body);
  }
  
  @Override
  public Statement visitRExpression(final XtdAQLParser.RExpressionContext ctx) {
    final XtdAQLParser.ExpressionContext exp = ctx.expression();
    if ((exp instanceof XtdAQLParser.NavContext)) {
      final XtdAQLParser.NavigationSegmentContext navSegment = ((XtdAQLParser.NavContext)exp).navigationSegment();
      if ((navSegment instanceof XtdAQLParser.CallOrApplyContext)) {
        final XtdAQLParser.CallExpContext call = ((XtdAQLParser.CallOrApplyContext)navSegment).callExp();
        if ((call instanceof XtdAQLParser.ServiceCallContext)) {
          TerminalNode _Ident = ((XtdAQLParser.ServiceCallContext)call).Ident();
          final String serviceName = _Ident.getText();
          String target = "";
          String feature = "";
          final XtdAQLParser.ExpressionContext beforeCall = ((XtdAQLParser.NavContext)exp).expression();
          if ((beforeCall instanceof XtdAQLParser.NavContext)) {
            final XtdAQLParser.NavigationSegmentContext featurePart = ((XtdAQLParser.NavContext)beforeCall).navigationSegment();
            if ((featurePart instanceof XtdAQLParser.FeatureContext)) {
              TerminalNode _Ident_1 = ((XtdAQLParser.FeatureContext)featurePart).Ident();
              String _text = _Ident_1.getText();
              feature = _text;
              XtdAQLParser.ExpressionContext _expression = ((XtdAQLParser.NavContext)beforeCall).expression();
              String _text_1 = _expression.getText();
              target = _text_1;
            }
          }
          XtdAQLParser.ExpressionSequenceContext _expressionSequence = ((XtdAQLParser.ServiceCallContext)call).expressionSequence();
          final List<XtdAQLParser.ExpressionContext> params = _expressionSequence.expression();
          if ((Objects.equal(serviceName, "add") && (params.size() == 1))) {
            XtdAQLParser.ExpressionContext _get = params.get(0);
            String _text_2 = _get.getText();
            return ModelBuilder.singleton.buildFeatureInsert(target, feature, _text_2);
          } else {
            if ((Objects.equal(serviceName, "remove") && (params.size() == 1))) {
              XtdAQLParser.ExpressionContext _get_1 = params.get(0);
              String _text_3 = _get_1.getText();
              return ModelBuilder.singleton.buildFeatureRemove(target, feature, _text_3);
            } else {
              if ((Objects.equal(serviceName, "put") && (params.size() == 2))) {
                XtdAQLParser.ExpressionContext _get_2 = params.get(0);
                String _text_4 = _get_2.getText();
                XtdAQLParser.ExpressionContext _get_3 = params.get(1);
                String _text_5 = _get_3.getText();
                return ModelBuilder.singleton.buildFeaturePut(target, feature, _text_4, _text_5);
              }
            }
          }
        }
      }
    }
    String _text_6 = exp.getText();
    return ModelBuilder.singleton.buildExpression(_text_6);
  }
}
