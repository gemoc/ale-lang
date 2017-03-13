package oa.root.algebra;

import oa.root.ChildA;
import oa.root.ChildAA;
import oa.root.ChildB;
import oa.root.ChildBA;
import oa.root.Parent;

public interface OaRootAlgebra<A, B, C> {

	B childAA(final ChildAA childAA);
	
	C childB(final ChildB childB);
	
	C childBA(final ChildBA childBA);
	
	A parent(final Parent parent);

	public default A $(final Parent parent) {
		final A ret;
		if (parent instanceof Parent) {
			ret = this.parent((Parent) parent);
		} else {
			throw new RuntimeException("Unknow Parent " + parent);
		}
		return ret;
	}
	
	public default B $(final ChildA childA) {
		final B ret;
		if (childA instanceof ChildAA) {
			ret = this.childAA((ChildAA) childA);
		} else {
			throw new RuntimeException("Unknow ChildA " + childA);
		}
		return ret;
	}
	
	public default C $(final ChildB childB) {
		final C ret;
		if (childB instanceof ChildBA) {
			ret = this.childBA((ChildBA) childB);
		} else if (childB instanceof ChildB) {
			ret = this.childB((ChildB) childB);
		} else {
			throw new RuntimeException("Unknow ChildB " + childB);
		}
		return ret;
	}
}