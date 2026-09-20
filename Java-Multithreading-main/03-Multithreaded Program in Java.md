# Multithreaded Program in Java

## TOPIC OVERVIEW

A multithreaded program is a program that can execute multiple threads at the same or nearly the same time. In Java, this allows one program to perform multiple tasks concurrently instead of waiting for one task to finish before starting another.

**Why this topic is important:**

* It is the foundation of modern Java applications.


* It improves performance when tasks can run independently.


* It helps build responsive user interfaces, servers, and network applications.


* It explains the difference between sequential and concurrent execution.



---

## 1. DEFINITION OF MULTITHREADING

Multithreading is the ability of a program to create and run multiple threads in parallel or concurrently.

* A thread is a lightweight unit of execution.


* One program can have many threads.


* Each thread can run a different part of the program.


* Threads share the same memory space of the process.



## 2. DEFINITION OF MULTITHREADED PROGRAM

A multithreaded program is a Java program that uses two or more threads to execute separate tasks.

## 3. WHY MULTITHREADING IS USED

Multithreading is used because it helps a program:

* perform multiple tasks at the same time.


* remain responsive while background tasks run.


* use CPU resources efficiently.


* improve speed for I/O-heavy and long-running operations.



**Real-life examples:**

* A music player can play music while downloading songs.


* A web browser can load pages while responding to user clicks.


* A server can handle many client requests at once.



## 4. MULTITHREADING VS SINGLE-THREADING

* **Single-threaded program**: Only one thread runs, tasks execute one after another, and it is simpler to understand and debug.


* **Multithreaded program**: Multiple threads run together, tasks can overlap, and it is more powerful but more complex.



## 5. IMPORTANT JAVA THREAD CONCEPTS

* Thread class


* Runnable interface


* `start()` method


* `run()` method


* `sleep()` method


* `join()` method


* `synchronized` keyword



## 6. HOW JVM HANDLES THREADS

The Java Virtual Machine (JVM) manages threads and schedules them for execution. The operating system may run threads on different CPU cores, depending on the system.

* The exact order of thread execution is not always fixed.


* Output order can differ from run to run.



## 7. PSEUDOCODE FOR MULTITHREADED PROGRAM

```text
BEGIN
    CREATE thread T1
    CREATE thread T2

    START T1
    START T2

    WAIT for T1 to finish
    WAIT for T2 to finish

    DISPLAY "All threads completed"
END

```

This pseudocode shows that multiple threads can run independently.

---

## 8. PROGRAM 1: FIRST MULTITHREADED PROGRAM USING Thread CLASS

**Headline:** Creating a Basic Multithreaded Program Using the Thread Class

**Program:**

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread running: " + i);
        }
    }
}

public class MultiThreadExample1 {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println("Main thread is running");
    }
}

```

**Why this program is used:**

* It shows the easiest way to create a thread.


* It demonstrates how a new thread starts separately from the main thread.


* It helps beginners understand the relation between `Thread` and `run()`.



---

## 9. PROGRAM 2: MULTITHREADED PROGRAM USING Runnable INTERFACE

**Headline:** Creating Threads Using the Runnable Interface

**Program:**

```java
class PrintTask implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Runnable task: " + i);
        }
    }
}

public class MultiThreadExample2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new PrintTask());
        t1.start();
        System.out.println("Main thread finished setup");
    }
}

```

**Why this program is used:**

* It demonstrates a second, more preferred way to create threads.


* It separates the task logic from thread creation.


* It allows a class to inherit from another class while still creating a thread.



---

## 10. PROGRAM 3: MULTITHREADING WITH TWO THREADS

**Headline:** Running Two Threads Simultaneously

**Program:**

```java
public class MultiThreadExample3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 2: " + i);
            }
        });

        t1.start();
        t2.start();
    }
}

```

---

## 11. PROGRAM 4: USING sleep() METHOD

**Headline:** Understanding Thread Sleep in Java

**Program:**

```java
public class MultiThreadExample4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
    }
}

```

---

## 12. COMMON PROBLEMS IN MULTITHREADING

* **Race conditions**: multiple threads access shared data at the same time.


* **Deadlock**: two or more threads wait forever for each other.


* **Starvation**: a thread never gets CPU time.


* **Visibility problems**: one thread may not see updated values from another thread.



## 13. WHY SYNCHRONIZATION IS IMPORTANT

Synchronization ensures that only one thread can access a critical section at a time. This helps prevent inconsistent data.

## 14. FINAL SUMMARY

A multithreaded program allows multiple threads to run at the same time or close to it. Java provides built-in support for multithreading through the `Thread` class and `Runnable` interface. Multithreading is useful for improving responsiveness and performance, but it also introduces challenges like race conditions and deadlocks.

