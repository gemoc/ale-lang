package org.eclipse.emf.ecoretools.ale.core.validation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.acceleo.query.runtime.impl.ValidationMessage;
import org.eclipse.acceleo.query.validation.type.ClassType;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.ICollectionType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.While;

import com.google.common.collect.Lists;

public class TypeValidator implements IValidator {

	public static final String INCOMPATIBLE_TYPE = "Expected %s but was %s";
	public static final String BOOLEAN_TYPE = "Expected Boolean but was %s";
	public static final String COLLECTION_TYPE = "Expected Collection but was %s";
	public static final String VOID_RESULT_ASSIGN = "'result' is assigned in void operation";
	public static final String EXTENDS_ITSELF = "Reopened %s is extending itself";
	public static final String EXTENDS_BASE_CLASS = "%s is not a sub type of %s";
	
	BaseValidator base;
	
	public void setBase(BaseValidator base) {
		this.base = base;
	}
	
	@Override
	public List<IValidationMessage> validateModelBehavior(List<ModelUnit> units) {
		return new ArrayList<IValidationMessage>();
	}
	
	@Override
	public List<IValidationMessage> validateModelUnit(ModelUnit unit) {
		return new ArrayList<IValidationMessage>();
	}
	
	@Override
	public List<IValidationMessage> validateExtendedClass(ExtendedClass xtdClass) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		msgs.addAll(validateBehavioredClass(xtdClass));
		
		if(isExtendingItself(xtdClass)) {
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(EXTENDS_ITSELF, xtdClass.getBaseClass().getName()),
					base.getStartOffset(xtdClass),
					base.getEndOffset(xtdClass)
					));
		}
		
		EClass baseCls = xtdClass.getBaseClass();
		List<EClass> notSuperEClass = 
			xtdClass
			.getExtends()
			.stream()
			.map(c -> c.getBaseClass())
			.filter(cls -> !cls.isSuperTypeOf(baseCls))
			.collect(Collectors.toList());
		if(!notSuperEClass.isEmpty()) {
			String types = 
				notSuperEClass
				.stream()
				.map(type -> type.getName())
				.collect(Collectors.joining(",","[","]"));
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(EXTENDS_BASE_CLASS, xtdClass.getBaseClass().getName(),types),
					base.getStartOffset(xtdClass),
					base.getEndOffset(xtdClass)
					));
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateRuntimeClass(RuntimeClass classDef) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		msgs.addAll(validateBehavioredClass(classDef));
		
		return msgs;
	}
	
	private List<IValidationMessage> validateBehavioredClass(BehavioredClass clazz) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
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
					.map(type -> type.toString())
					.collect(Collectors.joining(",","[","]"));
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(INCOMPATIBLE_TYPE, att.getFeatureRef().getEType().getName(),types),
						base.getStartOffset(att),
						base.getEndOffset(att)
						));
			}
		});
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateMethod(Method mtd) {
		return new ArrayList<IValidationMessage>();
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
	
	private List<IValidationMessage> validateAssignment(Statement stmt, Expression targetExp, String featureName, Expression valueExp, boolean checkIsCollection) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		/*
		 * Collect feature types
		 */
		Set<IType> targetTypes = base.getPossibleTypes(targetExp);
		Set<EClassifierType> featureTypes = new HashSet<EClassifierType>();
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
		 * Check targetExp.featureName is collection
		 */
		if(checkIsCollection && !isCollection) {
			String inferredToString = 
					featureTypes
					.stream()
					.map(type -> type.toString())
					.collect(Collectors.joining(",","[","]"));
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(COLLECTION_TYPE,inferredToString),
					base.getStartOffset(targetExp),
					base.getEndOffset(targetExp)
					));
		}
		
		/*
		 * Check assignment type
		 */
		if(!featureTypes.isEmpty()){
			Set<IType> inferredTypes = base.getPossibleTypes(valueExp);
			boolean isAnyAssignable = false;
			for(IType featureType: featureTypes){
				Optional<IType> existResult = inferredTypes.stream().filter(t -> featureType.isAssignableFrom(t)).findAny();
				if(existResult.isPresent()){
					isAnyAssignable = true;
					break;
				}
			}
			if(!isAnyAssignable){
				String inferredToString = 
					inferredTypes
					.stream()
					.map(type -> type.toString())
					.collect(Collectors.joining(",","[","]"));
				String featureToString = 
						featureTypes
						.stream()
						.map(type -> type.getType().getName())
						.collect(Collectors.joining(",","[","]"));
				
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(INCOMPATIBLE_TYPE,featureToString,inferredToString),
						base.getStartOffset(stmt),
						base.getEndOffset(stmt)
						));
			}
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateVariableAssignment(VariableAssignment varAssign) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		Map<String, Set<IType>> declaringScope = base.findScope(varAssign.getName());
		if(varAssign.getName().equals("result")) {
			Method op = base.getContainingOperation(varAssign);
			EOperation eOp = ((Method)op).getOperationRef();
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
				EClassifier returnType = eOp.getEType();
				EClassifierType declaredType = new EClassifierType(base.getQryEnv(), returnType);
				Set<IType> inferredTypes = base.getPossibleTypes(varAssign.getValue());
				Optional<IType> matchingType = inferredTypes.stream().filter(type -> declaredType.isAssignableFrom(type)).findAny();
				if(!matchingType.isPresent()) {
					String types = 
							inferredTypes
							.stream()
							.map(type -> type.toString())
							.collect(Collectors.joining(",","[","]"));
					msgs.add(new ValidationMessage(
							ValidationMessageLevel.ERROR,
							String.format(INCOMPATIBLE_TYPE,returnType.getName(),types),
							base.getStartOffset(varAssign),
							base.getEndOffset(varAssign)
							));
				}
			}
		}
		else if(declaringScope != null && !varAssign.getName().equals("self")) {
			Set<IType> declaredTypes = declaringScope.get(varAssign.getName());
			Set<IType> inferredTypes = base.getPossibleTypes(varAssign.getValue());
			if(declaredTypes != null && inferredTypes != null) {
				Optional<IType> existResult = 
					declaredTypes
					.stream()
					.filter(declType -> 
					inferredTypes
						.stream()
						.filter(expectedType -> declType.isAssignableFrom(expectedType))
						.findAny()
						.isPresent()
					)
					.findAny();
				if(!existResult.isPresent()){
					String declaredToString = 
							declaredTypes
							.stream()
							.map(type -> type.toString())
							.collect(Collectors.joining(",","[","]"));
					String inferredToString = 
							inferredTypes
							.stream()
							.map(type -> type.toString())
							.collect(Collectors.joining(",","[","]"));
					
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
	
	@Override
	public List<IValidationMessage> validateVariableDeclaration(VariableDeclaration varDecl) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		if(varDecl.getInitialValue() != null) {
			EClassifierType varType = new EClassifierType(base.getQryEnv(), varDecl.getType());
			Set<IType> inferredTypes = base.getPossibleTypes(varDecl.getInitialValue());
			if(inferredTypes != null) {
				Optional<IType> existResult = inferredTypes.stream().filter(t -> varType.isAssignableFrom(t)).findAny();
				if(!existResult.isPresent()){
					String inferredToString = 
							inferredTypes
							.stream()
							.map(type -> type.toString())
							.collect(Collectors.joining(",","[","]"));
					
					msgs.add(new ValidationMessage(
							ValidationMessageLevel.ERROR,
							String.format(INCOMPATIBLE_TYPE,varDecl.getType().getName(),inferredToString),
							base.getStartOffset(varDecl),
							base.getEndOffset(varDecl)
							));
				}
			}
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateForEach(ForEach loop) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
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
					.map(type -> type.toString())
					.collect(Collectors.joining(",","[","]"));
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
		return validateIsBoolean(ifStmt.getCondition());
	}
	
	@Override
	public List<IValidationMessage> validateWhile(While loop) {
		return validateIsBoolean(loop.getCondition());
	}
	
	private List<IValidationMessage> validateIsBoolean(Expression exp) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();

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
					.map(type -> type.toString())
					.collect(Collectors.joining(",","[","]"));
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
}
