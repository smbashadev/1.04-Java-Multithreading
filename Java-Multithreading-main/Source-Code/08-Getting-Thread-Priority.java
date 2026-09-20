/*
 * ============================================================================
 * Program Name : Getting Thread Priority
 * Description  : This program demonstrates how to get the priority
 *                of the Main Thread and Child Thread.
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

        // Gets the priority of the child thread.
        int childThreadPriority = Thread.currentThread().getPriority();

        // Displays the priority of the child thread.
        System.out.println("Child Thread Priority : " + childThreadPriority);

        // Displays a message indicating that the child thread has finished.
        System.out.println("Child Thread Finished");
    }
}

// Main class of the program.
public class GettingThreadPriority {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the main thread has started.
        System.out.println("Main Thread Started");

        // Gets the priority of the main thread.
        int mainThreadPriority = Thread.currentThread().getPriority();

        // Displays the priority of the main thread.
        System.out.println("Main Thread Priority : " + mainThreadPriority);

        // Creates an object of the MyThread class.
        MyThread thread = new MyThread();

        // Starts the child thread.
        thread.start();

        // Displays a message indicating that the main thread has finished.
        System.out.println("Main Thread Finished");
    }
}
