/*******************************************************************************
 * Copyright (c) 2020 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.ide.ui.io;

import static java.lang.Integer.parseInt;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecoretools.ale.ide.ui.Activator;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IHyperlink;
import org.eclipse.ui.console.IPatternMatchListenerDelegate;
import org.eclipse.ui.console.PatternMatchEvent;
import org.eclipse.ui.console.TextConsole;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * Turns stacktraces into hyperlinks within ALE consoles. 
 */
public class HyperlinkAleConsoleMatcherListener implements IPatternMatchListenerDelegate {

	private TextConsole console;

	@Override
	public void connect(TextConsole console) {
		if (console instanceof AleConsole) {
			this.console = console;
		}
	}

	@Override
	public void disconnect() {
		this.console = null;
	}

	@Override
	public void matchFound(PatternMatchEvent event) {
		if (!isInAleConsole()) {
			return;
		}
		try {
			String fileReferenceText = console.getDocument().get(event.getOffset(), event.getLength());
			int filePathIndex = startIndexIn(fileReferenceText);
			int separatorIndex = fileReferenceText.lastIndexOf(':');

			String absoluteFilePath = fileReferenceText.substring(filePathIndex, separatorIndex);
			int lineNumber = parseInt(fileReferenceText.substring(separatorIndex + 1));

			IHyperlink hyperlink = makeHyperlink(absoluteFilePath, lineNumber); // a link to any file
			console.addHyperlink(hyperlink, event.getOffset() + filePathIndex, event.getLength() - filePathIndex);
		}
		catch (NumberFormatException e) {
			// a Java exception has likely been printed by the interpreter, nevermind
		}
		catch (Exception exception) {
			Activator.error("Unable to create hyperlink from " + event.getOffset() + " to " + event.getLength(), exception);
		}
	}
	
	private int startIndexIn(String fileReferenceText) {
		return fileReferenceText.toLowerCase().indexOf("at ") + "at ".length();
	}

	private boolean isInAleConsole() {
		return console != null;
	}

	private static IHyperlink makeHyperlink(String absoluteFilePath, int lineNumber)
	{
		return new AleConsoleHyperlink(absoluteFilePath, lineNumber);
	}
	
	/**
	 * An hyperlink that opens the file in an editor when clicked. 
	 */
	private static final class AleConsoleHyperlink implements IHyperlink {
		
		private final String absoluteFilePath;
		private final int lineNumber;

		private AleConsoleHyperlink(String absoluteFilePath, int lineNumber) {
			this.absoluteFilePath = absoluteFilePath;
			this.lineNumber       = lineNumber;
		}

		@Override
		public void linkExited() {
			// nothing to do
		}

		@Override
		public void linkEntered() {
			// nothing to do
		}

		@Override
		public void linkActivated() {
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(absoluteFilePath));
				IEditorPart editorPart = IDE.openEditor(page, file);
				goToLine(editorPart, lineNumber);
			}
			catch (Exception exception) {
				Activator.error("Unable to open an editor when hyperlinked to " + absoluteFilePath + ":" + lineNumber + " has been triggered", exception);
			}
		}

		private static void goToLine(IEditorPart editorPart, int lineNumber) {
			if (editorPart instanceof ITextEditor) {
				ITextEditor textEditor = (ITextEditor) editorPart;
				IDocument document = textEditor.getDocumentProvider().getDocument(textEditor.getEditorInput());
				
				if (document != null) {
					IRegion region = null;

					try {
						region = document.getLineInformation(lineNumber - 1);
						textEditor.selectAndReveal(region.getOffset(), region.getLength());
					}
					catch (BadLocationException exception) {
						Activator.error("Unable to go to line " + lineNumber + " in editor " + editorPart, exception);
					}
				}
			}
		}
	}

}
