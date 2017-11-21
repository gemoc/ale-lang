package org.eclipse.emf.ecoretools.ale.ide.debug;

import org.eclipse.debug.core.sourcelookup.AbstractSourceLookupDirector;
import org.eclipse.debug.core.sourcelookup.ISourceLookupParticipant;

public class AleSourceLookupDirector extends AbstractSourceLookupDirector{

	@Override
	public void initializeParticipants() {
		addParticipants(new ISourceLookupParticipant[]{new AleSourceLookupParticipant()});
	}

}
