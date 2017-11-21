package org.eclipse.emf.ecoretools.ale.ide.debug;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.ui.actions.IToggleBreakpointsTarget;
import org.eclipse.emf.ecoretools.ale.ide.Activator;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.xtext.ui.editor.XtextEditor;

public class AleLineBreakpointAdapter implements IToggleBreakpointsTarget {

	@Override
	public void toggleLineBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
		XtextEditor textEditor = getEditor(part);
		if (textEditor != null) {
			IResource resource = (IResource) textEditor.getEditorInput().getAdapter(IResource.class);
			ITextSelection textSelection = (ITextSelection) selection;
			int lineNumber = textSelection.getStartLine();
			IBreakpoint[] breakpoints = DebugPlugin.getDefault().getBreakpointManager()
					.getBreakpoints(Activator.PLUGIN_ID);
			for (int i = 0; i < breakpoints.length; i++) {
				IBreakpoint breakpoint = breakpoints[i];
				if (resource.equals(breakpoint.getMarker().getResource())) {
					if (((ILineBreakpoint) breakpoint).getLineNumber() == (lineNumber + 1)) {
						breakpoint.delete();
						return;
					}
				}
			}
			AleLineBreakpoint lineBreakpoint = new AleLineBreakpoint(resource, lineNumber + 1);
			DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(lineBreakpoint);
		}
	}

	@Override
	public boolean canToggleLineBreakpoints(IWorkbenchPart part, ISelection selection) {
		return getEditor(part) != null;
	}
	       
	private XtextEditor getEditor(IWorkbenchPart part) {
		if (part instanceof XtextEditor) {
			XtextEditor editorPart = (XtextEditor) part;
			IResource resource = (IResource) editorPart.getEditorInput().getAdapter(IResource.class);
			if (resource != null) {
				String extension = resource.getFileExtension();
				if (extension != null && extension.equals("ale")) {
					return editorPart;
				}
			}
		}
		return null;
	}

	@Override
	public void toggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean canToggleMethodBreakpoints(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void toggleWatchpoints(IWorkbenchPart part, ISelection selection) throws CoreException {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean canToggleWatchpoints(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		return false;
	}

}
