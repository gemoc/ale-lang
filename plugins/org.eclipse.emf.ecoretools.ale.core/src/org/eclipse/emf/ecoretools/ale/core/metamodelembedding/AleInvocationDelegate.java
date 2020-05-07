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
package org.eclipse.emf.ecoretools.ale.core.metamodelembedding;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecoretools.ale.core.Activator;
import org.eclipse.emf.ecoretools.ale.core.env.ClosedAleEnvironmentException;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;

/**
 * Represents the actual behavior of an EOperation which body is defined
 * in ALE through an EAnnotation.
 * <p>
 * {@link #dynamicInvoke(InternalEObject, EList) dynamicInvoke} is called each time the EOperation is
 * {@link EObject #eInvoke(EOperation, org.eclipse.emf.common.util.EList) dynamically invoked}.
 */
class AleInvocationDelegate implements InvocationDelegate {

	private final IAleEnvironment environment;
	private final Method method;
	
	/**
	 * Creates a new delegate that executes given method when invoked.
	 * 
	 * @param environment
	 * 			The ALE environment in which the method will be evaluated.
	 * @param method
	 * 			The method to evaluate.
	 */
	AleInvocationDelegate(IAleEnvironment environment, Method method) {
		this.environment = environment;
		this.method = method;
	}
	
	@Override
	public Object dynamicInvoke(InternalEObject target, EList<?> arguments) throws InvocationTargetException {
		try {
			invokeMethodOn(target, arguments);
			environment.getInterpreter().close();
		}
		catch (ClosedAleEnvironmentException e) {
			Activator.error("Unable to call " + method.getOperationRef().getName() + " on " + target, e);
		}
		finally {
			// FIXME [Memory Leak] Ensure interpreter's resources are closed
			//		 We likely can't close the environment here because the delegate may be invoked several times.
			//
			//		 Maybe consider releasing the resources after X times & reloading them later if the delegate is called again?
			//
//			environment.close();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private IEvaluationResult invokeMethodOn(EObject target, List<?> arguments) throws ClosedAleEnvironmentException {
		if (method == null) {
			return null;
		}
		return environment.getInterpreter().eval(target, method, (List<Object>) arguments);
	}

}
