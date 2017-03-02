package lang.ide.popup.actions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.sirius.common.tools.api.interpreter.IInterpreterWithDiagnostic.IEvaluationResult;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import lang.LangInterpreter;

public class RunModel extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		
		
		System.out.println("Run model!");
		Shell shell = HandlerUtil.getActiveWorkbenchWindow(event).getShell();
		
		IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getActiveMenuSelection(event);
		IResource resource = (IResource) selection.getFirstElement();
		
		
		ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(shell, ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
		dialog.setTitle("Resource Selection");
		dialog.open();
		Object[] selected = dialog.getResult();
		
		LangInterpreter interpreter = new LangInterpreter();
		
//		interpreter.javaExtensions.addImport("logo.example.service.Display");
		Set<String> projects = new HashSet<String>();
		projects.add("logo.example");
		projects.add("logo.model");
		Set<String> plugins = new HashSet<String>();
			plugins.add("lang.core");
			plugins.add("org.eclipse.acceleo.query");
		interpreter.javaExtensions.updateScope(plugins,projects);
		
		interpreter.javaExtensions.reloadIfNeeded();
		
		ResourceSetImpl rs = new ResourceSetImpl();
		Set<EPackage> lastEPackages = 
				interpreter
				.getQueryEnvironment()
				.getEPackageProvider()
				.getEClassifiers()
				.stream()
				.map(cls -> cls.getEPackage())
				.collect(Collectors.toSet());
		lastEPackages
			.stream()
			.forEach(pkg -> rs.getPackageRegistry().put(pkg.getNsURI(), pkg));
		Resource res = rs.getResource(URI.createPlatformResourceURI(resource.getFullPath().toString(), true), true);
		EObject caller = res.getContents().get(0);
		EClass cls = caller.eClass();
		String implem = getFileContent(((File)selected[0]).getLocation().toString());
		
		IEvaluationResult result = interpreter.eval(caller, new ArrayList(), implem);
		
		return null;
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
}
