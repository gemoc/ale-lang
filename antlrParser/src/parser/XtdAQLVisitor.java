// Generated from XtdAQL.g4 by ANTLR 4.3
package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link XtdAQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface XtdAQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rRemove}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRRemove(@NotNull XtdAQLParser.RRemoveContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Set}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet(@NotNull XtdAQLParser.SetContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rSet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRSet(@NotNull XtdAQLParser.RSetContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRBlock(@NotNull XtdAQLParser.RBlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rPut}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRPut(@NotNull XtdAQLParser.RPutContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Remove}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRemove(@NotNull XtdAQLParser.RemoveContext ctx);

	/**
	 * Visit a parse tree produced by the {@code While}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(@NotNull XtdAQLParser.WhileContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Insert}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert(@NotNull XtdAQLParser.InsertContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRClass(@NotNull XtdAQLParser.RClassContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Put}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPut(@NotNull XtdAQLParser.PutContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRIf(@NotNull XtdAQLParser.RIfContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ForEach}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForEach(@NotNull XtdAQLParser.ForEachContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rForEach}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRForEach(@NotNull XtdAQLParser.RForEachContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitROperation(@NotNull XtdAQLParser.ROperationContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRVariable(@NotNull XtdAQLParser.RVariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rImports}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRImports(@NotNull XtdAQLParser.RImportsContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rInsert}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRInsert(@NotNull XtdAQLParser.RInsertContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rRoot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRRoot(@NotNull XtdAQLParser.RRootContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(@NotNull XtdAQLParser.AssignContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRAssign(@NotNull XtdAQLParser.RAssignContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Exp}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(@NotNull XtdAQLParser.ExpContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRWhile(@NotNull XtdAQLParser.RWhileContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRParameters(@NotNull XtdAQLParser.RParametersContext ctx);

	/**
	 * Visit a parse tree produced by the {@code If}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(@NotNull XtdAQLParser.IfContext ctx);
}