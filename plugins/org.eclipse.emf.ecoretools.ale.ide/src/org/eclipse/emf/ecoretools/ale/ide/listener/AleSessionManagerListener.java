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
package org.eclipse.emf.ecoretools.ale.ide.listener;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.ide.resource.AleResourceFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

public class AleSessionListener implements SessionManagerListener {

	public static final String ECORE_VP_EXTENSION = "BehaviorEntities";
	public static final String IMPLEM_EXTENSION = "ale";
	public static final String DSL_EXTENSION = "dsl";
	public static final String RESOURCE_SUFFIX = "transient";

	@Override
	public void notifyAddSession(Session newSession) {
		
		initEnvironment(newSession);
		
		System.out.println("Session is added");
	}

	@Override
	public void notifyRemoveSession(Session removedSession) {
		System.out.println("Session is removed");
	}

	@Override
	public void viewpointSelected(Viewpoint selectedSirius) {
		
		
		System.out.println("Viewpoint is selected");
	}

	@Override
	public void viewpointDeselected(Viewpoint deselectedSirius) {
		System.out.println("Viewpoint is deselected");
	}

	@Override
	public void notify(Session updated, int notification) {
		System.out.println("Session is notified");
	}
	
	private void initEnvironment(Session session) {
		final TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
		ResourceSet rs = editingDomain.getResourceSet();
		
		ALEInterpreter interpreter = new ALEInterpreter();
		rs.getResourceFactoryRegistry()
			.getExtensionToFactoryMap()
			.put("dsl", new AleResourceFactory(interpreter.getQueryEnvironment(),rs));
	}
}
