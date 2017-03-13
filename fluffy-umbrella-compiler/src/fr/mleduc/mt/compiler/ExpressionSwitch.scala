package fr.mleduc.mt.compiler

//import org.eclipse.acceleo.query.ast.And
//import org.eclipse.acceleo.query.ast.BooleanLiteral
//import org.eclipse.acceleo.query.ast.Call
//import org.eclipse.acceleo.query.ast.CollectionTypeLiteral
//import org.eclipse.acceleo.query.ast.Conditional
//import org.eclipse.acceleo.query.ast.EnumLiteral
//import org.eclipse.acceleo.query.ast.ErrorBinding
//import org.eclipse.acceleo.query.ast.ErrorCall
//import org.eclipse.acceleo.query.ast.ErrorConditional
//import org.eclipse.acceleo.query.ast.ErrorEnumLiteral
//import org.eclipse.acceleo.query.ast.ErrorExpression
//import org.eclipse.acceleo.query.ast.ErrorStringLiteral
//import org.eclipse.acceleo.query.ast.ErrorTypeLiteral
//import org.eclipse.acceleo.query.ast.ErrorVariableDeclaration
//import org.eclipse.acceleo.query.ast.Implies
//import org.eclipse.acceleo.query.ast.IntegerLiteral
//import org.eclipse.acceleo.query.ast.Lambda
//import org.eclipse.acceleo.query.ast.Let
//import org.eclipse.acceleo.query.ast.NullLiteral
//import org.eclipse.acceleo.query.ast.Or
//import org.eclipse.acceleo.query.ast.RealLiteral
//import org.eclipse.acceleo.query.ast.SequenceInExtensionLiteral
//import org.eclipse.acceleo.query.ast.SetInExtensionLiteral
//import org.eclipse.acceleo.query.ast.StringLiteral
//import org.eclipse.acceleo.query.ast.TypeLiteral
//import org.eclipse.acceleo.query.ast.TypeSetLiteral
//import org.eclipse.acceleo.query.ast.VarRef
//import org.eclipse.acceleo.query.ast.util.AstSwitch
import org.eclipse.emf.ecore.EClassifier

import fr.mleduc.mt.compiler.util.ecoreImproved.EClassifierImproved
import fr.mleduc.mt.compiler.util.ecoreImproved.elistToScalaList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EClass

class ExpressionSwitch //extends AstSwitch[String] 
{
//  override def caseAnd(and: And): String = "and"
//
//  override def caseCall(call: Call): String = {
//    //    call.getArguments.toList match {
//    //      case Nil => "aaaa"
//    //      case (x :: xs) if x.isInstanceOf[VarRef] && x.asInstanceOf[VarRef].getVariableName == "self" => {
//    //        s"this.${call.getServiceName}()"
//    //      }
//    //      case xs => {
//    //        if (xs.head.isInstanceOf[TypeLiteral]) {
//    //          val tl = xs.head.asInstanceOf[TypeLiteral]
//    //          s"${tl.getValue.asInstanceOf[EClassifier].toType}.${call.getServiceName}();"
//    //        } else {
//    //          "TODO caseCall"
//    //        }
//    //      }
//    //    }
//    val sn = call.getServiceName
//    val caller = call.getArguments.head
//    val callerName = doSwitch(caller)
//    val params = call.getArguments.tail.map { doSwitch _ }.mkString(", ")
//    s"$callerName.$sn($params)"
//  }
//
//  override def caseErrorCall(errorCall: ErrorCall): String = "erroCall"
//
//  override def caseImplies(implies: Implies): String = "implies"
//
//  override def caseOr(or: Or): String = "or"
//
//  override def caseConditional(conditional: Conditional): String = "conditional"
//
//  override def caseErrorConditional(errorConditional: ErrorConditional): String = "errorCond"
//
//  override def caseErrorBinding(errorBinding: ErrorBinding): String = "TODO"
//
//  override def caseErrorEnumLiteral(errorBinding: ErrorEnumLiteral): String = "TODO"
//
//  override def caseErrorExpression(errorBinding: ErrorExpression): String = "TODO"
//
//  override def caseErrorStringLiteral(errorBinding: ErrorStringLiteral): String = "TODO"
//
//  override def caseErrorTypeLiteral(errorBinding: ErrorTypeLiteral): String = "TODO"
//
//  override def caseErrorVariableDeclaration(errorBinding: ErrorVariableDeclaration): String = "TODO"
//
//  override def caseLet(let: Let): String = "let"
//
//  override def caseBooleanLiteral(booleanLiteral: BooleanLiteral): String = "booleanLit"
//
//  override def caseEnumLiteral(enumLiteral: EnumLiteral): String = "enumLit"
//
//  override def caseIntegerLiteral(integerLiteral: IntegerLiteral): String = "intlit"
//
//  override def caseLambda(lambda: Lambda): String = "lambda"
//
//  override def caseNullLiteral(nullLit: NullLiteral): String = "nullLit"
//
//  override def caseRealLiteral(realLit: RealLiteral): String = "realLit"
//
//  override def caseSequenceInExtensionLiteral(sequenceInExtensionLit: SequenceInExtensionLiteral): String = "seqinext"
//
//  override def caseSetInExtensionLiteral(setInExtensionLit: SetInExtensionLiteral): String = "setinext"
//
//  override def caseStringLiteral(stringLit: StringLiteral): String = stringLit.getValue
//
//  override def caseTypeLiteral(typeLit: TypeLiteral): String = typeLit.getValue.asInstanceOf[EClass].getName
//
//  override def caseCollectionTypeLiteral(typeLiteral: CollectionTypeLiteral): String = "typelit"
//
//  override def caseTypeSetLiteral(typeSetLit: TypeSetLiteral): String = "type set literal"
//
//  override def caseVarRef(varRef: VarRef): String = s"${varRef.getVariableName}"
}
