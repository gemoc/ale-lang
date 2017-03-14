/*
 * generated by Xtext 2.10.0
 */
package org.xtext.example.mydsl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.example.mydsl.myDsl.MyDslPackage;
import org.xtext.example.mydsl.myDsl.rAttribute;
import org.xtext.example.mydsl.myDsl.rNewClass;
import org.xtext.example.mydsl.myDsl.rOpenClass;
import org.xtext.example.mydsl.myDsl.rOperation;
import org.xtext.example.mydsl.myDsl.rParameters;
import org.xtext.example.mydsl.myDsl.rRoot;
import org.xtext.example.mydsl.myDsl.rVariable;
import org.xtext.example.mydsl.services.MyDslGrammarAccess;

@SuppressWarnings("all")
public class MyDslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MyDslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MyDslPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MyDslPackage.RATTRIBUTE:
				sequence_rAttribute(context, (rAttribute) semanticObject); 
				return; 
			case MyDslPackage.RNEW_CLASS:
				sequence_rNewClass(context, (rNewClass) semanticObject); 
				return; 
			case MyDslPackage.ROPEN_CLASS:
				sequence_rOpenClass(context, (rOpenClass) semanticObject); 
				return; 
			case MyDslPackage.ROPERATION:
				sequence_rOperation(context, (rOperation) semanticObject); 
				return; 
			case MyDslPackage.RPARAMETERS:
				sequence_rParameters(context, (rParameters) semanticObject); 
				return; 
			case MyDslPackage.RROOT:
				sequence_rRoot(context, (rRoot) semanticObject); 
				return; 
			case MyDslPackage.RVARIABLE:
				sequence_rVariable(context, (rVariable) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     rAttribute returns rAttribute
	 *
	 * Constraint:
	 *     (type=Ident name=Ident)
	 */
	protected void sequence_rAttribute(ISerializationContext context, rAttribute semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.RATTRIBUTE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.RATTRIBUTE__TYPE));
			if (transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.RATTRIBUTE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.RATTRIBUTE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRAttributeAccess().getTypeIdentTerminalRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getRAttributeAccess().getNameIdentTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     rClass returns rNewClass
	 *     rNewClass returns rNewClass
	 *
	 * Constraint:
	 *     (name=Ident attributes+=rAttribute* operations+=rOperation*)
	 */
	protected void sequence_rNewClass(ISerializationContext context, rNewClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     rClass returns rOpenClass
	 *     rOpenClass returns rOpenClass
	 *
	 * Constraint:
	 *     (name=Ident attributes+=rAttribute* operations+=rOperation*)
	 */
	protected void sequence_rOpenClass(ISerializationContext context, rOpenClass semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     rOperation returns rOperation
	 *
	 * Constraint:
	 *     (type=Ident name=Ident paramList+=rParameters? body=rBlock)
	 */
	protected void sequence_rOperation(ISerializationContext context, rOperation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     rParameters returns rParameters
	 *
	 * Constraint:
	 *     (params+=rVariable params+=rVariable*)
	 */
	protected void sequence_rParameters(ISerializationContext context, rParameters semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     rRoot returns rRoot
	 *
	 * Constraint:
	 *     xtendedClasses+=rClass+
	 */
	protected void sequence_rRoot(ISerializationContext context, rRoot semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     rVariable returns rVariable
	 *
	 * Constraint:
	 *     (type=Ident name=Ident)
	 */
	protected void sequence_rVariable(ISerializationContext context, rVariable semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.RVARIABLE__TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.RVARIABLE__TYPE));
			if (transientValues.isValueTransient(semanticObject, MyDslPackage.Literals.RVARIABLE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MyDslPackage.Literals.RVARIABLE__NAME));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRVariableAccess().getTypeIdentTerminalRuleCall_0_0(), semanticObject.getType());
		feeder.accept(grammarAccess.getRVariableAccess().getNameIdentTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
}