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
package org.eclipse.emf.ecoretools.ale.ide.services;

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
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecoretools.ale.rAttribute;
import org.eclipse.emf.ecoretools.ale.rClass;
import org.eclipse.emf.ecoretools.ale.rOperation;
import org.eclipse.emf.ecoretools.ale.rRoot;
import org.eclipse.emf.ecoretools.ale.core.parser.AstBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.ide.Activator;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
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
	
	public static final String IMPLEM_EXTENSION = "ale";
	public static final String DSL_EXTENSION = "dsl";
	
    public boolean isImplemented(EObject elem) {
    	if(elem instanceof EOperation) {
    		EOperation op = (EOperation) elem;
    		List<ModelUnit> modelUnits = getModelBehavior(elem);
    		Optional<ExtendedClass> searchCls = 
				modelUnits
				.stream()
				.map(elm -> (ModelUnit) elm)
				.flatMap(u -> u.getClassExtensions().stream())
				.filter(ext -> ext.getBaseClass().getName().equals(op.getEContainingClass().getName())).findFirst();
        		
    		if(searchCls.isPresent()) {
    			ExtendedClass xtdClass = searchCls.get();
    			return xtdClass
    				.getMethods()
    				.stream()
    				.filter(mtd -> mtd.getOperationRef().getName().equals(op.getName()) && mtd.getOperationRef().getEContainingClass() == xtdClass.getBaseClass())
    				.findAny()
    				.isPresent();
    		}
    	}
    	
    	return false;
    }
    
    private List<ModelUnit> getModelBehavior(EObject element) {
    	Session session = SessionManager.INSTANCE.getSession(element);
    	
    	URI uri = element.eResource().getURI();
    	URI implemURI = uri.trimFileExtension().appendFileExtension(DSL_EXTENSION);
    	
    	Optional<Resource> implemRes = 
			session
			.getSemanticResources()
			.stream()
			.filter(res -> res.getURI().equals(implemURI))
			.findFirst();
    	
    	if(implemRes.isPresent()){
    		return 
    			implemRes.get()
    			.getContents()
				.stream()
				.filter(elem -> elem instanceof ModelUnit)
				.map(elm -> (ModelUnit) elm)
				.collect(Collectors.toList());
    	}
    	
    	return new ArrayList<ModelUnit>();
    }
    
    public List<Attribute> getDynaAttrib(EClass cls){
    	List<ModelUnit> modelUnits = getModelBehavior(cls);
    	Optional<ExtendedClass> searchCls = 
			modelUnits
			.stream()
			.flatMap(u -> u.getClassExtensions().stream())
			.filter(ext -> ext.getBaseClass().getName().equals(cls.getName())).findFirst();
		if(searchCls.isPresent()){
			ExtendedClass xtdCls = searchCls.get();
			return 
				xtdCls
				.getAttributes()
				.stream()
				.filter(att -> att.getFeatureRef() instanceof EAttribute) //FIXME: show also not displayer EReferences
				.collect(Collectors.toList());
		}
    	
    	return new ArrayList<Attribute>();
    }
    
    public List<Method> getMethod(EClass cls) {
    	List<ModelUnit> modelUnits = getModelBehavior(cls);
    	Optional<ExtendedClass> searchCls = 
			modelUnits
			.stream()
			.flatMap(u -> u.getClassExtensions().stream())
			.filter(ext -> ext.getBaseClass().getName().equals(cls.getName())).findFirst();
		if(searchCls.isPresent()){
			ExtendedClass xtdCls = searchCls.get();
			return 
				xtdCls
				.getMethods()
				.stream()
				.filter(op -> op instanceof Method)
				.map(op -> (Method) op)
				.filter(op -> !isImplemented(op.getOperationRef())) //TODO: improve
				.collect(Collectors.toList());
		}
    	
    	return new ArrayList<Method>();
    }
    
	public EOperation editImplementation(EOperation op) {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IFile file = getImplemFile(op.eResource());
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
							rRoot root = (rRoot) state.getContents().get(0);
							
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
							
							EList<rClass> allXtdCls = root.getXtendedClasses();
							Optional<rClass> search = allXtdCls.stream().filter(xtd -> xtd.getName().equals(op.getEContainingClass().getName())).findFirst();
							
							rClass xtdCls = null;
							if(search.isPresent()){
								xtdCls = search.get(); 
								ICompositeNode node = NodeModelUtils.findActualNodeFor(xtdCls);
								
								Optional<rOperation> opSearch = xtdCls.getOperations().stream().filter(o -> o.getName().equals(opName)).findFirst();
								if(!opSearch.isPresent()){
									int endOffset = node.getEndOffset();
									document.replace(endOffset-1, 0,	template);
									xEditor.selectAndReveal(endOffset, template.length() -2);
								}
							}
							else {
								ICompositeNode node = NodeModelUtils.findActualNodeFor(root);
								int endOffset = node.getEndOffset();
								String newXtdClass = "\nopen class "+op.getEContainingClass().getName()+" {\n"+template+"}";
								document.replace(endOffset, 0,	newXtdClass);
								xEditor.selectAndReveal(endOffset, newXtdClass.length());
								int templateOffset = endOffset + op.getEContainingClass().getName().length() + 16;
								xEditor.selectAndReveal(templateOffset, template.length() -2);
							}
						}
					}
				});
			}
			
		} catch (PartInitException e) {
			Activator.getDefault().error(e);
		}
		return op;
	}

	public EClass addMethod(EClass cls) {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IFile file = getImplemFile(cls.eResource());
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
							rRoot root = (rRoot) state.getContents().get(0);
							
							String returnType = "int";
							String parameters = "()";
							String opName = "newMethod";
							String template = "\tdef "+returnType+" "+opName+" "+parameters+" {\n\t\t/* Write your code here */\n\t\tresult := 0;\n\t}\n";
							
							EList<rClass> allXtdCls = root.getXtendedClasses();
							Optional<rClass> search = allXtdCls.stream().filter(xtd -> xtd.getName().equals(cls.getName())).findFirst();
							
							rClass xtdCls = null;
							if(search.isPresent()){
								xtdCls = search.get(); 
								ICompositeNode node = NodeModelUtils.findActualNodeFor(xtdCls);
								
								Optional<rOperation> opSearch = xtdCls.getOperations().stream().filter(o -> o.getName().equals(opName)).findFirst();
								if(!opSearch.isPresent()){
									int endOffset = node.getEndOffset();
									document.replace(endOffset-1, 0, template);
									xEditor.selectAndReveal(endOffset, template.length() -2);
								}
							}
							else {
								ICompositeNode node = NodeModelUtils.findActualNodeFor(root);
								int endOffset = node.getEndOffset();
								String newXtdClass = "\nopen class "+cls.getName()+" {\n"+template+"}";
								document.replace(endOffset, 0,	newXtdClass);
								int templateOffset = endOffset + cls.getName().length() + 16;
								xEditor.selectAndReveal(templateOffset, template.length() -2);
							}
						}
					}
				});
			}
			
		} catch (PartInitException e) {
			Activator.getDefault().error(e);
		}
		return cls;
	}

	public EClass addDynamicFeature(EClass cls){
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IFile file = getImplemFile(cls.eResource());
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
							rRoot root = (rRoot) state.getContents().get(0);
							
							String type = "int";
							String attrName = "newFeature";
							String template = "\n\t"+type+" "+attrName+";\n";
							
							EList<rClass> allXtdCls = root.getXtendedClasses();
							Optional<rClass> search = allXtdCls.stream().filter(xtd -> xtd.getName().equals(cls.getName())).findFirst();
							
							rClass xtdCls = null;
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
									xEditor.selectAndReveal(endOffset+1, template.length() -3);
								}
							}
							else {
								ICompositeNode node = NodeModelUtils.findActualNodeFor(root);
								int endOffset = node.getEndOffset();
								String newXtdClass = "\nopen class "+cls.getName()+" {\n"+template+"}";
								document.replace(endOffset, 0,	newXtdClass);
								int templateOffset = endOffset + cls.getName().length() + 17;
								xEditor.selectAndReveal(templateOffset, template.length() -3);
							}
						}
					}
				});
			}
			
		} catch (PartInitException e) {
			Activator.getDefault().error(e);
		}
		return cls;
	}
	
	private static IFile getImplemFile(Resource ecoreResource) {
		IFile file = WorkspaceSynchronizer.getFile(ecoreResource);
		IPath dslPath = file.getFullPath().removeFileExtension().addFileExtension(IMPLEM_EXTENSION);
		IWorkspaceRoot ws = ResourcesPlugin.getWorkspace().getRoot();
		IFile implemFile = ws.getFile(dslPath);
		return implemFile;
	}
}
