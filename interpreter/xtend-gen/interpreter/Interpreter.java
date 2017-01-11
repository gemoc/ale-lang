package interpreter;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import fr.inria.diverse.XtdAQLStandaloneSetup;
import fr.inria.diverse.xtdAQL.Parameter;
import fr.inria.diverse.xtdAQL.Root;
import interpreter.EvalBodyService;
import interpreter.MyService;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.runtime.impl.QueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

@SuppressWarnings("all")
public class Interpreter {
  private IQueryEnvironment qryEnv;
  
  private Root implem;
  
  public static void main(final String[] args) {
    final String metamodelPath = "model/dummy.ecore";
    final String implementionPath = "model/implem.xmi";
    final String modelPath = "model/model.xmi";
    final String mainExpression = "self.name + \' : \' + self.eClass().name + \'\nService : \' + self.foobar()";
    Resource _loadModel = Interpreter.loadModel(metamodelPath);
    TreeIterator<EObject> _allContents = _loadModel.getAllContents();
    Iterator<EPackage> _filter = Iterators.<EPackage>filter(_allContents, EPackage.class);
    final Set<EPackage> metamodel = IteratorExtensions.<EPackage>toSet(_filter);
    XtdAQLStandaloneSetup.doSetup();
    Resource _loadModel_1 = Interpreter.loadModel(implementionPath);
    TreeIterator<EObject> _allContents_1 = _loadModel_1.getAllContents();
    EObject _head = IteratorExtensions.<EObject>head(_allContents_1);
    final Root implemModel = ((Root) _head);
    final Interpreter interpreter = new Interpreter(metamodel, implemModel);
    final IQueryBuilderEngine.AstResult astResult = interpreter.parse(mainExpression);
    Resource _loadModel_2 = Interpreter.loadModel(modelPath);
    EList<EObject> _contents = _loadModel_2.getContents();
    final EObject newClass1 = IterableExtensions.<EObject>head(_contents);
    final EvaluationResult evaluationResult = interpreter.eval(newClass1, astResult);
    final Diagnostic status = evaluationResult.getDiagnostic();
    InputOutput.<Diagnostic>println(status);
    InputOutput.println();
    Object _result = evaluationResult.getResult();
    InputOutput.<Object>println(_result);
  }
  
  public Interpreter(final Set<EPackage> metamodel, final Root implem) {
    this.implem = implem;
    this.createEnvironment(metamodel);
  }
  
  public void createEnvironment(final Set<EPackage> metamodel) {
    try {
      IQueryEnvironment _newEnvironmentWithDefaultServices = Query.newEnvironmentWithDefaultServices(null);
      this.qryEnv = _newEnvironmentWithDefaultServices;
      final Method method = MyService.class.getMethod("foo", Object.class);
      JavaMethodService _javaMethodService = new JavaMethodService(method, null);
      this.qryEnv.registerService(_javaMethodService);
      final Consumer<EPackage> _function = (EPackage pkg) -> {
        this.qryEnv.registerEPackage(pkg);
        String _nsURI = pkg.getNsURI();
        boolean _containsKey = EPackage.Registry.INSTANCE.containsKey(_nsURI);
        boolean _not = (!_containsKey);
        if (_not) {
          String _nsURI_1 = pkg.getNsURI();
          EPackage.Registry.INSTANCE.put(_nsURI_1, pkg);
        }
        this.registerImplem(pkg);
      };
      metamodel.forEach(_function);
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
  public EvaluationResult eval(final EObject target, final IQueryBuilderEngine.AstResult expression) {
    final QueryEvaluationEngine engine = new QueryEvaluationEngine(this.qryEnv);
    final Map<String, Object> variables = CollectionLiterals.<String, Object>newHashMap();
    variables.put("self", target);
    return engine.eval(expression, variables);
  }
  
  /**
   * Evaluate the body of an implemented EOperation
   */
  public EvaluationResult eval(final EObject target, final fr.inria.diverse.xtdAQL.Method implem, final List<Object> paramters) {
    final QueryEvaluationEngine engine = new QueryEvaluationEngine(this.qryEnv);
    String _body = implem.getBody();
    String _quote = Pattern.quote("[");
    String body = _body.replaceFirst(_quote, "");
    String _quote_1 = Pattern.quote("/]");
    String _replaceFirst = body.replaceFirst(_quote_1, "");
    body = _replaceFirst;
    final IQueryBuilderEngine.AstResult expression = this.parse(body);
    final Map<String, Object> variables = CollectionLiterals.<String, Object>newHashMap();
    variables.put("self", target);
    EList<Parameter> _param = implem.getParam();
    final Procedure2<Parameter, Integer> _function = (Parameter param, Integer index) -> {
      String _name = param.getName();
      Object _get = paramters.get((index).intValue());
      variables.put(_name, _get);
    };
    IterableExtensions.<Parameter>forEach(_param, _function);
    return engine.eval(expression, variables);
  }
  
  /**
   * Register a service for each implementation of EOperation
   */
  private void registerImplem(final EPackage p) {
    EList<EClassifier> _eClassifiers = p.getEClassifiers();
    Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
    final Consumer<EClass> _function = (EClass it) -> {
      this.registerImplem(it);
    };
    _filter.forEach(_function);
  }
  
  /**
   * Register a service for each implementation of EOperation
   */
  private void registerImplem(final EClass cls) {
    EList<EOperation> _eAllOperations = cls.getEAllOperations();
    final Consumer<EOperation> _function = (EOperation op) -> {
      EList<fr.inria.diverse.xtdAQL.Class> _classes = null;
      if (this.implem!=null) {
        _classes=this.implem.getClasses();
      }
      fr.inria.diverse.xtdAQL.Class _findFirst = null;
      if (_classes!=null) {
        final Function1<fr.inria.diverse.xtdAQL.Class, Boolean> _function_1 = (fr.inria.diverse.xtdAQL.Class it) -> {
          String _name = it.getName();
          String _name_1 = cls.getName();
          return Boolean.valueOf(Objects.equal(_name, _name_1));
        };
        _findFirst=IterableExtensions.<fr.inria.diverse.xtdAQL.Class>findFirst(_classes, _function_1);
      }
      EList<fr.inria.diverse.xtdAQL.Method> _methods = null;
      if (_findFirst!=null) {
        _methods=_findFirst.getMethods();
      }
      fr.inria.diverse.xtdAQL.Method _findFirst_1 = null;
      if (_methods!=null) {
        final Function1<fr.inria.diverse.xtdAQL.Method, Boolean> _function_2 = (fr.inria.diverse.xtdAQL.Method it) -> {
          String _name = it.getName();
          String _name_1 = op.getName();
          return Boolean.valueOf(Objects.equal(_name, _name_1));
        };
        _findFirst_1=IterableExtensions.<fr.inria.diverse.xtdAQL.Method>findFirst(_methods, _function_2);
      }
      final fr.inria.diverse.xtdAQL.Method opImpl = _findFirst_1;
      if ((opImpl != null)) {
        EvalBodyService _evalBodyService = new EvalBodyService(op, opImpl, this);
        this.qryEnv.registerService(_evalBodyService);
      }
    };
    _eAllOperations.forEach(_function);
  }
  
  public static Resource loadModel(final String path) {
    Map<String, Object> _extensionToFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
    XMIResourceFactoryImpl _xMIResourceFactoryImpl = new XMIResourceFactoryImpl();
    _extensionToFactoryMap.put("*", _xMIResourceFactoryImpl);
    final ResourceSetImpl rs = new ResourceSetImpl();
    final URI uri = URI.createURI(path);
    return rs.getResource(uri, true);
  }
}
