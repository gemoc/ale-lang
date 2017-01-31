package interpreter;

import com.google.common.base.Objects;
import implementation.Behaviored;
import implementation.Block;
import implementation.ExpressionStatement;
import implementation.FeatureAssignment;
import implementation.FeatureInsert;
import implementation.FeaturePut;
import implementation.FeatureRemove;
import implementation.ForEach;
import implementation.If;
import implementation.Implementation;
import implementation.Method;
import implementation.Statement;
import implementation.VariableAssignement;
import implementation.VariableDeclaration;
import implementation.While;
import implementation.util.ImplementationSwitch;
import interpreter.DynamicFeatureAccess;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Consumer;
import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.IQueryEvaluationEngine;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class ImplementationEvaluator extends ImplementationSwitch<Object> {
  private IQueryEvaluationEngine aqlEngine;
  
  private DynamicFeatureAccess dynamicFeatureAccess;
  
  private Diagnostic diagnostic;
  
  private Stack<Map<String, Object>> variablesStack;
  
  public ImplementationEvaluator(final IQueryEvaluationEngine aqlEngine, final DynamicFeatureAccess dynamicFeatureAccess) {
    this.aqlEngine = aqlEngine;
    this.dynamicFeatureAccess = dynamicFeatureAccess;
  }
  
  public Object eval(final EObject target, final Behaviored operation, final List<Object> parameters) {
    Stack<Map<String, Object>> _stack = new Stack<Map<String, Object>>();
    this.variablesStack = _stack;
    final Map<String, Object> variables = CollectionLiterals.<String, Object>newHashMap();
    variables.put("self", target);
    variables.put("result", null);
    EOperation _xifexpression = null;
    if ((operation instanceof Implementation)) {
      _xifexpression = ((Implementation)operation).getOperationRef();
    } else {
      EOperation _xifexpression_1 = null;
      if ((operation instanceof Method)) {
        _xifexpression_1 = ((Method)operation).getOperationDef();
      }
      _xifexpression = _xifexpression_1;
    }
    final EOperation opDefinition = _xifexpression;
    EList<EParameter> _eParameters = opDefinition.getEParameters();
    final Procedure2<EParameter, Integer> _function = (EParameter param, Integer index) -> {
      String _name = param.getName();
      Object _get = parameters.get((index).intValue());
      variables.put(_name, _get);
    };
    IterableExtensions.<EParameter>forEach(_eParameters, _function);
    this.variablesStack.push(variables);
    BasicDiagnostic _basicDiagnostic = new BasicDiagnostic();
    this.diagnostic = _basicDiagnostic;
    Block _body = operation.getBody();
    this.doSwitch(_body);
    final Object result = variables.get("result");
    this.variablesStack.pop();
    return result;
  }
  
  @Override
  public Object caseBlock(final Block block) {
    final HashMap<String, Object> newScope = CollectionLiterals.<String, Object>newHashMap();
    this.variablesStack.push(newScope);
    EList<Statement> _statements = block.getStatements();
    final Consumer<Statement> _function = (Statement stmt) -> {
      this.doSwitch(stmt);
    };
    _statements.forEach(_function);
    this.variablesStack.pop();
    return null;
  }
  
  @Override
  public Object caseVariableDeclaration(final VariableDeclaration varDecl) {
    Expression _initialValue = varDecl.getInitialValue();
    final Object value = this.aqlEval(_initialValue);
    Map<String, Object> _peek = this.variablesStack.peek();
    String _name = varDecl.getName();
    _peek.put(_name, value);
    return null;
  }
  
  @Override
  public Object caseVariableAssignement(final VariableAssignement varAssign) {
    String _name = varAssign.getName();
    final Map<String, Object> scope = this.findScope(_name);
    if ((scope != null)) {
      Expression _value = varAssign.getValue();
      final Object value = this.aqlEval(_value);
      String _name_1 = varAssign.getName();
      scope.put(_name_1, value);
    } else {
    }
    return null;
  }
  
  @Override
  public Object caseFeatureAssignment(final FeatureAssignment featAssign) {
    Expression _target = featAssign.getTarget();
    final Object assigned = this.aqlEval(_target);
    Expression _value = featAssign.getValue();
    final Object value = this.aqlEval(_value);
    if ((assigned instanceof EObject)) {
      EClass _eClass = ((EObject)assigned).eClass();
      String _targetFeature = featAssign.getTargetFeature();
      final EStructuralFeature feature = _eClass.getEStructuralFeature(_targetFeature);
      if ((feature != null)) {
        ((EObject)assigned).eSet(feature, value);
      } else {
        String _targetFeature_1 = featAssign.getTargetFeature();
        this.dynamicFeatureAccess.setDynamicFeatureValue(((EObject)assigned), _targetFeature_1, value);
      }
    }
    return null;
  }
  
  @Override
  public Object caseFeatureInsert(final FeatureInsert featInsert) {
    Expression _target = featInsert.getTarget();
    final Object assigned = this.aqlEval(_target);
    Expression _value = featInsert.getValue();
    final Object value = this.aqlEval(_value);
    if ((assigned instanceof EObject)) {
      EClass _eClass = ((EObject)assigned).eClass();
      String _targetFeature = featInsert.getTargetFeature();
      final EStructuralFeature feature = _eClass.getEStructuralFeature(_targetFeature);
      final Object featureValue = ((EObject)assigned).eGet(feature);
      if ((featureValue instanceof EList)) {
        ((EList)featureValue).add(value);
      }
    }
    return null;
  }
  
  @Override
  public Object caseFeatureRemove(final FeatureRemove featRemove) {
    Expression _target = featRemove.getTarget();
    final Object assigned = this.aqlEval(_target);
    Expression _value = featRemove.getValue();
    final Object value = this.aqlEval(_value);
    if ((assigned instanceof EObject)) {
      EClass _eClass = ((EObject)assigned).eClass();
      String _targetFeature = featRemove.getTargetFeature();
      final EStructuralFeature feature = _eClass.getEStructuralFeature(_targetFeature);
      final Object featureValue = ((EObject)assigned).eGet(feature);
      if ((featureValue instanceof EList)) {
        ((EList)featureValue).remove(value);
      }
    }
    return null;
  }
  
  @Override
  public Object caseFeaturePut(final FeaturePut featPut) {
    Expression _target = featPut.getTarget();
    final Object assigned = this.aqlEval(_target);
    Expression _key = featPut.getKey();
    final Object key = this.aqlEval(_key);
    Expression _value = featPut.getValue();
    final Object value = this.aqlEval(_value);
    if ((assigned instanceof EObject)) {
      EClass _eClass = ((EObject)assigned).eClass();
      String _targetFeature = featPut.getTargetFeature();
      final EStructuralFeature feature = _eClass.getEStructuralFeature(_targetFeature);
      final Object featureValue = ((EObject)assigned).eGet(feature);
      if ((featureValue instanceof EMap)) {
        ((EMap)featureValue).put(key, value);
      }
    }
    return null;
  }
  
  @Override
  public Object caseForEach(final ForEach forEach) {
    Expression _collectionExpression = forEach.getCollectionExpression();
    Object _aqlEval = this.aqlEval(_collectionExpression);
    final Collection collection = ((Collection) _aqlEval);
    final HashMap<String, Object> newScope = CollectionLiterals.<String, Object>newHashMap();
    this.variablesStack.push(newScope);
    final Consumer<Object> _function = (Object it) -> {
      String _variable = forEach.getVariable();
      newScope.put(_variable, it);
      Block _body = forEach.getBody();
      this.doSwitch(_body);
    };
    collection.forEach(_function);
    this.variablesStack.pop();
    return null;
  }
  
  @Override
  public Object caseWhile(final While loop) {
    Expression _collectionExpression = loop.getCollectionExpression();
    Object conditionValue = this.aqlEval(_collectionExpression);
    while (((conditionValue instanceof Boolean) && Objects.equal(conditionValue, Boolean.valueOf(true)))) {
      {
        Block _body = loop.getBody();
        this.doSwitch(_body);
        Expression _collectionExpression_1 = loop.getCollectionExpression();
        Object _aqlEval = this.aqlEval(_collectionExpression_1);
        conditionValue = _aqlEval;
      }
    }
    return null;
  }
  
  @Override
  public Object caseIf(final If ifStmt) {
    Expression _condition = ifStmt.getCondition();
    Object _aqlEval = this.aqlEval(_condition);
    final Boolean condition = ((Boolean) _aqlEval);
    if ((condition).booleanValue()) {
      Block _then = ifStmt.getThen();
      this.doSwitch(_then);
    } else {
      Block _else = ifStmt.getElse();
      boolean _tripleNotEquals = (_else != null);
      if (_tripleNotEquals) {
        Block _else_1 = ifStmt.getElse();
        this.doSwitch(_else_1);
      }
    }
    return null;
  }
  
  @Override
  public Object caseExpressionStatement(final ExpressionStatement stmt) {
    Expression _expression = stmt.getExpression();
    return this.aqlEval(_expression);
  }
  
  /**
   * Flatten stack
   */
  private Map<String, Object> getCurrentScope() {
    final HashMap<String, Object> scope = CollectionLiterals.<String, Object>newHashMap();
    final Consumer<Map<String, Object>> _function = (Map<String, Object> frame) -> {
      Set<Map.Entry<String, Object>> _entrySet = frame.entrySet();
      final Consumer<Map.Entry<String, Object>> _function_1 = (Map.Entry<String, Object> entry) -> {
        String _key = entry.getKey();
        Object _value = entry.getValue();
        scope.put(_key, _value);
      };
      _entrySet.forEach(_function_1);
    };
    this.variablesStack.forEach(_function);
    return scope;
  }
  
  private Object aqlEval(final Expression expression) {
    BasicDiagnostic _basicDiagnostic = new BasicDiagnostic();
    final IQueryBuilderEngine.AstResult dummyAstResult = new IQueryBuilderEngine.AstResult(expression, new Function0<Map<Object, Integer>>() {
      public Map<Object, Integer> apply() {
        return null;
      }
    }.apply(), new Function0<Map<Object, Integer>>() {
      public Map<Object, Integer> apply() {
        return null;
      }
    }.apply(), Collections.<org.eclipse.acceleo.query.ast.Error>unmodifiableList(CollectionLiterals.<org.eclipse.acceleo.query.ast.Error>newArrayList()), _basicDiagnostic);
    Map<String, Object> _currentScope = this.getCurrentScope();
    EvaluationResult _eval = this.aqlEngine.eval(dummyAstResult, _currentScope);
    return _eval.getResult();
  }
  
  private Map<String, Object> findScope(final String variable) {
    List<Map<String, Object>> _reverseView = ListExtensions.<Map<String, Object>>reverseView(this.variablesStack);
    final Function1<Map<String, Object>, Boolean> _function = (Map<String, Object> it) -> {
      Set<String> _keySet = it.keySet();
      return Boolean.valueOf(_keySet.contains(variable));
    };
    return IterableExtensions.<Map<String, Object>>findFirst(_reverseView, _function);
  }
}
