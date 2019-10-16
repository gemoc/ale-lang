/*******************************************************************************
 * Copyright (c) 2017-2019 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.validation;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.eclipse.emf.ecoretools.ale.core.validation.QualifiedNames.getQualifiedName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.acceleo.query.runtime.impl.ValidationMessage;
import org.eclipse.acceleo.query.validation.type.AbstractCollectionType;
import org.eclipse.acceleo.query.validation.type.ClassType;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.ICollectionType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.NothingType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.ConditionalBlock;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.VariableInsert;
import org.eclipse.emf.ecoretools.ale.implementation.VariableRemove;
import org.eclipse.emf.ecoretools.ale.implementation.While;

import com.google.common.collect.Lists;

// FIXME This class becomes too complex; it should be split into simpler ones
public class TypeValidator implements IValidator {

	public static final String INCOMPATIBLE_TYPE = "Expected %s but was %s";
	public static final String BOOLEAN_TYPE = "Expected ecore::EBoolean but was %s";
	public static final String COLLECTION_TYPE = "Expected Collection but was %s";
	public static final String VOID_RESULT_ASSIGN = "'result' is assigned in void operation";
	public static final String EXTENDS_ITSELF = "Reopened %s is extending itself";
	public static final String INDIRECT_EXTENSION = "Can't extend %s since it is not a direct super type of %s";
	public static final String SELF_INSERT = "Cannot insert anything into 'self'";
	public static final String SELF_REMOVE = "Cannot remove anything from 'self'";
	
	BaseValidator base;
	
	public void setBase(BaseValidator base) {
		this.base = base;
	}
	
	@Override
	public List<IValidationMessage> validateModelBehavior(List<ModelUnit> units) {
		return new ArrayList<>();
	}
	
	@Override
	public List<IValidationMessage> validateModelUnit(ModelUnit unit) {
		return new ArrayList<>();
	}
	
	@Override
	public List<IValidationMessage> validateExtendedClass(ExtendedClass xtdClass) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		msgs.addAll(validateBehavioredClass(xtdClass));
		
		if(isExtendingItself(xtdClass)) {
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(EXTENDS_ITSELF, getQualifiedName(xtdClass.getBaseClass())),
					base.getStartOffset(xtdClass),
					base.getEndOffset(xtdClass)
					));
		}
		
		EClass baseCls = xtdClass.getBaseClass();
		EList<EClass> superTypes = baseCls.getESuperTypes();
		
		List<EClass> extendsBaseClasses =
				xtdClass
				.getExtends()
				.stream()
				.map(xtd -> xtd.getBaseClass())
				.collect(toList());
		
		extendsBaseClasses.forEach(superBase -> {
			if(!superTypes.contains(superBase) && baseCls != superBase) {
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(INDIRECT_EXTENSION, getQualifiedName(superBase), getQualifiedName(baseCls)),
						this.base.getStartOffset(xtdClass),
						this.base.getEndOffset(xtdClass)
						));
			}
		});
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateRuntimeClass(RuntimeClass classDef) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		msgs.addAll(validateBehavioredClass(classDef));
		
		return msgs;
	}
	
	private List<IValidationMessage> validateBehavioredClass(BehavioredClass clazz) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		clazz
		.getAttributes()
		.stream()
		.filter(att -> att.getInitialValue() != null)
		.forEach(att -> {
			Set<IType> inferredTypes = base.getPossibleTypes(att.getInitialValue());
			EClassifierType declaredType = new EClassifierType(base.getQryEnv(), att.getFeatureRef().getEType());
			Optional<IType> existResult = inferredTypes.stream().filter(type -> declaredType.isAssignableFrom(type)).findAny();
			if(!existResult.isPresent()){
				String types = 
					inferredTypes
					.stream()
					.map(type -> getQualifiedName(type))
					.collect(joining(",","[","]"));
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(INCOMPATIBLE_TYPE, getQualifiedName(att.getFeatureRef().getEType()),types),
						base.getStartOffset(att),
						base.getEndOffset(att)
						));
			}
		});
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateMethod(Method mtd) {
		return new ArrayList<>();
	}
	
	@Override
	public List<IValidationMessage> validateFeatureAssignment(FeatureAssignment featAssign) {
		return validateAssignment(featAssign, featAssign.getTarget(), featAssign.getTargetFeature(), featAssign.getValue(), false);
	}
	
	@Override
	public List<IValidationMessage> validateFeatureInsert(FeatureInsert featInsert) {
		return validateAssignment(featInsert, featInsert.getTarget(), featInsert.getTargetFeature(), featInsert.getValue(), true);
	}
	
	@Override
	public List<IValidationMessage> validateFeatureRemove(FeatureRemove featRemove) {
		
		return validateAssignment(featRemove, featRemove.getTarget(), featRemove.getTargetFeature(), featRemove.getValue(), true);
	}
	
	private List<IValidationMessage> validateAssignment(Statement stmt, Expression targetExp, String featureName, Expression valueExp, boolean isInsert) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		/*
		 * Collect feature types to perform tests thereafter
		 */
		Set<IType> targetTypes = base.getPossibleTypes(targetExp);
		Set<EClassifierType> featureTypes = new HashSet<>();
		boolean isCollection = false;
		for(IType type: targetTypes){
			if(type.getType() instanceof EClass){
				EClass realType = (EClass) type.getType();
				EStructuralFeature feature = realType.getEStructuralFeature(featureName);
				
				if(feature  != null){ //static features
					EClassifierType featureType = new EClassifierType(base.getQryEnv(), feature.getEType());
					featureTypes.add(featureType);
					isCollection = feature.isMany();
				}
				else { //runtime features
					List<ExtendedClass> extensions = base.findExtensions(realType);
					
					Optional<Attribute> foundDynamicAttribute = //FIXME: take inheritance in account
						extensions
						.stream()
						.flatMap(xtdCls -> xtdCls.getAttributes().stream())
						.filter(field -> field.getFeatureRef().getName().equals(featureName))
						.findFirst();
					if(foundDynamicAttribute.isPresent()) {
						EClassifierType featureType = new EClassifierType(base.getQryEnv(), foundDynamicAttribute.get().getFeatureRef().getEType());
						featureTypes.add(featureType);
						isCollection = foundDynamicAttribute.get().getFeatureRef().isMany();
					}
				}
			}
		}
		
		/*
		 * Check that targetExp.featureName is a collection
		 * 
		 * Provides an error message when the user attempts to insert
		 * an object within a variable that is not a collection, e.g.:
		 * 
		 * 		self.notACollection += anObject
		 */
		boolean isTryingToInsertSomeValueWithinAScalar = isInsert && !isCollection && !featureTypes.isEmpty();
		if(isTryingToInsertSomeValueWithinAScalar) {
			boolean scalarAcceptsInsertion = canInsert(featureTypes, base.getPossibleTypes(valueExp));
			if(!scalarAcceptsInsertion) {
				String inferredToString = 
						featureTypes
						.stream()
						.map(type -> getQualifiedName(type))
						.collect(joining(",","[","]"));
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(COLLECTION_TYPE,inferredToString),
						base.getStartOffset(targetExp),
						base.getEndOffset(targetExp)
						));
			}
		}
		
		/*
		 * Check assignment type
		 */
		if(!featureTypes.isEmpty()) {
			
			/*
			 * Those are the types returned by the expression at the right of the '=' symbol.
			 * We are now going to ensure that the feature targeted by the assignment is compatible
			 * with at least one of them.
			 */
			Set<IType> inferredTypes = base.getPossibleTypes(valueExp);

			if(!isInsert && isCollection) {
				for(IType inferredType: inferredTypes){
					if(inferredType instanceof AbstractCollectionType) {
						IType collectionType = ((AbstractCollectionType)inferredType).getCollectionType();
						
						// FIXME Is something missing here?
					}
				}
				boolean isAnyAssignable = false;
				for(IType featureType: featureTypes) {
					Optional<IType> existResult = 
							inferredTypes
							.stream()
							.filter(t -> t instanceof AbstractCollectionType)
							.map(t -> ((AbstractCollectionType)t).getCollectionType())
							.filter(t -> featureType.isAssignableFrom(t))
							.findAny();
					if(existResult.isPresent()){
						isAnyAssignable = true;
						break;
					}
				}
				if(!isAnyAssignable) {
					String inferredToString = 
							inferredTypes
							.stream()
							.map(type -> getQualifiedName(type))
							.collect(joining(",","[","]"));
					String featureToString = 
							featureTypes
							.stream()
							.map(type -> getQualifiedName(type.getType()))
							.collect(joining(",","(",")"));
					msgs.add(new ValidationMessage(
							ValidationMessageLevel.ERROR,
							String.format(INCOMPATIBLE_TYPE,"[Collection"+featureToString+"]",inferredToString),
							base.getStartOffset(stmt),
							base.getEndOffset(stmt)
							));
				}
			}
			else {
				boolean isAnyAssignable = false;
				for(IType featureType: featureTypes){
					Optional<IType> existResult = inferredTypes
							.stream()
							.filter(t -> 
								isAssignable(featureType, t)
								|| (featureType.getType()  == EcorePackage.eINSTANCE.getEEList() && t instanceof AbstractCollectionType )) // TODO should be able to be more precise
							.findAny();
					if(existResult.isPresent()){
						isAnyAssignable = true;
						break;
					}
				}
				if(!isAnyAssignable){
					String inferredToString = 
							inferredTypes
							.stream()
							.map(type -> getQualifiedName(type))
							.collect(joining(",","[","]"));
					String featureToString = 
							featureTypes
							.stream()
							.map(type -> getQualifiedName(type.getType()))
							.collect(joining(",","[","]"));
					
					msgs.add(new ValidationMessage(
							ValidationMessageLevel.ERROR,
							String.format(INCOMPATIBLE_TYPE,featureToString,inferredToString),
							base.getStartOffset(stmt),
							base.getEndOffset(stmt)
							));
				}
				
			}
			
		}
		
		return msgs;
	}
	
	/**
	 * Determines whether a value of a given types can be inserted to a variable of another types.
	 * 
	 * @param featureTypes
	 * 			The types of the variable to which a value could be inserted.
	 * @param possibleTypes
	 * 			The types of the value to insert.
	 * 
	 * @return true if a value of a given types can be inserted to a variable of another types
	 */
	private boolean canInsert(Set<EClassifierType> featureTypes, Set<IType> possibleTypes) {
		for(EClassifierType eClassifierType : featureTypes) {
			if(eClassifierType.getType() instanceof EDataType) {
				EDataType eDataType = (EDataType) eClassifierType.getType();
				
				// If both are String then we can insert the second one by concatenating the strings
				
				if(String.class.equals(eDataType.getInstanceClass())) {
					for(IType iType : possibleTypes) {
						if(String.class.equals(iType.getType())) {
							return true;
						}
					}
				}
				
				// If both are Integers then we can insert the second one by adding its value to the first one
				
				if(int.class.equals(eDataType.getInstanceClass())) {
					for(IType iType : possibleTypes) {
						Object type = iType.getType();
						// Match adding a primitive (e.g. a += 2)
						if(Integer.class.equals(type)) {
							return true;
						}
						// Match adding a variable (e.g. a += b)
						if(type instanceof EDataType) {
							return int.class.equals(((EDataType) type).getInstanceClass());
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public List<IValidationMessage> validateVariableAssignment(VariableAssignment varAssign) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		Set<IType> declaringTypes = findDeclaredTypes(varAssign);
		if(varAssign.getName().equals("result")) {
			Method op = base.getContainingOperation(varAssign);
			EOperation eOp = ((Method)op).getOperationRef();
			if(eOp != null) {
				boolean isVoidOp = eOp.getEType() == null && eOp.getEGenericType() == null;
				
				if(isVoidOp) {
					msgs.add(new ValidationMessage(
							ValidationMessageLevel.ERROR,
							String.format(VOID_RESULT_ASSIGN,varAssign.getName()),
							base.getStartOffset(varAssign),
							base.getEndOffset(varAssign)
							));
				}
				else {
					
					Optional<EOperation> eOperation = findContainingEOperation(varAssign);
					EClassifier returnType = eOp.getEType();
					EClassifierType declaredType = new EClassifierType(base.getQryEnv(), returnType);
					Set<IType> inferredTypes = base.getPossibleTypes(varAssign.getValue());
					Optional<IType> matchingType = inferredTypes
							.stream()
							.filter(inferredType -> 
								isInferredTypeCompatibleForResultVar(declaredType, eOperation, inferredType))
							.findAny();
					if(!matchingType.isPresent()) {
						String types = 
								inferredTypes
								.stream()
								.map(type -> getQualifiedName(type))
								.collect(joining(",","[","]"));
						msgs.add(new ValidationMessage(
								ValidationMessageLevel.ERROR,
								String.format(INCOMPATIBLE_TYPE,"["+getTypeQualifiedNameForOperationResult(declaredType, eOperation)+"]",types),
								base.getStartOffset(varAssign),
								base.getEndOffset(varAssign)
								));
					}
				}
			}
		}
		else if(declaringTypes != null && !varAssign.getName().equals("self")) {
			Set<IType> inferredTypes = base.getPossibleTypes(varAssign.getValue());
			
			if(inferredTypes != null && !declaringTypes.isEmpty()) {
				
				Optional<VariableDeclaration> declaration = findDeclaration(varAssign);
				Optional<IType> existResult = 
						declaringTypes
						.stream()
						.filter(declType -> 
							inferredTypes
								.stream()
								.filter(inferredType ->
									isInferredTypeCompatibleForVar(declType, declaration, inferredType))
								.findAny()
								.isPresent()
							)
						.findAny();
				if(!existResult.isPresent()){
					String declaredToString = 
							declaringTypes
							.stream()
							.map(type -> getTypeQualifiedNameForVar(type,declaration))
							.collect(joining(",","[","]"));
					String inferredToString = 
							inferredTypes
							.stream()
							.map(type -> getQualifiedName(type))
							.collect(joining(",","[","]"));
					
					msgs.add(new ValidationMessage(
							ValidationMessageLevel.ERROR,
							String.format(INCOMPATIBLE_TYPE,declaredToString,inferredToString),
							base.getStartOffset(varAssign),
							base.getEndOffset(varAssign)
							));
				}
				
			}
		}
		
		return msgs;
	}
	
	/**
	 * Determines whether an instance of a given type can be assigned to a variable of another type. 
	 * <p>
	 * This function is required because {@link IType#isAssignableFrom(IType)} does not work as expected
	 * when its parameter represents a metaclass defined within user's metamodel. Reasons are the following:
	 * <ul>
	 * 	<li>when the package is registered, EMF does not register the type as a subtype of EClass. This is
	 * 		likely expected since not explicitly stated in the metamodel, but still surprising. Hence, given:
	 * 		<ul>
	 * 			<li>target = EClass
	 * 			<li>value = Greet (a custom EClass)
	 * 		</ul>
	 * 		Acceleo is not able to determine that Greet inherits from EClass and returns false when 
	 * 		{@code target.isAssignableFrom(value)} is called.
	 * 
	 * 	<li>when no corresponding Java class is registered for the user class (which happens at least when 
	 * 		the user has defined a metamodel but didn't generate any code) then the method returns true most
	 *      of the time. That's because, since Acceleo is not able to determine that user's class inherits internally the algorithm is close to:
	 * 		<pre>boolean isAssignableFrom(otherType) {
	 *    if (getJavaClass(otherType) == null) {
	 *        return this.isAssignable(null); 
	 *    }
	 *    return getJavaClass(this).isAssignableFrom(getJavaClass(otherType);
	 *}</pre>
	 * </ul>
	 * This method performs checks corresponding to the previous cases then calls {@link IType#isAssignableFrom(IType)}.
	 * 
	 * @param targetType
	 * 			The type of the variable to which a value should be assigned
	 * @param valueType
	 * 			The type of the expression to assign to the variable
	 * 
	 * @return whether a value of type {@code valueType} can be assigned to a variable of type {@code target}
	 */
	private boolean isAssignable(IType targetType, IType valueType) {
		// FIXME Check the types somehow. The algorithm could be:
		//			1. Check whether either targetType or valueType correspond to a class defined in user's metamodel
		//			2. If yes, then somehow ensure types are coherent
		//			3. If not, then delegate to IType#isAssignableFrom
		//
		// It would also worth considering adding EObject as a super type of user's classes to help IType to do its
		// job well. This could be done in DslBuilder#register(List<EPackages>).
		
		return targetType.isAssignableFrom(valueType);
	}

	private String getTypeQualifiedNameForOperationResult(IType declaredType, Optional<EOperation> eOperation) {
		if( declaredType.getType() == EcorePackage.eINSTANCE.getEEList()) {
			// collection
			if(eOperation.isPresent()) {
				if(eOperation.get().getEGenericType().getETypeArguments().isEmpty()) {
					return "Collection(?)";
				} else {
					EClassifierType varTypeParam = new EClassifierType(base.getQryEnv(), eOperation.get().getEGenericType().getETypeArguments().get(0).getEClassifier());
					return "Collection("+getQualifiedName(varTypeParam)+")";
				}
			}
		} 
		return getQualifiedName(declaredType);
	}
	private String getTypeQualifiedNameForVar(IType declaredType, Optional<VariableDeclaration> declaration) {
		if( declaredType.getType() == EcorePackage.eINSTANCE.getEEList()) {
			if(declaration.isPresent()) {
				// collection
				EClassifierType varTypeParam = new EClassifierType(base.getQryEnv(), declaration.get().getTypeParameter());
				//return getQualifiedName(declaration.get().getType())+"("+getQualifiedName(varTypeParam)+")";
				return "Collection("+getQualifiedName(varTypeParam)+")";
				
			}
		} 
		return getQualifiedName(declaredType);
	}
	/**
	 * in case of collection, extract information from the Var declaration to check if the inferred type is compatible
	 * @param declaredType
	 * @param declaration
	 * @param inferredType
	 * @return
	 */
	private boolean isInferredTypeCompatibleForVar(IType declaredType, Optional<VariableDeclaration> declaration, IType inferredType) {
		if(declaredType.getType() == EcorePackage.eINSTANCE.getEEList() && inferredType instanceof AbstractCollectionType) {
			if(declaration.isPresent()) {
				EClassifierType varTypeParam = new EClassifierType(base.getQryEnv(), declaration.get().getTypeParameter());
				IType collectionType = ((AbstractCollectionType)inferredType).getCollectionType();
				return varTypeParam.isAssignableFrom(collectionType) || collectionType instanceof NothingType;
			}
		} 
		return declaredType.isAssignableFrom(inferredType);
	}
	/**
	 * in case of collection, extract information from the EOperation declaration to check if the inferred type is compatible
	 * @param declaredType
	 * @param eOperation
	 * @param inferredType
	 * @return
	 */
	private boolean isInferredTypeCompatibleForResultVar(IType declaredType, Optional<EOperation> eOperation, IType inferredType) {
		if(declaredType.getType() == EcorePackage.eINSTANCE.getEEList() && inferredType instanceof AbstractCollectionType) {
			if(eOperation.isPresent() && inferredType instanceof AbstractCollectionType) {
				IType collectionType = ((AbstractCollectionType)inferredType).getCollectionType();
				if(eOperation.get().getEGenericType().getETypeArguments().isEmpty()) {
					// no type argument provided in the EOperation definition ! accept any collection content
					return true;
					
				} else if(collectionType instanceof NothingType){
					return true;
				} else {
					EClassifierType varTypeParam = new EClassifierType(base.getQryEnv(), eOperation.get().getEGenericType().getETypeArguments().get(0).getEClassifier());
					return varTypeParam.isAssignableFrom(collectionType);
				}
			}
		} 
		return declaredType.isAssignableFrom(inferredType);
	}
	
	
	@Override
	public List<IValidationMessage> validateVariableDeclaration(VariableDeclaration varDecl) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		if(varDecl.getInitialValue() != null) {
			
			EClassifier declaredType = varDecl.getType();
			Set<IType> inferredTypes = base.getPossibleTypes(varDecl.getInitialValue());
			if(inferredTypes != null) {
				
				if(declaredType == EcorePackage.eINSTANCE.getEEList()) {
					EClassifierType varTypeParam = new EClassifierType(base.getQryEnv(), varDecl.getTypeParameter());
					Optional<IType> existResult =
							inferredTypes
							.stream()
							.filter(t -> t instanceof AbstractCollectionType)
							.map(t -> ((AbstractCollectionType)t).getCollectionType())
							.filter(t -> varTypeParam.isAssignableFrom(t) || t instanceof NothingType)
							.findAny();
					if(!existResult.isPresent()) {
						String inferredToString = 
								inferredTypes
								.stream()
								.map(type -> getQualifiedName(type))
								.collect(joining(",","[","]"));

						msgs.add(new ValidationMessage(
								ValidationMessageLevel.ERROR,
								String.format(INCOMPATIBLE_TYPE,"Collection("+getQualifiedName(varTypeParam)+")",inferredToString),
								base.getStartOffset(varDecl),
								base.getEndOffset(varDecl)
								));
					}
				}
				else {
					EClassifierType varType = new EClassifierType(base.getQryEnv(), varDecl.getType());
					Optional<IType> existResult =
							inferredTypes
							.stream()
							.filter(t -> varType.isAssignableFrom(t) 
									|| (t instanceof AbstractCollectionType && varDecl.getType() == EcorePackage.eINSTANCE.getEEList())) //TODO: check collection type parameter
							.findAny();
					if(!existResult.isPresent()) {
						String inferredToString = 
								inferredTypes
								.stream()
								.map(type -> getQualifiedName(type))
								.collect(joining(",","[","]"));
						
						msgs.add(new ValidationMessage(
								ValidationMessageLevel.ERROR,
								String.format(INCOMPATIBLE_TYPE,getQualifiedName(varDecl.getType()),inferredToString),
								base.getStartOffset(varDecl),
								base.getEndOffset(varDecl)
								));
					}
				}
			}
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateVariableInsert(VariableInsert varInsert) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		if(varInsert.getName().equals("self")) {
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					SELF_INSERT,
					base.getStartOffset(varInsert),
					base.getEndOffset(varInsert)
					));
		}
		else {
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.WARNING,
					String.format("Unable to ensure that %s supports '+=' operator here", varInsert.getName()),
					base.getStartOffset(varInsert),
					base.getEndOffset(varInsert)
					));
		}
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateVariableRemove(VariableRemove varInsert) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		if(varInsert.getName().equals("self")) {
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					SELF_REMOVE,
					base.getStartOffset(varInsert),
					base.getEndOffset(varInsert)
					));
		}
		else {
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.WARNING,
					String.format("Unable to ensure that %s supports '-=' operator here", varInsert.getName()),
					base.getStartOffset(varInsert),
					base.getEndOffset(varInsert)
					));
		}
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateForEach(ForEach loop) {
		List<IValidationMessage> msgs = new ArrayList<>();
		
		/*
		 * Check expression is collection
		 */
		Optional<IType> existResult = 
			base
			.getPossibleTypes(loop.getCollectionExpression())
			.stream()
			.filter(type -> type instanceof ICollectionType)
			.findAny();
		if(!existResult.isPresent()) {
			String inferredToString = 
					base
					.getPossibleTypes(loop.getCollectionExpression())
					.stream()
					.map(type -> getQualifiedName(type))
					.collect(joining(",","[","]"));
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(COLLECTION_TYPE,inferredToString),
					base.getStartOffset(loop.getCollectionExpression()),
					base.getEndOffset(loop.getCollectionExpression())
					));
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateIf(If ifStmt) {
		List<IValidationMessage> res = new ArrayList<>();
		for (ConditionalBlock cBlock : ifStmt.getBlocks()) {
			res.addAll(validateIsBoolean(cBlock.getCondition()));
		}
		return res;
	}
	
	@Override
	public List<IValidationMessage> validateWhile(While loop) {
		return validateIsBoolean(loop.getCondition());
	}
	
	private List<IValidationMessage> validateIsBoolean(Expression exp) {
		List<IValidationMessage> msgs = new ArrayList<>();

		Set<IType> selectorTypes = base.getPossibleTypes(exp);
		boolean onlyNotBoolean = true;
		final IType booleanObjectType = new ClassType(base.getQryEnv(), Boolean.class);
		final IType booleanType = new ClassType(base.getQryEnv(), boolean.class);
		for (IType type : selectorTypes) {
			final boolean assignableFrom = booleanObjectType.isAssignableFrom(type)
					|| booleanType.isAssignableFrom(type);
			onlyNotBoolean = onlyNotBoolean && !assignableFrom;
		}
		if(onlyNotBoolean){
			String inferredToString = 
					selectorTypes
					.stream()
					.map(type -> getQualifiedName(type))
					.collect(joining(",","[","]"));
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(BOOLEAN_TYPE,inferredToString),
					base.getStartOffset(exp),
					base.getEndOffset(exp)
					));
		}
		
		return msgs;
	}
	
	private boolean isExtendingItself(ExtendedClass xtdClass) {
		
		List<ExtendedClass> todo = Lists.newArrayList(xtdClass);
		List<ExtendedClass> done = Lists.newArrayList();
		
		while(!todo.isEmpty()) {
			ExtendedClass current = todo.get(0);
			
			if(done.contains(current)) {
				return true;
			}
			
			todo.addAll(current.getExtends());
			
			done.add(current);
			todo.remove(0);
		}
		
		return false;
	}
	
	
	/**
	 * find the EOperation that contain this statement
	 */
	private Optional<EOperation> findContainingEOperation(Statement statement){

		// find containing method then EOperation
		EObject current = statement.eContainer();
		EClass type = ImplementationPackage.eINSTANCE.getMethod();
		while (current != null && !type.isSuperTypeOf(current.eClass()) && !type.isInstance(current)) {
			current = current.eContainer();
		}
		if (current != null && (type.isSuperTypeOf(current.eClass()) || type.isInstance(current))) {
			return Optional.ofNullable(((Method)current).getOperationRef());
		} 
		
		return Optional.empty();
	}
	
	private Optional<VariableDeclaration> findDeclaration(VariableAssignment varAssign) {
		
		String variableName = varAssign.getName();
		
		EObject currentObject = varAssign;
		EObject currentScope = varAssign.eContainer();
		
		while(currentScope != null) {
			if(currentScope instanceof Block) {
				Block block = (Block) currentScope;
				int index = block.getStatements().indexOf(currentObject);
				if(index != -1) {
					Optional<VariableDeclaration> candidate =
						block.getStatements()
						.stream()
						.limit(index)
						.filter(stmt -> stmt instanceof VariableDeclaration)
						.map(stmt -> (VariableDeclaration) stmt)
						.filter(varDecl -> varDecl.getName().equals(variableName))
						.findFirst();
					if(candidate.isPresent()) {
						return candidate;
					}
				}
			}
			
			currentObject = currentScope;
			currentScope = currentScope.eContainer();
		}
		
		return Optional.empty();
	}
	
	private Set<IType> findDeclaredTypes(VariableAssignment varAssign) {
		
		Set<IType> res = new HashSet<>();
		String variableName = varAssign.getName();
		
		// Look at extended EClass attributes
		EObject currentObject = varAssign;
		EObject currentScope = varAssign.eContainer();
		
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
						.filter(stmt -> stmt instanceof VariableDeclaration)
						.map(stmt -> (VariableDeclaration) stmt)
						.filter(varDecl -> varDecl.getName().equals(variableName))
						.findFirst();
					if(candidate.isPresent()) {
						EClassifier type = candidate.get().getType();
						res.add(new EClassifierType(base.getQryEnv(), type));
						return res;
					}
				}
			}
			
			// Look at loop's variable
			else if(currentScope instanceof ForEach) {
				ForEach loop = (ForEach) currentScope;
				if(loop.getVariable().equals(variableName)) {
					Set<IType> inferredTypes = base.getPossibleTypes(loop.getCollectionExpression());
					return inferredTypes;
				}
			}
			
			// Look at class extension
			else if(currentScope instanceof BehavioredClass) {
				BehavioredClass cls = (BehavioredClass) currentScope;
				Optional<Attribute> candidate = cls.getAttributes().stream().filter(attr -> attr.getFeatureRef().getName().equals(variableName)).findFirst();
				if(candidate.isPresent()) {
					EClassifier type = candidate.get().getFeatureRef().getEType();
					res.add(new EClassifierType(base.getQryEnv(), type));
					return res;
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
					res.add(new EClassifierType(base.getQryEnv(), type));
					return res;
				}
			}
			
			currentObject = currentScope;
			currentScope = currentScope.eContainer();
		}
		
		return res;
	}
}
