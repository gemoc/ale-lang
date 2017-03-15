package fr.mleduc.mt.compiler.operation

import implementation.ExtendedClass
import implementation.Implementation
import implementation.Method
import implementation.ModelBehavior
import java.io.FileWriter
import java.io.IOException
import org.eclipse.core.resources.IProject
import org.eclipse.emf.ecore.ETypedElement

class GenerateOperation {
	
	private def static dispatch getOperation(Implementation implementation) {
		implementation.operationRef
	}
	
	private def static dispatch getOperation(Method method) {
		method.operationDef
	}
	
	def generate(ExtendedClass clazz, IProject project) {
		val behavior = clazz.eContainer as ModelBehavior
		val clazzName = behavior.name.substring(0, 1).toUpperCase() + behavior.name.substring(1) + clazz.baseClass.name.toFirstUpper+"Operation";
		val fileContent = '''
		package «behavior.name».algebra.operation;
		
		interface «clazzName» {
			«FOR operation: clazz.methods»
«««			TODO: convert ecore types to java types
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
	
	
	def static toJavaType(ETypedElement opp) {
		if(opp.EGenericType != null) {
			val type = opp.EType
			return '''«type.instanceClassName»«FOR t: opp.EGenericType.ETypeArguments BEFORE '<' SEPARATOR ', ' AFTER '>' »«t.EClassifier.instanceClassName»«ENDFOR»'''
		} else {
			return '''«opp.EType.instanceClassName»'''
		}
	}
}
