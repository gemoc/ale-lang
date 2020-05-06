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

import java.util.Optional;

import org.eclipse.acceleo.query.ast.TypeLiteral;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.NothingType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.acceleo.query.validation.type.SetType;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.implementation.UnresolvedEClassifier;

/**
 * Performs conversions between AQL's {@link IType} and EMF's {@link EClassifier}.
 */
public interface IConvertType {
	
	/**
	 * Turns an EMF typed element into an AQL type.
	 * <p>
	 * <h3>Type matching</h3>
	 * <ul>
	 * 	<li>{@link EcorePackage#getEEList() EEList} are turned into {@link SequenceType},
	 * 	<li>{@link EStructuralFeature} with multiplicity "many" are turned into {@link SequenceType}, 
	 * 	<li>{@link EStructuralFeature} with multiplicity "one" are turned into {@link SetType},
	 * </ul>
	 * For others, return {@link #toAQL(EClassifier) toAQL(typedElement.getEType())}.
	 * <p>
	 * <h3>Genericity</h3>
	 * 
	 * If the new type should have a generic parameter type but it cannot be resolved, 
	 * {@link NothingType NothingType("?")} is used instead.
	 * 
	 * @param typedElement
	 * 			The EMF element to convert to AQL
	 * 
	 * @return the AQL type corresponding to the given EMF type
	 */
	IType toAQL(ETypedElement typedElement);
	
	/**
	 * Turns an EMF classifier into an AQL type.
	 * <p>
	 * If the classifier is turned into a generic type, such as {@link SequenceType},
	 * its generic type parameter won't be resolved. For this reason you should use 
	 * {@link #toAQL(EClassifier, EClassifier)} whenever possible.
	 * 
	 * @param type
	 * 			The EMF classifier to convert
	 * 
	 * @return the AQL type corresponding to the given EMF classifier
	 * 
	 * @see #toAQL(EClassifier, EClassifier)
	 */
	IType toAQL(EClassifier type);
	
	/**
	 * Turns an EMF classifier into an AQL type.
	 * 
	 * @param type
	 * 			The EMF classifier to convert
	 * @param typeParameter
	 * 			The EMF generic type parameter or null if the type is not generic
	 * 
	 * @return the AQL type corresponding to the given EMF classifier
	 * 
	 * @see #toAQL(EClassifier)
	 */
	IType toAQL(EClassifier type, EClassifier typeParameter);

	/**
	 * Attempts to turn an AQL type into an EMF classifier.
	 * 
	 * @param type
	 * 			The AQL type to convert
	 * 
	 * @return the EMF classifier corresponding to the given AQL type
	 * 		   if able to convert it
	 */
	Optional<EClassifier> toEMF(IType type);

	/**
	 * Attempts to turn an AQL type literal into an EMF classifier.
	 * 
	 * @param typeLiteral
	 * 			The AQL type literal to convert
	 * 
	 * @return the EMF classifier corresponding to the given AQL literal type
	 * 		   if able to convert it
	 */
	Optional<EClassifier> toEMF(TypeLiteral typeLiteral);

	/**
	 * Turns a Java class into an EMF classifier.
	 * 
	 * @param type
	 * 			The class to convert
	 * 
	 * @return the EMF classifier corresponding to the given class if able to convert it,
	 * 		   {@link UnresolvedEClassifier} otherwise
	 */
	EClassifier toEMF(Class<?> type);
	
}
