/*******************************************************************************
 * Copyright (c) 2020 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.interpreter;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.env.ClosedAleEnvironmentException;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.notapi.AleEngine;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.sirius.common.tools.api.interpreter.IEvaluationResult;

/**
 * Instances of this class are able to execute an {@link EObject} while taking
 * ALE behaviors into account.
 * <p> 
 * Use {@link IAleEnvironment#getInterpreter()} to get a reliable interpreter.
 * <p>
 * Interpreters must be closed to prevent memory leaks. Interpreters delivered by
 * an environment {@link IAleEnvironment#close() do not have to be closed manually}.
 */
public interface IAleInterpreter extends AutoCloseable {
    
	/**
	 * Returns the logger used by the interpreter.
	 * <p>
	 * Can be used to access stacktraces.
	 * 
	 * @return the logger used by the interpreter.
	 */
    DiagnosticLogger getLogger();
	
	/**
	 * Calls the {@code main} method onto {@code caller}, passing {@code args}.
	 * <p>
	 * <strong>Caution</strong>: all objects must belong to the same environment.
	 * {@code caller} must have been 
	 * {@link IAleEnvironment#loadModel(org.eclipse.emf.common.util.URI) loaded from the environment}
	 * and {@code main} must come from 
	 * {@link IAleEnvironment#getBehaviors() environment's behaviors}.
	 * 
	 * @param caller
	 * 			The object on which the main method will be called.
	 * @param main
	 * 			The method to call on the caller.
	 * @param args
	 * 			The arguments that will be passed to the method.
	 * @return
	 */
	IEvaluationResult eval(EObject caller, Method main, List<Object> args) throws ClosedAleEnvironmentException;

	/**
	 * Registers services for each methods from a list of qualified class names.
	 * 
	 * @param services
	 * 			The new services to register.
	 */
	void registerServices(Iterable<String> services);

	/**
	 * Declare plug-ins & projects where services can be found.
	 * 
	 * @param plugins
	 * 			The names of the plug-ins providing services.
	 * @param project
	 * 			The names of the plug-ins providing services.
	 */
	void initScope(Set<String> plugins, Set<String> project);
    
    /**
     * Returns the engine used by the ongoing evaluation.
     * @return the engine if the evaluation has started, null otherwise
     * 
     * @deprecated does not seem to be used
     */
	@Deprecated
	AleEngine getCurrentEngine();

	/**
	 * Registers a new listener that will be notified each time an AQL service is called.
	 * 
	 * @param listener
	 * 			The listener to register.
	 */
    void addServiceListener(IServiceCallListener listener);

    /**
     * Returns all the service listeners currently registered.
     * @return all the service listeners currently registered
     */
	List<IServiceCallListener> getServiceListeners();
	
	/**
	 * Releases any resource held by this interpreter.
	 * <p>
	 * Interpreters delivered by an environment 
	 * {@link IAleEnvironment#close() do not have to be closed manually}.
	 */
	void close();
}
