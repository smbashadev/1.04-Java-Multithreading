/*
 * ============================================================================
 * Program Name : Daemon Thread
 * Description  : This program demonstrates how to create a daemon thread
 *                using the setDaemon() method.
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

        // Prints numbers from 1 to 5.
        for (int number = 1; number <= 5; number++) {

            // Displays the current thread name and number.
            System.out.println(getName() + " : " + number);

            try {

                // Pauses the thread for 500 milliseconds.
                Thread.sleep(500);

            } catch (InterruptedException exception) {

                // Displays a message if the thread is interrupted.
                System.out.println("Thread Interrupted");
            }
        }

        // Displays a completion message.
        System.out.println(getName() + " Finished");
    }
}

// Creates the main class.
public class DaemonThread {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the program has started.
        System.out.println("Program Started");

        // Creates a thread object.
        MyThread thread = new MyThread();

        // Assigns a name to the thread.
        thread.setName("Daemon Thread");

        // Converts the thread into a daemon thread.
        thread.setDaemon(true);

        // Starts the daemon thread.
        thread.start();

        // Displays whether the thread is a daemon thread.
        System.out.println("Is Daemon Thread : " + thread.isDaemon());

        // Displays a message indicating that the main thread has completed.
        System.out.println("Main Thread Finished");
    }
}
