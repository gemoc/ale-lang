// Generated from XtdAQL.g4 by ANTLR 4.3
package parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XtdAQLParser}.
 */
public interface XtdAQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rRemove}.
	 * @param ctx the parse tree
	 */
	void enterRRemove(@NotNull XtdAQLParser.RRemoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rRemove}.
	 * @param ctx the parse tree
	 */
	void exitRRemove(@NotNull XtdAQLParser.RRemoveContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Set}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void enterSet(@NotNull XtdAQLParser.SetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Set}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void exitSet(@NotNull XtdAQLParser.SetContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rSet}.
	 * @param ctx the parse tree
	 */
	void enterRSet(@NotNull XtdAQLParser.RSetContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rSet}.
	 * @param ctx the parse tree
	 */
	void exitRSet(@NotNull XtdAQLParser.RSetContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rBlock}.
	 * @param ctx the parse tree
	 */
	void enterRBlock(@NotNull XtdAQLParser.RBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rBlock}.
	 * @param ctx the parse tree
	 */
	void exitRBlock(@NotNull XtdAQLParser.RBlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rPut}.
	 * @param ctx the parse tree
	 */
	void enterRPut(@NotNull XtdAQLParser.RPutContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rPut}.
	 * @param ctx the parse tree
	 */
	void exitRPut(@NotNull XtdAQLParser.RPutContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Remove}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void enterRemove(@NotNull XtdAQLParser.RemoveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Remove}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void exitRemove(@NotNull XtdAQLParser.RemoveContext ctx);

	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhile(@NotNull XtdAQLParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhile(@NotNull XtdAQLParser.WhileContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Insert}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void enterInsert(@NotNull XtdAQLParser.InsertContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Insert}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void exitInsert(@NotNull XtdAQLParser.InsertContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rClass}.
	 * @param ctx the parse tree
	 */
	void enterRClass(@NotNull XtdAQLParser.RClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rClass}.
	 * @param ctx the parse tree
	 */
	void exitRClass(@NotNull XtdAQLParser.RClassContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Put}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void enterPut(@NotNull XtdAQLParser.PutContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Put}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void exitPut(@NotNull XtdAQLParser.PutContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rIf}.
	 * @param ctx the parse tree
	 */
	void enterRIf(@NotNull XtdAQLParser.RIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rIf}.
	 * @param ctx the parse tree
	 */
	void exitRIf(@NotNull XtdAQLParser.RIfContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ForEach}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void enterForEach(@NotNull XtdAQLParser.ForEachContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForEach}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void exitForEach(@NotNull XtdAQLParser.ForEachContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rForEach}.
	 * @param ctx the parse tree
	 */
	void enterRForEach(@NotNull XtdAQLParser.RForEachContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rForEach}.
	 * @param ctx the parse tree
	 */
	void exitRForEach(@NotNull XtdAQLParser.RForEachContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rOperation}.
	 * @param ctx the parse tree
	 */
	void enterROperation(@NotNull XtdAQLParser.ROperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rOperation}.
	 * @param ctx the parse tree
	 */
	void exitROperation(@NotNull XtdAQLParser.ROperationContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rVariable}.
	 * @param ctx the parse tree
	 */
	void enterRVariable(@NotNull XtdAQLParser.RVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rVariable}.
	 * @param ctx the parse tree
	 */
	void exitRVariable(@NotNull XtdAQLParser.RVariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rImports}.
	 * @param ctx the parse tree
	 */
	void enterRImports(@NotNull XtdAQLParser.RImportsContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rImports}.
	 * @param ctx the parse tree
	 */
	void exitRImports(@NotNull XtdAQLParser.RImportsContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rInsert}.
	 * @param ctx the parse tree
	 */
	void enterRInsert(@NotNull XtdAQLParser.RInsertContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rInsert}.
	 * @param ctx the parse tree
	 */
	void exitRInsert(@NotNull XtdAQLParser.RInsertContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rRoot}.
	 * @param ctx the parse tree
	 */
	void enterRRoot(@NotNull XtdAQLParser.RRootContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rRoot}.
	 * @param ctx the parse tree
	 */
	void exitRRoot(@NotNull XtdAQLParser.RRootContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssign(@NotNull XtdAQLParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssign(@NotNull XtdAQLParser.AssignContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rAssign}.
	 * @param ctx the parse tree
	 */
	void enterRAssign(@NotNull XtdAQLParser.RAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rAssign}.
	 * @param ctx the parse tree
	 */
	void exitRAssign(@NotNull XtdAQLParser.RAssignContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Exp}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void enterExp(@NotNull XtdAQLParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Exp}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void exitExp(@NotNull XtdAQLParser.ExpContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rWhile}.
	 * @param ctx the parse tree
	 */
	void enterRWhile(@NotNull XtdAQLParser.RWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rWhile}.
	 * @param ctx the parse tree
	 */
	void exitRWhile(@NotNull XtdAQLParser.RWhileContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rParameters}.
	 * @param ctx the parse tree
	 */
	void enterRParameters(@NotNull XtdAQLParser.RParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rParameters}.
	 * @param ctx the parse tree
	 */
	void exitRParameters(@NotNull XtdAQLParser.RParametersContext ctx);

	/**
	 * Enter a parse tree produced by the {@code If}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void enterIf(@NotNull XtdAQLParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code If}
	 * labeled alternative in {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void exitIf(@NotNull XtdAQLParser.IfContext ctx);
}