---
title: Tutorial
order: 3
---

MiniFSM tutorial


In this tutorial you will learn how to make an executable language from scratch.

1. We will start by creating a Finite State Machine metamodel with EMF
2. We will then write a simple interpreter in ALE

Metamodel
=========

In this section we will create the abstract syntax of our language as an Ecore model.

Finite State Machine
--------------------

First of all, we need to define the domain of our language. 

So what is a FSM?

[Wikipedia’s definition](https://en.wikipedia.org/wiki/Finite-state_machine):
>is a mathematical model of computation. It is an abstract machine that can be in exactly one of a finite number of states at any given time. The FSM can change from one state to another in response to some external inputs; the change from one state to another is called a transition. A FSM is defined by a list of its states, its initial state, and the conditions for each transition.

![FSM sample](https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Turnstile_state_machine_colored.svg/330px-Turnstile_state_machine_colored.svg.png)

Create Ecore model
------------------

1. `File > New > Project...`<br>
   `Eclipse Modeling Framework > Empty EMF Project > Next`
2. Fill `Project name` with 'minifsm' and `Finish`
3. Right-click on the `model folder` and select `New > Others...`<br>
   Select `Eclipse Modeling Framework > Ecore model`, then `Next`
4. Name it 'minifsm.ecore' and click `Finish`

Fill the metamodel
------------------

### Create a .aird file

1. Right click on minifsm.ecore and select `Initialize Ecore Diagram ...`
2. Click `Next >`
3. `Entities in a Class Diagram` is already selected, click `Next >`
4. Select the root EPackage and click `Finish`

### Name the root EPackage
1. Open the Properties view (Menu `Show View > Other... > General > Properties`)
2. Fill `Name` with 'minifsm'
3. Fill `Ns URI` with 'http://minifsm'
4. Fille `Ns Prefix` with 'minifsm'

### Create EClasses
1. Select `Classifier > Class` and create with a simple click:
 * FSM
 * State
 * InitialState
 * Transition

### Create Relations
1. Select `Relation > Super Type`
2. Select the `InitialState` class
3. Select the `State` class to end the relation creation

In similare way with `Relation > Composition` create 
 * FSM -> State (name it 'states')
 * FSM -> Transition (name it 'transitions')

End with `Relation > Reference` create
 * Transition -> State (name it 'incoming')
 * Transition -> State (name it 'outgoing')

### Create Attributes
1. Select `Feature > Attribute`
2. Click on `State` to create the new feature
3. In the `Propeties` view fill `Name` with 'name'
4. For the `EType` select 'EString'

In similare way add `event` typed `EString` into Transition

### Declare EOperation
1. Select `Feature > Operation`
2. Click on `FSM`
3. In the `Properties` view fill `Name` with 'execute'
4. In the left part of the `Properties` view, open the `Parameter` tab
5. Click the `Add` button at the right
6. In `Parameter Details` name it 'event' and type it 'EString'

Add also an operation:
 * `execute` into State
 * `isActivated` typed EBoolean into Transition

Your metamodel should look like that now:
//TODO: add image here

Implementation
==============

In this section we will write an interpreter for our language by implementing the EOperations defined in the Ecore model.

Make sure you are in the Modelin perspective

1. In the menu `Window > Perspective > Open Perspective > Other...`
2. Select `Modeling`

Then we activate the Behavior tools:
1. Right click on minifsm.aird and select `Viewpoints Selection`
2. Check `Behavior` and click `OK`
3. Now you can activate the `Behavior` layer in the toolbar
//TODO: add screenshot pointing to the tool bar icon > Menu

You have a new selection in the `Palette` at the right
Two new files are created:
 * minifsm.dsl (We will ignore it in this tutorial)
 * minifsm.ale (It will contain the implementations)

Add Dynamic features
--------------------
1. Select `Behavior > Reference`
2. Click on `FSM`
3. Click on `State`
5. Click yes if it asking to convert to XText project
6. In the automatically opened `minifsm.ale`, change `newRef` for `currentState`

Do the same with `Behavior > Attribute` to add `String currentEvent` into `FSM`

//TODO: screen with both .ale & .aird

Implement EOperations
---------------------

1. In the Class Diagram editor, right click on `isActivated` from `Transition`
2. Select `Edit implementation`
3. Fill the body with:
```
def boolean isActivated () {
	result := self.fsm.currentEvent = self.event and self.incoming = self.fsm.currentState;
}
```

We are checking
 * the event triggered by the Transition is the same as the current event handle by the FSM
 * the incoming State from the Transition is the current State of the FSM

The content of the variable `result` will be returned at the end of `isActivated`<br>
The variable `self` refer to the current object (here it is a Transition)

//TODO: screen with both .ale & .aird

//TODO: State.execute(), FSM.execute(), FSM.main()

Launch the execution
--------------------

### Create dynamic instance

### Run!
