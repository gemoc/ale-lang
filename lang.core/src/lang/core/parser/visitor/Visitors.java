package lang.core.parser.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.acceleo.query.ast.SequenceInExtensionLiteral;
import org.eclipse.emf.common.util.BasicDiagnostic;

import implementation.Behaviored;
import implementation.Block;
import implementation.ExpressionStatement;
import implementation.ExtendedClass;
import implementation.FeatureAssignment;
import implementation.FeatureInsert;
import implementation.FeaturePut;
import implementation.FeatureRemove;
import implementation.ForEach;
import implementation.If;
import implementation.ImplementationFactory;
import implementation.ImplementationPackage;
import implementation.Method;
import implementation.ModelBehavior;
import implementation.RuntimeClass;
import implementation.Statement;
import implementation.VariableAssignment;
import implementation.VariableDeclaration;
import implementation.While;
import lang.core.parser.XtdAQLBaseVisitor;
import lang.core.parser.XtdAQLParser.CallExpContext;
import lang.core.parser.XtdAQLParser.CallOrApplyContext;
import lang.core.parser.XtdAQLParser.ExpressionContext;
import lang.core.parser.XtdAQLParser.FeatureContext;
import lang.core.parser.XtdAQLParser.NavContext;
import lang.core.parser.XtdAQLParser.NavigationSegmentContext;
import lang.core.parser.XtdAQLParser.RAssignContext;
import lang.core.parser.XtdAQLParser.RAttributeContext;
import lang.core.parser.XtdAQLParser.RBlockContext;
import lang.core.parser.XtdAQLParser.RExpressionContext;
import lang.core.parser.XtdAQLParser.RForEachContext;
import lang.core.parser.XtdAQLParser.RIfContext;
import lang.core.parser.XtdAQLParser.RNewClassContext;
import lang.core.parser.XtdAQLParser.ROpenClassContext;
import lang.core.parser.XtdAQLParser.ROperationContext;
import lang.core.parser.XtdAQLParser.RParametersContext;
import lang.core.parser.XtdAQLParser.RRootContext;
import lang.core.parser.XtdAQLParser.RServiceContext;
import lang.core.parser.XtdAQLParser.RVarDeclContext;
import lang.core.parser.XtdAQLParser.RVariableContext;
import lang.core.parser.XtdAQLParser.RWhileContext;
import lang.core.parser.XtdAQLParser.ServiceCallContext;
import lang.core.parser.XtdAQLParser.VarRefContext;
import lang.core.parser.visitor.ModelBuilder.Parameter;

/**
 * Visits the result of the antlr parser to build the Implementation model.
 */
public class Visitors {
	
	/**
	 * Do the same as ParseTree.getText() but insert white space
	 * between elements to avoid unwanted concatenation
	 */
	public static String safeGetText(ParseTree node) {
		if (node.getChildCount() == 0) {
			return node.getText();
		}

		StringBuilder builder = new StringBuilder();
		
		for (int i = 0; i < node.getChildCount(); i++) {
			if(i > 0){
				builder.append(" ");
			}
			builder.append(safeGetText(node.getChild(i)));
		}

		return builder.toString();
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
	
	static class BlockVisitor extends XtdAQLBaseVisitor<Block> {
		
		ParseResult<ModelBehavior> parseRes;
		
		public BlockVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public Block visitRBlock(RBlockContext ctx) {
			StatementVisitor subVisitor = new StatementVisitor(parseRes);
			List<Statement> body =
					ctx
					.rStatement()
					.stream()
					.map(s -> subVisitor.visit(s))
					.collect(Collectors.toList());
					
			Block res =  ModelBuilder.singleton.buildBlock(body);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
	}
	
	static class StatementVisitor extends XtdAQLBaseVisitor<Statement> {
		
		ParseResult<ModelBehavior> parseRes;
		
		public StatementVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public Statement visitRVarDecl(RVarDeclContext ctx) {
			String initialValue = null;
			if(ctx.expression() != null){ //no initial value
				initialValue = safeGetText(ctx.expression());
			}
			
			String typeName = ctx.type.getText();
			
			String name = ctx.Ident().getText();
			
			VariableDeclaration res = ModelBuilder.singleton.buildVariableDecl(
				name,
				initialValue,
				typeName
			);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			if(res.getInitialValue() != null){
				parseRes.getStartPositions().put(res.getInitialValue(),ctx.expression().start.getStartIndex());
				parseRes.getEndPositions().put(res.getInitialValue(),ctx.expression().stop.getStopIndex());
			}
			return res;
		}
		
		@Override
		public Statement visitRAssign(RAssignContext ctx) {
			ExpressionContext left = ctx.expression().get(0); // epxression.feature or variable?
			String value =  safeGetText(ctx.expression().get(1));
			
			Statement res = null;
			if(left instanceof VarRefContext){
				VarRefContext varRef = (VarRefContext) left;
				res = ModelBuilder.singleton.buildVariableAssignement(varRef.Ident().getText(),value);
				parseRes.getStartPositions().put(((VariableAssignment)res).getValue(),ctx.expression().get(1).start.getStartIndex());
				parseRes.getEndPositions().put(((VariableAssignment)res).getValue(),ctx.expression().get(1).stop.getStopIndex());
			}
			else if(left instanceof NavContext){
				NavContext navCtx = (NavContext) left;
				NavigationSegmentContext navSegment = navCtx.navigationSegment();
				if(navSegment instanceof FeatureContext){
					FeatureContext featCtx = (FeatureContext) navSegment;
					String feature = featCtx.Ident().getText();
					String target = safeGetText(navCtx.expression());
					res = ModelBuilder.singleton.buildFeatureAssign(target,feature,value);
					parseRes.getStartPositions().put(((FeatureAssignment)res).getValue(),ctx.expression().get(1).start.getStartIndex());
					parseRes.getEndPositions().put(((FeatureAssignment)res).getValue(),ctx.expression().get(1).stop.getStopIndex());
				}
			}
			else {
				//TODO: raise error if we reach here
				res = ModelBuilder.singleton.buildVariableAssignement(left.getText(),value);
			}
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
		
		@Override
		public Statement visitRIf(RIfContext ctx) {
			String cond = safeGetText(ctx.expression());
			Block then = (new BlockVisitor(parseRes)).visit(ctx.rBlock().get(0));
			Block elseB = null;
			if(ctx.rBlock().size() > 1)
				elseB = (new BlockVisitor(parseRes)).visit(ctx.rBlock().get(1));
			If res = ModelBuilder.singleton.buildIf(cond,then,elseB);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			parseRes.getStartPositions().put(res.getCondition(),ctx.expression().start.getStartIndex());
			parseRes.getEndPositions().put(res.getCondition(),ctx.expression().stop.getStopIndex());
			return res;
		}
		
		@Override
		public Statement visitRForEach(RForEachContext ctx) {
			
			ForEach res = null;
			Block body = (new BlockVisitor(parseRes)).visit(ctx.rBlock());
			ExpressionContext collectionExp = ctx.rCollection().expression();
			if(collectionExp == null){
				String left = ctx.rCollection().Integer().get(0).getText();
				String right = ctx.rCollection().Integer().get(1).getText();
				SequenceInExtensionLiteral intSeq = ModelBuilder.singleton.buildIntSequence(left,right);
				res = ModelBuilder.singleton.buildForEach(ctx.Ident().getText(),intSeq,body);
			}
			else {
				res = ModelBuilder.singleton.buildForEach(ctx.Ident().getText(),safeGetText(collectionExp),body);
				parseRes.getStartPositions().put(res.getCollectionExpression(),collectionExp.start.getStartIndex());
				parseRes.getEndPositions().put(res.getCollectionExpression(),collectionExp.stop.getStopIndex());
			}
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
		
		@Override
		public Statement visitRWhile(RWhileContext ctx) {
			Block body = (new BlockVisitor(parseRes)).visit(ctx.rBlock());
			While res = ModelBuilder.singleton.buildWhile(safeGetText(ctx.expression()),body);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			parseRes.getStartPositions().put(res.getCondition(),ctx.expression().start.getStartIndex());
			parseRes.getEndPositions().put(res.getCondition(),ctx.expression().stop.getStopIndex());
			return res;
		}
	
		@Override
		public Statement visitRExpression(RExpressionContext ctx) {
			
			ExpressionContext exp = ctx.expression();
			
			Statement res =  null;
			if(exp instanceof NavContext){
				NavigationSegmentContext navSegment = ((NavContext)exp).navigationSegment();
				if(navSegment instanceof CallOrApplyContext){
					CallExpContext call = ((CallOrApplyContext)navSegment).callExp();
					if(call instanceof ServiceCallContext){
						String serviceName = ((ServiceCallContext)call).Ident().getText();
						
						String target = "";
						String feature = "";
						ExpressionContext beforeCall = ((NavContext)exp).expression();
						if(beforeCall instanceof NavContext){
							NavigationSegmentContext featurePart = ((NavContext)beforeCall).navigationSegment();
							if(featurePart instanceof FeatureContext){
								feature = ((FeatureContext)featurePart).Ident().getText();
								target = safeGetText(((NavContext)beforeCall).expression());
							}
						}
						
						List<ExpressionContext> params = ((ServiceCallContext)call).expressionSequence().expression();
						
						if(serviceName.equals("add") && params.size() == 1){
							res = ModelBuilder.singleton.buildFeatureInsert(target,feature,safeGetText(params.get(0)));
							parseRes.getStartPositions().put(((FeatureInsert)res).getTarget(),((NavContext)beforeCall).expression().start.getStartIndex());
							parseRes.getEndPositions().put(((FeatureInsert)res).getTarget(),((NavContext)beforeCall).expression().stop.getStopIndex());
							parseRes.getStartPositions().put(((FeatureInsert)res).getValue(),params.get(0).start.getStartIndex());
							parseRes.getEndPositions().put(((FeatureInsert)res).getValue(),params.get(0).stop.getStopIndex());
						}
						else if(serviceName.equals("remove") && params.size() == 1){
							res = ModelBuilder.singleton.buildFeatureRemove(target,feature,safeGetText(params.get(0)));
							parseRes.getStartPositions().put(((FeatureRemove)res).getTarget(),((NavContext)beforeCall).expression().start.getStartIndex());
							parseRes.getEndPositions().put(((FeatureRemove)res).getTarget(),((NavContext)beforeCall).expression().stop.getStopIndex());
							parseRes.getStartPositions().put(((FeatureRemove)res).getValue(),params.get(0).start.getStartIndex());
							parseRes.getEndPositions().put(((FeatureRemove)res).getValue(),params.get(0).stop.getStopIndex());
						}
						else if(serviceName.equals("put") && params.size() == 2){
							res = ModelBuilder.singleton.buildFeaturePut(target,feature,safeGetText(params.get(0)),safeGetText(params.get(1)));
							parseRes.getStartPositions().put(((FeaturePut)res).getTarget(),((NavContext)beforeCall).expression().start.getStartIndex());
							parseRes.getEndPositions().put(((FeaturePut)res).getTarget(),((NavContext)beforeCall).expression().stop.getStopIndex());
							parseRes.getStartPositions().put(((FeaturePut)res).getKey(),params.get(0).start.getStartIndex());
							parseRes.getEndPositions().put(((FeaturePut)res).getKey(),params.get(0).stop.getStopIndex());
							parseRes.getStartPositions().put(((FeaturePut)res).getValue(),params.get(1).start.getStartIndex());
							parseRes.getEndPositions().put(((FeaturePut)res).getValue(),params.get(1).stop.getStopIndex());
						}
					}
				}
			}
			
			if(res == null){
				res = ModelBuilder.singleton.buildExpressionStatement(safeGetText(exp));
				parseRes.getStartPositions().put(((ExpressionStatement)res).getExpression(),exp.start.getStartIndex());
				parseRes.getEndPositions().put(((ExpressionStatement)res).getExpression(),exp.stop.getStopIndex());
			}
			
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
	}

	static class OpVisitor extends XtdAQLBaseVisitor<Behaviored> {
		
		ParseResult<ModelBehavior> parseRes;
		
		public OpVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public Behaviored visitROperation(ROperationContext ctx) {
			String keyword = 
				ctx
				.children
				.stream()
				.filter(c -> c instanceof TerminalNode)
				.findFirst()
				.get()
				.getText();
			
			final String returnType = ctx.type.getText();
			
			String operationName = ctx.name.getText();;
			
			List<Parameter> parameters = new ArrayList<Parameter>();
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
			
			List<String> tags =
				ctx
				.rTag()
				.stream()
				.map(t -> t.Ident().getText())
				.collect(Collectors.toList());
			
			Behaviored res = null;
			if(keyword.equals("def")) {
				res = ModelBuilder.singleton.buildMethod(operationName, parameters, returnType, body, tags);
			}
			else if(keyword.equals("override")) {
				res = ModelBuilder.singleton.buildImplementation(className, operationName, parameters, returnType, body, tags);
			}
			else {
				//TODO: error: should not happen
				res = ModelBuilder.singleton.buildMethod(operationName, parameters, returnType, body, tags);
			}
			
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
		
	}
	
	static class ParamVisitor extends XtdAQLBaseVisitor<List<Parameter>> {
		
		ParseResult<ModelBehavior> parseRes;
		
		public ParamVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public List<Parameter> visitRParameters(RParametersContext ctx) {
			VarVisitor subVisitor = new VarVisitor(parseRes);
			List<Parameter> res = 
				ctx
				.rVariable()
				.stream()
				.map(var -> subVisitor.visit(var))
				.collect(Collectors.toList());
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
	}
	
	static class VarVisitor extends XtdAQLBaseVisitor<Parameter> {
		
		ParseResult<ModelBehavior> parseRes;
		
		public VarVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public Parameter visitRVariable(RVariableContext ctx) {
			String typeName = ctx.type.getText();
			
			String name = ctx.Ident().getText();
			
			Parameter res = ModelBuilder.singleton.buildParameter(typeName,name);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
	}
	
	static class OpenClassVisitor extends XtdAQLBaseVisitor<ExtendedClass> {
		
		ParseResult<ModelBehavior> parseRes;
		Map<String,String> importedBehaviors;
		
		public OpenClassVisitor(ParseResult<ModelBehavior> parseRes, Map<String,String> importedBehaviors) {
			this.parseRes = parseRes;
			this.importedBehaviors = importedBehaviors;
		}
		
		@Override
		public ExtendedClass visitROpenClass(ROpenClassContext ctx) {
			String name = ctx.name.getText();
			AttributeVisitor subVisitor1 = new AttributeVisitor(parseRes);
			List<VariableDeclaration> attributes = 
					ctx
					.rAttribute()
					.stream()
					.map(attr -> (VariableDeclaration) subVisitor1.visitRAttribute(attr))
					.collect(Collectors.toList());
			OpVisitor subVisitor2 = new OpVisitor(parseRes);
			List<Behaviored> operations = 
					ctx
					.rOperation()
					.stream()
					.map(op -> subVisitor2.visit(op))
					.collect(Collectors.toList());
			List<String> extended = 
				ctx
				.rQualified()
				.stream()
				.map(q -> aliasToRealName(q.getText(),importedBehaviors))
				.collect(Collectors.toList());
			
			ExtendedClass res = ModelBuilder.singleton.buildExtendedClass(name,attributes,operations,extended);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			return res;
		}
		
	}

	static class NewClassVisitor extends XtdAQLBaseVisitor<RuntimeClass> {
		
		ParseResult<ModelBehavior> parseRes;
		
		public NewClassVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public RuntimeClass visitRNewClass(RNewClassContext ctx) {
			String name = ctx.name.getText();
			AttributeVisitor subVisitor1 = new AttributeVisitor(parseRes);
			List<VariableDeclaration> attributes = 
					ctx
					.rAttribute()
					.stream()
					.map(attr -> (VariableDeclaration) subVisitor1.visitRAttribute(attr))
					.collect(Collectors.toList());
			OpVisitor subVisitor2 = new OpVisitor(parseRes);
			List<Method> operations = 
					ctx
					.rOperation()
					.stream()
					.map(op -> subVisitor2.visit(op))
					.filter(op -> op instanceof Method)
					.map(op -> (Method) op)
					.collect(Collectors.toList());
			
			RuntimeClass res = ModelBuilder.singleton.buildRuntimeClass(name,attributes,operations);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			
			return res;
		}
	}
	
	static class AttributeVisitor extends XtdAQLBaseVisitor<VariableDeclaration> {
		
		ParseResult<ModelBehavior> parseRes;
		
		public AttributeVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public VariableDeclaration visitRAttribute(RAttributeContext ctx) {
			String initialValue = null;
			if(ctx.expression() != null) {
				initialValue = safeGetText(ctx.expression());
			}
			
			String typeName = ctx.type.getText();
			
			String name = ctx.Ident().getText();
					
			VariableDeclaration res = ModelBuilder.singleton.buildVariableDecl(
					name,
					initialValue,
					typeName);
			parseRes.getStartPositions().put(res,ctx.start.getStartIndex());
			parseRes.getEndPositions().put(res,ctx.stop.getStopIndex());
			if(res.getInitialValue() != null){
				parseRes.getStartPositions().put(res.getInitialValue(),ctx.expression().start.getStartIndex());
				parseRes.getEndPositions().put(res.getInitialValue(),ctx.expression().stop.getStopIndex());
			}
			return res;
		}
	}
	
	static class ServiceVisitor extends XtdAQLBaseVisitor<String> {
		@Override
		public String visitRService(RServiceContext ctx) {
			String rawText = ctx.getText();
			rawText = rawText.replaceFirst("use", "");
			rawText = rawText.replaceFirst(";", "");
			rawText.replaceAll("\\t\\r\\n", "");
			return rawText;
		}
	}

	static class ModelBehaviorVisitor extends XtdAQLBaseVisitor<ModelBehavior> {
		
		ParseResult<ModelBehavior> parseRes;
		
		public ModelBehaviorVisitor(ParseResult<ModelBehavior> parseRes) {
			this.parseRes = parseRes;
		}
		
		@Override
		public ModelBehavior visitRRoot(RRootContext ctx) {
			ImplementationFactory factory = (ImplementationFactory) ImplementationPackage.eINSTANCE.getEFactoryInstance();
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
			ServiceVisitor serviceVisitor = new ServiceVisitor();
			res.getServices().addAll(
					ctx
					.rService()
					.stream()
					.map(srv -> serviceVisitor.visit(srv))
					.collect(Collectors.toList())
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
	public static ParseResult<ModelBehavior> visit(RRootContext rootCtx) {
		ParseResult<ModelBehavior> result = new ParseResult<ModelBehavior>();
		result.setDiagnostic(new BasicDiagnostic());
		ModelBehavior root = (new ModelBehaviorVisitor(result)).visit(rootCtx);
		result.setRoot(root);
		return result;
	}
	
	/**
	 * Build new classes
	 */
	public static ParseResult<ModelBehavior> preVisit(RRootContext ctx) {
		ParseResult<ModelBehavior> parseRes = new ParseResult<ModelBehavior>();
		
		ImplementationFactory factory = (ImplementationFactory) ImplementationPackage.eINSTANCE.getEFactoryInstance();
		ModelBehavior model = factory.createModelBehavior();
		
		model.setName(ctx.rQualified().getText());
		
		NewClassVisitor subVisitor = new NewClassVisitor(parseRes);
		model.getClassDefinitions().addAll(
				ctx
				.rClass()
				.stream()
				.map(c -> c.rNewClass())
				.filter(c -> c != null)
				.map(cls -> subVisitor.visit(cls))
				.collect(Collectors.toList())
				);
		parseRes.setRoot(model);
		return parseRes;
	}
}