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
package org.eclipse.emf.ecoretools.ale.validation;

import static java.util.stream.Collectors.joining;
import static org.eclipse.emf.ecoretools.ale.core.validation.QualifiedNames.getQualifiedName;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;

import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.osgi.util.NLS;

/**
 * Helper class to obtains translated strings.
 */
public final class AleEditorMessages extends NLS {
	
	private static final String BASE_NAME = "org.eclipse.emf.ecoretools.ale.validation.ale_editor_messages"; //$NON-NLS-1$

    static {
    	// load message values from bundle file
    	NLS.initializeMessages(BASE_NAME, AleEditorMessages.class);
    }

    public static String ADD_ASSIGN_ILLEGAL;
    public static String SUB_ASSIGN_ILLEGAL;
    public static String TYPE_MISMATCH;
    public static String ASSIGN_ILLEGAL;
    public static String OPEN_CLASS_DUPLICATION;
    public static String ATTRIBUTE_NOT_FOUND;
    public static String METHOD_NOT_FOUND;
    public static String VARIABLE_NOT_FOUND;
    public static String VARIABLE_ALREADY_BOUND;
    public static String EXTENDS_ORDER;
    public static String NOT_AN_OPENABLE_CLASS;
    public static String OPENING_A_NON_EXISTING_CLASS;
    public static String OPENED_CLASS_HAS_NAMESAKES;
    public static String VOID_RESULT_ASSIGN;
    public static String UNRESOLVED_TYPE;
    public static String ASSIGNMENT_TO_SELF;
    public static String UNSUPPORTED_OPERATOR;
    public static String INDIRECT_EXTENSION;
    public static String NOT_ITERABLE;
    public static String MISSING_RETURN_STATEMENT;
    public static String ASSIGNMENT_TO_PARAMETER;
    public static String OVERRIDDEN_METHOD_NOT_FOUND;
    public static String METHOD_ALREADY_DECLARED;
    public static String SELF_RESERVED;
    public static String RESULT_RESERVED;
    public static String EXTENDING_ITSELF;
    public static String METHOD_ALREADY_DEFINED;
    
    public static String assignIllegal(String valueTypes, String variableTypes, String expectedTypes) {
    	return MessageFormat.format(ASSIGN_ILLEGAL, valueTypes, variableTypes, expectedTypes);
    }
    
    public static String addAssignIllegal(String valueTypes, String variableTypes, String expectedTypes) {
    	return MessageFormat.format(ADD_ASSIGN_ILLEGAL, valueTypes, variableTypes, expectedTypes);
    }
    
    public static String subAssignIllegal(String valueTypes, String variableTypes, String expectedTypes) {
    	return MessageFormat.format(SUB_ASSIGN_ILLEGAL, valueTypes, variableTypes, expectedTypes);
    }
    
    public static String typeMismatch(String expectedTypes, String actualTypes) {
    	return MessageFormat.format(TYPE_MISMATCH, actualTypes, expectedTypes);
    }
    
    public static String extendingItself(String className) {
    	return MessageFormat.format(EXTENDING_ITSELF, className);
    }
    
    public static String indirectExtension(EClass openClass, EClass inheritedClass) {
    	return MessageFormat.format(INDIRECT_EXTENSION, getQualifiedName(inheritedClass), getQualifiedName(openClass));
    }
    
    public static String overriddenMethodNotFound(BehavioredClass behavioredClass) {
    	return MessageFormat.format(OVERRIDDEN_METHOD_NOT_FOUND, behavioredClass.getName());
    }

    public static String assignmentToParameter(String name) {
    	return MessageFormat.format(ASSIGNMENT_TO_PARAMETER, name);
    }
    
    public static String methodAlreadyDeclared(String name) {
    	return MessageFormat.format(METHOD_ALREADY_DECLARED, name);
    }
    
	public static String variableNotFound(String name) {
		return MessageFormat.format(VARIABLE_NOT_FOUND, name);
	}
	
	public static String notIterable(List<IType> actualTypes) {
		return MessageFormat.format(NOT_ITERABLE, commaSeparated(actualTypes));
	}

	public static String variableAlreadyBound(String name) {
		return MessageFormat.format(VARIABLE_ALREADY_BOUND, name);
	}

	public static String selfReserved() {
		return SELF_RESERVED;
	}
	
	public static String resultReserved() {
		return RESULT_RESERVED;
	}
	
	public static String assignmentToSelf() {
		return ASSIGNMENT_TO_SELF;
	}
	
    public static String assignmentToResultInVoidMethod() {
    	return VOID_RESULT_ASSIGN;
    }
    
    public static String missingReturnStatement() {
    	return MISSING_RETURN_STATEMENT;
    }
    
    public static String unsupportedOperator(String name, String operator) {
    	return MessageFormat.format(UNSUPPORTED_OPERATOR, name, operator);
    }
    
    public static String unresolvedType(String name, String availableEPackages) {
    	return MessageFormat.format(UNRESOLVED_TYPE, name, availableEPackages);
    }
    
    public static String classIsAlreadyOpened(ExtendedClass extendedClass) {
    	return MessageFormat.format(OPEN_CLASS_DUPLICATION, extendedClass.getName());
    }
    
    public static String wrongExtendsOrder(EClass baseClass, EClass superBase) {
    	return MessageFormat.format(EXTENDS_ORDER, baseClass.getName(), superBase.getName());
    }
    
    public static String notAnOpenableClass(String className) {
    	return MessageFormat.format(NOT_AN_OPENABLE_CLASS, className);
    }
    
    public static String openingANonExistingClass(String className) {
    	return MessageFormat.format(OPENING_A_NON_EXISTING_CLASS, className);
    }
    
    public static String openedClassHasNamesakes(String className, Collection<EPackage> namesakes) {
    	return MessageFormat.format(OPENED_CLASS_HAS_NAMESAKES, listed(namesakes));
    }

    public static String attributeNotFound(String name, String owner) {
    	return MessageFormat.format(ATTRIBUTE_NOT_FOUND, name, owner);
    }

	public static String methodNotFound(String signature, BehavioredClass owner) {
		return MessageFormat.format(METHOD_NOT_FOUND, signature, owner.getName());
	}

	public static String methodAlreadyDefinedInBaseClass(String signature) {
		return MessageFormat.format(METHOD_ALREADY_DEFINED, signature);
	}
    
	public static String repr(Collection<IType> expectedTypes) {
		if (expectedTypes.size() == 1) {
			return getQualifiedName(expectedTypes.iterator().next());
		}
		else {
			return commaSeparated(expectedTypes);
		}
	}
	
	private static String commaSeparated(Collection<IType> types) {
		return types.stream()
					.map(type -> getQualifiedName(type))
					.sorted()
					.distinct()
					.collect(joining(",", "[", "]"));
	}
	
	private static <T> String listed(Collection<T> elements) {
		return elements.stream()
					   .map(Object::toString)
					   .collect(joining("\r\n - ", " - ", ""));
	}

}
