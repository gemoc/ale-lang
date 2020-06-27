/*******************************************************************************
 * Copyright (c) 2020 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.validation.test;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

/**
 * A fake IMarker for testing purposes. 
 */
public class FakeMarker implements IMarker {
	
	private final Map<String, Object> attributes = new HashMap<>();

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete() throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getAttribute(String attributeName) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAttribute(String attributeName, int defaultValue) {
		if (attributes.getOrDefault(attributeName, defaultValue) instanceof Integer) {
			return (int) attributes.getOrDefault(attributeName, defaultValue);
		}
		return defaultValue;
	}

	@Override
	public String getAttribute(String attributeName, String defaultValue) {
		if (attributes.getOrDefault(attributeName, defaultValue) instanceof String) {
			return (String) attributes.getOrDefault(attributeName, defaultValue);
		}
		return defaultValue;
	}

	@Override
	public boolean getAttribute(String attributeName, boolean defaultValue) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Map<String, Object> getAttributes() throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] getAttributes(String[] attributeNames) throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCreationTime() throws CoreException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IResource getResource() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() throws CoreException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSubtypeOf(String superType) throws CoreException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAttribute(String attributeName, int value) throws CoreException {
		attributes.put(attributeName, value);
	}

	@Override
	public void setAttribute(String attributeName, Object value) throws CoreException {
		attributes.put(attributeName, value);
	}

	@Override
	public void setAttribute(String attributeName, boolean value) throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAttributes(String[] attributeNames, Object[] values) throws CoreException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAttributes(Map<String, ? extends Object> attributes) throws CoreException {
		// TODO Auto-generated method stub

	}

}
