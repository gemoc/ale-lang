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
import parser.XtdAQLParser.ExpContext
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
import parser.XtdAQLParser.RSetContext
import parser.XtdAQLParser.RInsertContext
import parser.XtdAQLParser.RPutContext
import parser.XtdAQLParser.RRemoveContext

class BlockVisitor extends XtdAQLBaseVisitor<Block> {
	
	override visitRBlock(RBlockContext ctx) {
		val subVisitor = new StatementVisitor
		val body = ctx.rStatement.map[subVisitor.visit(it)]
		ModelBuilder.singleton.buildBlock(body)
	}
	
}

class StatementVisitor extends XtdAQLBaseVisitor<Statement> {
	
	override visitRAssign(RAssignContext ctx) {
		return ModelBuilder.singleton.buildVariableDecl(ctx.ID.text,ctx.Expression.text)
	}
	override visitRIf(RIfContext ctx) {
		val cond = ctx.Expression.text
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
		return ModelBuilder.singleton.buildForEach(ctx.ID.text,ctx.Expression.text,body)
	}
	override visitRWhile(RWhileContext ctx) {
		val body = (new BlockVisitor).visit(ctx.rBlock)
		return ModelBuilder.singleton.buildWhile(ctx.Expression.text,body)
	}
	override visitRSet(RSetContext ctx) {
		val target = ctx.Expression.get(0).text
		val feature = ctx.ID.text
		val value = ctx.Expression.get(1).text
		return ModelBuilder.singleton.buildFeatureAssign(target,feature,value)
	}
	override visitRInsert(RInsertContext ctx) {
		val target = ctx.Expression.get(0).text
		val feature = ctx.ID.text
		val value = ctx.Expression.get(1).text
		return ModelBuilder.singleton.buildFeatureInsert(target,feature,value)
	}
	override visitRRemove(RRemoveContext ctx) {
		val target = ctx.Expression.get(0).text
		val feature = ctx.ID.text
		val value = ctx.Expression.get(1).text
		return ModelBuilder.singleton.buildFeatureRemove(target,feature,value)
	}
	override visitRPut(RPutContext ctx) {
		val target = ctx.Expression.get(0).text
		val feature = ctx.ID.text
		val key = ctx.Expression.get(1).text
		val value = ctx.Expression.get(2).text
		return ModelBuilder.singleton.buildFeaturePut(target,feature,key,value)
	}
	
	override visitExp(ExpContext ctx) {
		return ModelBuilder.singleton.buildExpression(ctx.Expression.text)
	}
	
	
}

class OpVisitor extends XtdAQLBaseVisitor<Behaviored> {
	
	override visitROperation(ROperationContext ctx) {
		val parameters = (new ParamVisitor).visit(ctx.rParameters)
		val body = (new BlockVisitor).visit(ctx.rBlock)
		
		val operationName = ctx.getChild(1).text
		val nbArgs = parameters.size
		val className = ctx.parent.getChild(1).text
		
//		val realOperation = resolve(className, operationName, nbArgs)
		return ModelBuilder.singleton.buildMethod(className, operationName, parameters, body) //TODO: build Implem also
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

class ClassVisitor extends XtdAQLBaseVisitor<List<Behaviored>> {
	
	override visitRClass(RClassContext ctx) {
		val subVisitor = new OpVisitor
		val res = ctx.rOperation.map[subVisitor.visit(it)]
		return res
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
		root.declarations += ctx.rClass.map[(subVisitor).visit(it)].flatten
		return root
	}
	
}