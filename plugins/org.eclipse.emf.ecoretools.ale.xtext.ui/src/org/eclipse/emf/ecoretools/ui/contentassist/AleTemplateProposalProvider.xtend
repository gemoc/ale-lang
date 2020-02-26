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

import java.util.Set
import javax.inject.Inject
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EOperation
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecoretools.ale.Block
import org.eclipse.emf.ecoretools.ale.ExtendedClass
import org.eclipse.emf.ecoretools.ale.VarRef
import org.eclipse.emf.ecoretools.ale.core.parser.internal.DslSemantics
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass
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
	val matchesCandidatesContainingTypedText = new PrefixMatcher {
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
			 * Autocomplete <element>.<typed>|
			 */
			if (element instanceof VarRef) {
				val typed = if (prefix.contains('.')) prefix.substring(prefix.indexOf('.') + 1) else prefix
				
				val semantics = element.semantics
				val elementType = element.findType(semantics)
			
				if (elementType instanceof BehavioredClass) {
					acceptor.createProposalsForBehavioredClass(elementType, element, semantics, typed, templateContext, context)
				}
				else if (elementType instanceof ETypedElement) {
					acceptor.createProposalsForETypedElement(elementType, element, semantics, typed, templateContext, context)
				}
			}
		}
	}
	
	private def createProposalsForBehavioredClass(ITemplateAcceptor acceptor, BehavioredClass clazz, EObject syntax, DslSemantics semantics, String typed, TemplateContext templateContext, ContentAssistContext context) {
		// Used to ensure that only one template is created for overridden operations (which are defined both in Ecore and ALE)
		val proposedOperations = newHashSet()
		 
		// Autocomplete methods declared within the ALE script
			 
		clazz.methods
			 .filter[method | matchesCandidatesContainingTypedText.isCandidateMatchingPrefix(method.operationRef.name, typed)]
			 .forEach[method | 
			 	acceptor.createProposalFor(method.operationRef, templateContext, context, proposedOperations)
			 ]
				
		// Autocomplete methods declared within the Ecore model
				
		if (clazz instanceof ExtendedClass) {
			val extendedClassInEcore = clazz as ExtendedClass
			val extendedClassInAleScript = semantics.behaviors
					          						.flatMap[root | root.classExtensions]
					          						.findFirst[ext | extendedClassInEcore.name == ext.baseClass.name]
					          							
			extendedClassInAleScript.baseClass
									.EOperations
									.filter[operation | matchesCandidatesContainingTypedText.isCandidateMatchingPrefix(operation.name, typed)]
									.forEach[operation | acceptor.createProposalFor(operation, templateContext, context, proposedOperations)]
		}
	}
	
	private def createProposalsForETypedElement(ITemplateAcceptor acceptor, ETypedElement clazz, EObject syntax, DslSemantics semantics, String typed, TemplateContext templateContext, ContentAssistContext context) {
		if (!clazz.isMany && clazz.EType instanceof EClass) {
			acceptor.createProposalsForEClass(clazz.EType as EClass, syntax, semantics, typed, templateContext, context)
		}
	}
	
	private def createProposalsForEClass(ITemplateAcceptor acceptor, EClass clazz, EObject syntax, DslSemantics semantics, String typed, TemplateContext templateContext, ContentAssistContext context) {
		// Used to ensure that only one template is created for overridden operations (which are defined both in Ecore and ALE)
		val proposedOperations = newHashSet()
		 
		// Autocomplete methods declared within the ALE script
			 
		clazz.EOperations
			 .filter[operation | matchesCandidatesContainingTypedText.isCandidateMatchingPrefix(operation.name, typed)]
			 .forEach[operation | acceptor.createProposalFor(operation, templateContext, context, proposedOperations)]
				
		// Autocomplete methods declared within the Ecore model
				
		if (clazz instanceof ExtendedClass) {
			val extendedClassInEcore = clazz as ExtendedClass
			val extendedClassInAleScript = semantics.behaviors
					          						.flatMap[root | root.classExtensions]
					          						.findFirst[ext | extendedClassInEcore.name == ext.baseClass.name]
					          							
			extendedClassInAleScript.baseClass
									.EOperations
									.filter[operation | matchesCandidatesContainingTypedText.isCandidateMatchingPrefix(operation.name, typed)]
									.forEach[operation | acceptor.createProposalFor(operation, templateContext, context, proposedOperations)]
		}
	}
	
	private def createProposalFor(ITemplateAcceptor acceptor, EOperation operation, TemplateContext templateContext, ContentAssistContext context, Set<String> proposedOperations) {
		val templateName = operation.name + "(" + operation.EParameters.map[param | param.EType.name + " " + param.name].join(", ") + ") : " + operation.EType.asString
		val templatePattern = operation.name + "(" + operation.EParameters.map[param | "${" + param.name + "}"].join(", ") + ")"
						
		val template = new Template(templateName, "", templateName, templatePattern, false);
		val proposal = doCreateProposal(template, templateContext, context, getImage(template), getRelevance(template))

		val fProposal = new AleTemplateProposal(matchesCandidatesContainingTypedText, template, templateContext, context.replaceRegion, proposal.image, proposal.relevance)
		acceptor.accept(fProposal)
		
		return templateName
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