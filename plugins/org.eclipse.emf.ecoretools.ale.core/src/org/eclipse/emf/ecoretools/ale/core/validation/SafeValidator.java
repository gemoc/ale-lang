/*******************************************************************************
 * Copyright (c) 2020 Inria and Obeo.
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

import java.util.List;
import java.util.Objects;

import org.eclipse.emf.ecoretools.ale.core.Activator;
import org.eclipse.emf.ecoretools.ale.core.diagnostics.Message;
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
import org.eclipse.emf.ecoretools.ale.implementation.VariableInsert;
import org.eclipse.emf.ecoretools.ale.implementation.VariableRemove;
import org.eclipse.emf.ecoretools.ale.implementation.While;

/**
 * Decorates a {@link IValidator} in order to surround all its method calls
 * with a try-catch statement. Exceptions are logged through the {@link Activator}
 * and an empty list is returned instead. 
 */
public final class SafeValidator implements IValidator {

	private final IValidator unsafeValidator;

	public SafeValidator(IValidator validator) {
		this.unsafeValidator = Objects.requireNonNull(validator, "validator");
	}

	public void setBase(BaseValidator baseValidator) {
		unsafeValidator.setBase(baseValidator);
	}

	public List<Message> validateModelBehavior(List<ModelUnit> units) {
		try {
			return unsafeValidator.validateModelBehavior(units);
		} 
		catch (Exception e) {
			Activator.error("An internal error occurred while validating ModelBehavior: " + units, e);
			return emptyList();
		}
	}

	public List<Message> validateModelUnit(ModelUnit unit) {
		try {
			return unsafeValidator.validateModelUnit(unit);
		} 
		catch (Exception e) {
			Activator.error("An internal error occurred while validating ModelUnit: " + unit, e);
			return emptyList();
		}
	}

	public List<Message> validateExtendedClass(ExtendedClass xtdClass) {
		try {
			return unsafeValidator.validateExtendedClass(xtdClass);
		} 
		catch (Exception e) {
			Activator.error("An internal error occurred while validating ExtendedClass: " + xtdClass, e);
			return emptyList();
		}
	}

	public List<Message> validateRuntimeClass(RuntimeClass classDef) {
		try {
			return unsafeValidator.validateRuntimeClass(classDef);
		} 
		catch (Exception e) {
			Activator.error("An internal error occurred while validating RuntimeClass: " + classDef, e);
			return emptyList();
		}
	}

	public List<Message> validateMethod(Method mtd) {
		try {
			return unsafeValidator.validateMethod(mtd);
		} 
		catch (Exception e) {
			Activator.error("An internal error occurred while validating Method: " + mtd, e);
			return emptyList();
		}
	}

	public List<Message> validateFeatureAssignment(FeatureAssignment featAssign) {
		try {
			return unsafeValidator.validateFeatureAssignment(featAssign);
		}
		catch (Exception e) {
			Activator.error("An internal error occurred while validating FeatureAssignment: " + featAssign, e);
			return emptyList();
		}
	}

	public List<Message> validateFeatureInsert(FeatureInsert featInsert) {
		try { 
			return unsafeValidator.validateFeatureInsert(featInsert);
		}
		catch (Exception e) {
			Activator.error("An internal error occurred while validating FeatureInsert: " + featInsert, e);
			return emptyList();
		}
	}

	public List<Message> validateFeatureRemove(FeatureRemove featRemove) {
		try {
			return unsafeValidator.validateFeatureRemove(featRemove);
		}
		catch (Exception e) {
			Activator.error("An internal error occurred while validating FeatureRemove: " + featRemove, e);
			return emptyList();
		}
	}

	public List<Message> validateVariableAssignment(VariableAssignment varAssign) {
		try {
			return unsafeValidator.validateVariableAssignment(varAssign);
		}
		catch (Exception e) {
			Activator.error("An internal error occurred while validating VariableAssignment: " + varAssign, e);
			return emptyList();
		}
	}

	public List<Message> validateVariableDeclaration(VariableDeclaration varDecl) {
		try {
			return unsafeValidator.validateVariableDeclaration(varDecl);
		}
		catch (Exception e) {
			Activator.error("An internal error occurred while validating VariableDeclaration: " + varDecl, e);
			return emptyList();
		}
	}

	public List<Message> validateVariableInsert(VariableInsert varInsert) {
		try {
			return unsafeValidator.validateVariableInsert(varInsert);
		}
		catch (Exception e) {
			Activator.error("An internal error occurred while validating VariableInsert: " + varInsert, e);
			return emptyList();
		}
	}

	public List<Message> validateVariableRemove(VariableRemove varRemove) {
		try {
			return unsafeValidator.validateVariableRemove(varRemove);
		}
		catch (Exception e) {
			Activator.error("An internal error occurred while validating VariableRemove: " + varRemove, e);
			return emptyList();
		}
	}

	public List<Message> validateForEach(ForEach loop) {
		try {
			return unsafeValidator.validateForEach(loop);
		}
		catch (Exception e) {
			Activator.error("An internal error occurred while validating ForEach: " + loop, e);
			return emptyList();
		}
	}

	public List<Message> validateIf(If ifStmt) {
		try {
			return unsafeValidator.validateIf(ifStmt);
		}
		catch (Exception e) {
			Activator.error("An internal error occurred while validating If: " + ifStmt, e);
			return emptyList();
		}
	}

	public List<Message> validateWhile(While loop) {
		try {
			return unsafeValidator.validateWhile(loop);
		}
		catch (Exception e) {
			Activator.error("An internal error occurred while validating While: " + loop, e);
			return emptyList();
		}
	}
	
}
