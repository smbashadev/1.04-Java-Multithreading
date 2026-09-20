/*
 * ============================================================================
 * Program Name : Synchronized Block
 * Description  : This program demonstrates how to synchronize only a
 *                specific block of code instead of the entire method.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a class to represent a shared resource.
class SharedResource {

    // Creates a normal method.
    public void displayNumbers() {

        // Displays a message before entering the synchronized block.
        System.out.println(Thread.currentThread().getName() + " Reached the Method");

        // Synchronizes only the critical section.
        synchronized (this) {

            // Displays a message after entering the synchronized block.
            System.out.println(Thread.currentThread().getName() + " Entered the Synchronized Block");

            // Prints numbers from 1 to 5.
            for (int number = 1; number <= 5; number++) {

                // Displays the current thread name and number.
                System.out.println(Thread.currentThread().getName() + " : " + number);

                try {

                    // Pauses the thread for 500 milliseconds.
                    Thread.sleep(500);

                } catch (InterruptedException exception) {

                    // Displays a message if the thread is interrupted.
                    System.out.println("Thread Interrupted");
                }
            }

            // Displays a message before leaving the synchronized block.
            System.out.println(Thread.currentThread().getName() + " Exited the Synchronized Block");
        }

        // Displays a message after leaving the synchronized block.
        System.out.println(Thread.currentThread().getName() + " Completed the Method");
    }
}

// Creates a thread class.
class MyThread extends Thread {

    // Declares a reference to the shared resource.
    private SharedResource resource;

    // Creates a constructor.
    public MyThread(SharedResource resource, String threadName) {

        // Stores the shared resource.
        this.resource = resource;

        // Assigns the thread name.
        setName(threadName);
    }

    // Overrides the run() method.
    @Override
    public void run() {

        // Calls the shared method.
        resource.displayNumbers();
    }
}

// Creates the main class.
public class SynchronizedBlock {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Creates one shared resource object.
        SharedResource resource = new SharedResource();

        // Creates the first thread.
        MyThread thread1 = new MyThread(resource, "Thread-1");

        // Creates the second thread.
        MyThread thread2 = new MyThread(resource, "Thread-2");

        // Starts the first thread.
        thread1.start();

        // Starts the second thread.
        thread2.start();
    }
}
