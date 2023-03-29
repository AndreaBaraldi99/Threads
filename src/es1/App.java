package es1;
public class App {
    public static void main(String[] args) {
        SharedObject sharedObject = new SharedObject();
        Thread t1 = new Thread(new BasicThread("Thread 1", sharedObject));
        Thread t2 = new Thread(new BasicThread("Thread 2", sharedObject));
        Thread t3 = new Thread(new BasicThread("Thread 3", sharedObject));

        t1.start();
        t2.start();
        t3.start();
    }
}
