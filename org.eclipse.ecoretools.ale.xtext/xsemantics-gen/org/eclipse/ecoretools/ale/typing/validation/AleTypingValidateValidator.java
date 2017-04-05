package org.eclipse.ecoretools.ale.typing.validation;

import com.google.inject.Inject;
import it.xsemantics.runtime.validation.XsemanticsValidatorErrorGenerator;
import org.eclipse.ecoretools.ale.RRoot;
import org.eclipse.ecoretools.ale.typing.AleTypingValidate;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;

@SuppressWarnings("all")
public class AleTypingValidateValidator extends AbstractDeclarativeValidator {
  @Inject
  protected XsemanticsValidatorErrorGenerator errorGenerator;
  
  @Inject
  protected AleTypingValidate xsemanticsSystem;
  
  protected AleTypingValidate getXsemanticsSystem() {
    return this.xsemanticsSystem;
  }
  
  @Check
  public void checkClassNameDuplicate(final RRoot rRoot) {
    errorGenerator.generateErrors(this,
    	getXsemanticsSystem().checkClassNameDuplicate(rRoot),
    		rRoot);
  }
}
