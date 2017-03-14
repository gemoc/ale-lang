package fluffyumbrellacompiler.ui.popup.actions;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import fr.mleduc.mt.compiler.DSLCompiler;

public class XaqlCompile implements IObjectActionDelegate {

	private IFile selectedIFile = null;

	/**
	 * Constructor for Action1.
	 */
	public XaqlCompile() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(final IAction action) {
		try {
			final InputStream contents = this.selectedIFile.getContents();
			new DSLCompiler(contents).compile(this.selectedIFile.getProject());
		} catch (final CoreException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(final IAction action, final ISelection selection) {
		if (selection != null & selection instanceof IStructuredSelection) {
			final StructuredSelection ss = (StructuredSelection) selection;
			final Object o = ss.getFirstElement();
			if (o instanceof IFile) {
				selectedIFile = (IFile) o;
			}
			if (o instanceof IAdaptable) {
				final IFile res = (IFile) ((IAdaptable) o).getAdapter(IFile.class);
				if (res != null) {
					selectedIFile = res;
				}
			}
		}
	}

}
