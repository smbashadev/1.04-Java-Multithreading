/*
 * ============================================================================
 * Program Name : Thread Safe Counter
 * Description  : This program demonstrates how synchronization ensures
 *                thread-safe access to a shared counter.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a shared counter class.
class Counter {

    // Declares the shared counter variable.
    private int count = 0;

    // Creates a synchronized method to increment the counter.
    public synchronized void increment() {

        // Increases the counter by one.
        count++;

        // Displays the current thread and counter value.
        System.out.println(Thread.currentThread().getName()
                + " Incremented Counter to : " + count);
    }

    // Creates a method to return the counter value.
    public int getCount() {

        // Returns the counter value.
        return count;
    }
}

// Creates a thread class.
class CounterThread extends Thread {

    // Declares the shared counter.
    private Counter counter;

    // Creates the constructor.
    public CounterThread(Counter counter, String threadName) {

        // Stores the shared counter object.
        this.counter = counter;

        // Sets the thread name.
        setName(threadName);
    }

    // Overrides the run() method.
    @Override
    public void run() {

        // Increments the counter five times.
        for (int number = 1; number <= 5; number++) {

            // Calls the synchronized increment method.
            counter.increment();

            try {

                // Pauses the thread for 500 milliseconds.
                Thread.sleep(500);

            } catch (InterruptedException exception) {

                // Displays interruption message.
                System.out.println(getName() + " Interrupted");
            }
        }
    }
}

// Creates the main class.
public class ThreadSafeCounter {

    // Main method where execution starts.
    public static void main(String[] args) {

        // Creates one shared counter object.
        Counter counter = new Counter();

        // Creates the first thread.
        CounterThread thread1 =
                new CounterThread(counter, "Thread-1");

        // Creates the second thread.
        CounterThread thread2 =
                new CounterThread(counter, "Thread-2");

        // Starts both threads.
        thread1.start();
        thread2.start();

        try {

            // Waits until both threads complete execution.
            thread1.join();
            thread2.join();

        } catch (InterruptedException exception) {

            // Displays interruption message.
            System.out.println("Main Thread Interrupted");
        }

        // Displays the final counter value.
        System.out.println("\nFinal Counter Value : " + counter.getCount());
    }
}
