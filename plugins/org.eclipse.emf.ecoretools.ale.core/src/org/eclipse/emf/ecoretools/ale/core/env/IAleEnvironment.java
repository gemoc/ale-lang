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
package org.eclipse.emf.ecoretools.ale.core.env;

import java.io.Closeable;
import java.io.File;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Properties;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecoretools.ale.core.env.impl.FileBasedAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.impl.PathsBasedAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.impl.RawEnvironmentBasedAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleInterpreter;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

/**
 * The environment used by ALE's tooling.
 * <p>
 * An environment defines the Ecore models and the ALE source files that are currently available.
 * Editors, interpreters and compilers should rely on one to configure their runtime.
 * 
 * <h2>About paths</h2>
 * 
 * Using an ALE environment requires to deal with raw paths, see for instance:
 * <ul>
 * 	<li>{@link #fromPaths(Collection, Collection)}
 * 	<li>{@link #getBehaviorsSources()}
 * 	<li>{@link #getMetamodelsSources()}
 * </ul>
 * 
 * Those paths are heterogeneous and that's why, for the moment, we use String instances to represent
 * them. At the moment, paths can be:
 * <ul>
 * 	<li>absolute workspace paths ({@code /project/folder/file}
 * 	<li>platform resource URIs ({@code platform:/resources/project/folder/file}
 * </ul>
 */
public interface IAleEnvironment extends AutoCloseable, Closeable {
	
	/**
	 * Creates a new environment which content is loaded from a file.
	 * <p>
	 * This file is typically a .dsl {@link Properties property file}
	 * which contains the following keys:
	 * <ul>
	 * 	<li>{@value FileBasedAleEnvironment#BEHAVIORS_KEY}: paths to ALE source files
	 * 	<li>{@value FileBasedAleEnvironment#METAMODELS_KEY}: paths to Ecore metamodels
	 * </ul>
	 * <p>
	 * <strong>Do not forget to close it to prevent memory leaks</strong>.
	 * 
	 * @param file
	 * 			The .dsl file defining the content of the environment.
	 * 			May not exist.
	 * 
	 * @return a new environment which content is loaded from a .dsl configuration file
	 * 
	 * @see #fromFile(File)
	 */
	static FileBasedAleEnvironment fromFile(IFile file) {
		return new FileBasedAleEnvironment(file);
	}
	
	/**
	 * Creates a new environment which content is loaded from a .dsl configuration file.
	 * <p>
	 * <strong>Do not forget to close it to prevent memory leaks</strong>.
	 * 
	 * @param file
	 * 			The .dsl file defining the content of the environment.
	 * 			May not exist.
	 * 
	 * @return a new environment which content is loaded from a .dsl configuration file
	 * 
	 * @see #fromFile(IFile)
	 */
	static FileBasedAleEnvironment fromFile(File file) {
		return new FileBasedAleEnvironment(file);
	}
	
	/**
	 * Creates a new runtime environment which content is loaded from the given paths.
	 * <p>
	 * <strong>Do not forget to close it to prevent memory leaks</strong>.
	 * 
	 * @param metamodelPaths
	 * 			The paths to the metamodels available in the environment.
	 * @param behaviorPaths
	 * 			The paths to the ALE source files available in the environment.
	 * 
	 * @return a new runtime environment configured from given paths
	 */
	static IAleEnvironment fromPaths(Collection<String> metamodelPaths, Collection<String> behaviorPaths) {
		return new PathsBasedAleEnvironment(metamodelPaths, behaviorPaths);
	}
	
	/**
	 * Creates a new runtime environment which is configured from given raw components.
	 * <p>
	 * <strong>Do not forget to close it to prevent memory leaks</strong>.
	 * 
	 * @param context
	 * 			The AQL context used by the interpreter. {@link #close()} frees the resources it holds.
	 * @param metamodels
	 * 			The packages available in the environment.
	 * @param behaviors
	 * 			The ALE behaviors available in the environment.
	 * 
	 * @return a new runtime environment configured from raw components
	 */
	static IAleEnvironment fromRaw(IQueryEnvironment context, Collection<EPackage> metamodels, Collection<ParsedFile<ModelUnit>> behaviors) {
		return new RawEnvironmentBasedAleEnvironment(context, metamodels, behaviors);
	}
	
	/**
	 * Returns the AQL context used by the {@link #getInterpreter() interpreter}.
	 * @return the AQL context used by the interpreter
	 */
	IQueryEnvironment getContext();
	
	/**
	 * Returns the single interpreter linked to this environment.
	 * <p>
	 * This interpreter has access to every {@link #getMetamodels() static EClass}
	 * and to every {@link #getBehaviors() dynamic behavior} provided by this
	 * environment.
	 * <p>
	 * There can be only one interpreter per environment <i>instance</i>. In other
	 * words, calling this method multiple times will always return the same instance.
	 * However, another environment instance will always return a different interpreter,
	 * even if it is based on the same metamodels and behaviors as this environment.
	 * 
	 * @return the single interpreter linked to this environment
	 */
	IAleInterpreter getInterpreter();
	
	/**
	 * Returns all the metamodels available in this environment.
	 * @return all the metamodels available in this environment
	 */
	List<EPackage> getMetamodels();
	
	/**
	 * Returns all the dynamic behaviors available in this environment.
	 * @return all the dynamic behaviors available in this environment
	 * 
	 * @see #getBehaviors(IQueryEnvironment)
	 */
	IBehaviors getBehaviors();
	
	/**
	 * Returns a path made of all the resources defining some behavior.
	 * <p>
	 * Each resource is separated by a comma.
	 * <p>
	 * Depending on the implementation this method may or may not return
	 * the underlying collection used by this object.
	 * 
	 * @return a comma-separated list of all ALE source files
	 */
	LinkedHashSet<String> getBehaviorsSources();
	
	/**
	 * Returns a path made of all the resources defining an Ecore model.
	 * <p>
	 * Each resource is separated by a comma.
	 * <p>
	 * Depending on the implementation this method may or may not return
	 * the underlying collection used by this object.
	 * 
	 * @return a comma-separated list of all the Ecore model
	 */
	LinkedHashSet<String> getMetamodelsSources();
	
	/**
	 * Loads an Ecore model.
	 * 
	 * @param modelURI
	 * 			The URI identifying the model resource to load.
	 *  
	 * @return the {@link EObject}s defined in the model
	 */
	List<EObject> loadModel(URI modelURI);
	
	/**
	 * Loads an EMF resource.
	 * 
	 * @param resourceURI
	 * 			The URI identifying resource to load.
	 *  
	 * @return the resource identified by given URI
	 */
	Resource loadResource(URI resourceURI);
	
	/**
	 * Releases any resource held by this environment.
	 * <p>
	 * Also closes resources held by the interpreter so that clients
	 * don't have to call {@link IAleInterpreter#close()} explicitly.
	 */
	void close();

}
