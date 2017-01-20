package parser.visitor;

import implementation.Block;
import implementation.Statement;
import java.util.List;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import parser.XtdAQLBaseVisitor;
import parser.XtdAQLParser;
import parser.visitor.ModelBuilder;
import parser.visitor.StatementVisitor;

@SuppressWarnings("all")
public class BlockVisitor extends XtdAQLBaseVisitor<Block> {
  @Override
  public Block visitRBlock(final XtdAQLParser.RBlockContext ctx) {
    Block _xblockexpression = null;
    {
      final StatementVisitor subVisitor = new StatementVisitor();
      List<XtdAQLParser.RStatementContext> _rStatement = ctx.rStatement();
      final Function1<XtdAQLParser.RStatementContext, Statement> _function = (XtdAQLParser.RStatementContext it) -> {
        return subVisitor.visit(it);
      };
      final List<Statement> body = ListExtensions.<XtdAQLParser.RStatementContext, Statement>map(_rStatement, _function);
      _xblockexpression = ModelBuilder.singleton.buildBlock(body);
    }
    return _xblockexpression;
  }
}
