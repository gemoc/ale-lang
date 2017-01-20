package parser.visitor;

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
  public Statement visitRAssign(final XtdAQLParser.RAssignContext ctx) {
    TerminalNode _ID = ctx.ID();
    String _text = _ID.getText();
    TerminalNode _Expression = ctx.Expression();
    String _text_1 = _Expression.getText();
    return ModelBuilder.singleton.buildVariableDecl(_text, _text_1);
  }
  
  @Override
  public Statement visitRIf(final XtdAQLParser.RIfContext ctx) {
    If _xblockexpression = null;
    {
      TerminalNode _Expression = ctx.Expression();
      final String cond = _Expression.getText();
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
    TerminalNode _ID = ctx.ID();
    String _text = _ID.getText();
    TerminalNode _Expression = ctx.Expression();
    String _text_1 = _Expression.getText();
    return ModelBuilder.singleton.buildForEach(_text, _text_1, body);
  }
  
  @Override
  public Statement visitRWhile(final XtdAQLParser.RWhileContext ctx) {
    BlockVisitor _blockVisitor = new BlockVisitor();
    XtdAQLParser.RBlockContext _rBlock = ctx.rBlock();
    final Block body = _blockVisitor.visit(_rBlock);
    TerminalNode _Expression = ctx.Expression();
    String _text = _Expression.getText();
    return ModelBuilder.singleton.buildWhile(_text, body);
  }
  
  @Override
  public Statement visitRSet(final XtdAQLParser.RSetContext ctx) {
    List<TerminalNode> _Expression = ctx.Expression();
    TerminalNode _get = _Expression.get(0);
    final String target = _get.getText();
    TerminalNode _ID = ctx.ID();
    final String feature = _ID.getText();
    List<TerminalNode> _Expression_1 = ctx.Expression();
    TerminalNode _get_1 = _Expression_1.get(1);
    final String value = _get_1.getText();
    return ModelBuilder.singleton.buildFeatureAssign(target, feature, value);
  }
  
  @Override
  public Statement visitRInsert(final XtdAQLParser.RInsertContext ctx) {
    List<TerminalNode> _Expression = ctx.Expression();
    TerminalNode _get = _Expression.get(0);
    final String target = _get.getText();
    TerminalNode _ID = ctx.ID();
    final String feature = _ID.getText();
    List<TerminalNode> _Expression_1 = ctx.Expression();
    TerminalNode _get_1 = _Expression_1.get(1);
    final String value = _get_1.getText();
    return ModelBuilder.singleton.buildFeatureInsert(target, feature, value);
  }
  
  @Override
  public Statement visitRRemove(final XtdAQLParser.RRemoveContext ctx) {
    List<TerminalNode> _Expression = ctx.Expression();
    TerminalNode _get = _Expression.get(0);
    final String target = _get.getText();
    TerminalNode _ID = ctx.ID();
    final String feature = _ID.getText();
    List<TerminalNode> _Expression_1 = ctx.Expression();
    TerminalNode _get_1 = _Expression_1.get(1);
    final String value = _get_1.getText();
    return ModelBuilder.singleton.buildFeatureRemove(target, feature, value);
  }
  
  @Override
  public Statement visitRPut(final XtdAQLParser.RPutContext ctx) {
    List<TerminalNode> _Expression = ctx.Expression();
    TerminalNode _get = _Expression.get(0);
    final String target = _get.getText();
    TerminalNode _ID = ctx.ID();
    final String feature = _ID.getText();
    List<TerminalNode> _Expression_1 = ctx.Expression();
    TerminalNode _get_1 = _Expression_1.get(1);
    final String key = _get_1.getText();
    List<TerminalNode> _Expression_2 = ctx.Expression();
    TerminalNode _get_2 = _Expression_2.get(2);
    final String value = _get_2.getText();
    return ModelBuilder.singleton.buildFeaturePut(target, feature, key, value);
  }
  
  @Override
  public Statement visitExp(final XtdAQLParser.ExpContext ctx) {
    TerminalNode _Expression = ctx.Expression();
    String _text = _Expression.getText();
    return ModelBuilder.singleton.buildExpression(_text);
  }
}
