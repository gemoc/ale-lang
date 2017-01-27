package interpreter;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import drawing.Window;
import implementation.Behaviored;
import implementation.Block;
import implementation.Expression;
import implementation.ExtendedClass;
import implementation.FeatureAssignment;
import implementation.FeatureInsert;
import implementation.FeaturePut;
import implementation.FeatureRemove;
import implementation.ForEach;
import implementation.If;
import implementation.Implementation;
import implementation.ImplementationPackage;
import implementation.Root;
import implementation.Statement;
import implementation.VariableAssignement;
import implementation.VariableDeclaration;
import implementation.While;
import interpreter.DynamicFeatureAccess;
import interpreter.DynamicFeatureAccessService;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.runtime.impl.QueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import parser.AstBuilder;
import services.EvalBodyService;
import services.FactoryService;
import services.LogService;
import services.MyService;
import services.TrigoServices;
import vmlogo.Context;
import vmlogo.Turtle;
import vmlogo.VmlogoPackage;

@SuppressWarnings("all")
public class Interpreter {
  private IQueryEnvironment qryEnv;
  
  private Root implemModel;
  
  private Set<EPackage> metamodel;
  
  private DynamicFeatureAccess dynamicFeatureAccess;
  
  public static void main(final String[] args) {
    try {
      final String metamodelPath = "/home/fcoulon/git/fluffy-umbrella/k3.sample.maven.logo.model/model/ASMLogo.ecore";
      final String implementionPath = "data/LogoProgram.implem";
      final String modelPath = "model/LogoProgram.xmi";
      final String contextPath = "data/My.vmlogo";
      final String mainExpression = "self.eval(context)";
      final ResourceSetImpl rs = new ResourceSetImpl();
      Resource _loadModel = Interpreter.loadModel(metamodelPath, rs);
      TreeIterator<EObject> _allContents = _loadModel.getAllContents();
      Iterator<EPackage> _filter = Iterators.<EPackage>filter(_allContents, EPackage.class);
      final Set<EPackage> metamodel = IteratorExtensions.<EPackage>toSet(_filter);
      final ImplementationPackage implemPkg = ImplementationPackage.eINSTANCE;
      final VmlogoPackage vmPkg = VmlogoPackage.eINSTANCE;
      metamodel.add(vmPkg);
      Path _get = Paths.get(implementionPath);
      byte[] _readAllBytes = Files.readAllBytes(_get);
      final String fileContent = new String(_readAllBytes);
      AstBuilder _astBuilder = new AstBuilder(metamodel);
      final Root implemModel = _astBuilder.parse(fileContent);
      final Interpreter interpreter = new Interpreter(metamodel, implemModel);
      interpreter.registerImplem();
      interpreter.qryEnv.registerEPackage(vmPkg);
      final IQueryBuilderEngine.AstResult astResult = interpreter.parse(mainExpression);
      Resource _loadModel_1 = Interpreter.loadModel(modelPath, rs);
      EList<EObject> _contents = _loadModel_1.getContents();
      final EObject root = IterableExtensions.<EObject>head(_contents);
      Resource _loadModel_2 = Interpreter.loadModel(contextPath, rs);
      EList<EObject> _contents_1 = _loadModel_2.getContents();
      final EObject ctx = IterableExtensions.<EObject>head(_contents_1);
      Pair<String, EObject> _mappedTo = Pair.<String, EObject>of("context", ctx);
      final HashMap<String, EObject> arguments = CollectionLiterals.<String, EObject>newHashMap(_mappedTo);
      final EvaluationResult evaluationResult = interpreter.eval(root, astResult, arguments);
      final Diagnostic status = evaluationResult.getDiagnostic();
      Turtle _turtle = ((Context) ctx).getTurtle();
      final Window win = new Window(_turtle);
      InputOutput.<Diagnostic>println(status);
      InputOutput.println();
      Object _result = evaluationResult.getResult();
      InputOutput.<Object>println(_result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Interpreter(final Set<EPackage> metamodel, final Root implem) {
    this.implemModel = implem;
    this.metamodel = metamodel;
    this.createEnvironment();
  }
  
  public void createEnvironment() {
    try {
      IQueryEnvironment _newEnvironmentWithDefaultServices = Query.newEnvironmentWithDefaultServices(null);
      this.qryEnv = _newEnvironmentWithDefaultServices;
      final Method method = MyService.class.getMethod("foo", Object.class);
      JavaMethodService _javaMethodService = new JavaMethodService(method, null);
      this.qryEnv.registerService(_javaMethodService);
      final Method logMethod = LogService.class.getMethod("log", Object.class);
      JavaMethodService _javaMethodService_1 = new JavaMethodService(logMethod, null);
      this.qryEnv.registerService(_javaMethodService_1);
      final Method createMethod = FactoryService.class.getMethod("create", EClass.class);
      JavaMethodService _javaMethodService_2 = new JavaMethodService(createMethod, null);
      this.qryEnv.registerService(_javaMethodService_2);
      final Method cosMethod = TrigoServices.class.getMethod("cosinus", Double.class);
      JavaMethodService _javaMethodService_3 = new JavaMethodService(cosMethod, null);
      this.qryEnv.registerService(_javaMethodService_3);
      final Method sinMethod = TrigoServices.class.getMethod("sinus", Double.class);
      JavaMethodService _javaMethodService_4 = new JavaMethodService(sinMethod, null);
      this.qryEnv.registerService(_javaMethodService_4);
      final Method tanMethod = TrigoServices.class.getMethod("tan", Double.class);
      JavaMethodService _javaMethodService_5 = new JavaMethodService(tanMethod, null);
      this.qryEnv.registerService(_javaMethodService_5);
      final Method featureAccessMethod = DynamicFeatureAccess.class.getMethod("aqlFeatureAccess", EObject.class, String.class);
      DynamicFeatureAccess _dynamicFeatureAccess = new DynamicFeatureAccess(this.implemModel);
      this.dynamicFeatureAccess = _dynamicFeatureAccess;
      DynamicFeatureAccessService _dynamicFeatureAccessService = new DynamicFeatureAccessService(featureAccessMethod, this.dynamicFeatureAccess);
      this.qryEnv.registerService(_dynamicFeatureAccessService);
      final Consumer<EPackage> _function = (EPackage pkg) -> {
        this.qryEnv.registerEPackage(pkg);
        String _nsURI = pkg.getNsURI();
        boolean _containsKey = EPackage.Registry.INSTANCE.containsKey(_nsURI);
        boolean _not = (!_containsKey);
        if (_not) {
          String _nsURI_1 = pkg.getNsURI();
          EPackage.Registry.INSTANCE.put(_nsURI_1, pkg);
        }
      };
      this.metamodel.forEach(_function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IQueryBuilderEngine.AstResult parse(final String expression) {
    final QueryBuilderEngine builder = new QueryBuilderEngine(this.qryEnv);
    return builder.build(expression);
  }
  
  /**
   * Evaluate an AQL expression in the context of {@link target}
   */
  public EvaluationResult eval(final EObject target, final IQueryBuilderEngine.AstResult expression, final Map<String, EObject> args) {
    final QueryEvaluationEngine engine = new QueryEvaluationEngine(this.qryEnv);
    final Map<String, Object> variables = CollectionLiterals.<String, Object>newHashMap();
    variables.put("self", target);
    variables.putAll(args);
    return engine.eval(expression, variables);
  }
  
  /**
   * Evaluate the body of an implemented EOperation
   */
  public Object eval(final EObject target, final Behaviored implem, final List<Object> paramters) {
    final Map<String, Object> variables = CollectionLiterals.<String, Object>newHashMap();
    variables.put("self", target);
    variables.put("result", null);
    if ((implem instanceof Implementation)) {
      EOperation _operationRef = ((Implementation)implem).getOperationRef();
      EList<EParameter> _eParameters = _operationRef.getEParameters();
      final Procedure2<EParameter, Integer> _function = (EParameter param, Integer index) -> {
        String _name = param.getName();
        Object _get = paramters.get((index).intValue());
        variables.put(_name, _get);
      };
      IterableExtensions.<EParameter>forEach(_eParameters, _function);
    } else {
      if ((implem instanceof implementation.Method)) {
        EOperation _operationDef = ((implementation.Method)implem).getOperationDef();
        EList<EParameter> _eParameters_1 = _operationDef.getEParameters();
        final Procedure2<EParameter, Integer> _function_1 = (EParameter param, Integer index) -> {
          String _name = param.getName();
          Object _get = paramters.get((index).intValue());
          variables.put(_name, _get);
        };
        IterableExtensions.<EParameter>forEach(_eParameters_1, _function_1);
      }
    }
    Block _body = implem.getBody();
    this.eval(_body, variables);
    return variables.get("result");
  }
  
  /**
   * Always return the variable 'result'
   */
  public Object eval(final Statement stmt, final Map<String, Object> variables) {
    final QueryEvaluationEngine engine = new QueryEvaluationEngine(this.qryEnv);
    if ((stmt instanceof Block)) {
      final HashMap<String, Object> newScope = CollectionLiterals.<String, Object>newHashMap();
      newScope.putAll(variables);
      EList<Statement> _statements = ((Block)stmt).getStatements();
      final Consumer<Statement> _function = (Statement s) -> {
        this.eval(s, newScope);
      };
      _statements.forEach(_function);
      Set<String> _keySet = variables.keySet();
      final Consumer<String> _function_1 = (String key) -> {
        Object _get = newScope.get(key);
        variables.put(key, _get);
      };
      _keySet.forEach(_function_1);
    } else {
      if ((stmt instanceof VariableDeclaration)) {
        String _valueExpression = ((VariableDeclaration)stmt).getValueExpression();
        final IQueryBuilderEngine.AstResult expression = this.parse(_valueExpression);
        final EvaluationResult valueRes = engine.eval(expression, variables);
        String _name = ((VariableDeclaration)stmt).getName();
        Object _result = valueRes.getResult();
        variables.put(_name, _result);
      } else {
        if ((stmt instanceof VariableAssignement)) {
          String _valueExpression_1 = ((VariableAssignement)stmt).getValueExpression();
          final IQueryBuilderEngine.AstResult expression_1 = this.parse(_valueExpression_1);
          final EvaluationResult valueRes_1 = engine.eval(expression_1, variables);
          String _name_1 = ((VariableAssignement)stmt).getName();
          Object _result_1 = valueRes_1.getResult();
          variables.put(_name_1, _result_1);
        } else {
          if ((stmt instanceof FeatureAssignment)) {
            String _targetExpression = ((FeatureAssignment)stmt).getTargetExpression();
            final IQueryBuilderEngine.AstResult assignedExp = this.parse(_targetExpression);
            EvaluationResult _eval = engine.eval(assignedExp, variables);
            final Object assigned = _eval.getResult();
            String _valueExpression_2 = ((FeatureAssignment)stmt).getValueExpression();
            final IQueryBuilderEngine.AstResult valueExp = this.parse(_valueExpression_2);
            EvaluationResult _eval_1 = engine.eval(valueExp, variables);
            final Object value = _eval_1.getResult();
            if ((assigned instanceof EObject)) {
              EClass _eClass = ((EObject)assigned).eClass();
              String _targetFeature = ((FeatureAssignment)stmt).getTargetFeature();
              final EStructuralFeature feature = _eClass.getEStructuralFeature(_targetFeature);
              if ((feature != null)) {
                ((EObject)assigned).eSet(feature, value);
              } else {
                String _targetFeature_1 = ((FeatureAssignment)stmt).getTargetFeature();
                this.dynamicFeatureAccess.setDynamicFeatureValue(((EObject)assigned), _targetFeature_1, value);
              }
            }
          } else {
            if ((stmt instanceof FeatureInsert)) {
              String _targetExpression_1 = ((FeatureInsert)stmt).getTargetExpression();
              final IQueryBuilderEngine.AstResult assignedExp_1 = this.parse(_targetExpression_1);
              EvaluationResult _eval_2 = engine.eval(assignedExp_1, variables);
              final Object assigned_1 = _eval_2.getResult();
              String _valueExpression_3 = ((FeatureInsert)stmt).getValueExpression();
              final IQueryBuilderEngine.AstResult valueExp_1 = this.parse(_valueExpression_3);
              EvaluationResult _eval_3 = engine.eval(valueExp_1, variables);
              final Object value_1 = _eval_3.getResult();
              if ((assigned_1 instanceof EObject)) {
                EClass _eClass_1 = ((EObject)assigned_1).eClass();
                String _targetFeature_2 = ((FeatureInsert)stmt).getTargetFeature();
                final EStructuralFeature feature_1 = _eClass_1.getEStructuralFeature(_targetFeature_2);
                final Object featureValue = ((EObject)assigned_1).eGet(feature_1);
                if ((featureValue instanceof EList)) {
                  ((EList)featureValue).add(value_1);
                }
              }
            } else {
              if ((stmt instanceof FeatureRemove)) {
                String _targetExpression_2 = ((FeatureRemove)stmt).getTargetExpression();
                final IQueryBuilderEngine.AstResult assignedExp_2 = this.parse(_targetExpression_2);
                EvaluationResult _eval_4 = engine.eval(assignedExp_2, variables);
                final Object assigned_2 = _eval_4.getResult();
                String _valueExpression_4 = ((FeatureRemove)stmt).getValueExpression();
                final IQueryBuilderEngine.AstResult valueExp_2 = this.parse(_valueExpression_4);
                EvaluationResult _eval_5 = engine.eval(valueExp_2, variables);
                final Object value_2 = _eval_5.getResult();
                if ((assigned_2 instanceof EObject)) {
                  EClass _eClass_2 = ((EObject)assigned_2).eClass();
                  String _targetFeature_3 = ((FeatureRemove)stmt).getTargetFeature();
                  final EStructuralFeature feature_2 = _eClass_2.getEStructuralFeature(_targetFeature_3);
                  final Object featureValue_1 = ((EObject)assigned_2).eGet(feature_2);
                  if ((featureValue_1 instanceof EList)) {
                    ((EList)featureValue_1).remove(value_2);
                  }
                }
              } else {
                if ((stmt instanceof FeaturePut)) {
                  String _targetExpression_3 = ((FeaturePut)stmt).getTargetExpression();
                  final IQueryBuilderEngine.AstResult assignedExp_3 = this.parse(_targetExpression_3);
                  EvaluationResult _eval_6 = engine.eval(assignedExp_3, variables);
                  final Object assigned_3 = _eval_6.getResult();
                  String _keyExpression = ((FeaturePut)stmt).getKeyExpression();
                  final IQueryBuilderEngine.AstResult keyExp = this.parse(_keyExpression);
                  EvaluationResult _eval_7 = engine.eval(keyExp, variables);
                  final Object key = _eval_7.getResult();
                  String _valueExpression_5 = ((FeaturePut)stmt).getValueExpression();
                  final IQueryBuilderEngine.AstResult valueExp_3 = this.parse(_valueExpression_5);
                  EvaluationResult _eval_8 = engine.eval(valueExp_3, variables);
                  final Object value_3 = _eval_8.getResult();
                  if ((assigned_3 instanceof EObject)) {
                    EClass _eClass_3 = ((EObject)assigned_3).eClass();
                    String _targetFeature_4 = ((FeaturePut)stmt).getTargetFeature();
                    final EStructuralFeature feature_3 = _eClass_3.getEStructuralFeature(_targetFeature_4);
                    final Object featureValue_2 = ((EObject)assigned_3).eGet(feature_3);
                    if ((featureValue_2 instanceof EMap)) {
                      ((EMap)featureValue_2).put(key, value_3);
                    }
                  }
                } else {
                  if ((stmt instanceof ForEach)) {
                    String _collectionExpression = ((ForEach)stmt).getCollectionExpression();
                    final IQueryBuilderEngine.AstResult collectionExp = this.parse(_collectionExpression);
                    EvaluationResult _eval_9 = engine.eval(collectionExp, variables);
                    Object _result_2 = _eval_9.getResult();
                    final Collection collection = ((Collection) _result_2);
                    final HashMap<String, Object> newScope_1 = CollectionLiterals.<String, Object>newHashMap();
                    newScope_1.putAll(variables);
                    final Consumer<Object> _function_2 = (Object it) -> {
                      String _variable = ((ForEach)stmt).getVariable();
                      newScope_1.put(_variable, it);
                      Block _body = ((ForEach)stmt).getBody();
                      this.eval(_body, newScope_1);
                    };
                    collection.forEach(_function_2);
                    Set<String> _keySet_1 = variables.keySet();
                    final Consumer<String> _function_3 = (String key_1) -> {
                      Object _get = newScope_1.get(key_1);
                      variables.put(key_1, _get);
                    };
                    _keySet_1.forEach(_function_3);
                  } else {
                    if ((stmt instanceof While)) {
                      String _collectionExpression_1 = ((While)stmt).getCollectionExpression();
                      final IQueryBuilderEngine.AstResult condition = this.parse(_collectionExpression_1);
                      EvaluationResult _eval_10 = engine.eval(condition, variables);
                      Object conditionValue = _eval_10.getResult();
                      while (((conditionValue instanceof Boolean) && Objects.equal(conditionValue, Boolean.valueOf(true)))) {
                        {
                          Block _body = ((While)stmt).getBody();
                          this.eval(_body, variables);
                          EvaluationResult _eval_11 = engine.eval(condition, variables);
                          Object _result_3 = _eval_11.getResult();
                          conditionValue = _result_3;
                        }
                      }
                    } else {
                      if ((stmt instanceof If)) {
                        String _condition = ((If)stmt).getCondition();
                        final IQueryBuilderEngine.AstResult conditionExp = this.parse(_condition);
                        EvaluationResult _eval_11 = engine.eval(conditionExp, variables);
                        Object _result_3 = _eval_11.getResult();
                        final Boolean condition_1 = ((Boolean) _result_3);
                        if ((condition_1).booleanValue()) {
                          Block _then = ((If)stmt).getThen();
                          this.eval(_then, variables);
                        } else {
                          Block _else = ((If)stmt).getElse();
                          boolean _tripleNotEquals = (_else != null);
                          if (_tripleNotEquals) {
                            Block _else_1 = ((If)stmt).getElse();
                            this.eval(_else_1, variables);
                          }
                        }
                      } else {
                        if ((stmt instanceof Expression)) {
                          String _value = ((Expression)stmt).getValue();
                          final IQueryBuilderEngine.AstResult valueExp_4 = this.parse(_value);
                          engine.eval(valueExp_4, variables);
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return variables.get("result");
  }
  
  private Method getJavaMethod(final Class cls, final String methodName, final Class argType) {
    Method[] _methods = cls.getMethods();
    final Function1<Method, Boolean> _function = (Method it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, methodName));
    };
    Iterable<Method> _filter = IterableExtensions.<Method>filter(((Iterable<Method>)Conversions.doWrapArray(_methods)), _function);
    final Function1<Method, Boolean> _function_1 = (Method it) -> {
      int _parameterCount = it.getParameterCount();
      return Boolean.valueOf((_parameterCount == 1));
    };
    final Iterable<Method> candidates = IterableExtensions.<Method>filter(_filter, _function_1);
    final Function1<Method, Boolean> _function_2 = (Method it) -> {
      Class<?>[] _parameterTypes = it.getParameterTypes();
      Class<?> _get = _parameterTypes[0];
      return Boolean.valueOf(_get.isAssignableFrom(argType));
    };
    Iterable<Method> _filter_1 = IterableExtensions.<Method>filter(candidates, _function_2);
    final Method firstTry = IterableExtensions.<Method>head(_filter_1);
    if ((firstTry != null)) {
      return firstTry;
    }
    Class<? extends Object> _switchResult = null;
    boolean _matched = false;
    if (Objects.equal(argType, Boolean.class)) {
      _matched=true;
      _switchResult = boolean.class;
    }
    if (!_matched) {
      if (Objects.equal(argType, Byte.class)) {
        _matched=true;
        _switchResult = byte.class;
      }
    }
    if (!_matched) {
      if (Objects.equal(argType, Character.class)) {
        _matched=true;
        _switchResult = char.class;
      }
    }
    if (!_matched) {
      if (Objects.equal(argType, Short.class)) {
        _matched=true;
        _switchResult = short.class;
      }
    }
    if (!_matched) {
      if (Objects.equal(argType, Integer.class)) {
        _matched=true;
        _switchResult = int.class;
      }
    }
    if (!_matched) {
      if (Objects.equal(argType, Long.class)) {
        _matched=true;
        _switchResult = long.class;
      }
    }
    if (!_matched) {
      if (Objects.equal(argType, Float.class)) {
        _matched=true;
        _switchResult = float.class;
      }
    }
    if (!_matched) {
      if (Objects.equal(argType, Double.class)) {
        _matched=true;
        _switchResult = double.class;
      }
    }
    if (!_matched) {
      _switchResult = null;
    }
    final Class<? extends Object> primitiveType = _switchResult;
    if ((primitiveType != null)) {
      final Function1<Method, Boolean> _function_3 = (Method it) -> {
        Class<?>[] _parameterTypes = it.getParameterTypes();
        Class<?> _get = _parameterTypes[0];
        return Boolean.valueOf(_get.isAssignableFrom(primitiveType));
      };
      Iterable<Method> _filter_2 = IterableExtensions.<Method>filter(candidates, _function_3);
      return IterableExtensions.<Method>head(_filter_2);
    }
    return null;
  }
  
  private void registerImplem() {
    EList<ExtendedClass> _classExtensions = this.implemModel.getClassExtensions();
    final Function1<ExtendedClass, EList<Behaviored>> _function = (ExtendedClass it) -> {
      return it.getMethods();
    };
    List<EList<Behaviored>> _map = ListExtensions.<ExtendedClass, EList<Behaviored>>map(_classExtensions, _function);
    Iterable<Behaviored> _flatten = Iterables.<Behaviored>concat(_map);
    final Consumer<Behaviored> _function_1 = (Behaviored implem) -> {
      EvalBodyService _evalBodyService = new EvalBodyService(implem, this);
      this.qryEnv.registerService(_evalBodyService);
    };
    _flatten.forEach(_function_1);
  }
  
  public Set<EPackage> getMetamodel() {
    return this.metamodel;
  }
  
  public static Resource loadModel(final String path) {
    Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
    _extensionToFactoryMap.put("*", _xMIResourceFactoryImpl);
    final ResourceSetImpl rs = new ResourceSetImpl();
    final URI uri = URI.createURI(path);
    return rs.getResource(uri, true);
  }
  
  public static Resource loadModel(final String path, final ResourceSet rs) {
    Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
    _extensionToFactoryMap.put("*", _xMIResourceFactoryImpl);
    final URI uri = URI.createURI(path);
    return rs.getResource(uri, true);
  }
}
