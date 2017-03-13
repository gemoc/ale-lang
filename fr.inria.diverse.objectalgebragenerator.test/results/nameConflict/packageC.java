package b.algebra;

import a.algebra.AAlgebra;
import b.algebra.BAlgebra;
import c.AAClass;

public interface BAlgebra<A> extends AAlgebra<A>, BAlgebra<A> {

	A aaClass(final AAClass aAClass);

	@Override
	public default A $(final AClass aClass) {
		final A ret;
		if (aClass instanceof AAClass) {
			ret = this.aAClass((AAClass) aClass);
		} else {
			try {
				ret = AAlgebra.super.$(aClass);
			} catch(RuntimeException e) {
				ret = BAlgebra.super.$(aClass);
			}
		}
		return ret;
	}
}