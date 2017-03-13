package fr.mleduc.mt.compiler

import fr.mleduc.mt.compiler.util.ecoreImproved.EClassifierImproved
import fr.mleduc.mt.compiler.util.ecoreImproved.elistToScalaList
//import implementation.Block
//import implementation.ExpressionStatement
//import implementation.ExtendedClass
//import implementation.FeatureAssignment
//import implementation.FeatureInsert
//import implementation.FeaturePut
//import implementation.FeatureRemove
//import implementation.ForEach
//import implementation.If
//import implementation.Method
//import implementation.VariableAssignment
//import implementation.VariableDeclaration
//import implementation.While
//import implementation.util.ImplementationSwitch

class MethodDeclarationSwitch //extends ImplementationSwitch[String] 
{

//  val astSwitch = new ExpressionSwitch
//
//  override def caseMethod(method: Method): String = {
//    val static = method.getTags.contains("main")
//    val methodName = method.getOperationDef.getName
//    val params = method.getOperationDef.getEParameters.map { x =>
//      {
//        val typez: String = x.getEType.toType()
//        s"${typez} ${x.getName}"
//      }
//    }
//
//    val methodDecl = s"""public void ${methodName}(${params.mkString(", ")}) {
//    | ${method.getBody.getStatements.map { doSwitch _ }.mkString("\n")}
//    |}""".stripMargin
//    if (static) {
//
//      // TODO: what about an @init method ?
//      // TODO: how to deal with params in the @main method
//
//      val className = method.eContainer().asInstanceOf[ExtendedClass].getBaseClass.getName
//
//      s"""public static void main(String[] args) {
//        new ${className}().${methodName}();
//      }""".stripMargin + "\n\n" + methodDecl
//    } else
//      methodDecl
//
//  }
//
//  override def caseBlock(block: Block): String = s"{\n${block.getStatements.map { doSwitch }.mkString("\n")}}"
//  override def caseExpressionStatement(expressionStatement: ExpressionStatement): String = astSwitch.doSwitch(expressionStatement.getExpression)
//  override def caseFeatureAssignment(featureAssignement: FeatureAssignment): String = s"TODO ${featureAssignement.getTarget} = ${featureAssignement.getValue}"
//  override def caseFeatureInsert(featureInsert: FeatureInsert): String = "FeatureInsert"
//  override def caseFeaturePut(featurePut: FeaturePut): String = "FeaturePut"
//  override def caseFeatureRemove(featureRemove: FeatureRemove): String = "FeatureRemove"
//  override def caseForEach(forEach: ForEach): String = "ForEach"
//  override def caseIf(iff: If): String = s"if(${astSwitch.doSwitch(iff.getCondition)}) ${doSwitch(iff.getElse)} ${if (iff.getThen != null && iff.getThen.getStatements.size() > 0) { " else " + doSwitch(iff.getThen) } else ""}"
//  override def caseVariableAssignment(variableAssignement: VariableAssignment): String = "VariableAssignement"
//  override def caseVariableDeclaration(variableDeclaration: VariableDeclaration): String = {
//    val typez = variableDeclaration.getType.toType()
//    val name = variableDeclaration.getName
//    val expr = astSwitch.doSwitch(variableDeclaration.getInitialValue)
//    s"${typez} ${name} = ${expr}"
//  }
//  override def caseWhile(whilez: While): String = "While"

}