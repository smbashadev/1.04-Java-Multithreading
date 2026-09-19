/*
 * ============================================================================
 * Program Name : Thread Pool Introduction
 * Description  : This program demonstrates how to create and use a
 *                Thread Pool using the ExecutorService framework.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Creates a task class that implements the Runnable interface.
class Task implements Runnable {

    // Stores the task number.
    private int taskNumber;

    // Creates the constructor.
    public Task(int taskNumber) {

        // Stores the task number.
        this.taskNumber = taskNumber;
    }

    // Overrides the run() method.
    @Override
    public void run() {

        // Displays the thread executing the task.
        System.out.println(
                Thread.currentThread().getName()
                        + " is executing Task "
                        + taskNumber);

        try {

            // Simulates task execution.
            Thread.sleep(1000);

        } catch (InterruptedException exception) {

            // Displays interruption message.
            System.out.println("Task Interrupted");
        }

        // Displays task completion.
        System.out.println(
                Thread.currentThread().getName()
                        + " completed Task "
                        + taskNumber);
    }
}

// Creates the main class.
public class ThreadPoolIntroduction {

    // Main method where execution starts.
    public static void main(String[] args) {

        // Creates a fixed thread pool with three threads.
        ExecutorService executorService =
                Executors.newFixedThreadPool(3);

        // Submits five tasks to the thread pool.
        for (int taskNumber = 1; taskNumber <= 5; taskNumber++) {

            executorService.execute(new Task(taskNumber));
        }

        // Stops accepting new tasks.
        executorService.shutdown();

        // Displays a message.
        System.out.println("All tasks submitted to the Thread Pool.");
    }
}
