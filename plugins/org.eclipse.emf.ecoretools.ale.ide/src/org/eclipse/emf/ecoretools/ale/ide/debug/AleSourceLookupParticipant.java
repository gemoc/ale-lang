package org.eclipse.emf.ecoretools.ale.ide.debug;

import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupParticipant;

public class AleSourceLookupParticipant extends AbstractSourceLookupParticipant {

	String workspacePath;

	public AleSourceLookupParticipant() {
		workspacePath = ResourcesPlugin.getWorkspace().getRoot().getLocationURI().getPath();
	}
	
	@Override
	public String getSourceName(Object object) throws CoreException {
		if(object instanceof AleStackFrame) {
			AleStackFrame srcObj = (AleStackFrame) object;
			String srcPath = srcObj.getSourceFile();
			if(srcPath.startsWith(workspacePath)) {
				String relativeSrcPath = srcObj.getSourceFile().replaceFirst(workspacePath, "");
				IPath relativePath = new Path(relativeSrcPath);
				return relativePath.removeFirstSegments(1).toString();
			}
		}
		return null;
	}
}
