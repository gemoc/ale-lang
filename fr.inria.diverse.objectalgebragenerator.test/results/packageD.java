package d.algebra;

import b.A1Class;
import b.algebra.BAlgebra;
import c.A2Class;
import c.algebra.CAlgebra;
import d.A12Class;

public interface DAlgebra<A, B, C> extends BAlgebra<A, B>, CAlgebra<A, C> {

	A a12Class(final A12Class a12Class);

	@Override
	public default A $(final AClass aClass) {
		final A ret;
		if (aClass instanceof A12Class) {
			ret = this.a12Class((A12Class) aClass);
		} else {
			try {
				ret = BAlgebra.super.$(aClass);
			} catch(RuntimeException e) {
				ret = CAlgebra.super.$(aClass);
			}
		}
		return ret;
	}

}