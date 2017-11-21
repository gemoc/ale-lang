package org.eclipse.emf.ecoretools.ale.ide.debug;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.sourcelookup.ISourceContainer;
import org.eclipse.debug.core.sourcelookup.ISourcePathComputerDelegate;
import org.eclipse.debug.core.sourcelookup.containers.WorkspaceSourceContainer;

public class AleSourcePathComputerDelegate implements ISourcePathComputerDelegate {

	@Override
	public ISourceContainer[] computeSourceContainers(ILaunchConfiguration configuration, IProgressMonitor monitor)
			throws CoreException {
		return new ISourceContainer[]{ new WorkspaceSourceContainer()};
	}
}
