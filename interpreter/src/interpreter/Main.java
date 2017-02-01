package interpreter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import drawing.Window;
import implementation.Behaviored;
import implementation.ExtendedClass;
import implementation.ModelBehavior;
import kmLogo.ASM.ASMPackage;
import kmLogo.ASM.LogoProgram;
import parser.AstBuilder;
import vmlogo.Context;
import vmlogo.VmlogoPackage;

public class Main {
	public static void main(String[] args) {
		
		Set<EPackage> mm = loadMetamodel();
		ModelBehavior implem = loadImplem(mm);
		
		ResourceSetImpl rs = new ResourceSetImpl();
		LogoProgram model = (LogoProgram) loadModel("model/LogoProgram.xmi",rs).getContents().get(0);
		Context ctx = (Context) loadModel("data/My.vmlogo",rs).getContents().get(0);
		List params = new ArrayList();
		params.add(ctx);
		
		EvalEnvironment env = new EvalEnvironment(Query.newEnvironmentWithDefaultServices(null), mm, implem);
		ImplementationEngine engine = new ImplementationEngine(env);
		engine.eval(model, getMainOp(implem), params);
		
		new Window(ctx.getTurtle());
	}
	
	public static Behaviored getMainOp(ModelBehavior implem) {
		Optional<Behaviored> mainOp = 
				implem.getClassExtensions().stream()
				.flatMap(cls -> cls.getMethods().stream())
				.filter(op -> op.isIsMain())
				.findFirst();
		
		return mainOp.get();
	}
	
	public static Set<EPackage> loadMetamodel(){
		Set<EPackage> metamodel = new HashSet<EPackage>();
		metamodel.add(ASMPackage.eINSTANCE);
		metamodel.add(VmlogoPackage.eINSTANCE);
		return metamodel;
	}
	
	public static ModelBehavior loadImplem(Set<EPackage> metamodel){
		String implementionPath = "data/LogoProgram.implem";
		String fileContent = "";
		try {
			fileContent = new String(Files.readAllBytes(Paths.get(implementionPath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return (new AstBuilder(metamodel)).parse(fileContent);
	}
	
	public static Resource loadModel(String path,ResourceSet rs) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		URI uri = URI.createURI(path);
		return rs.getResource(uri, true);
	}
}
