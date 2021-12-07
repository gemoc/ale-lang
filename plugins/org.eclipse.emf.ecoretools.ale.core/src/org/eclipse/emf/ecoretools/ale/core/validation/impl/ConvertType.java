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

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.CollectionTypeLiteral;
import org.eclipse.acceleo.query.ast.TypeLiteral;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.NothingType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.acceleo.query.validation.type.SetType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.core.validation.IConvertType;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;

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
		else {
			if(typedElement.isMany()) {
				//
				// Map
				//
				if(Map.Entry.class == typedElement.getEType().getInstanceClass() || "java.util.Map$Entry".equals(typedElement.getEType().getInstanceClassName())) {
					// Maps are considered as lists of MapEntry
					return new SequenceType(queryEnvironment, toAQL(typedElement.getEType()));
				}
				// Set
				//
				if(typedElement.isUnique() && !typedElement.isOrdered()) {
					return new SetType(queryEnvironment, toAQL(typedElement.getEType()));
				}
				// Ordered Set
				//
				if(typedElement.isUnique() && typedElement.isOrdered()) {
					return new OrderedSetType(queryEnvironment, toAQL(typedElement.getEType()));
				}
				// Sequence
				//
				return new SequenceType(queryEnvironment, toAQL(typedElement.getEType()));
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
		if(type == null || type == ImplementationPackage.eINSTANCE.getVoidEClassifier()) {
			return new NothingType("void");
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

	@Override
	public Optional<EClassifier> toEMF(TypeLiteral typeLiteral) {
		if (typeLiteral instanceof CollectionTypeLiteral) {
			CollectionTypeLiteral collectionTypeLiteral = (CollectionTypeLiteral) typeLiteral;
			
			if (collectionTypeLiteral.getElementType().getValue() instanceof Class<?>) {
				Class<?> clazz = (Class<?>) collectionTypeLiteral.getElementType().getValue();
				
				EClassifier classifier = toEMF(clazz);
				if (classifier == ImplementationPackage.eINSTANCE.getUnresolvedEClassifier()) {
					classifier = EcoreFactory.eINSTANCE.createEDataType();
					classifier.setInstanceClass((Class<?>) collectionTypeLiteral.getElementType().getValue());
					classifier.setName(classifier.getInstanceClass().getSimpleName());
					classifier.setInstanceTypeName(classifier.getInstanceClass().getName());
					classifier.setInstanceClassName(classifier.getInstanceClass().getName());
				}
				return Optional.ofNullable(classifier);
			}
			else if (collectionTypeLiteral.getElementType().getValue() instanceof EClass) {
				EClassifier classifier = (EClass) collectionTypeLiteral.getElementType().getValue();
				return Optional.of(classifier);
			}
		}
		/*
		 * String myString;
		 */
		else if (typeLiteral.getValue() instanceof Class<?>){
			EClassifier classifier = toEMF((Class<?>) typeLiteral.getValue());
			return Optional.of(classifier);
		}
		/*
		 * ecore::EClass myVariable;
		 */
		else if (typeLiteral.getValue() instanceof EClassifier) {
			return Optional.of((EClassifier) typeLiteral.getValue());
		}
		return Optional.empty();
	}
	
	@Override
	public EClassifier toEMF(Class<?> type) {
			 if(type == java.lang.String.class)		return EcorePackage.eINSTANCE.getEString();
		else if(type == java.lang.Integer.class)	return EcorePackage.eINSTANCE.getEInt();
		else if(type == java.lang.Double.class)		return EcorePackage.eINSTANCE.getEDouble();
		else if(type == java.lang.Boolean.class)	return EcorePackage.eINSTANCE.getEBoolean();
		else if(type == List.class)					return EcorePackage.eINSTANCE.getEEList();
		else if(type == Set.class)					return EcorePackage.eINSTANCE.getEEList();
		else if(type == Map.class)					return EcorePackage.eINSTANCE.getEEList();
		else										return ImplementationPackage.eINSTANCE.getUnresolvedEClassifier();
	}
	
}
