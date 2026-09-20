/*
 * ============================================================================
 * Program Name : Main Thread and Child Thread
 * Description  : This program demonstrates that the Main Thread and
 *                Child Thread execute independently.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a class that extends the Thread class.
class ChildThread extends Thread {

    // Overrides the run() method.
    @Override
    public void run() {

        // Displays a message indicating that the child thread has started.
        System.out.println("Child Thread Started");

        // Prints numbers from 1 to 5.
        for (int number = 1; number <= 5; number++) {

            // Displays the current number printed by the child thread.
            System.out.println("Child Thread : " + number);
        }

        // Displays a message indicating that the child thread has completed.
        System.out.println("Child Thread Finished");
    }
}

// Main class of the program.
public class MainThreadAndChildThread {

    // Entry point of the Java program.
    public static void main(String[] args) {

        // Displays a message indicating that the main thread has started.
        System.out.println("Main Thread Started");

        // Creates an object of the ChildThread class.
        ChildThread thread = new ChildThread();

        // Starts the child thread.
        thread.start();

        // Prints numbers from 1 to 5 using the main thread.
        for (int number = 1; number <= 5; number++) {

            // Displays the current number printed by the main thread.
            System.out.println("Main Thread : " + number);
        }

        // Displays a message indicating that the main thread has completed.
        System.out.println("Main Thread Finished");
    }
}
