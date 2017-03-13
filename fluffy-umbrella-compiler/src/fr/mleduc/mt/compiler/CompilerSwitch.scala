package fr.mleduc.mt.compiler

//import implementation.util.ImplementationSwitch

//import implementation._
import org.apache.commons.io.FileUtils
import java.io.IOException
import java.io.File
import java.util.function.Consumer
import org.eclipse.emf.common.util.EList
import java.io.FileWriter
import java.io.BufferedWriter
import scala.util.Try
import scala.util.Success
import scala.util.Failure
import fr.mleduc.mt.compiler.util.ecoreImproved._

class ScalaCompilerSwitch //extends ImplementationSwitch[Unit] 
{

//  private val compilationDir = "/home/mleduc/dev/java/structural-type-checker-workspace/compiled/src";
//
//  val variableDeclarationSwitch = new VariableDeclarationSwitch
//  val methodDeclarationSwitch = new MethodDeclarationSwitch
//
//  override def caseModelBehavior(modelbehaviour: ModelBehavior) {
//    val file = new File(compilationDir);
//
//    Try(FileUtils.deleteDirectory(file)) match {
//      case Success(_) =>
//        FileUtils.forceMkdir(file);
//        modelbehaviour.getClassExtensions().foreach { doSwitch _ }
//      case Failure(e: IOException) => e.printStackTrace()
//    }
//
//  }
//
//  override def caseExtendedClass(extendedClass: ExtendedClass) {
//    val baseClass = extendedClass.getBaseClass;
//    val segments = baseClass.getEPackage.fullName.split("\\.")
//    val rootDir = segments.foldLeft(new File(compilationDir))((file, segment) => new File(file, segment))
//    FileUtils.forceMkdir(rootDir)
//    val file = new File(rootDir, extendedClass.getBaseClass().getName() + ".java")
//
//    val bw = new BufferedWriter(new FileWriter(file))
//    bw.write(s"""package ${baseClass.getEPackage.fullName};
//
//              |class ${baseClass.getName} {
//              |  ${extendedClass.getAttributes.map { variableDeclarationSwitch.doSwitch _ }.mkString("\n\n  ")}
//              |
//              |  ${extendedClass.getMethods.map { methodDeclarationSwitch.doSwitch _ }.mkString("\n\n  ")}
//              |}""".stripMargin)
//    bw.close()
//
//  }
}

