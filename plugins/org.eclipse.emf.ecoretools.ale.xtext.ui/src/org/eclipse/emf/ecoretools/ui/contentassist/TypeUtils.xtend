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

import org.eclipse.emf.ecore.EClassifier
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.emf.ecoretools.ale.BoolType
import org.eclipse.emf.ecoretools.ale.ClassifierType
import org.eclipse.emf.ecoretools.ale.IntType
import org.eclipse.emf.ecoretools.ale.RealType
import org.eclipse.emf.ecoretools.ale.SeqType
import org.eclipse.emf.ecoretools.ale.SetType
import org.eclipse.emf.ecoretools.ale.StringType
import org.eclipse.emf.ecoretools.ale.rType
import org.eclipse.emf.ecoretools.ale.typeLiteral

final class TypeUtils {
	
	private new() {
		// this utility provide extension methods, it should not be instantiated
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
    
    def static String typeAsString(EStructuralFeature feature) {
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
    	return type.name
    }
	
}