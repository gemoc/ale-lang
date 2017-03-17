package lang.core.parser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import implementation.ExtendedClass;
import implementation.ModelBehavior;
import lang.core.parser.visitor.ModelBuilder;
import lang.core.parser.visitor.ParseResult;
import lang.core.parser.visitor.Visitors;

public class DslBuilder {
	
	IQueryEnvironment queryEnvironment;
	
	public DslBuilder(IQueryEnvironment qryEnv) {
		this.queryEnvironment = qryEnv;
	}

	/**
     * Setup the eval environment & parse semantic files
     */
    public List<ParseResult<ModelBehavior>> parse(Dsl dsl) { //TODO: add an option to clear services & epackages before
    	/*
    	 * Register EPackages
    	 */
    	ResourceSet rs = new ResourceSetImpl();
    	rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
    	dsl.getAllSyntaxes()
    		.stream()
    		.forEach(syntaxURI -> {
    			List<EPackage> pkgImports = load(syntaxURI, rs);
    			pkgImports
	    			.stream()
	    			.forEach(pkg -> {
	    				//Register if not already there
	    				Collection<EPackage> matchingPkgs = queryEnvironment.getEPackageProvider().getEPackage(pkg.getName());
	    				Optional<EPackage> existingPkg = matchingPkgs.stream().filter(p -> p.getNsURI().equals(pkg.getNsURI())).findFirst();
	    				if(!existingPkg.isPresent()){
	    					queryEnvironment.registerEPackage(pkg);
	    				}
	    			});
    		});
    	
    	/*
    	 * Parse behavior files
    	 */
    	List<ParseResult<ModelBehavior>> parsedSemantics =
    			(new AstBuilder(queryEnvironment)).parseFromFiles(dsl.getAllSemantics());
    	
//    	/*
//    	 * Register services
//    	 */
//    	parsedSemantics
//	    	.stream()
//	    	.forEach(sem -> {
//	    		ModelBehavior root = sem.getRoot();
//	    		if(root != null) {
//	    			root
//	    			.getServices()
//	        		.stream()
//	        		.forEach(srv -> javaExtensions.addImport(srv));
//	    		}
//	    	});
//    	javaExtensions.reloadIfNeeded();
    	
    	/*
    	 * Resolve extends
    	 */
    	Map<String,List<ExtendedClass>> behaviorToClass = new HashMap<String,List<ExtendedClass>>();
    	List<ExtendedClass> allExtensions = new ArrayList<ExtendedClass>();
    	parsedSemantics
    	.stream()
    	.forEach(sem -> {
    		ModelBehavior root = sem.getRoot();
    		if(root != null) {
    			List<ExtendedClass> xtdCls =  root.getClassExtensions().stream().collect(Collectors.toList());
    			behaviorToClass.put(root.getName(), xtdCls);
    			allExtensions.addAll(xtdCls);
    		}
    	});
    	allExtensions
    	.stream()
    	.forEach(cls -> {
    		List<EAnnotation> toResolve =
				cls
				.getEAnnotations()
				.stream()
				.filter(a -> a.getSource().equals(ModelBuilder.PARSER_SOURCE))
				.filter(a -> a.getDetails().get(ModelBuilder.PARSER_EXTENDS_KEY) != null)
				.collect(Collectors.toList());
    		toResolve
	    		.stream()
	    		.forEach(annot -> {
	    			String xtd = annot.getDetails().get(ModelBuilder.PARSER_EXTENDS_KEY);
	    			if(Visitors.isQualified(xtd)) {
	    				int lastDot = xtd.lastIndexOf(".");
	    				if(lastDot < xtd.length()){
	    					String qualifying = xtd.substring(0, lastDot);
	    					String name = xtd.substring(lastDot+1);
	    					List<ExtendedClass> candidates = behaviorToClass.get(qualifying);
	    					if(candidates != null) {
	    						Optional<ExtendedClass> searchRes =
	    							candidates
		    						.stream()
		    						.filter(c -> c.getBaseClass().getName().equals(name))
		    						.findFirst();
	    						if(searchRes.isPresent()) {
	    							cls.getExtends().add(searchRes.get());
	    							cls.getEAnnotations().remove(annot);
	    						}
	    					}
	    				}
	    			}
	    		});
    	});
    	
    	return parsedSemantics;
    }
	
    private List<EPackage> load(String ecoreURI, ResourceSet rs) {
    	URI uri = URI.createURI(ecoreURI);
    	Resource res  = rs.getResource(uri, true);
    	
    	return 
    		res
	    	.getContents()
	    	.stream()
	    	.filter(o -> o instanceof EPackage)
	    	.map(o -> (EPackage) o)
	    	.collect(Collectors.toList());
    }
}
