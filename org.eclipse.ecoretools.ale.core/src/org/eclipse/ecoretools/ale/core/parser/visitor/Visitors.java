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
package org.eclipse.ecoretools.ale.core.parser.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.acceleo.query.ast.SequenceInExtensionLiteral;
import org.eclipse.ecoretools.ale.core.parser.ALEBaseVisitor;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.CallExpContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.CallOrApplyContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.ExpressionContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.FeatureContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.NavContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.NavigationSegmentContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.RAssignContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.RAttributeContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.RBlockContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.RExpressionContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.RForEachContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.RIfContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.RNewClassContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.ROpenClassContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.ROperationContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.RParametersContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.RRootContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.RServiceContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.RVarDeclContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.RVariableContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.RWhileContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.ServiceCallContext;
import org.eclipse.ecoretools.ale.core.parser.ALEParser.VarRefContext;
import org.eclipse.ecoretools.ale.core.parser.visitor.ModelBuilder.Parameter;
import org.eclipse.ecoretools.ale.implementation.Behaviored;
import org.eclipse.ecoretools.ale.implementation.Block;
import org.eclipse.ecoretools.ale.implementation.ExpressionStatement;
import org.eclipse.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.ecoretools.ale.implementation.FeaturePut;
import org.eclipse.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.ecoretools.ale.implementation.ForEach;
import org.eclipse.ecoretools.ale.implementation.If;
import org.eclipse.ecoretools.ale.implementation.ImplementationFactory;
import org.eclipse.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.ecoretools.ale.implementation.Method;
import org.eclipse.ecoretools.ale.implementation.ModelBehavior;
import org.eclipse.ecoretools.ale.implementation.RuntimeClass;
import org.eclipse.ecoretools.ale.implementation.Statement;
import org.eclipse.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.ecoretools.ale.implementation.While;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;


/**
 * Visits the result of the antlr parser to build the Implementation model.
 */
public class Visitors {

	/**
	 * Do the same as ParseTree.getText() but insert white space between
	 * elements to avoid unwanted concatenation
	 */
	public static String safeGetText(ParseTree node) {
		if (node.getChildCount() == 0) {
			return node.getText();
		}

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < node.getChildCount(); i++) {
			if (i > 0) {
				builder.append(" ");
			}
			builder.append(safeGetText(node.getChild(i)));
		}

		return builder.toString();
	}

	public static boolean isQualified(String name) {
		return name.contains(".");
	}

	public static String aliasToRealName(String qname, Map<String, String> importedBehaviors) {
		if (isQualified(qname)) {
			String[] segments = qname.split("\\.");
			String importSeg = importedBehaviors.get(segments[0]);
			if (importSeg != null) {
				segments[0] = importSeg;
			}
			return String.join(".", segments);
		}
		return qname;
	}

	static class BlockVisitor extends ALEBaseVisitor<Block> {
		
		ParseResult<ModelBehavior> parseRes;

		public BlockVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}

		@Override
		public Block visitRBlock(RBlockContext ctx) {
			StatementVisitor subVisitor = new StatementVisitor(parseRes);
			List<Statement> body = ctx.rStatement().stream().map(s -> subVisitor.visit(s)).collect(Collectors.toList());

			Block res = ModelBuilder.singleton.buildBlock(body);
			parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());
			return res;
		}
	}

	
	static class StatementVisitor extends ALEBaseVisitor<Statement> {
		

		ParseResult<ModelBehavior> parseRes;

		public StatementVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}

		@Override
		public Statement visitRVarDecl(RVarDeclContext ctx) {
			String initialValue = null;
			if (ctx.expression() != null) { // no initial value
				initialValue = safeGetText(ctx.expression());
			}

			String typeName = ctx.type.getText();

			String name = ctx.Ident().getText();

			VariableDeclaration res = ModelBuilder.singleton.buildVariableDecl(name, initialValue, typeName);
			parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());
			if (res.getInitialValue() != null) {
				parseRes.getStartPositions().put(res.getInitialValue(), ctx.expression().start.getStartIndex());
				parseRes.getEndPositions().put(res.getInitialValue(), ctx.expression().stop.getStopIndex());
			}
			return res;
		}

		@Override
		public Statement visitRAssign(RAssignContext ctx) {
			ExpressionContext left = ctx.expression().get(0); // epxression.feature
																// or variable?
			String value = safeGetText(ctx.expression().get(1));

			Statement res = null;
			if (left instanceof VarRefContext) {
				VarRefContext varRef = (VarRefContext) left;
				res = ModelBuilder.singleton.buildVariableAssignement(varRef.Ident().getText(), value);
				parseRes.getStartPositions().put(((VariableAssignment) res).getValue(),
						ctx.expression().get(1).start.getStartIndex());
				parseRes.getEndPositions().put(((VariableAssignment) res).getValue(),
						ctx.expression().get(1).stop.getStopIndex());
			} else if (left instanceof NavContext) {
				NavContext navCtx = (NavContext) left;
				NavigationSegmentContext navSegment = navCtx.navigationSegment();
				if (navSegment instanceof FeatureContext) {
					FeatureContext featCtx = (FeatureContext) navSegment;
					String feature = featCtx.Ident().getText();
					String target = safeGetText(navCtx.expression());
					res = ModelBuilder.singleton.buildFeatureAssign(target, feature, value);
					parseRes.getStartPositions().put(((FeatureAssignment) res).getValue(),
							ctx.expression().get(1).start.getStartIndex());
					parseRes.getEndPositions().put(((FeatureAssignment) res).getValue(),
							ctx.expression().get(1).stop.getStopIndex());
				}
			} else {
				// TODO: raise error if we reach here
				res = ModelBuilder.singleton.buildVariableAssignement(left.getText(), value);
			}
			parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());
			return res;
		}

		@Override
		public Statement visitRIf(RIfContext ctx) {
			String cond = safeGetText(ctx.expression());
			Block then = (new BlockVisitor(parseRes)).visit(ctx.rBlock().get(0));
			Block elseB = null;
			if (ctx.rBlock().size() > 1)
				elseB = (new BlockVisitor(parseRes)).visit(ctx.rBlock().get(1));
			If res = ModelBuilder.singleton.buildIf(cond, then, elseB);
			parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());
			parseRes.getStartPositions().put(res.getCondition(), ctx.expression().start.getStartIndex());
			parseRes.getEndPositions().put(res.getCondition(), ctx.expression().stop.getStopIndex());
			return res;
		}

		@Override
		public Statement visitRForEach(RForEachContext ctx) {

			ForEach res = null;
			Block body = (new BlockVisitor(parseRes)).visit(ctx.rBlock());
			ExpressionContext collectionExp = ctx.rCollection().expression();
			if (collectionExp == null) {
				String left = ctx.rCollection().Integer().get(0).getText();
				String right = ctx.rCollection().Integer().get(1).getText();
				SequenceInExtensionLiteral intSeq = ModelBuilder.singleton.buildIntSequence(left, right);
				res = ModelBuilder.singleton.buildForEach(ctx.Ident().getText(), intSeq, body);
			} else {
				res = ModelBuilder.singleton.buildForEach(ctx.Ident().getText(), safeGetText(collectionExp), body);
				parseRes.getStartPositions().put(res.getCollectionExpression(), collectionExp.start.getStartIndex());
				parseRes.getEndPositions().put(res.getCollectionExpression(), collectionExp.stop.getStopIndex());
			}
			parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());
			return res;
		}

		@Override
		public Statement visitRWhile(RWhileContext ctx) {
			Block body = (new BlockVisitor(parseRes)).visit(ctx.rBlock());
			While res = ModelBuilder.singleton.buildWhile(safeGetText(ctx.expression()), body);
			parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());
			parseRes.getStartPositions().put(res.getCondition(), ctx.expression().start.getStartIndex());
			parseRes.getEndPositions().put(res.getCondition(), ctx.expression().stop.getStopIndex());
			return res;
		}

		@Override
		public Statement visitRExpression(RExpressionContext ctx) {

			ExpressionContext exp = ctx.expression();

			Statement res = null;
			if (exp instanceof NavContext) {
				NavigationSegmentContext navSegment = ((NavContext) exp).navigationSegment();
				if (navSegment instanceof CallOrApplyContext) {
					CallExpContext call = ((CallOrApplyContext) navSegment).callExp();
					if (call instanceof ServiceCallContext) {
						String serviceName = ((ServiceCallContext) call).Ident().getText();

						String target = "";
						String feature = "";
						ExpressionContext beforeCall = ((NavContext) exp).expression();
						if (beforeCall instanceof NavContext) {
							NavigationSegmentContext featurePart = ((NavContext) beforeCall).navigationSegment();
							if (featurePart instanceof FeatureContext) {
								feature = ((FeatureContext) featurePart).Ident().getText();
								target = safeGetText(((NavContext) beforeCall).expression());
							}
						}

						List<ExpressionContext> params = ((ServiceCallContext) call).expressionSequence().expression();

						if (serviceName.equals("add") && params.size() == 1) {
							res = ModelBuilder.singleton.buildFeatureInsert(target, feature,
									safeGetText(params.get(0)));
							parseRes.getStartPositions().put(((FeatureInsert) res).getTarget(),
									((NavContext) beforeCall).expression().start.getStartIndex());
							parseRes.getEndPositions().put(((FeatureInsert) res).getTarget(),
									((NavContext) beforeCall).expression().stop.getStopIndex());
							parseRes.getStartPositions().put(((FeatureInsert) res).getValue(),
									params.get(0).start.getStartIndex());
							parseRes.getEndPositions().put(((FeatureInsert) res).getValue(),
									params.get(0).stop.getStopIndex());
						} else if (serviceName.equals("remove") && params.size() == 1) {
							res = ModelBuilder.singleton.buildFeatureRemove(target, feature,
									safeGetText(params.get(0)));
							parseRes.getStartPositions().put(((FeatureRemove) res).getTarget(),
									((NavContext) beforeCall).expression().start.getStartIndex());
							parseRes.getEndPositions().put(((FeatureRemove) res).getTarget(),
									((NavContext) beforeCall).expression().stop.getStopIndex());
							parseRes.getStartPositions().put(((FeatureRemove) res).getValue(),
									params.get(0).start.getStartIndex());
							parseRes.getEndPositions().put(((FeatureRemove) res).getValue(),
									params.get(0).stop.getStopIndex());
						} else if (serviceName.equals("put") && params.size() == 2) {
							res = ModelBuilder.singleton.buildFeaturePut(target, feature, safeGetText(params.get(0)),
									safeGetText(params.get(1)));
							parseRes.getStartPositions().put(((FeaturePut) res).getTarget(),
									((NavContext) beforeCall).expression().start.getStartIndex());
							parseRes.getEndPositions().put(((FeaturePut) res).getTarget(),
									((NavContext) beforeCall).expression().stop.getStopIndex());
							parseRes.getStartPositions().put(((FeaturePut) res).getKey(),
									params.get(0).start.getStartIndex());
							parseRes.getEndPositions().put(((FeaturePut) res).getKey(),
									params.get(0).stop.getStopIndex());
							parseRes.getStartPositions().put(((FeaturePut) res).getValue(),
									params.get(1).start.getStartIndex());
							parseRes.getEndPositions().put(((FeaturePut) res).getValue(),
									params.get(1).stop.getStopIndex());
						}
					}
				}
			}

			if (res == null) {
				res = ModelBuilder.singleton.buildExpressionStatement(safeGetText(exp));
				parseRes.getStartPositions().put(((ExpressionStatement) res).getExpression(),
						exp.start.getStartIndex());
				parseRes.getEndPositions().put(((ExpressionStatement) res).getExpression(), exp.stop.getStopIndex());
			}

			parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());
			return res;
		}
	}


	static class OpVisitor extends ALEBaseVisitor<Behaviored> {
		
		ParseResult<ModelBehavior> parseRes;

		public OpVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}

		@Override
		public Behaviored visitROperation(ROperationContext ctx) {
			String keyword = ctx.children.stream().filter(c -> c instanceof TerminalNode).findFirst().get().getText();

			final String returnType = ctx.type.getText();

			String operationName = ctx.name.getText();

			List<Parameter> parameters = new ArrayList<Parameter>();
			if (ctx.rParameters() != null)
				parameters = (new ParamVisitor(parseRes)).visit(ctx.rParameters());

			Block body = (new BlockVisitor(parseRes)).visit(ctx.rBlock());

			String className = ctx.parent.getChild(1).getText();

			RuleContext parent = ctx.parent;
			if (parent instanceof RNewClassContext) {
				className = ((RNewClassContext) parent).name.getText();
			} else if (parent instanceof ROpenClassContext) {
				className = ((ROpenClassContext) parent).name.getText();
			}

			List<String> tags = ctx.rTag().stream().map(t -> t.Ident().getText()).collect(Collectors.toList());

			Behaviored res = null;
			if (keyword.equals("def")) {
				res = ModelBuilder.singleton.buildMethod(operationName, parameters, returnType, body, tags);
			} else if (keyword.equals("override")) {
				res = ModelBuilder.singleton.buildImplementation(className, operationName, parameters, returnType, body,
						tags);
			} else {
				// TODO: error: should not happen
				res = ModelBuilder.singleton.buildMethod(operationName, parameters, returnType, body, tags);
			}

			parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());
			return res;
		}

	}

	
	static class ParamVisitor extends ALEBaseVisitor<List<Parameter>> {
		

		ParseResult<ModelBehavior> parseRes;

		public ParamVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}

		@Override
		public List<Parameter> visitRParameters(RParametersContext ctx) {
			VarVisitor subVisitor = new VarVisitor(parseRes);
			List<Parameter> res = ctx.rVariable().stream().map(var -> subVisitor.visit(var))
					.collect(Collectors.toList());
			parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());
			return res;
		}
	}

	
	static class VarVisitor extends ALEBaseVisitor<Parameter> {
		

		ParseResult<ModelBehavior> parseRes;

		public VarVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}

		@Override
		public Parameter visitRVariable(RVariableContext ctx) {
			String typeName = ctx.type.getText();

			String name = ctx.Ident().getText();

			Parameter res = ModelBuilder.singleton.buildParameter(typeName, name);
			parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());
			return res;
		}
	}

	
	static class OpenClassVisitor extends ALEBaseVisitor<ExtendedClass> {
		
		ParseResult<ModelBehavior> parseRes;
		Map<String, String> importedBehaviors;

		public OpenClassVisitor(ParseResult<ModelBehavior> parseRes, Map<String, String> importedBehaviors) {
			this.parseRes = parseRes;
			this.importedBehaviors = importedBehaviors;
		}

		@Override
		public ExtendedClass visitROpenClass(ROpenClassContext ctx) {
			String name = ctx.name.getText();
			AttributeVisitor subVisitor1 = new AttributeVisitor(parseRes);
			List<VariableDeclaration> attributes = ctx.rAttribute().stream()
					.map(attr -> (VariableDeclaration) subVisitor1.visitRAttribute(attr)).collect(Collectors.toList());
			OpVisitor subVisitor2 = new OpVisitor(parseRes);
			List<Behaviored> operations = ctx.rOperation().stream().map(op -> subVisitor2.visit(op))
					.collect(Collectors.toList());
			List<String> extended = ctx.rQualified().stream().map(q -> aliasToRealName(q.getText(), importedBehaviors))
					.collect(Collectors.toList());

			ExtendedClass res = ModelBuilder.singleton.buildExtendedClass(name, attributes, operations, extended);
			parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());
			return res;
		}

	}


	static class NewClassVisitor extends ALEBaseVisitor<RuntimeClass> {
		

		ParseResult<ModelBehavior> parseRes;

		public NewClassVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}

		@Override
		public RuntimeClass visitRNewClass(RNewClassContext ctx) {
			String name = ctx.name.getText();
			AttributeVisitor subVisitor1 = new AttributeVisitor(parseRes);
			List<VariableDeclaration> attributes = ctx.rAttribute().stream()
					.map(attr -> (VariableDeclaration) subVisitor1.visitRAttribute(attr)).collect(Collectors.toList());
			OpVisitor subVisitor2 = new OpVisitor(parseRes);
			List<Method> operations = ctx.rOperation().stream().map(op -> subVisitor2.visit(op))
					.filter(op -> op instanceof Method).map(op -> (Method) op).collect(Collectors.toList());

			RuntimeClass res = ModelBuilder.singleton.buildRuntimeClass(name, attributes, operations);
			parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());

			return res;
		}
	}


	
	static class AttributeVisitor extends ALEBaseVisitor<VariableDeclaration> {
		
		ParseResult<ModelBehavior> parseRes;

		public AttributeVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}

		@Override
		public VariableDeclaration visitRAttribute(RAttributeContext ctx) {
			String initialValue = null;
			if (ctx.expression() != null) {
				initialValue = safeGetText(ctx.expression());
			}

			String typeName = ctx.type.getText();

			String name = ctx.Ident().getText();

			VariableDeclaration res = ModelBuilder.singleton.buildVariableDecl(name, initialValue, typeName);
			parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());
			if (res.getInitialValue() != null) {
				parseRes.getStartPositions().put(res.getInitialValue(), ctx.expression().start.getStartIndex());
				parseRes.getEndPositions().put(res.getInitialValue(), ctx.expression().stop.getStopIndex());
			}
			return res;
		}
	}

	static class ServiceVisitor extends ALEBaseVisitor<String> {

		@Override
		public String visitRService(RServiceContext ctx) {
			String rawText = ctx.getText();
			rawText = rawText.replaceFirst("use", "");
			rawText = rawText.replaceFirst(";", "");
			rawText.replaceAll("\\t\\r\\n", "");
			return rawText;
		}
	}


	static class ModelBehaviorVisitor extends ALEBaseVisitor<ModelBehavior> {
		
		ParseResult<ModelBehavior> parseRes;

		public ModelBehaviorVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}

		@Override
		public ModelBehavior visitRRoot(RRootContext ctx) {
			ImplementationFactory factory = (ImplementationFactory) ImplementationPackage.eINSTANCE
					.getEFactoryInstance();
			ModelBehavior res = factory.createModelBehavior();

			res.setName(ctx.rQualified().getText());

			
			Map<String,String> importedBehaviors = new HashMap<String,String>();
			ctx
			.rImport()
			.stream()
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
					.collect(Collectors.toList())
					);
			NewClassVisitor subVisitor2 = new NewClassVisitor(parseRes);
			res.getClassDefinitions().addAll(
					ctx
					.rClass()
					.stream()
					.map(c -> c.rNewClass())
					.filter(c -> c != null)
					.map(cls -> subVisitor2.visit(cls))
					.collect(Collectors.toList())
					);
			ServiceVisitor serviceVisitor = new ServiceVisitor();
			res.getServices()
					.addAll(ctx.rService().stream().map(srv -> serviceVisitor.visit(srv)).collect(Collectors.toList()));
			if (parseRes.getRoot() != null) {
				parseRes.getStartPositions().put(res, ctx.start.getStartIndex());
				parseRes.getEndPositions().put(res, ctx.stop.getStopIndex());
			}
			return res;
		}
	}

	/**
	 * Build class extensions
	 */
	public static ParseResult<ModelBehavior> visit(RRootContext rootCtx) {
		ParseResult<ModelBehavior> result = new ParseResult<ModelBehavior>();
		result.setDiagnostic(new BasicDiagnostic());
		ModelBehavior root = (new ModelBehaviorVisitor(result)).visit(rootCtx);
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
			.collect(Collectors.toList());				
	}
}