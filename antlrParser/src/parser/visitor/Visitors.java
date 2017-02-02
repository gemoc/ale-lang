package parser.visitor;

import implementation.Behaviored;
import implementation.Block;
import implementation.ImplementationFactory;
import implementation.ImplementationPackage;
import implementation.Parameter;
import implementation.ModelBehavior;
import implementation.Statement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import parser.XtdAQLBaseVisitor;
import parser.XtdAQLParser.RAssignContext;
import parser.XtdAQLParser.RBlockContext;
import parser.XtdAQLParser.RClassContext;
import parser.XtdAQLParser.RForEachContext;
import parser.XtdAQLParser.RIfContext;
import parser.XtdAQLParser.ROperationContext;
import parser.XtdAQLParser.RParametersContext;
import parser.XtdAQLParser.RRootContext;
import parser.XtdAQLParser.RVariableContext;
import parser.XtdAQLParser.RWhileContext;
import implementation.ExtendedClass;
import implementation.VariableDeclaration;
import parser.XtdAQLParser.RAttributeContext;
import parser.XtdAQLParser.VarRefContext;
import parser.XtdAQLParser.NavContext;
import parser.XtdAQLParser.NavigationSegmentContext;
import parser.XtdAQLParser.FeatureContext;
import parser.XtdAQLParser.RExpressionContext;
import parser.XtdAQLParser.ServiceCallContext;
import parser.XtdAQLParser.CallExpContext;
import parser.XtdAQLParser.CallOrApplyContext;
import parser.XtdAQLParser.ExpressionContext;
import parser.XtdAQLParser.VariableDefinitionContext;
import parser.XtdAQLParser.RVarDeclContext;

public class Visitors {
	static class BlockVisitor extends XtdAQLBaseVisitor<Block> {
		@Override
		public Block visitRBlock(RBlockContext ctx) {
			StatementVisitor subVisitor = new StatementVisitor();
			List<Statement> body =
					ctx
					.rStatement()
					.stream()
					.map(s -> subVisitor.visit(s))
					.collect(Collectors.toList());
					
			return ModelBuilder.singleton.buildBlock(body);
		}
	}
	
	static class StatementVisitor extends XtdAQLBaseVisitor<Statement> {
		@Override
		public Statement visitRVarDecl(RVarDeclContext ctx) {
			return ModelBuilder.singleton.buildVariableDecl(
				ctx.Ident(1).getText(),
				ctx.expression().getText(),
				ctx.Ident(0).getText()
			);
		}
		
		@Override
		public Statement visitRAssign(RAssignContext ctx) {
			ExpressionContext left = ctx.expression().get(0); // epxression.feature or variable?
			String value =  ctx.expression().get(1).getText();
			
			if(left instanceof VarRefContext){
				VarRefContext varRef = (VarRefContext) left;
				return ModelBuilder.singleton.buildVariableAssignement(varRef.Ident().getText(),value);
			}
			else if(left instanceof NavContext){
				NavContext navCtx = (NavContext) left;
				NavigationSegmentContext navSegment = navCtx.navigationSegment();
				if(navSegment instanceof FeatureContext){
					FeatureContext featCtx = (FeatureContext) navSegment;
					String feature = featCtx.Ident().getText();
					String target = navCtx.expression().getText();
					return ModelBuilder.singleton.buildFeatureAssign(target,feature,value);
				}
			}
	
			//TODO: raise error if we reach here
			return ModelBuilder.singleton.buildVariableAssignement(left.getText(),value);
		}
		
		@Override
		public Statement visitRIf(RIfContext ctx) {
			String cond = ctx.expression().getText();
			Block then = (new BlockVisitor()).visit(ctx.rBlock().get(0));
			Block elseB = null;
			if(ctx.rBlock().size() > 1)
				elseB = (new BlockVisitor()).visit(ctx.rBlock().get(1));
			return ModelBuilder.singleton.buildIf(cond,then,elseB);
		}
		
		@Override
		public Statement visitRForEach(RForEachContext ctx) {
			Block body = (new BlockVisitor()).visit(ctx.rBlock());
			return ModelBuilder.singleton.buildForEach(ctx.Ident().getText(),ctx.expression().getText(),body);
		}
		
		@Override
		public Statement visitRWhile(RWhileContext ctx) {
			Block body = (new BlockVisitor()).visit(ctx.rBlock());
			return ModelBuilder.singleton.buildWhile(ctx.expression().getText(),body);
		}
	
		@Override
		public Statement visitRExpression(RExpressionContext ctx) {
			
			ExpressionContext exp = ctx.expression();
			
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
								target = ((NavContext)beforeCall).expression().getText();
							}
						}
						
						List<ExpressionContext> params = ((ServiceCallContext)call).expressionSequence().expression();
						
						if(serviceName.equals("add") && params.size() == 1){
							return ModelBuilder.singleton.buildFeatureInsert(target,feature,params.get(0).getText());
						}
						else if(serviceName.equals("remove") && params.size() == 1){
							return ModelBuilder.singleton.buildFeatureRemove(target,feature,params.get(0).getText());
						}
						else if(serviceName.equals("put") && params.size() == 2){
							return ModelBuilder.singleton.buildFeaturePut(target,feature,params.get(0).getText(),params.get(1).getText());
						}
					}
				}
			}
			
			return ModelBuilder.singleton.buildExpressionStatement(exp.getText());
		}
	}

	static class OpVisitor extends XtdAQLBaseVisitor<Behaviored> {
		
		@Override
		public Behaviored visitROperation(ROperationContext ctx) {
			String firstToken = ctx.getStart().getText();
			
			List<Parameter> parameters = new ArrayList<Parameter>();
			if(ctx.rParameters() != null)
				parameters = (new ParamVisitor()).visit(ctx.rParameters());
				
			Block body = (new BlockVisitor()).visit(ctx.rBlock());
			
			String operationName = ctx.getChild(1).getText();
			String className = ctx.parent.getChild(1).getText();
			
			boolean isMain = firstToken.equals("@main");
			
			return ModelBuilder.singleton.buildOperation(className, operationName, parameters, body, isMain);
		}
		
	}
	
	static class ParamVisitor extends XtdAQLBaseVisitor<List<Parameter>> {
		@Override
		public List<Parameter> visitRParameters(RParametersContext ctx) {
			VarVisitor subVisitor = new VarVisitor();
			return 
				ctx
				.rVariable()
				.stream()
				.map(var -> subVisitor.visit(var))
				.collect(Collectors.toList());
		}
	}
	
	static class VarVisitor extends XtdAQLBaseVisitor<Parameter> {
		@Override
		public Parameter visitRVariable(RVariableContext ctx) {
			String type = ctx.getChild(0).getText();
			String name = ctx.getChild(1).getText();
			return ModelBuilder.singleton.buildParameter(type,name);
		}
	}
	
	static class ClassVisitor extends XtdAQLBaseVisitor<ExtendedClass> {
		
		@Override
		public ExtendedClass visitRClass(RClassContext ctx) {
			String name = ctx.Ident().getText();
			AttributeVisitor subVisitor1 = new AttributeVisitor();
			List<VariableDeclaration> attributes = 
					ctx
					.rAttribute()
					.stream()
					.map(attr -> (VariableDeclaration) subVisitor1.visitRAttribute(attr))
					.collect(Collectors.toList());
			OpVisitor subVisitor2 = new OpVisitor();
			List<Behaviored> operations = 
					ctx
					.rOperation()
					.stream()
					.map(op -> subVisitor2.visit(op))
					.collect(Collectors.toList());
			return ModelBuilder.singleton.buildExtendedClass(name,attributes,operations);
		}
		
	}
	
	static class AttributeVisitor extends XtdAQLBaseVisitor<VariableDeclaration> {
		@Override
		public VariableDeclaration visitRAttribute(RAttributeContext ctx) {
			return ModelBuilder.singleton.buildVariableDecl(
					ctx.Ident(1).getText(),
					ctx.expression().getText(),
					ctx.Ident(0).getText());
		}
	}

	static class ModelBehaviorVisitor extends XtdAQLBaseVisitor<ModelBehavior> {
		
		@Override
		public ModelBehavior visitRRoot(RRootContext ctx) {
			ClassVisitor subVisitor = new ClassVisitor();
			ImplementationFactory factory = (ImplementationFactory) ImplementationPackage.eINSTANCE.getEFactoryInstance();
			ModelBehavior root = factory.createModelBehavior();
			root.getClassExtensions().addAll(
					ctx
					.rClass()
					.stream()
					.map(cls -> subVisitor.visit(cls))
					.collect(Collectors.toList())
					);
			return root;
		}
	}
	
	public static ModelBehavior visit(RRootContext rootCtx){
		return (new ModelBehaviorVisitor()).visit(rootCtx);
	}
}