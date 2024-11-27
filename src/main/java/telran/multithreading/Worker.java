package telran.multithreading;

public class Worker extends Thread {
    String name;
    Object lock1;
    Object lock2;

    public Worker(String name, Object lock1, Object lock2) {
        this.name = name;
        this.lock1 = lock1;
        this.lock2 = lock2;
    } 

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println(getWorkerName() + ": Holding Lock1");
            try {
                sleep(100);
            } catch (IllegalArgumentException | InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getWorkerName() + ": Waiting for Lock2");
            synchronized (lock2) {
                System.out.println(getWorkerName() + ": Holding Lock1 and Lock2");
            }
        }
    }

    public String getWorkerName() {
        return name;
    }

}
