/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.ide;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;

public class WorkbenchDsl extends Dsl {

	public WorkbenchDsl(String dslFile) throws FileNotFoundException {
		super(dslFile);
		resolveUris();
	}
	
	public WorkbenchDsl(InputStream input) {
		super(input);
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
