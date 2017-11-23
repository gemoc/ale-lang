package org.eclipse.emf.ecoretools.ale.ide.debug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IRegisterGroup;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.debug.core.model.IVariable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecoretools.ale.implementation.Method;

public class AleStackFrame implements IStackFrame {
	
	AleThread thread;
	Method calledOp;
	EObject caller;
	Map<String,Object> variables;
	
	public AleStackFrame(Method calledOp, EObject caller, AleThread thread) {
		this.thread =  thread;
		this.calledOp = calledOp;
		this.caller = caller;
		this.variables = new HashMap<>();
	}

	@Override
	public String getModelIdentifier() {
		return thread.getModelIdentifier();
	}

	@Override
	public IDebugTarget getDebugTarget() {
		return thread.getDebugTarget();
	}

	@Override
	public ILaunch getLaunch() {
		return thread.getLaunch();
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canStepInto() {
		return thread.canStepInto();
	}

	@Override
	public boolean canStepOver() {
		return thread.canStepOver();
	}

	@Override
	public boolean canStepReturn() {
		return thread.canStepReturn();
	}

	@Override
	public boolean isStepping() {
		return thread.isStepping();
	}

	@Override
	public void stepInto() throws DebugException {
		thread.stepInto();
	}

	@Override
	public void stepOver() throws DebugException {
		thread.stepOver();
	}

	@Override
	public void stepReturn() throws DebugException {
		thread.stepReturn();
	}

	@Override
	public boolean canResume() {
		return thread.canResume();
	}

	@Override
	public boolean canSuspend() {
		return thread.canSuspend();
	}

	@Override
	public boolean isSuspended() {
		return thread.isSuspended();
	}

	@Override
	public void resume() throws DebugException {
		thread.resume();
	}

	@Override
	public void suspend() throws DebugException {
		thread.suspend();
	}

	@Override
	public boolean canTerminate() {
		return thread.canTerminate();
	}

	@Override
	public boolean isTerminated() {
		return thread.isTerminated();
	}

	@Override
	public void terminate() throws DebugException {
		thread.terminate();
	}

	@Override
	public IThread getThread() {
		return thread;
	}

	@Override
	public IVariable[] getVariables() throws DebugException {
		ArrayList<IVariable> res = new ArrayList<>();
		for(Entry<String, Object> entry : variables.entrySet()) {
			res.add(new AleVariable(entry.getKey(), entry.getValue(), this));
		}
		return res.toArray(new IVariable[res.size()]);
	}

	@Override
	public boolean hasVariables() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getLineNumber() throws DebugException {
		return thread.getCurrentLine();
	}

	@Override
	public int getCharStart() throws DebugException {
		return -1;
	}

	@Override
	public int getCharEnd() throws DebugException {
		return -1;
	}

	@Override
	public String getName() throws DebugException {
		return calledOp.getOperationRef().getName();
	}

	@Override
	public IRegisterGroup[] getRegisterGroups() throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasRegisterGroups() throws DebugException {
		// TODO Auto-generated method stub
		return false;
	}

	public String getSourceFile() {
		return thread.findSourceFor(calledOp);
	}
	
	public void updateVariables(Map<String, Object> variables) {
		this.variables = variables;
	}
}
