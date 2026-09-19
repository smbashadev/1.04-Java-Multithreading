# Introduction to Multithreading in Java

## 1. What is Multithreading?

* Multithreading refers to the ability to run multiple threads within a single process.


* A thread serves as the smallest unit of execution contained inside a program.


* This capability allows a program to execute more than one task simultaneously.



## 2. Process vs Thread

* **Process**: Defined as a running program that possesses its own dedicated memory space.


* **Thread**: A lightweight unit operating inside a process that shares memory resources with other threads.


* **Example**: A web browser acts as a process, while each individual browser tab may operate within its own separate thread.



## 3. Why Use Multithreading?

* It enhances performance when utilizing multi-core CPUs.


* Multithreading maintains application responsiveness.


* It enables the execution of background tasks without obstructing the main program flow.


* It is highly effective for operations such as file I/O, network communication, animations, and processing server requests.



## 4. Concurrency vs Parallelism

* **Concurrency**: A state where multiple tasks make progress over a period of time.


* **Parallelism**: A state where multiple tasks are executed at the exact same time across different CPU cores.


* A program can achieve concurrency without necessarily being fully parallel.



## 5. Java Thread Model

* Java facilitates multithreading through the use of the `Thread` class and the `Runnable` interface.


* Every Java program initiates with a single main thread.


* Developers can create additional threads to execute code independently.



## 6. Creating Threads in Java

### Method 1: Extending the Thread Class

```java
class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
        System.out.println("Main thread");
    }
}

```

### Method 2: Implementing the Runnable Interface

```java
class MyTask implements Runnable {
    public void run() {
        System.out.println("Task is running");
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyTask());
        t1.start();
    }
}

```

## 7. start() vs run()

* `start()`: This method creates a new thread and initiates the task asynchronously.


* `run()`: This method merely executes the code normally within the current thread context.


* You must always use the `start()` method to begin the execution of a new thread.



## 8. Important Thread Methods

* `sleep(long milliseconds)`: Pauses the execution of the current thread for a specified duration.


* `join()`: Forces the current thread to wait until another specified thread finishes its task.


* `yield()`: Provides an opportunity for another thread of the same priority to run.


* `setPriority()`: Configures the priority level for a thread.



## 9. Thread Life Cycle

A thread typically exists in one of the following states:

* New


* Runnable


* Running


* Blocked/Waiting


* Terminated



## 10. Challenges in Multithreading

* Race conditions


* Deadlock


* Starvation


* Visibility issues


* Data inconsistency



## 11. Synchronization

* Synchronization is a mechanism used to control access to shared resources.


* It prevents multiple threads from modifying the same data simultaneously, thereby avoiding conflicts.



### Example:

```java
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

```

## 12. Summary

* Multithreading enables multiple tasks to run concurrently.


* It is a vital tool for improving application performance and responsiveness.


* Java provides native, built-in support for multithreading using `Thread` and `Runnable`.


* Synchronization is essential to ensure safe access to shared data.



## 13. Simple Example

```java
public class Main {
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

## 14. Key Takeaway

* While multithreading is a powerful capability, it must be implemented with careful consideration.


* Mastering the thread lifecycle and synchronization techniques is essential for writing correct and stable multithreaded programs.
