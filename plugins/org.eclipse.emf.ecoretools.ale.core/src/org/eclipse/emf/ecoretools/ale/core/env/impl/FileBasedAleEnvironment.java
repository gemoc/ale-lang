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
package org.eclipse.emf.ecoretools.ale.core.env.impl;

import static java.lang.String.join;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static org.eclipse.emf.ecoretools.ale.core.io.IOResources.toFile;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashSet;
import java.util.List;
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
			try (FileOutputStream output = new FileOutputStream(platformFile)) {
				newProperties.store(output, "");
			}
		}
	}
	
	private void load(InputStream input) throws IOException {
		try {
			Properties properties = new Properties();
			properties.load(input);
			
			String allMetamodels = (String) properties.get(METAMODELS_KEY);
			String allBehaviors = (String) properties.get(BEHAVIORS_KEY);
			
			if (allMetamodels != null) {
				String[] rawMetamodels = allMetamodels.split(",");
				this.metamodels.addAll(trim(rawMetamodels));
			}
			if (allBehaviors!= null) {
				String[] rawBehaviors = allBehaviors.split(",");
				this.behaviors.addAll(trim(rawBehaviors));
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
		ByteArrayOutputStream writableProperties = new ByteArrayOutputStream(100);
		newProperties.store(writableProperties, "");
		
		InputStream readableProperties = new ByteArrayInputStream(writableProperties.toByteArray());
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
