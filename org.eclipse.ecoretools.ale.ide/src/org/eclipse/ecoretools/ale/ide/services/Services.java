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
package org.eclipse.ecoretools.ale.ide.services;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.ecoretools.ale.rAttribute;
import org.eclipse.ecoretools.ale.RClass;
import org.eclipse.ecoretools.ale.rOperation;
import org.eclipse.ecoretools.ale.RRoot;
import org.eclipse.ecoretools.ale.core.parser.AstBuilder;
import org.eclipse.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.ecoretools.ale.implementation.Implementation;
import org.eclipse.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.ecoretools.ale.implementation.Method;
import org.eclipse.ecoretools.ale.implementation.ModelBehavior;
import org.eclipse.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;


public class Services {
	
	public static final String IMPLEM_EXTENSION = "mydsl";
	public static final String DSL_EXTENSION = "dsl";
	public static final String RESOURCE_SUFFIX = "transient";
	
	public static void reloadModelBehavior(Session session, Resource ecoreRes) {
		final TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
		ResourceSet rs = editingDomain.getResourceSet();
		
    	URI uri = ecoreRes.getURI();
    	URI implemURI = uri.trimFileExtension().appendFileExtension(IMPLEM_EXTENSION+"."+RESOURCE_SUFFIX);
    	
    	/*
    	 * Remove existing implem resource
    	 */
    	Optional<Resource> implemSearch = 
			session
			.getSemanticResources()
			.stream()
			.filter(r -> r.getURI().equals(implemURI))
			.findFirst();
    	if(implemSearch.isPresent()){
    		RecordingCommand cmd = new RecordingCommand(editingDomain) {
				@Override
				protected void doExecute() {
					session.removeSemanticResource(implemSearch.get(), new NullProgressMonitor(), false);
				}
			};
			try {
				CommandStack commandStack = editingDomain.getCommandStack();
				commandStack.execute(cmd);
			} catch (Exception e) {
				// TODO: error msg
			}
    	}
    	
    	/*
    	 * Reload implem resource
    	 */
		RecordingCommand cmd = new RecordingCommand(editingDomain) {
		@Override
		protected void doExecute() {
				getOrCreateImplemFile(ecoreRes);
				Resource res = rs.createResource(implemURI);
				
				URI implemFileURI = uri.trimFileExtension().appendFileExtension(IMPLEM_EXTENSION);
				String relativeURI = implemFileURI.toPlatformString(true);
				String fullURI = ResourcesPlugin.getWorkspace().getRoot().getLocation()+relativeURI;
				List<EPackage> pkgs = getMetamodel(ecoreRes);
				ModelBehavior mb = loadBehavior(fullURI, pkgs).getRoot();
				res.getContents().add(mb);
				
				session.addSemanticResource(res.getURI(), new NullProgressMonitor());
			}
		};
		try {
			CommandStack commandStack = editingDomain.getCommandStack();
			commandStack.execute(cmd);
		} catch (Exception e) {
			// TODO: error msg
		}
	}
	
	/**
	 * Create a .mydsl file based an the ecoreResource's URI and add listener.
	 * Do nothing if already there
	 */
	private static IFile getOrCreateImplemFile(Resource ecoreResource) {
		
		IFile file = WorkspaceSynchronizer.getFile(ecoreResource);
		IPath dslPath = file.getFullPath().removeFileExtension().addFileExtension(IMPLEM_EXTENSION);
		IWorkspaceRoot ws = ResourcesPlugin.getWorkspace().getRoot();
		IFile implemFile = ws.getFile(dslPath);
		if(!implemFile.exists()){
			String emptyContent = "";
			InputStream source = new ByteArrayInputStream(emptyContent.getBytes());
			try {
				implemFile.create(source, true, new NullProgressMonitor());
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		Session session = SessionManager.INSTANCE.getSession(ecoreResource);
		addListenerIfNeeded(session,ecoreResource);
		return implemFile;
	}
	
	
	
	private static List<EPackage> getMetamodel(Resource ecoreRes) {
		List<EPackage> res = new ArrayList<EPackage>();
		ecoreRes.getAllContents().forEachRemaining(e -> {
			if(e instanceof EPackage){
				res.add((EPackage) e);
			}
		});
		return res;
	}
	
	/**
	 * Call the parser
	 */
	private static ParseResult<ModelBehavior> loadBehavior(String filePath, List<EPackage> pkgs) {
		String content = getFileContent(filePath);
		
		IQueryEnvironment queryEnvironment = Query.newEnvironmentWithDefaultServices(null);
		queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE);
		queryEnvironment.registerEPackage(AstPackage.eINSTANCE);
		pkgs.stream().forEach(pkg -> queryEnvironment.registerEPackage(pkg));
		return (new AstBuilder(queryEnvironment)).parse(content);
	}
	
	private static String getFileContent(String implementionPath){
		String fileContent = "";
		try {
			fileContent = new String(Files.readAllBytes(Paths.get(implementionPath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}
	
	static Map<Session,Map<String,IResourceChangeListener>> registry = new HashMap<Session,Map<String,IResourceChangeListener>>();

	public EObject addListenerIfNeeded(EObject e){
		Session session = SessionManager.INSTANCE.getSession(e);
		addListenerIfNeeded(session, e.eResource());
		return null;
	}
	
	private static void addListenerIfNeeded(Session session, Resource ecoreRes) {
		
		URI implemUri = ecoreRes.getURI().trimFileExtension().appendFileExtension(IMPLEM_EXTENSION);
		String implemPath = implemUri.toPlatformString(true);
		
		IResourceChangeListener existingListener = null;
		Map<String, IResourceChangeListener> sessionReg = registry.get(session);
		if(sessionReg != null){
			existingListener = registry.get(session).get(implemPath);
		}
		else{
			registry.put(session,new HashMap<String,IResourceChangeListener>());
		}
		
		if(existingListener == null) {
			IFile implemFile = null;
			if (implemUri.isPlatformResource()) {
	             IPath path = new Path(implemUri.toPlatformString(true));
	             implemFile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
	        }
			else if (implemUri.isFile() && !implemUri.isRelative()) {
				implemFile = ResourcesPlugin.getWorkspace().getRoot().getFileForLocation(new Path(implemUri.toFileString()));
	        }
			
			final IFile targetFile = implemFile;
			if(implemFile != null) {
				IResourceChangeListener listener = new IResourceChangeListener() {
					@Override
					public void resourceChanged(IResourceChangeEvent event) {
						if(event.getType() == IResourceChangeEvent.POST_CHANGE){
							IResourceDelta deltaTarget = event.getDelta().findMember(targetFile.getFullPath());
							if(deltaTarget != null){
								reloadModelBehavior(session,ecoreRes);
								RecordingCommand cmd = new RecordingCommand(session.getTransactionalEditingDomain()) {
									@Override
									protected void doExecute() {
										session.getOwnedViews().forEach(e -> e.refresh());
									}
								};
								try {
									CommandStack commandStack = session.getTransactionalEditingDomain().getCommandStack();
									commandStack.execute(cmd);
								} catch (Exception e) {
									// TODO: error msg
								}
							}
						}
					}
				};
				sessionReg = registry.get(session);
				sessionReg.put(implemPath, listener);
				ResourcesPlugin.getWorkspace().addResourceChangeListener(listener);
			}
		}
	}
	
    public boolean isImplemented(EObject elem) {
    	Session session = SessionManager.INSTANCE.getSession(elem);
    	
    	URI uri = elem.eResource().getURI();
    	URI implemURI = uri.trimFileExtension().appendFileExtension(IMPLEM_EXTENSION+"."+RESOURCE_SUFFIX);
    	
    	Optional<Resource> implemSearch = 
    			session
    			.getSemanticResources()
    			.stream()
    			.filter(res -> res.getURI().equals(implemURI))
    			.findFirst();
    	
    	if(implemSearch.isPresent()){
        	if(elem instanceof EOperation) {
        		EOperation op = (EOperation) elem;
        		Optional<ExtendedClass> searchCls = 
        			((ModelBehavior)implemSearch.get().getContents().get(0))
    				.getClassExtensions()
    				.stream()
    				.filter(ext -> ext.getBaseClass().getName().equals(op.getEContainingClass().getName())).findFirst();
        		
        		if(searchCls.isPresent()) {
        			ExtendedClass xtdClass = searchCls.get();
        			return xtdClass
        				.getMethods()
        				.stream()
        				.filter(mtd -> (mtd instanceof Implementation)	&& ((Implementation)mtd).getOperationRef().getName().equals(op.getName()))
        				.findAny()
        				.isPresent();
        		}
        	}
    	}
    	return false;
    }
    
    public List<VariableDeclaration> getDynaAttrib(EClass cls){
    	
    	Session session = SessionManager.INSTANCE.getSession(cls);
    	final TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
		ResourceSet rs = editingDomain.getResourceSet();
		
    	URI uri = cls.eResource().getURI();
    	URI implemURI = uri.trimFileExtension().appendFileExtension(IMPLEM_EXTENSION+"."+RESOURCE_SUFFIX);
    	
    	Optional<Resource> implemSearch = 
			session
			.getSemanticResources()
			.stream()
			.filter(r -> r.getURI().equals(implemURI))
			.findFirst();
    	if(implemSearch.isPresent()){
    		Resource implemRes = implemSearch.get();
    		ModelBehavior root = (ModelBehavior) implemRes.getContents().get(0);
			Optional<ExtendedClass> searchCls = 
				root
				.getClassExtensions()
				.stream()
				.filter(ext -> ext.getBaseClass().getName().equals(cls.getName())).findFirst();
			if(searchCls.isPresent()){
				ExtendedClass xtdCls = searchCls.get();
				return xtdCls.getAttributes();
			}
    	}
    	return new ArrayList<VariableDeclaration>();
    }
    
    public List<Method> getMethod(EClass cls){
    	Session session = SessionManager.INSTANCE.getSession(cls);
    	final TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
		ResourceSet rs = editingDomain.getResourceSet();
		
    	URI uri = cls.eResource().getURI();
    	URI implemURI = uri.trimFileExtension().appendFileExtension(IMPLEM_EXTENSION+"."+RESOURCE_SUFFIX);
    	
    	Optional<Resource> implemSearch = 
			session
			.getSemanticResources()
			.stream()
			.filter(r -> r.getURI().equals(implemURI))
			.findFirst();
    	if(implemSearch.isPresent()){
    		Resource implemRes = implemSearch.get();
    		ModelBehavior root = (ModelBehavior) implemRes.getContents().get(0);
			Optional<ExtendedClass> searchCls = 
				root
				.getClassExtensions()
				.stream()
				.filter(ext -> ext.getBaseClass().getName().equals(cls.getName())).findFirst();
			if(searchCls.isPresent()){
				ExtendedClass xtdCls = searchCls.get();
				return 
					xtdCls
					.getMethods()
					.stream()
					.filter(op -> op instanceof Method)
					.map(op -> (Method) op)
					.collect(Collectors.toList());
			}
    	}
    	return new ArrayList<Method>();
    }
    
	public EOperation editImplementation(EOperation op) {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IFile file = getOrCreateImplemFile(op.eResource());
		IEditorDescriptor desc = PlatformUI.getWorkbench().
		        getEditorRegistry().getDefaultEditor(file.getName());
		try {
			IEditorPart editor = page.openEditor(new FileEditorInput(file), desc.getId());
			
			if(editor instanceof XtextEditor){
				XtextEditor xEditor = (XtextEditor) editor;
				IXtextDocument document = xEditor.getDocument();
				document.modify(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource state) throws Exception {
						if(state.getContents().size() > 0) {
							RRoot root = (RRoot) state.getContents().get(0);
							
							String returnType = "void";
							if(op.getEType() != null){
								returnType = op.getEType().getName();;
							}
							String parameters = op.getEParameters()
								.stream()
								.map(p -> p.getEType().getName()+" "+ p.getName())
								.collect(Collectors.joining(",","(",")"));
							String opName = op.getName();
							String template = "\toverride "+returnType+" "+opName+" "+parameters+" {\n\t\t/* Write your code here */\n\t}\n";
							
							EList<RClass> allXtdCls = root.getXtendedClasses();
							Optional<RClass> search = allXtdCls.stream().filter(xtd -> xtd.getName().equals(op.getEContainingClass().getName())).findFirst();
							
							RClass xtdCls = null;
							if(search.isPresent()){
								xtdCls = search.get(); 
								ICompositeNode node = NodeModelUtils.findActualNodeFor(xtdCls);
								
								Optional<rOperation> opSearch = xtdCls.getOperations().stream().filter(o -> o.getName().equals(opName)).findFirst();
								if(!opSearch.isPresent()){
									int endOffset = node.getEndOffset();
									document.replace(endOffset-1, 0,	template);
								}
							}
							else {
								ICompositeNode node = NodeModelUtils.findActualNodeFor(root);
								int endOffset = node.getEndOffset();
								String newXtdClass = "\nclass "+op.getEContainingClass().getName()+" {\n"+template+"}";
								document.replace(endOffset, 0,	newXtdClass);
								xEditor.selectAndReveal(endOffset, newXtdClass.length());
							}
						}
					}
				});
			}
			
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return op;
	}

	public EClass addMethod(EClass cls) {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IFile file = getOrCreateImplemFile(cls.eResource());
		IEditorDescriptor desc = PlatformUI.getWorkbench().
		        getEditorRegistry().getDefaultEditor(file.getName());
		try {
			IEditorPart editor = page.openEditor(new FileEditorInput(file), desc.getId());
			
			if(editor instanceof XtextEditor){
				XtextEditor xEditor = (XtextEditor) editor;
				IXtextDocument document = xEditor.getDocument();
				document.modify(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource state) throws Exception {
						if(state.getContents().size() > 0) {
							RRoot root = (RRoot) state.getContents().get(0);
							
							String returnType = "int";
							String parameters = "()";
							String opName = "newMethod";
							String template = "\tdef "+returnType+" "+opName+" "+parameters+" {\n\t\t/* Write your code here */\n\t\tresult := 0;\n\t}\n";
							
							EList<RClass> allXtdCls = root.getXtendedClasses();
							Optional<RClass> search = allXtdCls.stream().filter(xtd -> xtd.getName().equals(cls.getName())).findFirst();
							
							RClass xtdCls = null;
							if(search.isPresent()){
								xtdCls = search.get(); 
								ICompositeNode node = NodeModelUtils.findActualNodeFor(xtdCls);
								
								Optional<rOperation> opSearch = xtdCls.getOperations().stream().filter(o -> o.getName().equals(opName)).findFirst();
								if(!opSearch.isPresent()){
									int endOffset = node.getEndOffset();
									document.replace(endOffset-1, 0, template);
								}
							}
							else {
								ICompositeNode node = NodeModelUtils.findActualNodeFor(root);
								int endOffset = node.getEndOffset();
								String newXtdClass = "\nclass "+cls.getName()+" {\n"+template+"}";
								document.replace(endOffset, 0,	newXtdClass);
							}
						}
					}
				});
			}
			
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return cls;
	}

	public EClass addDynamicFeature(EClass cls){
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IFile file = getOrCreateImplemFile(cls.eResource());
		IEditorDescriptor desc = PlatformUI.getWorkbench().
		        getEditorRegistry().getDefaultEditor(file.getName());
		try {
			IEditorPart editor = page.openEditor(new FileEditorInput(file), desc.getId());
			
			if(editor instanceof XtextEditor){
				XtextEditor xEditor = (XtextEditor) editor;
				IXtextDocument document = xEditor.getDocument();
				document.modify(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource state) throws Exception {
						if(state.getContents().size() > 0) {
							RRoot root = (RRoot) state.getContents().get(0);
							
							String type = "int";
							String attrName = "newFeature";
							String template = "\n\t"+type+" "+attrName+";\n";
							
							EList<RClass> allXtdCls = root.getXtendedClasses();
							Optional<RClass> search = allXtdCls.stream().filter(xtd -> xtd.getName().equals(cls.getName())).findFirst();
							
							RClass xtdCls = null;
							if(search.isPresent()){
								xtdCls = search.get(); 
								ICompositeNode node = NodeModelUtils.findActualNodeFor(xtdCls);
								
								Optional<rAttribute> attrSearch = xtdCls.getAttributes().stream().filter(a -> a.getName().equals(attrName)).findFirst();
								if(!attrSearch.isPresent()){
									int endOffset = node.getEndOffset();
									Iterable<ILeafNode> leafs = node.getLeafNodes();
									ArrayList<ILeafNode> l = new ArrayList<ILeafNode>();
									leafs.forEach(e -> l.add(e));
									
									Optional<ILeafNode> openBraceSearch = l.stream()
										.filter(n -> n instanceof LeafNode 
												&& ((LeafNode)n).getGrammarElement() instanceof Keyword 
												&& ((Keyword)((LeafNode)n).getGrammarElement()).getValue().equals("{"))
										.findFirst();
									if(openBraceSearch.isPresent()){
										endOffset = openBraceSearch.get().getEndOffset()+1;
									}
									
									document.replace(endOffset-1, 0, template);
								}
							}
							else {
								ICompositeNode node = NodeModelUtils.findActualNodeFor(root);
								int endOffset = node.getEndOffset();
								String newXtdClass = "\nclass "+cls.getName()+" {\n"+template+"}";
								document.replace(endOffset, 0,	newXtdClass);
							}
						}
					}
				});
			}
			
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return cls;
	}
}
