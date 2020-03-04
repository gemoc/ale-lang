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
package org.eclipse.emf.ecoretools.ale.ide.refactoring;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.ide.Activator;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;

/**
 * A change that updates the paths to ALE resources in a project's .dsl configuration file.
 * <p>
 * This change is supposed to occur <strong>after</strong> that the project has been renamed.
 */
public class RenamePathsInDslFilesChange extends Change {
	
	private final IFile dslFile;
	private final Collection<String> behaviors;
	private final Collection<String> metamodels;

	/**
	 * Creates a new change that updates paths to ALE resources in a project's .dsl configuration file.
	 * 
	 * @param dslFile
	 * 			The .dsl file to update
	 * @param behaviors
	 * 			The new URIs to environment's behaviors 
	 * @param metamodels
	 * 			The new URIs to environment's metamodels 
	 */
	public RenamePathsInDslFilesChange(IFile dslFile, Collection<String> behaviors, Collection<String> metamodels) {
		super();
		this.dslFile = requireNonNull(dslFile, "dslFile");
		this.behaviors = requireNonNull(behaviors, "behaviors");
		this.metamodels = requireNonNull(metamodels, "metamodels");
	}

	@Override
	public String getName() {
		return "Update paths in '" + dslFile.getFullPath() + "'";
	}

	@Override
	public void initializeValidationData(IProgressMonitor pm) {
		// nothing to do
	}

	@Override
	public RefactoringStatus isValid(IProgressMonitor pm) throws CoreException {
		// Actually dslFile.exists() is always false here (and within initialize)
		// so the lines below are not a reliable way to check change's validity
		
//		if (!dslFile.exists()) {
//			return RefactoringStatus.createFatalErrorStatus(dslFile.getFullPath() + " does not exist");
//		}
//		if (dslFile.isReadOnly()) {
//			return RefactoringStatus.createFatalErrorStatus(dslFile.getFullPath() + " is read-only");
//		}
		return RefactoringStatus.create(Status.OK_STATUS);
	}

	@Override
	public Object getModifiedElement() {
		return dslFile;
	}
	
	@Override
	public Object[] getAffectedObjects() {
		return new Object[] { dslFile };
	}

	@Override
	public Change perform(IProgressMonitor monitor) throws CoreException {
		try {
			Dsl dsl = new Dsl(dslFile.getLocation().toOSString());
			
			Collection<String> currentBehaviors = new LinkedHashSet<>(dsl.getBehaviors());
			Collection<String> currentMetamodels = new LinkedHashSet<>(dsl.getMetamodels());
			
			dsl.getBehaviors().clear();
			dsl.getMetamodels().clear();
			
			dsl.getBehaviors().addAll(behaviors);
			dsl.getMetamodels().addAll(metamodels);
			
			dsl.save();
			
			Change undo = new RenamePathsInDslFilesChange(dslFile, currentBehaviors, currentMetamodels);
			return undo;
		}
		catch (Exception e) {
			Activator.warn("Unable to rename paths in " + dslFile.getFullPath(), e);
		}
		finally {
			monitor.done();
		}
		return null;
	}

}
