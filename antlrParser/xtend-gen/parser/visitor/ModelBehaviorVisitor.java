package parser.visitor;

import com.google.common.collect.Iterables;
import implementation.ExtendedClass;
import implementation.ImplementationFactory;
import implementation.ImplementationPackage;
import implementation.ModelBehavior;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import parser.XtdAQLBaseVisitor;
import parser.XtdAQLParser;
import parser.visitor.ClassVisitor;

@SuppressWarnings("all")
public class ModelBehaviorVisitor extends XtdAQLBaseVisitor<ModelBehavior> {
  @Override
  public ModelBehavior visitRRoot(final XtdAQLParser.RRootContext ctx) {
    final ClassVisitor subVisitor = new ClassVisitor();
    EFactory _eFactoryInstance = ImplementationPackage.eINSTANCE.getEFactoryInstance();
    final ImplementationFactory factory = ((ImplementationFactory) _eFactoryInstance);
    final ModelBehavior root = factory.createModelBehavior();
    EList<ExtendedClass> _classExtensions = root.getClassExtensions();
    List<XtdAQLParser.RClassContext> _rClass = ctx.rClass();
    final Function1<XtdAQLParser.RClassContext, ExtendedClass> _function = (XtdAQLParser.RClassContext it) -> {
      return subVisitor.visit(it);
    };
    List<ExtendedClass> _map = ListExtensions.<XtdAQLParser.RClassContext, ExtendedClass>map(_rClass, _function);
    Iterables.<ExtendedClass>addAll(_classExtensions, _map);
    return root;
  }
}
