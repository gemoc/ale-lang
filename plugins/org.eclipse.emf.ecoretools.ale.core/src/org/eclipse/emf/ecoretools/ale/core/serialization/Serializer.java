/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.serialization;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;

/*
 * Class producing ALE textual fragment from EObjects
 * 
 * @deprecated this class does not seem to be used, we will remove it 
 */
@Deprecated
public class Serializer {

	public static String toString(EStructuralFeature feature) {
		
		StringBuffer result = new StringBuffer();
		
		result.append(feature.getEType().getName());
		result.append(" ");
		result.append(feature.getName());
		
		String initialValue = EcoreUtil.getAnnotation(feature, ImplementationPackage.eNS_URI, "initial");
		if(initialValue != null) {
			result.append(" := ");
			result.append(initialValue);
		}
		
		result.append(";");
		
		return result.toString();
	}
	
	public static String toString(EOperation operation) {
		
		StringBuffer result = new StringBuffer();
		
		String body = EcoreUtil.getAnnotation(operation, ImplementationPackage.eNS_URI, "body");
		if(body != null) {
			result.append("override ");
			if(operation.getEType() == null) {
				result.append("void");
			}
			else {
				result.append(operation.getEType().getName());
			}
			result.append(" ");
			result.append(operation.getName());
			result.append(
				operation
				.getEParameters()
				.stream()
				.map(param -> param.getEType().getName() +" "+ param.getName())
				.collect(Collectors.joining(", ","(",")"))
				);
		
			if(!body.startsWith("{")){
				result.append("{\n");
			}
			
			result.append(body);
			
			if(!body.endsWith("}")){
				result.append("}");
			}
		}
		
		return result.toString();
	}
	
	public static String runtimeToString(EClass cls) {
		
		StringBuffer result = new StringBuffer();
		
		if(EcoreUtil.getAnnotation(cls, ImplementationPackage.eNS_URI, "runtime") != null) {
			
			result.append("class ");
			result.append(cls.getName());
			result.append("{\n");
			
			cls.getEStructuralFeatures().forEach(feature -> {
				result.append(toString(feature));
				result.append("\n");
			});
			cls.getEOperations().forEach(operation-> {
				result.append(toString(operation));
				result.append("\n");
			});
			
			result.append("}");
		}
		
		return result.toString();
	}
	
	
	public static String openclassToString(EClass cls) {
		
		StringBuffer result = new StringBuffer();
		
		if(EcoreUtil.getAnnotation(cls, ImplementationPackage.eNS_URI, "runtime") == null) {
			
			List<String> implems = new ArrayList<String>();
			cls.getEOperations().forEach(operation-> {
				String implem = toString(operation);
				if(!implem.isEmpty()) {
					implems.add(implem);
				}
			});
			
			if(!implems.isEmpty()) {
				result.append("open class ");
				result.append(cls.getName());
				result.append("{\n");
				
				implems.forEach(implem -> {
					result.append(implem);
					result.append("{\n");
				});
				
				result.append("}");
			}
		}
		
		return result.toString();
	}	
}
