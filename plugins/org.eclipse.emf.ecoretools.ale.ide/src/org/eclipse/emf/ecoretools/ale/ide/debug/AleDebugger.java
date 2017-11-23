package org.eclipse.emf.ecoretools.ale.ide.debug;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.interpreter.ALEEngine;
import org.eclipse.emf.ecoretools.ale.core.interpreter.DynamicFeatureRegistry;
import org.eclipse.emf.ecoretools.ale.core.interpreter.StatementListener;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.EvalBodyService;
import org.eclipse.emf.ecoretools.ale.core.interpreter.services.ServiceCallListener;
import org.eclipse.emf.ecoretools.ale.ide.debug.AleThread.State;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;
import org.eclipse.xtext.util.Arrays;

public class AleDebugger implements ServiceCallListener, StatementListener {

	AleThread thread;
	ALEInterpreter interpreter;
	
	boolean isReadyToUse = false;
	boolean isSteppingOver = false;

	IStackFrame currentFrame = null;
	IStackFrame stepReturnOrigin = null;
	Stack<Map<String, Object>> currentStack = null;
	Stack<Map<String, Object>> stepOverOrigin = null;
	Statement currentStatement = null;
	
	List<Statement> breakpoints;
	
	public AleDebugger(ALEInterpreter interpreter, AleThread thread) {
		this.thread = thread;
		this.interpreter = interpreter;
		this.breakpoints = new ArrayList<>();
	}
	
	public void notifyStart() {
		thread.setRunning();
	}
	
	public void notifyStop() {
		try {
			thread.terminate();
		} catch (DebugException e) {
			e.printStackTrace();
		}
	}
	
	public void notifyRun() {
		thread.setRunning();
	}
	
	public void notifySuspendOn(Statement stmt) {
		try {
			this.currentStatement = stmt;
			thread.suspend();
			sleep();
		} catch (DebugException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized void sleep() {
		while (!isReadyToUse) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isReadyToUse = false;
	}
	
	public synchronized void wakeUp() {
		isReadyToUse = true;
		notify();
	}
	
	public synchronized void stepOver() {
		stepOverOrigin = currentStack;
		wakeUp();
	}
	
	public synchronized void stepReturn() {
		stepReturnOrigin = currentFrame;
		wakeUp();
	}
	
	public synchronized void stepInto() {
		wakeUp();
	}
	
	public Statement getCurrentStatement() {
		return currentStatement;
	}

	@Override
	public void preCall(IService service, Object[] arguments) {
		if(service instanceof EvalBodyService && arguments.length > 0 && arguments[0] instanceof EObject) {
			Method calledOp = ((EvalBodyService) service).getImplem();
			thread.pushStackFrameFor(calledOp, (EObject)arguments[0]);
			try {
				currentFrame = thread.getTopStackFrame();
			} catch (DebugException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void postCall(IService service, Object[] arguments, Object result) {
		if(service instanceof EvalBodyService) {
			thread.popStackFrame();
		}
	}

	@Override
	public void preExec(Statement stmt, Stack<Map<String, Object>> variablesStack) {
		
		currentStack = variablesStack;
		thread.updateCurrentFrame(getCurrentScope());
		
		if(isBreakpoint(stmt)) {
			notifySuspendOn(stmt);
		}
		else if(State.SUSPENDED.equals(thread.getCurrentState())) {
			if(!(stmt instanceof Block)) {
				notifySuspendOn(stmt);
			}
		}
		else if(State.STEPPING_INTO.equals(thread.getCurrentState())) {
			if(!(stmt instanceof Block)) {
				notifySuspendOn(stmt);
			}
		}
		else if(State.STEPPING_OVER.equals(thread.getCurrentState()) && currentStack == stepOverOrigin) {
			if(!(stmt instanceof Block)) {
				stepOverOrigin = null;
				notifySuspendOn(stmt);
			}
		}
		else if(State.STEPPING_RETURN.equals(thread.getCurrentState())) {
			try {
				if(!Arrays.contains(thread.getStackFrames(), stepReturnOrigin)) {
					stepReturnOrigin = null;
					notifySuspendOn(stmt);
				}
			} catch (DebugException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void postExec(Statement stmt, Stack<Map<String, Object>> variablesStack) {
	}
	
	
	/**
	 * Return all features and their values (including dynamic ones)
	 */
	public Map<EStructuralFeature,Object> getAllFeatureValues(EObject obj) {
		
		Map<EStructuralFeature,Object> res = new HashMap<EStructuralFeature,Object>();
		
		/*
		 * Abstract syntax's features
		 */
		for (EStructuralFeature feature : obj.eClass().getEAllStructuralFeatures()) {
			Object value = obj.eGet(feature);
			res.put(feature,value);
		}
		
		/*
		 * Dynamic features 
		 */
		ALEEngine aleEngine = interpreter.getCurrentEngine();
		if(aleEngine != null) {
			DynamicFeatureRegistry featureAccess = aleEngine.getEvalEnvironment().getFeatureAccess();
			Map<EClass,EClass> baseToRuntime = featureAccess.getBaseToRuntime();
			EClass runtimeFragment = baseToRuntime.get(obj.eClass());
			if(runtimeFragment != null) {
				for (EStructuralFeature feature : runtimeFragment.getEStructuralFeatures()) {
					Object value = featureAccess.aqlFeatureAccess(obj, feature.getName());
					res.put(feature,value);
				}
			}
		}
		
		return res;
	}
	
	/*
	 * Flatten stack
	 */
	public Map<String,Object> getCurrentScope() {
		Map<String,Object> scope = new HashMap<String,Object>();
		currentStack
		.stream()
		.flatMap(scp -> scp.entrySet().stream())
		.forEachOrdered(entry -> scope.put(entry.getKey(), entry.getValue()));
		
		return scope;
	}
	
	public void addBreakpoint(Statement stmt) {
		breakpoints.add(stmt);
	}
	
	public void removeBreakpoint(Statement stmt) {
		breakpoints.remove(stmt);
	}
	
	public boolean isBreakpoint(Statement stmt) {
		return breakpoints.contains(stmt);
	}
}
