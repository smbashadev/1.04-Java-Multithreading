/*
 * ============================================================================
 * Program Name : Multiple Threads Using Runnable Interface
 * Description  : This program demonstrates how to create and execute
 *                multiple threads using the Runnable interface.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a class that implements the Runnable interface.
class MyTask implements Runnable {

    // Declares a variable to store the task name.
    private String taskName;

    // Creates a constructor to initialize the task name.
    public MyTask(String taskName) {

        // Assigns the task name.
        this.taskName = taskName;
    }

    // Overrides the run() method.
    @Override
    public void run() {

        // Displays a message indicating that the task has started.
        System.out.println(taskName + " Started");

        // Prints numbers from 1 to 3.
        for (int number = 1; number <= 3; number++) {

            // Displays the current number.
            System.out.println(taskName + " : " + number);
        }

        // Displays a message indicating that the task has completed.
        System.out.println(taskName + " Finished");
    }
}

// Creates the main class.
public class MultipleThreadsUsingRunnableInterface {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the main thread has started.
        System.out.println("Main Thread Started");

        // Creates the first Runnable task.
        MyTask task1 = new MyTask("Task 1");

        // Creates the second Runnable task.
        MyTask task2 = new MyTask("Task 2");

        // Creates the first thread.
        Thread thread1 = new Thread(task1);

        // Creates the second thread.
        Thread thread2 = new Thread(task2);

        // Starts the first thread.
        thread1.start();

        // Starts the second thread.
        thread2.start();

        // Displays a message indicating that the main thread has finished.
        System.out.println("Main Thread Finished");
    }
}
