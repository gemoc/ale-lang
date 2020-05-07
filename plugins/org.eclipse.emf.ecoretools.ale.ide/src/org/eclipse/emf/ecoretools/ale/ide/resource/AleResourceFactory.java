/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.ide.resource;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecoretools.ale.core.parser.BehaviorsParser;

public class AleResourceFactory implements Resource.Factory{
	
	protected IQueryEnvironment qryEnv;
	ResourceSet rs;

	public AleResourceFactory(IQueryEnvironment qryEnv, ResourceSet rs) {
		this.qryEnv = qryEnv;
		this.rs = rs;
	}

	@Override
	public Resource createResource(URI uri) {
		return new AleResource(uri,new BehaviorsParser(qryEnv,rs));
	}
}
