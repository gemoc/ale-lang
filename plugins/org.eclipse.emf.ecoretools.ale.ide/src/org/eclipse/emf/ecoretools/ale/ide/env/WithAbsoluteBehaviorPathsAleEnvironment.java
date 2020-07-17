/*******************************************************************************
 * Copyright (c) 2017, 2020 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.ide.env;

import static java.util.stream.Collectors.toList;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.impl.AbstractAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.IOUtils;

/**
 * Decorates an {@link IAleEnvironment ALE environment} and normalizes its URIs
 * to improve compatibility with other tools.
 * <p>
 * This decorator should be used every time the environment contains workspace-relative
 * or platform-specific paths. 
 * <p>
 * Specifically, this decorator converts <strong>{@link #getBehaviorsSources() behaviors}' URIs</strong>
 * from platform-specific URIs ({@code platform:/}) to more a more generic scheme ({@code file:/}).
 * <p>
 * Below is a typical use of this decorator:
 * <pre>IAleEnvironment dslFile = new Normalized(new DslConfiguration(path));</pre>  
 */
public class WithAbsoluteBehaviorPathsAleEnvironment extends AbstractAleEnvironment {
	
	private final LinkedHashSet<String> metamodels;
	
	private final LinkedHashSet<String> behaviors;
	
	public WithAbsoluteBehaviorPathsAleEnvironment(IAleEnvironment environment) {
		metamodels = new LinkedHashSet<>(environment.getMetamodelsSources());
		behaviors = new LinkedHashSet<>(resolveUris(environment.getBehaviorsSources()));
	}
	
	@Override
	public LinkedHashSet<String> getBehaviorsSources() {
		return behaviors;
	}
	
	@Override
	public LinkedHashSet<String> getMetamodelsSources() {
		return metamodels;
	}
	
	private static Collection<String> resolveUris(Collection<String> uris) {
		return uris.stream()
				   .map(uri -> URI.createFileURI(IOUtils.convertToFile(uri)).toFileString())
				   .filter(Objects::nonNull)
				   .collect(toList());
	}
	
	
}
