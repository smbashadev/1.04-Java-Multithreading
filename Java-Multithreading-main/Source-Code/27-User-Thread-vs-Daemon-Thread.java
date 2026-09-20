/*
 * ============================================================================
 * Program Name : User Thread vs Daemon Thread
 * Description  : This program demonstrates the difference between a
 *                User Thread and a Daemon Thread.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a class that extends the Thread class.
class MyThread extends Thread {

    // Creates a constructor to assign the thread name.
    public MyThread(String threadName) {

        // Calls the parent constructor.
        super(threadName);
    }

    // Overrides the run() method.
    @Override
    public void run() {

        // Prints numbers from 1 to 5.
        for (int number = 1; number <= 5; number++) {

            // Displays the thread name and current number.
            System.out.println(getName() + " : " + number);

            try {

                // Pauses the thread for 500 milliseconds.
                Thread.sleep(500);

            } catch (InterruptedException exception) {

                // Displays a message if the thread is interrupted.
                System.out.println(getName() + " Interrupted");
            }
        }

        // Displays a completion message.
        System.out.println(getName() + " Finished");
    }
}

// Creates the main class.
public class UserThreadVsDaemonThread {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the program has started.
        System.out.println("Program Started");

        // Creates a user thread.
        MyThread userThread = new MyThread("User Thread");

        // Creates a daemon thread.
        MyThread daemonThread = new MyThread("Daemon Thread");

        // Converts the second thread into a daemon thread.
        daemonThread.setDaemon(true);

        // Starts the user thread.
        userThread.start();

        // Starts the daemon thread.
        daemonThread.start();

        // Displays the daemon status of both threads.
        System.out.println(userThread.getName() + " Is Daemon : " + userThread.isDaemon());
        System.out.println(daemonThread.getName() + " Is Daemon : " + daemonThread.isDaemon());

        // Displays a message indicating that the main thread has finished.
        System.out.println("Main Thread Finished");
    }
}
