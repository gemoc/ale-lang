// Generated from ALE.g4 by ANTLR 4.3

/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ALEParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ALEVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd(@NotNull ALEParser.AddContext ctx);

	/**
	 * Visit a parse tree produced by the {@code NullLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLit(@NotNull ALEParser.NullLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Nav}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNav(@NotNull ALEParser.NavContext ctx);

	/**
	 * Visit a parse tree produced by the {@code TypeLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeLit(@NotNull ALEParser.TypeLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr(@NotNull ALEParser.OrContext ctx);

	/**
	 * Visit a parse tree produced by the {@code CallOrApply}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallOrApply(@NotNull ALEParser.CallOrApplyContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ErrorEnumLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorEnumLit(@NotNull ALEParser.ErrorEnumLitContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#binding}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinding(@NotNull ALEParser.BindingContext ctx);

	/**
	 * Visit a parse tree produced by the {@code FalseLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseLit(@NotNull ALEParser.FalseLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(@NotNull ALEParser.ConditionalContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFeature(@NotNull ALEParser.FeatureContext ctx);

	/**
	 * Visit a parse tree produced by the {@code RealType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealType(@NotNull ALEParser.RealTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rQualified}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRQualified(@NotNull ALEParser.RQualifiedContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRExpression(@NotNull ALEParser.RExpressionContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComp(@NotNull ALEParser.CompContext ctx);

	/**
	 * Visit a parse tree produced by the {@code StringLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLit(@NotNull ALEParser.StringLitContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rForEach}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRForEach(@NotNull ALEParser.RForEachContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplies(@NotNull ALEParser.ImpliesContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rVarDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRVarDecl(@NotNull ALEParser.RVarDeclContext ctx);

	/**
	 * Visit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetType(@NotNull ALEParser.SetTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#collectionIterator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionIterator(@NotNull ALEParser.CollectionIteratorContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rNewClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRNewClass(@NotNull ALEParser.RNewClassContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rRoot}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRRoot(@NotNull ALEParser.RRootContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rService}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRService(@NotNull ALEParser.RServiceContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rSwitch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRSwitch(@NotNull ALEParser.RSwitchContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRType(@NotNull ALEParser.RTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#lambdaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaExpression(@NotNull ALEParser.LambdaExpressionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRAttribute(@NotNull ALEParser.RAttributeContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRCase(@NotNull ALEParser.RCaseContext ctx);

	/**
	 * Visit a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetExpr(@NotNull ALEParser.LetExprContext ctx);

	/**
	 * Visit a parse tree produced by the {@code IntegerLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLit(@NotNull ALEParser.IntegerLitContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#variableDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDefinition(@NotNull ALEParser.VariableDefinitionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRIf(@NotNull ALEParser.RIfContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ClassifierSetType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassifierSetType(@NotNull ALEParser.ClassifierSetTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNot(@NotNull ALEParser.NotContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Min}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMin(@NotNull ALEParser.MinContext ctx);

	/**
	 * Visit a parse tree produced by the {@code And}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd(@NotNull ALEParser.AndContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Xor}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXor(@NotNull ALEParser.XorContext ctx);

	/**
	 * Visit a parse tree produced by the {@code TrueLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueLit(@NotNull ALEParser.TrueLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ExplicitSeqLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitSeqLit(@NotNull ALEParser.ExplicitSeqLitContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rOpenClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitROpenClass(@NotNull ALEParser.ROpenClassContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRStatement(@NotNull ALEParser.RStatementContext ctx);

	/**
	 * Visit a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(@NotNull ALEParser.VarRefContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ClassifierType}
	 * labeled alternative in {@link ALEParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassifierType(@NotNull ALEParser.ClassifierTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code SeqType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqType(@NotNull ALEParser.SeqTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRClass(@NotNull ALEParser.RClassContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#expressionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSequence(@NotNull ALEParser.ExpressionSequenceContext ctx);

	/**
	 * Visit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntType(@NotNull ALEParser.IntTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code EnumLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumLit(@NotNull ALEParser.EnumLitContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitROperation(@NotNull ALEParser.ROperationContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRVariable(@NotNull ALEParser.RVariableContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rOpposite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitROpposite(@NotNull ALEParser.ROppositeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code RealLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealLit(@NotNull ALEParser.RealLitContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rCardinality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRCardinality(@NotNull ALEParser.RCardinalityContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ExplicitSetLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitSetLit(@NotNull ALEParser.ExplicitSetLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ErrorClassifierType}
	 * labeled alternative in {@link ALEParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorClassifierType(@NotNull ALEParser.ErrorClassifierTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rWhile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRWhile(@NotNull ALEParser.RWhileContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ServiceCall}
	 * labeled alternative in {@link ALEParser#callExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitServiceCall(@NotNull ALEParser.ServiceCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRBlock(@NotNull ALEParser.RBlockContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#addOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddOp(@NotNull ALEParser.AddOpContext ctx);

	/**
	 * Visit a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanType(@NotNull ALEParser.BooleanTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ClsType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClsType(@NotNull ALEParser.ClsTypeContext ctx);

	/**
	 * Visit a parse tree produced by the {@code StrType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrType(@NotNull ALEParser.StrTypeContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rCollection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRCollection(@NotNull ALEParser.RCollectionContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(@NotNull ALEParser.CompOpContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMult(@NotNull ALEParser.MultContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rExpressionStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRExpressionStmt(@NotNull ALEParser.RExpressionStmtContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLit(@NotNull ALEParser.LitContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRAssign(@NotNull ALEParser.RAssignContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rImport}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRImport(@NotNull ALEParser.RImportContext ctx);

	/**
	 * Visit a parse tree produced by the {@code CollectionCall}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionCall(@NotNull ALEParser.CollectionCallContext ctx);

	/**
	 * Visit a parse tree produced by the {@code IterationCall}
	 * labeled alternative in {@link ALEParser#callExp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationCall(@NotNull ALEParser.IterationCallContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRTag(@NotNull ALEParser.RTagContext ctx);

	/**
	 * Visit a parse tree produced by {@link ALEParser#rParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRParameters(@NotNull ALEParser.RParametersContext ctx);

	/**
	 * Visit a parse tree produced by the {@code ErrorStringLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorStringLit(@NotNull ALEParser.ErrorStringLitContext ctx);

	/**
	 * Visit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParen(@NotNull ALEParser.ParenContext ctx);
}