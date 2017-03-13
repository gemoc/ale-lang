package c.algebra;

import a.AClass;
import a.algebra.AAlgebra;
import c.A2Class;
import c.CClass;

public interface CAlgebra<A, B> extends AAlgebra<A> {

	A a2Class(final A2Class a2Class);

	B cClass(final CClass bClass);

	@Override
	public default A $(final AClass aClass) {
		final A ret;
		if (aClass instanceof A1Class) {
			ret = this.a1Class((AClass) aClass);
		} else {
			ret = AAlgebra.super.$(aClass);
		}
		return ret;
	}
}