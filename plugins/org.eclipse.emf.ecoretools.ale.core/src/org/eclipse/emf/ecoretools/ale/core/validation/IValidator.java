/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse default License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.validation;

import java.util.Collections;
import java.util.List;

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

public interface IValidator {
	
	void setBase(BaseValidator baseValidator);
	
	default List<Message> validateModelBehavior(List<ModelUnit> units) {
		return Collections.emptyList();
	}
	
	default List<Message> validateModelUnit(ModelUnit unit) {
		return Collections.emptyList();
	}
	
	default List<Message> validateExtendedClass(ExtendedClass xtdClass) {
		return Collections.emptyList();
	}
	
	default List<Message> validateRuntimeClass(RuntimeClass classDef) {
		return Collections.emptyList();
	}
	
	default List<Message> validateMethod(Method mtd) {
		return Collections.emptyList();
	}
	
	default List<Message> validateFeatureAssignment(FeatureAssignment featAssign) {
		return Collections.emptyList();
	}
	
	default List<Message> validateFeatureInsert(FeatureInsert featInsert) {
		return Collections.emptyList();
	}
	
	default List<Message> validateFeatureRemove(FeatureRemove featRemove) {
		return Collections.emptyList();
	}
	
	default List<Message> validateVariableAssignment(VariableAssignment varAssign) {
		return Collections.emptyList();
	}
	
	default List<Message> validateVariableDeclaration(VariableDeclaration varDecl) {
		return Collections.emptyList();
	}
	
	default List<Message> validateVariableInsert(VariableInsert varInsert) {
		return Collections.emptyList();
	}
	
	default List<Message> validateVariableRemove(VariableRemove varRemove) {
		return Collections.emptyList();
	}
	
	default List<Message> validateForEach(ForEach loop) {
		return Collections.emptyList();
	}
	
	default List<Message> validateIf(If ifStmt) {
		return Collections.emptyList();
	}
	
	default List<Message> validateWhile(While loop) {
		return Collections.emptyList();
	}
	
}
