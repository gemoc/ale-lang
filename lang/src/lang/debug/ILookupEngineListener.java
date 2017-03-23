package lang.debug;

import org.eclipse.acceleo.query.runtime.IService;
import org.eclipse.acceleo.query.validation.type.IType;

public interface ILookupEngineListener {

	/**
	 * Called at the start of ILookupEngine.lookup(String,IType[])
	 */
	public void preLookup(String name, IType[] argumentTypes);
	
	/**
	 * Called at the end of ILookupEngine.lookup(String,IType[])
	 */
	public void postLookup(IService foundService);
	
}
