# Multithreading Interview Questions and Answers in Java

## TOPIC OVERVIEW

This file contains important interview questions and answers related to Java multithreading. It is designed for beginners as well as intermediate learners who want to revise the core concepts of threads, synchronization, and concurrency.

---

## 1. WHAT IS MULTITHREADING?

**Answer:**
Multithreading is a feature in Java that allows multiple threads to execute concurrently within the same program. Each thread runs independently but shares common memory space.

**Example:**

```java
class MultiThreadingDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("Thread 1 is running"));
        Thread t2 = new Thread(() -> System.out.println("Thread 2 is running"));

        t1.start();
        t2.start();
    }
}

```

**Explanation:**

* `start()` creates a new thread and invokes the `run()` method.
* Both threads execute at the same time, depending on scheduling.

---

## 2. WHAT IS A THREAD?

**Answer:**
A thread is the smallest unit of execution in a program. It is a lightweight process that allows a program to perform multiple tasks concurrently.

**Example:**

```java
class ThreadExample {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("This is a thread"));
        t.start();
    }
}

```

---

## 3. DIFFERENCE BETWEEN PROCESS AND THREAD

**Answer:**

* **Process:** An independent program with its own memory space (e.g., a web browser).
* **Thread:** A unit of execution inside a process that shares memory with other threads (e.g., tabs inside the browser).

---

## 4. WHAT IS THE DIFFERENCE BETWEEN `start()` AND `run()`?

**Answer:**

* `start()` creates a new thread and executes the code in parallel.
* `run()` simply calls the method directly on the *current* thread, without spawning a new one.

**Example:**

```java
class StartVsRun {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("run() called"));

        t.start(); 
        // t.run(); // If uncommented, this will execute in the main thread, not a new one
    }
}

```

---

## 5. HOW MANY WAYS CAN WE CREATE A THREAD?

**Answer:**
There are two common ways to create a thread in Java:

1. By extending the `Thread` class.
2. By implementing the `Runnable` interface.

**Example using `Thread`:**

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread class example");
    }
}

class Demo {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}

```

**Example using `Runnable`:**

```java
class Demo2 {
    public static void main(String[] args) {
        Runnable r = () -> System.out.println("Runnable example");
        Thread t = new Thread(r);
        t.start();
    }
}

```

---

## 6. WHAT IS THE DIFFERENCE BETWEEN `Thread` AND `Runnable`?

**Answer:**

* `Thread` is a **class**.
* `Runnable` is an **interface**.
* Implementing `Runnable` is preferred because Java does not support multiple inheritance; implementing an interface leaves your class free to extend another class if needed.

**Example:**

```java
class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread running");
    }
}

class Demo3 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
    }
}

```

---

## 7. WHAT IS THE THREAD LIFE CYCLE?

**Answer:**
A thread in Java transitions through several states:

* **New:** Created but not yet started.
* **Runnable:** Ready to run and waiting for CPU time.
* **Running:** Currently executing.
* **Blocked/Waiting:** Waiting for a resource or another thread.
* **Terminated:** Execution completed.

**Example:**

```java
class LifeCycleDemo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Running");
            }
        });

        System.out.println(t.getState()); // Prints NEW
        t.start();
        System.out.println(t.getState()); // Prints RUNNABLE
    }
}

```

---

## 8. WHAT IS SYNCHRONIZATION IN JAVA?

**Answer:**
Synchronization is used to control access to shared resources so that only one thread can access a critical section at a time, preventing data inconsistency.

**Example:**

```java
class Counter {
    private int count = 0;

    synchronized void increment() {
        count++;
    }

    int getCount() {
        return count;
    }
}

class SyncDemo {
    public static void main(String[] args) throws Exception {
        Counter c = new Counter();
        
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) { c.increment(); }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) { c.increment(); }
        });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final count: " + c.getCount());
    }
}

```

---

## 9. WHAT IS THE DIFFERENCE BETWEEN `synchronized` METHOD AND `synchronized` BLOCK?

**Answer:**

* A **synchronized method** locks the entire method (locking the object instance).
* A **synchronized block** locks only a specific part of the code, allowing for more granular control and potentially better performance.

**Example:**

```java
class Example {
    private final Object lock = new Object();

    void display() {
        // Only this specific block is locked
        synchronized (lock) {
            System.out.println("Critical section");
        }
    }
}

```

---

## 10. WHAT IS A RACE CONDITION?

**Answer:**
A race condition occurs when multiple threads access shared data at the same time, and the final result depends on the unpredictable timing of the threads' execution.

**Example:**

```java
class RaceConditionDemo {
    static int count = 0;

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) count++;
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) count++;
        });

        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final count: " + count); // Likely incorrect due to race condition
    }
}

```

---

## 11. DIFFERENCE BETWEEN `wait()`, `notify()`, AND `notifyAll()`?

**Answer:**

* `wait()`: Causes a thread to release its lock and wait until another thread notifies it.
* `notify()`: Wakes up a single waiting thread.
* `notifyAll()`: Wakes up all waiting threads.

**Example:**

```java
class SharedResource {
    private boolean flag = false;

    synchronized void produce() throws Exception {
        while (flag) { wait(); }
        flag = true;
        System.out.println("Produced");
        notify();
    }

    synchronized void consume() throws Exception {
        while (!flag) { wait(); }
        flag = false;
        System.out.println("Consumed");
        notify();
    }
}

```

---

## 12. WHAT IS THE DIFFERENCE BETWEEN `sleep()` AND `wait()`?

**Answer:**

* `sleep()` pauses the thread for a fixed amount of time and **does not** release the lock.
* `wait()` **releases** the lock and waits indefinitely until it is notified.

**Example:**

```java
class SleepWaitDemo {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000); // Pauses for 1 second
                System.out.println("After sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t.start();
        t.join();
    }
}

```

---

## 13. WHAT IS THE `join()` METHOD USED FOR?

**Answer:**
The `join()` method allows one thread to pause its execution and wait for another thread to complete its task before continuing.

**Example:**

```java
class JoinDemo {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread 1");
            }
        });

        t1.start();
        t1.join(); // Main thread waits here until t1 finishes
        System.out.println("Main thread continues after t1 finishes");
    }
}

```

---

## 14. WHAT IS A DAEMON THREAD?

**Answer:**
A daemon thread runs in the background to perform tasks (like garbage collection) and does not prevent the JVM from exiting. When all user (non-daemon) threads finish, the JVM automatically stops daemon threads and exits.

**Example:**

```java
class DaemonDemo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while (true) {
                System.out.println("Daemon running");
            }
        });
        t.setDaemon(true); // Must be set before starting the thread
        t.start();
        System.out.println("Main thread ends");
    }
}

```

---

## 15. WHAT ARE THREAD PRIORITIES?

**Answer:**
Thread priority is a hint to the thread scheduler regarding the importance of a thread. The JVM defines priorities on a scale from `1` (MIN_PRIORITY) to `10` (MAX_PRIORITY), with `5` being the default (NORM_PRIORITY).

**Example:**

```java
class PriorityDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("Low priority"));
        Thread t2 = new Thread(() -> System.out.println("High priority"));

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}

```

---

## 16. WHAT IS THE DIFFERENCE BETWEEN `volatile` AND `synchronized`?

**Answer:**

* `volatile`: Ensures the *visibility* of changes to variables across threads (reads directly from main memory), but does not guarantee atomicity.
* `synchronized`: Ensures both *visibility* and *mutual exclusion* (only one thread can execute the block at a time).

**Example:**

```java
class VolatileDemo {
    // Ensures changes to 'running' are immediately visible to other threads
    private volatile boolean running = true;

    public void stop() {
        running = false;
    }
}

```

---

## 17. WHAT IS A DEADLOCK?

**Answer:**
A deadlock occurs when two or more threads are blocked forever, waiting for each other to release locks on resources.

**Example Scenario:**

* Thread 1 holds Lock A and is waiting to acquire Lock B.
* Thread 2 holds Lock B and is waiting to acquire Lock A.
* Neither can proceed.

---

## 18. DIFFERENCE BETWEEN `ConcurrentHashMap` AND `Hashtable`?

**Answer:**

* **`ConcurrentHashMap`**: Divides the map into segments and locks only the relevant segment during an update, allowing concurrent reads and writes for better performance.
* **`Hashtable`**: Synchronizes every method, locking the entire map during any operation, which makes it much slower in a highly concurrent environment.

---

## 19. WHAT IS THE USE OF `ExecutorService`?

**Answer:**
`ExecutorService` is a higher-level API used to manage a pool of threads efficiently. It eliminates the overhead of manually creating and destroying thread objects for every task.

**Example:**

```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        
        executor.submit(() -> System.out.println("Task 1"));
        executor.submit(() -> System.out.println("Task 2"));
        
        executor.shutdown();
    }
}

```

---

## 20. WHAT IS A THREAD SAFETY ISSUE?

**Answer:**
Thread safety issues occur when a class, object, or variable behaves incorrectly or yields unpredictable results because it is accessed and modified by multiple threads simultaneously without proper synchronization.

**Examples:**

* Unsynchronized shared counters.
* Concurrent modifications to shared lists or variables.

---

## 21. WHAT IS THE DIFFERENCE BETWEEN `yield()` AND `sleep()`?

**Answer:**

* `yield()`: A hint to the thread scheduler that the current thread is willing to yield its current use of a processor, allowing other threads of the same priority a chance to run.
* `sleep()`: Forces the current thread to pause execution for a specific duration, regardless of other threads.

**Example:**

```java
class YieldDemo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Yielding");
                Thread.yield();
            }
        });
        t.start();
    }
}

```

---

## 22. WHAT IS THE IMPORTANCE OF INTER-THREAD COMMUNICATION?

**Answer:**
Inter-thread communication allows threads to coordinate their actions and share information in a controlled manner. It prevents wasted CPU cycles (like busy-waiting) by allowing threads to pause until a specific condition is met.

**Examples:**

* Producer-consumer patterns.
* Thread signaling using `wait()` and `notify()`.

---

## 23. WHAT IS THE PRODUCER-CONSUMER PROBLEM?

**Answer:**
The producer-consumer problem is a classic concurrency and synchronization challenge. It involves:

* A **Producer** thread that generates data and puts it into a shared buffer (queue).
* A **Consumer** thread that removes data from the buffer and processes it.
* **The Problem:** Ensuring the producer doesn't add data when the buffer is full, and the consumer doesn't try to remove data when the buffer is empty.

---

## 24. CAN WE START A THREAD TWICE?

**Answer:**
No. A thread cannot be started more than once. If you call `start()` on a thread that has already been started, it will throw an `IllegalThreadStateException`.

**Example:**

```java
class StartTwiceDemo {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Hello"));
        t.start();
        // t.start(); // This line will throw an IllegalThreadStateException
    }
}

```

---

## 25. WHAT IS THE ROLE OF THE JVM IN MULTITHREADING?

**Answer:**
The Java Virtual Machine (JVM) acts as the manager for multithreading. It handles:

* Thread execution and lifecycle management.
* Thread scheduling (mapping Java threads to native OS threads).
* Memory management (ensuring all threads share the heap memory while maintaining a separate call stack for each individual thread).

---

## FINAL SUMMARY

Java multithreading is a critical topic for technical interviews because it tests a developer's understanding of concurrent execution, resource management, and application performance. A strong technical foundation must include:

* Thread creation and lifecycles.
* The absolute necessity of synchronization.
* Inter-thread communication strategies.
* Identifying and resolving thread safety risks, such as deadlocks and race conditions.

---
