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
package org.eclipse.emf.ecoretools.ale.core.diagnostics.impl;

import static java.lang.Math.max;
import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;
import static org.eclipse.emf.ecoretools.ale.core.interpreter.internal.Messages.repr;
import static org.eclipse.emf.ecoretools.ale.core.validation.QualifiedNames.getQualifiedName;

import java.util.Collection;

import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToResultInVoidOperation;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IDiagnosticFormatter;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MissingReturnStatement;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.NotIterable;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.util.DiagnosticsSwitch;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.LookalikeStrings;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.Messages;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.Scopes;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.Scopes.Scope;

import com.google.common.base.Strings;

/**
 * Turns {@link Message}s into String aimed at be printed in the console.
 */
public class ConsoleDiagnosticsFormatter extends DiagnosticsSwitch<String> implements IDiagnosticFormatter {
	
	@Override
	public String adapt(EObject element) {
		return doSwitch(element);
	}

	@Override
	public String caseAssignmentToResultInVoidOperation(AssignmentToResultInVoidOperation error) {
		String headline  = Messages.variableNotFound(error.getName());
		String snippet   = Messages.codeSnippet(error.getLocation().getLine(), error.getWholeCode());
		String underline = underlineFirst(snippet, error.getIncriminatedCode());
		String advises   = Messages.resultNotAvailableInVoidMethod() + " " + replacementProposals(error.getName(), getScope(error).getVariableNames());
		return headline + nlnl() + snippet + nl() + underline + nl() + advises;
	}
	
	@Override
	public String caseProhibitedAssignmentToSelf(ProhibitedAssignmentToSelf error) {
		String headline  = Messages.selfCannotBeAssigned();
		String snippet   = Messages.codeSnippet(error.getLocation().getLine(), error.getWholeCode());
		String underline = underlineFirst(snippet, error.getIncriminatedCode());
		String excerpt   = low(Messages.reservedKeyword());
		return headline + nlnl() + snippet + nl() + underline + " " + excerpt;
	}
	
	@Override
	public String caseAttributeNotFound(AttributeNotFound error) {
		String headline  = Messages.attributeNotFound(error.getName(), error.getOwner().getName());
		String snippet   = Messages.codeSnippet(error.getLocation().getLine(), error.getWholeCode());
		String underline = underlineFirst(snippet, error.getIncriminatedCode());
		return headline + nlnl() + snippet + nl() + underline;
	}

	@Override
	public String caseInternalError(InternalError object) {
		return object.getStacktrace().stream()
					 .map(String::valueOf)
					 .collect(joining(nl()));
	}
	
	@Override
	public String caseMethodNotFound(MethodNotFound error) {
		String headline  = Messages.methodNotFound(error.getName(), getQualifiedName(error.getArgumentTypes().get(0)));
		String snippet   = Messages.codeSnippet(error.getLocation().getLine(), error.getWholeCode());
		String underline = underlineFirst(snippet, error.getIncriminatedCode());
		return headline + nlnl() + snippet + nl() + underline;
	}

	@Override
	public String caseMissingReturnStatement(MissingReturnStatement error) {
		String headline  = Messages.methodMustAssignResult(error.getMethod().getOperationRef());
		String snippet   = Messages.codeSnippet(error.getLocation().getLine(), error.getWholeCode());
		String underline = underlineLast(snippet, "}");
		String excerpt   = Messages.missingResultAssignment(error.getMethod().getOperationRef().getName());
		return headline + nlnl() + snippet + nl() + underline + " " + excerpt;
	}

	@Override
	public String caseNotIterable(NotIterable error) {
		String headline  = Messages.cannotIterateOver(repr(error.getActualTypes()));
		String snippet   = Messages.codeSnippet(error.getLocation().getLine(), error.getWholeCode());
		String underline = underlineLast(snippet, error.getIncriminatedCode());
		String excerpt   = "should be a Sequence or an OrderedSet";
		return headline + nlnl() + snippet + nl() + underline + " " + excerpt;
	}

	@Override
	public String caseTypeMismatch(TypeMismatch error) {
		String headline  = Messages.typeMismatch(error.getExpectedTypes(), error.getActualTypes());
		String snippet   = Messages.codeSnippet(error.getLocation().getLine(), error.getWholeCode());
		String underline = underlineFirst(snippet, error.getIncriminatedCode());
		String excerpt   = Messages.shouldBe(repr(error.getExpectedTypes()));
		return headline + nlnl() + snippet + nl() + underline + " " + excerpt;
	}

	@Override
	public String caseTypeNotFound(TypeNotFound error) {
		String headline  = Messages.typeNotFound(error.getName());
		String snippet   = Messages.codeSnippet(error.getLocation().getLine(), error.getWholeCode());
		String underline = underlineFirst(snippet, error.getIncriminatedCode());
		return headline + nlnl() + snippet + nl() + underline;
	}

	@Override
	public String caseUnsupportedOperator(UnsupportedOperator error) {
		String headline  = Messages.unsupportedOperator(op(error.getOperator()), typeAsString(error.getTarget()));
		String snippet   = Messages.codeSnippet(error.getLocation().getLine(), error.getWholeCode());
		String underline = underlineFirst(snippet, error.getIncriminatedCode());
		return headline + nlnl() + snippet + nl() + underline;
	}

	@Override
	public String caseVariableAlreadyDefined(VariableAlreadyDefined error) {
		String headline  = Messages.variableAlreadyBound(error.getName());
		String snippet   = Messages.codeSnippet(error.getLocation().getLine(), error.getWholeCode());
		String underline = underlineFirst(snippet, error.getIncriminatedCode());
		String excerpt   = low(Messages.alreadyDeclaredHere(error.getDuplicateLocation().getSource(), error.getDuplicateLocation().getLine()));
		return headline + nlnl() + snippet + nl() + underline + " " + excerpt;
	}

	@Override
	public String caseVariableNotFound(VariableNotFound error) {
		String headline  = Messages.variableNotFound(error.getName());
		String snippet   = Messages.codeSnippet(error.getLocation().getLine(), error.getWholeCode());
		String underline = underlineFirst(snippet, error.getIncriminatedCode());
		String advises   = replacementProposals(error.getName(), getScope(error).getVariableNames());
		return headline + nlnl() + snippet + nl() + underline + nl() + advises;
	}

	private static String doPropositions(String actual, Collection<String> expected) {
		LookalikeStrings lookalikes = LookalikeStrings.compare(actual).with(expected).now();

		String onePerLine = lookalikes.getNBests(4).stream()
							  .map(lookalike -> "    " + lookalike)
							  .collect(joining(lineSeparator()));
		
		return Messages.propositions(nlnl() + onePerLine);
	}

	private static Scope getScope(Message error) {
		return ((Scopes) error.getContext().getScopes()).getCurrent();
	}
	
	private static String op(Operator op) {
		switch(op) {
			case ADDITION:					return "+";
			case SUBSTRACTION:				return "-";
			case GREATER_THAN: 				return ">";
			case LOWER_THAN: 				return "<";
			case EQUAL: 					return "==";
			case ADDITION_ASSIGNMENT:		return "+=";
			case SUBSTRACTION_ASSIGNMENT:	return "-=";
			case GREATER_OR_EQUAL:			return ">=";
			case LOWER_OR_EQUAL:			return "<=";
			case DOT:						return ".";
			default:						return "";
		}
	}
	
	private static String replacementProposals(String originalVariable, Collection<String> expected) {
		if (expected.isEmpty()) {
			// TODO type inference to replace <type>
			return Messages.undeclaredVariable(originalVariable, "<type> " + originalVariable + ";");
		}
		else {
			return doPropositions(originalVariable, expected);
		}
	}
	
	@SuppressWarnings("unchecked")
	private static String typeAsString(Object target) {
		if (target instanceof IType) {
			return getQualifiedName((IType) target);
		}
		if (target instanceof EClassifier) {
			return getQualifiedName((EClassifier) target);
		}
		if (target instanceof Collection) {
			try {
				return repr((Collection<IType>) target);
			} catch (ClassCastException e) {
				// nevermind, at least we tried
			}
		}
		return String.valueOf(target);
	}

	/**
	 * Returns a string corresponding to underlining the first occurrence
	 * of {@code incriminatedCode} in {@code codeSnippet}.
	 * 
	 * @param codeSnippet
	 * 			The whole piece of code.
	 * @param incriminatedCode
	 * 			The code to underline.
	 * 
	 * @return the underline with '^' characters 
	 */
	private static String underlineFirst(String codeSnippet, String incriminatedCode) {
		int incriminatedCodeStart = -1;
		
		String[] lines = codeSnippet.split("\\r?\\n");
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			
			if (line.contains(incriminatedCode)) {
				int margin = margin(line);
				incriminatedCodeStart = spaced(line).indexOf(incriminatedCode, margin);
				break;
			}
		}
		if (incriminatedCodeStart < 0) {
			// Range not found, likely because the incriminated code spans multiple lines
			// Let's try again
			int margin = margin(codeSnippet);
			incriminatedCodeStart = spaced(codeSnippet).indexOf(incriminatedCode, margin);
		}
		if (incriminatedCodeStart < 0 ) {
			return "";
		}
		return spaces(incriminatedCodeStart) + carets(incriminatedCode.length());
	}

	/**
	 * Returns a string corresponding to underlining the last occurrence
	 * of {@code incriminatedCode} in {@code codeSnippet}.
	 * 
	 * @param codeSnippet
	 * 			The whole piece of code.
	 * @param incriminatedCode
	 * 			The code to underline.
	 * 
	 * @return the underline with '^' characters 
	 */
	private static String underlineLast(String codeSnippet, String incriminatedCode) {
		int incriminatedCodeStart = -1;
		
		String[] lines = codeSnippet.split("\\r?\\n");
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];
			
			if (line.contains(incriminatedCode)) {
				int margin = margin(line);
				incriminatedCodeStart = spaced(line).indexOf(incriminatedCode, margin);
			}
		}
		if (incriminatedCodeStart < 0) {
			// Range not found, likely because the incriminated code spans multiple lines
			// Let's try again
			int margin = margin(codeSnippet);
			incriminatedCodeStart = spaced(codeSnippet).indexOf(incriminatedCode, margin);
		}
		if (incriminatedCodeStart < 0 ) {
			return "";
		}
		return spaces(incriminatedCodeStart) + carets(incriminatedCode.length());
	}
	
	private static String low(String str) {
		return str.toLowerCase();
	}
	
	/** Returns the number of characters used to write the line number in the given snippet */
	private static int margin(String codeSnippet) {
		return max(0, codeSnippet.indexOf('|'));
	}
	
	private static String spaces(int count) {
		return Strings.repeat(" ", count);
	}
	
	private static String carets(int count) {
		return Strings.repeat("^", count);
	}

	/**
	 * Replaces {@code \t} characters by four spaces.
	 * <p>
	 * Used before {@code indexOf} because {@code \t} counts for only 1 character,
	 * which thus leads {@link #spaces(int)} to print only one space.
	 */
	private static String spaced(String codeSnippet) {
		return codeSnippet.replace("\t", "    ");
	}
	
	/** Returns the system-dependent line separator character */ 
	private static String nl() {
		return System.lineSeparator();
	}
	
	/** Returns the system-dependent line separator character, two times */ 
	private static String nlnl() {
		return nl() + nl();
	}

}
