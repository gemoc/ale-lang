package org.eclipse.emf.ecoretools.ale.core.validation.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.core.validation.ALEValidator;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.junit.Before;
import org.junit.Test;

/**
 * Check name errors raised by the ModelBehavior validator
 */
public class NameValidatorTest {

	ALEInterpreter interpreter;
	
	@Before
	public void setup(){
		interpreter = new ALEInterpreter();
	}
	
	@Test
	public void testAttributeDuplication(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/duplicatedAttrib.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 71, 92, "The name newAttribute is already used", msg.get(0));
	}
	
	@Test
	public void testParamDuplication(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/duplicatedParameters.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 43, 82, "The name param is already used", msg.get(0));
	}
	
	@Test
	public void testLocalDuplication(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/duplicatedLocalVariable.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 82, 99, "The name localVar is already used", msg.get(0));
	}
	
	@Test
	public void testConflictAttribParamLocal(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/conflictAttribParamLocal.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 87, 99, "The name foo is already used", msg.get(0));
	}
	
	@Test
	public void testScopeLocal(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/scopeLocalVariable.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 93, 110, "The name localVar is already used", msg.get(0));
	}
	
	@Test
	public void testResultDeclarationError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/declareResultError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 44, 59, "'result' is a reserved name", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 62, 106, "'result' is a reserved name", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 88, 103, "'result' is a reserved name", msg.get(2));
	}
	
	@Test
	public void testSelfDeclarationError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/declareSelfError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 45, 58, "'self' is a reserved name", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 61, 101, "'self' is a reserved name", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 85, 98, "'self' is a reserved name", msg.get(2));
	}
	
	@Test
	public void testUnknownLocalAssign(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignUnknownLocal.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 65, 82, "The variable wrong is not defined", msg.get(0));
	}
	
	@Test
	public void testUnknownFeatureAssign(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignUnknownFeature.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 86, "The feature wrong is not defined", msg.get(0));
	}
	
	@Test
	public void testParamAssignError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignParamError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 74, 85, "param is a parameter and can't be assigned", msg.get(0));
	}
	
	@Test
	public void testSelfAssignError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignSelfError.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 92, "'self' can't be assigned", msg.get(0));
	}
	
	@Test
	public void testOperationDuplication(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/operationDuplication.implem"));
		List<ParseResult<ModelUnit>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ALEValidator validator = new ALEValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 80, "The operation op() is already declared", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 140, 168, "The operation mtd(EString) is already declared", msg.get(1));
	}
	
	private void assertMsgEquals(ValidationMessageLevel errorLvl, int startPos, int endPos, String text, IValidationMessage msg){
		assertEquals(errorLvl, msg.getLevel());
		assertEquals(startPos, msg.getStartPosition());
		assertEquals(endPos, msg.getEndPosition());
		assertEquals(text, msg.getMessage());
	}
}
