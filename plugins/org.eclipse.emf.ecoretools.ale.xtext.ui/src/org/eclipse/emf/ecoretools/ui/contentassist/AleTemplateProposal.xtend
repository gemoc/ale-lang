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

import org.eclipse.jface.text.BadLocationException
import org.eclipse.jface.text.DocumentEvent
import org.eclipse.jface.text.IDocument
import org.eclipse.jface.text.IRegion
import org.eclipse.jface.text.templates.Template
import org.eclipse.jface.text.templates.TemplateContext
import org.eclipse.swt.graphics.Image
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher
import org.eclipse.xtext.ui.editor.templates.XtextTemplateProposal

/**
 * A template proposal that uses a {@link PrefixMatcher} to determine
 * whether its template should be shown.
 */
class AleTemplateProposal extends XtextTemplateProposal {
	
	/**
	 * Used to test whether the template should be shown.
	 */
	val PrefixMatcher matcher		
	
	new(PrefixMatcher matcher, Template template, TemplateContext context, IRegion region, Image image, int relevance) {
		super(template, context, region, image, relevance)
		this.matcher = matcher			
	}
	
	override validate(IDocument document, int offset, DocumentEvent event) {
		try {
			val replaceOffset= getReplaceOffset();
			if (offset >= replaceOffset) {
				val String content= document.get(replaceOffset, offset - replaceOffset);
				return matcher.isCandidateMatchingPrefix(template.getName(), content.toLowerCase());
			}
		} catch (BadLocationException e) {
			// concurrent modification - ignore
		}
		return false;
		
	}
	
	override getDisplayString() {
		// Override to remove the leading "-" shown by default
		// (template's description is supposed to be displayed after it)
		//
		return getTemplate().getName()
	}
	
}