/*
 * ============================================================================
 * Program Name : Same Runnable Shared by Multiple Threads
 * Description  : This program demonstrates how multiple Thread objects
 *                can execute the same Runnable object.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a class that implements the Runnable interface.
class MyTask implements Runnable {

    // Overrides the run() method.
    @Override
    public void run() {

        // Gets the name of the currently executing thread.
        String threadName = Thread.currentThread().getName();

        // Displays a message indicating that the thread has started.
        System.out.println(threadName + " Started");

        // Prints numbers from 1 to 3.
        for (int number = 1; number <= 3; number++) {

            // Displays the current number.
            System.out.println(threadName + " : " + number);
        }

        // Displays a message indicating that the thread has finished.
        System.out.println(threadName + " Finished");
    }
}

// Creates the main class.
public class SameRunnableSharedByMultipleThreads {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the program has started.
        System.out.println("Program Started");

        // Creates only one Runnable object.
        MyTask task = new MyTask();

        // Creates the first thread using the same Runnable object.
        Thread thread1 = new Thread(task, "Thread 1");

        // Creates the second thread using the same Runnable object.
        Thread thread2 = new Thread(task, "Thread 2");

        // Starts the first thread.
        thread1.start();

        // Starts the second thread.
        thread2.start();

        // Displays a message indicating that the main thread has finished.
        System.out.println("Program Finished");
    }
}
