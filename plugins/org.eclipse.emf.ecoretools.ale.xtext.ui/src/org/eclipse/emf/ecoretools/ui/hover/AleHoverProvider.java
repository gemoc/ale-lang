package org.eclipse.emf.ecoretools.ui.hover;

import static java.util.stream.Collectors.joining;
import static org.eclipse.emf.ecoretools.ale.core.validation.QualifiedNames.getQualifiedName;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecoretools.ale.Unit;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.ide.project.IAleProject;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.jface.internal.text.html.HTMLPrinter;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.XtextBrowserInformationControlInput;

public class AleHoverProvider extends DefaultEObjectHoverProvider {

	@Override
	protected XtextBrowserInformationControlInput getHoverInfo(EObject obj, IRegion region, XtextBrowserInformationControlInput prev) {
		if (obj instanceof Keyword) {
			String html = getHoverInfoAsHtml(obj);
			if (html != null) {
				StringBuffer buffer = new StringBuffer(html);
				HTMLPrinter.insertPageProlog(buffer, 0, getStyleSheet());
				HTMLPrinter.addPageEpilog(buffer);
				return new XtextBrowserInformationControlInput(prev, obj, buffer.toString(), getLabelProvider());
			}
		}
		return super.getHoverInfo(obj, region, prev);
	}

	@Override
	protected String getHoverInfoAsHtml(EObject hovered) {
		if (hovered instanceof Keyword) {
			return hoverText((Keyword) hovered);
		}
		else if (hovered instanceof org.eclipse.emf.ecoretools.ale.ExtendedClass) {
			org.eclipse.emf.ecoretools.ale.ExtendedClass extendedClass = (org.eclipse.emf.ecoretools.ale.ExtendedClass) hovered;
			IFile aleFile = WorkspaceSynchronizer.getFile(hovered.eResource());
			IAleEnvironment environment = IAleProject.from(aleFile.getProject()).getEnvironment();
			return environment.getBehaviors()
							  .findClass(extendedClass.getName())
							  .filter(ExtendedClass.class::isInstance)
							  .map(ExtendedClass.class::cast)
							  .map(cls -> hoverText(environment, cls))
							  .orElse("unresolved class");
		}
		else if (hovered instanceof Unit) {
			Unit unit = (Unit) hovered;
			IFile aleFile = WorkspaceSynchronizer.getFile(hovered.eResource());
			IAleEnvironment environment = IAleProject.from(aleFile.getProject()).getEnvironment();
			return hoverText(environment, unit);
		}
		return super.getHoverInfoAsHtml(hovered);
	}

	private static String hoverText(Keyword keyword) {
		if (keyword.getValue().equals("open")) {
			return "Opens a class already defined in an Ecore model to add new attributes or methods";
		}
		else if (keyword.getValue().equals("behavior")) {
			return "Defines a new semantic module. <br/>"
				 + "<br/>"
				 + "The name that follows is the name of the new EPackage "
				 + "that will be created to contain the dynamic classes defined with the <code>class</code> keyword.";
		}
		else {
			return "";
		}
	}
	
	private static String hoverText(IAleEnvironment env, ExtendedClass cls) {
		if (cls.getBaseClass() == null) {
			return "unresolved class '" + cls.getName() + "'<br/>"
				 + "<br/>"
				 + "The following EPackage are currently registered:<br/>"
				 + env.getMetamodels().stream()
				 	  .map(pkg -> "<li>" + pkg.getName() + " (nsPrefix:" + pkg.getNsPrefix() + ", nsURI: " + pkg.getNsURI() + ")</il>")
					  .collect(joining("", "<ul>", "</ul>"));
		}
		else {
			EClass openClass = cls.getBaseClass();
			EPackage pkg = openClass.getEPackage();
			return "<b>Opening:</b> " + getQualifiedName(openClass) + "<br/>"
				 + "<br/>"
				 + "<b>EPackage:</b> " + pkg.getName() + " (nsPrefix:" + pkg.getNsPrefix() + ", nsURI: " + pkg.getNsURI() + ")";
		}
	}
	
	private static String hoverText(IAleEnvironment environment, Unit unit) {
		return "Available EPackages:<br/>"
			 + environment.getMetamodels().stream()
			 			  .map(pkg -> "<li>" + pkg.getName() + " (nsPrefix:" + pkg.getNsPrefix() + ", nsURI: " + pkg.getNsURI() + ")</li>")
			 			  .collect(joining("", "<ul>", "</ul>"));
	}

}
