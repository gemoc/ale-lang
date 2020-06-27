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

import java.util.Set;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassExtendsItself;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Context;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsFactory;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IndirectExtension;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.NotIterable;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IllegalAssignment;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.impl.StackedScopes;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.core.validation.ITypeChecker;
import org.eclipse.emf.ecoretools.ale.core.validation.IValidationMessageFactory;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.VariableInsert;
import org.eclipse.emf.ecoretools.ale.implementation.VariableRemove;

import com.google.common.collect.Sets;

public final class ValidationMessageFactory implements IValidationMessageFactory {
	public static final String INDIRECT_EXTENSION = "Can't extend %s since it is not a direct super type of %s";
	public static final String UNSUPPORTED_OPERATOR = "%s does not support the '%s' operator";
	public static final String VOID_RESULT_ASSIGN = "'result' is not available in a void method. Change method's return type";
	public static final String UNRESOLVED_TYPE = "Unresolved type %s, it cannot be found in any of the declared packages: %s";
	
	private final BaseValidator base;
	
	public ValidationMessageFactory(BaseValidator base) {
		this.base = requireNonNull(base, "base");
	}
	
	@Override
	public Message assignmentToResultInVoidOperation(Statement assignment) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(assignment).get(0));
		location.setStartPosition(base.getStartOffset(assignment));
		location.setEndPosition(base.getEndOffset(assignment));
		
		VariableNotFound notfound = DiagnosticsFactory.eINSTANCE.createAssignmentToResultInVoidOperation();
		notfound.setName("result");
		notfound.setSource(assignment);
		notfound.setLocation(location);
		return notfound;
	}
	
	@Override
	public Message expectedBoolean(Expression exp) {
		Set<IType> expectedTypes = Sets.newHashSet(new EClassifierType(base.getQryEnv(), EcorePackage.eINSTANCE.getEBoolean()));
		Set<IType> actualTypes = base.getPossibleTypes(exp);
		
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(exp).get(0));
		location.setStartPosition(base.getStartOffset(exp));
		location.setEndPosition(base.getEndOffset(exp));
		
		TypeMismatch mismatch = DiagnosticsFactory.eINSTANCE.createTypeMismatch();
		mismatch.setLocation(location);
		mismatch.setSource(exp);
		mismatch.getExpectedTypes().addAll(expectedTypes);
		mismatch.getActualTypes().addAll(actualTypes);
		return mismatch;
	}
	
	@Override
	public Message extendingItself(ExtendedClass xtdClass) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(xtdClass).get(0));
		location.setStartPosition(base.getStartOffset(xtdClass));
		location.setEndPosition(base.getEndOffset(xtdClass));
		
		ClassExtendsItself extendsItself = DiagnosticsFactory.eINSTANCE.createClassExtendsItself();
		extendsItself.setLocation(location);
		extendsItself.setSource(xtdClass);
		return extendsItself;
	}
	
	@Override
	public Message forEachCanOnlyIterateOnCollections(ForEach loop) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(loop.getCollectionExpression()).get(0));
		location.setStartPosition(base.getStartOffset(loop.getCollectionExpression()));
		location.setEndPosition(base.getEndOffset(loop.getCollectionExpression()));
		
		NotIterable notIterable = DiagnosticsFactory.eINSTANCE.createNotIterable();
		notIterable.setLocation(location);
		notIterable.setSource(loop.getCollectionExpression());
		notIterable.getActualTypes().addAll(base.getPossibleTypes(loop.getCollectionExpression()));
		return notIterable;
	}
	
	@Override
	public Message illegalAssignment(Set<IType> variableTypes, Set<IType> valueTypes, EObject assignment, Object assignedValue) {
		// Easiest hack I've found to identify the most relevant range of text to underline
		boolean includesSemicolon = assignment.getClass().getName().startsWith("org.eclipse.emf.ecoretools.ale");
		
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(assignment).get(0));
		location.setStartPosition(base.getStartOffset(assignedValue));
		location.setEndPosition(base.getEndOffset(assignedValue) + (includesSemicolon ? 1 : 1));
		
		IllegalAssignment illegalAssignment = DiagnosticsFactory.eINSTANCE.createIllegalAssignment();
		illegalAssignment.setLocation(location);
		illegalAssignment.setSource(assignment);
		illegalAssignment.getExpectedTypes().addAll(variableTypes);
		illegalAssignment.getTargetTypes().addAll(variableTypes);
		illegalAssignment.getActualTypes().addAll(valueTypes);
		illegalAssignment.setAssignedValue(assignedValue);
		return illegalAssignment;
	}

	@Override
	public Message illegalInsertion(Set<IType> variableTypes, Set<IType> insertedValueTypes, Set<IType> acceptedValueTypes, Expression value) {
		TypeMismatch mismatch = DiagnosticsFactory.eINSTANCE.createIllegalAdditionAssignment();
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(value).get(0));
		location.setStartPosition(base.getStartOffset(value));
		location.setEndPosition(base.getEndOffset(value) + 1);
		
		mismatch.setLocation(location);
		mismatch.setSource(value);
		mismatch.getTargetTypes().addAll(variableTypes);
		mismatch.getExpectedTypes().addAll(acceptedValueTypes);
		mismatch.getActualTypes().addAll(insertedValueTypes);
		return mismatch;
	}
	
	private boolean assigningCollectionToCollection(Set<IType> variableTypes, Set<IType> valueTypes) {
		ITypeChecker types = new TypeChecker(new StackedScopes(), base.getQryEnv());
		return variableTypes.stream().anyMatch(types::isCollection)
			&& valueTypes.stream().anyMatch(types::isCollection);
	}
	
	@Override
	public Message illegalRemoval(Set<IType> variableTypes, Set<IType> removedValueTypes, Set<IType> acceptedValueTypes, Expression value) {
		TypeMismatch mismatch = DiagnosticsFactory.eINSTANCE.createIllegalSubstractionAssignment();
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(value).get(0));
		location.setStartPosition(base.getStartOffset(value));
		location.setEndPosition(base.getEndOffset(value) + 1);
		
		mismatch.setLocation(location);
		mismatch.setSource(value);
		mismatch.getTargetTypes().addAll(variableTypes);
		mismatch.getExpectedTypes().addAll(acceptedValueTypes);
		mismatch.getActualTypes().addAll(removedValueTypes);
		return mismatch;
	}
	
	@Override
	public Message incompatibleTypes(Set<IType> expected, Set<IType> actual, EObject statement) {
		TypeMismatch mismatch;
		if (assigningCollectionToCollection(expected, actual)) {
			mismatch = DiagnosticsFactory.eINSTANCE.createCollectionTypeMismatch();
		}
		else {
			mismatch = DiagnosticsFactory.eINSTANCE.createTypeMismatch();
		}
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(statement).get(0));
		location.setStartPosition(base.getStartOffset(statement));
		location.setEndPosition(base.getEndOffset(statement));
		
		mismatch.setLocation(location);
		mismatch.setSource(statement);
		mismatch.getExpectedTypes().addAll(expected);
		mismatch.getActualTypes().addAll(actual);
		return mismatch;
	}
	
	@Override
	public Message indirectExtension(ExtendedClass xtdClass, EClass superBase, EClass baseCls) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(xtdClass).get(0));
		location.setStartPosition(base.getStartOffset(xtdClass));
		location.setEndPosition(base.getStartOffset(xtdClass) + ("open class " + xtdClass.getName() + " extends " + xtdClass.getBaseClass().getName()).length());
		
		IndirectExtension indirectExtension = DiagnosticsFactory.eINSTANCE.createIndirectExtension();
		indirectExtension.setLocation(location);
		indirectExtension.setSource(xtdClass);
		indirectExtension.setOpenClass(baseCls);
		indirectExtension.setInheritedClass(superBase);
		return indirectExtension;
	}

	@Override
	public Message prohibitedInsertionToSelf(VariableInsert statement) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(statement).get(0));
		location.setStartPosition(base.getStartOffset(statement));
		location.setEndPosition(base.getStartOffset(statement) + "self".length());
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		
		UnsupportedOperator unsupported = DiagnosticsFactory.eINSTANCE.createProhibitedInsertionToSelf();
		unsupported.setSource(statement);
		unsupported.setContext(context);
		unsupported.setLocation(location);
		unsupported.setOperator(Operator.ADDITION_ASSIGNMENT);
		return unsupported;
	}
	
	@Override
	public Message prohibitedRemovalFromSelf(VariableRemove statement) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(statement).get(0));
		location.setStartPosition(base.getStartOffset(statement));
		location.setEndPosition(base.getStartOffset(statement) + "self".length());
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		
		UnsupportedOperator unsupported = DiagnosticsFactory.eINSTANCE.createProhibitedRemovalFromSelf();
		unsupported.setSource(statement);
		unsupported.setContext(context);
		unsupported.setLocation(location);
		unsupported.setOperator(Operator.ADDITION_ASSIGNMENT);
		return unsupported;
	}
	
	@Override
	public Message unresolvedType(EObject statement) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(statement).get(0));
		location.setStartPosition(base.getStartOffset(statement));
		location.setEndPosition(base.getEndOffset(statement));
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		
		TypeNotFound unresolved = DiagnosticsFactory.eINSTANCE.createTypeNotFound();
		unresolved.setSource(statement);
		unresolved.setContext(context);
		unresolved.setLocation(location);
		// FIXME implement a contextual TypeNotFound to get better name. cf. https://github.com/gemoc/ale-lang/issues/78
		unresolved.setName("");
		unresolved.getAvailableEPackages().addAll(base.getQryEnv().getEPackageProvider().getRegisteredEPackages());
		return unresolved;
	}
	
	@Override
	public Message unsupportedOperatorOnFeature(Set<IType> currentTypes, EObject statement, String featureName, Operator operator) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(statement).get(0));
		location.setStartPosition(base.getStartOffset(statement));
		location.setEndPosition(base.getStartOffset(statement) + ("self." + featureName).length());
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		
		UnsupportedOperator unsupported = DiagnosticsFactory.eINSTANCE.createUnsupportedOperator();
		unsupported.setSource(statement);
		unsupported.setContext(context);
		unsupported.setLocation(location);
		unsupported.setOperator(operator);
		unsupported.getTargetTypes().addAll(currentTypes);
		return unsupported;
	}

	@Override
	public Message unsupportedOperatorOnVariable(Set<IType> currentTypes, EObject statement, String variableName, Operator operator) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(base.getLines(statement).get(0));
		location.setStartPosition(base.getStartOffset(statement));
		location.setEndPosition(base.getStartOffset(statement) + variableName.length());
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		
		UnsupportedOperator unsupported = DiagnosticsFactory.eINSTANCE.createUnsupportedOperator();
		unsupported.setSource(statement);
		unsupported.setContext(context);
		unsupported.setLocation(location);
		unsupported.setOperator(operator);
		unsupported.getTargetTypes().addAll(currentTypes);
		return unsupported;
	}
	
}
