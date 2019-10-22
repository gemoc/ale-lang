/**
 * ******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  *
 * Contributors:
 *     Inria - initial API and implementation
 *  *
 * generated by Xtext 2.14.0
 *  ******************************************************************************
 */
package org.eclipse.emf.ecoretools.ale.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecoretools.ale.Add;
import org.eclipse.emf.ecoretools.ale.AleFactory;
import org.eclipse.emf.ecoretools.ale.AlePackage;
import org.eclipse.emf.ecoretools.ale.And;
import org.eclipse.emf.ecoretools.ale.Apply;
import org.eclipse.emf.ecoretools.ale.Assign;
import org.eclipse.emf.ecoretools.ale.Attribute;
import org.eclipse.emf.ecoretools.ale.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.Block;
import org.eclipse.emf.ecoretools.ale.BoolType;
import org.eclipse.emf.ecoretools.ale.Call;
import org.eclipse.emf.ecoretools.ale.ClassifierSetType;
import org.eclipse.emf.ecoretools.ale.ClassifierType;
import org.eclipse.emf.ecoretools.ale.Collection;
import org.eclipse.emf.ecoretools.ale.Comp;
import org.eclipse.emf.ecoretools.ale.Conditional;
import org.eclipse.emf.ecoretools.ale.Expression;
import org.eclipse.emf.ecoretools.ale.ExpressionStmt;
import org.eclipse.emf.ecoretools.ale.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.False;
import org.eclipse.emf.ecoretools.ale.Feature;
import org.eclipse.emf.ecoretools.ale.ForEach;
import org.eclipse.emf.ecoretools.ale.If;
import org.eclipse.emf.ecoretools.ale.Implie;
import org.eclipse.emf.ecoretools.ale.Import;
import org.eclipse.emf.ecoretools.ale.Insert;
import org.eclipse.emf.ecoretools.ale.Int;
import org.eclipse.emf.ecoretools.ale.IntType;
import org.eclipse.emf.ecoretools.ale.Let;
import org.eclipse.emf.ecoretools.ale.Lit;
import org.eclipse.emf.ecoretools.ale.Min;
import org.eclipse.emf.ecoretools.ale.Mult;
import org.eclipse.emf.ecoretools.ale.Not;
import org.eclipse.emf.ecoretools.ale.Null;
import org.eclipse.emf.ecoretools.ale.Operation;
import org.eclipse.emf.ecoretools.ale.Or;
import org.eclipse.emf.ecoretools.ale.OrderedSet;
import org.eclipse.emf.ecoretools.ale.Real;
import org.eclipse.emf.ecoretools.ale.RealType;
import org.eclipse.emf.ecoretools.ale.Remove;
import org.eclipse.emf.ecoretools.ale.RuntimeClass;
import org.eclipse.emf.ecoretools.ale.SeqType;
import org.eclipse.emf.ecoretools.ale.Sequence;
import org.eclipse.emf.ecoretools.ale.Service;
import org.eclipse.emf.ecoretools.ale.SetType;
import org.eclipse.emf.ecoretools.ale.Statement;
import org.eclipse.emf.ecoretools.ale.StringType;
import org.eclipse.emf.ecoretools.ale.Tag;
import org.eclipse.emf.ecoretools.ale.True;
import org.eclipse.emf.ecoretools.ale.Unit;
import org.eclipse.emf.ecoretools.ale.VarDecl;
import org.eclipse.emf.ecoretools.ale.VarRef;
import org.eclipse.emf.ecoretools.ale.Variable;
import org.eclipse.emf.ecoretools.ale.While;
import org.eclipse.emf.ecoretools.ale.Xor;
import org.eclipse.emf.ecoretools.ale.binding;
import org.eclipse.emf.ecoretools.ale.classifierTypeRule;
import org.eclipse.emf.ecoretools.ale.literal;
import org.eclipse.emf.ecoretools.ale.rCase;
import org.eclipse.emf.ecoretools.ale.rOpposite;
import org.eclipse.emf.ecoretools.ale.rSwitch;
import org.eclipse.emf.ecoretools.ale.rType;
import org.eclipse.emf.ecoretools.ale.typeLiteral;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AleFactoryImpl extends EFactoryImpl implements AleFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static AleFactory init()
  {
    try
    {
      AleFactory theAleFactory = (AleFactory)EPackage.Registry.INSTANCE.getEFactory(AlePackage.eNS_URI);
      if (theAleFactory != null)
      {
        return theAleFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new AleFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AleFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case AlePackage.UNIT: return createUnit();
      case AlePackage.IMPORT: return createImport();
      case AlePackage.SERVICE: return createService();
      case AlePackage.BEHAVIORED_CLASS: return createBehavioredClass();
      case AlePackage.EXTENDED_CLASS: return createExtendedClass();
      case AlePackage.RUNTIME_CLASS: return createRuntimeClass();
      case AlePackage.OPERATION: return createOperation();
      case AlePackage.TAG: return createTag();
      case AlePackage.VARIABLE: return createVariable();
      case AlePackage.ATTRIBUTE: return createAttribute();
      case AlePackage.ROPPOSITE: return createrOpposite();
      case AlePackage.STATEMENT: return createStatement();
      case AlePackage.VAR_DECL: return createVarDecl();
      case AlePackage.ASSIGN: return createAssign();
      case AlePackage.INSERT: return createInsert();
      case AlePackage.REMOVE: return createRemove();
      case AlePackage.FOR_EACH: return createForEach();
      case AlePackage.COLLECTION: return createCollection();
      case AlePackage.BLOCK: return createBlock();
      case AlePackage.IF: return createIf();
      case AlePackage.WHILE: return createWhile();
      case AlePackage.RSWITCH: return createrSwitch();
      case AlePackage.RCASE: return createrCase();
      case AlePackage.EXPRESSION_STMT: return createExpressionStmt();
      case AlePackage.EXPRESSION: return createExpression();
      case AlePackage.BINDING: return createbinding();
      case AlePackage.LITERAL: return createliteral();
      case AlePackage.TYPE_LITERAL: return createtypeLiteral();
      case AlePackage.CLASSIFIER_TYPE_RULE: return createclassifierTypeRule();
      case AlePackage.RTYPE: return createrType();
      case AlePackage.CALL: return createCall();
      case AlePackage.FEATURE: return createFeature();
      case AlePackage.APPLY: return createApply();
      case AlePackage.MULT: return createMult();
      case AlePackage.ADD: return createAdd();
      case AlePackage.COMP: return createComp();
      case AlePackage.AND: return createAnd();
      case AlePackage.OR: return createOr();
      case AlePackage.XOR: return createXor();
      case AlePackage.IMPLIE: return createImplie();
      case AlePackage.NOT: return createNot();
      case AlePackage.MIN: return createMin();
      case AlePackage.VAR_REF: return createVarRef();
      case AlePackage.LIT: return createLit();
      case AlePackage.CONDITIONAL: return createConditional();
      case AlePackage.LET: return createLet();
      case AlePackage.STRING: return createString();
      case AlePackage.INT: return createInt();
      case AlePackage.REAL: return createReal();
      case AlePackage.TRUE: return createTrue();
      case AlePackage.FALSE: return createFalse();
      case AlePackage.NULL: return createNull();
      case AlePackage.SEQUENCE: return createSequence();
      case AlePackage.ORDERED_SET: return createOrderedSet();
      case AlePackage.ENUM: return createEnum();
      case AlePackage.STRING_TYPE: return createStringType();
      case AlePackage.INT_TYPE: return createIntType();
      case AlePackage.REAL_TYPE: return createRealType();
      case AlePackage.BOOL_TYPE: return createBoolType();
      case AlePackage.SEQ_TYPE: return createSeqType();
      case AlePackage.SET_TYPE: return createSetType();
      case AlePackage.CLASSIFIER_SET_TYPE: return createClassifierSetType();
      case AlePackage.CLASSIFIER_TYPE: return createClassifierType();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Unit createUnit()
  {
    UnitImpl unit = new UnitImpl();
    return unit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Service createService()
  {
    ServiceImpl service = new ServiceImpl();
    return service;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BehavioredClass createBehavioredClass()
  {
    BehavioredClassImpl behavioredClass = new BehavioredClassImpl();
    return behavioredClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExtendedClass createExtendedClass()
  {
    ExtendedClassImpl extendedClass = new ExtendedClassImpl();
    return extendedClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuntimeClass createRuntimeClass()
  {
    RuntimeClassImpl runtimeClass = new RuntimeClassImpl();
    return runtimeClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Operation createOperation()
  {
    OperationImpl operation = new OperationImpl();
    return operation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Tag createTag()
  {
    TagImpl tag = new TagImpl();
    return tag;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Variable createVariable()
  {
    VariableImpl variable = new VariableImpl();
    return variable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public rOpposite createrOpposite()
  {
    rOppositeImpl rOpposite = new rOppositeImpl();
    return rOpposite;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarDecl createVarDecl()
  {
    VarDeclImpl varDecl = new VarDeclImpl();
    return varDecl;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Assign createAssign()
  {
    AssignImpl assign = new AssignImpl();
    return assign;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Insert createInsert()
  {
    InsertImpl insert = new InsertImpl();
    return insert;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Remove createRemove()
  {
    RemoveImpl remove = new RemoveImpl();
    return remove;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForEach createForEach()
  {
    ForEachImpl forEach = new ForEachImpl();
    return forEach;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Collection createCollection()
  {
    CollectionImpl collection = new CollectionImpl();
    return collection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block createBlock()
  {
    BlockImpl block = new BlockImpl();
    return block;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public If createIf()
  {
    IfImpl if_ = new IfImpl();
    return if_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public While createWhile()
  {
    WhileImpl while_ = new WhileImpl();
    return while_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public rSwitch createrSwitch()
  {
    rSwitchImpl rSwitch = new rSwitchImpl();
    return rSwitch;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public rCase createrCase()
  {
    rCaseImpl rCase = new rCaseImpl();
    return rCase;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressionStmt createExpressionStmt()
  {
    ExpressionStmtImpl expressionStmt = new ExpressionStmtImpl();
    return expressionStmt;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression createExpression()
  {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public binding createbinding()
  {
    bindingImpl binding = new bindingImpl();
    return binding;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public literal createliteral()
  {
    literalImpl literal = new literalImpl();
    return literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public typeLiteral createtypeLiteral()
  {
    typeLiteralImpl typeLiteral = new typeLiteralImpl();
    return typeLiteral;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public classifierTypeRule createclassifierTypeRule()
  {
    classifierTypeRuleImpl classifierTypeRule = new classifierTypeRuleImpl();
    return classifierTypeRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public rType createrType()
  {
    rTypeImpl rType = new rTypeImpl();
    return rType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Call createCall()
  {
    CallImpl call = new CallImpl();
    return call;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Feature createFeature()
  {
    FeatureImpl feature = new FeatureImpl();
    return feature;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Apply createApply()
  {
    ApplyImpl apply = new ApplyImpl();
    return apply;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Mult createMult()
  {
    MultImpl mult = new MultImpl();
    return mult;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Add createAdd()
  {
    AddImpl add = new AddImpl();
    return add;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Comp createComp()
  {
    CompImpl comp = new CompImpl();
    return comp;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public And createAnd()
  {
    AndImpl and = new AndImpl();
    return and;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Or createOr()
  {
    OrImpl or = new OrImpl();
    return or;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Xor createXor()
  {
    XorImpl xor = new XorImpl();
    return xor;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Implie createImplie()
  {
    ImplieImpl implie = new ImplieImpl();
    return implie;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Not createNot()
  {
    NotImpl not = new NotImpl();
    return not;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Min createMin()
  {
    MinImpl min = new MinImpl();
    return min;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarRef createVarRef()
  {
    VarRefImpl varRef = new VarRefImpl();
    return varRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Lit createLit()
  {
    LitImpl lit = new LitImpl();
    return lit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Conditional createConditional()
  {
    ConditionalImpl conditional = new ConditionalImpl();
    return conditional;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Let createLet()
  {
    LetImpl let = new LetImpl();
    return let;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.emf.ecoretools.ale.String createString()
  {
    StringImpl string = new StringImpl();
    return string;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Int createInt()
  {
    IntImpl int_ = new IntImpl();
    return int_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Real createReal()
  {
    RealImpl real = new RealImpl();
    return real;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public True createTrue()
  {
    TrueImpl true_ = new TrueImpl();
    return true_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public False createFalse()
  {
    FalseImpl false_ = new FalseImpl();
    return false_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Null createNull()
  {
    NullImpl null_ = new NullImpl();
    return null_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Sequence createSequence()
  {
    SequenceImpl sequence = new SequenceImpl();
    return sequence;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OrderedSet createOrderedSet()
  {
    OrderedSetImpl orderedSet = new OrderedSetImpl();
    return orderedSet;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public org.eclipse.emf.ecoretools.ale.Enum createEnum()
  {
    EnumImpl enum_ = new EnumImpl();
    return enum_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringType createStringType()
  {
    StringTypeImpl stringType = new StringTypeImpl();
    return stringType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntType createIntType()
  {
    IntTypeImpl intType = new IntTypeImpl();
    return intType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RealType createRealType()
  {
    RealTypeImpl realType = new RealTypeImpl();
    return realType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolType createBoolType()
  {
    BoolTypeImpl boolType = new BoolTypeImpl();
    return boolType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SeqType createSeqType()
  {
    SeqTypeImpl seqType = new SeqTypeImpl();
    return seqType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SetType createSetType()
  {
    SetTypeImpl setType = new SetTypeImpl();
    return setType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifierSetType createClassifierSetType()
  {
    ClassifierSetTypeImpl classifierSetType = new ClassifierSetTypeImpl();
    return classifierSetType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifierType createClassifierType()
  {
    ClassifierTypeImpl classifierType = new ClassifierTypeImpl();
    return classifierType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlePackage getAlePackage()
  {
    return (AlePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static AlePackage getPackage()
  {
    return AlePackage.eINSTANCE;
  }

} //AleFactoryImpl
