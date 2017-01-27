package services

import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EObject
import java.util.Collection

class EListService {
	def static void add(Collection list, Object obj) { //TODO: check types
		list.add(obj)
	}
}