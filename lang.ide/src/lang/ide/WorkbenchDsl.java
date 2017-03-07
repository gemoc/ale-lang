package lang.ide;

import java.util.ArrayList;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;

import lang.Dsl;

public class WorkbenchDsl extends Dsl{

	public WorkbenchDsl(String dslFile) {
		super(dslFile);
		resolveUris();
	}
	
	private void resolveUris() {
		ArrayList<String> newSemantics = new ArrayList<String>();
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		getAllSemantics()
			.stream()
			.forEach(elem -> {
				URI uri = URI.createURI(elem);
				if(ws != null && uri.isPlatform()) {
					IResource file = ws.getRoot().findMember(uri.toPlatformString(true));
					String path = file.getLocationURI().getRawPath();
					newSemantics.add(path);
				}
				else {
					newSemantics.add(elem);
				}
			});
		getAllSemantics().clear();
		getAllSemantics().addAll(newSemantics);
	}
}
