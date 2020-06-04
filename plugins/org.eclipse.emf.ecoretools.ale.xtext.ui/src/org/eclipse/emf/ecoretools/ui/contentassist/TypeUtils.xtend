/*******************************************************************************
 * Copyright (c) 2019 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ui.contentassist

import org.eclipse.core.resources.IFile
import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.ENamedElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EParameter
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.emf.ecoretools.ale.BehavioredClass
import org.eclipse.emf.ecoretools.ale.BoolType
import org.eclipse.emf.ecoretools.ale.ClassifierType
import org.eclipse.emf.ecoretools.ale.ExtendedClass
import org.eclipse.emf.ecoretools.ale.IntType
import org.eclipse.emf.ecoretools.ale.Operation
import org.eclipse.emf.ecoretools.ale.RealType
import org.eclipse.emf.ecoretools.ale.SeqType
import org.eclipse.emf.ecoretools.ale.SetType
import org.eclipse.emf.ecoretools.ale.StringType
import org.eclipse.emf.ecoretools.ale.VarRef
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment
import org.eclipse.emf.ecoretools.ale.core.env.IBehaviors
import org.eclipse.emf.ecoretools.ale.ide.project.IAleProject
import org.eclipse.emf.ecoretools.ale.implementation.Method
import org.eclipse.emf.ecoretools.ale.implementation.Statement
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration
import org.eclipse.emf.ecoretools.ale.rType
import org.eclipse.emf.ecoretools.ale.typeLiteral
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer

/**
 * Utility methods used by proposals providers to query syntactical elements.
 */
final class TypeUtils {
	
	private new() {
		// this utility provide extension methods, it should not be instantiated
	}
	
	def static getSemantics(EObject model) {
		/*
		 * Metamodel input
		 */
		val IFile aleFile = WorkspaceSynchronizer.getFile(model.eResource);
		
		var IAleEnvironment environment = null
		try {
			environment = IAleProject.from(aleFile.project).environment
			return environment.behaviors	
		}
		finally {
			if (environment !== null) {
				environment.close()
			}
		}
	}
	
	/**
	 * Finds the actual type of the reference.
	 * <p>
	 * Returns the semantic type (ale.implementation.BehavioredClass) if possible,
	 * otherwise returns the syntactic type (ale.BehavioredClass or EClass).
	 */
	def static EObject findType(VarRef reference, IBehaviors semantics) {
		val enclosingClass = reference.enclosingBehavioredClass
		 
		if (reference.ID == "self") {
			val referenceType = enclosingClass
			return referenceType.semanticAlterEgo(semantics)
		}
		else {
			val operation = reference.enclosingMethod
			
			val method = semantics.openClasses
								  .findFirst[ext | enclosingClass.name == enclosingClass.name ]
								  .methods
								  .findFirst[m | m.matches(operation)]
								  
			val inferredType = method.typeOf(reference)
			return inferredType.semanticAlterEgo(semantics)
		}
	}
	
	private def static enclosingBehavioredClass(EObject element) {
		var clazz = element.eContainer
		while (!(clazz instanceof BehavioredClass) && clazz !== null) {
			clazz = clazz.eContainer
		}
		return clazz as BehavioredClass
	}
	
	private def static enclosingMethod(EObject element) {
		var clazz = element.eContainer
		while (!(clazz instanceof Operation) && clazz !== null) {
			clazz = clazz.eContainer
		}
		return clazz as Operation
	}
	
	private def static typeOf(Method method, VarRef ref) {
		for (EParameter param : method.operationRef.EParameters) {
			if (param.name == ref.ID) {
				return param.EType
			}
		}
		for (Statement statement : method.body.statements) {
			if (statement instanceof VariableDeclaration) {
				val decl = statement as VariableDeclaration
				return decl.type
			}
		}
	}
	
	private def static matches(Method method, Operation operation) {
		if (method.operationRef.name != operation.name) {
			return false;
		}
		if (method.operationRef.EParameters.size != operation.params.size) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns the semantic type (ale.implementation.BehavioredClass) corresponding
	 * to the given syntactical type, or the syntactical type if it cannot be found.
	 */
	private def static semanticAlterEgo(BehavioredClass syntacticalClass, IBehaviors semantics) {
		if (syntacticalClass instanceof ExtendedClass) {
			val correspondingOpenClass = semantics.units
													  .flatMap[root | root.classExtensions]
						 							  .findFirst[behavior | behavior.baseClass.name == syntacticalClass.name]
						 							  
			if (correspondingOpenClass !== null) {
				return correspondingOpenClass
			}
		}
		val correspondingRuntimeClass = semantics.runtimeClasses
				 							     .findFirst[behavior | behavior.name == syntacticalClass.name]

		if (correspondingRuntimeClass !== null) {
			return correspondingRuntimeClass
		}
		return syntacticalClass
	}
	
	/**
	 * Returns the semantic type (ale.implementation.BehavioredClass) corresponding
	 * to the given syntactical type, or the syntactical type if it cannot be found.
	 */
	private def static semanticAlterEgo(ENamedElement syntacticalElement, IBehaviors semantics) {
		// Extract actual type when nested in a typed element (e.g. local variables)
		val syntacticalClass = if (syntacticalElement instanceof ETypedElement) syntacticalElement.EType else syntacticalElement
		
		val correspondingOpenClass = semantics.units
											  .flatMap[root | root.classExtensions]
					 						  .findFirst[behavior | EcoreUtil.equals(behavior.baseClass, syntacticalClass)]
					 							  
		if (correspondingOpenClass !== null) {
			return correspondingOpenClass
		}
		val correspondingRuntimeClass = semantics.runtimeClasses
				 							     .findFirst[behavior | behavior.name == syntacticalClass.name]

		if (correspondingRuntimeClass !== null) {
			return correspondingRuntimeClass
		}
		return syntacticalClass
	}
	
    def static String asString(rType type) {
    	if (type instanceof ClassifierType) {
    		return type.className
    	}
		if (type instanceof SetType) {
			return "Set(" + type.type.asString + ")"
		}
		if (type instanceof SeqType) {
			return "Sequence(" + type.type.asString + ")"
		}
		if (type instanceof StringType) {
			return "EString"			
		}
		if (type instanceof BoolType) {
			return "EBoolean"
		}
		if (type instanceof IntType) {
			return "EInteger"
		}
		if (type instanceof RealType) {
			return "EDouble"
		}
    	if (type instanceof typeLiteral) {
	    	return type.eClass.name
    	}
    	return type.name
    }
    
    def static String typeAsString(ETypedElement feature) {
    	if (feature.isMany) {
			if (feature.isUnique) {
				return "Set(" + feature.EType.asString + ")"
			}
			else {
				return "Sequence(" + feature.EType.asString + ")"
			}
    	}
    	return feature.EType.asString
    }
    
    def static String asString(EClassifier type) {
    	if (type === null) {
    		return "void"
    	}
    	else {
    		return type.name
		}
    }
	
}