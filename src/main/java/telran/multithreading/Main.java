package telran.multithreading;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Worker worker1 = new Worker("Worker1", lock1, lock2);
        Worker worker2 = new Worker("Worker2", lock2, lock1);
        worker1.start();
        worker2.start();
        worker1.join();
        worker2.join();
    }
}