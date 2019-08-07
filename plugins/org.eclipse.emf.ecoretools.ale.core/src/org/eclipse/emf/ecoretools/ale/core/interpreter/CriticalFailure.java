package org.eclipse.emf.ecoretools.ale.core.interpreter;

import org.eclipse.emf.common.util.BasicDiagnostic;

public class CriticalFailure extends Exception {
	
	BasicDiagnostic diagnostics;

	public CriticalFailure(String message, BasicDiagnostic diagnostics) {
		super(message);
		this.diagnostics = diagnostics;
	}
	
}
