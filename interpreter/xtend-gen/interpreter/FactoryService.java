package interpreter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

@SuppressWarnings("all")
public class FactoryService {
  public static EObject create(final EClass cls) {
    return EcoreUtil.create(cls);
  }
}
