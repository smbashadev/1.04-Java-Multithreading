/*
 * ============================================================================
 * Program Name : Getting Thread Name
 * Description  : This program demonstrates how to get the name of the
 *                currently executing thread using currentThread().getName().
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

        // Displays a message indicating that the child thread has started.
        System.out.println("Child Thread Started");

        // Gets the name of the currently executing thread.
        String threadName = Thread.currentThread().getName();

        // Displays the child thread name.
        System.out.println("Child Thread Name : " + threadName);

        // Displays a message indicating that the child thread has finished.
        System.out.println("Child Thread Finished");
    }
}

// Main class of the program.
public class GettingThreadName {

    // Main method where program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the main thread has started.
        System.out.println("Main Thread Started");

        // Gets the name of the main thread.
        String mainThreadName = Thread.currentThread().getName();

        // Displays the name of the main thread.
        System.out.println("Main Thread Name : " + mainThreadName);

        // Creates an object of the MyThread class.
        MyThread thread = new MyThread();

        // Starts the child thread.
        thread.start();

        // Displays a message indicating that the main thread has finished.
        System.out.println("Main Thread Finished");
    }
}
