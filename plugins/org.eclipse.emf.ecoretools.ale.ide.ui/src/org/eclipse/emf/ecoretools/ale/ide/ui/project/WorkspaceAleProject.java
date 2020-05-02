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
package org.eclipse.emf.ecoretools.ale.ide.ui.project;

import static java.lang.String.join;
import static java.util.Arrays.asList;
import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;
import static java.util.Objects.requireNonNull;
import static org.eclipse.emf.common.util.URI.createPlatformResourceURI;
import static org.eclipse.emf.ecoretools.ale.core.preferences.AleProjectPreferences.ALE_SOURCE_FILES;
import static org.eclipse.emf.ecoretools.ale.core.preferences.AleProjectPreferences.CONFIGURED_FROM_DSL_FILE;
import static org.eclipse.emf.ecoretools.ale.core.preferences.AleProjectPreferences.DSL_FILE_PATH;
import static org.eclipse.emf.ecoretools.ale.core.preferences.AleProjectPreferences.ECORE_MODEL_FILES;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.IScopeContext;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.impl.RuntimeAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.ide.project.AleProject;
import org.eclipse.emf.ecoretools.ale.ide.project.AleProjectNature;
import org.eclipse.emf.ecoretools.ale.ide.ui.Activator;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.dialect.DialectManager;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.internal.session.SessionTransientAttachment;
import org.eclipse.sirius.business.internal.session.danalysis.SaveSessionJob;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallback;
import org.eclipse.sirius.ui.business.internal.commands.ChangeViewpointSelectionCommand;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.description.RepresentationDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.osgi.service.prefs.BackingStoreException;

/**
 * An {@link IAleProject ALE project} located in the workspace. 
 */
public class WorkspaceAleProject implements AleProject {
	/** 
	 * The workspace containing the project. 
	 */
	private final IWorkspace workspace;
	/**
	 * The description of the project.
	 */
	private final Description description;
	
	/**
	 * Instantiates a new ALE project located in the workspace.
	 * 
	 * @param workspace
	 * 			The workspace containing the project.
	 */
	public WorkspaceAleProject(IWorkspace workspace, Description description) {
		this.workspace = requireNonNull(workspace, "workspace");
		this.description = requireNonNull(description, "description");
	}

	@Override
	public IAleEnvironment getEnvironment() {
		// TODO either check preferences or find .dsl file
		return null;
	}
	
	@Override
	public IProject create(String name, IPath path, IProgressMonitor monitor) throws CoreException {
		IWorkspaceRunnable createProject = projectMonitor -> {
			SubMonitor subMonitor = SubMonitor.convert(projectMonitor, "Creating ALE project", 7);
			try {
				IProject project = createProject(name, path, subMonitor.split(1));
				EPackage epackage = getOrCreateEcoreModel(project, subMonitor.split(1));
				IPath aleFilePath = createAleSourceFile(project, epackage, subMonitor.split(1));
				
				configureAleEnvironment(project, asList(URI.createPlatformResourceURI(epackage.eResource().getURI().toString(), true).toString()), asList(URI.createPlatformResourceURI(aleFilePath.toPortableString(), true).toString()), subMonitor.split(1));
				createRepresentation(project, epackage, subMonitor.split(1));
				addJavaNature(project, subMonitor.split(1));
				
				project.refreshLocal(IResource.DEPTH_INFINITE, subMonitor.split(1));
			} 
			catch (IOException e) {
				throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
			}
			finally {
				monitor.done();
			}
		};
		workspace.run(createProject, monitor);
		return workspace.getRoot().getProject(name);
	}
	
	/**
	 * Creates a new IProject and persists it on disk.
	 */
	private IProject createProject(String name, IPath path, IProgressMonitor monitor) throws CoreException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, "Creating the project...", 3);
		IProject project = workspace.getRoot().getProject(name);
		
		if (project.exists()) {
			throw new CoreException(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "project " + name + " already exists in the workspace"));
		}
		IProjectDescription desc = workspace.newProjectDescription(name);
		desc.setLocation(path);
		desc.setNatureIds(new String[] { XtextProjectHelper.NATURE_ID, AleProjectNature.ID });
		
		subMonitor.subTask("Creating the project " + name + "...");
		project.create(desc, subMonitor.split(1));
		
		subMonitor.subTask("Opening the project " + name + "...");
		project.open(subMonitor.split(1));
		
		subMonitor.subTask("Creating the model folder...");
		project.getFolder("model").create(false, true, subMonitor.split(1));
		
		return project;
	}
	
	private EPackage getOrCreateEcoreModel(IProject project, IProgressMonitor monitor) throws IOException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, "Creating the Ecore model...", 1);
		
		if (!description.useAnExistingEcoreModel) {
			return createEcoreModel(project, description.ecorePackageName, subMonitor.split(1));
		}
		else {
			return getEcoreModel(description.ecoreModelFilePath);
		}
	}
	
	private static EPackage createEcoreModel(IProject project, String packageName, IProgressMonitor monitor) throws IOException {
		EPackage pkg = EcoreFactory.eINSTANCE.createEPackage();
		pkg.setName(packageName);
		pkg.setNsPrefix(packageName);
		pkg.setNsURI("http://" + packageName);
		
		IFile ecoreFile = project.getFolder("model").getFile(project.getName() + ".ecore");
		ResourceSet resources = new ResourceSetImpl();
		Resource resource = resources.createResource(URI.createFileURI(ecoreFile.getFullPath().toOSString()));
		
		resource.getContents().add(pkg);
		resource.save(emptyMap());
		
		return pkg;
	}
	
	private IPath createAleSourceFile(IProject project, EPackage epackage, IProgressMonitor monitor) throws CoreException {
		SubMonitor subMonitor = SubMonitor.convert(monitor, "Creating ALE source file...", 2);
		String initialContent = "behavior " + epackage.getName() + ";";
		InputStream readableInitialContent = new ByteArrayInputStream(initialContent.getBytes());
		
		IFolder srcFolder = project.getFolder("src-ale");
		srcFolder.create(false, true, subMonitor.split(1));
		
		IFile src = srcFolder.getFile(project.getName() + ".ale");
		src.create(readableInitialContent, false, subMonitor.split(1));
		
		return src.getFullPath();
	}
	
	private static EPackage getEcoreModel(IPath path) {
		ResourceSet resources = new ResourceSetImpl();
		Resource resource = resources.getResource(URI.createFileURI(path.toOSString()), true);
		return (EPackage) resource.getContents().get(0);
	}
	
	private void configureAleEnvironment(IProject project, List<String> ecoreModels, List<String> aleSourceFiles, IProgressMonitor monitor) {
		IScopeContext context = new ProjectScope(project);
        IEclipsePreferences preferences = context.getNode("org.eclipse.emf.ecoretools.ale.core");
		
		if (description.createDslConfigurationFile) {
			SubMonitor subMonitor = SubMonitor.convert(monitor, "Creating .dsl file...", 1);
			
			IFile dslFile = project.getFile(project.getName() + ".dsl");
			String dslFilePath = dslFile.getLocation().toOSString();
			URI dslFileURI = createPlatformResourceURI(dslFile.getFullPath().toPortableString(), true);
			
			Dsl dsl = new Dsl(new RuntimeAleEnvironment(ecoreModels, aleSourceFiles));
			dsl.setSourceFile(dslFilePath);
			dsl.save();
			
			try {
				preferences.putBoolean(CONFIGURED_FROM_DSL_FILE.property(), true);
				preferences.put(DSL_FILE_PATH.property(), dslFileURI.toString());
				preferences.flush();
			} 
			catch (BackingStoreException e) {
				Activator.error(e.getMessage(), e);
			}
			subMonitor.worked(1);
		}
		else {
			try {
				preferences.putBoolean(CONFIGURED_FROM_DSL_FILE.property(), false);
				preferences.put(ALE_SOURCE_FILES.property(), join(",", aleSourceFiles));
				preferences.put(ECORE_MODEL_FILES.property(), join(",", ecoreModels));
				preferences.flush();
			} 
			catch (BackingStoreException e) {
				Activator.error(e.getMessage(), e);
			}
		}
	}
	
	private void createRepresentation(IProject project, EObject model, IProgressMonitor monitor) {
		if (! description.createRepresentation) {
			return;
		}
		SubMonitor subMonitor = SubMonitor.convert(monitor, "Creating Sirius representation...", 4);
		
		// Create a new Sirius session to handle the representation
		
		URI sessionResourceURI = URI.createPlatformResourceURI(project.getFolder("model").getFile(project.getName() + ".aird").getFullPath().toOSString(), true);
		Session session = SessionManager.INSTANCE.getSession(sessionResourceURI, new NullProgressMonitor());
		session.open(new NullProgressMonitor());
		
		// Allow to create a representation for the model thereafter
		
		session.getTransactionalEditingDomain().getCommandStack()
			   .execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
				   @Override
				   protected void doExecute() {
					   session.addSemanticResource(URI.createURI(EcorePackage.eNS_URI), subMonitor);
					   
					   // Actually Sirius seems to automatically add model's EResource, so the following is useless
//					   session.addSemanticResource(URI.createPlatformResourceURI(model.eResource().getURI().toString(), true), subMonitor.split(1));
				   }
			   });

		// Add the 'Design' viewpoint to the representation
		
		Optional<Viewpoint> maybeDesignViewpoint = findDesignViewpoint(ViewpointRegistry.getInstance());
		if (! maybeDesignViewpoint.isPresent()) {
			Activator.error("Cannot create Sirius representation in project " + project.getName() + ": 'Design' viewpoint not found", null);
			return;
		}
		Viewpoint designViewpoint = maybeDesignViewpoint.get();
		ChangeViewpointSelectionCommand cc = new ChangeViewpointSelectionCommand(
				session, 
				new ViewpointSelectionCallback(), 
				new HashSet<>(asList(designViewpoint)), 
				emptySet(), 
				subMonitor.split(1)
		);
		session.getTransactionalEditingDomain().getCommandStack().execute(cc);
	    session.getTransactionalEditingDomain().getCommandStack()
	           .execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
	                @Override
	                protected void doExecute() {
	                    session.createView(maybeDesignViewpoint.get(), asList(model), true, subMonitor.split(1));
	                }
	           });
	    
	    // Okay, that's tricky.
	    //
	    // For some reason there are several instances of the 'Design' viewpoints.
	    // However, when we use the one returned by the ViewpointRegistry Sirius doesn't create any representation
	    // for our model because it doesn't match the instance it uses internally (the `equals` method should
	    // have been overridden).
	    //
	    // As a result, we retrieve the correct instance of the viewpoint below so that Sirius actually
	    // creates the diagram representation.
	    //
	    // FIXME here: I found out by spending lot of time in the debugger, this solution is awful and will likely
	    //		 not work with other versions of Sirius (hopefully it won't even be needed). I may have missed
	    //		 something so if a better solution exist please improve!
	    
	    Collection<DView> selectedViews = session.getSelectedViews();
	    if (! selectedViews.isEmpty()) {
	    	DView view = selectedViews.iterator().next();
	    	designViewpoint = view.getViewpoint();
	    }
	    
	    // Finally create a representation of our Ecore model from the 'Entities' template
	    
	    Optional<RepresentationDescription> representationDescription = 
	    		DialectManager.INSTANCE.getAvailableRepresentationDescriptions(asList(designViewpoint), model)
									   .stream()
									   .filter(desc -> desc.getName().equals("Entities"))
									   .findAny();

	    if (! representationDescription.isPresent()) {
	    	Activator.error("Cannot create Sirius representation in project " + project.getName() + ": 'Entities' representation not found", null);
			return;
	    }
	    // Otherwise Sirius is not able to find the session from the model
	    model.eAdapters().add(new SessionTransientAttachment(session));
	    
	    session.getTransactionalEditingDomain().getCommandStack()
		   .execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
			   @Override
			   protected void doExecute() {
				   DialectManager.INSTANCE.createRepresentation(
						   project.getName() + " class diagram", 
						   model, 
						   representationDescription.get(), 
						   session, 
						   subMonitor.split(1)
				   );
			   }
		   });
	    
	    // Another trick to prevent issues when creating a representation for existing Ecore models
	    //
	    // Issue description:
	    // -----------------
	    //
	    // When one attempts to initialize the representation with the EPackage content Sirius throws an error.
	    // 
	    // Steps to reproduce:
	    // ------------------
	    //
	    // 1. Create a new ALE project relying on an existing Ecore model
	    // 2. Open the .aird representation file
	    // 3. Open the model's representation ('? class diagram')
	    // 4. Double-click on 'Double-click to initialize ...'
	    //
	    // Explanation:
	    // -----------
	    // 
	    // According to [1], when Sirius adds the external Ecore model as a semantic resource of the session it
	    // actually adds a _copy_ of the resource. It then mistakenly believes that Ecore classes are not part
	    // of the session's semantic resources and throws a exception.
	    //
	    // [1] https://www.eclipse.org/forums/index.php?t=msg&th=1085757&goto=1760173&#msg_1760173
	    //
	    // Workaround:
	    // ----------
	    //
	    // It looks like closing the session clears some internal state and make everything work as expected.
	    //
	    // BUT.
	    //
	    // We cannot close the session whenever we want. When we modify the session the changes are not synchronously 
	    // persisted in the .aird file. Instead, a SaveSessionJob is schedule in background (when? I don't really know)
	    // and we have to wait for it to end before closing the session.
	    //
	    // BUT.
	    //
	    // For some reason:
	    //	- calling Job.getJobManager().join(SaveSessionJob.FAMILY) while a SaveSessionJob is actually running
	    //	  ends up in an infinite loop,
	    //  - using an infinite loop (while or for) and checking periodically whether the job has ended does not
	    //	  work either (the job runs forever).
	    //
	    // In the end, the only reliable solution I've found is to schedule another Job responsible of closing 
	    // the session and that reschedules itself until the SaveSessionJob is done.
	    
	    new Job("Close Sirius session of project " + project.getName()) {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				boolean sessionIsSaved = Job.getJobManager().find(SaveSessionJob.FAMILY).length == 0;

				if (! sessionIsSaved) {
					// The session has not been saved yet, we cannot close
					// Reschedule the job so we can try later
					schedule(5);
				}
				else {
					session.close(new NullProgressMonitor());
				}
				return Status.OK_STATUS;
			}
	    	
	    }.schedule();
	}
	
	private static Optional<Viewpoint> findDesignViewpoint(ViewpointRegistry registry) {
		return registry.getViewpoints().stream()
					   .filter(viewpoint -> registry.isFromPlugin(viewpoint))
					   .filter(viewpoint -> "Design".equals(viewpoint.getName()))
					   .findAny();
	}
	
	private void addJavaNature(IProject project, IProgressMonitor monitor) throws CoreException {
		if (! description.activateJava) {
			return;
		}
		SubMonitor subMonitor = SubMonitor.convert(monitor, 6);
		try {
			subMonitor.setTaskName("Adding Java nature...");
			
			IProjectDescription desc = project.getDescription();
		    String[] prevNatures = desc.getNatureIds();
		    String[] newNatures = new String[prevNatures.length + 1];
		    System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
		    newNatures[prevNatures.length] = JavaCore.NATURE_ID;
		    desc.setNatureIds(newNatures);
			project.setDescription(desc, subMonitor.split(1));
			
			subMonitor.setTaskName("Configuring classpath...");
			
			IJavaProject javaProject = JavaCore.create(project);
			
			// Set bin/ as output location

			IFolder binFolder = project.getFolder("bin");
			binFolder.create(false, true, subMonitor.split(1));
			javaProject.setOutputLocation(binFolder.getFullPath(), subMonitor.split(1));
			
			// Add JRE to classpath

			List<IClasspathEntry> entries = new ArrayList<>();
			entries.add(JavaRuntime.getDefaultJREContainerEntry());
			javaProject.setRawClasspath(entries.toArray(new IClasspathEntry[entries.size()]), subMonitor.split(1));

			// Set src/ as source folder

			IFolder sourceFolder = project.getFolder("src");
			sourceFolder.create(false, true, subMonitor.split(1));

			IPackageFragmentRoot root = javaProject.getPackageFragmentRoot(sourceFolder);
			IClasspathEntry[] oldEntries = javaProject.getRawClasspath();
			IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + 1];
			System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
			newEntries[oldEntries.length] = JavaCore.newSourceEntry(root.getPath());
			javaProject.setRawClasspath(newEntries, subMonitor.split(1));
		} 
		catch (NoClassDefFoundError e) {
			// Can happen because dependencies to JDT are optional (one might want to use ALE without Java)
			Activator.error("Unable to set Java nature to project '" + project.getName() + "': org.eclipse.jdt.core or org.eclipse.jdt.launching is not available", e);
		}
	}
	
	/**
	 * The properties of an ALE project. 
	 */
	public static final class Description {
		public final boolean useAnExistingEcoreModel;
		public final IPath ecoreModelFilePath;
		public final String ecorePackageName;
		public final boolean createRepresentation;
		public final boolean activateJava;
		public final boolean createDslConfigurationFile;
		
		/**
		 * @param useAnExistingEcoreModel
		 * 			Whether the user wants to reuse an existing Ecore model
		 * @param ecoreModelFilePath
		 * 			The path to the existing Ecore model (can be null if the user does not want to use one)
		 * @param ecorePackageName
		 * 			The name of the EPackage to create (can be null if the user does not want to create a new Ecore model)
		 * @param createRepresentation
		 * 			Whether the user wants a Sirius representation to be created for the Ecore model
		 * @param activateJava
		 * 			Whether the user wants to create Java services
		 * @param createDslConfigurationFile
		 * 			Whether a .dsl configuration file should be created
		 */
		public Description(boolean useAnExistingEcoreModel, IPath ecoreModelFilePath, String ecorePackageName, boolean createRepresentation, boolean activateJava,
				    boolean createDslConfigurationFile) {
			this.useAnExistingEcoreModel = useAnExistingEcoreModel;
			this.ecoreModelFilePath = ecoreModelFilePath;
			this.ecorePackageName = ecorePackageName;
			this.createRepresentation = createRepresentation;
			this.activateJava = activateJava;
			this.createDslConfigurationFile = createDslConfigurationFile;
		}
		
	}
	
}
