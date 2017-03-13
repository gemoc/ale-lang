package fr.inria.diverse.objectalgebragenerator.test;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Test;

import fr.inria.diverse.objectalgebragenerator.popup.actions.GenerateAlgebra;

public class UnitTests2 {

	private static final String ROOT_PATH = System.getProperty("user.dir");


	@Test
	public void simpleTest() throws Exception {
		testCompare("simpleTest");
	}
	
	@Test
	public void nameConflictPackageA() throws Exception {
		testCompare("nameConflict/packageA");	
	}
	@Test
	public void nameConflictPackageB() throws Exception {
		testCompare("nameConflict/packageB");	
	}
	
	@Test
	public void nameConflictPackageC() throws Exception {
		testCompare("nameConflict/packageC");	
	}
	
	@Test
	public void packageA() throws Exception {
		testCompare("packageA");	
	}
	
	@Test
	public void wShapedInheritance() throws Exception {
		testCompare("wShapedInheritance");	
	}
	
	@Test
	public void packageB() throws Exception {
		testCompare("packageB");	
	}
	
	@Test
	public void packageC() throws Exception {
		testCompare("packageC");	
	}
	
	@Test
	public void packageD() throws Exception {
		testCompare("packageD");	
	}
	
	
	@Test
	public void oneAbstractClass() throws Exception {
		testCompare("oneAbstractClass");
	}
	
	@Test
	public void simpleInheritance1() throws Exception {
		testCompare("SimpleInheritance1");
	}
	
	@Test
	public void simpleInheritance2() throws Exception {
		testCompare("SimpleInheritance2");
	}
	
	@Test
	public void oARootInheritance1() throws Exception {
		testCompare("OARootInheritance1");
	}
	
	@Test
	public void simpleCrossRefNoInheritance() throws Exception {
		testCompare("SimpleCrossRefNoInheritance");
	}
	
	

	private void testCompare(String file) throws IOException {
		final URI uri = URI.createFileURI(new File("model/" + file + ".ecore").getAbsolutePath());

		final ResourceSetImpl resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore", new XMIResourceFactoryImpl());
		final Resource resource = resourceSet.getResource(uri, true);
		final EPackage ePackage = (EPackage) resource.getContents().get(0);
		final String fileContent = new GenerateAlgebra().processAlgebra(ePackage);

		System.out.println(fileContent);
	}
}
