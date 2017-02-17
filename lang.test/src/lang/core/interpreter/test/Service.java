package lang.core.interpreter.test;

import org.eclipse.emf.ecore.EObject;

public class Service {
	public String foobar(EObject o) {
		return "foobar:"+o.eClass().getName();
	}
}
