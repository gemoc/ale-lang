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
package org.eclipse.emf.ecoretools.ale.core.delegate.test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecoretools.ale.core.delegate.ALEInvocationDelegateFactory;
import org.junit.Before;
import org.junit.Test;

public class DelegateTest {
	
	ResourceSet modelRs;
	
	@Before
	public void setup() {
		
		modelRs = new ResourceSetImpl();
		modelRs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		
		URI fsmUri = URI.createURI("model/fsm.ecore");
		Resource fsmRes = modelRs.getResource(fsmUri, true);
		EPackage pkg = (EPackage) fsmRes.getContents().get(0);
		EPackageRegistryImpl.createGlobalRegistry().put(pkg.getNsURI(), pkg);
		modelRs.getPackageRegistry().put(pkg.getNsURI(), pkg);
		
		EOperation.Internal.InvocationDelegate.Factory.Registry.INSTANCE.put("http://implementation/", new ALEInvocationDelegateFactory(Arrays.asList(pkg)));
	}
	
	@Test
	public void testInvoke() {

		URI uri = URI.createURI("model/FSM.xmi");
		Resource res = modelRs.getResource(uri, true);
		EObject fsm = res.getContents().get(0);
		
		EOperation execOp = fsm.eClass().getEOperations().get(0);
		
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		try {
			BasicEList<String> args = new BasicEList<String>();
			args.add("event");
			fsm.eInvoke(execOp, args);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		assertEquals("FSM exec:\nHello world from First state\n", outContent.toString());
		System.setOut(null);
	}
}
