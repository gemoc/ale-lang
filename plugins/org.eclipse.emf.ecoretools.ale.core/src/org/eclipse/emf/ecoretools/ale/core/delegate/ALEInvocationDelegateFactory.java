package org.eclipse.emf.ecoretools.ale.core.delegate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.ast.AstPackage;
import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate;
import org.eclipse.emf.ecore.EOperation.Internal.InvocationDelegate.Factory;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageRegistryImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ALEEngine;
import org.eclipse.emf.ecoretools.ale.core.interpreter.DiagnosticLogger;
import org.eclipse.emf.ecoretools.ale.core.interpreter.EvalEnvironment;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ExtensionEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

public class ALEInvocationDelegateFactory implements Factory {

	ALEEngine engine;
	List<ModelUnit> allBehaviors;
	List<EPackage> scope;
	
	public ALEInvocationDelegateFactory() {
		
	}
	
	public ALEInvocationDelegateFactory(List<EPackage> scope) {
		this.scope = scope;
	}
	
	@Override
	public InvocationDelegate createInvocationDelegate(EOperation operation) {
		
		ALEEngine engine = getEngine();
		
		Optional<Method> method = 
			allBehaviors
			.stream()
			.flatMap(unit -> unit.getClassExtensions().stream())
			.flatMap(cls -> cls.getMethods().stream())
			.filter(mtd -> mtd.getOperationRef() == operation)
			.findFirst();
		
		return new ALEInvocationDelegate(engine, method);
	}
	
	public ALEEngine getEngine() {
		if(engine == null) {
			IQueryEnvironment qryEnv = new ExtensionEnvironment();
			qryEnv.registerEPackage(EcorePackage.eINSTANCE);
	    	qryEnv.registerCustomClassMapping(EcorePackage.eINSTANCE.getEStringToStringMapEntry(),
					EStringToStringMapEntryImpl.class);
	    	qryEnv.registerEPackage(ImplementationPackage.eINSTANCE);
	    	qryEnv.registerEPackage(AstPackage.eINSTANCE);
	    	
	    	List<EPackage> pkgs = getAllPackages();
	    	for (EPackage ePkg : pkgs) {
	    		qryEnv.registerEPackage(ePkg);
			}
			
			List<ParseResult<ModelUnit>> parsedSemantics = (new EAnnotationParser(qryEnv)).parse(pkgs);
			allBehaviors = 
					parsedSemantics
			    	.stream()
			    	.filter(sem -> sem.getRoot() != null)
			    	.map(sem -> sem.getRoot())
			    	.collect(Collectors.toList());
			DiagnosticLogger logger = new DiagnosticLogger(parsedSemantics);
			EvalEnvironment env = new EvalEnvironment(qryEnv, allBehaviors, logger);
			engine = new ALEEngine(env);
		}
		return engine;
	}
	
	private List<EPackage> getAllPackages() {
		if(scope != null) {
			return scope;
		}
		else {
			List<EPackage> pkgs = new ArrayList<EPackage>();
	    	pkgs.addAll((Collection<? extends EPackage>) EPackageRegistryImpl.createGlobalRegistry().values());
	    	return pkgs;
		}
	}
}
