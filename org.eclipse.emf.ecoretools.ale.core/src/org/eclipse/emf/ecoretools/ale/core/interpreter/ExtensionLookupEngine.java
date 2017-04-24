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
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.lookup.basic.BasicLookupEngine;
import org.eclipse.acceleo.query.validation.type.ClassType;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.EvalBodyService;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

//FIXME: would like extend CacheLookupEngine but it's too private
public class ExtensionLookupEngine extends BasicLookupEngine {

	public ExtensionLookupEngine(IReadOnlyQueryEnvironment queryEnvironment) {
		super(queryEnvironment);
	}

	/**
	 * Get all matching services
	 */
	private List<IService> lookupAll(String name, IType[] argumentTypes) {
		
		List<IService> multiMethod = getServices().getMultiService(name, argumentTypes.length);
		if (multiMethod == null) {
			return null;
		} else {
			List<IService> candidates = new ArrayList<IService>();
			for (IService service : multiMethod) {
				if (service.matches(queryEnvironment, argumentTypes)) {
					candidates.add(service);
				}
			}
			return candidates;
		}
	}
	
	/**
	 * Default lookup for ALE
	 */
	@Override
	public IService lookup(String name, IType[] argumentTypes) {
		
		/*
		 * Special case for 'selectedCall' since the number of arguments is dynamic
		 */
		if(name.equals("selectedCall") && argumentTypes.length >= 4) {
			EClassifier eObject = queryEnvironment.getEPackageProvider().getTypes("EObject").iterator().next();
			ClassType stringType = new ClassType(queryEnvironment, String.class);
			
			boolean isMatching = 
				   argumentTypes[0].getType() instanceof EObject // caller
				&& argumentTypes[1].getType() == String.class    // modelUnitID
				&& argumentTypes[2].getType() == String.class    // className
				&& argumentTypes[3].getType() == String.class;   // methodName
			
			if(isMatching) {
				return getServices().getMultiService(name, 5).get(0);
			}
		}
		
		/*
		 * Default
		 */
		List<IService> candidates = lookupAll(name, argumentTypes);
		if(candidates == null) {
			return null;
		}
		else {
			return selectBestCandidate(candidates);
		}
	}
	
	/**
	 * Return the service {@link name} defined in {@className} from {@link modelUnitID}
	 */
	public IService filteredLookup(String modelUnitID, String className, String name, IType[] argumentTypes) {
		List<IService> candidates = lookupAll(name, argumentTypes);
		if(candidates == null) {
			return null;
		}
		else {
			return selectBestCandidate(candidates,modelUnitID,className);
		}
	}
	
	private IService selectBestCandidate(List<IService> candidates) {
		
		List<EvalBodyService> evalServices = 
			candidates
			.stream()
			.filter(srv -> srv instanceof EvalBodyService)
			.map(srv -> (EvalBodyService)srv)
			.collect(Collectors.toList());
		
		if(!evalServices.isEmpty()) {
			
			IService result = null;
			for (EvalBodyService service : evalServices) {
				if (result == null
						
						|| (service.getPriority() > result.getPriority() && service
						.isEqualParameterTypes(queryEnvironment, result))
						
						|| (service.isLowerParameterTypes(queryEnvironment, result)) ) {
					
					result = service;
				}
			}
			return result;
		}
		else { //BasicLookupEngine behavior
			
			IService result = null;
			for (IService service : candidates) {
				if (result == null
						|| service.getPriority() > result.getPriority()
						|| (service.getPriority() == result.getPriority() && service
								.isLowerOrEqualParameterTypes(queryEnvironment, result))) {
					result = service;
				}
			}
			return result;
		}
	}
	
	private IService selectBestCandidate(List<IService> candidates, String modelUnitID, String className) {
		
		/*
		 * Filter EvalBodyService
		 */
		List<EvalBodyService> evalServices = 
				candidates
				.stream()
				.filter(srv -> srv instanceof EvalBodyService)
				.map(srv -> (EvalBodyService)srv)
				.collect(Collectors.toList());
		
		/*
		 * Filter ModelUnit.className
		 */
		List<EvalBodyService> matchingServices = new ArrayList<EvalBodyService>();
		if(!evalServices.isEmpty()) {
			for (EvalBodyService service : evalServices) {
				BehavioredClass behavioredClass = (BehavioredClass) service.getImplem().eContainer();
				ModelUnit unit = (ModelUnit) behavioredClass.eContainer();
				if(behavioredClass.getName().equals(className) && unit.getName().equals(modelUnitID)) {
					matchingServices.add(service);
				}
			}
		}
		
		/*
		 * Filter arguments types & priority (BasicLookupEngine behavior)
		 */
		if(!matchingServices.isEmpty()) {
			IService result = null;
			for (IService service : matchingServices) {
				if (result == null
						|| service.getPriority() > result.getPriority()
						|| (service.getPriority() == result.getPriority() && service
								.isLowerOrEqualParameterTypes(queryEnvironment, result))) {
					result = service;
				}
			}
			return result;
		}
		
		return null; //TODO: service not found error
	}
}
