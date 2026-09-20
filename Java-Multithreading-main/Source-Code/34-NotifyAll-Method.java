/*
 * ============================================================================
 * Program Name : NotifyAll Method
 * Description  : This program demonstrates inter-thread communication
 *                using the notifyAll() method.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a shared resource class.
class SharedResource {

    // Creates a synchronized method for waiting threads.
    public synchronized void waitForSignal() {

        // Displays the thread that is waiting.
        System.out.println(Thread.currentThread().getName() + " is waiting...");

        try {

            // Releases the lock and waits for notification.
            wait();

        } catch (InterruptedException exception) {

            // Displays interruption message.
            System.out.println(Thread.currentThread().getName() + " Interrupted");
        }

        // Displays a message after notification.
        System.out.println(Thread.currentThread().getName() + " resumed execution.");
    }

    // Creates a synchronized method to notify all waiting threads.
    public synchronized void sendNotification() {

        // Displays a notification message.
        System.out.println("Producer is sending notification to all waiting threads.");

        // Wakes all waiting threads.
        notifyAll();
    }
}

// Creates the main class.
public class NotifyAllMethod {

    // Main method where execution starts.
    public static void main(String[] args) {

        // Creates the shared resource.
        SharedResource resource = new SharedResource();

        // Creates the first waiting thread.
        Thread thread1 = new Thread(() -> {

            // Calls the waiting method.
            resource.waitForSignal();

        }, "Thread-1");

        // Creates the second waiting thread.
        Thread thread2 = new Thread(() -> {

            // Calls the waiting method.
            resource.waitForSignal();

        }, "Thread-2");

        // Creates the third waiting thread.
        Thread thread3 = new Thread(() -> {

            // Calls the waiting method.
            resource.waitForSignal();

        }, "Thread-3");

        // Creates the producer thread.
        Thread producer = new Thread(() -> {

            try {

                // Waits for all threads to enter the waiting state.
                Thread.sleep(2000);

            } catch (InterruptedException exception) {

                // Displays interruption message.
                System.out.println("Producer Interrupted");
            }

            // Sends notification to all waiting threads.
            resource.sendNotification();

        }, "Producer");

        // Starts all waiting threads.
        thread1.start();
        thread2.start();
        thread3.start();

        // Starts the producer thread.
        producer.start();
    }
}
