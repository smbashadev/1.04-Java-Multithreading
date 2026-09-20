/*
 * ============================================================================
 * Program Name : Thread Join Method
 * Description  : This program demonstrates how to make the Main Thread
 *                wait until the Child Thread completes using join().
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

        // Executes the loop from 1 to 5.
        for (int number = 1; number <= 5; number++) {

            // Displays the current number.
            System.out.println("Child Thread : " + number);
        }

        // Displays a message indicating that the child thread has completed.
        System.out.println("Child Thread Finished");
    }
}

// Main class of the program.
public class ThreadJoinMethod {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the main thread has started.
        System.out.println("Main Thread Started");

        // Creates an object of the MyThread class.
        MyThread thread = new MyThread();

        // Starts the child thread.
        thread.start();

        // Handles InterruptedException.
        try {

            // Makes the Main Thread wait until the Child Thread finishes.
            thread.join();

        } catch (InterruptedException exception) {

            // Displays a message if the Main Thread is interrupted.
            System.out.println("Main Thread Interrupted");
        }

        // Displays this message only after the Child Thread completes.
        System.out.println("Main Thread Resumed");

        // Displays a message indicating that the main thread has finished.
        System.out.println("Main Thread Finished");
    }
}
