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
package org.eclipse.emf.ecoretools.ale.core.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.runtime.IValidationMessage;
import org.eclipse.acceleo.query.runtime.ValidationMessageLevel;
import org.eclipse.acceleo.query.runtime.impl.ValidationMessage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureInsert;
import org.eclipse.emf.ecoretools.ale.implementation.FeatureRemove;
import org.eclipse.emf.ecoretools.ale.implementation.ForEach;
import org.eclipse.emf.ecoretools.ale.implementation.If;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;
import org.eclipse.emf.ecoretools.ale.implementation.VariableAssignment;
import org.eclipse.emf.ecoretools.ale.implementation.VariableDeclaration;
import org.eclipse.emf.ecoretools.ale.implementation.While;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class OpenClassValidator implements IValidator {
	
	public static final String OPENCLASS_DUPLICATION = "The EClass %s is already opened (need explicit extends)";
	public static final String EXTENDS_ORDER = "The extended EClass %s have to be after %s";
	
	BaseValidator base;
	List<ExtendedClass> duplicatedExensions = new ArrayList<>();

	@Override
	public void setBase(BaseValidator baseValidator) {
		this.base = baseValidator;
	}

	@Override
	public List<IValidationMessage> validateModelBehavior(List<ModelUnit> units) {
		List<IValidationMessage> msgs = new ArrayList<>();
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
				.forEach(xtd -> duplicatedExensions.add(xtd));
			}
		});
		
		return msgs;
	}

	@Override
	public List<IValidationMessage> validateModelUnit(ModelUnit unit) {
		List<IValidationMessage> msgs = new ArrayList<>();
		return msgs;
	}

	@Override
	public List<IValidationMessage> validateExtendedClass(ExtendedClass xtdClass) {
		
		List<IValidationMessage> msgs = new ArrayList<>();
		
		if(duplicatedExensions.contains(xtdClass)) {
			msgs.add(new ValidationMessage(
					ValidationMessageLevel.ERROR,
					String.format(OPENCLASS_DUPLICATION, xtdClass.getBaseClass().getName()),
					this.base.getStartOffset(xtdClass),
					this.base.getEndOffset(xtdClass)
					));
		}

		
		
		EClass base = xtdClass.getBaseClass();
		EList<EClass> superTypes = base.getESuperTypes();
		
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
				msgs.add(new ValidationMessage(
						ValidationMessageLevel.ERROR,
						String.format(EXTENDS_ORDER, superType.getName(), extendsBaseClasses.get(upperIndex).getName()),
						this.base.getStartOffset(xtdClass),
						this.base.getEndOffset(xtdClass)
						));
			}
			else {
				upperIndex = currentIndex;
			}
		}
		
		return msgs;
	}

	@Override
	public List<IValidationMessage> validateRuntimeClass(RuntimeClass classDef) {
		return new ArrayList<>();
	}

	@Override
	public List<IValidationMessage> validateMethod(Method mtd) {
		return new ArrayList<>();
	}

	@Override
	public List<IValidationMessage> validateFeatureAssignment(FeatureAssignment featAssign) {
		return new ArrayList<>();
	}

	@Override
	public List<IValidationMessage> validateFeatureInsert(FeatureInsert featInsert) {
		return new ArrayList<>();
	}

	@Override
	public List<IValidationMessage> validateFeatureRemove(FeatureRemove featRemove) {
		return new ArrayList<>();
	}

	@Override
	public List<IValidationMessage> validateVariableAssignment(VariableAssignment varAssign) {
		return new ArrayList<>();
	}

	@Override
	public List<IValidationMessage> validateVariableDeclaration(VariableDeclaration varDecl) {
		return new ArrayList<>();
	}

	@Override
	public List<IValidationMessage> validateForEach(ForEach loop) {
		return new ArrayList<>();
	}

	@Override
	public List<IValidationMessage> validateIf(If ifStmt) {
		return new ArrayList<>();
	}

	@Override
	public List<IValidationMessage> validateWhile(While loop) {
		return new ArrayList<>();
	}

}
