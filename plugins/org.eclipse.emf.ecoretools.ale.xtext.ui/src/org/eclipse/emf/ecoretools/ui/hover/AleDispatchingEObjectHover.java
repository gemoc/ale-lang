package org.eclipse.emf.ecoretools.ui.hover;

import static java.util.Arrays.asList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider.IInformationControlCreatorProvider;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;

public class AleDispatchingEObjectHover extends DispatchingEObjectTextHover {
 
    @Inject
    IEObjectHoverProvider hoverProvider;
 
    IInformationControlCreatorProvider lastCreatorProvider = null;
 
    @Override
    public Object getHoverInfo(EObject first, ITextViewer textViewer, IRegion hoverRegion) {
        if (first instanceof Keyword) {
            lastCreatorProvider = hoverProvider.getHoverInfo(first, textViewer, hoverRegion);
            return lastCreatorProvider == null ? null : lastCreatorProvider.getInfo();
        }
        lastCreatorProvider = null;
        return super.getHoverInfo(first, textViewer, hoverRegion);
    }
 
    @Override
    public IInformationControlCreator getHoverControlCreator() {
        return this.lastCreatorProvider == null ? super.getHoverControlCreator() : lastCreatorProvider.getHoverControlCreator();
    }
 
    @Override
    protected Pair<EObject, IRegion> getXtextElementAt(XtextResource resource, final int offset) {
        Pair<EObject, IRegion> result = super.getXtextElementAt(resource, offset);
        if (result == null) {
            result = resolveKeywordAt(resource, offset);
        }
        return result;
    }

	private static Pair<EObject, IRegion> resolveKeywordAt(XtextResource resource, int offset) {
		IParseResult parseResult = resource.getParseResult();
		if (parseResult != null) {
			ILeafNode leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset);
			if (leaf != null && leaf.isHidden() && leaf.getOffset() == offset) {
				leaf = NodeModelUtils.findLeafNodeAtOffset(parseResult.getRootNode(), offset - 1);
			}
			if (leaf != null && leaf.getGrammarElement() instanceof Keyword) {
				Keyword keyword = (Keyword) leaf.getGrammarElement();
				if (asList("open", "behavior").contains(keyword.getValue())) {
					return Tuples.create((EObject) keyword, (IRegion) new Region(leaf.getOffset(), leaf.getLength()));
				}
			}
		}
		return null;
	}

}
