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
import static java.util.stream.Stream.generate;
import static org.eclipse.emf.ecoretools.ale.core.validation.QualifiedNames.getQualifiedName;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
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
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAdditionAssignment;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAssignment;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalSubstractionAssignment;
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
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator;
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
import org.eclipse.emf.ecoretools.ale.core.validation.ITypeChecker;
import org.eclipse.emf.ecoretools.ale.core.validation.QualifiedNames;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;

/**
 * Turns {@link Message}s into String aimed at being displayed as tooltips in a text editor.
 */
public final class EditorMarkerFormatter extends DiagnosticsSwitch<String> implements IDiagnosticFormatter {
	
	private final ITypeChecker types;
	
	public EditorMarkerFormatter(ITypeChecker types) {
		this.types = types;
	}

	@Override
	public String adapt(EObject element) {
		return doSwitch(element);
	}

	@Override
	public String caseAttributeNotFound(AttributeNotFound error) {
		return AleEditorMessages.attributeNotFound(error.getName(), ""); //error.getOwner());
	}

	@Override
	public String caseMethodNotFound(MethodNotFound error) {
		String signature = error.getName() + error.getArgumentTypes().stream().map(QualifiedNames::getQualifiedName).collect(Collectors.joining(", ", "(", ")"));
		return AleEditorMessages.methodNotFound(signature, error.getOwner());
	}

	@Override
	public String caseVariableNotFound(VariableNotFound error) {
		return AleEditorMessages.variableNotFound(error.getName());
	}

	@Override
	public String caseIllegalAdditionAssignment(IllegalAdditionAssignment error) {
		String text = AleEditorMessages.addAssignIllegal(
				commaSeparated(error.getActualTypes()), 
				commaSeparated(error.getTargetTypes()), 
				commaSeparated(error.getExpectedTypes())
		);
		if (assigningCollectionToCollection(error.getTargetTypes(), error.getActualTypes())) {
			text += "\n" + generate(() -> "-").limit(50).collect(joining());
			text += "\nMake sure both collections hold the same type";
		}
		return text;
	}

	@Override
	public String caseIllegalSubstractionAssignment(IllegalSubstractionAssignment error) {
		String text = AleEditorMessages.subAssignIllegal(
				commaSeparated(error.getActualTypes()), 
				commaSeparated(error.getTargetTypes()), 
				commaSeparated(error.getExpectedTypes())
		);
		if (assigningCollectionToCollection(error.getTargetTypes(), error.getActualTypes())) {
			text += "\n" + generate(() -> "-").limit(50).collect(joining());
			text += "\nMake sure both collections hold the same type";
		}
		return text;
	}

	@Override
	public String caseVariableAlreadyDefined(VariableAlreadyDefined error) {
		return AleEditorMessages.variableAlreadyBound(error.getName());
	}

	@Override
	public String caseInternalError(InternalError error) {
		if (error.getMessage() != null) {
			return AleEditorMessages.internalError(error.getMessage());
		}
		if (error.getCause() != null && error.getCause().getMessage() != null) {
			return AleEditorMessages.internalError(error.getCause().getMessage());
		}
		return AleEditorMessages.internalError("unknown error");
	}

	@Override
	public String caseProhibitedAssignmentToSelf(ProhibitedAssignmentToSelf object) {
		return AleEditorMessages.assignmentToSelf();
	}

	@Override
	public String caseAssignmentToResultInVoidOperation(AssignmentToResultInVoidOperation object) {
		return AleEditorMessages.assignmentToResultInVoidMethod();
	}

	@Override
	public String caseNotIterable(NotIterable error) {
		return AleEditorMessages.notIterable(error.getActualTypes());
	}

	@Override
	public String caseUnsupportedOperator(UnsupportedOperator error) {
		return AleEditorMessages.unsupportedOperator(commaSeparated(error.getTargetTypes()), op(error.getOperator()));
	}

	@Override
	public String caseMissingReturnStatement(MissingReturnStatement object) {
		return AleEditorMessages.missingReturnStatement();
	}

	@Override
	public String caseClassOpenedMoreThanOnce(ClassOpenedMoreThanOnce error) {
		return AleEditorMessages.classIsAlreadyOpened(error.getCurrentDeclaration());
	}

	@Override
	public String caseNotAnOpenableClass(NotAnOpenableClass error) {
		return AleEditorMessages.notAnOpenableClass(error.getOpenClass().getName());
	}

	@Override
	public String caseOpenClassNotFound(OpenClassNotFound error) {
		return AleEditorMessages.openingANonExistingClass(error.getOpenClass().getName());
	}

	@Override
	public String caseTypeHasNamesakes(TypeHasNamesakes error) {
		if (error.getSource() instanceof ExtendedClass) {
			ExtendedClass extendedClass = (ExtendedClass) error.getSource();
			List<EPackage> packages = error.getNamesakes().stream().map(EClassifier::getEPackage).collect(Collectors.toList());
			return AleEditorMessages.openedClassHasNamesakes(extendedClass.getName(), packages);
		}
		return super.caseTypeHasNamesakes(error);
	}

	@Override
	public String caseIncorrectExtendOrder(IncorrectExtendOrder error) {
		return AleEditorMessages.wrongExtendsOrder(error.getSuperType(), error.getSuperSuperType());
	}

	@Override
	public String caseCollectionTypeMismatch(CollectionTypeMismatch object) {
		// TODO Auto-generated method stub
		return super.caseCollectionTypeMismatch(object);
	}

	@Override
	public String caseClassExtendsItself(ClassExtendsItself error) {
		if (error.getSource() instanceof ExtendedClass) {
			ExtendedClass extendedClass = (ExtendedClass) error.getSource();
			return AleEditorMessages.extendingItself(getQualifiedName(extendedClass.getBaseClass()));
		}
		return "";
	}

	@Override
	public String caseTypeMismatch(TypeMismatch error) {
		return AleEditorMessages.typeMismatch(commaSeparated(error.getExpectedTypes()), commaSeparated(error.getActualTypes()));
	}

	@Override
	public String caseIllegalAssignment(IllegalAssignment error) {
		String text = AleEditorMessages.assignIllegal(
				commaSeparated(error.getActualTypes()),
				commaSeparated(error.getTargetTypes()),
				commaSeparated(error.getExpectedTypes())
		);
		if (assigningSequenceToSet(error.getTargetTypes(), error.getActualTypes())) {
			text += "\n" + generate(() -> "-").limit(text.length()).collect(joining());
			text += "\nCall aSequence->asOrderedSet() to allow assignment";
		}
		else if (assigningSetToSequence(error.getTargetTypes(), error.getActualTypes())) {
			text += "\n" + generate(() -> "-").limit(text.length()).collect(joining());
			text += "\nCall anOrderedSet->asSequence() to allow assignment";
		}
		return text;
	}

	@Override
	public String caseIndirectExtension(IndirectExtension object) {
		return AleEditorMessages.indirectExtension(object.getOpenClass(), object.getInheritedClass());
	}

	@Override
	public String caseProhibitedInsertionToSelf(ProhibitedInsertionToSelf object) {
		return AleEditorMessages.unsupportedOperator("'self'", "+=");
	}

	@Override
	public String caseProhibitedRemovalFromSelf(ProhibitedRemovalFromSelf object) {
		return AleEditorMessages.unsupportedOperator("'self'", "-=");
	}

	@Override
	public String caseTypeNotFound(TypeNotFound error) {
		return AleEditorMessages.unresolvedType(error.getName(), nl() + listed(error.getAvailableEPackages(), EditorMarkerFormatter::repr));
	}

	@Override
	public String caseDynamicClassAlreadyDefined(DynamicClassAlreadyDefined error) {
		return AleEditorMessages.variableAlreadyBound(error.getCurrentDeclaration().getName());
	}

	@Override
	public String caseAttributeAlreadyDefinedInBaseClass(AttributeAlreadyDefinedInBaseClass error) {
		return AleEditorMessages.variableAlreadyBound(error.getAttributeName());
	}

	@Override
	public String caseMethodAlreadyDefinedInBaseClass(MethodAlreadyDefinedInBaseClass error) {
		return AleEditorMessages.methodAlreadyDefinedInBaseClass(getSignature(error.getNewDefinition()));
	}

	@Override
	public String caseAttributeAlreadyDefinedInCurrentClass(AttributeAlreadyDefinedInCurrentClass error) {
		return AleEditorMessages.variableAlreadyBound(error.getAttributeName());
	}

	@Override
	public String caseReservedKeywordSelf(ReservedKeywordSelf object) {
		return AleEditorMessages.selfReserved();
	}

	@Override
	public String caseReservedKeywordResult(ReservedKeywordResult object) {
		return AleEditorMessages.resultReserved();
	}

	@Override
	public String caseMethodAlreadyDefinedInCurrentClass(MethodAlreadyDefinedInCurrentClass object) {
		return AleEditorMessages.methodAlreadyDeclared(getSignature(object.getCurrentDeclaration()));
	}

	@Override
	public String caseMethodParameterAlreadyDefined(MethodParameterAlreadyDefined error) {
		return AleEditorMessages.variableAlreadyBound(error.getParameterName());
	}

	@Override
	public String caseOverriddenMethodNotFound(OverriddenMethodNotFound error) {
		return AleEditorMessages.overriddenMethodNotFound(error.getOverridingMethodOwner());
	}

	@Override
	public String caseProhibitedAssignmentToMethodParameter(ProhibitedAssignmentToMethodParameter error) {
		return AleEditorMessages.assignmentToParameter(error.getParameterName());
	}

	@Override
	public String caseAcceleoValidationMessage(AcceleoValidationMessage error) {
		return error.getMessage();
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	///    TYPE-CHECKING UTILITY FUNCTIONS ////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private boolean assigningSequenceToSet(Collection<IType> variableTypes, Collection<IType> valueTypes) {
		return variableTypes.stream().anyMatch(types::isSet)
			&& valueTypes.stream().anyMatch(types::isSequence);
	}
	
	private boolean assigningSetToSequence(Collection<IType> variableTypes, Collection<IType> valueTypes) {
		return variableTypes.stream().anyMatch(types::isSequence)
			&& valueTypes.stream().anyMatch(types::isSet);
	}
	
	private boolean assigningCollectionToCollection(Collection<IType> variableTypes, Collection<IType> valueTypes) {
		return variableTypes.stream().anyMatch(types::isCollection)
			&& valueTypes.stream().anyMatch(types::isCollection);
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	///    FORMATTING UTILITY FUNCTIONS ///////////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	
	private String getSignature(Method op) {
		EOperation eOp = op.getOperationRef();
		if(eOp != null) {
			String paramsToString = 
					eOp
					.getEParameters()
					.stream()
					.map(param -> param.getEType().getName())
					.collect(joining(",","(",")"));
			
			return eOp.getName() + paramsToString; 
		}
		return "undefined";
	}
	
	private static String repr(EPackage pkg) {
		return getQualifiedName(pkg) + " (" + pkg.getNsURI() + ")";
	}
	
	private static String commaSeparated(Collection<IType> types) {
		return types.stream()
					.map(type -> getQualifiedName(type))
					.sorted()
					.distinct()
					.collect(joining(",", "[", "]"));
	}
	
	private static <T> String listed(Collection<T> elements, Function<T, String> toString) {
		return elements.stream()
				.map(toString::apply)
				.collect(joining(nl() + " - ", " - ", ""));
	}

	/** Returns the system-dependent line separator character */ 
	private static String nl() {
		return System.lineSeparator();
	}

}
