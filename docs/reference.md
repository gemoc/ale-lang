---
title: Reference
order: 4
---

Reference documentation

Detail each feature



DSL file
========

It is a 'classpath' for language to define the location elements such as Ecore metamodels & behavior files.

It is a standard Java properties file with special key/values:
 * syntax=path/to/model.ecore,path/to/model2.ecore
 * behavior=path/to/some.implem,path/to/another.implem

Behavior file
=============

It defines a set of class extensions & runtime classes and has an identifier.

```
behavior some.unique.identifier

open class FSM {
	override exec() {
		//Do stuff
	}
}

class Variables {
	//Store values here
}
```

EClass extension
================

Reopen an existing EClass to add new attributes & operation

## Attribute declaration

```
open class Square {
	int newAttribute; 
}
```

## EOperation implementation

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

## Method declaration

```
open class Circle {
	def void reduce(double arg){
		self.radius := self.radius - arg;
	}
}
```

## Inherit EClass extension

Redefine an operation from another behavior file

```
behavior fsm.composite.executable;

import fsm.executable as simplefsm;

open class CompositeState extends simplefsm.State {
	override void exec() {
		//Redefine the behavior here
	}
}
```

Runtime EClass
==============

Declare an EClass specific to the runtime.
It only exists during the execution.

```
class Context {

}
```

Statements
==========

## Variable declaration

```
int localVar;
```

## Variable assignment

```
localVar := 3;
```

## Attribute assignment

```
self.myAttrib := "newVal";
```

## If

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

## ForEach

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

## While

```
While(isRaining){
	'cats!'.log();
}
```

## 0..* insertion

```
self.elements.add(newElem);
```

## 0..* remove

```
self.elements.remove(oldElem);
```

## Println

```
eObject.log();
'some string'.log();
```

## Create EClass instance

```
MyClass newCls := MyPackage::MyClass.create();
```

## Self

```
self.myAttribute;
self.operation();
```

## Result

```
result := someValue;
```

## Super (not implemented yet)

Misc
====

## External Java Service

```
use qualified.name.MyService;
```
