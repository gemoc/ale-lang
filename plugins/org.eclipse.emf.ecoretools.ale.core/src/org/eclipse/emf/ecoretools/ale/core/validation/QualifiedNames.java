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
package org.eclipse.emf.ecoretools.ale.core.validation;

import static java.util.stream.Collectors.joining;

import java.util.LinkedList;

import org.eclipse.acceleo.query.validation.type.AbstractCollectionType;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.acceleo.query.validation.type.SetType;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;

/**
 * Utility methods to compute qualified names.
 */
final public class QualifiedNames {
	
	private QualifiedNames() {
		// utility class should not be instantiated
	}
	
	public static String getQualifiedName(EClassifier cls) {
		if (cls.getEPackage() == null) {
			boolean classNameIsKnown = cls.getInstanceClassName() != null && !cls.getInstanceClassName().isEmpty();
			return classNameIsKnown ? cls.getInstanceClassName()
									: cls.getName();
		}
		return getQualifiedName(cls.getEPackage()) + "::" + cls.getName(); 
	}
	
	public static String getQualifiedName(EPackage pkg) {
		LinkedList<EPackage> pkgs = new LinkedList<>();
		EPackage current = pkg;
		while(current != null) {
			pkgs.addFirst(current);
			current = current.getESuperPackage();
		}
		return pkgs.stream()
				   .map(p -> p.getName())
				   .collect(joining("::"));
	}
	
	public static String getQualifiedName(IType type) {
		if(type instanceof SetType) {
			AbstractCollectionType collectionType = (AbstractCollectionType) type;
			return "Set(" + getQualifiedName(collectionType.getCollectionType()) + ")";
		}
		if(type instanceof SequenceType) {
			AbstractCollectionType collectionType = (AbstractCollectionType) type;
			return "Sequence(" + getQualifiedName(collectionType.getCollectionType()) + ")";
		}
		if(type instanceof AbstractCollectionType) {
			AbstractCollectionType collectionType = (AbstractCollectionType) type;
			return "Collection(" + getQualifiedName(collectionType.getCollectionType()) + ")";
		}
		if(type instanceof EClassifierType) {
			EClassifier cls = ((EClassifierType) type).getType();
			return getQualifiedName(cls);
		}
		return String.valueOf(type);
	}
	
}