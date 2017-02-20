package lang.core.validation.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.junit.Before;
import org.junit.Test;

import implementation.ImplementationPackage;
import implementation.ModelBehavior;
import lang.core.parser.AstBuilder;
import lang.core.parser.visitor.ParseResult;
import lang.core.validation.ImplementationValidator;

/**
 * This class checks the errors raised by the ModelBehavior validator
 */
public class ValidatorTest {
	
	IQueryEnvironment queryEnvironment;
	AstBuilder parser;
	
	@Before
	public void setup(){
		queryEnvironment = Query.newEnvironmentWithDefaultServices(null);
		queryEnvironment.registerEPackage(ImplementationPackage.eINSTANCE);
		queryEnvironment.registerEPackage(AstPackage.eINSTANCE);
		parser = new AstBuilder(queryEnvironment);
	}
	
	@Test
	public void testAttributeDuplication(){
		String fileContent = getFileContent("input/validation/duplicatedAttrib.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 39, 60, "The name newAttribute is already used", msg.get(0));
	}
	
	@Test
	public void testTypeErrorAttribute(){
		String fileContent = getFileContent("input/validation/typeErrorAttrib.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 35, 52, "Expected EString but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testParamDuplication(){
		String fileContent = getFileContent("input/validation/duplicatedParameters.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 16, 55, "The name param is already used", msg.get(0));
	}
	
	@Test
	public void testLocalDuplication(){
		String fileContent = getFileContent("input/validation/duplicatedLocalVariable.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 49, 66, "The name localVar is already used", msg.get(0));
	}
	
	@Test
	public void testTypeErrorLocal(){
		String fileContent = getFileContent("input/validation/typeErrorLocal.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 43, 60, "Expected EString but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testNoConflictAttribParamLocal(){
		String fileContent = getFileContent("input/validation/noConflictAttribParamLocal.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(0, msg.size());
	}
	
	@Test
	public void testScopeLocal(){
		String fileContent = getFileContent("input/validation/scopeLocalVariable.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 62, 79, "The name localVar is already used", msg.get(0));
	}
	
	@Test
	public void testScopeTypeErrorLocal(){
		String fileContent = getFileContent("input/validation/scopeTypeErrorLocal.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 62, 79, "Expected EInt but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testResultDeclarationError(){
		String fileContent = getFileContent("input/validation/declareResultError.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 16, 31, "'result' is a reserved name", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 34, 78, "'result' is a reserved name", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 60, 75, "'result' is a reserved name", msg.get(2));
	}
	
	@Test
	public void testSelfDeclarationError(){
		String fileContent = getFileContent("input/validation/declareSelfError.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(3, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 16, 29, "'self' is a reserved name", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 32, 72, "'self' is a reserved name", msg.get(1));
		assertMsgEquals(ValidationMessageLevel.ERROR, 56, 69, "'self' is a reserved name", msg.get(2));
	}
	
	@Test
	public void testLocalAssignTypeError(){
		String fileContent = getFileContent("input/validation/assignLocalTypeError.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 81, 98, "Expected EInt but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testUnknownLocalAssign(){
		String fileContent = getFileContent("input/validation/assignUnknownLocal.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 33, 50, "The variable wrong is not defined", msg.get(0));
	}
	
	@Test
	public void testAttributeAssignTypeError(){ //dynamic attribute
		String fileContent = getFileContent("input/validation/assignAttributeTypeError.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 51, 72, "Expected EString but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testFeatureAssignTypeError(){ //EStructural feature
		String fileContent = getFileContent("input/validation/assignFeatureTypeError.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 33, 52, "Expected [EPackage] but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testUnknownFeatureAssign(){
		String fileContent = getFileContent("input/validation/assignUnknownFeature.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 33, 55, "The feature wrong is not defined", msg.get(0));
	}
	
	@Test
	public void testResultAssignTypeError(){
		String fileContent = getFileContent("input/validation/assignResult.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(2, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 33, 44, "'result' is assigned in void operation", msg.get(0));
		assertMsgEquals(ValidationMessageLevel.ERROR, 92, 103, "Expected [EString] but was [java.lang.Integer]", msg.get(1));
	}
	
	@Test
	public void testParamAssignError(){
		String fileContent = getFileContent("input/validation/assignParamError.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 42, 53, "param is a parameter and can't be assigned", msg.get(0));
	}
	
	@Test
	public void testSelfAssignError(){
		String fileContent = getFileContent("input/validation/assignSelfError.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 33, 61, "'self' can't be assigned", msg.get(0));
	}
	
	@Test
	public void testFeatureInsertTypeError(){
		String fileContent = getFileContent("input/validation/featureInsertTypeError.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 33, 63, "Expected [EClass] but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testFeatureRemoveTypeError(){
		String fileContent = getFileContent("input/validation/featureRemoveTypeError.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 33, 66, "Expected [EClass] but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testForEachCollectionError(){
		String fileContent = getFileContent("input/validation/forEachCollectionError.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 42, 45, "Expected Collection but was [java.lang.Boolean]", msg.get(0));
	}
	
	@Test
	public void testIfBooleanError(){
		String fileContent = getFileContent("input/validation/ifBooleanError.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 36, 42, "Expected Boolean but was [java.lang.Integer]", msg.get(0));
	}
	
	@Test
	public void testWhileBooelanError(){
		String fileContent = getFileContent("input/validation/whileBooleanError.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 39, 48, "Expected Boolean but was [java.lang.String]", msg.get(0));
	}
	
	@Test
	public void testOperationDuplication(){
		String fileContent = getFileContent("input/validation/operationDuplication.implem");
		ParseResult<ModelBehavior> res = parser.parse(fileContent);
		ModelBehavior root = res.getRoot();
		ImplementationValidator validator = new ImplementationValidator(queryEnvironment);
		validator.validate(res);
		List<IValidationMessage> msg = validator.getMessages();
		
		assertEquals(1, msg.size());
		assertMsgEquals(ValidationMessageLevel.ERROR, 35, 51, "The name op is already used", msg.get(0));
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
