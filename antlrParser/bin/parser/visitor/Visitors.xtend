package parser.visitor

import implementation.Behaviored
import implementation.Block
import implementation.ImplementationFactory
import implementation.ImplementationPackage
import implementation.Parameter
import implementation.Root
import implementation.Statement
import java.util.List
import parser.XtdAQLBaseVisitor
import parser.XtdAQLParser.RAssignContext
import parser.XtdAQLParser.RBlockContext
import parser.XtdAQLParser.RClassContext
import parser.XtdAQLParser.RForEachContext
import parser.XtdAQLParser.RIfContext
import parser.XtdAQLParser.ROperationContext
import parser.XtdAQLParser.RParametersContext
import parser.XtdAQLParser.RRootContext
import parser.XtdAQLParser.RVariableContext
import parser.XtdAQLParser.RWhileContext
import implementation.ExtendedClass
import implementation.VariableDeclaration
import parser.XtdAQLParser.RAttributeContext
import parser.XtdAQLParser.VarRefContext
import parser.XtdAQLParser.NavContext
import parser.XtdAQLParser.FeatureContext
import parser.XtdAQLParser.RExpressionContext
import parser.XtdAQLParser.ServiceCallContext
import parser.XtdAQLParser.CallOrApplyContext
import parser.XtdAQLParser.VariableDefinitionContext
import parser.XtdAQLParser.RVarDeclContext

class BlockVisitor extends XtdAQLBaseVisitor<Block> {
	
	override visitRBlock(RBlockContext ctx) {
		val subVisitor = new StatementVisitor
		val body = ctx.rStatement.map[subVisitor.visit(it)]
		ModelBuilder.singleton.buildBlock(body)
	}
	
}

class StatementVisitor extends XtdAQLBaseVisitor<Statement> {
	
	override visitRVarDecl(RVarDeclContext ctx) {
		return ModelBuilder.singleton.buildVariableDecl(ctx.Ident(1).text,ctx.expression.text,ctx.Ident(0).text)
	}
	
	override visitRAssign(RAssignContext ctx) {
		
		val left = ctx.expression.get(0) // epxression.feature or variable?
		val value =  ctx.expression.get(1).text
		
		if(left instanceof VarRefContext){
			return ModelBuilder.singleton.buildVariableAssignement(left.Ident.text,value)
		}
		else if(left instanceof NavContext){
			val navSegment = left.navigationSegment
			if(navSegment instanceof FeatureContext){
				val feature = navSegment.Ident.text
				val target = left.expression.text
				return ModelBuilder.singleton.buildFeatureAssign(target,feature,value)
			}
		}

		//TODO: raise error if we reach here
		return ModelBuilder.singleton.buildVariableAssignement(left.text,value)
	}
	override visitRIf(RIfContext ctx) {
		val cond = ctx.expression.text
		val then = (new BlockVisitor).visit(ctx.rBlock.head)
		val elseB = 
			if(ctx.rBlock.size > 1)
				(new BlockVisitor).visit(ctx.rBlock.get(1))
			else
				null
		ModelBuilder.singleton.buildIf(cond,then,elseB)
	}
	override visitRForEach(RForEachContext ctx) {
		val body = (new BlockVisitor).visit(ctx.rBlock)
		return ModelBuilder.singleton.buildForEach(ctx.Ident.text,ctx.expression.text,body)
	}
	override visitRWhile(RWhileContext ctx) {
		val body = (new BlockVisitor).visit(ctx.rBlock)
		return ModelBuilder.singleton.buildWhile(ctx.expression.text,body)
	}
	
	override visitRExpression(RExpressionContext ctx) {
		
		val exp = ctx.expression
		
		if(exp instanceof NavContext){
			val navSegment = exp.navigationSegment
			if(navSegment instanceof CallOrApplyContext){
				val call = navSegment.callExp
				if(call instanceof ServiceCallContext){
					val serviceName = call.Ident.text
					
					var target = ""
					var feature = ""
					val beforeCall = exp.expression
					if(beforeCall instanceof NavContext){
						val featurePart = beforeCall.navigationSegment
						if(featurePart instanceof FeatureContext){
							feature = featurePart.Ident.text
							target = beforeCall.expression.text
						}
					}
					
					val params = call.expressionSequence.expression
					
					if(serviceName == "add" && params.size == 1){
						return ModelBuilder.singleton.buildFeatureInsert(target,feature,params.get(0).text)
					}
					else if(serviceName == "remove" && params.size == 1){
						return ModelBuilder.singleton.buildFeatureRemove(target,feature,params.get(0).text)
					}
					else if(serviceName == "put" && params.size == 2){
						return ModelBuilder.singleton.buildFeaturePut(target,feature,params.get(0).text,params.get(1).text)
					}
				}
			}
		}
		
		return ModelBuilder.singleton.buildExpressionStatement(exp.text)
	}
}

class OpVisitor extends XtdAQLBaseVisitor<Behaviored> {
	
	override visitROperation(ROperationContext ctx) {
		val parameters = 
			if(ctx.rParameters !== null)
				(new ParamVisitor).visit(ctx.rParameters)
			else
				newArrayList
		val body = (new BlockVisitor).visit(ctx.rBlock)
		
		val operationName = ctx.getChild(1).text
		val className = ctx.parent.getChild(1).text
		
		return ModelBuilder.singleton.buildOperation(className, operationName, parameters, body)
	}
	
}

class ParamVisitor extends XtdAQLBaseVisitor<List<Parameter>> {
	
	override visitRParameters(RParametersContext ctx) {
		val subVisitor = new VarVisitor
		return ctx.rVariable.map[subVisitor.visit(it)]
	}
	
}

class VarVisitor extends XtdAQLBaseVisitor<Parameter> {
	
	override visitRVariable(RVariableContext ctx) {
		val type = ctx.getChild(0).text
		val name = ctx.getChild(1).text
		return ModelBuilder.singleton.buildParameter(type,name)
	}
	
}

class ClassVisitor extends XtdAQLBaseVisitor<ExtendedClass> {
	
	override visitRClass(RClassContext ctx) {
		val name = ctx.Ident.text
		val subVisitor1 = new AttributeVisitor
		val attributes = ctx.rAttribute.map[subVisitor1.visitRAttribute(it) as VariableDeclaration]
		val subVisitor2 = new OpVisitor
		val operations = ctx.rOperation.map[subVisitor2.visit(it)]
		return ModelBuilder.singleton.buildExtendedClass(name,attributes,operations)
	}
	
}

class AttributeVisitor extends XtdAQLBaseVisitor<VariableDeclaration> {
	override visitRAttribute(RAttributeContext ctx) {
		return ModelBuilder.singleton.buildVariableDecl(ctx.Ident(1).text,ctx.expression.text,ctx.Ident(0).text)
	}
}

//class ImportVisitor extends XtdAQLBaseVisitor<List<EPackage>> {
//	
//	override visitRImports(RImportsContext ctx) {
//		val rs = new ResourceSetImpl();
//		rs.resourceFactoryRegistry.extensionToFactoryMap.put("*", new XMIResourceFactoryImpl())
//		
//		return
//			ctx.STRING
//			.map[it.text.replaceAll("\"","")]
//			.map[URI.createURI(it)]
//			.map[rs.getResource(it, true)]
//			.map[allContents.filter(EPackage).toList]
//			.flatten
//			.toList
//	}
//	
//}

class RootVisitor extends XtdAQLBaseVisitor<Root> {
	
	override visitRRoot(RRootContext ctx) {
//		val allPackages = (new ImportVisitor).visit(ctx.rImports)
//		ModelBuilder.singleton.registerPackages(allPackages)
		
		val subVisitor = new ClassVisitor
		val factory = ImplementationPackage.eINSTANCE.EFactoryInstance as ImplementationFactory
		val root = factory.createRoot
		root.classExtensions += ctx.rClass.map[subVisitor.visit(it)]
		return root
	}
	
}