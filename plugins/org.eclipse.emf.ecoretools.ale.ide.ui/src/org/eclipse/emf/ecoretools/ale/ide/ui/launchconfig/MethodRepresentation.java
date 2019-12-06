/*******************************************************************************
 * Copyright (c) 2019 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig;

import static java.util.stream.Collectors.joining;

import java.util.List;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.ale.core.validation.QualifiedNames;
import org.eclipse.emf.ecoretools.ale.ide.ui.Activator;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;

/**
 * Provides a textual representation of a {@link Method}.
 * <p>
 * This representation is of the form:
 * <ul>
 * 	<li><code><i>method_name</i>(<i>param1</i>, <i>param2</i>) on <i>target</i> (<i>caller</i>)</code>
 * </ul>
 * <p>
 * For instance:
 * <ul>
 * 	<li><code>helloworld::HelloWorld.main() on MyWorld (helloworld::HelloWorld)</code>
 * </ul>
 */
public class MethodRepresentation {
	/**
	 * The method to represent.
	 */
	private final Method method;
	/**
	 * The class that owns the method (typically an instance of {@link BehavioredClass}).
	 */
	private final EObject owner;
	/**
	 * The element on which the method is called.
	 */
	private final EObject target;
	
	private MethodRepresentation(Method method, EObject owner, EObject target) {
		this.method = method;
		this.owner = owner;
		this.target = target;
	}

	/**
	 * Creates a new method representation.
	 * 
	 * @param method
	 * 			The method to represent
	 * @param owner
	 * 			The class that owns the method (typically an instance of {@link BehavioredClass})
	 * 
	 * @return the representation of the method.
	 */
	public static MethodRepresentation of(Method method, EObject owner) {
		return of(method, owner, null);
	}

	/**
	 * Creates a new method representation.
	 * 
	 * @param method
	 * 			The method to represent
	 * @param owner
	 * 			The class that owns the method (typically an instance of {@link BehavioredClass})
	 * @param target
	 * 			The element on which the method is called
	 * 
	 * @return the representation of the method.
	 */
	public static MethodRepresentation of(Method method, EObject owner, EObject target) {
		return new MethodRepresentation(method, owner, target);
	}
	
	@Override
	public String toString() {
		EOperation operation = method.getOperationRef();
		String ownerName = getQualifiedName(method.eContainer());
		String commaSeparatedParameters = commaSeparated(operation.getEParameters());
		String representation = ownerName + "." + operation.getName() + "(" + commaSeparatedParameters + ")";
		if (owner != null) {
			representation += " on " + targetAsString(target, owner);
		}
		return representation;
	}
	
	private static String targetAsString(EObject target, EObject owner) {
		if (target == null) {
			return getQualifiedName(owner);
		}
		else {
			return getName(target, owner);
		}
	}
	
	private static String getName(EObject target, EObject owner) {
		EStructuralFeature nameFeature = target.eClass().getEStructuralFeature("name");
		if (nameFeature != null) {
			String name = "" + target.eGet(nameFeature);
			return name + " (" + getQualifiedName(owner) + ")";
		}
		return getQualifiedName(owner);
	}
	
	private static String getQualifiedName(EObject element) {
		if (element instanceof ExtendedClass) {
			return QualifiedNames.getQualifiedName(((ExtendedClass) element).getBaseClass());
		}
		else if (element instanceof EClassifier) {
			return QualifiedNames.getQualifiedName((EClassifier) element);
		}
		else {
			// Should never happen
			Activator.warn("Cannot determine label for method owner: " + element, null);
			return "" + element;
		}
	}

	private static String commaSeparated(List<EParameter> parameters) {
		return parameters.stream()
						 .map(EParameter::getEType)
						 .map(MethodRepresentation::getQualifiedName)
						 .collect(joining(", "));
	}

}
