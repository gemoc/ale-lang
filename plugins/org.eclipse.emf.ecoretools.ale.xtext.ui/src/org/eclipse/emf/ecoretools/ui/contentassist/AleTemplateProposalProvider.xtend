/*******************************************************************************
 * Copyright (c) 2019 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ui.contentassist

import java.io.ByteArrayInputStream
import java.nio.charset.StandardCharsets
import java.util.Arrays
import java.util.List
import javax.inject.Inject
import org.eclipse.core.resources.IFile
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import org.eclipse.emf.ecoretools.ale.ALEInterpreter
import org.eclipse.emf.ecoretools.ale.BehavioredClass
import org.eclipse.emf.ecoretools.ale.Block
import org.eclipse.emf.ecoretools.ale.ExtendedClass
import org.eclipse.emf.ecoretools.ale.VarRef
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer
import org.eclipse.jface.text.templates.ContextTypeRegistry
import org.eclipse.jface.text.templates.Template
import org.eclipse.jface.text.templates.TemplateContext
import org.eclipse.jface.text.templates.persistence.TemplateStore
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.impl.AbstractNode
import org.eclipse.xtext.nodemodel.impl.CompositeNode
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ITemplateAcceptor
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper
import org.eclipse.xtext.ui.editor.templates.DefaultTemplateProposalProvider
import org.eclipse.xtext.ui.editor.templates.XtextTemplateContext

import static extension org.eclipse.emf.ecoretools.ui.contentassist.TypeUtils.*

/**
 * Dynamically provides templates for ALE's proposal provider.
 * <p>
 * Templates are used to provide autocomplete for operations: unlike bare
 * proposals templates can declare 'stakeholders' which make easier for the
 * user to type operations' parameters. 
 */
class AleTemplateProposalProvider extends DefaultTemplateProposalProvider {
	
	/**
	 * Avoid duplicated templates
	 */
	val matcher = new PrefixMatcher {
		override isCandidateMatchingPrefix(String name, String prefix) {
			val cleanName = name.toLowerCase
			val cleanPrefix = prefix.toLowerCase
			
			if (cleanPrefix.isEmpty) {
				return true;
			}
			if (cleanName.startsWith(cleanPrefix)) {
				return true;
			}
			if (cleanName.contains(cleanPrefix)) {
				return true;
			}
			return false
		}
	}
	
	@Inject
	new(TemplateStore templateStore, ContextTypeRegistry registry, ContextTypeIdHelper helper) {
		super(templateStore, registry, helper)
	}
	
	override createTemplates(TemplateContext templateContext, ContentAssistContext context, ITemplateAcceptor acceptor) {
		if (templateContext instanceof XtextTemplateContext) {
			val prefix = context.offsetPrefix.trim
			val element = context.currentModel
			
			/*
			 * Autocomplete self.<typed>
			 */
			if (prefix.startsWith("self.") || (element instanceof VarRef && ((element as VarRef).ID == "self"))) {
				val typed = prefix.contains('.') ? prefix.substring(prefix.indexOf('.') + 1) : prefix
				var clazz = element.enclosingBehavioredClass
				
				// Used to ensure that only one template is created for overridden operations (which are defined both in Ecore and ALE)
				val operationsProcessed = newArrayList()
				 
				// Autocomplete methods declared within the Ecore model
				
				if (clazz instanceof ExtendedClass) {
					val extendedClassInEcore = clazz as ExtendedClass
					val semantics = getSemantics(element, context);
					val extendedClassInAleScript = semantics.filter[unit | unit.root !== null]
							          						.map[unit | unit.root]
							          						.flatMap[root | root.classExtensions]
							          						.findFirst[ext | extendedClassInEcore.name == ext.baseClass.name]
							          							
					extendedClassInAleScript.baseClass
											.EOperations
											.filter[operation | matcher.isCandidateMatchingPrefix(operation.name, typed)]
											.forEach[operation |
												val text = operation.name + "(" + operation.EParameters.map[param | param.EType.name + " " + param.name].join(", ") + ") : " + operation.EType.name
						
												val template = new Template(text, "", text, text, false);
												val proposal = doCreateProposal(template, templateContext, context, getImage(template), getRelevance(template))
						
												val fProposal = new AleTemplateProposal(matcher, template, templateContext, context.replaceRegion, proposal.image, proposal.relevance)
												acceptor.accept(fProposal)
												
												operationsProcessed += text
											]
				}
				 
				// Autocomplete methods declared within the ALE script
					 
				clazz.operations
					 .filter[operation | matcher.isCandidateMatchingPrefix(operation.name, typed)]
					 .forEach[operation |
						val templateName = operation.name + "(" + operation.params.map[param | param.type.asString + " " + param.name].join(", ") + ") : " + operation.type.asString

						// The operations is overridden & a template has already been created						
						if (operationsProcessed.contains(templateName)) {
							return
						}
						val templatePattern = operation.name + "(" + operation.params.map[param | "${" + param.name + "}"].join(", ") + ")"

						val template = new Template(templateName, "", templateName, templatePattern, false);
						val proposal = doCreateProposal(template, templateContext, context, getImage(template), getRelevance(template))

						val fProposal = new AleTemplateProposal(matcher, template, templateContext, context.replaceRegion, proposal.image, proposal.relevance)
						acceptor.accept(fProposal)
					 ]
					 
			}
		}
	}
	
	def getSemantics(EObject model, ContentAssistContext context) {
		/*
		 * Metamodel input
		 */
		val IFile aleFile = WorkspaceSynchronizer.getFile(model.eResource);
		val IPath dslPath = aleFile.getFullPath().removeFileExtension().addFileExtension("ecore");
    	val rs = new ResourceSetImpl();
    	rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
    	val ecorePkgs = DslBuilder.load(dslPath.toString,rs);
		
		/*
		 * ALE input
		 */
		val stream = new ByteArrayInputStream(context.document.get().getBytes(StandardCharsets.UTF_8));
		
		/*
		 * Parse result
		 */
		val ALEInterpreter interpreter = new ALEInterpreter();
		val List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(ecorePkgs,Arrays.asList(stream));
		
		return parsedSemantics;
	}
	
	private def enclosingBehavioredClass(EObject element) {
		var clazz = element.eContainer
		while (!(clazz instanceof BehavioredClass) && clazz !== null) {
			clazz = clazz.eContainer
		}
		return clazz as BehavioredClass
	}
	
	/**
	 * Find the Block node containing this node
	 * 
	 * Return null if not found
	 */
	private def CompositeNode getBlockNode(INode node) {
		val debugDump = NodeModelUtils.compactDump(node.rootNode,true)
		var current = node;
		while(current != null) {
			if(current instanceof CompositeNodeWithSemanticElement) {
				if(current.semanticElement instanceof Block){
					return current;
				}
			}
			current = current.parent
		}
		return null;
	}
	
	/**
	 * Find the Statement node at the offset
	 * 
	 * Return null if not found
	 */
	private def AbstractNode findStatementNode(INode node, int offset) {
		val block = getBlockNode(node)
		//val debugDump = NodeModelUtils.compactDump(block,true)
		if(block != null) {
			val candidate = block.basicGetChildren.findFirst[child |
				child.textRegion.contains(offset)
			]
			return candidate;
		}
		return null;
	}
	
	/**
	 * Assuming {@link text} is a statement, try to find the start of the expression around the offset
	 */
	private def int findStart(String text, int offset) {
		
		/*
		 * Assign case
		 */
		var i = offset
		while(i > 0) {
			val frame = text.substring(i-1,i+1);
			if(frame == ':=' || frame == '+=' || frame == '-=' || frame == 'in') {
				if(i == offset) {
					return offset;
				}
				else {
					return i + 1;
				}
			}
			i--
		}
		
		/*
		 * While case
		 */
		val whileIndex = text.indexOf('while')
		if(whileIndex != -1) {
			val openIndex = text.indexOf('(',whileIndex)
			if(openIndex != -1) {
				return openIndex;
			}
		}
		 
		 
		/*
		 * If case
		 */
		val ifIndex = text.indexOf('if')
		if(ifIndex != -1) {
			val openIndex = text.indexOf('(',ifIndex)
			val thenIndex = text.indexOf('then',ifIndex)
			if(openIndex != -1 && (thenIndex == -1 || openIndex < thenIndex)) { //check 'if' is not an 'if expression'
				return openIndex
			}
		}
		 
		/*
		 * Simple expression / default case
		 */
		return 0
	}
	
	/**
	 * Return the beginning of the expression before the offset
	 */
	private def String getOffsetPrefix(ContentAssistContext context) {
		val stmtNode = findStatementNode(context.currentNode, context.offset-1)
		if(stmtNode !== null) {
			val stmtText = context.document.get(stmtNode.offset,stmtNode.length)
			val startIndex = findStart(stmtText,context.offset-1-stmtNode.offset)
			val startOffset = stmtNode.offset + startIndex
			return context.document.get(startOffset,context.offset-startOffset)
		}
		return ""
	}
	
}