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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ProjectScope;
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
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecoretools.ale.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.Operation;
import org.eclipse.emf.ecoretools.ale.Unit;
import org.eclipse.emf.ecoretools.ale.core.parser.AstBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.ide.Activator;
import org.eclipse.emf.ecoretools.ale.ide.AlePreferenceStore;
import org.eclipse.emf.ecoretools.ale.implementation.Attribute;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelBehavior;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;
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
import org.eclipse.ui.preferences.ScopedPreferenceStore;
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
    				.filter(mtd -> mtd.getOperationRef() != null && mtd.getOperationRef().getName().equals(op.getName()) && mtd.getOperationRef().getEContainingClass() == xtdClass.getBaseClass())
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
				.filter(att -> att.getFeatureRef() instanceof EAttribute) //FIXME: show also not displayed EReferences
				.collect(Collectors.toList());
		}
    	
    	return new ArrayList<Attribute>();
    }
    
    public List<Attribute> getDynaAttrib(RuntimeClass cls){
		return 
			cls
			.getAttributes()
			.stream()
			.filter(att -> att.getFeatureRef() instanceof EAttribute) //FIXME: show also not displayed EReferences
			.collect(Collectors.toList());
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
    
    public List<Method> getMethod(RuntimeClass cls) {
		return 
			cls
			.getMethods()
			.stream()
			.filter(op -> op instanceof Method)
			.map(op -> (Method) op)
			.collect(Collectors.toList());
    }
    
    public ModelUnit getModelUnit(EPackage pkg) {
    	List<ModelUnit> res = getModelBehavior(pkg);
    	
    	if(!res.isEmpty()) {
    		return res.get(0); //TODO: manage several .ale files
    	}
    	
    	return null;
    }
    
	public EOperation editImplementation(EOperation op) {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IFile file = getImplemFile(op.eResource());
		IEditorDescriptor desc = PlatformUI.getWorkbench().
		        getEditorRegistry().getDefaultEditor(file.getName());
		try {
			IEditorPart oldEditor = page.getActiveEditor();
			IEditorPart editor = page.openEditor(new FileEditorInput(file), desc.getId());
			
			if(!hasXtextFocus(file.getProject())) {
				page.activate(oldEditor);
			}
			
			if(editor instanceof XtextEditor){
				XtextEditor xEditor = (XtextEditor) editor;
				IXtextDocument document = xEditor.getDocument();
				document.modify(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource state) throws Exception {
						if(state.getContents().size() > 0) {
							Unit root = (Unit) state.getContents().get(0);
							
							String returnType = "void";
							if(op.getEType() != null){
								returnType = op.getEType().getName();;
							}
							String parameters = op.getEParameters()
								.stream()
								.map(p -> p.getEType().getName()+" "+ p.getName())
								.collect(Collectors.joining(",","(",")"));
							String opName = op.getName();
							String content = "/* Write your code here */";
							String template = "\toverride "+returnType+" "+opName+" "+parameters+" {\n\t\t"+content+"\n\t}\n";
							
							EList<BehavioredClass> allXtdCls = root.getXtendedClasses();
							Optional<BehavioredClass> search = allXtdCls.stream().filter(xtd -> xtd.getName().equals(op.getEContainingClass().getName())).findFirst();
							
							BehavioredClass xtdCls = null;
							if(search.isPresent()){
								xtdCls = search.get(); 
								ICompositeNode node = NodeModelUtils.findActualNodeFor(xtdCls);
								
								Optional<Operation> opSearch = xtdCls.getOperations().stream().filter(o -> o.getName().equals(opName)).findFirst();
								if(!opSearch.isPresent()){
									int endOffset = node.getEndOffset();
									document.replace(endOffset-1, 0,	template);
									int bodyOffset = endOffset + returnType.length() + opName .length() + parameters.length() + 16 ;
									xEditor.selectAndReveal(bodyOffset, content.length());
								}
							}
							else {
								ICompositeNode node = NodeModelUtils.findActualNodeFor(root);
								int endOffset = node.getEndOffset();
								String newXtdClass = "\n\nopen class "+op.getEContainingClass().getName()+" {\n"+template+"}";
								document.replace(endOffset, 0,	newXtdClass);
								int templateOffset = endOffset + op.getEContainingClass().getName().length() + 16;
								int bodyOffset = templateOffset + returnType.length() + opName .length() + parameters.length() + 17;
								xEditor.selectAndReveal(bodyOffset, content.length());
							}
						}
					}
				});
				editor.doSave(new NullProgressMonitor());
			}
			
		} catch (PartInitException e) {
			Activator.getDefault().error(e);
		}
		return op;
	}
	
	public EObject addMethod(EObject obj) {
		
		final String className;
		final String keyword;
		
		if(obj instanceof EClass) {
			className = ((EClass)obj).getName();
			keyword = "open class";
		}
		else if(obj instanceof RuntimeClass) {
			className = ((RuntimeClass)obj).getName();
			keyword = "class";
		}
		else {
			return obj;
		}
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IFile file = getImplemFile(obj.eResource());
		IEditorDescriptor desc = PlatformUI.getWorkbench().
		        getEditorRegistry().getDefaultEditor(file.getName());
		try {
			IEditorPart oldEditor = page.getActiveEditor();
			IEditorPart editor = page.openEditor(new FileEditorInput(file), desc.getId());
			
			if(!hasXtextFocus(file.getProject())) {
				page.activate(oldEditor);
			}
			
			if(editor instanceof XtextEditor){
				XtextEditor xEditor = (XtextEditor) editor;
				IXtextDocument document = xEditor.getDocument();
				document.modify(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource state) throws Exception {
						if(state.getContents().size() > 0) {
							Unit root = (Unit) state.getContents().get(0);
							
							String returnType = "int";
							String parameters = "()";
							String opName = "newMethod";
							String template = "\tdef "+returnType+" "+opName+" "+parameters+" {\n\t\t/* Write your code here */\n\t\tresult := 0;\n\t}\n";
							
							EList<BehavioredClass> allXtdCls = root.getXtendedClasses();
							Optional<BehavioredClass> search = allXtdCls.stream().filter(xtd -> xtd.getName().equals(className)).findFirst();
							
							BehavioredClass xtdCls = null;
							if(search.isPresent()){
								xtdCls = search.get(); 
								ICompositeNode node = NodeModelUtils.findActualNodeFor(xtdCls);
								
								Optional<Operation> opSearch = xtdCls.getOperations().stream().filter(o -> o.getName().equals(opName)).findFirst();
								if(!opSearch.isPresent()){
									int endOffset = node.getEndOffset();
									document.replace(endOffset-1, 0, template);
									int nameOffest = endOffset + returnType.length() + 5;
									xEditor.selectAndReveal(nameOffest, opName.length());
								}
								else {
									for(int i = 2; i <= xtdCls.getOperations().size()+1; i++) {
										final String suffixedOpName = opName + i;  
										opSearch = xtdCls.getOperations().stream().filter(o -> o.getName().equals(suffixedOpName)).findFirst();
										if(!opSearch.isPresent()){
											template = "\tdef "+returnType+" "+suffixedOpName+" "+parameters+" {\n\t\t/* Write your code here */\n\t\tresult := 0;\n\t}\n";
											int endOffset = node.getEndOffset();
											document.replace(endOffset-1, 0, template);
											int nameOffest = endOffset + returnType.length() + 5;
											xEditor.selectAndReveal(nameOffest, suffixedOpName.length());
											break;
										}
									}
								}
							}
							else {
								ICompositeNode node = NodeModelUtils.findActualNodeFor(root);
								int endOffset = node.getEndOffset();
								String newXtdClass = "\n\n"+keyword+" "+className+" {\n"+template+"}";
								document.replace(endOffset, 0,	newXtdClass);
								int nameOffest = endOffset + keyword.length() + className.length() + returnType.length() + 12;
								xEditor.selectAndReveal(nameOffest, opName.length());
							}
						}
					}
				});
			}
			editor.doSave(new NullProgressMonitor());
		} catch (PartInitException e) {
			Activator.getDefault().error(e);
		}
		return obj;
	}

	
	public EObject addDynamicFeature(EObject obj){
		return addDynamicFeature(obj,"newFeature","int");
	}
	
	public EObject addDynamicFeature(EObject obj, String featureName, String typeName){
		
		final String className;
		final String keyword;
		
		if(obj instanceof EClass) {
			className = ((EClass)obj).getName();
			keyword = "open class";
		}
		else if(obj instanceof RuntimeClass) {
			className = ((RuntimeClass)obj).getName();
			keyword = "class";
		}
		else {
			return obj;
		}
		
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IFile file = getImplemFile(obj.eResource());
		IEditorDescriptor desc = PlatformUI.getWorkbench().
		        getEditorRegistry().getDefaultEditor(file.getName());
		try {
			IEditorPart oldEditor = page.getActiveEditor();
			IEditorPart editor = page.openEditor(new FileEditorInput(file), desc.getId());
			
			if(!hasXtextFocus(file.getProject())) {
				page.activate(oldEditor);
			}
			
			if(editor instanceof XtextEditor){
				XtextEditor xEditor = (XtextEditor) editor;
				IXtextDocument document = xEditor.getDocument();
				document.modify(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource state) throws Exception {
						if(state.getContents().size() > 0) {
							Unit root = (Unit) state.getContents().get(0);
							
							String template = "\n\t"+typeName+" "+featureName+";\n";
							
							EList<BehavioredClass> allXtdCls = root.getXtendedClasses();
							Optional<BehavioredClass> search = allXtdCls.stream().filter(xtd -> xtd.getName().equals(className)).findFirst();
							
							BehavioredClass xtdCls = null;
							if(search.isPresent()){
								xtdCls = search.get(); 
								ICompositeNode node = NodeModelUtils.findActualNodeFor(xtdCls);
								
								Optional<org.eclipse.emf.ecoretools.ale.Attribute> attrSearch = xtdCls.getAttributes().stream().filter(a -> a.getName().equals(featureName)).findFirst();
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
									int nameOffest = endOffset + typeName.length() + 2;
									xEditor.selectAndReveal(nameOffest, featureName.length());
								}
								else {
									for(int i = 2; i <= xtdCls.getAttributes().size()+1; i++) {
										final String suffixedFeatureName = featureName + i;  
										attrSearch = xtdCls.getAttributes().stream().filter(a -> a.getName().equals(suffixedFeatureName)).findFirst();
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
											
											template = "\n\t"+typeName+" "+suffixedFeatureName+";\n";
											document.replace(endOffset-1, 0, template);
											int nameOffest = endOffset + typeName.length() + 2;
											xEditor.selectAndReveal(nameOffest, suffixedFeatureName.length());
											break;
										}
									}
								}
							}
							else {
								ICompositeNode node = NodeModelUtils.findActualNodeFor(root);
								int endOffset = node.getEndOffset();
								String newXtdClass = "\n\n"+keyword+" "+className+" {\n"+template+"}";
								document.replace(endOffset, 0,	newXtdClass);
								int nameOffest = endOffset + keyword.length() + className.length() + typeName.length() + 9;
								xEditor.selectAndReveal(nameOffest, featureName.length());
							}
						}
					}
				});
				editor.doSave(new NullProgressMonitor());
			}
			
		} catch (PartInitException e) {
			Activator.getDefault().error(e);
		}
		return obj;
	}
	
	
	public void createRuntimeClass(EObject obj) {
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IFile file = getImplemFile(obj.eResource());
		IEditorDescriptor desc = PlatformUI.getWorkbench().
		        getEditorRegistry().getDefaultEditor(file.getName());
		try {
			IEditorPart oldEditor = page.getActiveEditor();
			IEditorPart editor = page.openEditor(new FileEditorInput(file), desc.getId());
			
			if(!hasXtextFocus(file.getProject())) {
				page.activate(oldEditor);
			}
			
			if(editor instanceof XtextEditor){
				XtextEditor xEditor = (XtextEditor) editor;
				IXtextDocument document = xEditor.getDocument();
				document.modify(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource state) throws Exception {
						if(state.getContents().size() > 0) {
							Unit root = (Unit) state.getContents().get(0);
							
							String newClassName = "NewRuntimeClass";
							String template = "\n\t/* Write your code here */\n";
							String newClass = "\n\nclass "+newClassName+" {\n"+template+"}";
							
							EList<BehavioredClass> allXtdCls = root.getXtendedClasses();
							Optional<BehavioredClass> search = allXtdCls.stream().filter(xtd -> xtd.getName().equals(newClassName)).findFirst();
							if(!search.isPresent()){
								ICompositeNode node = NodeModelUtils.findActualNodeFor(root);
								int endOffset = node.getEndOffset();
								document.replace(endOffset, 0,	newClass);
								int templateOffset = endOffset + newClassName.length() + 13;
								int nameOffest = endOffset + 8;
								xEditor.selectAndReveal(nameOffest, newClassName.length());
							}
							else {
								for(int i = 2; i <= allXtdCls.size()+1; i++) {
									final String suffixedClassName = newClassName + i;  
									search = allXtdCls.stream().filter(xtd -> xtd.getName().equals(suffixedClassName)).findFirst();
									if(!search.isPresent()){
										newClass = "\n\nclass "+suffixedClassName+" {\n"+template+"}";
										ICompositeNode node = NodeModelUtils.findActualNodeFor(root);
										int endOffset = node.getEndOffset();
										document.replace(endOffset, 0,	newClass);
										int templateOffset = endOffset + newClassName.length() + 13;
										int nameOffest = endOffset + 8;
										xEditor.selectAndReveal(nameOffest, suffixedClassName.length());
										break;
									}
								}
							}
						}
					}
				});
			}
			editor.doSave(new NullProgressMonitor());
		} catch (PartInitException e) {
			Activator.getDefault().error(e);
		}
	}
	
	private static IFile getImplemFile(Resource ecoreResource) {
		IFile file = WorkspaceSynchronizer.getFile(ecoreResource);
		IPath dslPath = file.getFullPath().removeFileExtension().addFileExtension(IMPLEM_EXTENSION);
		IWorkspaceRoot ws = ResourcesPlugin.getWorkspace().getRoot();
		IFile implemFile = ws.getFile(dslPath);
		return implemFile;
	}
	
	public EObject getSource(Attribute attrib) {
		
		EObject container = attrib.eContainer();
		if(container instanceof ExtendedClass) {
			return ((ExtendedClass)container).getBaseClass();
		}
		else if(container instanceof RuntimeClass) {
			return container;
		}
		
		return null;
	}
	
	public EObject getTarget(Attribute attrib) {
		
		EClassifier type = attrib.getFeatureRef().getEType();
		if(type.eResource() == null) {
			
			List<ModelUnit> modelUnits = attrib.eResource()
    			.getContents()
				.stream()
				.filter(elem -> elem instanceof ModelUnit)
				.map(elm -> (ModelUnit) elm)
				.collect(Collectors.toList());
			
			
	    	Optional<RuntimeClass> searchCls = 
				modelUnits
				.stream()
				.flatMap(u -> u.getClassDefinitions().stream())
				.filter(cls -> cls.getName().equals(type.getName())).findFirst();
	    	
			if(searchCls.isPresent()){
				return searchCls.get();
			}
	    	
		}
		
		return type;
	}
	
	private boolean hasXtextFocus(IProject project) {
		ScopedPreferenceStore store = new AlePreferenceStore(new ProjectScope(project), Activator.PLUGIN_ID);
		return store.getBoolean(AlePreferenceStore.ALE_PREF_XTEXT_FOCUS);
	}
}
