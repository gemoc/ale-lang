First draft of an interpreter to evaluate EOperation implementation in AQL
---


The entry point is **interpreter.Interpreter.main()** [in the 'interpreter' project :) ]

This POC evaluate this AQL expression :
"self.name + ' : ' + `self.eClass().name + '\nService : ' + self.foobar()"`

**self** refer to the first element of **model.xmi**

**foobar()** is defined in **dummy.ecore** and implemented in **implem.xmi**
