/*
 * ============================================================================
 * Program Name  : Multithreaded Program in Java
 * Description   : Demonstrates the creation of multiple threads by extending
 *                 the Thread class. Each thread executes its own task
 *                 independently, illustrating concurrent execution.
 *
 * Author        : Shaik Mahaboob Basha
 * Repository    : 04-Java-Multithreading
 * GitHub        : https://github.com/shaikbasha-dev
 * ============================================================================
 */

// Declares a class named TaskOne that extends the Thread class.
class TaskOne extends Thread {

    // Overrides the run() method that contains the task to be executed by the thread.
    @Override
    public void run() {

        // Displays the name of the currently executing thread.
        System.out.println(Thread.currentThread().getName() + " Started");

        // Executes a loop five times.
        for (int i = 1; i <= 5; i++) {

            // Displays the current iteration of Task One.
            System.out.println(Thread.currentThread().getName() + " -> Task One : Step " + i);
        }

        // Displays a completion message after finishing the task.
        System.out.println(Thread.currentThread().getName() + " Finished");
    }
}

// Declares another class named TaskTwo that also extends the Thread class.
class TaskTwo extends Thread {

    // Overrides the run() method.
    @Override
    public void run() {

        // Displays the name of the currently executing thread.
        System.out.println(Thread.currentThread().getName() + " Started");

        // Executes a loop five times.
        for (int i = 1; i <= 5; i++) {

            // Displays the current iteration of Task Two.
            System.out.println(Thread.currentThread().getName() + " -> Task Two : Step " + i);
        }

        // Displays a completion message.
        System.out.println(Thread.currentThread().getName() + " Finished");
    }
}

// Declares the main class of the program.
public class MultithreadedProgram {

    // The main() method is the starting point of the Java application.
    public static void main(String[] args) {

        // Displays a message indicating the start of the main thread.
        System.out.println("Main Thread Started");

        // Creates an object of TaskOne.
        TaskOne thread1 = new TaskOne();

        // Creates an object of TaskTwo.
        TaskTwo thread2 = new TaskTwo();

        // Assigns a custom name to the first thread.
        thread1.setName("Thread-1");

        // Assigns a custom name to the second thread.
        thread2.setName("Thread-2");

        // Starts the execution of the first thread.
        thread1.start();

        // Starts the execution of the second thread.
        thread2.start();

        // Displays a message from the main thread.
        System.out.println("Main Thread Continues Its Execution");

        // Displays a message indicating the end of the main thread.
        System.out.println("Main Thread Finished");
    }
}
