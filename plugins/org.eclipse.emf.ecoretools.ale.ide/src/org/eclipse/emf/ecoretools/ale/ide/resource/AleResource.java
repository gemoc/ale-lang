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

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.impl.DslConfiguration;
import org.eclipse.emf.ecoretools.ale.core.parser.BehaviorsParser;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.ide.env.Normalized;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

public class AleResource extends ResourceImpl {
	
	protected BehaviorsParser parser;
	protected List<ParsedFile<ModelUnit>> parseResult;
	
	private boolean isNotifyEnabled = true;
	
	public AleResource(URI uri, BehaviorsParser parser) {
		super(uri);
		this.parser = parser;
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		try (IAleEnvironment dslFile = new Normalized(new DslConfiguration(inputStream))) {
			List<ParsedFile<ModelUnit>> newParseResult = parser.parse(dslFile.getMetamodels(), dslFile.getBehaviorsSources());
			
			if(newParseResult != null) { //TODO: check no parse error
				unload();
				parseResult = newParseResult;
				List<ModelUnit> newContent = parseResult.stream().map(pr -> pr.getRoot()).collect(toList());
				
				isNotifyEnabled = false;
				getContents().addAll(newContent);
				isNotifyEnabled = true;
			}
		}
	}
	
	@Override
	protected void doUnload() {
		super.doUnload();
		//TODO: remove parse result?
	}
	
	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		//FIXME: need a serializer
	}
	
	public List<ParsedFile<ModelUnit>> getParseResult() {
		return parseResult;
	}
	
	@Override
	public boolean eNotificationRequired() {
		if(isNotifyEnabled) {
			return super.eNotificationRequired();
		}
		else {
			return false;
		}
	}
	
	@Override
	public void save(Map<?, ?> options) throws IOException {
		//Do nothing
	}
}
