/*******************************************************************************
 * Copyright (c) 2020 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.parser;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.osgi.framework.Bundle;

// TODO [Refactor] Can this be merged with IOResources?
public class IOUtils {
	
	private IOUtils() {
		// utility classes should not be instantiated
	}
    
    static List<String> toAbsolutePaths(Collection<String> behaviors) {
    	List<String> absolutePaths = new ArrayList<>();
    	
    	for (String behavior : behaviors) {
    		try {
    			URI behaviorURI = URI.createFileURI(convertToFile(behavior));
    			absolutePaths.add(behaviorURI.toFileString());
    		} 
    		catch (IllegalArgumentException e) {
    			// URI is ill-formatted, skip it
    		}
    		catch (NullPointerException e) {
    			// The file doesn't exist, skip it
    		}
		}
    	return absolutePaths;
    }
	
	/**
	 * Convert platform URI to file path
	 */
	public static String convertToFile(String platformUriString) {
		URI uri = URI.createURI(platformUriString);
		
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
			res = platformUriString;
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
			return  pluginFilePath + path.substring(1);
		} catch (IOException e) {
			// FIXME [API] Should throw
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
