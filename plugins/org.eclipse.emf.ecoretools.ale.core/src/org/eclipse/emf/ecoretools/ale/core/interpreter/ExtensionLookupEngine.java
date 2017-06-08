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
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.lookup.basic.BasicLookupEngine;
import org.eclipse.acceleo.query.validation.type.ClassType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.EvalBodyService;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

import com.google.common.collect.Lists;

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
			return selectBestCandidate(candidates, argumentTypes);
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
	
	private IService selectBestCandidate(List<IService> candidates, IType[] argumentTypes) {
		
		List<EvalBodyService> evalServices = 
			candidates
			.stream()
			.filter(srv -> srv instanceof EvalBodyService)
			.map(srv -> (EvalBodyService)srv)
			.collect(Collectors.toList());
		
		Object callerType = argumentTypes[0].getType();
		if(!evalServices.isEmpty() && callerType instanceof EClass) {
			
			IService selection = null;
			int distance = -1; //TODO: compute distance table at parse time
			for (EvalBodyService service : evalServices) {
				if (selection == null) {
					selection = service;
					distance = getDistance((EClass) callerType,(EClass) service.getParameterTypes(queryEnvironment).get(0).getType());
				}
				else {
					int newDistance = getDistance((EClass) callerType,(EClass) service.getParameterTypes(queryEnvironment).get(0).getType());
					if(newDistance < distance) {
						selection = service;
						distance = newDistance;
					}
					else if(selection.getParameterTypes(queryEnvironment).get(0).getType() == service.getParameterTypes(queryEnvironment).get(0).getType()) {
						if(service.getPriority() > selection.getPriority() 
								|| service.isLowerOrEqualParameterTypes(queryEnvironment, selection)){
							selection = service;
						}
					}
				}
			}
			
			return selection;
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
	
	private int getDistance(EClass source, EClass target) {
		EList<EClass> superTypes = getEAllSuperTypes(source);
		return superTypes.indexOf(target);
	}
	
	/**
	 * Get all super type in Breadth-first (right to left) order, include {@link cls}
	 */
	private EList<EClass> getEAllSuperTypes(EClass cls) {
		
		EList<EClass> result = new BasicEList<EClass>();
		
		LinkedList<EClass> toVisit = new LinkedList<EClass>();
		toVisit.add(cls);
		
		while(!toVisit.isEmpty()) {
			EClass current = toVisit.poll();
			if(!result.contains(current)) {
				result.add(current);
				Lists.reverse(current.getESuperTypes())
					.forEach(elem -> toVisit.offer(elem));
			}
		}
		
		return result;
	}
}
