/*
 * ============================================================================
 * Program Name : Current Thread Method
 * Description  : This program demonstrates how to get information about
 *                the currently executing thread using currentThread().
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates the main class.
public class CurrentThreadMethod {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the program has started.
        System.out.println("Program Started");

        // Gets the currently executing thread.
        Thread currentThread = Thread.currentThread();

        // Displays the complete information of the current thread.
        System.out.println("Current Thread : " + currentThread);

        // Displays only the name of the current thread.
        System.out.println("Thread Name : " + currentThread.getName());

        // Displays the priority of the current thread.
        System.out.println("Thread Priority : " + currentThread.getPriority());

        // Displays a message indicating that the program has completed.
        System.out.println("Program Finished");
    }
}
