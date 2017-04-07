package org.eclipse.emf.ecoretools.ale.core.interpreter.services;

import org.eclipse.acceleo.query.runtime.CrossReferenceProvider;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IRootEObjectProvider;
import org.eclipse.acceleo.query.services.EObjectServices;

public class DynamicEObjectServices extends EObjectServices{

	public DynamicEObjectServices(IReadOnlyQueryEnvironment queryEnvironment, CrossReferenceProvider crossReferencer,
			IRootEObjectProvider rootProvider) {
		super(queryEnvironment, crossReferencer, rootProvider);
	}

}
