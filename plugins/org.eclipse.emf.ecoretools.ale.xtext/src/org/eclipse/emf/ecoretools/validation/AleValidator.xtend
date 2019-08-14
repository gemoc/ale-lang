/*
 * generated by Xtext 2.10.0
 */
package org.eclipse.emf.ecoretools.validation

import java.util.List
import org.eclipse.acceleo.query.runtime.IValidationMessage
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IWorkspaceRoot
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IPath
import org.eclipse.emf.ecoretools.ale.ALEInterpreter
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult
import org.eclipse.emf.ecoretools.ale.core.validation.ALEValidator
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer
import org.eclipse.xtext.validation.Check
import java.util.ArrayList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecoretools.ale.Unit
import com.google.common.collect.Sets
import java.util.Set
import org.eclipse.emf.ecoretools.ale.Sequence
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode
import org.eclipse.emf.ecoretools.ale.AlePackage
import org.eclipse.emf.ecoretools.ale.OrderedSet
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecoretools.ale.SeqType
import org.eclipse.emf.ecoretools.ale.SetType

/**
 * Delegate validation to ALE validator
 */
class AleValidator extends AbstractAleValidator {
	
	public static String ALE_MARKER = "org.eclipse.emf.ecoretools.ale.xtext.AleMarker";
	
	@Check
	def checkIsValid(Unit root) {
		
		val IFile aleFile = WorkspaceSynchronizer.getFile(root.eResource);
		cleanUpMarkers(aleFile);
		
		val IPath dslPath = aleFile.getFullPath().removeFileExtension().addFileExtension("dsl");
		val IWorkspaceRoot ws = ResourcesPlugin.getWorkspace().getRoot();
		val dslFile = ws.getFile(dslPath)
		val dsl = new Dsl(dslFile.contents);
		dsl.resolveUris
		val ALEInterpreter interpreter = new ALEInterpreter();
		interpreter.initScope(Sets.newHashSet(),Sets.newHashSet(#[dslFile.project.name]))
		val List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(dsl);
		
		/*
    	 * Register services
    	 */
    	val List<java.lang.String> services = 
    		parsedSemantics
	    	.map[getRoot()]
	    	.filterNull
	    	.map[getServices()]
	    	.flatten
	    	.toList
    	interpreter.registerServices(services)
		
		val ALEValidator validator = new ALEValidator(interpreter.queryEnvironment);
		validator.validate(parsedSemantics);
		val List<IValidationMessage> msgs = validator.getMessages();
		
		msgs.forEach[msg |
			val marker = aleFile.createMarker(ALE_MARKER);
			marker.setAttribute(IMarker.MESSAGE, msg.getMessage());
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			marker.setAttribute(IMarker.CHAR_START, msg.startPosition);
			marker.setAttribute(IMarker.CHAR_END, msg.endPosition);
		]
		
	}
	
	@Check
	def checkSequenceInitialization(Sequence sequence) {
		checkNoExtraSpaceAfterKeyword(sequence, "Sequence", "Sequence initialization")
	}
	
	@Check
	def checkOrderedSetInitialization(OrderedSet orderedSet) {
		checkNoExtraSpaceAfterKeyword(orderedSet, "OrderedSet", "OrderedSet initialization")
	}
	
	@Check
	def checkSequenceTypeDeclaration(SeqType seqType) {
		checkNoExtraSpaceAfterKeyword(seqType, "Sequence", "Sequence type declaration")
	}
	
	@Check
	def checkOrderedSetTypeDeclaration(SetType setType) {
		checkNoExtraSpaceAfterKeyword(setType, "OrderedSet", "OrderedSet type declaration")
	}
	
	def checkNoExtraSpaceAfterKeyword(EObject grammarElement, String keyword, String message) {		
		val node = NodeModelUtils.getNode(grammarElement)
		val keywordNode = node.children.findFirst[it.grammarElement instanceof Keyword
				&& (it.grammarElement as Keyword).value.equals(keyword)]
		if (keywordNode.nextSibling instanceof HiddenLeafNode) {
			messageAcceptor.acceptError("Extra space in " + message, grammarElement,
				keywordNode.endOffset, keywordNode.nextSibling.length, "")
		}
	}
	
	// copied from WorkbenchDsl (which introduce cyclic dependency if used)
	static def void resolveUris(Dsl dsl) {
		val newSemantics = new ArrayList<String>();
		val ws = ResourcesPlugin.getWorkspace();
		dsl.getAllSemantics()
			.forEach[elem |
				val uri = URI.createURI(elem);
				if(ws != null && uri.isPlatform()) {
					val file = ws.getRoot().findMember(uri.toPlatformString(true));
					val path = file.getLocationURI().getRawPath();
					newSemantics.add(path);
				}
				else {
					newSemantics.add(elem);
				}
			]
		dsl.getAllSemantics().clear();
		dsl.getAllSemantics().addAll(newSemantics);
	}
	
	private def cleanUpMarkers(IFile file) {
		file.deleteMarkers(ALE_MARKER, true, IResource.DEPTH_ZERO);
	}
}
