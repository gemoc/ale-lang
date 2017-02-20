package lang.core.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.parser.AstValidator;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.acceleo.query.runtime.impl.ValidationMessage;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.validation.type.ClassType;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.ICollectionType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;

import implementation.Behaviored;
import implementation.Block;
import implementation.ExpressionStatement;
import implementation.ExtendedClass;
import implementation.FeatureAssignment;
import implementation.FeatureInsert;
import implementation.FeatureRemove;
import implementation.ForEach;
import implementation.If;
import implementation.Implementation;
import implementation.Method;
import implementation.ModelBehavior;
import implementation.Statement;
import implementation.VariableAssignment;
import implementation.VariableDeclaration;
import implementation.While;
import implementation.util.ImplementationSwitch;
import lang.core.parser.visitor.ParseResult;

public class ImplementationValidator extends ImplementationSwitch<Object> {
	
	public static final String INCOMPATIBLE_TYPE = "Expected %s but was %s";
	public static final String NAME_ALREADY_USED = "The name %s is already used";
	public static final String SELF_RESERVED = "'self' is a reserved name";
	public static final String RESULT_RESERVED = "'result' is a reserved name";
	public static final String COLLECTION_TYPE = "Expected Collection but was %s";
	public static final String BOOLEAN_TYPE = "Expected Boolean but was %s";
	public static final String VARIABLE_UNDEFINED = "The variable %s is not defined";
	
	ParseResult<ModelBehavior> model;
	List<IValidationMessage> msgs;
	Stack<Map<String, Set<IType>>> variableTypesStack;
	
	AstValidator expValidator;
	IQueryEnvironment qryEnv;
	
	public ImplementationValidator(IQueryEnvironment qryEnv) {
		this.qryEnv = qryEnv;
		this.expValidator = new AstValidator(new ValidationServices(qryEnv));
	}

	@Override
	public Object caseExtendedClass(ExtendedClass xtdClass) {
		
		Map<String,Set<IType>> attributeTypes = new HashMap<String,Set<IType>>();
		for(VariableDeclaration attrib : xtdClass.getAttributes()) {
			/*
			 * Check name
			 */
			if(attrib.getName().equals("result")){
				int startPostion = model.getStartPositions().get(attrib);
				int endPosition = model.getEndPositions().get(attrib);
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(RESULT_RESERVED,attrib.getName()),
						startPostion,
						endPosition
						));
			}
			else if(attrib.getName().equals("self")){
				int startPostion = model.getStartPositions().get(attrib);
				int endPosition = model.getEndPositions().get(attrib);
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(SELF_RESERVED,attrib.getName()),
						startPostion,
						endPosition
						));
			}
			
			Set<IType> possibleTypes = attributeTypes.get(attrib.getName());
			if(possibleTypes != null) {
				int startPostion = model.getStartPositions().get(attrib);
				int endPosition = model.getEndPositions().get(attrib);
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(NAME_ALREADY_USED,attrib.getName()),
						startPostion,
						endPosition
						));
			}
			else {
				EClassifierType declaredType = new EClassifierType(qryEnv, attrib.getType());
				Set<IType> typeSet = new HashSet<IType>();
				typeSet.add(declaredType);
				attributeTypes.put(attrib.getName(), typeSet);
			}
			
			if(attrib.getInitialValue() != null){
				/*
				 * Check initial expression
				 */
				IValidationResult expValidation = validateExpression(attrib.getInitialValue(),new HashMap<String,Set<IType>>());
				msgs.addAll(expValidation.getMessages());
				
				/*
				 * Check assignment type
				 */
				Set<IType> inferredTypes = expValidation.getPossibleTypes(attrib.getInitialValue());
				EClassifierType declaredType = new EClassifierType(qryEnv, attrib.getType());
				Optional<IType> existResult = inferredTypes.stream().filter(type -> declaredType.isAssignableFrom(type)).findAny();
				if(!existResult.isPresent()){
					String types = 
						inferredTypes
						.stream()
						.map(type -> type.toString())
						.collect(Collectors.joining(",","[","]"));
					int startPostion = model.getStartPositions().get(attrib);
					int endPosition = model.getEndPositions().get(attrib);
					msgs.add(new ValidationMessage(
							ValidationMessageLevel.ERROR,
							String.format(INCOMPATIBLE_TYPE,attrib.getType().getName(),types),
							startPostion,
							endPosition
							));
				}
			}
		}
		
		Set<IType> selfTypeSet = new HashSet<IType>();
		EClassifierType selfType = new EClassifierType(qryEnv, xtdClass.getBaseClass());
		selfTypeSet.add(selfType);
		attributeTypes.put("self", selfTypeSet);
		xtdClass
			.getBaseClass()
			.getEAllAttributes()
			.stream()
			.forEach(att -> {
				Set<IType> attTypeSet = new HashSet<IType>();
				EClassifierType attType = new EClassifierType(qryEnv, att.getEType());
				attTypeSet.add(attType);
				attributeTypes.put(att.getName(), attTypeSet);
				}
			);
		xtdClass
			.getBaseClass()
			.getEAllReferences()
			.stream()
			.forEach(ref -> {
				Set<IType> refTypeSet = new HashSet<IType>();
				EClassifierType attType = new EClassifierType(qryEnv, ref.getEType());
				refTypeSet.add(attType);
				attributeTypes.put(ref.getName(), refTypeSet);
				}
			);
		
		variableTypesStack.push(attributeTypes);
		for (Behaviored operation : xtdClass.getMethods()) {
			doSwitch(operation);
		}
		variableTypesStack.pop();
		
		return null;
	}
	
	@Override
	public Object caseMethod(Method mtd) {
		validateBehaviored(mtd,mtd.getOperationDef().getEParameters());
		return null;
	}
	
	@Override
	public Object caseImplementation(Implementation impl) {
		validateBehaviored(impl,impl.getOperationRef().getEParameters());
		return null;
	}
	
	private void validateBehaviored(Behaviored op, List<EParameter> params){
		Map<String,Set<IType>> parameterTypes = new HashMap<String,Set<IType>>();
		
		for (EParameter param : params) {
			
			if(param.getName().equals("result")){
				int startPostion = model.getStartPositions().get(op);
				int endPosition = model.getEndPositions().get(op);
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(RESULT_RESERVED,param.getName()),
						startPostion,
						endPosition
						));
			}
			else if(param.getName().equals("self")){
				int startPostion = model.getStartPositions().get(op);
				int endPosition = model.getEndPositions().get(op);
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(SELF_RESERVED,param.getName()),
						startPostion,
						endPosition
						));
			}
			
			Set<IType> possibleTypes = parameterTypes.get(param.getName());
			if(possibleTypes != null) {
				int startPostion = model.getStartPositions().get(op); //FIXME: need parameter bounds
				int endPosition = model.getEndPositions().get(op);
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(NAME_ALREADY_USED,param.getName()),
						startPostion,
						endPosition
						));
			}
			else {
				possibleTypes = new HashSet<IType>();
				EClassifierType type = new EClassifierType(qryEnv, param.getEType());
				possibleTypes.add(type);
				parameterTypes.put(param.getName(), possibleTypes);
			}
		}
		
		variableTypesStack.push(parameterTypes);
		doSwitch(op.getBody());
		variableTypesStack.pop();
	}
	
	@Override
	public Object caseBlock(Block block) {
		Map<String,Set<IType>> variableTypes = new HashMap<String,Set<IType>>();
		
		variableTypesStack.push(variableTypes);
		for(Statement stmt: block.getStatements()){
			doSwitch(stmt);
		}
		variableTypesStack.pop();
		
		return null;
	}
	
	@Override
	public Object caseExpressionStatement(ExpressionStatement expStmt) {
		IValidationResult expValidation = validateExpression(expStmt.getExpression(),getCurrentScope());
		msgs.addAll(expValidation.getMessages());
		return null;
	}
	
	@Override
	public Object caseFeatureAssignment(FeatureAssignment featAssign) {
		/*
		 * Check target expression
		 */
		IValidationResult expValidation = validateExpression(featAssign.getTarget(),getCurrentScope());
		msgs.addAll(expValidation.getMessages());
		
		/*
		 * Collect feature types
		 */
		Set<IType> targetTypes = expValidation.getPossibleTypes(featAssign.getTarget());
		Set<IType> featureTypes = new HashSet<IType>();
		for(IType type: targetTypes){
			if(type.getType() instanceof EClass){
				EClass realType = (EClass) type.getType();
				EStructuralFeature feature = realType.getEStructuralFeature(featAssign.getTargetFeature());
				if(feature  != null){
					EClassifierType featureType = new EClassifierType(qryEnv, feature.getEType());
					featureTypes.add(featureType);
				}
				else {
					//TODO: check dynamic attribute declaration
				}
			}
		}
		
		/*
		 * Check assigned expression
		 */
		expValidation = validateExpression(featAssign.getValue(),getCurrentScope());
		msgs.addAll(expValidation.getMessages());
		
		/*
		 * Check assignment type
		 */
		Set<IType> inferredTypes = expValidation.getPossibleTypes(featAssign.getValue());
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
					.map(type -> type.toString())
					.collect(Collectors.joining(",","[","]"));
			
			int startPostion = model.getStartPositions().get(featAssign);
			int endPosition = model.getEndPositions().get(featAssign);
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(INCOMPATIBLE_TYPE,featureToString,inferredToString),
					startPostion,
					endPosition
					));
		}
		return null;
	}
	
	@Override
	public Object caseFeatureInsert(FeatureInsert featInsert) {
		/*
		 * Check target expression
		 */
		IValidationResult expValidation = validateExpression(featInsert.getTarget(),getCurrentScope());
		msgs.addAll(expValidation.getMessages());
		
		/*
		 * Collect feature types
		 */
		Set<IType> targetTypes = expValidation.getPossibleTypes(featInsert.getTarget());
		Set<IType> featureTypes = new HashSet<IType>();
		for(IType type: targetTypes){
			if(type.getType() instanceof EClass){
				EClass realType = (EClass) type.getType();
				EStructuralFeature feature = realType.getEStructuralFeature(featInsert.getTargetFeature());
				EClassifierType featureType = new EClassifierType(qryEnv, feature.getEType());
				featureTypes.add(featureType);
			}
		}
		
		/*
		 * Check assigned expression
		 */
		expValidation = validateExpression(featInsert.getValue(),getCurrentScope());
		msgs.addAll(expValidation.getMessages());
		
		/*
		 * Check assignment type
		 */
		Set<IType> inferredTypes = expValidation.getPossibleTypes(featInsert.getValue());
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
					.map(type -> type.toString())
					.collect(Collectors.joining(",","[","]"));
			
			int startPostion = model.getStartPositions().get(featInsert);
			int endPosition = model.getEndPositions().get(featInsert);
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(INCOMPATIBLE_TYPE,featureToString,inferredToString),
					startPostion,
					endPosition
					));
		}
		
		return null;
	}
	
	@Override
	public Object caseFeatureRemove(FeatureRemove featRemove) {
		/*
		 * Check target expression
		 */
		IValidationResult expValidation = validateExpression(featRemove.getTarget(),getCurrentScope());
		msgs.addAll(expValidation.getMessages());
		
		/*
		 * Collect feature types
		 */
		Set<IType> targetTypes = expValidation.getPossibleTypes(featRemove.getTarget());
		Set<IType> featureTypes = new HashSet<IType>();
		for(IType type: targetTypes){
			if(type.getType() instanceof EClass){
				EClass realType = (EClass) type.getType();
				EStructuralFeature feature = realType.getEStructuralFeature(featRemove.getTargetFeature());
				EClassifierType featureType = new EClassifierType(qryEnv, feature.getEType());
				featureTypes.add(featureType);
			}
		}
		
		/*
		 * Check assigned expression
		 */
		expValidation = validateExpression(featRemove.getValue(),getCurrentScope());
		msgs.addAll(expValidation.getMessages());
		
		/*
		 * Check assignment type
		 */
		Set<IType> inferredTypes = expValidation.getPossibleTypes(featRemove.getValue());
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
					.map(type -> type.toString())
					.collect(Collectors.joining(",","[","]"));
			
			int startPostion = model.getStartPositions().get(featRemove);
			int endPosition = model.getEndPositions().get(featRemove);
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(INCOMPATIBLE_TYPE,featureToString,inferredToString),
					startPostion,
					endPosition
					));
		}
		return null;
	}
	
	@Override
	public Object caseForEach(ForEach loop) {
		
		Map<String, Set<IType>> currentScope = getCurrentScope();
		Map<String,Set<IType>> variableTypes = new HashMap<String,Set<IType>>();
		
		/*
		 * Check expression
		 */
		IValidationResult expValidation = validateExpression(loop.getCollectionExpression(),currentScope);
		msgs.addAll(expValidation.getMessages());
		
		variableTypes.put(loop.getVariable(), expValidation.getPossibleTypes(loop.getCollectionExpression()));
		
		/*
		 * Check expression is collection
		 */
		Optional<IType> existResult = 
			expValidation
			.getPossibleTypes(loop.getCollectionExpression())
			.stream()
			.filter(type -> type instanceof ICollectionType)
			.findAny();
		if(!existResult.isPresent()){
			String inferredToString = 
					expValidation
					.getPossibleTypes(loop.getCollectionExpression())
					.stream()
					.map(type -> type.toString())
					.collect(Collectors.joining(",","[","]"));
			int startPostion = model.getStartPositions().get(loop.getCollectionExpression());
			int endPosition = model.getEndPositions().get(loop.getCollectionExpression());
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(COLLECTION_TYPE,inferredToString),
					startPostion,
					endPosition
					));
		}
		
		variableTypesStack.push(variableTypes);
		doSwitch(loop.getBody());
		variableTypesStack.pop();
		
		return null;
	}
	
	@Override
	public Object caseIf(If ifStmt) {
		Map<String, Set<IType>> currentScope = getCurrentScope();
		
		/*
		 * Check expression
		 */
		IValidationResult expValidation = validateExpression(ifStmt.getCondition(),currentScope);
		msgs.addAll(expValidation.getMessages());
		
		/*
		 * Check expression is boolean
		 */
		Set<IType> selectorTypes = expValidation.getPossibleTypes(ifStmt.getCondition());
		boolean onlyNotBoolean = true;
		final IType booleanObjectType = new ClassType(qryEnv, Boolean.class);
		final IType booleanType = new ClassType(qryEnv, boolean.class);
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
			int startPostion = model.getStartPositions().get(ifStmt.getCondition());
			int endPosition = model.getEndPositions().get(ifStmt.getCondition());
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(BOOLEAN_TYPE,inferredToString),
					startPostion,
					endPosition
					));
		}
		
		doSwitch(ifStmt.getThen());
		if(ifStmt.getElse() != null){
			doSwitch(ifStmt.getElse());
		}
		
		return null;
	}
	
	@Override
	public Object caseModelBehavior(ModelBehavior root) {
		for(ExtendedClass xtdClass : root.getClassExtensions()){
			doSwitch(xtdClass);
		}
		return null;
	}
	
	@Override
	public Object caseVariableAssignment(VariableAssignment varAssign) {
		/*
		 * Check expression
		 */
		IValidationResult expValidation = validateExpression(varAssign.getValue(),getCurrentScope());
		msgs.addAll(expValidation.getMessages());
		
		/*
		 * Check name
		 */
		Map<String, Set<IType>> declaringScope = findScope(varAssign.getName());
		if(declaringScope == null){
			int startPostion = model.getStartPositions().get(varAssign);
			int endPosition = model.getEndPositions().get(varAssign);
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(VARIABLE_UNDEFINED,varAssign.getName()),
					startPostion,
					endPosition
					));
		}
		else{
			Set<IType> currentTypes = declaringScope.get(varAssign.getName());
			currentTypes.addAll(expValidation.getPossibleTypes(varAssign.getValue()));
		}
		
		/*
		 * Check assignment type
		 */
		//FIXME: look for declaration
		
		return null;
	}
	
	@Override
	public Object caseVariableDeclaration(VariableDeclaration varDecl) {
		/*
		 * Check expression
		 */
		IValidationResult expValidation = null;
		if(varDecl.getInitialValue() != null) {
			expValidation = validateExpression(varDecl.getInitialValue(),getCurrentScope());
			msgs.addAll(expValidation.getMessages());
		}
		
		/*
		 * Check name
		 */
		if(varDecl.getName().equals("result")){
			int startPostion = model.getStartPositions().get(varDecl);
			int endPosition = model.getEndPositions().get(varDecl);
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(RESULT_RESERVED,varDecl.getName()),
					startPostion,
					endPosition
					));
		}
		else if(varDecl.getName().equals("self")){
			int startPostion = model.getStartPositions().get(varDecl);
			int endPosition = model.getEndPositions().get(varDecl);
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(SELF_RESERVED,varDecl.getName()),
					startPostion,
					endPosition
					));
		}
		
		Map<String, Set<IType>> lastScope = variableTypesStack.peek();
		if(lastScope.get(varDecl.getName()) != null){
			int startPostion = model.getStartPositions().get(varDecl);
			int endPosition = model.getEndPositions().get(varDecl);
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(NAME_ALREADY_USED,varDecl.getName()),
					startPostion,
					endPosition
					));
		}
		else if(expValidation != null){
			lastScope.put(varDecl.getName(), expValidation.getPossibleTypes(varDecl.getInitialValue()));
		}
		else {
			EClassifierType declaredType = new EClassifierType(qryEnv, varDecl.getType());
			Set<IType> typeSet = new HashSet<IType>();
			typeSet.add(declaredType);
			lastScope.put(varDecl.getName(), typeSet);
		}
		
		/*
		 * Check assignment type
		 */
		EClassifierType varType = new EClassifierType(qryEnv, varDecl.getType());
		Set<IType> inferredTypes = lastScope.get(varDecl.getName());
		Optional<IType> existResult = inferredTypes.stream().filter(t -> varType.isAssignableFrom(t)).findAny();
		if(!existResult.isPresent()){
			String inferredToString = 
					inferredTypes
					.stream()
					.map(type -> type.toString())
					.collect(Collectors.joining(",","[","]"));
			
			int startPostion = model.getStartPositions().get(varDecl);
			int endPosition = model.getEndPositions().get(varDecl);
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(INCOMPATIBLE_TYPE,varDecl.getType().getName(),inferredToString),
					startPostion,
					endPosition
					));
		}
		
		return null;
	}
	
	@Override
	public Object caseWhile(While loop) {
		Map<String, Set<IType>> currentScope = getCurrentScope();
		
		/*
		 * Check expression
		 */
		IValidationResult expValidation = validateExpression(loop.getCondition(),currentScope);
		msgs.addAll(expValidation.getMessages());
		
		/*
		 * Check expression is boolean
		 */
		Set<IType> selectorTypes = expValidation.getPossibleTypes(loop.getCondition());
		boolean onlyNotBoolean = true;
		final IType booleanObjectType = new ClassType(qryEnv, Boolean.class);
		final IType booleanType = new ClassType(qryEnv, boolean.class);
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
			int startPostion = model.getStartPositions().get(loop.getCondition());
			int endPosition = model.getEndPositions().get(loop.getCondition());
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(BOOLEAN_TYPE,inferredToString),
					startPostion,
					endPosition
					));
		}
		
		doSwitch(loop.getBody());
		return null;
	}
	
	public void validate(ParseResult<ModelBehavior> root) {
		this.model = root;
		this.msgs = new ArrayList<IValidationMessage>();
		this.variableTypesStack = new Stack<Map<String, Set<IType>>>();
		doSwitch(model.getRoot());
	}
	
	public List<IValidationMessage> getMessages() {
		return msgs;
	}
	
	/*
	 * Use embedded validator to check Expressions
	 */
	private IValidationResult validateExpression(Expression exp, Map<String, Set<IType>> variableTypes) {
		//Make an AstResult with positions from Implementation parser
		AstResult fakeAst = new AstResult(
				exp,
				model.getStartPositions(),
				model.getEndPositions(),
				new ArrayList(),
				new BasicDiagnostic()
				);
		return expValidator.validate(variableTypes, fakeAst);
	}
	
	/*
	 * Flatten stack
	 */
	private Map<String, Set<IType>> getCurrentScope() {
		Map<String, Set<IType>> scope = new HashMap<String, Set<IType>>();
		variableTypesStack
		.stream()
		.flatMap(scp -> scp.entrySet().stream())
		.forEachOrdered(entry -> scope.put(entry.getKey(), entry.getValue()));
		
		return scope;
	}
	
	private Map<String, Set<IType>> findScope(String variable) {
		for(int i = variableTypesStack.size() - 1; i >= 0; i--) {
			Map<String, Set<IType>> scope = variableTypesStack.get(i);
			if(scope.keySet().contains(variable)){
				return scope;
			}
		}
		return null;
	}
}
