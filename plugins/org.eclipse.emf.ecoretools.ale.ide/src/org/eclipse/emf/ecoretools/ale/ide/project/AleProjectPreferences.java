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
package org.eclipse.emf.ecoretools.ale.ide.project;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;

/**
 * Project-scope, ALE-related {@link IEclipsePreferences preferences}.
 * <p>
 * These preferences are notably used to store ALE's environment.
 */
public enum AleProjectPreferences {
    /** 
     * Whether ALE's path is computed from a .dsl file (otherwise it relies on project's preferences). 
     */
    CONFIGURED_FROM_DSL_FILE("CONFIGURED_FROM_DSL_FILE"),
    /** 
     * The path to the .dsl configuring ALE's environment. 
     */
    DSL_FILE_PATH("DSL_FILE_PATH"),
    /** 
     * The paths to the .ale files defining the behavior. 
     */
    ALE_SOURCE_FILES("ALE_SOURCE_FILES"),
    /** 
     * The paths to the .ecore files defining the metamodel. 
     */
    ECORE_MODEL_FILES("ECORE_MODEL_FILES");
    
    private static final Map<String, AleProjectPreferences> propertyToPreference = new HashMap<>();

    static {
        for (AleProjectPreferences setting : AleProjectPreferences.values()) {
            propertyToPreference.put(setting.property, setting);
        }
    }
    
    /** A key identifying the setting. */
    private final String property;
    
    private AleProjectPreferences(String property) {
        this.property = property;
    }
    
    /**
     * Returns a unique string identifying the setting.
     * @return a unique string identifying the setting
     */
    public String property() {
        return property;
    }
    
    /**
     * Returns the setting identified by the given property.
     * 
     * @param property
     *          The property to turn into a setting.
     * 
     * @return the setting corresponding to the given key, or null if no one match 
     */
    public static AleProjectPreferences fromProperty(String property) {
        return propertyToPreference.get(property);
    }

}
