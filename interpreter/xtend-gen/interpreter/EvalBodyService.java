package interpreter;

import fr.inria.diverse.xtdAQL.Method;
import interpreter.Interpreter;
import java.util.List;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.impl.EOperationService;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * AQL Service to eval EOperation implementation
 */
@SuppressWarnings("all")
public class EvalBodyService extends EOperationService {
  private Interpreter interpreter;
  
  private Method implem;
  
  public EvalBodyService(final EOperation eOperation, final Method implem, final Interpreter interpreter) {
    super(eOperation);
    this.implem = implem;
    this.interpreter = interpreter;
  }
  
  @Override
  public boolean equals(final Object obj) {
    return (this == obj);
  }
  
  @Override
  public Object internalInvoke(final Object[] arguments) throws Exception {
    Object _xblockexpression = null;
    {
      Object _get = arguments[0];
      final EObject caller = ((EObject) _get);
      Iterable<Object> _drop = IterableExtensions.<Object>drop(((Iterable<Object>)Conversions.doWrapArray(arguments)), 1);
      List<Object> _list = IterableExtensions.<Object>toList(_drop);
      EvaluationResult _eval = this.interpreter.eval(caller, this.implem, _list);
      _xblockexpression = _eval.getResult();
    }
    return _xblockexpression;
  }
}
