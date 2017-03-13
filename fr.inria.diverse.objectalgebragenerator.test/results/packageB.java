package b.algebra;

import a.AClass;
import a.algebra.AAlgebra;
import b.A1Class;
import b.BClass;

public interface BAlgebra<A, B> extends AAlgebra<A> {

	A a1Class(final A1Class a1Class);

	B bClass(final BClass bClass);

	@Override
	public default A $(final AClass aClass) {
		final A ret;
		if (aClass instanceof A1Class) {
			ret = this.a1Class((A1Class) aClass);
		} else {
			ret = AAlgebra.super.$(aClass);
		}
		return ret;
	}

	public default B $(final BClass bClass) {
		final B ret;
		if (bClass instanceof BClass) {
			ret = this.bClass((BClass) bClass);
		} else {
			throw new RuntimeException("Unknow BClass " + bClass);
		}
		return ret;
	}
}