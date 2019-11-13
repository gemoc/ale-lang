package org.eclipse.emf.ecoretools.ale;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IQueryEvaluationEngine;
import org.eclipse.acceleo.query.runtime.QueryEvaluation;
import org.eclipse.acceleo.query.runtime.QueryParsing;
import org.eclipse.acceleo.query.runtime.IQueryBuilderEngine.AstResult;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.sirius.common.tools.api.interpreter.EvaluationException;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * This class offers services similar to AQLSiriusInterpreter but without the registration to the workspace listener
 * If offers the possibility to parse and evaluate string expressions and return various kinds of objects
 * It relies on the queryEnvironment of an existing ALEInterpreter. (ie. this is the responsibility of this ALEInterpreter 
 * to clean/dispose the query environment when not use anymore)
 */
public class ALEDynamicExpressionEvaluator {

	ALEInterpreter aleInterpreter;
	
	public ALEDynamicExpressionEvaluator(ALEInterpreter aleInterpreter) {
		super();
		this.aleInterpreter = aleInterpreter;
	}

	public IEvaluationResult evaluateExpression(final EObject target, final String fullExpression)
			throws EvaluationException {
		// this.javaExtensions.reloadIfNeeded();
		String expression = fullExpression.replaceFirst("ale:", "");
		Map<String, Object> variables = new HashMap<>();
		variables.put("self", target); //$NON-NLS-1$

		IQueryEnvironment queryEnv = aleInterpreter.getQueryEnvironment();
		if (queryEnv != null) {
			final IQueryBuilderEngine builder = QueryParsing.newBuilder(queryEnv);
			AstResult build = builder.build(expression);
			IQueryEvaluationEngine evaluationEngine = QueryEvaluation.newEngine(queryEnv);
			final EvaluationResult evalResult = evaluationEngine.eval(build, variables);

			final BasicDiagnostic diagnostic = new BasicDiagnostic();
			if (Diagnostic.OK != build.getDiagnostic().getSeverity()) {
				diagnostic.merge(build.getDiagnostic());
			}
			if (Diagnostic.OK != evalResult.getDiagnostic().getSeverity()) {
				diagnostic.merge(evalResult.getDiagnostic());
			}

			return new IEvaluationResult() {

				@Override
				public Object getValue() {
					return evalResult.getResult();
				}

				@Override
				public Diagnostic getDiagnostic() {
					List<Diagnostic> children = diagnostic.getChildren();
					if (children.size() == 1) {
						return children.get(0);
					} else {
						return diagnostic;
					}
				}
			};
		}
		return new IEvaluationResult() {
			@Override
			public Object getValue() {
				return null;
			}

			@Override
			public Diagnostic getDiagnostic() {
				return new BasicDiagnostic();
			}

		};
		
		
	}
	
    
    public Object evaluate(EObject target, String fullExpression) throws EvaluationException {
        IEvaluationResult evaluationResult = this.evaluateExpression(target, fullExpression);
        // We fire the exception to keep the old behavior
        Diagnostic diagnostic = evaluationResult.getDiagnostic();
        if (diagnostic.getSeverity() == Diagnostic.ERROR) {
            String uri = EcoreUtil.getURI(target).toString();
            String message = MessageFormat.format(Messages.ALEInterpreter_errorWithExpression, fullExpression, diagnostic.toString(), uri, target);
            throw new EvaluationException(message, diagnostic.getException());
        }
        return evaluationResult.getValue();
    }
	
    /**
     * {@inheritDoc}
     */
    public Collection<EObject> evaluateCollection(EObject context, String expression) throws EvaluationException {
        Object raw = evaluate(context, expression);
        final Collection<EObject> result;
        if (raw instanceof Collection<?>) {
            result = Lists.newArrayList(Iterables.filter((Collection<?>) raw, EObject.class));
        } else if (raw instanceof EObject) {
            result = Collections.singleton((EObject) raw);
        } else if (raw != null && raw.getClass().isArray()) {
            result = Lists.newArrayList(Iterables.filter(Lists.newArrayList((Object[]) raw), EObject.class));
        } else {
            result = Collections.emptySet();
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public boolean evaluateBoolean(EObject context, String expression) throws EvaluationException {
        Object raw = evaluate(context, expression);
        final boolean result;
        if (raw == null) {
            result = false;
        } else if (raw instanceof Boolean) {
            result = ((Boolean) raw).booleanValue();
        } else {
            String toString = raw.toString();
            if ("true".equalsIgnoreCase(toString)) { //$NON-NLS-1$
                result = true;
            } else if ("false".equalsIgnoreCase(toString)) { //$NON-NLS-1$
                result = false;
            } else {
                /*
                 * raw is != null and its toString is neither true or false,
                 * this happens when the user expect the condition to check that
                 * a value is existing, then we consider any non null value
                 * returns true and null returns false.
                 */
                result = true;
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    public EObject evaluateEObject(EObject context, String expression) throws EvaluationException {
        Object raw = evaluate(context, expression);
        if (raw instanceof EObject) {
            return (EObject) raw;
        } else {
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    public String evaluateString(EObject context, String expression) throws EvaluationException {
        Object raw = evaluate(context, expression);
        if (raw != null) {
            return String.valueOf(raw);
        } else {
            return ""; //$NON-NLS-1$
        }
    }

    /**
     * {@inheritDoc}
     */
    public Integer evaluateInteger(EObject context, String expression) throws EvaluationException {
        Object raw = evaluate(context, expression);
        try {
            return Integer.parseInt(String.valueOf(raw));
        } catch (NumberFormatException e) {
            return Integer.valueOf(0);
        }
    }

}
