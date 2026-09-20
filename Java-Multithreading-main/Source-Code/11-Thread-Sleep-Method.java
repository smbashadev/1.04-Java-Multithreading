/*
 * ============================================================================
 * Program Name : Thread Sleep Method
 * Description  : This program demonstrates how to pause the execution
 *                of a thread using the sleep() method.
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
            System.out.println("Number : " + number);

            // Handles the InterruptedException.
            try {

                // Pauses the child thread for 1000 milliseconds (1 second).
                Thread.sleep(1000);

            } catch (InterruptedException exception) {

                // Displays a message if the thread is interrupted.
                System.out.println("Thread Interrupted");
            }
        }

        // Displays a message indicating that the child thread has finished.
        System.out.println("Child Thread Finished");
    }
}

// Main class of the program.
public class ThreadSleepMethod {

    // Main method where program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the main thread has started.
        System.out.println("Main Thread Started");

        // Creates an object of the MyThread class.
        MyThread thread = new MyThread();

        // Starts the child thread.
        thread.start();

        // Displays a message indicating that the main thread has finished.
        System.out.println("Main Thread Finished");
    }
}
