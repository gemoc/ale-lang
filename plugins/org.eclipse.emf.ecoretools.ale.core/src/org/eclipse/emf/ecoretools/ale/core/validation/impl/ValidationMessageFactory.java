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
package org.eclipse.emf.ecoretools.ale.core.validation.impl;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Stream.generate;
import static org.eclipse.emf.ecoretools.ale.core.validation.QualifiedNames.getQualifiedName;

import java.util.Set;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.acceleo.query.runtime.impl.ValidationMessage;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.impl.StackedScopes;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.core.validation.ITypeChecker;
import org.eclipse.emf.ecoretools.ale.core.validation.IValidationMessageFactory;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;

@SuppressWarnings("restriction")
public final class ValidationMessageFactory implements IValidationMessageFactory {

	public static final String BOOLEAN_TYPE = "Expected a boolean expression but was %s";
	public static final String COLLECTION_TYPE = "Expected Collection but was %s";
	public static final String EXTENDS_ITSELF = "Reopened %s is extending itself";
	public static final String ILLEGAL_ASSIGNMENT = "Type mismatch: cannot assign %s to %s";
	public static final String ILLEGAL_INSERTION = "%s cannot be added to %s (expected %s)";
	public static final String ILLEGAL_REMOVAL = "%s cannot be removed from %s (expected %s)";
	public static final String INCOMPATIBLE_TYPES = "Expected %s but was %s";
	public static final String INDIRECT_EXTENSION = "Can't extend %s since it is not a direct super type of %s";
	public static final String UNSUPPORTED_OPERATOR = "%s does not support the '%s' operator";
	public static final String VOID_RESULT_ASSIGN = "'result' is not available in a void method. Change method's return type";
	public static final String UNRESOLVED_TYPE = "Unresolved type %s, it cannot be found in any of the declared packages: %s";
	
	private final BaseValidator base;
	
	public ValidationMessageFactory(BaseValidator base) {
		this.base = requireNonNull(base, "base");
	}
	
	@Override
	public IValidationMessage assignmentToResultInVoidOperation(Statement assignment) {
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				VOID_RESULT_ASSIGN,
				base.getStartOffset(assignment),
				base.getEndOffset(assignment)
		);
	}
	
	@Override
	public IValidationMessage expectedBoolean(Expression exp) {
		Set<IType> actualTypes = base.getPossibleTypes(exp);
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				String.format(BOOLEAN_TYPE, commaSeparated(actualTypes)),
				base.getStartOffset(exp),
				base.getEndOffset(exp)
		);
	}
	
	@Override
	public IValidationMessage extendingItself(ExtendedClass xtdClass) {
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				String.format(EXTENDS_ITSELF, getQualifiedName(xtdClass.getBaseClass())),
				base.getStartOffset(xtdClass),
				base.getEndOffset(xtdClass)
		);
	}
	
	@Override
	public IValidationMessage forEachCanOnlyIterateOnCollections(ForEach loop) {
		Set<IType> actualTypes = base.getPossibleTypes(loop.getCollectionExpression());
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				String.format(COLLECTION_TYPE, commaSeparated(actualTypes)),
				base.getStartOffset(loop.getCollectionExpression()),
				base.getEndOffset(loop.getCollectionExpression())
		);
	}
	
	@Override
	public IValidationMessage illegalAssignment(Set<IType> variableTypes, Set<IType> valueTypes, Object assignment) {
		String errorMessage = String.format(ILLEGAL_ASSIGNMENT, commaSeparated(valueTypes), commaSeparated(variableTypes));
		if (assigningSequenceToSet(variableTypes, valueTypes)) {
			errorMessage += "\n" + generate(() -> "-").limit(errorMessage.length()).collect(joining());
			errorMessage += "\nCall aSequence->asOrderedSet() to allow assignment";
		}
		else if (assigningSetToSequence(variableTypes, valueTypes)) {
			errorMessage += "\n" + generate(() -> "-").limit(errorMessage.length()).collect(joining());
			errorMessage += "\nCall anOrderedSet->asSequence() to allow assignment";
		}
		// Easiest hack I've found to identify the most relevant range of text to underline
		boolean includesSemicolon = assignment.getClass().getName().startsWith("org.eclipse.emf.ecoretools.ale");
		
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				errorMessage,
				base.getStartOffset(assignment),
				base.getEndOffset(assignment) + (includesSemicolon ? 0 : 1)
		);
	}
	
	private boolean assigningSequenceToSet(Set<IType> variableTypes, Set<IType> valueTypes) {
		ITypeChecker types = new TypeChecker(new StackedScopes(), base.getQryEnv());
		return variableTypes.stream().anyMatch(types::isSet)
			&& valueTypes.stream().anyMatch(types::isSequence);
	}
	
	private boolean assigningSetToSequence(Set<IType> variableTypes, Set<IType> valueTypes) {
		ITypeChecker types = new TypeChecker(new StackedScopes(), base.getQryEnv());
		return variableTypes.stream().anyMatch(types::isSequence)
			&& valueTypes.stream().anyMatch(types::isSet);
	}

	@Override
	public IValidationMessage illegalInsertion(Set<IType> variableTypes, Set<IType> insertedValueTypes, Set<IType> acceptedValueTypes, Object value) {
		String errorMessage = String.format(ILLEGAL_INSERTION, commaSeparated(insertedValueTypes), commaSeparated(variableTypes), commaSeparated(acceptedValueTypes));
		if (assigningCollectionToCollection(variableTypes, insertedValueTypes)) {
			errorMessage += "\n" + generate(() -> "-").limit(50).collect(joining());
			errorMessage += "\nMake sure both collections hold the same type";
		}
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				errorMessage,
				base.getStartOffset(value),
				base.getEndOffset(value) + 1
		);
	}
	
	private boolean assigningCollectionToCollection(Set<IType> variableTypes, Set<IType> valueTypes) {
		ITypeChecker types = new TypeChecker(new StackedScopes(), base.getQryEnv());
		return variableTypes.stream().anyMatch(types::isCollection)
			&& valueTypes.stream().anyMatch(types::isCollection);
	}
	
	@Override
	public IValidationMessage illegalRemoval(Set<IType> variableTypes, Set<IType> removedValueTypes, Set<IType> acceptedValueTypes, Object value) {
		String errorMessage = String.format(ILLEGAL_REMOVAL, commaSeparated(removedValueTypes), commaSeparated(variableTypes), commaSeparated(acceptedValueTypes));
		if (assigningCollectionToCollection(variableTypes, removedValueTypes)) {
			errorMessage += "\n" + generate(() -> "-").limit(50).collect(joining());
			errorMessage += "\nMake sure both collections hold the same type";
		}
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				errorMessage,
				base.getStartOffset(value),
				base.getEndOffset(value) + 1
		);
	}
	
	@Override
	public IValidationMessage incompatibleTypes(Set<IType> expected, Set<IType> actual, Object statement) {
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				String.format(INCOMPATIBLE_TYPES, commaSeparated(expected), commaSeparated(actual)),
				base.getStartOffset(statement),
				base.getEndOffset(statement)
		);
	}
	
	
	@Override
	public IValidationMessage indirectExtension(ExtendedClass xtdClass, EClass superBase, EClass baseCls) {
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				String.format(INDIRECT_EXTENSION, getQualifiedName(superBase), getQualifiedName(baseCls)),
				base.getStartOffset(xtdClass),
				base.getEndOffset(xtdClass)
		);
	}

	@Override
	public IValidationMessage prohibitedInsertionToSelf(Object statement) {
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				String.format(UNSUPPORTED_OPERATOR, "'self'", "+="),
				base.getStartOffset(statement),
				base.getStartOffset(statement) + "self".length()
		);
	}
	
	@Override
	public IValidationMessage prohibitedRemovalFromSelf(Object statement) {
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				String.format(UNSUPPORTED_OPERATOR, "'self'", "-="),
				base.getStartOffset(statement),
				base.getStartOffset(statement) + "self".length()
		);
	}
	
	@Override
	public IValidationMessage unresolvedType(Object expression) {
		String declaredPackages = base.getQryEnv().getEPackageProvider().getRegisteredEPackages().stream()
												  .map(EPackage::getName)
												  .collect(joining(", ","[","]")); 
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				// TODO implement a contextual UnresolvedType to get better name. cf. https://github.com/gemoc/ale-lang/issues/78
				String.format(UNRESOLVED_TYPE, ""/*getQualifiedName(att.getFeatureRef().getEType())*/, declaredPackages),
				base.getStartOffset(expression),
				base.getEndOffset(expression)
		);
	}
	
	@Override
	public IValidationMessage unsupportedOperatorOnFeature(Set<IType> currentTypes, Object statement, String featureName, String operator) {
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				String.format(UNSUPPORTED_OPERATOR,commaSeparated(currentTypes), operator),
				base.getStartOffset(statement),
				base.getStartOffset(statement) + ("self." + featureName).length()
		);
	}

	@Override
	public IValidationMessage unsupportedOperatorOnVariable(Set<IType> currentTypes, Object statement, String variableName, String operator) {
		return new ValidationMessage(
				ValidationMessageLevel.ERROR,
				String.format(UNSUPPORTED_OPERATOR,commaSeparated(currentTypes), operator),
				base.getStartOffset(statement),
				base.getStartOffset(statement) + variableName.length()
		);
	}
	
	private static String commaSeparated(Set<IType> types) {
		return types.stream()
					.map(type -> getQualifiedName(type))
					.sorted()
					.distinct()
					.collect(joining(",","[","]"));
	}
}
