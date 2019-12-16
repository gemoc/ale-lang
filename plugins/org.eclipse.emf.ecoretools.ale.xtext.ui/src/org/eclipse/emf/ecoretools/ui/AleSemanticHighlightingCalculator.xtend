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
package org.eclipse.emf.ecoretools.ui

import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.AbstractRule
import org.eclipse.xtext.Action
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.Keyword
import org.eclipse.xtext.RuleCall
import org.eclipse.xtext.TerminalRule
import org.eclipse.xtext.TypeRef
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator
import org.eclipse.xtext.impl.ActionImpl
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.CancelIndicator

class AleSemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	override provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		if (resource === null || resource.getParseResult() === null)
			return;
			
		val INode root = resource.getParseResult().getRootNode();
		for (INode node : root.getAsTreeIterable()) {
			
			if (node.grammarElement instanceof RuleCall) {
				var RuleCall rc = node.grammarElement as RuleCall;
                val EObject c = node.grammarElement.eContainer;
                
                // Tests whether the node represents the name of an element (class, method, parameter).
                if(c instanceof Assignment && (c as Assignment).getFeature().equals("name")) {
                    val INode p = node.getParent();
                    if (p !== null && p.grammarElement instanceof RuleCall) {
                        rc = p.grammarElement as RuleCall;
                        val AbstractRule r2 = rc.getRule();
			   
                        // Tests whether the parent node represents a method.                        
                        if (r2.name == "rOperation") {
                            acceptor.addPosition(node.getOffset(), node.getLength(), AleHighlightingConfiguration.METHOD_DEFINITION_ID);
                        }
                        else if (r2.name == "rTag") {
                            acceptor.addPosition(node.getOffset() - 1, node.getLength() + 1, AleHighlightingConfiguration.TAG_ID);
                        }
                        else if (r2.name == "rType") {
                            acceptor.addPosition(node.getOffset(), node.getLength(), AleHighlightingConfiguration.CLASSES_ID);
                        }
                        else if (r2.name == "rOpenClass") {
                            acceptor.addPosition(node.getOffset(), node.getLength(), AleHighlightingConfiguration.OPEN_CLASS_DEFINITION_ID);
                        }
                        else if (r2.name == "rVariable") {
                            acceptor.addPosition(node.getOffset(), node.getLength(), AleHighlightingConfiguration.METHOD_PARAMETER_ID);
                        }
                        else if (r2.name == "rService") {
                            acceptor.addPosition(node.getOffset(), node.getLength(), AleHighlightingConfiguration.SERVICE_IMPORT_ID);
                        }
                        else if (r2.name == "rAttribute") {
                        	acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.ATTRIBUTE_DECLARATION_ID);
                        }
                        else if (r2.name == "rVarDecl") {
                        	acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.LOCAL_VARIABLE_DECLARATION_ID)
                        }
                    }
                }
				// Tests whether the node represents an iterator            
                if(c instanceof Assignment && (c as Assignment).getFeature().equals("iterator")) {
                	val INode p = node.getParent();
                    if (p !== null && p.grammarElement instanceof RuleCall) {
                        rc = p.grammarElement as RuleCall;
                        val AbstractRule r2 = rc.getRule();
			   
                        // Matches for-each loops' iterator (e.g. for(<iterator> in <collection>)                     
                        if (r2.name == "rForEach") {
                            acceptor.addPosition(node.getOffset(), node.getLength(), AleHighlightingConfiguration.LOCAL_VARIABLE_DECLARATION_ID);
                        }
                    }
                }
			}
			else if (node.grammarElement instanceof Keyword) {
				val keywords = 
					#{"open", "class", "def", "open", "use", "behavior", "true", "false", 
					  "and", "or", "implies", "unique", "contains", "opposite", "override",
					  "import", "as", "for", "if", "while", "switch", "default", "xor", "not",
					  "then", "else", "endif", "in", "let", "null", "case"}
				
				// FIXME [Refactor] Those shouldn't be keywords; looks like a hack that should be fixed
				val misc = #{"String", "Integer", "Real", "Boolean", "Sequence", "OrderedSet"}
				
				if (keywords.contains(node.text)) {
					acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.KEYWORD_ID)
				}
				else if (! misc.contains(node.text)) {
					acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.PUNCTUATION_ID)
				}
			}
			else if (node.grammarElement instanceof TerminalRule) {
				val rule = node.grammarElement as TerminalRule
				if (rule.name == "SL_COMMENT") {
					acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.COMMENT_ID)
				}				
				else if (rule.name == "ML_COMMENT") {				
					acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.COMMENT_ID)
				}				
				else if (rule.name == "WS") {
					acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.DEFAULT_ID)
				}
				else {
					print("rule: " + rule.name)
					acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.DEFAULT_ID)
				}
			}
			else if (node.grammarElement instanceof Action) {
				val action = node.grammarElement as Action
				
				if (action.type instanceof TypeRef) {
					if (action.type.classifier.name == "Lit") {
						// Seems to be handled anyway
//						acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.STRING_ID)
					}
					else if (action.type.classifier.name.endsWith("Type")) {
						acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.CLASSES_ID)
					}
					else if (action.type.classifier.name == "Int") {
						acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.NUMBER_ID)
					}
					else if (action.type.classifier.name == "String") {
						acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.STRING_ID)
					}
					else if (action.type.classifier.name == "Block") {
						acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.DEFAULT_ID)
					}
					else if (action.type.classifier.name == "True" || action.type.classifier.name == "False") {
						// already handled by the Keyword rule
					}
					else if (action.type.classifier.name == "Call") {
						val text = node.text.trim
						var offset = node.offset
						var length = node.length
						
						if (text.contains(".")) {
							offset += text.indexOf('.')
							length -= text.indexOf('.')
						}
						acceptor.addPosition(offset, length, AleHighlightingConfiguration.METHOD_CALL_ID)
					}
					else if (action.type.classifier.name == "VarRef") {
						val variable = node.text.trim
						
						if (variable == "self") {
							acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.SELF_ID)
						}
						else if (variable == "result") {
							acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.RESULT_VARIABLE_ID)
						}
						else {
							acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.LOCAL_VARIABLE_REFERENCE_ID)
						}
					}
					else if (action.type.classifier.name == "Add") {
						// an addition or a subtraction, no specific style
					}
					else if (action.type.classifier.name == "Feature") {
						val dotIndex = node.text.trim.indexOf('.')
						if (dotIndex > 0) {
							acceptor.addPosition(node.offset + dotIndex + 1, node.length - dotIndex - 1, AleHighlightingConfiguration.ATTRIBUTE_ACCESS_ID)
						}
					}
					else if (action.type.classifier.name == "OrderedSet" || action.type.classifier.name == "Sequence") {
						// constructor call
						acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.METHOD_CALL_ID)
					}
					else {
						// at least operators like '>' and '<'
					}
				}
				else {
					acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.SERVICE_IMPORT_ID)
				}
			}
			else {
				acceptor.addPosition(node.offset, node.length, AleHighlightingConfiguration.DEFAULT_ID)
			}
		}
	}

}
