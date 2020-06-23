// Generated from Query.g4 by ANTLR 4.7.1
package org.eclipse.emf.ecoretools.ale.core.parser;

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
	 * Visit a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(QueryParser.VarRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(QueryParser.AddContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Nav}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNav(QueryParser.NavContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(QueryParser.OrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetExpr(QueryParser.LetExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(QueryParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(QueryParser.CompContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(QueryParser.NotContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Min}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMin(QueryParser.MinContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplies(QueryParser.ImpliesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(QueryParser.MultContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLit(QueryParser.LitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(QueryParser.AndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Xor}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXor(QueryParser.XorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link QueryParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(QueryParser.ParenContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#binding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinding(QueryParser.BindingContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(QueryParser.AddOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(QueryParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link QueryParser#navigationSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(QueryParser.FeatureContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallOrApply}
	 * labeled alternative in {@link QueryParser#navigationSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallOrApply(QueryParser.CallOrApplyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CollectionCall}
	 * labeled alternative in {@link QueryParser#navigationSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionCall(QueryParser.CollectionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IterationCall}
	 * labeled alternative in {@link QueryParser#callExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationCall(QueryParser.IterationCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ServiceCall}
	 * labeled alternative in {@link QueryParser#callExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceCall(QueryParser.ServiceCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(QueryParser.LambdaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#collectionIterator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionIterator(QueryParser.CollectionIteratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#expressionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSequence(QueryParser.ExpressionSequenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link QueryParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(QueryParser.VariableDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLit(QueryParser.StringLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ErrorStringLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorStringLit(QueryParser.ErrorStringLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntegerLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLit(QueryParser.IntegerLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RealLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealLit(QueryParser.RealLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TrueLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLit(QueryParser.TrueLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FalseLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLit(QueryParser.FalseLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NullLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLit(QueryParser.NullLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExplicitSeqLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitSeqLit(QueryParser.ExplicitSeqLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExplicitSetLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitSetLit(QueryParser.ExplicitSetLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EnumLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumLit(QueryParser.EnumLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ErrorEnumLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorEnumLit(QueryParser.ErrorEnumLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeLit}
	 * labeled alternative in {@link QueryParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeLit(QueryParser.TypeLitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StrType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrType(QueryParser.StrTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(QueryParser.IntTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RealType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealType(QueryParser.RealTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanType(QueryParser.BooleanTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SeqType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqType(QueryParser.SeqTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetType(QueryParser.SetTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClsType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClsType(QueryParser.ClsTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassifierSetType}
	 * labeled alternative in {@link QueryParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassifierSetType(QueryParser.ClassifierSetTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassifierType}
	 * labeled alternative in {@link QueryParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassifierType(QueryParser.ClassifierTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ErrorClassifierType}
	 * labeled alternative in {@link QueryParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorClassifierType(QueryParser.ErrorClassifierTypeContext ctx);
}