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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.parser.AstBuilderListener;
import org.eclipse.acceleo.query.runtime.CrossReferenceProvider;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IRootEObjectProvider;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.services.EObjectServices;
import org.eclipse.emf.common.util.AbstractTreeIterator;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.DynamicFeatureRegistry;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * AQL service that resolves attributes of instances in an ALE program.
 */
public class DynamicEObjectServices extends EObjectServices {
	
	public static final String UNKNOWN_FEATURE = "Feature %s not found in EClass %s";
	public static final String NON_EOBJECT_FEATURE_ACCESS = "Attempt to access feature (%s) on a non ModelObject value (%s).";
	
	DynamicFeatureRegistry dynamicFeatures;

	public DynamicEObjectServices(IReadOnlyQueryEnvironment queryEnvironment, CrossReferenceProvider crossReferencer,
			IRootEObjectProvider rootProvider, DynamicFeatureRegistry dynamicFeatures) {
		super(queryEnvironment, crossReferencer, rootProvider);
		this.dynamicFeatures = dynamicFeatures;
	}

	@Override
	public Object aqlFeatureAccess(EObject self, String featureName) {
		return dynamicFeatures.aqlFeatureAccess(self, featureName);
	}
	
	@Override
	public List<EObject> eContents(EObject eObject) {
		List<EObject> contents = Lists.newArrayList(eObject.eContents());
		
		Optional<EObject> extension = dynamicFeatures.getRuntimeExtension(eObject);
		if (extension.isPresent()) {
			contents.addAll(extension.get().eContents());
		}
		return contents;
	}
	
	@Override
	public EObject eContainer(EObject eObject) {
		return dynamicFeatures.getInstanceOrSelf(eObject.eContainer());
	}
	
	@Override
	public EObject eContainer(EObject eObject, EClass type) {
		final EObject result;

		EObject current = eContainer(eObject);
		while (current != null && !type.isSuperTypeOf(current.eClass()) && !type.isInstance(current)) {
			current = eContainer(current);
		}
		if (current != null && (type.isSuperTypeOf(current.eClass()) || type.isInstance(current))) {
			result = current;
		} else {
			result = null;
		}
		return result;
	}
	
	@Override
	public List<EObject> eAllContents(EObject eObject) {
		return Lists.newArrayList(dynamicEAllContents(eObject));
	}
	
	private TreeIterator<EObject> dynamicEAllContents(EObject eObject) {
		return new AbstractTreeIterator<EObject>(eObject, false) {
			private static final long serialVersionUID = 1L;

			@Override
			public Iterator<EObject> getChildren(Object object) {
				return eContents((EObject) object).iterator();
			}
		};
	}

	@Override
	public List<EObject> eCrossReferences(EObject eObject) {
		List<EObject> crossRef = Lists.newArrayList(eObject.eCrossReferences());
		
		Optional<EObject> extension = dynamicFeatures.getRuntimeExtension(eObject);
		if (extension.isPresent()) {
			crossRef.addAll(extension.get().eCrossReferences());
		}
		return crossRef;
	}
	
	@Override
	public Object eGet(EObject eObject, final String featureName) {
		Object result = super.eGet(eObject, featureName);
		
		if (result == null) {
			Optional<EObject> extension = dynamicFeatures.getRuntimeExtension(eObject);
			if (extension.isPresent()) {
				final EStructuralFeature feature = extension.get().eClass().getEStructuralFeature(featureName);

				if (feature != null) {
					result = extension.get().eGet(feature);
				}
				if (result instanceof Set<?>) {
					result = Sets.newLinkedHashSet((Set<?>)result);
				} 
				else if (result instanceof EMap<?, ?>) {
					result = new BasicEMap<Object, Object>(((EMap<?, ?>)result).map());
				} 
				else if (result instanceof Collection<?>) {
					result = Lists.newArrayList((Collection<?>)result);
				}
			}
		}
		return result;
	}
	
	@Override
	protected IService getService(Method publicMethod) {
		if (AstBuilderListener.FEATURE_ACCESS_SERVICE_NAME.equals(publicMethod.getName())) {
			return new DynamicEObjectFeatureAccess(publicMethod, this, dynamicFeatures);
		}
		if ("eCrossReferences".equals(publicMethod.getName()) && publicMethod.getReturnType() == Object.class) {
			// Original definition of eCrossReferences(EObject) in EObjectServices has a wrong signature:
			// it returns Object instead of List<EObject>
			//
			// We overload this definition in this very class but we still have to filter out the original.
			//
			return null;
		}
		return super.getService(publicMethod);
	}
}
