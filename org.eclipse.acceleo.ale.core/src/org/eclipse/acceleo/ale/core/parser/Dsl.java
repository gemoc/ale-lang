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
package org.eclipse.acceleo.ale.core.parser;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Dsl {
	List<String> allSyntaxes = new ArrayList<String>();
	List<String> allSemantics = new ArrayList<String>();
	
	public Dsl(List<String> syntaxes, List<String> semantics) {
		this.allSyntaxes.addAll(syntaxes);
		this.allSemantics.addAll(semantics);
	}
	
	public Dsl(String dslFile) {
		
		Properties dslProp = new Properties();
		try {
			FileInputStream in = new FileInputStream(dslFile);
			dslProp.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String allSyntaxes = (String) dslProp.get("syntax");
		String allBehaviors = (String) dslProp.get("behavior");
		
		String[] syntaxes = allSyntaxes.split(",");
		String[] behaviors = allBehaviors.split(",");
		
		this.allSyntaxes.addAll(Arrays.asList(syntaxes));
		this.allSemantics.addAll(Arrays.asList(behaviors));
		
	}
	
	public List<String> getAllSemantics() {
		return allSemantics;
	}
	
	public List<String> getAllSyntaxes() {
		return allSyntaxes;
	}
}
