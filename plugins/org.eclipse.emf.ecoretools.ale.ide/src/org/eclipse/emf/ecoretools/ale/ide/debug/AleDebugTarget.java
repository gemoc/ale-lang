package org.eclipse.emf.ecoretools.ale.ide.debug;

import java.net.URI;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IMarkerDelta;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.DebugEvent;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IMemoryBlock;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.core.model.IThread;
import org.eclipse.emf.ecoretools.ale.ALEInterpreter;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.ide.Activator;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

public class AleDebugTarget implements IDebugTarget {

	AleThread thread;
	ILaunch launch;
	Job evalJob;
	
	public AleDebugTarget(ILaunch launch, Job evalJob, List<ParseResult<ModelUnit>> parsedSemantics, ALEInterpreter interpreter) {
		this.thread = new AleThread(interpreter, this,parsedSemantics);
		this.launch = launch;
		this.evalJob = evalJob;
		
		DebugPlugin.getDefault().getBreakpointManager().addBreakpointListener(this);
		IBreakpoint[] existingBreakpoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints(getModelIdentifier());
		for (int i = 0; i < existingBreakpoints.length; i++) {
			breakpointAdded(existingBreakpoints[i]);
		}
	}
	
	@Override
	public String getModelIdentifier() {
		return Activator.PLUGIN_ID;
	}

	@Override
	public IDebugTarget getDebugTarget() {
		return this;
	}

	@Override
	public ILaunch getLaunch() {
		return launch;
	}

	@Override
	public <T> T getAdapter(Class<T> adapter) {
		return null;
	}

	@Override
	public boolean canTerminate() {
		return !isTerminated();
	}

	@Override
	public boolean isTerminated() {
		return thread == null;
	}

	@Override
	public void terminate() throws DebugException {
		evalJob.cancel();
		DebugPlugin.getDefault().getBreakpointManager().removeBreakpointListener(this);
		DebugPlugin.getDefault().fireDebugEventSet(new DebugEvent[] {new DebugEvent(this, DebugEvent.TERMINATE)});
		thread = null;
	}

	@Override
	public boolean canResume() {
		return thread != null && thread.canResume();
	}

	@Override
	public boolean canSuspend() {
		return thread != null && thread.canSuspend();
	}

	@Override
	public boolean isSuspended() {
		return thread != null && thread.isSuspended();
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
	public void breakpointAdded(IBreakpoint breakpoint) {
		try {
			int line = (int) breakpoint.getMarker().getAttribute(IMarker.LINE_NUMBER);
			String file = breakpoint.getMarker().getResource().getLocation().toString();
			thread.addBreakpoint(line, file);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void breakpointRemoved(IBreakpoint breakpoint, IMarkerDelta delta) {
		try {
			int line = (int) breakpoint.getMarker().getAttribute(IMarker.LINE_NUMBER);
			String file = breakpoint.getMarker().getResource().getLocation().toString();
			thread.removeBreakpoint(line, file);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void breakpointChanged(IBreakpoint breakpoint, IMarkerDelta delta) {
	}
	
	@Override
	public boolean supportsBreakpoint(IBreakpoint breakpoint) {
		return breakpoint.getModelIdentifier().equals(getModelIdentifier());
	}

	@Override
	public boolean canDisconnect() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void disconnect() throws DebugException {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isDisconnected() {
		return isTerminated();
	}

	@Override
	public boolean supportsStorageRetrieval() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IMemoryBlock getMemoryBlock(long startAddress, long length) throws DebugException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IProcess getProcess() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IThread[] getThreads() throws DebugException {
		if (isTerminated()) {
            return new IThread[0];
        }
        return new IThread[]{thread};
	}

	@Override
	public boolean hasThreads() throws DebugException {
		return true;
	}

	@Override
	public String getName() throws DebugException {
		return "ALE Debug Target";
	}

	public AleDebugger getDebugger() {
		return thread.getDebugger();
	}

}
