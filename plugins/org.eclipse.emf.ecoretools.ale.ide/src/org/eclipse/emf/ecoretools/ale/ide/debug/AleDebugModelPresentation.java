package org.eclipse.emf.ecoretools.ale.ide.debug;

import org.eclipse.core.resources.IFile;
import org.eclipse.debug.core.model.ILineBreakpoint;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.IValueDetailListener;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.part.FileEditorInput;

public class AleDebugModelPresentation implements IDebugModelPresentation {

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IEditorInput getEditorInput(Object element) {
		if (element instanceof IFile)
			return new FileEditorInput((IFile) element);
		if (element instanceof ILineBreakpoint)
			return new FileEditorInput((IFile) ((ILineBreakpoint) element).getMarker().getResource());
		return null;
	}

	@Override
	public String getEditorId(IEditorInput input, Object element) {
		if (element instanceof IFile || element instanceof ILineBreakpoint)
			return "org.eclipse.emf.ecoretools.Ale";
		return null;
	}

	@Override
	public void setAttribute(String attribute, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getText(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void computeDetail(IValue value, IValueDetailListener listener) {
		// TODO Auto-generated method stub
		
	}

}
