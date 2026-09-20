/*
 * ============================================================================
 * Program Name  : Single-Threaded Program in Java
 * Description   : Demonstrates the execution of a single thread (Main Thread)
 *                 where all tasks are executed sequentially.
 *
 * Author        : Shaik Mahaboob Basha
 * Repository    : 04-Java-Multithreading
 * GitHub        : https://github.com/shaikbasha-dev
 * ============================================================================
 */

// Declares the class named SingleThreadedProgram.
public class SingleThreadedProgram {

    // The main() method is the entry point of every Java application.
    public static void main(String[] args) {

        // Displays a message indicating that the main thread has started execution.
        System.out.println("Main Thread Started");

        // Displays the name of the currently executing thread.
        System.out.println("Current Thread : " + Thread.currentThread().getName());

        // Displays the first task executed by the main thread.
        System.out.println("Task 1 : Learning Core Java");

        // Displays the second task executed by the main thread.
        System.out.println("Task 2 : Learning Java Multithreading");

        // Displays the third task executed by the main thread.
        System.out.println("Task 3 : Practicing Java Programs");

        // Displays the fourth task executed by the main thread.
        System.out.println("Task 4 : Preparing for Technical Interviews");

        // Displays a message indicating that all tasks have been completed.
        System.out.println("All Tasks Executed Successfully");

        // Displays a message indicating that the main thread has completed execution.
        System.out.println("Main Thread Finished");
    }
}
