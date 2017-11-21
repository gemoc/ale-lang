package org.eclipse.emf.ecoretools.ale.ide.debug;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.google.common.collect.Lists;

public class AleValue implements IValue {

	AleVariable variable;
	Object realObject;
	Map<EStructuralFeature, Object> featureValues;

	public AleValue(Object realObject, AleVariable variable) {
		this.variable = variable;
		this.realObject = realObject;
		
		if(realObject instanceof EObject) {
			EObject obj = (EObject) realObject;
			AleDebugger debugger = ((AleThread) variable.getFrame().getThread()).getDebugger();
			featureValues = debugger.getAllFeatureValues(obj);
		}
	}
	
	@Override
	public String getModelIdentifier() {
		return variable.getModelIdentifier();
	}

	@Override
	public IDebugTarget getDebugTarget() {
		return variable.getDebugTarget();
	}

	@Override
	public ILaunch getLaunch() {
		return variable.getLaunch();
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getReferenceTypeName() throws DebugException {
		return null;
	}

	@Override
	public String getValueString() throws DebugException {
		if(realObject == null) {
			return "null";
		}
		else if(realObject instanceof EObject) {
			return ((EObject)realObject).eClass().getName() + " (id=" + realObject.hashCode() +")";
		}
		else if(realObject instanceof String 
				|| realObject instanceof Integer
				|| realObject instanceof Long
				|| realObject instanceof Double
				|| realObject instanceof Float
				|| realObject instanceof Boolean) {
			return realObject.toString();
		}
		else {
			return realObject.getClass().getName();
		}
	}

	@Override
	public boolean isAllocated() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		if(featureValues != null) {
			ArrayList<IVariable> variables = new ArrayList<>();
			for(Entry<EStructuralFeature, Object> entry : featureValues.entrySet()) {
				String featureName = entry.getKey().getName();
				Object value = entry.getValue();
				variables.add(new AleVariable(featureName,value,variable.frame));
			}
			return Lists.reverse(variables).toArray(new IVariable[variables.size()]);
		}
		return new IVariable[0];
	}

	@Override
	public boolean hasVariables() throws DebugException {
		return featureValues != null && !featureValues.entrySet().isEmpty();
	}

}
