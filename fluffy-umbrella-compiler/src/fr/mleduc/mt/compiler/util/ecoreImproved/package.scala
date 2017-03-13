package fr.mleduc.mt.compiler.util

import org.eclipse.emf.ecore._
import org.eclipse.emf.common.util.EList
import java.util.function.Consumer

package object ecoreImproved {

  implicit def elistToScalaList[T](elist: EList[T]): List[T] = {
    val ret = new scala.collection.mutable.MutableList[T]
    elist.forEach(new Consumer[T] {
      override def accept(t: T) = {
        ret += t
      }
    })

    ret.toList
  }

  implicit class EClassifierImproved(typez: EClassifier) {

    def toType(): String =
      if (typez.getInstanceClassName == "int") s"Integer"
      else if (typez.getInstanceClassName == "boolean") "Boolean"
      else if (typez.getInstanceClassName == "byte") "Byte"
      else if (typez.getInstanceClassName == "char") "Char"
      else if (typez.getInstanceClassName == "double") "Double"
      else if (typez.getInstanceClassName == "float") "Float"
      else if (typez.getInstanceClassName == "long") "Long"
      else if (typez.getInstanceClassName == "short") "Short"
      else s"${typez.getName}"

    def toTypeInstance: String =
      if (typez.getInstanceClassName == "int") s"Integer(${typez.getDefaultValue})"
      else if (typez.getInstanceClassName == "boolean") "Boolean(${typez.getDefaultValue})"
      else if (typez.getInstanceClassName == "byte") "Byte(${typez.getDefaultValue})"
      else if (typez.getInstanceClassName == "char") "Char(${typez.getDefaultValue})"
      else if (typez.getInstanceClassName == "double") "Double(${typez.getDefaultValue})"
      else if (typez.getInstanceClassName == "float") "Float(${typez.getDefaultValue})"
      else if (typez.getInstanceClassName == "long") "Long(${typez.getDefaultValue})"
      else if (typez.getInstanceClassName == "short") "Short(${typez.getDefaultValue})"
      else s"${typez.getName}()"
  }

  implicit class EPackageImproved(ePackage: EPackage) {
    def fullName: String = {
      if (ePackage.getESuperPackage != null) {
        ePackage.getESuperPackage.fullName + "." + ePackage.getName
      } else {
        ePackage.getName
      }
    }
  }

  implicit class EClassImproved(eClass: EClass) {
    def fullName: String = if (eClass.getEPackage != null) {
      eClass.getEPackage.fullName + '.' + eClass.getName
    } else {
      eClass.getName
    }
  }

  implicit class EOperationImproved(eOperation: EOperation) {
    import scala.collection.JavaConversions._

    def fullName: String = s"${eOperation.getEContainingClass.fullName}.${eOperation.getName}(${eOperation.getEParameters.toList.map { p => s"${p.getName}:${p.getEType.getName}" }.mkString(", ")}):${eOperation.getEType.getName}"
  }

  implicit class EStructuralFeatureImproved(eStructuralFeature: EStructuralFeature) {
    def fullName: String = if (eStructuralFeature.isInstanceOf[EAttribute]) {
      eStructuralFeature.asInstanceOf[EAttribute].fullName
    } else {
      eStructuralFeature.asInstanceOf[EReference].fullName
    }
  }

  implicit class EAttributeImproved(eAttribute: EAttribute) {
    def fullName: String = s"${eAttribute.getEContainingClass.fullName}.${eAttribute.getName}:${eAttribute.getEType.getName}"
  }

  implicit class EReferenceImproved(eReference: EReference) {
    def fullName: String = s"${eReference.getEContainingClass.fullName}.${eReference.getName}:${eReference.getEType.getName}[${eReference.getLowerBound}..${eReference.getUpperBound}]"
  }
}