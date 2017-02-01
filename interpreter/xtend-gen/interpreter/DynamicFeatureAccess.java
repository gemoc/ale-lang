package interpreter;

import com.google.common.base.Objects;
import implementation.ExtendedClass;
import implementation.ModelBehavior;
import implementation.VariableDeclaration;
import interpreter.DynamicFeatureAccessService;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.acceleo.query.runtime.AcceleoQueryEvaluationException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class DynamicFeatureAccess {
  private ModelBehavior implem;
  
  private Map<EObject, Map<String, Object>> extendedObjects;
  
  public DynamicFeatureAccess(final ModelBehavior implem) {
    this.implem = implem;
    HashMap<EObject, Map<String, Object>> _newHashMap = CollectionLiterals.<EObject, Map<String, Object>>newHashMap();
    this.extendedObjects = _newHashMap;
  }
  
  /**
   * Returns the value of the specified feature on the specified object. The object must be an
   * {@link EObject} or a {@link Set}, {@link List} of {@link EObject}.
   * 
   * @param context
   *            the object in which to read the feature.
   * @param featureName
   *            the name of the feature to read.
   * @param diagnostic
   *            The status to update in case of warnings or errors during this call.
   * @return the value of the specified feature in the specified object.
   */
  public Object aqlFeatureAccess(final EObject context, final String featureName) {
    Object result = null;
    boolean _equals = Objects.equal(context, null);
    if (_equals) {
      final String message = String.format(DynamicFeatureAccessService.NON_EOBJECT_FEATURE_ACCESS, featureName, "null");
      throw new AcceleoQueryEvaluationException(message);
    } else {
      final EClass eClass = context.eClass();
      final EStructuralFeature feature = eClass.getEStructuralFeature(featureName);
      boolean _equals_1 = Objects.equal(feature, null);
      if (_equals_1) {
        Object _dynamicFeatureValue = this.getDynamicFeatureValue(context, featureName);
        result = _dynamicFeatureValue;
        boolean _equals_2 = Objects.equal(result, null);
        if (_equals_2) {
          String _name = eClass.getName();
          final String message_1 = String.format(DynamicFeatureAccessService.UNKNOWN_FEATURE, featureName, _name);
          throw new AcceleoQueryEvaluationException(message_1);
        }
      } else {
        Object _eGet = context.eGet(feature);
        result = _eGet;
      }
    }
    return result;
  }
  
  public Object getDynamicFeatureValue(final EObject instance, final String featureName) {
    final Map<String, Object> extendedInstance = this.getExtensionFeatures(instance);
    final Object featureValue = extendedInstance.get(featureName);
    if ((featureValue != null)) {
      return featureValue;
    }
    EList<ExtendedClass> _classExtensions = this.implem.getClassExtensions();
    final Function1<ExtendedClass, Boolean> _function = (ExtendedClass it) -> {
      EClass _baseClass = it.getBaseClass();
      return Boolean.valueOf(_baseClass.isInstance(instance));
    };
    final ExtendedClass xtdClass = IterableExtensions.<ExtendedClass>findFirst(_classExtensions, _function);
    EList<VariableDeclaration> _attributes = xtdClass.getAttributes();
    final Function1<VariableDeclaration, Boolean> _function_1 = (VariableDeclaration it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, featureName));
    };
    final VariableDeclaration featureDeclaration = IterableExtensions.<VariableDeclaration>findFirst(_attributes, _function_1);
    if ((featureDeclaration == null)) {
      EClass _eClass = instance.eClass();
      String _name = _eClass.getName();
      final String message = String.format(DynamicFeatureAccessService.UNKNOWN_FEATURE, featureName, _name);
      throw new AcceleoQueryEvaluationException(message);
    }
    final int initialValue = 0;
    extendedInstance.put(featureName, Integer.valueOf(initialValue));
    return Integer.valueOf(initialValue);
  }
  
  public void setDynamicFeatureValue(final EObject instance, final String featureName, final Object newValue) {
    final Map<String, Object> extendedInstance = this.getExtensionFeatures(instance);
    final Object featureValue = extendedInstance.get(featureName);
    if ((featureValue != null)) {
      extendedInstance.put(featureName, newValue);
    } else {
      EList<ExtendedClass> _classExtensions = this.implem.getClassExtensions();
      final Function1<ExtendedClass, Boolean> _function = (ExtendedClass it) -> {
        EClass _baseClass = it.getBaseClass();
        return Boolean.valueOf(_baseClass.isInstance(instance));
      };
      final ExtendedClass xtdClass = IterableExtensions.<ExtendedClass>findFirst(_classExtensions, _function);
      EList<VariableDeclaration> _attributes = xtdClass.getAttributes();
      final Function1<VariableDeclaration, Boolean> _function_1 = (VariableDeclaration it) -> {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, featureName));
      };
      final VariableDeclaration featureDeclaration = IterableExtensions.<VariableDeclaration>findFirst(_attributes, _function_1);
      if ((featureDeclaration != null)) {
        extendedInstance.put(featureName, newValue);
      } else {
      }
    }
  }
  
  private Map<String, Object> getExtensionFeatures(final EObject instance) {
    Map<String, Object> extendedInstance = this.extendedObjects.get(instance);
    if ((extendedInstance == null)) {
      HashMap<String, Object> _hashMap = new HashMap<String, Object>();
      extendedInstance = _hashMap;
      this.extendedObjects.put(instance, extendedInstance);
    }
    return extendedInstance;
  }
}
