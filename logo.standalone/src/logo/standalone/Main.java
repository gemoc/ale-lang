package logo.standalone;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;

import implementation.Behaviored;
import implementation.ImplementationPackage;
import implementation.ModelBehavior;
import kmLogo.ASM.ASMPackage;
import kmLogo.ASM.LogoProgram;
import lang.LangInterpreter;
import lang.core.interpreter.DiagnosticLogger;
import lang.core.interpreter.ImplementationEvaluator;
import lang.core.parser.visitor.ParseResult;
import logo.example.service.Display;
import vmlogo.Turtle;
import vmlogo.VmlogoPackage;

public class Main {
	
	public static void main(String[] args) {
		/*
		 * Load resources
		 */
		Set<EPackage> mm = loadMetamodel();
		ResourceSetImpl rs = new ResourceSetImpl();
		LogoProgram model = (LogoProgram) loadModel("../logo.example/data/LogoProgram.xmi",rs).getContents().get(0);
		String implementation = getFileContent("../logo.example/data/LogoProgram.implem");
		
		/*
		 * Init eval environment
		 */
		LangInterpreter interpreter = new LangInterpreter();
		mm.stream().forEach(pkg -> interpreter.getQueryEnvironment().registerEPackage(pkg));
		interpreter.getQueryEnvironment().registerEPackage(ImplementationPackage.eINSTANCE);
		interpreter.getQueryEnvironment().registerEPackage(AstPackage.eINSTANCE);
		
		/*
		 * Eval
		 */
		IEvaluationResult result = interpreter.eval(model, new ArrayList(), implementation);
		Display.show((Turtle) result.getValue());
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
	
	public static String getFileContent(String implementionPath){
		String fileContent = "";
		try {
			fileContent = new String(Files.readAllBytes(Paths.get(implementionPath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileContent;
	}
	
	public static Resource loadModel(String path,ResourceSet rs) {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		URI uri = URI.createURI(path);
		return rs.getResource(uri, true);
	}
	
	public static int getLine(int offset, String file) {
		try (LineNumberReader r = new LineNumberReader(new FileReader(file))) {
			r.setLineNumber(1); //first line is number 0 by default
		    int count = 0;
		    while (r.read() != -1 && count < offset) {
		        count++;
		    }
		    if (count == offset) {
		        return r.getLineNumber();
		    } else {
		        System.out.println("File is not long enough");
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static void diagnosticForHuman(DiagnosticLogger logger, String file, ParseResult<ModelBehavior> parseRes) {
		logger.getLog().stream().forEach(diagnotic -> {
			if(diagnotic instanceof BasicDiagnostic){
				BasicDiagnostic chain = (BasicDiagnostic) diagnotic;
				chain
					.getChildren()
					.stream()
					.forEach(
						diag -> {
							if(diag.getSource().equals(ImplementationEvaluator.PLUGIN_ID)){
								Expression failedExp = (Expression) diag.getData().get(0);
								Diagnostic diagExp = (Diagnostic) diag.getData().get(1);
								int startPos = parseRes.getStartPositions().get(failedExp);
								int line = getLine(startPos, file);
								System.out.println("\n[AQL eval fail] At line "+ line +" :\n"+diagExp.toString());
							}
						}
					);
			}
		});
	}
}
