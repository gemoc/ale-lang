package lang.core.interpreter.services;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.acceleo.query.ast.Call;
import org.eclipse.acceleo.query.ast.StringLiteral;
import org.eclipse.acceleo.query.runtime.ICompletionProposal;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IValidationResult;
import org.eclipse.acceleo.query.runtime.impl.AbstractService;
import org.eclipse.acceleo.query.runtime.impl.JavaMethodService;
import org.eclipse.acceleo.query.runtime.impl.ValidationServices;
import org.eclipse.acceleo.query.runtime.impl.completion.EFeatureCompletionProposal;
import org.eclipse.acceleo.query.validation.type.EClassifierType;
import org.eclipse.acceleo.query.validation.type.IType;
import org.eclipse.acceleo.query.validation.type.SequenceType;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

import lang.core.interpreter.DynamicFeatureRegistry;

/**
 * Copy/past of EObjectServices.EObjectFeatureAccess cause it's private & final :(
 */
public class DynamicFeatureAccessService extends JavaMethodService {
	
	public static final String DON_T_KNOW_WHAT_TO_DO_WITH = "don't know what to do with ";
	public static final String NON_EOBJECT_FEATURE_ACCESS = "Attempt to access feature (%s) on a non ModelObject value (%s).";
	public static final String UNKNOWN_FEATURE = "Feature %s not found in EClass %s";
	
	/**
	 * Creates a new service instance given a method and an instance.
	 * 
	 * @param method
	 *            the method that realizes the service
	 * @param serviceInstance
	 *            the instance on which the service must be called
	 */
	public DynamicFeatureAccessService (Method method, DynamicFeatureRegistry serviceInstance) {
		super(method, serviceInstance);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see JavaMethodService#getType(org.eclipse.acceleo.query.ast.Call,
	 *      org.eclipse.acceleo.query.runtime.impl.ValidationServices,
	 *      org.eclipse.acceleo.query.runtime.IValidationResult,
	 *      org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment, java.util.List)
	 */
	@Override
	public Set<IType> getType(Call call, ValidationServices services, IValidationResult validationResult,
			IReadOnlyQueryEnvironment queryEnvironment, List<IType> argTypes) {
		String featureName = ((StringLiteral)call.getArguments().get(1)).getValue();
		Set<IType> result = featureAccessTypes(services, queryEnvironment, argTypes.get(0),
				featureName);

		return result;
	}

	/**
	 * Gets the type of a feature access.
	 * 
	 * @param queryEnvironment
	 *            the {@link IReadOnlyQueryEnvironment}
	 * @param receiverTypes
	 *            the target types to gets the feature from
	 * @param featureName
	 *            the feature name
	 * @return the type of a feature access
	 */
	public Set<IType> featureAccessTypes(ValidationServices services,
			IReadOnlyQueryEnvironment queryEnvironment, IType receiverType, String featureName) {
		Set<IType> result = new LinkedHashSet<IType>();

		Set<EClass> receiverEClasses = new LinkedHashSet<EClass>();
		if (receiverType.getType() instanceof EClass) {
			receiverEClasses.add((EClass)receiverType.getType());
		} else if (receiverType.getType() instanceof Class) {
			Set<EClassifier> eClassifiers = queryEnvironment.getEPackageProvider().getEClassifiers(
					(Class<?>)receiverType.getType());
			if (eClassifiers != null) {
				for (EClassifier eCls : eClassifiers) {
					if (eCls instanceof EClass) {
						receiverEClasses.add((EClass)eCls);
					}
				}
			}
		} else {
			throw new IllegalStateException(DON_T_KNOW_WHAT_TO_DO_WITH + receiverType.getType());
		}

		if (receiverEClasses.isEmpty()) {
			result.add(services.nothing(NON_EOBJECT_FEATURE_ACCESS, featureName, receiverType.getType()
					.toString()));
		} else {
			for (EClass eClass : receiverEClasses) {
				EStructuralFeature feature = eClass.getEStructuralFeature(featureName);
				if (feature == null) {
					result.add(services.nothing(UNKNOWN_FEATURE, featureName, eClass.getName()));
				} else {
					EClassifierType featureBasicType = new EClassifierType(queryEnvironment,
							feature.getEType());
					if (feature.isMany()) {
						result.add(new SequenceType(queryEnvironment, featureBasicType));
					} else {
						result.add(featureBasicType);
					}
				}
			}
		}

		return result;
		// CHECKSTYLE:OFF
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see AbstractService#validateAllType(org.eclipse.acceleo.query.runtime.impl.ValidationServices,
	 *      org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment, java.util.Map)
	 */
	@Override
	public Set<IType> validateAllType(ValidationServices services,
			IReadOnlyQueryEnvironment queryEnvironment, Map<List<IType>, Set<IType>> allTypes) {
		Set<IType> result = new LinkedHashSet<IType>();

		Set<IType> knownReceiverTypes = new LinkedHashSet<IType>();
		for (Entry<List<IType>, Set<IType>> entry : allTypes.entrySet()) {
			if (knownReceiverTypes.add(entry.getKey().get(0))) {
				result.addAll(entry.getValue());
			}
		}

		return result;
	}

	@Override
	public List<ICompletionProposal> getProposals(IReadOnlyQueryEnvironment queryEnvironment,
			Set<IType> receiverTypes) {
		return getEStructuralFeatureProposals(queryEnvironment, receiverTypes);
	}

	/**
	 * Gets the {@link List} of {@link EFeatureCompletionProposal} for {@link EStructuralFeature}.
	 * 
	 * @param receiverTypes
	 *            the receiver types.
	 * @return the {@link List} of {@link EFeatureCompletionProposal} for {@link EStructuralFeature}
	 */
	public List<ICompletionProposal> getEStructuralFeatureProposals(
			IReadOnlyQueryEnvironment queryEnvironment, Set<IType> receiverTypes) {
		List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
		Set<EClass> eClasses = new LinkedHashSet<EClass>();

		for (IType iType : receiverTypes) {
			if (iType.getType() instanceof EClass) {
				eClasses.add((EClass)iType.getType());
			}
		}

		for (EStructuralFeature feature : queryEnvironment.getEPackageProvider().getEStructuralFeatures(
				eClasses)) {
			result.add(new EFeatureCompletionProposal(feature));
		}

		return result;
	}
	
	@Override
	public int getPriority() {
		return super.getPriority() + 1;
	}
}