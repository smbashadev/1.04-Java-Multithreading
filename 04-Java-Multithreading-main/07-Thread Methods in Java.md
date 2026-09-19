# Thread Methods in Java

## TOPIC OVERVIEW

Java provides a suite of built-in methods within the `Thread` class to manage and control thread execution. These methods are fundamental for tasks such as starting threads, pausing execution, coordinating dependencies, inspecting thread states, and influencing thread scheduling.

**Why this topic is important:**

* It empowers developers to control thread execution effectively.


* Mastery of these methods is essential for writing robust, concurrent Java programs.


* These methods are frequently used in enterprise applications, including server management, gaming, and background processing.


* They provide deep insight into the lifecycle and behavior of threads within the Java Virtual Machine (JVM).



---

## 1. DEFINITION OF THREAD METHODS

Thread methods are predefined members of the `Thread` class that facilitate the management of thread behaviors. These methods enable developers to manage thread names, priorities, statuses, and synchronization.

### Commonly Used Thread Methods

* `start()`: Initiates a new thread.


* `run()`: Defines the logic the thread will execute.


* `sleep(long millis)`: Pauses execution for a specified duration.


* `join()`: Coordinates dependencies by forcing one thread to wait for another.


* `yield()`: Suggests to the thread scheduler that the current thread can pause.


* `isAlive()`: Inspects if a thread is currently running.


* `getName()`/`setName(String)`: Manages thread identification.


* `currentThread()`: Retrieves a reference to the execution thread.


* `getState()`: Inspects the current state of a thread.



---

## 2. KEY METHOD BEHAVIORS

### start() vs. run()

* `start()` must be used to initiate a new thread and invoke `run()` asynchronously.


* Calling `run()` directly will simply execute the code within the current thread, like any standard method call, failing to create a new thread.



### sleep() and yield()

* `sleep(long millis)` pauses the current thread for the duration defined and throws an `InterruptedException`.


* `yield()` is a non-binding suggestion to the thread scheduler to allow other threads to execute.



### join()

* `join()` is used to make the calling thread wait for the target thread to finish. This is critical when one task is dependent on the completion of another.



---

## 3. PROGRAMMATIC EXAMPLES

### Coordinating Threads with join()

The following example demonstrates how to ensure the main thread waits for a child thread to complete its iteration:

```java
public class ThreadMethodExample3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Child thread: " + i);
            }
        });

        t1.start();
        t1.join(); // Main thread waits until t1 finishes
        System.out.println("Main thread continues");
    }
}

```

### Thread Identification and State

This example illustrates how to retrieve thread information and inspect its lifecycle state:

```java
public class ThreadMethodExample6 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        });

        t1.start();
        System.out.println("Is thread alive before join? " + t1.isAlive());
        t1.join();
        System.out.println("Thread state after completion: " + t1.getState());
    }
}

```

---

## 4. COMMON MISTAKES

* Invoking `run()` instead of `start()` when attempting to create a new thread.


* Neglecting to handle `InterruptedException` for methods like `sleep()`.


* Over-relying on `yield()` or `sleep()` to control precise timing, as these are subject to OS scheduling.


* Omitting `join()` in scenarios where the execution order is strictly dependent.



---

## 5. FINAL SUMMARY

Thread methods provide the necessary control mechanisms to build efficient multithreaded applications. By mastering `start()`, `join()`, `sleep()`, and other state-monitoring methods, developers can better manage thread lifecycles, coordinate concurrent tasks, and debug complex synchronization issues.
