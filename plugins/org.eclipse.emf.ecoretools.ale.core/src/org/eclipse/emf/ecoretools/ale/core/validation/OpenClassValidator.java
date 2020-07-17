/*******************************************************************************
 * Copyright (c) 2017-2019 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.validation;

import static java.util.Collections.emptyList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.ClassOpenedMoreThanOnce;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.DiagnosticsFactory;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.IncorrectExtendOrder;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.NotAnOpenableClass;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.OpenClassNotFound;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.TypeHasNamesakes;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;
import org.eclipse.emf.ecoretools.ale.implementation.UnresolvedEClassifier;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.VariableInsert;
import org.eclipse.emf.ecoretools.ale.implementation.VariableRemove;
import org.eclipse.emf.ecoretools.ale.implementation.While;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Validates properties of {@link ExtendedClass} in ALE programs.
 */
public class OpenClassValidator implements IValidator {
	
	private BaseValidator base;
	private Map<String, ExtendedClass> duplicatedExensions = new HashMap<>();

	@Override
	public void setBase(BaseValidator baseValidator) {
		this.base = baseValidator;
	}

	@Override
	public List<Message> validateModelBehavior(List<ModelUnit> units) {
		List<Message> msgs = new ArrayList<>();
		duplicatedExensions.clear();
		
		Multimap<EClass, ExtendedClass> extensionByBase = ArrayListMultimap.create();
		
		units
			.stream()
			.flatMap(unit -> unit.getClassExtensions().stream())
			.forEach(xtd -> extensionByBase.put(xtd.getBaseClass(), xtd));
		
		extensionByBase
		.keySet()
		.forEach(base -> {
			Collection<ExtendedClass> extensions = extensionByBase.get(base);
			if(extensions.size() > 1) {
				extensions
				.stream()
				.skip(1)
				.filter(xtd -> xtd.getExtends().isEmpty())
				.forEach(xtd -> duplicatedExensions.put(xtd.getName(), xtd));
			}
		});
		
		return msgs;
	}

	@Override
	public List<Message> validateModelUnit(ModelUnit unit) {
		List<Message> msgs = new ArrayList<>();
		return msgs;
	}

	@Override
	public List<Message> validateExtendedClass(ExtendedClass xtdClass) {
		
		List<Message> msgs = new ArrayList<>();
		
		if(duplicatedExensions.containsKey(xtdClass.getName())) {
			ClassOpenedMoreThanOnce classOpenedMoreThanOnce = DiagnosticsFactory.eINSTANCE.createClassOpenedMoreThanOnce();
			classOpenedMoreThanOnce.setSource(xtdClass);
			classOpenedMoreThanOnce.setLocation(DiagnosticsFactory.eINSTANCE.createCodeLocation());
			classOpenedMoreThanOnce.getLocation().setStartPosition(base.getStartOffset(xtdClass));
			classOpenedMoreThanOnce.getLocation().setEndPosition(base.getEndOffset(xtdClass));
			classOpenedMoreThanOnce.getLocation().setLine(base.getLines(xtdClass).get(0));
			classOpenedMoreThanOnce.getLocation().setSource(base.getSourceFile(xtdClass));
			classOpenedMoreThanOnce.setCurrentDeclaration(xtdClass);
			classOpenedMoreThanOnce.setPreviousDeclaration(duplicatedExensions.get(xtdClass.getName()));
			
			msgs.add(classOpenedMoreThanOnce);
		}
		EClass baseClass = xtdClass.getBaseClass();
		
		if (baseClass == null) {
			NotAnOpenableClass notAnOpenableClass = DiagnosticsFactory.eINSTANCE.createNotAnOpenableClass();
			notAnOpenableClass.setSource(xtdClass);
			notAnOpenableClass.setLocation(DiagnosticsFactory.eINSTANCE.createCodeLocation());
			notAnOpenableClass.getLocation().setStartPosition(base.getStartOffset(xtdClass));
			notAnOpenableClass.getLocation().setEndPosition(base.getStartOffset(xtdClass) + "open class ".length() + xtdClass.getName().length());
			notAnOpenableClass.getLocation().setLine(base.getLines(xtdClass).get(0));
			notAnOpenableClass.getLocation().setSource(base.getSourceFile(xtdClass));
			notAnOpenableClass.setOpenClass(xtdClass);

			msgs.add(notAnOpenableClass);
		}
		else {
			validateExtendedClassHasNoNamesake(xtdClass, msgs);
			validateExtendedClassExists(xtdClass, baseClass, msgs);
			
			EList<EClass> superTypes = baseClass.getESuperTypes();
			List<EClass> extendsBaseClasses =
				xtdClass
				.getExtends()
				.stream()
				.map(xtd -> xtd.getBaseClass())
				.collect(Collectors.toList());
			
			int upperIndex = -1;
			for(EClass superType : superTypes) {
				int currentIndex = extendsBaseClasses.indexOf(superType);
				if(currentIndex != -1 && currentIndex <=  upperIndex) {
					IncorrectExtendOrder incorrectExtendOrder = DiagnosticsFactory.eINSTANCE.createIncorrectExtendOrder();
					incorrectExtendOrder.setSource(xtdClass);
					incorrectExtendOrder.setLocation(DiagnosticsFactory.eINSTANCE.createCodeLocation());
					incorrectExtendOrder.getLocation().setStartPosition(base.getStartOffset(xtdClass));
					incorrectExtendOrder.getLocation().setEndPosition(base.getStartOffset(xtdClass) + ("open class " + xtdClass.getName() + " extends " + xtdClass.getBaseClass().getName()).length());
					incorrectExtendOrder.getLocation().setLine(base.getLines(xtdClass).get(0));
					incorrectExtendOrder.getLocation().setSource(base.getSourceFile(xtdClass));
					incorrectExtendOrder.setSuperType(superType);
					incorrectExtendOrder.setSuperSuperType(extendsBaseClasses.get(upperIndex));
					
					msgs.add(incorrectExtendOrder);
				}
				else {
					upperIndex = currentIndex;
				}
			}
		}
		return msgs;
	}

	private void validateExtendedClassExists(ExtendedClass xtdClass, EClass baseClass, List<Message> msgs) {
		boolean baseClassDoesntExist = UnresolvedEClassifier.class.equals(baseClass.getInstanceClass());
		if (baseClassDoesntExist) {
			OpenClassNotFound openClassDoesNotExist = DiagnosticsFactory.eINSTANCE.createOpenClassNotFound();
			openClassDoesNotExist.setSource(xtdClass);
			openClassDoesNotExist.setLocation(DiagnosticsFactory.eINSTANCE.createCodeLocation());
			openClassDoesNotExist.getLocation().setStartPosition(base.getStartOffset(xtdClass));
			openClassDoesNotExist.getLocation().setEndPosition(base.getStartOffset(xtdClass) + "open class ".length() + xtdClass.getName().length());
			openClassDoesNotExist.getLocation().setLine(base.getLines(xtdClass).get(0));
			openClassDoesNotExist.getLocation().setSource(base.getSourceFile(xtdClass));
			openClassDoesNotExist.setOpenClass(xtdClass);
			
			msgs.add(openClassDoesNotExist);
		}
	}

	private void validateExtendedClassHasNoNamesake(ExtendedClass xtdClass, List<Message> msgs) {
		Collection<EClassifier> namesakes = this.base.getQryEnv().getEPackageProvider().getTypes(xtdClass.getName());
		boolean hasNamesakes = namesakes.size() > 1;
		if (hasNamesakes) {
			TypeHasNamesakes openClassHasNamesakes = DiagnosticsFactory.eINSTANCE.createTypeHasNamesakes();
			openClassHasNamesakes.setSource(xtdClass);
			openClassHasNamesakes.getNamesakes().addAll(namesakes);
			openClassHasNamesakes.setLocation(DiagnosticsFactory.eINSTANCE.createCodeLocation());
			openClassHasNamesakes.getLocation().setStartPosition(base.getStartOffset(xtdClass));
			openClassHasNamesakes.getLocation().setEndPosition(base.getStartOffset(xtdClass) + "open class ".length() + xtdClass.getName().length());
			openClassHasNamesakes.getLocation().setLine(base.getLines(xtdClass).get(0));
			openClassHasNamesakes.getLocation().setSource(base.getSourceFile(xtdClass));
			
			msgs.add(openClassHasNamesakes);
		}
	}

	@Override
	public List<Message> validateRuntimeClass(RuntimeClass classDef) {
		return emptyList();
	}

	@Override
	public List<Message> validateMethod(Method mtd) {
		return emptyList();
	}

	@Override
	public List<Message> validateFeatureAssignment(FeatureAssignment featAssign) {
		return emptyList();
	}

	@Override
	public List<Message> validateFeatureInsert(FeatureInsert featInsert) {
		return emptyList();
	}

	@Override
	public List<Message> validateFeatureRemove(FeatureRemove featRemove) {
		return emptyList();
	}

	@Override
	public List<Message> validateVariableAssignment(VariableAssignment varAssign) {
		return emptyList();
	}

	@Override
	public List<Message> validateVariableDeclaration(VariableDeclaration varDecl) {
		return emptyList();
	}
	
	@Override
	public List<Message> validateVariableInsert(VariableInsert varInsert) {
		return emptyList();
	}
	
	@Override
	public List<Message> validateVariableRemove(VariableRemove varRemove) {
		return emptyList();
	}

	@Override
	public List<Message> validateForEach(ForEach loop) {
		return emptyList();
	}

	@Override
	public List<Message> validateIf(If ifStmt) {
		return emptyList();
	}

	@Override
	public List<Message> validateWhile(While loop) {
		return emptyList();
	}

}
