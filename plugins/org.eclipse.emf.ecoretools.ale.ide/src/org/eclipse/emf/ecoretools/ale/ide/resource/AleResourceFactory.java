package org.eclipse.emf.ecoretools.ale.ide.resource;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;

public class AleResourceFactory implements Resource.Factory{
	
	protected IQueryEnvironment qryEnv;
	ResourceSet rs;

	public AleResourceFactory(IQueryEnvironment qryEnv, ResourceSet rs) {
		this.qryEnv = qryEnv;
		this.rs = rs;
	}

	@Override
	public Resource createResource(URI uri) {
		return new AleResource(uri,new DslBuilder(qryEnv,rs));
	}
}
