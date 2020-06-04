/*******************************************************************************
 * Copyright (c) 2017 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.core.serialization;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.eclipse.acceleo.query.runtime.IQueryEnvironment;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.ale.core.env.impl.FileBasedAleEnvironment;
import org.eclipse.emf.ecoretools.ale.core.parser.BehaviorsParser;
import org.eclipse.emf.ecoretools.ale.core.parser.ParsedFile;
import org.eclipse.emf.ecoretools.ale.core.parser.internal.AntlrAstToAleBehaviorsFactory;
import org.eclipse.emf.ecoretools.ale.implementation.ImplementationPackage;
import org.eclipse.emf.ecoretools.ale.implementation.Method;
import org.eclipse.emf.ecoretools.ale.implementation.ModelUnit;
import org.eclipse.emf.ecoretools.ale.implementation.RuntimeClass;

import com.google.common.collect.Maps;

/**
 * @deprecated this class does not seem to be used, we will remove it 
 */
@Deprecated
public class Converter {

	IQueryEnvironment qryEnv;
	
	public Converter(IQueryEnvironment qryEnv) {
		this.qryEnv = qryEnv;
		AntlrAstToAleBehaviorsFactory.createSingleton(qryEnv);
	}
	
	/*
	 * Convert all implemented EOperation to EAnnotations
	 */
	public void aleToEcore (FileBasedAleEnvironment dsl, boolean createRuntimeEcore) throws IOException {
		
		//Check feasible
		List<ParsedFile<ModelUnit>> parseRes = new BehaviorsParser(qryEnv).parse(dsl.getMetamodels(), dsl.getBehaviorsSources());
		List<ModelUnit> allModelUnits = parseRes.stream().map(p -> p.getRoot()).collect(Collectors.toList());
		boolean isConvertible = allModelUnits.stream().allMatch(unit -> isConvertibleToEcore(unit));
		
		if(isConvertible) {
			parseRes.forEach(parseUnit -> {
				//Collect implem
				List<Method> allImplem = 
					parseUnit
					.getRoot()
					.getClassExtensions()
					.stream()
					.flatMap(cls -> cls.getMethods().stream()) //isConvertible garantee they are implem
					.collect(Collectors.toList());
				allImplem.forEach(mtd -> {
					EOperation opRef = mtd.getOperationRef();
					Optional<String> body = parseUnit.getText(mtd.getBody());
					if(opRef != null) {
						if(body.isPresent()){
							EcoreUtil.setAnnotation(opRef, ImplementationPackage.eNS_URI, "body", body.get());
						}
						EcoreUtil.setAnnotation(opRef.getEContainingClass().getEPackage(),
								"http://www.eclipse.org/emf/2002/Ecore", "invocationDelegates", ImplementationPackage.eNS_URI);
					}
				});
				
				//Add runtime classes
				List<RuntimeClass> allRuntimeCls = 
					parseUnit
					.getRoot()
					.getClassDefinitions();
				allRuntimeCls
					.stream()
					.flatMap(cls -> cls.getMethods().stream())
					.forEach(mtd -> {
						EOperation opRef = mtd.getOperationRef();
						Optional<String> body = parseUnit.getText(mtd.getBody());
						if(body.isPresent() && opRef != null){
							EcoreUtil.setAnnotation(opRef, ImplementationPackage.eNS_URI, "body", body.get());
						}
					});
				allRuntimeCls
					.stream()
					.flatMap(cls -> cls.getAttributes().stream())
					.forEach(att -> {
						EStructuralFeature featureRef = att.getFeatureRef();
						Optional<String> initVal = parseUnit.getText(att.getInitialValue());
						if(initVal.isPresent()){
							EcoreUtil.setAnnotation(featureRef, ImplementationPackage.eNS_URI, "initial", initVal.get());
						}
					});
			});
			
			//Add runtime classes
			List<RuntimeClass> allRuntimeCls = 
				allModelUnits
				.stream()
				.flatMap(unit -> unit.getClassDefinitions().stream())
				.collect(Collectors.toList());
			EPackage runtimePkg = getRuntimeEPackage(dsl,createRuntimeEcore);
			EcoreUtil.setAnnotation(runtimePkg,
					"http://www.eclipse.org/emf/2002/Ecore", "settingDelegates", ImplementationPackage.eNS_URI);
			EcoreUtil.setAnnotation(runtimePkg,
					"http://www.eclipse.org/emf/2002/Ecore", "invocationDelegates", ImplementationPackage.eNS_URI);
			allRuntimeCls.forEach(runtimeCls -> {
				EClass newCls = AntlrAstToAleBehaviorsFactory.singleton.buildEClass(runtimeCls.getName());
				AntlrAstToAleBehaviorsFactory.singleton.updateEClass(newCls, runtimeCls);
				EcoreUtil.setAnnotation(newCls, ImplementationPackage.eNS_URI, "runtime", "");
				runtimePkg.getEClassifiers().add(newCls);
			});
			
			//Remove .ale
			dsl.getBehaviorsSources().clear();
			dsl.save(dsl);
		}
	}
	
	/*
	 * Convert all EAnnotation to ALE implementation
	 */
	public void ecoreToAle(FileBasedAleEnvironment dsl, boolean createRuntimeEcore) throws IOException {
		
		StringBuffer aleContent = new StringBuffer();
		aleContent.append("behavior generated.runtime;\n\n");
		
		List<EPackage> pkgs = dsl.getMetamodels();
		
		//all implem
		List<EPackage> allPkgs = 
			pkgs
			.stream()
			.flatMap(pkg -> getAllEPackages(pkg).stream())
			.collect(Collectors.toList());
		
		List<EPackage> runtimePkgs =
			allPkgs
			.stream()
			.filter(pkg -> EcoreUtil.getAnnotation(pkg, ImplementationPackage.eNS_URI, "runtime") != null)
			.collect(Collectors.toList());
		
		List<EPackage> syntaxPkgs =
			allPkgs
			.stream()
			.filter(pkg -> EcoreUtil.getAnnotation(pkg, ImplementationPackage.eNS_URI, "runtime") == null)
			.collect(Collectors.toList());
		
		//all runtime cls
		if(!createRuntimeEcore) {
		runtimePkgs
			.stream()
			.flatMap(pkg -> pkg.getEClassifiers().stream())
			.filter(c -> c instanceof EClass)
			.map(cls -> (EClass) cls)
			.forEach(cls -> {
				aleContent.append(Serializer.runtimeToString(cls));
				aleContent.append("\n");
			});
		}
		
		//all open class
		syntaxPkgs
			.stream()
			.flatMap(pkg -> pkg.getEClassifiers().stream())
			.filter(c -> c instanceof EClass)
			.map(cls -> (EClass) cls)
			.forEach(cls -> {
				aleContent.append(Serializer.openclassToString(cls));
				aleContent.append("\n");
			});
		
		
		//Create .ale
		Resource res = syntaxPkgs.get(0).eResource();
		URI ecoreURI = res.getURI();
		if(ecoreURI.fileExtension().equals("ecore")) {
			URI aleURI = ecoreURI.trimFileExtension().appendFileExtension("ale");
			String aleFilePath = aleURI.toFileString();
			Path path = Paths.get(aleFilePath);
			try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			    writer.write(aleContent.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//Remove runtime classes & EAnnotations
			removeAllRuntimeData(dsl,createRuntimeEcore);

			//Update dsl
			dsl.getBehaviorsSources().add(aleFilePath);
			dsl.save(dsl);
		}
	}
	
	
	/*
	 * Return false if declaring new elements
	 */
	private boolean isConvertibleToEcore(ModelUnit unit) {
		
		boolean hasAttributes = unit
			.getClassExtensions()
			.stream()
			.flatMap(cls -> cls.getAttributes().stream())
			.findAny()
			.isPresent();
		
		boolean hasMethod =
			unit
			.getClassExtensions()
			.stream()
			.flatMap(cls -> cls.getMethods().stream())
			.filter(mtd -> isImplementation(mtd))
			.findAny()
			.isPresent();
		
		return !(hasAttributes || hasMethod);
	}
	
	private boolean isImplementation(Method mtd) {
		EOperation opRef = mtd.getOperationRef();
		if(opRef != null) {
			String nsURI = opRef.getEContainingClass().getEPackage().getNsURI();
			boolean isRuntime = nsURI == null || nsURI.startsWith(AntlrAstToAleBehaviorsFactory.RUNTIME_ALE_NSURI);
			return !isRuntime;
		}
		return false;
	}
	
	/*
	 * Get the EPackage containing the Runtime Classes.
	 * Create a new resource if asked.
	 */
	private EPackage getRuntimeEPackage(FileBasedAleEnvironment dsl, boolean createRuntimeEcore) {

		List<EPackage> pkgs = dsl.getMetamodels();
		Optional<EPackage> runtimePkg = 
			pkgs
			.stream()
			.filter(pkg -> EcoreUtil.getAnnotation(pkg, ImplementationPackage.eNS_URI, "runtime") != null)
			.findFirst();
		
		if(runtimePkg.isPresent()) {
			return runtimePkg.get();
		}
		else if(createRuntimeEcore) {
			if(!pkgs.isEmpty()) {
				Resource res = pkgs.get(0).eResource();
				String fileName = res.getURI().lastSegment();
				if(fileName.endsWith("\\.ecore")) {
					fileName = "runtime" + Character.toUpperCase(fileName.charAt(0)) + fileName.substring(1);
					URI runtimeURI = res.getURI().trimSegments(1).appendSegment(fileName);
					Resource runtimeRes = res.getResourceSet().createResource(runtimeURI);
					EPackage newPkg = AntlrAstToAleBehaviorsFactory.singleton.buildEPackage("runtime");
					EcoreUtil.setAnnotation(newPkg, ImplementationPackage.eNS_URI, "runtime", "");
					runtimeRes.getContents().add(newPkg);
					try {
						runtimeRes.save(Maps.newHashMap());
						dsl.getMetamodelsSources().add(runtimeURI.toFileString());
						return newPkg;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		else {
			if(!pkgs.isEmpty()) {
				EPackage firstPkg = pkgs.get(0);
				return firstPkg;
			}
		}
		
		return null;
	}
	
	/*
	 * Return pkg and its sub packages
	 */
	private List<EPackage> getAllEPackages(EPackage pkg) {
		List<EPackage> res = 
			pkg
			.getESubpackages()
			.stream()
			.flatMap(p -> getAllEPackages(p).stream())
			.collect(Collectors.toList());
		res.add(0, pkg);
		return res;
	}
	
	private void removeAllRuntimeData(FileBasedAleEnvironment dsl, boolean createRuntimeEcore) throws IOException {
		List<EPackage> pkgs = dsl.getMetamodels();
		
		//all implem
		List<EPackage> allPkgs = 
			pkgs
			.stream()
			.flatMap(pkg -> getAllEPackages(pkg).stream())
			.collect(Collectors.toList());
		
		allPkgs.forEach(pkg -> {
			EAnnotation eAnnotation = pkg.getEAnnotation(ImplementationPackage.eNS_URI);
			if(eAnnotation != null) {
				EcoreUtil.remove(eAnnotation);
			}
		});
		
		List<EPackage> syntaxPkgs =
			allPkgs
			.stream()
			.filter(pkg -> EcoreUtil.getAnnotation(pkg, ImplementationPackage.eNS_URI, "runtime") == null)
			.collect(Collectors.toList());
		syntaxPkgs
			.stream()
			.flatMap(pkg -> pkg.getEClassifiers().stream())
			.filter(c -> c instanceof EClass)
			.map(c -> (EClass) c)
			.forEach(cls -> {
				if(EcoreUtil.getAnnotation(cls, ImplementationPackage.eNS_URI, "runtime") != null) {
					EcoreUtil.remove(cls);
				}
				else {
					cls.getEStructuralFeatures().forEach(feature -> {
						EAnnotation eAnnotation = feature.getEAnnotation(ImplementationPackage.eNS_URI);
						if(eAnnotation != null) {
							EcoreUtil.remove(eAnnotation);
						}
					});
					cls.getEOperations().forEach(operation -> {
						EAnnotation eAnnotation = operation.getEAnnotation(ImplementationPackage.eNS_URI);
						if(eAnnotation != null) {
							EcoreUtil.remove(eAnnotation);
						}
					});
				}
			});
		
		//Remove runtime packages
		if(!createRuntimeEcore) {
			List<EPackage> runtimePkgs =
					allPkgs
					.stream()
					.filter(pkg -> EcoreUtil.getAnnotation(pkg, ImplementationPackage.eNS_URI, "runtime") != null)
					.collect(Collectors.toList());
			runtimePkgs.forEach(pkg -> {
				dsl.getMetamodelsSources().remove(pkg.eResource().getURI().toString()); //TODO: check both standalone & workspace
			});
		}
		
		//Save changes
		syntaxPkgs
			.stream()
			.map(pkg -> pkg.eResource())
			.collect(Collectors.toSet())
			.forEach(res -> {
				try {
					res.save(Maps.newHashMap());
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		dsl.save(dsl);
	}
}
