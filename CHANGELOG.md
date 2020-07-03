# Changelog
All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/).

## [Unreleased]
### Fixed
- [#4](https://github.com/gemoc/ale-lang/issues/4) The .dsl configuration file and the .ale source file must have the same base name
- [#28](https://github.com/gemoc/ale-lang/issues/28) The interpreter ignores references to non-existing attributes or variables and calls to non-existing methods
- [#38](https://github.com/gemoc/ale-lang/issues/38) The interpreter is not interrupted when an unexpected error occurs
- [#39](https://github.com/gemoc/ale-lang/issues/39) Sirius' _Behavior_ layer does not show dynamic information when _.ale_ source files and the Ecore metamodel are located in different projects
- [#51](https://github.com/gemoc/ale-lang/issues/51) Pure ALE classes are not handled by the type checker
- [#64](https://github.com/gemoc/ale-lang/issues/64) `null` cannot be assigned to variables
- [#67](https://github.com/gemoc/ale-lang/issues/67) `Sequence` values can be assigned to variables which type is `OrderedSet` and vice versa
- [#70](https://github.com/gemoc/ale-lang/issues/70) Paths to ALE resources (in _.dsl_ files and projects' preferences) are not updated when the project is renamed
- [#102](https://github.com/gemoc/ale-lang/issues/102) The editor shows an error when a method is used to define the range of a for-each loop
- [#119](https://github.com/gemoc/ale-lang/issues/119) Cannot override static EOperations from a subclass
- [#120](https://github.com/gemoc/ale-lang/issues/120) The `+=` operator cannot be used to concatenate two collections
- [#126](https://github.com/gemoc/ale-lang/issues/126) The interpreter evaluates an expression even if a subexpression produces an error
- [#128](https://github.com/gemoc/ale-lang/issues/128) The interpreter allows to concatenate heterogeneous collections
- [#149](https://github.com/gemoc/ale-lang/issues/149) Xtext validators are not resilient
- [#151](https://github.com/gemoc/ale-lang/issues/151) Every EPackage found in project's dependencies is added to the environment
- [#159](https://github.com/gemoc/ale-lang/issues/159) The editor shows all validation errors, even the ones that come from other ALE files

### Added
- [#60](https://github.com/gemoc/ale-lang/issues/60) An ALE Run Configuration is created when launching ALE through the contextual menu shortcut
- [#86](https://github.com/gemoc/ale-lang/issues/86) The XMI model and the ALE entry point to execute are prompted when they can't be automatically inferred while launching the interpreter
- [#86](https://github.com/gemoc/ale-lang/issues/86) The XMI model and the ALE entry point to execute can be set from the *Launch Configuration Tab*
- [#92](https://github.com/gemoc/ale-lang/issues/92) The editor autocompletes attributes and methods of `self`
- [#94](https://github.com/gemoc/ale-lang/issues/94) The editor automatically switches to dark colors when Eclipse IDE is in dark theme
- [#98](https://github.com/gemoc/ale-lang/issues/98) The _New ALE Project_ wizard can be used to create ALE projects
- [#110](https://github.com/gemoc/ale-lang/issues/110) The title of the ALE console is updated as the execution progresses
- [#115](https://github.com/gemoc/ale-lang/pull/115) Multiple _.ale_ source files can be taken into account when executing an ALE program
- [#115](https://github.com/gemoc/ale-lang/pull/115) The ALE environment (the _.ale_ source files and the _.ecore_ metamodels) can now be stored in the project's preferences, allowing to get rid of the _.dsl_ configuration file **[breaking change]**
- [#115](https://github.com/gemoc/ale-lang/pull/115) The interpreter can be run by right-clicking on an ALE project
- [#129](https://github.com/gemoc/ale-lang/pull/129) The editor warns when the `+=` and `-=` operators ared used on the `result` variable in a void method
- [#131](https://github.com/gemoc/ale-lang/pull/131) The editor autocompletes attributes and methods of local variables and method parameters (support limited to model instances)
- [#169](https://github.com/gemoc/ale-lang/pull/169) The editor shows documentation about the _open_ and _behavior_ keywords on hover

### Changed
- [#93](https://github.com/gemoc/ale-lang/issues/93) More tokens are available to tailor editor's syntax coloring
- [#94](https://github.com/gemoc/ale-lang/issues/94) The editor's dark theme has better colors
- [#89](https://github.com/gemoc/ale-lang/pull/89) The bare `List<ParseResult>` objects are abstracted as `DslSemantics` instances **[breaking change]**
- [#115](https://github.com/gemoc/ale-lang/pull/115) The _.ale_ source files are generated in the `src-ale/` directory
- [#115](https://github.com/gemoc/ale-lang/pull/115) The _.dsl_ configuration file is generated at the root of the project
- [#124](https://github.com/gemoc/ale-lang/pull/124) The errors shown in the ALE console are now clean, red stacktraces with hyperlinks to source files
- [#136](https://github.com/gemoc/ale-lang/pull/136) The public API is easier to use **[breaking change]**
- [#141](https://github.com/gemoc/ale-lang/issues/141) Move to ANTLR 4.7.1

## [] - 2019-12-08
### Changed
- [#26](https://github.com/gemoc/ale-lang/issues/26) Use `ecore` and `ale` keys instead of `syntax` and `semantics` in *.dsl* files **[breaking change]**
- [#56](https://github.com/gemoc/ale-lang/issues/56) The interpreter now affects a default value to variables declared without an initial one

### Fixed
- [#3](https://github.com/gemoc/ale-lang/issues/3) The editor shows errors when a parameter of type Sequence is used in a method
- [#10](https://github.com/gemoc/ale-lang/issues/10) The editor shows an error when a Sequence instance is used to defined the range of a for-each loop
- [#20](https://github.com/gemoc/ale-lang/issues/20) The interpreter cannot resolve methods taking a Sequence as parameter
- [#56](https://github.com/gemoc/ale-lang/issues/56) The interpreter crashes when a variable is declared without any initial value
- [#88](https://github.com/gemoc/ale-lang/pull/88) The *logo.standalone* example project does not compile anymore

## [1.0.0.201911261613] - 2019-11-26
### Added
- [#81](https://github.com/gemoc/ale-lang/pull/81) The editor shows an error when variables of incompatible types are used as operands of the `+=` and `-=` operators
- [#81](https://github.com/gemoc/ale-lang/pull/81) The editor shows an error when a variable declared within a for-each loop is used where its type is forbidden
- [#81](https://github.com/gemoc/ale-lang/pull/81) The editor shows an error when `result` is assigned a value which type is incompatible with method's return type
- The `Dsl` class now exposes all the key/value mappings defined in the underlying *.dsl* configuration file

## [1.0.0.201911131044] - 2019-11-13
### Added
- [#83](https://github.com/gemoc/ale-lang/pull/83) A new `ALEDynamicExpressionEvaluator` aimed at easing interpretation of single string expressions in a standalone environment

## [1.0.0.201911121022] - 2019-11-12
### Added
- Xtext-based editor
- Interpreter (executable from .dsl)
- Java API to execute the interpreter