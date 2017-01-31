package interpreter;

import com.google.common.collect.Iterables;
import implementation.Behaviored;
import implementation.ExtendedClass;
import implementation.Root;
import interpreter.DynamicFeatureAccess;
import interpreter.DynamicFeatureAccessService;
import interpreter.ImplementationEvaluator;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.ServiceRegistrationResult;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.runtime.impl.QueryEvaluationEngine;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import services.EvalBodyService;
import services.FactoryService;
import services.LogService;
import services.TrigoServices;

@SuppressWarnings("all")
public class EvalEnvironment {
  private IQueryEnvironment qryEnv;
  
  private Root implemModel;
  
  private DynamicFeatureAccess dynamicFeatures;
  
  public EvalEnvironment(final IQueryEnvironment qryEnv, final Set<EPackage> metamodel, final Root implem) {
    this.qryEnv = qryEnv;
    this.createDefaultServices();
    final Consumer<EPackage> _function = (EPackage it) -> {
      this.registerEPackage(it);
    };
    metamodel.forEach(_function);
    this.registerImplem(implem);
  }
  
  public void createDefaultServices() {
    try {
      final Method logMethod = LogService.class.getMethod("log", Object.class);
      JavaMethodService _javaMethodService = new JavaMethodService(logMethod, null);
      this.qryEnv.registerService(_javaMethodService);
      final Method createMethod = FactoryService.class.getMethod("create", EClass.class);
      JavaMethodService _javaMethodService_1 = new JavaMethodService(createMethod, null);
      this.qryEnv.registerService(_javaMethodService_1);
      final Method cosMethod = TrigoServices.class.getMethod("cosinus", Double.class);
      JavaMethodService _javaMethodService_2 = new JavaMethodService(cosMethod, null);
      this.qryEnv.registerService(_javaMethodService_2);
      final Method sinMethod = TrigoServices.class.getMethod("sinus", Double.class);
      JavaMethodService _javaMethodService_3 = new JavaMethodService(sinMethod, null);
      this.qryEnv.registerService(_javaMethodService_3);
      final Method tanMethod = TrigoServices.class.getMethod("tan", Double.class);
      JavaMethodService _javaMethodService_4 = new JavaMethodService(tanMethod, null);
      this.qryEnv.registerService(_javaMethodService_4);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void registerEPackage(final EPackage pkg) {
    this.qryEnv.registerEPackage(pkg);
    String _nsURI = pkg.getNsURI();
    boolean _containsKey = EPackage.Registry.INSTANCE.containsKey(_nsURI);
    boolean _not = (!_containsKey);
    if (_not) {
      String _nsURI_1 = pkg.getNsURI();
      EPackage.Registry.INSTANCE.put(_nsURI_1, pkg);
    }
  }
  
  /**
   * Register services to access dynamic features and evaluate operations
   */
  public ServiceRegistrationResult registerImplem(final Root implemModel) {
    try {
      ServiceRegistrationResult _xblockexpression = null;
      {
        this.implemModel = implemModel;
        DynamicFeatureAccess _dynamicFeatureAccess = new DynamicFeatureAccess(implemModel);
        this.dynamicFeatures = _dynamicFeatureAccess;
        QueryEvaluationEngine _queryEvaluationEngine = new QueryEvaluationEngine(this.qryEnv);
        final ImplementationEvaluator evaluator = new ImplementationEvaluator(_queryEvaluationEngine, this.dynamicFeatures);
        EList<ExtendedClass> _classExtensions = implemModel.getClassExtensions();
        final Function1<ExtendedClass, EList<Behaviored>> _function = (ExtendedClass it) -> {
          return it.getMethods();
        };
        List<EList<Behaviored>> _map = ListExtensions.<ExtendedClass, EList<Behaviored>>map(_classExtensions, _function);
        Iterable<Behaviored> _flatten = Iterables.<Behaviored>concat(_map);
        final Consumer<Behaviored> _function_1 = (Behaviored implemOp) -> {
          EvalBodyService _evalBodyService = new EvalBodyService(implemOp, this);
          this.qryEnv.registerService(_evalBodyService);
        };
        _flatten.forEach(_function_1);
        final Method featureAccessMethod = DynamicFeatureAccess.class.getMethod("aqlFeatureAccess", EObject.class, String.class);
        DynamicFeatureAccessService _dynamicFeatureAccessService = new DynamicFeatureAccessService(featureAccessMethod, this.dynamicFeatures);
        _xblockexpression = this.qryEnv.registerService(_dynamicFeatureAccessService);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public IQueryEnvironment getQueryEnvironment() {
    return this.qryEnv;
  }
  
  public DynamicFeatureAccess getFeatureAccess() {
    return this.dynamicFeatures;
  }
}
