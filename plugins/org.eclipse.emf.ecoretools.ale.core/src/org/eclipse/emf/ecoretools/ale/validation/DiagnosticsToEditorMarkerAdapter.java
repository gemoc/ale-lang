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

import java.util.function.Function;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecoretools.ale.core.Activator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AcceleoValidationMessage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToResultInVoidOperation;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInBaseClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeAlreadyDefinedInCurrentClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassExtendsItself;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.CollectionTypeMismatch;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DynamicClassAlreadyDefined;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IDiagnosticFormatter;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAssignment;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInBaseClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodAlreadyDefinedInCurrentClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodParameterAlreadyDefined;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MissingReturnStatement;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.NotAnOpenableClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.NotIterable;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.OpenClassNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.OverriddenMethodNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToMethodParameter;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedAssignmentToSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedInsertionToSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ProhibitedRemovalFromSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordResult;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ReservedKeywordSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeHasNamesakes;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyDefined;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.util.DiagnosticsSwitch;

public class DiagnosticsToEditorMarkerAdapter extends DiagnosticsSwitch<IMarker> {
	
	private final Function<String, IMarker> markerFactory;
	
	private final IDiagnosticFormatter formatter;
	
	public DiagnosticsToEditorMarkerAdapter(Function<String, IMarker> markerFactory, IDiagnosticFormatter formatter) {
		this.markerFactory = markerFactory;
		this.formatter = formatter;
	}
	
	private IMarker newMarker(Message error) {
//		IMarker marker = markerFactory.apply(error.getClass().getCanonicalName());
		IMarker marker = markerFactory.apply("org.eclipse.emf.ecoretools.ale.xtext.AleMarker");
		return fill(marker, error);
	}
	
	private IMarker fill(IMarker marker, Message error) {
		try {
			marker.setAttribute(IMarker.MESSAGE, formatter.adapt(error));
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			marker.setAttribute(IMarker.CHAR_START, error.getLocation().getStartPosition());
			marker.setAttribute(IMarker.CHAR_END, error.getLocation().getEndPosition());
		} 
		catch (CoreException e) {
			Activator.error("Unable to create marker for " + error, e);
		}
		return marker;
	}

	@Override
	public IMarker caseAttributeNotFound(AttributeNotFound error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseMethodNotFound(MethodNotFound error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseVariableNotFound(VariableNotFound error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseTypeNotFound(TypeNotFound error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseTypeMismatch(TypeMismatch error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseVariableAlreadyDefined(VariableAlreadyDefined error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseInternalError(InternalError error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseProhibitedAssignmentToSelf(ProhibitedAssignmentToSelf error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseAssignmentToResultInVoidOperation(AssignmentToResultInVoidOperation error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseNotIterable(NotIterable error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseUnsupportedOperator(UnsupportedOperator error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseMissingReturnStatement(MissingReturnStatement error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseClassOpenedMoreThanOnce(ClassOpenedMoreThanOnce error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseNotAnOpenableClass(NotAnOpenableClass error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseOpenClassNotFound(OpenClassNotFound error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseTypeHasNamesakes(TypeHasNamesakes error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseIncorrectExtendOrder(IncorrectExtendOrder error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseCollectionTypeMismatch(CollectionTypeMismatch error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseClassExtendsItself(ClassExtendsItself error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseIllegalAssignment(IllegalAssignment error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseIndirectExtension(IndirectExtension error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseProhibitedInsertionToSelf(ProhibitedInsertionToSelf error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseProhibitedRemovalFromSelf(ProhibitedRemovalFromSelf error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseDynamicClassAlreadyDefined(DynamicClassAlreadyDefined error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseAttributeAlreadyDefinedInBaseClass(AttributeAlreadyDefinedInBaseClass error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseMethodAlreadyDefinedInBaseClass(MethodAlreadyDefinedInBaseClass error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseAttributeAlreadyDefinedInCurrentClass(AttributeAlreadyDefinedInCurrentClass error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseReservedKeywordSelf(ReservedKeywordSelf error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseReservedKeywordResult(ReservedKeywordResult error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseMethodAlreadyDefinedInCurrentClass(MethodAlreadyDefinedInCurrentClass error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseMethodParameterAlreadyDefined(MethodParameterAlreadyDefined error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseOverriddenMethodNotFound(OverriddenMethodNotFound error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseProhibitedAssignmentToMethodParameter(ProhibitedAssignmentToMethodParameter error) {
		return newMarker(error);
	}

	@Override
	public IMarker caseAcceleoValidationMessage(AcceleoValidationMessage error) {
		return newMarker(error);
	}

}
