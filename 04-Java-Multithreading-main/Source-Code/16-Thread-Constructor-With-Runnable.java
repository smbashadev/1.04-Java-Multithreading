/*
 * ============================================================================
 * Program Name : Thread Constructor with Runnable
 * Description  : This program demonstrates how to create a thread using
 *                the Thread(Runnable target) constructor.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a class that implements the Runnable interface.
class MyRunnable implements Runnable {

    // Overrides the run() method.
    @Override
    public void run() {

        // Displays a message from the child thread.
        System.out.println("Child Thread is Running");
    }
}

// Creates the main class.
public class ThreadConstructorWithRunnable {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the program has started.
        System.out.println("Program Started");

        // Creates an object of the Runnable implementation.
        MyRunnable runnableObject = new MyRunnable();

        // Creates a Thread object using the Runnable object.
        Thread thread = new Thread(runnableObject);

        // Starts the child thread.
        thread.start();

        // Displays a message indicating that the program has finished.
        System.out.println("Program Finished");
    }
}
