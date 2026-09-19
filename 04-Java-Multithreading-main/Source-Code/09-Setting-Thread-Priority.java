/*
 * ============================================================================
 * Program Name : Setting Thread Priority
 * Description  : This program demonstrates how to set and get the
 *                priority of a thread using setPriority() and getPriority().
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

        // Displays the name of the child thread.
        System.out.println("Thread Name : " + Thread.currentThread().getName());

        // Displays the priority of the child thread.
        System.out.println("Thread Priority : " + Thread.currentThread().getPriority());

        // Displays a message indicating that the child thread has finished.
        System.out.println("Child Thread Finished");
    }
}

// Main class of the program.
public class SettingThreadPriority {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the main thread has started.
        System.out.println("Main Thread Started");

        // Creates an object of MyThread.
        MyThread thread = new MyThread();

        // Assigns a custom name to the child thread.
        thread.setName("Learning Thread");

        // Sets the priority of the child thread to 8.
        thread.setPriority(8);

        // Starts the child thread.
        thread.start();

        // Displays a message indicating that the main thread has finished.
        System.out.println("Main Thread Finished");
    }
}
