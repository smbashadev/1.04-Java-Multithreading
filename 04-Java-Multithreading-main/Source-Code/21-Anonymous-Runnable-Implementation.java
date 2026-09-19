/*
 * ============================================================================
 * Program Name : Anonymous Runnable Implementation
 * Description  : This program demonstrates how to create a Runnable object
 *                using an anonymous inner class.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates the main class.
public class AnonymousRunnableImplementation {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the program has started.
        System.out.println("Program Started");

        // Creates a Thread object by passing an anonymous Runnable object.
        Thread thread = new Thread(new Runnable() {

            // Overrides the run() method.
            @Override
            public void run() {

                // Displays a message from the child thread.
                System.out.println("Child Thread is Running");

                // Prints numbers from 1 to 5.
                for (int number = 1; number <= 5; number++) {

                    // Displays the current number.
                    System.out.println("Number : " + number);
                }

                // Displays a completion message.
                System.out.println("Child Thread Finished");
            }
        });

        // Starts the child thread.
        thread.start();

        // Displays a message indicating that the main thread has finished.
        System.out.println("Program Finished");
    }
}
