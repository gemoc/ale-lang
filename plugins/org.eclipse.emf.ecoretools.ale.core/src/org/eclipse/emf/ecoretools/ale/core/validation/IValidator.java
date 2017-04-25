package org.eclipse.emf.ecoretools.ale.core.validation;

import java.util.List;

import org.eclipse.acceleo.query.runtime.IValidationMessage;
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

public interface IValidator {
	
	public void setBase(BaseValidator baseValidator);
	
	public List<IValidationMessage> validateModelBehavior(List<ModelUnit> units);
	public List<IValidationMessage> validateModelUnit(ModelUnit unit);
	public List<IValidationMessage> validateExtendedClass(ExtendedClass xtdClass);
	public List<IValidationMessage> validateRuntimeClass(RuntimeClass classDef);
	public List<IValidationMessage> validateMethod(Method mtd);
	
	public List<IValidationMessage> validateFeatureAssignment(FeatureAssignment featAssign);
	public List<IValidationMessage> validateFeatureInsert(FeatureInsert featInsert);
	public List<IValidationMessage> validateFeatureRemove(FeatureRemove featRemove);
	public List<IValidationMessage> validateVariableAssignment(VariableAssignment varAssign);
	public List<IValidationMessage> validateVariableDeclaration(VariableDeclaration varDecl);
	public List<IValidationMessage> validateForEach(ForEach loop);
	public List<IValidationMessage> validateIf(If ifStmt);
	public List<IValidationMessage> validateWhile(While loop);
	
}
