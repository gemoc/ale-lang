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
package org.eclipse.emf.ecoretools.ale.core.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.runtime.AcceleoQueryEvaluationException;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult;
import org.eclipse.acceleo.query.runtime.IQueryEvaluationEngine;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.DynamicFeatureAccessService;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;

/**
 * This class manages dynamic attributes for EObjects.
 */
public class DynamicFeatureRegistry {
	
	List<ModelBehavior> allImplemModels;
	
	Map<EObject,Map<String,Object>> extendedObjects; //instance -> (featureName -> value)
	
	public DynamicFeatureRegistry (List<ModelBehavior> allImplemModels){
		this.allImplemModels = allImplemModels;
		extendedObjects = new HashMap<EObject,Map<String,Object>>();
	}
	
	/**
	 * Returns the value of the specified feature on the specified object.
	 * Attributes declared in EClasses take priority over dynamic attributes. 
	 * The object must be an
	 * {@link EObject} or a {@link Set}, {@link List} of {@link EObject}.
	 * 
	 * @param context
	 *            the object in which to read the feature.
	 * @param featureName
	 *            the name of the feature to read.
	 * @param diagnostic
	 *            The status to update in case of warnings or errors during this call.
	 * @return the value of the specified feature in the specified object.
	 */
	public Object aqlFeatureAccess(EObject context, String featureName) {
		Object result;

		if (context == null) {
			String message = String.format(DynamicFeatureAccessService.NON_EOBJECT_FEATURE_ACCESS, featureName, "null");
			throw new AcceleoQueryEvaluationException(message);
		} else {
			EClass eClass = (context).eClass();
			EStructuralFeature feature = eClass.getEStructuralFeature(featureName);
			if (feature == null) {
				result = getDynamicFeatureValue(context,featureName);
				if(result == null){
					String message = String.format(DynamicFeatureAccessService.UNKNOWN_FEATURE, featureName, eClass.getName());
					throw new AcceleoQueryEvaluationException(message);
				}
			} else {
				result = (context).eGet(feature);
			}
		}

		return result;
	}
	
	public Object getDynamicFeatureValue(EObject instance, String featureName) {
		
		Map<String,Object> extendedInstance = getExtensionFeatures(instance);
		
		Object featureValue = extendedInstance.get(featureName);
		if(featureValue != null)
			return featureValue;
		
		Optional<ExtendedClass> xtdClass = //FIXME:look type hierarchy 
				allImplemModels
				.stream()
				.flatMap(m -> m.getClassExtensions().stream())
				.filter(cls -> cls.getBaseClass().isInstance(instance))
				.findFirst(); 
		
		if(!xtdClass.isPresent()){
			String message = String.format(DynamicFeatureAccessService.UNKNOWN_FEATURE, featureName, instance.eClass().getName());
			throw new AcceleoQueryEvaluationException(message);
		}
		
		Optional<VariableDeclaration> featureDeclaration = 
				xtdClass
				.get()
				.getAttributes()
				.stream()
				.filter(attr -> attr.getName().equals(featureName))
				.findFirst();
		
		if(!featureDeclaration.isPresent()){
			String message = String.format(DynamicFeatureAccessService.UNKNOWN_FEATURE, featureName, instance.eClass().getName());
			throw new AcceleoQueryEvaluationException(message);
		}
		
		int initialValue = 0; //TODO: eval initial value (in the constructor)
		extendedInstance.put(featureName,initialValue);
		
		return initialValue;
	}
	
	public void setDynamicFeatureValue(EObject instance, String featureName, Object newValue) {
		Map<String,Object> extendedInstance = getExtensionFeatures(instance);
		
		Object featureValue = extendedInstance.get(featureName);
		if(featureValue != null)
			extendedInstance.put(featureName,newValue);
		else{
			Optional<ExtendedClass> xtdClass = //FIXME:look type hierarchy 
					allImplemModels
					.stream()
					.flatMap(m -> m.getClassExtensions().stream())
					.filter(cls -> cls.getBaseClass().isInstance(instance))
					.findFirst();
			
			if(xtdClass.isPresent()){
				Optional<VariableDeclaration> featureDeclaration = 
						xtdClass
						.get()
						.getAttributes()
						.stream()
						.filter(attr -> attr.getName().equals(featureName))
						.findFirst();
				
				if(featureDeclaration.isPresent()){
					extendedInstance.put(featureName,newValue);
				}
				else{
					//TODO:raise feature not found error
				}
			}
		}
	}
	
	private Map<String,Object> getExtensionFeatures(EObject instance) {
		Map<String,Object> extendedInstance = extendedObjects.get(instance);
		
		if(extendedInstance == null){
			extendedInstance = new HashMap<String,Object>();
			extendedObjects.put(instance,extendedInstance);
		}
		
		return extendedInstance;
	}
	
    /**
     * Initialize dynamic feature for each EObject of the model
     */
    public void dynamicModelConstructor(Set<EObject> model, IQueryEvaluationEngine aqlEngine) {
		model.forEach(obj -> {
			List<ExtendedClass> extensions = findExtensionFor(obj);
			init(obj, extensions, aqlEngine);
		});
	}
    
    private List<ExtendedClass> findExtensionFor(EObject instance) {
    	return 
    		allImplemModels
	    	.stream()
	    	.flatMap(mb -> mb.getClassExtensions().stream())
	    	.filter(xtdCls -> xtdCls.getBaseClass().isSuperTypeOf(instance.eClass()))
	    	.collect(Collectors.toList());
    }
    
    private void init(EObject instance, List<ExtendedClass> extensions, IQueryEvaluationEngine aqlEngine) {
    	Map<String,Object> extendedInstance = getExtensionFeatures(instance);
    	
    	Map<String,Object> scope = new HashMap<String,Object>();
    	scope.put("self", instance);
    	
    	extensions
			.stream()
			.flatMap(xtdCls -> xtdCls.getAttributes().stream())
			.filter(attr -> attr.getInitialValue() != null)
			.forEach(attr -> {
				AstResult dummyAstResult = new AstResult(attr.getInitialValue(), new HashMap(), new HashMap(), new ArrayList(), new BasicDiagnostic());
				EvaluationResult result = aqlEngine.eval(dummyAstResult, scope); //TODO: forward diagnotic
				Object value = result.getResult();
				extendedInstance.put(attr.getName(), value);
			});
    }
}