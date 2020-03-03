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
package org.eclipse.emf.ecoretools.ale.ide.ui.preferences;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.dialogs.PropertyPage;

/**
 * Abstract property page providing new services to sub-classes.
 */
abstract class AbstractPropertyPage extends PropertyPage {
    
    /** The project which properties are shown by this page. */
    protected IProject project;
    
    /**
     * Sets {@link #project} to the value of the current project.
     * 
     * @return {@code true} if the current project has been resolved successfully,
     *            {@code false} otherwise.
     */
    protected boolean resolveCurrentProject() {
        final IAdaptable adaptable = getElement();
        
        if (adaptable == null) {
            return false;
        }
        project = adaptable.getAdapter(IProject.class);
        return project != null;
    }
    
    protected static void addSeparator(Composite parent, int numColumns) {
        Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
        GridData gridData = new GridData();
        gridData.horizontalAlignment = GridData.FILL;
        gridData.grabExcessHorizontalSpace = true;
        gridData.horizontalSpan = numColumns;
        separator.setLayoutData(gridData);
    }

}