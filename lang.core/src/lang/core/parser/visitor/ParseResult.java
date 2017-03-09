package lang.core.parser.visitor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;

/**
 * Wrapper for Implementation model.
 * It keeps a mapping between elements of the model & their offset in the '.implem' file.
 */
public class ParseResult<T> {
	private String sourceFile;
	private final Map<Object, Integer> startPositions = new HashMap<Object, Integer>();
	private final Map<Object, Integer> endPositions = new HashMap<Object, Integer>();
	private Diagnostic diagnostic;
	private T root;
	
	public Map<Object, Integer> getStartPositions() {
		return startPositions;
	}
	
	public Map<Object, Integer> getEndPositions() {
		return endPositions;
	}
	
	public Diagnostic getDiagnostic() {
		return diagnostic;
	}
	
	public void setDiagnostic(Diagnostic diagnostic) {
		this.diagnostic = diagnostic;
	}
	
	public T getRoot() {
		return root;
	}
	
	public void setRoot(T root) {
		this.root = root;
	}
	
	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}
	
	public String getSourceFile() {
		return sourceFile;
	}
}
