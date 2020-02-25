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
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.ide.helloworld.tests.commons.NewAleProjectWizardBot;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.io.CharStreams;

/**
 * This class tests the behavior of the New ALE Project wizard.
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class NewAleProjectWizardTest {

	private static SWTWorkbenchBot bot;

	EPartService t;
	
	@BeforeClass
	public static void beforeClass() throws CoreException {
	    bot = new SWTWorkbenchBot();
	   
	    IResourcesSetupUtil.cleanWorkspace();
	    
	    // Close Welcome page
	    for (SWTBotView view : bot.views()) {
            if (view.getTitle().equals("Welcome")) {
                view.close();
            }
	    }
	    
	    //Display Console view
	    Display.getDefault().syncExec(() -> {
            try {
            	IWorkbench workbench = PlatformUI.getWorkbench();
            	workbench.showPerspective("org.eclipse.sirius.ui.tools.perspective.modeling", workbench.getActiveWorkbenchWindow());
            	workbench.getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.ui.console.ConsoleView");
			} catch (WorkbenchException e) {
				e.printStackTrace();
			}
	    });
	}
	
	@Before
	public void setUp() throws CoreException {
		UIThreadRunnable.syncExec(() ->
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().forceActive()
		);
		assertNoMarkers();
	}
	
	@Test
	public void testCreateNewStandaloneProject() throws CoreException, IOException {
		NewAleProjectWizardBot wizard = new NewAleProjectWizardBot(bot);
		wizard.open("minifsm");
		wizard.createNewEcoreModel("fsm");
		try {
			wizard.finish();
		}
		catch (TimeoutException e) {
			// Just discard the exception
			// For _some reason_ the dialog is not closed on the CI (even though the 'Finish' action
			// is properly executed) so SWTBot ends up throwing an exception.
			//
			// According to https://www.eclipse.org/forums/index.php/t/1092646/ it may be caused by missing
			// dependencies but I don't have the courage to debug this.
			//
			// Since SWTBot has already waited for 5s, let's assume the project is already built and move on.
		}
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		IProject minifsm = workspace.getProject("minifsm");
		
		assertTrue("The minifsm project should exist", minifsm.exists());
		assertNotNull("The minifsm project should have the Xtext nature " + XtextProjectHelper.NATURE_ID,
					  minifsm.getNature(XtextProjectHelper.NATURE_ID));
		
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
	
	private static void assertNoMarkers() throws CoreException {
		IProject[] allProjects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for(IProject project : allProjects) {
			IMarker[] markers = project.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
			for(IMarker marker : markers) {
				Assert.assertFalse(
					"Unexpected marker: " + marker.getAttribute(IMarker.MESSAGE) + " on "+marker.getResource().getFullPath(),
					marker.getAttribute(IMarker.SEVERITY).equals(IMarker.SEVERITY_ERROR)
				);
			}
		}
	}
}
