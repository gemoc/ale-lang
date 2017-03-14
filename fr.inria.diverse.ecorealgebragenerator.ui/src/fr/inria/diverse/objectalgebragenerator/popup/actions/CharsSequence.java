package fr.inria.diverse.objectalgebragenerator.popup.actions;

import org.eclipse.xtext.xbase.lib.Functions.Function1;

public class CharsSequence implements Function1<Object, String> {

	private final int aord = 'A';
	private final int zord = 'Z';
	private final int range = zord - aord + 1;
	private int cptr = 0;

	@Override
	public String apply(Object p) {

		final String ret = generateString(cptr);
		cptr++;
		return ret;
	}

	public String generateString(final int n) {
		final String ret;
		if (aord + n <= zord) {
			ret = nToStr(n);
		} else {
			int mod = n % range ;
			int rest = (n / range) - 1;
			// System.out.println("range = " + range);
			// System.out.println("n = " + n);
			// System.out.println("mod = " + mod);
			// System.out.println("rest = " + rest);
			ret = generateString(rest) + nToStr(mod);
		}
		return ret;
	}

	private String nToStr(int n) {
		final String ret;
		char c = (char) (aord + n);
		ret = String.valueOf(c);
		return ret;
	}

}
