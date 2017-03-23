package lang.core.validation.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.junit.Before;
import org.junit.Test;

import implementation.ImplementationPackage;
import implementation.ModelBehavior;
import lang.LangInterpreter;
import lang.core.parser.AstBuilder;
import lang.core.parser.Dsl;
import lang.core.parser.DslBuilder;
import lang.core.parser.visitor.ParseResult;
import lang.core.validation.ImplementationValidator;

/**
 * This class checks the errors raised by the ModelBehavior validator
 */
public class ValidatorTest {
	
	LangInterpreter interpreter;
	
	@Before
	public void setup(){
		interpreter = new LangInterpreter();
	}
	
	@Test
	public void testAttributeDuplication(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/duplicatedAttrib.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 71, 92, "The name newAttribute is already used", msg.get(0));
	}
	
	@Test
	public void testTypeErrorAttribute(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/typeErrorAttrib.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 81, "Expected EString but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testParamDuplication(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/duplicatedParameters.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 43, 82, "The name param is already used", msg.get(0));
	}
	
	@Test
	public void testLocalDuplication(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/duplicatedLocalVariable.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 82, 99, "The name localVar is already used", msg.get(0));
	}
	
	@Test
	public void testTypeErrorLocal(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/typeErrorLocal.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 73, 90, "Expected EString but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testNoConflictAttribParamLocal(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/noConflictAttribParamLocal.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testScopeLocal(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/scopeLocalVariable.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 93, 110, "The name localVar is already used", msg.get(0));
	}
	
	@Test
	public void testScopeTypeErrorLocal(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/scopeTypeErrorLocal.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 92, 109, "Expected [EClassifier=EInt] but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testResultDeclarationError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/declareResultError.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
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
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 45, 58, "'self' is a reserved name", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 61, 101, "'self' is a reserved name", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 85, 98, "'self' is a reserved name", msg.get(2));
	}
	
	@Test
	public void testLocalAssignTypeError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignLocalTypeError.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 113, 130, "Expected [EClassifier=EInt] but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testUnknownLocalAssign(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignUnknownLocal.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 65, 82, "The variable wrong is not defined", msg.get(0));
	}
	
	@Test
	public void testAttributeAssignTypeError(){ //dynamic attribute
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignAttributeTypeError.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 82, 101, "Expected [EString] but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testFeatureAssignTypeError(){ //EStructural feature
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignFeatureTypeError.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 83, "Expected [EPackage] but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testUnknownFeatureAssign(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignUnknownFeature.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 86, "The feature wrong is not defined", msg.get(0));
	}
	
	@Test
	public void testResultAssignTypeError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignResult.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 63, 74, "'result' is assigned in void operation", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 122, 133, "Expected EString but was [java.lang.Integer]", msg.get(1));
	}
	
	@Test
	public void testParamAssignError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignParamError.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 74, 85, "param is a parameter and can't be assigned", msg.get(0));
	}
	
	@Test
	public void testSelfAssignError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/assignSelfError.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 92, "'self' can't be assigned", msg.get(0));
	}
	
	@Test
	public void testFeatureInsertTypeError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureInsertTypeError.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 61, 91, "Expected [EClass] but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testFeatureRemoveTypeError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/featureRemoveTypeError.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 60, 93, "Expected [EClass] but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testForEachCollectionError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/forEachCollectionError.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 70, 73, "Expected Collection but was [java.lang.Boolean]", msg.get(0));
	}
	
	@Test
	public void testIfBooleanError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/ifBooleanError.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 63, 69, "Expected Boolean but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testWhileBooelanError(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/whileBooleanError.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 69, 78, "Expected Boolean but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testOperationDuplication(){
		Dsl environment = new Dsl(Arrays.asList(),Arrays.asList("input/validation/operationDuplication.implem"));
		List<ParseResult<ModelBehavior>> parsedSemantics = (new DslBuilder(interpreter.getQueryEnvironment())).parse(environment);
		
		
		ImplementationValidator validator = new ImplementationValidator(interpreter.getQueryEnvironment());
		validator.validate(parsedSemantics);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 64, 80, "The name op is already used", msg.get(0));
	}
	
	
	private void assertMsgEquals(ValidationMessageLevel errorLvl, int startPos, int endPos, String text, IValidationMessage msg){
		assertEquals(errorLvl, msg.getLevel());
		assertEquals(startPos, msg.getStartPosition());
		assertEquals(endPos, msg.getEndPosition());
		assertEquals(text, msg.getMessage());
	}
	
	private static String getFileContent(String implementionPath){
		String fileContent = "";
		try {
			fileContent = new String(Files.readAllBytes(Paths.get(implementionPath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}
}
