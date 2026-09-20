/*
 * ============================================================================
 * Program Name : Printing Numbers Using Runnable Interface
 * Description  : This program demonstrates how to print numbers from
 *                1 to 5 using the Runnable interface.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a class that implements the Runnable interface.
class NumberTask implements Runnable {

    // Overrides the run() method.
    @Override
    public void run() {

        // Displays a heading.
        System.out.println("Child Thread Started");

        // Prints numbers from 1 to 5.
        for (int number = 1; number <= 5; number++) {

            // Displays the current number.
            System.out.println("Number : " + number);
        }

        // Displays a completion message.
        System.out.println("Child Thread Finished");
    }
}

// Creates the main class.
public class PrintingNumbersUsingRunnableInterface {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message before creating the thread.
        System.out.println("Main Thread Started");

        // Creates the Runnable object.
        NumberTask task = new NumberTask();

        // Creates the Thread object.
        Thread thread = new Thread(task);

        // Starts the child thread.
        thread.start();

        // Displays a message after starting the child thread.
        System.out.println("Main Thread Finished");
    }
}
