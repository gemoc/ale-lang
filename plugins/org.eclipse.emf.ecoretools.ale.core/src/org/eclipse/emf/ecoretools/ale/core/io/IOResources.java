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
package org.eclipse.emf.ecoretools.ale.core.io;

import static java.util.Arrays.asList;

import java.io.File;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

/**
 * Utility class to deal with heterogeneous IO resources. 
 * 
 * FIXME [API] Should also provide the methods DslBuilder#toAbsolutePaths
 */
public class IOResources {
	
	private IOResources() {
		// utility class should not be instantiated
	}

	private static IWorkspace workspace;
	static {
		try {
			workspace = ResourcesPlugin.getWorkspace();
		} catch (IllegalStateException e) {
			// Eclipse-less mode
		}
	}
	
	/**
	 * Configures the Eclipse workspace used by this utility class.
	 * <p>
	 * This method is <strong>not supposed to be called by clients</strong>.
	 * 
	 * @param workspace
	 * 			The new workspace to use. May be null.
	 */
	public static void setWorkspace(final IWorkspace workspace) {
		IOResources.workspace = workspace;
	}
	
	public static Optional<File> toFile(URI uri) {
		if (workspace != null) {
			IResource file = workspace.getRoot().findMember(uri.toPlatformString(true));
			if(file != null) {
				String path = file.getLocationURI().getRawPath();
				return Optional.of(new File(path));
			}
		}
		return Optional.empty();
	}
	
	public static Optional<File> toFile(IFile ifile) {
		try {
			File file = new File(ifile.getLocationURI());
			return Optional.of(file);
		}
		catch (NullPointerException e) {
			// the ifile does not exist in the workspace
			// FIXME Should try to infer file's path by concatenating workspace's path and ifile's path
			return Optional.empty();
		}
	}
	
	/** @return the file of the workspace identified by the given URI */
	public static Optional<IFile> toIFile(URI uri) {
		IPath path = new Path(uri.toPlatformString(true));
		IFile ifile = workspace.getRoot().getFile(path);
		return Optional.ofNullable(ifile);
	}
	
	public static IFile toIFile(File file) {
		return FileBuffers.getWorkspaceFileAtLocation(Path.fromOSString(file.getPath()));
	}
	
	/** @return the files of the workspace that correspond to the given file */
	public static Set<IFile> toIFiles(File file) {
		java.net.URI location = file.toURI();
		IFile[] files = ResourcesPlugin.getWorkspace().getRoot()
									   .findFilesForLocationURI(location);
		return new HashSet<>(asList(files));
	}

	/** @return the files of the workspace identified by given URI */
	public static Set<IFile> toIFiles(String uri) {
		try {
			URI behaviorURI = URI.createURI(uri);
			return toFile(behaviorURI).map(IOResources::toIFiles)
									  .orElseGet(HashSet::new);
		}
		catch (NullPointerException e) {
			// FIXME [API] should throw
			// the file identified by the URI does not exist
			return new HashSet<>();
		}
	}
	
	public static URI toPlatformResourceURI(IFile ifile) {
		String pathName = ifile.getFullPath().toPortableString();
		return URI.createPlatformResourceURI(pathName, true);
	}

}
