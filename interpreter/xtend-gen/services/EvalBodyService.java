package services;

import com.google.common.base.Objects;
import implementation.Behaviored;
import implementation.ExtendedClass;
import implementation.Implementation;
import implementation.Method;
import interpreter.Interpreter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import org.eclipse.acceleo.query.runtime.impl.AbstractService;
import org.eclipse.acceleo.query.runtime.impl.EOperationService;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * AQL Service to eval EOperation implementation
 */
@SuppressWarnings("all")
public class EvalBodyService extends AbstractService {
  private Interpreter interpreter;
  
  private Behaviored implem;
  
  public EvalBodyService(final Behaviored implem, final Interpreter interpreter) {
    this.implem = implem;
    this.interpreter = interpreter;
  }
  
  @Override
  public Object internalInvoke(final Object[] arguments) throws Exception {
    Object _xblockexpression = null;
    {
      Object _get = arguments[0];
      final EObject caller = ((EObject) _get);
      Iterable<Object> _drop = IterableExtensions.<Object>drop(((Iterable<Object>)Conversions.doWrapArray(arguments)), 1);
      List<Object> _list = IterableExtensions.<Object>toList(_drop);
      _xblockexpression = this.interpreter.eval(caller, this.implem, _list);
    }
    return _xblockexpression;
  }
  
  @Override
  public String getName() {
    if ((this.implem instanceof Method)) {
      EOperation _operationDef = ((Method)this.implem).getOperationDef();
      return _operationDef.getName();
    } else {
      if ((this.implem instanceof Implementation)) {
        EOperation _operationRef = ((Implementation)this.implem).getOperationRef();
        return _operationRef.getName();
      } else {
        return "undefined";
      }
    }
  }
  
  @Override
  public int getNumberOfParameters() {
    if ((this.implem instanceof Method)) {
      EOperation _operationDef = ((Method)this.implem).getOperationDef();
      EList<EParameter> _eParameters = _operationDef.getEParameters();
      int _size = _eParameters.size();
      return (_size + 1);
    } else {
      if ((this.implem instanceof Implementation)) {
        EOperation _operationRef = ((Implementation)this.implem).getOperationRef();
        EList<EParameter> _eParameters_1 = _operationRef.getEParameters();
        int _size_1 = _eParameters_1.size();
        return (_size_1 + 1);
      } else {
        return 1;
      }
    }
  }
  
  @Override
  public List<IType> getParameterTypes(final IReadOnlyQueryEnvironment queryEnvironment) {
    final List<IType> result = new ArrayList<IType>();
    if ((this.implem instanceof Implementation)) {
      EOperation _operationRef = ((Implementation)this.implem).getOperationRef();
      EClass _eContainingClass = _operationRef.getEContainingClass();
      EClassifierType _eClassifierType = new EClassifierType(queryEnvironment, _eContainingClass);
      result.add(_eClassifierType);
      EOperation _operationRef_1 = ((Implementation)this.implem).getOperationRef();
      EList<EParameter> _eParameters = _operationRef_1.getEParameters();
      for (final EParameter parameter : _eParameters) {
        {
          EClassifier _eType = parameter.getEType();
          final EClassifierType rawType = new EClassifierType(queryEnvironment, _eType);
          boolean _isMany = parameter.isMany();
          if (_isMany) {
            SequenceType _sequenceType = new SequenceType(queryEnvironment, rawType);
            result.add(_sequenceType);
          } else {
            result.add(rawType);
          }
        }
      }
    } else {
      if ((this.implem instanceof Method)) {
        EObject _eContainer = ((Method)this.implem).eContainer();
        final EClass containingClass = ((ExtendedClass) _eContainer).getBaseClass();
        EClassifierType _eClassifierType_1 = new EClassifierType(queryEnvironment, containingClass);
        result.add(_eClassifierType_1);
        EOperation _operationDef = ((Method)this.implem).getOperationDef();
        EList<EParameter> _eParameters_1 = _operationDef.getEParameters();
        for (final EParameter parameter_1 : _eParameters_1) {
          {
            EClassifier _eType = parameter_1.getEType();
            final EClassifierType rawType = new EClassifierType(queryEnvironment, _eType);
            boolean _isMany = parameter_1.isMany();
            if (_isMany) {
              SequenceType _sequenceType = new SequenceType(queryEnvironment, rawType);
              result.add(_sequenceType);
            } else {
              result.add(rawType);
            }
          }
        }
      }
    }
    return result;
  }
  
  @Override
  public int getPriority() {
    return (EOperationService.PRIORITY + 1);
  }
  
  @Override
  public String getShortSignature() {
    final List<IType> parameterTypes = this.getParameterTypes(null);
    return this.serviceShortSignature(((Object[])Conversions.unwrapArray(parameterTypes, Object.class)));
  }
  
  @Override
  public String getLongSignature() {
    String ePkgNsURI = null;
    String eCLassName = null;
    EObject _eContainer = this.implem.eContainer();
    final EClass eContainingClass = ((ExtendedClass) _eContainer).getBaseClass();
    boolean _notEquals = (!Objects.equal(eContainingClass, null));
    if (_notEquals) {
      String _name = eContainingClass.getName();
      eCLassName = _name;
      final EPackage ePackage = eContainingClass.getEPackage();
      boolean _notEquals_1 = (!Objects.equal(ePackage, null));
      if (_notEquals_1) {
        String _nsURI = ePackage.getNsURI();
        ePkgNsURI = _nsURI;
      } else {
        ePkgNsURI = null;
      }
    } else {
      ePkgNsURI = null;
      eCLassName = null;
    }
    String _shortSignature = this.getShortSignature();
    return ((((ePkgNsURI + " ") + eCLassName) + " ") + _shortSignature);
  }
  
  @Override
  public Set<IType> getType(final Call call, final ValidationServices services, final IValidationResult validationResult, final IReadOnlyQueryEnvironment queryEnvironment, final List<IType> argTypes) {
    final Set<IType> result = new LinkedHashSet<IType>();
    EOperation _xifexpression = null;
    if ((this.implem instanceof Implementation)) {
      _xifexpression = ((Implementation)this.implem).getOperationRef();
    } else {
      EOperation _xifexpression_1 = null;
      if ((this.implem instanceof Method)) {
        _xifexpression_1 = ((Method)this.implem).getOperationDef();
      }
      _xifexpression = _xifexpression_1;
    }
    final EOperation eOperation = _xifexpression;
    EClassifier _eType = eOperation.getEType();
    final IType eClassifierType = new EClassifierType(queryEnvironment, _eType);
    boolean _isMany = eOperation.isMany();
    if (_isMany) {
      SequenceType _sequenceType = new SequenceType(queryEnvironment, eClassifierType);
      result.add(_sequenceType);
    } else {
      result.add(eClassifierType);
    }
    return result;
  }
}
