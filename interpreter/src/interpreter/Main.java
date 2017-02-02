package interpreter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Expression;
import org.eclipse.acceleo.query.runtime.EvaluationResult;
import org.eclipse.acceleo.query.runtime.Query;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
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
import parser.visitor.ParseResult;
import vmlogo.Context;
import vmlogo.VmlogoPackage;

public class Main {
	public static void main(String[] args) {
		
		Set<EPackage> mm = loadMetamodel();
		ParseResult<ModelBehavior> parseResult = loadImplem(mm);
		ModelBehavior implem = parseResult.getRoot();
		
		ResourceSetImpl rs = new ResourceSetImpl();
		LogoProgram model = (LogoProgram) loadModel("model/LogoProgram.xmi",rs).getContents().get(0);
		Context ctx = (Context) loadModel("data/My.vmlogo",rs).getContents().get(0);
		List params = new ArrayList();
		params.add(ctx);
		
		DiagnosticLogger logger = new DiagnosticLogger();
		EvalEnvironment env = new EvalEnvironment(Query.newEnvironmentWithDefaultServices(null), mm, implem, logger);
		ImplementationEngine engine = new ImplementationEngine(env);
		EvaluationResult result = engine.eval(model, getMainOp(implem), params);
		
//		System.out.println(result.getDiagnostic());
		logger.notify(result.getDiagnostic());
		diagnosticForHuman(logger,"data/LogoProgram.implem",parseResult);
		
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
	
	public static ParseResult<ModelBehavior> loadImplem(Set<EPackage> metamodel){
		String implementionPath = "data/LogoProgram.implem";
		String fileContent = "";
		try {
			fileContent = new String(Files.readAllBytes(Paths.get(implementionPath)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ParseResult<ModelBehavior> parseRes = (new AstBuilder(metamodel)).parse(fileContent);
//		int offset = parseRes.getStartPositions().get(parseRes.getRoot().getClassExtensions().get(5).getMethods().get(0).getBody().getStatements().get(0));
//		int line = getLine(offset,implementionPath);
		return parseRes;
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
