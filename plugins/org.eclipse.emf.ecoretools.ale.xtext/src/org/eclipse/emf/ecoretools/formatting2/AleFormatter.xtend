package org.eclipse.emf.ecoretools.formatting2

import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.emf.ecoretools.ale.Unit
import org.eclipse.emf.ecoretools.ale.BehavioredClass
import org.eclipse.emf.ecoretools.ale.Operation
import org.eclipse.emf.ecoretools.ale.Block
import org.eclipse.emf.ecoretools.ale.If
import org.eclipse.emf.ecoretools.ale.ForEach
import org.eclipse.emf.ecoretools.ale.While

class AleFormatter extends AbstractFormatter2 {
	
	def dispatch void format(Unit unit, extension IFormattableDocument document) {		
		for (semicolon : unit.allRegionsFor.keywords(";")) {
			semicolon.surround[noSpace].append[newLine]
		}
		for (colon : unit.allRegionsFor.keywords(":")) {
			colon.surround[noSpace].append[newLine]
		}
		for (doublecolon : unit.allRegionsFor.keywords("::")) {
			doublecolon.surround[noSpace]
		}
		for (dot : unit.allRegionsFor.keywords(".")) {
			dot.surround[noSpace]
		}
		for (comma : unit.allRegionsFor.keywords(",")) {
			comma.prepend[noSpace]
		}
		for (at : unit.allRegionsFor.keywords("@")) {
			at.surround[noSpace]
		}
		for (parenthesispair : unit.allRegionsFor.keywordPairs("(", ")")) {
			parenthesispair.key.surround[noSpace]
			parenthesispair.value.prepend[noSpace]
		}
		for (curlypair : unit.allRegionsFor.keywordPairs("{", "}")) {
			curlypair.key.append[noSpace]
			curlypair.value.surround[noSpace]
			if (curlypair.key.nextSemanticRegion != curlypair.value) {
				curlypair.key.append[newLine]
				curlypair.value.append[newLine]
				curlypair.interior[indent]
			}
		}
		
		unit.regionFor.keyword(";").append[newLines=2; highPriority]
		
		for (xtendedClass : unit.xtendedClasses) {
			xtendedClass.format
		}
	}
	
	def dispatch void format(BehavioredClass xtendedClass, extension IFormattableDocument document) {
		val end = xtendedClass.regionFor.keyword("}")
		if (end.nextSemanticRegion !== null) {
			end.append[newLines=2; highPriority]
		}
		
		for (operation : xtendedClass.operations) {
			operation.format
		}
	}
	
	def dispatch void format(Operation operation, extension IFormattableDocument document) {
		operation.tag.forEach[it.append[newLine]]
		if (operation.eContainer !== null && operation.eContainer instanceof BehavioredClass) {
			val behavioredClass = operation.eContainer as BehavioredClass
			if (behavioredClass.attributes.size > 0
					|| behavioredClass.operations.indexOf(operation) > 0) {
				operation.prepend[newLines=2; highPriority]
			} 
		}
		
		operation.body.format
	}
	
	def dispatch void format(Block block, extension IFormattableDocument document) {
		for (statement : block.statements) {
			if (statement instanceof If) {
				val sIf = statement as If
				sIf.regionFor.keyword("if").append[oneSpace; highPriority]
				sIf.then.format
				if (sIf.getElse !== null) {
					sIf.regionFor.keyword("else").prepend[newLines=0; oneSpace; highPriority]
					sIf.regionFor.keyword("else").append[oneSpace; highPriority]
					sIf.getElse.format	
				}
			} else if (statement instanceof ForEach) {
				val sForEach = statement as ForEach
				sForEach.regionFor.keyword("for").append[oneSpace; highPriority]
			} else if (statement instanceof While) {
				val sWhile = statement as While
				sWhile.regionFor.keyword("while").append[oneSpace; highPriority]
			}
		}
	}	
}