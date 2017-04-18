package org.eclipse.emf.ecoretools.ale.core.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.acceleo.query.runtime.impl.ValidationMessage;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
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
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.While;

/**
 * This validator checks validity, conflict and existence of named elements
 */
public class NameValidator implements IValidator {
	
	public static final String NAME_ALREADY_USED = "The name %s is already used";
	public static final String SELF_RESERVED = "'self' is a reserved name";
	public static final String RESULT_RESERVED = "'result' is a reserved name";
	public static final String OP_ALREADY_DECLARED = "The operation %s is already declared";
	public static final String FEATURE_UNDEFINED = "The feature %s is not defined";
	public static final String VARIABLE_UNDEFINED = "The variable %s is not defined";
	public static final String PARAM_ASSIGN = "%s is a parameter and can't be assigned";
	public static final String SELF_ASSIGN = "'self' can't be assigned";
	
	BaseValidator base;
	
	public void setBase(BaseValidator base) {
		this.base = base;
	}
	
	public List<IValidationMessage> validateModelBehavior(List<ModelUnit> units) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		/*
		 * Check ModelUnit names are unique
		 */
		List<String> declarations = new ArrayList<String>();
		units
		.stream()
		.forEach(unit -> {
			if(declarations.contains(unit.getName())) {
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(NAME_ALREADY_USED, unit.getName()),
						0,
						0
						));
			}
			else {
				declarations.add(unit.getName());
			}
		});
		
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateModelUnit(ModelUnit unit) {
		
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		/*
		 * Check duplication of RuntimeClass
		 */
		List<String> declarations = new ArrayList<String>(); 
		unit
		.getClassDefinitions()
		.stream()
		.forEach(cls -> {
			if(declarations.contains(cls.getName())) {
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(NAME_ALREADY_USED, cls.getName()),
						base.getStartOffset(cls),
						base.getEndOffset(cls)
						));
			}
			else {
				declarations.add(cls.getName());
			}
		});
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateExtendedClass(ExtendedClass xtdClass) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		//TODO: check cycles in 'extends'
		msgs.addAll(validateBehavioredClass(xtdClass));
		
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
		
		/*
		 * Check attributes names
		 */
		List<String> declarations = new ArrayList<String>(); 
		clazz
		.getAttributes()
		.stream()
		.forEach(att -> {
			String name = att.getFeatureRef().getName();
			if(declarations.contains(name)) {
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(NAME_ALREADY_USED, name),
						base.getStartOffset(att),
						base.getEndOffset(att)
						));
			}
			else if(name.equals("self")){
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(SELF_RESERVED, name),
						base.getStartOffset(att),
						base.getEndOffset(att)
						));
			}
			else if(name.equals("result")){
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(RESULT_RESERVED, name),
						base.getStartOffset(att),
						base.getEndOffset(att)
						));
			}
			else {
				declarations.add(name);
			}
		});
		
		/*
		 * Check operation duplication
		 */
		List<Method> previousOp = new ArrayList<Method>(); 
		for (Method mtd : clazz.getMethods()) {
			boolean isConflict = previousOp.stream().anyMatch(prevOp -> isMatching(mtd, prevOp));
			if(isConflict) {
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(OP_ALREADY_DECLARED, getSignature(mtd)),
						base.getStartOffset(mtd),
						base.getEndOffset(mtd)
						));
			}
			previousOp.add(mtd);
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateMethod(Method mtd) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		/*
		 * Check parameter name
		 */
		List<String> declarations = new ArrayList<String>();
		for (EParameter param : mtd.getOperationRef().getEParameters()) {
			String name = param.getName();
			if(declarations.contains(name)) {
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(NAME_ALREADY_USED,param.getName()),
						base.getStartOffset(mtd),
						base.getEndOffset(mtd)
						));
			}
			else if(param.getName().equals("result")){
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(RESULT_RESERVED,param.getName()),
						base.getStartOffset(mtd),
						base.getEndOffset(mtd)
						));
			}
			else if(param.getName().equals("self")){
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(SELF_RESERVED,param.getName()),
						base.getStartOffset(mtd),
						base.getEndOffset(mtd)
						));
			}
			else {
				declarations.add(name);
			}
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateFeatureAssignment(FeatureAssignment featAssign) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		/*
		 * Check the assigned feature exist 
		 */
		boolean isExistingFeature = false;
		Set<IType> targetTypes = base.getPossibleTypes(featAssign.getTarget());
		for(IType type: targetTypes){
			if(type.getType() instanceof EClass){
				EClass realType = (EClass) type.getType();
				EStructuralFeature feature = realType.getEStructuralFeature(featAssign.getTargetFeature());
				
				if(feature  != null){ //static features
					isExistingFeature = true;
				}
				else { //runtime features
					List<ExtendedClass> extensions = base.findExtensions(realType);
					Optional<Attribute> foundDynamicAttribute = //FIXME: take inheritance in account
						extensions
						.stream()
						.flatMap(xtdCls -> xtdCls.getAttributes().stream())
						.filter(field -> field.getFeatureRef().getName().equals(featAssign.getTargetFeature()))
						.findFirst();
					if(foundDynamicAttribute.isPresent()) {
						isExistingFeature = true;
					}
				}
			}
		}
		
		if(!isExistingFeature){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(FEATURE_UNDEFINED,featAssign.getTargetFeature()),
					base.getStartOffset(featAssign),
					base.getEndOffset(featAssign)
					));
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateFeatureInsert(FeatureInsert featInsert) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		/*
		 * Check the assigned feature exist 
		 */
		boolean isExistingFeature = false;
		Set<IType> targetTypes = base.getPossibleTypes(featInsert.getTarget());
		for(IType type: targetTypes){
			if(type.getType() instanceof EClass){
				EClass realType = (EClass) type.getType();
				EStructuralFeature feature = realType.getEStructuralFeature(featInsert.getTargetFeature());
				
				if(feature  != null){ //static features
					isExistingFeature = true;
				}
				else { //runtime features
					List<ExtendedClass> extensions = base.findExtensions(realType);
					Optional<Attribute> foundDynamicAttribute = //FIXME: take inheritance in account
						extensions
						.stream()
						.flatMap(xtdCls -> xtdCls.getAttributes().stream())
						.filter(field -> field.getFeatureRef().getName().equals(featInsert.getTargetFeature()))
						.findFirst();
					if(foundDynamicAttribute.isPresent()) {
						isExistingFeature = true;
					}
				}
			}
		}
		
		if(!isExistingFeature){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(FEATURE_UNDEFINED,featInsert.getTargetFeature()),
					base.getStartOffset(featInsert),
					base.getEndOffset(featInsert)
					));
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateFeatureRemove(FeatureRemove featRemove) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		/*
		 * Check the assigned feature exist 
		 */
		boolean isExistingFeature = false;
		Set<IType> targetTypes = base.getPossibleTypes(featRemove.getTarget());
		for(IType type: targetTypes){
			if(type.getType() instanceof EClass){
				EClass realType = (EClass) type.getType();
				EStructuralFeature feature = realType.getEStructuralFeature(featRemove.getTargetFeature());
				
				if(feature  != null){ //static features
					isExistingFeature = true;
				}
				else { //runtime features
					List<ExtendedClass> extensions = base.findExtensions(realType);
					Optional<Attribute> foundDynamicAttribute = //FIXME: take inheritance in account
						extensions
						.stream()
						.flatMap(xtdCls -> xtdCls.getAttributes().stream())
						.filter(field -> field.getFeatureRef().getName().equals(featRemove.getTargetFeature()))
						.findFirst();
					if(foundDynamicAttribute.isPresent()) {
						isExistingFeature = true;
					}
				}
			}
		}
		
		if(!isExistingFeature){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(FEATURE_UNDEFINED,featRemove.getTargetFeature()),
					base.getStartOffset(featRemove),
					base.getEndOffset(featRemove)
					));
		}
		
		return msgs;
	}
	
	@Override
	public List<IValidationMessage> validateVariableAssignment(VariableAssignment varAssign) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		/*
		 * Check name
		 */
		Map<String, Set<IType>> declaringScope = base.findScope(varAssign.getName());
		if(declaringScope == null && !varAssign.getName().equals("result")){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(VARIABLE_UNDEFINED,varAssign.getName()),
					base.getStartOffset(varAssign),
					base.getEndOffset(varAssign)
					));
		}
		else if(varAssign.getName().equals("self")){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(SELF_ASSIGN,varAssign.getName()),
					base.getStartOffset(varAssign),
					base.getEndOffset(varAssign)
					));
		}
		else {
			Method op = base.getContainingOperation(varAssign);
			List<EParameter> params = op.getOperationRef().getEParameters();
			Optional<EParameter> matchingParam = 
				params
				.stream()
				.filter(param -> param.getName().equals(varAssign.getName()))
				.findFirst();
			if(matchingParam.isPresent()){
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(PARAM_ASSIGN,varAssign.getName()),
						base.getStartOffset(varAssign),
						base.getEndOffset(varAssign)
						));
			}
		}
		
		return msgs;
	}
	
	public List<IValidationMessage> validateVariableDeclaration(VariableDeclaration varDecl) {
		List<IValidationMessage> msgs = new ArrayList<IValidationMessage>();
		
		/*
		 * Check name
		 */
		if(varDecl.getName().equals("result")){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(RESULT_RESERVED,varDecl.getName()),
					base.getStartOffset(varDecl),
					base.getEndOffset(varDecl)
					));
		}
		else if(varDecl.getName().equals("self")){
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(SELF_RESERVED,varDecl.getName()),
					base.getStartOffset(varDecl),
					base.getEndOffset(varDecl)
					));
		}
		else {
			Map<String, Set<IType>> declaringScope = base.findScope(varDecl.getName());
			if(declaringScope != null){
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(NAME_ALREADY_USED,varDecl.getName()),
						base.getStartOffset(varDecl),
						base.getEndOffset(varDecl)
						));
			}
		}
		
		return msgs;
	}
	
	public List<IValidationMessage> validateForEach(ForEach loop) {
		return new ArrayList<IValidationMessage>();
	}
	
	public List<IValidationMessage> validateIf(If ifStmt) {
		return new ArrayList<IValidationMessage>();
	}
	
	public List<IValidationMessage> validateWhile(While loop) {
		return new ArrayList<IValidationMessage>();
	}
	
	private String getSignature(Method op) {
		EOperation eOp = ((Method)op).getOperationRef();
		
		String paramsToString = 
			eOp
			.getEParameters()
			.stream()
			.map(param -> param.getEType().getName())
			.collect(Collectors.joining(",","(",")"));
		
		return eOp.getName() + paramsToString; 
	}
	
	private boolean isMatching(Method op1, Method op2) {
		EOperation eOp1 = op1.getOperationRef();
		EOperation eOp2 = op2.getOperationRef();
		
		boolean isMatchingName = eOp1.getName().equals(eOp2.getName());
		boolean isMatchingArgsSize = (eOp1.getEParameters().size() == eOp2.getEParameters().size());
		
		if(!(isMatchingName && isMatchingArgsSize)){
			return false;
		}
		
		boolean areParamTypeMatching = true;
		for(int i = 0; i <  eOp1.getEParameters().size(); i++) {
			EParameter param1 = eOp1.getEParameters().get(i);
			EParameter param2 = eOp2.getEParameters().get(i);
			areParamTypeMatching = areParamTypeMatching && (param1.getEType().equals(param2.getEType()));
		}
		return isMatchingName && isMatchingArgsSize && areParamTypeMatching;
	}
}
