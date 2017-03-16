package fr.mleduc.mt.compiler.generator.operation

import implementation.ExtendedClass
import implementation.Implementation
import implementation.Method
import implementation.ModelBehavior
import java.io.FileWriter
import java.io.IOException
import org.eclipse.core.resources.IProject
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.EOperation

class GenerateOperation {
	
	private def static dispatch EOperation getOperation(Implementation implementation) {
		implementation.operationRef
	}
	
	private def static dispatch EOperation getOperation(Method method) {
		method.operationDef
	}
	
	def generate(ExtendedClass clazz, IProject project) {
		val behavior = clazz.eContainer as ModelBehavior
		val clazzName = behavior.name.toFirstUpper + clazz.baseClass.name.toFirstUpper+"Operation";
		val fileContent = '''
		package «behavior.name».algebra.operation;
		
		public interface «clazzName» «FOR ext:clazz.extends BEFORE 'extends' SEPARATOR ', '»«ext.toJavaType»«ENDFOR» {
			«FOR operation: clazz.methods»
				«IF operation.operation.EType == null»void«ELSE»«operation.operation.toJavaType»«ENDIF» «operation.operation.name»(«FOR param:operation.operation.EParameters SEPARATOR ', '»«param.toJavaType» «param.name»«ENDFOR»);

			«ENDFOR»
		}'''
		val directoryAlgebra = project.getLocation().append("src").append(behavior.name).append("algebra").append(
			"operation");
		directoryAlgebra.toFile().mkdirs();
		val fileJavaAlgebra = directoryAlgebra.append(
			clazzName).
			addFileExtension("java");

		try {
			val FileWriter fileWriter = new FileWriter(fileJavaAlgebra.toFile());
			fileWriter.write(fileContent);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	def static String toJavaType(ETypedElement opp) {
		if(opp.EGenericType != null) {
			val type = opp.EType
			return '''«type.instanceClassName»«FOR t: opp.EGenericType.ETypeArguments BEFORE '<' SEPARATOR ', ' AFTER '>' »«t.EClassifier.instanceClassName»«ENDFOR»'''
		} else {
			return '''«opp.EType.instanceClassName»'''
		}
	}
	
	def static String toJavaType(ExtendedClass clazz) {
		val behavior = clazz.eContainer as ModelBehavior
		'''«behavior.name».algebra.operation.«behavior.name.toFirstUpper»«clazz.baseClass.name.toFirstUpper»Operation'''
	}
}
