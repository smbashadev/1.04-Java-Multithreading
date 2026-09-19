/*
 * ============================================================================
 * Program Name : Thread Yield Method
 * Description  : This program demonstrates how the yield() method allows
 *                the currently executing thread to give other threads
 *                an opportunity to execute.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a class that extends the Thread class.
class MyThread extends Thread {

    // Overrides the run() method.
    @Override
    public void run() {

        // Prints numbers from 1 to 5.
        for (int number = 1; number <= 5; number++) {

            // Displays the child thread name and current number.
            System.out.println(getName() + " : " + number);

            // Gives other threads a chance to execute.
            Thread.yield();
        }
    }
}

// Creates the main class.
public class ThreadYieldMethod {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Creates the first thread.
        MyThread thread1 = new MyThread();

        // Assigns a name to the first thread.
        thread1.setName("Thread-1");

        // Creates the second thread.
        MyThread thread2 = new MyThread();

        // Assigns a name to the second thread.
        thread2.setName("Thread-2");

        // Starts the first thread.
        thread1.start();

        // Starts the second thread.
        thread2.start();
    }
}
