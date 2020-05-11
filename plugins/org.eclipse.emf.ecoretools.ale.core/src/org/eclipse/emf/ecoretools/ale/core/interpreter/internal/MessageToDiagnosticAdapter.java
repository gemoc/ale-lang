package org.eclipse.emf.ecoretools.ale.core.interpreter.internal;

import java.io.File;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecoretools.ale.core.Activator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AssignmentToSelf;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.AttributeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.CodeLocation;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Context;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsFactory;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IDiagnosticFormatter;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MethodNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.MissingReturnStatement;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.NotIterable;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Operator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeMismatch;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.UnsupportedOperator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableAlreadyBound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.VariableNotFound;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.IBehaviors;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ServiceNotFoundException;
import org.eclipse.emf.ecoretools.ale.core.io.IOResources;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.While;

/**
 * Turns an ALE {@link Message} into an EMF {@link BasicDiagnostic}. 
 */
public class MessageToDiagnosticAdapter {
	
	private final IAleEnvironment environment;
	private final IBehaviors behaviors;
	private final IDiagnosticFormatter formatter;

	/**
	 * Creates a new adapter to turn ALE {@link Message}s into EMF {@link BasicDiagnostic}s.
	 * 
	 * @param environment
	 * 			The ALE environment from which {@link Message}s are created.
	 * @param formatter
	 * 			The formatter used to create diagnostics' messages
	 */
	MessageToDiagnosticAdapter(IAleEnvironment environment, IDiagnosticFormatter formatter) {
		this.environment = environment;
		this.behaviors = environment.getBehaviors();
		this.formatter = formatter;
	}
	
	public BasicDiagnostic newDiagnostic(Object data, String message) {
		return new BasicDiagnostic(
				Diagnostic.ERROR,
				Activator.PLUGIN_ID,
				0,
				message,
				new Object[] { data }
		);
	}

	BasicDiagnostic alreadyBound(ForEach source, Scopes scopes) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(getLine(source));
		getFile(source).ifPresent(location::setSource);
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		context.setScopes(scopes);
		
		Object duplicate = getPreviousDeclarationOf(source.getVariable(), source);
		CodeLocation duplicateLocation = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		duplicateLocation.setLine(getLine(duplicate));
		duplicateLocation.setSource(getFile(duplicate).orElse(""));
		
		VariableAlreadyBound unexpected = DiagnosticsFactory.eINSTANCE.createVariableAlreadyBound();
		unexpected.setName(source.getVariable());
		unexpected.setSource(source);
		unexpected.setContext(context);
		unexpected.setLocation(location);
		unexpected.setWholeCode(getCode(source));
		unexpected.setIncriminatedCode(source.getVariable());
		unexpected.setDuplicateLocation(duplicateLocation);
		
		return newDiagnostic(source, formatter.adapt(unexpected));
	}
	
	BasicDiagnostic alreadyBound(VariableDeclaration source, Scopes scopes) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(getLine(source));
		getFile(source).ifPresent(location::setSource);
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		context.setScopes(scopes);
		
		Object duplicate = getPreviousDeclarationOf(source.getName(), source);
		CodeLocation duplicateLocation = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		duplicateLocation.setLine(getLine(duplicate));
		duplicateLocation.setSource(getFile(duplicate).orElse(""));
		
		VariableAlreadyBound unexpected = DiagnosticsFactory.eINSTANCE.createVariableAlreadyBound();
		unexpected.setName(source.getName());
		unexpected.setSource(source);
		unexpected.setContext(context);
		unexpected.setLocation(location);
		unexpected.setWholeCode(getCode(source));
		unexpected.setIncriminatedCode(source.getName());
		unexpected.setDuplicateLocation(duplicateLocation);
		
		return newDiagnostic(source, formatter.adapt(unexpected));
	}
	
	BasicDiagnostic assignmentToSelf(VariableAssignment assignment, Scopes scopes) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(getLine(assignment));
		getFile(assignment).ifPresent(location::setSource);
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		context.setScopes(scopes);
		
		AssignmentToSelf unexpected = DiagnosticsFactory.eINSTANCE.createAssignmentToSelf();
		unexpected.setSource(assignment);
		unexpected.setContext(context);
		unexpected.setLocation(location);
		unexpected.setWholeCode(getCode(assignment));
		unexpected.setIncriminatedCode(assignment.getName());
		
		return newDiagnostic(assignment, formatter.adapt(unexpected));
	}
	
	BasicDiagnostic attributeNotFound(String name, EObject source, EClass owner, Scopes scopes) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(getLine(source));
		behaviors.findParsedFileDefining(source).map(ParsedFile::getSourceFile).ifPresent(location::setSource);
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		context.setScopes(scopes);
		
		AttributeNotFound notfound = DiagnosticsFactory.eINSTANCE.createAttributeNotFound();
		notfound.setName(name);
		notfound.setSource(source);
		notfound.setContext(context);
		notfound.setLocation(location);
		notfound.setWholeCode(getCode(source));
		notfound.setIncriminatedCode(name);
		notfound.setOwner(owner);
		
		return newDiagnostic(source, formatter.adapt(notfound));
	}
	
	BasicDiagnostic internalError(Object data, Throwable cause) {
		org.eclipse.emf.ecoretools.ale.core.diagnostics.InternalError internal = DiagnosticsFactory.eINSTANCE.createInternalError();
		internal.setMessage(cause.getMessage());
		internal.setCause(cause);
		return newDiagnostic(data, formatter.adapt(internal));
	}
	
	BasicDiagnostic methodNotFound(Expression expression, ServiceNotFoundException notFound, Scopes scopes) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(getLine(expression));
		getFile(expression).ifPresent(location::setSource);
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		context.setScopes(scopes);
		
		MethodNotFound error = DiagnosticsFactory.eINSTANCE.createMethodNotFound();
		error.setSource(expression);
		error.setContext(context);
		error.setLocation(location);
		error.setWholeCode(getCode(expression));
		error.setIncriminatedCode(error.getWholeCode().substring(error.getWholeCode().indexOf('.') + 1));
		error.setName(notFound.getServiceName());
		error.getArguments().addAll(notFound.getArguments());
		error.getArgumentTypes().addAll(notFound.getArgumentTypes());
		
		return newDiagnostic(expression, formatter.adapt(error));
	}
	
	BasicDiagnostic missingReturnStatement(Method method, Scopes scopes) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(getLine(method));
		getFile(method).ifPresent(location::setSource);
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		context.setScopes(scopes);
		
		MissingReturnStatement missing = DiagnosticsFactory.eINSTANCE.createMissingReturnStatement();
		missing.setSource(method);
		missing.setMethod(method);
		missing.setContext(context);
		missing.setLocation(location);
		missing.setWholeCode(getCode(method));
		missing.setIncriminatedCode(getCode(method));
		
		return newDiagnostic(method, formatter.adapt(missing));
	}
	
	BasicDiagnostic notIterable(ForEach foreach, Set<IType> valueTypes, Scopes scopes) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(getLine(foreach));
		getFile(foreach).ifPresent(location::setSource);
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		context.setScopes(scopes);
		
		NotIterable unsupported = DiagnosticsFactory.eINSTANCE.createNotIterable();
		unsupported.setSource(foreach);
		unsupported.setContext(context);
		unsupported.setLocation(location);
		unsupported.setWholeCode("for (" + foreach.getVariable() + " in " + getCode(foreach.getCollectionExpression()) + ") {");
		unsupported.setIncriminatedCode(getCode(foreach.getCollectionExpression()));
		unsupported.getActualTypes().addAll(valueTypes);
		
		return newDiagnostic(foreach, formatter.adapt(unsupported));
	}
	
	BasicDiagnostic typeMismatch(EObject source, Object incriminatedElement, Set<IType> expectedTypes, Set<IType> actualTypes) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(getLine(source));
		behaviors.findParsedFileDefining(source).map(ParsedFile::getSourceFile).ifPresent(location::setSource);
		
		TypeMismatch mismatch = DiagnosticsFactory.eINSTANCE.createTypeMismatch();
		mismatch.setSource(source);
		mismatch.setLocation(location);
		mismatch.setWholeCode(getCode(source));
		mismatch.setIncriminatedCode(getCode(incriminatedElement));
		mismatch.getExpectedTypes().addAll(expectedTypes);
		mismatch.getActualTypes().addAll(actualTypes);
		
		return newDiagnostic(source, formatter.adapt(mismatch));
	}
	
	BasicDiagnostic typeMismatch(If source, Object incriminatedElement, Set<IType> expectedTypes, Set<IType> actualTypes) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(getLine(source));
		getFile(source).ifPresent(location::setSource);
		
		TypeMismatch mismatch = DiagnosticsFactory.eINSTANCE.createTypeMismatch();
		mismatch.setSource(source);
		mismatch.setLocation(location);
		mismatch.setWholeCode("if (" + getCode(incriminatedElement) + ") {");
		mismatch.setIncriminatedCode(getCode(incriminatedElement));
		mismatch.getExpectedTypes().addAll(expectedTypes);
		mismatch.getActualTypes().addAll(actualTypes);
		
		return newDiagnostic(source, formatter.adapt(mismatch));
	}
	
	BasicDiagnostic typeMismatch(While source, Object incriminatedElement, Set<IType> expectedTypes, Set<IType> actualTypes) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(getLine(source));
		getFile(source).ifPresent(location::setSource);
		
		TypeMismatch mismatch = DiagnosticsFactory.eINSTANCE.createTypeMismatch();
		mismatch.setSource(source);
		mismatch.setLocation(location);
		mismatch.setWholeCode("while (" + getCode(incriminatedElement) + ") {");
		mismatch.setIncriminatedCode(getCode(incriminatedElement));
		mismatch.getExpectedTypes().addAll(expectedTypes);
		mismatch.getActualTypes().addAll(actualTypes);
		
		return newDiagnostic(source, formatter.adapt(mismatch));
	}
	
	BasicDiagnostic unresolvedType(EObject source, Object cause, String name, Scopes scopes) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(getLine(source));
		getFile(source).ifPresent(location::setSource);
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		context.setScopes(scopes);
		
		TypeNotFound notFound = DiagnosticsFactory.eINSTANCE.createTypeNotFound();
		notFound.setSource(source);
		notFound.setContext(context);
		notFound.setLocation(location);
		notFound.setWholeCode(getCode(source));
		notFound.setIncriminatedCode(getCode(cause));
		
		return newDiagnostic(source, formatter.adapt(notFound));
	}
	
	BasicDiagnostic unsupportedOperator(EObject expression, Object lhs, Object target, Operator operator, Scopes scopes) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(getLine(expression));
		getFile(expression).ifPresent(location::setSource);
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		context.setScopes(scopes);
		
		UnsupportedOperator unsupported = DiagnosticsFactory.eINSTANCE.createUnsupportedOperator();
		unsupported.setSource(expression);
		unsupported.setContext(context);
		unsupported.setLocation(location);
		unsupported.setWholeCode(getCode(expression));
		unsupported.setIncriminatedCode(getCode(lhs));
		unsupported.setOperator(operator);
		unsupported.setTarget(target);
		
		return newDiagnostic(expression, formatter.adapt(unsupported));
	}

	BasicDiagnostic variableNotFound(String name, EObject source, Scopes scopes) {
		CodeLocation location = DiagnosticsFactory.eINSTANCE.createCodeLocation();
		location.setLine(getLine(source));
		behaviors.findParsedFileDefining(source).map(ParsedFile::getSourceFile).ifPresent(location::setSource);
		
		Context context = DiagnosticsFactory.eINSTANCE.createContext();
		context.setScopes(scopes);
		
		VariableNotFound notfound = name.equals("result") ? DiagnosticsFactory.eINSTANCE.createAssignmentToResultInVoidOperation() : DiagnosticsFactory.eINSTANCE.createVariableNotFound();
		notfound.setName(name);
		notfound.setSource(source);
		notfound.setContext(context);
		notfound.setLocation(location);
		notfound.setWholeCode(getCode(source));
		notfound.setIncriminatedCode(name);
		
		return newDiagnostic(source, formatter.adapt(notfound));
	}
	
	private Object getPreviousDeclarationOf(String name, Statement declaration) {
		/*
		 * Assumes that:
		 * 	- variables can only be declared in methods
		 *  - variables are bound to method's scope
		 *  
		 *  FIXME [Validation] Does not handle nested scopes (foreach, while, etc.)
		 */
		Method method = (Method) declaration.eContainer().eContainer();
		
		for (EParameter parameter : method.getOperationRef().getEParameters()) {
			if (parameter.getName().equals(name)) {
				return parameter;
			}
		}
		for (Statement statement : method.getBody().getStatements()) {
			if (statement instanceof VariableDeclaration) {
				VariableDeclaration candidate = (VariableDeclaration) statement;
				if (candidate.getName().equals(name)) {
					return candidate;
				}
			}
		}
		// Should never happen
		throw new IllegalArgumentException("cannot find duplicate declaration of " + declaration + " in " + method);
	}
	
	private int getLine(Object astElement) {
		return behaviors.findParsedFileDefining(astElement)
						.map(file -> file.getLines(astElement).get(0))
						.orElse(0);
	}
	
	private Optional<String> getFile(Object astElement) {
		return environment.getBehaviors()
						  .findParsedFileDefining(astElement)
						  .map(ParsedFile::getSourceFile)
						  .map(File::new)
						  .map(IOResources::toIFile)
						  .map(file -> file.getFullPath().makeRelative().toString());
	}
	
	private String getCode(Object astElement) {
		if (astElement instanceof String) {
			// we've been given the code itself
			return (String) astElement;
		}
		return behaviors.findParsedFileDefining(astElement)
						.map(file -> file.getText(astElement).orElse("<code not found>"))
						.orElse("<source file not found>");
	}
}
