package fr.inria.diverse.objectalgebragenerator

import fr.inria.diverse.objectalgebragenerator.Graph.GraphNode
import java.util.Collection
import java.util.HashSet
import java.util.List
import java.util.Map
import java.util.Set
import org.eclipse.emf.common.util.EList
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EPackage
import org.eclipse.emf.ecore.EReference

class GenerateAlgebra {

//	private def Node<EClass> addChildren(EClass e, List<EClass> allElems) {
//		val ret = new Node(e)
//		val subtypes = allElems.filter[f|f.ESuperTypes.contains(e)]
//		subtypes.filter[x|!x.isRoot].map[f|addChildren(f, allElems)].forEach[x|ret.addChild(x)]
//		ret
//	}
	
	public def Graph<EClass> buildGraph(EPackage ePackage) {
		val graph1 = new Graph<EClass>()
		visitPackages(newHashSet(), ePackage, graph1)
		graph1	
	}
	
	private def Map<String, List<GraphNode<EClass>>> buildAllTypes(List<List<GraphNode<EClass>>> clusters) {
		clusters.toMap(new CharsSequence)
	}
	
	private def List<List<GraphNode<EClass>>> calculateClusters(Graph<EClass> graphCurrentPackage) {
		graphCurrentPackage.clusters().map[x|x.sortBy[y|y.elem.name]].sortBy[z|z.head.elem.name].toList		
	}
	
	def calculateAllTypes(EPackage ePackage, boolean global) {
		buildConcretTypes(buildAllTypes(calculateClusters(buildGraph(ePackage)))).mapValues[e|if(global) e else e.filter[f|f.elem.EPackage.equals(ePackage)]].
			filter[p1, p2|!p2.empty]
			
		}
		
	def String processConcreteOperation(GraphNode<EClass> entry, EPackage epackage) {
		val clazz = entry.elem
		val all$TypesGlobal = calculateAllTypes(epackage, true) 
		'''
		package «epackage.name».algebra.impl.operation;
		
		public class «clazz.EPackage.name.toFirstUpper»«clazz.name.toFirstUpper»Operation implements «epackage.name».algebra.operation.«epackage.name.toFirstUpper + clazz.name.toFirstUpper+"Operation"» {
			
			private final «clazz.javaFullPath» self;
			private final «epackage.name».algebra.«epackage.name.toFirstUpper»Algebra«FOR x: all$TypesGlobal.entrySet BEFORE '<' SEPARATOR ', ' AFTER '>'»? extends «x.value.findRootType.operationFullPath(epackage)»«ENDFOR» algebra;
			
			public «clazz.EPackage.name.toFirstUpper»«clazz.name.toFirstUpper»Operation(final «clazz.javaFullPath» self, final «epackage.name».algebra.«epackage.name.toFirstUpper»Algebra«FOR x: all$TypesGlobal.entrySet BEFORE '<' SEPARATOR ', ' AFTER '>'»? extends «x.value.findRootType.operationFullPath(epackage)»«ENDFOR» algebra) {
				this.self = self;
				this.algebra = algebra;
			}
		}
		'''
	
	}

	def String processConcreteAlgebra(EPackage ePackage) { 
	
		/*
		 * Here we have to generate one method per class
		 */
	
		val typez = buildGraph(ePackage) 
		val all$TypesGlobal = calculateAllTypes(ePackage, true) 
	
		'''
		package «ePackage.name».algebra.impl;
		
		public interface «ePackage.name.toFirstUpper»AlgebraImpl extends «ePackage.name».algebra.«ePackage.name.toFirstUpper»Algebra«FOR x: all$TypesGlobal.values BEFORE '<' SEPARATOR ', ' AFTER '>'»«x.findRootType.operationFullPath(ePackage)»«ENDFOR» {
			«FOR x: typez.nodes»
			@Override
			default «ePackage.name».algebra.impl.operation.«x.elem.EPackage.name.toFirstUpper»«x.findRootType(all$TypesGlobal).name.toFirstUpper»Operation «x.findRootType(all$TypesGlobal).name.toFirstLower»(final «x.elem.javaFullPath» «x.elem.name») {
				return new «ePackage.name».algebra.impl.operation.«x.elem.EPackage.name.toFirstUpper»«x.findRootType(all$TypesGlobal).name.toFirstUpper»Operation(«x.findRootType(all$TypesGlobal).name», this);
			} 
			«ENDFOR»
		}
		'''
	}
	
	private def EClass findRootType(GraphNode<EClass> node, Map<String, Iterable<GraphNode<EClass>>> clusters) {
		clusters.values.filter[i | i.exists[e | e.elem === node.elem]].head.findRootType
	}
	
	
	private def Collection<EClass> ancestors(EClass clazz) {
		val ret = newHashSet()
		if(!clazz.ESuperTypes.empty) {
			clazz.ESuperTypes.forEach[st|
				ret.add(st) 
				ret.addAll(st.ancestors)
			]
		}
		
		ret
	}
	
	
	def allClasses(EPackage ePackage) {
		ePackage.eAllContents.filter[e|e instanceof EClass].map[e|e as EClass].toList.sortBy[e|e.name]	
	}
	
	def String genericType(EClass clazz) 
		'''«clazz.EPackage.name.replaceAll("\\.","").toFirstUpper»__«clazz.name»T'''
	
	

	def String processAlgebra(EPackage ePackage) {
		
		val allEClasses = ePackage.allClasses
		val graph = buildGraph(ePackage)
		val allMethods = graph.nodes.sortBy[e|e.elem.name].filter[e|e.elem.EPackage.equals(ePackage)].filter [e|
			!e.elem.abstract
		] 
		val allDirectPackages = allMethods.allDirectPackages(ePackage)
		
		'''
		package «ePackage.name».algebra;
		
		«FOR clazz: allEClasses»
		import «clazz.javaFullPath»;
		«ENDFOR»
		
		public interface «ePackage.toPackageName»«FOR clazz: graph.nodes.sortBy[x|x.elem.name] BEFORE '<' SEPARATOR ',' AFTER '>'»«clazz.elem.genericType»«ENDFOR»
			«FOR ePp : allDirectPackages.sortBy[name] BEFORE ' extends ' SEPARATOR ', '»«ePp.name».algebra.«ePp.toPackageName»«FOR x : ePp.allClasses BEFORE '<' SEPARATOR ', ' AFTER '>'»«x.genericType»«ENDFOR»«ENDFOR» {
			«FOR clazzNode:allMethods»
			«clazzNode.elem.genericType» «clazzNode.elem.name.toFirstLower»(final «clazzNode.elem.name» «clazzNode.elem.name.toFirstLower»);
			«FOR parent: clazzNode.elem.ancestors»
			«parent.genericType» «parent.name.toFirstLower»_«clazzNode.elem.name.toFirstLower»(final «clazzNode.elem.name» «clazzNode.elem.name.toFirstLower»);
			«ENDFOR»
			
			«ENDFOR»
			
			«FOR clazz:graph.nodes»
			default «clazz.elem.genericType» $(«clazz.elem.name» «clazz.elem.name.toFirstLower») {
				«FOR subClazz:clazz.incomings.filter[sc|!sc.elem.abstract]»
				if(«clazz.elem.name.toFirstLower» instanceof «subClazz.elem.name») return «clazz.elem.name.toFirstLower»_«subClazz.elem.name.toFirstLower»((«subClazz.elem.name») «subClazz.elem.name.toFirstLower»);
				«ENDFOR»
				«IF clazz.elem.abstract»
				return null;
				«ELSE»
				return «clazz.elem.name.toFirstLower»(«clazz.elem.name.toFirstLower»);
				«ENDIF»
			}
			«ENDFOR»
		}
		'''
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

	private def String toTryCatch(Iterable<EPackage> packages, String typeVarName) {
			'''
			«IF packages.size == 1»
				ret = «packages.head.name».algebra.«packages.head.toPackageName».super.$(«typeVarName»);
			«ELSE»
				try {
					ret = «packages.head.toPackageName».super.$(«typeVarName»);
				} catch(RuntimeException e) {
					«toTryCatch(packages.tail, typeVarName)»
				}
			«ENDIF»
			'''
	}

	public def static EClass getFindRootType(Iterable<GraphNode<EClass>> nodes) {
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
		//println('''# Add class «e.name»''')
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
		eClass.ESuperTypes.empty //|| eClass.hasOARootAnnotation
	}

	private def static EClass findRootParent(EClass eClass) {
		if(eClass.isRoot) eClass else findRootParent(eClass.ESuperTypes.head)
	}

	private def static String toClassName(String name) {
		name.split("\\.").map[e|e.toFirstUpper].join
	}

	private def static toPackageName(EPackage ePackage) '''«ePackage.name.toClassName»Algebra'''
	
	private def static javaFullPath(EClass eClass) '''«eClass.EPackage.name».«eClass.name»'''
	private def static operationFullPath(EClass eClass, EPackage rootPackage) '''«rootPackage.name».algebra.operation.«rootPackage.name.toFirstUpper»«eClass.name»Operation'''
}
