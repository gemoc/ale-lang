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

import static com.google.common.collect.Sets.newHashSet;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.validation.type.ClassType;
import org.eclipse.acceleo.query.validation.type.ICollectionType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.NothingType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.core.validation.BaseValidator;
import org.eclipse.emf.ecoretools.ale.core.validation.ITypeChecker;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;

public final class TypeChecker implements ITypeChecker {
	
	private final BaseValidator base;
	
	public TypeChecker(BaseValidator base) {
		this.base = base;
	}
	
	@Override
	public Set<IType> acceptedTypesForInsertion(Set<IType> variableTypes) {
		Set<IType> acceptedTypes = new HashSet<>();
		
		for(IType variableType : variableTypes) {
			if(isInteger(variableType)) {
				acceptedTypes.add(variableType);
			}
			else if(isString(variableType)) {
				acceptedTypes.add(variableType);
			}
			else if(variableType instanceof ICollectionType) {
				ICollectionType collection = (ICollectionType) variableType;
				if(collection.getCollectionType() != null) {
					acceptedTypes.add(collection.getCollectionType());
					acceptedTypes.add(collection);
				}
			}
		}
		return acceptedTypes;
	}
	
	@Override
	public Set<IType> acceptedTypesForRemoval(Set<IType> variableTypes) {
		Set<IType> acceptedTypes = new HashSet<>();
		
		for(IType variableType : variableTypes) {
			if(isInteger(variableType)) {
				acceptedTypes.add(variableType);
			}
			else if(variableType instanceof ICollectionType) {
				ICollectionType collection = (ICollectionType) variableType;
				if(collection.getCollectionType() != null) {
					acceptedTypes.add(collection.getCollectionType());
					acceptedTypes.add(collection);
				}
			}
		}
		return acceptedTypes;
	}
	
	@Override
	public boolean acceptsInsertion(Set<IType> variableTypes, Set<IType> valueTypes) {
		for (IType variableType : variableTypes) {
			for (IType valueType : valueTypes) {
				if(isInteger(variableType) && isInteger(valueType)) {
					// addition
					return true;
				}
				if(isString(variableType) && isString(valueType)) {
					// string concatenation
					return true;
				}
				if(isCollection(variableType) && elementCanBelongToCollection(variableType, valueType)) {
					// addition of an element to a collection
					return true;
				}
				if(isCollection(variableType) && isCollection(valueType) && isAssignable(variableType, valueType)) {
					// collections concatenation
					return true;
			}
		}
		}
		return false;
	}
	
	@Override
	public boolean acceptsRemoval(Set<IType> variableTypes, Set<IType> valueTypes) {
		for (IType variableType : variableTypes) {
			for (IType valueType : valueTypes) {
				if(isInteger(variableType) && isInteger(valueType)) {
					// subtraction
					return true;
				}
				if(isCollection(variableType) && elementCanBelongToCollection(variableType, valueType)) {
					// removing an element from a collection
					return true;
				}
				if(isCollection(variableType) && isCollection(valueType) && isAssignable(variableType, valueType)) {
					// collections difference
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public boolean elementCanBelongToCollection(IType collectionType, IType elementType) {
		if(!(collectionType instanceof ICollectionType)) {
			return false;
		}
		ICollectionType pcollectionType = (ICollectionType) collectionType;
		return isAssignable(pcollectionType.getCollectionType(), newHashSet(elementType));
	}
	
	@Override
	public Optional<IType> findCompatibleType(IType variableType, Set<IType> valueTypes) {
		return valueTypes.stream()
						 .filter(inferredType -> isAssignable(variableType, inferredType))
						 .findAny();
	}
	
	@Override
	public boolean isAssignable(IType variableType, IType valueType) {
		// FIXME Check custom EClass somehow. The algorithm could be:
		//			1. Check whether either targetType or valueType correspond to a class defined in user's metamodel
		//			2. If yes, then somehow ensure types are coherent
		//			3. If not, then delegate to IType#isAssignableFrom
		//
		// It could also worth considering adding EObject as a super type of user's classes to help IType doing its
		// job well. This could be done in DslBuilder#register(List<EPackages>).
		if (isNull(valueType)) {
			return true;
		}
		boolean bothAreCollections = isCollection(variableType) && isCollection(valueType);
		if(bothAreCollections) {
			return collectionsHaveCompatibleGenericTypes(variableType, valueType);
		}
		if(isBoolean(variableType) && isBoolean(valueType)) {
			return true;
		}
		if(isInteger(variableType) && isInteger(valueType)) {
			return true;
		}
		if(isString(variableType) && isString(valueType)) {
			return true;
		}
		return variableType.isAssignableFrom(valueType);
	}
	
	private boolean collectionsHaveCompatibleGenericTypes(IType variable, IType value) {
		IType variableCollectionType = ((ICollectionType) variable).getCollectionType();
		IType valueCollectionType = ((ICollectionType) value).getCollectionType();
		
		if(isUnknown(variableCollectionType)) {
			// The variable has no generic type and can hence holds any Object.
			// As such, any other collection is compatible with it.
			return true;
		}
		if(isUnknown(valueCollectionType)) {
			// The value has no generic type and can hence be assigned to any other collection
			return true;
		}
		return isAssignable(variableCollectionType, valueCollectionType);
	}
	
	@Override
	public boolean isAssignable(IType variableType, Set<IType> valueTypes) {
		return findCompatibleType(variableType, valueTypes).isPresent();
	}

	
	@Override
	public boolean isBoolean(Expression exp) {
		Set<IType> expressionTypes = base.getPossibleTypes(exp);
		return expressionTypes.stream()
					   		  .anyMatch(type -> isBoolean(type));
	}
	
	@Override
	public boolean isBoolean(IType type) {
		final IType booleanObjectType = new ClassType(base.getQryEnv(), Boolean.class);
		final IType booleanType = new ClassType(base.getQryEnv(), boolean.class);
		
		return booleanObjectType.isAssignableFrom(type) || booleanType.isAssignableFrom(type);
	}
	
	@Override
	public boolean isCollection(IType type) {
		return type instanceof ICollectionType;
	}
	
	@Override
	public boolean isInteger(IType type) {
		// Match primitives, e.g. 42
		if (Integer.class.equals(type.getType()) ) {
			return true;
		}
		// Match variables of type Int
		if (type.getType() instanceof EDataType) {
			EDataType dataType = (EDataType) type.getType();
			return int.class.equals(dataType.getInstanceClass())
				|| Integer.class.equals(dataType.getInstanceClass());
		}
		return false;
	}
	
	@Override
	public boolean isNull(IType type) {
		if (type.getType() == null) {
			return true;
		}
		if (type instanceof NothingType) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isString(IType type) {
		// Match primitives, e.g. 'hello'
		if(String.class.equals(type.getType())) {
			return true;
		}
		// Match primitives, e.g. 'hello'
		if(type.getType() == EcorePackage.eINSTANCE.getEString()) {
			return true;
		}
		// Match variables of type String
		if(type.getType() instanceof EDataType) {
			EDataType dataType = (EDataType) type.getType();
			return String.class.equals(dataType.getInstanceClass());
		}
		return false;
	}
	
	@Override
	public boolean isUnknown(IType type) {
		return type == null || type instanceof NothingType;
	}
	
	@Override
	public boolean isUnresolved(ETypedElement type) {
		return type.getEType() == ImplementationPackage.eINSTANCE.getUnresolvedEClassifier();
	}

	@Override
	public boolean supportsInsertion(IType type) {
		if(isCollection(type)) {
			return true;
		}
		if(isInteger(type)) {
			return true;
		}
		if(isString(type)) {
			return true;
		}
		// FIXME handle other numbers
		return false;
	}
	
	@Override
	public boolean supportsRemoval(IType type) {
		if(isCollection(type)) {
			return true;
		}
		if(isInteger(type)) {
			return true;
		}
		// FIXME handle other numbers
		return false;
	}

}
