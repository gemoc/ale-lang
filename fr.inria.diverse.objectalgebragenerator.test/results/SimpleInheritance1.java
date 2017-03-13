package simple.inheritance1.algebra;

import simple.inheritance1.ChildA;
import simple.inheritance1.ChildB;
import simple.inheritance1.Parent;

public interface SimpleInheritance1Algebra<A> {

	A childA(final ChildA childA);

	A childB(final ChildB childB);

	A parent(final Parent parent);

	public default A $(final Parent parent) {
		final A ret;
		if (parent instanceof ChildA) {
			ret = this.childA((ChildA) parent);
		} else if (parent instanceof ChildB) {
			ret = this.childB((ChildB) parent);
		} else if (parent instanceof Parent) {
			ret = this.parent((Parent) parent);
		} else {
			throw new RuntimeException("Unknow Parent " + parent);
		}
		return ret;
	}
}