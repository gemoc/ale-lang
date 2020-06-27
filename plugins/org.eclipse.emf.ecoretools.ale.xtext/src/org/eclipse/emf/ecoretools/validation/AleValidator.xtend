/*
 * generated by Xtext 2.10.0
 */
package org.eclipse.emf.ecoretools.validation

import com.google.common.collect.Sets
import java.util.ArrayList
import java.util.List
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecoretools.AleXtextPlugin
import org.eclipse.emf.ecoretools.ale.OrderedSet
import org.eclipse.emf.ecoretools.ale.SeqType
import org.eclipse.emf.ecoretools.ale.Sequence
import org.eclipse.emf.ecoretools.ale.SetType
import org.eclipse.emf.ecoretools.ale.Unit
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message
import org.eclipse.emf.ecoretools.ale.core.env.impl.FileBasedAleEnvironment
import org.eclipse.emf.ecoretools.ale.core.interpreter.impl.AleInterpreter
import org.eclipse.emf.ecoretools.ale.core.validation.ALEValidator
import org.eclipse.emf.ecoretools.ale.core.validation.impl.TypeChecker
import org.eclipse.emf.ecoretools.ale.ide.project.IAleProject
import org.eclipse.emf.ecoretools.ale.validation.DiagnosticsToEditorMarkerAdapter
import org.eclipse.emf.ecoretools.ale.validation.EditorMarkerFormatter
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.validation.Check

/**
 * Delegate validation to ALE validator
 */
class AleValidator extends AbstractAleValidator {
	
	public static String ALE_MARKER = "org.eclipse.emf.ecoretools.ale.xtext.AleMarker";
	
	@Check
	def checkIsValid(Unit root) {
		
		val IFile aleFile = WorkspaceSynchronizer.getFile(root.eResource);
		cleanUpMarkers(aleFile);
		
		val IProject project = aleFile.project;
		val env = IAleProject.from(project).environment;

		val interpreter = env.interpreter as AleInterpreter
		try {
			interpreter.initScope(Sets.newHashSet(),Sets.newHashSet(#[project.name]))
			val parsedSemantics = env.behaviors.parsedFiles
			
			/*
	    	 * Register services
	    	 */
	    	val List<String> services = 
	    		parsedSemantics
		    	.map[getRoot()]
		    	.filterNull
		    	.map[getServices()]
		    	.flatten
		    	.toList
	    	interpreter.registerServices(services)
			
			val ALEValidator validator = new ALEValidator(env);
			validator.validate(parsedSemantics);
			val List<Message> msgs = validator.getMessages();
			
			val markerFactory = new DiagnosticsToEditorMarkerAdapter([ str | aleFile.createMarker(str) ], new EditorMarkerFormatter(new TypeChecker(null, env.context)))
			
			msgs.forEach[msg | markerFactory.doSwitch(msg)]
		}
		catch (Exception e) {
			val marker = aleFile.createMarker(ALE_MARKER)
			marker.setAttribute(IMarker.MESSAGE, "An internal error occurred while validating the file: " + e.message)
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR)
			marker.setAttribute(IMarker.CHAR_START, 0)
			marker.setAttribute(IMarker.CHAR_END, 0)
			
			AleXtextPlugin.error("An internal error occurred while validating " + aleFile, e)
		}
		finally {
			env.close()
		}
		
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
	static def void resolveUris(FileBasedAleEnvironment dsl) {
		val newSemantics = new ArrayList<String>();
		val ws = ResourcesPlugin.getWorkspace();
		dsl.getBehaviorsSources()
			.forEach[elem |
				val uri = URI.createURI(elem);
				if(ws !== null && uri.isPlatform()) {
					val file = ws.getRoot().findMember(uri.toPlatformString(true));
					val path = file.getLocationURI().getRawPath();
					newSemantics.add(path);
				}
				else {
					newSemantics.add(elem);
				}
			]
		dsl.getBehaviorsSources().clear();
		dsl.getBehaviorsSources().addAll(newSemantics);
	}
	
	private def cleanUpMarkers(IFile file) {
		file.deleteMarkers(ALE_MARKER, true, IResource.DEPTH_ZERO);
	}
}
