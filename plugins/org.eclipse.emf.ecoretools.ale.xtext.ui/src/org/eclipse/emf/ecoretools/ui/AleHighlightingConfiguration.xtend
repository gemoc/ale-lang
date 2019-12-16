/*******************************************************************************
 * Copyright (c) 2019-2020 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ui

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor

class AleHighlightingConfiguration extends DefaultHighlightingConfiguration {
	
	public static val String ATTRIBUTE_ACCESS_ID = "Attribute access"
	public static val String ATTRIBUTE_DECLARATION_ID = "Attribute declaration"
	public static val String CLASSES_ID = "Classes";
	public static val String LOCAL_VARIABLE_DECLARATION_ID = "Local variable declaration"
	public static val String LOCAL_VARIABLE_REFERENCE_ID = "Local variable reference"
	public static val String METHOD_CALL_ID = "Method call";
	public static val String METHOD_DEFINITION_ID = "Method definition"
	public static val String METHOD_PARAMETER_ID = "Method parameter";
	public static val String OPEN_CLASS_DEFINITION_ID = "Open class definition"
	public static val String RESULT_VARIABLE_ID = "Result variable"
	public static val String SELF_ID = "Self keyword";
	public static val String SERVICE_IMPORT_ID = "Service import";
	public static val String TAG_ID = "Tag"
	
	override configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(ATTRIBUTE_ACCESS_ID, ATTRIBUTE_ACCESS_ID, attributeDeclarationStyle)
		acceptor.acceptDefaultHighlighting(ATTRIBUTE_DECLARATION_ID, ATTRIBUTE_DECLARATION_ID, attributeAccessStyle)
		acceptor.acceptDefaultHighlighting(CLASSES_ID, CLASSES_ID, classesStyle())
		acceptor.acceptDefaultHighlighting(COMMENT_ID, "Comment", commentTextStyle)
		acceptor.acceptDefaultHighlighting(DEFAULT_ID, "Default", defaultTextStyle)
		acceptor.acceptDefaultHighlighting(KEYWORD_ID, "Keyword", keywordTextStyle)
		acceptor.acceptDefaultHighlighting(LOCAL_VARIABLE_DECLARATION_ID, LOCAL_VARIABLE_DECLARATION_ID, localVariableStyle)
		acceptor.acceptDefaultHighlighting(LOCAL_VARIABLE_REFERENCE_ID, LOCAL_VARIABLE_REFERENCE_ID, localVariableStyle)
		acceptor.acceptDefaultHighlighting(METHOD_CALL_ID, METHOD_CALL_ID, methodCallStyle)
		acceptor.acceptDefaultHighlighting(METHOD_DEFINITION_ID, METHOD_DEFINITION_ID, methodStyle())
		acceptor.acceptDefaultHighlighting(METHOD_PARAMETER_ID, METHOD_PARAMETER_ID, methodParameterStyle())
		acceptor.acceptDefaultHighlighting(NUMBER_ID, "Number", numberTextStyle)
		acceptor.acceptDefaultHighlighting(OPEN_CLASS_DEFINITION_ID, OPEN_CLASS_DEFINITION_ID, openClassDefinitionStyle())
		acceptor.acceptDefaultHighlighting(PUNCTUATION_ID, "Punctuation", punctuationTextStyle)
		acceptor.acceptDefaultHighlighting(RESULT_VARIABLE_ID, RESULT_VARIABLE_ID, resultVariableStyle)
		acceptor.acceptDefaultHighlighting(SELF_ID, SELF_ID, selfKeywordStyle)
		acceptor.acceptDefaultHighlighting(SERVICE_IMPORT_ID, SERVICE_IMPORT_ID, serviceStyle())
		acceptor.acceptDefaultHighlighting(STRING_ID, "String", stringTextStyle());
		acceptor.acceptDefaultHighlighting(TAG_ID, TAG_ID, tagStyle)
	}
	
	private def attributeDeclarationStyle() {
		return defaultTextStyle
	}
	
	private def attributeAccessStyle() {
		return defaultTextStyle
	}
	
	private def serviceStyle() {
		return defaultTextStyle
	}
	
	private def methodStyle() {
		return defaultTextStyle
	}
	
	private def classesStyle() {
		return defaultTextStyle
	}
	
	private def openClassDefinitionStyle() {
		return defaultTextStyle
	}
	
	private def localVariableStyle() {
		return defaultTextStyle
	}
	
	private def methodCallStyle() {
		return defaultTextStyle
	}
	
	private def methodParameterStyle() {
		return defaultTextStyle
	}
	
	private def resultVariableStyle() {
		return defaultTextStyle
	}
	
	private def selfKeywordStyle() {
		return defaultTextStyle
	}
	
	private def tagStyle() {
		return defaultTextStyle
	}
	
}
