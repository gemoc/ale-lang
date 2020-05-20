package org.eclipse.emf.ecoretools.ale;

import java.util.List;
import java.util.Optional;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.sirius.common.tools.api.interpreter.IEvaluationResult;
import org.eclipse.sirius.common.tools.internal.interpreter.DefaultConverter;


/**
 * Create an IEvaluationResult that optimizes a little the depth of the returned diagnostic
 *
 */
public class OptimizedEvaluationResult extends org.eclipse.sirius.common.tools.api.interpreter.EvaluationResult implements IEvaluationResult {
	
	protected OptimizedEvaluationResult(Optional<Object> rawValue, Diagnostic diagnostic) {
		super(rawValue, new DefaultConverter(), diagnostic);
	}

	@Override
	public Diagnostic getDiagnostic() {
		Diagnostic sdiagnostic = super.getDiagnostic();
		List<Diagnostic> children = sdiagnostic.getChildren();
		if (children.size() == 1) {
			return children.get(0);
		} else {
			return sdiagnostic;
		}
	}
}
