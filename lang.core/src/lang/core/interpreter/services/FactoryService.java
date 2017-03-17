package lang.core.interpreter.services;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.google.common.collect.Sets;

import lang.core.interpreter.EvalEnvironment;

/**
 * AQL service to create instance of EClass
 */
public class FactoryService {
	
	EvalEnvironment evalEnv;
	
	public FactoryService(EvalEnvironment evalEnv) {
		this.evalEnv = evalEnv;
	}
	
	public EObject create(EClass cls) {
		EObject newInstance = EcoreUtil.create(cls);
		evalEnv.initialize(Sets.newHashSet(newInstance));
		return newInstance;
	}
}