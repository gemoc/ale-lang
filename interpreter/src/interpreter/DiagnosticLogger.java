package interpreter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;

public class DiagnosticLogger {
	List<Diagnostic> log = new ArrayList<Diagnostic>();
	
	public void notify(Diagnostic diag) {
		log.add(diag);
	}
	
	public List<Diagnostic> getLog() {
		return log;
	}
}
