package services;

import java.util.Collections;
import java.util.List;
import org.eclipse.acceleo.query.runtime.impl.LambdaValue;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ForEachService {
  public static <T extends Object> List<T> forEach(final List<T> sequence, final LambdaValue lambda) {
    if ((lambda != null)) {
      for (final T elt : sequence) {
        try {
          lambda.eval(((Object[])Conversions.unwrapArray(Collections.<T>unmodifiableSet(CollectionLiterals.<T>newHashSet(elt)), Object.class)));
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            lambda.logException(Diagnostic.WARNING, e);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
    }
    return sequence;
  }
}
