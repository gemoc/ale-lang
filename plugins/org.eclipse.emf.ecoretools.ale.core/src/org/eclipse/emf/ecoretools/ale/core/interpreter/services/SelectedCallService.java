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

import static com.google.common.collect.Sets.newHashSet;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.validation.type.ClassType;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.NothingType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.Activator;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.ExtensionLookupEngine;
import org.eclipse.emf.ecoretools.ale.core.validation.IConvertType;
import org.eclipse.emf.ecoretools.ale.core.validation.impl.ConvertType;

/**
 * AQL service that calls a specific implementation based on the qualified name of the BehavioredClass.
 */
public class SelectedCallService {

	private ExtensionLookupEngine lookupEngine;
	private IQueryEnvironment queryEnvironment;
	private IConvertType convert;
	
	public SelectedCallService(IQueryEnvironment queryEnvironment, ExtensionLookupEngine lookupEngine) {
		this.queryEnvironment = queryEnvironment;
		this.lookupEngine = lookupEngine;
		this.convert = new ConvertType(queryEnvironment);
	}
	
	public IService createService() {
		try {
			Method method = SelectedCallService.class.getMethod("selectedCall", EObject.class, String.class, String.class, String.class, Object[].class);
			return new JavaMethodService(method, this) {
				@Override
				protected Object internalInvoke(Object[] arguments) throws Exception {
					
					/*
					 * Convert last arguments to an array of Objects
					 */
					List<Object> allArgs = Arrays.asList(arguments);
					List<Object> invokeArgs = new ArrayList<>(allArgs);
					if(arguments.length > 4) {
						//Skip caller, modelUnitID, className & methodName
						List<Object> selection = allArgs.subList(0, 4);
						Object[] realArgs = allArgs.subList(4, allArgs.size()).toArray();
						
						invokeArgs.retainAll(selection);
						invokeArgs.add(realArgs);
					}
					else {
						Object[] realArgs = Arrays.asList().toArray();
						invokeArgs.add(realArgs);
					}
					return method.invoke(SelectedCallService.this, invokeArgs.toArray());
				}

				@Override
				public Set<IType> getType(Call call, ValidationServices services, IValidationResult validationResult, IReadOnlyQueryEnvironment queryEnvironment, List<IType> argTypes) {
					// FIXME The type checker allows 'NothingType' to be assigned to any variable
					//		 This is unsafe, but makes the SelectedCall service usable until a solution is found 
					return newHashSet(new NothingType("SelectedCallService cannot determine the return type of the method"));
				}
				
			};
		}
		catch (NoSuchMethodException | SecurityException e) {
			// Should never happen
			Activator.error("Cannot create the SelectedCallService service", e);
		}
		return null;
	}
	
	/**
	 * Call an explicitly selected implementation.
	 */
	public Object selectedCall(EObject caller, String modelUnitID, String className, String methodName, Object[] args) {
		
		//TODO: behave like EvaluationServices.call for errors
		List<Object> allArgs = Arrays.asList(caller);
		allArgs = new ArrayList<>(allArgs);
		Collections.addAll(allArgs, args);
		
		IType[] types = getArgumentTypes(allArgs.toArray());
		IService service = lookupEngine.filteredLookup(modelUnitID, className, methodName, types);
		
		return service.invoke(allArgs.toArray());
	}
	
	/**
	 * Build the argument {@link IType} array that corresponds to the specified arguments array.
	 * 
	 * @param arguments
	 *            the argument from which types are required
	 * @return the argument {@link IType} array that corresponds to the specified arguments array
	 */
	private IType[] getArgumentTypes(Object[] arguments) {
		// FIXME use this.convert
		IType[] argumentTypes = new IType[arguments.length];
		for (int i = 0; i < arguments.length; i++) {
			if (arguments[i] == null) {
				argumentTypes[i] = new ClassType(queryEnvironment, null);
			} else if (arguments[i] instanceof EObject) {
				argumentTypes[i] = new EClassifierType(queryEnvironment, ((EObject)arguments[i]).eClass());
			} else {
				argumentTypes[i] = new ClassType(queryEnvironment, arguments[i].getClass());
			}
		}
		return argumentTypes;
	}
}
