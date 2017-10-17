package org.eclipse.emf.ecoretools.ale.ide.helloworld.tests;

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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.ide.services.Services;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.modelingproject.AbstractRepresentationsFileJob;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DEdgeSpec;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DRepresentationElement;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.results.VoidResult;
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
 * This class test that adding a new reference in the .ale file lead to the creation of a graphical edge in the .aird
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class BehaviorLayerTest {

	private static SWTWorkbenchBot bot;

	EPartService t;
	
	@BeforeClass
	public static void beforeClass() throws Exception {
	    bot = new SWTWorkbenchBot();
	   
	    //Close Welcome page
	    for (SWTBotView view : bot.views()) {
            if (view.getTitle().equals("Welcome")) {
                view.close();
            }
	    }
	    
	    //Display Console view
	    Display.getDefault().asyncExec(new Runnable() {
	        @Override
	        public void run() {
	            try {
	            	IWorkbench workbench = PlatformUI.getWorkbench();
	            	workbench.showPerspective("org.eclipse.sirius.ui.tools.perspective.modeling", workbench.getActiveWorkbenchWindow());
	            	workbench.getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.ui.console.ConsoleView");
				} catch (WorkbenchException e) {
					e.printStackTrace();
				}
	        }
	    });
	}
	
	@Before
	public void setUp() throws Exception {
		UIThreadRunnable.syncExec(new VoidResult() {
			public void run() {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell().forceActive();
			}
		});
	}
	
	@Test
	public void testCreateReference() throws Exception {
		bot.menu("File").menu("New").menu("Example...").click();
		bot.tree().getTreeItem("ALE Examples").getNode("Hello world!").select();
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
		
		assertNoMarkers();
		
		//Reopen the class and add a new reference
		Session session = SessionManager.INSTANCE.getSessions().iterator().next();
		EPackage pkg = (EPackage) session.getSemanticResources().iterator().next().getContents().get(0);
		EClass cls = (EClass) pkg.getEClassifiers().get(0);
		
		Display.getDefault().asyncExec(new Runnable() {
	        @Override
	        public void run() {
	            try {
	            	(new Services()).addDynamicFeature(cls,"newRef",cls.getName());
		        } catch (Exception e) {
					e.printStackTrace();
		        }
	        }
	    });
		
		bot.editorByTitle("helloworld class diagram").show();
		
		Collection<DRepresentation> rep = DialectManager.INSTANCE.getRepresentations(session.getSemanticResources().iterator().next().getContents().get(0), session);
		EList<DRepresentationElement> diagramElements = rep.iterator().next().getRepresentationElements();
		Optional<DEdgeSpec> edge = diagramElements.stream().filter(elem -> elem instanceof DEdgeSpec).map(elem -> (DEdgeSpec) elem).findFirst();

		assertTrue(edge.isPresent());
		assertEquals("newRef",edge.get().getName());
		assertEquals(cls.getName(), ((DRepresentationElement)edge.get().basicGetSourceNode()).getName());
		assertEquals(cls.getName(), ((DRepresentationElement)edge.get().basicGetTargetNode()).getName());
		
		System.out.println();
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
