package org.eclipse.ecoretools.ale.typing;

import com.google.inject.Provider;
import it.xsemantics.runtime.ErrorInformation;
import it.xsemantics.runtime.Result;
import it.xsemantics.runtime.RuleApplicationTrace;
import it.xsemantics.runtime.RuleEnvironment;
import it.xsemantics.runtime.RuleFailedException;
import it.xsemantics.runtime.XsemanticsRuntimeSystem;
import java.util.List;
import org.eclipse.ecoretools.ale.Literal;
import org.eclipse.ecoretools.ale.RClass;
import org.eclipse.ecoretools.ale.RRoot;
import org.eclipse.ecoretools.ale.RType;
import org.eclipse.ecoretools.ale.TypeLiteralString;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class AleTypingValidate extends XsemanticsRuntimeSystem {
  public final static String LITERAL = "org.eclipse.ecoretools.ale.typing.Literal";
  
  private PolymorphicDispatcher<Result<RType>> exprTypeDispatcher;
  
  public AleTypingValidate() {
    init();
  }
  
  public void init() {
    exprTypeDispatcher = buildPolymorphicDispatcher1(
    	"exprTypeImpl", 3, "|-", ":");
  }
  
  public Result<RType> exprType(final Literal expression) {
    return exprType(new RuleEnvironment(), null, expression);
  }
  
  public Result<RType> exprType(final RuleEnvironment _environment_, final Literal expression) {
    return exprType(_environment_, null, expression);
  }
  
  public Result<RType> exprType(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Literal expression) {
    try {
    	return exprTypeInternal(_environment_, _trace_, expression);
    } catch (Exception _e_exprType) {
    	return resultForFailure(_e_exprType);
    }
  }
  
  public Result<Boolean> checkClassNameDuplicate(final RRoot rRoot) {
    return checkClassNameDuplicate(null, rRoot);
  }
  
  public Result<Boolean> checkClassNameDuplicate(final RuleApplicationTrace _trace_, final RRoot rRoot) {
    try {
    	return checkClassNameDuplicateInternal(_trace_, rRoot);
    } catch (Exception _e_CheckClassNameDuplicate) {
    	return resultForFailure(_e_CheckClassNameDuplicate);
    }
  }
  
  protected Result<Boolean> checkClassNameDuplicateInternal(final RuleApplicationTrace _trace_, final RRoot rRoot) throws RuleFailedException {
    EList<RClass> _xtendedClasses = rRoot.getXtendedClasses();
    final Function1<RClass, String> _function = (RClass it) -> {
      return it.getName();
    };
    List<String> _map = ListExtensions.<RClass, String>map(_xtendedClasses, _function);
    String _lineSeparator = System.lineSeparator();
    String _join = IterableExtensions.join(_map, _lineSeparator);
    InputOutput.<String>println(_join);
    /* true */
    if (!true) {
      sneakyThrowRuleFailedException("true");
    }
    return new Result<Boolean>(true);
  }
  
  protected Result<RType> exprTypeInternal(final RuleEnvironment _environment_, final RuleApplicationTrace _trace_, final Literal expression) {
    try {
    	checkParamsNotNull(expression);
    	return exprTypeDispatcher.invoke(_environment_, _trace_, expression);
    } catch (Exception _e_exprType) {
    	sneakyThrowRuleFailedException(_e_exprType);
    	return null;
    }
  }
  
  protected void exprTypeThrowException(final String _error, final String _issue, final Exception _ex, final Literal expression, final ErrorInformation[] _errorInformations) throws RuleFailedException {
    String error = ("cannot type " + expression);
    EObject source = expression;
    throwRuleFailedException(error,
    	_issue, _ex, new ErrorInformation(source, null));
  }
  
  protected Result<RType> exprTypeImpl(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeLiteralString literal) throws RuleFailedException {
    try {
    	final RuleApplicationTrace _subtrace_ = newTrace(_trace_);
    	final Result<RType> _result_ = applyRuleLiteral(G, _subtrace_, literal);
    	addToTrace(_trace_, new Provider<Object>() {
    		public Object get() {
    			return ruleName("literal") + stringRepForEnv(G) + " |- " + stringRep(literal) + " : " + stringRep(_result_.getFirst());
    		}
    	});
    	addAsSubtrace(_trace_, _subtrace_);
    	return _result_;
    } catch (Exception e_applyRuleLiteral) {
    	exprTypeThrowException(ruleName("literal") + stringRepForEnv(G) + " |- " + stringRep(literal) + " : " + "TypeLiteralString",
    		LITERAL,
    		e_applyRuleLiteral, literal, new ErrorInformation[] {new ErrorInformation(literal)});
    	return null;
    }
  }
  
  protected Result<RType> applyRuleLiteral(final RuleEnvironment G, final RuleApplicationTrace _trace_, final TypeLiteralString literal) throws RuleFailedException {
    
    return new Result<RType>(_applyRuleLiteral_1(G, literal));
  }
  
  private TypeLiteralString _applyRuleLiteral_1(final RuleEnvironment G, final TypeLiteralString literal) throws RuleFailedException {
    return literal;
  }
}
