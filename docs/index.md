EClass extension
================

## Attribute declaration

```
class Square {
	int newAttribute; 
}
```

## EOperation implementation

```
class Circle {
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
class Circle {
	def void reduce(double arg){
		self.radius := self.radius - arg;
	}
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

