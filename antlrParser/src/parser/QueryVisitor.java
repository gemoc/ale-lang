// Generated from Query.g4 by ANTLR 4.3
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
 * by {@link QueryParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface QueryVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(@NotNull QueryParser.AddContext ctx);

	/**
	 * Visit a parse tree produced by the {@code NullLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLit(@NotNull QueryParser.NullLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Nav}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNav(@NotNull QueryParser.NavContext ctx);

	/**
	 * Visit a parse tree produced by the {@code TypeLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeLit(@NotNull QueryParser.TypeLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull QueryParser.OrContext ctx);

	/**
	 * Visit a parse tree produced by the {@code CallOrApply}
	 * labeled alternative in {@link QueryParser#navigationSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallOrApply(@NotNull QueryParser.CallOrApplyContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ErrorEnumLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorEnumLit(@NotNull QueryParser.ErrorEnumLitContext ctx);

	/**
	 * Visit a parse tree produced by {@link QueryParser#binding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinding(@NotNull QueryParser.BindingContext ctx);

	/**
	 * Visit a parse tree produced by the {@code FalseLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLit(@NotNull QueryParser.FalseLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(@NotNull QueryParser.ConditionalContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link QueryParser#navigationSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(@NotNull QueryParser.FeatureContext ctx);

	/**
	 * Visit a parse tree produced by the {@code RealType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealType(@NotNull QueryParser.RealTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(@NotNull QueryParser.CompContext ctx);

	/**
	 * Visit a parse tree produced by the {@code StringLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLit(@NotNull QueryParser.StringLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplies(@NotNull QueryParser.ImpliesContext ctx);

	/**
	 * Visit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetType(@NotNull QueryParser.SetTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link QueryParser#collectionIterator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionIterator(@NotNull QueryParser.CollectionIteratorContext ctx);

	/**
	 * Visit a parse tree produced by {@link QueryParser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(@NotNull QueryParser.LambdaExpressionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetExpr(@NotNull QueryParser.LetExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code IntegerLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLit(@NotNull QueryParser.IntegerLitContext ctx);

	/**
	 * Visit a parse tree produced by {@link QueryParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(@NotNull QueryParser.VariableDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ClassifierSetType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassifierSetType(@NotNull QueryParser.ClassifierSetTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(@NotNull QueryParser.NotContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Min}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMin(@NotNull QueryParser.MinContext ctx);

	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull QueryParser.AndContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Xor}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXor(@NotNull QueryParser.XorContext ctx);

	/**
	 * Visit a parse tree produced by the {@code TrueLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLit(@NotNull QueryParser.TrueLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ExplicitSeqLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitSeqLit(@NotNull QueryParser.ExplicitSeqLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(@NotNull QueryParser.VarRefContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ClassifierType}
	 * labeled alternative in {@link QueryParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassifierType(@NotNull QueryParser.ClassifierTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code SeqType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqType(@NotNull QueryParser.SeqTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link QueryParser#expressionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSequence(@NotNull QueryParser.ExpressionSequenceContext ctx);

	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(@NotNull QueryParser.IntTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code EnumLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumLit(@NotNull QueryParser.EnumLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code RealLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealLit(@NotNull QueryParser.RealLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ExplicitSetLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitSetLit(@NotNull QueryParser.ExplicitSetLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ErrorClassifierType}
	 * labeled alternative in {@link QueryParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorClassifierType(@NotNull QueryParser.ErrorClassifierTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ServiceCall}
	 * labeled alternative in {@link QueryParser#callExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceCall(@NotNull QueryParser.ServiceCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link QueryParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(@NotNull QueryParser.AddOpContext ctx);

	/**
	 * Visit a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanType(@NotNull QueryParser.BooleanTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ClsType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClsType(@NotNull QueryParser.ClsTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code StrType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrType(@NotNull QueryParser.StrTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link QueryParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(@NotNull QueryParser.CompOpContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(@NotNull QueryParser.MultContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLit(@NotNull QueryParser.LitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code CollectionCall}
	 * labeled alternative in {@link QueryParser#navigationSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionCall(@NotNull QueryParser.CollectionCallContext ctx);

	/**
	 * Visit a parse tree produced by the {@code IterationCall}
	 * labeled alternative in {@link QueryParser#callExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationCall(@NotNull QueryParser.IterationCallContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ErrorStringLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorStringLit(@NotNull QueryParser.ErrorStringLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(@NotNull QueryParser.ParenContext ctx);
}