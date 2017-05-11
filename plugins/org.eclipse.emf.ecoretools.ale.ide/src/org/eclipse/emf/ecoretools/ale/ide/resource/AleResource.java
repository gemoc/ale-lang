package org.eclipse.emf.ecoretools.ale.ide.resource;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecoretools.ale.core.parser.Dsl;
import org.eclipse.emf.ecoretools.ale.core.parser.DslBuilder;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.ide.WorkbenchDsl;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

public class AleResource extends ResourceImpl {
	
	protected DslBuilder parser;
	protected List<ParseResult<ModelUnit>> parseResult;
	
	private boolean isNotifyEnabled = true;
	
	public AleResource(URI uri, DslBuilder parser) {
		super(uri);
		this.parser = parser;
	}
	
	@Override
	protected void doLoad(InputStream inputStream, Map<?, ?> options) throws IOException {
		Dsl dslFile = new WorkbenchDsl(inputStream);
		List<ParseResult<ModelUnit>> newParseResult = parser.parse(dslFile);
		
		if(newParseResult != null) { //TODO: check no parse error
			unload();
			parseResult = newParseResult;
			List<ModelUnit> newContent = parseResult.stream().map(pr -> pr.getRoot()).collect(Collectors.toList());
			
			isNotifyEnabled = false;
			getContents().addAll(newContent);
			isNotifyEnabled = true;
		}
	}
	
	@Override
	protected void doUnload() {
		super.doUnload();
		//TODO: remove parse result?
	}
	
	@Override
	public void doSave(OutputStream outputStream, Map<?, ?> options) throws IOException {
		//FIXME: need a serializer
	}
	
	public List<ParseResult<ModelUnit>> getParseResult() {
		return parseResult;
	}
	
	@Override
	public boolean eNotificationRequired() {
		if(isNotifyEnabled) {
			return super.eNotificationRequired();
		}
		else {
			return false;
		}
	}
	
	@Override
	public void save(Map<?, ?> options) throws IOException {
		//Do nothing
	}
}
