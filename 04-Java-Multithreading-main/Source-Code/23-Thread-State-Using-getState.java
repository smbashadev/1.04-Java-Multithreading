/*
 * ============================================================================
 * Program Name : Thread State Using getState()
 * Description  : This program demonstrates how to retrieve the current
 *                state of a thread using the getState() method.
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

        // Displays a message indicating that the child thread is executing.
        System.out.println("Child Thread is Running...");

        try {

            // Pauses the child thread for 1000 milliseconds.
            Thread.sleep(1000);

        } catch (InterruptedException exception) {

            // Displays an interruption message if an exception occurs.
            System.out.println("Thread Interrupted");
        }

        // Displays a message indicating that the child thread has completed.
        System.out.println("Child Thread Finished");
    }
}

// Creates the main class.
public class ThreadStateUsingGetState {

    // Main method where the program execution starts.
    public static void main(String[] args) throws InterruptedException {

        // Creates the thread object.
        MyThread thread = new MyThread();

        // Displays the initial thread state.
        System.out.println("Before start() : " + thread.getState());

        // Starts the child thread.
        thread.start();

        // Displays the thread state immediately after starting.
        System.out.println("After start() : " + thread.getState());

        // Waits for 200 milliseconds.
        Thread.sleep(200);

        // Displays the thread state while it is sleeping.
        System.out.println("While sleeping : " + thread.getState());

        // Waits until the child thread completes.
        thread.join();

        // Displays the final thread state.
        System.out.println("After completion : " + thread.getState());
    }
}
