package org.eclipse.emf.ecoretools.ale.core.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.parser.AstValidator;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecoretools.ale.core.interpreter.EvalEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.ExpressionStatement;
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
import org.eclipse.emf.ecoretools.ale.implementation.util.ImplementationSwitch;

import com.google.common.collect.Sets;

public class BaseValidator extends ImplementationSwitch<Object> {

	List<IValidationMessage> msgs;
	
	List<ParseResult<ModelUnit>> allModels;
	ParseResult<ModelUnit> currentModel;
	Stack<Map<String, Set<IType>>> variableTypesStack;
	
	Map<Expression,IValidationResult> validations;
	
	AstValidator expValidator;
	IQueryEnvironment qryEnv;
	List<IValidator> validators;
	
	public BaseValidator(IQueryEnvironment qryEnv, List<IValidator> validators) {
		this.qryEnv = qryEnv;
		this.expValidator = new AstValidator(new ValidationServices(qryEnv));
		
		this.validators = new ArrayList<IValidator>();
		validators.forEach(validator -> {
			this.validators.add(validator);
			validator.setBase(this);
		});
	}
	
	public List<IValidationMessage> validate(List<ParseResult<ModelUnit>> roots) {
		
		this.msgs = new ArrayList<IValidationMessage>();
		this.validations = new HashMap<Expression,IValidationResult>();
		this.allModels = roots;
		
		List<ModelUnit> allUnits =
			roots
			.stream()
			.map(p->p.getRoot())
			.filter(u->u != null)
			.collect(Collectors.toList());
		
		new EvalEnvironment(qryEnv, allUnits, null); //add runtime services to qryEnv

		validators.stream().forEach(validator -> msgs.addAll(validator.validateModelBehavior(allUnits)));
		
		roots.forEach(root -> {
			this.currentModel = root;
			this.variableTypesStack = new Stack<Map<String, Set<IType>>>();
			doSwitch(currentModel.getRoot());
		});
		
		return msgs;
	}
	
	@Override
	public Object caseModelUnit(ModelUnit root) {
		
		validators.stream().forEach(validator -> msgs.addAll(validator.validateModelUnit(root)));
		
		for(ExtendedClass xtdClass : root.getClassExtensions()){
			doSwitch(xtdClass);
		}
		
		for(RuntimeClass xtdClass : root.getClassDefinitions()){
			doSwitch(xtdClass);
		}
		
		return null;
	}
	
	@Override
	public Object caseExtendedClass(ExtendedClass xtdClass) {
		
		Map<String,Set<IType>> classScope = new HashMap<String,Set<IType>>();
		for(Attribute attrib : xtdClass.getAttributes()) {
			if(attrib.getInitialValue() != null) {
				validateAndStore(attrib.getInitialValue(),new HashMap<String,Set<IType>>());
			}
		}
		
		Set<IType> selfTypeSet = new HashSet<IType>();
		EClassifierType selfType = new EClassifierType(qryEnv, xtdClass.getBaseClass());
		selfTypeSet.add(selfType);
		classScope.put("self", selfTypeSet);
		
		validators.stream().forEach(validator -> msgs.addAll(validator.validateExtendedClass(xtdClass)));
		
		variableTypesStack.push(classScope);
		for (Method operation : xtdClass.getMethods()) {
			doSwitch(operation);
		}
		variableTypesStack.pop();
		
		return null;
	}
	
	@Override
	public Object caseRuntimeClass(RuntimeClass runtimeCls) {
		
		Map<String,Set<IType>> classScope = new HashMap<String,Set<IType>>();
		for(Attribute attrib : runtimeCls.getAttributes()) {
			if(attrib.getInitialValue() != null) {
				validateAndStore(attrib.getInitialValue(),new HashMap<String,Set<IType>>());
			}
		}
		
		String pkgName = ((ModelUnit)runtimeCls.eContainer()).getName();
		if(pkgName.lastIndexOf(".") != -1 && pkgName.lastIndexOf(".") != pkgName.length()-1){ //FIXME: AQL doesn't support qualified name
			pkgName = pkgName.substring(pkgName.lastIndexOf(".")+1);
		}
		Collection<EClassifier> registered = qryEnv.getEPackageProvider().getTypes(pkgName, runtimeCls.getName());
		if(!registered.isEmpty()) {
			EClassifier runtimeEClass = registered.iterator().next();
			Set<IType> selfTypeSet = new HashSet<IType>();
			EClassifierType selfType = new EClassifierType(qryEnv, runtimeEClass);
			selfTypeSet.add(selfType);
			classScope.put("self", selfTypeSet);
		}
		
		validators.stream().forEach(validator -> msgs.addAll(validator.validateRuntimeClass(runtimeCls)));
		
		variableTypesStack.push(classScope);
		for (Method operation : runtimeCls.getMethods()) {
			doSwitch(operation);
		}
		variableTypesStack.pop();
		
		return null;
	}
	
	@Override
	public Object caseMethod(Method mtd) {
		Map<String,Set<IType>> methodScope = new HashMap<String,Set<IType>>(variableTypesStack.peek());
		
		for (EParameter param : mtd.getOperationRef().getEParameters()) {
			Set<IType> previousDeclaration = methodScope.get(param.getName());
			if(previousDeclaration == null) {
				EClassifierType type = new EClassifierType(qryEnv, param.getEType());
				methodScope.put(param.getName(), Sets.newHashSet(type));
			}
		}
		
		validators.stream().forEach(validator -> msgs.addAll(validator.validateMethod(mtd)));
		
		variableTypesStack.push(methodScope);
		doSwitch(mtd.getBody());
		variableTypesStack.pop();
		
		return null;
	}
	
	@Override
	public Object caseBlock(Block block) {
		Map<String,Set<IType>> blockScope = new HashMap<String,Set<IType>>(variableTypesStack.peek());
		
		variableTypesStack.push(blockScope);
		for(Statement stmt: block.getStatements()){
			doSwitch(stmt);
		}
		variableTypesStack.pop();
		
		return null;
	}
	
	@Override
	public Object caseExpressionStatement(ExpressionStatement expStmt) {
		validateAndStore(expStmt.getExpression(),getCurrentScope());
		return null;
	}
	
	@Override
	public Object caseFeatureAssignment(FeatureAssignment featAssign) {
		Map<String, Set<IType>> scope = getCurrentScope();
		validateAndStore(featAssign.getTarget(),scope);
		validateAndStore(featAssign.getValue(),scope);
		
		validators.stream().forEach(validator -> msgs.addAll(validator.validateFeatureAssignment(featAssign)));
		
		return null;
	}
	
	@Override
	public Object caseFeatureInsert(FeatureInsert featInsert) {
		Map<String, Set<IType>> scope = getCurrentScope();
		validateAndStore(featInsert.getTarget(),scope);
		validateAndStore(featInsert.getValue(),scope);
		
		validators.stream().forEach(validator -> msgs.addAll(validator.validateFeatureInsert(featInsert)));
		
		return null;
	}
	
	@Override
	public Object caseFeatureRemove(FeatureRemove featRemove) {
		Map<String, Set<IType>> scope = getCurrentScope();
		validateAndStore(featRemove.getTarget(),scope);
		validateAndStore(featRemove.getValue(),scope);
		
		validators.stream().forEach(validator -> msgs.addAll(validator.validateFeatureRemove(featRemove)));
		
		return null;
	}
	
	@Override
	public Object caseForEach(ForEach loop) {
		
		Map<String,Set<IType>> loopScope = new HashMap<String,Set<IType>>(variableTypesStack.peek());
		
		validateAndStore(loop.getCollectionExpression(),getCurrentScope());
		loopScope.put(loop.getVariable(), getPossibleTypes(loop.getCollectionExpression()));
		
		validators.stream().forEach(validator -> msgs.addAll(validator.validateForEach(loop)));
		
		variableTypesStack.push(loopScope);
		doSwitch(loop.getBody());
		variableTypesStack.pop();
		
		return null;
	}
	
	@Override
	public Object caseIf(If ifStmt) {
		
		validateAndStore(ifStmt.getCondition(),getCurrentScope());
		
		validators.stream().forEach(validator -> msgs.addAll(validator.validateIf(ifStmt)));
		
		/*
		 * Then
		 */
		Map<String,Set<IType>> thenScope = new HashMap<String,Set<IType>>(variableTypesStack.peek());
		IValidationResult validRes = validations.get(ifStmt.getCondition());
		if(validRes != null) {
			Map<String, Set<IType>> vartypes = validRes.getInferredVariableTypes(ifStmt.getCondition(), true);
			thenScope.putAll(vartypes);
		}
		variableTypesStack.push(thenScope);
		doSwitch(ifStmt.getThen());
		variableTypesStack.pop();
		
		/*
		 * Else
		 */
		if(ifStmt.getElse() != null){
			Map<String,Set<IType>> elseScope = new HashMap<String,Set<IType>>(variableTypesStack.peek());
			if(validRes != null) {
				Map<String, Set<IType>> vartypes = validRes.getInferredVariableTypes(ifStmt.getCondition(), false);
				elseScope.putAll(vartypes);
			}
			variableTypesStack.push(elseScope);
			doSwitch(ifStmt.getElse());
			variableTypesStack.pop();
		}
		
		return null;
	}
	
	@Override
	public Object caseVariableAssignment(VariableAssignment varAssign) {
		validateAndStore(varAssign.getValue(),getCurrentScope());
		
		validators.stream().forEach(validator -> msgs.addAll(validator.validateVariableAssignment(varAssign)));
		
		return null;
	}
	
	@Override
	public Object caseVariableDeclaration(VariableDeclaration varDecl) {
		if(varDecl.getInitialValue() != null) {
			validateAndStore(varDecl.getInitialValue(),getCurrentScope());
		}
		
		validators.stream().forEach(validator -> msgs.addAll(validator.validateVariableDeclaration(varDecl)));
		
		Map<String, Set<IType>> lastScope = variableTypesStack.peek();
		if(varDecl.getInitialValue() != null){
			lastScope.put(varDecl.getName(), getPossibleTypes(varDecl.getInitialValue()));
		}
		else {
			EClassifierType declaredType = new EClassifierType(qryEnv, varDecl.getType());
			lastScope.put(varDecl.getName(), Sets.newHashSet(declaredType));
		}
		
		return null;
	}
	
	@Override
	public Object caseWhile(While loop) {
		validateAndStore(loop.getCondition(),getCurrentScope());
		
		validators.stream().forEach(validator -> msgs.addAll(validator.validateWhile(loop)));
		
		Map<String,Set<IType>> loopScope = new HashMap<String,Set<IType>>(variableTypesStack.peek());
		IValidationResult validRes = validations.get(loop.getCondition());
		if(validRes != null) {
			Map<String, Set<IType>> vartypes = validRes.getInferredVariableTypes(loop.getCondition(), true);
			loopScope.putAll(vartypes);
		}
		variableTypesStack.push(loopScope);
		doSwitch(loop.getBody());
		variableTypesStack.pop();
		
		return null;
	}

	public Map<String, Set<IType>> getCurrentScope() {
		return variableTypesStack.peek();
	}
	
	/*
	 * Use embedded validator to check Expressions
	 */
	private IValidationResult validateExpression(Expression exp, Map<String, Set<IType>> variableTypes) {
		//Make an AstResult with positions from Implementation parser
		AstResult fakeAst = new AstResult(
				exp,
				currentModel.getStartPositions(),
				currentModel.getEndPositions(),
				new ArrayList(),
				new BasicDiagnostic()
				);
		return expValidator.validate(variableTypes, fakeAst);
	}
	
	public int getStartOffset(Object obj) {
		return currentModel.getStartPositions().get(obj);
	}
	
	public int getEndOffset(Object obj) {
		return currentModel.getEndPositions().get(obj);
	}
	
	private void validateAndStore(Expression exp, Map<String, Set<IType>> context) {
		IValidationResult expValidation = validateExpression(exp, context);
		msgs.addAll(expValidation.getMessages());
		validations.put(exp,expValidation);
	}
	
	public Set<IType> getPossibleTypes(Expression exp) {
		IValidationResult validRes = validations.get(exp);
		
		if(validRes != null) {
			return validRes.getPossibleTypes(exp);
		}
		
		return new HashSet<IType>();
	}
	
	public List<ExtendedClass> findExtensions(EClass realType) {
		return 
			allModels
			.stream()
			.flatMap(m -> m.getRoot().getClassExtensions().stream())
			.filter(xtdCls -> xtdCls.getBaseClass().isSuperTypeOf(realType))
			.collect(Collectors.toList());
	}
	
	public IQueryEnvironment getQryEnv() {
		return qryEnv;
	}
	
	public Method getContainingOperation(VariableAssignment varAssign) {
		EObject parent = varAssign.eContainer();
		while(parent != null && !(parent instanceof Method)){
			parent = parent.eContainer();
		}
		return (Method)parent;
	}
}
