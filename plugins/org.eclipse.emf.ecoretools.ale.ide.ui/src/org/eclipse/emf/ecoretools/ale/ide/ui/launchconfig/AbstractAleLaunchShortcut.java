/*******************************************************************************
 * Copyright (c) 2017-2020 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig;

import static org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig.AleLaunchConfiguration.BEHAVIORS_PATH;
import static org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig.AleLaunchConfiguration.METAMODELS_PATH;
import static org.eclipse.emf.ecoretools.ale.ide.ui.launchconfig.AleLaunchConfiguration.MODEL_FILE;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.emf.ecoretools.ale.core.interpreter.IAleEnvironment;
import org.eclipse.emf.ecoretools.ale.ide.ui.Activator;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;

/**
 * Shortcut allowing to run ALE from the contextual menu.
 * 
 * <h3>Creating a new shortcut</h3>
 * <p>
 * The retrieval of the relevant environment is delegated to subclasses. That's actually
 * the only thing subclasses have to care about because the rest of the launch algorithm
 * is defined here.
 * <p>
 * All the actual launching-related code stays in {@link AleLaunchConfigurationDelegate}. 
 *
 * <h3>Launch algorithm</h3
 * <p>
 * <ol>
 * 	<li>Retrieves the {@link IAleEnvironment ALE environment} relevant to the selection,
 * 	<li>Creates a new {@link AleLaunchConfiguration.ID ALE Launch Configuration},
 * 	<li>Launches it.
 * </ol>
 * <p>
 */
abstract class AbstractAleLaunchShortcut implements ILaunchShortcut {
    
	/**
	 * Called when a launch is required.
	 * <p>
	 * Subclasses should implement this method in a way that subsequent calls to
	 * {@link #getModel()}, {@link #getEnvironment()} and {@link #getBaseConfigurationName()}
	 * return a non-null value.
	 * 
	 * @param resource
	 * 			The resource on which the contextual menu has been used.
	 * 
	 * @throws Exception if something bad occurs
	 */
    @SuppressWarnings("squid:S00112")
    protected abstract void prepareLaunchOn(IResource resource) throws Exception;
    
    /**
     * Returns the XMI model to execute.
     * @return the XMI model to execute, or nothing to cancel the launch
     */
    protected abstract Optional<IResource> getModel();
    
    /**
     * Returns the name of the launch configuration to create.
     * @return the name of the launch configuration to create
     */
    protected abstract String getBaseConfigurationName();
    
    /**
     * Returns the environment relevant to this execution.
     * @return the environment relevant to this execution
     */
    protected abstract IAleEnvironment getEnvironment();
	
    @Override
    public void launch(ISelection selection, String mode) {
    	try {
    		IResource resource = toResource(selection);
    		prepareLaunchOn(resource);
    		
    		if (! getModel().isPresent()) {
    			// The user didn't choose any model -> implicit cancellation
    			return;
    		}
    		ILaunchConfiguration configuration = createLaunchConfiguration(getBaseConfigurationName(), getEnvironment(), getModel().get());
			
	        // Run the new launch configuration
	        configuration.launch(ILaunchManager.RUN_MODE, null);
    	}
    	catch (Exception e) {
    		Activator.error("An error occurred while launching ALE", e);
    	}
    }

	@Override
	public void launch(IEditorPart editor, String mode) {
		//TODO: launch from ALE editor -> find corresponding .dsl
		
//		 IFile dslFile = ResourceUtil.getFile(editor.getEditorInput());
//		 Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
//			
//		if(shell != null && dslFile != null) {
//			RunModelAction.launch(shell, dslFile);
//		}
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	///    LAUNCH CONFIGURATIONS-RELATED UTILITY FUNCTIONS ////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private static ILaunchConfiguration createLaunchConfiguration(String baseConfigurationName, IAleEnvironment conf, IResource model) throws CoreException {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
        ILaunchConfigurationType type = manager.getLaunchConfigurationType(AleLaunchConfiguration.ID);
        ILaunchConfiguration[] configurations = manager.getLaunchConfigurations(type);

        String launchConfigurationName = availableLaunchConfigurationName(baseConfigurationName, configurations);
        
        ILaunchConfigurationWorkingCopy workingCopy = type.newInstance(null, launchConfigurationName);        
        workingCopy.setAttribute(METAMODELS_PATH, String.join(",", conf.getMetamodels()));
        workingCopy.setAttribute(BEHAVIORS_PATH, String.join(",", conf.getBehaviors()));
        workingCopy.setAttribute(MODEL_FILE, model.getFullPath().toPortableString());
        
        return workingCopy.doSave();
	}
	
	/**
	 * Computes a launch configuration name that is not used by any existing configuration.
	 * 
	 * @param baseConfigurationName
	 *			The name that serves as a base to compute the name of the new launch configuration
	 * @param configurations
	 * 			The existing launch configurations to ensure that the computed name is unique
	 * 
	 * @return a unique name based on given base name and that is not used by any existing launch configuration
	 */
	private static String availableLaunchConfigurationName(String baseConfigurationName, ILaunchConfiguration[] configurations) {
		String launchConfigurationName = baseConfigurationName;
		int index = 0;
		
		while (configurationExists(configurations, launchConfigurationName)) {
			++index;
			launchConfigurationName = baseConfigurationName + " (" + index + ")";
			
			preventInfiniteLoop(index);
		}
		return launchConfigurationName;
	}
	
	/**
	 * Returns whether a launch configuration with the given name already exists.
	 * 
	 * @param configurations
	 * 			The launch configurations to check
	 * @param name
	 * 			The name to validate
	 * 
	 * @return whether a launch configuration with the given name already exists
	 */
	private static boolean configurationExists(ILaunchConfiguration[] configurations, String name) {
		for (ILaunchConfiguration launchConfiguration : configurations) {
			if (launchConfiguration.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	private static void preventInfiniteLoop(int loopIndex) {
		boolean overflowed = loopIndex < 0;
		if (overflowed) {
			// Unlikely, but better than keeping the possibility to freeze the whole IDE
			throw new IndexOutOfBoundsException("Unable to create a new configuration: there are already " + Integer.MAX_VALUE + " of them");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	///    RESOURCE-RELATED UTILITY FUNCTIONS /////////////////////////////////////////////////////////////////////
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private static IResource toResource(ISelection selection) {
		Object selectedElement = ((IStructuredSelection) selection).getFirstElement();
		try {
			if (selectedElement instanceof IJavaProject) {
				IJavaProject javaProject = (IJavaProject) selectedElement;
				return javaProject.getCorrespondingResource();
			}
		}
		catch (NoClassDefFoundError e) {
			// Can happen because dependencies to JDT are optional (one might want to use ALE without Java)
			// If this error is thrown we can safely consider that the selection is not a Java project and
			// thus continue with the default behavior.
		} catch (JavaModelException e) {
			// Should not happen
			throw new RuntimeException("Unable to get the IResource corresponding to the Java project", e);
		}
		return (IResource) selectedElement;
	}
	
	/**
	 * Opens a selection dialog asking the user to select the XMI model to interpret.
	 */
	protected static Optional<IResource> askUserToSelectAnXmiModel(IResource dslFile) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		FilteredResourcesSelectionDialog dialog = new FilteredResourcesSelectionDialog(
				shell, 
				false,
				ResourcesPlugin.getWorkspace().getRoot(),
				IResource.FILE
		);
		dialog.setTitle("Select the model to execute");
		dialog.setInitialPattern("*.xmi");

		// If possible, select by default a .xmi file next to the .dsl file
		// NOTE: works on Eclipse >= 4.14 only, see the following tracker:
		//       https://bugs.eclipse.org/bugs/show_bug.cgi?id=214491
		Optional<IResource> siblingXmi = findSiblingXmi(dslFile);
		siblingXmi.ifPresent(dialog::setInitialSelections);

		dialog.open();
		Object[] selected = dialog.getResult();
		
		if (selected != null && selected.length == 1 && selected[0] instanceof IResource) {
			return Optional.of((IResource) selected[0]);
		}
		else {
			return Optional.empty();
		}
	}

	/** 
	 * Finds an XMI file located next to the given resource. 
	 */
	private static Optional<IResource> findSiblingXmi(IResource dslFile) {
		Stream<IResource> siblings;
		try {
			siblings = Arrays.stream(dslFile.getParent().members());
		} 
		catch (CoreException | NullPointerException e) {
			// For some reason we cannot check .dsl file's siblings.
			// Never mind, we don't want to bother the user with that.
			return Optional.empty();
		}
		return siblings.filter(isXMI()).findAny();
	}

	private static Predicate<? super IResource> isXMI() {
		return sibling -> "xmi".equalsIgnoreCase(sibling.getFileExtension());
	}

}
