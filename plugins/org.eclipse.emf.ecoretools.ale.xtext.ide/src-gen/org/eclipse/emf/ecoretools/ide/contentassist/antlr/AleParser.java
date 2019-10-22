/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *
 * generated by Xtext 2.14.0
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.eclipse.emf.ecoretools.ide.contentassist.antlr.internal.InternalAleParser;
import org.eclipse.emf.ecoretools.services.AleGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class AleParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(AleGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, AleGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getRClassAccess().getAlternatives(), "rule__RClass__Alternatives");
			builder.put(grammarAccess.getROperationAccess().getAlternatives_1(), "rule__ROperation__Alternatives_1");
			builder.put(grammarAccess.getRAttributeAccess().getModifierAlternatives_0_0(), "rule__RAttribute__ModifierAlternatives_0_0");
			builder.put(grammarAccess.getRCardinalityAccess().getAlternatives_2(), "rule__RCardinality__Alternatives_2");
			builder.put(grammarAccess.getRSimpleStatementAccess().getAlternatives(), "rule__RSimpleStatement__Alternatives");
			builder.put(grammarAccess.getRBlockStatementAccess().getAlternatives(), "rule__RBlockStatement__Alternatives");
			builder.put(grammarAccess.getRCollectionAccess().getAlternatives(), "rule__RCollection__Alternatives");
			builder.put(grammarAccess.getRBlockAccess().getAlternatives_2_0(), "rule__RBlock__Alternatives_2_0");
			builder.put(grammarAccess.getRBlockAccess().getAlternatives_2_1(), "rule__RBlock__Alternatives_2_1");
			builder.put(grammarAccess.getRIfAccess().getAlternatives_5_1(), "rule__RIf__Alternatives_5_1");
			builder.put(grammarAccess.getRExpressionAccess().getExpAlternatives_0(), "rule__RExpression__ExpAlternatives_0");
			builder.put(grammarAccess.getExpressionAccess().getAlternatives_1(), "rule__Expression__Alternatives_1");
			builder.put(grammarAccess.getExpressionAccess().getAlternatives_1_2_2(), "rule__Expression__Alternatives_1_2_2");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getAlternatives(), "rule__NonLeftRecExpression__Alternatives");
			builder.put(grammarAccess.getAddOpAccess().getAlternatives(), "rule__AddOp__Alternatives");
			builder.put(grammarAccess.getCompOpAccess().getAlternatives(), "rule__CompOp__Alternatives");
			builder.put(grammarAccess.getCollectionIteratorAccess().getAlternatives(), "rule__CollectionIterator__Alternatives");
			builder.put(grammarAccess.getLiteralAccess().getAlternatives(), "rule__Literal__Alternatives");
			builder.put(grammarAccess.getTypeLiteralAccess().getAlternatives(), "rule__TypeLiteral__Alternatives");
			builder.put(grammarAccess.getRTypeAccess().getAlternatives(), "rule__RType__Alternatives");
			builder.put(grammarAccess.getRRootAccess().getGroup(), "rule__RRoot__Group__0");
			builder.put(grammarAccess.getRImportAccess().getGroup(), "rule__RImport__Group__0");
			builder.put(grammarAccess.getRServiceAccess().getGroup(), "rule__RService__Group__0");
			builder.put(grammarAccess.getROpenClassAccess().getGroup(), "rule__ROpenClass__Group__0");
			builder.put(grammarAccess.getROpenClassAccess().getGroup_3(), "rule__ROpenClass__Group_3__0");
			builder.put(grammarAccess.getROpenClassAccess().getGroup_3_2(), "rule__ROpenClass__Group_3_2__0");
			builder.put(grammarAccess.getRNewClassAccess().getGroup(), "rule__RNewClass__Group__0");
			builder.put(grammarAccess.getROperationAccess().getGroup(), "rule__ROperation__Group__0");
			builder.put(grammarAccess.getROperationAccess().getGroup_5(), "rule__ROperation__Group_5__0");
			builder.put(grammarAccess.getROperationAccess().getGroup_5_1(), "rule__ROperation__Group_5_1__0");
			builder.put(grammarAccess.getRTagAccess().getGroup(), "rule__RTag__Group__0");
			builder.put(grammarAccess.getRVariableAccess().getGroup(), "rule__RVariable__Group__0");
			builder.put(grammarAccess.getRAttributeAccess().getGroup(), "rule__RAttribute__Group__0");
			builder.put(grammarAccess.getRAttributeAccess().getGroup_5(), "rule__RAttribute__Group_5__0");
			builder.put(grammarAccess.getRCardinalityAccess().getGroup(), "rule__RCardinality__Group__0");
			builder.put(grammarAccess.getROppositeAccess().getGroup(), "rule__ROpposite__Group__0");
			builder.put(grammarAccess.getRVarDeclAccess().getGroup(), "rule__RVarDecl__Group__0");
			builder.put(grammarAccess.getRVarDeclAccess().getGroup_2(), "rule__RVarDecl__Group_2__0");
			builder.put(grammarAccess.getRAssignAccess().getGroup(), "rule__RAssign__Group__0");
			builder.put(grammarAccess.getRInsertAccess().getGroup(), "rule__RInsert__Group__0");
			builder.put(grammarAccess.getRRemoveAccess().getGroup(), "rule__RRemove__Group__0");
			builder.put(grammarAccess.getRForEachAccess().getGroup(), "rule__RForEach__Group__0");
			builder.put(grammarAccess.getRCollectionAccess().getGroup_0(), "rule__RCollection__Group_0__0");
			builder.put(grammarAccess.getRBlockAccess().getGroup(), "rule__RBlock__Group__0");
			builder.put(grammarAccess.getRBlockAccess().getGroup_2(), "rule__RBlock__Group_2__0");
			builder.put(grammarAccess.getRBlockAccess().getGroup_2_0_0(), "rule__RBlock__Group_2_0_0__0");
			builder.put(grammarAccess.getRBlockAccess().getGroup_2_1_0(), "rule__RBlock__Group_2_1_0__0");
			builder.put(grammarAccess.getRIfAccess().getGroup(), "rule__RIf__Group__0");
			builder.put(grammarAccess.getRIfAccess().getGroup_5(), "rule__RIf__Group_5__0");
			builder.put(grammarAccess.getRWhileAccess().getGroup(), "rule__RWhile__Group__0");
			builder.put(grammarAccess.getRSwitchAccess().getGroup(), "rule__RSwitch__Group__0");
			builder.put(grammarAccess.getRSwitchAccess().getGroup_2(), "rule__RSwitch__Group_2__0");
			builder.put(grammarAccess.getRCaseAccess().getGroup(), "rule__RCase__Group__0");
			builder.put(grammarAccess.getRCaseAccess().getGroup_1(), "rule__RCase__Group_1__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup(), "rule__Expression__Group__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_0(), "rule__Expression__Group_1_0__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_0_4(), "rule__Expression__Group_1_0_4__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_0_4_1(), "rule__Expression__Group_1_0_4_1__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_1(), "rule__Expression__Group_1_1__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_2(), "rule__Expression__Group_1_2__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_2_2_0(), "rule__Expression__Group_1_2_2_0__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_2_2_0_3(), "rule__Expression__Group_1_2_2_0_3__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_2_2_1(), "rule__Expression__Group_1_2_2_1__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_2_2_1_2(), "rule__Expression__Group_1_2_2_1_2__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_2_2_1_2_1(), "rule__Expression__Group_1_2_2_1_2_1__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_3(), "rule__Expression__Group_1_3__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_4(), "rule__Expression__Group_1_4__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_5(), "rule__Expression__Group_1_5__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_6(), "rule__Expression__Group_1_6__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_7(), "rule__Expression__Group_1_7__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_8(), "rule__Expression__Group_1_8__0");
			builder.put(grammarAccess.getExpressionAccess().getGroup_1_9(), "rule__Expression__Group_1_9__0");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getGroup_0(), "rule__NonLeftRecExpression__Group_0__0");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getGroup_1(), "rule__NonLeftRecExpression__Group_1__0");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getGroup_2(), "rule__NonLeftRecExpression__Group_2__0");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getGroup_3(), "rule__NonLeftRecExpression__Group_3__0");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getGroup_4(), "rule__NonLeftRecExpression__Group_4__0");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getGroup_5(), "rule__NonLeftRecExpression__Group_5__0");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getGroup_6(), "rule__NonLeftRecExpression__Group_6__0");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getGroup_6_3(), "rule__NonLeftRecExpression__Group_6_3__0");
			builder.put(grammarAccess.getBindingAccess().getGroup(), "rule__Binding__Group__0");
			builder.put(grammarAccess.getBindingAccess().getGroup_1(), "rule__Binding__Group_1__0");
			builder.put(grammarAccess.getLiteralAccess().getGroup_0(), "rule__Literal__Group_0__0");
			builder.put(grammarAccess.getLiteralAccess().getGroup_1(), "rule__Literal__Group_1__0");
			builder.put(grammarAccess.getLiteralAccess().getGroup_2(), "rule__Literal__Group_2__0");
			builder.put(grammarAccess.getLiteralAccess().getGroup_3(), "rule__Literal__Group_3__0");
			builder.put(grammarAccess.getLiteralAccess().getGroup_4(), "rule__Literal__Group_4__0");
			builder.put(grammarAccess.getLiteralAccess().getGroup_5(), "rule__Literal__Group_5__0");
			builder.put(grammarAccess.getLiteralAccess().getGroup_6(), "rule__Literal__Group_6__0");
			builder.put(grammarAccess.getLiteralAccess().getGroup_6_3(), "rule__Literal__Group_6_3__0");
			builder.put(grammarAccess.getLiteralAccess().getGroup_6_3_1(), "rule__Literal__Group_6_3_1__0");
			builder.put(grammarAccess.getLiteralAccess().getGroup_7(), "rule__Literal__Group_7__0");
			builder.put(grammarAccess.getLiteralAccess().getGroup_7_3(), "rule__Literal__Group_7_3__0");
			builder.put(grammarAccess.getLiteralAccess().getGroup_7_3_1(), "rule__Literal__Group_7_3_1__0");
			builder.put(grammarAccess.getLiteralAccess().getGroup_8(), "rule__Literal__Group_8__0");
			builder.put(grammarAccess.getTypeLiteralAccess().getGroup_0(), "rule__TypeLiteral__Group_0__0");
			builder.put(grammarAccess.getTypeLiteralAccess().getGroup_1(), "rule__TypeLiteral__Group_1__0");
			builder.put(grammarAccess.getTypeLiteralAccess().getGroup_2(), "rule__TypeLiteral__Group_2__0");
			builder.put(grammarAccess.getTypeLiteralAccess().getGroup_3(), "rule__TypeLiteral__Group_3__0");
			builder.put(grammarAccess.getTypeLiteralAccess().getGroup_4(), "rule__TypeLiteral__Group_4__0");
			builder.put(grammarAccess.getTypeLiteralAccess().getGroup_5(), "rule__TypeLiteral__Group_5__0");
			builder.put(grammarAccess.getTypeLiteralAccess().getGroup_7(), "rule__TypeLiteral__Group_7__0");
			builder.put(grammarAccess.getTypeLiteralAccess().getGroup_7_3(), "rule__TypeLiteral__Group_7_3__0");
			builder.put(grammarAccess.getClassifierTypeRuleAccess().getGroup(), "rule__ClassifierTypeRule__Group__0");
			builder.put(grammarAccess.getRQIdentAccess().getGroup(), "rule__RQIdent__Group__0");
			builder.put(grammarAccess.getRQIdentAccess().getGroup_1(), "rule__RQIdent__Group_1__0");
			builder.put(grammarAccess.getRQualifiedAccess().getGroup(), "rule__RQualified__Group__0");
			builder.put(grammarAccess.getRQualifiedAccess().getGroup_1(), "rule__RQualified__Group_1__0");
			builder.put(grammarAccess.getRRootAccess().getNameAssignment_1(), "rule__RRoot__NameAssignment_1");
			builder.put(grammarAccess.getRRootAccess().getImportsAssignment_3(), "rule__RRoot__ImportsAssignment_3");
			builder.put(grammarAccess.getRRootAccess().getServicesAssignment_4(), "rule__RRoot__ServicesAssignment_4");
			builder.put(grammarAccess.getRRootAccess().getXtendedClassesAssignment_5(), "rule__RRoot__XtendedClassesAssignment_5");
			builder.put(grammarAccess.getRImportAccess().getNameAssignment_1(), "rule__RImport__NameAssignment_1");
			builder.put(grammarAccess.getRImportAccess().getAliasAssignment_3(), "rule__RImport__AliasAssignment_3");
			builder.put(grammarAccess.getRServiceAccess().getNameAssignment_1(), "rule__RService__NameAssignment_1");
			builder.put(grammarAccess.getROpenClassAccess().getNameAssignment_2(), "rule__ROpenClass__NameAssignment_2");
			builder.put(grammarAccess.getROpenClassAccess().getExtendsAssignment_3_1(), "rule__ROpenClass__ExtendsAssignment_3_1");
			builder.put(grammarAccess.getROpenClassAccess().getExtendsAssignment_3_2_1(), "rule__ROpenClass__ExtendsAssignment_3_2_1");
			builder.put(grammarAccess.getROpenClassAccess().getAttributesAssignment_5(), "rule__ROpenClass__AttributesAssignment_5");
			builder.put(grammarAccess.getROpenClassAccess().getOperationsAssignment_6(), "rule__ROpenClass__OperationsAssignment_6");
			builder.put(grammarAccess.getRNewClassAccess().getNameAssignment_1(), "rule__RNewClass__NameAssignment_1");
			builder.put(grammarAccess.getRNewClassAccess().getAttributesAssignment_3(), "rule__RNewClass__AttributesAssignment_3");
			builder.put(grammarAccess.getRNewClassAccess().getOperationsAssignment_4(), "rule__RNewClass__OperationsAssignment_4");
			builder.put(grammarAccess.getROperationAccess().getTagAssignment_0(), "rule__ROperation__TagAssignment_0");
			builder.put(grammarAccess.getROperationAccess().getTypeAssignment_2(), "rule__ROperation__TypeAssignment_2");
			builder.put(grammarAccess.getROperationAccess().getNameAssignment_3(), "rule__ROperation__NameAssignment_3");
			builder.put(grammarAccess.getROperationAccess().getParamsAssignment_5_0(), "rule__ROperation__ParamsAssignment_5_0");
			builder.put(grammarAccess.getROperationAccess().getParamsAssignment_5_1_1(), "rule__ROperation__ParamsAssignment_5_1_1");
			builder.put(grammarAccess.getROperationAccess().getBodyAssignment_7(), "rule__ROperation__BodyAssignment_7");
			builder.put(grammarAccess.getRTagAccess().getNameAssignment_1(), "rule__RTag__NameAssignment_1");
			builder.put(grammarAccess.getRVariableAccess().getTypeAssignment_0(), "rule__RVariable__TypeAssignment_0");
			builder.put(grammarAccess.getRVariableAccess().getNameAssignment_1(), "rule__RVariable__NameAssignment_1");
			builder.put(grammarAccess.getRAttributeAccess().getModifierAssignment_0(), "rule__RAttribute__ModifierAssignment_0");
			builder.put(grammarAccess.getRAttributeAccess().getBoundsAssignment_1(), "rule__RAttribute__BoundsAssignment_1");
			builder.put(grammarAccess.getRAttributeAccess().getOppositeAssignment_2(), "rule__RAttribute__OppositeAssignment_2");
			builder.put(grammarAccess.getRAttributeAccess().getTypeAssignment_3(), "rule__RAttribute__TypeAssignment_3");
			builder.put(grammarAccess.getRAttributeAccess().getNameAssignment_4(), "rule__RAttribute__NameAssignment_4");
			builder.put(grammarAccess.getRAttributeAccess().getExpAssignment_5_1(), "rule__RAttribute__ExpAssignment_5_1");
			builder.put(grammarAccess.getROppositeAccess().getNameAssignment_1(), "rule__ROpposite__NameAssignment_1");
			builder.put(grammarAccess.getRVarDeclAccess().getTypeAssignment_0(), "rule__RVarDecl__TypeAssignment_0");
			builder.put(grammarAccess.getRVarDeclAccess().getNameAssignment_1(), "rule__RVarDecl__NameAssignment_1");
			builder.put(grammarAccess.getRVarDeclAccess().getExpAssignment_2_1(), "rule__RVarDecl__ExpAssignment_2_1");
			builder.put(grammarAccess.getRAssignAccess().getTargetAssignment_0(), "rule__RAssign__TargetAssignment_0");
			builder.put(grammarAccess.getRAssignAccess().getExpAssignment_2(), "rule__RAssign__ExpAssignment_2");
			builder.put(grammarAccess.getRInsertAccess().getTargetAssignment_0(), "rule__RInsert__TargetAssignment_0");
			builder.put(grammarAccess.getRInsertAccess().getExpAssignment_2(), "rule__RInsert__ExpAssignment_2");
			builder.put(grammarAccess.getRRemoveAccess().getTargetAssignment_0(), "rule__RRemove__TargetAssignment_0");
			builder.put(grammarAccess.getRRemoveAccess().getExpAssignment_2(), "rule__RRemove__ExpAssignment_2");
			builder.put(grammarAccess.getRForEachAccess().getIteratorAssignment_2(), "rule__RForEach__IteratorAssignment_2");
			builder.put(grammarAccess.getRForEachAccess().getCollectionAssignment_4(), "rule__RForEach__CollectionAssignment_4");
			builder.put(grammarAccess.getRForEachAccess().getBlockAssignment_6(), "rule__RForEach__BlockAssignment_6");
			builder.put(grammarAccess.getRCollectionAccess().getMinAssignment_0_1(), "rule__RCollection__MinAssignment_0_1");
			builder.put(grammarAccess.getRCollectionAccess().getMaxAssignment_0_3(), "rule__RCollection__MaxAssignment_0_3");
			builder.put(grammarAccess.getRCollectionAccess().getExpAssignment_1(), "rule__RCollection__ExpAssignment_1");
			builder.put(grammarAccess.getRBlockAccess().getStatementsAssignment_2_0_0_0(), "rule__RBlock__StatementsAssignment_2_0_0_0");
			builder.put(grammarAccess.getRBlockAccess().getStatementsAssignment_2_0_1(), "rule__RBlock__StatementsAssignment_2_0_1");
			builder.put(grammarAccess.getRBlockAccess().getStatementsAssignment_2_1_0_0(), "rule__RBlock__StatementsAssignment_2_1_0_0");
			builder.put(grammarAccess.getRBlockAccess().getStatementsAssignment_2_1_1(), "rule__RBlock__StatementsAssignment_2_1_1");
			builder.put(grammarAccess.getRIfAccess().getCondAssignment_2(), "rule__RIf__CondAssignment_2");
			builder.put(grammarAccess.getRIfAccess().getThenAssignment_4(), "rule__RIf__ThenAssignment_4");
			builder.put(grammarAccess.getRIfAccess().getElseAssignment_5_1_0(), "rule__RIf__ElseAssignment_5_1_0");
			builder.put(grammarAccess.getRIfAccess().getNestedIfAssignment_5_1_1(), "rule__RIf__NestedIfAssignment_5_1_1");
			builder.put(grammarAccess.getRWhileAccess().getCondAssignment_2(), "rule__RWhile__CondAssignment_2");
			builder.put(grammarAccess.getRWhileAccess().getBlockAssignment_4(), "rule__RWhile__BlockAssignment_4");
			builder.put(grammarAccess.getRSwitchAccess().getParamNameAssignment_2_0(), "rule__RSwitch__ParamNameAssignment_2_0");
			builder.put(grammarAccess.getRSwitchAccess().getParamValAssignment_3(), "rule__RSwitch__ParamValAssignment_3");
			builder.put(grammarAccess.getRSwitchAccess().getCasesAssignment_6(), "rule__RSwitch__CasesAssignment_6");
			builder.put(grammarAccess.getRSwitchAccess().getOtherAssignment_9(), "rule__RSwitch__OtherAssignment_9");
			builder.put(grammarAccess.getRCaseAccess().getGuardAssignment_0(), "rule__RCase__GuardAssignment_0");
			builder.put(grammarAccess.getRCaseAccess().getMatchAssignment_1_1(), "rule__RCase__MatchAssignment_1_1");
			builder.put(grammarAccess.getRCaseAccess().getValueAssignment_3(), "rule__RCase__ValueAssignment_3");
			builder.put(grammarAccess.getRExpressionAccess().getExpAssignment(), "rule__RExpression__ExpAssignment");
			builder.put(grammarAccess.getExpressionAccess().getNameAssignment_1_0_2(), "rule__Expression__NameAssignment_1_0_2");
			builder.put(grammarAccess.getExpressionAccess().getParamsAssignment_1_0_4_0(), "rule__Expression__ParamsAssignment_1_0_4_0");
			builder.put(grammarAccess.getExpressionAccess().getParamsAssignment_1_0_4_1_1(), "rule__Expression__ParamsAssignment_1_0_4_1_1");
			builder.put(grammarAccess.getExpressionAccess().getFeatureAssignment_1_1_2(), "rule__Expression__FeatureAssignment_1_1_2");
			builder.put(grammarAccess.getExpressionAccess().getNameAssignment_1_2_2_0_0(), "rule__Expression__NameAssignment_1_2_2_0_0");
			builder.put(grammarAccess.getExpressionAccess().getVarNameAssignment_1_2_2_0_2(), "rule__Expression__VarNameAssignment_1_2_2_0_2");
			builder.put(grammarAccess.getExpressionAccess().getVarTypeAssignment_1_2_2_0_3_1(), "rule__Expression__VarTypeAssignment_1_2_2_0_3_1");
			builder.put(grammarAccess.getExpressionAccess().getLambdaAssignment_1_2_2_0_5(), "rule__Expression__LambdaAssignment_1_2_2_0_5");
			builder.put(grammarAccess.getExpressionAccess().getNameAssignment_1_2_2_1_0(), "rule__Expression__NameAssignment_1_2_2_1_0");
			builder.put(grammarAccess.getExpressionAccess().getParamsAssignment_1_2_2_1_2_0(), "rule__Expression__ParamsAssignment_1_2_2_1_2_0");
			builder.put(grammarAccess.getExpressionAccess().getParamsAssignment_1_2_2_1_2_1_1(), "rule__Expression__ParamsAssignment_1_2_2_1_2_1_1");
			builder.put(grammarAccess.getExpressionAccess().getOpAssignment_1_3_1(), "rule__Expression__OpAssignment_1_3_1");
			builder.put(grammarAccess.getExpressionAccess().getRightAssignment_1_3_2(), "rule__Expression__RightAssignment_1_3_2");
			builder.put(grammarAccess.getExpressionAccess().getOpAssignment_1_4_1(), "rule__Expression__OpAssignment_1_4_1");
			builder.put(grammarAccess.getExpressionAccess().getRightAssignment_1_4_2(), "rule__Expression__RightAssignment_1_4_2");
			builder.put(grammarAccess.getExpressionAccess().getOpAssignment_1_5_1(), "rule__Expression__OpAssignment_1_5_1");
			builder.put(grammarAccess.getExpressionAccess().getRightAssignment_1_5_2(), "rule__Expression__RightAssignment_1_5_2");
			builder.put(grammarAccess.getExpressionAccess().getRightAssignment_1_6_2(), "rule__Expression__RightAssignment_1_6_2");
			builder.put(grammarAccess.getExpressionAccess().getRightAssignment_1_7_2(), "rule__Expression__RightAssignment_1_7_2");
			builder.put(grammarAccess.getExpressionAccess().getRightAssignment_1_8_2(), "rule__Expression__RightAssignment_1_8_2");
			builder.put(grammarAccess.getExpressionAccess().getRightAssignment_1_9_2(), "rule__Expression__RightAssignment_1_9_2");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getExpAssignment_0_2(), "rule__NonLeftRecExpression__ExpAssignment_0_2");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getExpAssignment_1_2(), "rule__NonLeftRecExpression__ExpAssignment_1_2");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getIDAssignment_2_1(), "rule__NonLeftRecExpression__IDAssignment_2_1");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getLiteralAssignment_3_1(), "rule__NonLeftRecExpression__LiteralAssignment_3_1");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getCondAssignment_5_2(), "rule__NonLeftRecExpression__CondAssignment_5_2");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getThenAssignment_5_4(), "rule__NonLeftRecExpression__ThenAssignment_5_4");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getElseAssignment_5_6(), "rule__NonLeftRecExpression__ElseAssignment_5_6");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getBindingsAssignment_6_2(), "rule__NonLeftRecExpression__BindingsAssignment_6_2");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getBindingsAssignment_6_3_1(), "rule__NonLeftRecExpression__BindingsAssignment_6_3_1");
			builder.put(grammarAccess.getNonLeftRecExpressionAccess().getExpAssignment_6_5(), "rule__NonLeftRecExpression__ExpAssignment_6_5");
			builder.put(grammarAccess.getBindingAccess().getNameAssignment_0(), "rule__Binding__NameAssignment_0");
			builder.put(grammarAccess.getBindingAccess().getTypeAssignment_1_1(), "rule__Binding__TypeAssignment_1_1");
			builder.put(grammarAccess.getBindingAccess().getExpAssignment_3(), "rule__Binding__ExpAssignment_3");
			builder.put(grammarAccess.getLiteralAccess().getValueAssignment_0_1(), "rule__Literal__ValueAssignment_0_1");
			builder.put(grammarAccess.getLiteralAccess().getValueAssignment_1_1(), "rule__Literal__ValueAssignment_1_1");
			builder.put(grammarAccess.getLiteralAccess().getValueAssignment_2_1(), "rule__Literal__ValueAssignment_2_1");
			builder.put(grammarAccess.getLiteralAccess().getParamsAssignment_6_3_0(), "rule__Literal__ParamsAssignment_6_3_0");
			builder.put(grammarAccess.getLiteralAccess().getParamsAssignment_6_3_1_1(), "rule__Literal__ParamsAssignment_6_3_1_1");
			builder.put(grammarAccess.getLiteralAccess().getParamsAssignment_7_3_0(), "rule__Literal__ParamsAssignment_7_3_0");
			builder.put(grammarAccess.getLiteralAccess().getParamsAssignment_7_3_1_1(), "rule__Literal__ParamsAssignment_7_3_1_1");
			builder.put(grammarAccess.getTypeLiteralAccess().getTypeAssignment_4_3(), "rule__TypeLiteral__TypeAssignment_4_3");
			builder.put(grammarAccess.getTypeLiteralAccess().getTypeAssignment_5_3(), "rule__TypeLiteral__TypeAssignment_5_3");
			builder.put(grammarAccess.getTypeLiteralAccess().getTypesAssignment_7_2(), "rule__TypeLiteral__TypesAssignment_7_2");
			builder.put(grammarAccess.getTypeLiteralAccess().getTypesAssignment_7_3_1(), "rule__TypeLiteral__TypesAssignment_7_3_1");
			builder.put(grammarAccess.getClassifierTypeRuleAccess().getPackageNameAssignment_1(), "rule__ClassifierTypeRule__PackageNameAssignment_1");
			builder.put(grammarAccess.getClassifierTypeRuleAccess().getClassNameAssignment_3(), "rule__ClassifierTypeRule__ClassNameAssignment_3");
			builder.put(grammarAccess.getRTypeAccess().getNameAssignment_1(), "rule__RType__NameAssignment_1");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private AleGrammarAccess grammarAccess;

	@Override
	protected InternalAleParser createParser() {
		InternalAleParser result = new InternalAleParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public AleGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(AleGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
