/*
 * generated by Xtext 2.10.0
 */
package org.eclipse.emf.ecoretools.ui.contentassist

import java.util.List
import org.eclipse.acceleo.query.ast.Expression
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.ETypedElement
import org.eclipse.emf.ecore.EcorePackage
import org.eclipse.emf.ecoretools.ale.ExtendedClass
import org.eclipse.emf.ecoretools.ale.VarRef
import org.eclipse.emf.ecoretools.ale.core.env.IBehaviors
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass
import org.eclipse.emf.ecoretools.ale.implementation.Block
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.jface.viewers.StyledString
import org.eclipse.jface.viewers.StyledString.Styler
import org.eclipse.swt.graphics.TextStyle
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.impl.AbstractNode
import org.eclipse.xtext.nodemodel.impl.CompositeNode
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher

import static extension org.eclipse.emf.ecoretools.ui.contentassist.TypeUtils.*

/**
 * Provides autocomplete for ALE.
 * <p>
 * Currently only autocomplete {@code self}'s attributes.
 */
class AleProposalProvider extends AbstractAleProposalProvider {
	
	val matchesCandidatesContainingTypedText = new PrefixMatcher {
		override isCandidateMatchingPrefix(String name, String prefix) {
			if (prefix.isEmpty) {
				return true;
			}
			if (name.startsWith(prefix)) {
				return true;
			}
			if (name.contains(prefix)) {
				return true;
			}
			return false
		}
	}
	
	val attributeNameStyler = new Styler() {
		override applyStyles(TextStyle textStyle) {
			// keep default style
		}
	}
	
	val attributeTypeStyler = StyledString.QUALIFIER_STYLER
	
	val matchingCharactersStyler = new Styler() {
		override applyStyles(TextStyle textStyle) {
			// Actually I'd like to use bold but found no way...
		}
	}
	
	override completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		// Prevent Xtext from proposing keywords all the time (especially when inappropriate)
        return;
    }
    
    override completeRuleCall(RuleCall object, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
    	// Prevent Xtext from proposing unexpected proposals (such as '1')
    	return;
    }
    
    override completeROpenClass_Name(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		try (val env = model.aleEnvironment) {
			val eClasses = env.metamodels.flatMap[EClassifiers.filter[EClass.isAssignableFrom(it.class)].map[EClass.cast(it)]]
										 .filter[name.startsWith(context.prefix)]
			acceptor.createOpenClassProposal(eClasses, context)
		}
	}
	
	override completeRForEach_Collection(EObject element, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val typed = if (context.prefix.contains('.')) context.prefix.substring(context.prefix.indexOf('.') + 1) else context.prefix
			
		val enclosingClass = EcoreUtil2.getContainerOfType(element, org.eclipse.emf.ecoretools.ale.BehavioredClass)

		if (enclosingClass !== null) {
			val semantics = element.semantics
			semantics.findClass(enclosingClass.name).ifPresent[ behaviorClass |

				// Autocomplete attributes declared in the .ale
				//
				behaviorClass.attributes
					 		 .filter[attribute | matchesCandidatesContainingTypedText.isCandidateMatchingPrefix(attribute.featureRef.name, typed)]
					 		 .filter[attribute | attribute.featureRef.isMany || attribute.featureRef.EType == EcorePackage.eINSTANCE.EEList]
					 		 .forEach[attribute | acceptor.createAttributeProposal('self.' + attribute.featureRef.name, attribute.featureRef.typeAsString, typed, context)]
					
				// Autocomplete attributes declared in the .ecore
				// 		 
				if (behaviorClass instanceof org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass) {
					behaviorClass.baseClass.EStructuralFeatures
										   .filter[feature | matchesCandidatesContainingTypedText.isCandidateMatchingPrefix(feature.name, typed)]
										   .filter[feature| feature.isMany || feature.EType == EcorePackage.eINSTANCE.EEList]
										   .forEach[feature | acceptor.createAttributeProposal('self.' + feature.name, feature.typeAsString, typed, context)]
				}
			]
		}
	}
	
	override completeExpression_Feature(EObject element, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		val prefix = getOffsetPrefix(context)
		
		// FIXME get expected type to filter out irrelevant proposals
		//		 e.g. do not suggests 'self.name' when completing 'for (i in self.|)'
		
		/*
		 * Autocomplete <element>.<typed>|
		 */
		if (element instanceof VarRef) {
			val typed = if (prefix.contains('.')) prefix.substring(prefix.indexOf('.') + 1) else prefix
			
			val semantics = element.semantics
			val elementType = element.findType(semantics)
			
			if (elementType instanceof BehavioredClass) {
				acceptor.createProposalsForBehavioredClass(elementType, element, semantics, typed, context)
			}
			else if (elementType instanceof ETypedElement) {
				acceptor.createProposalsForETypedElement(elementType, element, semantics, typed, context)
			}
		}
	}
	
	private def createProposalsForBehavioredClass(ICompletionProposalAcceptor acceptor, BehavioredClass clazz, EObject syntax, IBehaviors semantics, String typed, ContentAssistContext context) {
		// Autocomplete attributes declared within the ALE script
		
		clazz.attributes
			 .filter[attribute | matchesCandidatesContainingTypedText.isCandidateMatchingPrefix(attribute.featureRef.name, typed)]
			 .forEach[attribute | acceptor.createAttributeProposal(attribute.featureRef.name, attribute.featureRef.typeAsString, typed, context)]
			 
		// Autocomplete features declared in the Ecore model
			 
		if (clazz instanceof ExtendedClass) {
			val extendedClassInEcore = clazz as ExtendedClass
			val extendedClassInAleScript = semantics.openClasses
					          						.findFirst[ext | extendedClassInEcore.name == ext.baseClass.name]
					          
			extendedClassInAleScript.baseClass.EStructuralFeatures
									.filter[feature | matchesCandidatesContainingTypedText.isCandidateMatchingPrefix(feature.name, typed)]
									.forEach[feature | acceptor.createAttributeProposal(feature.name, feature.typeAsString, typed, context)]
		}
	}
	
	private def createProposalsForETypedElement(ICompletionProposalAcceptor acceptor, ETypedElement clazz, EObject syntax, IBehaviors semantics, String typed, ContentAssistContext context) {
		if (!clazz.isMany && clazz.EType instanceof EClass) {
			acceptor.createProposalsForEClass(clazz.EType as EClass, syntax, semantics, typed, context)
		}
	}
	
	private def createProposalsForEClass(ICompletionProposalAcceptor acceptor, EClass clazz, EObject syntax, IBehaviors semantics, String typed, ContentAssistContext context) {
		// Autocomplete attributes declared within the ALE script
		
		clazz.EStructuralFeatures
			 .filter[feature | matchesCandidatesContainingTypedText.isCandidateMatchingPrefix(feature.name, typed)]
			 .forEach[feature | acceptor.createAttributeProposal(feature.name, feature.typeAsString, typed, context)]
			 
		// Autocomplete features declared in the Ecore model
			 
		if (clazz instanceof ExtendedClass) {
			val extendedClassInEcore = clazz as ExtendedClass
			val extendedClassInAleScript = semantics.openClasses
					          						.findFirst[ext | extendedClassInEcore.name == ext.baseClass.name]
					          
			extendedClassInAleScript.baseClass.EStructuralFeatures
									.filter[feature | matchesCandidatesContainingTypedText.isCandidateMatchingPrefix(feature.name, typed)]
									.forEach[feature | acceptor.createAttributeProposal(feature.name, feature.typeAsString, typed, context)]
		}
	}
	
	private def createAttributeProposal(ICompletionProposalAcceptor acceptor, String name, String type, String typed, ContentAssistContext context) {
		val styledText = new StyledString(name + " : " + type)
		/*
		 * Style attribute's name
		 */
		styledText.setStyle(0, name.length, attributeNameStyler);
		/*
		 * Style attribute's type
		 */
		styledText.setStyle(styledText.length - type.length, type.length, attributeTypeStyler);
		/*
		 * Outline the matching characters
		 */
		val matchingCharactersIndex = name.indexOf(typed)
		styledText.setStyle(matchingCharactersIndex, typed.length, matchingCharactersStyler)
		
		val completion = doCreateProposal(name, styledText, null, getPriorityHelper().getDefaultPriority(), context)
		if (completion instanceof ConfigurableCompletionProposal) {
			completion.matcher = matchesCandidatesContainingTypedText;
		}
		acceptor.accept(completion)
	}
	
	private def createOpenClassProposal(ICompletionProposalAcceptor acceptor, Iterable<EClass> candidateEClasses, ContentAssistContext context) {
		for (EClass candidateEClass : candidateEClasses) {
			val eClassName = candidateEClass.asString
			val styledText = new StyledString(eClassName)
//		/*
//		 * Style attribute's name
//		 */
//		styledText.setStyle(0, eClassName.length, attributeNameStyler);
		
			val completion = doCreateProposal(eClassName, styledText, null, getPriorityHelper().getDefaultPriority(), context)
			if (completion instanceof ConfigurableCompletionProposal) {
				completion.matcher = matchesCandidatesContainingTypedText;
			}
			acceptor.accept(completion)
		}
	}
	
	override completeExpression_Name(EObject model, Assignment assignment, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
//		addProposals(candidate,model,context,acceptor)
//		acceptor.accept(doCreateProposal("[DEBUG] name", null, null, getPriorityHelper().getDefaultPriority()+1,context))
	}
	
	override complete_expression(EObject model, RuleCall ruleCall, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
//		addProposals(candidate,model,context,acceptor)
//		acceptor.accept(doCreateProposal("[DEBUG] expression", null, null, getPriorityHelper().getDefaultPriority()+1,context))
	}
	
	private def void addProposals(String expression, EObject model, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
			
//			if(expression.isEmpty) {
//				return
//			}
//			
//			/*
//			 * Metamodel input
//			 */
//			val IFile aleFile = WorkspaceSynchronizer.getFile(model.eResource);
//			val IPath dslPath = aleFile.getFullPath().removeFileExtension().addFileExtension("ecore");
//	    	val rs = new ResourceSetImpl();
//	    	rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
//	    	val ecorePkgs = DslBuilder.load(dslPath.toString,rs);
//			
//			/*
//			 * ALE input
//			 */
//			val stream = new ByteArrayInputStream(context.document.get().getBytes(StandardCharsets.UTF_8));
//			
//			/*
//			 * Parse result
//			 */
//			val AleInterpreter interpreter = new AleInterpreter();
//			val List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(ecorePkgs,Arrays.asList(stream));
//			
//			/*
//	    	 * Register services
//	    	 */
//	    	val List<String> services = 
//	    		parsedSemantics
//		    	.map[getRoot()]
//		    	.filterNull
//		    	.map[getServices()]
//		    	.flatten
//		    	.toList
//	    	interpreter.registerServices(services)
//			
//			var Map<String, Set<IType>> variableTypes = newHashMap();
//			val contextExp = getExpression(parsedSemantics,context.offset-1)
//			val validator = new ALEValidator(interpreter.queryEnvironment)
//			if(contextExp !== null) {
//				variableTypes = validator.getValidationContext(contextExp,parsedSemantics)
//			}
//			if(variableTypes.entrySet.isEmpty) { //default: get block context
//				val block = getBlock(parsedSemantics,context.offset)
//				variableTypes = validator.getValidationContext(block,parsedSemantics)
//			}
//			
//			val QueryCompletionEngine engine = new QueryCompletionEngine(interpreter.getQueryEnvironment());
//			val ICompletionResult completionResult = engine.getCompletion(expression, expression.length, variableTypes);
//			val proposals = completionResult.getProposals(new BasicFilter(completionResult));
//					
//			proposals.forEach[proposal |
//				val styledText = new StyledString(proposal.proposal)
//				styledText.setStyle(0, proposal.proposal.length, StyledString.QUALIFIER_STYLER);
//				acceptor.accept(doCreateProposal(proposal.proposal, styledText, null, getPriorityHelper().getDefaultPriority()+1,context))
//			]
	}
	
	/**
	 * Search in the AST for an ALE Expression at the given offset.
	 * 
	 * Return null if not found
	 */
	private def Expression getExpression(List<ParsedFile<ModelUnit>> parsedSemantics, int offset) {
		
		var Expression res = null;
		var start = 0;
		var end = 0;
		
		if(!parsedSemantics.isEmpty) {
			//FIXME: search in all units
			val unit = parsedSemantics.head;
			val allExps = unit.getStartPositions.keySet.filter(Expression)
			val candidate = 
				allExps
				.findFirst[exp |
					 unit.getStartPositions.get(exp) <= offset && unit.getEndPositions.get(exp) >= offset
				]
				
			if(candidate !== null) {
				res = candidate
				start = unit.getStartPositions.get(candidate)
				end = unit.getEndPositions.get(candidate)
			
				while(res.eContainer instanceof Expression){
					res = res.eContainer as Expression
				}
			}
		}
		
		return res
	}
	
	/**
	 * Search in the AST for an ALE Block at the given offset.
	 * 
	 * Return null if not found
	 */
	private def Block getBlock(List<ParsedFile<ModelUnit>> parsedSemantics, int offset) {
		var Block res = null;
		var start = 0;
		var end = 0;
		
		if(!parsedSemantics.isEmpty) {
			//FIXME: search in all units
			val unit = parsedSemantics.head;
			val allExps = unit.getStartPositions.keySet.filter(Block)
			val candidate = 
				allExps
				.findFirst[block |
					 unit.getStartPositions.get(block) <= offset && unit.getEndPositions.get(block) >= offset
				]
				
			if(candidate !== null) {
				res = candidate
				start = unit.getStartPositions.get(candidate)
				end = unit.getEndPositions.get(candidate)
			
				for(block : allExps.drop(1)) {
					 start <= unit.getStartPositions.get(block) && unit.getEndPositions.get(block) <= end
					 start = unit.getStartPositions.get(block) 
					 end = unit.getEndPositions.get(block)
				}
			}
		}
		
		return res
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
