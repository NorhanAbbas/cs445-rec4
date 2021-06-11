# CS 445 Recitation 4: Stacks

## Introduction

In this recitation, you will practice using the Stack ADT to implement a variant
of the Bag ADT, `UndoableBag`, that can undo and redo the insertion and removal
of elements. You will override the `add` and `remove` methods so that the
`UndoableBag` will keep track of the data that was inserted to or removed from
the `UndoableBag`. You will then implement the `undo` method, which will undo
the most recent insert or remove method on the `UndoableBag`. Lastly, you will
implement the `redo` method, which will repeat an insert or remove method that
was most recently undone by calling the `undo` method.

The primary goal of this recitation is to practice and gain confidence with the
Stack ADT, learning the respective operations and how to interact with a Stack.
A secondary goal is to get practice with inheritance (the technique of extending
a class) and composition (the technique of using objects of one class as
instance variables in another class).

As we have seen in lecture, a stack is a LIFO (Last In, First Out) collection of
items that may contain duplicates. Before completing this exercise, you should
review the methods available to you in the Stack ADT, as well as the
implementation techniques we used to construct a linked-based implementation of
this ADT.

## Gradle Testing on GitHub

In Recitation 3, you learned how to execute pre-written unit tests using
`./gradlew test` (or `gradlew.bat test` on DOS-like terminals). In this
exercise, in addition to running pre-written unit tests locally on a terminal,
these unit tests will be executed remotely on GitHub when changes are pushed
using the `git push` command. For this recitation, the tests running remotely on
GitHub are the same tests that can be run on a local terminal. Follow along
closely and/or take notes as your TA introduces you to the concept of executing
tests on GitHub through the `git push` command and the resulting output.

Note that your programming assignments will come with unit tests that will be
run for you each time you push to your submission repository. These will
automatically be enabled. If you fork the Recitation 4 repository, and want the
included tests to run in your fork, you'll need to navigate to the "Actions" tab
on GitHub and enable them.

## Exercise

1. Download the provided code by forking and cloning this [Recitation 4
repository](https://github.com/2217-cs445/cs445-rec4). The starting code for
this exercise, as usual, is found in subdirectory `app/src/main/java/`. Navigate
to this subdirectory, then into the `cs445/rec4/` package folder within it. Note
the following provided Java files:

   - `BagInterface.java` is a Java interface representing the Bag ADT.
   - `ArrayBag.java` is a dynamic capacity array-based implementation of the Bag
     ADT.
   - `StackInterface.java` is a Java interface representing the ADT Stack.
   - `LinkedStack.java` is a linked-chain implementation of ADT Stack.
   - `UndoableBag.java` is an implementation of the Bag ADT that is able to undo
     and redo previous insert and remove operations. It has non-functional stubs
     for the `undo()` and `redo()` methods as well as the `add(E)`, `remove()`,
     and `remove(E)` methods.
   - `Action.java` is a wrapper class for storing operations and data items to
     allow for undo and redo operations in `UndoableBag.java`.
   - `BagClient.java` is a simple example client that allows users to interact
     with the UndoableBag through an interactive command-line menu.

   In addition to the main portion of the code, we have also provided a test
   class that can be found in subdirectory `app/src/test/java/`. Navigate to
   this subdirectory, then into the `cs445/rec4/` package folder within it. Note
   the following provided Java file:

   - `UndoableBagTest.java` contains example test cases for the UndoableBag
     class

2. Read through `UndoableBag.java`, noting the 6 `TODO` comments. You will need
to complete these portions of the code.

3. At the first `TODO` comment, create two new reference variables named
`undoStack` and `redoStack` for storing a stack of actions for undo operations
and a stack of actions for redo operations.

4. At the second `TODO` comment, modify the add method to keep track of the data
item being inserted in the `undoStack` for future undo operations.

5. At the third and fourth `TODO` comments, modify the remove methods to keep
track of the data item being removed in the `undoStack` for future undo
operations.

------

6. Devise an algorithm for undoing an insert or remove operation on the
UndoableBag. Here are some questions you may want to consider:

   - What operation should be performed when undoing an insertion to the
     UndoableBag? What operation should be performed to undo the removal of a
     data item?
   - How can we ensure that any undone insert or remove operation can be
     repeated in the future? Where might we store this Action?

7. Implement your algorithm as method `boolean undo()` in `UndoableBag.java`.
Consider using a switch case to determine which action is currently being
undone. Remember which method in `StackInterface.java` can be used to remove an
Action from the top of a stack and similarly which method can be used to add an
Action to the top of a stack.

8. Test your `undo` method. You can run the provided tests automatically using
gradle:

   - `./gradlew test` (on Unix-like terminals such as those found on Mac, Linux,
     or Windows Subsystem for Linux)
   - `gradlew.bat test` (on DOS-like terminals such as the more traditional
     Windows terminal)

   Correct any bugs you find.

------

9. Devise an algorithm for redoing an insert or remove operation on the
UndoableBag. Here are some questions you may want to consider:

   - What operation should be performed when redoing an insertion to the
     UndoableBag? What operation should be performed to redo the removal of a
     data item?
   - How can we ensure that any operation that is repeated through the redo
     method can later be undone? Where might we store this Action?

10. Implement your algorithm as method `boolean redo()` in `UndoableBag.java`.
Consider using a switch case to determine which action is being repeated.
Remember which method in `StackInterface.java` can be used to remove an Action
from the top of a stack and similarly which method can be used to add an Action
to the top of a stack.

11. Test your `redo` method. You can run the provided tests automatically using
gradle:

    - `./gradlew test` (on Unix-like terminals such as those found on Mac,
      Linux, or Windows Subsystem for Linux)
    - `gradlew.bat test` (on DOS-like terminals such as the more traditional
      Windows terminal)

    Correct any bugs you find.

## Conclusion

In this exercise, you wrote implementation code for a Bag data structure with
undo and redo capabilities by interacting with the Stack ADT. You also practiced
using the methods and LIFO behavior of Stacks for maintaining a history of
actions on `UndoableBag`.
>>>>
