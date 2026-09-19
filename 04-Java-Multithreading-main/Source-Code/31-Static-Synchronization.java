/*
 * ============================================================================
 * Program Name : Static Synchronization
 * Description  : This program demonstrates synchronization using a
 *                static synchronized method.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a class to demonstrate static synchronization.
class SharedResource {

    // Creates a static synchronized method.
    public static synchronized void displayNumbers(String threadName) {

        // Displays a message when a thread enters the method.
        System.out.println(threadName + " Entered the Method");

        // Prints numbers from 1 to 5.
        for (int number = 1; number <= 5; number++) {

            // Displays the current number.
            System.out.println(threadName + " : " + number);

            try {

                // Pauses the thread for 500 milliseconds.
                Thread.sleep(500);

            } catch (InterruptedException exception) {

                // Displays a message if the thread is interrupted.
                System.out.println("Thread Interrupted");
            }
        }

        // Displays a message when a thread exits the method.
        System.out.println(threadName + " Exited the Method");
    }
}

// Creates a thread class.
class MyThread extends Thread {

    // Creates a constructor.
    public MyThread(String threadName) {

        // Assigns the thread name.
        setName(threadName);
    }

    // Overrides the run() method.
    @Override
    public void run() {

        // Calls the static synchronized method.
        SharedResource.displayNumbers(getName());
    }
}

// Creates the main class.
public class StaticSynchronization {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Creates the first thread.
        MyThread thread1 = new MyThread("Thread-1");

        // Creates the second thread.
        MyThread thread2 = new MyThread("Thread-2");

        // Starts the first thread.
        thread1.start();

        // Starts the second thread.
        thread2.start();
    }
}
