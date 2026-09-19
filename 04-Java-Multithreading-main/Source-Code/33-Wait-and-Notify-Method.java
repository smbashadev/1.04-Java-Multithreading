/*
 * ============================================================================
 * Program Name : Wait and Notify Method
 * Description  : This program demonstrates inter-thread communication
 *                using the wait() and notify() methods.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a shared resource class.
class SharedResource {

    // Declares a boolean variable to indicate data availability.
    private boolean dataAvailable = false;

    // Creates a synchronized method for waiting.
    public synchronized void waitForData() {

        // Displays a waiting message.
        System.out.println("Consumer is waiting for data...");

        // Checks whether data is available.
        while (!dataAvailable) {

            try {

                // Releases the lock and waits for notification.
                wait();

            } catch (InterruptedException exception) {

                // Displays interruption message.
                System.out.println("Consumer Interrupted");
            }
        }

        // Displays a message after notification.
        System.out.println("Consumer received the notification.");
        System.out.println("Consumer is processing the data.");
    }

    // Creates a synchronized method for producing data.
    public synchronized void produceData() {

        // Displays a message.
        System.out.println("Producer is preparing data...");

        try {

            // Simulates some work.
            Thread.sleep(2000);

        } catch (InterruptedException exception) {

            // Displays interruption message.
            System.out.println("Producer Interrupted");
        }

        // Marks data as available.
        dataAvailable = true;

        // Displays notification message.
        System.out.println("Producer has produced the data.");

        // Wakes up one waiting thread.
        notify();
    }
}

// Creates the main class.
public class WaitAndNotifyMethod {

    // Main method where execution starts.
    public static void main(String[] args) {

        // Creates the shared resource object.
        SharedResource resource = new SharedResource();

        // Creates the consumer thread.
        Thread consumer = new Thread(() -> {

            // Calls the waiting method.
            resource.waitForData();

        }, "Consumer");

        // Creates the producer thread.
        Thread producer = new Thread(() -> {

            // Calls the producer method.
            resource.produceData();

        }, "Producer");

        // Starts the consumer thread.
        consumer.start();

        try {

            // Delays the producer so the consumer waits first.
            Thread.sleep(1000);

        } catch (InterruptedException exception) {

            // Displays interruption message.
            System.out.println("Main Thread Interrupted");
        }

        // Starts the producer thread.
        producer.start();
    }
}
