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
import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.validation.type.AbstractCollectionType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.internal.Scopes;
import org.eclipse.emf.ecoretools.ale.core.validation.IAstLookup;
import org.eclipse.emf.ecoretools.ale.core.validation.IConvertType;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;

/**
 * Used to retrieve types of expressions manipulated by ALE.
 */
public final class AstLookup implements IAstLookup {
	
	private final Scopes scopes;
	
	private final IConvertType convert;

	private final IAleEnvironment env;
	
	public AstLookup(IAleEnvironment env, Scopes scopes, IConvertType convert) {
		this.env = requireNonNull(env, "env");
		this.scopes = requireNonNull(scopes, "scopes");
		this.convert = requireNonNull(convert, "convert");
	}
	
	@Override
	public Set<IType> inferredTypesOf(Expression expression) {
		return scopes.getCurrent().getPossibleTypesOf(expression);
	}
	
	@Override
	public Set<IType> typesDeclaredFor(String variableName, EObject astBranch) {
		Set<IType> declaredTypes = new HashSet<>();
		
		// Look at extended EClass attributes
		EObject currentObject = astBranch;
		EObject currentScope = astBranch.eContainer();
		
		while(currentScope != null) {
			
			// Look at previous statement in the same block
			if(currentScope instanceof Block) {
				Block block = (Block) currentScope;
				int index = block.getStatements().indexOf(currentObject);
				if(index != -1) {
					Optional<VariableDeclaration> candidate =
						block.getStatements()
						.stream()
						.limit(index)
						.filter(VariableDeclaration.class::isInstance)
						.map(VariableDeclaration.class::cast)
						.filter(varDecl -> varDecl.getName().equals(variableName))
						.findFirst();
					if(candidate.isPresent()) {
						ETypedElement type = candidate.get().getType();
						declaredTypes.add(convert.toAQL(type));
						return declaredTypes;
					}
				}
			}
			
			// Look at loop's variable
			else if(currentScope instanceof ForEach) {
				ForEach loop = (ForEach) currentScope;
				if(loop.getVariable().equals(variableName)) {
					return scopes.getCurrent().getPossibleTypesOf(loop.getCollectionExpression()).stream()
							   .map(AbstractCollectionType.class::cast)
							   .map(AbstractCollectionType::getCollectionType)
							   .collect(toSet());
				}
			}
			
			// Look at class extension
			else if(currentScope instanceof BehavioredClass) {
				BehavioredClass cls = (BehavioredClass) currentScope;
				Optional<Attribute> candidate = cls.getAttributes().stream().filter(attr -> attr.getFeatureRef().getName().equals(variableName)).findFirst();
				if(candidate.isPresent()) {
					EClassifier type = candidate.get().getFeatureRef().getEType();
					declaredTypes.add(convert.toAQL(type));
					return declaredTypes;
				}
			}
			
			// Look at extended class
			else if(currentScope instanceof ExtendedClass) {
				ExtendedClass extension = (ExtendedClass) currentScope;
				Optional<EStructuralFeature> feature = 
						extension.getBaseClass().getEAllStructuralFeatures()
						.stream()
						.filter(feat -> feat.getName().equals(variableName))
						.findFirst();
				if(feature.isPresent()) {
					EClassifier type = feature.get().getEType();
					declaredTypes.add(convert.toAQL(type));
					return declaredTypes;
				}
			}
			
			// Look at enclosing method's parameters
			else if (currentScope instanceof Method) {
				Method method = (Method) currentScope;
				Optional<EParameter> parameter = method.getOperationRef()
													   .getEParameters().stream()
													   .filter(param -> param.getName().equals(variableName))
													   .findFirst();
				
				if (parameter.isPresent()) {
					declaredTypes.add(convert.toAQL(parameter.get()));
				}
			}
			currentObject = currentScope;
			currentScope = currentScope.eContainer();
		}
		return declaredTypes;
	}
	
	@Override
	public Set<IType> findFeatureTypes(String featureName, Expression featureAccessExpression) {
		Set<IType> variableTypes = new HashSet<>();
		Set<IType> inferredVariableTypes = scopes.getCurrent().getPossibleTypesOf(featureAccessExpression);
		
		for(IType type : inferredVariableTypes){
			if(type.getType() instanceof EClass){
				EClass realType = (EClass) type.getType();
				EStructuralFeature feature = realType.getEStructuralFeature(featureName);
				
				boolean featureIsCreatedAtRuntime = (feature == null);
				if(featureIsCreatedAtRuntime) {
					List<ExtendedClass> extensions = findExtensions(realType);
					feature = extensions.stream()
										.flatMap(xtdCls -> xtdCls.getAttributes().stream())
										.filter(field -> field.getFeatureRef().getName().equals(featureName))
										.map(Attribute::getFeatureRef)
										.findAny().orElse(null);
				}
				if(feature == null) {
					// The feature does not exist, the error will be handled by a NameValidator
					// TODO Check if it is possible to have a non-existing feature here and consider
					//		showing an error message if necessary
					continue;
				}
				IType featureType = convert.toAQL(feature);
				variableTypes.add(featureType);
			}
		}
		return variableTypes;
	}
	
	public List<ExtendedClass> findExtensions(EClass realType) {
		return 
			env.getBehaviors().getParsedFiles()
			.stream()
			.flatMap(m -> m.getRoot().getClassExtensions().stream())
			// base class can be null when X match no existing class in "open class X"
			.filter(xtdCls -> xtdCls.getBaseClass() != null)
			.filter(xtdCls -> xtdCls.getBaseClass().isSuperTypeOf(realType))
			.collect(Collectors.toList());
	}
	
	@Override
	public Method enclosingMethod(Statement statement) {
		EObject parent = statement.eContainer();
		while(parent != null && !(parent instanceof Method)){
			parent = parent.eContainer();
		}
		return (Method) parent;
	}
	
}
