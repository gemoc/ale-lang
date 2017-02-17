package lang.core.interpreter.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.junit.Before;
import org.junit.Test;

import lang.LangInterpreter;

/**
 * This class test the execution of ModelBehavior
 */
public class EvalTest {
	
	LangInterpreter interpreter;
	EObject caller;
	
	@Before
	public void setup() {
		interpreter = new LangInterpreter();
		List<EPackage> pkgs = loadMetamodel();
		pkgs
		.stream()
		.forEach(pkg -> interpreter.getQueryEnvironment().registerEPackage(pkg));
		EClass cls = (EClass) interpreter.getQueryEnvironment().getEPackageProvider().getType("test","ClassA");
		caller = EcoreUtil.create(cls);
		
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
	
	private static List<EPackage> loadMetamodel() {
		ResourceSet rs = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		URI uri = URI.createURI("model/test.ecore");
		List<EPackage> pkgs = new ArrayList<EPackage>();
		
		pkgs.addAll(
			rs.getResource(uri, true)
			.getContents()
			.stream()
			.filter(o -> o instanceof EPackage)
			.map(o -> (EPackage) o)
			.collect(Collectors.toList())
			);
		
		return pkgs;
	}
	
	@Test
	public void testAccessLocalVariable(){
		String fileContent = getFileContent("input/eval/localvar.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals("foobar",res.getValue());
	}
	
	@Test
	public void testAccessParameter(){
		String fileContent = getFileContent("input/eval/args.implem");
		List<Object> args = new ArrayList();
		String obj = "";
		args.add(obj);
		IEvaluationResult res = interpreter.eval(caller, args, fileContent);
		
		assertEquals(obj,res.getValue());
	}
	
	@Test
	public void testAccessSelf(){
		String fileContent = getFileContent("input/eval/self.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(caller,res.getValue());
	}
	
	@Test
	public void testAccessSelfDynamicAttribute(){
		String fileContent = getFileContent("input/eval/selfDynamicAttribute.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals("foo",res.getValue());
	}
	
	@Test
	public void testAccessLocalDynamicAttribute(){
		String fileContent = getFileContent("input/eval/localDynamicAttribute.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals("foo",res.getValue());
	}

	@Test
	public void testAccessParamDynamicAttribute(){
		String fileContent = getFileContent("input/eval/paramDynamicAttribute.implem");
		List<Object> args = new ArrayList();
		EObject newInstance = EcoreUtil.create(caller.eClass());
		args.add(newInstance);
		IEvaluationResult res = interpreter.eval(caller, args, fileContent);
		
		assertEquals("foo",res.getValue());
	}

	@Test
	public void testAccessResultDynamicAttribute(){
		String fileContent = getFileContent("input/eval/resultDynamicAttribute.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals("foo",res.getValue());
	}
	
	@Test
	public void testAccessCallDynamicAttribute(){
		String fileContent = getFileContent("input/eval/callDynamicAttribute.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals("foo",res.getValue());
	}
	
	@Test
	public void testAccessSelfAttribute(){
		String fileContent = getFileContent("input/eval/selfAttribute.implem");
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		caller.eSet(field, 1);
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(1,res.getValue());
	}
	
	@Test
	public void testAccessLocalAttribute(){
		String fileContent = getFileContent("input/eval/localAttribute.implem");
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		caller.eSet(field, 2);
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(2,res.getValue());
	}

	@Test
	public void testAccessParamAttribute(){
		String fileContent = getFileContent("input/eval/paramAttribute.implem");
		List<Object> args = new ArrayList();
		EObject newInstance = EcoreUtil.create(caller.eClass());
		args.add(newInstance);
		EStructuralFeature field = newInstance.eClass().getEStructuralFeature("field");
		newInstance.eSet(field, 3);
		IEvaluationResult res = interpreter.eval(caller, args, fileContent);
		
		assertEquals(3,res.getValue());
	}

	@Test
	public void testAccessResultAttribute(){
		String fileContent = getFileContent("input/eval/resultAttribute.implem");
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		caller.eSet(field, 4);
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(4,res.getValue());
	}
	
	@Test
	public void testAccessCallAttribute(){
		String fileContent = getFileContent("input/eval/callAttribute.implem");
		EStructuralFeature field = caller.eClass().getEStructuralFeature("field");
		caller.eSet(field, 5);
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(5,res.getValue());
	}
	
	@Test
	public void testAssignSelfDynamicAttribute(){
		String fileContent = getFileContent("input/eval/selfDynamicAttributeAssign.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals("bar",res.getValue());
	}
	
	@Test
	public void testAssignLocalDynamicAttribute(){
		String fileContent = getFileContent("input/eval/localDynamicAttributeAssign.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals("bar",res.getValue());
	}
	
	@Test
	public void testAssignParamDynamicAttribute(){
		String fileContent = getFileContent("input/eval/paramDynamicAttributeAssign.implem");
		List<Object> args = new ArrayList();
		EObject newInstance = EcoreUtil.create(caller.eClass());
		args.add(newInstance);
		IEvaluationResult res = interpreter.eval(caller, args, fileContent);
		
		assertEquals("bar",res.getValue());
	}
	
	@Test
	public void testAssignResultDynamicAttribute(){
		String fileContent = getFileContent("input/eval/resultDynamicAttributeAssign.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals("bar",res.getValue());
	}
	
	@Test
	public void testAssignCallDynamicAttribute(){
		String fileContent = getFileContent("input/eval/callDynamicAttributeAssign.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals("bar",res.getValue());
	}
	
	@Test
	public void testAssignSelfAttribute(){
		String fileContent = getFileContent("input/eval/selfAttributeAssign.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(1,res.getValue());
	}
	
	@Test
	public void testAssignLocalAttribute(){
		String fileContent = getFileContent("input/eval/localAttributeAssign.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(2,res.getValue());
	}
	
	@Test
	public void testAssignParamAttribute(){
		String fileContent = getFileContent("input/eval/paramAttributeAssign.implem");
		List<Object> args = new ArrayList();
		EObject newInstance = EcoreUtil.create(caller.eClass());
		args.add(newInstance);
		IEvaluationResult res = interpreter.eval(caller, args, fileContent);
		
		assertEquals(3,res.getValue());
	}

	@Test
	public void testAssignResultAttribute(){
		String fileContent = getFileContent("input/eval/resultAttributeAssign.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(4,res.getValue());
	}

	@Test
	public void testAssignCallAttribute(){
		String fileContent = getFileContent("input/eval/callAttributeAssign.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(5,res.getValue());
	}
	
	@Test
	public void testSelfCall(){
		String fileContent = getFileContent("input/eval/selfCall.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(1,res.getValue());
	}
	
	@Test
	public void testLocalCall(){
		String fileContent = getFileContent("input/eval/localCall.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(2,res.getValue());
	}
	
	@Test
	public void testAttributeCall(){
		String fileContent = getFileContent("input/eval/attributeCall.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(3,res.getValue());
	}
	
	@Test
	public void testDynamicAttributeCall(){
		String fileContent = getFileContent("input/eval/dynamicAttributeCall.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(4,res.getValue());
	}
	
	@Test
	public void testParamCall(){
		String fileContent = getFileContent("input/eval/paramCall.implem");
		List<Object> args = new ArrayList();
		EObject newInstance = EcoreUtil.create(caller.eClass());
		args.add(newInstance);
		IEvaluationResult res = interpreter.eval(caller, args, fileContent);
		
		assertEquals(5,res.getValue());
	}
	
	@Test
	public void testResultCall(){
		String fileContent = getFileContent("input/eval/resultCall.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(6,res.getValue());
	}
	
	@Test
	public void testChainAttrib(){
		String fileContent = getFileContent("input/eval/chainAttribute.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(caller,res.getValue());
	}
	
	@Test
	public void testChainDynamicAttrib(){
		String fileContent = getFileContent("input/eval/chainDynamicAttribute.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(caller,res.getValue());
	}
	
	@Test
	public void testChainCall(){
		String fileContent = getFileContent("input/eval/chainCall.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(caller,res.getValue());
	}
	
	@Test
	public void testForEachSequence(){
		String fileContent = getFileContent("input/eval/forEachSequence.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals("012345",res.getValue());
	}
	
	@Test
	public void testForEachReverseSequence(){
		String fileContent = getFileContent("input/eval/forEachReverseSequence.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals("4321",res.getValue());
	}
	
	@Test
	public void testForEachCollection(){
		String fileContent = getFileContent("input/eval/forEachCollection.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(2,res.getValue());
	}
	
	@Test
	public void testForEachEmpty(){
		String fileContent = getFileContent("input/eval/forEachEmptyCollection.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(0,res.getValue());
	}
	
	@Test
	public void testWhile(){
		String fileContent = getFileContent("input/eval/while.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(10,res.getValue());
	}
	
	@Test
	public void testIfTrue(){
		String fileContent = getFileContent("input/eval/ifTrue.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(1,res.getValue());
	}
	
	@Test
	public void testIfFalse(){
		String fileContent = getFileContent("input/eval/ifFalse.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(0,res.getValue());
	}
	
	@Test
	public void testElseTrue(){
		String fileContent = getFileContent("input/eval/elseTrue.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(1,res.getValue());
	}
	
	@Test
	public void testElseFalse(){
		String fileContent = getFileContent("input/eval/elseFalse.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(2,res.getValue());
	}
	
	@Test
	public void testAdd(){
		String fileContent = getFileContent("input/eval/add.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(3,res.getValue());
	}
	
	@Test
	public void testRemove(){
		String fileContent = getFileContent("input/eval/remove.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals(2,res.getValue());
	}
	
	@Test
	public void testLog(){
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		
		String fileContent = getFileContent("input/eval/log.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		assertEquals("foobar\n", outContent.toString());
		
		System.setOut(null);
		
	}
	
	@Test
	public void testCreate(){
		String fileContent = getFileContent("input/eval/create.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertNotNull(res.getValue());
		assertNotEquals(caller,res.getValue());
		assertTrue(res.getValue() instanceof EObject);
		assertTrue(((EObject)res.getValue()).eClass().getName().equals("ClassA"));
	}
	
	@Test
	public void testService(){
		String fileContent = getFileContent("input/eval/service.implem");
		IEvaluationResult res = interpreter.eval(caller, new ArrayList(), fileContent);
		
		assertEquals("foobar:ClassA",res.getValue());
	}
}
