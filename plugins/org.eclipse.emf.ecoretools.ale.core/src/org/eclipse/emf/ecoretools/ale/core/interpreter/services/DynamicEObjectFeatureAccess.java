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
package org.eclipse.emf.ecoretools.ale.core.interpreter.services;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.ast.StringLiteral;
import org.eclipse.acceleo.query.runtime.ICompletionProposal;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.runtime.impl.completion.EFeatureCompletionProposal;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.ale.core.interpreter.DynamicFeatureRegistry;
import org.eclipse.emf.ecoretools.ale.core.interpreter.MethodEvaluator;
import org.eclipse.emf.ecoretools.ale.core.validation.IConvertType;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.ConvertType;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.Concept;
import org.eclipse.emf.ecoretools.ale.implementation.Concepts;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;

//FIXME: copy past from EObjectServices.EObjectFeatureAccess because it's private
public class DynamicEObjectFeatureAccess extends JavaMethodService {

	public static final String UNKNOWN_FEATURE = "Feature %s not found in EClass %s";
	private static final String DON_T_KNOW_WHAT_TO_DO_WITH = "don't know what to do with ";
	private static final String NON_EOBJECT_FEATURE_ACCESS = "Attempt to access feature (%s) on a non ModelObject value (%s).";
	
	DynamicFeatureRegistry dynamicFeatures;
	
	/**
	 * Creates a new service instance given a method and an instance.
	 * 
	 * @param method
	 *            the method that realizes the service
	 * @param serviceInstance
	 *            the instance on which the service must be called
	 */
	public DynamicEObjectFeatureAccess(Method method, Object serviceInstance, DynamicFeatureRegistry dynamicFeatures) {
		super(method, serviceInstance);
		this.dynamicFeatures = dynamicFeatures;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.acceleo.query.runtime.impl.JavaMethodService#getType(org.eclipse.acceleo.query.ast.Call,
	 *      org.eclipse.acceleo.query.runtime.impl.ValidationServices,
	 *      org.eclipse.acceleo.query.runtime.IValidationResult,
	 *      org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment, java.util.List)
	 */
	@Override
	public Set<IType> getType(Call call, ValidationServices services, IValidationResult validationResult,
			IReadOnlyQueryEnvironment queryEnvironment, List<IType> argTypes) {
		final String featureName = ((StringLiteral)call.getArguments().get(1)).getValue();
		final Set<IType> result = featureAccessTypes(services, queryEnvironment, argTypes.get(0),
				featureName);

		return result;
	}

	/**
	 * Gets the type of a feature access.
	 * 
	 * @param queryEnvironment
	 *            the {@link IReadOnlyQueryEnvironment}
	 * @param receiverTypes
	 *            the target types to gets the feature from
	 * @param featureName
	 *            the feature name
	 * @return the type of a feature access
	 */
	public Set<IType> featureAccessTypes(ValidationServices services,
			IReadOnlyQueryEnvironment queryEnvironment, IType receiverType, String featureName) {
		final Set<IType> result = new LinkedHashSet<IType>();
		
		final Set<EClass> receiverEClasses = new LinkedHashSet<EClass>();
		if (receiverType.getType() instanceof EClass) {
			receiverEClasses.add((EClass)receiverType.getType());
		} else if (receiverType.getType() instanceof Class) {
			final Set<EClassifier> eClassifiers = queryEnvironment.getEPackageProvider().getEClassifiers(
					(Class<?>)receiverType.getType());
			if (eClassifiers != null) {
				for (EClassifier eCls : eClassifiers) {
					if (eCls instanceof EClass) {
						receiverEClasses.add((EClass)eCls);
					}
				}
			}
		} else if (receiverType.getType() != null) {
			throw new IllegalStateException(DON_T_KNOW_WHAT_TO_DO_WITH + receiverType.getType());
		}

		if (receiverEClasses.isEmpty()) {
			if (receiverType.getType() != null) {
				result.add(services.nothing(NON_EOBJECT_FEATURE_ACCESS, featureName, receiverType
						.getType().toString()));
			} else {
				result.add(services.nothing(NON_EOBJECT_FEATURE_ACCESS, featureName, "null"));
			}
		} else {
			IConvertType convert = new ConvertType(queryEnvironment);
			for (EClass eClass : receiverEClasses) {
				if (eClass.equals(ImplementationPackage.eINSTANCE.getConcepts())) {
					Concepts concepts = MethodEvaluator.concepts;
					if (concepts.getAll().stream().anyMatch(concept -> concept.getId().equals(featureName))) {
						result.add(convert.toAQL(ImplementationPackage.eINSTANCE.getConcept()));
					}
					else {
						result.add(services.nothing("The concept " + featureName + " does not exist"));
					}
				}
				else {
					EStructuralFeature feature = eClass.getEStructuralFeature(featureName);

					if(feature == null) {
						Optional<Attribute> dynamicFeature = dynamicFeatures.findFeature(eClass, featureName);
						if(dynamicFeature.isPresent()) {
							feature = dynamicFeature.get().getFeatureRef();
						}
					}
					
					if (feature == null) {
						result.add(services.nothing(UNKNOWN_FEATURE, featureName, eClass.getName()));
					} else {
						result.add(convert.toAQL(feature));
					}
				}
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.acceleo.query.runtime.impl.AbstractService#validateAllType(org.eclipse.acceleo.query.runtime.impl.ValidationServices,
	 *      org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment, java.util.Map)
	 */
	@Override
	public Set<IType> validateAllType(ValidationServices services,
			IReadOnlyQueryEnvironment queryEnvironment, Map<List<IType>, Set<IType>> allTypes) {
		final Set<IType> result = new LinkedHashSet<IType>();

		final Set<IType> knownReceiverTypes = new LinkedHashSet<IType>();
		for (Entry<List<IType>, Set<IType>> entry : allTypes.entrySet()) {
			if (knownReceiverTypes.add(entry.getKey().get(0))) {
				result.addAll(entry.getValue());
			}
		}

		return result;
	}

	@Override
	public List<ICompletionProposal> getProposals(IReadOnlyQueryEnvironment queryEnvironment,
			Set<IType> receiverTypes) {
		return getEStructuralFeatureProposals(queryEnvironment, receiverTypes);
	}

	/**
	 * Gets the {@link List} of {@link EFeatureCompletionProposal} for {@link EStructuralFeature}.
	 * 
	 * @param receiverTypes
	 *            the receiver types.
	 * @return the {@link List} of {@link EFeatureCompletionProposal} for {@link EStructuralFeature}
	 */
	public List<ICompletionProposal> getEStructuralFeatureProposals(
			IReadOnlyQueryEnvironment queryEnvironment, Set<IType> receiverTypes) {
		final List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
		final Set<EClass> eClasses = new LinkedHashSet<EClass>();

		for (IType iType : receiverTypes) {
			if (iType.getType() instanceof EClass) {
				eClasses.add((EClass)iType.getType());
			}
		}

		for (EStructuralFeature feature : queryEnvironment.getEPackageProvider().getEStructuralFeatures(
				eClasses)) {
			result.add(new EFeatureCompletionProposal(feature));
		}

		return result;
	}
}
