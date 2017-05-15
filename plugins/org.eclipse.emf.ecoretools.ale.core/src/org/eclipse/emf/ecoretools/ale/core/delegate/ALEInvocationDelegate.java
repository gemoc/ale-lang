package org.eclipse.emf.ecoretools.ale.core.delegate;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ALEEngine;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecore.InternalEObject;

public class ALEInvocationDelegate implements InvocationDelegate {

	ALEEngine engine;
	Optional<Method> mtd;
	
	public ALEInvocationDelegate(ALEEngine engine, Optional<Method> mtd) {
		this.engine = engine;
		this.mtd = mtd;
	}
	
	@Override
	public Object dynamicInvoke(InternalEObject target, EList<?> arguments) throws InvocationTargetException {
		
		if(mtd.isPresent()) {
			return engine.eval(target, mtd.get(), (List<Object>) arguments);
		}
		
		return null;
	}

}
