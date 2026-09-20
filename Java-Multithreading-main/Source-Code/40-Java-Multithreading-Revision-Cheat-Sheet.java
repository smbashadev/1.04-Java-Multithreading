/*
 * ============================================================================
 * Program Name : Java Multithreading Revision Cheat Sheet
 * Description  : This program summarizes the major concepts covered in
 *                Java Multithreading.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

public class JavaMultithreadingRevisionCheatSheet {

    // Main method where execution starts.
    public static void main(String[] args) {

        System.out.println("==================================================");
        System.out.println("      JAVA MULTITHREADING REVISION CHEAT SHEET");
        System.out.println("==================================================");

        System.out.println("\n1. Thread Creation");
        System.out.println("------------------------------------------");
        System.out.println("• Extend Thread Class");
        System.out.println("• Implement Runnable Interface");
        System.out.println("• Use Callable Interface");

        System.out.println("\n2. Thread Life Cycle");
        System.out.println("------------------------------------------");
        System.out.println("• New");
        System.out.println("• Runnable");
        System.out.println("• Running");
        System.out.println("• Blocked / Waiting");
        System.out.println("• Terminated");

        System.out.println("\n3. Important Thread Methods");
        System.out.println("------------------------------------------");
        System.out.println("• start()");
        System.out.println("• run()");
        System.out.println("• sleep()");
        System.out.println("• join()");
        System.out.println("• yield()");
        System.out.println("• interrupt()");
        System.out.println("• currentThread()");
        System.out.println("• isAlive()");
        System.out.println("• getName()");
        System.out.println("• setName()");
        System.out.println("• getPriority()");
        System.out.println("• setPriority()");

        System.out.println("\n4. Daemon Threads");
        System.out.println("------------------------------------------");
        System.out.println("• Background Threads");
        System.out.println("• JVM does not wait for Daemon Threads");
        System.out.println("• Example : Garbage Collector");

        System.out.println("\n5. Synchronization");
        System.out.println("------------------------------------------");
        System.out.println("• Synchronized Method");
        System.out.println("• Synchronized Block");
        System.out.println("• Static Synchronization");
        System.out.println("• Prevents Race Conditions");

        System.out.println("\n6. Deadlock");
        System.out.println("------------------------------------------");
        System.out.println("• Occurs when threads wait for each other");
        System.out.println("• Prevent by consistent lock ordering");

        System.out.println("\n7. Inter-Thread Communication");
        System.out.println("------------------------------------------");
        System.out.println("• wait()");
        System.out.println("• notify()");
        System.out.println("• notifyAll()");
        System.out.println("• Producer Consumer Problem");

        System.out.println("\n8. Modern Concurrency");
        System.out.println("------------------------------------------");
        System.out.println("• ExecutorService");
        System.out.println("• Thread Pool");
        System.out.println("• ReentrantLock");
        System.out.println("• Callable");
        System.out.println("• Future");

        System.out.println("\n9. Best Practices");
        System.out.println("------------------------------------------");
        System.out.println("• Keep synchronized blocks small");
        System.out.println("• Always release locks");
        System.out.println("• Prefer ExecutorService over manually creating threads");
        System.out.println("• Avoid Deadlocks");
        System.out.println("• Use Thread Pools for multiple tasks");

        System.out.println("\n10. Frequently Asked Interview Topics");
        System.out.println("------------------------------------------");
        System.out.println("• Thread vs Process");
        System.out.println("• Thread vs Runnable");
        System.out.println("• Runnable vs Callable");
        System.out.println("• sleep() vs wait()");
        System.out.println("• notify() vs notifyAll()");
        System.out.println("• synchronized vs ReentrantLock");
        System.out.println("• User Thread vs Daemon Thread");
        System.out.println("• Race Condition");
        System.out.println("• Deadlock");
        System.out.println("• Thread Pool");

        System.out.println("\n==================================================");
        System.out.println("      END OF JAVA MULTITHREADING REVISION");
        System.out.println("==================================================");
    }
}
