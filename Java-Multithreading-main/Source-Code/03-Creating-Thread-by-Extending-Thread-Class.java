/*
 * ============================================================================
 * Program Name : Creating a Thread Using Thread Class
 * Description  : This program demonstrates how to create a thread
 *                by extending the Thread class.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a new class that extends the Thread class.
class MyThread extends Thread {

    // Overrides the run() method.
    // The code written inside this method is executed by the child thread.
    @Override
    public void run() {

        // Displays a message from the child thread.
        System.out.println("Child Thread is Running...");
    }
}

// Main class of the program.
public class CreatingAThreadUsingThreadClass {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message from the main thread.
        System.out.println("Main Thread Started");

        // Creates an object of the MyThread class.
        MyThread thread = new MyThread();

        // Starts the child thread.
        thread.start();

        // Displays a message from the main thread.
        System.out.println("Main Thread Finished");
    }
}
