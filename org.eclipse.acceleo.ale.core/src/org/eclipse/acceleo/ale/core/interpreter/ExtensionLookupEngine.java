package org.eclipse.acceleo.ale.core.interpreter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.acceleo.ale.core.interpreter.services.EvalBodyService;
import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.runtime.lookup.basic.BasicLookupEngine;
import org.eclipse.acceleo.query.runtime.lookup.basic.CacheLookupEngine;
import org.eclipse.acceleo.query.validation.type.IType;

//FIXME: would like extend CacheLookupEngine but it's too private
public class ExtensionLookupEngine extends BasicLookupEngine {

	public ExtensionLookupEngine(IReadOnlyQueryEnvironment queryEnvironment) {
		super(queryEnvironment);
	}

	@Override
	public IService lookup(String name, IType[] argumentTypes) {
		List<IService> multiMethod = getServices().getMultiService(name, argumentTypes.length);
		if (multiMethod == null) {
			return null;
		} else {
			List<IService> candidates = new ArrayList<IService>();
			for (IService service : multiMethod) {
				if (service.matches(queryEnvironment, argumentTypes)) {
					candidates.add(service);
				}
			}
			return selectBestCandidate(candidates);
		}
	}
	
	private IService selectBestCandidate(List<IService> candidates) {
		
		List<EvalBodyService> evalServices = 
			candidates
			.stream()
			.filter(srv -> srv instanceof EvalBodyService)
			.map(srv -> (EvalBodyService)srv)
			.collect(Collectors.toList());
		
		if(!evalServices.isEmpty()) {
			
			IService result = null;
			for (EvalBodyService service : evalServices) {
				if (result == null
						
						|| (service.getPriority() > result.getPriority() && service
						.isEqualParameterTypes(queryEnvironment, result))
						
						|| (service.isLowerParameterTypes(queryEnvironment, result)) ) {
					
					result = service;
				}
			}
			return result;
		}
		else { //BasicLookupEngine behavior
			
			IService result = null;
			for (IService service : candidates) {
				if (result == null
						|| service.getPriority() > result.getPriority()
						|| (service.getPriority() == result.getPriority() && service
								.isLowerOrEqualParameterTypes(queryEnvironment, result))) {
					result = service;
				}
			}
			return result;
		}
	}
}
