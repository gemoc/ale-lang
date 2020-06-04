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
package org.eclipse.emf.ecoretools.ale.ide.helloworld.tests;

import static org.eclipse.swtbot.swt.finder.SWTBotAssert.assertTextContains;
import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellIsActive;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.matchers.WidgetMatcherFactory;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotStyledText;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * This class tests that HelloWorld is available in the Examples Wizard and that is running as expected 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class HelloworldTest {

	private static SWTWorkbenchBot bot;

	EPartService t;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
		
	    bot = new SWTWorkbenchBot();
	   
	    IResourcesSetupUtil.cleanWorkspace();
	    
	    //Close Welcome page
	    for (SWTBotView view : bot.views()) {
            if (view.getTitle().equals("Welcome")) {
                view.close();
            }
	    }
	    
	    //Display Console view
	    Display.getDefault().asyncExec(() -> {
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
	public void setUp() throws Exception {
		UIThreadRunnable.syncExec(() -> 
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().forceActive()
		);
	}
	
	@Test
	public void testHelloworld() throws Exception {
		bot.menu("File").menu("New").menu("Example...").click();
		bot.waitUntil(shellIsActive("New Example"));
		bot.tree().getTreeItem("EcoreTools ALE Examples").getNode("Hello world!").select();
		bot.button("Next >").click();
		bot.button("Finish").click();
		
		ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
		IResourcesSetupUtil.reallyWaitForAutoBuild();
		
		assertNull(ResourcesPlugin.getWorkspace().getRoot().findMember("helloworld/helloworld.dsl"));
		assertNotNull(ResourcesPlugin.getWorkspace().getRoot().findMember("helloworld/src-ale/helloworld.ale"));
		assertNotNull(ResourcesPlugin.getWorkspace().getRoot().findMember("helloworld/model/HelloWorld.xmi"));
		assertNotNull(ResourcesPlugin.getWorkspace().getRoot().findMember("helloworld/model/helloworld.aird"));
		assertNotNull(ResourcesPlugin.getWorkspace().getRoot().findMember("helloworld/model/helloworld.ecore"));
		
		bot.tree().getTreeItem("helloworld").expand();
		bot.tree().getTreeItem("helloworld").getNode("src-ale").expand();
		bot.tree().getTreeItem("helloworld").getNode("src-ale").getNode("helloworld.ale").doubleClick();
		bot.editorByTitle("helloworld.ale").show();
		
		assertNoMarkers();
		
		bot.viewByTitle("Model Explorer").show();
		bot.tree().getTreeItem("helloworld")
				  .contextMenu("Run As")
				  .menu("1 ALE Application")
				  .click();
		bot.waitUntil(shellIsActive("Select the model to execute"));
		bot.button("OK").click();
		
		Thread.sleep(5000);
		
		SWTBotView view = bot.viewById("org.eclipse.ui.console.ConsoleView");
		Widget consoleViewComposite = view.getWidget();
		StyledText console = bot.widget(WidgetMatcherFactory.widgetOfType(StyledText.class), consoleViewComposite);
		SWTBotStyledText styledText = new SWTBotStyledText(console);
		assertTextContains("Hello world!\n", styledText);
	}
	
	private void assertNoMarkers() throws CoreException {
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
