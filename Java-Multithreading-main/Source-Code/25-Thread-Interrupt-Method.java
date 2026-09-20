/*
 * ============================================================================
 * Program Name : Thread Interrupt Method
 * Description  : This program demonstrates how to interrupt a sleeping thread
 *                using the interrupt() method.
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

        try {

            // Displays a message before sleeping.
            System.out.println("Child Thread is Sleeping...");

            // Pauses the child thread for 5000 milliseconds.
            Thread.sleep(5000);

            // Displays a message if the thread completes sleeping.
            System.out.println("Child Thread Woke Up");

        } catch (InterruptedException exception) {

            // Displays a message when the thread is interrupted.
            System.out.println("Child Thread Interrupted");
        }

        // Displays a message indicating that the child thread has finished.
        System.out.println("Child Thread Finished");
    }
}

// Creates the main class.
public class ThreadInterruptMethod {

    // Main method where the program execution starts.
    public static void main(String[] args) throws InterruptedException {

        // Displays a message indicating that the program has started.
        System.out.println("Program Started");

        // Creates the child thread.
        MyThread thread = new MyThread();

        // Starts the child thread.
        thread.start();

        // Waits for 2000 milliseconds.
        Thread.sleep(2000);

        // Displays a message before interrupting the child thread.
        System.out.println("Main Thread Interrupting Child Thread");

        // Interrupts the child thread.
        thread.interrupt();

        // Waits until the child thread completes.
        thread.join();

        // Displays a message indicating that the program has finished.
        System.out.println("Program Finished");
    }
}
