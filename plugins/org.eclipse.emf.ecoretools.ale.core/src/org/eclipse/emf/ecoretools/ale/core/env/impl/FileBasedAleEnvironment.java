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
package org.eclipse.emf.ecoretools.ale.core.env.impl;

import static java.lang.String.join;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.eclipse.emf.ecoretools.ale.core.io.IOResources.toFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.io.IOResources;

/**
 * An {@link IAleEnvironment ALE environment} that is defined as
 * a {@link Properties property file}.
 * <p>
 * This class is not supposed to be instantiated by clients, call 
 * {@link IAleEnvironment#fromFile(File)}
 * instead.
 */
// TODO [API] Should provide a load() method instead of loading
//		      the .dsl file in the constructor
public final class FileBasedAleEnvironment extends AbstractAleEnvironment {
	
	public static final String BEHAVIORS_KEY = "ale";
	public static final String METAMODELS_KEY = "ecore";
	
	private File platformFile;
	private IFile workspaceFile;
	
	private LinkedHashSet<String> metamodels = new LinkedHashSet<>();
	private LinkedHashSet<String> behaviors = new LinkedHashSet<>();
	private Map<String, String> properties = new HashMap<>();
	
	/**
	 * Creates a new environment from a .dsl file.
	 * 
	 * @param dslFile
	 * 			The .dsl file defining the content of the environment.
	 * 			May not exist.
	 */
	public FileBasedAleEnvironment(IFile dslFile) {
		load(dslFile);
		this.workspaceFile = dslFile;
		this.platformFile = toFile(workspaceFile).orElse(null);
	}
	
	
	/**
	 * Creates a new environment from a .dsl file.
	 * 
	 * @param dslFile
	 * 			The .dsl file defining the content of the environment.
	 * 			May not exist.
	 */
	public FileBasedAleEnvironment(File dslFile) {
		this.platformFile = dslFile;
		Set<IFile> ifiles = IOResources.toIFiles(dslFile);
		this.workspaceFile = ifiles.isEmpty() ? null : ifiles.iterator().next();
		try {
			load(new FileInputStream(dslFile));
		} 
		catch (IOException e) {
			// the file cannot be read, nevermind
		}
	}

	/**
	 * Creates a new environment from a .dsl file.
	 * <p>
	 * <strong>Closes given stream</strong>.
	 * 
	 * @param input
	 * 			The content of the .dsl file.
	 * 
	 * @throws IOException an IO error occurs 
	 */
	public FileBasedAleEnvironment(InputStream input) throws IOException {
		load(input);
	}
	
	private void load(IFile file) {
		try {
			load(file.getContents());
		}
		catch (IOException | CoreException e) {
			// the file does not exist, nevermind
		}
	}
	
	@Override
	public Optional<String> findSourceFileName() {
		if (this.platformFile != null) {
			return Optional.ofNullable(platformFile.getName());
		}
		if (this.workspaceFile != null) {
			return Optional.ofNullable(workspaceFile.getName());
		}
		return Optional.empty();
	}
	
	@Override
	public Optional<String> findProperty(String property) {
		return Optional.ofNullable(properties.getOrDefault(property, null));
	}


	@Override
	public LinkedHashSet<String> getBehaviorsSources() {
		return behaviors;
	}
	
	@Override
	public LinkedHashSet<String> getMetamodelsSources() {
		return metamodels;
	}
	
	/**
	 * Persists given environment as a .dsl file.
	 * <p>
	 * The exact path is the one given to the constructor.
	 * <p>
	 * If the file is located in the workspace then Eclipse's resources
	 * API is used.
	 * 
	 * @param environment
	 * 			The environment to persist
	 * 
	 * @throws IOException if the environment cannot be saved
	 */
	public void save(IAleEnvironment environment) throws IOException {
		Properties newProperties = new Properties();
		newProperties.put(METAMODELS_KEY, join(",", environment.getMetamodelsSources()));
		newProperties.put(BEHAVIORS_KEY, join(",", environment.getBehaviorsSources()));
		
		if (workspaceFile != null) {
			// Preferred because relies on Eclipse's resources API
			// and is thus better integrated with the IDE
			write(workspaceFile, newProperties);
		}
		else if (platformFile != null) {
			StringBuilder sb = new  StringBuilder();
			sb.append("#\n");
			for(Entry<Object, Object> entry : newProperties.entrySet()) {
				sb.append(entry.getKey() + " = " +entry.getValue()+"\n");
			}
			Files.write(platformFile.toPath(), sb.toString().getBytes());
		}
	}
	
	private void load(InputStream input) throws IOException {
		try {
			// Use Java's Properties API to load the file
			
			Properties fileProperties = new Properties();
			fileProperties.load(input);
			
			// Extract paths to Ecore metamodels and ALE source files
			
			String allMetamodels = (String) fileProperties.get(METAMODELS_KEY);
			String allBehaviors = (String) fileProperties.get(BEHAVIORS_KEY);
			
			if (allMetamodels != null) {
				String[] rawMetamodels = allMetamodels.split(",");
				this.metamodels.addAll(trim(rawMetamodels));
			}
			if (allBehaviors!= null) {
				String[] rawBehaviors = allBehaviors.split(",");
				this.behaviors.addAll(trim(rawBehaviors));
			}
			
			// Keep track of all defined properties (key/value pairs in the file)
			
			for(String property : fileProperties.stringPropertyNames()) {
				this.properties.put(property, fileProperties.getProperty(property));
			}
		} 
		finally {
			input.close();
		}
	}

	/**
	 * Writes the given properties to {@link #workspaceFile}.
	 * <p>
	 * Not implemented in the most efficient way because implies several
	 * copies of the data, but since properties are small and not saved 
	 * often this is enough for now.
	 * 
	 * @param newProperties
	 * 			The properties to save
	 * 
	 * @throws IOException if the properties cannot be saved
	 */
	private static void write(IFile workspaceFile, Properties newProperties) throws IOException {
		StringBuilder sb = new  StringBuilder();
		sb.append("#\n");
		for(Entry<Object, Object> entry : newProperties.entrySet()) {
			sb.append(entry.getKey() + " = " +entry.getValue()+"\n");
		}
		
		InputStream readableProperties = new ByteArrayInputStream(sb.toString().getBytes());
		try {
			if (! workspaceFile.exists()) {
				workspaceFile.create(readableProperties, false, new NullProgressMonitor());
			}
			else {
				workspaceFile.setContents(readableProperties, IResource.KEEP_HISTORY, new NullProgressMonitor());
			}
		} 
		catch (CoreException e) {
			throw new IOException(e.getMessage(), e);
		}
	}
	
	private static List<String> trim(String[] uris) {
		return stream(uris)
				.map(String::trim)
				.collect(toList());
	}
	
}
