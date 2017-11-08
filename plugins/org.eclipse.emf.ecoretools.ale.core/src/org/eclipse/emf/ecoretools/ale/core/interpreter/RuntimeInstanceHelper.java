/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.interpreter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class RuntimeInstanceHelper {
	
	public static final String ALE_RUNTIME = "ALE_RUNTIME_";
	public static final String ALE_RUNTIME_PKG = "ALE_RUNTIME_PKG";
	
	public static Map<EClass,EClass> getBaseToRuntime(List<ModelUnit> allModelUnits, List<EClass> domain) {
		
		Map<EClass,EClass> baseToRuntime = new HashMap<EClass,EClass>();
		
		/*
		 * Collect fragments from Extension & super-Extensions
		 */
		Map<EClass,List<EClass>> baseToFragments = new HashMap<EClass,List<EClass>>();
		allModelUnits
		.stream()
		.flatMap(u -> u.getClassExtensions().stream())
		.forEach(xtd -> {
			EClass base = xtd.getBaseClass();
			
			List<EClass> fragments = baseToFragments.get(base);
			if(fragments == null){
				fragments = new ArrayList<EClass>();
				baseToFragments.put(base,fragments);
			}
			
			List<EClass> finalFrag = fragments;
			
			Set<ExtendedClass> allSupers = new HashSet<ExtendedClass>();
			collectAllSupers(xtd,allSupers);
			
			allSupers.forEach(extension -> {
				if(extension.getFragment() != null){
					finalFrag.add(extension.getFragment());
				}
			});
		});
		
		//Avoid null value
		domain.forEach(cls -> {
			if(baseToFragments.get(cls) == null) {
				baseToFragments.put(cls, new ArrayList<EClass>());
			}
		});
		
		/*
		 * Finish collect with super classes
		 */
		domain.forEach(cls -> {
			baseToRuntime.put(cls, merge(cls,allFragments(cls,baseToFragments,domain)));
		});
		
		/*
		 * Put all new EClass in an EPackage
		 */
		EClass ePkgClass = EcorePackage.eINSTANCE.getEPackage();
		EPackage pkg = (EPackage) EcoreUtil.create(ePkgClass);
		pkg.setName(ALE_RUNTIME_PKG);
		baseToRuntime.values().forEach(cls -> pkg.getEClassifiers().add(cls));
		
		return baseToRuntime;
	}
	
	private static List<EClass> allSupers(EClass cls, List<EClass> domain) {
		return
			domain
			.stream()
			.filter(c -> c.isSuperTypeOf(cls))
			.collect(Collectors.toList());
	}
	
	private static void collectAllSupers(ExtendedClass xtdCls, Set<ExtendedClass> collector) {
		if(!collector.contains(xtdCls)) {
			collector.add(xtdCls);
			EList<ExtendedClass> supers = xtdCls.getExtends();
			supers.forEach(s ->	collectAllSupers(s,collector));
		}
	}
	
	private static Set<EClass> allFragments(EClass baseClass, Map<EClass,List<EClass>> baseToFragments, List<EClass> domain) {
		
		List<EClass> allSuperClasses = allSupers(baseClass, domain);
		
		return
			allSuperClasses
			.stream()
			.flatMap(base -> baseToFragments.get(base).stream())
			.collect(Collectors.toSet());
	}
	
	/*
	 * Create runtime EClass for {@link base}
	 * 
	 * Return new EClass with all structural features
	 */
	private static EClass merge(EClass base, Set<EClass> fragments) {
		EClass eClsClass = EcorePackage.eINSTANCE.getEClass();
		EClass cls = (EClass) EcoreUtil.create(eClsClass);
		cls.setName(ALE_RUNTIME+base.getName());
		
		fragments
		.stream()
		.flatMap(frag -> frag.getEAllStructuralFeatures().stream())
		.forEach(feature -> {
			EStructuralFeature featureCopy = EcoreUtil.copy(feature);
			cls.getEStructuralFeatures().add(featureCopy);
		});
		
		return cls;
	}
}
