# ALE Architecture <!-- omit in toc -->

- [Overview](#overview)
- [Event flow](#event-flow)

## Overview

This folder defines ALE's source plug-ins. Here is an overview of their purposes.

Bundle | Purpose
------ | -------
`org.eclipse.emf.ecoretools.ale` | Provides ALE's public API.
`org.eclipse.emf.ecoretools.ale.core` | Defines ALE's parsers and interpreter.
`org.eclipse.emf.ecoretools.ale.examples` | Provides Eclipse wizards to create example projects.
`org.eclipse.emf.ecoretools.ale.ide` | Integrates ALE within Eclipse IDE.
`org.eclipse.emf.ecoretools.ale.ide.ui` | Integrates ALE within Eclipse IDE's UI.
`org.eclipse.emf.ecoretools.ale.xtext` | Defines an xText grammar to provide a tailored ALE text editor.
`org.eclipse.emf.ecoretools.ale.xtext.ide` | (Generated) Provides services for the xText grammar.
`org.eclipse.emf.ecoretools.ale.xtext.ui` | (Generated) Integrates the xText grammar within Eclipse IDE's UI.

## Event flow

Here is an introduction to how ALE works.

> **TODO**: Insert a sequence diagram to make the flow clearer

1. An ALE script can be interpeted through an Eclipse [Launch Configuration](https://www.vogella.com/tutorials/EclipseLauncherFramework/article.html). This Launch Configuration executes ALE in a [background Job](https://www.vogella.com/tutorials/EclipseJobs/article.html).
   - See [AleLaunchConfigurationDelegate](org.eclipse.emf.ecoretools.ale.ide.ui/src/org/eclipse/emf/ecoretools/ale/ide/ui/launchconfig/AleLaunchConfigurationDelegate.java) for the definition of the Launch Configuration
2. The Launch Configuration uses an instance of [ALEInterpreter](org.eclipse.emf.ecoretools.ale\src\org\eclipse\emf\ecoretools\ale/ALEInterpreter.java) to start the execution of the script
3. A [DslBuilder](org.eclipse.emf.ecoretools.ale.core\src\org\eclipse\emf\ecoretools\ale\core\parser/DslBuilder.java) is used to dynamically load the Ecore metamodel(s) to execute.
4. An [AstBuilder](org.eclipse.emf.ecoretools.ale.core\src\org\eclipse\emf\ecoretools\ale\core\parser/AstBuilder.java) is used to parse the ALE script(s) and create a corresponding model (i.e. an objet representing the script's statements).
    - _Note_: ALE is parsed with ANTLR. The reason why we don't rely on xText's parser is because ALE internally uses [AQL](https://www.eclipse.org/acceleo/documentation/) to evaluate statements. AQL is parsed thanks to ANTLR so using xText would force us to re-write an AQL interpreter.
5. Once both the syntaxes (i.e. the metamodels) and the semantics (i.e. the ALE scripts) are gathered, the entry point (the method annotated with `@main`) is determined and given to an [ALEEngine](org.eclipse.emf.ecoretools.ale.core\src\org\eclipse\emf\ecoretools\ale\core\interpreter/ALEEngine.java).
6. This ALEEngine uses a [MethodEvaluator](org.eclipse.emf.ecoretools.ale.core\src\org\eclipse\emf\ecoretools\ale\core\interpreter/MethodEvaluator.java) to actually interpret the different statements and to produce a result.
