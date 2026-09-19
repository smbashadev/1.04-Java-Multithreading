/*
 * ============================================================================
 * Program Name : Thread Constructor with Thread Name
 * Description  : This program demonstrates how to create a thread using
 *                the Thread(String name) constructor.
 *
 * Author       : Shaik Mahaboob Basha
 * Repository   : 04-Java-Multithreading
 * ============================================================================
 */

// Creates a class that extends the Thread class.
class MyThread extends Thread {

    // Creates a constructor that accepts the thread name.
    public MyThread(String threadName) {

        // Calls the parent class constructor and assigns the thread name.
        super(threadName);
    }

    // Overrides the run() method.
    @Override
    public void run() {

        // Displays a message indicating that the child thread has started.
        System.out.println("Child Thread Started");

        // Displays the name of the child thread.
        System.out.println("Thread Name : " + getName());

        // Displays a message indicating that the child thread has finished.
        System.out.println("Child Thread Finished");
    }
}

// Creates the main class.
public class ThreadConstructorWithThreadName {

    // Main method where the program execution starts.
    public static void main(String[] args) {

        // Displays a message indicating that the program has started.
        System.out.println("Program Started");

        // Creates a thread object by passing the thread name to the constructor.
        MyThread thread = new MyThread("Learning Thread");

        // Starts the child thread.
        thread.start();

        // Displays a message indicating that the program has finished.
        System.out.println("Program Finished");
    }
}
