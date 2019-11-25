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
package org.eclipse.emf.ecoretools.ale.core.parser;

import static java.util.stream.Collectors.toList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Dsl {
	
	String sourceFile;
	List<String> allSyntaxes = new ArrayList<>();
	List<String> allSemantics = new ArrayList<>();
	private Properties dslProp;
	
	public Dsl(List<String> syntaxes, List<String> semantics) {
		this.allSyntaxes.addAll(syntaxes);
		this.allSemantics.addAll(semantics);
	}
	
	public Dsl(String dslFile) throws FileNotFoundException {
		this(new FileInputStream(dslFile));
		this.sourceFile = dslFile;
	}
	
	public Dsl(InputStream input) {
		
		this.dslProp = new Properties();
		try {
			getDslProp().load(input);
			input.close();
		} catch (IOException e) {
			// TODO Throw the exception: it cannot be handled here
			e.printStackTrace();
		}
		
		String allSyntaxes = (String) getDslProp().get("syntax");
		String allBehaviors = (String) getDslProp().get("behavior");
		
		if(allSyntaxes != null && allBehaviors != null) {
			String[] syntaxes = allSyntaxes.split(",");
			String[] behaviors = allBehaviors.split(",");
			
			this.allSyntaxes.addAll(trim(syntaxes));
			this.allSemantics.addAll(trim(behaviors));
		}
		else {
			//TODO: Malformed file error
		}
		
	}
	
	public List<String> getAllSemantics() {
		return allSemantics;
	}
	
	public List<String> getAllSyntaxes() {
		return allSyntaxes;
	}
	
	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}
	
	public void save() {
		if(sourceFile != null) {
			Properties dslProp = new Properties();
			dslProp.put("syntax", String.join(",", allSyntaxes));
			dslProp.put("behavior", String.join(",", allSemantics));
			try (FileOutputStream output = new FileOutputStream(sourceFile)) {
				dslProp.store(output,"");
			} catch (IOException e) {
				// TODO Throw the exception: it cannot be handled here
				e.printStackTrace();
			}
		}
	}
	
	protected List<String> trim(String[] uris) {
		return Arrays.asList(uris).stream().map(s->s.trim()).collect(toList());
	}

	public Properties getDslProp() {
		return dslProp;
	}

	public String getSourceFile() {
		return sourceFile;
	}
	
	
}
