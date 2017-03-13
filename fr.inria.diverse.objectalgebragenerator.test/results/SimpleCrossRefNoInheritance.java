package simplecrossref.noinheritance.algebra;

import simplecrossref.noinheritance.BClass;

public interface SimplecrossrefNoinheritanceAlgebra<A, B> extends OneClassAlgebra<A> {

	B bClass(final BClass bClass);

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