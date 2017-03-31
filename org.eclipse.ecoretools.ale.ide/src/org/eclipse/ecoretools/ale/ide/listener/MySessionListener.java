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
package org.eclipse.ecoretools.ale.ide.listener;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.ecoretools.ale.core.parser.AstBuilder;
import org.eclipse.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.ecoretools.ale.ide.services.Services;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.viewpoint.DView;
import org.eclipse.sirius.viewpoint.description.RepresentationExtensionDescription;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

import org.eclipse.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.ecoretools.ale.implementation.ModelBehavior;

public class MySessionListener implements SessionManagerListener{

	public static final String ECORE_VP_EXTENSION = "MyExtension";
	public static final String IMPLEM_EXTENSION = "mydsl";
	public static final String DSL_EXTENSION = "dsl";
	public static final String RESOURCE_SUFFIX = "transient";

	@Override
	public void notifyAddSession(Session newSession) {
		
//		Optional<RepresentationExtensionDescription> searchEntityExt =
//				selectedSirius
//				.getOwnedRepresentationExtensions()
//				.stream()
//				.filter(ext -> ext.getName().equals(ECORE_VP_EXTENSION))
//				.findFirst();
//			
//			if(searchEntityExt.isPresent()){
				//Check implem
				
//				Iterator<DView> it = newSession.getOwnedViews().iterator();
//				it.next().getOwnedRepresentationDescriptors().get(0).getName();//TODO
				
				Set<Resource> allModels = 
					newSession
					.getOwnedViews()
					.stream()
					.flatMap(elem -> elem.getModels().stream())
					.filter(elem -> elem instanceof EPackage)
					.map(elem -> elem.eResource())
					.collect(Collectors.toSet());
				
//				TransactionalEditingDomain editingDomain = newSession.getTransactionalEditingDomain();
//				ResourceSet rs = editingDomain.getResourceSet();
				
				allModels.forEach(ecoreRes -> {
					Services.reloadModelBehavior(newSession, ecoreRes);
//					URI uri = ecoreRes.getURI();
//					URI implemURI = uri.trimFileExtension().appendFileExtension(IMPLEM_EXTENSION);
//					List<EPackage> pkgs = getMetamodel(ecoreRes);
//					
//					String relativeURI = implemURI.toPlatformString(true);
//					String fullURI = ResourcesPlugin.getWorkspace().getRoot().getLocation()+relativeURI;
//					
//					ModelBehavior behavior = loadBehavior(fullURI,pkgs).getRoot();
				});
				
				
				//Create implem + listener
				
				//Reload implem
//			}
		
		System.out.println("Session is added");
	}

	@Override
	public void notifyRemoveSession(Session removedSession) {
		System.out.println("Session is removed");
	}

	@Override
	public void viewpointSelected(Viewpoint selectedSirius) {
		
		
		System.out.println("Viewpoint is selected");
	}

	@Override
	public void viewpointDeselected(Viewpoint deselectedSirius) {
		System.out.println("Viewpoint is deselected");
	}

	@Override
	public void notify(Session updated, int notification) {
		System.out.println("Session is notified");
	}
	
	private List<EPackage> getMetamodel(Resource ecoreRes) {
		List<EPackage> res = new ArrayList<EPackage>();
		ecoreRes.getAllContents().forEachRemaining(e -> {
			if(e instanceof EPackage){
				res.add((EPackage) e);
			}
		});
		return res;
	}
	
//	private ParseResult<ModelBehavior> loadBehavior(String filePath, List<EPackage> pkgs) {
//		String content = getFileContent(filePath);
//		
//		IQueryEnvironment queryEnvironment = Query.newEnvironmentWithDefaultServices(null);
//		queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE);
//		queryEnvironment.registerEPackage(AstPackage.eINSTANCE);
//		pkgs.stream().forEach(pkg -> queryEnvironment.registerEPackage(pkg));
//		return (new AstBuilder(queryEnvironment)).parse(content);
//	}
//	
//	private static String getFileContent(String implementionPath){
//		String fileContent = "";
//		try {
//			fileContent = new String(Files.readAllBytes(Paths.get(implementionPath)));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return fileContent;
//	}
//	
//	/**
//	 * Create a .mydsl file based an the ecoreResource's URI.
//	 * Do nothing if already there
//	 */
//	private void createImplemFile(Resource ecoreResource) {
//		IFile file = WorkspaceSynchronizer.getFile(ecoreResource);
//		IPath dslPath = file.getFullPath().removeFileExtension().addFileExtension(IMPLEM_EXTENSION);
//		IWorkspaceRoot ws = ResourcesPlugin.getWorkspace().getRoot();
//		IFile implemFile = ws.getFile(dslPath);
//		if(!implemFile.exists()){
//			String emptyContent = "";
//			InputStream source = new ByteArrayInputStream(emptyContent.getBytes());
//			try {
//				implemFile.create(source, true, new NullProgressMonitor());
//			} catch (CoreException e) {
//				e.printStackTrace();
//			}
//		}
//	}
}
