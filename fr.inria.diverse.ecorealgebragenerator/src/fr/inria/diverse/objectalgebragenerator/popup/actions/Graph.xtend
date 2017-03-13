package fr.inria.diverse.objectalgebragenerator.popup.actions

import java.util.Set
import org.eclipse.emf.ecore.EClass
import fr.inria.diverse.objectalgebragenerator.popup.actions.Graph.GraphNode

class Graph<E> {
	static class GraphNode<E> {
		public E elem
		private Set<GraphNode<E>> incomming = newHashSet()
		private Set<GraphNode<E>> outgoing = newHashSet()

		new(E elem) {
			this.elem = elem
		}

		private def addOutgoing(GraphNode<E> x) {
			outgoing.add(x)
		}

		private def addIncomming(GraphNode<E> x) {
			incomming.add(x)
		}

		def getOutgoing() {
			outgoing
		}

		def isRoot() {
			outgoing.empty
		}

		def Set<GraphNode<E>> getRoots() {
			if (isRoot) {
				newHashSet(this)
			} else {
				outgoing.map[roots].flatten.toSet
			}
		}

		override boolean equals(Object obj) {
			println('''comparing ELEMENTS''')
			if (obj instanceof GraphNode) {
				println('''comparing obj («obj.elem === elem») «obj.elem» TO «elem»''')
				obj.elem === elem
			} else {
				false
			}
		}

		override String toString() {
			'''Node («elem»)'''
		}

		override int hashCode() {
			elem.hashCode()
		}

		private def Set<GraphNode<E>> getParents() {
			val ret = newHashSet();
			ret.addAll(this.outgoing)
			outgoing.forEach[x|ret.addAll(x.parents)]
			ret
		}

		def Set<GraphNode<E>> getChildren() {
			val ret = newHashSet();
			ret.addAll(this.incomming)
			incomming.forEach[x|ret.addAll(x.children)]
			ret
		}

		def Integer distanceFromRoot(EClass class1) {
			if (class1.equals(elem)) {
				0
			} else {
				outgoing.map[distanceFromRoot(class1) + 1].min
			}
		}

	}

	public Set<GraphNode<E>> nodes = newHashSet()

	def addNode(E elem) {
		val nE = new GraphNode(elem)
		nodes.add(nE)
		nodes.findFirst[x|x.equals(nE)]
	}

	def addEdge(GraphNode<E> elem1, GraphNode<E> elem2) {
		elem1.addOutgoing(elem2)
		elem2.addIncomming(elem1)

	}

	def getRoots() {
		nodes.filter[isRoot]
	}

	override String toString() {
		'''Graph («FOR n : nodes SEPARATOR ', '»«n»«ENDFOR»)'''
	}

	def Set<Set<GraphNode<E>>> clusters() {
		val ret = newHashSet()
		nodes.forEach [ GraphNode<E> x |
			if (!ret.exists [ Set<GraphNode<E>> y |
				y.contains(x) || y.containsSome(x.parents) || y.containsSome(x.children)
			]) {
				val nhs = newHashSet()
				nhs.add(x)
				nhs.addAll(x.parents)
				nhs.addAll(x.children)
				ret.add(nhs)
			} else {

				/*
				 * If some sets exists with elements common to the current elem (itself of its parents/childen) they are merge into a single set  
				 */
				val set = ret.filter[y|y.contains(x) || y.containsSome(x.parents) || y.containsSome(x.children)].toList
				
				ret.removeAll(set);

				val newSet = newHashSet()
				set.forEach[u|newSet.addAll(u)]

				newSet.addAll(x.parents)
				newSet.addAll(x.children)
				ret.add(newSet)
			}
		]
		ret
	}

	private def boolean containsSome(Set<?> nodes, Set<?> nodes2) {
		nodes.exists[e|nodes2.contains(e)]
	}

}
