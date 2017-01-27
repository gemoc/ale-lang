package services

import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil

class FactoryService {
	
	def static EObject create(EClass cls) {
		return EcoreUtil.create(cls)
	}	
}