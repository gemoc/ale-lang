package org.eclipse.emf.ecoretools.ale.ide.launchconfig;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.ResourceUtil;

public class LaunchShortcut implements ILaunchShortcut {

	@Override
	public void launch(ISelection selection, String mode) {
		if(selection instanceof IStructuredSelection) {
			IResource dslFile = (IResource) ((IStructuredSelection)selection).getFirstElement();
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				
			if(shell != null && dslFile != null) {
				RunModelAction.launch(shell, dslFile);
			}
		}
	}

	@Override
	public void launch(IEditorPart editor, String mode) {
		//TODO: launch from ALE editor -> find corresponding .dsl
		
//		 IFile dslFile = ResourceUtil.getFile(editor.getEditorInput());
//		 Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
//			
//		if(shell != null && dslFile != null) {
//			RunModelAction.launch(shell, dslFile);
//		}
	}

}
