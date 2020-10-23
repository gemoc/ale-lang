/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.interpreter.internal;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;
import static org.eclipse.emf.ecoretools.ale.core.validation.QualifiedNames.getQualifiedName;

import java.text.MessageFormat;
import java.util.Collection;

import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.osgi.util.NLS;

/**
 * Helper class to obtains translated strings.
 */
@SuppressWarnings("squid:S3008")
public final class Messages extends NLS {
	
	private static final String BASE_NAME = "org.eclipse.emf.ecoretools.ale.core.interpreter.internal.messages"; //$NON-NLS-1$

    static {
    	// load message values from bundle file
    	NLS.initializeMessages(BASE_NAME, Messages.class);
    }

    public static String UNSUPPORTED_INSERTION;
    public static String UNSUPPORTED_REMOVAL;
    public static String ILLEGAL_INSERTION;
    public static String ILLEGAL_REMOVAL;
    public static String ILLEGAL_REMOVAL_FROM_COLLECTION;
    public static String IF_GUARD_IS_NOT_BOOLEAN;
    public static String ATTRIBUTE_NOT_FOUND;
    public static String VARIABLE_NOT_FOUND;
    public static String UNINITIALIZED;
    public static String METHOD_NOT_FOUND;
    public static String TYPE_MISMATCH;
    public static String CODE_SNIPPET;
    public static String PROPOSITIONS;
    public static String VARIABLE_ALREADY_BOUND;
    public static String ALREADY_DECLARED_HERE;
    public static String UNDECLARED_VARIABLE;
    public static String RESULT_NOT_AVAILABLE_IN_VOID_METHOD;
    public static String RESERVED_KEYWORD;
    public static String SELF_CANNOT_BE_ASSIGNED;
    public static String MISSING_RESULT_ASSIGNMENT;
    public static String METHOD_MUST_ASSIGN_RESULT;
    public static String UNSUPPORTED_OPERATOR;
    public static String CANNOT_ITERATE;
    public static String TYPE_NOT_FOUND;
    public static String SHOULD_BE;
    
    public static String shouldBe(String className) {
    	return MessageFormat.format(SHOULD_BE, className);
    }
    
    public static String typeNotFound(String className) {
    	return MessageFormat.format(TYPE_NOT_FOUND, className);
    }
    
    public static String cannotIterateOver(String className) {
    	return MessageFormat.format(CANNOT_ITERATE, className);
    }
    
    public static String alreadyDeclaredHere(String sourceFile, int line) {
    	return MessageFormat.format(ALREADY_DECLARED_HERE, sourceFile, line);
    }
    
    public static String unsupportedOperator(String operator, String className) {
    	return MessageFormat.format(UNSUPPORTED_OPERATOR, operator, className);
    }
    
    public static String resultNotAvailableInVoidMethod() {
    	return RESULT_NOT_AVAILABLE_IN_VOID_METHOD;
    }
    
    public static String reservedKeyword() {
    	return RESERVED_KEYWORD;
    }
    
    public static String selfCannotBeAssigned() {
    	return SELF_CANNOT_BE_ASSIGNED;
    }
    
    public static String undeclaredVariable(String name, String declaration) {
    	return MessageFormat.format(UNDECLARED_VARIABLE, name, declaration);
    }
    
    public static String methodNotFound(String methodSignature, String callerClass) {
    	return MessageFormat.format(METHOD_NOT_FOUND, methodSignature, callerClass);
    }
    
    public static String methodMustAssignResult(EOperation operation) {
    	String arguments = operation.getEParameters().stream().map(p -> p.getEType().getName()).collect(joining(", ")); 
    	String signature = operation.getName() + "(" + arguments + ")";
    	return MessageFormat.format(METHOD_MUST_ASSIGN_RESULT, signature);
    }
    
    public static String missingResultAssignment(String methodName) {
    	return MessageFormat.format(MISSING_RESULT_ASSIGNMENT, methodName);
    }
    
    public static String propositions(String propositions) {
    	return MessageFormat.format(PROPOSITIONS, propositions);
    }
    
    public static String variableAlreadyBound(String name) {
    	return MessageFormat.format(VARIABLE_ALREADY_BOUND, name);
    }
    
    public static String attributeNotFound(String attributeName, String className) {
    	return MessageFormat.format(ATTRIBUTE_NOT_FOUND, attributeName, className);
    }
    
    public static String variableNotFound(String name) {
    	return MessageFormat.format(VARIABLE_NOT_FOUND, name);
    }
    
    public static String uninitializedVariableOrFeature(String varName) {
    	return MessageFormat.format(UNINITIALIZED, varName);
    }
    
    public static String typeMismatch(Collection<IType> expectedTypes, Collection<IType> actualTypes) {
    	String expected = repr(expectedTypes);
    	String actual = repr(actualTypes);
    	return MessageFormat.format(TYPE_MISMATCH,
    			expected,
    			actual
		);
    }
    
    public static String codeSnippet(int line, String wholeCode) {
    	String snippet = "";
    	String lines[] = wholeCode.split("\\r?\\n");
    	
    	for (int i = 0; i < lines.length; i++) {
    		snippet += MessageFormat.format(CODE_SNIPPET,
    				line + i,
    				lines[i] 
			);
    		if (i + 1 < lines.length) {
    			snippet += lineSeparator();
    		}
		}
    	return snippet;
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

}
