# Object Algebra Generator
## Introduction
This plugin allow a developer to derive an Object Algebra Java 8 interface from an ecore model.
## TODO
  - adding the export of <<packageName>>.algebra on the exported package in the MANIFEST.
  - manage to keep the abstract type parameters letters sequentials. If some sub-part of the inheritance structure is only composed of abstract classes, a letter is still generated but thrown off afterwards in the process. (e.g. A, B, C, ??missing??, E, F, G...) 
