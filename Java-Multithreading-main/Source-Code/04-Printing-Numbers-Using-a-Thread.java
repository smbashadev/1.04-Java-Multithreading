/*
 * ============================================================================
 * Program Name : Printing Numbers Using a Thread
 * Description  : This program demonstrates how a child thread executes
 *                a simple task by printing numbers from 1 to 5.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a class that extends the Thread class.
class NumberThread extends Thread {

    // Overrides the run() method.
    // The code inside this method will be executed by the child thread.
    @Override
    public void run() {

        // Displays a message indicating that the child thread has started.
        System.out.println("Child Thread Started");

        // Executes the loop from 1 to 5.
        for (int number = 1; number <= 5; number++) {

            // Displays the current number.
            System.out.println("Number : " + number);
        }

        // Displays a message indicating that the child thread has finished.
        System.out.println("Child Thread Finished");
    }
}

// Main class of the program.
public class PrintingNumbersUsingAThread {

    // The main() method is the entry point of the program.
    public static void main(String[] args) {

        // Displays a message indicating that the main thread has started.
        System.out.println("Main Thread Started");

        // Creates an object of the NumberThread class.
        NumberThread thread = new NumberThread();

        // Starts the child thread.
        thread.start();

        // Displays a message indicating that the main thread has completed.
        System.out.println("Main Thread Finished");
    }
}
