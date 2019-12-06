/*******************************************************************************
 * Copyright (c) 2019 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.parser.internal;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecoretools.ale.core.parser.visitor.ParseResult;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;

/**
 * The semantics of a DSL at some point in time.
 * <p>
 * An instance of this class is not updated as the underlying resource
 * defining the semantics (e.g. a <i>.dsl</i> or a <i>.ale</i> file) changes.
 */
public class ImmutableDslSemantics implements DslSemantics {
	
	private final List<ParseResult<ModelUnit>> raw;

	public ImmutableDslSemantics(List<ParseResult<ModelUnit>> raw) {
		this.raw = new ArrayList<>(raw);
	}

	@Override
	public List<ModelUnit> getBehaviors() {
		return nonNullUnits()
		    	  .collect(toList());
	}

	@Override
	public Set<String> getServices() {
		return nonNullUnits()
		    	  .flatMap(root -> root.getServices().stream())
		    	  .collect(toSet());
	}

	@Override
	public Optional<Method> findMethod(EOperation correspondingOperation) {
		return getBehaviors().stream()
							.flatMap(unit -> unit.getClassExtensions().stream())
							.flatMap(cls -> cls.getMethods().stream())
							.filter(mtd -> mtd.getOperationRef() == correspondingOperation)
							.findAny();
	}
	
	@Override
	public List<Method> getMainMethods() {
		return nonNullUnits()
				  .flatMap(parsedFile -> parsedFile.getClassExtensions().stream())
				  .flatMap(clazz -> clazz.getMethods().stream())
				  .filter(method -> method.getTags().contains("main"))
				  .collect(toList());
	}

	@Override
	public List<ParseResult<ModelUnit>> getParsedFiles() {
		return new ArrayList<>(raw);
	}

	@Override
	public Optional<ParseResult<ModelUnit>> findParsedFileDefining(Object astElement) {
		for (ParseResult<ModelUnit> parsedFile : raw) {
			boolean parsedFileDefinesTheElement = parsedFile.getStartPositions().get(astElement) != null;
			if (parsedFileDefinesTheElement) {
				return Optional.of(parsedFile);
			}
		}
		return Optional.empty();
	}

	private Stream<ModelUnit> nonNullUnits() {
		return raw.stream()
				  .map(ParseResult::getRoot)
				  .filter(Objects::nonNull);
	}

}
