package org.eclipse.emf.ecoretools.ale.ide.debug;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IValue;
import org.eclipse.debug.core.model.IVariable;

public class AleVariable implements IVariable {
	
	String name;
	AleStackFrame frame;
	Object realObject;

	public AleVariable(String name, Object realObject, AleStackFrame frame) {
		this.name = name;
		this.realObject = realObject;
		this.frame = frame;
	}

	@Override
	public String getModelIdentifier() {
		return frame.getModelIdentifier();
	}

	@Override
	public IDebugTarget getDebugTarget() {
		return frame.getDebugTarget();
	}

	@Override
	public ILaunch getLaunch() {
		return frame.getLaunch();
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setValue(String expression) throws DebugException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValue(IValue value) throws DebugException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsValueModification() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyValue(String expression) throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyValue(IValue value) throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IValue getValue() throws DebugException {
		// TODO Auto-generated method stub
		return new AleValue(realObject,this);
	}

	@Override
	public String getName() throws DebugException {
		return name;
	}

	@Override
	public String getReferenceTypeName() throws DebugException {
		// TODO Auto-generated method stub
		return "barref";
	}

	@Override
	public boolean hasValueChanged() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}
	
	public AleStackFrame getFrame() {
		return frame;
	}

}
