# Single-Threaded Program in Java

## TOPIC OVERVIEW

A single-threaded program is a program in which only one thread of execution runs at a time. In Java, the `main()` method runs in the main thread. This means that the program executes instructions one after another in a sequential manner.

**Why this topic is important:**

* It helps us understand how Java programs work before learning multithreading.
* It explains the default flow of execution.
* It gives a strong foundation for understanding concurrency and parallelism.
* It shows why multithreading is needed when we want multiple tasks to run together.

---

## 1. DEFINITION OF SINGLE-THREADED PROGRAM

A single-threaded program is a Java program that has exactly one active path of execution. The program starts from `main()`, follows one instruction flow, and finishes that flow before moving to another independent task.

**In simple terms:**

* One thread executes all the instructions.
* There is no simultaneous execution of multiple tasks inside the program.
* If one task is slow, the rest of the program must wait.

## 2. DEFINITION OF THREAD

A thread is the smallest unit of execution in a program.

**Important points:**

* A thread is responsible for running a sequence of instructions.
* A Java program always starts with one thread called the main thread.
* If we create more threads, the program becomes multi-threaded.

## 3. WHAT IS THE MAIN THREAD?

The main thread is the first thread created when a Java program starts. It executes the `main()` method.

**Example:**
`public static void main(String[] args)`

This line tells Java:

* Start execution from here.
* Accept command-line inputs if any.
* Run all statements in this method in the main thread.

## 4. WHY USE A SINGLE-THREADED PROGRAM?

A single-threaded program is useful when:

* The tasks are very simple.
* The program does not need parallel execution.
* We want easy debugging and predictable flow.
* The logic is sequential and easy to understand.

**It helps Java developers because:**

* It teaches the basics of control flow.
* It shows how methods are called.
* It helps in understanding how Java programs move from one statement to another.
* It becomes easier to compare single-threaded and multi-threaded behavior later.

## 5. ADVANTAGES OF SINGLE-THREADED PROGRAMS

* Easy to understand.
* Easy to debug.
* No synchronization issues.
* No race conditions.
* No deadlock problem.
* Good for small programs and beginners.

## 6. DISADVANTAGES OF SINGLE-THREADED PROGRAMS

* Slower when performing many tasks at once.
* One long task can block the whole program.
* Not ideal for server applications or large systems.
* Poor use of multi-core processors.

## 7. PSEUDOCODE FOR SINGLE-THREADED PROGRAM

```text
BEGIN
    DISPLAY message "Program started"
    CALL method to perform task 1
    CALL method to perform task 2
    DISPLAY message "Program finished"
END

```

This pseudocode shows that each action happens one after another.

---

## 8. PROGRAM 1: SIMPLE SINGLE-THREADED PROGRAM

**Headline:** Understanding the Flow of a Basic Single-Threaded Java Program

**Program:**

```java
public class SingleThreadExample1 {
    public static void main(String[] args) {
        System.out.println("Program started");
        System.out.println("This is a single-threaded program");
        System.out.println("Program finished");
    }
}

```

**Why this program is used:**

* It shows the simplest form of a Java program.
* It proves that Java executes instructions in sequence.
* It helps beginners understand the `main()` method.

**Line-by-line explanation:**

1. `public class SingleThreadExample1 {`: Declares a public class named SingleThreadExample1. Every Java program must have at least one class.
2. `public static void main(String[] args) {`: The main method is the entry point of the program. `public` means accessible from anywhere; `static` means the method belongs to the class; `void` means no return value; `String[] args` stores command-line arguments.
3. `System.out.println("Program started");`: Prints the message to the console. `println` moves the cursor to the next line.
4. `System.out.println("This is a single-threaded program");`: Prints another message, showing sequential flow.
5. `System.out.println("Program finished");`: Prints the last message.
6. `}`: Ends the main method.
7. `}`: Ends the class.

**Output:**

```text
Program started
This is a single-threaded program
Program finished

```

---

## 9. PROGRAM 2: SINGLE-THREADED PROGRAM USING METHODS

**Headline:** Understanding Method Calls in a Single-Threaded Java Program

**Program:**

```java
public class SingleThreadExample2 {
    public static void main(String[] args) {
        System.out.println("Starting program");
        greetUser();
        calculateSum();
        System.out.println("Program completed");
    }

    public static void greetUser() {
        System.out.println("Hello, welcome to Java");
    }

    public static void calculateSum() {
        int a = 10;
        int b = 20;
        int sum = a + b;
        System.out.println("Sum is: " + sum);
    }
}

```

**Why this program is used:**

* It shows how methods are called one by one.
* It explains that Java follows a single flow of execution.
* It demonstrates modular programming.

**Summary:**
This program shows how a single-threaded Java application executes methods one after another.

---

## 10. PROGRAM 3: SINGLE-THREADED PROGRAM WITH USER INPUT

**Headline:** Using Input in a Single-Threaded Java Program

**Program:**

```java
import java.util.Scanner;

public class SingleThreadExample3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello, " + name);
        sc.close();
    }
}

```

**Why this program is used:**

* It shows how a single-threaded program can accept keyboard input.
* It explains how Java reads data from the user.
* It gives a practical example of sequential execution.

---

## 11. PROGRAM 4: SINGLE-THREADED PROGRAM USING LOOPS

**Headline:** Understanding Sequential Execution with Loops

**Program:**

```java
public class SingleThreadExample4 {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Value: " + i);
        }
    }
}

```

**Why this program is used:**

* It shows that a single thread can repeat tasks in order.
* It teaches the concept of iteration.
* It helps understand control flow clearly.

---

## 12. COMPARISON: SINGLE-THREADED VS MULTI-THREADED

| Feature | Single-threaded | Multi-threaded |
| --- | --- | --- |
| **Execution Path** | One path | Multiple paths |
| **Complexity** | Easier to write and debug | More complex |
| **Concurrency** | No concurrency problems | Needs synchronization |
| **Efficiency** | Less efficient for complex tasks | Better for performance |

## 13. IMPORTANT DEFINITIONS RECAP

* **Thread**: A path of execution in a program.
* **Single-threaded program**: A program with only one thread running.
* **Main thread**: The thread that starts the program.
* **Sequential execution**: Instructions run one after another.
* **Method**: A block of code used to perform a task.
* **Loop**: A construct that repeats instructions.

## 14. FINAL SUMMARY

A single-threaded program in Java runs one task at a time using the main thread. It is simple, easy to understand, and useful for learning the basic flow of Java. The main method is the starting point, and methods, loops, and input handling can all be used inside the program. Although it is not ideal for high-performance multitasking, it builds the foundation needed to understand multithreading later.

