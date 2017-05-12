---
title: Reference
order: 4
---

Reference documentation
=======================

This page covers all aspects of ALE and provides documentation for each feature

---------------------------------------------------------------------

DSL file
========

This file descibes a Domain Specific Language made executable with ALE.

It defines a scope containing all declared elements of a DSL, which are the abstract syntax files (.ecore files) and the semantic files (.ale files) <br>
It is mainly used for the execution and the validation (type checking, name conflicts...).

It uses the file extension *dsl*. <br>
It is a standard Java properties file (i.e a textual file where each line follows the syntax <key>=<value>)

We use the special keys:
 * syntax = Comma separated list of paths to .ecore files.
 * behavior = Comma separated list of paths to .ale files.


Examples:

*logo-standalone.dsl*

```
syntax=../logo.model/model/ASMLogo.ecore,../logo.model/model/VMLogo.ecore
behavior=../logo.example/data/LogoProgram.ale
```

We also suport Eclipse Platform URL that ease the location of files within a workspace.
It follows the syntax : platform:/resource/\<project\>/\<path to file.ale\>

*logo.dsl*

```
syntax=platform:/resource/logo.model/model/ASMLogo.ecore,platform:/resource/logo.model/model/VMLogo.ecore
behavior=platform:/resource/logo.example/data/LogoProgram.ale
```

---------------------------------------------------------------------

Behavior file
=============

This file defines a DSL implementation.

It allows to re-open EClass from the abstract syntax to mainly implements existing EOperations but also declare new ones, new features and even new classes specific to the runtime.

It uses the file extension *ale*. <br>
The file must start with `behavior <unique identifier>`. <br>

Example:

```
behavior fsm.implementation;

open class FSM {
	override void exec() {
		//Do stuff
	}
}

class Variables {
	//Store values here
}
```

---------------------------------------------------------------------

Open Class
----------

Re-open an existing EClass to add new elements and implement existing EOperations.

This allows to split abstract syntax & semantics concerns by weaving new features and implementations on EClasses. The original Ecore files remains unmodified but thanks to the ALE interpreter news elements can be used in the  execution of the implemented operations.

An .ale file can declare only one `open class` per EClass.

It follows the syntax:
`open class <EClass> {`

`}`

## Feature declaration

Add a new feature within an EClass.

The new feature should be runtime specific, such as adding a currentState inside a Finite State Machine.

We infer an attribute if the declared type is a primitive type (such as int, String...), otherwise we infer a reference.

It is declared at the beginning the body of `open class` or `class`.

It follows the syntax `<Type name> <Feature name> := <AQL expression>;`

Examples:

```
open class FSM {
	State currentState; 
}
```

```
class Request {
	int timeout := 100;
	String data; // the initial value is optional
}
```

### EOperation implementation

Define a behavior for an existing EOperation.

It is always declared inside an `open class` and has the same signature as an existing EOperation from the weaved EClass (or one of its super types).

It follows the syntax :


`override <type> <EOperation name> ( <type> <parameter name> ) {`

   `<Statements>*`

`}`


Example:

```
open class Circle {
	override int getSize(){
		// The value of the special variable 'result'
		// is returned at the end of the body
		double PI := 3.14159;		
		result:= self.radius * PI * 2;
	} 
}
```

### Method declaration

Define an new operation within an EClass.

It is not part of the abstract syntax but still allows you to split your code in a reusable way.

It is declared inside the body of an `open class` or a `class` and its signature must not match an existing EOperation from the weaved EClass (or one of its super types).

It follows the syntax :

`def <type> <Operation name> ( <type> <parameter name> ) {`

`	<Statements>`

`}`

Example:

```
open class State {
	def String fullName() {
		result := self.fsm.name + '.' self.name;
	}
}
```

### Inherit Open Class

Declare an Open Class extending existing Open Class(es).

When writing an Open Class you may want to specialize one (or more) existing Open Class.
The new Open Class reuse all the inherited content, declare new features/operations and refines body of inherited operations.

The extended Open Class have to be weaved on the same EClass (or super type) of the current Open Class.

It follows the syntax:

`open class <EClass> extends <Open Class ID>, <Open Class ID> {`

`}`


Example:

The `<Open Class ID>` can be another reopened EClass from the same file.

```
open class State {
	override String execute() {
		result := 'State ' + self.name;
	}
}

open class Initial extends State {
	override String execute() {
		result := 'Initial State ' + self.name;
	}
}
```

The `<Open Class ID>` can be a qualified name of a reopened EClass from another file.<br>
To do so, you have to import it at the beginning of the behavior file by following the syntax:
`import <Behavior identifier> as <Alias>`

```
behavior fsm.composite.executable;

import fsm.executable as simplefsm;

open class CompositeState extends simplefsm.State {
	override void exec() {
		//Redefine the behavior here
	}
}
```

---------------------------------------------------------------------

Runtime EClass
--------------

Declare an EClass specific to the runtime.

You may want to define Runtime data that are not part of an existing EClass of the abstract syntax, but useful for the execution.

It follows the syntax:

`class <Name> {`

`}`


You can declare new features and operations as in the body of `open class` but of course `override` operations are not allowed.

Example:

```
class Context {
	int counter := 0;
	
	def void increment() {
		self.counter := self.counter + 1;
	}
}
```

---------------------------------------------------------------------

Statements
----------

### Variable declaration

```
int localVar;
```

### Variable assignment

```
localVar := 3;
```

### Attribute assignment

```
self.myAttrib := "newVal";
```

### If

```
if(isRainning){
	self.getFluffyUmbrella();
}
```

```
if(i < 3) {
	//Do something
}
else {
	//Don't do something
}
```

### ForEach

```
for(elem in collection){
	elem.log(); //Print elem in the standard output
}
```

```
for(i in [1..5]){
	fact := fact * i;
}
```

### While

```
While(isRaining){
	'cats!'.log();
}
```

### 0..* insertion

```
self.elements.add(newElem);
```

### 0..* remove

```
self.elements.remove(oldElem);
```

### Println

```
eObject.log();
'some string'.log();
```

### Create EClass instance

```
MyClass newCls := MyPackage::MyClass.create();
```

### Self

```
self.myAttribute;
self.operation();
```

### Result

```
result := someValue;
```

### Super (not implemented yet)

---------------------------------------------------------------------

Misc
----

### External Java Service

```
use qualified.name.MyService;
```
