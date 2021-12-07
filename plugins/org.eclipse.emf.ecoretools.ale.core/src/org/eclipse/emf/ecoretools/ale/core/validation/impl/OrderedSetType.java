package org.eclipse.emf.ecoretools.ale.core.validation.impl;

import java.util.LinkedHashSet;

import org.eclipse.acceleo.query.runtime.IReadOnlyQueryEnvironment;
import org.eclipse.acceleo.query.validation.type.AbstractCollectionType;
import org.eclipse.acceleo.query.validation.type.IType;

public class OrderedSetType extends AbstractCollectionType {

	public OrderedSetType(IReadOnlyQueryEnvironment queryEnvironment, IType type) {
		super(queryEnvironment, type);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Class<?> getType() {
		return LinkedHashSet.class;
	}

	@Override
	public boolean isAssignableFrom(IType otherType) {
		// TODO Auto-generated method stub
		return super.isAssignableFrom(otherType);
	}

	@Override
	public String toString() {
		return "OrderedSet(" + getCollectionType().toString() + ")";
	}
	
}
