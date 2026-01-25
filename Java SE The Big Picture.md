
# Author: Natalio Gomes

## Java Development Kit (JDK)

The **Java Development Kit (JDK)** consists of:
- Java Programming Language
- Core Libraries
- Java Runtime Environment (JRE)

---

## Java Workflow

```

Java Source Code
↓
javac (Compiler: transforms human-readable code into bytecode)
↓
JVM (inside the JRE)

````

### Example

```java
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
````

### Compile

```bash
javac App.java
```

* Produces `App.class` (compiled bytecode)

### Run

```bash
java App
```

### What happens at runtime

* JRE starts and contains the JVM
* JVM loads `App.class`
* JVM verifies the bytecode for safety and validity
* Interpreter and **Just-In-Time (JIT) Compiler** translate bytecode into native machine code at runtime
* JVM executes `App.main()`
* `main` must be `static` because the JVM calls it without creating an object

---

## Java Portability

* Java is **backward compatible**

  * Code written in Java 8 can run on newer Java versions without modification
* Java follows the **Write Once, Run Anywhere (WORA)** principle
* JVM and JRE are **platform-dependent**
* Source code is platform-independent
* The JDK provides everything needed to compile and run Java applications

---

## Memory Management

* Java has a **Garbage Collector**
* Responsible for automatic memory management
* Frees unused objects to prevent memory leaks

---

## Processes and Threads

### What is a Process?

* A **process** is a running instance of a program
* Example: a web browser
* Each application runs in its own process
* Processes are isolated; if one crashes, others are unaffected

---

### What is a Thread?

* A **thread** is a lightweight unit of execution inside a process
* Threads share the same memory space
* Example:

  * Thread 1: Networking
  * Thread 2: User Interface (UI)

---

### What is Multithreading?

* **Multithreading** means multiple threads running within a single process
* Improves responsiveness and resource utilization

---

### What is Parallelism?

* Parallelism requires hardware with **multiple CPU cores**
* Threads can run **simultaneously** on different cores
* Enables true simultaneous execution

### What Are Java Streams?
This funcitonality allows you to perform a series of operation oo a collection of elements.
For example

```java
public class App {
    public static void main(String[] args) {
        Function<Integer, Integer> isEven = (Integer number) -> number % 2;
        List<Integer> result = List.of(1,2,3,4,5).stream()
            .filter(item -> item > 2) // filter items of the list 1,2,3,4,5 and onl;y get those that are greather than 2
            .map(isEven) // use the previous result and map all items to check if they are even, the output is 1 or 0
            .toList() // finally lets convert the result of the map operation to a list
    }
}
```

### What is the difference between Heap and STACK
To illustrate this:
    int x = 10; // located in the stack
    Person p = new Person(); p is in the stack which refers to the object Person in the Heap

Heap is a shared memory area where all objects and the instance variable are aloocated at runtime.

A process contains a heap and multiple threads, and each thread has its own stack.
Process
├── Heap        (shared)
└── Threads
    ├── Thread 1 → Stack
    ├── Thread 2 → Stack
    └── Thread 3 → Stack

---
