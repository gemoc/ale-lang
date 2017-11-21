package org.eclipse.emf.ecoretools.ale.ide.debug;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IStackFrame;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.Block;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.Statement;

public class AleThread implements IThread {

	public enum State {
		RUNNING, STEPPING_INTO, STEPPING_OVER, STEPPING_RETURN, SUSPENDED, TERMINATED
	}

	State currentState;
	Thread thread;
	AleDebugTarget debugTarget;
	AleDebugger debugger;
	
	Stack<IStackFrame> callStack;
	List<ParseResult<ModelUnit>> parsedSemantics;

	public AleThread(ALEInterpreter interpreter, AleDebugTarget debugTarget, List<ParseResult<ModelUnit>> parsedSemantics) {
		this.debugTarget = debugTarget;
		this.debugger = new AleDebugger(interpreter, this);
		this.currentState = State.SUSPENDED;
		this.callStack = new Stack<IStackFrame>();
		this.parsedSemantics = parsedSemantics;
	}

	@Override
	public String getModelIdentifier() {
		return debugTarget.getModelIdentifier();
	}

	@Override
	public IDebugTarget getDebugTarget() {
		return debugTarget;
	}

	@Override
	public ILaunch getLaunch() {
		return debugTarget.getLaunch();
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canResume() {
		return isSuspended();
	}

	@Override
	public boolean canSuspend() {
		return isStepping() || State.RUNNING.equals(currentState);
	}

	@Override
	public boolean isSuspended() {
		return State.SUSPENDED.equals(currentState);
	}

	@Override
	public void resume() throws DebugException {
		currentState = State.RUNNING;
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {new DebugEvent(this, DebugEvent.RESUME)});
		debugger.wakeUp();
	}

	@Override
	public void suspend() throws DebugException {
		currentState = State.SUSPENDED;
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {new DebugEvent(this, DebugEvent.SUSPEND)});
		// System.out.println("Suspend");
	}

	@Override
	public boolean canStepInto() {
		return isSuspended();
	}

	@Override
	public boolean canStepOver() {
		return isSuspended();
	}

	@Override
	public boolean canStepReturn() {
		return isSuspended();
	}

	@Override
	public boolean isStepping() {
		return State.STEPPING_INTO.equals(currentState) 
				|| State.STEPPING_OVER.equals(currentState)
				|| State.STEPPING_RETURN.equals(currentState);
	}

	@Override
	public void stepInto() throws DebugException {
		currentState = State.STEPPING_INTO;
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {new DebugEvent(this, DebugEvent.STEP_INTO)});
		debugger.stepInto();
		// System.out.println("Step into");
	}

	@Override
	public void stepOver() throws DebugException {
		currentState = State.STEPPING_OVER;
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {new DebugEvent(this, DebugEvent.STEP_OVER)});
		debugger.stepOver();
		// System.out.println("Step over");
	}

	@Override
	public void stepReturn() throws DebugException {
		currentState = State.STEPPING_RETURN;
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {new DebugEvent(this, DebugEvent.STEP_RETURN)});
		debugger.stepReturn();
		// System.out.println("Step return");
	}

	@Override
	public boolean canTerminate() {
		return true;
	}

	@Override
	public boolean isTerminated() {
		return State.TERMINATED.equals(currentState);
	}

	@Override
	public void terminate() throws DebugException {
		currentState = State.TERMINATED;
		debugTarget.terminate();
	}

	@Override
	public IStackFrame[] getStackFrames() throws DebugException {
		return callStack.toArray(new IStackFrame[callStack.size()]);
	}

	@Override
	public boolean hasStackFrames() throws DebugException {
		return !callStack.isEmpty();
	}

	@Override
	public int getPriority() throws DebugException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IStackFrame getTopStackFrame() throws DebugException {
		if(!callStack.isEmpty()) {
			return callStack.peek();
		}
		return null;
	}

	@Override
	public String getName() throws DebugException {
		return "Main Thread";
	}

	@Override
	public IBreakpoint[] getBreakpoints() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRunning() {
		currentState = State.RUNNING;
	}

	public AleDebugger getDebugger() {
		return debugger;
	}
	
	public State getCurrentState() {
		return currentState;
	}
	
	public void pushStackFrameFor(Method calledOp, EObject caller) {
		Resource res = calledOp.eResource();
		callStack.push(new AleStackFrame(calledOp, caller, this));
	}
	
	public void popStackFrame() {
		if(!callStack.isEmpty()) {
			callStack.pop();
		}
	}
	
	public String findSourceFor(Method calledOp) {
		BehavioredClass clazz = (BehavioredClass) calledOp.eContainer();
		ModelUnit modelUnit = (ModelUnit) clazz.eContainer();
		for (ParseResult<ModelUnit> parseResult : parsedSemantics) {
			if(parseResult.getRoot() == modelUnit) {
				return parseResult.getSourceFile();
			}
		}
		return null;
	}
	
	public int getCurrentLine() {
		Statement currentStmt = debugger.getCurrentStatement();
		if (currentStmt != null) {
			EObject parent = currentStmt.eContainer();
			while (parent != null && !(parent instanceof ModelUnit)) {
				parent = parent.eContainer();
			}
			if (parent != null) {
				ModelUnit modelUnit = (ModelUnit) parent;
				for (ParseResult<ModelUnit> parseResult : parsedSemantics) {
					if (parseResult.getRoot() == modelUnit) {
						Integer pos = parseResult.getStartPositions().get(currentStmt);
						if (pos != null) {
							return getLine(pos, parseResult.getSourceFile());
						}
					}
				}

			}
		}
		return -1;
	}
	
	private int getLine(int offset, String file) {
		try (LineNumberReader r = new LineNumberReader(new FileReader(file))) {
			r.setLineNumber(1); //first line is number 0 by default
		    int count = 0;
		    while (r.read() != -1 && count < offset) {
		        count++;
		    }
		    if (count == offset) {
		        return r.getLineNumber();
		    } else {
		        System.out.println("File is not long enough");
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public void addBreakpoint(int line, String file) {
		for (ParseResult<ModelUnit> parseResult : parsedSemantics) {
			if(parseResult.getSourceFile().equals(file)) {
				Statement stmt = getStatementAt(line,parseResult);
				if(stmt != null) {
					debugger.addBreakpoint(stmt);
				}
				break;
			}
		}
	}
	
	public void removeBreakpoint(int line, String file) {
		for (ParseResult<ModelUnit> parseResult : parsedSemantics) {
			if(parseResult.getSourceFile().equals(file)) {
				Statement stmt = getStatementAt(line,parseResult);
				if(stmt != null) {
					debugger.addBreakpoint(stmt);
				}
				break;
			}
		}
	}
	
	public Statement getStatementAt(int line, ParseResult<ModelUnit> unit) {
		List<BehavioredClass> allCls = new ArrayList<BehavioredClass>();
		allCls.addAll(unit.getRoot().getClassExtensions());
		allCls.addAll(unit.getRoot().getClassDefinitions());

		for (BehavioredClass behavioredClass : allCls) {
			for (Method method : behavioredClass.getMethods()) {
				Block body = method.getBody();

				int startLine = getStartLine(body, unit);
				int stopLine = getStopLine(body, unit);
				if (startLine <= line && line <= stopLine) {
					return getStatementAt(line, body, unit);
				}
			}
		}
		return null;
	}
	
	private Statement getStatementAt(int line, Block context, ParseResult<ModelUnit> unit) {
		List<Statement> content = new ArrayList<Statement>();
		context.eAllContents().forEachRemaining(elem -> {
			if(elem instanceof Statement) {
				content.add((Statement) elem);
			}
		});
		
		int bestStartLine = getStartLine(context, unit);
		int bestStopLine = getStopLine(context, unit);
		Statement candidate = null;
		
		for(Statement stmt : content) {
			int startLine = getStartLine(stmt, unit);
			int stopLine = getStopLine(stmt, unit);
			if (startLine <= line && line <= stopLine
				&& bestStartLine <= startLine && stopLine <= bestStopLine) {
				candidate = stmt;
				bestStartLine = startLine;
				bestStopLine = stopLine;
			}
		}
		
		return candidate;
	}
	
	private int getStartLine(Object elem, ParseResult<ModelUnit> unit) {
		Integer startOffset = unit.getStartPositions().get(elem);
		if(startOffset != null) {
			return getLine(startOffset, unit.getSourceFile());
		}
		return -1;
	}
	
	private int getStopLine(Object elem, ParseResult<ModelUnit> unit) {
		Integer stopOffset = unit.getEndPositions().get(elem);
		if(stopOffset != null) {
			return getLine(stopOffset, unit.getSourceFile());
		}
		return -1;
	}

}
