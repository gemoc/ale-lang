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

import org.eclipse.acceleo.query.validation.type.IType;

/**
 * Thrown when an AQL service is called but does not exist. 
 */
public class ServiceNotFoundException extends RuntimeException {
	
	/**
	 * Generated serial UID.
	 */
	private static final long serialVersionUID = -6902776691459890930L;

	private final String name;
	private final transient List<IType> argumentTypes;
	private final transient List<Object> arguments;

	public ServiceNotFoundException(String name, String signature, List<IType> argumentTypes, List<Object> arguments) {
		super("AQL service '" + signature + "' could not be found");
		this.name          = name;
		this.argumentTypes = argumentTypes;
		this.arguments     = arguments;
	}

	public String getServiceName() {
		return name;
	}

	public List<IType> getArgumentTypes() {
		return argumentTypes;
	}

	public List<Object> getArguments() {
		return arguments;
	}
	
}
