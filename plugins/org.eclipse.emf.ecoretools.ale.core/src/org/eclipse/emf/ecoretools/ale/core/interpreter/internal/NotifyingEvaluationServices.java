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
package org.eclipse.emf.ecoretools.ale.core.interpreter.internal;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.eclipse.acceleo.query.parser.AstBuilderListener;
import org.eclipse.acceleo.query.runtime.AcceleoQueryEvaluationException;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.impl.EvaluationServices;
import org.eclipse.acceleo.query.runtime.impl.Nothing;
import org.eclipse.acceleo.query.validation.type.ClassType;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.NothingType;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IServiceCallListener;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ServiceNotFoundException;

/**
 * Represent the set of callable AQL services and provides API to call them.
 * <p>
 * {@link IServiceCallListener Listeners} can be registered to be notified
 * each time an AQL service is called.
 * <p>
 * Relies on {@link IQueryEnvironment#getLookupEngine() query environment's lookup engine}
 * to find available AQL services.
 */
public class NotifyingEvaluationServices extends EvaluationServices {

	private static final String INTERNAL_ERROR_MSG = "An internal error occured during evaluation of a query";
	
	private List<IServiceCallListener> listeners;
	
	/**
	 * Creates a new instance representing the set of callable AQL services.
	 * 
	 * @param queryEnv
	 * 			The AQL context that actually stores the AQL services.
	 */
	public NotifyingEvaluationServices(IReadOnlyQueryEnvironment queryEnv) {
		super(queryEnv);
		this.listeners = new ArrayList<>();
	}
	
	/**
	 * Creates a new instance representing the set of callable AQL services.
	 * 
	 * @param queryEnv
	 * 			The AQL context that actually stores the AQL services.
	 * @param listeners
	 * 			The listeners to notify each time an AQL service is called.
	 */
	public NotifyingEvaluationServices(IReadOnlyQueryEnvironment queryEnv, List<IServiceCallListener> listeners) {
		super(queryEnv);
		this.listeners = listeners;
	}

	@Override
	public Object call(String serviceName, Object[] arguments, Diagnostic diagnostic) {
		final Object result;

		if (arguments.length == 0) {
			throw new AcceleoQueryEvaluationException(
					"An internal error occured during evaluation of a query : at least one argument must be specified for service "
							+ serviceName + ".");
		}
		try {
			IType[] argumentTypes = getArgumentTypes(arguments);
			Optional<Nothing> unresolvedArgument = Arrays.stream(arguments).filter(Nothing.class::isInstance).map(Nothing.class::cast).findFirst();
			if (unresolvedArgument.isPresent()) {
				// May happen because #callService returns Nothing in case of error
				return unresolvedArgument.get();
			}
			else {
				IService service = queryEnvironment.getLookupEngine().lookup(serviceName, argumentTypes);
				if (service == null) {
					throw new ServiceNotFoundException(serviceName, serviceSignature(serviceName, argumentTypes), asList(argumentTypes), asList(arguments));
				}
				listeners.forEach(l -> l.preCall(service, arguments));
				result = callService(service, arguments, diagnostic);
				listeners.forEach(l -> l.postCall(service, arguments,result));
				return result;
			}
			// CHECKSTYLE:OFF
		} catch (Exception e) {
			// CHECKSTYLE:ON
			throw new AcceleoQueryEvaluationException(INTERNAL_ERROR_MSG, e);
		}
	}
	
	//FIXME: copy-pasted private methods below
	private Object callService(IService service, Object[] arguments, Diagnostic diagnostic) {
		try {
			final Object result = service.invoke(arguments);
			if (result instanceof Nothing) {
				addDiagnosticFor(diagnostic, Diagnostic.WARNING, (Nothing)result);
			}
			return result;
		} catch (AcceleoQueryEvaluationException e) {
			Nothing placeHolder = new Nothing(e.getMessage(), e);
			if (e.getCause() instanceof AcceleoQueryEvaluationException) {
				addDiagnosticFor(diagnostic, Diagnostic.WARNING, placeHolder);
			} else {
				addDiagnosticFor(diagnostic, Diagnostic.ERROR, placeHolder);
			}
			return placeHolder;
		}
	}
	
	private void addDiagnosticFor(Diagnostic chain, int severity, Nothing nothing) {
		if (chain instanceof DiagnosticChain) {
			Diagnostic child = new BasicDiagnostic(severity, AstBuilderListener.PLUGIN_ID, 0, nothing
					.getMessage(), new Object[] {nothing.getCause(), });
			((DiagnosticChain)chain).add(child);
		}
	}
	
	private IType[] getArgumentTypes(Object[] arguments) {
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
	
	private Nothing nothing(String message, Object... msgArgs) {
		String formatedMessage = String.format(message, msgArgs);
		return new Nothing(formatedMessage);
	}
}
