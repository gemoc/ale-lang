package org.eclipse.emf.ecoretools.ale.core.interpreter;

import java.util.Map;
import java.util.Stack;

import org.eclipse.emf.ecoretools.ale.implementation.Statement;

public interface StatementListener {

	public void preExec(Statement stmt, Stack<Map<String, Object>> variablesStack);
	
	public void postExec(Statement stmt, Stack<Map<String, Object>> variablesStack);
	
}
