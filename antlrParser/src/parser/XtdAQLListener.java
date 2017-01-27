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
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link XtdAQLParser}.
 */
public interface XtdAQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd(@NotNull XtdAQLParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd(@NotNull XtdAQLParser.AddContext ctx);

	/**
	 * Enter a parse tree produced by the {@code NullLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNullLit(@NotNull XtdAQLParser.NullLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNullLit(@NotNull XtdAQLParser.NullLitContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Nav}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNav(@NotNull XtdAQLParser.NavContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Nav}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNav(@NotNull XtdAQLParser.NavContext ctx);

	/**
	 * Enter a parse tree produced by the {@code TypeLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterTypeLit(@NotNull XtdAQLParser.TypeLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitTypeLit(@NotNull XtdAQLParser.TypeLitContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOr(@NotNull XtdAQLParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOr(@NotNull XtdAQLParser.OrContext ctx);

	/**
	 * Enter a parse tree produced by the {@code CallOrApply}
	 * labeled alternative in {@link XtdAQLParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void enterCallOrApply(@NotNull XtdAQLParser.CallOrApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallOrApply}
	 * labeled alternative in {@link XtdAQLParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void exitCallOrApply(@NotNull XtdAQLParser.CallOrApplyContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ErrorEnumLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterErrorEnumLit(@NotNull XtdAQLParser.ErrorEnumLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ErrorEnumLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitErrorEnumLit(@NotNull XtdAQLParser.ErrorEnumLitContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterBinding(@NotNull XtdAQLParser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitBinding(@NotNull XtdAQLParser.BindingContext ctx);

	/**
	 * Enter a parse tree produced by the {@code FalseLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterFalseLit(@NotNull XtdAQLParser.FalseLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitFalseLit(@NotNull XtdAQLParser.FalseLitContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditional(@NotNull XtdAQLParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditional(@NotNull XtdAQLParser.ConditionalContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link XtdAQLParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void enterFeature(@NotNull XtdAQLParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link XtdAQLParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void exitFeature(@NotNull XtdAQLParser.FeatureContext ctx);

	/**
	 * Enter a parse tree produced by the {@code RealType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterRealType(@NotNull XtdAQLParser.RealTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitRealType(@NotNull XtdAQLParser.RealTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterRExpression(@NotNull XtdAQLParser.RExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitRExpression(@NotNull XtdAQLParser.RExpressionContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComp(@NotNull XtdAQLParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComp(@NotNull XtdAQLParser.CompContext ctx);

	/**
	 * Enter a parse tree produced by the {@code StringLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLit(@NotNull XtdAQLParser.StringLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLit(@NotNull XtdAQLParser.StringLitContext ctx);

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
	 * Enter a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImplies(@NotNull XtdAQLParser.ImpliesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImplies(@NotNull XtdAQLParser.ImpliesContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterRVarDecl(@NotNull XtdAQLParser.RVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitRVarDecl(@NotNull XtdAQLParser.RVarDeclContext ctx);

	/**
	 * Enter a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSetType(@NotNull XtdAQLParser.SetTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSetType(@NotNull XtdAQLParser.SetTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#collectionIterator}.
	 * @param ctx the parse tree
	 */
	void enterCollectionIterator(@NotNull XtdAQLParser.CollectionIteratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#collectionIterator}.
	 * @param ctx the parse tree
	 */
	void exitCollectionIterator(@NotNull XtdAQLParser.CollectionIteratorContext ctx);

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
	 * Enter a parse tree produced by {@link XtdAQLParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(@NotNull XtdAQLParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(@NotNull XtdAQLParser.LambdaExpressionContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rAttribute}.
	 * @param ctx the parse tree
	 */
	void enterRAttribute(@NotNull XtdAQLParser.RAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rAttribute}.
	 * @param ctx the parse tree
	 */
	void exitRAttribute(@NotNull XtdAQLParser.RAttributeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLetExpr(@NotNull XtdAQLParser.LetExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLetExpr(@NotNull XtdAQLParser.LetExprContext ctx);

	/**
	 * Enter a parse tree produced by the {@code IntegerLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLit(@NotNull XtdAQLParser.IntegerLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLit(@NotNull XtdAQLParser.IntegerLitContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(@NotNull XtdAQLParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(@NotNull XtdAQLParser.VariableDefinitionContext ctx);

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
	 * Enter a parse tree produced by the {@code ClassifierSetType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterClassifierSetType(@NotNull XtdAQLParser.ClassifierSetTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassifierSetType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitClassifierSetType(@NotNull XtdAQLParser.ClassifierSetTypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNot(@NotNull XtdAQLParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNot(@NotNull XtdAQLParser.NotContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Min}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMin(@NotNull XtdAQLParser.MinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Min}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMin(@NotNull XtdAQLParser.MinContext ctx);

	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(@NotNull XtdAQLParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(@NotNull XtdAQLParser.AndContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Xor}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterXor(@NotNull XtdAQLParser.XorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Xor}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitXor(@NotNull XtdAQLParser.XorContext ctx);

	/**
	 * Enter a parse tree produced by the {@code TrueLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterTrueLit(@NotNull XtdAQLParser.TrueLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitTrueLit(@NotNull XtdAQLParser.TrueLitContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ExplicitSeqLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterExplicitSeqLit(@NotNull XtdAQLParser.ExplicitSeqLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExplicitSeqLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitExplicitSeqLit(@NotNull XtdAQLParser.ExplicitSeqLitContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void enterRStatement(@NotNull XtdAQLParser.RStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void exitRStatement(@NotNull XtdAQLParser.RStatementContext ctx);

	/**
	 * Enter a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(@NotNull XtdAQLParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(@NotNull XtdAQLParser.VarRefContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ClassifierType}
	 * labeled alternative in {@link XtdAQLParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 */
	void enterClassifierType(@NotNull XtdAQLParser.ClassifierTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassifierType}
	 * labeled alternative in {@link XtdAQLParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 */
	void exitClassifierType(@NotNull XtdAQLParser.ClassifierTypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code SeqType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSeqType(@NotNull XtdAQLParser.SeqTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SeqType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSeqType(@NotNull XtdAQLParser.SeqTypeContext ctx);

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
	 * Enter a parse tree produced by {@link XtdAQLParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void enterExpressionSequence(@NotNull XtdAQLParser.ExpressionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void exitExpressionSequence(@NotNull XtdAQLParser.ExpressionSequenceContext ctx);

	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntType(@NotNull XtdAQLParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntType(@NotNull XtdAQLParser.IntTypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code EnumLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterEnumLit(@NotNull XtdAQLParser.EnumLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EnumLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitEnumLit(@NotNull XtdAQLParser.EnumLitContext ctx);

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
	 * Enter a parse tree produced by the {@code RealLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterRealLit(@NotNull XtdAQLParser.RealLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitRealLit(@NotNull XtdAQLParser.RealLitContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ExplicitSetLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterExplicitSetLit(@NotNull XtdAQLParser.ExplicitSetLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExplicitSetLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitExplicitSetLit(@NotNull XtdAQLParser.ExplicitSetLitContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ErrorClassifierType}
	 * labeled alternative in {@link XtdAQLParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 */
	void enterErrorClassifierType(@NotNull XtdAQLParser.ErrorClassifierTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ErrorClassifierType}
	 * labeled alternative in {@link XtdAQLParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 */
	void exitErrorClassifierType(@NotNull XtdAQLParser.ErrorClassifierTypeContext ctx);

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
	 * Enter a parse tree produced by the {@code ServiceCall}
	 * labeled alternative in {@link XtdAQLParser#callExp}.
	 * @param ctx the parse tree
	 */
	void enterServiceCall(@NotNull XtdAQLParser.ServiceCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ServiceCall}
	 * labeled alternative in {@link XtdAQLParser#callExp}.
	 * @param ctx the parse tree
	 */
	void exitServiceCall(@NotNull XtdAQLParser.ServiceCallContext ctx);

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
	 * Enter a parse tree produced by {@link XtdAQLParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(@NotNull XtdAQLParser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(@NotNull XtdAQLParser.AddOpContext ctx);

	/**
	 * Enter a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanType(@NotNull XtdAQLParser.BooleanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanType(@NotNull XtdAQLParser.BooleanTypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code ClsType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterClsType(@NotNull XtdAQLParser.ClsTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClsType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitClsType(@NotNull XtdAQLParser.ClsTypeContext ctx);

	/**
	 * Enter a parse tree produced by the {@code StrType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStrType(@NotNull XtdAQLParser.StrTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StrType}
	 * labeled alternative in {@link XtdAQLParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStrType(@NotNull XtdAQLParser.StrTypeContext ctx);

	/**
	 * Enter a parse tree produced by {@link XtdAQLParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(@NotNull XtdAQLParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link XtdAQLParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(@NotNull XtdAQLParser.CompOpContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMult(@NotNull XtdAQLParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMult(@NotNull XtdAQLParser.MultContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLit(@NotNull XtdAQLParser.LitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLit(@NotNull XtdAQLParser.LitContext ctx);

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
	 * Enter a parse tree produced by the {@code CollectionCall}
	 * labeled alternative in {@link XtdAQLParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void enterCollectionCall(@NotNull XtdAQLParser.CollectionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CollectionCall}
	 * labeled alternative in {@link XtdAQLParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void exitCollectionCall(@NotNull XtdAQLParser.CollectionCallContext ctx);

	/**
	 * Enter a parse tree produced by the {@code IterationCall}
	 * labeled alternative in {@link XtdAQLParser#callExp}.
	 * @param ctx the parse tree
	 */
	void enterIterationCall(@NotNull XtdAQLParser.IterationCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IterationCall}
	 * labeled alternative in {@link XtdAQLParser#callExp}.
	 * @param ctx the parse tree
	 */
	void exitIterationCall(@NotNull XtdAQLParser.IterationCallContext ctx);

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
	 * Enter a parse tree produced by the {@code ErrorStringLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterErrorStringLit(@NotNull XtdAQLParser.ErrorStringLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ErrorStringLit}
	 * labeled alternative in {@link XtdAQLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitErrorStringLit(@NotNull XtdAQLParser.ErrorStringLitContext ctx);

	/**
	 * Enter a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParen(@NotNull XtdAQLParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link XtdAQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParen(@NotNull XtdAQLParser.ParenContext ctx);
}