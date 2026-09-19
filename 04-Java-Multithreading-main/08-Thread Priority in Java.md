# Thread Priority in Java

## TOPIC OVERVIEW

Thread priority is a mechanism used by the Java scheduler to determine the relative importance of threads when allocating CPU time. While Java associates an integer priority value with every thread, it serves as a hint to the scheduler rather than a strict execution command.

**Why this topic is important:**

* It provides insight into how the Java Virtual Machine (JVM) manages thread scheduling.


* It allows developers to influence execution behavior in specific scenarios.


* It is a foundational concept for understanding concurrent performance and scheduling behavior.



---

## 1. DEFINITION OF THREAD PRIORITY

Thread priority is an integer value that signals the importance of a thread relative to others. Java defines three standard priority levels:

* **`Thread.MIN_PRIORITY`**: 1


* **`Thread.NORM_PRIORITY`**: 5 (Default)


* **`Thread.MAX_PRIORITY`**: 10



---

## 2. KEY CHARACTERISTICS

* **Default Priority**: Threads created without an explicit priority assignment are automatically assigned `Thread.NORM_PRIORITY` (value of 5).


* **Hint-based System**: Priority is only a hint to the scheduler. There is no guarantee that a higher-priority thread will always execute before a lower-priority one.


* **Context Dependency**: The final scheduling behavior is heavily influenced by the underlying operating system, the JVM implementation, and current system load.


* **Relative Values**: Priority values are interpreted as relative importance, not absolute scheduling rules.



---

## 3. IMPORTANT METHODS

* **`setPriority(int priority)`**: Sets the priority level for the thread.


* **`getPriority()`**: Retrieves the current priority value of the thread.



---

## 4. PROGRAMMATIC EXAMPLES

### Setting and Getting Priority

The following program demonstrates how to assign and verify a thread's priority level:

```java
public class ThreadPriorityExample1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread priority: " + Thread.currentThread().getPriority());
        }, "WorkerThread");

        t1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Priority before start: " + t1.getPriority());
        t1.start();
    }
}

```

### Comparing Priority Differences

This example illustrates how developers can define threads with varying priorities, though scheduling preference is not absolute:

```java
public class ThreadPriorityExample2 {
    public static void main(String[] args) {
        Thread low = new Thread(() -> {
            for (int i = 1; i <= 5; i++) System.out.println("Low priority: " + i);
        });

        Thread high = new Thread(() -> {
            for (int i = 1; i <= 5; i++) System.out.println("High priority: " + i);
        });

        low.setPriority(Thread.MIN_PRIORITY);
        high.setPriority(Thread.MAX_PRIORITY);

        low.start();
        high.start();
    }
}

```

---

## 5. FINAL SUMMARY

Thread priority is an essential tool for influencing thread scheduling, allowing developers to categorize tasks by importance using integer values ranging from 1 to 10. By utilizing `setPriority()` and `getPriority()`, developers can tailor thread metadata to suggest execution preferences to the Java scheduler. However, because this system is not a strict guarantee, applications should not rely on priority for critical synchronization or execution ordering.
