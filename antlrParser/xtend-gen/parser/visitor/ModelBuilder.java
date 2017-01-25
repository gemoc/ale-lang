package parser.visitor;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
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
import implementation.ImplementationFactory;
import implementation.ImplementationPackage;
import implementation.Method;
import implementation.Parameter;
import implementation.Statement;
import implementation.VariableDeclaration;
import implementation.While;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.acceleo.query.runtime.impl.EPackageProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class ModelBuilder {
  public static ModelBuilder singleton;
  
  public static ModelBuilder createSingleton(final EPackageProvider ePackageProvider) {
    ModelBuilder _modelBuilder = new ModelBuilder(ePackageProvider);
    ModelBuilder.singleton = _modelBuilder;
    return ModelBuilder.singleton;
  }
  
  private EPackageProvider ePackageProvider;
  
  private final EcoreFactory ecoreFactory = ((EcoreFactory) EcorePackage.eINSTANCE.getEFactoryInstance());
  
  private final ImplementationFactory factory = ((ImplementationFactory) ImplementationPackage.eINSTANCE.getEFactoryInstance());
  
  public ModelBuilder(final EPackageProvider ePackageProvider) {
    this.ePackageProvider = ePackageProvider;
  }
  
  public void registerPackages(final List<EPackage> pkgs) {
    final Consumer<EPackage> _function = (EPackage it) -> {
      this.ePackageProvider.registerPackage(it);
    };
    pkgs.forEach(_function);
  }
  
  public Method buildMethod(final String containingClass, final String name, final List<Parameter> params, final Block body) {
    final EOperation operation = this.ecoreFactory.createEOperation();
    operation.setName(name);
    final Consumer<Parameter> _function = (Parameter p) -> {
      final EParameter opParam = this.ecoreFactory.createEParameter();
      String _name = p.getName();
      opParam.setName(_name);
      EClassifier _type = p.getType();
      opParam.setEType(_type);
      EList<EParameter> _eParameters = operation.getEParameters();
      _eParameters.add(opParam);
    };
    params.forEach(_function);
    final Method newMethod = this.factory.createMethod();
    newMethod.setContainingClass(containingClass);
    newMethod.setOperationDef(operation);
    newMethod.setBody(body);
    return newMethod;
  }
  
  public Parameter buildParameter(final String type, final String name) {
    final Parameter param = this.factory.createParameter();
    param.setName(name);
    EClassifier _resolve = this.resolve(type);
    param.setType(_resolve);
    return param;
  }
  
  public VariableDeclaration buildVariableDecl(final String name, final String exp) {
    final VariableDeclaration varDecl = this.factory.createVariableDeclaration();
    varDecl.setName(name);
    varDecl.setValueExpression(exp);
    return varDecl;
  }
  
  public If buildIf(final String condition, final Block thenBlock, final Block elseBlock) {
    final If ifStmt = this.factory.createIf();
    ifStmt.setCondition(condition);
    ifStmt.setThen(thenBlock);
    ifStmt.setElse(elseBlock);
    return ifStmt;
  }
  
  public Block buildBlock(final List<Statement> statements) {
    final Block block = this.factory.createBlock();
    EList<Statement> _statements = block.getStatements();
    Iterables.<Statement>addAll(_statements, statements);
    return block;
  }
  
  public Expression buildExpression(final String value) {
    final Expression exp = this.factory.createExpression();
    exp.setValue(value);
    return exp;
  }
  
  public ForEach buildForEach(final String variable, final String expression, final Block body) {
    final ForEach loop = this.factory.createForEach();
    loop.setVariable(variable);
    loop.setCollectionExpression(expression);
    loop.setBody(body);
    return loop;
  }
  
  public While buildWhile(final String expression, final Block body) {
    final While loop = this.factory.createWhile();
    loop.setCollectionExpression(expression);
    loop.setBody(body);
    return loop;
  }
  
  public FeatureAssignment buildFeatureAssign(final String target, final String feature, final String valueExp) {
    final FeatureAssignment featSetting = this.factory.createFeatureAssignment();
    featSetting.setTargetExpression(target);
    featSetting.setTargetFeature(feature);
    featSetting.setValueExpression(valueExp);
    return featSetting;
  }
  
  public FeatureInsert buildFeatureInsert(final String target, final String feature, final String valueExp) {
    final FeatureInsert featSetting = this.factory.createFeatureInsert();
    featSetting.setTargetExpression(target);
    featSetting.setTargetFeature(feature);
    featSetting.setValueExpression(valueExp);
    return featSetting;
  }
  
  public FeatureRemove buildFeatureRemove(final String target, final String feature, final String valueExp) {
    final FeatureRemove featSetting = this.factory.createFeatureRemove();
    featSetting.setTargetExpression(target);
    featSetting.setTargetFeature(feature);
    featSetting.setValueExpression(valueExp);
    return featSetting;
  }
  
  public FeaturePut buildFeaturePut(final String target, final String feature, final String keyExp, final String valueExp) {
    final FeaturePut featSetting = this.factory.createFeaturePut();
    featSetting.setTargetExpression(target);
    featSetting.setTargetFeature(feature);
    featSetting.setKeyExpression(keyExp);
    featSetting.setValueExpression(valueExp);
    return featSetting;
  }
  
  public ExtendedClass buildExtendedClass(final String baseCls, final List<VariableDeclaration> vars, final List<Behaviored> operations) {
    final ExtendedClass cls = this.factory.createExtendedClass();
    EClassifier _resolve = this.resolve(baseCls);
    cls.setBaseClass(((EClass) _resolve));
    EList<Behaviored> _methods = cls.getMethods();
    Iterables.<Behaviored>addAll(_methods, operations);
    EList<VariableDeclaration> _attributes = cls.getAttributes();
    Iterables.<VariableDeclaration>addAll(_attributes, vars);
    return cls;
  }
  
  public EOperation resolve(final String className, final String methodName, final int nbArgs) {
    Set<EClassifier> _eClassifiers = this.ePackageProvider.getEClassifiers();
    Iterable<EClass> _filter = Iterables.<EClass>filter(_eClassifiers, EClass.class);
    final Function1<EClass, Boolean> _function = (EClass it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, className));
    };
    final Iterable<EClass> candidates = IterableExtensions.<EClass>filter(_filter, _function);
    final Function1<EClass, EList<EOperation>> _function_1 = (EClass it) -> {
      return it.getEOperations();
    };
    Iterable<EList<EOperation>> _map = IterableExtensions.<EClass, EList<EOperation>>map(candidates, _function_1);
    Iterable<EOperation> _flatten = Iterables.<EOperation>concat(_map);
    final Function1<EOperation, Boolean> _function_2 = (EOperation it) -> {
      return Boolean.valueOf((Objects.equal(it.getName(), methodName) && (it.getEParameters().size() == nbArgs)));
    };
    final EOperation eOperation = IterableExtensions.<EOperation>findFirst(_flatten, _function_2);
    return eOperation;
  }
  
  public EClassifier resolve(final String className) {
    Set<EClassifier> _eClassifiers = this.ePackageProvider.getEClassifiers();
    final Function1<EClassifier, Boolean> _function = (EClassifier it) -> {
      String _name = it.getName();
      return Boolean.valueOf(Objects.equal(_name, className));
    };
    final EClassifier candidate = IterableExtensions.<EClassifier>findFirst(_eClassifiers, _function);
    if ((candidate != null)) {
      return candidate;
    }
    switch (className) {
      case "boolean":
        return EcorePackage.eINSTANCE.getEBoolean();
      case "byte":
        return EcorePackage.eINSTANCE.getEByte();
      case "char":
        return EcorePackage.eINSTANCE.getEChar();
      case "short":
        return EcorePackage.eINSTANCE.getEShort();
      case "int":
        return EcorePackage.eINSTANCE.getEInt();
      case "long":
        return EcorePackage.eINSTANCE.getELong();
      case "float":
        return EcorePackage.eINSTANCE.getEFloat();
      case "double":
        return EcorePackage.eINSTANCE.getEDouble();
      default:
        return EcorePackage.eINSTANCE.getEClassifier();
    }
  }
}
