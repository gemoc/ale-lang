// Generated from XtdAQL.g4 by ANTLR 4.3
package parser;

/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/

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
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(@NotNull XtdAQLParser.AddContext ctx);

	/**
	 * Visit a parse tree produced by the {@code NullLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLit(@NotNull XtdAQLParser.NullLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Nav}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNav(@NotNull XtdAQLParser.NavContext ctx);

	/**
	 * Visit a parse tree produced by the {@code TypeLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeLit(@NotNull XtdAQLParser.TypeLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull XtdAQLParser.OrContext ctx);

	/**
	 * Visit a parse tree produced by the {@code CallOrApply}
	 * labeled alternative in {@link XtdAQLParser#navigationSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallOrApply(@NotNull XtdAQLParser.CallOrApplyContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ErrorEnumLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorEnumLit(@NotNull XtdAQLParser.ErrorEnumLitContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#binding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinding(@NotNull XtdAQLParser.BindingContext ctx);

	/**
	 * Visit a parse tree produced by the {@code FalseLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLit(@NotNull XtdAQLParser.FalseLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(@NotNull XtdAQLParser.ConditionalContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link XtdAQLParser#navigationSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(@NotNull XtdAQLParser.FeatureContext ctx);

	/**
	 * Visit a parse tree produced by the {@code RealType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealType(@NotNull XtdAQLParser.RealTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRExpression(@NotNull XtdAQLParser.RExpressionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(@NotNull XtdAQLParser.CompContext ctx);

	/**
	 * Visit a parse tree produced by the {@code StringLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLit(@NotNull XtdAQLParser.StringLitContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rForEach}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRForEach(@NotNull XtdAQLParser.RForEachContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplies(@NotNull XtdAQLParser.ImpliesContext ctx);

	/**
	 * Visit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetType(@NotNull XtdAQLParser.SetTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#collectionIterator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionIterator(@NotNull XtdAQLParser.CollectionIteratorContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rRoot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRRoot(@NotNull XtdAQLParser.RRootContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(@NotNull XtdAQLParser.LambdaExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRAttribute(@NotNull XtdAQLParser.RAttributeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetExpr(@NotNull XtdAQLParser.LetExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code IntegerLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLit(@NotNull XtdAQLParser.IntegerLitContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(@NotNull XtdAQLParser.VariableDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRIf(@NotNull XtdAQLParser.RIfContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ClassifierSetType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassifierSetType(@NotNull XtdAQLParser.ClassifierSetTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(@NotNull XtdAQLParser.NotContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Min}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMin(@NotNull XtdAQLParser.MinContext ctx);

	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull XtdAQLParser.AndContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Xor}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXor(@NotNull XtdAQLParser.XorContext ctx);

	/**
	 * Visit a parse tree produced by the {@code TrueLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLit(@NotNull XtdAQLParser.TrueLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ExplicitSeqLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitSeqLit(@NotNull XtdAQLParser.ExplicitSeqLitContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRStatement(@NotNull XtdAQLParser.RStatementContext ctx);

	/**
	 * Visit a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(@NotNull XtdAQLParser.VarRefContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ClassifierType}
	 * labeled alternative in {@link XtdAQLParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassifierType(@NotNull XtdAQLParser.ClassifierTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code SeqType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqType(@NotNull XtdAQLParser.SeqTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRClass(@NotNull XtdAQLParser.RClassContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#expressionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSequence(@NotNull XtdAQLParser.ExpressionSequenceContext ctx);

	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(@NotNull XtdAQLParser.IntTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code EnumLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumLit(@NotNull XtdAQLParser.EnumLitContext ctx);

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
	 * Visit a parse tree produced by the {@code RealLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealLit(@NotNull XtdAQLParser.RealLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ExplicitSetLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitSetLit(@NotNull XtdAQLParser.ExplicitSetLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ErrorClassifierType}
	 * labeled alternative in {@link XtdAQLParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorClassifierType(@NotNull XtdAQLParser.ErrorClassifierTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRWhile(@NotNull XtdAQLParser.RWhileContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ServiceCall}
	 * labeled alternative in {@link XtdAQLParser#callExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceCall(@NotNull XtdAQLParser.ServiceCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRBlock(@NotNull XtdAQLParser.RBlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(@NotNull XtdAQLParser.AddOpContext ctx);

	/**
	 * Visit a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanType(@NotNull XtdAQLParser.BooleanTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ClsType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClsType(@NotNull XtdAQLParser.ClsTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code StrType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrType(@NotNull XtdAQLParser.StrTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(@NotNull XtdAQLParser.CompOpContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(@NotNull XtdAQLParser.MultContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLit(@NotNull XtdAQLParser.LitContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRAssign(@NotNull XtdAQLParser.RAssignContext ctx);

	/**
	 * Visit a parse tree produced by the {@code CollectionCall}
	 * labeled alternative in {@link XtdAQLParser#navigationSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionCall(@NotNull XtdAQLParser.CollectionCallContext ctx);

	/**
	 * Visit a parse tree produced by the {@code IterationCall}
	 * labeled alternative in {@link XtdAQLParser#callExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationCall(@NotNull XtdAQLParser.IterationCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link XtdAQLParser#rParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRParameters(@NotNull XtdAQLParser.RParametersContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ErrorStringLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorStringLit(@NotNull XtdAQLParser.ErrorStringLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(@NotNull XtdAQLParser.ParenContext ctx);
}