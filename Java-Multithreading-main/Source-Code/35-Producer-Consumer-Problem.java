/*
 * ============================================================================
 * Program Name : Producer Consumer Problem
 * Description  : This program demonstrates the Producer-Consumer Problem
 *                using wait() and notify() methods.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a shared resource class.
class SharedResource {

    // Stores the shared data.
    private int data;

    // Indicates whether data is available.
    private boolean dataAvailable = false;

    // Creates a synchronized method for producing data.
    public synchronized void produce(int value) {

        // Waits if previous data has not been consumed.
        while (dataAvailable) {

            try {

                // Releases the lock and waits.
                wait();

            } catch (InterruptedException exception) {

                // Displays interruption message.
                System.out.println("Producer Interrupted");
            }
        }

        // Produces new data.
        data = value;

        // Marks data as available.
        dataAvailable = true;

        // Displays the produced data.
        System.out.println("Producer Produced : " + data);

        // Notifies the waiting consumer.
        notify();
    }

    // Creates a synchronized method for consuming data.
    public synchronized void consume() {

        // Waits until data becomes available.
        while (!dataAvailable) {

            try {

                // Releases the lock and waits.
                wait();

            } catch (InterruptedException exception) {

                // Displays interruption message.
                System.out.println("Consumer Interrupted");
            }
        }

        // Displays the consumed data.
        System.out.println("Consumer Consumed : " + data);

        // Marks data as consumed.
        dataAvailable = false;

        // Notifies the producer.
        notify();
    }
}

// Creates the main class.
public class ProducerConsumerProblem {

    // Main method where execution starts.
    public static void main(String[] args) {

        // Creates the shared resource.
        SharedResource resource = new SharedResource();

        // Creates the producer thread.
        Thread producer = new Thread(() -> {

            // Produces five values.
            for (int number = 1; number <= 5; number++) {

                // Produces the current value.
                resource.produce(number);

                try {

                    // Simulates production time.
                    Thread.sleep(1000);

                } catch (InterruptedException exception) {

                    // Displays interruption message.
                    System.out.println("Producer Interrupted");
                }
            }

        }, "Producer");

        // Creates the consumer thread.
        Thread consumer = new Thread(() -> {

            // Consumes five values.
            for (int number = 1; number <= 5; number++) {

                // Consumes the data.
                resource.consume();

                try {

                    // Simulates processing time.
                    Thread.sleep(1500);

                } catch (InterruptedException exception) {

                    // Displays interruption message.
                    System.out.println("Consumer Interrupted");
                }
            }

        }, "Consumer");

        // Starts the producer thread.
        producer.start();

        // Starts the consumer thread.
        consumer.start();
    }
}
