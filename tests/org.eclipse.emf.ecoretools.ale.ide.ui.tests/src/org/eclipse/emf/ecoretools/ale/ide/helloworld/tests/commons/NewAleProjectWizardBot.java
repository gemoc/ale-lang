/*******************************************************************************
 * Copyright (c) 2019 Inria and Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Inria - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.ecoretools.ale.ide.helloworld.tests.commons;

import static org.eclipse.emf.ecoretools.ale.ide.ui.wizards.NewAleProjectConfigurationWizardPage.CREATE_ECORE_MODEL_BUTTON_ID;
import static org.eclipse.emf.ecoretools.ale.ide.ui.wizards.NewAleProjectConfigurationWizardPage.ECORE_PACKAGE_NAME_TEXT_ID;
import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses;
import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellIsActive;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.exceptions.WidgetNotFoundException;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;

/**
 * Bot aimed at easing creation of new ALE projects during UI tests. 
 */
// TODO Make API fluent to prevent inconsistent order of method calls
public class NewAleProjectWizardBot {
	
	private final SWTWorkbenchBot bot;
	
	private SWTBotShell wizard;

	/**
	 * Instantiates a new bot aimed at easing the creation of new ALE projects.
	 * 
	 * @param bot
	 *			A valid bot capable of manipulating Eclipse's workbench 
	 */
	public NewAleProjectWizardBot(SWTWorkbenchBot bot) {
		this.bot = bot;
	}
	
	/**
	 * Opens the wizard, sets the name of the project then goes to the second page.
	 * 
	 * @param projectName
	 * 			The name of the project
	 */
	public void open(String projectName) {
		bot.menu("File")
		   .menu("New")
		   .menu("Project...")
		   .click();
		wizard = bot.shell("New Project");
        wizard.activate();
        bot.tree()
           .expandNode("ALE")
           .select("ALE Project");
        bot.button("Next >").click();
        bot.textWithLabel("Project name:").setText(projectName);
        bot.button("Next >").click();
        
        // Ensure the wizard is open & visible before moving on
        bot.waitUntil(shellIsActive("ALE Project Wizard"));
	}
	
	/**
	 * Selects the 'create new Ecore model' option.
	 * 
	 * @param packageName
	 * 			The name of the new model to create
	 * 
	 * @throws WidgetNotFoundException if the node was not found
	 */
	public void createNewEcoreModel(String packageName) {
		bot.radioWithId(CREATE_ECORE_MODEL_BUTTON_ID).click();
		bot.textWithId(ECORE_PACKAGE_NAME_TEXT_ID).setText(packageName);
	}
	
	public boolean canFinish() {
		return bot.button("Finish").isEnabled();
	}
	
	public void finish() {
		if (! canFinish()) {
			throw new IllegalStateException("The New ALE Project wizard has been asked to finish but the 'Finish' button is disabled");
		}
        bot.button("Finish").click();

        // Ensure the project is fully created before moving on
        bot.waitUntil(shellCloses(wizard));
	}

}