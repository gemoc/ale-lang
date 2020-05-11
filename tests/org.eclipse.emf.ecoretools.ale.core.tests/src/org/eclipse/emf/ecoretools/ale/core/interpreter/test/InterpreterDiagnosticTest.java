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
package org.eclipse.emf.ecoretools.ale.core.interpreter.test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.core.env.ClosedAleEnvironmentException;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.IBehaviors;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Tests the errors shown by the Interpreter.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InterpreterDiagnosticTest {
	
	private ByteArrayOutputStream errContent;

	private PrintStream legacyErr;

	private IAleEnvironment environment;
	
	@Before
	public void setup() {
		legacyErr  = System.err;
		errContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(errContent));
	}

	@After
	public void cleanup() {
		System.setErr(legacyErr);
	}
	
	/**
	 * Turns off stdErr capture and returns the contents that have been captured
	 *
	 * @return
	 */
	private String getErr() {
		System.setErr(new PrintStream(new FileOutputStream(FileDescriptor.out)));
		return errContent.toString();
	}

	/** Returns the system-dependent line separator character */ 
	private static String nl() {
		return System.lineSeparator();
	}
	/** Returns the system-dependent line separator character, two times */ 
	private static String nlnl() {
		return nl() + nl();
	}

	@Test
	public void assignmentToDynamicFeatureTypeMismatch() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/assignmentToDynamicFeatureTypeMismatch.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();

		String expected = "Type mismatch between expected type `ecore::EString` and actual type `java.lang.Integer`." + nlnl() + 
						  "9| self.str := 42;" + nl() + 
						  "               ^^ should be `ecore::EString`" + nlnl() + 
						  "  At input/diagnostics/assignmentToDynamicFeatureTypeMismatch.ale:9" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}

	@Test
	public void assignmentToDynamicFeatureUndeclared() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/assignmentToDynamicFeatureUndeclared.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();

		String expected = "Cannot find attribute `str` in class `ClassA`." + nlnl() + 
						  "7| self.str := self;" + nl() + 
						  "        ^^^" + nlnl() + 
						  "  At input/diagnostics/assignmentToDynamicFeatureUndeclared.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void assignmentToResultInVoidMethod() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/assignmentToResultInVoidMethod.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();

		String expected = "Cannot find variable `result`." + nlnl() +
						  "7| result := 'Hello World!';" + nl() +
						  "   ^^^^^^" + nl() +
						  "`result` is not available in a void method. Maybe you want one of the following?" + nlnl() + 
						  "    self" + nlnl() +
						  "  At input/diagnostics/assignmentToResultInVoidMethod.ale:7" + nl();
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void assignmentToResultMissingInNonVoidMethod() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/assignmentToResultMissingInNonVoidMethod.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "Method 'foo(EString, EInt)' must assign the `result` variable." + nlnl() + 
						  "10| def boolean foo(String name, int age) {" + nl() + 
						  "11| 		// result := true;" + nl() + 
						  "12| 	}" + nl() + 
						  "        ^ missing `result := ...;` " + nlnl() +
						  "  At input/diagnostics/assignmentToResultMissingInNonVoidMethod.ale:10" + nl() +
						  "  At input/diagnostics/assignmentToResultMissingInNonVoidMethod.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void assignmentToSelf() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/assignmentToSelf.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "`self` cannot be assigned." + nlnl() + 
						  "7| self := 42;" + nl() + 
						  "   ^^^^ reserved keyword" + nlnl() + 
						  "  At input/diagnostics/assignmentToSelf.ale:7" + nl();
		assertEquals("Wrong output on stderr", expected, getErr());
	}

	@Test
	public void assignmentToVariableTypeMismatch() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/assignmentToVariableTypeMismatch.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();

		String expected = "Type mismatch between expected type `ecore::EString` and actual type `java.lang.Integer`." + nlnl() + 
						  "8| str := 42;" + nl() + 
						  "          ^^ should be `ecore::EString`" + nlnl() + 
						  "  At input/diagnostics/assignmentToVariableTypeMismatch.ale:8" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}

	@Test
	public void assignmentToVariableUndeclared() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/assignmentToVariableUndeclared.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();

		String expected = "Cannot find variable `str`." + nlnl() + 
						  "7| str := self;" + nl() + 
						  "   ^^^" + nl() + 
						  "Maybe you want one of the following?" + nlnl() + 
						  "    self" + nlnl() + 
						  "  At input/diagnostics/assignmentToVariableUndeclared.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}

	@Test
	public void declarationOfVariableAlreadyDeclared() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/declarationOfVariableAlreadyDeclared.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "A variable named `sentences` already exists." + nlnl() + 
						  "8| Sequence(String) sentences := Sequence{'Hello World!'};" + nl() + 
						  "                    ^^^^^^^^^ already declared at :7" + nlnl() +
						  "  At input/diagnostics/declarationOfVariableAlreadyDeclared.ale:8" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void declarationOfVariableNamedAfterParameter() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/declarationOfVariableNamedAfterParameter.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "A variable named `number` already exists." + nlnl() + 
						  "11| int number := 42;" + nl() + 
						  "        ^^^^^^ already declared at :10" + nlnl() + 
						  "  At input/diagnostics/declarationOfVariableNamedAfterParameter.ale:11" + nl() + 
						  "  At input/diagnostics/declarationOfVariableNamedAfterParameter.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void declarationOfVariableWithIllegalInitialValue() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/declarationOfVariableWithIllegalInitialValue.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "Type mismatch between expected type `ecore::EString` and actual type `Set(java.lang.String)`." + nlnl() + 
						  "7| String str := OrderedSet{'Hello World!'};" + nl() +
						  "                 ^^^^^^^^^^^^^^^^^^^^^^^^^^ should be `ecore::EString`" + nlnl() + 
						  "  At input/diagnostics/declarationOfVariableWithIllegalInitialValue.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void foreachNotIterable() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/foreachNotIterable.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "Cannot iterate over `java.lang.Integer`" + nlnl() + 
						  "7| for (i in 42) {" + nl() + 
						  "             ^^ should be a Sequence or an OrderedSet" + nlnl() + 
						  "  At input/diagnostics/foreachNotIterable.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void foreachVariableAlreadyBoundToParameter() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/foreachVariableAlreadyBoundToParameter.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "A variable named `i` already exists." + nlnl() + 
						  "11| for (i in [1..5]) {" + nl() + 
						  "12| 		" + nl() + 
						  "13| 		}" + nl() +
						  "         ^ already declared at :10" + nlnl() + 
						  "  At input/diagnostics/foreachVariableAlreadyBoundToParameter.ale:11" + nl() +
						  "  At input/diagnostics/foreachVariableAlreadyBoundToParameter.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void foreachVariableAlreadyBoundToVariable() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/foreachVariableAlreadyBoundToVariable.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "A variable named `i` already exists." + nlnl() + 
						  "8| for (i in [1..5]) {" + nl() + 
						  "9| 		" + nl() + 
						  "10| 		}" + nl() + 
						  "        ^ already declared at :7" + nlnl() + 
						  "  At input/diagnostics/foreachVariableAlreadyBoundToVariable.ale:8" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void ifNonBooleanCondition() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/ifNonBooleanCondition.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "Type mismatch between expected type `ecore::EBoolean` and actual type `java.lang.String`." + nlnl() + 
						  "7| if ('Hello World!') {" + nl() + 
						  "       ^^^^^^^^^^^^^^ should be `ecore::EBoolean`" + nlnl() + 
						  "  At input/diagnostics/ifNonBooleanCondition.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void insertionToVariableThatDoesNotSupportOperator() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/insertionToVariableThatDoesNotSupportOperator.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "`test::ClassA` does not support the `+=` operator" + nlnl() + 
						  "8| other += self;" + nl() + 
						  "   ^^^^^" + nlnl() + 
						  "  At input/diagnostics/insertionToVariableThatDoesNotSupportOperator.ale:8" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void insertionToVariableTypeMismatch() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/insertionToVariableTypeMismatch.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "Type mismatch between expected type `Sequence(ecore::EString)` and actual type `Sequence(java.lang.Integer)`." + nlnl() + 
						  "8| numbers += Sequence{3, 4, 5};" + nl() + 
						  "              ^^^^^^^^^^^^^^^^^ should be `Sequence(ecore::EString)`" + nlnl() + 
						  "  At input/diagnostics/insertionToVariableTypeMismatch.ale:8" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void insertionToVariableUndeclared() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/insertionToVariableUndeclared.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();

		String expected = "Cannot find variable `str`." + nlnl() + 
						  "7| str += ' World!';" + nl() + 
						  "   ^^^" + nl() + 
						  "Maybe you want one of the following?" + nlnl() + 
						  "    self" + nlnl() + 
						  "  At input/diagnostics/insertionToVariableUndeclared.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void insertionToDynamicFeatureThatDoesNotSupportOperator() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/insertionToDynamicFeatureThatDoesNotSupportOperator.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "`ecore::EBoolean` does not support the `+=` operator" + nlnl() + 
				"9| self.isHappy += true;" + nl() + 
				"        ^^^^^^^" + nlnl() + 
				"  At input/diagnostics/insertionToDynamicFeatureThatDoesNotSupportOperator.ale:9" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void insertionToDynamicFeatureTypeMismatch() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/insertionToDynamicFeatureTypeMismatch.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "Type mismatch between expected type `ecore::EInt` and actual type `java.lang.Boolean`." + nlnl() + 
				"9| self.i += true;" + nl() + 
				"             ^^^^ should be `ecore::EInt`" + nlnl() + 
				"  At input/diagnostics/insertionToDynamicFeatureTypeMismatch.ale:9" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void insertionToDynamicFeatureUndeclared() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/insertionToDynamicFeatureUndeclared.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "Cannot find attribute `undeclared` in class `ClassA`." + nlnl() + 
				"7| self.undeclared += 42;" + nl() + 
				"        ^^^^^^^^^^" + nlnl() + 
				"  At input/diagnostics/insertionToDynamicFeatureUndeclared.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void insertionToStaticFeatureThatDoesNotSupportOperator() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/attributesOfDifferentTypes.ecore"), asList("input/diagnostics/insertionToStaticFeatureThatDoesNotSupportOperator.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/Mix.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "`ecore::EBoolean` does not support the `+=` operator" + nlnl() + 
				"7| self.bool += true;" + nl() + 
				"        ^^^^" + nlnl() + 
				"  At input/diagnostics/insertionToStaticFeatureThatDoesNotSupportOperator.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void insertionToStaticFeatureTypeMismatch() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/attributesOfDifferentTypes.ecore"), asList("input/diagnostics/insertionToStaticFeatureTypeMismatch.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/Mix.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "Type mismatch between expected type `Sequence(ecore::EString)` and actual type `java.lang.Boolean`." + nlnl() + 
				"7| self.strings += true;" + nl() + 
				"                   ^^^^ should be `Sequence(ecore::EString)`" + nlnl() + 
				"  At input/diagnostics/insertionToStaticFeatureTypeMismatch.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void removeToDynamicFeatureThatDoesNotSupportOperator() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/removeToDynamicFeatureThatDoesNotSupportOperator.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "`ecore::EBoolean` does not support the `-=` operator" + nlnl() + 
				"9| self.isHappy -= true;" + nl() + 
				"        ^^^^^^^" + nlnl() + 
				"  At input/diagnostics/removeToDynamicFeatureThatDoesNotSupportOperator.ale:9" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void removeToDynamicFeatureTypeMismatch() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/removeToDynamicFeatureTypeMismatch.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "Type mismatch between expected type `ecore::EInt` and actual type `java.lang.Boolean`." + nlnl() + 
				"9| self.i -= true;" + nl() + 
				"             ^^^^ should be `ecore::EInt`" + nlnl() + 
				"  At input/diagnostics/removeToDynamicFeatureTypeMismatch.ale:9" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void removeToDynamicFeatureUndeclared() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/removeToDynamicFeatureUndeclared.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "Cannot find attribute `undeclared` in class `ClassA`." + nlnl() + 
				"7| self.undeclared -= 42;" + nl() + 
				"        ^^^^^^^^^^" + nlnl() + 
				"  At input/diagnostics/removeToDynamicFeatureUndeclared.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void removeToStaticFeatureThatDoesNotSupportOperator() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/attributesOfDifferentTypes.ecore"), asList("input/diagnostics/removeToStaticFeatureThatDoesNotSupportOperator.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/Mix.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "`ecore::EBoolean` does not support the `-=` operator" + nlnl() + 
				"7| self.bool -= true;" + nl() + 
				"        ^^^^" + nlnl() + 
				"  At input/diagnostics/removeToStaticFeatureThatDoesNotSupportOperator.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void removeToStaticFeatureTypeMismatch() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/attributesOfDifferentTypes.ecore"), asList("input/diagnostics/removeToStaticFeatureTypeMismatch.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/Mix.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "Type mismatch between expected type `Sequence(ecore::EString)` and actual type `java.lang.Boolean`." + nlnl() + 
				"7| self.strings -= true;" + nl() + 
				"                   ^^^^ should be `Sequence(ecore::EString)`" + nlnl() + 
				"  At input/diagnostics/removeToStaticFeatureTypeMismatch.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void removeToVariableThatDoesNotSupportOperator() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/removeToVariableThatDoesNotSupportOperator.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "`test::ClassA` does not support the `-=` operator" + nlnl() + 
				"8| other -= self;" + nl() + 
				"   ^^^^^" + nlnl() + 
				"  At input/diagnostics/removeToVariableThatDoesNotSupportOperator.ale:8" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void removeToVariableTypeMismatch() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/removeToVariableTypeMismatch.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "Type mismatch between expected type `Sequence(ecore::EString)` and actual type `Sequence(java.lang.Integer)`." + nlnl() + 
				"8| numbers -= Sequence{3, 4, 5};" + nl() + 
				"              ^^^^^^^^^^^^^^^^^ should be `Sequence(ecore::EString)`" + nlnl() + 
				"  At input/diagnostics/removeToVariableTypeMismatch.ale:8" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void removeToVariableUndeclared() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/removeToVariableUndeclared.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();

		String expected = "Cannot find variable `str`." + nlnl() + 
						  "7| str -= ' World!';" + nl() + 
						  "   ^^^" + nl() + 
						  "Maybe you want one of the following?" + nlnl() + 
						  "    self" + nlnl() + 
						  "  At input/diagnostics/removeToVariableUndeclared.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}
	
	@Test
	public void whileNonBooleanCondition() throws ClosedAleEnvironmentException {
		environment = IAleEnvironment.fromPaths(asList("model/test.ecore"), asList("input/diagnostics/whileNonBooleanCondition.ale"));
		
		EObject caller = environment.loadModel(URI.createURI("model/ClassA.xmi")).get(0);
		IBehaviors behaviors = environment.getBehaviors();
		Method main = behaviors.getMainMethods().get(0);
		environment.getInterpreter().eval(caller, main, asList());
		environment.getInterpreter().getLogger().diagnosticForHuman();
		
		String expected = "Type mismatch between expected type `ecore::EBoolean` and actual type `java.lang.String`." + nlnl() + 
						  "7| while ('Hello World!') {" + nl() + 
						  "          ^^^^^^^^^^^^^^ should be `ecore::EBoolean`" + nlnl() + 
						  "  At input/diagnostics/whileNonBooleanCondition.ale:7" + nl(); 
		assertEquals("Wrong output on stderr", expected, getErr());
	}

}
