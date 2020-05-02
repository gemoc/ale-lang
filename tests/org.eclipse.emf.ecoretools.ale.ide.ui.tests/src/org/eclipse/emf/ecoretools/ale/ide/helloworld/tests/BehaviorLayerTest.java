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

import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellIsActive;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Optional;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.ide.ui.services.Services;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.modelingproject.AbstractRepresentationsFileJob;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.EdgeStyle;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DEdgeSpec;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DNodeListElementSpec;
import org.eclipse.sirius.viewpoint.BasicLabelStyle;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * This class test that adding a new reference in the .ale file lead to the creation of a graphical edge in the .aird
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class BehaviorLayerTest {

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
	    Display.getDefault().syncExec(() -> {
            try {
            	IWorkbench workbench = PlatformUI.getWorkbench();
            	workbench.showPerspective("org.eclipse.sirius.ui.tools.perspective.modeling", workbench.getActiveWorkbenchWindow());
            	workbench.getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.ui.console.ConsoleView");
			} catch (WorkbenchException e) {
				e.printStackTrace();
			}
	    });
	    
	    //Open HelloWorld diagram
		bot.menu("File").menu("New").menu("Example...").click();
		bot.waitUntil(shellIsActive("New Example"));
		bot.tree().getTreeItem("EcoreTools ALE Examples").getNode("Hello world!").select();
		bot.button("Next >").click();
		bot.button("Finish").click();
		
		ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.INCREMENTAL_BUILD, new NullProgressMonitor());
		IResourcesSetupUtil.reallyWaitForAutoBuild();
		
		bot.viewByTitle("Model Explorer").show();
		bot.tree().getTreeItem("helloworld").expand();
		bot.tree().getTreeItem("helloworld").getNode("model").expand();
		bot.tree().getTreeItem("helloworld").getNode("model").getNode("helloworld.aird").doubleClick();
		bot.tree().getTreeItem("helloworld").getNode("model").getNode("helloworld.aird").expand();
		
		Job.getJobManager().join(AbstractRepresentationsFileJob.FAMILY, new NullProgressMonitor()); // Wait loading models
		
		bot.tree().getTreeItem("helloworld").getNode("model").getNode("helloworld.aird").getNode("Representations per category").expand();
		bot.tree().getTreeItem("helloworld").getNode("model").getNode("helloworld.aird").getNode("Representations per category").getNode("Design").expand();
		bot.tree().getTreeItem("helloworld").getNode("model").getNode("helloworld.aird").getNode("Representations per category").getNode("Design").getNode("Entities in a Class Diagram").expand();
		bot.tree().getTreeItem("helloworld").getNode("model").getNode("helloworld.aird").getNode("Representations per category").getNode("Design").getNode("Entities in a Class Diagram").getNode("helloworld class diagram").doubleClick();
		bot.editorByTitle("helloworld class diagram").show();
		bot.toolbarDropDownButtonWithTooltip("Layers").menuItem("Behavior").click();
		
	}
	
	@Before
	public void setUp() throws Exception {
		
		UIThreadRunnable.syncExec(() ->
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().forceActive()
		);
		
		assertNoMarkers();
	}
	
	@Test
	@Ignore // Fails as of PR #115 and I can't make it work again
	public void testCreateReference() throws Exception {
		
		Session session = SessionManager.INSTANCE.getSessions().iterator().next();
		EPackage pkg = (EPackage) session.getSemanticResources().iterator().next().getContents().get(0);
		EClass cls = (EClass) pkg.getEClassifiers().get(0);
		
		Display.getDefault().asyncExec(() -> {
            try {
            	(new Services()).addDynamicFeature(cls,"newRef",cls.getName());
	        } catch (Exception e) {
				e.printStackTrace();
	        }
	    });
		
		bot.editorByTitle("helloworld class diagram").show();
		
		Collection<DRepresentation> rep = DialectManager.INSTANCE.getRepresentations(session.getSemanticResources().iterator().next().getContents().get(0), session);
		session.getTransactionalEditingDomain().getCommandStack()
			   .execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
				   @Override
				   protected void doExecute() {
					   rep.forEach(repr -> DialectManager.INSTANCE.refresh(repr, new NullProgressMonitor()));
				   }
			   });
		EList<DRepresentationElement> diagramElements = rep.iterator().next().getRepresentationElements();
		Optional<DEdgeSpec> edge = diagramElements.stream().filter(elem -> elem instanceof DEdgeSpec).map(elem -> (DEdgeSpec) elem).findFirst();

		assertTrue(edge.isPresent());
		assertEquals("newRef",edge.get().getName());
		assertEquals(3, (int) ((EdgeStyle) edge.get().getStyle()).getSize());
		assertEquals(cls.getName(), ((DRepresentationElement)edge.get().basicGetSourceNode()).getName());
		assertEquals(cls.getName(), ((DRepresentationElement)edge.get().basicGetTargetNode()).getName());
		
	}
	
	@Test
	public void testCreateAttribute() throws Exception {
		
		Session session = SessionManager.INSTANCE.getSessions().iterator().next();
		EPackage pkg = (EPackage) session.getSemanticResources().iterator().next().getContents().get(0);
		EClass cls = (EClass) pkg.getEClassifiers().get(0);
		
		Display.getDefault().asyncExec(() -> {
            try {
            	new Services().addDynamicFeature(cls);
	        } catch (Exception e) {
				e.printStackTrace();
	        }
	    });
		
		bot.editorByTitle("helloworld class diagram").show();
		
		Collection<DRepresentation> rep = DialectManager.INSTANCE.getRepresentations(session.getSemanticResources().iterator().next().getContents().get(0), session);
		
		session.getTransactionalEditingDomain().getCommandStack()
			   .execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
				   @Override
				   protected void doExecute() {
					   rep.forEach(repr -> DialectManager.INSTANCE.refresh(repr, new NullProgressMonitor()));
				   }
			   });
		EList<DRepresentationElement> diagramElements = rep.iterator().next().getRepresentationElements();
		Optional<DNodeListElementSpec> attribute = 
				diagramElements
				.stream()
				.filter(elem -> elem instanceof DNodeListElementSpec)
				.map(elem -> (DNodeListElementSpec) elem)
				.filter(elem -> elem.getName().contentEquals("newFeature : EInt"))
				.findFirst();
		
		assertTrue(attribute.isPresent());
		assertEquals("bold",((BasicLabelStyle)attribute.get().getStyle()).getLabelFormat().get(0).getLiteral());
	}
	
	@Test
	public void testCreateOperation() throws Exception {
		
		Session session = SessionManager.INSTANCE.getSessions().iterator().next();
		EPackage pkg = (EPackage) session.getSemanticResources().iterator().next().getContents().get(0);
		EClass cls = (EClass) pkg.getEClassifiers().get(0);
		
		Display.getDefault().asyncExec(() -> {
            try {
            	new Services().addMethod(cls);
	        } catch (Exception e) {
				e.printStackTrace();
	        }
	    });
		
		bot.editorByTitle("helloworld class diagram").show();
		
		Collection<DRepresentation> rep = DialectManager.INSTANCE.getRepresentations(session.getSemanticResources().iterator().next().getContents().get(0), session);
		session.getTransactionalEditingDomain().getCommandStack()
			   .execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
				   @Override
				   protected void doExecute() {
					   rep.forEach(repr -> DialectManager.INSTANCE.refresh(repr, new NullProgressMonitor()));
				   }
			   });
		EList<DRepresentationElement> diagramElements = rep.iterator().next().getRepresentationElements();
		Optional<DNodeListElementSpec> operation = 
				diagramElements
				.stream()
				.filter(elem -> elem instanceof DNodeListElementSpec)
				.map(elem -> (DNodeListElementSpec) elem)
				.filter(elem -> elem.getName().contentEquals("newMethod() : EInt"))
				.findFirst();
		
		assertTrue(operation.isPresent());
		assertEquals("bold",((BasicLabelStyle)operation.get().getStyle()).getLabelFormat().get(0).getLiteral());
	}
	
	@Test
	public void testImplementOperation() throws Exception {
		Session session = SessionManager.INSTANCE.getSessions().iterator().next();
		EPackage pkg = (EPackage) session.getSemanticResources().iterator().next().getContents().get(0);
		EClass cls = (EClass) pkg.getEClassifiers().get(0);
		EOperation op = cls.getEOperations().get(0);
        
		Display.getDefault().asyncExec(() -> {
            try {
            	new Services().editImplementation(op);
	        } catch (Exception e) {
				e.printStackTrace();
	        }
	    });
		
		bot.editorByTitle("helloworld class diagram").show();
		
		Collection<DRepresentation> rep = DialectManager.INSTANCE.getRepresentations(session.getSemanticResources().iterator().next().getContents().get(0), session);
		EList<DRepresentationElement> diagramElements = rep.iterator().next().getRepresentationElements();
		Optional<DNodeListElementSpec> operation = 
				diagramElements
				.stream()
				.filter(elem -> elem instanceof DNodeListElementSpec)
				.map(elem -> (DNodeListElementSpec) elem)
				.filter(elem -> elem.getName().contentEquals("greeting() : EString"))
				.findFirst();
		
		assertTrue("The \"greeting() : EString\" operation should be shown in the diagram", operation.isPresent());
		assertEquals("The greeting() operation should be displayed in a bold font",
					 "bold", ((BasicLabelStyle)operation.get().getStyle()).getLabelFormat().get(0).getLiteral());
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
