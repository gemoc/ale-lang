package services;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class FactoryService {
	
	public static EObject create(EClass cls) {
		return EcoreUtil.create(cls);
	}	
}