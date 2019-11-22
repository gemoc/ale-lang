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
package org.eclipse.emf.ecoretools.ale.core.validation.impl;

import static java.util.Objects.requireNonNull;

import java.util.Optional;

import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.NothingType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.core.validation.IConvertType;

public final class ConvertType implements IConvertType {
	
	private final IReadOnlyQueryEnvironment queryEnvironment;
	
	public ConvertType(IReadOnlyQueryEnvironment queryEnvironment) {
		this.queryEnvironment = requireNonNull(queryEnvironment, "queryEnvironment");
	}
	
	@Override
	public IType toAQL(ETypedElement typedElement) {
		if(typedElement.getEType() == EcorePackage.eINSTANCE.getEEList()) {
			IType aqlGenericType = new NothingType("?");
			if(!typedElement.getEGenericType().getETypeArguments().isEmpty()) {
				EGenericType emfGenericType = typedElement.getEGenericType().getETypeArguments().get(0);
				aqlGenericType = toAQL(emfGenericType.getEClassifier());
			}
			return new SequenceType(queryEnvironment, aqlGenericType);
		}
		if(typedElement instanceof EStructuralFeature) {
			EStructuralFeature feature = (EStructuralFeature) typedElement;
			if(feature.isMany()) {
				// FIXME Unique is true by default so currently any feature is turned into a set; we should set it to false
//				if(feature.isUnique()) {
//					return new SetType(env, TypeConverter.toAQL(env, feature.getEType()));
//				}
//				else {
					return new SequenceType(queryEnvironment, toAQL(feature.getEType()));
//				}
			}
		}
		return toAQL(typedElement.getEType());
	}
	
	@Override
	public IType toAQL(EClassifier type) {
		return toAQL(type, null);
	}
	
	@Override
	public IType toAQL(EClassifier type, EClassifier typeParameter) {
		if(type == EcorePackage.eINSTANCE.getEEList()) {
			IType collectionType = new NothingType("?");
			if(typeParameter != null) {
				collectionType = toAQL(typeParameter);
			}
			return new SequenceType(queryEnvironment, collectionType);
		}
		return new EClassifierType(queryEnvironment, type);
	}

	@Override
	public Optional<EClassifier> toEMF(IType type) {
		 if(type.getType() instanceof EClassifier) {
			 EClassifier classifier = (EClassifier) type.getType();
			 return Optional.of(classifier);
		 }
		 return Optional.empty();
	}
	
}
