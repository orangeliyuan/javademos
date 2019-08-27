package per.example.demo.syncdemo;

public class Demo5 implements Runnable{
    private static Demo5 instance1 = new Demo5();
    private static Demo5 instance2 = new Demo5();
    @Override
    public void run() {
        synchronized (Demo5.class) {
            System.out.println("*.class 形式：name:" + Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " done");
        }
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(instance1);
        Thread t2 = new Thread(instance2);
        t1.start();
        t2.start();
        while (t1.isAlive() || t2.isAlive()) {
        }
        System.out.println("finished");
    }
}
