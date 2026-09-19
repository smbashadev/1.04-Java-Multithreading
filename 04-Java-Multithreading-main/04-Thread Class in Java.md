# Thread Class in Java

## TOPIC OVERVIEW

In Java, the `Thread` class is a foundational component used for creating and managing threads, which are separate paths of execution within a program. It enables developers to create new threads, control their behavior, and manage their lifecycle.

**Why this topic is important:**

* It is the core building block of Java multithreading.


* It helps developers write programs that perform multiple tasks simultaneously.


* It is essential for understanding how Java handles concurrency.


* It prepares learners for advanced concepts like the executor framework and parallel processing.



---

## 1. DEFINITION OF THREAD CLASS

The `Thread` class is a predefined class in Java located in the `java.lang` package. It represents a thread of execution and provides methods to start, pause, stop, and manage threads.

## 2. WHAT IS A THREAD?

A thread is the smallest unit of execution in a program. It can be thought of as a lightweight process, a path of execution, or a worker that runs code independently. Every Java program starts with at least one thread, known as the main thread.

## 3. WHY THE Thread CLASS IS IMPORTANT

The `Thread` class is crucial for:

* Creating new threads.


* Running multiple tasks simultaneously.


* Making programs more responsive.


* Handling background operations efficiently.


* Improving performance in applications requiring parallel execution.



## 4. THREAD CLASS VS Runnable INTERFACE

| Feature | `Thread` Class | `Runnable` Interface |
| --- | --- | --- |
| **Usage** | Override `run()` directly.

 | Better for separating task logic from thread logic.

 |
| **Flexibility** | Cannot inherit from another class if you extend `Thread`.

 | Flexible; a class can implement `Runnable` and extend another class.

 |
| **Access** | Gives direct access to thread methods.

 | Requires reference to a `Thread` object.

 |

## 5. IMPORTANT METHODS OF THE Thread CLASS

* `start()`: Starts a new thread and calls `run()`.


* `run()`: Contains the code executed by the thread.


* `sleep(long millis)`: Pauses a thread for a specified time.


* `join()`: Waits for another thread to finish.


* `getName()` / `setName()`: Gets or changes the thread's name.


* `currentThread()`: Returns the currently executing thread.


* `isAlive()`: Checks if a thread is active.


* `setPriority(int p)`: Sets the thread's priority.


* `yield()`: Gives a chance to another thread to execute.



## 6. THREAD LIFE CYCLE

Threads transition through several states:

* **New**: Thread object created but not started.


* **Runnable**: Thread is ready to run.


* **Running**: Thread is actively executing.


* **Blocked/Waiting**: Thread waits for a resource or another thread.


* **Terminated**: Thread has finished execution.



---

## 7. PROGRAM 1: EXTENDING THE Thread CLASS

**Headline**: Creating a Simple Thread by Extending the `Thread` Class

**Program**:

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread running: " + i);
        }
    }
}

public class ThreadClassExample1 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println("Main thread is executing");
    }
}

```

---

## 8. PROGRAM 2: start() VS run()

**Headline**: Understanding the Difference Between `start()` and `run()`

**Program**:

```java
public class ThreadClassExample2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Inside run() method");
        });

        t1.run(); // Calls run() directly, not as a new thread
        System.out.println("After run() call");
    }
}

```

Calling `run()` directly executes it as a standard method in the current thread, whereas `start()` initiates a new thread.

---

## 9. PROGRAM 3: THREAD NAME AND PRIORITY

**Headline**: Naming and Prioritizing Threads

**Program**:

```java
public class ThreadClassExample3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, "WorkerThread");

        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
    }
}

```

---

## 10. PROGRAM 4: USING sleep()

**Headline**: Delaying Thread Execution with `sleep()`

**Program**:

```java
public class ThreadClassExample4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread is going to sleep");
                Thread.sleep(2000); // Pauses for 2 seconds
                System.out.println("Thread woke up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
    }
}

```

---

## 11. PROGRAM 5: USING join()

**Headline**: Waiting for a Thread to Finish Using `join()`

**Program**:

```java
public class ThreadClassExample5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Task: " + i);
            }
        });

        t1.start();
        t1.join(); // Waits for t1 to finish before continuing
        System.out.println("Main thread continues after join");
    }
}

```

---

## 12. COMMON MISTAKES

* Calling `run()` directly instead of `start()`.


* Failing to handle `InterruptedException`.


* Assuming a fixed output execution order.


* Excessive thread creation without proper control.


* Sharing data without synchronization.



## 13. FINAL SUMMARY

The `Thread` class is fundamental to Java multithreading, providing the necessary tools to create, manage, and coordinate concurrent tasks. Proficiency with methods like `start()`, `run()`, `sleep()`, and `join()` is essential for developing efficient, high-performance concurrent applications.

