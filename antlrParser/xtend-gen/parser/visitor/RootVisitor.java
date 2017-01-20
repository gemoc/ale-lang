package parser.visitor;

import com.google.common.collect.Iterables;
import implementation.Behaviored;
import implementation.ImplementationFactory;
import implementation.ImplementationPackage;
import implementation.Root;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import parser.XtdAQLBaseVisitor;
import parser.XtdAQLParser;
import parser.visitor.ClassVisitor;

@SuppressWarnings("all")
public class RootVisitor extends XtdAQLBaseVisitor<Root> {
  @Override
  public Root visitRRoot(final XtdAQLParser.RRootContext ctx) {
    final ClassVisitor subVisitor = new ClassVisitor();
    EFactory _eFactoryInstance = ImplementationPackage.eINSTANCE.getEFactoryInstance();
    final ImplementationFactory factory = ((ImplementationFactory) _eFactoryInstance);
    final Root root = factory.createRoot();
    EList<Behaviored> _declarations = root.getDeclarations();
    List<XtdAQLParser.RClassContext> _rClass = ctx.rClass();
    final Function1<XtdAQLParser.RClassContext, List<Behaviored>> _function = (XtdAQLParser.RClassContext it) -> {
      return subVisitor.visit(it);
    };
    List<List<Behaviored>> _map = ListExtensions.<XtdAQLParser.RClassContext, List<Behaviored>>map(_rClass, _function);
    Iterable<Behaviored> _flatten = Iterables.<Behaviored>concat(_map);
    Iterables.<Behaviored>addAll(_declarations, _flatten);
    return root;
  }
}
