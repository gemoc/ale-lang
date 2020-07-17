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
package org.eclipse.emf.ecoretools.ale.ide.listener;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecoretools.ale.core.env.impl.FileBasedAleEnvironment;
import org.eclipse.emf.ecoretools.ale.ide.resource.AleResource;
import org.eclipse.emf.ecoretools.design.service.EcoreToolsDesignPlugin;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionListener;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

/**
 * Session Manager Listener creating 
 */
public class AleSessionManagerListener implements SessionManagerListener {

	public static final String BEHAVIOR_VP_ID = "Behavior";
	public static final String BEHAVIOR_LAYER = "Behavior";
	public static final String ECORE_VP_EXTENSION = "BehaviorEntities";
	public static final String IMPLEM_EXTENSION = "ale";
	public static final String DSL_EXTENSION = "dsl";
	
	AleWorkspaceListener wsListener;

	@Override
	public void notifyAddSession(Session newSession) {
		registerEmfFactory(newSession);
		createDslIfNeeded(newSession);
	}

	@Override
	public void notifyRemoveSession(Session removedSession) {
		removeWsListener(removedSession);
	}

	@Override
	public void viewpointSelected(Viewpoint selectedSirius) {
		// nothing to do
	}

	@Override
	public void viewpointDeselected(Viewpoint deselectedSirius) {
		// nothing to do
	}

	@Override
	public void notify(Session updated, int notification) {
		if(notification == SessionListener.SELECTED_VIEWS_CHANGE_KIND) {
			createDslIfNeeded(updated);
		}
	}
	
	private void createDslIfNeeded(Session session) {
		Optional<Viewpoint> behaviorVP = 
			session
			.getSelectedViewpoints(true)
			.stream()
			.filter(vp -> vp.getName().equals(BEHAVIOR_VP_ID))
			.findFirst();
		if(behaviorVP.isPresent()) {
			if(!getDsl(session).isPresent()) {
				// FIXME Is it really necessary to add the .dsl file as a semantic resource?
				//
				// This was required to retrieve information about the semantics
				// from Sirius to populate the 'Behavior' layer.
				//
				// However, as of PR #115 the .dsl file may not exist. Services::getModelBehavior
				// has been updated to reflected this.
				//
//				createAndRegisterDsl(session);
			}
			createWsListener(session);
		}
	}
	
	private void registerEmfFactory(Session session) {
		final TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
		ResourceSet rs = editingDomain.getResourceSet();
		
		// FIXME [API] May cause memory leaks because the IQueryEnvironment is never release
		//			   What is it for, anyway?
		
//		AleInterpreter interpreter = new AleInterpreter();
//		rs.getResourceFactoryRegistry()
//			.getExtensionToFactoryMap()
//			.put("dsl", new AleResourceFactory(interpreter.getQueryEnvironment(),rs));
	}
	
	private Optional<Resource> getDsl(Session session) {
		List<Resource> dslRes = 
			session
			.getSemanticResources()
			.stream()
			.filter(r -> {
				String fileExt = r.getURI().fileExtension();
				if(fileExt != null){
					return fileExt.equals(DSL_EXTENSION);
				}
				return false;
			})
			.collect(Collectors.toList());
		
		if(dslRes.isEmpty()) {
			return Optional.empty();
		}
		else if(dslRes.size() == 1) {
			return Optional.of(dslRes.get(0));
		}
		else {
			// TODO: raise error (only one .dsl file)
			return Optional.of(dslRes.get(0));
		}
	}
	
	/**
	 * Create & add DSL resource into the Session
	 */
	private void createAndRegisterDsl(Session session) {
		//TODO: manage already existing files 
		List<Resource> mmRes = getMetamodels(session);
		
		if(!mmRes.isEmpty()) {
			Resource ecoreResource = mmRes.get(0); //TODO: error when more that one .ecore ?
			
			String ecoreURI = ecoreResource.getURI().toString();
			String aleURI = ecoreResource.getURI().trimFileExtension().appendFileExtension(IMPLEM_EXTENSION).toString();
			
			IFile file = WorkspaceSynchronizer.getFile(ecoreResource);
			IPath alePath = file.getFullPath().removeFileExtension().addFileExtension(IMPLEM_EXTENSION);
			IPath dslPath = file.getFullPath().removeFileExtension().addFileExtension(DSL_EXTENSION);
			
			String aleContent = "behavior "+ getSimpleName(ecoreResource) +";\n";
			String dslContent = FileBasedAleEnvironment.METAMODELS_KEY + "=" + ecoreURI + "\n" + FileBasedAleEnvironment.BEHAVIORS_KEY + "=" + aleURI + "\n";
			
			createFile(alePath, aleContent);
			createFile(dslPath, dslContent);
			
			//TODO: make sure ecore URI is fine
			URI dslURI = ecoreResource.getURI().trimFileExtension().appendFileExtension(DSL_EXTENSION);
			RecordingCommand cmd = new RecordingCommand(session.getTransactionalEditingDomain()) {
					@Override
					protected void doExecute() {
						session.addSemanticResource(dslURI, new NullProgressMonitor());
					}
				};
			try {
				CommandStack commandStack = session.getTransactionalEditingDomain().getCommandStack();
				commandStack.execute(cmd);
			} catch (Exception e) {
				EcoreToolsDesignPlugin.INSTANCE.log(e);
			}
		}
		else {
			//TODO: error
		}
	}
	
	/**
	 * Create or Replace the listener for DSL files
	 */
	private void createWsListener(Session session) {
		
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		if(wsListener != null) {
			ws.removeResourceChangeListener(wsListener);
			System.out.println("debug remove");
		}
		
		Optional<Resource> dslRes = getDsl(session);
		if(dslRes.isPresent()) {
			
			AleResource res = (AleResource) dslRes.get();
			wsListener = new AleWorkspaceListener(session,res);
			ws.addResourceChangeListener(wsListener);
			
			res.getParseResult().forEach(parse -> {
				String filePath = parse.getSourceFile();
				IPath path = new Path(filePath);
				IFile file = null;
				if(path.isAbsolute()) {
					file = ws.getRoot().getFileForLocation(path);
				}
				else {
					file = ws.getRoot().getFile(path);
				}
				wsListener.listen(file);
			});
		}
	}
	
	private void removeWsListener(Session session) {
		if(wsListener != null){
			IWorkspace ws = ResourcesPlugin.getWorkspace();
			ws.removeResourceChangeListener(wsListener);
			System.out.println("debug remove");
		}
	}
	
	private List<Resource> getMetamodels(Session session) {
		List<Resource> mmRes = 
				session
				.getSemanticResources()
				.stream()
				.filter(res -> isMetamodel(res) )
				.collect(Collectors.toList());
		
		return mmRes;
	}
	
	private boolean isMetamodel(Resource res) {
		String fileExt = res.getURI().fileExtension();
		return fileExt != null && fileExt.equals("ecore");
	}
	
	private String getSimpleName(Resource ecoreRes) {
		return ecoreRes.getURI().lastSegment().replaceAll("\\.ecore", "");
	}
	
	private void createFile(IPath filePath, String fileContent) {
		IWorkspaceRoot ws = ResourcesPlugin.getWorkspace().getRoot();
		IFile dslFile = ws.getFile(filePath);
		InputStream source = new ByteArrayInputStream(fileContent.getBytes());
		try {
			if(!dslFile.exists()) {
				dslFile.create(source, true, new NullProgressMonitor());
			}
		} catch (CoreException e) {
			EcoreToolsDesignPlugin.INSTANCE.log(e);
		}
	}
}
