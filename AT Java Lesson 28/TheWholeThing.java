/*
 * 2/26/25
 * Sw design with java 
 * Jonathan Martinez 
 * 
 * 
 * 
 * 
 * Homework #28 - Intro to Inheritance

Reading Assignment:
Read section 9.1  of the Java Concepts textbook.

Important Note: 
For this homework assignment, students are encouraged to work with their classmates to solve the problems.  Students can also search the Internet for help solving these problems.  Students should not, however, use artificial intelligence (including ChatGPT) to write their programs.  The work that a student submits should accurately reflect their understanding of the assignment.

Assignment:
Part A:
Suppose you are to design an inheritance hierarchy with the following classes, Snake, Crocodile, Reptile, and Turtle.  
Which of these items is the superclass and why?
Snake
Turtle
Reptile
Crocodile


- Reptile is the superclass because it is the most general class in the hierachy, while the other classes are specific types of reptiles.

Part B:
Suppose you have designed an inheritance hierarchy that includes the following relationships:

Guitar is a subclass of Instrument
AcousticGuitar is a subclass of Guitar
ElectricGuitar is a subclass of Guitar

Given the declarations below, which of the objects CANNOT be passed to the method tune(Guitar g) and why??

AcousticGuitar ag;
ElectricGuitar eg;
Guitar myGuitar;
Instrument myInstrument;

- The object myInstrument cannot be passed to the method tune(Guitar g) because it is not a subclass of Guitar, but rather the 
superclass of Guitar.


 * 
 */