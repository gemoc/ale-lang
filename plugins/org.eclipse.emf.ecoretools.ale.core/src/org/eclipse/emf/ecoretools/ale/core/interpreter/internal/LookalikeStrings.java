/*******************************************************************************
 * Copyright (c) 2020 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.interpreter.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class LookalikeStrings {
	
	public static LookalikeStringsBuilder compare(String original) {
		return new LookalikeStringsBuilder(original);
	}
	
	public static class LookalikeStringsBuilder {
		private String original;
		private Set<String> lookalikes = new HashSet<>();
		
		public LookalikeStringsBuilder(String original) {
			this.original = original;
		}

		public LookalikeStringsBuilder with(String lookalike) {
			lookalikes.add(lookalike);
			return this;
		}
		
		public LookalikeStringsBuilder with(Collection<String> newLookalikes) {
			lookalikes.addAll(newLookalikes);
			return this;
		}
		
		public LookalikeStrings now() {
			return new LookalikeStrings(original, lookalikes);
		}
	}
	
	private static class Relevancy implements Comparable<Relevancy> {
		int differences;
		int firstDifferenceIndex;
		
		public Relevancy(int firstDifferenceIndex, int differences) {
			this.differences = differences;
			this.firstDifferenceIndex = firstDifferenceIndex;
		}

		@Override
		public int compareTo(Relevancy other) {
			if (this.differences != other.differences) {
				return this.differences - other.differences;
			}
			else {
				return this.firstDifferenceIndex - other.firstDifferenceIndex;
			}
		}
		
		@Override
		public String toString() {
			return differences + " ; " + firstDifferenceIndex;
		}
		
		@Override
		public int hashCode() {
			final int prime  = 31;
			int       result = 1;
			result = prime * result + differences;
			result = prime * result + firstDifferenceIndex;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Relevancy other = (Relevancy) obj;
			if (differences != other.differences)
				return false;
			if (firstDifferenceIndex != other.firstDifferenceIndex)
				return false;
			return true;
		}
		
	}
	
	private static class Lookalike implements Comparable<Lookalike> {
		String text;
		Relevancy relevancy;
		
		public Lookalike(String text, Relevancy relevancy) {
			this.text = text;
			this.relevancy = relevancy;
		}

		@Override
		public int compareTo(Lookalike other) {
			int comp = this.relevancy.compareTo(other.relevancy);
			if (comp == 0) {
				return this.text.compareTo(other.text);
			}
			else {
				return comp;
			}
		}
		
		@Override
		public int hashCode() {
			final int prime  = 31;
			int       result = 1;
			result = prime * result + ((relevancy == null) ? 0 : relevancy.hashCode());
			result = prime * result + ((text == null) ? 0 : text.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Lookalike other = (Lookalike) obj;
			if (relevancy == null) {
				if (other.relevancy != null)
					return false;
			} else if (!relevancy.equals(other.relevancy))
				return false;
			if (text == null) {
				if (other.text != null)
					return false;
			} else if (!text.equals(other.text))
				return false;
			return true;
		}
		
	}
	
	private final String original;
	
	private final Set<String> lookalikes;
	
	private SortedSet<Lookalike> bestLookalikesFirst;

	public LookalikeStrings(String original, Collection<String> lookalikes) {
		this.original   = original;
		this.lookalikes = new HashSet<>(lookalikes);
	}
	
	public LinkedHashSet<String> getNBests(int n) {
		LinkedHashSet<String> bests = new LinkedHashSet<>();
		Iterator<Lookalike> iterator = getSortedLookalikes().iterator();
		
		for (int i = 0 ; i < n ; ++i) {
			if (!iterator.hasNext()) {
				break;
			}
			bests.add(iterator.next().text);
		}
		return bests;
	}
	
	private SortedSet<Lookalike> getSortedLookalikes() {
		if (bestLookalikesFirst == null) {
			bestLookalikesFirst = new TreeSet<>();
			
			for (String lookalike : lookalikes) {
				bestLookalikesFirst.add(new Lookalike(lookalike, relevancyOf(lookalike)));
			}
		}
		return bestLookalikesFirst;
	}
	
	private Relevancy relevancyOf(String lookalike) {
		int count = 0;
		int firstDifferenceIndex = -1;
		int originalOffset = 0;
		int lookalikeOffset = 0;
		if (original.startsWith("self.")) {
			originalOffset = "self.".length();
		}
		if (lookalike.startsWith("self.")) {
			lookalikeOffset = "self.".length();
		}
		
		for (int i = 0 ; (i + originalOffset) < original.length() && (i + lookalikeOffset) < lookalike.length() ; ++i) {
			if (original.charAt(i + originalOffset) != lookalike.charAt(i + lookalikeOffset)) {
				++count;
				
				if (firstDifferenceIndex == -1) {
					firstDifferenceIndex = i;
				}
			}
		}
		count += Math.abs(original.length() - lookalike.length());
		return new Relevancy(firstDifferenceIndex, count);
	}

	public String getOriginal() {
		return original;
	}

}
