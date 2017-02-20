package lang.core.interpreter.services;

/**
 * AQL service to print objects on the output
 */
public class LogService {
	
	public static void log(Object o) {
		if(o != null)
			System.out.println(o.toString());
		else
			System.out.println(o);
	}
}