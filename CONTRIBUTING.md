# How to contribute <!-- omit in toc -->

- [What can I do?](#what-can-i-do)
- [How is the plug-in architected?](#how-is-the-plug-in-architected)
- [How do I make changes?](#how-do-i-make-changes)
  - [Which IDE should I use?](#which-ide-should-i-use)
  - [How do I open the projects in Eclipse IDE?](#how-do-i-open-the-projects-in-eclipse-ide)
  - [How do I create a new plug-in?](#how-do-i-create-a-new-plug-in)
  - [How do I create tests for a new plug-in?](#how-do-i-create-tests-for-a-new-plug-in)
- [How can I check that my changes are consistent with the codebase?](#how-can-i-check-that-my-changes-are-consistent-with-the-codebase)
- [How can I check that the tests still pass?](#how-can-i-check-that-the-tests-still-pass)
- [How can I manually test the plug-in?](#how-can-i-manually-test-the-plug-in)

## What can I do?

If you want to contribute by writing code, feel free to pick an open issue or submit a new feature.

Otherwise, you can create an issue to report a bug, ask for a new feature or for more documentation. This is appreciated too!

> **Note**: if you want to solve an open issue, please leave a comment on the corresponding thread so that we know that someone is working on it.

## How is the plug-in architected?

ALE is made of several Eclipse bundles. Each bundle is implemented as an Eclipse project and is available in the `plugins/` directory.

Please see [plugins/README.md](plugins/README.md) for further details.

## How do I make changes?

### Which IDE should I use?

The [Eclipse IDE for Java and DSL developers](https://www.eclipse.org/downloads/packages/) is the preferred IDE to develop Eclipse plug-ins.

### How do I open the projects in Eclipse IDE?

The projects can be imported from Eclipse IDE:

1. `File` > `Import...`
2. `Existing Projects into Workspace`
3. Type to the path of the `plugins/` directory in the `Select root directory` field
4. Check all projects
5. `Finish`

Wait for all the projects to be imported. Depending on the Eclipse package you are using many errors may come up: some projects' dependencies may be missing. To solve this, we have to tell Eclipse IDE to use a specific environment. Our development environment is specified through a [target platform](https://www.vogella.com/tutorials/EclipseTargetPlatform/article.html). This target platform is located within the `releng/` directory; to use it:

1. `File` > `Import...`
2. `Existing Projects into Workspace`
3. Type to the path of the `releng` directory in the `Select root directory` field
4. Check only the `org.eclipse.emf.ecoretools.ale.target-platform` project if you are working on Linux, or `org.eclipse.emf.ecoretools.ale.target-platform.win32` if you are working on Windows
5. `Finish`
6. Open the `org.eclipse.emf.ecoretools.ale.target-platform(.win32).target` file
7. On the top-right corner of the editor, click on _Set as Active Target Platform_.

Eclipse IDE starts downloading all the dependencies, which may take some time. The process can be followed thanks to the _Progress_ view.

If the compilation errors do not disappear even after the target platform is set, a full rebuild should fix the issue:
1. `Project` > `Clean...`
2. Check `Clean all projects`
3. Click on `Click`

> **Note**: in some rare cases errors still remain. In such a case, opening the `org.eclipse.emf.ecoretools.ale.target-platform(.win32).target` file and clicking on _Reload target platform_ or restarting Eclipse IDE should definitely fix them.

### How do I create a new plug-in?

A source plug-in should be created in the `plugins/` directory. A new plug-in project can be created as follows:

1. `File` > `New` > `Other...`
2. Select `Plug-in Project`
3. Type the name of the plug-in and change its default location
4. Click `Finish`

> **Caution**: do not forget to add the corresponding module in the `plugins/pom.xml` file, otherwise the plug-in will be ignored by Maven.

### How do I create tests for a new plug-in?

Tests are hosted in _fragments_ located under the `tests/` directory. By convention, a fragment's name is the name of the tested plug-in suffixed with `.tests`. A new fragment project can be created as follows:

1. `File` > `New` > `Other...`
2. Select `Fragment Project`
3. Type the name of the fragment and change its default location
4. Click `Next` then select the host plug-in (the one that contains the code to test)
4. Click `Finish`

In order to include the tests in Maven build, the following steps are required:
1. Add the corresponding module to the `tests/pom.xml` file

Please take a look at existing tests and make yours consistent.

## How can I check that my changes are consistent with the codebase?

You can check the code with the following command:
```
mvn clean verify
```

It checks that:
 - the code compiles
 - all the tests pass

> **Boy Scout Rule**: Leave your code better than you found it!

## How can I check that the tests still pass?

Tests can be run from Maven with the following command:
```
mvn clean verify
```

Alternatively, tests can be run from Eclipse:
1. Right-click on a test project or a test class
2. `Run As` > `JUnit Plug-in Test`

A new Eclipse window should open during the time of the tests, before closing automatically.

## How can I manually test the plug-in?

Manual tests are still useful for prototyping, especially since UI tests are not implemented yet.

To open a new Eclipse IDE instance that uses the plug-in under development:

1. Right-click on a project
2. `Run As` > `Eclipse application`

A new Eclipse IDE window should open, in which new projects can be created for testing purposes.