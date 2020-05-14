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
package org.eclipse.emf.ecoretools.ale.core.parser.internal;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.acceleo.query.ast.SequenceInExtensionLiteral;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEBaseVisitor;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.ExpressionContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.FeatureContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.NavContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.NavigationSegmentContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RAssignContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RAttributeContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RBlockContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RExpressionContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RExpressionStmtContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RForEachContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RIfContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RInsertContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RNewClassContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.ROpenClassContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.ROperationContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RParametersContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RRemoveContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RRootContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RServiceContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RTypeContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RVarDeclContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RVariableContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.RWhileContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ALEParser.VarRefContext;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.AntlrAstToAleBehaviorsFactory.Parameter;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationFactory;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.While;

/**
 * Visits the result of the ANTLR parser to build the Implementation model.
 */
public class AstVisitors {
	
	private AstVisitors() {
		// this is a utility class
	}
	
	public static boolean isQualified(String name) {
		return name.contains(".");
	}
	
	public static String aliasToRealName(String qname, Map<String,String> importedBehaviors) {
		if(isQualified(qname)) {
			String[] segments = qname.split("\\.");
			String importSeg = importedBehaviors.get(segments[0]);
			if(importSeg != null) {
				segments[0] = importSeg;
			}
			return String.join(".", segments);
		}
		return qname;
	}
	
	public static class BlockVisitor extends ALEBaseVisitor<Block> {
		
		ParsedFile<ModelUnit> parseRes;
		
		public BlockVisitor(ParsedFile<ModelUnit> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public Block visitRBlock(RBlockContext ctx) {
			StatementVisitor subVisitor = new StatementVisitor(parseRes);
			List<Statement> body =
					ctx
					.rStatement()
					.stream()
					.map(subVisitor::visit)
					.filter(Objects::nonNull)
					.collect(toList());
					
			Block res =  AntlrAstToAleBehaviorsFactory.singleton.buildBlock(body);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
	}
	
	static class StatementVisitor extends ALEBaseVisitor<Statement> {
		
		ParsedFile<ModelUnit> parseRes;
		
		public StatementVisitor(ParsedFile<ModelUnit> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public Statement visitErrorNode(ErrorNode node) {
			return null;
		}
		
		@Override
		public Statement visitRVarDecl(RVarDeclContext ctx) {
			RTypeContext typeName = ctx.type;
			
			String name = ctx.Ident().getText();
			RExpressionContext initialValue = ctx.rExpression();
			
			VariableDeclaration res = AntlrAstToAleBehaviorsFactory.singleton.buildVariableDecl(
				name,
				initialValue,
				typeName,
				parseRes
			);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
		
		@Override
		public Statement visitRAssign(RAssignContext ctx) {
			ExpressionContext left = ctx.expression(); // epxression.feature or variable?
			RExpressionContext value =  ctx.rExpression();
			
			Statement res = null;
			if(left instanceof VarRefContext){
				VarRefContext varRef = (VarRefContext) left;
				res = AntlrAstToAleBehaviorsFactory.singleton.buildVariableAssignement(varRef.Ident().getText(),value,parseRes);
			}
			else if(left instanceof NavContext){
				NavContext navCtx = (NavContext) left;
				NavigationSegmentContext navSegment = navCtx.navigationSegment();
				if(navSegment instanceof FeatureContext){
					FeatureContext featCtx = (FeatureContext) navSegment;
					String feature = featCtx.Ident().getText();
					ExpressionContext target = navCtx.expression();
					res = AntlrAstToAleBehaviorsFactory.singleton.buildFeatureAssign(target,feature,value,parseRes);
				}
			}
			else {
				//TODO: raise error if we reach here
				res = AntlrAstToAleBehaviorsFactory.singleton.buildVariableAssignement(left.getText(),value,parseRes);
			}
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
		
		@Override
		public Statement visitRInsert(RInsertContext ctx) {
			ExpressionContext left = ctx.expression(); // epxression.feature or variable?
			RExpressionContext value =  ctx.rExpression();
			
			Statement res = null;
			if (left instanceof NavContext) {
				NavContext navCtx = (NavContext) left;
				NavigationSegmentContext navSegment = navCtx.navigationSegment();
				if (navSegment instanceof FeatureContext) {
					FeatureContext featCtx = (FeatureContext) navSegment;
					String feature = featCtx.Ident().getText();
					ExpressionContext target = navCtx.expression();
					res = AntlrAstToAleBehaviorsFactory.singleton.buildFeatureInsert(target, feature, value.expression(), parseRes);
				}
			}
			else if(left instanceof VarRefContext) {
				VarRefContext varRef = (VarRefContext) left;
				res = AntlrAstToAleBehaviorsFactory.singleton.buildVariableInsert(varRef.Ident().getText(),value,parseRes);
			}
			 
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
		
		@Override
		public Statement visitRRemove(RRemoveContext ctx) {
			ExpressionContext left = ctx.expression(); // epxression.feature or variable?
			RExpressionContext value =  ctx.rExpression();
			
			Statement res = null;
			 if(left instanceof NavContext){
				NavContext navCtx = (NavContext) left;
				NavigationSegmentContext navSegment = navCtx.navigationSegment();
				if(navSegment instanceof FeatureContext){
					FeatureContext featCtx = (FeatureContext) navSegment;
					String feature = featCtx.Ident().getText();
					ExpressionContext target = navCtx.expression();
					res = AntlrAstToAleBehaviorsFactory.singleton.buildFeatureRemove(target,feature,value.expression(),parseRes);
				}
			}
			else if(left instanceof VarRefContext) {
				VarRefContext varRef = (VarRefContext) left;
				res = AntlrAstToAleBehaviorsFactory.singleton.buildVariableRemove(varRef.Ident().getText(),value,parseRes);
			}
			 
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
		
		@Override
		public Statement visitRIf(RIfContext ctx) {
			RExpressionContext cond = ctx.rExpression();
			Block then = (new BlockVisitor(parseRes)).visit(ctx.rBlock().get(0));
			ConditionalBlock cBlock = AntlrAstToAleBehaviorsFactory.singleton.buildConditionalBlock(cond, then, parseRes);
			
			If res = null;
			if(ctx.nestedIf != null) {
				res = (If) visitRIf(ctx.nestedIf);
				res.getBlocks().add(0, cBlock);
			}
			else {
				Block elseB = null;
				if(ctx.rBlock().size() > 1) {
					elseB = (new BlockVisitor(parseRes)).visit(ctx.rBlock().get(1));
				}
				res = AntlrAstToAleBehaviorsFactory.singleton.buildIf(Arrays.asList(cBlock),elseB,parseRes);
			}
			
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
		
		@Override
		public Statement visitRForEach(RForEachContext ctx) {
			
			ForEach res = null;
			Block body = (new BlockVisitor(parseRes)).visit(ctx.rBlock());
			RExpressionContext collectionExp = ctx.rCollection().rExpression();
			if(collectionExp == null){
				String left = ctx.rCollection().Integer().get(0).getText();
				String right = ctx.rCollection().Integer().get(1).getText();
				SequenceInExtensionLiteral intSeq = AntlrAstToAleBehaviorsFactory.singleton.buildIntSequence(left,right);
				res = AntlrAstToAleBehaviorsFactory.singleton.buildForEach(ctx.Ident().getText(),intSeq,body);
			}
			else {
				res = AntlrAstToAleBehaviorsFactory.singleton.buildForEach(ctx.Ident().getText(),collectionExp,body,parseRes);
			}
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
		
		@Override
		public Statement visitRWhile(RWhileContext ctx) {
			Block body = (new BlockVisitor(parseRes)).visit(ctx.rBlock());
			While res = AntlrAstToAleBehaviorsFactory.singleton.buildWhile(ctx.rExpression(),body,parseRes);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
	
		@Override
		public Statement visitRExpressionStmt(RExpressionStmtContext ctx) {

			Statement res = AntlrAstToAleBehaviorsFactory.singleton.buildExpressionStatement(ctx.rExpression(),parseRes);
			
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
	}

	static class OpVisitor extends ALEBaseVisitor<Method> {
		
		ParsedFile<ModelUnit> parseRes;
		EClass fragment;
		
		public OpVisitor(ParsedFile<ModelUnit> parseRes, EClass fragment) {
			this.parseRes = parseRes;
			this.fragment = fragment;
		}
		
		@Override
		public Method visitROperation(ROperationContext ctx) {
			String keyword = ctx.children.stream()
								.filter(TerminalNode.class::isInstance)
								.findFirst()
								.orElseThrow(() -> new RuntimeException("cannot find any TerminalNode in " + ctx.children))
								.getText();
			
			final RTypeContext returnType = ctx.type;
			
			String operationName = ctx.name.getText();;
			
			List<Parameter> parameters = new ArrayList<>();
			if(ctx.rParameters() != null)
				parameters = (new ParamVisitor(parseRes)).visit(ctx.rParameters());
				
			Block body = (new BlockVisitor(parseRes)).visit(ctx.rBlock());
			
			String className = ctx.parent.getChild(1).getText();
			
			RuleContext parent = ctx.parent;
			if(parent instanceof RNewClassContext) {
				className = ((RNewClassContext)parent).name.getText();
			}
			else if(parent instanceof ROpenClassContext){
				className = ((ROpenClassContext)parent).name.getText();
			}
			
			List<String> tags = ctx.rTag().stream()
								   .map(t -> t.Ident().getText())
								   .collect(toList());
			
			Method res = null;
			if(keyword.equals("def")) {
				res = AntlrAstToAleBehaviorsFactory.singleton.buildMethod(fragment, operationName, parameters, returnType, body, tags);
			}
			else if(keyword.equals("override")) {
				res = AntlrAstToAleBehaviorsFactory.singleton.buildImplementation(className, operationName, parameters, returnType, body, tags);
			}
			else {
				//TODO: error: should not happen
				res = AntlrAstToAleBehaviorsFactory.singleton.buildMethod(fragment, operationName, parameters, returnType, body, tags);
			}
			
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
		
	}
	
	static class ParamVisitor extends ALEBaseVisitor<List<Parameter>> {
		
		ParsedFile<ModelUnit> parseRes;
		
		public ParamVisitor(ParsedFile<ModelUnit> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public List<Parameter> visitRParameters(RParametersContext ctx) {
			VarVisitor subVisitor = new VarVisitor(parseRes);
			List<Parameter> res = 
				ctx
				.rVariable()
				.stream()
				.map(subVisitor::visit)
				.collect(toList());
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
	}
	
	static class VarVisitor extends ALEBaseVisitor<Parameter> {
		
		ParsedFile<ModelUnit> parseRes;
		
		public VarVisitor(ParsedFile<ModelUnit> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public Parameter visitRVariable(RVariableContext ctx) {
			RTypeContext type = ctx.type;
			
			String name = ctx.Ident().getText();
			
			Parameter res = AntlrAstToAleBehaviorsFactory.singleton.buildParameter(type,name);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
	}
	
	static class OpenClassVisitor extends ALEBaseVisitor<ExtendedClass> {
		
		ParsedFile<ModelUnit> parseRes;
		Map<String,String> importedBehaviors;
		
		public OpenClassVisitor(ParsedFile<ModelUnit> parseRes, Map<String,String> importedBehaviors) {
			this.parseRes = parseRes;
			this.importedBehaviors = importedBehaviors;
		}
		
		@Override
		public ExtendedClass visitROpenClass(ROpenClassContext ctx) {
			String name = ctx.name.getText();
			
			EClass fragment = null;
			if(!ctx.rAttribute().isEmpty() || !ctx.rOperation().isEmpty()){
				fragment = AntlrAstToAleBehaviorsFactory.singleton.buildEClass(name);
			}
			
			AttributeVisitor subVisitor1 = new AttributeVisitor(parseRes,fragment);
			List<Attribute> attributes = 
					ctx
					.rAttribute()
					.stream()
					.map(attr -> (Attribute) subVisitor1.visitRAttribute(attr))
					.collect(toList());
			OpVisitor subVisitor2 = new OpVisitor(parseRes,fragment);
			List<Method> operations = 
					ctx
					.rOperation()
					.stream()
					.map(op -> subVisitor2.visit(op))
					.filter(elem -> elem != null)
					.collect(toList());
			List<String> extended = 
				ctx
				.rQualified()
				.stream()
				.skip(1) // the first one is the the name
				.map(q -> aliasToRealName(q.getText(),importedBehaviors))
				.collect(toList());
			
			ExtendedClass res = AntlrAstToAleBehaviorsFactory.singleton.buildExtendedClass(name,attributes,operations,extended);
			res.setFragment(fragment);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
		
	}

	static class NewClassVisitor extends ALEBaseVisitor<RuntimeClass> {
		
		ParsedFile<ModelUnit> parseRes;
		
		public NewClassVisitor(ParsedFile<ModelUnit> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public RuntimeClass visitRNewClass(RNewClassContext ctx) {
			String name = ctx.name.getText();
			
			EClass fragment = AntlrAstToAleBehaviorsFactory.singleton.buildEClass(name);
			
			AttributeVisitor subVisitor1 = new AttributeVisitor(parseRes,fragment);
			List<Attribute> attributes = 
					ctx
					.rAttribute()
					.stream()
					.map(subVisitor1::visitRAttribute)
					.collect(toList());
			OpVisitor subVisitor2 = new OpVisitor(parseRes,fragment);
			List<Method> operations = 
					ctx
					.rOperation()
					.stream()
					.map(subVisitor2::visit)
					.filter(Method.class::isInstance)
					.map(Method.class::cast)
					.collect(toList());
			
			RuntimeClass res = AntlrAstToAleBehaviorsFactory.singleton.buildRuntimeClass(name,attributes,operations);
			res.setFragment(fragment);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			
			return res;
		}
	}
	
	static class AttributeVisitor extends ALEBaseVisitor<Attribute> {
		
		ParsedFile<ModelUnit> parseRes;
		EClass fragment;
		
		public AttributeVisitor(ParsedFile<ModelUnit> parseRes, EClass fragment) {
			this.parseRes = parseRes;
			this.fragment = fragment;
		}
		
		@Override
		public Attribute visitRAttribute(RAttributeContext ctx) {
			RExpressionContext initialValue = ctx.rExpression();
			
			RTypeContext type = ctx.type;
			
			String name = ctx.Ident().getText();
			
			boolean isUnique = false;
			boolean isContainment = false;
			if(ctx.modifier != null) {
				if(ctx.modifier.getText().equals("contains")) {
					isContainment = true;
					isUnique = true;
				}
				else if(ctx.modifier.getText().equals("unique")) {
					isUnique = true;
				}
			}
			
			int lowerBound = 0;
			int upperBound = 1;
			if(ctx.bounds != null) {
				lowerBound = Integer.decode(ctx.bounds.Integer().get(0).getText());
				if(ctx.bounds.Integer().size() > 1){
					upperBound = Integer.decode(ctx.bounds.Integer().get(1).getText());
				}
				else if(ctx.bounds.MultOp() != null && ctx.bounds.MultOp().getText().equals("*")){
					upperBound = -1;
				}
			}
			
			String opposite = null;
			if(ctx.opposite != null) {
				opposite = ctx.opposite.Ident().getText();
			}
					
			Attribute res = AntlrAstToAleBehaviorsFactory.singleton.buildAttribute(
					fragment,
					name,
					initialValue,
					type,
					lowerBound,
					upperBound,
					isContainment,
					isUnique,
					opposite,
					parseRes);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
	}
	
	static class ServiceVisitor extends ALEBaseVisitor<String> {
		@Override
		public String visitRService(RServiceContext ctx) {
			String rawText = ctx.getText();
			rawText = rawText.replaceFirst("use", "");
			rawText = rawText.replaceFirst(";", "");
			return rawText.replaceAll("\\t\\r\\n", "");
		}
	}

	static class ModelUnitVisitor extends ALEBaseVisitor<ModelUnit> {
		
		ParsedFile<ModelUnit> parseRes;
		
		public ModelUnitVisitor(ParsedFile<ModelUnit> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public ModelUnit visitRRoot(RRootContext ctx) {
			ImplementationFactory factory = (ImplementationFactory) ImplementationPackage.eINSTANCE.getEFactoryInstance();
			ModelUnit res = factory.createModelUnit();
			
			res.setName(ctx.rQualified().getText());
			
			Map<String,String> importedBehaviors = new HashMap<>();
			ctx.rImport().stream()
				.forEach(imp -> 
					importedBehaviors.put(imp.Ident().getText(), imp.rQualified().getText())
				);
			
			OpenClassVisitor subVisitor1 = new OpenClassVisitor(parseRes,importedBehaviors);
			res.getClassExtensions().addAll(
					ctx
					.rClass()
					.stream()
					.map(c -> c.rOpenClass())
					.filter(c -> c != null)
					.map(cls -> subVisitor1.visit(cls))
					.collect(toList())
					);
			NewClassVisitor subVisitor2 = new NewClassVisitor(parseRes);
			res.getClassDefinitions().addAll(
					ctx
					.rClass()
					.stream()
					.map(c -> c.rNewClass())
					.filter(c -> c != null)
					.map(cls -> subVisitor2.visit(cls))
					.collect(toList())
					);
			ServiceVisitor serviceVisitor = new ServiceVisitor();
			res.getServices().addAll(
					ctx
					.rService()
					.stream()
					.map(srv -> serviceVisitor.visit(srv))
					.collect(toList())
					);
			if(parseRes.getRoot() != null) {
				parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
				parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			}
			return res;
		}
	}
	
	/**
	 * Build class extensions
	 */
	public static ParsedFile<ModelUnit> visit(RRootContext rootCtx) {
		ParsedFile<ModelUnit> result = new ParsedFile<ModelUnit>();
		result.setDiagnostic(new BasicDiagnostic());
		ModelUnit root = (new ModelUnitVisitor(result)).visit(rootCtx);
		result.setRoot(root);
		return result;
	}
	
	/**
	 * Create new EClasses
	 */
	public static List<EClass> preVisit(RRootContext ctx) {
		return
			ctx
			.rClass()
			.stream()
			.map(c -> c.rNewClass())
			.filter(c -> c != null)
			.map(cls -> {
				EClass eClsClass = EcorePackage.eINSTANCE.getEClass();
				EClass res = (EClass) EcoreUtil.create(eClsClass);
				res.setName(cls.name.getText());
				return res;
			})
			.collect(toList());				
	}
}