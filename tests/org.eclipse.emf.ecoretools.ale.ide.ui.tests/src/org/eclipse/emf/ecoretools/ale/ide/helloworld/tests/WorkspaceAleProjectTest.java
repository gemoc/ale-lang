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
package org.eclipse.emf.ecoretools.ale.ide.helloworld.tests;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.eclipse.emf.common.util.URI.createURI;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.ide.ui.project.WorkspaceAleProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.io.CharStreams;

/**
 * Test the behavior of a {@link WorkspaceAleProject}.
 * <p>
 * Ignored because fails on CI.
 */
@Ignore
public class WorkspaceAleProjectTest {
	
	@Test
	public void testCreateNewStandaloneProject() throws CoreException, IOException {
		
		// WHEN: a 'minifsm' ALE project is created
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		WorkspaceAleProject.Description desc = new WorkspaceAleProject.Description(
				false, null,
				"fsm", 
				true,
				true
		);
		WorkspaceAleProject project = new WorkspaceAleProject(workspace, desc);
		project.create("minifsm", workspace.getRoot().getProject("minifsm").getFullPath(), new NullProgressMonitor());

		// AND: the workspace is built
		
		ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
		IResourcesSetupUtil.reallyWaitForAutoBuild();
		
		// THEN: a valid ALE project exists
		
		IProject minifsm = workspace.getRoot().getProject("minifsm");
		
		assertTrue("The minifsm project should exist", minifsm.exists());
		assertNotNull("The minifsm project should have the Xtext nature " + XtextProjectHelper.NATURE_ID,
					  minifsm.getNature(XtextProjectHelper.NATURE_ID));
		assertNotNull("The minifsm project should have the Java nature " + XtextProjectHelper.NATURE_ID,
				  minifsm.getNature(JavaCore.NATURE_ID));
		
		IFolder modelFolder = minifsm.getFolder("model");
		assertTrue("model/ should exist", modelFolder.exists());
		assertTrue("model/minifsm.ecore should exist", modelFolder.getFile("minifsm.ecore").exists());
		assertTrue("model/minifsm.dsl should exist", modelFolder.getFile("minifsm.dsl").exists());
		assertTrue("model/minifsm.aird should exist", modelFolder.getFile("minifsm.aird").exists());
		assertTrue("model/minifsm.ale should exist", modelFolder.getFile("minifsm.ale").exists());
		assertEquals("model/minifsm.ale file has the wrong content", "behavior fsm;", contentOf(modelFolder.getFile("minifsm.ale")));
		
		EPackage fsm = loadPackage(modelFolder.getFile("minifsm.ecore"));
		assertEquals("generated FSM EPackage has the wrong name", "fsm", fsm.getName());
		assertEquals("generated FSM EPackage has the wrong Ns URI", "http://fsm", fsm.getNsURI());
		assertEquals("generated FSM EPackage has the wrong Ns prefix", "fsm", fsm.getNsPrefix());
		
		Dsl dsl = new Dsl(modelFolder.getFile("minifsm.dsl").getContents());
		assertEquals("model/minifsm.dsl does not have the right syntax", asList(createURI("platform:/resource/minifsm/model/minifsm.ecore", true)), toURIs(dsl.getAllSyntaxes()));
		assertEquals("model/minifsm.dsl does not have the right semantics", asList(createURI("platform:/resource/minifsm/model/minifsm.ale", true)), toURIs(dsl.getAllSemantics()));
	}
	
	private static List<URI> toURIs(List<String> uris) {
		return uris.stream()
				   .map(uri -> createURI(uri, true))
				   .collect(toList());
	}
	
	private static EPackage loadPackage(IFile file) {
		ResourceSet resources = new ResourceSetImpl();
		Resource model = resources.getResource(URI.createFileURI(file.getLocation().toString()), true);
		return (EPackage) model.getContents().get(0);
	}
	
	private static String contentOf(IFile file) throws CoreException, IOException {
		InputStream contents = file.getContents();
		try (InputStreamReader reader = new InputStreamReader(contents)) {
			return CharStreams.toString(reader).trim();
		}
	}
	
}
