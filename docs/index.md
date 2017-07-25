---
title: Home
order: 0
---

Action Language for EMF
=======================

ALE is a language to make Ecore metamodels executable.
Concretely, ALE allows to "re-open" the EClasses from Ecore metamodels to implement existing EOperations and weave new features or new operations.

Main features of ALE include:
 * Executable metamodeling: Re-open existing EClasses to insert new methods with their implementations
 * Metamodel extension: The very same mechanism can be used to extend existing Ecore metamodels and insert new features (eg. attributes) in a non-intrusive way
 * Interpreted: No need to deploy Eclipse plugins, just run the behavior on a model directly in your modeling environment
 * Extensible: If ALE doesn't fit your needs, register Java classes as services and invoke them inside your implementations of EOperations.

Breathe life into your metamodels!
===============================

ALE make it easy to address a wide range of activities related to model elements manipulation. This includes activities such as:
 * weaving operational semantics in metamodel definitions
 * defining model checkers
 * defining model-to-model transformations
 * defining model-to-text transformations


Open-class mechanism
====================

```
behavior fsm.dummy.implementation;

open class FSM {

	State currentState;
	String currentEvent;

	override void execute(EList<String> events) {
		'Start'.log();
		self.currentState := self.initialState;
		for(event in events) {
			self.currentState.execute();
			self.currentState := 
				self.currentState.transitions
					->select(t | t.event = self.currentEvent)
					->first();
		}
		'End'.log();
	}

}
```

