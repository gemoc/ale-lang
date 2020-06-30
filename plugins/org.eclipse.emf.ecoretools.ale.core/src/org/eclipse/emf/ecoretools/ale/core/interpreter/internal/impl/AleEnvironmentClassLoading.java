/*******************************************************************************
 * Copyright (c) 2020 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation (adapted from https://github.com/gemoc/org.eclipse.sirius/blob/97bb7b9/plugins/org.eclipse.sirius.editor/src-gen/org/eclipse/sirius/editor/utils/WorkspaceClassLoading.java)
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.interpreter.internal.impl;

import static java.util.Arrays.asList;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecoretools.ale.core.Activator;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.sirius.common.tools.api.interpreter.ClassLoading;
import org.eclipse.sirius.common.tools.api.interpreter.ClasspathChangeCallback;
import org.eclipse.sirius.common.tools.api.interpreter.EPackageLoadingCallback.EPackageDeclarationSource;
import org.osgi.framework.Bundle;

/**
 * A {@link ClassLoading} implementation which look for a class in a list of
 * OSGi bundles.
 */
public class AleEnvironmentClassLoading implements ClassLoading {

    private final Map<String, URLClassLoader> projectsToClassLoader = new HashMap<>();

    @Override
    public Class<?> findClass(Set<String> viewpointProjects, Set<String> plugins, String qualifiedName) {
        Class<?> result = null;
        IWorkspaceRoot root = EcorePlugin.getWorkspaceRoot();
        if (root != null) {
            Iterator<String> it = viewpointProjects.iterator();
            while (result == null && it.hasNext()) {
                String projectName = it.next();
                ClassLoader loader = getOrCreateClassLoader(projectName, root);
                if (loader != null) {
                    try {
                        result = loader.loadClass(qualifiedName);
                    } catch (ClassNotFoundException e) {
                        /*
                         * nothing to report,we would not find the class.
                         */
                    } catch (NoClassDefFoundError e) {
                        /*
                         * nothing to report,we would not find the class.
                         */
                    }
                }
            }
        }
        Iterator<String> it = plugins.iterator();
        while (result == null && it.hasNext()) {
            Bundle bnd = Platform.getBundle(it.next());
            if (bnd != null) {
                try {
                    result = bnd.loadClass(qualifiedName);
                } catch (Throwable e) {
                    /*
                     * the class we are searching wasn't there.
                     */
                }
            }
        }
        return result;
    }

    @Override
    public void dispose() {
    	projectsToClassLoader.values().forEach(this::closeClassLoader);
        projectsToClassLoader.clear();
    }

    private void closeClassLoader(URLClassLoader old) {
        try {
        	old.close();
        } 
        catch (IOException e) {
        	Activator.error(e.getMessage(), e);
		}
    }

    @Override
    public void setClasspathChangeCallback(ClasspathChangeCallback listener) {
    	// we don't listen for classpath changes so listener would never be notified
    }

	@Override
	public Collection<EPackageDeclarationSource> findEcoreDeclarations(Set<String> projects, Set<String> plugins) {
		// Available EPackages are loaded from the ALE environment (.dsl file or preferences).
		// Those packages are already registered at this point hence we don't need to discover anything.
		return Collections.emptyList();
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	///    DYNAMIC CLASS LOADING UTILITY FUNCTIONS ////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    private ClassLoader getOrCreateClassLoader(String projectName, IWorkspaceRoot root) {
        URLClassLoader existing = projectsToClassLoader.get(projectName);
        if (existing == null) {
            existing = createClassLoader(projectName, root);
            if (existing != null) {
                projectsToClassLoader.put(projectName, existing);
            }
        }
        return existing;
    }

    private static URLClassLoader createClassLoader(String projectName, IWorkspaceRoot root) {
        IPluginModelBase pluginModel = getBundleForProject(projectName);

        List<URL> urls = new ArrayList<URL>();
        /*
         * declare the URLs for the workspace dependencies
         */
        IResource res = pluginModel.getUnderlyingResource();
        if (res != null) {
            urls = computeURLs(res.getProject());
        }
        
        //
        // /!\ CHANGE FROM THE ORIGINAL FILE
        //
        // I added getClass().getClassLoader() as a parent loader; otherwise ServiceUtils was throwing
        // NoClassDefFoundError on EObject when getting class' methods through reflection.
        //
        // The parent loader makes sure that there can't be two different instances of the same class.
        // I guess that the child loader now has access to the classes known by the parent and can thus
        // resolve EObject; not sure it's the right solution and not a workaround though.
        //
        URLClassLoader loader = new URLClassLoader(urls.toArray(new URL[urls.size()]), AleEnvironmentClassLoading.class.getClassLoader()) {

            @Override
            public Class<?> findClass(String name) throws ClassNotFoundException {
                try {
                    return  super.findClass(name);
                } 
                catch (Throwable e) {
                    // the class we are searching wasn't found in the URLs
                	return null;
                }
            }
        };
        return loader;
    }

    private static IPluginModelBase getBundleForProject(String projectName) {
        for (IPluginModelBase pluginModelBase : asList(PluginRegistry.getWorkspaceModels())) {
        	try {
        		boolean isBundleForProject = pluginModelBase.getBundleDescription().getSymbolicName().equals(projectName);
        		if (isBundleForProject) {
        			return pluginModelBase;
        		}
        	}
        	catch (NullPointerException e) {
        		// the model base doesn't have a description or a symbolic name, just ignore it
        	}
        }
        return null;
    }

	private static List<URL> computeURLs(IProject project) {
    	List<URL> uRLs = new ArrayList<>();
        final IJavaProject javaProject = JavaCore.create(project);
        try {
            for (IClasspathEntry entry : javaProject.getResolvedClasspath(true)) {
                if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
                    final IPath output = entry.getOutputLocation();
                    if (output != null) {
                        IFile reference = ResourcesPlugin.getWorkspace().getRoot().getFile(output);
                        if (reference.exists()) {
                            URL url;
                            try {
                                url = reference.getLocation().toFile().toURI().toURL();
                                uRLs.add(url);
                            } catch (MalformedURLException e) {
                                /*
                                 * We don't know how to handle this class path
                                 * entry.
                                 */
                            }
                        }

                    }
                }
            }
            /*
             * Add the default output location to the classpath anyway since
             * source folders are not required to have their own
             */
            final IPath output = javaProject.getOutputLocation();
            if (output != null) {
                IFolder reference = ResourcesPlugin.getWorkspace().getRoot().getFolder(output);
                if (reference.exists() && reference.getLocation() != null) {
                    File file = reference.getLocation().toFile();
                    try {
                        if (file != null && file.exists()) {
                            uRLs.add(file.toURI().toURL());
                        }
                    } catch (MalformedURLException e) {
                        /*
                         * the given path does not map to a file which can
                         * actually be mapped to an url, ignore it.
                         */
                    }
                }

            }
        } catch (JavaModelException e) {
        }
        return uRLs;
    }
	
}