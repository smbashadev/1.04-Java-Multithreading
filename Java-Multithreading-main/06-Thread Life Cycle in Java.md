# Thread Life Cycle in Java

## TOPIC OVERVIEW

The thread life cycle describes the sequence of states a thread traverses from its creation to completion. Understanding this cycle is crucial for Java developers to effectively manage thread scheduling, waiting, and termination.

**Why this topic is important:**

* It explains how Java manages threads.


* It assists in debugging complex concurrency issues.


* It improves the understanding of thread scheduling behavior.


* It provides the foundation for advanced concepts like `wait()`, `notify()`, `sleep()`, `join()`, and synchronization.



---

## 1. DEFINITION OF THREAD LIFE CYCLE

The thread life cycle refers to the various states a thread passes through during its execution.

### Important States of a Thread

1. **New**: The thread object is created, but `start()` has not been called.


2. **Runnable**: The thread is ready to execute and is waiting for CPU time.


3. **Running**: The thread is actively executing its code.


4. **Blocked / Waiting**: The thread is paused while waiting for a resource, lock, or another thread.


5. **Terminated**: The thread has finished its execution.



---

## 2. THREAD FLOW

The transition between these states typically follows this flow:
`New -> Runnable -> Running -> Blocked/Waiting -> Runnable -> Terminated`

Threads can move dynamically between the **Runnable** and **Waiting/Blocked** states depending on resource availability and system scheduling.

---

## 3. PROGRAM 1: DEMONSTRATING THREAD STATES

**Headline:** Understanding the States of a Java Thread

**Program:**

```java
class LifeCycleThread extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Thread is running: " + i);
        }
    }
}

public class ThreadLifeCycleExample1 {
    public static void main(String[] args) {
        LifeCycleThread t1 = new LifeCycleThread();
        System.out.println("Thread state after creation: " + t1.getState());

        t1.start();
        System.out.println("Thread state after start(): " + t1.getState());

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread state after completion: " + t1.getState());
    }
}

```

* **Purpose:** This program utilizes `getState()` to monitor the thread's transition from `NEW` to `RUNNABLE` and eventually to `TERMINATED`.



---

## 4. PROGRAM 2: THE EFFECT OF sleep()

**Headline:** How `sleep()` Affects the Thread Life Cycle

**Program:**

```java
public class ThreadLifeCycleExample2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("Thread started");
                Thread.sleep(2000); // Pauses thread for 2 seconds
                System.out.println("Thread resumed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        System.out.println("Main thread is running");
    }
}

```

* **Purpose:** Demonstrates how `sleep()` causes a thread to pause execution, temporarily moving it out of the running state.



---

## 5. PROGRAM 3: DEMONSTRATING WAITING THROUGH join()

**Headline:** Understanding Waiting Behavior with `join()`

**Program:**

```java
public class ThreadLifeCycleExample3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Child thread: " + i);
            }
        });

        t1.start();
        t1.join(); // Main thread waits here until t1 completes
        System.out.println("Main thread continues after child thread finishes");
    }
}

```

* **Purpose:** Shows how `join()` forces a thread into a waiting state until another thread completes its task.



---

## 6. KEY DIFFERENCES: BLOCKED VS. WAITING

* **Blocked**: A thread enters this state when it is waiting to acquire a lock to enter a synchronized block or method.


* **Waiting**: A thread enters this state while waiting for another thread to perform a specific action (e.g., calling `notify()` or finishing a `join()`).



---

## 7. FINAL SUMMARY

The thread life cycle is a fundamental concept representing the transitions of a thread from `NEW` to `TERMINATED`. Mastery of these state transitions is essential for writing efficient, deadlock-free, and high-performance multithreaded Java applications.

