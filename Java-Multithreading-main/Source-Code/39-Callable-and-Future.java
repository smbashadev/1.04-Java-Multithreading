/*
 * ============================================================================
 * Program Name : Callable and Future
 * Description  : This program demonstrates how to use the Callable interface
 *                and Future object to execute a task that returns a value.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

// Creates a class that implements the Callable interface.
class SumTask implements Callable<Integer> {

    // Overrides the call() method.
    @Override
    public Integer call() throws Exception {

        // Displays the executing thread.
        System.out.println(Thread.currentThread().getName()
                + " is calculating the sum.");

        // Declares a variable to store the sum.
        int sum = 0;

        // Calculates the sum of numbers from 1 to 10.
        for (int number = 1; number <= 10; number++) {

            // Adds the current number to the sum.
            sum = sum + number;

            // Simulates processing time.
            Thread.sleep(200);
        }

        // Returns the calculated sum.
        return sum;
    }
}

// Creates the main class.
public class CallableAndFuture {

    // Main method where execution starts.
    public static void main(String[] args) {

        // Creates a thread pool with one worker thread.
        ExecutorService executorService =
                Executors.newSingleThreadExecutor();

        // Creates the Callable task.
        SumTask task = new SumTask();

        // Submits the task and receives a Future object.
        Future<Integer> future = executorService.submit(task);

        try {

            // Displays a waiting message.
            System.out.println("Main Thread is waiting for the result...");

            // Retrieves the returned value.
            Integer result = future.get();

            // Displays the returned value.
            System.out.println("Sum = " + result);

        } catch (InterruptedException exception) {

            // Displays interruption message.
            System.out.println("Main Thread Interrupted");

        } catch (ExecutionException exception) {

            // Displays execution exception message.
            System.out.println("Task Execution Failed");
        }

        // Shuts down the thread pool.
        executorService.shutdown();
    }
}
