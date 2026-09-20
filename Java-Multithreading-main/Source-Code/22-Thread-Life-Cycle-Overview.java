/*
 * ============================================================================
 * Program Name : Thread Life Cycle Overview
 * Description  : This program demonstrates the life cycle of a thread by
 *                displaying its state before starting, after starting,
 *                and after execution completes.
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

        // Displays a message from the child thread.
        System.out.println("Child Thread is Running...");
    }
}

// Creates the main class.
public class ThreadLifeCycleOverview {

    // Main method where the program execution starts.
    public static void main(String[] args) throws InterruptedException {

        // Displays a message indicating that the program has started.
        System.out.println("Program Started");

        // Creates a thread object.
        MyThread thread = new MyThread();

        // Displays the thread state before starting.
        System.out.println("State Before Start : " + thread.getState());

        // Starts the thread.
        thread.start();

        // Displays the thread state immediately after starting.
        System.out.println("State After Start : " + thread.getState());

        // Waits until the child thread completes.
        thread.join();

        // Displays the thread state after execution completes.
        System.out.println("State After Completion : " + thread.getState());

        // Displays a message indicating that the program has finished.
        System.out.println("Program Finished");
    }
}
