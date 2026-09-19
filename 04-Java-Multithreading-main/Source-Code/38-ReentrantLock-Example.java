/*
 * ============================================================================
 * Program Name : ReentrantLock Example
 * Description  : This program demonstrates how to use the ReentrantLock
 *                class to provide thread-safe access to a shared resource.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

import java.util.concurrent.locks.ReentrantLock;

// Creates a shared resource class.
class SharedResource {

    // Creates a ReentrantLock object.
    private ReentrantLock lock = new ReentrantLock();

    // Creates a method to display numbers.
    public void displayNumbers() {

        // Acquires the lock.
        lock.lock();

        try {

            // Displays the thread that acquired the lock.
            System.out.println(Thread.currentThread().getName()
                    + " Acquired the Lock");

            // Prints numbers from 1 to 5.
            for (int number = 1; number <= 5; number++) {

                // Displays the current number.
                System.out.println(Thread.currentThread().getName()
                        + " : " + number);

                try {

                    // Pauses the thread for 500 milliseconds.
                    Thread.sleep(500);

                } catch (InterruptedException exception) {

                    // Displays interruption message.
                    System.out.println("Thread Interrupted");
                }
            }

        } finally {

            // Releases the lock.
            lock.unlock();

            // Displays a message after releasing the lock.
            System.out.println(Thread.currentThread().getName()
                    + " Released the Lock");
        }
    }
}

// Creates a thread class.
class MyThread extends Thread {

    // Declares the shared resource.
    private SharedResource resource;

    // Creates the constructor.
    public MyThread(SharedResource resource, String threadName) {

        // Stores the shared resource.
        this.resource = resource;

        // Sets the thread name.
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
public class ReentrantLockExample {

    // Main method where execution starts.
    public static void main(String[] args) {

        // Creates one shared resource object.
        SharedResource resource = new SharedResource();

        // Creates two threads.
        MyThread thread1 = new MyThread(resource, "Thread-1");
        MyThread thread2 = new MyThread(resource, "Thread-2");

        // Starts both threads.
        thread1.start();
        thread2.start();
    }
}
