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
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ALEParser}.
 */
public interface ALEListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd(@NotNull ALEParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd(@NotNull ALEParser.AddContext ctx);

	/**
	 * Enter a parse tree produced by the {@code NullLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNullLit(@NotNull ALEParser.NullLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNullLit(@NotNull ALEParser.NullLitContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Nav}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNav(@NotNull ALEParser.NavContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Nav}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNav(@NotNull ALEParser.NavContext ctx);

	/**
	 * Enter a parse tree produced by the {@code TypeLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterTypeLit(@NotNull ALEParser.TypeLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitTypeLit(@NotNull ALEParser.TypeLitContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull ALEParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull ALEParser.OrContext ctx);

	/**
	 * Enter a parse tree produced by the {@code CallOrApply}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void enterCallOrApply(@NotNull ALEParser.CallOrApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallOrApply}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void exitCallOrApply(@NotNull ALEParser.CallOrApplyContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ErrorEnumLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterErrorEnumLit(@NotNull ALEParser.ErrorEnumLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ErrorEnumLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitErrorEnumLit(@NotNull ALEParser.ErrorEnumLitContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterBinding(@NotNull ALEParser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitBinding(@NotNull ALEParser.BindingContext ctx);

	/**
	 * Enter a parse tree produced by the {@code FalseLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterFalseLit(@NotNull ALEParser.FalseLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitFalseLit(@NotNull ALEParser.FalseLitContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditional(@NotNull ALEParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditional(@NotNull ALEParser.ConditionalContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void enterFeature(@NotNull ALEParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void exitFeature(@NotNull ALEParser.FeatureContext ctx);

	/**
	 * Enter a parse tree produced by the {@code RealType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterRealType(@NotNull ALEParser.RealTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitRealType(@NotNull ALEParser.RealTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rQualified}.
	 * @param ctx the parse tree
	 */
	void enterRQualified(@NotNull ALEParser.RQualifiedContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rQualified}.
	 * @param ctx the parse tree
	 */
	void exitRQualified(@NotNull ALEParser.RQualifiedContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterRExpression(@NotNull ALEParser.RExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitRExpression(@NotNull ALEParser.RExpressionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComp(@NotNull ALEParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComp(@NotNull ALEParser.CompContext ctx);

	/**
	 * Enter a parse tree produced by the {@code StringLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLit(@NotNull ALEParser.StringLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLit(@NotNull ALEParser.StringLitContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rForEach}.
	 * @param ctx the parse tree
	 */
	void enterRForEach(@NotNull ALEParser.RForEachContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rForEach}.
	 * @param ctx the parse tree
	 */
	void exitRForEach(@NotNull ALEParser.RForEachContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImplies(@NotNull ALEParser.ImpliesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImplies(@NotNull ALEParser.ImpliesContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterRVarDecl(@NotNull ALEParser.RVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitRVarDecl(@NotNull ALEParser.RVarDeclContext ctx);

	/**
	 * Enter a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSetType(@NotNull ALEParser.SetTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSetType(@NotNull ALEParser.SetTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#collectionIterator}.
	 * @param ctx the parse tree
	 */
	void enterCollectionIterator(@NotNull ALEParser.CollectionIteratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#collectionIterator}.
	 * @param ctx the parse tree
	 */
	void exitCollectionIterator(@NotNull ALEParser.CollectionIteratorContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rNewClass}.
	 * @param ctx the parse tree
	 */
	void enterRNewClass(@NotNull ALEParser.RNewClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rNewClass}.
	 * @param ctx the parse tree
	 */
	void exitRNewClass(@NotNull ALEParser.RNewClassContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rRoot}.
	 * @param ctx the parse tree
	 */
	void enterRRoot(@NotNull ALEParser.RRootContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rRoot}.
	 * @param ctx the parse tree
	 */
	void exitRRoot(@NotNull ALEParser.RRootContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rService}.
	 * @param ctx the parse tree
	 */
	void enterRService(@NotNull ALEParser.RServiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rService}.
	 * @param ctx the parse tree
	 */
	void exitRService(@NotNull ALEParser.RServiceContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rSwitch}.
	 * @param ctx the parse tree
	 */
	void enterRSwitch(@NotNull ALEParser.RSwitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rSwitch}.
	 * @param ctx the parse tree
	 */
	void exitRSwitch(@NotNull ALEParser.RSwitchContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rType}.
	 * @param ctx the parse tree
	 */
	void enterRType(@NotNull ALEParser.RTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rType}.
	 * @param ctx the parse tree
	 */
	void exitRType(@NotNull ALEParser.RTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(@NotNull ALEParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(@NotNull ALEParser.LambdaExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rAttribute}.
	 * @param ctx the parse tree
	 */
	void enterRAttribute(@NotNull ALEParser.RAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rAttribute}.
	 * @param ctx the parse tree
	 */
	void exitRAttribute(@NotNull ALEParser.RAttributeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rCase}.
	 * @param ctx the parse tree
	 */
	void enterRCase(@NotNull ALEParser.RCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rCase}.
	 * @param ctx the parse tree
	 */
	void exitRCase(@NotNull ALEParser.RCaseContext ctx);

	/**
	 * Enter a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLetExpr(@NotNull ALEParser.LetExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLetExpr(@NotNull ALEParser.LetExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code IntegerLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLit(@NotNull ALEParser.IntegerLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLit(@NotNull ALEParser.IntegerLitContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(@NotNull ALEParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(@NotNull ALEParser.VariableDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rIf}.
	 * @param ctx the parse tree
	 */
	void enterRIf(@NotNull ALEParser.RIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rIf}.
	 * @param ctx the parse tree
	 */
	void exitRIf(@NotNull ALEParser.RIfContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ClassifierSetType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterClassifierSetType(@NotNull ALEParser.ClassifierSetTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassifierSetType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitClassifierSetType(@NotNull ALEParser.ClassifierSetTypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNot(@NotNull ALEParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNot(@NotNull ALEParser.NotContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Min}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMin(@NotNull ALEParser.MinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Min}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMin(@NotNull ALEParser.MinContext ctx);

	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull ALEParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull ALEParser.AndContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Xor}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterXor(@NotNull ALEParser.XorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Xor}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitXor(@NotNull ALEParser.XorContext ctx);

	/**
	 * Enter a parse tree produced by the {@code TrueLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterTrueLit(@NotNull ALEParser.TrueLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitTrueLit(@NotNull ALEParser.TrueLitContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ExplicitSeqLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterExplicitSeqLit(@NotNull ALEParser.ExplicitSeqLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExplicitSeqLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitExplicitSeqLit(@NotNull ALEParser.ExplicitSeqLitContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rOpenClass}.
	 * @param ctx the parse tree
	 */
	void enterROpenClass(@NotNull ALEParser.ROpenClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rOpenClass}.
	 * @param ctx the parse tree
	 */
	void exitROpenClass(@NotNull ALEParser.ROpenClassContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void enterRStatement(@NotNull ALEParser.RStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void exitRStatement(@NotNull ALEParser.RStatementContext ctx);

	/**
	 * Enter a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(@NotNull ALEParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(@NotNull ALEParser.VarRefContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ClassifierType}
	 * labeled alternative in {@link ALEParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 */
	void enterClassifierType(@NotNull ALEParser.ClassifierTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassifierType}
	 * labeled alternative in {@link ALEParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 */
	void exitClassifierType(@NotNull ALEParser.ClassifierTypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code SeqType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSeqType(@NotNull ALEParser.SeqTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SeqType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSeqType(@NotNull ALEParser.SeqTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rClass}.
	 * @param ctx the parse tree
	 */
	void enterRClass(@NotNull ALEParser.RClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rClass}.
	 * @param ctx the parse tree
	 */
	void exitRClass(@NotNull ALEParser.RClassContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void enterExpressionSequence(@NotNull ALEParser.ExpressionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void exitExpressionSequence(@NotNull ALEParser.ExpressionSequenceContext ctx);

	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntType(@NotNull ALEParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntType(@NotNull ALEParser.IntTypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code EnumLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterEnumLit(@NotNull ALEParser.EnumLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EnumLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitEnumLit(@NotNull ALEParser.EnumLitContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rOperation}.
	 * @param ctx the parse tree
	 */
	void enterROperation(@NotNull ALEParser.ROperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rOperation}.
	 * @param ctx the parse tree
	 */
	void exitROperation(@NotNull ALEParser.ROperationContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rVariable}.
	 * @param ctx the parse tree
	 */
	void enterRVariable(@NotNull ALEParser.RVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rVariable}.
	 * @param ctx the parse tree
	 */
	void exitRVariable(@NotNull ALEParser.RVariableContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rOpposite}.
	 * @param ctx the parse tree
	 */
	void enterROpposite(@NotNull ALEParser.ROppositeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rOpposite}.
	 * @param ctx the parse tree
	 */
	void exitROpposite(@NotNull ALEParser.ROppositeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code RealLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterRealLit(@NotNull ALEParser.RealLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitRealLit(@NotNull ALEParser.RealLitContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rCardinality}.
	 * @param ctx the parse tree
	 */
	void enterRCardinality(@NotNull ALEParser.RCardinalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rCardinality}.
	 * @param ctx the parse tree
	 */
	void exitRCardinality(@NotNull ALEParser.RCardinalityContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ExplicitSetLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterExplicitSetLit(@NotNull ALEParser.ExplicitSetLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExplicitSetLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitExplicitSetLit(@NotNull ALEParser.ExplicitSetLitContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ErrorClassifierType}
	 * labeled alternative in {@link ALEParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 */
	void enterErrorClassifierType(@NotNull ALEParser.ErrorClassifierTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ErrorClassifierType}
	 * labeled alternative in {@link ALEParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 */
	void exitErrorClassifierType(@NotNull ALEParser.ErrorClassifierTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rWhile}.
	 * @param ctx the parse tree
	 */
	void enterRWhile(@NotNull ALEParser.RWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rWhile}.
	 * @param ctx the parse tree
	 */
	void exitRWhile(@NotNull ALEParser.RWhileContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ServiceCall}
	 * labeled alternative in {@link ALEParser#callExp}.
	 * @param ctx the parse tree
	 */
	void enterServiceCall(@NotNull ALEParser.ServiceCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ServiceCall}
	 * labeled alternative in {@link ALEParser#callExp}.
	 * @param ctx the parse tree
	 */
	void exitServiceCall(@NotNull ALEParser.ServiceCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rBlock}.
	 * @param ctx the parse tree
	 */
	void enterRBlock(@NotNull ALEParser.RBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rBlock}.
	 * @param ctx the parse tree
	 */
	void exitRBlock(@NotNull ALEParser.RBlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(@NotNull ALEParser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(@NotNull ALEParser.AddOpContext ctx);

	/**
	 * Enter a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanType(@NotNull ALEParser.BooleanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanType(@NotNull ALEParser.BooleanTypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ClsType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterClsType(@NotNull ALEParser.ClsTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClsType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitClsType(@NotNull ALEParser.ClsTypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code StrType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStrType(@NotNull ALEParser.StrTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StrType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStrType(@NotNull ALEParser.StrTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rCollection}.
	 * @param ctx the parse tree
	 */
	void enterRCollection(@NotNull ALEParser.RCollectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rCollection}.
	 * @param ctx the parse tree
	 */
	void exitRCollection(@NotNull ALEParser.RCollectionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(@NotNull ALEParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(@NotNull ALEParser.CompOpContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMult(@NotNull ALEParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMult(@NotNull ALEParser.MultContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rExpressionStmt}.
	 * @param ctx the parse tree
	 */
	void enterRExpressionStmt(@NotNull ALEParser.RExpressionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rExpressionStmt}.
	 * @param ctx the parse tree
	 */
	void exitRExpressionStmt(@NotNull ALEParser.RExpressionStmtContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLit(@NotNull ALEParser.LitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLit(@NotNull ALEParser.LitContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rAssign}.
	 * @param ctx the parse tree
	 */
	void enterRAssign(@NotNull ALEParser.RAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rAssign}.
	 * @param ctx the parse tree
	 */
	void exitRAssign(@NotNull ALEParser.RAssignContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rImport}.
	 * @param ctx the parse tree
	 */
	void enterRImport(@NotNull ALEParser.RImportContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rImport}.
	 * @param ctx the parse tree
	 */
	void exitRImport(@NotNull ALEParser.RImportContext ctx);

	/**
	 * Enter a parse tree produced by the {@code CollectionCall}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void enterCollectionCall(@NotNull ALEParser.CollectionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CollectionCall}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void exitCollectionCall(@NotNull ALEParser.CollectionCallContext ctx);

	/**
	 * Enter a parse tree produced by the {@code IterationCall}
	 * labeled alternative in {@link ALEParser#callExp}.
	 * @param ctx the parse tree
	 */
	void enterIterationCall(@NotNull ALEParser.IterationCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IterationCall}
	 * labeled alternative in {@link ALEParser#callExp}.
	 * @param ctx the parse tree
	 */
	void exitIterationCall(@NotNull ALEParser.IterationCallContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rTag}.
	 * @param ctx the parse tree
	 */
	void enterRTag(@NotNull ALEParser.RTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rTag}.
	 * @param ctx the parse tree
	 */
	void exitRTag(@NotNull ALEParser.RTagContext ctx);

	/**
	 * Enter a parse tree produced by {@link ALEParser#rParameters}.
	 * @param ctx the parse tree
	 */
	void enterRParameters(@NotNull ALEParser.RParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rParameters}.
	 * @param ctx the parse tree
	 */
	void exitRParameters(@NotNull ALEParser.RParametersContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ErrorStringLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterErrorStringLit(@NotNull ALEParser.ErrorStringLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ErrorStringLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitErrorStringLit(@NotNull ALEParser.ErrorStringLitContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParen(@NotNull ALEParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParen(@NotNull ALEParser.ParenContext ctx);
}