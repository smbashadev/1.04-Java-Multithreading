/*
 * ============================================================================
 * Program Name : Thread Constructors
 * Description  : This program demonstrates how to create a thread using
 *                the default Thread constructor.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a class that extends the Thread class.
class MyThread extends Thread {

    // Overrides the run() method.
    @Override
    public void run() {

        // Displays a message indicating that the child thread is executing.
        System.out.println("Child Thread is Running");
    }
}

// Creates the main class.
public class ThreadConstructors {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the program has started.
        System.out.println("Program Started");

        // Creates a thread object using the default constructor.
        MyThread thread = new MyThread();

        // Starts the child thread.
        thread.start();

        // Displays a message indicating that the program has finished.
        System.out.println("Program Finished");
    }
}
