# Runnable Interface in Java

## TOPIC OVERVIEW

The `Runnable` interface is a core component in Java used for creating threads, representing a task that can be executed concurrently. Unlike extending the `Thread` class, implementing `Runnable` allows a class to maintain object-oriented flexibility, making it a preferred approach for real-world applications.

**Why this topic is important:**

* It is the preferred method for creating threads in many professional Java applications.


* It enables better code organization and modularity.


* It bypasses the constraints of single inheritance in Java.


* It facilitates the development of scalable, reusable multi-threaded programs.



---

## 1. DEFINITION OF Runnable INTERFACE

The `Runnable` interface is a functional interface that contains a single abstract method:

```java
public void run()

```

Any class implementing `Runnable` must provide the implementation for the `run()` method.

## 2. THE run() METHOD

The `run()` method defines the task that the thread will perform.

* The `run()` method does not start a thread independently.


* It serves only to define the task logic.


* To execute the task, one must create a `Thread` object and invoke `start()`.



## 3. ADVANTAGES OF USING Runnable

Using the `Runnable` interface is generally preferred over extending the `Thread` class for several reasons:

* Classes can implement `Runnable` while still extending another parent class.


* It cleanly separates task logic from thread management logic.


* It promotes cleaner, more reusable code structures.


* It offers greater flexibility for complex applications.



---

## 4. PROGRAM 1: BASIC Runnable EXAMPLE

**Headline:** Creating a Thread Using the `Runnable` Interface

**Program:**

```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Task is running");
    }
}

public class RunnableExample1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask());
        t1.start();
        System.out.println("Main thread is running");
    }
}

```

* **Purpose:** Demonstrates the simplest use case of the `Runnable` interface and the relationship between `Runnable` and `Thread`.


* **Output:**

```text
Task is running
Main thread is running

```

---

## 5. PROGRAM 2: RUNNING REPEATING TASKS

**Headline:** Running a Repeating Task Using `Runnable`

**Program:**

```java
class LoopTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Loop Task: " + i);
        }
    }
}

public class RunnableExample2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new LoopTask());
        t1.start();
    }
}

```

* **Purpose:** Illustrates how threads can handle repetitive work and iteration-based logic.



---

## 6. PROGRAM 3: USING LAMBDA EXPRESSIONS

**Headline:** Using Lambda Expressions with `Runnable`

**Program:**

```java
public class RunnableExample3 {
    public static void main(String[] args) {
        Runnable task = () -> {
            System.out.println("Lambda Runnable is running");
        };

        Thread t1 = new Thread(task);
        t1.start();
    }
}

```

* **Purpose:** Provides a modern, concise, and readable way to implement `Runnable` for small tasks.



---

## 7. PROGRAM 4: MULTIPLE THREADS WITH Runnable

**Headline:** Creating Multiple Threads Using `Runnable`

**Program:**

```java
class Task implements Runnable {
    private String name;

    public Task(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(name + ": " + i);
        }
    }
}

public class RunnableExample4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Task("Thread A"));
        Thread t2 = new Thread(new Task("Thread B"));

        t1.start();
        t2.start();
    }
}

```

* **Purpose:** Demonstrates scalability and how the same `Runnable` implementation can be reused for different thread instances with unique data.



---

## 8. Runnable VS. Thread CLASS

| Feature | Runnable | Thread |
| --- | --- | --- |
| **Abstraction** | Better for task abstraction.

 | Directly represents the thread object.

 |
| **Flexibility** | More flexible.

 | Less flexible for larger applications.

 |
| **Usage** | Preferred in modern Java.

 | Useful for simple, direct examples.

 |
| **Ecosystem** | Compatible with executor services.

 | N/A |

---

## 9. FINAL SUMMARY

The `Runnable` interface is a powerful, standard approach for defining concurrent tasks in Java. By promoting separation of concerns and flexibility, it serves as a foundation for efficient multithreaded programming. Key takeaways include:

* Always implement `Runnable` to separate task logic from thread logic.


* Always invoke `start()` to trigger execution in a new thread.


* Avoid invoking `run()` directly, as this does not enable parallel execution.


* Utilize lambda expressions to write shorter, more readable code.



---


* `outputs/`: For sample execution results.


* `notes/`: For summaries and best practices.
