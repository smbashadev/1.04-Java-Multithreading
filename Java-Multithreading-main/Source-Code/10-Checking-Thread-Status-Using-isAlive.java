/*
 * ============================================================================
 * Program Name : Checking Thread Status Using isAlive()
 * Description  : This program demonstrates how to check whether a thread
 *                is alive using the isAlive() method.
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

        // Displays a simple task performed by the child thread.
        System.out.println("Child Thread is Executing...");

        // Displays a message indicating that the child thread has finished.
        System.out.println("Child Thread Finished");
    }
}

// Main class of the program.
public class CheckingThreadStatusUsingIsAlive {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the main thread has started.
        System.out.println("Main Thread Started");

        // Creates an object of the MyThread class.
        MyThread thread = new MyThread();

        // Checks whether the thread is alive before starting it.
        System.out.println("Before start() : " + thread.isAlive());

        // Starts the child thread.
        thread.start();

        // Checks whether the thread is alive after starting it.
        System.out.println("After start() : " + thread.isAlive());

        // Waits until the child thread completes its execution.
        try {

            // Makes the main thread wait for the child thread.
            thread.join();

        } catch (InterruptedException exception) {

            // Displays an error message if the thread is interrupted.
            System.out.println("Thread Interrupted");
        }

        // Checks whether the thread is alive after completion.
        System.out.println("After Completion : " + thread.isAlive());

        // Displays a message indicating that the main thread has finished.
        System.out.println("Main Thread Finished");
    }
}
