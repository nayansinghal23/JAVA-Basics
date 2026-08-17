# Multi Threading in JAVA ->

### CPU

It is referred to as the brain of computer, is responsible for executing instructions from programs. It performs basic arithmetic, logic, control, and input/output operations specified by the user in the program eg :- Intel, AMD.

### Core

A core is an individual processing unit whithin CPU. Modern CPUs have multiple cores, allowing them to perform multiple tasks simultaneously.

### Process

An instance of program that is being executed. When a program runs, an operating system creates a process to manage its execution.

### Thread

It's a smallest unit of execution within a process. A process can have multiple threads, which share same resource but can run independently.

### Multi-threading

Ability to execute multiple threads within a single process concurrently. Java supports it via `java.lang.Thread` class and `java.lang.Runnable` interface. When a Java program starts, one thread begins immediately, which is called `main` thread. 