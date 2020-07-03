package org.eclipse.emf.ecoretools.ui.hover;

import org.eclipse.emf.ecore.EObject;
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
	protected String getHoverInfoAsHtml(EObject o) {
		if (o instanceof Keyword) {
			return hoverText((Keyword) o);
		}
		return super.getHoverInfoAsHtml(o);
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

}
