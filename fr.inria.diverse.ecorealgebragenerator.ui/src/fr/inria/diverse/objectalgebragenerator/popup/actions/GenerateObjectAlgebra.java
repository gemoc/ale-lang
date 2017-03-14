package fr.inria.diverse.objectalgebragenerator.popup.actions;

import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

public class GenerateObjectAlgebra implements IObjectActionDelegate {

	private Shell shell;
	private IFile selectedIFile = null;

	/**
	 * Constructor for Action1.
	 */
	public GenerateObjectAlgebra() {
		super();
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#run(IAction)
	 */
	public void run(final IAction action) {

		final URI uri = URI.createPlatformResourceURI(selectedIFile.getFullPath().toString(), true);

		final ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		final Resource resource = resourceSet.getResource(uri, true);
		final EPackage ePackage = (EPackage) resource.getContents().get(0);
		final IProject project = selectedIFile.getProject();
		generateAlgebra(ePackage, project);

		try {
			project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (final CoreException e) {
			e.printStackTrace();
		}

	}

	private void generateAlgebra(final EPackage ePackage, final IProject project) {
		final String fileContent = new GenerateAlgebra().processAlgebra(ePackage);
		final IPath directoryAlgebra = project.getLocation().append("src").append(ePackage.getName()).append("algebra");
		directoryAlgebra.toFile().mkdirs();
		final IPath fileJavaAlgebra = directoryAlgebra
				.append(ePackage.getName().substring(0, 1).toUpperCase() + ePackage.getName().substring(1) + "Algebra")
				.addFileExtension("java");

		try {
			final FileWriter fileWriter = new FileWriter(fileJavaAlgebra.toFile());
			fileWriter.write(fileContent);
			fileWriter.close();
		} catch (final IOException e) {
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
