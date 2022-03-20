# Java 8 New Features

**Interface Default and Static Methods**
Before Java 8, interfaces could have only public abstract methods. 
It was not possible to add new functionality to the existing interface without forcing all implementing classes to create an implementation of the new methods, 
nor it was possible to create interface methods with an implementation.

Starting with Java 8, interfaces can have static and default methods that, 
despite being declared in an interface, have a defined behavior.

- Static Method
- Default Method

**Method References**
Method reference can be used as a shorter and more readable alternative for a lambda expression which only calls an existing method. 
There are four variants of method references.

- Reference to a Static Method
- Reference to an Instance Method
- Reference to an Instance Method of an Object of a Particular Type
- Reference to a Constructor

**Optional<T>**
Before Java 8 developers had to carefully validate values they referred to, because of a possibility of throwing the NullPointerException (NPE). 
All these checks demanded a pretty annoying and error-prone boilerplate code.

Java 8 Optional<T> class can help to handle situations where there is a possibility of getting the NPE. It works as a container for the object of type T. 
It can return a value of this object if this value is not a null. 
When the value inside this container is null it allows doing some predefined actions instead of throwing NPE.

- Creation of the Optional<T>
- Optional<T> Usage
