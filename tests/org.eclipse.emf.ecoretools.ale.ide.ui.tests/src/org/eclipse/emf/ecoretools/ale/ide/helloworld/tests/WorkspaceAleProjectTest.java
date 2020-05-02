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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ICoreRunnable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.ide.project.impl.AleAware;
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
	public void testCreateAleProjectWithNewEcoreWithRepresentationWithJavaWithDsl() throws CoreException, IOException {
		String projectName = "minifsm";
		
		// GIVEN: the description of a new ALE project
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		WorkspaceAleProject.Description desc = new WorkspaceAleProject.Description(
				false, null,
				projectName, 
				true,
				true,
				true
		);
		
		// WHEN: a 'minifsm' ALE project is created
		
		workspace.run((ICoreRunnable) monitor -> {
				WorkspaceAleProject project = new WorkspaceAleProject(workspace, desc);
				project.create(projectName, Platform.getLocation().append(projectName), new NullProgressMonitor());
			},
			new NullProgressMonitor()
		);
		
		// AND: the workspace is built
		
		ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
		IResourcesSetupUtil.reallyWaitForAutoBuild();
		
		// THEN: a valid ALE project exists
		
		IProject project = workspace.getRoot().getProject(projectName);
		
		assertTrue("The " + projectName + " project should exist", project.exists());
		assertNotNull("The " + projectName + " project should have the Xtext nature " + XtextProjectHelper.NATURE_ID,
					  project.getNature(XtextProjectHelper.NATURE_ID));
		assertNotNull("The " + projectName + " project should have the Java nature " + JavaCore.NATURE_ID,
				  project.getNature(JavaCore.NATURE_ID));
		
		
		IFolder modelFolder = project.getFolder("model");
		assertTrue("model/ should exist", modelFolder.exists());
		assertTrue("model/" + projectName + ".ecore should exist", modelFolder.getFile(projectName + ".ecore").exists());
		assertTrue("model/" + projectName + ".aird should exist", modelFolder.getFile(projectName + ".aird").exists());
		
		IFolder aleSrcFolder = project.getFolder("src-ale");
		assertTrue("src-ale/" + projectName + ".ale should exist", aleSrcFolder.getFile(projectName + ".ale").exists());
		assertEquals("src-ale/" + projectName + ".ale file has the wrong content", "behavior " + projectName + ";", contentOf(aleSrcFolder.getFile(projectName + ".ale")));
		
		EPackage fsm = loadPackage(modelFolder.getFile(projectName + ".ecore"));
		assertEquals("generated FSM EPackage has the wrong name", projectName, fsm.getName());
		assertEquals("generated FSM EPackage has the wrong Ns URI", "http://" + projectName, fsm.getNsURI());
		assertEquals("generated FSM EPackage has the wrong Ns prefix", projectName, fsm.getNsPrefix());
		
		Dsl dsl = new Dsl(project.getFile(projectName + ".dsl").getContents());
		assertTrue(projectName + ".dsl should exist", project.getFile(projectName + ".dsl").exists());
		assertEquals(projectName + ".dsl does not have the right syntax", asList(createURI("platform:/resource/" + projectName + "/model/" + projectName + ".ecore", true)), toURIs(dsl.getMetamodels()));
		assertEquals(projectName + ".dsl does not have the right semantics", asList(createURI("platform:/resource/" + projectName + "/src-ale/" + projectName + ".ale", true)), toURIs(dsl.getBehaviors()));

		IAleEnvironment aleEnv = new AleAware(project).getEnvironment();
		assertEquals(projectName + ".dsl does not have the right syntax", asList(createURI("platform:/resource/" + projectName + "/model/" + projectName + ".ecore", true)), toURIs(aleEnv.getMetamodels()));
		
		// FIXME Currently #Normalized turns these paths into System-absolute paths; looks odd 
//		assertEquals(projectName + ".dsl does not have the right semantics", asList(createURI("platform:/resource/" + projectName + "/src-ale/" + projectName + ".ale", true)), toURIs(aleEnv.getBehaviors()));
	}

	@Test
	public void testCreateAleProjectWithNewEcoreWithoutRepresentationWithoutJavaWithoutDsl() throws CoreException, IOException {
		String projectName = "robotfactory";
		
		// GIVEN: the description of a new ALE project
		
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		WorkspaceAleProject.Description desc = new WorkspaceAleProject.Description(
				false, null,
				projectName, 
				false,
				false,
				false
		);
		
		// WHEN: a 'robotfactory' ALE project is created
		
		workspace.run((ICoreRunnable) monitor -> {
				WorkspaceAleProject project = new WorkspaceAleProject(workspace, desc);
				project.create(projectName, Platform.getLocation().append(projectName), new NullProgressMonitor());
			},
			new NullProgressMonitor()
		);
		
		// AND: the workspace is built
		
		ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
		IResourcesSetupUtil.reallyWaitForAutoBuild();
		
		// THEN: a valid ALE project exists
		
		IProject project = workspace.getRoot().getProject(projectName);
		
		assertTrue("The " + projectName + " project should exist", project.exists());
		assertNotNull("The " + projectName + " project should have the Xtext nature " + XtextProjectHelper.NATURE_ID,
					  project.getNature(XtextProjectHelper.NATURE_ID));
		assertNull("The " + projectName + " project shouldn't have the Java nature " + JavaCore.NATURE_ID,
				  project.getNature(JavaCore.NATURE_ID));
		
		
		IFolder modelFolder = project.getFolder("model");
		assertTrue("model/ should exist", modelFolder.exists());
		assertTrue("model/" + projectName + ".ecore should exist", modelFolder.getFile(projectName + ".ecore").exists());
		assertFalse("model/" + projectName + ".aird shouldn't exist", modelFolder.getFile(projectName + ".aird").exists());
		
		IFolder aleSrcFolder = project.getFolder("src-ale");
		assertTrue("src-ale/" + projectName + ".ale should exist", aleSrcFolder.getFile(projectName + ".ale").exists());
		assertEquals("src-ale/" + projectName + ".ale file has the wrong content", "behavior " + projectName + ";", contentOf(aleSrcFolder.getFile(projectName + ".ale")));
		
		EPackage fsm = loadPackage(modelFolder.getFile(projectName + ".ecore"));
		assertEquals("generated FSM EPackage has the wrong name", projectName, fsm.getName());
		assertEquals("generated FSM EPackage has the wrong Ns URI", "http://" + projectName, fsm.getNsURI());
		assertEquals("generated FSM EPackage has the wrong Ns prefix", projectName, fsm.getNsPrefix());
		
		assertFalse(projectName + ".dsl shouldn't exist", project.getFile(projectName + ".dsl").exists());
		IAleEnvironment aleEnv = new AleAware(project).getEnvironment();
		assertEquals(projectName + ".dsl does not have the right syntax", asList(createURI("platform:/resource/" + projectName + "/model/" + projectName + ".ecore", true)), toURIs(aleEnv.getMetamodels()));
//		assertEquals(projectName + ".dsl does not have the right semantics", asList(createURI("platform:/resource/" + projectName + "/src-ale/" + projectName + ".ale", true)), toURIs(aleEnv.getBehaviors()));
	}
	
	private static List<URI> toURIs(Collection<String> uris) {
		return uris.stream()
				   .map(URI::createURI)
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
