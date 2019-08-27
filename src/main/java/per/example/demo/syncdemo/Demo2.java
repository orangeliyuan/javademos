package per.example.demo.syncdemo;

public class Demo2 implements Runnable{
    private static Demo2 instance = new Demo2();
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("lock1-name : " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock1 done");
        }
        synchronized (lock2) {
            System.out.println("lock2-name : " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock2 done");
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {

        }
        System.out.println("finished");
    }
}
