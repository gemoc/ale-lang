package fr.inria.diverse.objectalgebragenerator.popup.actions

import java.util.List

class Node<T> {
	val List<Node<T>> childen = newArrayList()

	val T value

	var Node<T> parent

	new(T t) {
		this.value = t
	}

	def boolean hasChilden() {
		!childen.empty
	}

	def isRoot() {
		this.parent == null
	}

	def addChild(Node<T> t) {
		childen.add(t)
		t.parent = this
	}

	def List<T> toList() {
		val ret = newArrayList()
		ret.addAll(childen.map[toList].flatten)
		ret.add(value)
		ret
	}
}
