// Generated from ALE.g4 by ANTLR 4.7.1

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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ALEParser}.
 */
public interface ALEListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ALEParser#rRoot}.
	 * @param ctx the parse tree
	 */
	void enterRRoot(ALEParser.RRootContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rRoot}.
	 * @param ctx the parse tree
	 */
	void exitRRoot(ALEParser.RRootContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rImport}.
	 * @param ctx the parse tree
	 */
	void enterRImport(ALEParser.RImportContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rImport}.
	 * @param ctx the parse tree
	 */
	void exitRImport(ALEParser.RImportContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rService}.
	 * @param ctx the parse tree
	 */
	void enterRService(ALEParser.RServiceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rService}.
	 * @param ctx the parse tree
	 */
	void exitRService(ALEParser.RServiceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rClass}.
	 * @param ctx the parse tree
	 */
	void enterRClass(ALEParser.RClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rClass}.
	 * @param ctx the parse tree
	 */
	void exitRClass(ALEParser.RClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rOpenClass}.
	 * @param ctx the parse tree
	 */
	void enterROpenClass(ALEParser.ROpenClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rOpenClass}.
	 * @param ctx the parse tree
	 */
	void exitROpenClass(ALEParser.ROpenClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rNewClass}.
	 * @param ctx the parse tree
	 */
	void enterRNewClass(ALEParser.RNewClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rNewClass}.
	 * @param ctx the parse tree
	 */
	void exitRNewClass(ALEParser.RNewClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rOperation}.
	 * @param ctx the parse tree
	 */
	void enterROperation(ALEParser.ROperationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rOperation}.
	 * @param ctx the parse tree
	 */
	void exitROperation(ALEParser.ROperationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rTag}.
	 * @param ctx the parse tree
	 */
	void enterRTag(ALEParser.RTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rTag}.
	 * @param ctx the parse tree
	 */
	void exitRTag(ALEParser.RTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rParameters}.
	 * @param ctx the parse tree
	 */
	void enterRParameters(ALEParser.RParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rParameters}.
	 * @param ctx the parse tree
	 */
	void exitRParameters(ALEParser.RParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rVariable}.
	 * @param ctx the parse tree
	 */
	void enterRVariable(ALEParser.RVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rVariable}.
	 * @param ctx the parse tree
	 */
	void exitRVariable(ALEParser.RVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rAttribute}.
	 * @param ctx the parse tree
	 */
	void enterRAttribute(ALEParser.RAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rAttribute}.
	 * @param ctx the parse tree
	 */
	void exitRAttribute(ALEParser.RAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rCardinality}.
	 * @param ctx the parse tree
	 */
	void enterRCardinality(ALEParser.RCardinalityContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rCardinality}.
	 * @param ctx the parse tree
	 */
	void exitRCardinality(ALEParser.RCardinalityContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rOpposite}.
	 * @param ctx the parse tree
	 */
	void enterROpposite(ALEParser.ROppositeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rOpposite}.
	 * @param ctx the parse tree
	 */
	void exitROpposite(ALEParser.ROppositeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void enterRStatement(ALEParser.RStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rStatement}.
	 * @param ctx the parse tree
	 */
	void exitRStatement(ALEParser.RStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rVarDecl}.
	 * @param ctx the parse tree
	 */
	void enterRVarDecl(ALEParser.RVarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rVarDecl}.
	 * @param ctx the parse tree
	 */
	void exitRVarDecl(ALEParser.RVarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rAssign}.
	 * @param ctx the parse tree
	 */
	void enterRAssign(ALEParser.RAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rAssign}.
	 * @param ctx the parse tree
	 */
	void exitRAssign(ALEParser.RAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rInsert}.
	 * @param ctx the parse tree
	 */
	void enterRInsert(ALEParser.RInsertContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rInsert}.
	 * @param ctx the parse tree
	 */
	void exitRInsert(ALEParser.RInsertContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rRemove}.
	 * @param ctx the parse tree
	 */
	void enterRRemove(ALEParser.RRemoveContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rRemove}.
	 * @param ctx the parse tree
	 */
	void exitRRemove(ALEParser.RRemoveContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rForEach}.
	 * @param ctx the parse tree
	 */
	void enterRForEach(ALEParser.RForEachContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rForEach}.
	 * @param ctx the parse tree
	 */
	void exitRForEach(ALEParser.RForEachContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rCollection}.
	 * @param ctx the parse tree
	 */
	void enterRCollection(ALEParser.RCollectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rCollection}.
	 * @param ctx the parse tree
	 */
	void exitRCollection(ALEParser.RCollectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rBlock}.
	 * @param ctx the parse tree
	 */
	void enterRBlock(ALEParser.RBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rBlock}.
	 * @param ctx the parse tree
	 */
	void exitRBlock(ALEParser.RBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rIf}.
	 * @param ctx the parse tree
	 */
	void enterRIf(ALEParser.RIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rIf}.
	 * @param ctx the parse tree
	 */
	void exitRIf(ALEParser.RIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rWhile}.
	 * @param ctx the parse tree
	 */
	void enterRWhile(ALEParser.RWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rWhile}.
	 * @param ctx the parse tree
	 */
	void exitRWhile(ALEParser.RWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rExpressionStmt}.
	 * @param ctx the parse tree
	 */
	void enterRExpressionStmt(ALEParser.RExpressionStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rExpressionStmt}.
	 * @param ctx the parse tree
	 */
	void exitRExpressionStmt(ALEParser.RExpressionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void enterRExpression(ALEParser.RExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rExpression}.
	 * @param ctx the parse tree
	 */
	void exitRExpression(ALEParser.RExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rType}.
	 * @param ctx the parse tree
	 */
	void enterRType(ALEParser.RTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rType}.
	 * @param ctx the parse tree
	 */
	void exitRType(ALEParser.RTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rQualified}.
	 * @param ctx the parse tree
	 */
	void enterRQualified(ALEParser.RQualifiedContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rQualified}.
	 * @param ctx the parse tree
	 */
	void exitRQualified(ALEParser.RQualifiedContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rSwitch}.
	 * @param ctx the parse tree
	 */
	void enterRSwitch(ALEParser.RSwitchContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rSwitch}.
	 * @param ctx the parse tree
	 */
	void exitRSwitch(ALEParser.RSwitchContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#rCase}.
	 * @param ctx the parse tree
	 */
	void enterRCase(ALEParser.RCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#rCase}.
	 * @param ctx the parse tree
	 */
	void exitRCase(ALEParser.RCaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVarRef(ALEParser.VarRefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VarRef}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVarRef(ALEParser.VarRefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdd(ALEParser.AddContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Add}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdd(ALEParser.AddContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Nav}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNav(ALEParser.NavContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Nav}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNav(ALEParser.NavContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Or}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOr(ALEParser.OrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Or}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOr(ALEParser.OrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLetExpr(ALEParser.LetExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LetExpr}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLetExpr(ALEParser.LetExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterConditional(ALEParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Conditional}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitConditional(ALEParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComp(ALEParser.CompContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comp}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComp(ALEParser.CompContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNot(ALEParser.NotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Not}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNot(ALEParser.NotContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Min}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMin(ALEParser.MinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Min}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMin(ALEParser.MinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImplies(ALEParser.ImpliesContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Implies}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImplies(ALEParser.ImpliesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMult(ALEParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Mult}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMult(ALEParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLit(ALEParser.LitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Lit}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLit(ALEParser.LitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code And}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd(ALEParser.AndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code And}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd(ALEParser.AndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Xor}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterXor(ALEParser.XorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Xor}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitXor(ALEParser.XorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParen(ALEParser.ParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Paren}
	 * labeled alternative in {@link ALEParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParen(ALEParser.ParenContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#binding}.
	 * @param ctx the parse tree
	 */
	void enterBinding(ALEParser.BindingContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#binding}.
	 * @param ctx the parse tree
	 */
	void exitBinding(ALEParser.BindingContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#addOp}.
	 * @param ctx the parse tree
	 */
	void enterAddOp(ALEParser.AddOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#addOp}.
	 * @param ctx the parse tree
	 */
	void exitAddOp(ALEParser.AddOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(ALEParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(ALEParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void enterFeature(ALEParser.FeatureContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Feature}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void exitFeature(ALEParser.FeatureContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallOrApply}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void enterCallOrApply(ALEParser.CallOrApplyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallOrApply}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void exitCallOrApply(ALEParser.CallOrApplyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CollectionCall}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void enterCollectionCall(ALEParser.CollectionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CollectionCall}
	 * labeled alternative in {@link ALEParser#navigationSegment}.
	 * @param ctx the parse tree
	 */
	void exitCollectionCall(ALEParser.CollectionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IterationCall}
	 * labeled alternative in {@link ALEParser#callExp}.
	 * @param ctx the parse tree
	 */
	void enterIterationCall(ALEParser.IterationCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IterationCall}
	 * labeled alternative in {@link ALEParser#callExp}.
	 * @param ctx the parse tree
	 */
	void exitIterationCall(ALEParser.IterationCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ServiceCall}
	 * labeled alternative in {@link ALEParser#callExp}.
	 * @param ctx the parse tree
	 */
	void enterServiceCall(ALEParser.ServiceCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ServiceCall}
	 * labeled alternative in {@link ALEParser#callExp}.
	 * @param ctx the parse tree
	 */
	void exitServiceCall(ALEParser.ServiceCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(ALEParser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(ALEParser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#collectionIterator}.
	 * @param ctx the parse tree
	 */
	void enterCollectionIterator(ALEParser.CollectionIteratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#collectionIterator}.
	 * @param ctx the parse tree
	 */
	void exitCollectionIterator(ALEParser.CollectionIteratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void enterExpressionSequence(ALEParser.ExpressionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void exitExpressionSequence(ALEParser.ExpressionSequenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ALEParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void enterVariableDefinition(ALEParser.VariableDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ALEParser#variableDefinition}.
	 * @param ctx the parse tree
	 */
	void exitVariableDefinition(ALEParser.VariableDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLit(ALEParser.StringLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLit(ALEParser.StringLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ErrorStringLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterErrorStringLit(ALEParser.ErrorStringLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ErrorStringLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitErrorStringLit(ALEParser.ErrorStringLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLit(ALEParser.IntegerLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLit(ALEParser.IntegerLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RealLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterRealLit(ALEParser.RealLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitRealLit(ALEParser.RealLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TrueLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterTrueLit(ALEParser.TrueLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TrueLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitTrueLit(ALEParser.TrueLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FalseLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterFalseLit(ALEParser.FalseLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FalseLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitFalseLit(ALEParser.FalseLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NullLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNullLit(ALEParser.NullLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNullLit(ALEParser.NullLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExplicitSeqLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterExplicitSeqLit(ALEParser.ExplicitSeqLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExplicitSeqLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitExplicitSeqLit(ALEParser.ExplicitSeqLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExplicitSetLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterExplicitSetLit(ALEParser.ExplicitSetLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExplicitSetLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitExplicitSetLit(ALEParser.ExplicitSetLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EnumLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterEnumLit(ALEParser.EnumLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EnumLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitEnumLit(ALEParser.EnumLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ErrorEnumLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterErrorEnumLit(ALEParser.ErrorEnumLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ErrorEnumLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitErrorEnumLit(ALEParser.ErrorEnumLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterTypeLit(ALEParser.TypeLitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeLit}
	 * labeled alternative in {@link ALEParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitTypeLit(ALEParser.TypeLitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StrType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterStrType(ALEParser.StrTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StrType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitStrType(ALEParser.StrTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterIntType(ALEParser.IntTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitIntType(ALEParser.IntTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RealType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterRealType(ALEParser.RealTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RealType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitRealType(ALEParser.RealTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBooleanType(ALEParser.BooleanTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBooleanType(ALEParser.BooleanTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SeqType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSeqType(ALEParser.SeqTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SeqType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSeqType(ALEParser.SeqTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterSetType(ALEParser.SetTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitSetType(ALEParser.SetTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClsType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterClsType(ALEParser.ClsTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClsType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitClsType(ALEParser.ClsTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassifierSetType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void enterClassifierSetType(ALEParser.ClassifierSetTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassifierSetType}
	 * labeled alternative in {@link ALEParser#typeLiteral}.
	 * @param ctx the parse tree
	 */
	void exitClassifierSetType(ALEParser.ClassifierSetTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassifierType}
	 * labeled alternative in {@link ALEParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 */
	void enterClassifierType(ALEParser.ClassifierTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassifierType}
	 * labeled alternative in {@link ALEParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 */
	void exitClassifierType(ALEParser.ClassifierTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ErrorClassifierType}
	 * labeled alternative in {@link ALEParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 */
	void enterErrorClassifierType(ALEParser.ErrorClassifierTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ErrorClassifierType}
	 * labeled alternative in {@link ALEParser#classifierTypeRule}.
	 * @param ctx the parse tree
	 */
	void exitErrorClassifierType(ALEParser.ErrorClassifierTypeContext ctx);
}