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
package org.eclipse.emf.ecoretools.ale.core.env.impl;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecoretools.ale.core.env.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.env.IBehaviors;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.implementation.BehavioredClass;
import org.eclipse.emf.ecoretools.ale.implementation.ExtendedClass;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;

/**
 * The behaviors defined in an {@link IAleEnvironment} at some point in time.
 * <p>
 * An instance of this class is not updated as the underlying resource
 * defining the semantics (e.g. a <i>.dsl</i> or a <i>.ale</i> file) changes.
 */
public class ImmutableBehaviors implements IBehaviors {
	
	private final List<ParsedFile<ModelUnit>> raw;

	public ImmutableBehaviors(Collection<ParsedFile<ModelUnit>> raw) {
		this.raw = new ArrayList<>(raw);
	}

	@Override
	public List<ModelUnit> getUnits() {
		return nonNullUnits()
		    	  .collect(toList());
	}

	@Override
	public List<BehavioredClass> getClasses() {
		return nonNullUnits()
				  .flatMap(unit -> classesIn(unit))
				  .collect(toList());
	}
	
	private static Stream<BehavioredClass> classesIn(ModelUnit unit) {
		Stream<RuntimeClass> dynamicClasses = unit.getClassDefinitions().stream();
		Stream<ExtendedClass> staticClasses = unit.getClassExtensions().stream();
		return Stream.concat(dynamicClasses, staticClasses);
	}

	@Override
	public List<ExtendedClass> getOpenClasses() {
		return nonNullUnits()
				  .flatMap(unit -> unit.getClassExtensions().stream())
				  .collect(toList());
	}

	@Override
	public List<RuntimeClass> getRuntimeClasses() {
		return nonNullUnits()
				  .flatMap(unit -> unit.getClassDefinitions().stream())
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
		return nonNullUnits()
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
	public List<ParsedFile<ModelUnit>> getParsedFiles() {
		return new ArrayList<>(raw);
	}

	@Override
	public Optional<ParsedFile<ModelUnit>> findParsedFileDefining(Object astElement) {
		for (ParsedFile<ModelUnit> parsedFile : raw) {
			boolean parsedFileDefinesTheElement = parsedFile.getStartPositions().get(astElement) != null;
			if (parsedFileDefinesTheElement) {
				return Optional.of(parsedFile);
			}
		}
		return Optional.empty();
	}

	private Stream<ModelUnit> nonNullUnits() {
		return raw.stream()
				  .map(ParsedFile::getRoot)
				  .filter(Objects::nonNull);
	}

}
