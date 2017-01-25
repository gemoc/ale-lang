package interpreter

import org.eclipse.acceleo.query.runtime.AcceleoQueryEvaluationException
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EStructuralFeature
import implementation.Root
import java.util.Map
import java.util.HashMap

class DynamicFeatureAccess {
	
	Root implem
	
	Map<EObject,Map<String,Object>> extendedObjects //instance -> (featureName -> value)
	
	new(Root implem){
		this.implem = implem
		extendedObjects = newHashMap
	}
	
	/**
	 * Returns the value of the specified feature on the specified object. The object must be an
	 * {@link EObject} or a {@link Set}, {@link List} of {@link EObject}.
	 * 
	 * @param context
	 *            the object in which to read the feature.
	 * @param featureName
	 *            the name of the feature to read.
	 * @param diagnostic
	 *            The status to update in case of warnings or errors during this call.
	 * @return the value of the specified feature in the specified object.
	 */
	def Object aqlFeatureAccess(EObject context, String featureName) {
		var Object result;

		if (context == null) {
			val String message = String.format(DynamicFeatureAccessService.NON_EOBJECT_FEATURE_ACCESS, featureName, "null");
			throw new AcceleoQueryEvaluationException(message);
		} else {
			val EClass eClass = (context).eClass();
			val EStructuralFeature feature = eClass.getEStructuralFeature(featureName);
			if (feature == null) {
				result = getDynamicFeatureValue(context,featureName)
				if(result == null){
					val String message = String.format(DynamicFeatureAccessService.UNKNOWN_FEATURE, featureName, eClass.getName());
					throw new AcceleoQueryEvaluationException(message);
				}
			} else {
				result = (context).eGet(feature);
			}
		}

		return result;
	}
	
	public def Object getDynamicFeatureValue(EObject instance, String featureName) {
		
		val extendedInstance = getExtensionFeatures(instance)
		
		val featureValue = extendedInstance.get(featureName)
		if(featureValue !== null)
			return featureValue
		
		val xtdClass = implem.classExtensions.findFirst[baseClass.isInstance(instance)] //FIXME:type hierarchy
		val featureDeclaration = xtdClass.attributes.findFirst[name == featureName]
		
		if(featureDeclaration === null){
			val String message = String.format(DynamicFeatureAccessService.UNKNOWN_FEATURE, featureName, instance.eClass.getName());
			throw new AcceleoQueryEvaluationException(message);
		}
		
		//featureDeclaration.valueExpression
		val initialValue = 0 //TODO: eval initial value (in the constructor)
		extendedInstance.put(featureName,initialValue)
		
		return initialValue
	}
	
	public def void setDynamicFeatureValue(EObject instance, String featureName, Object newValue) {
		val extendedInstance = getExtensionFeatures(instance)
		
		val featureValue = extendedInstance.get(featureName)
		if(featureValue !== null)
			extendedInstance.put(featureName,newValue)
		else{
			val xtdClass = implem.classExtensions.findFirst[baseClass.isInstance(instance)] //FIXME:type hierarchy
			val featureDeclaration = xtdClass.attributes.findFirst[name == featureName]
			if(featureDeclaration !== null){
				extendedInstance.put(featureName,newValue)
			}
			else{
				//TODO:raise feature not found error
			}
		}
	}
	
	private def Map<String,Object> getExtensionFeatures(EObject instance) {
		var extendedInstance = extendedObjects.get(instance)
		
		if(extendedInstance === null){
			extendedInstance = new HashMap<String,Object>()
			extendedObjects.put(instance,extendedInstance)
		}
		
		return extendedInstance
	}
}