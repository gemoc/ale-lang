package org.eclipse.emf.ecoretools.ale.core.interpreter.services;

import org.eclipse.acceleo.query.runtime.IService;

public interface ServiceCallListener {
	
	public void preCall(IService service, Object[] arguments);
	
	public void postCall(IService service, Object[] arguments, Object result);
	
}
