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
package org.eclipse.emf.ecoretools.ale.ide;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleEnvironment;
import org.osgi.framework.Bundle;

/**
 * Decorates an {@link IAleEnvironment ALE environment} and normalizes its URIs
 * to improve compatibility with other tools.
 * <p>
 * This decorator should be used every time the environment contains workspace-relative
 * or platform-specific paths. 
 * <p>
 * Specifically, this decorator converts <strong>{@link #getBehaviors() behaviors}' URIs</strong>
 * from platform-specific URIs ({@code platform:/}) to more a more generic scheme ({@code file:/}).
 * <p>
 * Below is a typical use of this decorator:
 * <pre>IAleEnvironment dslFile = new Normalized(new Dsl(path));</pre>  
 */
public class Normalized implements IAleEnvironment {
	
	private final LinkedHashSet<String> metamodels;
	
	private final LinkedHashSet<String> behaviors;
	
	public Normalized(IAleEnvironment environment) {
		metamodels = new LinkedHashSet<>(environment.getMetamodels());
		behaviors = new LinkedHashSet<>(resolveUris(environment.getBehaviors()));
	}
	
	@Override
	public LinkedHashSet<String> getBehaviors() {
		return behaviors;
	}
	
	@Override
	public LinkedHashSet<String> getMetamodels() {
		return metamodels;
	}
	
	private static Collection<String> resolveUris(Collection<String> uris) {
		return uris.stream()
				   .map(uri -> URI.createFileURI(convertToFile(uri)).toFileString())
				   .filter(Objects::nonNull)
				   .collect(toList());
	}
	
	/**
	 * Convert platform URI to file path
	 */
	public static String convertToFile(String path) {
		URI uri = URI.createURI(path);
		
		String res = null;
		
		if(uri.isPlatformResource()) {
			res = resourceToFile(uri);
			if(res == null) {
				res = pluginToFile(resourceToPlugin(uri));
			}
		}
		else if(uri.isPlatformPlugin()) {
			res = pluginToFile(uri);
		}
		
		if(res == null) {
			res = path;
		}
		
		return res;
	}
	
	private static String resourceToFile(URI uri) {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		if(ws != null) {
			IResource file = ws.getRoot().findMember(uri.toPlatformString(true));
			if(file != null) {
				return file.getLocationURI().getRawPath();
			}
		}
		return null;
	}
	
	private static String pluginToFile(URI uri) {
		String pluginName = uri.segment(1);
		String path = uri.toPlatformString(true).substring(pluginName.length()+1);
		
		Bundle plugin = Platform.getBundle(pluginName);
		URL pluginURL = plugin.getEntry("/");
		
		try {
			String pluginFilePath = FileLocator.toFileURL(pluginURL).getFile();
			return  pluginFilePath.toString() + path.substring(1);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Convert platform:/resource/ to platform:/plugin/
	 */
	private static URI resourceToPlugin(URI uri) {
		return URI.createPlatformPluginURI(uri.toPlatformString(true), true);
	}
}
