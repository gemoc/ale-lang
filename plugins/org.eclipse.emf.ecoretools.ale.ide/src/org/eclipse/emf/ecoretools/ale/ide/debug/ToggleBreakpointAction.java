package org.eclipse.emf.ecoretools.ale.ide.debug;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.source.IVerticalRulerInfo;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

public class ToggleBreakpointAction  extends Action {
	
	private ITextEditor fEditor;
	private IVerticalRulerInfo fRulerInfo;
	
	public ToggleBreakpointAction(ITextEditor editor, IVerticalRulerInfo rulerInfo) {
		super("Toggle Line Breakpoint");
		fEditor = editor;
		fRulerInfo = rulerInfo;
	}
	
	public void run() {
		AleLineBreakpointAdapter adapter = new AleLineBreakpointAdapter();
		ITextSelection selection = getSelection();
		if (selection != null) {
			try {
				if (adapter.canToggleWatchpoints(fEditor, selection)) {
					adapter.toggleWatchpoints(fEditor, selection);
				} else if (adapter.canToggleLineBreakpoints(fEditor, selection)) {
					adapter.toggleLineBreakpoints(fEditor, selection);
				}
			} catch (CoreException e) {
			}
		}
	}
	
	private ITextSelection getSelection() {
		int line = fRulerInfo.getLineOfLastMouseButtonActivity();
		IDocumentProvider provider = fEditor.getDocumentProvider();
		ITextSelection selection = null;
		try {
			provider.connect(fEditor.getEditorInput());
			IDocument document = provider.getDocument(fEditor.getEditorInput());
			IRegion region = document.getLineInformation(line);
			selection = new TextSelection(document, region.getOffset(), region.getLength());
		} catch (CoreException e1) {
		} catch (BadLocationException e) {
		} finally {
			provider.disconnect(fEditor.getEditorInput());
		}
		return selection;
	}
}
