package per.example.demo.syncdemo;

public class Demo4 implements Runnable{
    private static Demo4 instance1 = new Demo4();
    private static Demo4 instance2 = new Demo4();
    @Override
    public void run() {
        method();
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
    public static synchronized void method() {
        System.out.println("static 形式：name:" + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " done");
    }
}
