package fr.inria.diverse.objectalgebragenerator.popup.actions

import fr.inria.diverse.objectalgebragenerator.popup.actions.Graph.GraphNode
import java.util.Comparator
import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Map.Entry
import java.util.Set
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference

class GenerateAlgebra {

	private def Node<EClass> addChildren(EClass e, List<EClass> allElems) {
		val ret = new Node(e)
		val subtypes = allElems.filter[f|f.ESuperTypes.contains(e)]
		subtypes.filter[x|!x.isRoot].map[f|addChildren(f, allElems)].forEach[x|ret.addChild(x)]
		ret
	}
	
	private def Graph<EClass> buildGraph(EPackage ePackage) {
		val graph1 = new Graph<EClass>();
		visitPackages(newHashSet(), ePackage, graph1)
		graph1	
	}
	
	private def Map<String, List<GraphNode<EClass>>> buildAllTypes(List<List<GraphNode<EClass>>> clusters) {
		clusters.toMap(new CharsSequence)
	}
	
	private def List<List<GraphNode<EClass>>> calculateClusters(Graph<EClass> graphCurrentPackage) {
		graphCurrentPackage.clusters().map[x|x.sortBy[y|y.elem.name]].sortBy[z|z.head.elem.name].toList		
	}
	
	private def buildConcretTypeForParents(EPackage ePackage, Map<String, List<GraphNode<EClass>>> allTypes) {
		val graphCurrentPackage = buildGraph(ePackage)

		val  clusters = calculateClusters(graphCurrentPackage)
		
		clusters.map[x | x.filter[z|!z.elem.abstract].head.elem.abstractType(allTypes)]
	}
	
		def String processAlgebraMemo(EPackage ePackage) { 
			return "";
		}

	def String processAlgebra(EPackage ePackage) {

		val graphCurrentPackage = buildGraph(ePackage)

		val  clusters = calculateClusters(graphCurrentPackage)
		val allTypes = buildAllTypes(clusters)
		
		val allConcretTypes = buildConcretTypes(allTypes)
		
		val allMethods = graphCurrentPackage.nodes.sortBy[e|e.elem.name].filter[e|e.elem.EPackage.equals(ePackage)].filter [e|
			!e.elem.abstract
		]

		
		
		val allDirectPackages = allMethods.allDirectPackages(ePackage) 

		val all$Types = allConcretTypes.mapValues[e|e.filter[f|f.elem.EPackage.equals(ePackage)]].
			filter[p1, p2|!p2.empty]
			
		val imports = newHashSet()
		imports.addAll(allMethods.map[elem].map[e|'''«e.EPackage.name».«e.name»'''])
		imports.addAll(all$Types.values.map[findRootType].map[e|'''«e.EPackage.name».«e.name»'''])
		imports.addAll(allDirectPackages.map[e|'''«e.name».algebra.«e.toPackageName»'''])
		
		'''
		package «ePackage.name».algebra;
		
		«FOR imported:imports.sort»
		import «imported»;
		«ENDFOR»
		import java.util.Map;
		
		public interface «ePackage.toPackageName»«FOR x : allConcretTypes.keySet BEFORE '<' SEPARATOR ', ' AFTER '>'»«x»«ENDFOR»«FOR ePp : allDirectPackages.sortBy[name].map[x | (x -> buildConcretTypeForParents(x, allTypes))] BEFORE ' extends ' SEPARATOR ', '»«ePp.key.toPackageName»«FOR x : ePp.value BEFORE '<' SEPARATOR ', ' AFTER '>'»«x»«ENDFOR»«ENDFOR» {
		
			«FOR eClass : allMethods.map[elem]»
				«eClass.abstractType(allTypes)» «eClass.name.toFirstLower»(final «eClass.name» «eClass.name.toFirstLower»);

			«ENDFOR»
			«FOR abstractTypes : all$Types.entrySet SEPARATOR '\n'»
			«IF abstractTypes.value.getDirectPackages(ePackage).size > 0»@Override«ENDIF»			
			public default «abstractTypes.key» $(final «abstractTypes.value.findRootType.name» «abstractTypes.value.findRootType.name.toFirstLower») {
				final «abstractTypes.key» ret;
				«FOR type : abstractTypes.concretTypes(ePackage).map[elem].sortBy[name] BEFORE 'if' SEPARATOR ' else if' AFTER ''» («abstractTypes.value.findRootType.name.toFirstLower».eClass().getClassifierID() == AAAAAPackage.«type.name.toUpperCase») {
					ret = this.«type.name.toFirstLower»((«type.name») «abstractTypes.value.findRootType.name.toFirstLower»);
				}«ENDFOR» else {
				«IF abstractTypes.value.getDirectPackages(ePackage).size > 0»
					«abstractTypes.value.getDirectPackages(ePackage).toTryCatch(abstractTypes.value.findRootType.name.toFirstLower)»
				«ELSE»
								«'\t'»throw new RuntimeException("Unknow «abstractTypes.value.findRootType.name» " + «abstractTypes.value.findRootType.name.toFirstLower»);
				«ENDIF»
				}
				return ret;
			}«ENDFOR»
		}'''
	}
	
	private def buildConcretTypes(Map<String, List<GraphNode<EClass>>> allTypes) {
		allTypes.mapValues[x|x.filter[y|!y.elem.abstract]].filter[p1, p2|!p2.empty]
	}
	
	private def List<EPackage> allDirectPackages(Iterable<GraphNode<EClass>> nodes, EPackage ePackage) {
		val allDirectPackagesByInheritance = nodes.getDirectPackageByInheritance(ePackage)
		
		val allDirectPackageByReference = nodes.getAllDirectPackagesByReference(ePackage)
		
		allDirectPackagesByInheritance.addAll(allDirectPackageByReference)
		allDirectPackagesByInheritance.sortBy[name]
	}
	
	private def Set<EPackage> getAllDirectPackagesByReference(Iterable<GraphNode<EClass>> nodes, EPackage ePackage) {
		nodes.map[e|e.elem.EReferences].map[e|e.directlyRelatedTypes].flatten.map[e|e.EPackage].filter [ e |
			!e.equals(ePackage)
		].toSet
	}
	
	private def Set<EPackage> getDirectPackageByInheritance(Iterable<GraphNode<EClass>> nodes, EPackage ePackage) {
		nodes.map[e|e.outgoing].flatten.map[e|e.elem.EPackage].filter [ e |
			!e.equals(ePackage)
		].toSet
	}


	
	private def concretTypes(Entry<String, Iterable<GraphNode<EClass>>> entry, EPackage ePackage) {
		entry.value.findConcretTypes(ePackage).sortWith(new Comparator<GraphNode<EClass>> {
				
				override compare(GraphNode<EClass> o1, GraphNode<EClass> o2) {
					val d1 = o1.distanceFromRoot(entry.value.findRootType)
					val d2 = o2.distanceFromRoot(entry.value.findRootType)
					d1.compareTo(d2)
				}
				
			}).reverse
	}
	
	

	private def String toTryCatch(Iterable<EPackage> packages, String typeVarName) {
			'''
			«IF packages.size == 1»
				ret = «packages.head.toPackageName».super.$(«typeVarName»);
			«ELSE»
				try {
					ret = «packages.head.toPackageName».super.$(«typeVarName»);
				} catch(RuntimeException e) {
					«toTryCatch(packages.tail, typeVarName)»
				}
			«ENDIF»
			'''
	}

	private def Set<GraphNode<EClass>> findConcretTypes(Iterable<GraphNode<EClass>> nodes, EPackage ePackage) {
		nodes.filter[e|!e.elem.abstract].filter[e|e.elem.EPackage.equals(ePackage)].toSet
	}

	private def List<EPackage> getDirectPackages(Iterable<GraphNode<EClass>> entry, EPackage currentPackage) {
		entry.map[outgoing].flatten.map[e|e.elem.EPackage].filter[e|!e.equals(currentPackage)].toSet.sortBy[name]
	}

	private def EClass getFindRootType(Iterable<GraphNode<EClass>> nodes) {
		val roots = nodes.map[roots].flatten.toSet
		if (roots.size >
			1) {
			throw new RuntimeException('''A classes cluster can't have more than one roots. We find a cluster composed of those roots: «FOR node : roots SEPARATOR ', '»«node.elem.EPackage.name».«node.elem.name»«ENDFOR»''')
		} else {
			roots.head.elem
		}
	}
	
	private def Iterable<GraphNode<EClass>> getListTypesRec(HashSet<EPackage> visited, EPackage ePackage, Graph<EClass> graph, Map<String, List<GraphNode<EClass>>> allTypes) {
		if(!visited.contains(ePackage)) {
			visited.add(ePackage)
			val List<GraphNode<EClass>> relatedToCurrentPackage = graph.nodes.sortBy[e|e.elem.name].filter [e|
				e.elem.EPackage.equals(ePackage) || e.children.exists[f|f.elem.EPackage.equals(ePackage)] || e.elem.EReferences.directlyRelatedTypes.exists[v|v.EPackage.equals(ePackage)]
			].toList
			
			
			val List<EPackage> letgo = relatedToCurrentPackage.allDirectPackages(ePackage)
			letgo.forEach[n|
				relatedToCurrentPackage.addAll(getListTypesRec(visited, n, graph, allTypes))
			] 
			
			relatedToCurrentPackage
			
			
			
		} else {
			newArrayList()
		}
	}

	private def String abstractType(EClass class1, Map<String, List<GraphNode<EClass>>> allTypes) {
		allTypes.entrySet.filter[e|
			e.value.contains(new GraphNode(class1))
		].head.key
	}

	private def void visitPackages(HashSet<EPackage> visitedpackage, EPackage ePackage, Graph<EClass> graph1) {
		visitedpackage.add(ePackage)
		val allEClasses = ePackage.eAllContents.filter[e|e instanceof EClass].map[e|e as EClass].toList.sortBy[e|e.name]
		allEClasses.forEach[e|addParents(graph1, e)]
		allEClasses.forEach[e|e.EReferences.directlyRelatedTypes.forEach[f|addParents(graph1, f)]]

		val notYetVisited = graph1.nodes.sortBy[e|e.elem.name].map[e|e.elem.EPackage].toSet.filter[e|!visitedpackage.contains(e)]
		notYetVisited.forEach [ e |
			visitPackages(visitedpackage, e, graph1)
		]
	}
	
	private def List<EClass> getDirectlyRelatedTypes(EList<EReference> list) {
		list.map[f|f.EType].filter[z|z instanceof EClass].map[q|q as EClass].filter[x|!x.EPackage.name.equals("ecore")].toList
	}

	private def void addParents(Graph<EClass> graph1, EClass e) {
		println('''# Add class «e.name»''')
		val node = graph1.addNode(e)
		e.ESuperTypes.forEach [ f |
			val node2 = graph1.addNode(f)
			if (!e.root) {
				graph1.addEdge(node, node2)
			}
			addParents(graph1, f)
		]
	}

	/**
	 * A root element is an element with no super type or explicitly defined with @OARoot.
	 */
	private def static boolean isRoot(EClass eClass) {
		eClass.ESuperTypes.empty || eClass.hasOARootAnnotation
	}

	private def static EClass findRootParent(EClass eClass) {
		if(eClass.isRoot) eClass else findRootParent(eClass.ESuperTypes.head)
	}

	private def static boolean hasOARootAnnotation(EClass eClass) {
		eClass.EAnnotations.exists[e|e.source.equals("OARoot")]
	}

	private def static String toClassName(String name) {
		name.split("\\.").map[e|e.toFirstUpper].join
	}

	private def static toPackageName(EPackage ePackage) '''«ePackage.name.toClassName»Algebra'''
}
