package services

import org.eclipse.acceleo.query.runtime.impl.JavaMethodService
import java.lang.reflect.Method
import java.util.List
import org.eclipse.acceleo.query.runtime.impl.LambdaValue
import org.eclipse.emf.common.util.Diagnostic

class ForEachService /*extends JavaMethodService*/{
	
//	new(Method method, Object serviceInstance) {
//		super(method, serviceInstance)
//	}
	
	def static <T> List<T> forEach(List<T> sequence, LambdaValue lambda) {
		if (lambda !== null) {
			for (T elt : sequence) {
				try {
					lambda.eval(#{elt })
				} catch (Exception e) {
					lambda.logException(Diagnostic.WARNING, e);
				}
			}
		}
		return sequence;
	}
}