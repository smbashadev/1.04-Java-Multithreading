/*
 * ============================================================================
 * Program Name : Setting Thread Name
 * Description  : This program demonstrates how to assign a custom name
 *                to a thread using the setName() method.
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

        // Displays the custom name of the child thread.
        System.out.println("Child Thread Name : " + Thread.currentThread().getName());

        // Displays a message indicating that the child thread has finished.
        System.out.println("Child Thread Finished");
    }
}

// Main class of the program.
public class SettingThreadName {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the main thread has started.
        System.out.println("Main Thread Started");

        // Creates an object of the MyThread class.
        MyThread thread = new MyThread();

        // Assigns a custom name to the child thread.
        thread.setName("Learning Thread");

        // Starts the child thread.
        thread.start();

        // Displays the name of the main thread.
        System.out.println("Main Thread Name : " + Thread.currentThread().getName());

        // Displays a message indicating that the main thread has finished.
        System.out.println("Main Thread Finished");
    }
}
