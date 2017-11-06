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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.osgi.framework.Bundle;

public class WorkbenchDsl extends Dsl {

	public WorkbenchDsl(List<String> syntaxes, List<String> semantics) {
		super(syntaxes,semantics);
		resolveUris();
	}
	
	public WorkbenchDsl(String dslFile) throws FileNotFoundException {
		super(convertToFile(dslFile));
		resolveUris();
	}
	
	public WorkbenchDsl(InputStream input) {
		super(input);
		resolveUris();
}
	
	private void resolveUris() {
		ArrayList<String> newSemantics = new ArrayList<String>();
		getAllSemantics()
			.stream()
			.forEach(elem -> newSemantics.add(URI.createFileURI(convertToFile(elem)).toFileString()));//expect system file path
		getAllSemantics().clear();
		getAllSemantics().addAll(newSemantics);
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
		return uri.createPlatformPluginURI(uri.toPlatformString(true), true);
	}
}
