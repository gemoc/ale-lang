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
package org.eclipse.emf.ecoretools.ale.core.parser.visitor;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.common.util.Diagnostic;

/**
 * Wrapper for Implementation model.
 * It keeps a mapping between elements of the model & their offset in the '.implem' file.
 */
public class ParseResult<T> {
	private String sourceFile;
	private final Map<Object, Integer> startPositions = new HashMap<Object, Integer>();
	private final Map<Object, Integer> endPositions = new HashMap<Object, Integer>();
	private Diagnostic diagnostic;
	private T root;
	
	public Map<Object, Integer> getStartPositions() {
		return startPositions;
	}
	
	public Map<Object, Integer> getEndPositions() {
		return endPositions;
	}
	
	public Diagnostic getDiagnostic() {
		return diagnostic;
	}
	
	public void setDiagnostic(Diagnostic diagnostic) {
		this.diagnostic = diagnostic;
	}
	
	public T getRoot() {
		return root;
	}
	
	public void setRoot(T root) {
		this.root = root;
	}
	
	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}
	
	public String getSourceFile() {
		return sourceFile;
	}
	
	public Optional<String> getText(Object element) {
		
		int start = startPositions.get(element);
		int end = endPositions.get(element);
		
		int length = end - start + 1;
		char[] cbuf = new char[length];
		
		Path path = Paths.get(sourceFile);
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			reader.read(cbuf, start, length);
			return Optional.of(new String(cbuf));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Optional.empty();
	}
}
