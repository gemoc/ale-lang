package interpreter;

import com.google.common.base.Objects;
import interpreter.DynamicFeatureAccess;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.ast.StringLiteral;
import org.eclipse.acceleo.query.runtime.ICompletionProposal;
import org.eclipse.acceleo.query.runtime.IEPackageProvider;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import org.eclipse.acceleo.query.runtime.impl.AbstractService;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.runtime.impl.completion.EFeatureCompletionProposal;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.NothingType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Copy/past of EObjectServices.EObjectFeatureAccess cause it's private & final :(
 */
@SuppressWarnings("all")
public class DynamicFeatureAccessService extends JavaMethodService {
  public final static String DON_T_KNOW_WHAT_TO_DO_WITH = "don\'t know what to do with ";
  
  public final static String NON_EOBJECT_FEATURE_ACCESS = "Attempt to access feature (%s) on a non ModelObject value (%s).";
  
  public final static String UNKNOWN_FEATURE = "Feature %s not found in EClass %s";
  
  /**
   * Creates a new service instance given a method and an instance.
   * 
   * @param method
   *            the method that realizes the service
   * @param serviceInstance
   *            the instance on which the service must be called
   */
  public DynamicFeatureAccessService(final Method method, final DynamicFeatureAccess serviceInstance) {
    super(method, serviceInstance);
  }
  
  /**
   * {@inheritDoc}
   * 
   * @see JavaMethodService#getType(org.eclipse.acceleo.query.ast.Call,
   *      org.eclipse.acceleo.query.runtime.impl.ValidationServices,
   *      org.eclipse.acceleo.query.runtime.IValidationResult,
   *      org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment, java.util.List)
   */
  @Override
  public Set<IType> getType(final Call call, final ValidationServices services, final IValidationResult validationResult, final IReadOnlyQueryEnvironment queryEnvironment, final List<IType> argTypes) {
    EList<Expression> _arguments = call.getArguments();
    Expression _get = _arguments.get(1);
    final String featureName = ((StringLiteral) _get).getValue();
    IType _get_1 = argTypes.get(0);
    final Set<IType> result = this.featureAccessTypes(services, queryEnvironment, _get_1, featureName);
    return result;
  }
  
  /**
   * Gets the type of a feature access.
   * 
   * @param queryEnvironment
   *            the {@link IReadOnlyQueryEnvironment}
   * @param receiverTypes
   *            the target types to gets the feature from
   * @param featureName
   *            the feature name
   * @return the type of a feature access
   */
  public Set<IType> featureAccessTypes(final ValidationServices services, final IReadOnlyQueryEnvironment queryEnvironment, final IType receiverType, final String featureName) {
    final Set<IType> result = new LinkedHashSet<IType>();
    final Set<EClass> receiverEClasses = new LinkedHashSet<EClass>();
    Object _type = receiverType.getType();
    if ((_type instanceof EClass)) {
      Object _type_1 = receiverType.getType();
      receiverEClasses.add(((EClass) _type_1));
    } else {
      Object _type_2 = receiverType.getType();
      if ((_type_2 instanceof Class)) {
        IEPackageProvider _ePackageProvider = queryEnvironment.getEPackageProvider();
        Object _type_3 = receiverType.getType();
        final Set<EClassifier> eClassifiers = _ePackageProvider.getEClassifiers(
          ((Class<?>) _type_3));
        boolean _notEquals = (!Objects.equal(eClassifiers, null));
        if (_notEquals) {
          for (final EClassifier eCls : eClassifiers) {
            if ((eCls instanceof EClass)) {
              receiverEClasses.add(((EClass) eCls));
            }
          }
        }
      } else {
        Object _type_4 = receiverType.getType();
        String _plus = (DynamicFeatureAccessService.DON_T_KNOW_WHAT_TO_DO_WITH + _type_4);
        throw new IllegalStateException(_plus);
      }
    }
    boolean _isEmpty = receiverEClasses.isEmpty();
    if (_isEmpty) {
      Object _type_5 = receiverType.getType();
      String _string = _type_5.toString();
      NothingType _nothing = services.nothing(DynamicFeatureAccessService.NON_EOBJECT_FEATURE_ACCESS, featureName, _string);
      result.add(_nothing);
    } else {
      for (final EClass eClass : receiverEClasses) {
        {
          final EStructuralFeature feature = eClass.getEStructuralFeature(featureName);
          boolean _equals = Objects.equal(feature, null);
          if (_equals) {
            String _name = eClass.getName();
            NothingType _nothing_1 = services.nothing(DynamicFeatureAccessService.UNKNOWN_FEATURE, featureName, _name);
            result.add(_nothing_1);
          } else {
            EClassifier _eType = feature.getEType();
            final EClassifierType featureBasicType = new EClassifierType(queryEnvironment, _eType);
            boolean _isMany = feature.isMany();
            if (_isMany) {
              SequenceType _sequenceType = new SequenceType(queryEnvironment, featureBasicType);
              result.add(_sequenceType);
            } else {
              result.add(featureBasicType);
            }
          }
        }
      }
    }
    return result;
  }
  
  /**
   * {@inheritDoc}
   * 
   * @see AbstractService#validateAllType(org.eclipse.acceleo.query.runtime.impl.ValidationServices,
   *      org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment, java.util.Map)
   */
  @Override
  public Set<IType> validateAllType(final ValidationServices services, final IReadOnlyQueryEnvironment queryEnvironment, final Map<List<IType>, Set<IType>> allTypes) {
    final Set<IType> result = new LinkedHashSet<IType>();
    final Set<IType> knownReceiverTypes = new LinkedHashSet<IType>();
    Set<Map.Entry<List<IType>, Set<IType>>> _entrySet = allTypes.entrySet();
    for (final Map.Entry<List<IType>, Set<IType>> entry : _entrySet) {
      List<IType> _key = entry.getKey();
      IType _get = _key.get(0);
      boolean _add = knownReceiverTypes.add(_get);
      if (_add) {
        Set<IType> _value = entry.getValue();
        result.addAll(_value);
      }
    }
    return result;
  }
  
  @Override
  public List<ICompletionProposal> getProposals(final IReadOnlyQueryEnvironment queryEnvironment, final Set<IType> receiverTypes) {
    return this.getEStructuralFeatureProposals(queryEnvironment, receiverTypes);
  }
  
  /**
   * Gets the {@link List} of {@link EFeatureCompletionProposal} for {@link EStructuralFeature}.
   * 
   * @param receiverTypes
   *            the receiver types.
   * @return the {@link List} of {@link EFeatureCompletionProposal} for {@link EStructuralFeature}
   */
  public List<ICompletionProposal> getEStructuralFeatureProposals(final IReadOnlyQueryEnvironment queryEnvironment, final Set<IType> receiverTypes) {
    final List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
    final Set<EClass> eClasses = new LinkedHashSet<EClass>();
    for (final IType iType : receiverTypes) {
      Object _type = iType.getType();
      if ((_type instanceof EClass)) {
        Object _type_1 = iType.getType();
        eClasses.add(((EClass) _type_1));
      }
    }
    IEPackageProvider _ePackageProvider = queryEnvironment.getEPackageProvider();
    Set<EStructuralFeature> _eStructuralFeatures = _ePackageProvider.getEStructuralFeatures(eClasses);
    for (final EStructuralFeature feature : _eStructuralFeatures) {
      EFeatureCompletionProposal _eFeatureCompletionProposal = new EFeatureCompletionProposal(feature);
      result.add(_eFeatureCompletionProposal);
    }
    return result;
  }
  
  @Override
  public int getPriority() {
    int _priority = super.getPriority();
    return (_priority + 1);
  }
}
