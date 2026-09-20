/*
 * ============================================================================
 * Program Name : Deadlock Demonstration
 * Description  : This program demonstrates how a deadlock can occur when
 *                two threads acquire locks in opposite order.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates the main class.
public class DeadlockDemonstration {

    // Creates the first lock object.
    private static final Object LOCK_ONE = new Object();

    // Creates the second lock object.
    private static final Object LOCK_TWO = new Object();

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Creates the first thread.
        Thread thread1 = new Thread(() -> {

            // Acquires the first lock.
            synchronized (LOCK_ONE) {

                // Displays a message.
                System.out.println("Thread-1 acquired LOCK_ONE");

                try {

                    // Pauses the thread for one second.
                    Thread.sleep(1000);

                } catch (InterruptedException exception) {

                    // Displays interruption message.
                    System.out.println("Thread-1 Interrupted");
                }

                // Displays waiting message.
                System.out.println("Thread-1 waiting for LOCK_TWO");

                // Attempts to acquire the second lock.
                synchronized (LOCK_TWO) {

                    // This line will never execute during deadlock.
                    System.out.println("Thread-1 acquired LOCK_TWO");
                }
            }

        }, "Thread-1");

        // Creates the second thread.
        Thread thread2 = new Thread(() -> {

            // Acquires the second lock.
            synchronized (LOCK_TWO) {

                // Displays a message.
                System.out.println("Thread-2 acquired LOCK_TWO");

                try {

                    // Pauses the thread for one second.
                    Thread.sleep(1000);

                } catch (InterruptedException exception) {

                    // Displays interruption message.
                    System.out.println("Thread-2 Interrupted");
                }

                // Displays waiting message.
                System.out.println("Thread-2 waiting for LOCK_ONE");

                // Attempts to acquire the first lock.
                synchronized (LOCK_ONE) {

                    // This line will never execute during deadlock.
                    System.out.println("Thread-2 acquired LOCK_ONE");
                }
            }

        }, "Thread-2");

        // Starts the first thread.
        thread1.start();

        // Starts the second thread.
        thread2.start();
    }
}
