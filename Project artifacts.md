# Project artifacts

## User defined

- syntaxes
- semantics
- dsl definitions

## Derived

- **project:** abstract-algebra-%semantic\_package\_name%
  - **package:** %semantic\_package\_name%.algebra.abstr.%semantic\_package\_name.firstUpper%Algebra.java
- **project:** syntax-%behavior\_name%
  - Generation of a ecore with %behavior\_name% package name and the classes + source generation
- **project:** algebra-%semantic\_package\_name%-%behavior\_name%
  - **package:** %semantic\_package\_name%.algebra.%behavior\_name%.impl.%semantic\_package\_name.firstUpper%%behavior_name.firstUpper%Algebra.java